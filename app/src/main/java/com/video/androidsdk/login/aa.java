package com.video.androidsdk.login;

import android.text.TextUtils;
import com.video.androidsdk.common.ServerDate;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SDKLoginMgr.java */
/* loaded from: classes.dex */
class aa implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKLoginMgr.a f3149a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SDKLoginMgr.a aVar) {
        this.f3149a = aVar;
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onDataReturn(String str) {
        SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener;
        SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener2;
        long j;
        String str2;
        LogEx.d("SDKLoginMgr", "updateUserToken onSuccessReturn:returndata:" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("Result");
            String string = jSONObject.getString("NewUserToken");
            String string2 = jSONObject.getString("TokenExpiredTime");
            iSDKLoginReturnListener2 = SDKLoginMgr.this.f3137c;
            iSDKLoginReturnListener2.onRefreshUserTokeReturn(i, string, string2);
            m.a().put("userToken", string);
            Date epgTime = ServerDate.getEpgTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            if (TextUtils.isEmpty(string2) || epgTime == null) {
                return;
            }
            try {
                j = simpleDateFormat.parse(string2).getTime() - epgTime.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
                j = 0;
            }
            if (j > 0) {
                SDKLoginMgr sDKLoginMgr = SDKLoginMgr.this;
                str2 = this.f3149a.f3140b;
                sDKLoginMgr.a(str2, j);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            iSDKLoginReturnListener = SDKLoginMgr.this.f3137c;
            iSDKLoginReturnListener.onRefreshUserTokeReturn(-1, "", "");
        }
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onFailReturn(int i, String str) {
        SDKLoginMgr.ISDKLoginReturnListener iSDKLoginReturnListener;
        LogEx.d("SDKLoginMgr", "updateUserToken onFailReturn:returncode:" + i + ",errormsg:" + str);
        iSDKLoginReturnListener = SDKLoginMgr.this.f3137c;
        iSDKLoginReturnListener.onRefreshUserTokeReturn(i, "", "");
    }
}
