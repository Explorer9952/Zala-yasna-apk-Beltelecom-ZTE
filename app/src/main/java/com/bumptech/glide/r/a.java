package com.bumptech.glide.r;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ApplicationVersionSignature.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, com.bumptech.glide.load.b> f2333a = new ConcurrentHashMap<>();

    public static com.bumptech.glide.load.b a(Context context) {
        String packageName = context.getPackageName();
        com.bumptech.glide.load.b bVar = f2333a.get(packageName);
        if (bVar != null) {
            return bVar;
        }
        com.bumptech.glide.load.b b2 = b(context);
        com.bumptech.glide.load.b putIfAbsent = f2333a.putIfAbsent(packageName, b2);
        return putIfAbsent == null ? b2 : putIfAbsent;
    }

    private static com.bumptech.glide.load.b b(Context context) {
        PackageInfo packageInfo;
        String uuid;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            uuid = String.valueOf(packageInfo.versionCode);
        } else {
            uuid = UUID.randomUUID().toString();
        }
        return new c(uuid);
    }
}
