package com.video.androidsdk.common.http;

/* loaded from: classes.dex */
public class HttpAttr {
    String charset;
    int connectTimeout;
    String encoding;
    boolean mbCanceled = false;
    String reqHeader;
    int socketTimeout;

    public void cancel() {
        this.mbCanceled = true;
    }

    public String getCharset() {
        return this.charset;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public String getReqHeader() {
        return this.reqHeader;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public boolean isCanceled() {
        return this.mbCanceled;
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setReqHeader(String str) {
        this.reqHeader = str;
    }

    public void setSocketTimeout(int i) {
        this.socketTimeout = i;
    }
}
