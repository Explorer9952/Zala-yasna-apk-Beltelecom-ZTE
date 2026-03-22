package com.video.androidsdk.common.config;

import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;

/* loaded from: classes.dex */
public class DSTConfigurator {
    public final String LOG_TAG = DSTConfigurator.class.getSimpleName();
    String dstSavings;
    String endDate;
    String startDate;
    String zoneID;
    String zoneOffset;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ConfigDSTTime {
        public int miHour;
        public int miMonth;
        public int miWeekDay;
        public int miWhichWeek;

        ConfigDSTTime() {
        }
    }

    public DSTConfigurator(String str, String str2, String str3, String str4, String str5) {
        this.zoneOffset = str;
        this.zoneID = str2;
        this.dstSavings = str3;
        this.startDate = str4;
        this.endDate = str5;
    }

    private int getTimeOffset(String str) {
        int intValue;
        if (str != null && !StringUtil.isEmptyString(str)) {
            try {
                int i = 1;
                if (str.charAt(0) == '-') {
                    intValue = Integer.valueOf(str.substring(1)).intValue();
                    i = -1;
                } else {
                    intValue = Integer.valueOf(str).intValue();
                }
                LogEx.d(this.LOG_TAG, "bFlag=" + i + ",iEPGTimeOffset = " + intValue);
                return i * intValue * 60 * 1000;
            } catch (Exception unused) {
                LogEx.w(this.LOG_TAG, "get iEPGTimeOffse Exception,strEPGTimeOffset=" + str);
                return 0;
            }
        }
        LogEx.w(this.LOG_TAG, "get TimeOffset error,maybe not congfig.");
        return 0;
    }

    private ConfigDSTTime parseDSTDate(String str) {
        if (StringUtil.isEmptyString(str)) {
            LogEx.w(this.LOG_TAG, "Get strSummerRule error, maybe not congfig.");
            return null;
        }
        LogEx.d(this.LOG_TAG, "dstDate =" + str);
        String[] splitString = StringUtil.splitString(str, ",");
        if (splitString.length != 4) {
            LogEx.w(this.LOG_TAG, "dstDate invalid," + str);
            return null;
        }
        ConfigDSTTime configDSTTime = new ConfigDSTTime();
        try {
            configDSTTime.miMonth = Integer.valueOf(splitString[0]).intValue();
            configDSTTime.miWhichWeek = Integer.valueOf(splitString[1]).intValue();
            configDSTTime.miWeekDay = Integer.valueOf(splitString[2]).intValue();
            configDSTTime.miHour = Integer.valueOf(splitString[3]).intValue();
            LogEx.d(this.LOG_TAG, "miMonth=" + configDSTTime.miMonth + ", miWhichWeek=" + configDSTTime.miWhichWeek + ", miWeekDay=" + configDSTTime.miWeekDay + ", miHour=" + configDSTTime.miHour);
            return configDSTTime;
        } catch (Exception unused) {
            LogEx.w(this.LOG_TAG, "dstDate invalid," + str);
            return null;
        }
    }

    private int tranZoneOffset(String str) {
        int i;
        int intValue;
        int intValue2;
        if (str != null && !StringUtil.isEmptyString(str)) {
            LogEx.d(this.LOG_TAG, "strZone, " + str);
            int i2 = 1;
            int i3 = 0;
            if (str.startsWith("GMT")) {
                if (str.length() != 9) {
                    LogEx.w(this.LOG_TAG, "strZone input invalid,strZone.length() != 9.");
                    return -1;
                }
                if (str.charAt(3) != '+') {
                    if (str.charAt(3) != '-') {
                        LogEx.w(this.LOG_TAG, "Invalid symbol," + str);
                        return -1;
                    }
                    i2 = -1;
                }
                try {
                    intValue = Integer.valueOf(str.substring(4, 6)).intValue();
                    intValue2 = Integer.valueOf(str.substring(7)).intValue();
                } catch (Exception unused) {
                    LogEx.w(this.LOG_TAG, "Integer.valueOf exception ," + str);
                    return -1;
                }
            } else {
                if (!str.startsWith("-") && !str.startsWith("+")) {
                    try {
                        intValue = Integer.valueOf(str).intValue();
                    } catch (Exception unused2) {
                        LogEx.w(this.LOG_TAG, "Integer.valueOf exception ," + str);
                        return -1;
                    }
                } else {
                    if (str.charAt(0) == '+') {
                        i = 1;
                    } else {
                        i = str.charAt(0) == '-' ? -1 : 0;
                    }
                    if (str.length() == 6) {
                        try {
                            int intValue3 = Integer.valueOf(str.substring(1, 3)).intValue();
                            intValue2 = Integer.valueOf(str.substring(4)).intValue();
                            i2 = i;
                            intValue = intValue3;
                        } catch (Exception unused3) {
                            LogEx.w(this.LOG_TAG, "Integer.valueOf exception ," + str);
                            return -1;
                        }
                    } else {
                        try {
                            i2 = i;
                            intValue = Integer.valueOf(str.substring(1)).intValue();
                        } catch (Exception unused4) {
                            LogEx.w(this.LOG_TAG, "Integer.valueOf exception ," + str);
                            return -1;
                        }
                    }
                }
                intValue2 = 0;
            }
            LogEx.d(this.LOG_TAG, "iFlag=" + i2 + ", iHourPart=" + intValue + ", iMinPart=" + intValue2);
            if (intValue < 0 || intValue > 12 || intValue2 < 0 || intValue2 >= 60) {
                LogEx.w(this.LOG_TAG, "strZone invalid," + str);
            } else {
                i3 = i2 * ((intValue * 60) + intValue2);
            }
            LogEx.d(this.LOG_TAG, "iZoneOffset = " + i3);
            return i3 * 60 * 1000;
        }
        LogEx.w(this.LOG_TAG, "strZone input invalid.");
        return -1;
    }

    public void setDSTRules() {
        if (this.zoneID == null) {
            LogEx.w(this.LOG_TAG, "zoneID invalid." + this.zoneID);
        }
        int tranZoneOffset = tranZoneOffset(this.zoneOffset);
        if (-1 == tranZoneOffset) {
            LogEx.w(this.LOG_TAG, "zoneOffset invalid." + this.zoneOffset);
            return;
        }
        int timeOffset = getTimeOffset(this.dstSavings);
        ConfigDSTTime parseDSTDate = parseDSTDate(this.startDate);
        if (parseDSTDate == null) {
            LogEx.w(this.LOG_TAG, "get summerStartTime null.");
            return;
        }
        int i = parseDSTDate.miMonth - 1;
        int i2 = ((parseDSTDate.miWhichWeek - 1) * 7) + 1;
        int i3 = -(parseDSTDate.miWeekDay + 1);
        int i4 = parseDSTDate.miHour * 3600000;
        ConfigDSTTime parseDSTDate2 = parseDSTDate(this.endDate);
        if (parseDSTDate2 == null) {
            LogEx.w(this.LOG_TAG, "get summerEndTime null.");
            return;
        }
        TimeUtil.setDSTRules(tranZoneOffset, this.zoneID, i, i2, i3, i4, parseDSTDate2.miMonth - 1, ((parseDSTDate2.miWhichWeek - 1) * 7) + 1, -(parseDSTDate2.miWeekDay + 1), parseDSTDate2.miHour * 3600000, timeOffset);
    }
}
