package com.zte.iptvclient.android.mobile.k.c;

import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SDKChildViewHistory.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f6701b = "a";

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f6702a;

    /* compiled from: SDKChildViewHistory.java */
    /* renamed from: com.zte.iptvclient.android.mobile.k.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0294a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f6703a;

        C0294a(a aVar, b bVar) {
            this.f6703a = bVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f6703a.a(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
            } catch (JSONException e) {
                e.printStackTrace();
                LogEx.w(a.f6701b, "JSONException occur");
                this.f6703a.a(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VIEWHISTORY_MODELCODE, 2, 202)), "JSONException occur", null);
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.w(a.f6701b, "SDKNetHTTPRequest onFailReturn");
            this.f6703a.a(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VIEWHISTORY_MODELCODE, 2, i % 1000)), str, null);
        }
    }

    /* compiled from: SDKChildViewHistory.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(String str, String str2, String str3);
    }

    public void a(HashMap<String, String> hashMap, b bVar) {
        if (bVar == null) {
            LogEx.w(f6701b, "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append("sdk_getchildviewhistory.jsp");
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
        LogEx.w(f6701b, sb.toString());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f6702a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new C0294a(this, bVar));
    }

    public void a() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f6702a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }
}
