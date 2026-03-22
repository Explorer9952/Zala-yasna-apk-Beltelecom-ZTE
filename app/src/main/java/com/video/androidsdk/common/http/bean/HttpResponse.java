package com.video.androidsdk.common.http.bean;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpResponse {
    String body;
    String charset;
    Exception exception;
    HashMap<String, String> headerMap;
    int returnCode;

    public HttpResponse(int i) {
        this.returnCode = i;
    }

    public String getBody() {
        return this.body;
    }

    public long getContentLength() {
        if (this.body == null) {
            return 0L;
        }
        return r0.length();
    }

    public Exception getException() {
        return this.exception;
    }

    public Map<String, String> getHeaderMap() {
        return this.headerMap;
    }

    public InputStream getInputStream() {
        if (this.body == null) {
            return null;
        }
        try {
            return new ByteArrayInputStream(this.body.getBytes(this.charset));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ByteArrayInputStream(this.body.getBytes());
        }
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public void setException(Exception exc) {
        this.exception = exc;
    }

    public void setHeaderMap(HashMap<String, String> hashMap) {
        this.headerMap = hashMap;
    }

    public void setReturnCode(int i) {
        this.returnCode = i;
    }

    public HttpResponse(int i, String str) {
        this.returnCode = i;
        this.body = str;
    }

    public HttpResponse(int i, String str, String str2) {
        this.returnCode = i;
        this.body = str;
        this.charset = str2;
    }
}
