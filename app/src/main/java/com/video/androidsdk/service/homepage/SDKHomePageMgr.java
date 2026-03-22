package com.video.androidsdk.service.homepage;

import android.text.TextUtils;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKHomePageMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3628a;

    /* loaded from: classes.dex */
    public interface OnDynamicColumnListReturnListener {
        void onDynamicColumnListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnHomeBannerReturnListener {
        void onHomeBannerReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnRecommendChannelListReturnListener {
        void onRecommendChannelListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnRecommendPrevueListReturnListener {
        void onRecommendPrevueListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnRecommendTvodListReturnListener {
        void onRecommendTvodListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnRecommendVodListReturnListener {
        void onRecommendVodListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3628a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void getDynamicColumnList(HashMap<String, String> hashMap, final OnDynamicColumnListReturnListener onDynamicColumnListReturnListener) {
        if (onDynamicColumnListReturnListener == null) {
            LogEx.w("SDKHomePageMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_HOME_DYNAMIC_COLUMNLIST);
        if (hashMap != null) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!"isneedcache".equals(key) && !"cachevalidityperiod".equals(key)) {
                    sb.append((Object) key);
                    sb.append("=");
                    sb.append((Object) value);
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3628a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        if (hashMap != null) {
            sDKNetHTTPRequest.setCacheParams(hashMap.get("isneedcache"), hashMap.get("cachevalidityperiod"));
        }
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.homepage.SDKHomePageMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                if (TextUtils.isEmpty(str)) {
                    LogEx.w("SDKHomePageMgr", "SDKNetHTTPRequest onDataReturn,the data is empty!");
                    onDynamicColumnListReturnListener.onDynamicColumnListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 2, 202)), "The data is empty", null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onDynamicColumnListReturnListener.onDynamicColumnListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKHomePageMgr", "JSONException occur");
                    onDynamicColumnListReturnListener.onDynamicColumnListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKHomePageMgr", "SDKNetHTTPRequest onFailReturn");
                onDynamicColumnListReturnListener.onDynamicColumnListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void getHomeBanner(HashMap<String, String> hashMap, final OnHomeBannerReturnListener onHomeBannerReturnListener) {
        if (onHomeBannerReturnListener == null) {
            LogEx.w("SDKHomePageMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_HOME_BANNER);
        if (hashMap != null) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!"isneedcache".equals(key) && !"cachevalidityperiod".equals(key)) {
                    sb.append((Object) key);
                    sb.append("=");
                    sb.append((Object) value);
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3628a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        if (hashMap != null) {
            sDKNetHTTPRequest.setCacheParams(hashMap.get("isneedcache"), hashMap.get("cachevalidityperiod"));
        }
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.homepage.SDKHomePageMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                if (TextUtils.isEmpty(str)) {
                    LogEx.w("SDKHomePageMgr", "SDKNetHTTPRequest onDataReturn,the data is empty!");
                    onHomeBannerReturnListener.onHomeBannerReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 1, 202)), "The data is empty", null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onHomeBannerReturnListener.onHomeBannerReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKHomePageMgr", "JSONException occur");
                    onHomeBannerReturnListener.onHomeBannerReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKHomePageMgr", "SDKNetHTTPRequest onFailReturn");
                onHomeBannerReturnListener.onHomeBannerReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }

    public void getRecommendChannelList(HashMap<String, String> hashMap, final OnRecommendChannelListReturnListener onRecommendChannelListReturnListener) {
        if (onRecommendChannelListReturnListener == null) {
            LogEx.w("SDKHomePageMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_CHANNEL_RECOMMEND_LIST);
        if (hashMap != null) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!"isneedcache".equals(key) && !"cachevalidityperiod".equals(key)) {
                    sb.append((Object) key);
                    sb.append("=");
                    sb.append((Object) value);
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3628a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        if (hashMap != null) {
            sDKNetHTTPRequest.setCacheParams(hashMap.get("isneedcache"), hashMap.get("cachevalidityperiod"));
        }
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.homepage.SDKHomePageMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                if (TextUtils.isEmpty(str)) {
                    LogEx.w("SDKHomePageMgr", "SDKNetHTTPRequest onDataReturn,the data is empty!");
                    onRecommendChannelListReturnListener.onRecommendChannelListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 3, 202)), "The data is empty", null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onRecommendChannelListReturnListener.onRecommendChannelListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKHomePageMgr", "JSONException occur");
                    onRecommendChannelListReturnListener.onRecommendChannelListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 3, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKHomePageMgr", "SDKNetHTTPRequest onFailReturn");
                onRecommendChannelListReturnListener.onRecommendChannelListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 3, i % 1000)), str, null);
            }
        });
    }

    public void getRecommendPrevueList(HashMap<String, String> hashMap, final OnRecommendPrevueListReturnListener onRecommendPrevueListReturnListener) {
        if (onRecommendPrevueListReturnListener == null) {
            LogEx.w("SDKHomePageMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_PREVUE_RECOMMEND_LIST);
        sb.append("?teamid=" + SDKLoginMgr.getInstance().getUserInfo("TeamID"));
        if (hashMap != null) {
            sb.append("&");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                sb.append((Object) key);
                sb.append("=");
                sb.append((Object) value);
                sb.append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3628a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.homepage.SDKHomePageMgr.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                if (TextUtils.isEmpty(str)) {
                    LogEx.w("SDKHomePageMgr", "SDKNetHTTPRequest onDataReturn,the data is empty!");
                    onRecommendPrevueListReturnListener.onRecommendPrevueListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 6, 202)), "The data is empty", null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onRecommendPrevueListReturnListener.onRecommendPrevueListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKHomePageMgr", "JSONException occur");
                    onRecommendPrevueListReturnListener.onRecommendPrevueListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 6, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKHomePageMgr", "SDKNetHTTPRequest onFailReturn");
                onRecommendPrevueListReturnListener.onRecommendPrevueListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 6, i % 1000)), str, null);
            }
        });
    }

    public void getRecommendTvodList(HashMap<String, String> hashMap, final OnRecommendTvodListReturnListener onRecommendTvodListReturnListener) {
        if (onRecommendTvodListReturnListener == null) {
            LogEx.w("SDKHomePageMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_TVOD_RECOMMEND_LIST);
        if (hashMap != null) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!"isneedcache".equals(key) && !"cachevalidityperiod".equals(key)) {
                    sb.append((Object) key);
                    sb.append("=");
                    sb.append((Object) value);
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3628a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        if (hashMap != null) {
            sDKNetHTTPRequest.setCacheParams(hashMap.get("isneedcache"), hashMap.get("cachevalidityperiod"));
        }
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.homepage.SDKHomePageMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                if (TextUtils.isEmpty(str)) {
                    LogEx.w("SDKHomePageMgr", "SDKNetHTTPRequest onDataReturn,the data is empty!");
                    onRecommendTvodListReturnListener.onRecommendTvodListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 4, 202)), "The data is empty", null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onRecommendTvodListReturnListener.onRecommendTvodListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKHomePageMgr", "JSONException occur");
                    onRecommendTvodListReturnListener.onRecommendTvodListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 4, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKHomePageMgr", "SDKNetHTTPRequest onFailReturn");
                onRecommendTvodListReturnListener.onRecommendTvodListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 4, i % 1000)), str, null);
            }
        });
    }

    public void getRecommendVodList(HashMap<String, String> hashMap, final OnRecommendVodListReturnListener onRecommendVodListReturnListener) {
        if (onRecommendVodListReturnListener == null) {
            LogEx.w("SDKHomePageMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_VOD_RECOMMEND_LIST);
        if (hashMap != null) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!"isneedcache".equals(key) && !"cachevalidityperiod".equals(key)) {
                    sb.append((Object) key);
                    sb.append("=");
                    sb.append((Object) value);
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3628a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        if (hashMap != null) {
            sDKNetHTTPRequest.setCacheParams(hashMap.get("isneedcache"), hashMap.get("cachevalidityperiod"));
        }
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.homepage.SDKHomePageMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                if (TextUtils.isEmpty(str)) {
                    LogEx.w("SDKHomePageMgr", "SDKNetHTTPRequest onDataReturn,the data is empty!");
                    onRecommendVodListReturnListener.onRecommendVodListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 5, 202)), "The data is empty", null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onRecommendVodListReturnListener.onRecommendVodListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKHomePageMgr", "JSONException occur");
                    onRecommendVodListReturnListener.onRecommendVodListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 5, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKHomePageMgr", "SDKNetHTTPRequest onFailReturn");
                onRecommendVodListReturnListener.onRecommendVodListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_HOMEPAGE_MODELCODE, 5, i % 1000)), str, null);
            }
        });
    }
}
