package com.zte.iptvclient.android.common.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.Constants;
import java.util.ArrayList;

/* compiled from: Preference.java */
/* loaded from: classes.dex */
public class h {
    private static String s0 = "useeTvPref";
    public static String t0 = "signout";

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f4683a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f4684b;
    private String r0;

    /* renamed from: c, reason: collision with root package name */
    private String f4685c = "loginType";

    /* renamed from: d, reason: collision with root package name */
    private String f4686d = Constants.SINA_WEIBO_USERNAME;
    private String e = "password";
    private String f = "isRemember";
    private String g = "isFirstLauncher";
    private String h = "isFirstInApp";
    private String i = "isFirstToHome";
    private String j = "isFirstToSTB";
    private String k = "isFirstToDetil";
    private String l = "isRemoteSunTheme";
    private String m = "isNoticeMessage";
    private String n = "isFirstCloseFloat";
    private String o = "account_history";
    private String p = "oldUserName";
    private String q = "iptvAccount";
    private String r = "nickName";
    private String s = "updatetokenkey";
    private String t = "Access_Token";
    private String u = "AppId";
    private String v = "Channel_Uid";
    private String w = "Market_Url";
    private String x = "epgaddr";
    private String y = ParamConst.LOGIN_TRUE_EPGPORT;
    private String z = ParamConst.LOGIN_75_SESSIONID;
    private String A = "recommendservice";
    private String B = "impserver";
    private String C = "userloginfailed";
    private String D = "frameid";
    private String E = "search_history";
    private String F = "timestamp";
    private String G = "stb_deviceid";
    private String H = "stb_udn";
    private String I = "limit_level";
    private String J = "profilecode";
    private String K = "limit_password";
    private String L = "order_password";
    private String M = "accept_voice_ad";
    private String N = "version_new";
    private String O = "version_update_url";
    private String P = "version_update_time";
    private String Q = "update_url";
    private String R = "version_option_update";
    private String S = "update_resource_url";
    private String T = "vod_show_blocktitle";
    private String U = "channel_show_blocktitle";
    private String V = "zone_catname";
    private String W = "zone_province";
    private String X = "user_nickname_to_stb";
    private String Y = "favorite_show_gridview";
    private String Z = "stb_cpcode";
    private String a0 = "skin_file_name";
    private String b0 = "order_check";
    private String c0 = "parental_check";
    private String d0 = "isaccountrem";
    private String e0 = "profilelogin";
    private String f0 = "profileroleid";
    private String g0 = com.video.androidsdk.service.comm.ParamConst.ORDERED_PRODUCT_QUERY_RSP_ISSUBSCIBE;
    private String h0 = "profilepassword";
    private String i0 = "profileblock";
    private String j0 = "profilelevel";
    private String k0 = "bossusercode";
    private String l0 = "ischannellineupfragment";
    private String m0 = "remoteIsClickeable";
    private String n0 = "balance";
    private String o0 = "megogoauth";
    private String p0 = "access_token";
    private String q0 = "svod_expiration";

    public h(Context context) {
        new ArrayList();
        this.r0 = "";
        SharedPreferences sharedPreferences = context.getSharedPreferences(s0, 0);
        this.f4683a = sharedPreferences;
        this.f4684b = sharedPreferences.edit();
    }

    public void A(String str) {
        this.f4684b.putString(this.Z, str);
        this.f4684b.commit();
    }

    public void B(String str) {
        this.f4684b.putString(this.G, str);
        this.f4684b.commit();
    }

    public void C(String str) {
        this.f4684b.putString(this.H, str);
        this.f4684b.commit();
    }

    public boolean C() {
        return true;
    }

    public String D() {
        return this.f4683a.getString(this.e, "");
    }

    public String E() {
        return this.f4683a.getString(this.i0, "");
    }

    public String F() {
        return this.f4683a.getString(this.J, "");
    }

    public String G() {
        return this.f4683a.getString(this.j0, "");
    }

    public String H() {
        return this.f4683a.getString(this.f0, "");
    }

    public boolean I() {
        return this.f4683a.getBoolean(this.m0, false);
    }

    public void J(String str) {
        this.f4684b.putString(this.X, str);
        this.f4684b.commit();
    }

    public void K(String str) {
        this.f4684b.putString(this.f4686d, str);
        this.f4684b.commit();
    }

    public String L() {
        return this.f4683a.getString(this.H, "");
    }

    public String M() {
        return this.f4683a.getString(this.E, "");
    }

    public String N() {
        return this.f4683a.getString(this.z, "");
    }

    public void O(String str) {
        this.f4684b.putString(this.T, str);
        this.f4684b.commit();
    }

    public boolean P() {
        return this.f4683a.getBoolean(this.g0, false);
    }

    public String Q() {
        return this.f4683a.getString(this.F, "");
    }

    public String R() {
        return this.f4683a.getString(this.S, "");
    }

