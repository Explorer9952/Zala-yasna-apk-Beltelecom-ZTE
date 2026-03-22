package com.video.androidsdk.service.auth;

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
public class SDKSubscribeMgr4CELLC {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3508a;

    /* loaded from: classes.dex */
    public interface OnUserRecentOrderListReturnListener {
        void onUserRecentOrderListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3508a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void getUserRecentOrderList(HashMap<String, String> hashMap, final OnUserRecentOrderListReturnListener onUserRecentOrderListReturnListener) {
        if (hashMap != null && onUserRecentOrderListReturnListener != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(SDKLoginMgr.getInstance().getFrameHome());
            sb.append(HttpUrlConstants.CELLC_GET_RECENT_ORDER);
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
            this.f3508a = sDKNetHTTPRequest;
            sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
            sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.auth.SDKSubscribeMgr4CELLC.1
                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onDataReturn(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        onUserRecentOrderListReturnListener.onUserRecentOrderListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        LogEx.w("SDKSubscribeMgr4CELLC", "JSONException occur");
                        onUserRecentOrderListReturnListener.onUserRecentOrderListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 202)), "JSONException occur", null);
                    }
                }

                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onFailReturn(int i, String str) {
                    LogEx.w("SDKSubscribeMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                    onUserRecentOrderListReturnListener.onUserRecentOrderListReturn(String.valueOf(i), str, null);
                }
            });
            return;
        }
        LogEx.w("SDKSubscribeMgr4CELLC", "param is null or listener is null");
    }
}
