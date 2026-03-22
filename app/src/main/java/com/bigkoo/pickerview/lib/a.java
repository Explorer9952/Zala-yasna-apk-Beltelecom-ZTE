package com.bigkoo.pickerview.lib;

import java.util.TimerTask;

/* compiled from: InertiaTimerTask.java */
/* loaded from: classes.dex */
final class a extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    float f1902a = 2.1474836E9f;

    /* renamed from: b, reason: collision with root package name */
    final float f1903b;

    /* renamed from: c, reason: collision with root package name */
    final WheelView f1904c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WheelView wheelView, float f) {
        this.f1904c = wheelView;
        this.f1903b = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (Double.doubleToLongBits(this.f1902a) == 2147483647L) {
            if (Math.abs(this.f1903b) <= 2000.0f) {
                this.f1902a = this.f1903b;
            } else if (this.f1903b > 0.0f) {
                this.f1902a = 2000.0f;
            } else {
                this.f1902a = -2000.0f;
            }
        }
        if (Math.abs(this.f1902a) >= 0.0f && Math.abs(this.f1902a) <= 20.0f) {
            this.f1904c.a();
            this.f1904c.f1899b.sendEmptyMessage(2000);
            return;
        }
        int i = (int) ((this.f1902a * 10.0f) / 1000.0f);
        WheelView wheelView = this.f1904c;
        int i2 = wheelView.w - i;
        wheelView.w = i2;
        if (!wheelView.s) {
            float f = wheelView.o * 2.0f;
            int i3 = wheelView.x;
            if (i2 <= ((int) ((-i3) * f))) {
                this.f1902a = 40.0f;
                wheelView.w = (int) ((-i3) * f);
            } else {
                int c2 = wheelView.c() - 1;
                WheelView wheelView2 = this.f1904c;
                if (i2 >= ((int) ((c2 - wheelView2.x) * f))) {
                    wheelView2.w = (int) (((wheelView2.c() - 1) - this.f1904c.x) * f);
                    this.f1902a = -40.0f;
                }
            }
        }
        float f2 = this.f1902a;
        if (f2 < 0.0f) {
            this.f1902a = f2 + 20.0f;
        } else {
            this.f1902a = f2 - 20.0f;
        }
        this.f1904c.f1899b.sendEmptyMessage(1000);
    }
}
