package com.video.androidsdk.service.subscription;

import android.text.TextUtils;
import android.util.Log;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.util.LocalTimeUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKSubscriptionMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3747a;

    /* loaded from: classes.dex */
    public interface OnBingewatchingListReturnListener {
        void onBingewatchingListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnCheckBingewatchingReturnListener {
        void onCheckBingewatchingReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnCheckReminderReturnListener {
        void onCheckReminderReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnReminderListReturnListener {
        void onReminderListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnSetBingewatchingReturnListener {
        void onSetBingewatchingReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnSetReminderReturnListener {
        void onSetReminderReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnSetUpcomingReturnListener {
        void onSetUpcomingReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnUpcomingListReturnListener {
        void onUpcomingListReturn(String str, String str2, String str3);
    }

    private String a(String str) {
        String str2;
        if (str == null) {
            return str;
        }
        if (TextUtils.isEmpty(SDKMgr.getEPGCharset())) {
            str2 = "UTF-8";
        } else {
            str2 = SDKMgr.getEPGCharset();
            LogEx.d("SDKSubscriptionMgr", "set encoding by sdkmgr getepgcharset:" + str2);
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            LogEx.w("SDKSubscriptionMgr", str2 + " not support." + e.getMessage());
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            }
        }
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3747a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void checkBingewatching(HashMap<String, String> hashMap, final OnCheckBingewatchingReturnListener onCheckBingewatchingReturnListener) {
        if (onCheckBingewatchingReturnListener == null) {
            LogEx.w("SDKSubscriptionMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onCheckBingewatchingReturnListener.onCheckBingewatchingReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 5, 2)), "params is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.CHECK_BEINGWATCHING);
        if (TextUtils.isEmpty(hashMap.get("usercode"))) {
            sb.append("?usercode=" + a(SDKLoginMgr.getInstance().getUserID()));
        } else {
            sb.append("?usercode=" + a(hashMap.get("usercode")));
        }
        sb.append("&usertoken=" + a(SDKLoginMgr.getInstance().getUserInfo("UserToken")));
        sb.append("&");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3747a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.subscription.SDKSubscriptionMgr.7
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onCheckBingewatchingReturnListener.onCheckBingewatchingReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSubscriptionMgr", "JSONException occur");
                    onCheckBingewatchingReturnListener.onCheckBingewatchingReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 5, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSubscriptionMgr", "SDKNetHTTPRequest onFailReturn");
                onCheckBingewatchingReturnListener.onCheckBingewatchingReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 5, i % 1000)), str);
            }
        });
    }

    public void getBingewatchingList(HashMap<String, String> hashMap, final OnBingewatchingListReturnListener onBingewatchingListReturnListener) {
        if (onBingewatchingListReturnListener == null) {
            LogEx.w("SDKSubscriptionMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onBingewatchingListReturnListener.onBingewatchingListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 4, 2)), "params is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_BEINGWATCHING_LIST);
        if (TextUtils.isEmpty(hashMap.get("usercode"))) {
            sb.append("?usercode=" + a(SDKLoginMgr.getInstance().getUserID()));
        } else {
            sb.append("?usercode=" + a(hashMap.get("usercode")));
        }
        sb.append("&usertoken=" + a(SDKLoginMgr.getInstance().getUserInfo("UserToken")));
        if (!hashMap.containsKey("sorttype")) {
            sb.append("&sorttype=1");
        }
        sb.append("&");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3747a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.subscription.SDKSubscriptionMgr.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onBingewatchingListReturnListener.onBingewatchingListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSubscriptionMgr", "JSONException occur");
                    onBingewatchingListReturnListener.onBingewatchingListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 4, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSubscriptionMgr", "SDKNetHTTPRequest onFailReturn");
                onBingewatchingListReturnListener.onBingewatchingListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 4, i % 1000)), str, null);
            }
        });
    }

    public void getReminderList(HashMap<String, String> hashMap, final OnReminderListReturnListener onReminderListReturnListener) {
        if (onReminderListReturnListener == null) {
            LogEx.w("SDKSubscriptionMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onReminderListReturnListener.onReminderListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 7, 2)), "params is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_REMINDER_LIST);
        if (TextUtils.isEmpty(hashMap.get("usercode"))) {
            sb.append("?usercode=" + a(SDKLoginMgr.getInstance().getUserID()));
        } else {
            sb.append("?usercode=" + a(hashMap.get("usercode")));
        }
        sb.append("&usertoken=" + a(SDKLoginMgr.getInstance().getUserInfo("UserToken")));
        if (!hashMap.containsKey("sorttype")) {
            sb.append("&sorttype=1");
        }
        sb.append("&");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3747a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.subscription.SDKSubscriptionMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onReminderListReturnListener.onReminderListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSubscriptionMgr", "JSONException occur");
                    onReminderListReturnListener.onReminderListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 7, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSubscriptionMgr", "SDKNetHTTPRequest onFailReturn");
                onReminderListReturnListener.onReminderListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 7, i % 1000)), str, null);
            }
        });
    }

    public void getUpcomingList(HashMap<String, String> hashMap, final OnUpcomingListReturnListener onUpcomingListReturnListener) {
        if (onUpcomingListReturnListener == null) {
            LogEx.w("SDKSubscriptionMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onUpcomingListReturnListener.onUpcomingListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 2, 2)), "params is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_UPCOMING_LIST);
        if (TextUtils.isEmpty(hashMap.get("usercode"))) {
            sb.append("?usercode=" + a(SDKLoginMgr.getInstance().getUserID()));
        } else {
            sb.append("?usercode=" + a(hashMap.get("usercode")));
        }
        sb.append("&usertoken=" + a(SDKLoginMgr.getInstance().getUserInfo("UserToken")));
        if (!hashMap.containsKey("sorttype")) {
            sb.append("&sorttype=1");
        }
        sb.append("&");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3747a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.subscription.SDKSubscriptionMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUpcomingListReturnListener.onUpcomingListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSubscriptionMgr", "JSONException occur");
                    onUpcomingListReturnListener.onUpcomingListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSubscriptionMgr", "SDKNetHTTPRequest onFailReturn");
                onUpcomingListReturnListener.onUpcomingListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void setBingewatching(HashMap<String, String> hashMap, final OnSetBingewatchingReturnListener onSetBingewatchingReturnListener) {
        if (onSetBingewatchingReturnListener == null) {
            LogEx.w("SDKSubscriptionMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onSetBingewatchingReturnListener.onSetBingewatchingReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 3, 2)), "params is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.DO_SET_BINGWATCHING);
        if (TextUtils.isEmpty(hashMap.get("usercode"))) {
            sb.append("?usercode=" + a(SDKLoginMgr.getInstance().getUserID()));
        } else {
            sb.append("?usercode=" + a(hashMap.get("usercode")));
        }
        sb.append("&usertoken=" + a(SDKLoginMgr.getInstance().getUserInfo("UserToken")));
        sb.append("&");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3747a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.subscription.SDKSubscriptionMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onSetBingewatchingReturnListener.onSetBingewatchingReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSubscriptionMgr", "JSONException occur");
                    onSetBingewatchingReturnListener.onSetBingewatchingReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 3, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSubscriptionMgr", "SDKNetHTTPRequest onFailReturn");
                onSetBingewatchingReturnListener.onSetBingewatchingReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 3, i % 1000)), str);
            }
        });
    }

    public void setReminder(HashMap<String, String> hashMap, final OnSetReminderReturnListener onSetReminderReturnListener) {
        if (onSetReminderReturnListener == null) {
            LogEx.w("SDKSubscriptionMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onSetReminderReturnListener.onSetReminderReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 6, 2)), "params is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.DO_REMINDER_SET);
        if (TextUtils.isEmpty(hashMap.get("usercode"))) {
            sb.append("?usercode=" + a(SDKLoginMgr.getInstance().getUserID()));
        } else {
            sb.append("?usercode=" + a(hashMap.get("usercode")));
        }
        sb.append("&usertoken=" + a(SDKLoginMgr.getInstance().getUserInfo("UserToken")));
        sb.append("&");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            try {
                if ("begintime".equals(key)) {
                    value = LocalTimeUtil.transformTimeFormat(value, "yyyyMMddHHmmss");
                }
            } catch (Exception e) {
                Log.e("SDKSubscriptionMgr", e.getMessage());
            }
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3747a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.subscription.SDKSubscriptionMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("returncode");
                    String optString2 = jSONObject.optString("errormsg");
                    if (onSetReminderReturnListener != null) {
                        onSetReminderReturnListener.onSetReminderReturn(optString, optString2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKSubscriptionMgr", "JSONException occur");
                    OnSetReminderReturnListener onSetReminderReturnListener2 = onSetReminderReturnListener;
                    if (onSetReminderReturnListener2 != null) {
                        onSetReminderReturnListener2.onSetReminderReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 6, 202)), "JSONException occur");
                    }
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSubscriptionMgr", "SDKNetHTTPRequest onFailReturn");
                OnSetReminderReturnListener onSetReminderReturnListener2 = onSetReminderReturnListener;
                if (onSetReminderReturnListener2 != null) {
                    onSetReminderReturnListener2.onSetReminderReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 6, i % 1000)), str);
                }
            }
        });
    }

    public void setUpcoming(HashMap<String, String> hashMap, final OnSetUpcomingReturnListener onSetUpcomingReturnListener) {
        if (onSetUpcomingReturnListener == null) {
            LogEx.w("SDKSubscriptionMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onSetUpcomingReturnListener.onSetUpcomingReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 1, 2)), "params is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.DO_UPCOMING_SET);
        if (TextUtils.isEmpty(hashMap.get("usercode"))) {
            sb.append("?usercode=" + a(hashMap.get("usercode")));
        } else {
            sb.append("?usercode=" + a(SDKLoginMgr.getInstance().getUserID()));
        }
        sb.append("&usertoken=" + a(SDKLoginMgr.getInstance().getUserInfo("UserToken")));
        sb.append("&");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3747a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.subscription.SDKSubscriptionMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onSetUpcomingReturnListener.onSetUpcomingReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSubscriptionMgr", "JSONException occur");
                    onSetUpcomingReturnListener.onSetUpcomingReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 1, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSubscriptionMgr", "SDKNetHTTPRequest onFailReturn");
                onSetUpcomingReturnListener.onSetUpcomingReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SUBSCRIPTION_MODELCODE, 1, i % 1000)), str);
            }
        });
    }
}
