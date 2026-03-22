package com.video.androidsdk.service.bookmark;

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
public class SDKBookMarkMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3523a;

    /* loaded from: classes.dex */
    public interface OnAddBookMarkReturnListener {
        void onAddBookMarkReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnBookMarkReturnListener {
        void onBookMarkReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnDelBookMarkReturnListener {
        void onDelBookMarkReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnSTBBookMarkListReturnListener {
        void onSTBBookMarkListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnUserBookMarkListReturnListener {
        void onUserBookMarkListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3523a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void doAddBookMark(HashMap<String, String> hashMap, final OnAddBookMarkReturnListener onAddBookMarkReturnListener) {
        if (onAddBookMarkReturnListener == null) {
            LogEx.w("SDKBookMarkMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_ADD_BOOKMARK);
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
        this.f3523a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.bookmark.SDKBookMarkMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onAddBookMarkReturnListener.onAddBookMarkReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKBookMarkMgr", "JSONException occur");
                    onAddBookMarkReturnListener.onAddBookMarkReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BOOKMARK_MODELCODE, 3, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKBookMarkMgr", "SDKNetHTTPRequest onFailReturn");
                onAddBookMarkReturnListener.onAddBookMarkReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BOOKMARK_MODELCODE, 3, i % 1000)), str);
            }
        });
    }

    public void doDelBookMark(HashMap<String, String> hashMap, final OnDelBookMarkReturnListener onDelBookMarkReturnListener) {
        if (onDelBookMarkReturnListener == null) {
            LogEx.w("SDKBookMarkMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.DO_DEL_BOOKMARK);
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
        this.f3523a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.bookmark.SDKBookMarkMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onDelBookMarkReturnListener.onDelBookMarkReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKBookMarkMgr", "JSONException occur");
                    onDelBookMarkReturnListener.onDelBookMarkReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BOOKMARK_MODELCODE, 4, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKBookMarkMgr", "SDKNetHTTPRequest onFailReturn");
                onDelBookMarkReturnListener.onDelBookMarkReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BOOKMARK_MODELCODE, 4, i % 1000)), str);
            }
        });
    }

    public void getBookMark(HashMap<String, String> hashMap, final OnBookMarkReturnListener onBookMarkReturnListener) {
        if (onBookMarkReturnListener == null) {
            LogEx.w("SDKBookMarkMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_USER_BOOKMARK);
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
        this.f3523a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.bookmark.SDKBookMarkMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onBookMarkReturnListener.onBookMarkReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKBookMarkMgr", "JSONException occur");
                    onBookMarkReturnListener.onBookMarkReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BOOKMARK_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKBookMarkMgr", "SDKNetHTTPRequest onFailReturn");
                onBookMarkReturnListener.onBookMarkReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BOOKMARK_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void getSTBBookMarkList(GetSTBBookMarkListReq getSTBBookMarkListReq, final OnSTBBookMarkListReturnListener onSTBBookMarkListReturnListener) {
        if (onSTBBookMarkListReturnListener == null) {
            LogEx.w("SDKBookMarkMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_STB_BOOKMARK_LIST);
        if (getSTBBookMarkListReq != null) {
            HashMap<String, String> hashMap = getSTBBookMarkListReq.toHashMap();
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
        this.f3523a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.bookmark.SDKBookMarkMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onSTBBookMarkListReturnListener.onSTBBookMarkListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKBookMarkMgr", "JSONException occur");
                    onSTBBookMarkListReturnListener.onSTBBookMarkListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BOOKMARK_MODELCODE, 5, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKBookMarkMgr", "SDKNetHTTPRequest onFailReturn");
                onSTBBookMarkListReturnListener.onSTBBookMarkListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BOOKMARK_MODELCODE, 5, i % 1000)), str, null);
            }
        });
    }

    public void getUserBookMarkList(HashMap<String, String> hashMap, final OnUserBookMarkListReturnListener onUserBookMarkListReturnListener) {
        if (onUserBookMarkListReturnListener == null) {
            LogEx.w("SDKBookMarkMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_USER_BOOKMARK_LIST);
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
        this.f3523a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.bookmark.SDKBookMarkMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUserBookMarkListReturnListener.onUserBookMarkListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKBookMarkMgr", "JSONException occur");
                    onUserBookMarkListReturnListener.onUserBookMarkListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BOOKMARK_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKBookMarkMgr", "SDKNetHTTPRequest onFailReturn");
                onUserBookMarkListReturnListener.onUserBookMarkListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BOOKMARK_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }
}
