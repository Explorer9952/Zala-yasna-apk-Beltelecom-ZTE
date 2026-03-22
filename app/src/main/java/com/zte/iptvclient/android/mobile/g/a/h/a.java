package com.zte.iptvclient.android.mobile.g.a.h;

import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.DeleteSchduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileDetailBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.UserVolumeBean;
import com.zte.iptvclient.android.mobile.g.a.c;

/* compiled from: CloudDvrPresenter.java */
/* loaded from: classes.dex */
public class a implements com.zte.iptvclient.android.mobile.g.a.a {

    /* renamed from: a, reason: collision with root package name */
    c f6261a;

    /* renamed from: b, reason: collision with root package name */
    com.zte.iptvclient.android.mobile.g.a.b f6262b;

    public a(c cVar, com.zte.iptvclient.android.mobile.g.a.b bVar) {
        this.f6261a = cVar;
        this.f6262b = bVar;
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        this.f6262b.c(str, str2, str3, str4, str5, this);
    }

    public void b(String str, String str2, String str3, String str4, String str5) {
        this.f6262b.b(str, str2, str3, str4, str5, this);
    }

    public void c(String str, String str2, String str3, String str4, String str5) {
        this.f6262b.a(str, str2, str3, str4, str5, this);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void d(Object obj) {
        this.f6261a.a((DeleteSchduleResultBean) obj);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void e(Object obj) {
        this.f6261a.a((RecordFileDetailBean) obj);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void f(Object obj) {
        this.f6261a.a((ScheduleResultBean) obj);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void g(String str) {
        this.f6261a.a(str);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void h(Object obj) {
        this.f6261a.b((String) obj);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        this.f6262b.a(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, this);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void b(String str) {
        this.f6261a.e(str);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void c(Object obj) {
        this.f6261a.a((ScheduleListBean) obj);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void d(String str) {
        this.f6261a.m(str);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void e(String str) {
        this.f6261a.h(str);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void f(String str) {
        this.f6261a.j(str);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void g(Object obj) {
        this.f6261a.a((RecordFileListBean) obj);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void h(String str) {
        this.f6261a.g(str);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f6262b.a(str, str2, str3, str4, str5, str6, str7, str8, this);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void b(Object obj) {
        this.f6261a.n((String) obj);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void c(String str) {
        this.f6261a.o(str);
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f6262b.a(str, str2, str3, str4, this);
    }

    public void a(String str, String str2, String str3) {
        this.f6262b.a(str, str2, str3, this);
    }

    public void a() {
        this.f6262b.a(this);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void a(String str) {
        this.f6261a.c(str);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.a
    public void a(Object obj) {
        this.f6261a.a((UserVolumeBean) obj);
    }
}
