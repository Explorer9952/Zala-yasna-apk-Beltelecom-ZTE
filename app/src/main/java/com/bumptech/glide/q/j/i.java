package com.bumptech.glide.q.j;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: SquaringDrawable.java */
/* loaded from: classes.dex */
public class i extends com.bumptech.glide.load.i.e.b {

    /* renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.load.i.e.b f2320a;

    /* renamed from: b, reason: collision with root package name */
    private a f2321b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2322c;

    /* compiled from: SquaringDrawable.java */
    /* loaded from: classes.dex */
    static class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f2323a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2324b;

        a(a aVar) {
            this(aVar.f2323a, aVar.f2324b);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        a(Drawable.ConstantState constantState, int i) {
            this.f2323a = constantState;
            this.f2324b = i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this, null, resources);
        }
    }

    public i(com.bumptech.glide.load.i.e.b bVar, int i) {
        this(new a(bVar.getConstantState(), i), bVar, null);
    }

    @Override // com.bumptech.glide.load.i.e.b
    public boolean a() {
        return this.f2320a.a();
    }

    @Override // com.bumptech.glide.load.i.e.b
    public void b(int i) {
        this.f2320a.b(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f2320a.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f2320a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(19)
    public int getAlpha() {
        return this.f2320a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(11)
    public Drawable.Callback getCallback() {
        return this.f2320a.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f2320a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f2321b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f2320a.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2321b.f2324b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2321b.f2324b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f2320a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f2320a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f2320a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f2320a.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f2320a.invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f2320a.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f2322c && super.mutate() == this) {
            this.f2320a = (com.bumptech.glide.load.i.e.b) this.f2320a.mutate();
            this.f2321b = new a(this.f2321b);
            this.f2322c = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.f2320a.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2320a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f2320a.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f2320a.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        this.f2320a.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f2320a.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f2320a.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.f2320a.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f2320a.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f2320a.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f2320a.unscheduleSelf(runnable);
    }

    i(a aVar, com.bumptech.glide.load.i.e.b bVar, Resources resources) {
        this.f2321b = aVar;
        if (bVar != null) {
            this.f2320a = bVar;
        } else if (resources != null) {
            this.f2320a = (com.bumptech.glide.load.i.e.b) aVar.f2323a.newDrawable(resources);
        } else {
            this.f2320a = (com.bumptech.glide.load.i.e.b) aVar.f2323a.newDrawable();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2320a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.f2320a.setBounds(rect);
    }
}
