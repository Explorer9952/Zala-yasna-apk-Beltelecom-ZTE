package com.video.androidsdk.service.channel;

import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKChannelMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3534a;

    /* loaded from: classes.dex */
    public interface OnAllChannelListReturnListener {
        void onAllChannelListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnChannelDetailReturnListener {
        void onChannelDetailReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnChannelDetailWithUrlReturnListener {
        void onChannelDetailWithUrlReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnChannelListReturnListener {
        void onChannelListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnChannelMosaicReturnListener {
        void onChannelMosaicReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnHotChannelReturnListener {
        void onHotChannelReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3534a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void getAllChannelList(final OnAllChannelListReturnListener onAllChannelListReturnListener) {
        if (onAllChannelListReturnListener == null) {
            LogEx.w("SDKChannelMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_ALL_CHANNEL_LIST);
        sb.append("?userid=" + SDKLoginMgr.getInstance().getUserID());
        sb.append("&usertoken=" + SDKLoginMgr.getInstance().getUserInfo("UserToken"));
        sb.append("&stbtype=2");
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3534a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.channel.SDKChannelMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onAllChannelListReturnListener.onAllChannelListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKChannelMgr", "JSONException occur");
                    onAllChannelListReturnListener.onAllChannelListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 4, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKChannelMgr", "SDKNetHTTPRequest onFailReturn");
                onAllChannelListReturnListener.onAllChannelListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 4, i % 1000)), str, null);
            }
        });
    }

    public void getChannelDetail(HashMap<String, String> hashMap, final OnChannelDetailReturnListener onChannelDetailReturnListener) {
        if (onChannelDetailReturnListener == null) {
            LogEx.w("SDKChannelMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKChannelMgr", "params == null");
            onChannelDetailReturnListener.onChannelDetailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 2, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_CHANNEL_DETAIL);
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
        this.f3534a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.channel.SDKChannelMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onChannelDetailReturnListener.onChannelDetailReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKChannelMgr", "JSONException occur");
                    onChannelDetailReturnListener.onChannelDetailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKChannelMgr", "SDKNetHTTPRequest onFailReturn");
                onChannelDetailReturnListener.onChannelDetailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void getChannelDetailWithURl(HashMap<String, String> hashMap, final OnChannelDetailWithUrlReturnListener onChannelDetailWithUrlReturnListener) {
        if (onChannelDetailWithUrlReturnListener == null) {
            LogEx.w("SDKChannelMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKChannelMgr", "params == null");
            onChannelDetailWithUrlReturnListener.onChannelDetailWithUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 3, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_CHANNEL_DETAIL);
        sb.append("?ischecksubscribe=1");
        sb.append("&");
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
        this.f3534a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.channel.SDKChannelMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d("SDKChannelMgr", "onDataReturn");
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onChannelDetailWithUrlReturnListener.onChannelDetailWithUrlReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKChannelMgr", "JSONException occur");
                    onChannelDetailWithUrlReturnListener.onChannelDetailWithUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 3, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKChannelMgr", "SDKNetHTTPRequest onFailReturn");
                onChannelDetailWithUrlReturnListener.onChannelDetailWithUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 3, i % 1000)), str, null);
            }
        });
    }

    public void getChannelList(HashMap<String, String> hashMap, final OnChannelListReturnListener onChannelListReturnListener) {
        if (onChannelListReturnListener == null) {
            LogEx.w("SDKChannelMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKChannelMgr", "params == null");
            onChannelListReturnListener.onChannelListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 1, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_CHANNEL_LIST);
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
        this.f3534a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.channel.SDKChannelMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onChannelListReturnListener.onChannelListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKChannelMgr", "JSONException occur");
                    onChannelListReturnListener.onChannelListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKChannelMgr", "SDKNetHTTPRequest onFailReturn");
                onChannelListReturnListener.onChannelListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }

    public void getChannelMosaic(HashMap<String, String> hashMap, final OnChannelMosaicReturnListener onChannelMosaicReturnListener) {
        if (onChannelMosaicReturnListener == null) {
            LogEx.w("SDKChannelMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKChannelMgr", "params == null");
            onChannelMosaicReturnListener.onChannelMosaicReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 5, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_CHANNEL_MOSAIC);
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
        this.f3534a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.channel.SDKChannelMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onChannelMosaicReturnListener.onChannelMosaicReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKChannelMgr", "JSONException occur");
                    onChannelMosaicReturnListener.onChannelMosaicReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 5, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKChannelMgr", "SDKNetHTTPRequest onFailReturn");
                onChannelMosaicReturnListener.onChannelMosaicReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 5, i % 1000)), str, null);
            }
        });
    }

    public void getHotChannel(HashMap<String, String> hashMap, final OnHotChannelReturnListener onHotChannelReturnListener) {
        if (onHotChannelReturnListener == null) {
            LogEx.w("SDKChannelMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKChannelMgr", "params == null");
            onHotChannelReturnListener.onHotChannelReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 6, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_HOT_CHANNEL);
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
        this.f3534a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.channel.SDKChannelMgr.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onHotChannelReturnListener.onHotChannelReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKChannelMgr", "JSONException occur");
                    onHotChannelReturnListener.onHotChannelReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 6, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKChannelMgr", "SDKNetHTTPRequest onFailReturn");
                onHotChannelReturnListener.onHotChannelReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CHANNEL_MODELCODE, 6, i % 1000)), str, null);
            }
        });
    }
}
