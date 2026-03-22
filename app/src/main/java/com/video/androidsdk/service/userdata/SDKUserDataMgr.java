package com.video.androidsdk.service.userdata;

import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKUserDataMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3768a;

    /* renamed from: b, reason: collision with root package name */
    private String f3769b = "";

    /* loaded from: classes.dex */
    public interface OnDelUserDataReturnListener {
        void onDelUserDataReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnGetUserDataReturnListener {
        void onGetUserDataReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnSetUserDataReturnListener {
        void onSetUserDataReturn(String str, String str2);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3768a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void delUserData(DelUserDataReq delUserDataReq, final OnDelUserDataReturnListener onDelUserDataReturnListener) {
        if (onDelUserDataReturnListener == null) {
            LogEx.e("SDKUserDataMgr", "listener is null");
            return;
        }
        if (delUserDataReq == null) {
            onDelUserDataReturnListener.onDelUserDataReturn(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "params is null");
            LogEx.e("SDKUserDataMgr", "params is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3768a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setParam("usercode", delUserDataReq.usercode);
        sDKNetHTTPRequest.setParam("datatype", delUserDataReq.datatype);
        String str = delUserDataReq.profilecode;
        if (str != null) {
            sDKNetHTTPRequest.setParam("profilecode", str);
        }
        sDKNetHTTPRequest.startRequest(SDKLoginMgr.getInstance().getFrameHome() + HttpUrlConstants.DEL_USERDATA, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.userdata.SDKUserDataMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                String str3;
                String str4;
                try {
                    if (TextUtils.isEmpty(str2)) {
                        str3 = WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
                        str4 = "";
                    } else {
                        JSONObject jSONObject = new JSONObject(str2);
                        str3 = jSONObject.optString("returncode");
                        str4 = jSONObject.optString("errormsg");
                    }
                    onDelUserDataReturnListener.onDelUserDataReturn(str3, str4);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserDataMgr", "JSONException occur");
                    onDelUserDataReturnListener.onDelUserDataReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USERDATA_MODELCODE, 3, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                LogEx.w("SDKUserDataMgr", "SDKNetHTTPRequest onFailReturn");
                onDelUserDataReturnListener.onDelUserDataReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USERDATA_MODELCODE, 3, i % 1000)), str2);
            }
        });
    }

    public void getUserData(GetUserDataReq getUserDataReq, final OnGetUserDataReturnListener onGetUserDataReturnListener) {
        if (onGetUserDataReturnListener == null) {
            LogEx.e("SDKUserDataMgr", "listener is null");
            return;
        }
        if (getUserDataReq == null) {
            onGetUserDataReturnListener.onGetUserDataReturn(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "params is null", "");
            LogEx.e("SDKUserDataMgr", "params is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3768a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setParam("usercode", getUserDataReq.usercode);
        sDKNetHTTPRequest.setParam("datatype", getUserDataReq.datatype);
        String str = getUserDataReq.profilecode;
        if (str != null) {
            sDKNetHTTPRequest.setParam("profilecode", str);
        }
        sDKNetHTTPRequest.startRequest(SDKLoginMgr.getInstance().getFrameHome() + HttpUrlConstants.GET_USERDATA, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.userdata.SDKUserDataMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                String str3;
                String str4;
                try {
                    if (TextUtils.isEmpty(str2)) {
                        str3 = WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
                        str4 = "";
                    } else {
                        JSONObject jSONObject = new JSONObject(str2);
                        str3 = jSONObject.optString("returncode");
                        str4 = jSONObject.optString("errormsg");
                    }
                    onGetUserDataReturnListener.onGetUserDataReturn(str3, str4, str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserDataMgr", "JSONException occur");
                    onGetUserDataReturnListener.onGetUserDataReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USERDATA_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                LogEx.w("SDKUserDataMgr", "SDKNetHTTPRequest onFailReturn");
                onGetUserDataReturnListener.onGetUserDataReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USERDATA_MODELCODE, 2, i % 1000)), str2, null);
            }
        });
    }

    public void setUserData(SetUserDataReq setUserDataReq, final OnSetUserDataReturnListener onSetUserDataReturnListener) {
        if (onSetUserDataReturnListener == null) {
            LogEx.w("SDKUserDataMgr", "listener is null");
            return;
        }
        if (setUserDataReq == null) {
            onSetUserDataReturnListener.onSetUserDataReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USERDATA_MODELCODE, 1, 2)), "params is null");
            LogEx.e("SDKUserDataMgr", "params is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3768a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setParam("usercode", setUserDataReq.usercode);
        sDKNetHTTPRequest.setParam("datatype", setUserDataReq.datatype);
        sDKNetHTTPRequest.setParam("datavalue", setUserDataReq.datavalue);
        String str = setUserDataReq.profilecode;
        if (str != null) {
            sDKNetHTTPRequest.setParam("profilecode", str);
        }
        sDKNetHTTPRequest.startRequest(SDKLoginMgr.getInstance().getFrameHome() + HttpUrlConstants.SET_USERDATA, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.userdata.SDKUserDataMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                String str3;
                String str4;
                try {
                    if (TextUtils.isEmpty(str2)) {
                        str3 = WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
                        str4 = "";
                    } else {
                        JSONObject jSONObject = new JSONObject(str2);
                        str3 = jSONObject.optString("returncode");
                        str4 = jSONObject.optString("errormsg");
                    }
                    onSetUserDataReturnListener.onSetUserDataReturn(str3, str4);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserDataMgr", "JSONException occur");
                    onSetUserDataReturnListener.onSetUserDataReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USERDATA_MODELCODE, 1, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                LogEx.w("SDKUserDataMgr", "SDKNetHTTPRequest onFailReturn");
                onSetUserDataReturnListener.onSetUserDataReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USERDATA_MODELCODE, 1, i % 1000)), str2);
            }
        });
    }
}
