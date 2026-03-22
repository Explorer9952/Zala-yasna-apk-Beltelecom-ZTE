package com.video.androidsdk.common.http.bean;

import com.video.androidsdk.common.http.DataAttribute;
import com.video.androidsdk.common.http.download.IHttpDownloadListener;

/* loaded from: classes.dex */
public class HttpRequestParams {
    DataAttribute attr;
    HttpAttribute httpAttr;
    IHttpDownloadListener listener;
    HttpRequest req;

    public HttpRequestParams(DataAttribute dataAttribute, HttpRequest httpRequest, IHttpDownloadListener iHttpDownloadListener) {
        this.attr = dataAttribute;
        this.req = httpRequest;
        this.listener = iHttpDownloadListener;
    }

    public DataAttribute getAttr() {
        return this.attr;
    }

    public HttpAttribute getHttpAttr() {
        return this.httpAttr;
    }

    public IHttpDownloadListener getListener() {
        return this.listener;
    }

    public HttpRequest getReq() {
        return this.req;
    }

    public void setHttpAttr(HttpAttribute httpAttribute) {
        this.httpAttr = httpAttribute;
    }

    public void setListener(IHttpDownloadListener iHttpDownloadListener) {
        this.listener = iHttpDownloadListener;
    }

    public HttpRequestParams(DataAttribute dataAttribute, HttpAttribute httpAttribute, HttpRequest httpRequest, IHttpDownloadListener iHttpDownloadListener) {
        this.attr = dataAttribute;
        this.httpAttr = httpAttribute;
        this.req = httpRequest;
        this.listener = iHttpDownloadListener;
    }
}
