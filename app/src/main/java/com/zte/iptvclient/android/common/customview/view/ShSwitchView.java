package com.zte.iptvclient.android.common.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.ahmobile.android.tvclient.R$styleable;
import d.c.a.i;

/* loaded from: classes.dex */
public class ShSwitchView extends View {
    private float A;
    private int B;
    private int C;
    private int D;
    private Paint E;
    private RectF F;
    private boolean G;
    private boolean J;
    private e K;

    /* renamed from: a, reason: collision with root package name */
    private i f4339a;

    /* renamed from: b, reason: collision with root package name */
    private com.nineoldandroids.util.c<ShSwitchView, Float> f4340b;

    /* renamed from: c, reason: collision with root package name */
    private i f4341c;

    /* renamed from: d, reason: collision with root package name */
    private com.nineoldandroids.util.c<ShSwitchView, Float> f4342d;
    private i e;
    private com.nineoldandroids.util.c<ShSwitchView, Float> f;
    private GestureDetector g;
    private GestureDetector.SimpleOnGestureListener h;
    private int i;
    private int j;
    private int k;
    private int l;
    private float m;
    private int n;
    private int o;
    private RectF p;
    private float q;
    private float r;
    private float s;
    private float t;
    private boolean u;
    private boolean v;
    private boolean w;
    private RectF x;
    private float y;
    private float z;

