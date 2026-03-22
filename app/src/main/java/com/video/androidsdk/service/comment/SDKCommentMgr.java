package com.video.androidsdk.service.comment;

import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.license.a;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKCommentMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3583a;

    /* loaded from: classes.dex */
    public interface OnAddCommentsReturnListener {
        void onAddCommentsReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnDelCommentsReturnListener {
        void onDelCommentsReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnEnabledCommentsReturnListener {
        void onEnabledCommentsReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetCommentsReturnListener {
        void onGetCommentsReturn(String str, String str2, String str3);
    }

    public void addComments(AddCommentsReq addCommentsReq, final OnAddCommentsReturnListener onAddCommentsReturnListener) {
        if (onAddCommentsReturnListener == null) {
            LogEx.w("SDKCommentMgr", "listener is null");
            return;
        }
        if (addCommentsReq == null) {
            onAddCommentsReturnListener.onAddCommentsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMENT_MODELCODE, 2, 2)), "req is null");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(SDKLoginMgr.getInstance().getFrameHome());
        stringBuffer.append(HttpUrlConstants.ADD_COMMENTS);
        HashMap<String, String> hashMap = addCommentsReq.toHashMap();
        stringBuffer.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            stringBuffer.append((Object) key);
            stringBuffer.append("=");
            stringBuffer.append((Object) value);
            stringBuffer.append("&");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3583a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(stringBuffer.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.comment.SDKCommentMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onAddCommentsReturnListener.onAddCommentsReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    onAddCommentsReturnListener.onAddCommentsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMENT_MODELCODE, 2, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onAddCommentsReturnListener.onAddCommentsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMENT_MODELCODE, 2, i % 1000)), str);
            }
        });
    }

    public void delComments(DelCommentsReq delCommentsReq, final OnDelCommentsReturnListener onDelCommentsReturnListener) {
        if (onDelCommentsReturnListener == null) {
            LogEx.w("SDKCommentMgr", "listener is null");
            return;
        }
        if (delCommentsReq == null) {
            onDelCommentsReturnListener.onDelCommentsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMENT_MODELCODE, 3, 2)), "req is null");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(SDKLoginMgr.getInstance().getFrameHome());
        stringBuffer.append(HttpUrlConstants.DEL_COMMENTS);
        HashMap<String, String> hashMap = delCommentsReq.toHashMap();
        stringBuffer.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            stringBuffer.append((Object) key);
            stringBuffer.append("=");
            stringBuffer.append((Object) value);
            stringBuffer.append("&");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3583a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(stringBuffer.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.comment.SDKCommentMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onDelCommentsReturnListener.onDelCommentsReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    onDelCommentsReturnListener.onDelCommentsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMENT_MODELCODE, 3, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onDelCommentsReturnListener.onDelCommentsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMENT_MODELCODE, 3, i % 1000)), str);
            }
        });
    }

    public void enabledComments(final OnEnabledCommentsReturnListener onEnabledCommentsReturnListener) {
        if (onEnabledCommentsReturnListener == null) {
            LogEx.w("SDKCommentMgr", "listener is null");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(SDKLoginMgr.getInstance().getFrameHome());
        stringBuffer.append(HttpUrlConstants.ENABLED_COMMENTS);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3583a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(stringBuffer.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.comment.SDKCommentMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onEnabledCommentsReturnListener.onEnabledCommentsReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    onEnabledCommentsReturnListener.onEnabledCommentsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMENT_MODELCODE, 3, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onEnabledCommentsReturnListener.onEnabledCommentsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMENT_MODELCODE, 3, i % 1000)), str, null);
            }
        });
    }

    public void getComments(GetCommentsReq getCommentsReq, final OnGetCommentsReturnListener onGetCommentsReturnListener) {
        if (onGetCommentsReturnListener == null) {
            LogEx.w("SDKCommentMgr", "listener is null");
            return;
        }
        if (getCommentsReq == null) {
            onGetCommentsReturnListener.onGetCommentsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMENT_MODELCODE, 1, 2)), "req is null", null);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(SDKLoginMgr.getInstance().getFrameHome());
        stringBuffer.append(HttpUrlConstants.QUERY_COMMENTS);
        HashMap<String, String> hashMap = getCommentsReq.toHashMap();
        stringBuffer.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            stringBuffer.append((Object) key);
            stringBuffer.append("=");
            stringBuffer.append((Object) value);
            stringBuffer.append("&");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3583a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(stringBuffer.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.comment.SDKCommentMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("returncode");
                    String optString2 = jSONObject.optString("errormsg");
                    String a2 = a.a("commentkey");
                    try {
                        JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                                String aesDecode = AES.aesDecode(jSONObject2.optString("usercode"), a2.getBytes());
                                jSONObject2.remove("usercode");
                                jSONObject2.put("usercode", aesDecode);
                                optJSONArray.put(i, jSONObject2);
                            }
                            jSONObject.remove("data");
                            jSONObject.put("data", optJSONArray);
                        }
                        LogEx.d("SDKCommentMgr", "data is  " + jSONObject);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        onGetCommentsReturnListener.onGetCommentsReturn(optString, optString2, str);
                    }
                    onGetCommentsReturnListener.onGetCommentsReturn(optString, optString2, jSONObject.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    onGetCommentsReturnListener.onGetCommentsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMENT_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onGetCommentsReturnListener.onGetCommentsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_COMMENT_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }
}
