package com.bumptech.glide.load.g;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher.java */
/* loaded from: classes.dex */
public abstract class g<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f2066a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f2067b;

    /* renamed from: c, reason: collision with root package name */
    private T f2068c;

    public g(Context context, Uri uri) {
        this.f2067b = context.getApplicationContext();
        this.f2066a = uri;
    }

    protected abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.g.c
    public final T a(Priority priority) throws Exception {
        T a2 = a(this.f2066a, this.f2067b.getContentResolver());
        this.f2068c = a2;
        return a2;
    }

    protected abstract void a(T t) throws IOException;

    @Override // com.bumptech.glide.load.g.c
    public void b() {
        T t = this.f2068c;
        if (t != null) {
            try {
                a((g<T>) t);
            } catch (IOException e) {
                if (Log.isLoggable("LocalUriFetcher", 2)) {
                    Log.v("LocalUriFetcher", "failed to close data", e);
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.g.c
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.g.c
    public String a() {
        return this.f2066a.toString();
    }
}
