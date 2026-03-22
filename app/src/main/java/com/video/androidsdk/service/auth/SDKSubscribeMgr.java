package com.video.androidsdk.service.auth;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.bean.SubscribeInfo;
import com.video.androidsdk.service.bean.SubscribeReq;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKSubscribeMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3493a;

    /* loaded from: classes.dex */
    public interface OnDoSubscribeReturnListener {
        void onDoSubscribeReturn(String str, String str2, SubscribeInfo subscribeInfo);
    }

    /* loaded from: classes.dex */
    public interface OnGetSubscribeChannelReturnListener {
        void onGetSubscribeChannelReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnProdContentListReturnListener {
        void onProdContentListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnUserConsumeListReturnListener {
        void onUserConsumeListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnUserOrderListReturnListener {
        void onUserOrderListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnUserProductListReturnListener {
        void onUserProductListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3493a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void doSubscribe(SubscribeReq subscribeReq, final OnDoSubscribeReturnListener onDoSubscribeReturnListener) {
        if (onDoSubscribeReturnListener == null) {
            LogEx.w("SDKSubscribeMgr", "OnDoSubscribeReturnListener is null");
            return;
        }
        if (subscribeReq == null) {
            LogEx.w("SDKSubscribeMgr", "SubscribeReq is null");
            onDoSubscribeReturnListener.onDoSubscribeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 3, 2)), "SubscribeReq is null", null);
            return;
        }
        this.f3493a = new SDKNetHTTPRequest();
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        this.f3493a.setHeader("Cookie", "JSESSIONID=" + hTTPSessionID);
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_SUBSCRIBE);
        HashMap<String, String> hashMap = subscribeReq.toHashMap();
        if (hashMap != null) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (TextUtils.equals(String.valueOf(key), "recommendtype")) {
                    if (TextUtils.equals("1", hashMap.get("action")) && !TextUtils.isEmpty(String.valueOf(value))) {
                        sb.append((Object) key);
                        sb.append("=");
                        sb.append((Object) value);
                        sb.append("&");
                    }
                } else {
                    sb.append((Object) key);
                    sb.append("=");
                    sb.append((Object) value);
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        this.f3493a.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.auth.SDKSubscribeMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    SubscribeInfo subscribeInfo = (SubscribeInfo) new Gson().fromJson(str, SubscribeInfo.class);
                    String valueOf = String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 3, 5));
                    String str2 = ErrMessage.GET_DATA_FAILED;
                    if (subscribeInfo != null) {
                        valueOf = subscribeInfo.getReturncode();
                        str2 = subscribeInfo.getErrormsg();
                    }
                    onDoSubscribeReturnListener.onDoSubscribeReturn(valueOf, str2, subscribeInfo);
                } catch (JsonParseException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSubscribeMgr", "json parse exception");
                    onDoSubscribeReturnListener.onDoSubscribeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 3, 202)), "json parse error", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onDoSubscribeReturnListener.onDoSubscribeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 3, i % 1000)), str, null);
            }
        });
    }

    public void getProdContentList(HashMap<String, String> hashMap, final OnProdContentListReturnListener onProdContentListReturnListener) {
        if (onProdContentListReturnListener == null) {
            LogEx.w("SDKSubscribeMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append("sdk_getmoviebyproduct.jsp");
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
        this.f3493a = new SDKNetHTTPRequest();
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        this.f3493a.setHeader("Cookie", "JSESSIONID=" + hTTPSessionID);
        this.f3493a.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.auth.SDKSubscribeMgr.7
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    onProdContentListReturnListener.onProdContentListReturn(new JSONArray(str).length() > 0 ? "0" : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSubscribeMgr", "JSONException occur");
                    onProdContentListReturnListener.onProdContentListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 8, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSubscribeMgr", "SDKNetHTTPRequest onFailReturn");
                onProdContentListReturnListener.onProdContentListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 8, i % 1000)), str, null);
            }
        });
    }

    public void getSubscribeChannel(final OnGetSubscribeChannelReturnListener onGetSubscribeChannelReturnListener) {
        if (onGetSubscribeChannelReturnListener == null) {
            LogEx.w("SDKSubscribeMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_SUBSCRIBE_CHANNEL);
        this.f3493a = new SDKNetHTTPRequest();
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        this.f3493a.setHeader("Cookie", "JSESSIONID=" + hTTPSessionID);
        this.f3493a.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.auth.SDKSubscribeMgr.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onGetSubscribeChannelReturnListener.onGetSubscribeChannelReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSubscribeMgr", "JSONException occur");
                    onGetSubscribeChannelReturnListener.onGetSubscribeChannelReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 7, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSubscribeMgr", "SDKNetHTTPRequest onFailReturn");
                onGetSubscribeChannelReturnListener.onGetSubscribeChannelReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 7, i % 1000)), str, null);
            }
        });
    }

    public void getUseProductList(HashMap<String, String> hashMap, final OnUserProductListReturnListener onUserProductListReturnListener) {
        if (onUserProductListReturnListener == null) {
            LogEx.w("SDKSubscribeMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_USER_PRODUCTLIST);
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
        this.f3493a = new SDKNetHTTPRequest();
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        this.f3493a.setHeader("Cookie", "JSESSIONID=" + hTTPSessionID);
        this.f3493a.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.auth.SDKSubscribeMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUserProductListReturnListener.onUserProductListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSubscribeMgr", "JSONException occur");
                    onUserProductListReturnListener.onUserProductListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 6, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSubscribeMgr", "SDKNetHTTPRequest onFailReturn");
                onUserProductListReturnListener.onUserProductListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 6, i % 1000)), str, null);
            }
        });
    }

    public void getUserConsumeList(HashMap<String, String> hashMap, final OnUserConsumeListReturnListener onUserConsumeListReturnListener) {
        if (onUserConsumeListReturnListener == null) {
            LogEx.w("SDKSubscribeMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_USER_CONSUMELIST);
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
        this.f3493a = new SDKNetHTTPRequest();
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        this.f3493a.setHeader("Cookie", "JSESSIONID=" + hTTPSessionID);
        this.f3493a.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.auth.SDKSubscribeMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUserConsumeListReturnListener.onUserConsumeListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSubscribeMgr", "JSONException occur");
                    onUserConsumeListReturnListener.onUserConsumeListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 4, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSubscribeMgr", "SDKNetHTTPRequest onFailReturn");
                onUserConsumeListReturnListener.onUserConsumeListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 4, i % 1000)), str, null);
            }
        });
    }

    public void getUserOrderList(HashMap<String, String> hashMap, final OnUserOrderListReturnListener onUserOrderListReturnListener) {
        if (onUserOrderListReturnListener == null) {
            LogEx.w("SDKSubscribeMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_USER_ORDERLIST);
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
        this.f3493a = new SDKNetHTTPRequest();
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        this.f3493a.setHeader("Cookie", "JSESSIONID=" + hTTPSessionID);
        this.f3493a.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.auth.SDKSubscribeMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUserOrderListReturnListener.onUserOrderListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSubscribeMgr", "JSONException occur");
                    onUserOrderListReturnListener.onUserOrderListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 5, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSubscribeMgr", "SDKNetHTTPRequest onFailReturn");
                onUserOrderListReturnListener.onUserOrderListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 5, i % 1000)), str, null);
            }
        });
    }

    public void subscribe(SubscribeReq subscribeReq, final OnDoSubscribeReturnListener onDoSubscribeReturnListener) {
        if (onDoSubscribeReturnListener == null) {
            LogEx.w("SDKSubscribeMgr", "OnDoSubscribeReturnListener is null");
            return;
        }
        if (subscribeReq == null) {
            LogEx.w("SDKSubscribeMgr", "SubscribeReq is null");
            onDoSubscribeReturnListener.onDoSubscribeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 10, 2)), "SubscribeReq is null", null);
            return;
        }
        this.f3493a = new SDKNetHTTPRequest();
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        this.f3493a.setHeader("Cookie", "JSESSIONID=" + hTTPSessionID);
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.SUBSCRIBE);
        HashMap<String, String> hashMap = subscribeReq.toHashMap();
        if (hashMap != null) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (TextUtils.equals(String.valueOf(key), "recommendtype")) {
                    if (TextUtils.equals("1", hashMap.get("action")) && !TextUtils.isEmpty(String.valueOf(value))) {
                        sb.append((Object) key);
                        sb.append("=");
                        sb.append((Object) value);
                        sb.append("&");
                    }
                } else {
                    sb.append((Object) key);
                    sb.append("=");
                    sb.append((Object) value);
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3493a;
        sDKNetHTTPRequest.startRequest(sDKNetHTTPRequest.replaceFrame(sb.toString()), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.auth.SDKSubscribeMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    SubscribeInfo subscribeInfo = (SubscribeInfo) new Gson().fromJson(str, SubscribeInfo.class);
                    String valueOf = String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 3, 5));
                    String str2 = ErrMessage.GET_DATA_FAILED;
                    if (subscribeInfo != null) {
                        valueOf = subscribeInfo.getReturncode();
                        str2 = subscribeInfo.getErrormsg();
                    }
                    onDoSubscribeReturnListener.onDoSubscribeReturn(valueOf, str2, subscribeInfo);
                } catch (JsonParseException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSubscribeMgr", "json parse exception");
                    onDoSubscribeReturnListener.onDoSubscribeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 10, 202)), "json parse error", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onDoSubscribeReturnListener.onDoSubscribeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_AUTH_ORDER_MODELCODE, 10, i % 1000)), str, null);
            }
        });
    }
}
