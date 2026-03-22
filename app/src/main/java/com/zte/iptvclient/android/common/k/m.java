package com.zte.iptvclient.android.common.k;

import android.app.Activity;
import android.content.Intent;

/* compiled from: IntentUtils.java */
/* loaded from: classes.dex */
public class m {
    public static boolean a(Activity activity, String str) {
        Intent intent = new Intent();
        intent.setClassName(activity.getApplicationContext().getPackageName(), str);
        return activity.getApplicationContext().getPackageManager().queryIntentActivities(intent, 0).size() != 0;
    }
}
