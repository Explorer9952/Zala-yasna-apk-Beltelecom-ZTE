package com.zte.iptvclient.android.mobile.ivi;

import android.text.TextUtils;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.k.s;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IVIUtils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static g f6590a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f6591b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f6592c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f6593d = "";
    private static String e = "";
    private static String f = "";
    private static ArrayList<com.zte.iptvclient.android.mobile.ivi.c.a> g = new ArrayList<>();
    private static String h = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_Server_URL1");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IVIUtils.java */
    /* renamed from: com.zte.iptvclient.android.mobile.ivi.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0282a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        C0282a() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("IVIUtils", "getivisession onDataReturn s=" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    String unused = a.f6593d = jSONObject.getString("session");
                    com.zte.iptvclient.android.common.j.d.d().a(a.f6593d);
                    String unused2 = a.e = jSONObject.getString("expiration");
                    if (!TextUtils.isEmpty(a.e)) {
                        String unused3 = a.e = a.e.replace("T", " ");
                        String unused4 = a.e = a.e.replace("Z", "");
                        try {
                            if (!s.b().before(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(a.e))) {
                                a.j();
                            } else {
                                a.g();
                            }
                            return;
                        } catch (ParseException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    a.f();
                }
            } catch (JSONException unused5) {
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("IVIUtils", "getivisession onFailReturn i=" + i + "  s=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IVIUtils.java */
    /* loaded from: classes.dex */
    public static class b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("IVIUtils", "getnewivisession onFailReturn s=" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    String unused = a.f6593d = jSONObject.getString("session");
                    com.zte.iptvclient.android.common.j.d.d().a(a.f6593d);
                    a.g();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("IVIUtils", "getnewivisession onFailReturn i=" + i + "  s=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IVIUtils.java */
    /* loaded from: classes.dex */
    public static class c implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("Api05  onDataReturn", "s = " + str);
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("Api05  onFailReturn", "i = " + i + "  s = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IVIUtils.java */
    /* loaded from: classes.dex */
    public static class d implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("defineAppVersion  onDataReturn", "s = " + str);
            try {
                String unused = a.f = new JSONObject(str).getJSONObject("result").getString("user_ab_bucket");
                if (TextUtils.isEmpty(a.f)) {
                    return;
                }
                a.h();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("Api06  onFailReturn", "i = " + i + "  s = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IVIUtils.java */
    /* loaded from: classes.dex */
    public static class e implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("Api06-2  onDataReturn", "s = " + str);
            com.zte.iptvclient.android.common.j.d.d().a(true);
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("Api06-2  onFailReturn", "i = " + i + "  s = " + str);
        }
    }

    /* compiled from: IVIUtils.java */
    /* loaded from: classes.dex */
    static class f implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        f() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("IVIUtils", "iviAuthOrder s = " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("returncode");
                if (!"0".equals(string)) {
                    a.f6590a.a(string);
                } else {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("result").optJSONArray("purchase_options").getJSONObject(0).optJSONArray("payment_options").getJSONObject(0).getJSONObject("purchase_params");
                    if (a.g != null) {
                        a.g.clear();
                        a.g.add(com.zte.iptvclient.android.mobile.ivi.c.a.a(jSONObject2));
                        com.zte.iptvclient.android.common.j.d.d().a(a.g);
                        a.f6590a.a("0");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("IVIUtils", "iviAuthOrder onFailReturn i=" + i + "  s=" + str);
            a.f6590a.a(String.valueOf(i));
        }
    }

    /* compiled from: IVIUtils.java */
    /* loaded from: classes.dex */
    public interface g {
        void a(String str);
    }

    public static void f() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version_Android");
        f6591b = propertiesInfo;
        if (TextUtils.isEmpty(propertiesInfo)) {
            f6591b = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version");
        }
        String str = h + "/mobileapi/user/login/verimatrix/v5/?verimatrix=e2da6077b9d69e7191b132a56cd1ad72&app_version=" + f6591b + "&device=aphone";
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new c());
    }

    public static void g() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version_Android");
        f6591b = propertiesInfo;
        if (TextUtils.isEmpty(propertiesInfo)) {
            f6591b = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version");
        }
        String str = h + "/mobileapi/geocheck/whoami/v6/?app_version=" + f6591b;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new d());
    }

    public static void h() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version_Android");
        f6591b = propertiesInfo;
        if (TextUtils.isEmpty(propertiesInfo)) {
            f6591b = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version");
        }
        String str = h + "/mobileapi/geocheck/whoami/v6/?app_version=" + f6591b + "&user_ab_bucket=" + f;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new e());
    }

    public static void i() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version_Android");
        f6591b = propertiesInfo;
        if (TextUtils.isEmpty(propertiesInfo)) {
            f6591b = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version");
        }
        String str = "http://{ipadd:port}/iptvepg/{frame}/sdk_getivisession.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", i.f()) + "?appversion=" + f6591b;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        LogEx.d("IVIUtils", "getivisession " + str);
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new C0282a());
    }

    public static void j() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version_Android");
        f6591b = propertiesInfo;
        if (TextUtils.isEmpty(propertiesInfo)) {
            f6591b = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version");
        }
        String str = "http://{ipadd:port}/iptvepg/{frame}/sdk_getnewivisession.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", i.f()) + "?verimatrix=" + f6592c + "&device=" + ParamConst.LOG_TERMINAL_TYPE_APHONE + "&appversion=" + f6591b;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        LogEx.d("IVIUtils", "getnewivisession " + str);
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new b());
    }

    public static void a(String str, g gVar) {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version_Android");
        f6591b = propertiesInfo;
        if (TextUtils.isEmpty(propertiesInfo)) {
            f6591b = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version");
        }
        f6590a = gVar;
        if (gVar == null) {
            return;
        }
        String str2 = "http://{ipadd:port}/iptvepg/{frame}/sdk_iviauthorder.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", i.f()) + "?id=" + str + "&appversion=" + f6591b + "&sessionid=" + f6593d + "&withsubscriptionrenewals=1";
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        LogEx.d("IVIUtils", "getnewivisession " + str2);
        sDKNetHTTPRequest.startRequest(str2, HttpRequest.METHOD_GET, new f());
    }
}
