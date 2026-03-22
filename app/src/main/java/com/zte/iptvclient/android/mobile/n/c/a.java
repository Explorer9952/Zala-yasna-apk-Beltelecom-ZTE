package com.zte.iptvclient.android.mobile.n.c;

import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.service.bean.UserLoginInfoReq;
import org.json.JSONObject;

/* compiled from: GetPassWordByAuthCode.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f6857a;

    /* renamed from: b, reason: collision with root package name */
    private b f6858b;

    /* renamed from: c, reason: collision with root package name */
    private String f6859c;

    /* compiled from: GetPassWordByAuthCode.java */
    /* renamed from: com.zte.iptvclient.android.mobile.n.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0316a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        C0316a() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            String str2;
            boolean isEmpty = TextUtils.isEmpty(str);
            String str3 = "";
            String str4 = null;
            String str5 = WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
            if (isEmpty) {
                a.this.f6858b.a(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "", null, null);
                LogEx.w("SDKUserMgr", "data response is null");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                str5 = jSONObject.optString("returncode");
                str2 = jSONObject.optString("errormsg");
                str3 = jSONObject.optString("usercode");
                str4 = jSONObject.optString("password");
            } catch (Exception e) {
                e.printStackTrace();
                str2 = "json error";
            }
            if (a.this.f6858b == null || TextUtils.isEmpty(str4)) {
                return;
            }
            a.this.f6858b.a(str5, str2, str3, str4);
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            if (a.this.f6858b != null) {
                a.this.f6858b.a(String.valueOf(i), str, null, null);
            }
        }
    }

    /* compiled from: GetPassWordByAuthCode.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(String str, String str2, String str3, String str4);
    }

    public a(String str) {
        this.f6859c = str;
    }

    public void a(String str, UserLoginInfoReq userLoginInfoReq, b bVar) {
        b bVar2;
        this.f6858b = bVar;
        if (userLoginInfoReq == null) {
            if (bVar != null) {
                bVar.a(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "UserLoginInfoReq is null", null, null);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.f6859c) && (bVar2 = this.f6858b) != null) {
            bVar2.a(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "UserLoginInfoReq authInfo is null", null, null);
        }
        this.f6857a = str;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "UTF-8");
        String str2 = "http://{impip:port}/ottuserlogin".replace("{impip:port}", this.f6857a) + "?authinfo=" + this.f6859c + "&ottuserid=" + userLoginInfoReq.ottuserid + "&identifycode=" + userLoginInfoReq.identifycode + "&terminalFlag=" + userLoginInfoReq.terminalFlag;
        LogEx.d("GetPassWordByAuthCode", "serviceUrl=" + str2);
        sDKNetHTTPRequest.startRequest(str2, HttpRequest.METHOD_POST, new C0316a());
    }
}
