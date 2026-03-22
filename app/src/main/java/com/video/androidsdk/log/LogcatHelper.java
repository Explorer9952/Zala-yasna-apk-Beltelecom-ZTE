package com.video.androidsdk.log;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.video.androidsdk.common.util.SecurityUtil;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class LogcatHelper {
    private static final int CONNECTION_TIMEOUT = 10000;
    private static final String FILE_NAME_DATE_FORMATE = "yyyyMMddhhmmssSSS";
    private static final String LOG_TAG = "SDKLogcatHelper";
    private static final int READ_TIMEOUT = 10000;
    private static LogcatHelper mLogcatHelper;
    private static String mstrFilePath;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private String mstrlogName = null;
    private File mstrFileName = null;
    private String mstrCmds = "logcat -v time";
    private boolean mRunning = false;
    private long mLogFileSize = 52428800;

    private LogcatHelper(Context context) {
        this.mHandlerThread = null;
        this.mHandler = null;
        if (Environment.getExternalStorageState().equals("mounted")) {
            mstrFilePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            mstrFilePath = context.getFilesDir().getAbsolutePath();
        }
        mstrFilePath += "/zxct/iptvLog/";
        File file = new File(mstrFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        HandlerThread handlerThread = new HandlerThread("logHandler");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.video.androidsdk.log.LogcatHelper.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                LogEx.i(LogcatHelper.LOG_TAG, "handleMessage =" + LogcatHelper.this.mRunning);
                LogcatHelper.this.writeLog();
            }
        };
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
        File file = new File(mstrFilePath, this.mstrlogName);
        this.mstrFileName = file;
        if (file.exists()) {
            SecurityUtil.securityCheck(this.mstrFileName.getAbsolutePath(), "delete");
            this.mstrFileName.delete();
        }
    }

    public static LogcatHelper getInstance(Context context) {
        if (mLogcatHelper == null) {
            mLogcatHelper = new LogcatHelper(context);
        }
        return mLogcatHelper;
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
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.log.LogcatHelper.writeLog():void");
    }

    public String getLogFilePath() {
        return mstrFilePath;
    }

    public void release() {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mHandlerThread = null;
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

    public void startLogcat() {
        Handler handler;
        LogEx.d(LOG_TAG, "start logcat");
        if (this.mRunning) {
            LogEx.d(LOG_TAG, "can not start Logcat multiple consecutive times");
        } else {
            if (this.mHandlerThread == null || (handler = this.mHandler) == null) {
                return;
            }
            this.mRunning = true;
            handler.removeCallbacksAndMessages(null);
            this.mHandler.sendEmptyMessageDelayed(0, 100L);
        }
    }

    public void stopLogcat() {
        LogEx.d(LOG_TAG, "stop logcat");
        this.mRunning = false;
    }

    public boolean uploadFile(String str) {
        return uploadFile(mstrFilePath + this.mstrlogName, str, this.mstrlogName);
    }

    public boolean uploadFile(String str, String str2) {
        return uploadFile(str, str2, this.mstrlogName);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x014a A[Catch: all -> 0x016b, IOException -> 0x016e, TryCatch #9 {all -> 0x016b, blocks: (B:17:0x0042, B:19:0x00b5, B:20:0x00ca, B:68:0x0121, B:73:0x0129, B:77:0x012e, B:78:0x0131, B:71:0x0126, B:60:0x010e, B:56:0x0116, B:44:0x011b, B:30:0x0142, B:32:0x014a, B:34:0x0152, B:63:0x0113, B:24:0x0134, B:29:0x013c, B:27:0x0139), top: B:16:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean uploadFile(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.log.LogcatHelper.uploadFile(java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
