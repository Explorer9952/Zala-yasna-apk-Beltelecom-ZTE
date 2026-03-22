package com.video.androidsdk.log;

import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class LogEx {
    private static final String LOG_TAG = "LogEx";
    public static final String STR_DEFAULT_JAVA_FILE_EXT = ".java";
    private static final String STR_FORMAT_YEAR_MOUTH_DAY = "yyyyMMdd";
    private static LogLevelType m_typeLogLevel = LogLevelType.TYPE_LOG_LEVEL_INFO;
    private static LogReportListener mLogReportListener = null;

    /* loaded from: classes.dex */
    public enum LogLevelType {
        TYPE_LOG_LEVEL_DEBUG(1),
        TYPE_LOG_LEVEL_INFO(2),
        TYPE_LOG_LEVEL_WARNING(3),
        TYPE_LOG_LEVEL_ERROR(4);

        private final int m_iEnumValue;

        LogLevelType(int i) {
            this.m_iEnumValue = i;
        }

        public int getValue() {
            return this.m_iEnumValue;
        }
    }

    /* loaded from: classes.dex */
    public interface LogReportListener {
        void reportLog(String str, int i);
    }

    private LogEx() {
    }

    public static void d(String str, String str2) {
        if (LogLevelType.TYPE_LOG_LEVEL_DEBUG != m_typeLogLevel || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String lineInfo = getLineInfo(new Throwable());
        String formatLogString = formatLogString("D", str, str2, lineInfo);
        Log.d(str, formatDateString(str2, lineInfo));
        LogReportListener logReportListener = mLogReportListener;
        if (logReportListener != null) {
            logReportListener.reportLog(formatLogString, LogLevelType.TYPE_LOG_LEVEL_DEBUG.getValue());
        }
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String lineInfo = getLineInfo(new Throwable());
        String formatLogString = formatLogString("E", str, str2, lineInfo);
        Log.e(str, formatDateString(str2, lineInfo));
        LogReportListener logReportListener = mLogReportListener;
        if (logReportListener != null) {
            logReportListener.reportLog(formatLogString, LogLevelType.TYPE_LOG_LEVEL_ERROR.getValue());
        }
    }

    public static String formatDateString(String str, String str2) {
        return (str == null || str2 == null) ? "" : String.format("%-23s%s%s", formatTime(Calendar.getInstance().getTime()), str2, str);
    }

    private static String formatLogString(String str, String str2, String str3, String str4) {
        if (str2 == null || str3 == null || str4 == null) {
            return null;
        }
        return String.format("[%s][%s][%s]%s%s", str, str2, formatTime(Calendar.getInstance().getTime()), str4, str3);
    }

    private static String formatTime(Date date) {
        return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.ENGLISH).format(date);
    }

    public static String getLineInfo(Throwable th) {
        String str;
        if (th == null) {
            Log.w(LOG_TAG, "ta is null!");
            return "";
        }
        try {
            StackTraceElement stackTraceElement = th.getStackTrace()[1];
            if (stackTraceElement == null) {
                Log.w(LOG_TAG, "element is null!");
                return "";
            }
            String format = String.format(" L[%d]", Integer.valueOf(stackTraceElement.getLineNumber()));
            String fileName = stackTraceElement.getFileName();
            String format2 = String.format("[%s]", stackTraceElement.getMethodName());
            if (!TextUtils.isEmpty(fileName)) {
                if (fileName.substring(fileName.length() - 5, fileName.length()).equalsIgnoreCase(STR_DEFAULT_JAVA_FILE_EXT)) {
                    fileName = fileName.substring(0, fileName.length() - 5);
                }
                str = String.format(" F[%s]", fileName);
            } else {
                Log.w(LOG_TAG, "strFileName is null!");
                str = " F[]";
            }
            return String.format("%-23s%-7s%-22s", str, format, format2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static LogLevelType getLogLevel() {
        return m_typeLogLevel;
    }

    public static LogReportListener getmLogReportListener() {
        return mLogReportListener;
    }

    public static void i(String str, String str2) {
        if (LogLevelType.TYPE_LOG_LEVEL_DEBUG == m_typeLogLevel || LogLevelType.TYPE_LOG_LEVEL_INFO == m_typeLogLevel) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String lineInfo = getLineInfo(new Throwable());
                String formatLogString = formatLogString("I", str, str2, lineInfo);
                Log.i(str, formatDateString(str2, lineInfo));
                LogReportListener logReportListener = mLogReportListener;
                if (logReportListener != null) {
                    logReportListener.reportLog(formatLogString, LogLevelType.TYPE_LOG_LEVEL_INFO.getValue());
                    return;
                }
                return;
            }
            Log.w(LOG_TAG, "strModuleName is null or strInfo is null!");
        }
    }

    public static void setLogLevel(LogLevelType logLevelType) {
        d(LOG_TAG, "typeLevel=" + logLevelType);
        m_typeLogLevel = logLevelType;
    }

    public static void setmLogReportListener(LogReportListener logReportListener) {
        mLogReportListener = logReportListener;
    }

    public static void w(String str, String str2) {
        if ((LogLevelType.TYPE_LOG_LEVEL_DEBUG != m_typeLogLevel && LogLevelType.TYPE_LOG_LEVEL_INFO != m_typeLogLevel && LogLevelType.TYPE_LOG_LEVEL_WARNING != m_typeLogLevel) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String lineInfo = getLineInfo(new Throwable());
        String formatLogString = formatLogString("W", str, str2, lineInfo);
        Log.w(str, formatDateString(str2, lineInfo));
        LogReportListener logReportListener = mLogReportListener;
        if (logReportListener != null) {
            logReportListener.reportLog(formatLogString, LogLevelType.TYPE_LOG_LEVEL_WARNING.getValue());
        }
    }
}
