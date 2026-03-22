package com.zte.iptvclient.android.mobile.f.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.SDKUserMgr;
import com.video.androidsdk.service.bean.UserProperties;
import com.video.androidsdk.service.lock.SDKLockMgr;
import com.video.androidsdk.service.userdata.GetUserDataReq;
import com.video.androidsdk.service.userdata.SDKUserDataMgr;
import com.zte.iptvclient.android.common.j.h;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChildLockUtil.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f6224a;

    /* renamed from: b, reason: collision with root package name */
    private static h f6225b;

    /* renamed from: c, reason: collision with root package name */
    private static int f6226c;

    /* renamed from: d, reason: collision with root package name */
    private static a f6227d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildLockUtil.java */
    /* renamed from: com.zte.iptvclient.android.mobile.f.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0251a implements SDKLockMgr.OnUserLockListReturnListener {
        C0251a() {
        }

        @Override // com.video.androidsdk.service.lock.SDKLockMgr.OnUserLockListReturnListener
        public void onUserLockMarkListReturn(String str, String str2, String str3) {
            LogEx.d("ChildLockUtil", "getUserLockList returncode is " + str);
            LogEx.d("ChildLockUtil", "getUserLockList errmsg is " + str2);
            LogEx.d("ChildLockUtil", "getUserLockList jsp is " + str3);
            if (TextUtils.equals(str, "0") || TextUtils.equals(str, "50991021")) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    if ("0".equals(jSONObject.optString("returncode"))) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("contentcode");
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("blocktitleenable");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            if ("1".equals(optJSONArray2.get(i).toString())) {
                                a.f6224a.put(optJSONArray.get(i).toString(), "1");
                            } else {
                                a.f6224a.put(optJSONArray.get(i).toString(), "0");
                            }
                        }
                        com.zte.iptvclient.android.common.j.e.b().a(a.f6224a);
                        return;
                    }
                    if (TextUtils.equals(jSONObject.optString("returncode"), "50991021")) {
                        com.zte.iptvclient.android.common.j.e.b().a(a.f6224a);
                    }
                } catch (Exception e) {
                    LogEx.e("ChildLockUtil", e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildLockUtil.java */
    /* loaded from: classes.dex */
    public static class b implements SDKUserDataMgr.OnGetUserDataReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.service.userdata.SDKUserDataMgr.OnGetUserDataReturnListener
        public void onGetUserDataReturn(String str, String str2, String str3) {
            if (str.equals("0")) {
                Log.d("99999", "用sdk请求返回的数据是" + str3);
                try {
                    JSONArray jSONArray = new JSONArray(Uri.decode((String) new JSONObject(str3).get("datavalue")));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        a.f6224a.put((String) jSONObject.get("channelcode"), (String) jSONObject.get("isblocktitle"));
                    }
                    com.zte.iptvclient.android.common.j.e.b().a(a.f6224a);
                } catch (ClassCastException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildLockUtil.java */
    /* loaded from: classes.dex */
    public class c implements SDKUserMgr.OnUserPropertiesReturnListener {
        c(a aVar) {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnUserPropertiesReturnListener
        public void onUserPropertiesReturn(String str, String str2, UserProperties userProperties) {
            LogEx.d("ChildLockUtil", "QueryUserInfo:  onDataReturn,arg0= " + str);
            if (TextUtils.equals(str, "0")) {
                try {
                    String trim = userProperties.getSwitchvalue().trim();
                    if (TextUtils.isEmpty(trim)) {
                        return;
                    }
                    String binaryString = Long.toBinaryString(Long.valueOf(trim).longValue());
                    boolean z = TextUtils.equals(binaryString.substring(binaryString.length() + (-16), binaryString.length() + (-15)), "1");
                    if (a.f6225b != null) {
                        a.f6225b.o(z);
                    }
                } catch (Exception e) {
                    LogEx.e("ChildLockUtil", "getParentalCheck String form Json=" + e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildLockUtil.java */
    /* loaded from: classes.dex */
    public class d implements SDKUserMgr.OnUserPropertiesReturnListener {
        d(a aVar) {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnUserPropertiesReturnListener
        public void onUserPropertiesReturn(String str, String str2, UserProperties userProperties) {
            if (TextUtils.equals(str, "0")) {
                String limitpwd = userProperties.getLimitpwd();
                if (a.f6225b != null) {
                    a.f6225b.p(limitpwd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildLockUtil.java */
    /* loaded from: classes.dex */
    public class e implements SDKUserMgr.OnUserPropertiesReturnListener {
        e(a aVar) {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnUserPropertiesReturnListener
        public void onUserPropertiesReturn(String str, String str2, UserProperties userProperties) {
            LogEx.d("ChildLockUtil", "QueryUserInfo:  onDataReturn,arg0= " + str);
            if (TextUtils.equals(str, "0")) {
                try {
                    String trim = userProperties.getSwitchvalue().trim();
                    if (TextUtils.isEmpty(trim)) {
                        return;
                    }
                    String binaryString = Long.toBinaryString(Long.valueOf(trim).longValue());
                    boolean z = !TextUtils.equals(binaryString.substring(binaryString.length() + (-8), binaryString.length() + (-7)), "0");
                    if (a.f6225b != null) {
                        a.f6225b.n(z);
                    }
                } catch (Exception e) {
                    LogEx.e("ChildLockUtil", "getOrderCheck String form Json=" + e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildLockUtil.java */
    /* loaded from: classes.dex */
    public class f implements SDKUserMgr.OnUserPropertiesReturnListener {
        f(a aVar) {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnUserPropertiesReturnListener
        public void onUserPropertiesReturn(String str, String str2, UserProperties userProperties) {
            if (TextUtils.equals(str, "0")) {
                String orderpwd = userProperties.getOrderpwd();
                if (a.f6225b != null) {
                    a.f6225b.w(orderpwd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildLockUtil.java */
    /* loaded from: classes.dex */
    public class g implements SDKUserMgr.OnUserPropertiesReturnListener {
        g(a aVar) {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnUserPropertiesReturnListener
        public void onUserPropertiesReturn(String str, String str2, UserProperties userProperties) {
            if (TextUtils.equals(str, "0")) {
                int parseInt = Integer.parseInt(userProperties.getLimitlevel());
                if (a.f6225b != null) {
                    a.f6225b.a(parseInt);
                }
            }
        }
    }

    public a(Context context) {
        f6225b = new h(context);
    }

    public static a a(Context context) {
        if (f6227d == null) {
            f6227d = new a(context);
        }
        return f6227d;
    }

    public static boolean b(String str) {
        h hVar;
        boolean c2 = c(str);
        if (!c2 || (hVar = f6225b) == null || !hVar.C()) {
            return false;
        }
        HashMap<String, String> a2 = com.zte.iptvclient.android.common.j.e.b().a();
        if (a2 != null) {
            Iterator<String> it2 = a2.keySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String next = it2.next();
                String str2 = a2.get(next);
                if (str.equals(next)) {
                    c2 = !"0".equals(str2);
                }
            }
        }
        return c2;
    }

    public static boolean c(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.equals("0", ConfigMgr.readPropertie("IsShowChildLock"))) {
            TextUtils.isEmpty("1");
            HashMap<String, String> a2 = com.zte.iptvclient.android.common.j.e.b().a();
            if (a2 != null) {
                Iterator<String> it2 = a2.keySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (str.equals(it2.next())) {
                        z = true;
                        break;
                    }
                }
            }
        }
        LogEx.d("ChildLockUtil", "checkIsLocked hasRatingLock  programRating " + str + z);
        return z;
    }

    public void d() {
        new SDKUserMgr().getUserProperties(new f(this));
    }

    public void e() {
        new SDKUserMgr().getUserProperties(new e(this));
    }

    public static boolean a(String str, h hVar, Context context) {
        if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
            return false;
        }
        TextUtils.isEmpty("1");
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            f6226c = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().i();
        } else {
            LogEx.d("ChildLockUtil", "strUserLevel " + f6226c);
            if ("0".equals(ConfigMgr.readPropertie("EuropeLogin"))) {
                String G = new h(context).G();
                f6226c = Integer.parseInt(G != null ? G : "0");
            } else {
                f6226c = hVar.t();
            }
        }
        LogEx.d("ChildLockUtil", "MainProperty strUserLevel " + f6226c);
        int i = f6226c;
        return (Integer.parseInt(str) & f6226c) != 0;
    }

    public void c() {
        if (f6225b.q().equals("1")) {
            f6225b.G().length();
        } else {
            new SDKUserMgr().getUserProperties(new g(this));
        }
    }

    public static boolean b(String str, Context context) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str) && context != null) {
            if (!TextUtils.equals("0", ConfigMgr.readPropertie("IsShowChildLock"))) {
                TextUtils.isEmpty("1");
                h hVar = new h(context);
                String G = hVar.G();
                String q = hVar.q();
                if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                    f6226c = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().i();
                    LogEx.d("ChildLockUtil", "strUserLevel " + f6226c);
                } else if ("1".equals(q)) {
                    f6226c = Integer.parseInt(G != null ? G : "0");
                } else {
                    f6226c = new h(context).t();
                }
                LogEx.d("ChildLockUtil", "MainProperty strUserLevel " + f6226c);
                int i = f6226c;
                if ((f6226c & Integer.parseInt(str)) != 0) {
                    z = true;
                }
            }
        }
        LogEx.d("ChildLockUtil", "checkIsLocked hasRatingLock  programRating " + str + z);
        return z;
    }

    public static boolean a(String str, Context context) {
        h hVar;
        if (context == null || !b(str, context) || (hVar = f6225b) == null || !hVar.C()) {
            return false;
        }
        String Y = new h(context).Y();
        return (TextUtils.isEmpty(Y) || "0".equals(Y)) ? false : true;
    }

    public static String a(String str, String str2, String str3, h hVar, Context context) {
        h hVar2;
        if ("1".equals(ConfigMgr.readPropertie("IsShowBlockTitle")) && a(str, hVar, context) && (hVar2 = f6225b) != null && hVar2.C()) {
            String Y = hVar.Y();
            if (!TextUtils.isEmpty(Y) && !"0".equals(Y)) {
                return str3;
            }
        }
        return str2;
    }

    public static void a(String str) {
        SDKUserDataMgr sDKUserDataMgr = new SDKUserDataMgr();
        GetUserDataReq getUserDataReq = new GetUserDataReq();
        getUserDataReq.datatype = DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT;
        getUserDataReq.profilecode = str;
        sDKUserDataMgr.getUserData(getUserDataReq, new b());
    }

    public static void b(Context context) {
        f6224a = new HashMap<>();
        h hVar = new h(context);
        String q = hVar.q();
        String F = hVar.F();
        if (q.equals("1")) {
            f6224a.clear();
            a(F);
            return;
        }
        SDKLockMgr sDKLockMgr = new SDKLockMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "500");
        hashMap.put("limittype", DownloadConstant.REPORT_MSGTYPE_ADD);
        hashMap.put("state", "1");
        sDKLockMgr.getUserLockList(hashMap, new C0251a());
    }

    public void a() {
        new SDKUserMgr().getUserProperties(new d(this));
    }

    public void b() {
        new SDKUserMgr().getUserProperties(new c(this));
    }
}
