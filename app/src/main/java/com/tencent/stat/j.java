package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.appevents.UserDataStore;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j {

    /* renamed from: c, reason: collision with root package name */
    private static com.tencent.stat.i.b f2894c = com.tencent.stat.i.m.b();

    /* renamed from: d, reason: collision with root package name */
    private static j f2895d = null;
    private static Context e = null;

    /* renamed from: a, reason: collision with root package name */
    DefaultHttpClient f2896a;

    /* renamed from: b, reason: collision with root package name */
    Handler f2897b;

    private j() {
        this.f2896a = null;
        this.f2897b = null;
        try {
            HandlerThread handlerThread = new HandlerThread("StatDispatcher");
            handlerThread.start();
            handlerThread.getId();
            this.f2897b = new Handler(handlerThread.getLooper());
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
            this.f2896a = defaultHttpClient;
            defaultHttpClient.setKeepAliveStrategy(new k(this));
            if (c.b() != null) {
                this.f2896a.getParams().setParameter("http.route.default-proxy", c.b());
            }
        } catch (Throwable th) {
            f2894c.c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context a() {
        return e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        e = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized j b() {
        j jVar;
        synchronized (j.class) {
            if (f2895d == null) {
                f2895d = new j();
            }
            jVar = f2895d;
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.tencent.stat.a.b bVar, h hVar) {
        b(Arrays.asList(bVar.d()), hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<String> list, h hVar) {
        boolean z;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int i = 0;
            while (true) {
                z = true;
                if (i >= list.size()) {
                    break;
                }
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(",");
                }
                i++;
            }
            sb.append("]");
            String p = c.p();
            f2894c.e("[" + p + "]Send request(" + sb.toString().length() + "bytes):" + sb.toString());
            HttpPost httpPost = new HttpPost(p);
            httpPost.addHeader("Accept-Encoding", "gzip");
            httpPost.setHeader("Connection", "Keep-Alive");
            httpPost.removeHeaders("Cache-Control");
            HttpHost h = com.tencent.stat.i.m.h(e);
            if (h != null) {
                this.f2896a.getParams().setParameter("http.route.default-proxy", com.tencent.stat.i.m.h(e));
                httpPost.addHeader("X-Online-Host", "pingma.qq.com:80");
                httpPost.addHeader("Accept", "*/*");
                httpPost.addHeader("Content-Type", "json");
            } else {
                z = false;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = sb.toString().getBytes("UTF-8");
            int length = bytes.length;
            if (sb.length() >= 256) {
                if (h == null) {
                    httpPost.addHeader("Content-Encoding", "rc4,gzip");
                } else {
                    httpPost.addHeader("X-Content-Encoding", "rc4,gzip");
                }
                byteArrayOutputStream.write(new byte[4]);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                bytes = byteArrayOutputStream.toByteArray();
                ByteBuffer.wrap(bytes, 0, 4).putInt(length);
                f2894c.a("before Gzip:" + length + " bytes, after Gzip:" + bytes.length + " bytes");
            } else if (h == null) {
                httpPost.addHeader("Content-Encoding", "rc4");
            } else {
                httpPost.addHeader("X-Content-Encoding", "rc4");
            }
            httpPost.setEntity(new ByteArrayEntity(com.tencent.stat.i.g.a(bytes)));
            HttpResponse execute = this.f2896a.execute(httpPost);
            if (z) {
                this.f2896a.getParams().removeParameter("http.route.default-proxy");
            }
            HttpEntity entity = execute.getEntity();
            int statusCode = execute.getStatusLine().getStatusCode();
            long contentLength = entity.getContentLength();
            f2894c.e("recv response status code:" + statusCode + ", content length:" + contentLength);
            if (contentLength == 0) {
                EntityUtils.toString(entity);
                if (statusCode != 200) {
                    f2894c.d("Server response error code:" + statusCode);
                } else if (hVar != null) {
                    hVar.a();
                }
            } else if (contentLength > 0) {
                InputStream content = entity.getContent();
                DataInputStream dataInputStream = new DataInputStream(content);
                byte[] bArr = new byte[(int) entity.getContentLength()];
                dataInputStream.readFully(bArr);
                content.close();
                dataInputStream.close();
                Header firstHeader = execute.getFirstHeader("Content-Encoding");
                if (firstHeader != null) {
                    if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                        bArr = com.tencent.stat.i.g.b(com.tencent.stat.i.m.a(bArr));
                    } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                        bArr = com.tencent.stat.i.m.a(com.tencent.stat.i.g.b(bArr));
                    } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                        bArr = com.tencent.stat.i.m.a(bArr);
                    } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                        bArr = com.tencent.stat.i.g.b(bArr);
                    }
                }
                if (statusCode == 200) {
                    try {
                        String str = new String(bArr, "UTF-8");
                        f2894c.a(str);
                        JSONObject jSONObject = new JSONObject(str);
                        if (!jSONObject.isNull("cfg")) {
                            c.a(jSONObject.getJSONObject("cfg"));
                        }
                        if (!jSONObject.isNull("et") && !jSONObject.isNull(UserDataStore.STATE)) {
                            f2894c.a("get mid respone:" + str);
                            if (jSONObject.getInt("et") == com.tencent.stat.a.f.SESSION_ENV.a()) {
                                int i2 = jSONObject.getInt(UserDataStore.STATE);
                                if (i2 != -1 && i2 != 0) {
                                    f2894c.c("error type for st:" + i2);
                                } else if (!jSONObject.isNull("mid")) {
                                    d.a(e, jSONObject.getString("mid"));
                                }
                            }
                        }
                    } catch (Throwable th) {
                        f2894c.e(th.toString());
                    }
                    if (hVar != null) {
                        hVar.a();
                    }
                } else {
                    f2894c.d("Server response error code:" + statusCode + ", error:" + new String(bArr, "UTF-8"));
                }
                content.close();
            } else {
                EntityUtils.toString(entity);
            }
            byteArrayOutputStream.close();
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(List<String> list, h hVar) {
        Handler handler;
        if (list.isEmpty() || (handler = this.f2897b) == null) {
            return;
        }
        handler.post(new l(this, list, hVar));
    }
}
