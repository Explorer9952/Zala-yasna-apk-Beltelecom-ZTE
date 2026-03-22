package com.video.androidsdk.common.http.download;

import android.text.TextUtils;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.NoCheckX509TrustManager;
import com.video.androidsdk.common.PortalConst;
import com.video.androidsdk.common.http.SessionMgr;
import com.video.androidsdk.common.http.bean.HttpAttribute;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.http.bean.HttpResponse;
import com.video.androidsdk.common.http.bean.HttpsRequest;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* loaded from: classes.dex */
public class HttpsDownloadHelper {
    public static final String CHARSET_PARAM = "; charset=";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_CHARSET = "UTF-8";
    private static final int Default_Timeout_Connection = 10000;
    private static final int Default_Timeout_Socket = 10000;
    public static final String ISO_8859_1 = "ISO-8859-1";
    private static final String LOG_TAG = "HttpsDownloadHelper";
    public static final String UTF_8 = "UTF-8";
    private static String[] VERIFY_HOST_NAME_ARRAY;
    private static Logger mLogger;

    /* loaded from: classes.dex */
    public static class MySSLSocketFactory extends SSLSocketFactory {
        private SSLSocketFactory mSSLSocketFactory;
        private SSLContext sc;

        public MySSLSocketFactory() {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                this.sc = sSLContext;
                sSLContext.init(null, null, null);
                this.mSSLSocketFactory = this.sc.getSocketFactory();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
        }

