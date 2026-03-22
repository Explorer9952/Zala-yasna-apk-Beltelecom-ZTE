package com.zte.iptvclient.android.mobile.p.e;

import com.zte.iptvclient.android.mobile.npvr.model.bean.AddNpvrResultBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.DeleteNpvrResultBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrListBean;
import com.zte.iptvclient.android.mobile.p.b;
import com.zte.iptvclient.android.mobile.p.c;

/* compiled from: NpvrPresenter.java */
/* loaded from: classes.dex */
public class a implements com.zte.iptvclient.android.mobile.p.a {

    /* renamed from: a, reason: collision with root package name */
    c f7016a;

    /* renamed from: b, reason: collision with root package name */
    b f7017b;

    public a(c cVar, b bVar) {
        this.f7016a = cVar;
        this.f7017b = bVar;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f7017b.a(str, str2, str3, str4, str5, str6, str7, this);
    }

    @Override // com.zte.iptvclient.android.mobile.p.a
    public void b(Object obj) {
        this.f7016a.a((NpvrListBean) obj);
    }

    public void c(String str, String str2) {
        this.f7017b.a(str, str2, this);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f7017b.a(str, str2, str3, str4, str5, str6, this);
    }

    @Override // com.zte.iptvclient.android.mobile.p.a
    public void b(String str, String str2) {
        this.f7016a.b(str, str2);
    }

    @Override // com.zte.iptvclient.android.mobile.p.a
    public void c(Object obj) {
        this.f7016a.a((AddNpvrResultBean) obj);
    }

    @Override // com.zte.iptvclient.android.mobile.p.a
    public void a(String str) {
        this.f7016a.l(str);
    }

    @Override // com.zte.iptvclient.android.mobile.p.a
    public void a(Object obj) {
        this.f7016a.a((DeleteNpvrResultBean) obj);
    }

    @Override // com.zte.iptvclient.android.mobile.p.a
    public void a(String str, String str2) {
        this.f7016a.d(str, str2);
    }
}
