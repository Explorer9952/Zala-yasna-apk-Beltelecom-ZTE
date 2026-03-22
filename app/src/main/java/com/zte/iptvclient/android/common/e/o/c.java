package com.zte.iptvclient.android.common.e.o;

/* compiled from: LoginReturnEvent.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f4468a;

    /* renamed from: b, reason: collision with root package name */
    private String f4469b;

    /* renamed from: c, reason: collision with root package name */
    private String f4470c;

    public void a(String str) {
        this.f4468a = str;
    }

    public void b(String str) {
        this.f4469b = str;
    }

    public String toString() {
        return "LoginReturnEvent{mReturncode='" + this.f4468a + "', mReturnNum='" + this.f4469b + "', mProfileFinish='" + this.f4470c + "'}";
    }

    public String a() {
        return this.f4468a;
    }
}
