package com.video.androidsdk.common.http;

import android.content.Context;
import com.video.androidsdk.b;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.http.bean.HttpRequestParams;
import com.video.androidsdk.common.http.bean.HttpResponse;
import com.video.androidsdk.common.http.bean.HttpsRequest;
import com.video.androidsdk.common.http.bean.HttpsRequestParams;
import com.video.androidsdk.common.http.download.HttpDownloadHelper;
import com.video.androidsdk.common.http.download.HttpsDownloadHelper;
import com.video.androidsdk.common.http.download.IHttpDownloadListener;
import com.video.androidsdk.log.LogEx;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class DataDownload {
    public static final int FLAG_MERGE_MODE_COMBINE = 3;
    public static final int FLAG_MERGE_MODE_DEFAULT = 0;
    public static final int FLAG_MERGE_MODE_LAST = 2;
    public static final int FLAG_MERGE_MODE_QUEUE = 5;
    public static final int FLAG_MERGE_MODE_REPLACE = 1;
    public static final int FLAG_MERGE_MODE_STACK = 4;
    private static final String LOG_TAG = "DataDownload";
    private static final String THREADPOOL_NAME = "DataDownload";
    private static final int THREAD_NUM_DEFAULT = 10;
    private static volatile DataDownload mInstance;
    private Vector<HttpRequestParams> mLoadingVc;
    private int mThreadNum = 10;
    private Map<HttpRequestParams, HttpRequest> mCacheMap = new HashMap();
    HashMap<HttpRequestParams, Future<?>> resultMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void addHttpTask(HttpRequestParams httpRequestParams) {
        HttpResponse httpResponse;
        HttpRequest req = httpRequestParams.getReq();
        IHttpDownloadListener listener = httpRequestParams.getListener();
        try {
            String protocol = new URL(req.getUrl()).getProtocol();
            LogEx.d("DataDownload", "sendHttpRequest end");
            if (HttpConstant.PROTOCOL_HTTPS.equalsIgnoreCase(protocol)) {
                HttpsDownloadHelper.trustAllHttpsCertificates();
                HttpsRequest httpsRequest = new HttpsRequest(req.getMethod(), req.getUrl(), req.getParams(), req.getBody());
                for (Map.Entry<String, String> entry : req.getHeaderMap().entrySet()) {
                    httpsRequest.addHeader(entry.getKey(), entry.getValue());
                }
                if (httpRequestParams instanceof HttpsRequestParams) {
                    httpsRequest.setHostnameVerifier(((HttpsRequestParams) httpRequestParams).getHostnameVerifier());
                    httpsRequest.setSSLContext(((HttpsRequestParams) httpRequestParams).getSSLContext());
                }
                httpResponse = HttpsDownloadHelper.send(httpsRequest, httpRequestParams.getHttpAttr());
            } else {
                httpResponse = HttpDownloadHelper.send(req, httpRequestParams.getHttpAttr());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            httpResponse = new HttpResponse(ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 203));
        }
        HttpRequest remove = this.mCacheMap.remove(httpRequestParams);
        if (listener != null) {
            if (remove == null) {
                listener.onCancel(req, httpResponse);
            } else if (httpResponse != null && httpResponse.getReturnCode() == ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 0)) {
                listener.onData(req, httpResponse);
            } else {
                listener.onError(req, httpResponse);
            }
        }
        this.resultMap.remove(httpRequestParams);
    }

    public static DataDownload getInstance() {
        if (mInstance == null) {
            mInstance = new DataDownload();
        }
        return mInstance;
    }

    public void cancelHttpRequest(HttpRequestParams httpRequestParams) {
        if (httpRequestParams == null) {
            return;
        }
        Future<?> future = this.resultMap.get(httpRequestParams);
        if (future != null && !future.isDone()) {
            future.cancel(true);
        }
        this.mCacheMap.remove(httpRequestParams);
        this.resultMap.remove(httpRequestParams);
    }

    public void cancelTask() {
        b.a().a("DataDownload");
    }

    public void init(Context context) {
        b.a().a("DataDownload");
        b.a().a("DataDownload", this.mThreadNum);
    }

    public void sendHttpRequest(final HttpRequestParams httpRequestParams) {
        LogEx.d("DataDownload", "sendHttpRequest start");
        if (httpRequestParams == null) {
            LogEx.w("DataDownload", "HttpRequestParams is null!");
            return;
        }
        HttpRequest req = httpRequestParams.getReq();
        if (req == null) {
            LogEx.w("DataDownload", "HttpRequest is null!");
            if (httpRequestParams.getListener() != null) {
                HttpResponse httpResponse = new HttpResponse(ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 2));
                httpResponse.setException(new NullPointerException());
                httpRequestParams.getListener().onError(req, httpResponse);
                return;
            }
            return;
        }
        ExecutorService a2 = b.a().a("DataDownload", this.mThreadNum);
        if (a2 == null) {
            LogEx.w("DataDownload", "DownLoad Pool is null!");
            if (httpRequestParams.getListener() != null) {
                httpRequestParams.getListener().onError(req, new HttpResponse(ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, ErrCode.ERRCODE_THREADPOOL_NULL)));
                return;
            }
            return;
        }
        this.mCacheMap.put(httpRequestParams, req);
        this.resultMap.put(httpRequestParams, a2.submit(new Runnable() { // from class: com.video.androidsdk.common.http.DataDownload.1
            @Override // java.lang.Runnable
            public void run() {
                LogEx.d("DataDownload", "addHttpTask start");
                DataDownload.this.addHttpTask(httpRequestParams);
            }
        }));
    }
}
