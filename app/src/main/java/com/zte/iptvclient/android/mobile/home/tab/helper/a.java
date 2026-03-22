package com.zte.iptvclient.android.mobile.home.tab.helper;

import android.content.Context;
import android.text.TextUtils;
import com.video.androidsdk.common.PreferenceHelper;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: ChildModeManager.java */
/* loaded from: classes.dex */
public class a {
    private static a m;

    /* renamed from: a, reason: collision with root package name */
    private String f6422a = "ChildModeManager";

    /* renamed from: b, reason: collision with root package name */
    private String f6423b = "childe_mode";

    /* renamed from: c, reason: collision with root package name */
    private String f6424c = "childe_play_max_minute";

    /* renamed from: d, reason: collision with root package name */
    private String f6425d = "childe_play_mor_start_time";
    private String e = "childe_play_mor_end_time";
    private String f = "childe_play_evn_start_time";
    private String g = "childe_play_evn_end_time";
    private String h = "childe_played_left_minute";
    private String i = "childe_user_level";
    private String j = "childe_played_left_minute_update_time";
    private String k = "guestphone";
    private SimpleDateFormat l = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);

    private PreferenceHelper g(String str) {
        Context applicationContext = BaseApp.e().getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        LogEx.d(this.f6422a, "getShareSharedPreferencesByAccount =" + str);
        return new PreferenceHelper(applicationContext, str);
    }

    private boolean h(String str) {
        boolean startsWith = str.startsWith("guest");
        LogEx.d(this.f6422a, "isGuestPhoneLogined " + startsWith + " foe currentAcounts " + str);
        return startsWith;
    }

    private boolean l() {
        String f = f();
        if (TextUtils.isEmpty(f)) {
            return false;
        }
        try {
            Date parse = this.l.parse(f);
            if (parse == null) {
                return false;
            }
            LogEx.d(this.f6422a, " lastData " + f + " getDay" + parse.getDay());
            LogEx.d(this.f6422a, " nowData " + s.b() + " getDay" + s.b().getDay());
            return parse.getDay() != s.b().getDay();
        } catch (Exception unused) {
            return false;
        }
    }

    private String m() {
        this.k = "guestphone";
        Context applicationContext = BaseApp.e().getApplicationContext();
        if (applicationContext != null) {
            this.k = new h(applicationContext).V();
        }
        LogEx.d(this.f6422a, " for currentAcounts " + this.k);
        return this.k;
    }

    public static a n() {
        if (m == null) {
            m = new a();
        }
        return m;
    }

    public boolean a() {
        if (!com.zte.iptvclient.android.mobile.n.c.b.t() || h(m())) {
            return false;
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            boolean z = g.getBoolean(this.f6423b, false);
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " get childeMode " + z);
            return z;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
        return false;
    }

    public void b(String str) {
        if (h(m())) {
            LogEx.d(this.f6422a, "isGuestPhoneLogined return setDate");
            return;
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            g.putString(this.f6425d, str);
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " update AmStartTime for seted " + str);
            return;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
    }

    public void c(String str) {
        if (h(m())) {
            LogEx.d(this.f6422a, "isGuestPhoneLogined return setDate");
            return;
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            g.putString(this.f6424c, str);
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " update KEY_CHILD_MAX_PALY_MINUTE for seted " + str);
            return;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
    }

    public String d() {
        if (h(m())) {
            return "";
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            String string = g.getString(this.f6424c, "");
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " get PlayMaxMinut " + string);
            return string;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
        return "";
    }

    public void e(String str) {
        if (h(m())) {
            LogEx.d(this.f6422a, "isGuestPhoneLogined return setDate");
            return;
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            g.putString(this.g, str);
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " update PmEndTime for seted " + str);
            return;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
    }

    public void f(String str) {
        if (h(m())) {
            LogEx.d(this.f6422a, "isGuestPhoneLogined return setDate");
            return;
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            g.putString(this.f, str);
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " update AmStartTime for seted " + str);
            return;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
    }

    public int i() {
        int i = 0;
        if (!h(m())) {
            PreferenceHelper g = g(m());
            if (g != null) {
                int i2 = g.getInt(this.i, 0);
                i = i2 == 0 ? 16 : i2;
                LogEx.d(this.f6422a, " current strAccounts =" + this.k + " get userlevel " + i);
            } else {
                LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
            }
        }
        return i;
    }

    public void j() {
        if (h(m())) {
            LogEx.d(this.f6422a, "isGuestPhoneLogined return setDate");
            return;
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            String d2 = d();
            g.putString(this.h, d2);
            k();
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " update resert for 00:00;PlayedLeftTime for seted " + d2);
            return;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
    }

    public void k() {
        if (h(m())) {
            LogEx.d(this.f6422a, "isGuestPhoneLogined return setDate");
            return;
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            String format = this.l.format(s.b());
            g.putString(this.j, format);
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " update PlayedLeftTimeUpdateTime for seted " + format);
            return;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
    }

    public String h() {
        if (h(m())) {
            return "";
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            String string = g.getString(this.f, "");
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " get PmStartTime " + string);
            return string;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
        return "";
    }

    public String g() {
        if (h(m())) {
            return "";
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            String string = g.getString(this.g, "");
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " get PmEndTime " + string);
            return string;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
        return "";
    }

    public void d(String str) {
        if (h(m())) {
            LogEx.d(this.f6422a, "isGuestPhoneLogined return setDate");
            return;
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            g.putString(this.h, str);
            k();
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " update PlayedLeftTime for seted " + str);
            return;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
    }

    public void a(boolean z) {
        if (h(m())) {
            LogEx.d(this.f6422a, "isGuestPhoneLogined return setDate");
            return;
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            g.putBoolean(this.f6423b, Boolean.valueOf(z));
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " update childeMode for seted " + z);
            return;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
    }

    public String b() {
        if (h(m())) {
            return "";
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            String string = g.getString(this.e, "");
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " get AmEndTime " + string);
            return string;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
        return "";
    }

    public String c() {
        if (h(m())) {
            return "";
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            String string = g.getString(this.f6425d, "");
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " get AmStartTime " + string);
            return string;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
        return "";
    }

    public String e() {
        String string;
        if (h(m())) {
            return "";
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            if (l()) {
                j();
                string = d();
                LogEx.d(this.f6422a, " current strAccounts =" + this.k + " get reInitChildModePlayedLeftMinutes PlayedLeftTime " + string);
            } else {
                string = g.getString(this.h, "");
            }
            String str = string;
            k();
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " get PlayedLeftTime " + str);
            return str;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
        return "";
    }

    public String f() {
        String format = this.l.format(s.b());
        if (h(m())) {
            return format;
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            String string = g.getString(this.j, format);
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " get PlayedLeftTime updateTime " + string);
            return string;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
        return format;
    }

    public void a(String str) {
        if (h(m())) {
            LogEx.d(this.f6422a, "isGuestPhoneLogined return setDate");
            return;
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            g.putString(this.e, str);
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " update AmEndTime for seted " + str);
            return;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
    }

    public void a(int i) {
        if (h(m())) {
            LogEx.d(this.f6422a, "isGuestPhoneLogined return setDate");
            return;
        }
        PreferenceHelper g = g(m());
        if (g != null) {
            g.putInt(this.i, i);
            LogEx.d(this.f6422a, " current strAccounts =" + this.k + " update userlevel for seted " + i);
            return;
        }
        LogEx.e(this.f6422a, "getShareSharedPreferencesByAccount =" + this.k + " is null !!!");
    }
}
