package com.video.androidsdk.service.play;

import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.auth.SDKAuthMgr;
import com.video.androidsdk.service.bean.AuthReq;
import com.video.androidsdk.service.bean.AuthSuccRspInfo;
import com.video.androidsdk.service.bean.Product;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.comm.SDKCommonTool;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKPlayMgr {

    /* renamed from: a, reason: collision with root package name */
    private OnPlayURLReturnListener f3672a;

    /* renamed from: b, reason: collision with root package name */
    private SDKAuthMgr.OnDoAuthReturnListener f3673b;

    /* renamed from: c, reason: collision with root package name */
    private SDKNetHTTPRequest f3674c;

    /* loaded from: classes.dex */
    public interface OnAdPlayUrlReturnListener {
        void onAdPlayUrlReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnBackPlayUrlReturnListener {
        void onBackPlayUrlReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnMultiDefinitionUrlReturnListener {
        void onMultiDefinitionUrlReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnPlayNotifyReturnListener {
        void onPlayNotifyReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnPlayURLReturnListener {
        void onPlayURLReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3674c;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void getAdPlayUrl(HashMap<String, String> hashMap, final OnAdPlayUrlReturnListener onAdPlayUrlReturnListener) {
        if (onAdPlayUrlReturnListener == null) {
            LogEx.w("SDKPlayMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKPlayMgr", "params is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_AD_PLAY_URL);
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
        this.f3674c = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.play.SDKPlayMgr.7
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onAdPlayUrlReturnListener.onAdPlayUrlReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKPlayMgr", "JSONException occur");
                    onAdPlayUrlReturnListener.onAdPlayUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PLAYURL_MODELCODE, 9, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKPlayMgr", "SDKNetHTTPRequest onFailReturn");
                onAdPlayUrlReturnListener.onAdPlayUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PLAYURL_MODELCODE, 9, i % 1000)), str, null);
            }
        });
    }

    public void getBackPlayUrl(HashMap<String, String> hashMap, final OnBackPlayUrlReturnListener onBackPlayUrlReturnListener) {
        if (onBackPlayUrlReturnListener == null) {
            LogEx.w("SDKPlayMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKPlayMgr", "params is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_BACK_PLAY_URL);
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
        this.f3674c = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.play.SDKPlayMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onBackPlayUrlReturnListener.onBackPlayUrlReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKPlayMgr", "JSONException occur");
                    onBackPlayUrlReturnListener.onBackPlayUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PLAYURL_MODELCODE, 8, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKPlayMgr", "SDKNetHTTPRequest onFailReturn");
                onBackPlayUrlReturnListener.onBackPlayUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PLAYURL_MODELCODE, 8, i % 1000)), str, null);
            }
        });
    }

    public void getMultiDefinitionUrl(HashMap<String, String> hashMap, final OnMultiDefinitionUrlReturnListener onMultiDefinitionUrlReturnListener) {
        if (onMultiDefinitionUrlReturnListener == null) {
            LogEx.w("SDKPlayMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_MULTI_DEFINITION_URL);
        if (hashMap == null) {
            LogEx.w("SDKPlayMgr", "params is null");
            return;
        }
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
        this.f3674c = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.play.SDKPlayMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onMultiDefinitionUrlReturnListener.onMultiDefinitionUrlReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKPlayMgr", "JSONException occur");
                    onMultiDefinitionUrlReturnListener.onMultiDefinitionUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PLAYURL_MODELCODE, 10, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKPlayMgr", "SDKNetHTTPRequest onFailReturn");
                onMultiDefinitionUrlReturnListener.onMultiDefinitionUrlReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PLAYURL_MODELCODE, 10, i % 1000)), str, null);
            }
        });
    }

    public void playNotify(HashMap<String, String> hashMap, final OnPlayNotifyReturnListener onPlayNotifyReturnListener) {
        if (onPlayNotifyReturnListener == null) {
            LogEx.w("SDKPlayMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKPlayMgr", "params is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append("datasource/doauth.jsp");
        sb.append("?isplay=1");
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
        this.f3674c = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.play.SDKPlayMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                onPlayNotifyReturnListener.onPlayNotifyReturn("0", str);
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onPlayNotifyReturnListener.onPlayNotifyReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PLAYURL_MODELCODE, 7, i % 1000)), str);
            }
        });
    }

    public void queryChannelPlayURL(String str, String str2, String str3, int i, String str4, OnPlayURLReturnListener onPlayURLReturnListener) {
        this.f3672a = onPlayURLReturnListener;
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_CHANNEL_URL);
        sb.append("?channelcode=" + str);
        sb.append("&columncode=" + str2);
        sb.append("&authidsession=" + str3);
        sb.append("&definition=" + i);
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&mediaservice=" + str4);
        }
        a(sb.toString(), 2);
    }

    public void queryNPVRPlayURL(String str, String str2, String str3, int i, String str4, String str5, OnPlayURLReturnListener onPlayURLReturnListener) {
        this.f3672a = onPlayURLReturnListener;
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_NPVR_URL);
        sb.append("?prevuecode=" + str);
        sb.append("&channelcode=" + str2);
        sb.append("&authidsession=" + str3);
        sb.append("&definition=" + i);
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&mediaservice=" + str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append("&npvrcode=" + str5);
        }
        a(sb.toString(), 6);
    }

    public void queryPlayURL(final Map<String, String> map, OnPlayURLReturnListener onPlayURLReturnListener, SDKAuthMgr.OnDoAuthReturnListener onDoAuthReturnListener) {
        this.f3672a = onPlayURLReturnListener;
        this.f3673b = onDoAuthReturnListener;
        if (map == null) {
            LogEx.w("SDKPlayMgr", "play url request param is null");
            OnPlayURLReturnListener onPlayURLReturnListener2 = this.f3672a;
            if (onPlayURLReturnListener2 != null) {
                onPlayURLReturnListener2.onPlayURLReturn(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "play url request param is null", null);
                return;
            }
            return;
        }
        if ("0".equals(map.get(ParamConst.PLAY_ISINNERCODE))) {
            new SDKCommonTool().queryInnerCode(map.get("contenttype"), map.get("contentcode"), map.get("columncode"), new SDKCommonTool.OnInnerCodeReturnListener() { // from class: com.video.androidsdk.service.play.SDKPlayMgr.2
                @Override // com.video.androidsdk.service.comm.SDKCommonTool.OnInnerCodeReturnListener
                public void onInnerCodeReturn(String str, String str2, Map<String, Object> map2) {
                    if (!"0".equals(str)) {
                        SDKPlayMgr.this.f3672a.onPlayURLReturn(str, str2, "");
                    } else {
                        SDKPlayMgr.this.a((Map<String, String>) map);
                    }
                }
            });
        } else {
            a(map);
        }
    }

    public void queryShiftPlayURL(String str, String str2, String str3, int i, String str4, OnPlayURLReturnListener onPlayURLReturnListener) {
        this.f3672a = onPlayURLReturnListener;
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_TV_PLAYURL);
        sb.append("?channelcode=" + str);
        sb.append("&columncode=" + str2);
        sb.append("&authid=" + str3);
        sb.append("&definition=" + i);
        sb.append("&mediaservice=" + str4);
        sb.append("&playtype=1");
        a(sb.toString(), 4);
    }

    public void querySnapPlayURL(String str, String str2, int i, String str3, OnPlayURLReturnListener onPlayURLReturnListener) {
        this.f3672a = onPlayURLReturnListener;
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_SNAP_URL);
        sb.append("?programcode=" + str);
        sb.append("&snapflag=" + str2);
        sb.append("&definition=" + i);
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&mediaservice=" + str3);
        }
        a(sb.toString(), 3);
    }

    public void queryTvodPlayURL(String str, String str2, String str3, int i, String str4, OnPlayURLReturnListener onPlayURLReturnListener) {
        this.f3672a = onPlayURLReturnListener;
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_TVOD_URL);
        sb.append("?prevuecode=" + str);
        sb.append("&channelcode=" + str2);
        sb.append("&authidsession=" + str3);
        sb.append("&definition=" + i);
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&mediaservice=" + str4);
        }
        a(sb.toString(), 5);
    }

    public void queryVoDPlayURL(String str, String str2, int i, String str3, OnPlayURLReturnListener onPlayURLReturnListener) {
        this.f3672a = onPlayURLReturnListener;
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_VOD_URL);
        sb.append("?programcode=" + str);
        sb.append("&authidsession=" + str2);
        sb.append("&definition=" + i);
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&mediaservice=" + str3);
        }
        a(sb.toString(), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Map<String, String> map) {
        new SDKAuthMgr().doAuth(new AuthReq(map.get("columncode"), map.get("programcode"), map.get("contenttype")), new SDKAuthMgr.OnDoAuthReturnListener() { // from class: com.video.androidsdk.service.play.SDKPlayMgr.3
            @Override // com.video.androidsdk.service.auth.SDKAuthMgr.OnDoAuthReturnListener
            public void onDoAuthNotPassProductListReturn(String str, String str2, List<Product> list) {
                if (SDKPlayMgr.this.f3673b != null) {
                    SDKPlayMgr.this.f3673b.onDoAuthNotPassProductListReturn(str, str2, list);
                }
                if (SDKPlayMgr.this.f3672a != null) {
                    SDKPlayMgr.this.f3672a.onPlayURLReturn(str, str2, null);
                }
            }

            @Override // com.video.androidsdk.service.auth.SDKAuthMgr.OnDoAuthReturnListener
            public void onDoAuthOtherFailReturn(String str, String str2) {
                if (SDKPlayMgr.this.f3673b != null) {
                    SDKPlayMgr.this.f3673b.onDoAuthOtherFailReturn(str, str2);
                }
                if (SDKPlayMgr.this.f3672a != null) {
                    SDKPlayMgr.this.f3672a.onPlayURLReturn(str, str2, null);
                }
            }

            @Override // com.video.androidsdk.service.auth.SDKAuthMgr.OnDoAuthReturnListener
            public void onDoAuthSuccReturn(AuthSuccRspInfo authSuccRspInfo) {
                if (SDKPlayMgr.this.f3673b != null) {
                    SDKPlayMgr.this.f3673b.onDoAuthSuccReturn(authSuccRspInfo);
                }
                String str = (String) map.get("programcode");
                String str2 = (String) map.get("channelcode");
                String str3 = (String) map.get("columncode");
                String str4 = (String) map.get("prevuecode");
                String authorizationid = authSuccRspInfo != null ? authSuccRspInfo.getAuthorizationid() : "";
                if (((String) map.get("contenttype")).equals(ParamConst.PLAY_CONTENTTYPE_VOD)) {
                    SDKPlayMgr.this.queryVoDPlayURL(str, authorizationid, 0, null, new OnPlayURLReturnListener() { // from class: com.video.androidsdk.service.play.SDKPlayMgr.3.1
                        @Override // com.video.androidsdk.service.play.SDKPlayMgr.OnPlayURLReturnListener
                        public void onPlayURLReturn(String str5, String str6, String str7) {
                            if (SDKPlayMgr.this.f3672a != null) {
                                SDKPlayMgr.this.f3672a.onPlayURLReturn(str5, str6, str7);
                            }
                        }
                    });
                    return;
                }
                if (((String) map.get("contenttype")).equals(ParamConst.PLAY_CONTENTTYPE_CHENNEL)) {
                    SDKPlayMgr.this.queryChannelPlayURL(str2, str3, authorizationid, 0, null, new OnPlayURLReturnListener() { // from class: com.video.androidsdk.service.play.SDKPlayMgr.3.2
                        @Override // com.video.androidsdk.service.play.SDKPlayMgr.OnPlayURLReturnListener
                        public void onPlayURLReturn(String str5, String str6, String str7) {
                            if (SDKPlayMgr.this.f3672a != null) {
                                SDKPlayMgr.this.f3672a.onPlayURLReturn(str5, str6, str7);
                            }
                        }
                    });
                    return;
                }
                if (((String) map.get("contenttype")).equals(ParamConst.PLAY_CONTENTTYPE_NPVR)) {
                    SDKPlayMgr.this.queryNPVRPlayURL(str4, str2, authorizationid, 0, null, null, new OnPlayURLReturnListener() { // from class: com.video.androidsdk.service.play.SDKPlayMgr.3.3
                        @Override // com.video.androidsdk.service.play.SDKPlayMgr.OnPlayURLReturnListener
                        public void onPlayURLReturn(String str5, String str6, String str7) {
                            if (SDKPlayMgr.this.f3672a != null) {
                                SDKPlayMgr.this.f3672a.onPlayURLReturn(str5, str6, str7);
                            }
                        }
                    });
                } else if (((String) map.get("contenttype")).equals(ParamConst.PLAY_CONTENTTYPE_TVOD)) {
                    SDKPlayMgr.this.queryTvodPlayURL(str4, str2, authorizationid, 0, null, new OnPlayURLReturnListener() { // from class: com.video.androidsdk.service.play.SDKPlayMgr.3.4
                        @Override // com.video.androidsdk.service.play.SDKPlayMgr.OnPlayURLReturnListener
                        public void onPlayURLReturn(String str5, String str6, String str7) {
                            SDKPlayMgr.this.f3672a.onPlayURLReturn(str5, str6, str7);
                        }
                    });
                } else if (((String) map.get("contenttype")).equals(ParamConst.PLAY_CONTENTTYPE_SHIFT)) {
                    SDKPlayMgr.this.queryShiftPlayURL(str2, str3, authorizationid, 0, null, new OnPlayURLReturnListener() { // from class: com.video.androidsdk.service.play.SDKPlayMgr.3.5
                        @Override // com.video.androidsdk.service.play.SDKPlayMgr.OnPlayURLReturnListener
                        public void onPlayURLReturn(String str5, String str6, String str7) {
                            if (SDKPlayMgr.this.f3672a != null) {
                                SDKPlayMgr.this.f3672a.onPlayURLReturn(str5, str6, str7);
                            }
                        }
                    });
                }
            }
        });
    }

    private void a(String str, final int i) {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3674c = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(str, "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.play.SDKPlayMgr.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String optString = jSONObject.optString("returncode");
                    String optString2 = jSONObject.optString("errormsg");
                    String optString3 = jSONObject.has("url") ? jSONObject.optString("url") : "";
                    if (SDKPlayMgr.this.f3672a != null) {
                        SDKPlayMgr.this.f3672a.onPlayURLReturn(optString, optString2, optString3);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKPlayMgr", "JSONException occur");
                    if (SDKPlayMgr.this.f3672a != null) {
                        SDKPlayMgr.this.f3672a.onPlayURLReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PLAYURL_MODELCODE, i, 6)), "JSONException occur", null);
                    }
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i2, String str2) {
                LogEx.w("SDKPlayMgr", "SDKNetHTTPRequest onFailReturn");
                if (SDKPlayMgr.this.f3672a != null) {
                    SDKPlayMgr.this.f3672a.onPlayURLReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PLAYURL_MODELCODE, i, i2 % 1000)), str2, null);
                }
            }
        });
    }

    public void querySnapPlayURL(QuerySnapPlayURLReq querySnapPlayURLReq, OnPlayURLReturnListener onPlayURLReturnListener) {
        this.f3672a = onPlayURLReturnListener;
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_SNAP_URL);
        if (querySnapPlayURLReq == null) {
            LogEx.w("SDKPlayMgr", "req is null");
            return;
        }
        HashMap<String, String> hashMap = querySnapPlayURLReq.toHashMap();
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
        a(sb.toString(), 3);
    }

    public void queryVoDPlayURL(QueryVoDPlayURLReq queryVoDPlayURLReq, OnPlayURLReturnListener onPlayURLReturnListener) {
        this.f3672a = onPlayURLReturnListener;
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_VOD_URL);
        if (queryVoDPlayURLReq == null) {
            LogEx.w("SDKPlayMgr", "req is null");
            return;
        }
        HashMap<String, String> hashMap = queryVoDPlayURLReq.toHashMap();
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
        a(sb.toString(), 1);
    }

    public void queryChannelPlayURL(QueryChannelPlayURLReq queryChannelPlayURLReq, OnPlayURLReturnListener onPlayURLReturnListener) {
        this.f3672a = onPlayURLReturnListener;
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_CHANNEL_URL);
        if (queryChannelPlayURLReq == null) {
            LogEx.w("SDKPlayMgr", "req is null");
            return;
        }
        HashMap<String, String> hashMap = queryChannelPlayURLReq.toHashMap();
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
        a(sb.toString(), 2);
    }

    public void queryShiftPlayURL(QueryShiftPlayURLReq queryShiftPlayURLReq, OnPlayURLReturnListener onPlayURLReturnListener) {
        this.f3672a = onPlayURLReturnListener;
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_TV_PLAYURL);
        if (queryShiftPlayURLReq == null) {
            LogEx.w("SDKPlayMgr", "req is null");
            return;
        }
        HashMap<String, String> hashMap = queryShiftPlayURLReq.toHashMap();
        sb.append("?");
        sb.append("playtype");
        sb.append("=");
        sb.append("1");
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
        a(sb.toString(), 4);
    }

    public void queryTvodPlayURL(QueryTvodPlayURLReq queryTvodPlayURLReq, OnPlayURLReturnListener onPlayURLReturnListener) {
        this.f3672a = onPlayURLReturnListener;
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_TVOD_URL);
        if (queryTvodPlayURLReq == null) {
            LogEx.w("SDKPlayMgr", "req is null");
            return;
        }
        HashMap<String, String> hashMap = queryTvodPlayURLReq.toHashMap();
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
        a(sb.toString(), 5);
    }

    public void queryNPVRPlayURL(QueryNPVRPlayURLReq queryNPVRPlayURLReq, OnPlayURLReturnListener onPlayURLReturnListener) {
        this.f3672a = onPlayURLReturnListener;
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.GET_NPVR_URL);
        if (queryNPVRPlayURLReq == null) {
            LogEx.w("SDKPlayMgr", "req is null");
            return;
        }
        HashMap<String, String> hashMap = queryNPVRPlayURLReq.toHashMap();
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
        a(sb.toString(), 6);
    }
}
