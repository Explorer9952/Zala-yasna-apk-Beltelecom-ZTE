package com.video.androidsdk.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import com.video.androidsdk.common.util.SecurityUtil;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String DATE_FORMATE = "yyyyMMddHHmmss";
    private static CrashHandler m_instance;
    private static String m_strErrorFilePath;
    private File m_fileDir;
    private Thread.UncaughtExceptionHandler m_handlerDefault;
    private PackageInfo m_pkgInfo;
    private String m_pkgname;
    private ICrashHandler minstanceCrashHandler = null;

    /* loaded from: classes.dex */
    public interface ICrashHandler {
        boolean onUncaughtExceptionOccured(Thread thread, Throwable th);
    }

    private CrashHandler(String str) {
        m_strErrorFilePath = str;
    }

    public static CrashHandler getInstance(String str) {
        if (m_instance == null) {
            m_instance = new CrashHandler(str);
        }
        return m_instance;
    }

    private boolean handleException(Throwable th) {
        if (th == null) {
            return false;
        }
        th.printStackTrace();
        DataOutputStream dataOutputStream = null;
        try {
            try {
                try {
                    String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                    if (!StringUtil.isEmptyString(m_strErrorFilePath)) {
                        File file = new File(m_strErrorFilePath + "Crash_" + format + ".txt");
                        SecurityUtil.securityCheck(file.getAbsolutePath(), "createNewFile");
                        if (file.createNewFile()) {
                            DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(file));
                            try {
                                printSysInfo(dataOutputStream2);
                                th.printStackTrace(new PrintStream(dataOutputStream2));
                                dataOutputStream = dataOutputStream2;
                            } catch (FileNotFoundException e) {
                                e = e;
                                dataOutputStream = dataOutputStream2;
                                e.printStackTrace();
                                if (dataOutputStream == null) {
                                    return true;
                                }
                                dataOutputStream.close();
                                return true;
                            } catch (IOException e2) {
                                e = e2;
                                dataOutputStream = dataOutputStream2;
                                e.printStackTrace();
                                if (dataOutputStream == null) {
                                    return true;
                                }
                                dataOutputStream.close();
                                return true;
                            } catch (Throwable th2) {
                                th = th2;
                                dataOutputStream = dataOutputStream2;
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
            } catch (IOException e5) {
                e = e5;
            }
            if (dataOutputStream == null) {
                return true;
            }
            dataOutputStream.close();
            return true;
        } catch (IOException e6) {
            e6.printStackTrace();
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01b3 A[Catch: all -> 0x01d2, IOException -> 0x01d5, LOOP:1: B:27:0x01ad->B:30:0x01b3, LOOP_END, TRY_LEAVE, TryCatch #18 {IOException -> 0x01d5, all -> 0x01d2, blocks: (B:28:0x01ad, B:30:0x01b3), top: B:27:0x01ad }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01c6 A[EDGE_INSN: B:31:0x01c6->B:32:0x01c6 BREAK  A[LOOP:1: B:27:0x01ad->B:30:0x01b3], EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void printSysInfo(java.io.DataOutputStream r9) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.CrashHandler.printSysInfo(java.io.DataOutputStream):void");
    }

    public File getCrashDir() {
        return this.m_fileDir;
    }

    public void init(Context context) {
        if (context != null) {
            this.m_pkgname = context.getPackageName();
            try {
                this.m_pkgInfo = context.getPackageManager().getPackageInfo(this.m_pkgname, 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        this.m_handlerDefault = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        if (StringUtil.isEmptyString(m_strErrorFilePath)) {
            return;
        }
        File file = new File(m_strErrorFilePath);
        this.m_fileDir = file;
        file.mkdirs();
    }

    public void setICrashHandlerListener(ICrashHandler iCrashHandler) {
        this.minstanceCrashHandler = iCrashHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (th == null) {
            LogEx.w("uncaughtException", "null == ex");
            return;
        }
        ICrashHandler iCrashHandler = this.minstanceCrashHandler;
        if (iCrashHandler != null) {
            iCrashHandler.onUncaughtExceptionOccured(thread, th);
        }
        if (!handleException(th) && (uncaughtExceptionHandler = this.m_handlerDefault) != null) {
            uncaughtExceptionHandler.uncaughtException(null, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }
}
