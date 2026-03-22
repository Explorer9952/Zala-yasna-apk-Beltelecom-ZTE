package com.video.androidsdk.collectAgent;

import com.video.androidsdk.collectAgent.u;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;

/* compiled from: CommonHTTPRequest.java */
/* loaded from: classes.dex */
class v implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ u.a f3107a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ u f3108b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, u.a aVar) {
        this.f3108b = uVar;
        this.f3107a = aVar;
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onDataReturn(String str) {
        LogEx.d("CommonHTTPRequest", "SDKNetHTTPRequest success");
        this.f3107a.a(0, "SDKNetHTTPRequest success");
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onFailReturn(int i, String str) {
        LogEx.w("CommonHTTPRequest", "SDKNetHTTPRequest onFailReturn");
        this.f3107a.a(-1, "SDKNetHTTPRequest onFailReturn");
    }
}
