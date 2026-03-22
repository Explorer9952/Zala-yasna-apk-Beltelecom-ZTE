package com.video.androidsdk.service.column;

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
public class SDKColumnMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3578a;

    /* loaded from: classes.dex */
    public interface OnColumnInfoReturnListener {
        void onColumnInfoReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnColumnListReturnListener {
        void onColumnListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3578a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void getColumnInfo(HashMap<String, String> hashMap, final OnColumnInfoReturnListener onColumnInfoReturnListener) {
        if (onColumnInfoReturnListener == null) {
            LogEx.w("SDKColumnMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_COLUMN_INFO);
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
        this.f3578a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.column.SDKColumnMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onColumnInfoReturnListener.onColumnInfoReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKColumnMgr", "JSONException occur");
                    onColumnInfoReturnListener.onColumnInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COLUMN_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKColumnMgr", "SDKNetHTTPRequest onFailReturn");
                onColumnInfoReturnListener.onColumnInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COLUMN_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void getColumnList(HashMap<String, String> hashMap, final OnColumnListReturnListener onColumnListReturnListener) {
        if (onColumnListReturnListener == null) {
            LogEx.w("SDKColumnMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_COLUMN_LIST);
        if (hashMap == null) {
            LogEx.w("SDKColumnMgr", "params == null");
            onColumnListReturnListener.onColumnListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COLUMN_MODELCODE, 1, 2)), ErrMessage.PARAM_IS_NULL, null);
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
        this.f3578a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setCacheParams(hashMap.get("isneedcache"), hashMap.get("cachevalidityperiod"));
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.column.SDKColumnMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onColumnListReturnListener.onColumnListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKColumnMgr", "JSONException occur");
                    onColumnListReturnListener.onColumnListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COLUMN_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKColumnMgr", "SDKNetHTTPRequest onFailReturn");
                onColumnListReturnListener.onColumnListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COLUMN_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }
}
