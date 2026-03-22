package com.video.androidsdk.service.viewhistory;

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
public class SDKViewHistoryMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3776a;

    /* loaded from: classes.dex */
    public interface OnAddViewHistoryReturnListener {
        void onAddViewHistoryReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnDelViewHistoryReturnListener {
        void onDelViewHistoryReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnUserViewHistorylistReturnListener {
        void onUserViewHistorylistReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3776a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void doAddViewHistory(HashMap<String, String> hashMap, final OnAddViewHistoryReturnListener onAddViewHistoryReturnListener) {
        if (onAddViewHistoryReturnListener == null) {
            LogEx.w("SDKViewHistoryMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_ADD_VIEW_HISTORY);
        if (hashMap != null) {
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
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3776a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.viewhistory.SDKViewHistoryMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onAddViewHistoryReturnListener.onAddViewHistoryReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKViewHistoryMgr", "JSONException occur");
                    onAddViewHistoryReturnListener.onAddViewHistoryReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VIEWHISTORY_MODELCODE, 2, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKViewHistoryMgr", "SDKNetHTTPRequest onFailReturn");
                onAddViewHistoryReturnListener.onAddViewHistoryReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VIEWHISTORY_MODELCODE, 2, i % 1000)), str);
            }
        });
    }

    public void doDelViewHistory(HashMap<String, String> hashMap, final OnDelViewHistoryReturnListener onDelViewHistoryReturnListener) {
        if (onDelViewHistoryReturnListener == null) {
            LogEx.w("SDKViewHistoryMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_DEL_VIEW_HISTORY);
        if (hashMap != null) {
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
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3776a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.viewhistory.SDKViewHistoryMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onDelViewHistoryReturnListener.onDelViewHistoryReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKViewHistoryMgr", "JSONException occur");
                    onDelViewHistoryReturnListener.onDelViewHistoryReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VIEWHISTORY_MODELCODE, 3, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKViewHistoryMgr", "SDKNetHTTPRequest onFailReturn");
                onDelViewHistoryReturnListener.onDelViewHistoryReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VIEWHISTORY_MODELCODE, 3, i % 1000)), str);
            }
        });
    }

    public void getUserViewHistorylist(HashMap<String, String> hashMap, final OnUserViewHistorylistReturnListener onUserViewHistorylistReturnListener) {
        if (onUserViewHistorylistReturnListener == null) {
            LogEx.w("SDKViewHistoryMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_VIEW_HISTORY_LIST);
        if (hashMap != null) {
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
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3776a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.viewhistory.SDKViewHistoryMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUserViewHistorylistReturnListener.onUserViewHistorylistReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKViewHistoryMgr", "JSONException occur");
                    onUserViewHistorylistReturnListener.onUserViewHistorylistReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VIEWHISTORY_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKViewHistoryMgr", "SDKNetHTTPRequest onFailReturn");
                onUserViewHistorylistReturnListener.onUserViewHistorylistReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VIEWHISTORY_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }
}
