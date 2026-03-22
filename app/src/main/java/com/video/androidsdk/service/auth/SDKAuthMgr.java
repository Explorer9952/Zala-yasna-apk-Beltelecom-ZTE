package com.video.androidsdk.service.auth;

import android.text.TextUtils;
import com.google.gson.JsonParseException;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.util.AndroidUtils;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.bean.AuthReq;
import com.video.androidsdk.service.bean.AuthSuccRspInfo;
import com.video.androidsdk.service.bean.Product;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import com.video.androidsdk.service.comm.ParamConst;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKAuthMgr {

    /* renamed from: a, reason: collision with root package name */
    private OnDoAuthReturnListener f3486a;

    /* renamed from: b, reason: collision with root package name */
    private SDKNetHTTPRequest f3487b;

    /* loaded from: classes.dex */
    public interface OnAuthByContentReturnListener {
        void onAuthByContentReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnDoAuthReturnListener {
        void onDoAuthNotPassProductListReturn(String str, String str2, List<Product> list);

        void onDoAuthOtherFailReturn(String str, String str2);

        void onDoAuthSuccReturn(AuthSuccRspInfo authSuccRspInfo);
    }

    /* loaded from: classes.dex */
    public interface OnFeatureAuthAndOrderListReturnListener {
        void onFeatureAuthAndOrderListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3487b;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void doAuth(AuthReq authReq, OnDoAuthReturnListener onDoAuthReturnListener) {
        if (onDoAuthReturnListener == null) {
            LogEx.w("SDKAuthMgr", "OnDoAuthReturnListener is null");
            return;
        }
        this.f3486a = onDoAuthReturnListener;
        if (authReq == null) {
            LogEx.w("SDKAuthMgr", "AuthReq is null");
            this.f3486a.onDoAuthOtherFailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 1, 2)), "AuthReq is null");
            return;
        }
        this.f3487b = new SDKNetHTTPRequest();
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        this.f3487b.setHeader("Cookie", "JSESSIONID=" + hTTPSessionID);
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append("datasource/doauth.jsp");
        LogEx.d("SDKAuthMgr", "do auth url=" + sb.toString());
        a(authReq, this.f3487b);
        this.f3487b.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.auth.SDKAuthMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                if (TextUtils.isEmpty(str)) {
                    LogEx.w("SDKAuthMgr", "return data is null");
                    SDKAuthMgr.this.f3486a.onDoAuthOtherFailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 1, 5)), "return data is null");
                }
                SDKAuthMgr.this.a(str);
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                SDKAuthMgr.this.f3486a.onDoAuthOtherFailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 1, i % 1000)), str);
            }
        });
    }

    public void doAuthByContent(HashMap<String, String> hashMap, final OnAuthByContentReturnListener onAuthByContentReturnListener) {
        if (onAuthByContentReturnListener == null) {
            LogEx.w("SDKAuthMgr", "OnAuthByContentReturnListener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKAuthMgr", "req param is null");
            onAuthByContentReturnListener.onAuthByContentReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 2, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.DO_AUTH_BY_CONTENT);
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
        this.f3487b = new SDKNetHTTPRequest();
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        this.f3487b.setHeader("Cookie", "JSESSIONID=" + hTTPSessionID);
        this.f3487b.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.auth.SDKAuthMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onAuthByContentReturnListener.onAuthByContentReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKAuthMgr", "JSONException occur");
                    onAuthByContentReturnListener.onAuthByContentReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKAuthMgr", "SDKNetHTTPRequest onFailReturn");
                onAuthByContentReturnListener.onAuthByContentReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void doFeatureAuthAndOrderList(FeatureAuthAndOrderListReq featureAuthAndOrderListReq, final OnFeatureAuthAndOrderListReturnListener onFeatureAuthAndOrderListReturnListener) {
        if (onFeatureAuthAndOrderListReturnListener == null) {
            LogEx.w("SDKAuthMgr", "OnFeatureAuthReturnListener is null");
            return;
        }
        if (featureAuthAndOrderListReq == null) {
            LogEx.w("SDKAuthMgr", "req  is null");
            onFeatureAuthAndOrderListReturnListener.onFeatureAuthAndOrderListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 9, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.DO_FEATURE_AUTH);
        HashMap<String, String> hashMap = featureAuthAndOrderListReq.toHashMap();
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
        this.f3487b = new SDKNetHTTPRequest();
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        this.f3487b.setHeader("Cookie", "JSESSIONID=" + hTTPSessionID);
        this.f3487b.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.auth.SDKAuthMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onFeatureAuthAndOrderListReturnListener.onFeatureAuthAndOrderListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKAuthMgr", "JSONException occur");
                    onFeatureAuthAndOrderListReturnListener.onFeatureAuthAndOrderListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 9, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKAuthMgr", "SDKNetHTTPRequest onFailReturn");
                onFeatureAuthAndOrderListReturnListener.onFeatureAuthAndOrderListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 9, i % 1000)), str, null);
            }
        });
    }

    private void a(AuthReq authReq, SDKNetHTTPRequest sDKNetHTTPRequest) {
        for (Field field : authReq.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                String name = field.getName();
                Object obj = field.get(authReq);
                if (obj != null) {
                    sDKNetHTTPRequest.setParam(name, String.valueOf(obj));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("returncode");
            String optString2 = jSONObject.optString("errormsg");
            if (optString.equals("0")) {
                HashMap<String, String> hashMap = AndroidUtils.toHashMap(str);
                this.f3486a.onDoAuthSuccReturn(hashMap != null ? new AuthSuccRspInfo(hashMap) : null);
                return;
            }
            if (!optString.equals(DownloadConstant.REPORT_MSGTYPE_ADD) && !optString.equals("98") && !optString.equals("70116597")) {
                this.f3486a.onDoAuthOtherFailReturn(optString, optString2);
                return;
            }
            this.f3486a.onDoAuthNotPassProductListReturn(optString, optString2, a(jSONObject));
        } catch (JsonParseException e) {
            e.printStackTrace();
            LogEx.w("SDKAuthMgr", "JsonParseException");
            this.f3486a.onDoAuthOtherFailReturn(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "json parse exception");
        } catch (JSONException e2) {
            e2.printStackTrace();
            LogEx.w("SDKAuthMgr", "JSONException");
            this.f3486a.onDoAuthOtherFailReturn(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "json parse exception");
        } catch (Exception e3) {
            e3.printStackTrace();
            LogEx.w("SDKAuthMgr", "JsonParseException");
            this.f3486a.onDoAuthOtherFailReturn(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "json parse exception");
        }
    }

    private List<Product> a(JSONObject jSONObject) {
        String optString = jSONObject.optString("totalcount");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("productcode");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("productname");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("fee");
        JSONArray optJSONArray4 = jSONObject.optJSONArray("purchasetype");
        JSONArray optJSONArray5 = jSONObject.optJSONArray(ParamConst.AUTH_RSP_PRODUCTDESC);
        JSONArray optJSONArray6 = jSONObject.optJSONArray(ParamConst.AUTH_RSP_LISTPRICE);
        JSONArray optJSONArray7 = jSONObject.optJSONArray("rentalterm");
        JSONArray optJSONArray8 = jSONObject.optJSONArray("rentalunit");
        JSONArray optJSONArray9 = jSONObject.optJSONArray("limittimes");
        JSONArray optJSONArray10 = jSONObject.optJSONArray(ParamConst.AUTH_RSP_AUTOCONTINUEOPTION);
        JSONArray optJSONArray11 = jSONObject.optJSONArray("contentcode");
        JSONArray optJSONArray12 = jSONObject.optJSONArray("servicecode");
        JSONArray optJSONArray13 = jSONObject.optJSONArray("starttime");
        JSONArray optJSONArray14 = jSONObject.optJSONArray("endtime");
        JSONArray optJSONArray15 = jSONObject.optJSONArray("columncode");
        JSONArray optJSONArray16 = jSONObject.optJSONArray("terminalflags");
        JSONArray optJSONArray17 = jSONObject.optJSONArray("balance");
        JSONArray optJSONArray18 = jSONObject.optJSONArray(ParamConst.AUTH_RSP_RESERVE1);
        JSONArray optJSONArray19 = jSONObject.optJSONArray(ParamConst.AUTH_RSP_PURCHASEPHONE);
        JSONArray optJSONArray20 = jSONObject.optJSONArray("prevuename");
        JSONArray optJSONArray21 = jSONObject.optJSONArray(ParamConst.AUTH_RSP_PREVIEWSTARTTIME);
        JSONArray optJSONArray22 = jSONObject.optJSONArray(ParamConst.AUTH_RSP_PREVIEWENDTIME);
        JSONArray optJSONArray23 = jSONObject.optJSONArray(ParamConst.AUTH_RSP_EFFECTTIME);
        JSONArray optJSONArray24 = jSONObject.optJSONArray("billdate");
        JSONArray optJSONArray25 = jSONObject.optJSONArray(ParamConst.AUTH_RSP_USERSCENETYPE);
        JSONArray optJSONArray26 = jSONObject.optJSONArray(ParamConst.AUTH_RSP_CHARGETYPE);
        JSONArray optJSONArray27 = jSONObject.optJSONArray("ordertype");
        JSONArray optJSONArray28 = jSONObject.optJSONArray(ParamConst.AUTH_RSP_AREATYPE);
        JSONArray optJSONArray29 = jSONObject.optJSONArray(ParamConst.AUTH_RSP_FAVOURABLEFEE);
        int intValue = Integer.valueOf(optString).intValue();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < intValue) {
            int i2 = intValue;
            Product product = new Product();
            JSONArray jSONArray = optJSONArray29;
            product.productcode = a(optJSONArray, i);
            product.productname = a(optJSONArray2, i);
            product.fee = a(optJSONArray3, i);
            product.purchasetype = a(optJSONArray4, i);
            product.productdesc = a(optJSONArray5, i);
            product.listprice = a(optJSONArray6, i);
            product.rentalterm = a(optJSONArray7, i);
            product.rentalunit = a(optJSONArray8, i);
            product.limittimes = a(optJSONArray9, i);
            product.autocontinueoption = a(optJSONArray10, i);
            product.contentcode = a(optJSONArray11, i);
            product.servicecode = a(optJSONArray12, i);
            JSONArray jSONArray2 = optJSONArray13;
            JSONArray jSONArray3 = optJSONArray;
            product.starttime = a(jSONArray2, i);
            JSONArray jSONArray4 = optJSONArray14;
            product.endtime = a(jSONArray4, i);
            JSONArray jSONArray5 = optJSONArray15;
            product.columncode = a(jSONArray5, i);
            JSONArray jSONArray6 = optJSONArray16;
            product.terminalflags = a(jSONArray6, i);
            JSONArray jSONArray7 = optJSONArray17;
            product.balance = a(jSONArray7, i);
            JSONArray jSONArray8 = optJSONArray18;
            product.reserve1 = a(jSONArray8, i);
            JSONArray jSONArray9 = optJSONArray19;
            product.purchasephone = a(jSONArray9, i);
            JSONArray jSONArray10 = optJSONArray20;
            product.prevueName = a(jSONArray10, i);
            JSONArray jSONArray11 = optJSONArray21;
            product.previewstarttime = a(jSONArray11, i);
            JSONArray jSONArray12 = optJSONArray22;
            product.previewendtime = a(jSONArray12, i);
            JSONArray jSONArray13 = optJSONArray23;
            product.effecttime = a(jSONArray13, i);
            JSONArray jSONArray14 = optJSONArray24;
            product.billdate = a(jSONArray14, i);
            JSONArray jSONArray15 = optJSONArray25;
            product.userscenetype = a(jSONArray15, i);
            JSONArray jSONArray16 = optJSONArray26;
            product.chargetype = a(jSONArray16, i);
            JSONArray jSONArray17 = optJSONArray27;
            product.ordertype = a(jSONArray17, i);
            JSONArray jSONArray18 = optJSONArray28;
            product.areatype = a(jSONArray18, i);
            optJSONArray29 = jSONArray;
            product.favourablefee = a(optJSONArray29, i);
            arrayList.add(product);
            i++;
            optJSONArray = jSONArray3;
            optJSONArray13 = jSONArray2;
            optJSONArray14 = jSONArray4;
            optJSONArray15 = jSONArray5;
            optJSONArray16 = jSONArray6;
            optJSONArray17 = jSONArray7;
            optJSONArray18 = jSONArray8;
            optJSONArray19 = jSONArray9;
            optJSONArray20 = jSONArray10;
            optJSONArray21 = jSONArray11;
            optJSONArray22 = jSONArray12;
            optJSONArray23 = jSONArray13;
            optJSONArray24 = jSONArray14;
            optJSONArray25 = jSONArray15;
            optJSONArray26 = jSONArray16;
            optJSONArray27 = jSONArray17;
            intValue = i2;
            optJSONArray28 = jSONArray18;
        }
        return arrayList;
    }

    private String a(JSONArray jSONArray, int i) {
        return jSONArray == null ? "" : jSONArray.optString(i);
    }
}
