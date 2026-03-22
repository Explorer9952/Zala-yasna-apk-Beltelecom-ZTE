package com.video.androidsdk.service.vod;

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
public class SDKVodMgr4CELLC {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3804a;

    /* loaded from: classes.dex */
    public interface OnColumnContentReturnListener {
        void onColumnContentReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnFirstContentListReturnListener {
        void onFirstContentListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnProductContentReturnListener {
        void onProductContentReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnUniqueVodListReturnListener {
        void onUniqueVodListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3804a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void getColumnContent(HashMap<String, String> hashMap, final OnColumnContentReturnListener onColumnContentReturnListener) {
        if (hashMap != null && onColumnContentReturnListener != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(SDKLoginMgr.getInstance().getFrameHome());
            sb.append(HttpUrlConstants.CELLC_GET_CONTENTS);
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
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            this.f3804a = sDKNetHTTPRequest;
            sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
            sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr4CELLC.2
                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onDataReturn(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        onColumnContentReturnListener.onColumnContentReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        LogEx.w("SDKVodMgr4CELLC", "JSONException occur");
                        onColumnContentReturnListener.onColumnContentReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 202)), "JSONException occur", null);
                    }
                }

                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onFailReturn(int i, String str) {
                    LogEx.w("SDKVodMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                    onColumnContentReturnListener.onColumnContentReturn(String.valueOf(i), str, null);
                }
            });
            return;
        }
        LogEx.w("SDKVodMgr4CELLC", "param is null or listener is null");
    }

    public void getFirstContentList(HashMap<String, String> hashMap, final OnFirstContentListReturnListener onFirstContentListReturnListener) {
        if (hashMap != null && onFirstContentListReturnListener != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(SDKLoginMgr.getInstance().getFrameHome());
            sb.append(HttpUrlConstants.CELLC_GET_HOME_CONTENTS);
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
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            this.f3804a = sDKNetHTTPRequest;
            sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
            sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr4CELLC.1
                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onDataReturn(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        onFirstContentListReturnListener.onFirstContentListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        LogEx.w("SDKVodMgr4CELLC", "JSONException occur");
                        onFirstContentListReturnListener.onFirstContentListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 202)), "JSONException occur", null);
                    }
                }

                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onFailReturn(int i, String str) {
                    LogEx.w("SDKVodMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                    onFirstContentListReturnListener.onFirstContentListReturn(String.valueOf(i), str, null);
                }
            });
            return;
        }
        LogEx.w("SDKVodMgr4CELLC", "param is null or listener is null");
    }

    public void getProductContent(HashMap<String, String> hashMap, final OnProductContentReturnListener onProductContentReturnListener) {
        if (hashMap != null && onProductContentReturnListener != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(SDKLoginMgr.getInstance().getFrameHome());
            sb.append("sdk_getmoviebyproduct.jsp");
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
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            this.f3804a = sDKNetHTTPRequest;
            sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
            sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr4CELLC.3
                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onDataReturn(String str) {
                    onProductContentReturnListener.onProductContentReturn("0", "", str);
                }

                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onFailReturn(int i, String str) {
                    LogEx.w("SDKVodMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                    onProductContentReturnListener.onProductContentReturn(String.valueOf(i), str, null);
                }
            });
            return;
        }
        LogEx.w("SDKVodMgr4CELLC", "param is null or listener is null");
    }

    public void getUniqueVodList(HashMap<String, String> hashMap, final OnUniqueVodListReturnListener onUniqueVodListReturnListener) {
        if (hashMap != null && onUniqueVodListReturnListener != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(SDKLoginMgr.getInstance().getFrameHome());
            sb.append(HttpUrlConstants.CELLC_GET_UNIQUE_VOD_LIST);
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
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            this.f3804a = sDKNetHTTPRequest;
            sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
            sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.vod.SDKVodMgr4CELLC.4
                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onDataReturn(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        onUniqueVodListReturnListener.onUniqueVodListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        LogEx.w("SDKVodMgr4CELLC", "JSONException occur");
                        onUniqueVodListReturnListener.onUniqueVodListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 202)), "JSONException occur", null);
                    }
                }

                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onFailReturn(int i, String str) {
                    LogEx.w("SDKVodMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                    onUniqueVodListReturnListener.onUniqueVodListReturn(String.valueOf(i), str, null);
                }
            });
            return;
        }
        LogEx.w("SDKVodMgr4CELLC", "param is null or listener is null");
    }
}
