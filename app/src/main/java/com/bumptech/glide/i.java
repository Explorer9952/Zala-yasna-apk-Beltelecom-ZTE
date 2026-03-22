package com.bumptech.glide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.h.l;
import com.bumptech.glide.load.h.s.a;
import com.bumptech.glide.load.h.s.c;
import com.bumptech.glide.load.h.s.d;
import com.bumptech.glide.load.h.s.e;
import com.bumptech.glide.load.h.t.a;
import com.bumptech.glide.load.h.t.b;
import com.bumptech.glide.load.h.t.c;
import com.bumptech.glide.load.h.t.e;
import com.bumptech.glide.load.h.t.f;
import com.bumptech.glide.load.h.t.g;
import com.bumptech.glide.load.h.t.h;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.n;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/* compiled from: Glide.java */
/* loaded from: classes.dex */
public class i {
    private static volatile i n;

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.h.c f1919a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.b f1920b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.l.c f1921c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.m.h f1922d;
    private final DecodeFormat e;
    private final com.bumptech.glide.p.c h;
    private final com.bumptech.glide.load.resource.bitmap.e i;
    private final com.bumptech.glide.load.i.h.f j;
    private final com.bumptech.glide.load.resource.bitmap.i k;
    private final com.bumptech.glide.load.i.h.f l;
    private final com.bumptech.glide.q.j.f f = new com.bumptech.glide.q.j.f();
    private final com.bumptech.glide.load.i.i.d g = new com.bumptech.glide.load.i.i.d();
    private final Handler m = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(com.bumptech.glide.load.engine.b bVar, com.bumptech.glide.load.engine.m.h hVar, com.bumptech.glide.load.engine.l.c cVar, Context context, DecodeFormat decodeFormat) {
        this.f1920b = bVar;
        this.f1921c = cVar;
        this.f1922d = hVar;
        this.e = decodeFormat;
        this.f1919a = new com.bumptech.glide.load.h.c(context);
        new com.bumptech.glide.load.engine.n.a(hVar, cVar, decodeFormat);
        this.h = new com.bumptech.glide.p.c();
        n nVar = new n(cVar, decodeFormat);
        this.h.a(InputStream.class, Bitmap.class, nVar);
        com.bumptech.glide.load.resource.bitmap.g gVar = new com.bumptech.glide.load.resource.bitmap.g(cVar, decodeFormat);
        this.h.a(ParcelFileDescriptor.class, Bitmap.class, gVar);
        m mVar = new m(nVar, gVar);
        this.h.a(com.bumptech.glide.load.h.g.class, Bitmap.class, mVar);
        com.bumptech.glide.load.i.g.c cVar2 = new com.bumptech.glide.load.i.g.c(context, cVar);
        this.h.a(InputStream.class, com.bumptech.glide.load.i.g.b.class, cVar2);
        this.h.a(com.bumptech.glide.load.h.g.class, com.bumptech.glide.load.i.h.a.class, new com.bumptech.glide.load.i.h.g(mVar, cVar2, cVar));
        this.h.a(InputStream.class, File.class, new com.bumptech.glide.load.i.f.d());
        a(File.class, ParcelFileDescriptor.class, new a.C0067a());
        a(File.class, InputStream.class, new c.a());
        a(Integer.TYPE, ParcelFileDescriptor.class, new c.a());
        a(Integer.TYPE, InputStream.class, new e.a());
        a(Integer.class, ParcelFileDescriptor.class, new c.a());
        a(Integer.class, InputStream.class, new e.a());
        a(String.class, ParcelFileDescriptor.class, new d.a());
        a(String.class, InputStream.class, new f.a());
        a(Uri.class, ParcelFileDescriptor.class, new e.a());
        a(Uri.class, InputStream.class, new g.a());
        a(URL.class, InputStream.class, new h.a());
        a(com.bumptech.glide.load.h.d.class, InputStream.class, new a.C0068a());
        a(byte[].class, InputStream.class, new b.a());
        this.g.a(Bitmap.class, com.bumptech.glide.load.resource.bitmap.j.class, new com.bumptech.glide.load.i.i.b(context.getResources(), cVar));
        this.g.a(com.bumptech.glide.load.i.h.a.class, com.bumptech.glide.load.i.e.b.class, new com.bumptech.glide.load.i.i.a(new com.bumptech.glide.load.i.i.b(context.getResources(), cVar)));
        com.bumptech.glide.load.resource.bitmap.e eVar = new com.bumptech.glide.load.resource.bitmap.e(cVar);
        this.i = eVar;
        this.j = new com.bumptech.glide.load.i.h.f(cVar, eVar);
        com.bumptech.glide.load.resource.bitmap.i iVar = new com.bumptech.glide.load.resource.bitmap.i(cVar);
        this.k = iVar;
        this.l = new com.bumptech.glide.load.i.h.f(cVar, iVar);
    }

