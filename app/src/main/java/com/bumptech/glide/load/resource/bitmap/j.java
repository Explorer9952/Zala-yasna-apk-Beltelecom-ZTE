package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

/* compiled from: GlideBitmapDrawable.java */
/* loaded from: classes.dex */
public class j extends com.bumptech.glide.load.i.e.b {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f2202a;

    /* renamed from: b, reason: collision with root package name */
    private int f2203b;

    /* renamed from: c, reason: collision with root package name */
    private int f2204c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2205d;
    private boolean e;
    private a f;

    /* compiled from: GlideBitmapDrawable.java */
    /* loaded from: classes.dex */
    static class a extends Drawable.ConstantState {

        /* renamed from: d, reason: collision with root package name */
        private static final Paint f2206d = new Paint(6);

        /* renamed from: a, reason: collision with root package name */
        final Bitmap f2207a;

        /* renamed from: b, reason: collision with root package name */
        int f2208b;

        /* renamed from: c, reason: collision with root package name */
        Paint f2209c;

        public a(Bitmap bitmap) {
            this.f2209c = f2206d;
            this.f2207a = bitmap;
        }

        void a(ColorFilter colorFilter) {
            a();
            this.f2209c.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new j((Resources) null, this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new j(resources, this);
        }

        void a(int i) {
            a();
            this.f2209c.setAlpha(i);
        }

        a(a aVar) {
            this(aVar.f2207a);
            this.f2208b = aVar.f2208b;
        }

        void a() {
            if (f2206d == this.f2209c) {
                this.f2209c = new Paint(6);
            }
        }
    }

    public j(Resources resources, Bitmap bitmap) {
        this(resources, new a(bitmap));
    }

    @Override // com.bumptech.glide.load.i.e.b
    public boolean a() {
        return false;
    }

    public Bitmap b() {
        return this.f.f2207a;
    }

    @Override // com.bumptech.glide.load.i.e.b
    public void b(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f2205d) {
            Gravity.apply(119, this.f2203b, this.f2204c, getBounds(), this.f2202a);
            this.f2205d = false;
        }
        a aVar = this.f;
        canvas.drawBitmap(aVar.f2207a, (Rect) null, this.f2202a, aVar.f2209c);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2204c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2203b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap = this.f.f2207a;
        return (bitmap == null || bitmap.hasAlpha() || this.f.f2209c.getAlpha() < 255) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.e && super.mutate() == this) {
            this.f = new a(this.f);
            this.e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2205d = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f.f2209c.getAlpha() != i) {
            this.f.a(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f.a(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }

    j(Resources resources, a aVar) {
        int i;
        this.f2202a = new Rect();
        if (aVar != null) {
            this.f = aVar;
            if (resources != null) {
                i = resources.getDisplayMetrics().densityDpi;
                i = i == 0 ? 160 : i;
                aVar.f2208b = i;
            } else {
                i = aVar.f2208b;
            }
            this.f2203b = aVar.f2207a.getScaledWidth(i);
            this.f2204c = aVar.f2207a.getScaledHeight(i);
            return;
        }
        throw new NullPointerException("BitmapState must not be null");
    }
}
