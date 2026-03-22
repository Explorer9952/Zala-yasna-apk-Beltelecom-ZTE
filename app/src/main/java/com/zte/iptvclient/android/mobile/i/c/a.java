package com.zte.iptvclient.android.mobile.i.c;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

/* compiled from: NotifyUtil.java */
/* loaded from: classes.dex */
public class a {
    @TargetApi(26)
    public static void a(Context context, String str) {
        NotificationChannel notificationChannel = new NotificationChannel(str, "Channel", 3);
        notificationChannel.setSound(null, null);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-65536);
        notificationChannel.setShowBadge(true);
        ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(notificationChannel);
    }
}
