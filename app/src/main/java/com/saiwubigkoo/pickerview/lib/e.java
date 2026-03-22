package com.saiwubigkoo.pickerview.lib;

import com.google.common.logging.nano.Vr;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmoothScrollTimerTask.java */
/* loaded from: classes.dex */
public final class e extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    int f2689a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    int f2690b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f2691c;

    /* renamed from: d, reason: collision with root package name */
    final WheelView f2692d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WheelView wheelView, int i) {
        this.f2692d = wheelView;
        this.f2691c = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f2689a == Integer.MAX_VALUE) {
            this.f2689a = this.f2691c;
        }
        int i = this.f2689a;
        int i2 = (int) (i * 0.1f);
        this.f2690b = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f2690b = -1;
            } else {
                this.f2690b = 1;
            }
        }
        if (Math.abs(this.f2689a) <= 1) {
            this.f2692d.a();
            this.f2692d.f2679a.sendEmptyMessage(Vr.VREvent.EventType.START_VR_LAUNCHER_COLD);
            return;
        }
        WheelView wheelView = this.f2692d;
        wheelView.v += this.f2690b;
        if (!wheelView.r) {
            float f = wheelView.n;
            float f2 = (-wheelView.w) * f;
            int c2 = wheelView.c() - 1;
            float f3 = (c2 - r2.w) * f;
            int i3 = this.f2692d.v;
            if (i3 <= f2 || i3 >= f3) {
                WheelView wheelView2 = this.f2692d;
                wheelView2.v -= this.f2690b;
                wheelView2.a();
                this.f2692d.f2679a.sendEmptyMessage(Vr.VREvent.EventType.START_VR_LAUNCHER_COLD);
                return;
            }
        }
        this.f2692d.f2679a.sendEmptyMessage(1000);
        this.f2689a -= this.f2690b;
    }
}
