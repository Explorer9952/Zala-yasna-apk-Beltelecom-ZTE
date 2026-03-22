package com.zte.iptvclient.android.common.f.b;

import android.text.TextUtils;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.zte.servicesdk.util.PortalConst;
import org.json.JSONObject;

/* compiled from: ChannelSortManager.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4552a = "e";

    /* renamed from: b, reason: collision with root package name */
    private static String f4553b = "10.47.222.5:9491";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChannelSortManager.java */
    /* loaded from: classes.dex */
    public static class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            String optString;
            LogEx.d(e.f4552a, " onDataReturn sucess " + str);
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    LogEx.d(e.f4552a, " getColumnList onDataReturn : object " + jSONObject.toString());
                    if (!TextUtils.equals("0", jSONObject.optString("resultcode")) || (optString = jSONObject.optString("datavalue")) == null || optString.equalsIgnoreCase("")) {
                        return;
                    }
                    LogEx.d(e.f4552a, " mChannelJson = " + optString);
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    com.zte.iptvclient.android.common.j.b.e().b(optString);
                } catch (Exception e) {
                    LogEx.d(e.f4552a, " exception = " + e.getMessage());
                }
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(e.f4552a, " return onFailReturn " + i + "   " + str);
        }
    }

    /* compiled from: ChannelSortManager.java */
    /* loaded from: classes.dex */
    static class b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(e.f4552a, " onDataReturn  " + str);
            try {
                if (TextUtils.equals("0", new JSONObject(str).optString("resultcode"))) {
                    LogEx.d(e.f4552a, " storeChannelList  success  " + str);
                }
            } catch (Exception e) {
                LogEx.e(e.f4552a, e.toString());
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(e.f4552a, " return onFailReturn " + i + "   " + str);
        }
    }

    public static void b() {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        String readPropertie = com.zte.iptvclient.common.uiframe.h.readPropertie(PortalConst.STR_UPS_SERVER, null);
        if (!TextUtils.isEmpty(readPropertie)) {
            f4553b = readPropertie;
            sDKNetHTTPRequest.setBody(a("").toString());
            sDKNetHTTPRequest.setHeader("Cookie", i.h());
            String replace = "http://{epgdomain}/getuserdata".replace("{epgdomain}", f4553b);
            LogEx.d(f4552a, "url = " + replace);
            sDKNetHTTPRequest.startRequest(replace, "POST", new a());
            return;
        }
        LogEx.d(f4552a, "ini  UPS_Server  not set ");
    }

    private static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String d2 = com.zte.iptvclient.common.uiframe.a.d("UserID");
            LogEx.d(f4552a, "usercode=" + d2);
            if (TextUtils.isEmpty(d2)) {
                jSONObject.put("usercode", "guestphone");
            } else {
                jSONObject.put("usercode", d2);
            }
            jSONObject.put("datatype", "3");
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("datavalue", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static void b(String str) {
        LogEx.d(f4552a, "storeChannelList ENTER");
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        String readPropertie = com.zte.iptvclient.common.uiframe.h.readPropertie(PortalConst.STR_UPS_SERVER, null);
        if (!TextUtils.isEmpty(readPropertie)) {
            f4553b = readPropertie;
            sDKNetHTTPRequest.setBody(a(str).toString());
            sDKNetHTTPRequest.setHeader("Cookie", i.h());
            sDKNetHTTPRequest.startRequest("http://{epgdomain}/setuserdata".replace("{epgdomain}", f4553b), "POST", new b());
            return;
        }
        LogEx.d(f4552a, "ini  UPS_Server  not set ");
    }
}
