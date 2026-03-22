package com.video.androidsdk.common.http;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.video.androidsdk.a.d;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.bean.HttpAttribute;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.http.bean.HttpRequestParams;
import com.video.androidsdk.common.http.bean.HttpResponse;
import com.video.androidsdk.common.http.download.IHttpDownloadListener;
import com.video.androidsdk.license.a;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.IIPTVLogin;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SDKNetHTTPRequest {
    private static final String LOG_TAG = "SDKNetHTTPRequest";
    private String mCachEvalidityPeriod;
    private Map<String, String> mRspHeaderMap;
    private HttpRequestParams mhttpRequestParams;
    private IHTTPRequestReturnListener mListener = null;
    private String mContent = "";
    private String mBody = "";
    private String mstrIsNeedCache = "0";
    private boolean mbHasCached = false;
    private Handler mhandlerInUIHandler = new Handler(Looper.getMainLooper()) { // from class: com.video.androidsdk.common.http.SDKNetHTTPRequest.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 0)) {
                if (SDKNetHTTPRequest.this.mListener != null) {
                    SDKNetHTTPRequest.this.mListener.onDataReturn(SDKNetHTTPRequest.this.mContent);
                }
            } else if (SDKNetHTTPRequest.this.mListener != null) {
                SDKNetHTTPRequest.this.mListener.onFailReturn(message.what, (String) message.obj);
                if (message.what == -1001) {
                    LogEx.i(SDKNetHTTPRequest.LOG_TAG, "return code is -1001,start relogin");
                    SDKLoginMgr.getInstance().reLogin();
                }
            }
        }
    };
    private Map<String, String> mReqHeaderMap = new HashMap();
    private HashMap<String, String> mParams = new HashMap<>();
    private HttpAttribute mHttpAttribute = new HttpAttribute();

    /* loaded from: classes.dex */
    public interface IHTTPRequestReturnListener {
        void onDataReturn(String str);

        void onFailReturn(int i, String str);
    }

    private String getRealMethod(String str) {
        if (TextUtils.isEmpty(str)) {
            return HttpRequest.METHOD_GET;
        }
        String lowerCase = str.toLowerCase();
        return -1 != lowerCase.indexOf("post") ? HttpRequest.METHOD_POST : -1 != lowerCase.indexOf("get") ? HttpRequest.METHOD_GET : lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedCache(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            LogEx.w(LOG_TAG, "url is null");
            return false;
        }
        LogEx.d(LOG_TAG, "request url  === " + str);
        if (str.contains("sdk_") && str.contains(".jsp")) {
            String substring = str.substring(str.indexOf("sdk_"), str.indexOf(".jsp") + 4);
            LogEx.d(LOG_TAG, "the interface is " + substring);
            if ((d.a(substring) || "1".equals(this.mstrIsNeedCache)) && (!str.contains("pageno=") || str.contains("pageno=1"))) {
                z = true;
            }
        }
        LogEx.d(LOG_TAG, "bIsNeedCache is === " + z);
        return z;
    }

    public void cancelRequest() {
        DataDownload.getInstance().cancelHttpRequest(this.mhttpRequestParams);
        if (this.mListener != null) {
            this.mListener = null;
        }
    }

    public String getResponseHeader(String str) {
        Map<String, String> map = this.mRspHeaderMap;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public String replaceFrame(String str) {
        if (TextUtils.isEmpty(SDKLoginMgr.getInstance().getPropertiesInfo("Frame_EPG")) || TextUtils.isEmpty(str) || !str.contains("frame")) {
            return str;
        }
        int indexOf = str.indexOf("frame");
        return str.substring(0, indexOf) + SDKLoginMgr.getInstance().getPropertiesInfo("Frame_EPG") + str.substring(str.indexOf("/", indexOf));
    }

    public void setBody(String str) {
        this.mBody = str;
    }

    public void setCacheParams(String str, String str2) {
        this.mstrIsNeedCache = str;
        this.mCachEvalidityPeriod = str2;
    }

    public void setCharset(String str) {
        this.mReqHeaderMap.put(IIPTVLogin.LOGIN_PARAM_CHARSET, str);
    }

    public void setHeader(String str, String str2) {
        if (str == null || str.trim().length() == 0 || str2 == null || str2.trim().length() == 0) {
            return;
        }
        this.mReqHeaderMap.put(str, str2);
        LogEx.d(LOG_TAG, "headerMap put : key = " + str + ",value=" + str2);
    }

    public void setParam(String str, String str2) {
        this.mParams.put(str, str2);
    }

    public void setTimeOut(int i, int i2) {
        this.mHttpAttribute.setConnectTimeout(i);
        this.mHttpAttribute.setSocketTimeout(i2);
    }

    public void startRequest(final String str, String str2, IHTTPRequestReturnListener iHTTPRequestReturnListener) {
        if (!a.f3129a) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d(LOG_TAG, "start request");
        if (!TextUtils.isEmpty(SDKLoginMgr.getInstance().getPropertiesInfo("Frame_EPG")) && str.contains(".jsp") && str.contains("frame")) {
            int indexOf = str.indexOf("frame");
            str = str.substring(0, indexOf) + SDKLoginMgr.getInstance().getPropertiesInfo("Frame_EPG") + str.substring(str.indexOf("/", indexOf));
        }
        this.mListener = iHTTPRequestReturnListener;
        if (isNeedCache(str)) {
            this.mContent = d.b(str);
            LogEx.d(LOG_TAG, "cache data :" + this.mContent);
            if (!TextUtils.isEmpty(this.mContent)) {
                LogEx.d(LOG_TAG, "bHasCached  ==  " + this.mbHasCached);
                this.mbHasCached = true;
                Message obtainMessage = this.mhandlerInUIHandler.obtainMessage();
                obtainMessage.obj = str;
                obtainMessage.what = ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 0);
                this.mhandlerInUIHandler.sendMessage(obtainMessage);
            }
        }
        String host = Uri.parse(str).getHost();
        LogEx.d(LOG_TAG, "url host is : " + host);
        if (!TextUtils.isEmpty(host) && !"null".equalsIgnoreCase(host)) {
            HttpRequest httpRequest = new HttpRequest(getRealMethod(str2), str, this.mBody);
            HashMap<String, String> hashMap = this.mParams;
            if (hashMap != null && hashMap.size() > 0) {
                httpRequest.setParams(this.mParams);
            }
            httpRequest.setHeaderMap(this.mReqHeaderMap);
            this.mhttpRequestParams = new HttpRequestParams(null, this.mHttpAttribute, httpRequest, new IHttpDownloadListener() { // from class: com.video.androidsdk.common.http.SDKNetHTTPRequest.2
                @Override // com.video.androidsdk.common.http.download.IHttpDownloadListener
                public void onCancel(HttpRequest httpRequest2, HttpResponse httpResponse) {
                }

                /* JADX WARN: Removed duplicated region for block: B:43:0x0185  */
                /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
                @Override // com.video.androidsdk.common.http.download.IHttpDownloadListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onData(com.video.androidsdk.common.http.bean.HttpRequest r6, com.video.androidsdk.common.http.bean.HttpResponse r7) {
                    /*
                        Method dump skipped, instructions count: 621
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.http.SDKNetHTTPRequest.AnonymousClass2.onData(com.video.androidsdk.common.http.bean.HttpRequest, com.video.androidsdk.common.http.bean.HttpResponse):void");
                }

                @Override // com.video.androidsdk.common.http.download.IHttpDownloadListener
                public void onError(HttpRequest httpRequest2, HttpResponse httpResponse) {
                    if (httpResponse == null || SDKNetHTTPRequest.this.mbHasCached) {
                        return;
                    }
                    if (httpResponse.getException() != null) {
                        httpResponse.getException().printStackTrace();
                    }
                    SDKNetHTTPRequest.this.mRspHeaderMap = httpResponse.getHeaderMap();
                    Message obtainMessage2 = SDKNetHTTPRequest.this.mhandlerInUIHandler.obtainMessage();
                    obtainMessage2.obj = str + " " + ErrMessage.ERRCODE_EXCEPTION;
                    obtainMessage2.what = httpResponse.getReturnCode();
                    SDKNetHTTPRequest.this.mhandlerInUIHandler.sendMessage(obtainMessage2);
                }
            });
            DataDownload.getInstance().sendHttpRequest(this.mhttpRequestParams);
            return;
        }
        if (this.mbHasCached) {
            return;
        }
        Message obtainMessage2 = this.mhandlerInUIHandler.obtainMessage();
        obtainMessage2.obj = str + " " + ErrMessage.PARAM_IS_NULL;
        obtainMessage2.what = ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 2);
        this.mhandlerInUIHandler.sendMessage(obtainMessage2);
    }
}