    public String S() {
        return this.f4683a.getString(this.Q, "");
    }

    public int T() {
        return this.f4683a.getInt(this.s, 0);
    }

    public String U() {
        return this.f4683a.getString(this.X, "");
    }

    public String V() {
        return this.f4683a.getString(this.f4686d, "");
    }

    public String W() {
        return this.f4683a.getString(this.N, "");
    }

    public String X() {
        return this.f4683a.getString(this.O, "");
    }

    public String Y() {
        return this.f4683a.getString(this.T, "");
    }

    public String Z() {
        return this.f4683a.getString(this.V, "");
    }

    public void a(String str) {
        this.f4684b.putString(this.t, str);
        this.f4684b.commit();
    }

    public String a0() {
        return this.f4683a.getString(this.W, "");
    }

    public String b() {
        return this.f4683a.getString(this.o, "");
    }

    public Boolean b0() {
        if (2 == com.zte.iptvclient.common.uiframe.b.c().a()) {
            return true;
        }
        return false;
    }

    public String c() {
        return TextUtils.isEmpty(this.f4683a.getString(this.n0, "")) ? "0.00" : this.f4683a.getString(this.n0, "");
    }

    public void d(String str) {
        this.f4684b.putString(this.n0, str);
        LogEx.d("Preference", "onBalanceReturn=" + str);
        this.f4684b.commit();
    }

    public void e(String str) {
        this.f4684b.putString(this.k0, str);
        this.f4684b.commit();
    }

    public void f(boolean z) {
        this.f4684b.putBoolean(this.i, z);
        this.f4684b.commit();
    }

    public void g(boolean z) {
        this.f4684b.putBoolean(this.j, z);
        this.f4684b.commit();
    }

    public String h() {
        return this.f4683a.getString(this.r0, "");
    }

    public void i(boolean z) {
        this.f4684b.putBoolean(this.m, z);
        this.f4684b.commit();
    }

    public String j() {
        return this.f4683a.getString(this.q, "");
    }

    public void k(String str) {
        this.f4684b.putString(this.r0, str);
        this.f4684b.commit();
    }

    public void l(boolean z) {
        this.f4684b.putBoolean(t0, z);
        this.f4684b.commit();
    }

    public void m(boolean z) {
        this.f4684b.putBoolean(this.o0, z);
        this.f4684b.commit();
    }

    public void n(String str) {
        this.f4684b.putString(this.d0, str);
        this.f4684b.commit();
    }

    public String o() {
        return this.f4683a.getString(this.C, "0");
    }

    public void p(boolean z) {
        this.f4684b.putBoolean(this.m0, z);
        this.f4684b.commit();
    }

    public String q() {
        return this.f4683a.getString(this.e0, "");
    }

    public boolean r() {
        return this.f4683a.getBoolean(this.f, true);
    }

    public void s(String str) {
        this.f4684b.putString(this.p0, str);
        this.f4684b.commit();
    }

    public void t(String str) {
        this.f4684b.putString(this.q0, str);
        this.f4684b.commit();
    }

    public void u(String str) {
        this.f4684b.putString(this.r, str);
        this.f4684b.commit();
    }

    public String v() {
        return this.f4683a.getString(this.p0, "");
    }

    public boolean w() {
        return this.f4683a.getBoolean(this.o0, false);
    }

    public String x() {
        return this.f4683a.getString(this.q0, "");
    }

    public void y(String str) {
        this.f4684b.putString(this.h0, str);
        this.f4684b.commit();
    }

    public String z() {
        return this.f4683a.getString(this.p, "");
    }

    public void D(String str) {
        this.f4684b.putString(this.E, str);
        this.f4684b.commit();
    }

    public void E(String str) {
        this.f4684b.putString(this.z, str);
        this.f4684b.commit();
    }

    public void F(String str) {
        this.f4684b.putString(this.a0, str);
        this.f4684b.commit();
    }

    public void G(String str) {
        this.f4684b.putString(this.F, str);
        this.f4684b.commit();
    }

    public void H(String str) {
        this.f4684b.putString(this.S, str);
        this.f4684b.commit();
    }

    public void I(String str) {
        this.f4684b.putString(this.Q, str);
        this.f4684b.commit();
    }

    public void L(String str) {
        this.f4684b.putString(this.N, str);
        this.f4684b.commit();
    }

    public void M(String str) {
        this.f4684b.putString(this.P, str);
        this.f4684b.commit();
    }

    public void N(String str) {
        this.f4684b.putString(this.O, str);
        this.f4684b.commit();
    }

    public void P(String str) {
        this.f4684b.putString(this.V, str);
        this.f4684b.commit();
    }

    public void Q(String str) {
        this.f4684b.putString(this.W, str);
        this.f4684b.commit();
    }

    public void b(String str) {
        this.f4684b.putString(this.o, str);
        this.f4684b.commit();
    }

    public void h(String str) {
        this.f4684b.putString(this.x, str);
        this.f4684b.commit();
    }

