package com.video.androidsdk.service.comm;

import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.a.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKUtil4CELLC {
    private static final String TAG = "SDKUtil4CELLC";

    /* loaded from: classes.dex */
    public interface OnGetEPGLocalTimeReturnListener {
        String onGetEPGLocalTimeReturn(String str);
    }

    public static String getAESEncryptText(String str) {
        return a.a(str);
    }

    public static String getDRMEncryptInfo(String str, String str2, String str3) {
        return a.a(str, str2, str3);
    }

    public void getEPGLocalTime(final OnGetEPGLocalTimeReturnListener onGetEPGLocalTimeReturnListener) {
        if (onGetEPGLocalTimeReturnListener == null) {
            LogEx.w(TAG, "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.CELLC_GET_EPG_DATE);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.comm.SDKUtil4CELLC.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    onGetEPGLocalTimeReturnListener.onGetEPGLocalTimeReturn(new JSONObject(str).optString("nowdate"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w(SDKUtil4CELLC.TAG, "JSONException occur");
                    onGetEPGLocalTimeReturnListener.onGetEPGLocalTimeReturn(null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w(SDKUtil4CELLC.TAG, "SDKNetHTTPRequest onFailReturn");
                onGetEPGLocalTimeReturnListener.onGetEPGLocalTimeReturn(null);
            }
        });
    }
}
