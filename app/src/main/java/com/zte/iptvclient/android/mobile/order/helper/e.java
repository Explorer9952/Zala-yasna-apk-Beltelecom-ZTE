package com.zte.iptvclient.android.mobile.order.helper;

import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SdkGetBatchVodInfoMgr.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static final String f6950b = "e";

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f6951a;

    /* compiled from: SdkGetBatchVodInfoMgr.java */
    /* loaded from: classes.dex */
    class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f6952a;

        a(e eVar, b bVar) {
            this.f6952a = bVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f6952a.a(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
            } catch (JSONException e) {
                e.printStackTrace();
                LogEx.w(e.f6950b, "JSONException occur");
                this.f6952a.a(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 2, 202)), "JSONException occur", null);
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.w(e.f6950b, "SDKNetHTTPRequest onFailReturn");
            this.f6952a.a(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_VOD_MODELCODE, 2, i % 1000)), str, "");
        }
    }

    /* compiled from: SdkGetBatchVodInfoMgr.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(String str, String str2, String str3);
    }

    public void a(HashMap<String, String> hashMap, b bVar) {
        if (bVar == null) {
            LogEx.w(f6950b, "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append("sdk_getbatchvodinfo.jsp");
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
        LogEx.w(f6950b, sb.toString());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f6951a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new a(this, bVar));
    }

    public void a() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f6951a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }
}
