package com.video.androidsdk.login;

import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
public class t implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr.ISDKLoginReturnListener f3217a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr f3218b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SDKLoginMgr sDKLoginMgr, SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener) {
        this.f3218b = sDKLoginMgr;
        this.f3217a = iSDKLoginReturnListener;
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onDataReturn(String str) {
        LogEx.d("SDKLoginMgr", "updateUserToken onSuccessReturn:returndata:" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("Result");
            String string = jSONObject.getString("NewUserToken");
            String string2 = jSONObject.getString("TokenExpiredTime");
            m.a().put("UserToken", string);
            if (this.f3217a != null) {
                this.f3217a.onRefreshUserTokeReturn(i, string, string2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener = this.f3217a;
            if (iSDKLoginReturnListener != null) {
                iSDKLoginReturnListener.onRefreshUserTokeReturn(-1, "", "");
            }
        }
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onFailReturn(int i, String str) {
        LogEx.d("SDKLoginMgr", "updateUserToken onFailReturn:returncode:" + i + ",errormsg:" + str);
        SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener = this.f3217a;
        if (iSDKLoginReturnListener != null) {
            iSDKLoginReturnListener.onRefreshUserTokeReturn(i, "", "");
        }
    }
}