    public void j(boolean z) {
        this.f4684b.putBoolean(this.f, z);
        this.f4684b.commit();
    }

    public void o(String str) {
        this.f4684b.putString(this.C, str);
        this.f4684b.commit();
    }

    public void q(String str) {
        this.f4684b.putString(this.f4685c, str);
        this.f4684b.commit();
    }

    public void r(String str) {
        this.f4684b.putString(this.w, str);
        this.f4684b.commit();
    }

    public void v(String str) {
        this.f4684b.putString(this.p, str);
        this.f4684b.commit();
    }

    public void w(String str) {
        this.f4684b.putString(this.L, str);
        this.f4684b.commit();
    }

    public void x(String str) {
        this.f4684b.putString(this.e, str);
        this.f4684b.commit();
    }

    public void z(String str) {
        this.f4684b.putString(this.A, str);
        this.f4684b.commit();
    }

    public boolean A() {
        return this.f4683a.getBoolean(this.b0, false);
    }

    public String B() {
        return this.f4683a.getString(this.L, "");
    }

    public String J() {
        return this.f4683a.getString(this.Z, "");
    }

    public String K() {
        return this.f4683a.getString(this.G, "");
    }

    public String O() {
        return this.f4683a.getString(this.a0, "white.skin");
    }

    public void a(int i) {
        this.f4684b.putInt(this.I, i);
        this.f4684b.commit();
    }

    public void c(boolean z) {
        this.f4684b.putBoolean(this.h, z);
        this.f4684b.commit();
    }

    public void e(boolean z) {
        this.f4684b.putBoolean(this.k, z);
        this.f4684b.commit();
    }

    public void f(String str) {
        this.f4684b.putString(this.l0, str);
        this.f4684b.commit();
    }

    public void g(String str) {
        this.f4684b.putString(this.v, str);
        this.f4684b.commit();
    }

    public void i(String str) {
        this.f4684b.putString(this.y, str);
        this.f4684b.commit();
    }

    public void k(boolean z) {
        this.f4684b.putBoolean(this.l, z);
        this.f4684b.commit();
    }

    public boolean l() {
        return this.f4683a.getBoolean(this.n, true);
    }

    public void m(String str) {
        this.f4684b.putString(this.q, str);
        this.f4684b.commit();
    }

    public boolean n() {
        return this.f4683a.getBoolean(this.g, true);
    }

    public boolean p() {
        return this.f4683a.getBoolean(this.m, true);
    }

    public boolean s() {
        return this.f4683a.getBoolean(this.l, true);
    }

    public int t() {
        return this.f4683a.getInt(this.I, 0);
    }

    public String u() {
        return this.f4683a.getString(this.K, "");
    }

    public String y() {
        return this.f4683a.getString(this.r, "");
    }

    public void b(boolean z) {
        this.f4684b.putBoolean(this.n, z);
        this.f4684b.commit();
    }

    public String d() {
        return this.f4683a.getString(this.k0, "");
    }

    public void h(boolean z) {
        this.f4684b.putBoolean(this.R, z);
        this.f4684b.commit();
    }

    public void j(String str) {
        this.f4684b.putString(this.D, str);
        this.f4684b.commit();
    }

    public void l(String str) {
        this.f4684b.putString(this.B, str);
        this.f4684b.commit();
    }

    public void n(boolean z) {
        this.f4684b.putBoolean(this.b0, z);
        this.f4684b.commit();
    }

    public void o(boolean z) {
        this.f4684b.putBoolean(this.c0, z);
        this.f4684b.commit();
    }

    public void p(String str) {
        this.f4684b.putString(this.K, str);
        this.f4684b.commit();
    }

    public boolean a() {
        return this.f4683a.getBoolean(this.M, false);
    }

    public void c(String str) {
        this.f4684b.putString(this.u, str);
        this.f4684b.commit();
    }

    public void d(boolean z) {
        this.f4684b.putBoolean(this.g, z);
        this.f4684b.commit();
    }

    public String e() {
        return this.f4683a.getString(this.U, "");
    }

    public String f() {
        return this.f4683a.getString(this.x, "");
    }

    public String g() {
        return this.f4683a.getString(this.D, "");
    }

    public String i() {
        return this.f4683a.getString(this.B, "");
    }

    public boolean k() {
        return this.f4683a.getBoolean(this.Y, true);
    }

    public boolean m() {
        return this.f4683a.getBoolean(this.h, true);
    }

    public void a(boolean z) {
        this.f4684b.putBoolean(this.Y, z);
        this.f4684b.commit();
    }

    public void b(int i) {
        this.f4684b.putInt(this.s, i);
        this.f4684b.commit();
    }

    public static String a(Context context, String str, String str2) {
        return context.getSharedPreferences(s0, 0).getString(str, str2);
    }

    public static boolean b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(s0, 0).edit();
        edit.putString(str, str2);
        return edit.commit();
    }
}
