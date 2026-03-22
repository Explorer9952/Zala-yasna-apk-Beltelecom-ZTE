package com.zte.iptvclient.android.common.f.b;

import android.text.TextUtils;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.zte.servicesdk.util.PortalConst;
import org.json.JSONObject;

/* compiled from: SortColumManager.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4577a = "l";

    /* renamed from: b, reason: collision with root package name */
    private static String f4578b = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SortColumManager.java */
    /* loaded from: classes.dex */
    public static class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(l.f4577a, " onDataReturn  " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                LogEx.d(l.f4577a, " getColumnList  : object " + jSONObject.toString());
                if (TextUtils.equals("0", jSONObject.optString("resultcode"))) {
                    String optString = jSONObject.optString("datavalue");
                    LogEx.d(l.f4577a, "mDataValue = " + optString);
                    if (optString == null || optString.equalsIgnoreCase("")) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(optString);
                    String string = jSONObject2.getString("vodColunmSort");
                    String string2 = jSONObject2.getString("channelColunmSort");
                    if (!TextUtils.isEmpty(string)) {
                        com.zte.iptvclient.android.common.j.k.i().b(string);
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        com.zte.iptvclient.android.common.j.j.e().b(string2);
                    }
                    LogEx.d(l.f4577a, " mVodColumnJson = " + string);
                    LogEx.d(l.f4577a, " mTVColumnJson = " + string2);
                }
            } catch (Exception e) {
                LogEx.d(l.f4577a, " exception = " + e.getMessage());
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(l.f4577a, " return onFailReturn " + i + "   " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SortColumManager.java */
    /* loaded from: classes.dex */
    public static class b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(l.f4577a, " onDataReturn  " + str);
            try {
                if (TextUtils.equals("0", new JSONObject(str).optString("resultcode"))) {
                    LogEx.d(l.f4577a, " onDataReturn  success setColumList " + str);
                }
            } catch (Exception e) {
                LogEx.e(l.f4577a, e.toString());
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(l.f4577a, " return storeColumnList failed" + i + "   " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SortColumManager.java */
    /* loaded from: classes.dex */
    public static class c implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4579a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4580b;

        c(String str, String str2) {
            this.f4579a = str;
            this.f4580b = str2;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            String optString;
            LogEx.d(l.f4577a, " onDataReturn sucess " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                LogEx.d(l.f4577a, " getColumnList onDataReturn : object " + jSONObject.toString());
                if (!TextUtils.equals("0", jSONObject.optString("resultcode")) || (optString = jSONObject.optString("datavalue")) == null || optString.equalsIgnoreCase("")) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(optString);
                LogEx.d(l.f4577a, jSONObject2.toString());
                String optString2 = jSONObject2.optString("vodColunmSort");
                String optString3 = jSONObject2.optString("channelColunmSort");
                if (this.f4579a.equalsIgnoreCase("TV")) {
                    JSONObject jSONObject3 = new JSONObject();
                    if (optString2 != null) {
                        jSONObject3.put("vodColunmSort", optString2);
                    } else {
                        jSONObject3.put("vodColunmSort", "");
                    }
                    jSONObject3.put("channelColunmSort", this.f4580b);
                    l.b(jSONObject3.toString());
                } else if (this.f4579a.equalsIgnoreCase("VOD")) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("vodColunmSort", this.f4580b);
                    if (optString2 != null) {
                        jSONObject4.put("channelColunmSort", optString3);
                    } else {
                        jSONObject4.put("channelColunmSort", "");
                    }
                    l.b(jSONObject4.toString());
                }
                LogEx.d(l.f4577a, " mVodColumnJson = " + optString2);
                LogEx.d(l.f4577a, " mTVColumnJson = " + optString3);
            } catch (Exception e) {
                LogEx.d(l.f4577a, " exception = " + e.getMessage());
                try {
                    if (this.f4579a.equalsIgnoreCase("TV")) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("vodColunmSort", "");
                        jSONObject5.put("channelColunmSort", this.f4580b);
                        l.b(jSONObject5.toString());
                    } else if (this.f4579a.equalsIgnoreCase("VOD")) {
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("vodColunmSort", this.f4580b);
                        jSONObject6.put("channelColunmSort", "");
                        l.b(jSONObject6.toString());
                    }
                } catch (Exception e2) {
                    LogEx.d(l.f4577a, " exception1 = " + e2.getMessage());
                }
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(l.f4577a, " return onFailReturn " + i + "   " + str);
        }
    }

    public static void b() {
        LogEx.d(f4577a, " getColumnList   enter");
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        String readPropertie = com.zte.iptvclient.common.uiframe.h.readPropertie(PortalConst.STR_UPS_SERVER, null);
        if (!TextUtils.isEmpty(readPropertie)) {
            f4578b = readPropertie;
            sDKNetHTTPRequest.setBody(a("").toString());
            LogEx.d(f4577a, "getJsonParameters(\"\").toString() = " + a("").toString());
            sDKNetHTTPRequest.setHeader("Cookie", i.h());
            LogEx.d(f4577a, " IPTVLoginMgr.getSessionId() = " + i.h());
            String replace = "http://{epgdomain}/getuserdata".replace("{epgdomain}", f4578b);
            LogEx.d(f4577a, "mStrColumSortService = " + replace);
            sDKNetHTTPRequest.startRequest(replace, "POST", new a());
            return;
        }
        LogEx.d(f4577a, "ini  UPS_Server  not set ");
    }

    private static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String d2 = com.zte.iptvclient.common.uiframe.a.d("UserID");
            LogEx.d(f4577a, "usercode=" + d2);
            if (TextUtils.isEmpty(d2)) {
                jSONObject.put("usercode", "guestphone");
            } else {
                jSONObject.put("usercode", d2);
            }
            jSONObject.put("datatype", 4);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("datavalue", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static void a(String str, String str2) {
        LogEx.d(f4577a, " upLoadJsonData  " + str + " mFrom = " + str2);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        String readPropertie = com.zte.iptvclient.common.uiframe.h.readPropertie(PortalConst.STR_UPS_SERVER, null);
        if (!TextUtils.isEmpty(readPropertie)) {
            f4578b = readPropertie;
            sDKNetHTTPRequest.setBody(a("").toString());
            sDKNetHTTPRequest.setHeader("Cookie", i.h());
            sDKNetHTTPRequest.startRequest("http://{epgdomain}/getuserdata".replace("{epgdomain}", f4578b), "POST", new c(str2, str));
            return;
        }
        LogEx.d(f4577a, "ini  UPS_Server  not set ");
    }

    public static void b(String str) {
        LogEx.d(f4577a, "storeColum ENTER " + str);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        String readPropertie = com.zte.iptvclient.common.uiframe.h.readPropertie(PortalConst.STR_UPS_SERVER, null);
        if (!TextUtils.isEmpty(readPropertie)) {
            f4578b = readPropertie;
            sDKNetHTTPRequest.setBody(a(str).toString());
            LogEx.d(f4577a, "getJsonParameters(dataValue).toString() = " + a(str).toString());
            sDKNetHTTPRequest.setHeader("Cookie", i.h());
            String replace = "http://{epgdomain}/setuserdata".replace("{epgdomain}", f4578b);
            LogEx.d(f4577a, "url = " + replace);
            sDKNetHTTPRequest.startRequest(replace, "POST", new b());
            return;
        }
        LogEx.d(f4577a, "ini  UPS_Server  not set ");
    }
}
