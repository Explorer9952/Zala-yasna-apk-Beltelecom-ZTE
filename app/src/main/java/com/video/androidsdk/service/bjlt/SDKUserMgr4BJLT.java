package com.video.androidsdk.service.bjlt;

import android.text.TextUtils;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.SDKUserMgr;
import com.video.androidsdk.service.bean.UserLoginInfoReq;
import com.video.androidsdk.service.comm.ParamConst;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKUserMgr4BJLT extends SDKUserMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3511a;

    /* loaded from: classes.dex */
    public interface OnLoginInfoReturnListener {
        void OnLoginInfoReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3511a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void queryLoginInfo(String str, UserLoginInfoReq userLoginInfoReq, final OnLoginInfoReturnListener onLoginInfoReturnListener) {
        if (onLoginInfoReturnListener == null) {
            LogEx.w("SDKUserMgr4BJLT", "OnLoginInfoReturnListener is null");
            return;
        }
        if (userLoginInfoReq == null) {
            LogEx.w("SDKUserMgr4BJLT", "UserLoginInfoReq req is null");
            return;
        }
        String replace = "http://{impip:port}/ottuserlogin".replace("http://{impip:port}", str);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3511a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setParam("ottuserid", userLoginInfoReq.ottuserid);
        sDKNetHTTPRequest.setParam("terminalFlag", userLoginInfoReq.terminalFlag);
        sDKNetHTTPRequest.setParam(ParamConst.REQUEST_IDENTIFYCODE, userLoginInfoReq.identifycode);
        sDKNetHTTPRequest.startRequest(replace, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.bjlt.SDKUserMgr4BJLT.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LogEx.w("SDKUserMgr4BJLT", "return data is empty");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    onLoginInfoReturnListener.OnLoginInfoReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), jSONObject.optString("password"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr4BJLT", "json parse error");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onLoginInfoReturnListener.OnLoginInfoReturn(String.valueOf(i), str2, null);
            }
        });
    }
}
