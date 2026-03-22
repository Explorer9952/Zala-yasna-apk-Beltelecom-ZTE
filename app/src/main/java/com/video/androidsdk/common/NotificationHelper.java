package com.video.androidsdk.common;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class NotificationHelper {
    private WeakReference<Context> mContextRef;
    private NotificationManager mNotificationManager;

    public NotificationHelper(Context context) {
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
        this.mContextRef = new WeakReference<>(context);
    }

    public void showNofity(int i, String str, long j, Uri uri) {
        Notification notification = new Notification();
        if (i > 0) {
            notification.icon = i;
        }
        if (str != null) {
            notification.tickerText = str;
        }
        notification.when = j;
        if (uri == null) {
            notification.defaults = 1;
        } else {
            notification.sound = uri;
        }
        WeakReference<Context> weakReference = this.mContextRef;
        if (weakReference != null && weakReference.get() != null) {
            PendingIntent activity = PendingIntent.getActivity(this.mContextRef.get(), 0, new Intent(), 268435456);
            if (Build.VERSION.SDK_INT < 16) {
                try {
                    notification.getClass().getDeclaredMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, this.mContextRef.get(), str, "", activity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                notification = new Notification.Builder(this.mContextRef.get()).setAutoCancel(true).setContentTitle(str).setContentText("").setContentIntent(activity).setWhen(System.currentTimeMillis()).build();
            }
        }
        this.mNotificationManager.notify(0, notification);
        this.mNotificationManager.cancel(0);
    }

    public void showNotify(int i, String str) {
        showNotify(i, str, System.currentTimeMillis());
    }

    public void showNotify(int i, String str, long j) {
        showNofity(i, str, j, null);
    }
}
