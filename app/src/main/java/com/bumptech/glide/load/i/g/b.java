package com.bumptech.glide.load.i.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;
import com.bumptech.glide.load.i.g.f;
import com.bumptech.glide.m.a;

/* compiled from: GifDrawable.java */
/* loaded from: classes.dex */
public class b extends com.bumptech.glide.load.i.e.b implements f.c {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f2122a;

    /* renamed from: b, reason: collision with root package name */
    private final Rect f2123b;

    /* renamed from: c, reason: collision with root package name */
    private final a f2124c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.m.a f2125d;
    private final f e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private boolean l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifDrawable.java */
    /* loaded from: classes.dex */
    public static class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        com.bumptech.glide.m.c f2126a;

        /* renamed from: b, reason: collision with root package name */
        byte[] f2127b;

        /* renamed from: c, reason: collision with root package name */
        Context f2128c;

        /* renamed from: d, reason: collision with root package name */
        com.bumptech.glide.load.f<Bitmap> f2129d;
        int e;
        int f;
        a.InterfaceC0069a g;
        com.bumptech.glide.load.engine.l.c h;
        Bitmap i;

        public a(com.bumptech.glide.m.c cVar, byte[] bArr, Context context, com.bumptech.glide.load.f<Bitmap> fVar, int i, int i2, a.InterfaceC0069a interfaceC0069a, com.bumptech.glide.load.engine.l.c cVar2, Bitmap bitmap) {
            if (bitmap != null) {
                this.f2126a = cVar;
                this.f2127b = bArr;
                this.h = cVar2;
                this.i = bitmap;
                this.f2128c = context.getApplicationContext();
                this.f2129d = fVar;
                this.e = i;
                this.f = i2;
                this.g = interfaceC0069a;
                return;
            }
            throw new NullPointerException("The first frame of the GIF must not be null");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new b(this);
        }
    }

    public b(Context context, a.InterfaceC0069a interfaceC0069a, com.bumptech.glide.load.engine.l.c cVar, com.bumptech.glide.load.f<Bitmap> fVar, int i, int i2, com.bumptech.glide.m.c cVar2, byte[] bArr, Bitmap bitmap) {
        this(new a(cVar2, bArr, context, fVar, i, i2, interfaceC0069a, cVar, bitmap));
    }

    private void g() {
        this.e.a();
        invalidateSelf();
    }

    private void h() {
        this.j = 0;
    }

    private void i() {
        if (this.f2125d.d() == 1) {
            invalidateSelf();
        } else {
            if (this.f) {
                return;
            }
            this.f = true;
            this.e.c();
            invalidateSelf();
        }
    }

    private void j() {
        this.f = false;
        this.e.d();
    }

    @Override // com.bumptech.glide.load.i.g.f.c
    @TargetApi(11)
    public void a(int i) {
        if (Build.VERSION.SDK_INT >= 11 && getCallback() == null) {
            stop();
            g();
            return;
        }
        invalidateSelf();
        if (i == this.f2125d.d() - 1) {
            this.j++;
        }
        int i2 = this.k;
        if (i2 == -1 || this.j < i2) {
            return;
        }
        stop();
    }

    @Override // com.bumptech.glide.load.i.e.b
    public boolean a() {
        return true;
    }

    public byte[] b() {
        return this.f2124c.f2127b;
    }

    public Bitmap c() {
        return this.f2124c.i;
    }

    public int d() {
        return this.f2125d.d();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.h) {
            return;
        }
        if (this.l) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.f2123b);
            this.l = false;
        }
        Bitmap b2 = this.e.b();
        if (b2 == null) {
            b2 = this.f2124c.i;
        }
        canvas.drawBitmap(b2, (Rect) null, this.f2123b, this.f2122a);
    }

    public com.bumptech.glide.load.f<Bitmap> e() {
        return this.f2124c.f2129d;
    }

    public void f() {
        this.h = true;
        a aVar = this.f2124c;
        aVar.h.a(aVar.i);
        this.e.a();
        this.e.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f2124c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2124c.i.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2124c.i.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2122a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2122a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.i = z;
        if (!z) {
            j();
        } else if (this.g) {
            i();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.g = true;
        h();
        if (this.i) {
            i();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.g = false;
        j();
        if (Build.VERSION.SDK_INT < 11) {
            g();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(com.bumptech.glide.load.i.g.b r12, android.graphics.Bitmap r13, com.bumptech.glide.load.f<android.graphics.Bitmap> r14) {
        /*
            r11 = this;
            com.bumptech.glide.load.i.g.b$a r10 = new com.bumptech.glide.load.i.g.b$a
            com.bumptech.glide.load.i.g.b$a r12 = r12.f2124c
            com.bumptech.glide.m.c r1 = r12.f2126a
            byte[] r2 = r12.f2127b
            android.content.Context r3 = r12.f2128c
            int r5 = r12.e
            int r6 = r12.f
            com.bumptech.glide.m.a$a r7 = r12.g
            com.bumptech.glide.load.engine.l.c r8 = r12.h
            r0 = r10
            r4 = r14
            r9 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r11.<init>(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.i.g.b.<init>(com.bumptech.glide.load.i.g.b, android.graphics.Bitmap, com.bumptech.glide.load.f):void");
    }

    @Override // com.bumptech.glide.load.i.e.b
    public void b(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i == 0) {
            this.k = this.f2125d.e();
        } else {
            this.k = i;
        }
    }

    b(a aVar) {
        this.f2123b = new Rect();
        this.i = true;
        this.k = -1;
        if (aVar != null) {
            this.f2124c = aVar;
            this.f2125d = new com.bumptech.glide.m.a(aVar.g);
            this.f2122a = new Paint();
            this.f2125d.a(aVar.f2126a, aVar.f2127b);
            f fVar = new f(aVar.f2128c, this, this.f2125d, aVar.e, aVar.f);
            this.e = fVar;
            fVar.a(aVar.f2129d);
            return;
        }
        throw new NullPointerException("GifState must not be null");
    }
}
