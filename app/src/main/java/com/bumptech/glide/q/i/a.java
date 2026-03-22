package com.bumptech.glide.q.i;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.bumptech.glide.q.i.f;

/* compiled from: DrawableCrossFadeFactory.java */
/* loaded from: classes.dex */
public class a<T extends Drawable> implements d<T> {

    /* renamed from: a, reason: collision with root package name */
    private final g<T> f2305a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2306b;

    /* renamed from: c, reason: collision with root package name */
    private b<T> f2307c;

    /* renamed from: d, reason: collision with root package name */
    private b<T> f2308d;

    /* compiled from: DrawableCrossFadeFactory.java */
    /* renamed from: com.bumptech.glide.q.i.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0070a implements f.a {

        /* renamed from: a, reason: collision with root package name */
        private final int f2309a;

        C0070a(int i) {
            this.f2309a = i;
        }

        @Override // com.bumptech.glide.q.i.f.a
        public Animation build() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(this.f2309a);
            return alphaAnimation;
        }
    }

    public a() {
        this(300);
    }

    private c<T> b() {
        if (this.f2308d == null) {
            this.f2308d = new b<>(this.f2305a.a(false, false), this.f2306b);
        }
        return this.f2308d;
    }

    @Override // com.bumptech.glide.q.i.d
    public c<T> a(boolean z, boolean z2) {
        if (z) {
            return e.b();
        }
        if (z2) {
            return a();
        }
        return b();
    }

    public a(int i) {
        this(new g(new C0070a(i)), i);
    }

    a(g<T> gVar, int i) {
        this.f2305a = gVar;
        this.f2306b = i;
    }

    private c<T> a() {
        if (this.f2307c == null) {
            this.f2307c = new b<>(this.f2305a.a(false, true), this.f2306b);
        }
        return this.f2307c;
    }
}
