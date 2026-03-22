package com.video.androidsdk.ad;

import android.net.Uri;
import android.text.TextUtils;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.license.a;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import java.util.Map;

/* loaded from: classes.dex */
public class SDKAdAPI {
    private static final String TAG = "SDKAdAPI";
    private static SDKAdAPI mSDKAdAPI = new SDKAdAPI();
    private String mAdServerDomian;

    /* loaded from: classes.dex */
    public interface OnBannerAdsReturnListener {
        void onBannerAdsReturn(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnChannelAdsReturnListener {
        void onChannelAdsReturn(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnPlayNotifyReturnListener {
        void OnPlayNotifyReturn(int i, String str);
    }

    /* loaded from: classes.dex */
    public interface OnRChannelAdsReturnListener {
        void onRChannelAdsReturn(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnVoDAdsReturnListener {
        void onVoDAdsReturn(int i, String str, String str2);
    }

    private SDKAdAPI() {
    }

    public static SDKAdAPI createInstance() {
        return mSDKAdAPI;
    }

    private SDKNetHTTPRequest getHttpRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        return sDKNetHTTPRequest;
    }

    private String getxmlString(Map<String, String> map, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        stringBuffer.append("<");
        stringBuffer.append(str);
        stringBuffer.append(">");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            LogEx.d(TAG, "key === " + key);
            LogEx.d(TAG, "value === " + value);
            stringBuffer.append("<");
            stringBuffer.append(key);
            stringBuffer.append(">");
            stringBuffer.append(value);
            stringBuffer.append("</");
            stringBuffer.append(key);
            stringBuffer.append(">");
        }
        stringBuffer.append("</");
        stringBuffer.append(str);
        stringBuffer.append(">");
        LogEx.d(TAG, "xml === " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    public void doPlayNotify(Map<String, String> map, final OnPlayNotifyReturnListener onPlayNotifyReturnListener) {
        if (!a.f3131c) {
            LogEx.e(TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (onPlayNotifyReturnListener == null) {
            LogEx.w(TAG, "OnPlayNotifyReturnListener is null.");
            return;
        }
        if (map == null) {
            LogEx.w(TAG, "play notify req is null");
            return;
        }
        if (TextUtils.isEmpty(this.mAdServerDomian)) {
            LogEx.w(TAG, "mAdServerDomian is null.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.mAdServerDomian);
        sb.append(HttpUrlConstants.REQUEST_PLAY_NOTIFY);
        LogEx.d(TAG, "doPlayNotify url is " + sb.toString());
        String str = getxmlString(map, "AdVodPlayReq");
        LogEx.d(TAG, "doPlayNotify xmlReq is " + str);
        SDKNetHTTPRequest httpRequest = getHttpRequest();
        httpRequest.setBody(str);
        httpRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.ad.SDKAdAPI.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                onPlayNotifyReturnListener.OnPlayNotifyReturn(0, "do play notify success!");
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onPlayNotifyReturnListener.OnPlayNotifyReturn(i, str2);
            }
        });
    }

    public void queryBannerAds(Map<String, String> map, final OnBannerAdsReturnListener onBannerAdsReturnListener) {
        if (!a.f3131c) {
            LogEx.e(TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (onBannerAdsReturnListener == null) {
            LogEx.w(TAG, "OnBannerAdsReturnListener is null.");
            return;
        }
        if (map == null) {
            LogEx.w(TAG, "banner ads req is null");
            return;
        }
        if (TextUtils.isEmpty(this.mAdServerDomian)) {
            LogEx.w(TAG, "mAdServerDomian is null.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.mAdServerDomian);
        sb.append(HttpUrlConstants.REQUEST_GET_EPG_BANNER);
        LogEx.d(TAG, "queryBannerAds url is " + sb.toString());
        String str = getxmlString(map, "AdEPGPageReq");
        LogEx.d(TAG, "queryBannerAds xml req is " + str);
        SDKNetHTTPRequest httpRequest = getHttpRequest();
        httpRequest.setBody(str);
        httpRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.ad.SDKAdAPI.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LogEx.w(SDKAdAPI.TAG, "queryBannerAds return data is empty.");
                }
                onBannerAdsReturnListener.onBannerAdsReturn(0, "Get EPGbanner ad success!", str2);
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onBannerAdsReturnListener.onBannerAdsReturn(i, str2, null);
            }
        });
    }

    public void queryChannelAds(Map<String, String> map, final OnChannelAdsReturnListener onChannelAdsReturnListener) {
        if (!a.f3131c) {
            LogEx.e(TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (map == null) {
            LogEx.w(TAG, "channeladsreq is null");
            return;
        }
        if (onChannelAdsReturnListener == null) {
            LogEx.w(TAG, "OnChannelAdsReturnListener is null");
            return;
        }
        if (TextUtils.isEmpty(this.mAdServerDomian)) {
            LogEx.w(TAG, "mAdServerDomian is null.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.mAdServerDomian);
        sb.append(HttpUrlConstants.REQUEST_GET_CHANNEL_AD);
        LogEx.d(TAG, "queryChannelAds url is " + sb.toString());
        SDKNetHTTPRequest httpRequest = getHttpRequest();
        httpRequest.setBody(getxmlString(map, "AdVodPlayReq"));
        httpRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.ad.SDKAdAPI.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                if (TextUtils.isEmpty(str)) {
                    LogEx.w(SDKAdAPI.TAG, "queryChannelAds return data is empty.");
                }
                onChannelAdsReturnListener.onChannelAdsReturn(0, "queryChannelAds success!", str);
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onChannelAdsReturnListener.onChannelAdsReturn(i, str, null);
            }
        });
    }

    public void queryRChannelAds(Map<String, String> map, final OnRChannelAdsReturnListener onRChannelAdsReturnListener) {
        if (!a.f3131c) {
            LogEx.e(TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (map == null || map.size() == 0) {
            LogEx.w(TAG, "queryRChannelAds req is empty.");
            return;
        }
        if (onRChannelAdsReturnListener == null) {
            LogEx.w(TAG, "OnRChannelAdsReturnListener  is null.");
            return;
        }
        if (TextUtils.isEmpty(this.mAdServerDomian)) {
            LogEx.w(TAG, "mAdServerDomian is null.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.mAdServerDomian);
        sb.append(HttpUrlConstants.REQUEST_GET_RCHANNEL_AD);
        LogEx.d(TAG, "queryRChannelAds url is " + sb.toString());
        SDKNetHTTPRequest httpRequest = getHttpRequest();
        httpRequest.setBody(getxmlString(map, "AdVodPlayReq"));
        httpRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.ad.SDKAdAPI.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                if (TextUtils.isEmpty(str)) {
                    LogEx.w(SDKAdAPI.TAG, "queryRChannelAds return data is empty.");
                }
                onRChannelAdsReturnListener.onRChannelAdsReturn(0, "queryRChannelAds success!", str);
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onRChannelAdsReturnListener.onRChannelAdsReturn(i, str, null);
            }
        });
    }

    public void queryVoDAds(Map<String, String> map, final OnVoDAdsReturnListener onVoDAdsReturnListener) {
        if (!a.f3131c) {
            LogEx.e(TAG, ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (map == null) {
            LogEx.w(TAG, "vod ads req is null.");
            return;
        }
        if (onVoDAdsReturnListener == null) {
            LogEx.w(TAG, "OnVoDAdsReturnListener is null.");
            return;
        }
        if (TextUtils.isEmpty(this.mAdServerDomian)) {
            LogEx.w(TAG, "mAdServerDomian is null.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.mAdServerDomian);
        sb.append(HttpUrlConstants.REQUEST_GET_VOD_AD);
        LogEx.d(TAG, "queryVoDAds url is " + sb.toString());
        String str = getxmlString(map, "AdVodPlayReq");
        LogEx.d(TAG, "queryVoDAds xmlReq is " + str);
        SDKNetHTTPRequest httpRequest = getHttpRequest();
        httpRequest.setBody(str);
        httpRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.ad.SDKAdAPI.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LogEx.w(SDKAdAPI.TAG, "queryVoDAds return data is empty.");
                }
                onVoDAdsReturnListener.onVoDAdsReturn(0, "queryVoDAds success!", str2);
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onVoDAdsReturnListener.onVoDAdsReturn(i, str2, null);
            }
        });
    }

    public void setServerDomain(String str) {
        Uri parse = !TextUtils.isEmpty(str) ? Uri.parse(str) : null;
        if (parse == null || TextUtils.isEmpty(parse.getHost()) || -1 == parse.getPort()) {
            return;
        }
        this.mAdServerDomian = str;
    }
}
