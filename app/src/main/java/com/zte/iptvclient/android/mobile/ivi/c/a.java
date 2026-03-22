package com.zte.iptvclient.android.mobile.ivi.c;

import org.json.JSONObject;

/* compiled from: PurchaseParams.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f6594a;

    public void A(String str) {
    }

    public void B(String str) {
    }

    public void C(String str) {
    }

    public void D(String str) {
    }

    public void E(String str) {
    }

    public void F(String str) {
    }

    public void G(String str) {
    }

    public void H(String str) {
    }

    public void I(String str) {
        this.f6594a = str;
    }

    public void J(String str) {
    }

    public String a() {
        return this.f6594a;
    }

    public void a(String str) {
    }

    public void b(String str) {
    }

    public void c(String str) {
    }

    public void d(String str) {
    }

    public void e(String str) {
    }

    public void f(String str) {
    }

    public void g(String str) {
    }

    public void h(String str) {
    }

    public void i(String str) {
    }

    public void j(String str) {
    }

    public void k(String str) {
    }

    public void l(String str) {
    }

    public void m(String str) {
    }

    public void n(String str) {
    }

    public void o(String str) {
    }

    public void p(String str) {
    }

    public void q(String str) {
    }

    public void r(String str) {
    }

    public void s(String str) {
    }

    public void t(String str) {
    }

    public void u(String str) {
    }

    public void v(String str) {
    }

    public void w(String str) {
    }

    public void x(String str) {
    }

    public void y(String str) {
    }

    public void z(String str) {
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.q(jSONObject.optString("_ownership_type"));
            aVar.z(jSONObject.optString("_quality"));
            aVar.p(jSONObject.optString("_object_type"));
            aVar.o(jSONObject.optString("_object_id"));
            aVar.B(jSONObject.optString("_renew_period_seconds"));
            aVar.t(jSONObject.optString("_price"));
            aVar.y(jSONObject.optString("_ps_price"));
            aVar.r(jSONObject.optString("_partial_debit_price"));
            aVar.x(jSONObject.optString("_ps_key"));
            aVar.E(jSONObject.optString("_subsite_id"));
            aVar.w(jSONObject.optString("_ps_account_id"));
            aVar.s(jSONObject.optString("_preorder"));
            aVar.I(jSONObject.optString("_uid"));
            aVar.H(jSONObject.optString("_ts"));
            aVar.J(jSONObject.optString("_uuid"));
            aVar.u(jSONObject.optString("_product_identifier"));
            aVar.h(jSONObject.optString("_currency"));
            aVar.k(jSONObject.optString("_finish_time"));
            aVar.i(jSONObject.optString("_discount_program_id"));
            aVar.C(jSONObject.optString("_renewal_initial_period"));
            aVar.D(jSONObject.optString("_renewal_price"));
            aVar.G(jSONObject.optString("_trial_id"));
            aVar.F(jSONObject.optString("_trial_group_key"));
            aVar.A(jSONObject.optString("_referrer_content_id"));
            aVar.e(jSONObject.optString("_change_card"));
            aVar.f(jSONObject.optString("_change_tariff"));
            aVar.d(jSONObject.optString("_certificate_pool_id"));
            aVar.g(jSONObject.optString("_content_mts_id"));
            aVar.v(jSONObject.optString("_profile_id"));
            aVar.j(jSONObject.optString("_downloadable"));
            aVar.l(jSONObject.optString("_mobile_offer_signature"));
            aVar.m(jSONObject.optString("_mobile_offer_timestamp"));
            aVar.n(jSONObject.optString("_mobile_offer_uuid"));
            aVar.b(jSONObject.optString("mobile_offer_key_id"));
            aVar.a(jSONObject.optString("app_version"));
            aVar.c(jSONObject.optString("sign"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aVar;
    }
}
