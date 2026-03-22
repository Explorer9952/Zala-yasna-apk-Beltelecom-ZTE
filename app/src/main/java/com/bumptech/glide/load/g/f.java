package com.bumptech.glide.load.g;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: HttpUrlFetcher.java */
/* loaded from: classes.dex */
public class f implements com.bumptech.glide.load.g.c<InputStream> {
    private static final c f = new b();

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.h.d f2062a;

    /* renamed from: b, reason: collision with root package name */
    private final c f2063b;

    /* renamed from: c, reason: collision with root package name */
    private HttpURLConnection f2064c;

    /* renamed from: d, reason: collision with root package name */
    private InputStream f2065d;
    private volatile boolean e;

    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    private static class b implements c {
        private b() {
        }

        @Override // com.bumptech.glide.load.g.f.c
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    public interface c {
        HttpURLConnection a(URL url) throws IOException;
    }

    public f(com.bumptech.glide.load.h.d dVar) {
        this(dVar, f);
    }

    @Override // com.bumptech.glide.load.g.c
    public void b() {
        InputStream inputStream = this.f2065d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f2064c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.bumptech.glide.load.g.c
    public void cancel() {
        this.e = true;
    }

    f(com.bumptech.glide.load.h.d dVar, c cVar) {
        this.f2062a = dVar;
        this.f2063b = cVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.g.c
    public InputStream a(Priority priority) throws Exception {
        return a(this.f2062a.c(), 0, null, this.f2062a.b());
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new IOException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f2064c = this.f2063b.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f2064c.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f2064c.setConnectTimeout(2500);
            this.f2064c.setReadTimeout(2500);
            this.f2064c.setUseCaches(false);
            this.f2064c.setDoInput(true);
            this.f2064c.connect();
            if (this.e) {
                return null;
            }
            int responseCode = this.f2064c.getResponseCode();
            int i2 = responseCode / 100;
            if (i2 == 2) {
                return a(this.f2064c);
            }
            if (i2 == 3) {
                String headerField = this.f2064c.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    return a(new URL(url, headerField), i + 1, url, map);
                }
                throw new IOException("Received empty or null redirect url");
            }
            if (responseCode == -1) {
                throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
            }
            throw new IOException("Request failed " + responseCode + ": " + this.f2064c.getResponseMessage());
        }
        throw new IOException("Too many (> 5) redirects!");
    }

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f2065d = com.bumptech.glide.s.b.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f2065d = httpURLConnection.getInputStream();
        }
        return this.f2065d;
    }

    @Override // com.bumptech.glide.load.g.c
    public String a() {
        return this.f2062a.a();
    }
}
