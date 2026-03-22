package com.saiwubigkoo.pickerview.lib;

import android.os.Handler;
import android.os.Message;
import com.saiwubigkoo.pickerview.lib.WheelView;

/* compiled from: MessageHandler.java */
/* loaded from: classes.dex */
final class c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final WheelView f2687a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WheelView wheelView) {
        this.f2687a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.f2687a.invalidate();
        } else if (i == 2000) {
            this.f2687a.a(WheelView.ACTION.FLING);
        } else {
            if (i != 3000) {
                return;
            }
            this.f2687a.d();
        }
    }
}
