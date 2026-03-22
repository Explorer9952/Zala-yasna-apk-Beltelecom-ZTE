package com.zte.iptvclient.android.common.i.b;

import android.os.AsyncTask;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.zte.iptvclient.android.common.f.b.i;

/* compiled from: ResourceAsyncTask.java */
/* loaded from: classes.dex */
public class b extends AsyncTask<String, Void, String> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f4640d = b.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0134b f4641a;

    /* renamed from: b, reason: collision with root package name */
    private String f4642b = "";

    /* renamed from: c, reason: collision with root package name */
    private boolean f4643c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResourceAsyncTask.java */
    /* loaded from: classes.dex */
    public class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(b.f4640d, "content= " + str);
            b.this.f4642b = str;
            b.this.f4643c = true;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(b.f4640d, "onFailReturn i = " + i + "  s = " + str);
            b.this.f4642b = "";
            b.this.f4643c = true;
        }
    }

    /* compiled from: ResourceAsyncTask.java */
    /* renamed from: com.zte.iptvclient.android.common.i.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0134b {
        void a(String str);
    }

    public b(InterfaceC0134b interfaceC0134b) {
        this.f4641a = interfaceC0134b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        this.f4642b = "";
        String str = strArr[0];
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "utf-8");
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.startRequest(str, "GET", new a());
        return this.f4642b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        InterfaceC0134b interfaceC0134b = this.f4641a;
        if (interfaceC0134b != null) {
            interfaceC0134b.a(str);
        }
    }
}
