package com.video.androidsdk.service.blackout;

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
public class SDKBlackoutMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3514a;

    /* loaded from: classes.dex */
    public interface OnGetChannelByGeoReturnListener {
        void onGetChannelByGeoReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetChannelReturnListener {
        void onGetChannelReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetPlayUrlReturnListener {
        void onGetPlayUrlReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetTimeStampReturnListener {
        void onGetTimeStampReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3514a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void getChannel(HashMap<String, String> hashMap, final OnGetChannelReturnListener onGetChannelReturnListener) {
        if (onGetChannelReturnListener == null) {
            LogEx.w("SDKBlackoutMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_BLACKOUT_CHANNEL);
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
        this.f3514a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.blackout.SDKBlackoutMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onGetChannelReturnListener.onGetChannelReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKBlackoutMgr", "JSONException occur");
                    onGetChannelReturnListener.onGetChannelReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BLACKOUT_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKBlackoutMgr", "SDKNetHTTPRequest onFailReturn");
                onGetChannelReturnListener.onGetChannelReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BLACKOUT_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }

    public void getChannelByGeo(HashMap<String, String> hashMap, final OnGetChannelByGeoReturnListener onGetChannelByGeoReturnListener) {
        if (onGetChannelByGeoReturnListener == null) {
            LogEx.w("SDKBlackoutMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_BLACKOUT_CHANNEL_GEO);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3514a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.blackout.SDKBlackoutMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onGetChannelByGeoReturnListener.onGetChannelByGeoReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKBlackoutMgr", "JSONException occur");
                    onGetChannelByGeoReturnListener.onGetChannelByGeoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BLACKOUT_MODELCODE, 4, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKBlackoutMgr", "SDKNetHTTPRequest onFailReturn");
                onGetChannelByGeoReturnListener.onGetChannelByGeoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BLACKOUT_MODELCODE, 4, i % 1000)), str, null);
            }
        });
    }

    public void getPlayUrl(HashMap<String, String> hashMap, final OnGetPlayUrlReturnListener onGetPlayUrlReturnListener) {
        if (onGetPlayUrlReturnListener == null) {
            LogEx.w("SDKBlackoutMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_BLACKOUT_URL);
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
        this.f3514a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.blackout.SDKBlackoutMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onGetPlayUrlReturnListener.onGetPlayUrlReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKBlackoutMgr", "JSONException occur");
                    onGetPlayUrlReturnListener.onGetPlayUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BLACKOUT_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKBlackoutMgr", "SDKNetHTTPRequest onFailReturn");
                onGetPlayUrlReturnListener.onGetPlayUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BLACKOUT_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void getTimeStamp(final OnGetTimeStampReturnListener onGetTimeStampReturnListener) {
        if (onGetTimeStampReturnListener == null) {
            LogEx.w("SDKBlackoutMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_BLACKOUT_TIMESTAMP);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3514a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.blackout.SDKBlackoutMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onGetTimeStampReturnListener.onGetTimeStampReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKBlackoutMgr", "JSONException occur");
                    onGetTimeStampReturnListener.onGetTimeStampReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BLACKOUT_MODELCODE, 3, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKBlackoutMgr", "SDKNetHTTPRequest onFailReturn");
                onGetTimeStampReturnListener.onGetTimeStampReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_BLACKOUT_MODELCODE, 3, i % 1000)), str, null);
            }
        });
    }
}
