package com.video.androidsdk.common.http.download;

import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.http.bean.HttpResponse;

/* loaded from: classes.dex */
public interface IHttpDownloadListener {
    void onCancel(HttpRequest httpRequest, HttpResponse httpResponse);

    void onData(HttpRequest httpRequest, HttpResponse httpResponse);

    void onError(HttpRequest httpRequest, HttpResponse httpResponse);
}
