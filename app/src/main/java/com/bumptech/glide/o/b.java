package com.bumptech.glide.o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.zte.ucs.tvcall.Commons;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ManifestParser.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2279a;

    public b(Context context) {
        this.f2279a = context;
    }

    public List<a> a() {
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f2279a.getPackageManager().getApplicationInfo(this.f2279a.getPackageName(), Commons.MSG_MCSP_INIT_SUCCESS);
            if (applicationInfo.metaData != null) {
                for (String str : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(a(str));
                    }
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }

    private static a a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object newInstance = cls.newInstance();
                if (newInstance instanceof a) {
                    return (a) newInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e3);
        }
    }
}
