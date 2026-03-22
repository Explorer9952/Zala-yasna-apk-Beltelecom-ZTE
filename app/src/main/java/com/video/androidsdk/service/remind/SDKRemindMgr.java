package com.video.androidsdk.service.remind;

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
public class SDKRemindMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3728a;

    /* loaded from: classes.dex */
    public interface OnAddRemindReturnListener {
        void onAddRemindReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnCheckIsRemindedReturnListener {
        void onCheckIsRemindedReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnDelRemindReturnListener {
        void onDelRemindReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnUserRemindListReturnListener {
        void onUserRemindListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3728a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void checkIsReminded(HashMap<String, String> hashMap, final OnCheckIsRemindedReturnListener onCheckIsRemindedReturnListener) {
        if (onCheckIsRemindedReturnListener == null) {
            LogEx.w("SDKRemindMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.CHECK_IS_REMINDED);
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
        this.f3728a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.remind.SDKRemindMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d("SDKRemindMgr", "SDKNetHTTPRequest onDataReturn:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onCheckIsRemindedReturnListener.onCheckIsRemindedReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKRemindMgr", "JSONException occur");
                    onCheckIsRemindedReturnListener.onCheckIsRemindedReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_REMIND_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKRemindMgr", "SDKNetHTTPRequest onFailReturn");
                onCheckIsRemindedReturnListener.onCheckIsRemindedReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_REMIND_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void doAddRemind(HashMap<String, String> hashMap, final OnAddRemindReturnListener onAddRemindReturnListener) {
        if (onAddRemindReturnListener == null) {
            LogEx.w("SDKRemindMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_ADD_REMIND);
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
        this.f3728a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.remind.SDKRemindMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d("SDKRemindMgr", "SDKNetHTTPRequest onDataReturn:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onAddRemindReturnListener.onAddRemindReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKRemindMgr", "JSONException occur");
                    onAddRemindReturnListener.onAddRemindReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_REMIND_MODELCODE, 3, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKRemindMgr", "SDKNetHTTPRequest onFailReturn");
                onAddRemindReturnListener.onAddRemindReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_REMIND_MODELCODE, 3, i % 1000)), str);
            }
        });
    }

    public void doDelRemind(HashMap<String, String> hashMap, final OnDelRemindReturnListener onDelRemindReturnListener) {
        if (onDelRemindReturnListener == null) {
            LogEx.w("SDKRemindMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_DEL_REMIND);
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
        this.f3728a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.remind.SDKRemindMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d("SDKRemindMgr", "SDKNetHTTPRequest onDataReturn:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onDelRemindReturnListener.onDelRemindReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKRemindMgr", "JSONException occur");
                    onDelRemindReturnListener.onDelRemindReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_REMIND_MODELCODE, 4, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKRemindMgr", "SDKNetHTTPRequest onFailReturn");
                onDelRemindReturnListener.onDelRemindReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_REMIND_MODELCODE, 4, i % 1000)), str);
            }
        });
    }

    public void getUserRemindList(HashMap<String, String> hashMap, final OnUserRemindListReturnListener onUserRemindListReturnListener) {
        if (onUserRemindListReturnListener == null) {
            LogEx.w("SDKRemindMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_USER_REMIND_LIST);
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
        this.f3728a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.remind.SDKRemindMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d("SDKRemindMgr", "SDKNetHTTPRequest onDataReturn:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUserRemindListReturnListener.onUserRemindListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKRemindMgr", "JSONException occur");
                    onUserRemindListReturnListener.onUserRemindListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_REMIND_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKRemindMgr", "SDKNetHTTPRequest onFailReturn");
                onUserRemindListReturnListener.onUserRemindListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_REMIND_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }
}