        private Socket enableTLS(Socket socket) {
            if (socket != null && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2", "TLSv1.3"});
            }
            return socket;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
            return enableTLS(this.mSSLSocketFactory.createSocket(socket, str, i, z));
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getDefaultCipherSuites() {
            return this.mSSLSocketFactory.getDefaultCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getSupportedCipherSuites() {
            return this.mSSLSocketFactory.getSupportedCipherSuites();
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
            return enableTLS(this.mSSLSocketFactory.createSocket(str, i));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
            return enableTLS(this.mSSLSocketFactory.createSocket(str, i, inetAddress, i2));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
            return enableTLS(this.mSSLSocketFactory.createSocket(inetAddress, i));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
            return enableTLS(this.mSSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
        }
    }

    static {
        String simpleName = HttpsDownloadHelper.class.getSimpleName();
        VERIFY_HOST_NAME_ARRAY = new String[0];
        mLogger = Logger.getLogger(simpleName);
    }

    public static String encodeURL(String str, String str2) {
        LogEx.d(LOG_TAG, "encoding start = " + str2);
        if (TextUtils.isEmpty(str)) {
            LogEx.w(LOG_TAG, "URL is empty!");
            return null;
        }
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_EPG_SERVER_ENCODER_MODE);
        if (!TextUtils.isEmpty(SDKLoginMgr.getInstance().getEPGHome()) && str.contains(SDKLoginMgr.getInstance().getEPGHome())) {
            if (!TextUtils.isEmpty(SDKMgr.getEPGCharset())) {
                str2 = SDKMgr.getEPGCharset();
                LogEx.d(LOG_TAG, "set encoding by sdkmgr getepgcharset:" + str2);
            } else if (!TextUtils.isEmpty(propertiesInfo)) {
                LogEx.d(LOG_TAG, "set encoding by PropertiesInfo:" + propertiesInfo);
                str2 = propertiesInfo;
            }
        }
        LogEx.d(LOG_TAG, "encoding finally = " + str2);
        LogEx.d(LOG_TAG, "URL=" + str);
        try {
            URL url = new URL(str);
            StringBuilder sb = new StringBuilder();
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            String path = url.getPath();
            String query = url.getQuery();
            if (-1 == port) {
                port = url.getDefaultPort();
            }
            sb.append(protocol);
            sb.append("://");
            sb.append(tryEncode(host, str2));
            sb.append(":");
            sb.append(port);
            if (!TextUtils.isEmpty(path)) {
                int indexOf = path.indexOf(";jsessionid=");
                if (-1 != indexOf) {
                    String substring = path.substring(indexOf + 12);
                    for (String str3 : path.substring(1, indexOf).split("/")) {
                        sb.append("/");
                        sb.append(tryEncode(str3, str2));
                    }
                    sb.append(";jsessionid=");
                    sb.append(tryEncode(substring, str2));
                    if (TextUtils.equals(path.substring(indexOf - 1), "/")) {
                        sb.append("/");
                    }
                } else {
                    for (String str4 : path.substring(1).split("/")) {
                        sb.append("/");
                        sb.append(tryEncode(str4, str2));
                    }
                    if (path.endsWith("/")) {
                        sb.append("/");
                    }
                }
            }
            if (!TextUtils.isEmpty(query)) {
                sb.append("?");
                String[] split = query.split("&");
                for (String str5 : split) {
                    int indexOf2 = str5.indexOf("=");
                    if (-1 != indexOf2) {
                        String substring2 = str5.substring(0, indexOf2);
                        String substring3 = str5.substring(indexOf2 + 1);
                        sb.append(tryEncode(substring2, str2));
                        sb.append("=");
                        sb.append(tryEncode(substring3, str2));
                        sb.append("&");
                    }
                }
                sb.replace(sb.length() - 1, sb.length(), "");
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            LogEx.e(LOG_TAG, "URI is error:" + str + " : " + e.getMessage());
            return null;
        }
    }

    public static HttpResponse get(HttpsRequest httpsRequest) {
        return get(httpsRequest, null);
    }

    private static String getCharset(Map<String, String> map, Map<String, String> map2) {
        if (map == null && map2 == null) {
            LogEx.d(LOG_TAG, "response data charset is : ISO-8859-1");
            return "ISO-8859-1";
        }
        String str = null;
        if (map != null && map.containsKey("Content-Type")) {
            str = map.get("Content-Type");
        }
        if (!StringUtil.isEmptyString(str)) {
            String charsetFromContentType = getCharsetFromContentType(str);
            LogEx.d(LOG_TAG, "getCharset() response data charset is : " + charsetFromContentType);
            if (!StringUtil.isEmptyString(charsetFromContentType)) {
                return charsetFromContentType;
            }
        }
        if (map2 != null && map2.containsKey("Content-Type")) {
            str = map2.get("Content-Type");
        }
        if (!StringUtil.isEmptyString(str)) {
            String charsetFromContentType2 = getCharsetFromContentType(str);
            LogEx.d(LOG_TAG, "getCharset() request data charset is : " + charsetFromContentType2);
            if (!StringUtil.isEmptyString(charsetFromContentType2)) {
                return charsetFromContentType2;
            }
        }
        return "ISO-8859-1";
    }

    private static String getCharsetFromContentType(String str) {
        String str2 = null;
        for (String str3 : str.split(";")) {
            String str4 = "; " + str3.trim();
            if (str4.startsWith("; charset=") && str4.length() > 10) {
                str2 = str4.substring(10);
            }
        }
        return str2;
    }

    private static HashMap<String, String> getRspHeaderMap(HttpsURLConnection httpsURLConnection) {
        List list;
        if (httpsURLConnection == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        Map headerFields = httpsURLConnection.getHeaderFields();
        if (headerFields == null) {
            return null;
        }
        for (Map.Entry entry : headerFields.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null && (list = (List) entry.getValue()) != null) {
                StringBuilder sb = new StringBuilder();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    sb.append((String) it2.next());
                    sb.append(";");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                hashMap.put(str, sb.toString());
            }
        }
        return hashMap;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private static com.video.androidsdk.common.http.bean.HttpResponse httpsGet(java.lang.String r19, java.lang.String r20, int r21, int r22, java.util.Map<java.lang.String, java.lang.String> r23, javax.net.ssl.SSLContext r24, javax.net.ssl.HostnameVerifier r25) {
        /*
            Method dump skipped, instructions count: 1329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.http.download.HttpsDownloadHelper.httpsGet(java.lang.String, java.lang.String, int, int, java.util.Map, javax.net.ssl.SSLContext, javax.net.ssl.HostnameVerifier):com.video.androidsdk.common.http.bean.HttpResponse");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private static com.video.androidsdk.common.http.bean.HttpResponse httpsPost(java.lang.String r20, java.lang.String r21, int r22, int r23, java.util.Map<java.lang.String, java.lang.String> r24, java.lang.String r25, javax.net.ssl.SSLContext r26, javax.net.ssl.HostnameVerifier r27, java.util.HashMap<java.lang.String, java.lang.String> r28, java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 1712
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.http.download.HttpsDownloadHelper.httpsPost(java.lang.String, java.lang.String, int, int, java.util.Map, java.lang.String, javax.net.ssl.SSLContext, javax.net.ssl.HostnameVerifier, java.util.HashMap, java.lang.String):com.video.androidsdk.common.http.bean.HttpResponse");
    }

    public static HttpResponse post(HttpsRequest httpsRequest) {
        return post(httpsRequest, null);
    }

    private static void refreshSession(HttpResponse httpResponse, String str) {
        int i = 0;
        if (ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 0) != httpResponse.getReturnCode()) {
            return;
        }
        Map<String, String> headerMap = httpResponse.getHeaderMap();
        String str2 = null;
        String str3 = headerMap != null ? headerMap.get("Set-Cookie") : null;
        if (str3 != null) {
            String[] split = str3.split(";");
            int length = split.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str4 = split[i];
                if (str4.startsWith("JSESSIONID=")) {
                    str2 = str4.replaceFirst("JSESSIONID=", "");
                    break;
                }
                i++;
            }
        }
        if (str2 != null) {
            SessionMgr.getInstance().putSessionID(str, str2);
        }
    }

    public static HttpResponse send(HttpsRequest httpsRequest) {
        return send(httpsRequest, null);
    }

    public static boolean setDefaultTrustManagerFactory(TrustManager[] trustManagerArr) {
        if (trustManagerArr == null) {
            LogEx.e(LOG_TAG, "TrustManager is null.");
            return false;
        }
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            return true;
        } catch (KeyManagementException e) {
            mLogger.log(Level.SEVERE, e.toString());
            return false;
        } catch (NoSuchAlgorithmException e2) {
            mLogger.log(Level.SEVERE, e2.toString());
            return false;
        } catch (Exception e3) {
            mLogger.log(Level.SEVERE, e3.toString());
            return false;
        }
    }

    public static void trustAllHttpsCertificates() {
        setDefaultTrustManagerFactory(new TrustManager[]{new NoCheckX509TrustManager()});
    }

    private static String tryEncode(String str, String str2) {
        if (str == null) {
            return str;
        }
        if (str2 == null) {
            return URLEncoder.encode(str);
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            LogEx.w(LOG_TAG, str2 + " not support." + e.getMessage());
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0279 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x026f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.video.androidsdk.common.http.bean.HttpResponse get(com.video.androidsdk.common.http.bean.HttpsRequest r16, com.video.androidsdk.common.http.bean.HttpAttribute r17) {
        /*
            Method dump skipped, instructions count: 695
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.http.download.HttpsDownloadHelper.get(com.video.androidsdk.common.http.bean.HttpsRequest, com.video.androidsdk.common.http.bean.HttpAttribute):com.video.androidsdk.common.http.bean.HttpResponse");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.video.androidsdk.common.http.bean.HttpResponse post(com.video.androidsdk.common.http.bean.HttpsRequest r14, com.video.androidsdk.common.http.bean.HttpAttribute r15) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.http.download.HttpsDownloadHelper.post(com.video.androidsdk.common.http.bean.HttpsRequest, com.video.androidsdk.common.http.bean.HttpAttribute):com.video.androidsdk.common.http.bean.HttpResponse");
    }

    public static HttpResponse send(HttpsRequest httpsRequest, HttpAttribute httpAttribute) {
        if (httpsRequest == null) {
            LogEx.w(LOG_TAG, "HttpsRequest is null!");
            return new HttpResponse(ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 2));
        }
        String method = httpsRequest.getMethod();
        if (TextUtils.isEmpty(method)) {
            LogEx.w(LOG_TAG, "HttpsRequest method is null!");
            return new HttpResponse(ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 2));
        }
        LogEx.d(LOG_TAG, "Request method: " + method);
        if (HttpRequest.METHOD_GET.equals(method)) {
            return get(httpsRequest, httpAttribute);
        }
        if (HttpRequest.METHOD_POST.equals(method)) {
            return post(httpsRequest, httpAttribute);
        }
        LogEx.w(LOG_TAG, "HttpsRequest method unknow:" + method);
        return new HttpResponse(ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 3));
    }
}
