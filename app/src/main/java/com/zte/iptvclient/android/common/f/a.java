package com.zte.iptvclient.android.common.f;

import android.os.CountDownTimer;

/* compiled from: AuthCodeTimeCount.java */
/* loaded from: classes.dex */
public class a extends CountDownTimer {

    /* renamed from: b, reason: collision with root package name */
    private static a f4530b;

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0127a f4531a;

    /* compiled from: AuthCodeTimeCount.java */
    /* renamed from: com.zte.iptvclient.android.common.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0127a {
        void b(long j);

        void r();
    }

    public a(long j, long j2) {
        super(j, j2);
    }

    public static a a() {
        if (f4530b == null) {
            f4530b = new a(60000L, 200L);
        }
        return f4530b;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        InterfaceC0127a interfaceC0127a = this.f4531a;
        if (interfaceC0127a != null) {
            interfaceC0127a.r();
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        InterfaceC0127a interfaceC0127a = this.f4531a;
        if (interfaceC0127a != null) {
            interfaceC0127a.b(j);
        }
    }

    public void a(InterfaceC0127a interfaceC0127a) {
        this.f4531a = interfaceC0127a;
    }
}
