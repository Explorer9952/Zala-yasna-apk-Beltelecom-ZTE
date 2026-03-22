package com.bigkoo.pickerview.lib;

import com.google.common.logging.nano.Vr;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmoothScrollTimerTask.java */
/* loaded from: classes.dex */
public final class e extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    int f1908a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    int f1909b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f1910c;

    /* renamed from: d, reason: collision with root package name */
    final WheelView f1911d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WheelView wheelView, int i) {
        this.f1911d = wheelView;
        this.f1910c = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f1908a == Integer.MAX_VALUE) {
            this.f1908a = this.f1910c;
        }
        int i = this.f1908a;
        int i2 = (int) (i * 0.1f);
        this.f1909b = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f1909b = -1;
            } else {
                this.f1909b = 1;
            }
        }
        if (Math.abs(this.f1908a) <= 1) {
            WheelView wheelView = this.f1911d;
            if (!wheelView.s) {
                float f = wheelView.o * 2.0f;
                int i3 = wheelView.w;
                int i4 = wheelView.x;
                if (i3 <= ((int) ((-i4) * f))) {
                    wheelView.w = (int) ((-i4) * f);
                    wheelView.f1899b.sendEmptyMessage(1000);
                } else {
                    int c2 = wheelView.c() - 1;
                    WheelView wheelView2 = this.f1911d;
                    if (i3 >= ((int) ((c2 - wheelView2.x) * f))) {
                        int c3 = wheelView2.c() - 1;
                        WheelView wheelView3 = this.f1911d;
                        wheelView2.w = (int) ((c3 - wheelView3.x) * f);
                        wheelView3.f1899b.sendEmptyMessage(1000);
                    }
                }
            }
            this.f1911d.a();
            this.f1911d.f1899b.sendEmptyMessage(Vr.VREvent.EventType.START_VR_LAUNCHER_COLD);
            return;
        }
        WheelView wheelView4 = this.f1911d;
        wheelView4.w += this.f1909b;
        wheelView4.f1899b.sendEmptyMessage(1000);
        this.f1908a -= this.f1909b;
    }
}
