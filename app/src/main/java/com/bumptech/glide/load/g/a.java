package com.bumptech.glide.load.g;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.IOException;

/* compiled from: AssetPathFetcher.java */
/* loaded from: classes.dex */
public abstract class a<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final String f2057a;

    /* renamed from: b, reason: collision with root package name */
    private final AssetManager f2058b;

    /* renamed from: c, reason: collision with root package name */
    private T f2059c;

    public a(AssetManager assetManager, String str) {
        this.f2058b = assetManager;
        this.f2057a = str;
    }

    protected abstract T a(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.g.c
    public T a(Priority priority) throws Exception {
        T a2 = a(this.f2058b, this.f2057a);
        this.f2059c = a2;
        return a2;
    }

    protected abstract void a(T t) throws IOException;

    @Override // com.bumptech.glide.load.g.c
    public void b() {
        T t = this.f2059c;
        if (t == null) {
            return;
        }
        try {
            a((a<T>) t);
        } catch (IOException e) {
            if (Log.isLoggable("AssetUriFetcher", 2)) {
                Log.v("AssetUriFetcher", "Failed to close data", e);
            }
        }
    }

    @Override // com.bumptech.glide.load.g.c
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.g.c
    public String a() {
        return this.f2057a;
    }
}
