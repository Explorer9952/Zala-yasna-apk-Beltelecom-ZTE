package com.video.androidsdk.login;

import android.text.TextUtils;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
class r implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr.OnSSOLoginReturnListener f3214a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr f3215b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SDKLoginMgr sDKLoginMgr, SDKLoginMgr.OnSSOLoginReturnListener onSSOLoginReturnListener) {
        this.f3215b = sDKLoginMgr;
        this.f3214a = onSSOLoginReturnListener;
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onDataReturn(String str) {
        LogEx.d("SDKLoginMgr", "SDKNetHTTPRequest onDataReturn:" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("returncode");
            String optString2 = jSONObject.optString("errormsg");
            String optString3 = jSONObject.optString("usercode");
            String optString4 = jSONObject.optString("password");
            if (TextUtils.equals(optString, "0")) {
                this.f3215b.startLogin(optString3, optString4);
            } else {
                this.f3214a.onSSOLoginReturn(optString, optString2, str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            LogEx.w("SDKLoginMgr", "JSONException occur");
            this.f3214a.onSSOLoginReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2, 202)), "JSONException occur", "");
        }
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onFailReturn(int i, String str) {
        LogEx.w("SDKLoginMgr", "SDKNetHTTPRequest onFailReturn");
        this.f3214a.onSSOLoginReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 103)), String.valueOf(i), str);
    }
}
