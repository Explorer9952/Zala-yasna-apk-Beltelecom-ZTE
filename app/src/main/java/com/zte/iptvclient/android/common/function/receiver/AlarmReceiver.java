package com.zte.iptvclient.android.common.function.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.video.androidsdk.log.LogEx;

/* loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static a f4595a;

    /* loaded from: classes.dex */
    public interface a {
        void a(Context context, Intent intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LogEx.d("AlarmReceiver", "recvive delay time message ");
        if (f4595a != null) {
            LogEx.d("AlarmReceiver", "do callback");
            f4595a.a(context, intent);
        }
    }
}
