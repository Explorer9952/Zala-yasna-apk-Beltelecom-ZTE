package com.video.androidsdk.service.vod;

import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKVodMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3783a;

    /* loaded from: classes.dex */
    public interface OnBatchVodListReturnListener {
        void onBatchVodListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnSeriesChildListReturnListener {
        void onSeriesChildListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnSeriesHeadInfoReturnListener {
        void onSeriesHeadInfoReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnVodDetailReturnListener {
        void onVodDetailReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnVodDetailWithUrlReturnListener {
        void onVodDetailWithUrlReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnVodFilterReturnListener {
        void onVodFilterReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnVodInfoByContentcodeReturnListener {
        void onVodInfoByContentcodeReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnVodInfoByProgramcodeReturnListener {
        void onVodInfoByProgramcodeReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnVodListReturnListener {
        void onVodListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnVodSearchListReturnListener {
        void onVodSearchListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3783a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void getBatchVodList(HashMap<String, String> hashMap, final OnBatchVodListReturnListener onBatchVodListReturnListener) {
        if (onBatchVodListReturnListener == null) {
            LogEx.w("SDKVodMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKVodMgr", "params == null");
            onBatchVodListReturnListener.onBatchVodListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 9, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_BATCH_VOD_LIST);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3783a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr.10
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onBatchVodListReturnListener.onBatchVodListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKVodMgr", "JSONException occur");
                    onBatchVodListReturnListener.onBatchVodListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 9, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKVodMgr", "SDKNetHTTPRequest onFailReturn");
                onBatchVodListReturnListener.onBatchVodListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 9, i % 1000)), str, null);
            }
        });
    }

    public void getSeriesChildlList(HashMap<String, String> hashMap, final OnSeriesChildListReturnListener onSeriesChildListReturnListener) {
        if (onSeriesChildListReturnListener == null) {
            LogEx.w("SDKVodMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKVodMgr", "params == null");
            onSeriesChildListReturnListener.onSeriesChildListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 5, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_SERIESCHILD_LIST);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3783a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onSeriesChildListReturnListener.onSeriesChildListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKVodMgr", "JSONException occur");
                    onSeriesChildListReturnListener.onSeriesChildListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 5, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKVodMgr", "SDKNetHTTPRequest onFailReturn");
                onSeriesChildListReturnListener.onSeriesChildListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 5, i % 1000)), str, null);
            }
        });
    }

    public void getSeriesHeadInfo(HashMap<String, String> hashMap, final OnSeriesHeadInfoReturnListener onSeriesHeadInfoReturnListener) {
        if (onSeriesHeadInfoReturnListener == null) {
            LogEx.w("SDKVodMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_SERIES_INFO);
        if (hashMap == null) {
            LogEx.w("SDKVodMgr", "params == null");
            onSeriesHeadInfoReturnListener.onSeriesHeadInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 4, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
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
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3783a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setCacheParams(hashMap.get("isneedcache"), hashMap.get("cachevalidityperiod"));
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onSeriesHeadInfoReturnListener.onSeriesHeadInfoReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKVodMgr", "JSONException occur");
                    onSeriesHeadInfoReturnListener.onSeriesHeadInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 4, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKVodMgr", "SDKNetHTTPRequest onFailReturn");
                onSeriesHeadInfoReturnListener.onSeriesHeadInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 4, i % 1000)), str, null);
            }
        });
    }

    public void getVodDetail(HashMap<String, String> hashMap, final OnVodDetailReturnListener onVodDetailReturnListener) {
        if (onVodDetailReturnListener == null) {
            LogEx.w("SDKVodMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKVodMgr", "params == null");
            onVodDetailReturnListener.onVodDetailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 2, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_VOD_DETAIL);
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
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3783a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setCacheParams(hashMap.get("isneedcache"), hashMap.get("cachevalidityperiod"));
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onVodDetailReturnListener.onVodDetailReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKVodMgr", "JSONException occur");
                    onVodDetailReturnListener.onVodDetailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKVodMgr", "SDKNetHTTPRequest onFailReturn");
                onVodDetailReturnListener.onVodDetailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void getVodDetailWithUrl(HashMap<String, String> hashMap, final OnVodDetailWithUrlReturnListener onVodDetailWithUrlReturnListener) {
        if (onVodDetailWithUrlReturnListener == null) {
            LogEx.w("SDKVodMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKVodMgr", "params == null");
            onVodDetailWithUrlReturnListener.onVodDetailWithUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 3, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_VOD_DETAIL);
        sb.append("?ischecksubscribe=1");
        sb.append("&");
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
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3783a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setCacheParams(hashMap.get("isneedcache"), hashMap.get("cachevalidityperiod"));
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr.7
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onVodDetailWithUrlReturnListener.onVodDetailWithUrlReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKVodMgr", "JSONException occur");
                    onVodDetailWithUrlReturnListener.onVodDetailWithUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 3, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKVodMgr", "SDKNetHTTPRequest onFailReturn");
                onVodDetailWithUrlReturnListener.onVodDetailWithUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 3, i % 1000)), str, null);
            }
        });
    }

    public void getVodFilter(HashMap<String, String> hashMap, final OnVodFilterReturnListener onVodFilterReturnListener) {
        if (onVodFilterReturnListener == null) {
            LogEx.w("SDKVodMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKVodMgr", "params == null");
            onVodFilterReturnListener.onVodFilterReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 6, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_VOD_FILTER);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3783a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onVodFilterReturnListener.onVodFilterReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKVodMgr", "JSONException occur");
                    onVodFilterReturnListener.onVodFilterReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 6, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKVodMgr", "SDKNetHTTPRequest onFailReturn");
                onVodFilterReturnListener.onVodFilterReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 6, i % 1000)), str, null);
            }
        });
    }

    public void getVodInfoByContentcode(HashMap<String, String> hashMap, final OnVodInfoByContentcodeReturnListener onVodInfoByContentcodeReturnListener) {
        if (onVodInfoByContentcodeReturnListener == null) {
            LogEx.w("SDKVodMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKVodMgr", "params == null");
            onVodInfoByContentcodeReturnListener.onVodInfoByContentcodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 8, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_SERIES_INFO);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3783a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr.8
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onVodInfoByContentcodeReturnListener.onVodInfoByContentcodeReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKVodMgr", "JSONException occur");
                    onVodInfoByContentcodeReturnListener.onVodInfoByContentcodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 8, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKVodMgr", "SDKNetHTTPRequest onFailReturn");
                onVodInfoByContentcodeReturnListener.onVodInfoByContentcodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 8, i % 1000)), str, null);
            }
        });
    }

    public void getVodInfoByProgramcode(HashMap<String, String> hashMap, final OnVodInfoByProgramcodeReturnListener onVodInfoByProgramcodeReturnListener) {
        if (onVodInfoByProgramcodeReturnListener == null) {
            LogEx.w("SDKVodMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKVodMgr", "params == null");
            onVodInfoByProgramcodeReturnListener.onVodInfoByProgramcodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 10, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_SERIES_INFO);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3783a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr.9
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onVodInfoByProgramcodeReturnListener.onVodInfoByProgramcodeReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKVodMgr", "JSONException occur");
                    onVodInfoByProgramcodeReturnListener.onVodInfoByProgramcodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 10, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKVodMgr", "SDKNetHTTPRequest onFailReturn");
                onVodInfoByProgramcodeReturnListener.onVodInfoByProgramcodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 10, i % 1000)), str, null);
            }
        });
    }

    public void getVodList(HashMap<String, String> hashMap, final OnVodListReturnListener onVodListReturnListener) {
        if (onVodListReturnListener == null) {
            LogEx.w("SDKVodMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_VOD_LIST);
        if (hashMap == null) {
            LogEx.w("SDKVodMgr", "params == null");
            onVodListReturnListener.onVodListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 1, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
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
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3783a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setCacheParams(hashMap.get("isneedcache"), hashMap.get("cachevalidityperiod"));
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onVodListReturnListener.onVodListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKVodMgr", "JSONException occur");
                    onVodListReturnListener.onVodListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKVodMgr", "SDKNetHTTPRequest onFailReturn");
                onVodListReturnListener.onVodListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }

    public void getVodSearchList(HashMap<String, String> hashMap, final OnVodSearchListReturnListener onVodSearchListReturnListener) {
        if (onVodSearchListReturnListener == null) {
            LogEx.w("SDKVodMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKVodMgr", "params == null");
            onVodSearchListReturnListener.onVodSearchListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 7, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_VOD_SEARCH_LIST);
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
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3783a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setCacheParams(hashMap.get("isneedcache"), hashMap.get("cachevalidityperiod"));
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onVodSearchListReturnListener.onVodSearchListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKVodMgr", "JSONException occur");
                    onVodSearchListReturnListener.onVodSearchListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 7, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKVodMgr", "SDKNetHTTPRequest onFailReturn");
                onVodSearchListReturnListener.onVodSearchListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 7, i % 1000)), str, null);
            }
        });
    }
}
