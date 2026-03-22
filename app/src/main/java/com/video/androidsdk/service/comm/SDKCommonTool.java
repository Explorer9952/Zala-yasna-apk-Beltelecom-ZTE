package com.video.androidsdk.service.comm;

import android.text.TextUtils;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.IIPTVLogin;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKCommonTool {
    private static final String TAG = "SDKCommonTool";
    private OnInnerCodeReturnListener mListener;
    private SDKNetHTTPRequest mRequest;

    /* loaded from: classes.dex */
    public interface OnGetEPGTimeReturnListener {
        void onGetEPGTimeReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnGetPublicKeyReturnListener {
        void onGetPublicKeyReturn(String str);
    }

    /* loaded from: classes.dex */
    public interface OnInnerCodeReturnListener {
        void onInnerCodeReturn(String str, String str2, Map<String, Object> map);
    }

    public static Map<String, Object> analysisJson(String str) {
        LogEx.d(TAG, "analysisSearchCommonJson start. strResponseJson = " + str);
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("returncode");
            hashMap.put("returncode", optString);
            LogEx.d(TAG, "intReturnCode:" + optString);
            String optString2 = jSONObject.optString("errormsg");
            hashMap.put("errormsg", optString2);
            LogEx.d(TAG, "strMsg:" + optString2);
            hashMap.put("columncode", jSONObject.optString("columncode"));
            hashMap.put("contentcode", jSONObject.optString("contentcode"));
            hashMap.put("contenttype", jSONObject.optString("contenttype"));
            hashMap.put("programcode", jSONObject.optString("programcode"));
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            LogEx.w(TAG, "Failed to parse jason:" + str);
            return hashMap;
        }
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.mRequest;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void getEPGTime(final OnGetEPGTimeReturnListener onGetEPGTimeReturnListener) {
        if (onGetEPGTimeReturnListener == null) {
            LogEx.w(TAG, "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.CELLC_GET_EPG_DATE);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.mRequest = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.comm.SDKCommonTool.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                String str2;
                String str3 = "";
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("nowdate");
                    try {
                        str3 = jSONObject.optString("utcnowdate");
                        onGetEPGTimeReturnListener.onGetEPGTimeReturn(optString, str3);
                    } catch (JSONException e) {
                        e = e;
                        String str4 = str3;
                        str3 = optString;
                        str2 = str4;
                        e.printStackTrace();
                        LogEx.w(SDKCommonTool.TAG, "JSONException occur");
                        onGetEPGTimeReturnListener.onGetEPGTimeReturn(str3, str2);
                    }
                } catch (JSONException e2) {
                    e = e2;
                    str2 = "";
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w(SDKCommonTool.TAG, "SDKNetHTTPRequest onFailReturn");
                onGetEPGTimeReturnListener.onGetEPGTimeReturn("", "");
            }
        });
    }

    public void getPublicKey(final OnGetPublicKeyReturnListener onGetPublicKeyReturnListener) {
        if (onGetPublicKeyReturnListener == null) {
            LogEx.w(TAG, "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_PK);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.mRequest = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.comm.SDKCommonTool.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                String str2 = "";
                try {
                    str2 = new JSONObject(str).optString("pk");
                    onGetPublicKeyReturnListener.onGetPublicKeyReturn(str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w(SDKCommonTool.TAG, "JSONException occur");
                    onGetPublicKeyReturnListener.onGetPublicKeyReturn(str2);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w(SDKCommonTool.TAG, "SDKNetHTTPRequest onFailReturn");
                onGetPublicKeyReturnListener.onGetPublicKeyReturn("");
            }
        });
    }

    public void queryInnerCode(String str, String str2, String str3, OnInnerCodeReturnListener onInnerCodeReturnListener) {
        if (onInnerCodeReturnListener == null) {
            LogEx.w(TAG, "queryInnerCode callback is null");
            return;
        }
        this.mListener = onInnerCodeReturnListener;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.mRequest = sDKNetHTTPRequest;
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "UTF-8");
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + hTTPSessionID);
        String str4 = SDKLoginMgr.getInstance().getFrameHome() + "sdk_getinnercode.jsp";
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        sb.append("?contenttype=" + str);
        sb.append("&contentcode=" + str2);
        sb.append("&columncode=" + str3);
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.comm.SDKCommonTool.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str5) {
                Map<String, Object> analysisJson = SDKCommonTool.analysisJson(str5);
                if (!TextUtils.isEmpty(String.valueOf(analysisJson.get("returncode")))) {
                    SDKCommonTool.this.mListener.onInnerCodeReturn(String.valueOf(analysisJson.get("returncode")), (String) analysisJson.get("errormsg"), analysisJson);
                } else {
                    LogEx.w(SDKCommonTool.TAG, "return data is empty");
                    SDKCommonTool.this.mListener.onInnerCodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMONTOOLS_MODELCODE, 1, 5)), "return data is null", analysisJson);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str5) {
                SDKCommonTool.this.mListener.onInnerCodeReturn(String.valueOf(i), str5, null);
            }
        });
    }

    public void queryInnerCode(QueryInnerCodeReq queryInnerCodeReq, OnInnerCodeReturnListener onInnerCodeReturnListener) {
        if (onInnerCodeReturnListener == null) {
            LogEx.w(TAG, "queryInnerCode callback is null");
            return;
        }
        if (queryInnerCodeReq == null) {
            this.mListener.onInnerCodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMONTOOLS_MODELCODE, 1, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        this.mListener = onInnerCodeReturnListener;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.mRequest = sDKNetHTTPRequest;
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "UTF-8");
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + hTTPSessionID);
        String str = SDKLoginMgr.getInstance().getFrameHome() + "sdk_getinnercode.jsp";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("?contenttype=" + queryInnerCodeReq.contenttype);
        sb.append("&contentcode=" + queryInnerCodeReq.contentcode);
        sb.append("&columncode=" + queryInnerCodeReq.columncode);
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.comm.SDKCommonTool.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                Map<String, Object> analysisJson = SDKCommonTool.analysisJson(str2);
                if (!TextUtils.isEmpty(String.valueOf(analysisJson.get("returncode")))) {
                    SDKCommonTool.this.mListener.onInnerCodeReturn(String.valueOf(analysisJson.get("returncode")), (String) analysisJson.get("errormsg"), analysisJson);
                } else {
                    LogEx.w(SDKCommonTool.TAG, "return data is empty");
                    SDKCommonTool.this.mListener.onInnerCodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMONTOOLS_MODELCODE, 1, 5)), "return data is null", analysisJson);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                SDKCommonTool.this.mListener.onInnerCodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMONTOOLS_MODELCODE, 1, i % 1000)), str2, null);
            }
        });
    }
}
