package com.zte.iptvclient.android.common.i.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.android.common.i.b.a;
import com.zte.iptvclient.android.common.i.b.b;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ResourceMgr.java */
/* loaded from: classes.dex */
public class c {
    private static final String j = "c";
    private static c k;

    /* renamed from: a, reason: collision with root package name */
    private com.zte.iptvclient.android.common.i.b.b f4645a = null;

    /* renamed from: b, reason: collision with root package name */
    private com.zte.iptvclient.android.common.i.b.a f4646b = null;

    /* renamed from: c, reason: collision with root package name */
    public Context f4647c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f4648d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private b.InterfaceC0134b h = new a();
    a.InterfaceC0133a i = new b();

    /* compiled from: ResourceMgr.java */
    /* loaded from: classes.dex */
    class a implements b.InterfaceC0134b {
        a() {
        }

        @Override // com.zte.iptvclient.android.common.i.b.b.InterfaceC0134b
        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                LogEx.d(c.j, "response is empty,so return");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int length = jSONObject.getJSONArray(ParamConst.UPDATE_VERSION_RSP_APPID).length();
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    if (c.this.f4648d.equalsIgnoreCase(jSONObject.getJSONArray(ParamConst.UPDATE_VERSION_RSP_APPID).getString(i2))) {
                        i = i2;
                    }
                }
                String string = jSONObject.getJSONArray(ParamConst.UPDATE_VERSION_RSP_APPID).getString(i);
                c.this.g = jSONObject.getJSONArray("AppVersion").getString(i);
                String string2 = jSONObject.getJSONArray(ParamConst.UPDATE_VERSION_RSP_URL).getString(i);
                String string3 = jSONObject.getJSONArray("MD5").getString(i);
                LogEx.d(c.j, "appid=" + string + ",version=" + c.this.g);
                LogEx.d(c.j, "url=" + string2 + ",md5=" + string3);
                LogEx.d(c.j, "appId=" + string + ",packageName=" + c.this.f4648d);
                String str2 = c.j;
                StringBuilder sb = new StringBuilder();
                sb.append("mVersionCode=");
                sb.append(c.this.e);
                LogEx.d(str2, sb.toString());
                String b2 = c.this.b(string2);
                LogEx.d(c.j, "chage url is=" + b2);
                if (TextUtils.equals(string, c.this.f4648d) && com.zte.iptvclient.android.common.i.c.a.a(c.this.g)) {
                    c.this.b();
                    c.this.f4646b = (com.zte.iptvclient.android.common.i.b.a) new com.zte.iptvclient.android.common.i.b.a(c.this.f, c.this.i).execute(b2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: ResourceMgr.java */
    /* loaded from: classes.dex */
    class b implements a.InterfaceC0133a {
        b() {
        }

        @Override // com.zte.iptvclient.android.common.i.b.a.InterfaceC0133a
        public void a(boolean z) {
            if (z) {
                Log.d(c.j, "download success version :" + c.this.g);
                com.zte.iptvclient.android.common.i.c.b.b().a(c.this.g);
                return;
            }
            Log.d(c.j, "download faile version :" + c.this.g);
        }
    }

    private c() {
    }

    private void c() {
        com.zte.iptvclient.android.common.i.b.b bVar = this.f4645a;
        if (bVar != null) {
            bVar.cancel(true);
            this.f4645a = null;
        }
    }

    public static c d() {
        if (k == null) {
            k = new c();
        }
        return k;
    }

    private void e() {
        File file = new File(this.f + "/source/tempshow/finish.txt");
        File file2 = new File(this.f + "/source/show/finish.txt");
        LogEx.d(j, "tempshow exists=" + file.exists() + ",show exists=" + file2.exists());
        if (file.exists()) {
            com.zte.iptvclient.android.common.i.c.a.c(this.f + "/source/show");
            new File(this.f + "/source/tempshow").renameTo(new File(this.f + "/source/show"));
            return;
        }
        com.zte.iptvclient.android.common.i.c.a.c(this.f + "/source/tempshow");
        if (file2.exists()) {
            return;
        }
        com.zte.iptvclient.android.common.i.c.a.c(this.f + "/source/show");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        String str2;
        LogEx.d(j, SDKLoginMgr.getInstance().getEPGHome());
        try {
            str2 = new URL(SDKLoginMgr.getInstance().getEPGHome()).getPath();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "/";
        }
        return "http://" + SDKLoginMgr.getInstance().getEpgIPAddress() + ":" + SDKLoginMgr.getInstance().getEpgIPPort() + str2 + com.zte.iptvclient.common.uiframe.a.c("Frame_Resource") + "/" + str;
    }

    public void a(Context context) {
        this.f4647c = context;
        this.f = context.getFilesDir().getPath();
        this.f4648d = context.getPackageName();
        try {
            this.e = context.getPackageManager().getPackageInfo(this.f4648d, 0).versionCode + "";
        } catch (Exception e) {
            LogEx.d(j, "e=" + e.getMessage());
        }
        com.zte.iptvclient.android.common.i.c.b.b().a(context);
        e();
        com.zte.iptvclient.android.common.i.c.c.a(this.f4647c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.zte.iptvclient.android.common.i.b.a aVar = this.f4646b;
        if (aVar != null) {
            aVar.cancel(true);
            this.f4646b = null;
        }
    }

    public int a(String str) {
        if (TextUtils.isEmpty(str)) {
            LogEx.d(j, "url is invalid");
            return 0;
        }
        c();
        this.f4645a = (com.zte.iptvclient.android.common.i.b.b) new com.zte.iptvclient.android.common.i.b.b(this.h).execute(str);
        return 1;
    }
}
