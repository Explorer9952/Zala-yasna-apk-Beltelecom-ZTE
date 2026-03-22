package com.saiwubigkoo.pickerview.lib;

import java.util.TimerTask;

/* compiled from: InertiaTimerTask.java */
/* loaded from: classes.dex */
final class a extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    float f2683a = 2.1474836E9f;

    /* renamed from: b, reason: collision with root package name */
    final float f2684b;

    /* renamed from: c, reason: collision with root package name */
    final WheelView f2685c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WheelView wheelView, float f) {
        this.f2685c = wheelView;
        this.f2684b = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f2683a == 2.1474836E9f) {
            if (Math.abs(this.f2684b) <= 2000.0f) {
                this.f2683a = this.f2684b;
            } else if (this.f2684b > 0.0f) {
                this.f2683a = 2000.0f;
            } else {
                this.f2683a = -2000.0f;
            }
        }
        if (Math.abs(this.f2683a) >= 0.0f && Math.abs(this.f2683a) <= 20.0f) {
            this.f2685c.a();
            this.f2685c.f2679a.sendEmptyMessage(2000);
            return;
        }
        int i = (int) ((this.f2683a * 10.0f) / 1000.0f);
        WheelView wheelView = this.f2685c;
        wheelView.v -= i;
        if (!wheelView.r) {
            float f = wheelView.n;
            float f2 = (-wheelView.w) * f;
            int c2 = wheelView.c() - 1;
            float f3 = (c2 - r6.w) * f;
            int i2 = this.f2685c.v;
            double d2 = i2;
            double d3 = f;
            Double.isNaN(d3);
            double d4 = d3 * 0.3d;
            Double.isNaN(d2);
            if (d2 - d4 < f2) {
                f2 = i2 + i;
            } else {
                double d5 = i2;
                Double.isNaN(d5);
                if (d5 + d4 > f3) {
                    f3 = i2 + i;
                }
            }
            WheelView wheelView2 = this.f2685c;
            int i3 = wheelView2.v;
            if (i3 <= f2) {
                this.f2683a = 40.0f;
                wheelView2.v = (int) f2;
            } else if (i3 >= f3) {
                wheelView2.v = (int) f3;
                this.f2683a = -40.0f;
            }
        }
        float f4 = this.f2683a;
        if (f4 < 0.0f) {
            this.f2683a = f4 + 20.0f;
        } else {
            this.f2683a = f4 - 20.0f;
        }
        this.f2685c.f2679a.sendEmptyMessage(1000);
    }
}
