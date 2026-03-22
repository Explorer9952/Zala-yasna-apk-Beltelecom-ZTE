package com.video.androidsdk.login;

import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
class p implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr.ISDKProfileLoginReturnListener f3208a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f3209b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr f3210c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SDKLoginMgr sDKLoginMgr, SDKLoginMgr.ISDKProfileLoginReturnListener iSDKProfileLoginReturnListener, String str) {
        this.f3210c = sDKLoginMgr;
        this.f3208a = iSDKProfileLoginReturnListener;
        this.f3209b = str;
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onDataReturn(String str) {
        LogEx.d("SDKLoginMgr", "onDataReturn  == " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.has("returncode") ? jSONObject.optString("returncode") : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
            String optString2 = jSONObject.has("errormsg") ? jSONObject.optString("errormsg") : "";
            if (this.f3208a != null && !TextUtils.equals(optString, "0")) {
                this.f3208a.onProfileLoginReturn(optString, optString2);
                return;
            }
            if (TextUtils.equals(optString, "0")) {
                if (!TextUtils.isEmpty(this.f3209b) && this.f3208a != null) {
                    this.f3210c.a(this.f3208a, this.f3209b);
                } else if (this.f3208a != null) {
                    this.f3208a.onProfileLoginReturn(optString, optString2);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            SDKLoginMgr.ISDKProfileLoginReturnListener iSDKProfileLoginReturnListener = this.f3208a;
            if (iSDKProfileLoginReturnListener != null) {
                iSDKProfileLoginReturnListener.onProfileLoginReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 202)), "JSONException occur");
            }
        }
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onFailReturn(int i, String str) {
        SDKLoginMgr.ISDKProfileLoginReturnListener iSDKProfileLoginReturnListener = this.f3208a;
        if (iSDKProfileLoginReturnListener != null) {
            iSDKProfileLoginReturnListener.onProfileLoginReturn(String.valueOf(i), str);
        }
    }
}
