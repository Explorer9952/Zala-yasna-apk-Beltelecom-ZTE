package com.zte.iptvclient.android.mobile.home.tab.helper;

import android.content.Context;
import android.text.TextUtils;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class TabHostManager {
    private static Context e = null;
    private static String f = "BottomChildTabs";
    private static TabHostManager g;

    /* renamed from: a, reason: collision with root package name */
    private List<com.zte.iptvclient.android.mobile.l.c.a.b> f6418a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private List<com.zte.iptvclient.android.mobile.l.c.a.b> f6419b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<com.zte.iptvclient.android.mobile.l.c.a.b> f6420c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private List<com.zte.iptvclient.android.mobile.l.c.a.b> f6421d = new ArrayList();

    /* loaded from: classes.dex */
    public enum TabName {
        MAIN,
        ACCOUNT,
        FAVORITE,
        BOOKMARK,
        WATCHRECORD,
        ORDER,
        CACHE,
        CHILDLOCK,
        STB,
        REMOTE,
        SETTING,
        HOME,
        TV,
        VOD,
        APPCENTER,
        DISCOVER,
        RECORDING,
        RESERVATION,
        MINE,
        HOMEMAGAZINE,
        CUSTOMIZATIONCENTER,
        HELPBACK,
        INTERACT,
        PACKAGE,
        DOWNLOAD,
        REMINDER,
        PARENTAL,
        HELP,
        MESSAGE,
        PPV,
        BINDING,
        CONSUMPTIONRECORDS,
        FEATUREPACKAGE,
        CHANNELLINEUP,
        BALANCE,
        SHARE,
        MY,
        REMOTER,
        RETURN,
        TV_CHILD,
        VOD_CHILD,
        QUIZ_CHILD,
        WATCHHISTORY_CHILD
    }

    private TabHostManager() {
    }

    private void e() {
        LogEx.d("TabHostManager", "checkTabsUpdate");
        String a2 = h.a(e, "TabVersion", null);
        if (TextUtils.isEmpty(a2)) {
            LogEx.d("TabHostManager", "not need update");
            Context context = e;
            h.b(context, "TabVersion", g.c(context));
        } else {
            if (a2.equals(g.c(e))) {
                return;
            }
            LogEx.d("TabHostManager", "need update");
            l();
        }
    }

    private void f() {
        this.f6418a.clear();
        this.f6419b.clear();
        this.f6420c.clear();
    }

    public static synchronized TabHostManager g() {
        TabHostManager tabHostManager;
        synchronized (TabHostManager.class) {
            if (g == null) {
                g = new TabHostManager();
            }
            tabHostManager = g;
        }
        return tabHostManager;
    }

    private void h() {
        String a2 = h.a(e, f, null);
        if (TextUtils.isEmpty(a2)) {
            LogEx.d("TabHostManager", "get bottomChildTabs from ini");
            a2 = ConfigMgr.readPropertie(f);
            h.b(e, f, a2);
        }
        String[] split = a2 != null ? a2.split(",") : null;
        if (split != null) {
            for (int i = 0; i < split.length; i++) {
                try {
                    if (!TextUtils.isEmpty(split[i])) {
                        TabName tabName = (TabName) Enum.valueOf(TabName.class, split[i]);
                        if (com.zte.iptvclient.android.mobile.l.c.a.a.a(e, tabName) != null) {
                            this.f6421d.add(com.zte.iptvclient.android.mobile.l.c.a.a.a(e, tabName));
                        }
                    }
                } catch (Exception e2) {
                    LogEx.e("TabHostManager", "prepareBottomChildTab Enum.valueOf to ItemFactory getExceptiom=" + e2.getMessage());
                    return;
                }
            }
        }
    }

    private void i() {
        String a2 = h.a(e, "BottomTabs", null);
        if (TextUtils.isEmpty(a2)) {
            LogEx.d("TabHostManager", "get bottomTabs from ini");
            a2 = ConfigMgr.readPropertie("BottomTabs");
            h.b(e, "BottomTabs", a2);
        }
        String[] split = a2 != null ? a2.split(",") : null;
        if (split != null) {
            for (int i = 0; i < split.length; i++) {
                try {
                    if (!TextUtils.isEmpty(split[i])) {
                        TabName tabName = (TabName) Enum.valueOf(TabName.class, split[i]);
                        if (com.zte.iptvclient.android.mobile.l.c.a.a.a(e, tabName) != null) {
                            this.f6420c.add(com.zte.iptvclient.android.mobile.l.c.a.a.a(e, tabName));
                        }
                    }
                } catch (Exception e2) {
                    LogEx.e("TabHostManager", "prepareBottomTab Enum.valueOf to ItemFactory getExceptiom=" + e2.getMessage());
                    return;
                }
            }
        }
    }

    private void j() {
        String a2 = h.a(e, "MY_MenuTabs", null);
        if (TextUtils.isEmpty(a2)) {
            LogEx.d("TabHostManager", "get mySlideMenuTabProKey from ini");
            a2 = ConfigMgr.readPropertie("MY_MenuTabs");
            h.b(e, "MY_MenuTabs", a2);
        }
        String[] split = a2 != null ? a2.split(",") : null;
        if (split != null) {
            for (int i = 0; i < split.length; i++) {
                try {
                    if (!TextUtils.isEmpty(split[i])) {
                        TabName tabName = (TabName) Enum.valueOf(TabName.class, split[i]);
                        if (com.zte.iptvclient.android.mobile.c0.a.a.a(e, tabName) != null) {
                            this.f6419b.add(com.zte.iptvclient.android.mobile.c0.a.a.a(e, tabName));
                        }
                    }
                } catch (Exception e2) {
                    LogEx.e("TabHostManager", "prepareMYSlideTab getException:" + e2.getMessage());
                    return;
                }
            }
        }
    }

    private void k() {
        LogEx.d("TabHostManager", "get slideTabs from ini");
        String readPropertie = ConfigMgr.readPropertie("MenuTabs");
        h.b(e, "MenuTabs", readPropertie);
        String[] split = readPropertie != null ? readPropertie.split(",") : null;
        if (split != null) {
            for (int i = 0; i < split.length; i++) {
                try {
                    if (!TextUtils.isEmpty(split[i])) {
                        TabName tabName = (TabName) Enum.valueOf(TabName.class, split[i]);
                        if (com.zte.iptvclient.android.mobile.c0.a.a.a(e, tabName) != null) {
                            this.f6418a.add(com.zte.iptvclient.android.mobile.c0.a.a.a(e, tabName));
                        }
                    }
                } catch (Exception e2) {
                    LogEx.e("TabHostManager", "prepareSlideTab getException:" + e2.getMessage());
                    return;
                }
            }
            LogEx.d("TabHostManager", "slideMenuTabs =" + this.f6418a.size());
        }
    }

    private void l() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(h.a(e, "MenuTabs", ""));
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(h.a(e, "MY_MenuTabs", ""));
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(h.a(e, "BottomTabs", ""));
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(h.a(e, f, ""));
            LogEx.d("TabHostManager", "local old tabs:" + sb.toString());
            if (sb.length() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(Arrays.asList(sb.toString().split(",")));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ConfigMgr.readPropertie("MenuTabs"));
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(ConfigMgr.readPropertie("MY_MenuTabs"));
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(ConfigMgr.readPropertie("BottomTabs"));
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(ConfigMgr.readPropertie(f));
                LogEx.d("TabHostManager", "new ini tabs:" + sb2.toString());
                List asList = Arrays.asList(sb2.toString().split(","));
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(asList);
                arrayList2.removeAll(arrayList);
                if (arrayList2.size() > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(h.a(e, "MenuTabs", ""));
                    for (int i = 0; i < arrayList2.size(); i++) {
                        sb3.append(",");
                        sb3.append(arrayList2.get(i));
                    }
                    h.b(e, "MenuTabs", sb3.toString());
                }
                arrayList.remove(asList);
                if (arrayList.size() > 0) {
                    String a2 = h.a(e, "MenuTabs", null);
                    String a3 = h.a(e, "MY_MenuTabs", null);
                    String a4 = h.a(e, "BottomTabs", null);
                    String a5 = h.a(e, f, null);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (a2 == null) {
                            return;
                        }
                        String str = (String) arrayList.get(i2);
                        a2 = a2.replace(str + ",", "").replace(str, "").trim();
                        if (a2.endsWith(",")) {
                            a2 = a2.substring(0, a2.length() - 1);
                        }
                        if (!TextUtils.isEmpty(a3)) {
                            a3 = a3.replace(str + ",", "").replace(str, "").trim();
                            if (a3.endsWith(",")) {
                                a3 = a3.substring(0, a3.length() - 1);
                            }
                        }
                        if (a4 != null) {
                            a4 = a4.replace(str + ",", "").replace(str, "").trim();
                            if (a4.endsWith(",")) {
                                a4 = a4.substring(0, a4.length() - 1);
                            }
                        }
                        if (a5 != null) {
                            a5 = a5.replace(str + ",", "").replace(str, "").trim();
                            if (a5.endsWith(",")) {
                                a5 = a5.substring(0, a5.length() - 1);
                            }
                        }
                    }
                    h.b(e, "MenuTabs", a2);
                    LogEx.d("TabHostManager", "finally slideMenuTabs:" + a2);
                    h.b(e, "MY_MenuTabs", a3);
                    LogEx.d("TabHostManager", "finally myslideMenuTabs:" + a3);
                    h.b(e, "BottomTabs", a4);
                    LogEx.d("TabHostManager", "finally bottomTabs:" + a4);
                    h.b(e, f, a5);
                    LogEx.d("TabHostManager", "finally bottomChildTabs:" + a5);
                }
            }
        } catch (Exception e2) {
            LogEx.e("TabHostManager", "updateTabs getException:" + e2.getMessage());
        }
    }

    public void a(Context context) {
        e = context.getApplicationContext();
        if (TextUtils.equals(ConfigMgr.readPropertie("IsHideQuizChild"), "1")) {
            f = "BottomChildTabs_NOQUIZ";
        }
        e();
        f();
        k();
        j();
        i();
        h();
    }

    public List<com.zte.iptvclient.android.mobile.l.c.a.b> b() {
        return this.f6420c;
    }

    public List<com.zte.iptvclient.android.mobile.l.c.a.b> c() {
        return this.f6419b;
    }

    public List<com.zte.iptvclient.android.mobile.l.c.a.b> d() {
        return this.f6418a;
    }

    public List<com.zte.iptvclient.android.mobile.l.c.a.b> a() {
        return this.f6421d;
    }
}
