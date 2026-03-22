package com.zte.iptvclient.android.common.function.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;

/* loaded from: classes.dex */
public class RemoteTimeReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private a f4597a;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!"android.intent.action.TIME_TICK".equals(action) && "android.intent.action.TIME_SET".equals(action)) {
            int i = Calendar.getInstance().get(11);
            if (i >= 7 && i < 21) {
                a aVar = this.f4597a;
                if (aVar != null) {
                    aVar.a(true);
                    return;
                }
                return;
            }
            a aVar2 = this.f4597a;
            if (aVar2 != null) {
                aVar2.a(false);
            }
        }
    }
}
