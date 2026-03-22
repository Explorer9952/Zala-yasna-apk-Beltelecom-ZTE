package com.zte.iptvclient.android.common.f.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.zte.iptvclient.android.common.BaseApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TVHistoryMgr.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static com.zte.iptvclient.android.common.j.h f4581a;

    private static <T> void a(String str, List<T> list) {
        SharedPreferences.Editor edit = c().getSharedPreferences("share_data", 0).edit();
        if (list == null || list.size() <= 0) {
            return;
        }
        edit.putString(str, new Gson().toJson(list));
        edit.commit();
    }

    private static void b(List<com.zte.iptvclient.android.common.javabean.models.i> list) {
        a(h(), list);
    }

    private static Context c() {
        return BaseApp.e().getApplicationContext();
    }

    private static com.zte.iptvclient.android.common.j.h d() {
        com.zte.iptvclient.android.common.j.h hVar = f4581a;
        if (hVar != null) {
            return hVar;
        }
        com.zte.iptvclient.android.common.j.h hVar2 = new com.zte.iptvclient.android.common.j.h(c());
        f4581a = hVar2;
        return hVar2;
    }

    public static List<com.zte.iptvclient.android.common.javabean.models.i> e() {
        if (i()) {
            return a(h(), com.zte.iptvclient.android.common.javabean.models.i.class);
        }
        return null;
    }

    private static List<String> f() {
        List<String> a2 = a("tv_history_list", String.class);
        if (!a2.contains("tv_history_admin")) {
            a2.add(0, "tv_history_admin");
            a("tv_history_list", a2);
        }
        return a2;
    }

    private static String g() {
        return d().V();
    }

    private static String h() {
        return "tv_history_" + g();
    }

    private static boolean i() {
        return f().contains(h());
    }

    private static void b() {
        List<String> f = f();
        if (i()) {
            f.remove(h());
        }
        c(f);
    }

    private static void c(List<String> list) {
        a("tv_history_list", list);
    }

    private static <T> List<T> a(String str, Class<T> cls) {
        SharedPreferences sharedPreferences = c().getSharedPreferences("share_data", 0);
        ArrayList arrayList = new ArrayList();
        String string = sharedPreferences.getString(str, null);
        if (string == null) {
            return arrayList;
        }
        Gson gson = new Gson();
        Iterator<JsonElement> it2 = new JsonParser().parse(string).getAsJsonArray().iterator();
        while (it2.hasNext()) {
            arrayList.add(gson.fromJson(it2.next(), (Class) cls));
        }
        return arrayList;
    }

    public static void a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(g())) {
            return;
        }
        List a2 = i() ? a(str) : new ArrayList();
        a();
        if (a2 != null) {
            a((List<com.zte.iptvclient.android.common.javabean.models.i>) a2, new com.zte.iptvclient.android.common.javabean.models.i(str, str2, str3, str4));
        }
    }

    public static void a(List<com.zte.iptvclient.android.common.javabean.models.i> list) {
        List<com.zte.iptvclient.android.common.javabean.models.i> e = e();
        if (e != null && list != null) {
            e.removeAll(list);
        }
        if ((e == null ? -1 : e.size()) == 0) {
            b();
        }
        b(e);
    }

    private static void a() {
        if (i()) {
            return;
        }
        List<String> f = f();
        f.add(h());
        c(f);
    }

    private static List<com.zte.iptvclient.android.common.javabean.models.i> a(String str) {
        List<com.zte.iptvclient.android.common.javabean.models.i> e = e();
        if (e != null) {
            Iterator<com.zte.iptvclient.android.common.javabean.models.i> it2 = e.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                com.zte.iptvclient.android.common.javabean.models.i next = it2.next();
                if (TextUtils.equals(str, next.a())) {
                    e.remove(next);
                    break;
                }
            }
        }
        return e;
    }

    private static void a(List<com.zte.iptvclient.android.common.javabean.models.i> list, com.zte.iptvclient.android.common.javabean.models.i iVar) {
        list.add(0, iVar);
        if (list.size() == 51) {
            list.remove(50);
        }
        b(list);
    }
}
