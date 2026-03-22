package com.video.androidsdk.service.pay;

import android.text.TextUtils;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.license.a;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKPayMgr {

    /* renamed from: a, reason: collision with root package name */
    private String f3667a;

    /* loaded from: classes.dex */
    public interface OnDoPrePayReturnListener {
        void onDoPrePayReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnQueryOrderStatusReturnListener {
        void onQueryOrderStatusReturn(String str, String str2);
    }

    private String a() {
        try {
            return AES.aesEncryptByBase64(((((SDKLoginMgr.getInstance().getUserInfo("UserID") + "$$") + TimeUtil.format(TimeUtil.getNow(), "yyyyMMddHHmmss")) + "$$") + AES.randomString(10)).getBytes(), a.a("thirdpaykey").trim().getBytes());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void doPrePay(PrePayReq prePayReq, final OnDoPrePayReturnListener onDoPrePayReturnListener) {
        if (TextUtils.isEmpty(this.f3667a)) {
            if (onDoPrePayReturnListener != null) {
                onDoPrePayReturnListener.onDoPrePayReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PAY_MODELCODE, 1, 100)), "ServerDomain has not set", null);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3667a);
        sb.append(HttpUrlConstants.PREPAY_URL);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("authinfo", URLEncoder.encode(a(), "UTF-8"));
            if (prePayReq != null) {
                jSONObject.put("usercode", prePayReq.usercode);
                jSONObject.put(ParamConst.AUTH_RSP_PRODUCTDESC, URLEncoder.encode(prePayReq.productdesc, "UTF-8"));
                jSONObject.put("goodsdesc", URLEncoder.encode(prePayReq.goodsdesc, "UTF-8"));
                jSONObject.put("deviceid", prePayReq.deviceid);
                jSONObject.put("terminalip", prePayReq.terminalip);
                jSONObject.put("totalfee", prePayReq.totalfee);
                jSONObject.put("purchasetype", prePayReq.purchasetype);
                jSONObject.put("productcode", prePayReq.productcode);
                jSONObject.put("programcode", prePayReq.programcode);
                jSONObject.put("terminalflag", prePayReq.terminalflag);
                jSONObject.put("paytype", prePayReq.paytype);
                jSONObject.put("feetype", prePayReq.feetype);
                jSONObject.put("attachinfo", URLEncoder.encode(prePayReq.attachinfo, "UTF-8"));
                jSONObject.put("payplatform", prePayReq.payplatform);
                jSONObject.put("platformid", prePayReq.platformid);
                jSONObject.put("contenttype", prePayReq.contenttype);
                jSONObject.put("returnurl", prePayReq.returnurl);
                jSONObject.put("contentname", URLEncoder.encode(prePayReq.contentname, "UTF-8"));
                jSONObject.put("usertoken", prePayReq.usertoken);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=UTF-8");
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.pay.SDKPayMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    int optInt = jSONObject2.has("returncode") ? jSONObject2.optInt("returncode") : -1;
                    String optString = jSONObject2.has("errormsg") ? jSONObject2.optString("errormsg") : "";
                    if (onDoPrePayReturnListener != null) {
                        onDoPrePayReturnListener.onDoPrePayReturn(String.valueOf(optInt), optString, str);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    LogEx.w("SDKPayMgr", "JSONException occur");
                    OnDoPrePayReturnListener onDoPrePayReturnListener2 = onDoPrePayReturnListener;
                    if (onDoPrePayReturnListener2 != null) {
                        onDoPrePayReturnListener2.onDoPrePayReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PAY_MODELCODE, 1, 202)), "JSONException occur", null);
                    }
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKPayMgr", "SDKNetHTTPRequest onFailReturn");
                OnDoPrePayReturnListener onDoPrePayReturnListener2 = onDoPrePayReturnListener;
                if (onDoPrePayReturnListener2 != null) {
                    onDoPrePayReturnListener2.onDoPrePayReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PAY_MODELCODE, 1, i % 1000)), str, null);
                }
            }
        });
    }

    public void queryOrderStatus(QueryOrderStatusReq queryOrderStatusReq, final OnQueryOrderStatusReturnListener onQueryOrderStatusReturnListener) {
        if (TextUtils.isEmpty(this.f3667a)) {
            if (onQueryOrderStatusReturnListener != null) {
                onQueryOrderStatusReturnListener.onQueryOrderStatusReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PAY_MODELCODE, 2, 100)), "ServerDomain has not set");
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3667a);
        sb.append(HttpUrlConstants.QUERY_TRADE_STATUS);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("authinfo", URLEncoder.encode(a(), "UTF-8"));
            if (queryOrderStatusReq != null) {
                jSONObject.put("usercode", queryOrderStatusReq.usercode);
                jSONObject.put("out_trade_no", queryOrderStatusReq.outtradeno);
                jSONObject.put("payplatform", queryOrderStatusReq.payplatform);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=UTF-8");
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.pay.SDKPayMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    int optInt = jSONObject2.has("returncode") ? jSONObject2.optInt("returncode") : -1;
                    String optString = jSONObject2.has("errormsg") ? jSONObject2.optString("errormsg") : "";
                    if (onQueryOrderStatusReturnListener != null) {
                        onQueryOrderStatusReturnListener.onQueryOrderStatusReturn(String.valueOf(optInt), optString);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    LogEx.w("SDKPayMgr", "JSONException occur");
                    OnQueryOrderStatusReturnListener onQueryOrderStatusReturnListener2 = onQueryOrderStatusReturnListener;
                    if (onQueryOrderStatusReturnListener2 != null) {
                        onQueryOrderStatusReturnListener2.onQueryOrderStatusReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PAY_MODELCODE, 2, 202)), "JSONException occur");
                    }
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKPayMgr", "SDKNetHTTPRequest onFailReturn");
                OnQueryOrderStatusReturnListener onQueryOrderStatusReturnListener2 = onQueryOrderStatusReturnListener;
                if (onQueryOrderStatusReturnListener2 != null) {
                    onQueryOrderStatusReturnListener2.onQueryOrderStatusReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PAY_MODELCODE, 1, i % 1000)), str);
                }
            }
        });
    }

    public void setServerDomain(String str) {
        this.f3667a = str;
    }
}
