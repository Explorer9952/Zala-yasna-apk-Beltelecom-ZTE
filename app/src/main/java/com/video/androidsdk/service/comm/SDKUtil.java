package com.video.androidsdk.service.comm;

import android.text.TextUtils;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.mes.BuildConfig;
import com.video.androidsdk.service.a.a;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class SDKUtil {
    private static final String STR_DRMTYPE_ENCRYPT_KEY = "exodrmtypekey";
    private static final String TAG = "SDKUtil";
    private static String playHeaderKey = "";

    public static String aesEncode(String str, String str2) {
        try {
            return AES.aesEncode(str.getBytes(), str2.getBytes());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getAESDecryptText(String str, String str2) {
        try {
            return AES.aesDecryptByBase64(str, AES.getEncryptKey(getEncryptKeyName(str2)).getBytes());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getAESEncryptText(String str) {
        return a.a(str);
    }

    public static String getDRMEncryptInfo(String str, String str2, String str3) {
        return a.a(str, str2, str3);
    }

    private static String getEncryptKeyName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 48563) {
            if (hashCode != 49524) {
                if (hashCode == 50485 && str.equals("3.0")) {
                    c2 = 2;
                }
            } else if (str.equals("2.0")) {
                c2 = 1;
            }
        } else if (str.equals(BuildConfig.VERSION_NAME)) {
            c2 = 0;
        }
        return c2 != 0 ? c2 != 1 ? c2 != 2 ? "" : "3.0_tudianaeskey" : "2.0_tudianaeskey" : "1.0_tudianaeskey";
    }

    public static String getPlayHeader(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String format = simpleDateFormat.format(new Date());
        if (TextUtils.isEmpty(playHeaderKey)) {
            playHeaderKey = com.video.androidsdk.license.a.a(STR_DRMTYPE_ENCRYPT_KEY);
        }
        return aesEncode(str + "-" + format, playHeaderKey);
    }

    public static String getAESEncryptText(String str, String str2) {
        try {
            return AES.aesEncryptByBase64(str.getBytes(), AES.getEncryptKey(getEncryptKeyName(str2)).getBytes());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
