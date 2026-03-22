package com.zte.iptvclient.android.mobile.k.c;

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

/* compiled from: SDKTvodMgr.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final String f6704b = "b";

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f6705a;

    /* compiled from: SDKTvodMgr.java */
    /* loaded from: classes.dex */
    class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0295b f6706a;

        a(b bVar, InterfaceC0295b interfaceC0295b) {
            this.f6706a = interfaceC0295b;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f6706a.a(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
            } catch (JSONException e) {
                e.printStackTrace();
                LogEx.w(b.f6704b, "JSONException occur");
                this.f6706a.a(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 3, 202)), "JSONException occur", "{\"data\":[]}");
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.w(b.f6704b, "SDKNetHTTPRequest onFailReturn");
            this.f6706a.a(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 3, i % 1000)), str, "{\"data\":[]}");
        }
    }

    /* compiled from: SDKTvodMgr.java */
    /* renamed from: com.zte.iptvclient.android.mobile.k.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0295b {
        void a(String str, String str2, String str3);
    }

    public void a(HashMap<String, String> hashMap, InterfaceC0295b interfaceC0295b) {
        if (interfaceC0295b == null) {
            LogEx.w(f6704b, "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_PREVUE_DETAIL);
        if (hashMap == null) {
            LogEx.w(f6704b, "params == null");
            interfaceC0295b.a(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 3, 2)), ErrMessage.PARAM_IS_NULL, "{\"data\":[]}");
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
        LogEx.w(f6704b, sb.toString());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f6705a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new a(this, interfaceC0295b));
    }

    public void a() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f6705a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }
}
