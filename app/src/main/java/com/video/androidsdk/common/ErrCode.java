package com.video.androidsdk.common;

import android.app.Activity;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;

/* loaded from: classes.dex */
public class ErrCode {
    public static final int ERRCODE_ADS_MODELCODE = 18000000;
    public static final int ERRCODE_ALREADY_BE_PROCESSED = 9;
    public static final int ERRCODE_AUTH_ORDER_MODELCODE = 17900000;
    public static final int ERRCODE_BLACKOUT_MODELCODE = 19800000;
    public static final int ERRCODE_BOOKMARK_MODELCODE = 18700000;
    public static final int ERRCODE_CACHE_MODELCODE = 19300000;
    public static final int ERRCODE_CHANNEL_MODELCODE = 18300000;
    public static final int ERRCODE_CLOUDVR_MODELCODE = 19700000;
    public static final int ERRCODE_COLUMN_MODELCODE = 18200000;
    public static final int ERRCODE_COMMENT_MODELCODE = 20500000;
    public static final int ERRCODE_COMMONTOOLS_MODELCODE = 17500000;
    public static final int ERRCODE_COMMON_MODELCODE = 17000000;
    public static final int ERRCODE_COMMUNITY_MODELCODE = 19400000;
    public static final int ERRCODE_CONFIG_INVALID = 101;
    public static final int ERRCODE_CONFIG_LOST = 100;
    public static final int ERRCODE_DATA_NO_RESPONSE = 13;
    public static final int ERRCODE_DLNA_DEVICE_OFFLINE = 20;
    public static final int ERRCODE_DLNA_MODELCODE = 17300000;
    public static final int ERRCODE_DLNA_NOTINIT = 18;
    public static final int ERRCODE_DLNA_REQUEST_OVERFLOW = 19;
    public static final int ERRCODE_DOWNLOAD_MODELCODE = 18100000;
    public static final int ERRCODE_EPG_SESSION_TIMEOUT = -1001;
    public static final int ERRCODE_EXCEPTION = 103;
    public static final int ERRCODE_FAIL = 1;
    public static final int ERRCODE_FAVORITE_MODELCODE = 18600000;
    public static final int ERRCODE_GET_DATA_FAILED = 5;
    public static final int ERRCODE_GET_REQUEST_NULL = 8;
    public static final int ERRCODE_HOMEPAGE_MODELCODE = 19000000;
    public static final int ERRCODE_HTTP_GET_DATA_FAILED = 170004;
    public static final int ERRCODE_HTTP_MODELCODE = 17200000;
    public static final int ERRCODE_HTTP_MOVED_TEMP = 302;
    public static final int ERRCODE_HTTP_NOT_FOUND = 404;
    public static final int ERRCODE_HTTP_PARAM_IS_NULL = 172001;
    public static final int ERRCODE_INVALID_PARAM = 3;
    public static final int ERRCODE_LIC_INVALIDATE = 17;
    public static final int ERRCODE_LOCK_MODELCODE = 18800000;
    public static final int ERRCODE_LOGCAT_MODELCODE = 17800000;
    public static final int ERRCODE_LOGIN_61 = 1;
    public static final int ERRCODE_LOGIN_62 = 2;
    public static final int ERRCODE_LOGIN_75 = 3;
    public static final int ERRCODE_LOGIN_80 = 4;
    public static final int ERRCODE_LOGIN_MODELCODE = 17100000;
    public static final int ERRCODE_NETIMAGE_FILE_LENGTH_EXCEPTION = 11;
    public static final int ERRCODE_NETWORK_NOT_AVAILABLE = 10;
    public static final int ERRCODE_NOT_SIMPLEJSON = 202;
    public static final int ERRCODE_NPVR_MODELCODE = 19500000;
    public static final int ERRCODE_OK = 0;
    public static final int ERRCODE_OK_EMPTY_DATA = 50991021;
    public static final int ERRCODE_PAGE_NOT_FOUND = 14;
    public static final int ERRCODE_PARAM_IS_NULL = 2;
    public static final int ERRCODE_PARSE_RESULT_FAILED = 6;
    public static final int ERRCODE_PAY_MODELCODE = 20300000;
    public static final int ERRCODE_PLAYURL_MODELCODE = 17400000;
    public static final int ERRCODE_PREVUE_MODELCODE = 18400000;
    public static final int ERRCODE_PROFILE_MODELCODE = 19900000;
    public static final int ERRCODE_QCS_LOGIN_REGISTERED = 116004;
    public static final int ERRCODE_RECOMMEND_MODELCODE = 19100000;
    public static final int ERRCODE_REFRESH_TOKEN_FAILED = 123021;
    public static final int ERRCODE_REMIND_MODELCODE = 19600000;
    public static final int ERRCODE_RESULT_EMPTY = 99;
    public static final int ERRCODE_SEARCH_MODELCODE = 19200000;
    public static final int ERRCODE_SESSION_INVALID = 7;
    public static final int ERRCODE_STB_DISCONNECT = 15;
    public static final int ERRCODE_STB_RECONNECT = 16;
    public static final int ERRCODE_SUBSCRIPTION_MODELCODE = 20200000;
    public static final int ERRCODE_THREADPOOL_NULL = 204;
    public static final int ERRCODE_THUMBNAIL_MODELCODE = 20400000;
    public static final int ERRCODE_TIME_OUT = 4;
    public static final int ERRCODE_TRUEERROR = 50211001;
    public static final int ERRCODE_UPGRADE_MODELCODE = 17700000;
    public static final int ERRCODE_URL_INVALID = 203;
    public static final int ERRCODE_USERDATA_MODELCODE = 20000000;
    public static final int ERRCODE_USER_CANCEL = 102;
    public static final int ERRCODE_USER_OPERATION_MODELCODE = 17600000;
    public static final int ERRCODE_VERSION_TOO_LOW = 12;
    public static final int ERRCODE_VIEWHISTORY_MODELCODE = 18900000;
    public static final int ERRCODE_VOD_MODELCODE = 18500000;
    public static final String LOG_TAG = "ErrCode";

    public static int getErrCode(int i) {
        return i + ERRCODE_COMMON_MODELCODE;
    }

    public static int getErrCode(int i, int i2) {
        return i + i2;
    }

    public static int getErrCode(int i, int i2, int i3) {
        return i + (i2 * 1000) + i3;
    }

    public static String getString(Activity activity, int i, int i2) {
        if (activity != null) {
            String string = activity.getResources().getString(i);
            if (string != null) {
                return String.format(string, Integer.valueOf(i2));
            }
            LogEx.w(LOG_TAG, "Failed to get string with resid " + i + "from resource!");
            return "";
        }
        LogEx.w(LOG_TAG, "activity is null!");
        return "";
    }

    public static String getString(String str, int i) {
        if (!StringUtil.isEmptyString(str)) {
            return String.format(str, Integer.valueOf(i));
        }
        LogEx.w(LOG_TAG, "strErrorDescription is null!");
        return "";
    }
}
