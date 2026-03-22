package com.bumptech.glide.q.i;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.q.i.c;

/* compiled from: DrawableCrossFadeViewAnimation.java */
/* loaded from: classes.dex */
public class b<T extends Drawable> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final c<T> f2310a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2311b;

    public b(c<T> cVar, int i) {
        this.f2310a = cVar;
        this.f2311b = i;
    }

    @Override // com.bumptech.glide.q.i.c
    public boolean a(T t, c.a aVar) {
        Drawable c2 = aVar.c();
        if (c2 != null) {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{c2, t});
            transitionDrawable.setCrossFadeEnabled(true);
            transitionDrawable.startTransition(this.f2311b);
            aVar.a(transitionDrawable);
            return true;
        }
        this.f2310a.a(t, aVar);
        return false;
    }
}