    /* loaded from: classes.dex */
    class d extends GestureDetector.SimpleOnGestureListener {
        d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (!ShSwitchView.this.isEnabled()) {
                return false;
            }
            ShSwitchView shSwitchView = ShSwitchView.this;
            shSwitchView.w = shSwitchView.v;
            ShSwitchView.this.f4339a.a(ShSwitchView.this.y, 0.0f);
            ShSwitchView.this.f4339a.b();
            ShSwitchView.this.f4341c.a(ShSwitchView.this.s, 1.0f);
            ShSwitchView.this.f4341c.b();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent2.getX() > ShSwitchView.this.k) {
                if (!ShSwitchView.this.u) {
                    ShSwitchView.this.u = true;
                    ShSwitchView.this.e.a(ShSwitchView.this.t, 1.0f);
                    ShSwitchView.this.e.b();
                    ShSwitchView.this.f4339a.a(ShSwitchView.this.y, 0.0f);
                    ShSwitchView.this.f4339a.b();
                }
            } else if (ShSwitchView.this.u) {
                ShSwitchView.this.u = false;
                ShSwitchView.this.e.a(ShSwitchView.this.t, 0.0f);
                ShSwitchView.this.e.b();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            ShSwitchView shSwitchView = ShSwitchView.this;
            shSwitchView.v = shSwitchView.u;
            if (ShSwitchView.this.w == ShSwitchView.this.v) {
                ShSwitchView.this.v = !r8.v;
                ShSwitchView.this.u = !r8.u;
            }
            if (ShSwitchView.this.u) {
                ShSwitchView.this.e.a(ShSwitchView.this.t, 1.0f);
                ShSwitchView.this.e.b();
                ShSwitchView.this.f4339a.a(ShSwitchView.this.y, 0.0f);
                ShSwitchView.this.f4339a.b();
            } else {
                ShSwitchView.this.e.a(ShSwitchView.this.t, 0.0f);
                ShSwitchView.this.e.b();
                ShSwitchView.this.f4339a.a(ShSwitchView.this.y, 1.0f);
                ShSwitchView.this.f4339a.b();
            }
            ShSwitchView.this.f4341c.a(ShSwitchView.this.s, 0.0f);
            ShSwitchView.this.f4341c.b();
            if (ShSwitchView.this.K != null && ShSwitchView.this.v != ShSwitchView.this.w) {
                ShSwitchView.this.K.a(ShSwitchView.this.v);
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(boolean z);
    }

    public ShSwitchView(Context context) {
        this(context, null);
    }

    private int a(float f, int i, int i2) {
        return ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r0) * f))) << 16) | (-16777216) | ((((i >> 8) & 255) + ((int) ((((i2 >> 8) & 255) - r1) * f))) << 8) | ((i & 255) + ((int) (((i2 & 255) - r6) * f)));
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        boolean z;
        super.onAttachedToWindow();
        this.J = true;
        if (this.G) {
            boolean z2 = this.v;
            this.u = z2;
            if (z2) {
                this.e.a(this.t, 1.0f);
                this.e.b();
                this.f4339a.a(this.y, 0.0f);
                this.f4339a.b();
            } else {
                this.e.a(this.t, 0.0f);
                this.e.b();
                this.f4339a.a(this.y, 1.0f);
                this.f4339a.b();
            }
            this.f4341c.a(this.s, 0.0f);
            this.f4341c.b();
            e eVar = this.K;
            if (eVar != null && (z = this.v) != this.w) {
                eVar.a(z);
            }
            this.G = false;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.J = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.z / 2.0f;
        float f2 = this.y;
        float f3 = f * f2;
        float f4 = (this.A / 2.0f) * f2;
        RectF rectF = this.x;
        int i = this.k;
        rectF.left = i - f3;
        int i2 = this.l;
        rectF.top = i2 - f4;
        rectF.right = i + f3;
        rectF.bottom = i2 + f4;
        float f5 = this.r;
        float f6 = f5 + ((this.q - f5) * this.s);
        RectF rectF2 = this.p;
        if (rectF2.left + (rectF2.width() / 2.0f) > ((float) this.k)) {
            RectF rectF3 = this.p;
            rectF3.left = rectF3.right - f6;
        } else {
            RectF rectF4 = this.p;
            rectF4.right = rectF4.left + f6;
        }
        float width = this.p.width();
        float f7 = this.t;
        float f8 = ((this.i - width) - ((this.n + this.o) * 2)) * f7;
        int a2 = a(f7, -3355444, this.B);
        this.D = a2;
        RectF rectF5 = this.p;
        float f9 = this.n + this.o + f8;
        rectF5.left = f9;
        rectF5.right = f9 + width;
        this.E.setColor(a2);
        this.E.setStyle(Paint.Style.FILL);
        int i3 = this.n;
        a(i3, i3, this.i - i3, this.j - i3, this.m, canvas, this.E);
        this.E.setColor(-1052689);
        RectF rectF6 = this.x;
        canvas.drawRoundRect(rectF6, rectF6.height() / 2.0f, this.x.height() / 2.0f, this.E);
        this.E.setShadowLayer(2.0f, 0.0f, this.n / 2, isEnabled() ? 536870912 : 268435456);
        RectF rectF7 = this.p;
        float f10 = this.m;
        int i4 = this.o;
        canvas.drawRoundRect(rectF7, f10 - i4, f10 - i4, this.E);
        this.E.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.E.setColor(-3355444);
        this.E.setStyle(Paint.Style.STROKE);
        this.E.setStrokeWidth(1.0f);
        RectF rectF8 = this.p;
        float f11 = this.m;
        int i5 = this.o;
        canvas.drawRoundRect(rectF8, f11 - i5, f11 - i5, this.E);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.i = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        this.j = size;
        int i3 = this.i;
        if (size / i3 < 0.33333f) {
            this.j = (int) (i3 * 0.33333f);
            super.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(i3, View.MeasureSpec.getMode(i)), View.MeasureSpec.makeMeasureSpec(this.j, View.MeasureSpec.getMode(i2)));
        }
        this.k = this.i / 2;
        this.l = this.j / 2;
        int i4 = this.n;
        this.m = r0 - i4;
        RectF rectF = this.x;
        int i5 = this.o;
        rectF.left = i5 + i4;
        rectF.top = i5 + i4;
        rectF.right = (r5 - i5) - i4;
        rectF.bottom = (r6 - i5) - i4;
        this.z = rectF.width();
        this.A = this.x.height();
        RectF rectF2 = this.p;
        int i6 = this.o;
        int i7 = this.n;
        rectF2.left = i6 + i7;
        rectF2.top = i6 + i7;
        int i8 = this.j;
        rectF2.right = (i8 - i6) - i7;
        rectF2.bottom = (i8 - i6) - i7;
        this.r = rectF2.height();
        float f = this.i * 0.7f;
        this.q = f;
        if (f > this.p.width() * 1.25f) {
            this.q = this.p.width() * 1.25f;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            if (!this.u) {
                i a2 = i.a(this, this.f4340b, this.y, 1.0f);
                this.f4339a = a2;
                a2.a(300L);
                this.f4339a.a(new DecelerateInterpolator());
                this.f4339a.b();
            }
            i a3 = i.a(this, this.f4342d, this.s, 0.0f);
            this.f4341c = a3;
            a3.a(300L);
            this.f4341c.a(new DecelerateInterpolator());
            this.f4341c.b();
            boolean z = this.u;
            this.v = z;
            e eVar = this.K;
            if (eVar != null && z != this.w) {
                eVar.a(z);
            }
        }
        return this.g.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.B = this.C;
        } else {
            this.B = a(0.5f, this.C, -1);
        }
    }

    /* loaded from: classes.dex */
    class a extends com.nineoldandroids.util.c<ShSwitchView, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // com.nineoldandroids.util.c
        public void a(ShSwitchView shSwitchView, Float f) {
            shSwitchView.a(f.floatValue());
        }

        @Override // com.nineoldandroids.util.c
        public Float a(ShSwitchView shSwitchView) {
            return Float.valueOf(shSwitchView.a());
        }
    }

    /* loaded from: classes.dex */
    class b extends com.nineoldandroids.util.c<ShSwitchView, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // com.nineoldandroids.util.c
        public void a(ShSwitchView shSwitchView, Float f) {
            shSwitchView.b(f.floatValue());
        }

        @Override // com.nineoldandroids.util.c
        public Float a(ShSwitchView shSwitchView) {
            return Float.valueOf(shSwitchView.b());
        }
    }

    /* loaded from: classes.dex */
    class c extends com.nineoldandroids.util.c<ShSwitchView, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // com.nineoldandroids.util.c
        public void a(ShSwitchView shSwitchView, Float f) {
            shSwitchView.c(f.floatValue());
        }

        @Override // com.nineoldandroids.util.c
        public Float a(ShSwitchView shSwitchView) {
            return Float.valueOf(shSwitchView.c());
        }
    }

    public ShSwitchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4340b = new a(Float.class, "innerBound");
        this.f4342d = new b(Float.class, "knobExpand");
        this.f = new c(Float.class, "knobMove");
        this.h = new d();
        this.y = 1.0f;
        this.D = -3355444;
        this.G = false;
        this.J = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShSwitchView);
        int color = obtainStyledAttributes.getColor(2, -6493879);
        this.B = color;
        this.C = color;
        int applyDimension = (int) TypedValue.applyDimension(1, 1.5f, context.getResources().getDisplayMetrics());
        int applyDimension2 = (int) TypedValue.applyDimension(1, 5.0f, context.getResources().getDisplayMetrics());
        this.o = obtainStyledAttributes.getDimensionPixelOffset(0, applyDimension);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(1, applyDimension2);
        obtainStyledAttributes.recycle();
        this.p = new RectF();
        this.x = new RectF();
        this.F = new RectF();
        this.E = new Paint(1);
        GestureDetector gestureDetector = new GestureDetector(context, this.h);
        this.g = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        i a2 = i.a(this, this.f4340b, this.y, 1.0f);
        this.f4339a = a2;
        a2.a(300L);
        this.f4339a.a(new DecelerateInterpolator());
        i a3 = i.a(this, this.f4342d, this.s, 1.0f);
        this.f4341c = a3;
        a3.a(300L);
        this.f4341c.a(new DecelerateInterpolator());
        i a4 = i.a(this, this.f, this.t, 1.0f);
        this.e = a4;
        a4.a(300L);
        this.e.a(new DecelerateInterpolator());
    }

    public void a(e eVar) {
        this.K = eVar;
    }

    void b(float f) {
        this.s = f;
        invalidate();
    }

    void c(float f) {
        this.t = f;
        invalidate();
    }

    void a(float f) {
        this.y = f;
        invalidate();
    }

    float b() {
        return this.s;
    }

    float c() {
        return this.t;
    }

    float a() {
        return this.y;
    }

    public void a(boolean z) {
        a(z, false);
    }

    public void a(boolean z, boolean z2) {
        boolean z3;
        if (this.v == z) {
            return;
        }
        if (!this.J && z2) {
            this.G = true;
            this.v = z;
            return;
        }
        this.v = z;
        this.u = z;
        if (!z2) {
            if (z) {
                c(1.0f);
                a(0.0f);
            } else {
                c(0.0f);
                a(1.0f);
            }
            b(0.0f);
        } else {
            if (z) {
                this.e.a(this.t, 1.0f);
                this.e.b();
                this.f4339a.a(this.y, 0.0f);
                this.f4339a.b();
            } else {
                this.e.a(this.t, 0.0f);
                this.e.b();
                this.f4339a.a(this.y, 1.0f);
                this.f4339a.b();
            }
            this.f4341c.a(this.s, 0.0f);
            this.f4341c.b();
        }
        e eVar = this.K;
        if (eVar == null || (z3 = this.v) == this.w) {
            return;
        }
        eVar.a(z3);
    }

    private void a(float f, float f2, float f3, float f4, float f5, Canvas canvas, Paint paint) {
        RectF rectF = this.F;
        rectF.left = f;
        rectF.top = f2;
        rectF.right = f3;
        rectF.bottom = f4;
        canvas.drawRoundRect(rectF, f5, f5, paint);
    }
}
