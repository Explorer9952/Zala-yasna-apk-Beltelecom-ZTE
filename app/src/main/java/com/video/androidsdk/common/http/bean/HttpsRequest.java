package com.video.androidsdk.common.http.bean;

import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

/* loaded from: classes.dex */
public class HttpsRequest extends HttpRequest {
    HostnameVerifier hostVerifier;
    SSLContext sslContext;

    public HttpsRequest(String str) {
        super(str);
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostVerifier;
    }

    public SSLContext getSSLContext() {
        return this.sslContext;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostVerifier = hostnameVerifier;
    }

    public void setSSLContext(SSLContext sSLContext) {
        this.sslContext = sSLContext;
    }

    public HttpsRequest(String str, String str2) {
        super(str, str2);
    }

    public HttpsRequest(String str, String str2, HashMap<String, String> hashMap) {
        super(str, str2, hashMap);
    }

    public HttpsRequest(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public HttpsRequest(String str, String str2, HashMap<String, String> hashMap, String str3) {
        super(str, str2, hashMap, str3);
    }
}
