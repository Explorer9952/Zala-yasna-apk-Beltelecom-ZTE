package com.unity3d.player;

import com.video.androidsdk.common.util.IoUtils;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class WWW extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private int f2985a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f2986b;

    /* renamed from: c, reason: collision with root package name */
    private String f2987c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f2988d;
    private Map e;

    WWW(int i, String str, byte[] bArr, Map map) {
        this.f2986b = i;
        this.f2987c = str;
        this.f2988d = bArr;
        this.e = map;
    }

    private static native void doneCallback(int i);

    private static native void errorCallback(int i, String str);

    private static native boolean headerCallback(int i, String str);

    private static native void progressCallback(int i, float f, float f2, double d2, int i2);

    private static native boolean readCallback(int i, byte[] bArr, int i2);

    protected boolean headerCallback(String str, String str2) {
        return headerCallback(this.f2986b, str + ": " + str2 + "\n\r");
    }

    protected boolean headerCallback(Map map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            for (String str : (List) entry.getValue()) {
                sb.append((String) entry.getKey());
                sb.append(": ");
                sb.append(str);
                sb.append("\r\n");
            }
            if (entry.getKey() == null) {
                for (String str2 : (List) entry.getValue()) {
                    sb.append("Status: ");
                    sb.append(str2);
                    sb.append("\r\n");
                }
            }
        }
        return headerCallback(this.f2986b, sb.toString());
    }

    protected void progressCallback(int i, int i2, int i3, int i4, long j, long j2) {
        WWW www;
        double d2;
        float f;
        float f2;
        double d3 = 0.0d;
        if (i4 > 0) {
            float f3 = i3 / i4;
            int max = Math.max(i4 - i3, 0);
            double d4 = i3;
            Double.isNaN(d4);
            double max2 = (d4 * 1000.0d) / Math.max(j - j2, 0.1d);
            double d5 = max;
            Double.isNaN(d5);
            double d6 = d5 / max2;
            if (!Double.isInfinite(d6) && !Double.isNaN(d6)) {
                d3 = d6;
            }
            www = this;
            d2 = d3;
            f2 = 1.0f;
            f = f3;
        } else {
            if (i2 <= 0) {
                return;
            }
            www = this;
            d2 = 0.0d;
            f = 0.0f;
            f2 = i / i2;
        }
        progressCallback(www.f2986b, f2, f, d2, i4);
    }

    protected boolean readCallback(byte[] bArr, int i) {
        return readCallback(this.f2986b, bArr, i);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            runSafe();
        } catch (Throwable th) {
            errorCallback(this.f2986b, "Error: " + th.toString());
        }
    }

    public void runSafe() {
        String str;
        InputStream inputStream;
        boolean z;
        int i;
        String str2;
        List<String> list;
        SSLSocketFactory a2;
        int i2 = this.f2985a + 1;
        this.f2985a = i2;
        if (i2 > 5) {
            errorCallback(this.f2986b, "Too many redirects");
            return;
        }
        try {
            URL url = new URL(this.f2987c);
            URLConnection openConnection = url.openConnection();
            if ((openConnection instanceof HttpsURLConnection) && (a2 = a.a()) != null) {
                ((HttpsURLConnection) openConnection).setSSLSocketFactory(a2);
            }
            if (url.getProtocol().equalsIgnoreCase(ParamConst.CHANNEL_PREVUE_INFO_RSP_FILENAME) && url.getHost() != null && url.getHost().length() != 0) {
                errorCallback(this.f2986b, url.getHost() + url.getFile() + " is not an absolute path!");
                return;
            }
            Map map = this.e;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (this.f2988d != null) {
                openConnection.setDoOutput(true);
                try {
                    OutputStream outputStream = openConnection.getOutputStream();
                    int i3 = 0;
                    while (i3 < this.f2988d.length) {
                        int min = Math.min(1428, this.f2988d.length - i3);
                        outputStream.write(this.f2988d, i3, min);
                        int i4 = i3 + min;
                        OutputStream outputStream2 = outputStream;
                        progressCallback(i4, this.f2988d.length, 0, 0, 0L, 0L);
                        i3 = i4;
                        outputStream = outputStream2;
                    }
                } catch (Exception e) {
                    errorCallback(this.f2986b, e.toString());
                    return;
                }
            }
            if (openConnection instanceof HttpURLConnection) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    if (headerFields != null && ((responseCode == 301 || responseCode == 302) && (list = headerFields.get("Location")) != null && !list.isEmpty())) {
                        httpURLConnection.disconnect();
                        this.f2987c = list.get(0);
                        run();
                        return;
                    }
                } catch (IOException e2) {
                    errorCallback(this.f2986b, e2.toString());
                    return;
                }
            }
            Map<String, List<String>> headerFields2 = openConnection.getHeaderFields();
            boolean headerCallback = headerCallback(headerFields2);
            int i5 = -1;
            if ((headerFields2 == null || !headerFields2.containsKey("content-length")) && openConnection.getContentLength() != -1) {
                headerCallback = headerCallback || headerCallback("content-length", String.valueOf(openConnection.getContentLength()));
            }
            if ((headerFields2 == null || !headerFields2.containsKey("content-type")) && openConnection.getContentType() != null) {
                headerCallback = headerCallback || headerCallback("content-type", openConnection.getContentType());
            }
            String str3 = " aborted";
            if (headerCallback) {
                errorCallback(this.f2986b, this.f2987c + " aborted");
                return;
            }
            int contentLength = openConnection.getContentLength() > 0 ? openConnection.getContentLength() : 0;
            int min2 = (url.getProtocol().equalsIgnoreCase(ParamConst.CHANNEL_PREVUE_INFO_RSP_FILENAME) || url.getProtocol().equalsIgnoreCase("jar")) ? contentLength == 0 ? IoUtils.DEFAULT_BUFFER_SIZE : Math.min(contentLength, IoUtils.DEFAULT_BUFFER_SIZE) : 1428;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = new byte[min2];
                InputStream inputStream2 = null;
                if (openConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
                    InputStream errorStream = httpURLConnection2.getErrorStream();
                    str = httpURLConnection2.getResponseCode() + ": " + httpURLConnection2.getResponseMessage();
                    inputStream2 = errorStream;
                } else {
                    str = "";
                }
                if (inputStream2 == null) {
                    inputStream = openConnection.getInputStream();
                    z = false;
                } else {
                    inputStream = inputStream2;
                    z = true;
                }
                int i6 = 0;
                for (int i7 = 0; i7 != i5; i7 = inputStream.read(bArr)) {
                    if (readCallback(bArr, i7)) {
                        errorCallback(this.f2986b, this.f2987c + str3);
                        return;
                    }
                    if (z) {
                        i = contentLength;
                        str2 = str3;
                    } else {
                        int i8 = i6 + i7;
                        i = contentLength;
                        str2 = str3;
                        progressCallback(0, 0, i8, contentLength, System.currentTimeMillis(), currentTimeMillis);
                        i6 = i8;
                    }
                    contentLength = i;
                    str3 = str2;
                    i5 = -1;
                }
                if (z) {
                    errorCallback(this.f2986b, str);
                }
                progressCallback(0, 0, i6, i6, 0L, 0L);
                doneCallback(this.f2986b);
            } catch (Exception e3) {
                errorCallback(this.f2986b, e3.toString());
            }
        } catch (MalformedURLException e4) {
            errorCallback(this.f2986b, e4.toString());
        } catch (IOException e5) {
            errorCallback(this.f2986b, e5.toString());
        }
    }
}
