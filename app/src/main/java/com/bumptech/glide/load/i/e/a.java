package com.bumptech.glide.load.i.e;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.j;

/* compiled from: DrawableResource.java */
/* loaded from: classes.dex */
public abstract class a<T extends Drawable> implements j<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final T f2114a;

    public a(T t) {
        if (t != null) {
            this.f2114a = t;
            return;
        }
        throw new NullPointerException("Drawable must not be null!");
    }

    @Override // com.bumptech.glide.load.engine.j
    public final T get() {
        return (T) this.f2114a.getConstantState().newDrawable();
    }
}
