package com.video.androidsdk.download;

import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.download.Linstener.OnTaskOperReturnListener;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKDownloadMgr.java */
/* loaded from: classes.dex */
public class f implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnTaskOperReturnListener f3125a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f3126b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f3127c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f3128d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ SDKDownloadMgr g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SDKDownloadMgr sDKDownloadMgr, OnTaskOperReturnListener onTaskOperReturnListener, String str, String str2, int i, String str3, String str4) {
        this.g = sDKDownloadMgr;
        this.f3125a = onTaskOperReturnListener;
        this.f3126b = str;
        this.f3127c = str2;
        this.f3128d = i;
        this.e = str3;
        this.f = str4;
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onDataReturn(String str) {
        String optString;
        String str2;
        LogEx.d("SDKDownloadMgr", "getVideoDownloadUrl success result:" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String ePGHome = SDKLoginMgr.getInstance().getEPGHome();
            if (!TextUtils.isEmpty(ePGHome) && ePGHome.startsWith(HttpConstant.PROTOCOL_HTTPS)) {
                optString = jSONObject.optString("httpsplayurl");
            } else {
                optString = jSONObject.optString("playurl");
            }
            LogEx.d("SDKDownloadMgr", "playurl is: " + optString);
            String dashRedirectUrl = this.g.getDashRedirectUrl(optString);
            LogEx.d("SDKDownloadMgr", "DashRedirectUrl is: " + dashRedirectUrl);
            if (!TextUtils.isEmpty(dashRedirectUrl)) {
                if (!TextUtils.isEmpty(this.f3126b)) {
                    int indexOf = dashRedirectUrl.indexOf("?");
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(dashRedirectUrl.substring(0, indexOf));
                    stringBuffer.append("." + this.f3126b);
                    stringBuffer.append(dashRedirectUrl.substring(indexOf));
                    dashRedirectUrl = stringBuffer.toString();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(dashRedirectUrl);
                str2 = this.g.k;
                sb.append(str2);
                sb.append(this.f3127c);
                String sb2 = sb.toString();
                LogEx.d("SDKDownloadMgr", "finalurl is: " + sb2);
                this.g.a(this.f3128d, sb2, this.e, this.f);
                if (this.f3125a != null) {
                    this.f3125a.onTaskOperReturn("0", "download url has been updated", "");
                }
            }
            if (this.f3125a != null) {
                this.f3125a.onTaskOperReturn(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "download url was updated failed", "");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onFailReturn(int i, String str) {
        LogEx.d("SDKDownloadMgr", "getVideoDownloadUrl fail result:" + i);
        OnTaskOperReturnListener onTaskOperReturnListener = this.f3125a;
        if (onTaskOperReturnListener != null) {
            onTaskOperReturnListener.onTaskOperReturn(String.valueOf(i), str, "");
        }
    }
}
