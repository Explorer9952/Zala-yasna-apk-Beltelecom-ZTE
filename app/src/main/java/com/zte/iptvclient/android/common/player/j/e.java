package com.zte.iptvclient.android.common.player.j;

import java.util.ArrayList;
import java.util.List;

/* compiled from: AdVodPlayRsp.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private int f4963a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f4964b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f4965c = 3;

    /* renamed from: d, reason: collision with root package name */
    private int f4966d = -1;
    private List<d> e = new ArrayList();
    private List<d> f = new ArrayList();
    private List<c> g = new ArrayList();
    private List<b> h = new ArrayList();
    private List<a> i = new ArrayList();

    public int a() {
        return this.f4966d;
    }

    public void b(int i) {
        this.f4965c = i;
    }

    public void c(int i) {
        this.f4963a = i;
    }

    public void d(int i) {
        this.f4964b = i;
    }

    public int e() {
        return this.f4965c;
    }

    public int f() {
        return this.f4963a;
    }

    public int g() {
        return this.f4964b;
    }

    public List<d> h() {
        return this.e;
    }

    public List<d> i() {
        return this.f;
    }

    public void a(int i) {
        this.f4966d = i;
    }

    public void b(List<d> list) {
        this.f = list;
    }

    public List<b> c() {
        return this.h;
    }

    public List<c> d() {
        return this.g;
    }

    public void a(List<d> list) {
        this.e = list;
    }

    public List<a> b() {
        return this.i;
    }
}
