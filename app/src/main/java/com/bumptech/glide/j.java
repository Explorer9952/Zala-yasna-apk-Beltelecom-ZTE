package com.bumptech.glide;

import android.content.Context;
import android.os.Build;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor;
import com.bumptech.glide.load.engine.m.a;
import java.util.concurrent.ExecutorService;

/* compiled from: GlideBuilder.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1923a;

    /* renamed from: b, reason: collision with root package name */
    private com.bumptech.glide.load.engine.b f1924b;

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.engine.l.c f1925c;

    /* renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.load.engine.m.h f1926d;
    private ExecutorService e;
    private ExecutorService f;
    private DecodeFormat g;
    private a.InterfaceC0065a h;

    public j(Context context) {
        this.f1923a = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i a() {
        if (this.e == null) {
            this.e = new FifoPriorityThreadPoolExecutor(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f == null) {
            this.f = new FifoPriorityThreadPoolExecutor(1);
        }
        com.bumptech.glide.load.engine.m.i iVar = new com.bumptech.glide.load.engine.m.i(this.f1923a);
        if (this.f1925c == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.f1925c = new com.bumptech.glide.load.engine.l.f(iVar.a());
            } else {
                this.f1925c = new com.bumptech.glide.load.engine.l.d();
            }
        }
        if (this.f1926d == null) {
            this.f1926d = new com.bumptech.glide.load.engine.m.g(iVar.b());
        }
        if (this.h == null) {
            this.h = new com.bumptech.glide.load.engine.m.f(this.f1923a);
        }
        if (this.f1924b == null) {
            this.f1924b = new com.bumptech.glide.load.engine.b(this.f1926d, this.h, this.f, this.e);
        }
        if (this.g == null) {
            this.g = DecodeFormat.DEFAULT;
        }
        return new i(this.f1924b, this.f1926d, this.f1925c, this.f1923a, this.g);
    }
}
