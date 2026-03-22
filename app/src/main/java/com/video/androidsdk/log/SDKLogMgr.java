package com.video.androidsdk.log;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.RequestUrlContants;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.AndroidUtils;
import com.video.androidsdk.common.util.SecurityUtil;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.common.util.ZipUtil;
import com.video.androidsdk.license.a;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.log.UpLoadCrashExceptionLogRequest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class SDKLogMgr implements LogEx.LogReportListener {
    private static final int CONNECTION_TIMEOUT = 10000;
    private static final String CREATE_TIME_PATTERN = "yyyyMMddHHmmss";
    private static final String DEFAULT_UNKNOW_PARAM = "unknow";
    public static final int DLNA_LOG_LEVEL_DEBUG = 4;
    public static final int DLNA_LOG_LEVEL_ERROR = 1;
    public static final int DLNA_LOG_LEVEL_INFO = 3;
    public static final int DLNA_LOG_LEVEL_WARN = 2;
    private static final String FILE_NAME_DATE_FORMATE = "yyyyMMddHHmmssSSS";
    private static final String LOG_BACK_FILE_NAME = "LOG.BAK";
    private static final long LOG_FILE_MAX_SIZE = 73400320;
    private static final String LOG_TAG = "SDKLogMgr";
    private static final int READ_TIMEOUT = 10000;
    private static final int WRITE_BUFFER_SIZE = 512000;
    private static SDKLogMgr instance = new SDKLogMgr();
    private static String mstrFilePath = null;
    private ConcurrentLinkedQueue<String> logQueue;
    private USBLogHelper mUSBPermissionsUtils;
    private int saveLogLevel;
    private SaveLogThread saveLogThread;
    private ExecutorService singleThreadPool;
    private String mSeverDomain = "";
    private boolean isCatchingDebugLog = false;
    private boolean mRunning = false;
    private String mstrlogName = null;
    private File mstrFileName = null;
    private long mLogFileSize = 52428800;
    private String mstrCmds = "logcat -v time";
    private String mstrClearLogCmds = "logcat -c";
    private HandlerThread mHandlerThread = null;
    private Handler mHandler = null;
    private Thread mAllLogThread = null;
    private String mUSBLogDirName = "zxctLog";
    private String mUSBFileName = null;
    private LogEx.LogLevelType originalLogLevelType = LogEx.getLogLevel();

    /* loaded from: classes.dex */
    public interface FileType {
        public static final String CRASH = "crash";
        public static final String DEBUG = "debug";
        public static final String ERROR = "error";
        public static final String USER_FEEDBACK = "userfeedback";
    }

    /* loaded from: classes.dex */
    public interface OnCrashFileUploadReturnListener {
        void onCrashFileUploadReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnDebugLogUploadReturnListener {
        void onDebugLogUploadReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnErrorLogUploadReturnListener {
        void onErrorLogUploadReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnUploadUserFeedBackReturnListener {
        void onUserFeedBackUploadReturn(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class SaveLogThread extends Thread {
        private BufferedWriter bufWriter;
        private FileWriter filerWriter;
        private boolean isWorking;
        private File saveLogFile;
        private String strLogFileDir = ConfigMgr.getDebugLogFilePath();
        private String strLogFilePath;

        public SaveLogThread() {
            this.isWorking = true;
            File file = new File(this.strLogFileDir);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].getAbsolutePath().endsWith(".log")) {
                        SDKLogMgr.this.backupLogFile(listFiles[i]);
                    }
                }
            }
            SDKLogMgr.this.deleteOldLogFile(file);
            this.saveLogFile = createLogSaveFile();
            try {
                this.filerWriter = new FileWriter(this.saveLogFile, true);
                this.bufWriter = new BufferedWriter(this.filerWriter, SDKLogMgr.WRITE_BUFFER_SIZE);
            } catch (IOException e) {
                e.printStackTrace();
                this.isWorking = false;
            }
        }

        private File createLogSaveFile() {
            SecureRandom secureRandom;
            String format = new SimpleDateFormat(SDKLogMgr.FILE_NAME_DATE_FORMATE).format(new Date());
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                secureRandom = null;
            }
            if (secureRandom != null) {
                this.strLogFilePath = this.strLogFileDir + format + secureRandom.nextInt(10) + ".log";
            } else {
                this.strLogFilePath = this.strLogFileDir + format + ".log";
            }
            File file = new File(this.strLogFilePath);
            try {
                SecurityUtil.securityCheck(file.getAbsolutePath(), "createNewFile");
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return file;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.isWorking) {
                if (SDKLogMgr.this.logQueue != null && !SDKLogMgr.this.logQueue.isEmpty()) {
                    try {
                        if (this.saveLogFile.length() > SDKLogMgr.LOG_FILE_MAX_SIZE) {
                            if (this.bufWriter != null) {
                                this.bufWriter.flush();
                                this.bufWriter.close();
                                this.bufWriter = null;
                            }
                            if (this.filerWriter != null) {
                                this.filerWriter.flush();
                                this.filerWriter.close();
                                this.filerWriter = null;
                            }
                            SDKLogMgr.this.backupLogFile(this.saveLogFile);
                            this.saveLogFile = createLogSaveFile();
                            try {
                                this.filerWriter = new FileWriter(this.saveLogFile, true);
                                this.bufWriter = new BufferedWriter(this.filerWriter, SDKLogMgr.WRITE_BUFFER_SIZE);
                            } catch (IOException e) {
                                e.printStackTrace();
                                this.isWorking = false;
                            }
                        } else if (this.bufWriter != null) {
                            SecurityUtil.securityCheck(this.bufWriter.toString(), "write");
                            this.bufWriter.write((String) SDKLogMgr.this.logQueue.poll());
                            this.bufWriter.newLine();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (SDKLogMgr.this.logQueue != null) {
                SDKLogMgr.this.logQueue.clear();
                SDKLogMgr.this.logQueue = null;
            }
        }

        public void shutdown() {
            try {
                if (this.bufWriter != null) {
                    this.bufWriter.flush();
                    this.bufWriter.close();
                    this.bufWriter = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.isWorking = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class UploadDebugFileThread extends Thread {
        private OnDebugLogUploadReturnListener listener;
        private String logFilePath;
        private DebugLogReq req;
        private String url;

        public UploadDebugFileThread(DebugLogReq debugLogReq, String str, OnDebugLogUploadReturnListener onDebugLogUploadReturnListener, String str2) {
            this.req = debugLogReq;
            this.url = str;
            this.listener = onDebugLogUploadReturnListener;
            this.logFilePath = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.logFilePath)) {
                SDKLogMgr.this.stopDebugLog();
                File[] listFiles = new File(ConfigMgr.getDebugLogFilePath()).listFiles();
                if (listFiles != null) {
                    int i = 0;
                    while (true) {
                        if (i >= listFiles.length) {
                            break;
                        }
                        if (listFiles[i].getAbsolutePath().endsWith(".log")) {
                            this.logFilePath = listFiles[i].getAbsolutePath();
                            break;
                        }
                        i++;
                    }
                }
            }
            String str = ConfigMgr.getSDCardCachePath() + new SimpleDateFormat(SDKLogMgr.FILE_NAME_DATE_FORMATE).format(new Date()) + new SecureRandom().nextInt(10) + ".zip";
            SDKLogMgr.this.zipLogFile(this.logFilePath, str);
            File file = new File(str);
            if (file.exists()) {
                boolean uploadFile = SDKLogMgr.this.uploadFile(str, String.format(RequestUrlContants.UPLOAD_BIG_FILE_URL, SDKLogMgr.this.mSeverDomain, file.getName()), file.getName(), this.listener);
                File file2 = new File(this.logFilePath);
                if (file2.exists()) {
                    if (file2.isDirectory()) {
                        File[] listFiles2 = new File(ConfigMgr.getDebugLogFilePath()).listFiles();
                        if (listFiles2 != null) {
                            for (int i2 = 0; i2 < listFiles2.length; i2++) {
                                SecurityUtil.securityCheck(listFiles2[i2].getAbsolutePath(), "delete");
                                listFiles2[i2].delete();
                            }
                        }
                    } else {
                        SecurityUtil.securityCheck(file2.getAbsolutePath(), "delete");
                        file2.delete();
                    }
                }
                SecurityUtil.securityCheck(file.getAbsolutePath(), "delete");
                file.delete();
                if (uploadFile) {
                    SDKLogMgr.this.uploadDebugInfo(this.req, this.url, this.listener, file.getName());
                    return;
                }
                OnDebugLogUploadReturnListener onDebugLogUploadReturnListener = this.listener;
                if (onDebugLogUploadReturnListener != null) {
                    onDebugLogUploadReturnListener.onDebugLogUploadReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGCAT_MODELCODE, 10)), "upload big file error");
                    LogEx.d(SDKLogMgr.LOG_TAG, "upload big debug file fail!");
                    return;
                }
                return;
            }
            OnDebugLogUploadReturnListener onDebugLogUploadReturnListener2 = this.listener;
            if (onDebugLogUploadReturnListener2 != null) {
                onDebugLogUploadReturnListener2.onDebugLogUploadReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGCAT_MODELCODE, 1)), "zip file not exists");
                LogEx.d(SDKLogMgr.LOG_TAG, "zip file not exists!");
            }
        }
    }

    private SDKLogMgr() {
        mstrFilePath = ConfigMgr.getDebugLogFilePath();
        File file = new File(mstrFilePath);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backupLogFile(File file) {
        String str = ConfigMgr.getDebugLogFilePath() + LOG_BACK_FILE_NAME;
        File file2 = new File(str);
        if (file2.exists()) {
            SecurityUtil.securityCheck(file2.getAbsolutePath(), "delete");
            file2.delete();
        }
        if (file.exists() && file.isFile()) {
            customRenameTo(file, new File(str));
        }
    }

    private void checkFile() {
        if (TextUtils.isEmpty(this.mstrlogName)) {
            String format = new SimpleDateFormat(FILE_NAME_DATE_FORMATE).format(new Date());
            SecureRandom secureRandom = null;
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            if (secureRandom != null) {
                this.mstrlogName = format + secureRandom.nextInt(10) + ".log";
            } else {
                this.mstrlogName = format + ".log";
            }
        }
        if (mstrFilePath == null) {
            mstrFilePath = ConfigMgr.getDebugLogFilePath();
            File file = new File(mstrFilePath);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        File file2 = new File(mstrFilePath, this.mstrlogName);
        this.mstrFileName = file2;
        if (file2.exists()) {
            SecurityUtil.securityCheck(this.mstrFileName.getAbsolutePath(), "delete");
            this.mstrFileName.delete();
        }
        try {
            SecurityUtil.securityCheck(this.mstrFileName.getAbsolutePath(), "createNewFile");
            this.mstrFileName.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static SDKLogMgr createInstance() {
        return instance;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0083 -> B:14:0x009d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void customRenameTo(java.io.File r10, java.io.File r11) {
        /*
            r9 = this;
            boolean r0 = r10.renameTo(r11)
            if (r0 != 0) goto L9d
            r0 = 0
            java.lang.String r1 = r11.getAbsolutePath()     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L53
            java.lang.String r2 = "createNewFile"
            com.video.androidsdk.common.util.SecurityUtil.securityCheck(r1, r2)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L53
            r11.createNewFile()     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L53
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L53
            java.lang.String r2 = "r"
            r1.<init>(r10, r2)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L53
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4d
            java.lang.String r3 = "rw"
            r2.<init>(r11, r3)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4d
            java.nio.channels.FileChannel r0 = r2.getChannel()     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4e
            java.nio.channels.FileChannel r3 = r1.getChannel()     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4e
            java.nio.channels.FileChannel$MapMode r4 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4e
            r5 = 0
            long r7 = r10.length()     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4e
            java.nio.MappedByteBuffer r3 = r3.map(r4, r5, r7)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4e
            r0.write(r3)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4e
            r10.delete()     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4e
            r1.close()     // Catch: java.io.IOException -> L3f
            goto L43
        L3f:
            r10 = move-exception
            r10.printStackTrace()
        L43:
            r2.close()     // Catch: java.io.IOException -> L82
            goto L9d
        L47:
            r10 = move-exception
            goto L4b
        L49:
            r10 = move-exception
            r2 = r0
        L4b:
            r0 = r1
            goto L88
        L4d:
            r2 = r0
        L4e:
            r0 = r1
            goto L54
        L50:
            r10 = move-exception
            r2 = r0
            goto L88
        L53:
            r2 = r0
        L54:
            java.lang.String r1 = "SDKLogMgr"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L87
            r3.<init>()     // Catch: java.lang.Throwable -> L87
            java.lang.String r4 = "Error to rename file: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L87
            r3.append(r10)     // Catch: java.lang.Throwable -> L87
            java.lang.String r10 = " > "
            r3.append(r10)     // Catch: java.lang.Throwable -> L87
            r3.append(r11)     // Catch: java.lang.Throwable -> L87
            java.lang.String r10 = r3.toString()     // Catch: java.lang.Throwable -> L87
            com.video.androidsdk.log.LogEx.e(r1, r10)     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L7c
            r0.close()     // Catch: java.io.IOException -> L78
            goto L7c
        L78:
            r10 = move-exception
            r10.printStackTrace()
        L7c:
            if (r2 == 0) goto L9d
            r2.close()     // Catch: java.io.IOException -> L82
            goto L9d
        L82:
            r10 = move-exception
            r10.printStackTrace()
            goto L9d
        L87:
            r10 = move-exception
        L88:
            if (r0 == 0) goto L92
            r0.close()     // Catch: java.io.IOException -> L8e
            goto L92
        L8e:
            r11 = move-exception
            r11.printStackTrace()
        L92:
            if (r2 == 0) goto L9c
            r2.close()     // Catch: java.io.IOException -> L98
            goto L9c
        L98:
            r11 = move-exception
            r11.printStackTrace()
        L9c:
            throw r10
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.log.SDKLogMgr.customRenameTo(java.io.File, java.io.File):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteOldLogFile(File file) {
        File[] listFiles;
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (!listFiles[i].getAbsolutePath().endsWith(".BAK")) {
                SecurityUtil.securityCheck(listFiles[i].getAbsolutePath(), "delete");
                listFiles[i].delete();
            }
        }
    }

    private void setCommonParams(UpLoadCrashExceptionLogRequest upLoadCrashExceptionLogRequest, BaseUploadLogReq baseUploadLogReq) {
        upLoadCrashExceptionLogRequest.setManufacturer(Build.MANUFACTURER);
        upLoadCrashExceptionLogRequest.setModel(Build.MODEL);
        upLoadCrashExceptionLogRequest.setOsversion(Build.VERSION.RELEASE);
        if (TextUtils.isEmpty(baseUploadLogReq.getTerminalType())) {
            upLoadCrashExceptionLogRequest.setTerminaltype(DEFAULT_UNKNOW_PARAM);
        } else {
            upLoadCrashExceptionLogRequest.setTerminaltype(baseUploadLogReq.getTerminalType());
        }
        if (TextUtils.isEmpty(baseUploadLogReq.getAppName())) {
            upLoadCrashExceptionLogRequest.setAppname(AndroidUtils.getAppName(SDKMgr.getApplicationContext()));
        } else {
            upLoadCrashExceptionLogRequest.setAppname(baseUploadLogReq.getAppName());
        }
        if (TextUtils.isEmpty(baseUploadLogReq.getAppVersion())) {
            upLoadCrashExceptionLogRequest.setAppVersion(String.valueOf(AndroidUtils.getAppVersionCode(SDKMgr.getApplicationContext())));
        } else {
            upLoadCrashExceptionLogRequest.setAppVersion(baseUploadLogReq.getAppVersion());
        }
        if (TextUtils.isEmpty(baseUploadLogReq.getUserName())) {
            upLoadCrashExceptionLogRequest.setUsername(DEFAULT_UNKNOW_PARAM);
        } else {
            upLoadCrashExceptionLogRequest.setUsername(baseUploadLogReq.getUserName());
        }
        if (TextUtils.isEmpty(baseUploadLogReq.getCreateTime())) {
            upLoadCrashExceptionLogRequest.setCreatetime(new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date()));
        } else {
            upLoadCrashExceptionLogRequest.setCreatetime(baseUploadLogReq.getCreateTime());
        }
        if (TextUtils.isEmpty(baseUploadLogReq.getFileName())) {
            upLoadCrashExceptionLogRequest.setFilename(new SimpleDateFormat(FILE_NAME_DATE_FORMATE, Locale.getDefault()).format(new Date()) + new SecureRandom().nextInt(10));
            return;
        }
        upLoadCrashExceptionLogRequest.setFilename(baseUploadLogReq.getFileName());
    }

    private void upLoadNewCrashLog(CrashFileUpLoadReq crashFileUpLoadReq, String str, final OnCrashFileUploadReturnListener onCrashFileUploadReturnListener) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        UpLoadCrashExceptionLogRequest upLoadCrashExceptionLogRequest;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    inputStreamReader = new InputStreamReader(new FileInputStream(new File(crashFileUpLoadReq.getFilePath())), "UTF-8");
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } catch (FileNotFoundException e) {
                        e = e;
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                inputStreamReader = null;
            } catch (IOException e4) {
                e = e4;
                inputStreamReader = null;
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
            try {
                SecurityUtil.securityCheck(bufferedReader.toString(), "readLine");
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                }
                if (StringUtil.isEmptyString(str)) {
                    upLoadCrashExceptionLogRequest = new UpLoadCrashExceptionLogRequest(String.format(RequestUrlContants.UPLOAD_LOG_URL, this.mSeverDomain));
                } else {
                    upLoadCrashExceptionLogRequest = new UpLoadCrashExceptionLogRequest(str);
                }
                setCommonParams(upLoadCrashExceptionLogRequest, crashFileUpLoadReq);
                upLoadCrashExceptionLogRequest.setErrorcode("0");
                upLoadCrashExceptionLogRequest.setErrordesc(sb.toString());
                upLoadCrashExceptionLogRequest.setFiletype(FileType.CRASH);
                upLoadCrashExceptionLogRequest.setCallBack(new UpLoadCrashExceptionLogRequest.CallBack() { // from class: com.video.androidsdk.log.SDKLogMgr.2
                    @Override // com.video.androidsdk.log.UpLoadCrashExceptionLogRequest.CallBack
                    public void uploadCrashExceptionLogCallback(String str2, String str3) {
                        OnCrashFileUploadReturnListener onCrashFileUploadReturnListener2 = onCrashFileUploadReturnListener;
                        if (onCrashFileUploadReturnListener2 != null) {
                            onCrashFileUploadReturnListener2.onCrashFileUploadReturn(String.valueOf(str2), str3);
                            LogEx.d(SDKLogMgr.LOG_TAG, "uploadCrashExceptionLogCallback,returncode:" + str2 + " errMsg:" + str3);
                        }
                    }
                });
                upLoadCrashExceptionLogRequest.startQuery();
                bufferedReader.close();
                inputStreamReader.close();
            } catch (FileNotFoundException e5) {
                e = e5;
                bufferedReader2 = bufferedReader;
                e.printStackTrace();
                if (onCrashFileUploadReturnListener != null) {
                    onCrashFileUploadReturnListener.onCrashFileUploadReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGCAT_MODELCODE, 2)), "CrashFileUpLoadReq FileNotFoundException");
                }
                LogEx.w(LOG_TAG, "CrashFileUpLoadReq FileNotFoundException");
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException e6) {
                e = e6;
                bufferedReader2 = bufferedReader;
                e.printStackTrace();
                if (onCrashFileUploadReturnListener != null) {
                    onCrashFileUploadReturnListener.onCrashFileUploadReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGCAT_MODELCODE, 2)), "CrashFileUpLoadReq IOException");
                }
                LogEx.w(LOG_TAG, "CrashFileUpLoadReq IOException");
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        throw th;
                    }
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                throw th;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadDebugInfo(DebugLogReq debugLogReq, String str, final OnDebugLogUploadReturnListener onDebugLogUploadReturnListener, String str2) {
        UpLoadCrashExceptionLogRequest upLoadCrashExceptionLogRequest;
        if (StringUtil.isEmptyString(str)) {
            upLoadCrashExceptionLogRequest = new UpLoadCrashExceptionLogRequest(String.format(RequestUrlContants.UPLOAD_LOG_URL, this.mSeverDomain));
        } else {
            upLoadCrashExceptionLogRequest = new UpLoadCrashExceptionLogRequest(str);
        }
        debugLogReq.setFileName(str2);
        setCommonParams(upLoadCrashExceptionLogRequest, debugLogReq);
        upLoadCrashExceptionLogRequest.setErrordesc(TextUtils.isEmpty(debugLogReq.getDescription()) ? FileType.DEBUG : debugLogReq.getDescription());
        upLoadCrashExceptionLogRequest.setFiletype(FileType.DEBUG);
        upLoadCrashExceptionLogRequest.setCallBack(new UpLoadCrashExceptionLogRequest.CallBack() { // from class: com.video.androidsdk.log.SDKLogMgr.4
            @Override // com.video.androidsdk.log.UpLoadCrashExceptionLogRequest.CallBack
            public void uploadCrashExceptionLogCallback(String str3, String str4) {
                OnDebugLogUploadReturnListener onDebugLogUploadReturnListener2 = onDebugLogUploadReturnListener;
                if (onDebugLogUploadReturnListener2 != null) {
                    onDebugLogUploadReturnListener2.onDebugLogUploadReturn(String.valueOf(str3), str4);
                    LogEx.d(SDKLogMgr.LOG_TAG, "uploadCrashExceptionLogCallback,returncode:" + str3 + " errMsg:" + str4);
                }
            }
        });
        upLoadCrashExceptionLogRequest.startQuery();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x009f -> B:28:0x00f1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void writeLog() {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.log.SDKLogMgr.writeLog():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zipLogFile(String str, String str2) {
        if (str == null || !new File(str).exists()) {
            return;
        }
        try {
            ZipUtil.zip(str, str2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLogFilePath() {
        return mstrFilePath;
    }

    public boolean getRunningStatus() {
        return this.mRunning;
    }

    @Override // com.video.androidsdk.log.LogEx.LogReportListener
    public void reportLog(String str, int i) {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue;
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
        } else {
            if (this.saveLogLevel > i || (concurrentLinkedQueue = this.logQueue) == null) {
                return;
            }
            concurrentLinkedQueue.add(str);
        }
    }

    public void setLogName(String str) {
        this.mstrlogName = str;
        LogEx.d(LOG_TAG, "strName=" + this.mstrlogName);
    }

    public void setLogSize(long j) {
        if (j > 0) {
            this.mLogFileSize = j * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
    }

    public void setSeverDomain(String str) {
        this.mSeverDomain = str;
    }

    public void setUSBFileName(String str) {
    }

    public void setUSBLogDirName(String str) {
    }

    public void setUSBLogSize(long j) {
    }

    public void startAllLog() {
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (this.mRunning) {
            LogEx.d(LOG_TAG, "can not start Logcat multiple consecutive times");
            return;
        }
        LogEx.d(LOG_TAG, "start logcat");
        this.mRunning = true;
        Thread thread = new Thread(new Runnable() { // from class: com.video.androidsdk.log.SDKLogMgr.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Runtime.getRuntime().exec(SDKLogMgr.this.mstrClearLogCmds);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                SDKLogMgr.this.writeLog();
            }
        });
        this.mAllLogThread = thread;
        thread.start();
    }

    public void startDebugLog() {
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
        } else {
            startDebugLog(LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG);
        }
    }

    public void startUSBLogcat() {
    }

    public void stopAllLog() {
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d(LOG_TAG, "stop logcat");
        this.mRunning = false;
        if (this.mAllLogThread != null) {
            try {
                Thread.sleep(500L);
                this.mAllLogThread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.mAllLogThread = null;
        }
    }

    public void stopDebugLog() {
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.setmLogReportListener(null);
        SaveLogThread saveLogThread = this.saveLogThread;
        if (saveLogThread != null) {
            saveLogThread.shutdown();
            this.saveLogThread = null;
        }
        LogEx.setLogLevel(this.originalLogLevelType);
        this.isCatchingDebugLog = false;
    }

    public void stopUSBLogcat() {
    }

    public void uploadCrashFile(CrashFileUpLoadReq crashFileUpLoadReq, OnCrashFileUploadReturnListener onCrashFileUploadReturnListener) {
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
        } else {
            uploadCrashFile(crashFileUpLoadReq, "", onCrashFileUploadReturnListener);
        }
    }

    public void uploadDebugLog(DebugLogReq debugLogReq, OnDebugLogUploadReturnListener onDebugLogUploadReturnListener) {
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
        } else {
            uploadDebugLog(debugLogReq, "", onDebugLogUploadReturnListener);
        }
    }

    public void uploadErrorLog(ErrorLogReq errorLogReq, OnErrorLogUploadReturnListener onErrorLogUploadReturnListener) {
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
        } else {
            uploadErrorLog(errorLogReq, "", onErrorLogUploadReturnListener);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:(4:17|18|(4:149|150|(2:151|(1:153)(1:154))|155)|(2:144|145))|(2:21|22)|23|24|(4:25|26|27|28)|(18:35|36|37|38|(2:39|(1:41)(1:42))|43|44|46|47|48|49|(2:51|52)|56|57|(2:59|(1:61))|63|(1:65)|66)|75|76|77|78|(2:79|(1:81)(1:82))|83|44|46|47|48|49|(0)|56|57|(0)|63|(0)|66) */
    /* JADX WARN: Can't wrap try/catch for region: R(29:16|17|18|(4:149|150|(2:151|(1:153)(1:154))|155)|(2:144|145)|21|22|23|24|(4:25|26|27|28)|(18:35|36|37|38|(2:39|(1:41)(1:42))|43|44|46|47|48|49|(2:51|52)|56|57|(2:59|(1:61))|63|(1:65)|66)|75|76|77|78|(2:79|(1:81)(1:82))|83|44|46|47|48|49|(0)|56|57|(0)|63|(0)|66) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0252, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0253, code lost:
    
        r13.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01ec, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01ed, code lost:
    
        r14.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01e4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01e5, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x021a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x027d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[Catch: all -> 0x0286, IOException -> 0x0289, SYNTHETIC, TRY_LEAVE, TryCatch #8 {IOException -> 0x0289, blocks: (B:18:0x003d, B:143:0x011e, B:24:0x0145, B:71:0x01ed, B:57:0x0237, B:59:0x023d, B:68:0x0253, B:55:0x01f7, B:74:0x01e5, B:120:0x0285, B:119:0x0282, B:126:0x0278, B:131:0x026e, B:95:0x0233, B:100:0x0229, B:105:0x021f, B:148:0x013c, B:178:0x0131, B:179:0x0134, B:184:0x0129, B:165:0x0116), top: B:17:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0273 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0269 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0169 A[Catch: all -> 0x020d, IOException -> 0x0211, TRY_ENTER, TryCatch #28 {IOException -> 0x0211, all -> 0x020d, blocks: (B:26:0x015d, B:30:0x0169, B:32:0x0171, B:35:0x017a, B:75:0x01a3), top: B:25:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019a A[Catch: all -> 0x01fb, IOException -> 0x01ff, LOOP:0: B:39:0x0194->B:41:0x019a, LOOP_END, TryCatch #29 {IOException -> 0x01ff, all -> 0x01fb, blocks: (B:38:0x0188, B:39:0x0194, B:41:0x019a, B:43:0x019e, B:44:0x01cb, B:78:0x01b1, B:79:0x01bd, B:81:0x01c3, B:83:0x01c7), top: B:28:0x0167 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x019e A[EDGE_INSN: B:42:0x019e->B:43:0x019e BREAK  A[LOOP:0: B:39:0x0194->B:41:0x019a], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x023d A[Catch: JSONException -> 0x0252, all -> 0x0286, IOException -> 0x0289, TRY_LEAVE, TryCatch #8 {IOException -> 0x0289, blocks: (B:18:0x003d, B:143:0x011e, B:24:0x0145, B:71:0x01ed, B:57:0x0237, B:59:0x023d, B:68:0x0253, B:55:0x01f7, B:74:0x01e5, B:120:0x0285, B:119:0x0282, B:126:0x0278, B:131:0x026e, B:95:0x0233, B:100:0x0229, B:105:0x021f, B:148:0x013c, B:178:0x0131, B:179:0x0134, B:184:0x0129, B:165:0x0116), top: B:17:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c3 A[Catch: all -> 0x01fb, IOException -> 0x01ff, LOOP:1: B:79:0x01bd->B:81:0x01c3, LOOP_END, TryCatch #29 {IOException -> 0x01ff, all -> 0x01fb, blocks: (B:38:0x0188, B:39:0x0194, B:41:0x019a, B:43:0x019e, B:44:0x01cb, B:78:0x01b1, B:79:0x01bd, B:81:0x01c3, B:83:0x01c7), top: B:28:0x0167 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c7 A[EDGE_INSN: B:82:0x01c7->B:83:0x01c7 BREAK  A[LOOP:1: B:79:0x01bd->B:81:0x01c3], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v27, types: [int] */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v34, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r13v41 */
    /* JADX WARN: Type inference failed for: r13v42 */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v44 */
    /* JADX WARN: Type inference failed for: r13v45 */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.video.androidsdk.log.SDKLogMgr$OnDebugLogUploadReturnListener] */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v24, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r14v29, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r14v34 */
    /* JADX WARN: Type inference failed for: r14v35 */
    /* JADX WARN: Type inference failed for: r14v36 */
    /* JADX WARN: Type inference failed for: r14v37 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v41 */
    /* JADX WARN: Type inference failed for: r14v42 */
    /* JADX WARN: Type inference failed for: r14v43 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean uploadFile(java.lang.String r11, java.lang.String r12, java.lang.String r13, com.video.androidsdk.log.SDKLogMgr.OnDebugLogUploadReturnListener r14) {
        /*
            Method dump skipped, instructions count: 709
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.log.SDKLogMgr.uploadFile(java.lang.String, java.lang.String, java.lang.String, com.video.androidsdk.log.SDKLogMgr$OnDebugLogUploadReturnListener):boolean");
    }

    public void uploadUserFeedBack(UserFeedBackReq userFeedBackReq, OnUploadUserFeedBackReturnListener onUploadUserFeedBackReturnListener) {
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
        } else {
            uploadUserFeedBack(userFeedBackReq, "", onUploadUserFeedBackReturnListener);
        }
    }

    public void startDebugLog(LogEx.LogLevelType logLevelType) {
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (this.isCatchingDebugLog) {
            return;
        }
        this.isCatchingDebugLog = true;
        LogEx.setLogLevel(logLevelType);
        this.logQueue = new ConcurrentLinkedQueue<>();
        this.saveLogLevel = logLevelType.getValue();
        LogEx.setmLogReportListener(this);
        SaveLogThread saveLogThread = new SaveLogThread();
        this.saveLogThread = saveLogThread;
        saveLogThread.start();
    }

    public void uploadCrashFile(CrashFileUpLoadReq crashFileUpLoadReq, String str, OnCrashFileUploadReturnListener onCrashFileUploadReturnListener) {
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (crashFileUpLoadReq != null && (!StringUtil.isEmptyString(str) || !StringUtil.isEmptyString(this.mSeverDomain))) {
            upLoadNewCrashLog(crashFileUpLoadReq, str, onCrashFileUploadReturnListener);
            return;
        }
        if (onCrashFileUploadReturnListener != null) {
            onCrashFileUploadReturnListener.onCrashFileUploadReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGCAT_MODELCODE, 3)), "req is null or ip:port or url is null");
        }
        LogEx.w(LOG_TAG, "uploadCrashFile params error");
    }

    public void uploadDebugLog(DebugLogReq debugLogReq, String str, OnDebugLogUploadReturnListener onDebugLogUploadReturnListener) {
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (debugLogReq != null && (!StringUtil.isEmptyString(str) || !StringUtil.isEmptyString(this.mSeverDomain))) {
            if (this.singleThreadPool == null) {
                this.singleThreadPool = Executors.newSingleThreadExecutor();
            }
            if (this.singleThreadPool == null) {
                if (onDebugLogUploadReturnListener != null) {
                    onDebugLogUploadReturnListener.onDebugLogUploadReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGCAT_MODELCODE, 1)), "create singleThreadPool error");
                }
                LogEx.w(LOG_TAG, "create singleThreadPool error");
                return;
            }
            if (!TextUtils.isEmpty(debugLogReq.getFilePath())) {
                File file = new File(debugLogReq.getFilePath());
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            this.singleThreadPool.execute(new UploadDebugFileThread(debugLogReq, str, onDebugLogUploadReturnListener, file2.getAbsolutePath()));
                        }
                        return;
                    }
                    return;
                }
                this.singleThreadPool.execute(new UploadDebugFileThread(debugLogReq, str, onDebugLogUploadReturnListener, debugLogReq.getFilePath()));
                return;
            }
            this.singleThreadPool.execute(new UploadDebugFileThread(debugLogReq, str, onDebugLogUploadReturnListener, null));
            return;
        }
        if (onDebugLogUploadReturnListener != null) {
            onDebugLogUploadReturnListener.onDebugLogUploadReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGCAT_MODELCODE, 3)), "req is null or ip:port is null");
        }
        LogEx.w(LOG_TAG, "uploadDebugLog params error");
    }

    public void uploadErrorLog(ErrorLogReq errorLogReq, String str, final OnErrorLogUploadReturnListener onErrorLogUploadReturnListener) {
        UpLoadCrashExceptionLogRequest upLoadCrashExceptionLogRequest;
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (errorLogReq != null && (!StringUtil.isEmptyString(str) || !StringUtil.isEmptyString(this.mSeverDomain))) {
            if (StringUtil.isEmptyString(str)) {
                upLoadCrashExceptionLogRequest = new UpLoadCrashExceptionLogRequest(String.format(RequestUrlContants.UPLOAD_LOG_URL, this.mSeverDomain));
            } else {
                upLoadCrashExceptionLogRequest = new UpLoadCrashExceptionLogRequest(str);
            }
            setCommonParams(upLoadCrashExceptionLogRequest, errorLogReq);
            upLoadCrashExceptionLogRequest.setErrorcode(errorLogReq.getErrorCode());
            upLoadCrashExceptionLogRequest.setErrordesc(errorLogReq.getErrorDesc());
            upLoadCrashExceptionLogRequest.setFiletype("error");
            upLoadCrashExceptionLogRequest.setCallBack(new UpLoadCrashExceptionLogRequest.CallBack() { // from class: com.video.androidsdk.log.SDKLogMgr.3
                @Override // com.video.androidsdk.log.UpLoadCrashExceptionLogRequest.CallBack
                public void uploadCrashExceptionLogCallback(String str2, String str3) {
                    OnErrorLogUploadReturnListener onErrorLogUploadReturnListener2 = onErrorLogUploadReturnListener;
                    if (onErrorLogUploadReturnListener2 != null) {
                        onErrorLogUploadReturnListener2.onErrorLogUploadReturn(String.valueOf(str2), str3);
                        LogEx.d(SDKLogMgr.LOG_TAG, "uploadCrashExceptionLogCallback,returncode:" + str2 + " errMsg:" + str3);
                    }
                }
            });
            upLoadCrashExceptionLogRequest.startQuery();
            return;
        }
        if (onErrorLogUploadReturnListener != null) {
            onErrorLogUploadReturnListener.onErrorLogUploadReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGCAT_MODELCODE, 3)), "req is null or ip:port is null");
        }
        LogEx.w(LOG_TAG, "uploadErrorLog params error");
    }

    public void uploadUserFeedBack(UserFeedBackReq userFeedBackReq, String str, final OnUploadUserFeedBackReturnListener onUploadUserFeedBackReturnListener) {
        UpLoadCrashExceptionLogRequest upLoadCrashExceptionLogRequest;
        if (!a.f3132d) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (userFeedBackReq != null && (!StringUtil.isEmptyString(str) || !StringUtil.isEmptyString(this.mSeverDomain))) {
            if (TextUtils.isEmpty(str)) {
                upLoadCrashExceptionLogRequest = new UpLoadCrashExceptionLogRequest(String.format(RequestUrlContants.UPLOAD_LOG_URL, this.mSeverDomain));
            } else {
                upLoadCrashExceptionLogRequest = new UpLoadCrashExceptionLogRequest(str);
            }
            setCommonParams(upLoadCrashExceptionLogRequest, userFeedBackReq);
            upLoadCrashExceptionLogRequest.setErrordesc(userFeedBackReq.getFeedbackinfo());
            upLoadCrashExceptionLogRequest.setFiletype(FileType.USER_FEEDBACK);
            upLoadCrashExceptionLogRequest.setCallBack(new UpLoadCrashExceptionLogRequest.CallBack() { // from class: com.video.androidsdk.log.SDKLogMgr.1
                @Override // com.video.androidsdk.log.UpLoadCrashExceptionLogRequest.CallBack
                public void uploadCrashExceptionLogCallback(String str2, String str3) {
                    OnUploadUserFeedBackReturnListener onUploadUserFeedBackReturnListener2 = onUploadUserFeedBackReturnListener;
                    if (onUploadUserFeedBackReturnListener2 != null) {
                        onUploadUserFeedBackReturnListener2.onUserFeedBackUploadReturn(String.valueOf(str2), str3);
                        LogEx.d(SDKLogMgr.LOG_TAG, "uploadCrashExceptionLogCallback,returncode:" + str2 + " errMsg:" + str3);
                    }
                }
            });
            upLoadCrashExceptionLogRequest.startQuery();
            return;
        }
        if (onUploadUserFeedBackReturnListener != null) {
            onUploadUserFeedBackReturnListener.onUserFeedBackUploadReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGCAT_MODELCODE, 3)), "req is null or ip:port is null");
        }
        LogEx.w(LOG_TAG, "uploadUserFeedBack params error");
    }
}
