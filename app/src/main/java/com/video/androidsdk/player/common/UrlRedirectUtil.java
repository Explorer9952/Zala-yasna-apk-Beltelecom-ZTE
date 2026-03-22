package com.video.androidsdk.player.common;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.concurrent.Executors;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* loaded from: classes.dex */
public class UrlRedirectUtil {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;

    /* renamed from: b, reason: collision with root package name */
    private static String f3351b = "UrlRedirectUtil";

    /* renamed from: c, reason: collision with root package name */
    private static String f3352c = "get";

    /* renamed from: d, reason: collision with root package name */
    private static String f3353d = "fail";
    private static String e = "redo";
    private static String[] k = new String[0];
    private a f;
    private String g;
    private b h;
    private String j;
    private String i = "";

    /* renamed from: a, reason: collision with root package name */
    final HostnameVerifier f3354a = new d(this);

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2);
    }

    public UrlRedirectUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Log.i(f3351b, "Finish url redirect, new url:" + this.i);
        if (this.f != null) {
            LogEx.d(f3351b, "UrlRedirectListener is noticed");
            this.f.a(this.j, this.i);
        } else {
            LogEx.w(f3351b, "UrlRedirectListener is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Log.w(f3351b, "Url Redirect fail");
        if (this.f != null) {
            LogEx.d(f3351b, "UrlRedirectListener is noticed");
            this.f.a(this.j, "");
        } else {
            LogEx.w(f3351b, "UrlRedirectListener is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        TrustManager[] trustManagerArr = {new e(this)};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void cancel() {
        b bVar = this.h;
        if (bVar != null) {
            bVar.cancel(true);
            this.f = null;
        }
    }

    public void getUrlAfterRedirection(String str) {
        LogEx.d(f3351b, "Begin url redirect, original url:" + str);
        this.g = str;
        b bVar = new b(this, null);
        this.h = bVar;
        bVar.executeOnExecutor(Executors.newCachedThreadPool(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends AsyncTask<String, String, String> {

        /* renamed from: a, reason: collision with root package name */
        HttpURLConnection f3355a;

        private b() {
            this.f3355a = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            try {
                try {
                    URL url = new URL(strArr[0]);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    this.f3355a = httpURLConnection;
                    httpURLConnection.setConnectTimeout(8000);
                    this.f3355a.setReadTimeout(8000);
                    if (url.getProtocol().toUpperCase().equals("HTTPS")) {
                        UrlRedirectUtil.this.h();
                    }
                    if (this.f3355a instanceof HttpsURLConnection) {
                        ((HttpsURLConnection) this.f3355a).setHostnameVerifier(UrlRedirectUtil.this.f3354a);
                    }
                    this.f3355a.setRequestMethod("GET");
                    int responseCode = this.f3355a.getResponseCode();
                    LogEx.d(UrlRedirectUtil.f3351b, "httpcode=" + responseCode);
                    UrlRedirectUtil.this.j = String.valueOf(responseCode);
                    if (responseCode == 200) {
                        UrlRedirectUtil.this.i = this.f3355a.getURL().toString();
                        String str = UrlRedirectUtil.f3352c;
                        HttpURLConnection httpURLConnection2 = this.f3355a;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return str;
                    }
                    if (responseCode != 302) {
                        LogEx.w(UrlRedirectUtil.f3351b, "Http Resp Error, Response Code is " + responseCode);
                        String str2 = UrlRedirectUtil.f3353d;
                        HttpURLConnection httpURLConnection3 = this.f3355a;
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        return str2;
                    }
                    String headerField = this.f3355a.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        String str3 = UrlRedirectUtil.f3353d;
                        HttpURLConnection httpURLConnection4 = this.f3355a;
                        if (httpURLConnection4 != null) {
                            httpURLConnection4.disconnect();
                        }
                        return str3;
                    }
                    UrlRedirectUtil.this.g = new String(headerField.getBytes("iso-8859-1"), "utf-8");
                    String str4 = UrlRedirectUtil.e;
                    HttpURLConnection httpURLConnection5 = this.f3355a;
                    if (httpURLConnection5 != null) {
                        httpURLConnection5.disconnect();
                    }
                    return str4;
                } catch (IOException e) {
                    e.printStackTrace();
                    UrlRedirectUtil.this.j = "001";
                    String str5 = UrlRedirectUtil.f3353d;
                    HttpURLConnection httpURLConnection6 = this.f3355a;
                    if (httpURLConnection6 != null) {
                        httpURLConnection6.disconnect();
                    }
                    return str5;
                }
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection7 = this.f3355a;
                if (httpURLConnection7 != null) {
                    httpURLConnection7.disconnect();
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(String str) {
            super.onCancelled(str);
            Log.d(UrlRedirectUtil.f3351b, "s");
            HttpURLConnection httpURLConnection = this.f3355a;
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e) {
                    Log.e(UrlRedirectUtil.f3351b, "Unexpected error while disconnecting", e);
                }
                this.f3355a = null;
            }
        }

        /* synthetic */ b(UrlRedirectUtil urlRedirectUtil, d dVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            if (!str.equals(UrlRedirectUtil.f3352c)) {
                if (!str.equals(UrlRedirectUtil.e)) {
                    UrlRedirectUtil.this.g();
                } else {
                    UrlRedirectUtil urlRedirectUtil = UrlRedirectUtil.this;
                    urlRedirectUtil.getUrlAfterRedirection(urlRedirectUtil.g);
                }
            } else {
                UrlRedirectUtil.this.f();
            }
            super.onPostExecute(str);
        }
    }

    public UrlRedirectUtil(a aVar) {
        this.f = aVar;
    }

    public void getUrlAfterRedirection(String str, a aVar) {
        LogEx.d(f3351b, "Begin url redirect, original url:" + str);
        this.f = aVar;
        this.g = str;
        b bVar = new b(this, null);
        this.h = bVar;
        bVar.executeOnExecutor(Executors.newCachedThreadPool(), str);
    }
}
