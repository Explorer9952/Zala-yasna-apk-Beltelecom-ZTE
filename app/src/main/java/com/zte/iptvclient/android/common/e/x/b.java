package com.zte.iptvclient.android.common.e.x;

/* compiled from: ChannelClickSwitchEvent.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f4493a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4494b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4495c;

    /* renamed from: d, reason: collision with root package name */
    private String f4496d;

    public b(int i, boolean z, boolean z2, String str) {
        this.f4493a = 0;
        this.f4494b = false;
        this.f4495c = false;
        this.f4496d = "";
        this.f4493a = i;
        this.f4494b = z;
        this.f4495c = z2;
        this.f4496d = str;
    }

    public int a() {
        return this.f4493a;
    }

    public String b() {
        return this.f4496d;
    }

    public boolean c() {
        return this.f4494b;
    }

    public boolean d() {
        return this.f4495c;
    }
}
