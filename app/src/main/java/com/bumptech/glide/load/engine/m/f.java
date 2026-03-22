package com.bumptech.glide.load.engine.m;

import android.content.Context;
import com.bumptech.glide.load.engine.m.d;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory.java */
/* loaded from: classes.dex */
public final class f extends d {

    /* compiled from: InternalCacheDiskCacheFactory.java */
    /* loaded from: classes.dex */
    class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f2049a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f2050b;

        a(Context context, String str) {
            this.f2049a = context;
            this.f2050b = str;
        }

        @Override // com.bumptech.glide.load.engine.m.d.a
        public File a() {
            File cacheDir = this.f2049a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f2050b != null ? new File(cacheDir, this.f2050b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public f(Context context, String str, int i) {
        super(new a(context, str), i);
    }
}
