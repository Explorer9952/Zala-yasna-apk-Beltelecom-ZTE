package com.unity3d.player;

import com.video.androidsdk.common.util.IoUtils;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class UnityWebRequest implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private long f2981a;

    /* renamed from: b, reason: collision with root package name */
    private String f2982b;

    /* renamed from: c, reason: collision with root package name */
    private String f2983c;

    /* renamed from: d, reason: collision with root package name */
    private Map f2984d;

    UnityWebRequest(long j, String str, Map map, String str2) {
        this.f2981a = j;
        this.f2982b = str2;
        this.f2983c = str;
        this.f2984d = map;
    }

    private static native void contentLengthCallback(long j, int i);

    private static native boolean downloadCallback(long j, ByteBuffer byteBuffer, int i);

    private static native void errorCallback(long j, int i, String str);

    private static native void headerCallback(long j, String str, String str2);

    private static native void responseCodeCallback(long j, int i);

    private static native int uploadCallback(long j, ByteBuffer byteBuffer);

    protected void badProtocolCallback(String str) {
        errorCallback(this.f2981a, 4, str);
    }

    protected void contentLengthCallback(int i) {
        contentLengthCallback(this.f2981a, i);
    }

    protected boolean downloadCallback(ByteBuffer byteBuffer, int i) {
        return downloadCallback(this.f2981a, byteBuffer, i);
    }

    protected void errorCallback(String str) {
        errorCallback(this.f2981a, 2, str);
    }

    protected void headerCallback(String str, String str2) {
        headerCallback(this.f2981a, str, str2);
    }

    protected void headerCallback(Map map) {
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                str = "Status";
            }
            Iterator it2 = ((List) entry.getValue()).iterator();
            while (it2.hasNext()) {
                headerCallback(str, (String) it2.next());
            }
        }
    }

    protected void malformattedUrlCallback(String str) {
        errorCallback(this.f2981a, 5, str);
    }

    protected void responseCodeCallback(int i) {
        responseCodeCallback(this.f2981a, i);
    }

    @Override // java.lang.Runnable
    public void run() {
        SSLSocketFactory a2;
        try {
            URL url = new URL(this.f2982b);
            URLConnection openConnection = url.openConnection();
            if ((openConnection instanceof HttpsURLConnection) && (a2 = a.a()) != null) {
                ((HttpsURLConnection) openConnection).setSSLSocketFactory(a2);
            }
            if (url.getProtocol().equalsIgnoreCase(ParamConst.CHANNEL_PREVUE_INFO_RSP_FILENAME) && !url.getHost().isEmpty()) {
                malformattedUrlCallback("file:// must use an absolute path");
                return;
            }
            if (openConnection instanceof JarURLConnection) {
                badProtocolCallback("A URL Connection to a Java ARchive (JAR) file or an entry in a JAR file is not supported");
                return;
            }
            boolean z = openConnection instanceof HttpURLConnection;
            if (z) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    httpURLConnection.setRequestMethod(this.f2983c);
                    httpURLConnection.setInstanceFollowRedirects(false);
                } catch (ProtocolException e) {
                    badProtocolCallback(e.toString());
                    return;
                }
            }
            Map map = this.f2984d;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            InputStream inputStream = null;
            int uploadCallback = uploadCallback(null);
            if (uploadCallback > 0) {
                openConnection.setDoOutput(true);
                try {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(Math.min(uploadCallback, 1428));
                    OutputStream outputStream = openConnection.getOutputStream();
                    while (true) {
                        int uploadCallback2 = uploadCallback(allocateDirect);
                        if (uploadCallback2 <= 0) {
                            break;
                        } else {
                            outputStream.write(allocateDirect.array(), allocateDirect.arrayOffset(), uploadCallback2);
                        }
                    }
                } catch (Exception e2) {
                    errorCallback(e2.toString());
                    return;
                }
            }
            if (z) {
                try {
                    responseCodeCallback(((HttpURLConnection) openConnection).getResponseCode());
                } catch (UnknownHostException e3) {
                    unknownHostCallback(e3.toString());
                } catch (IOException e4) {
                    errorCallback(e4.toString());
                    return;
                }
            }
            Map<String, List<String>> headerFields = openConnection.getHeaderFields();
            headerCallback(headerFields);
            if ((headerFields == null || !headerFields.containsKey("content-length")) && openConnection.getContentLength() != -1) {
                headerCallback("content-length", String.valueOf(openConnection.getContentLength()));
            }
            if ((headerFields == null || !headerFields.containsKey("content-type")) && openConnection.getContentType() != null) {
                headerCallback("content-type", openConnection.getContentType());
            }
            int contentLength = openConnection.getContentLength();
            if (contentLength > 0) {
                contentLengthCallback(contentLength);
            }
            int min = url.getProtocol().equalsIgnoreCase(ParamConst.CHANNEL_PREVUE_INFO_RSP_FILENAME) ? contentLength == 0 ? IoUtils.DEFAULT_BUFFER_SIZE : Math.min(contentLength, IoUtils.DEFAULT_BUFFER_SIZE) : 1428;
            try {
                if (openConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
                    responseCodeCallback(httpURLConnection2.getResponseCode());
                    inputStream = httpURLConnection2.getErrorStream();
                }
                if (inputStream == null) {
                    inputStream = openConnection.getInputStream();
                }
                ReadableByteChannel newChannel = Channels.newChannel(inputStream);
                ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(min);
                while (true) {
                    int read = newChannel.read(allocateDirect2);
                    if (read == -1 || !downloadCallback(allocateDirect2, read)) {
                        break;
                    } else {
                        allocateDirect2.clear();
                    }
                }
                newChannel.close();
            } catch (UnknownHostException e5) {
                unknownHostCallback(e5.toString());
            } catch (SSLHandshakeException e6) {
                sslCannotConnectCallback(e6.toString());
            } catch (Exception e7) {
                errorCallback(e7.toString());
            }
        } catch (MalformedURLException e8) {
            malformattedUrlCallback(e8.toString());
        } catch (IOException e9) {
            errorCallback(e9.toString());
        }
    }

    protected void sslCannotConnectCallback(String str) {
        errorCallback(this.f2981a, 16, str);
    }

    protected void unknownHostCallback(String str) {
        errorCallback(this.f2981a, 7, str);
    }

    protected int uploadCallback(ByteBuffer byteBuffer) {
        return uploadCallback(this.f2981a, byteBuffer);
    }
}
