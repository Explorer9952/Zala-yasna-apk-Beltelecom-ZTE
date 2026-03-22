package com.zte.iptvclient.android.common.function.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.video.androidsdk.log.LogEx;

/* loaded from: classes.dex */
public class TvAlarmReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static a f4598a;

    /* loaded from: classes.dex */
    public interface a {
        void a(Context context, Intent intent);
    }

    public static void a(a aVar) {
        f4598a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LogEx.d("AlarmReceiver", "recvive delay time message ");
        if (f4598a != null) {
            LogEx.d("AlarmReceiver", "do callback");
            f4598a.a(context, intent);
        }
    }
}
