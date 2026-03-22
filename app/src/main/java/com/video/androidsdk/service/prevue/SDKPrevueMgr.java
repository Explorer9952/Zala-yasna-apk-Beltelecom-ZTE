package com.video.androidsdk.service.prevue;

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
public class SDKPrevueMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3694a;

    /* loaded from: classes.dex */
    public interface OnCurrentPrevueReturnListener {
        void onCurrentPrevueReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetHotPrevueReturnListener {
        void onGetHotPrevueReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnMultiPrevueInfoReturnListener {
        void onMultiPrevueInfoReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnPrevueDetailReturnListener {
        void onPrevueDetailReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnPrevueDetailWithUrlReturnListener {
        void onPrevueDetailWithUrlReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnPrevueListReturnListener {
        void onPrevueListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3694a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void getCurrentPrevue(HashMap<String, String> hashMap, final OnCurrentPrevueReturnListener onCurrentPrevueReturnListener) {
        if (onCurrentPrevueReturnListener == null) {
            LogEx.w("SDKPrevueMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onCurrentPrevueReturnListener.onCurrentPrevueReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 5, 2)), "params is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_CURRENT_PREVUE);
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
        this.f3694a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.prevue.SDKPrevueMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onCurrentPrevueReturnListener.onCurrentPrevueReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKPrevueMgr", "JSONException occur");
                    onCurrentPrevueReturnListener.onCurrentPrevueReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 5, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKPrevueMgr", "SDKNetHTTPRequest onFailReturn");
                onCurrentPrevueReturnListener.onCurrentPrevueReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 5, i % 1000)), str, null);
            }
        });
    }

    public void getHotPrevue(HashMap<String, String> hashMap, final OnGetHotPrevueReturnListener onGetHotPrevueReturnListener) {
        if (onGetHotPrevueReturnListener == null) {
            LogEx.w("SDKPrevueMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onGetHotPrevueReturnListener.onGetHotPrevueReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 6, 2)), "params is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_PREVUE_HOT);
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
        this.f3694a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.prevue.SDKPrevueMgr.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onGetHotPrevueReturnListener.onGetHotPrevueReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKPrevueMgr", "JSONException occur");
                    onGetHotPrevueReturnListener.onGetHotPrevueReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 6, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKPrevueMgr", "SDKNetHTTPRequest onFailReturn");
                onGetHotPrevueReturnListener.onGetHotPrevueReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 6, i % 1000)), str, null);
            }
        });
    }

    public void getMultiPrevueInfo(HashMap<String, String> hashMap, final OnMultiPrevueInfoReturnListener onMultiPrevueInfoReturnListener) {
        if (onMultiPrevueInfoReturnListener == null) {
            LogEx.w("SDKPrevueMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onMultiPrevueInfoReturnListener.onMultiPrevueInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 4, 2)), "params is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_PREVUEINFO);
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
        this.f3694a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.prevue.SDKPrevueMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onMultiPrevueInfoReturnListener.onMultiPrevueInfoReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKPrevueMgr", "JSONException occur");
                    onMultiPrevueInfoReturnListener.onMultiPrevueInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 4, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKPrevueMgr", "SDKNetHTTPRequest onFailReturn");
                onMultiPrevueInfoReturnListener.onMultiPrevueInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 4, i % 1000)), str, null);
            }
        });
    }

    public void getPrevueDetail(HashMap<String, String> hashMap, final OnPrevueDetailReturnListener onPrevueDetailReturnListener) {
        if (onPrevueDetailReturnListener == null) {
            LogEx.w("SDKPrevueMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onPrevueDetailReturnListener.onPrevueDetailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 2, 2)), "params is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_PREVUE_DETAIL);
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
        this.f3694a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.prevue.SDKPrevueMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onPrevueDetailReturnListener.onPrevueDetailReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKPrevueMgr", "JSONException occur");
                    onPrevueDetailReturnListener.onPrevueDetailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKPrevueMgr", "SDKNetHTTPRequest onFailReturn");
                onPrevueDetailReturnListener.onPrevueDetailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void getPrevueDetailWithUrl(HashMap<String, String> hashMap, final OnPrevueDetailWithUrlReturnListener onPrevueDetailWithUrlReturnListener) {
        if (onPrevueDetailWithUrlReturnListener == null) {
            LogEx.w("SDKPrevueMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onPrevueDetailWithUrlReturnListener.onPrevueDetailWithUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 3, 2)), "params is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_PREVUE_DETAIL);
        sb.append("?ischecksubscribe=1");
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
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3694a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.prevue.SDKPrevueMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onPrevueDetailWithUrlReturnListener.onPrevueDetailWithUrlReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKPrevueMgr", "JSONException occur");
                    onPrevueDetailWithUrlReturnListener.onPrevueDetailWithUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 3, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKPrevueMgr", "SDKNetHTTPRequest onFailReturn");
                onPrevueDetailWithUrlReturnListener.onPrevueDetailWithUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 3, i % 1000)), str, null);
            }
        });
    }

    public void getPrevueList(HashMap<String, String> hashMap, final OnPrevueListReturnListener onPrevueListReturnListener) {
        if (onPrevueListReturnListener == null) {
            LogEx.w("SDKPrevueMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onPrevueListReturnListener.onPrevueListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 1, 2)), "params is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_PREVUE_LIST);
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
        this.f3694a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setCacheParams(hashMap.get("isneedcache"), hashMap.get("cachevalidityperiod"));
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.prevue.SDKPrevueMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onPrevueListReturnListener.onPrevueListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKPrevueMgr", "JSONException occur");
                    onPrevueListReturnListener.onPrevueListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKPrevueMgr", "SDKNetHTTPRequest onFailReturn");
                onPrevueListReturnListener.onPrevueListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PREVUE_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }
}
