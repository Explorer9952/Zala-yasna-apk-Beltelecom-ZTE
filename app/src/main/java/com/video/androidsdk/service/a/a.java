package com.video.androidsdk.service.a;

import android.text.TextUtils;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.ServerDate;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import org.json.JSONObject;

/* compiled from: Security4CELLCImp.java */
/* loaded from: classes.dex */
public class a {
    public static String a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            String a2 = com.video.androidsdk.license.a.a("cellcdrmkey");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("Usertoken", SDKLoginMgr.getInstance().getUserInfo("UserToken"));
                jSONObject.put("VendorCode", str3);
                jSONObject.put("ProjectCode", str);
                jSONObject.put("DeviceId", str2);
                jSONObject.put("TimeStamp", TimeUtil.formatUTC(ServerDate.getEpgTime(), "yyyyMMddHHmmss"));
                return AES.aesEncryptByBase64(jSONObject.toString().getBytes(), a2.getBytes());
            } catch (Exception e) {
                LogEx.e("Security4CELLCImp", e.getMessage());
            }
        }
        return "";
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            LogEx.w("Security4CELLCImp", ErrMessage.PARAM_IS_NULL);
            return "";
        }
        try {
            return AES.aesEncryptByBase64(str.getBytes(), com.video.androidsdk.license.a.a("cellccommonkey").getBytes());
        } catch (Exception e) {
            LogEx.e("Security4CELLCImp", e.getMessage());
            return "";
        }
    }
}
