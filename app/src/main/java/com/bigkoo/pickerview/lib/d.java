package com.bigkoo.pickerview.lib;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnItemSelectedRunnable.java */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final WheelView f1907a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WheelView wheelView) {
        this.f1907a = wheelView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WheelView wheelView = this.f1907a;
        wheelView.f1901d.a(wheelView.b());
    }
}
