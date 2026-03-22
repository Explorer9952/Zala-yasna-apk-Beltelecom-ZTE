package com.video.androidsdk.service.npvr;

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
public class SDKNPVRMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3652a;

    /* loaded from: classes.dex */
    public interface OnAddNPVRReturnListener {
        void onAddNPVRReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnAddSeriesNPVRReturnListener {
        void onAddSeriesNPVRReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnDelNPVRReturnListener {
        void onDelNPVRReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnDelSeriesNPVRReturnListener {
        void onDelSeriesNPVRReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnUserNPVRListByFrameReturnListener {
        void onUserNPVRListByFrameReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnUserNPVRListReturnListener {
        void onUserNPVRListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnUserSeriesNPVRListReturnListener {
        void onUserSeriesNPVRListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3652a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void doAddNPVR(HashMap<String, String> hashMap, final OnAddNPVRReturnListener onAddNPVRReturnListener) {
        if (onAddNPVRReturnListener == null) {
            LogEx.w("SDKNPVRMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onAddNPVRReturnListener.onAddNPVRReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 3, 2)), "params is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_ADD_NPVR);
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
        this.f3652a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.npvr.SDKNPVRMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d("SDKNPVRMgr", "SDKNetHTTPRequest onDataReturn:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onAddNPVRReturnListener.onAddNPVRReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKNPVRMgr", "JSONException occur");
                    onAddNPVRReturnListener.onAddNPVRReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 3, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKNPVRMgr", "SDKNetHTTPRequest onFailReturn");
                onAddNPVRReturnListener.onAddNPVRReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 3, i % 1000)), str);
            }
        });
    }

    public void doAddSeriesNPVR(HashMap<String, String> hashMap, final OnAddSeriesNPVRReturnListener onAddSeriesNPVRReturnListener) {
        if (onAddSeriesNPVRReturnListener == null) {
            LogEx.w("SDKNPVRMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onAddSeriesNPVRReturnListener.onAddSeriesNPVRReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 4, 2)), "params is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_ADD_SERIES_NPVR);
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
        this.f3652a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.npvr.SDKNPVRMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d("SDKNPVRMgr", "SDKNetHTTPRequest onDataReturn:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onAddSeriesNPVRReturnListener.onAddSeriesNPVRReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKNPVRMgr", "JSONException occur");
                    onAddSeriesNPVRReturnListener.onAddSeriesNPVRReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 4, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKNPVRMgr", "SDKNetHTTPRequest onFailReturn");
                onAddSeriesNPVRReturnListener.onAddSeriesNPVRReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 4, i % 1000)), str);
            }
        });
    }

    public void doDelNPVR(HashMap<String, String> hashMap, final OnDelNPVRReturnListener onDelNPVRReturnListener) {
        if (onDelNPVRReturnListener == null) {
            LogEx.w("SDKNPVRMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onDelNPVRReturnListener.onDelNPVRReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 5, 2)), "params is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_DEL_NPVR);
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
        this.f3652a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.npvr.SDKNPVRMgr.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d("SDKNPVRMgr", "SDKNetHTTPRequest onDataReturn:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onDelNPVRReturnListener.onDelNPVRReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKNPVRMgr", "JSONException occur");
                    onDelNPVRReturnListener.onDelNPVRReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 5, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKNPVRMgr", "SDKNetHTTPRequest onFailReturn");
                onDelNPVRReturnListener.onDelNPVRReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 5, i % 1000)), str);
            }
        });
    }

    public void doDelSeriesNPVR(HashMap<String, String> hashMap, final OnDelSeriesNPVRReturnListener onDelSeriesNPVRReturnListener) {
        if (onDelSeriesNPVRReturnListener == null) {
            LogEx.w("SDKNPVRMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onDelSeriesNPVRReturnListener.onDelSeriesNPVRReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 6, 2)), "params is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_DEL_SERIES_NPVR);
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
        this.f3652a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.npvr.SDKNPVRMgr.7
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d("SDKNPVRMgr", "SDKNetHTTPRequest onDataReturn:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onDelSeriesNPVRReturnListener.onDelSeriesNPVRReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKNPVRMgr", "JSONException occur");
                    onDelSeriesNPVRReturnListener.onDelSeriesNPVRReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 6, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKNPVRMgr", "SDKNetHTTPRequest onFailReturn");
                onDelSeriesNPVRReturnListener.onDelSeriesNPVRReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 6, i % 1000)), str);
            }
        });
    }

    public void getUserNPVRList(HashMap<String, String> hashMap, final OnUserNPVRListReturnListener onUserNPVRListReturnListener) {
        if (onUserNPVRListReturnListener == null) {
            LogEx.w("SDKNPVRMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onUserNPVRListReturnListener.onUserNPVRListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 1, 2)), "params is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_USER_NPVR_LIST);
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
        this.f3652a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.npvr.SDKNPVRMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d("SDKNPVRMgr", "SDKNetHTTPRequest onDataReturn:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUserNPVRListReturnListener.onUserNPVRListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKNPVRMgr", "JSONException occur");
                    onUserNPVRListReturnListener.onUserNPVRListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKNPVRMgr", "SDKNetHTTPRequest onFailReturn");
                onUserNPVRListReturnListener.onUserNPVRListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }

    public void getUserNPVRListByFrame(GetUserNPVRListByFrameReq getUserNPVRListByFrameReq, final OnUserNPVRListByFrameReturnListener onUserNPVRListByFrameReturnListener) {
        if (onUserNPVRListByFrameReturnListener == null) {
            LogEx.w("SDKNPVRMgr", "listener is null");
            return;
        }
        if (getUserNPVRListByFrameReq == null) {
            onUserNPVRListByFrameReturnListener.onUserNPVRListByFrameReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 7, 2)), "req is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_USER_NPVR_LIST_BY_FRAME);
        HashMap<String, String> hashMap = getUserNPVRListByFrameReq.toHashMap();
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
        this.f3652a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.npvr.SDKNPVRMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d("SDKNPVRMgr", "SDKNetHTTPRequest onDataReturn:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUserNPVRListByFrameReturnListener.onUserNPVRListByFrameReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKNPVRMgr", "JSONException occur");
                    onUserNPVRListByFrameReturnListener.onUserNPVRListByFrameReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 7, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKNPVRMgr", "SDKNetHTTPRequest onFailReturn");
                onUserNPVRListByFrameReturnListener.onUserNPVRListByFrameReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 7, i % 1000)), str, null);
            }
        });
    }

    public void getUserSeriesNPVRList(HashMap<String, String> hashMap, final OnUserSeriesNPVRListReturnListener onUserSeriesNPVRListReturnListener) {
        if (onUserSeriesNPVRListReturnListener == null) {
            LogEx.w("SDKNPVRMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onUserSeriesNPVRListReturnListener.onUserSeriesNPVRListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 2, 2)), "params is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_USER_SERIES_NPVR_LIST);
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
        this.f3652a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.npvr.SDKNPVRMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d("SDKNPVRMgr", "SDKNetHTTPRequest onDataReturn:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUserSeriesNPVRListReturnListener.onUserSeriesNPVRListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKNPVRMgr", "JSONException occur");
                    onUserSeriesNPVRListReturnListener.onUserSeriesNPVRListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKNPVRMgr", "SDKNetHTTPRequest onFailReturn");
                onUserSeriesNPVRListReturnListener.onUserSeriesNPVRListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_NPVR_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }
}