    public static i a(Context context) {
        if (n == null) {
            synchronized (i.class) {
                if (n == null) {
                    Context applicationContext = context.getApplicationContext();
                    List<com.bumptech.glide.o.a> a2 = new com.bumptech.glide.o.b(applicationContext).a();
                    j jVar = new j(applicationContext);
                    Iterator<com.bumptech.glide.o.a> it2 = a2.iterator();
                    while (it2.hasNext()) {
                        it2.next().a(applicationContext, jVar);
                    }
                    n = jVar.a();
                    Iterator<com.bumptech.glide.o.a> it3 = a2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(applicationContext, n);
                    }
                }
            }
        }
        return n;
    }

    private com.bumptech.glide.load.h.c j() {
        return this.f1919a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z, R> com.bumptech.glide.load.i.i.c<Z, R> b(Class<Z> cls, Class<R> cls2) {
        return this.g.a(cls, cls2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.resource.bitmap.i c() {
        return this.k;
    }

    public com.bumptech.glide.load.engine.l.c d() {
        return this.f1921c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeFormat e() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.i.h.f f() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.i.h.f g() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.engine.b h() {
        return this.f1920b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler i() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.resource.bitmap.e b() {
        return this.i;
    }

    public static <T> l<T, InputStream> b(Class<T> cls, Context context) {
        return a(cls, InputStream.class, context);
    }

    public static k b(Context context) {
        return com.bumptech.glide.manager.j.a().a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T, Z> com.bumptech.glide.p.b<T, Z> a(Class<T> cls, Class<Z> cls2) {
        return this.h.a(cls, cls2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <R> com.bumptech.glide.q.j.j<R> a(ImageView imageView, Class<R> cls) {
        return this.f.a(imageView, cls);
    }

    public void a() {
        com.bumptech.glide.s.h.b();
        this.f1922d.a();
        this.f1921c.a();
    }

    public void a(int i) {
        com.bumptech.glide.s.h.b();
        this.f1922d.a(i);
        this.f1921c.a(i);
    }

    public static void a(com.bumptech.glide.q.j.j<?> jVar) {
        com.bumptech.glide.s.h.b();
        com.bumptech.glide.q.c d2 = jVar.d();
        if (d2 != null) {
            d2.clear();
            jVar.a((com.bumptech.glide.q.c) null);
        }
    }

    public <T, Y> void a(Class<T> cls, Class<Y> cls2, com.bumptech.glide.load.h.m<T, Y> mVar) {
        com.bumptech.glide.load.h.m<T, Y> a2 = this.f1919a.a(cls, cls2, mVar);
        if (a2 != null) {
            a2.a();
        }
    }

    public static <T, Y> l<T, Y> a(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls == null) {
            if (!Log.isLoggable("Glide", 3)) {
                return null;
            }
            Log.d("Glide", "Unable to load null model, setting placeholder only");
            return null;
        }
        return a(context).j().a(cls, cls2);
    }

    public static <T> l<T, ParcelFileDescriptor> a(Class<T> cls, Context context) {
        return a(cls, ParcelFileDescriptor.class, context);
    }

    public static k a(Activity activity) {
        return com.bumptech.glide.manager.j.a().a(activity);
    }

    public static k a(FragmentActivity fragmentActivity) {
        return com.bumptech.glide.manager.j.a().a(fragmentActivity);
    }

    public static k a(Fragment fragment) {
        return com.bumptech.glide.manager.j.a().a(fragment);
    }
}
