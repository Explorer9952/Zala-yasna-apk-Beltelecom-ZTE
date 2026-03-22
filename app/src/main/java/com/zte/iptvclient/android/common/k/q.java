package com.zte.iptvclient.android.common.k;

import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SDKBlackoutMgr.java */
/* loaded from: classes.dex */
public class q {

    /* compiled from: SDKBlackoutMgr.java */
    /* loaded from: classes.dex */
    static class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f4821a;

        a(f fVar) {
            this.f4821a = fVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("SDKBlackoutMgr", "getBlackoutDetailInfoById onDataReturn rerurntcode=" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.has("returncode") ? jSONObject.optString("returncode") : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
                String optString2 = jSONObject.has("errormsg") ? jSONObject.optString("errormsg") : "";
                if (this.f4821a != null) {
                    this.f4821a.a(optString, optString2, str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                LogEx.w("SDKBlackoutMgr", "getBlackoutDetailInfoById JSONException occur" + e.getMessage());
                f fVar = this.f4821a;
                if (fVar != null) {
                    fVar.a(String.valueOf(ErrCode.getErrCode(198000, 202)), "JSONException occur", "");
                }
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("SDKBlackoutMgr", "getBlackoutDetailInfoById onFailReturn rerurntcode=" + i + " errormsg = " + str);
            f fVar = this.f4821a;
            if (fVar != null) {
                fVar.a(String.valueOf(i), str, "");
            }
        }
    }

    /* compiled from: SDKBlackoutMgr.java */
    /* loaded from: classes.dex */
    static class b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f4822a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4823b;

        b(d dVar, String str) {
            this.f4822a = dVar;
            this.f4823b = str;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("SDKBlackoutMgr", "getBlackOutInfoBySourceType onDataReturn rerurntcode=" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.has("returncode") ? jSONObject.optString("returncode") : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
                String optString2 = jSONObject.has("errormsg") ? jSONObject.optString("errormsg") : "";
                if (this.f4822a != null) {
                    if (TextUtils.equals(this.f4823b, "1")) {
                        this.f4822a.c(optString, optString2, str);
                        return;
                    }
                    if (TextUtils.equals(this.f4823b, "2")) {
                        this.f4822a.a(optString, optString2, str);
                    } else if (TextUtils.equals(this.f4823b, "4")) {
                        this.f4822a.b(optString, optString2, str);
                    } else {
                        this.f4822a.d(optString, optString2, str);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
                LogEx.w("SDKBlackoutMgr", "getBlackOutInfoBySourceType JSONException occur" + e.getMessage());
                if (this.f4822a != null) {
                    if (TextUtils.equals(this.f4823b, "1")) {
                        this.f4822a.c(String.valueOf(ErrCode.getErrCode(198000, 202)), "JSONException occur", "");
                        return;
                    }
                    if (TextUtils.equals(this.f4823b, "2")) {
                        this.f4822a.a(String.valueOf(ErrCode.getErrCode(198000, 202)), "JSONException occur", "");
                    } else if (TextUtils.equals(this.f4823b, "4")) {
                        this.f4822a.b(String.valueOf(ErrCode.getErrCode(198000, 202)), "JSONException occur", "");
                    } else {
                        this.f4822a.d(String.valueOf(ErrCode.getErrCode(198000, 202)), "JSONException occur", "");
                    }
                }
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("SDKBlackoutMgr", "getBlackOutInfoBySourceType onFailReturn rerurntcode=" + i + " errormsg = " + str);
            if (this.f4822a != null) {
                if (TextUtils.equals(this.f4823b, "1")) {
                    this.f4822a.c(String.valueOf(i), str, "");
                    return;
                }
                if (TextUtils.equals(this.f4823b, "2")) {
                    this.f4822a.a(String.valueOf(i), str, "");
                } else if (TextUtils.equals(this.f4823b, "4")) {
                    this.f4822a.b(String.valueOf(i), str, "");
                } else {
                    this.f4822a.d(String.valueOf(i), str, "");
                }
            }
        }
    }

    /* compiled from: SDKBlackoutMgr.java */
    /* loaded from: classes.dex */
    static class c implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f4824a;

        c(e eVar) {
            this.f4824a = eVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.has("returncode") ? jSONObject.optString("returncode") : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
                String optString2 = jSONObject.has("errormsg") ? jSONObject.optString("errormsg") : "";
                if (this.f4824a != null) {
                    this.f4824a.onGetPlayUrlReturn(optString, optString2, str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                LogEx.w("SDKBlackoutMgr", "JSONException occur");
                e eVar = this.f4824a;
                if (eVar != null) {
                    eVar.onGetPlayUrlReturn(String.valueOf(ErrCode.getErrCode(198000, 202)), "JSONException occur", "");
                }
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.w("SDKBlackoutMgr", "getPlayUrl onFailReturn");
            e eVar = this.f4824a;
            if (eVar != null) {
                eVar.onGetPlayUrlReturn(String.valueOf(i), str, "");
            }
        }
    }

    /* compiled from: SDKBlackoutMgr.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(String str, String str2, String str3);

        void b(String str, String str2, String str3);

        void c(String str, String str2, String str3);

        void d(String str, String str2, String str3);
    }

    /* compiled from: SDKBlackoutMgr.java */
    /* loaded from: classes.dex */
    public interface e {
        void onGetPlayUrlReturn(String str, String str2, String str3);
    }

    /* compiled from: SDKBlackoutMgr.java */
    /* loaded from: classes.dex */
    public interface f {
        void a(String str, String str2, String str3);
    }

    public static void a(HashMap<String, String> hashMap, f fVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.zte.iptvclient.android.common.f.b.i.f());
        sb.append("sdk_queryblackout.jsp");
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
        LogEx.d("SDKBlackoutMgr", "getBlackoutDetailInfoById req=" + sb.toString());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new a(fVar));
    }

    public static void a(String str, HashMap<String, String> hashMap, d dVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append("sdk_queryblackout.jsp");
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
        LogEx.d("SDKBlackoutMgr", "getBlackOutInfoBySourceType req=" + sb.toString());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new b(dVar, str));
    }

    public static void a(HashMap<String, String> hashMap, e eVar) {
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
        LogEx.d("SDKBlackoutMgr", "getPlayUrl req=" + sb.toString());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new c(eVar));
    }
}
