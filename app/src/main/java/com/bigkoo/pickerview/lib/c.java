package com.bigkoo.pickerview.lib;

import android.os.Handler;
import android.os.Message;
import com.bigkoo.pickerview.lib.WheelView;

/* compiled from: MessageHandler.java */
/* loaded from: classes.dex */
final class c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final WheelView f1906a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WheelView wheelView) {
        this.f1906a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.f1906a.invalidate();
        } else if (i == 2000) {
            this.f1906a.a(WheelView.ACTION.FLING);
        } else {
            if (i != 3000) {
                return;
            }
            this.f1906a.d();
        }
    }
}
