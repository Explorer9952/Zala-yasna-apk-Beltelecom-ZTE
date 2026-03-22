package com.video.androidsdk.service.lock;

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
public class SDKLockMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3641a;

    /* loaded from: classes.dex */
    public interface OnAddLockReturnListener {
        void onAddLockReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnCheckIsLockedReturnListener {
        void onCheckIsLockedReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnClearUserLockListReturnListener {
        void onClearUserLockListReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnDelLockReturnListener {
        void onDelLockReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnUserLockListReturnListener {
        void onUserLockMarkListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3641a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void checkIsLocked(HashMap<String, String> hashMap, final OnCheckIsLockedReturnListener onCheckIsLockedReturnListener) {
        if (onCheckIsLockedReturnListener == null) {
            LogEx.w("SDKLockMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.CHECK_ISLOCKED);
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
        this.f3641a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.lock.SDKLockMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onCheckIsLockedReturnListener.onCheckIsLockedReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKLockMgr", "JSONException occur");
                    onCheckIsLockedReturnListener.onCheckIsLockedReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOCK_MODELCODE, 2, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKLockMgr", "SDKNetHTTPRequest onFailReturn");
                onCheckIsLockedReturnListener.onCheckIsLockedReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOCK_MODELCODE, 2, i % 1000)), str);
            }
        });
    }

    public void clearUserLockList(HashMap<String, String> hashMap, final OnClearUserLockListReturnListener onClearUserLockListReturnListener) {
        if (onClearUserLockListReturnListener == null) {
            LogEx.w("SDKLockMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.DO_CLEAR_LOCK);
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
        this.f3641a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.lock.SDKLockMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onClearUserLockListReturnListener.onClearUserLockListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKLockMgr", "JSONException occur");
                    onClearUserLockListReturnListener.onClearUserLockListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOCK_MODELCODE, 5, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKLockMgr", "SDKNetHTTPRequest onFailReturn");
                onClearUserLockListReturnListener.onClearUserLockListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOCK_MODELCODE, 5, i % 1000)), str);
            }
        });
    }

    public void doAddLock(HashMap<String, String> hashMap, final OnAddLockReturnListener onAddLockReturnListener) {
        if (onAddLockReturnListener == null) {
            LogEx.w("SDKLockMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_ADD_LOCK);
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
        this.f3641a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.lock.SDKLockMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onAddLockReturnListener.onAddLockReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKLockMgr", "JSONException occur");
                    onAddLockReturnListener.onAddLockReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOCK_MODELCODE, 3, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKLockMgr", "SDKNetHTTPRequest onFailReturn");
                onAddLockReturnListener.onAddLockReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOCK_MODELCODE, 3, i % 1000)), str);
            }
        });
    }

    public void doDelLock(HashMap<String, String> hashMap, final OnDelLockReturnListener onDelLockReturnListener) {
        if (onDelLockReturnListener == null) {
            LogEx.w("SDKLockMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_DEL_LOCK);
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
        this.f3641a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.lock.SDKLockMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onDelLockReturnListener.onDelLockReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKLockMgr", "JSONException occur");
                    onDelLockReturnListener.onDelLockReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOCK_MODELCODE, 4, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKLockMgr", "SDKNetHTTPRequest onFailReturn");
                onDelLockReturnListener.onDelLockReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOCK_MODELCODE, 4, i % 1000)), str);
            }
        });
    }

    public void getUserLockList(HashMap<String, String> hashMap, final OnUserLockListReturnListener onUserLockListReturnListener) {
        if (onUserLockListReturnListener == null) {
            LogEx.w("SDKLockMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_USER_LOCK_LIST);
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
        this.f3641a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.lock.SDKLockMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUserLockListReturnListener.onUserLockMarkListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKLockMgr", "JSONException occur");
                    onUserLockListReturnListener.onUserLockMarkListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOCK_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKLockMgr", "SDKNetHTTPRequest onFailReturn");
                onUserLockListReturnListener.onUserLockMarkListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOCK_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }
}
