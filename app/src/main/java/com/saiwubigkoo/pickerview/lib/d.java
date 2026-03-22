package com.saiwubigkoo.pickerview.lib;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnItemSelectedRunnable.java */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final WheelView f2688a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WheelView wheelView) {
        this.f2688a = wheelView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WheelView wheelView = this.f2688a;
        wheelView.f2681c.a(wheelView.b());
    }
}
