package com.scwang.smartrefresh.layout.header.bezierradar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/* compiled from: RoundProgressView.java */
/* loaded from: classes.dex */
public class c extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f2801a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f2802b;

    /* renamed from: c, reason: collision with root package name */
    private ValueAnimator f2803c;

    /* renamed from: d, reason: collision with root package name */
    private int f2804d;
    private int e;
    private int f;
    private int g;
    private RectF h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RoundProgressView.java */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.f2804d = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            c.this.postInvalidate();
        }
    }

    public c(Context context) {
        super(context);
        this.f2804d = 0;
        this.e = 270;
        this.f = 0;
        this.g = 0;
        this.h = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        c();
    }

    private void c() {
        this.f2801a = new Paint();
        this.f2802b = new Paint();
        this.f2801a.setAntiAlias(true);
        this.f2802b.setAntiAlias(true);
        this.f2801a.setColor(-1);
        this.f2802b.setColor(1426063360);
        com.scwang.smartrefresh.layout.e.a aVar = new com.scwang.smartrefresh.layout.e.a();
        this.f = aVar.a(20.0f);
        this.g = aVar.a(7.0f);
        this.f2801a.setStrokeWidth(aVar.a(3.0f));
        this.f2802b.setStrokeWidth(aVar.a(3.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 360);
        this.f2803c = ofInt;
        ofInt.setDuration(720L);
        this.f2803c.addUpdateListener(new a());
        this.f2803c.setRepeatCount(-1);
        this.f2803c.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public void b(int i) {
        this.f2801a.setColor(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (isInEditMode()) {
            this.e = 0;
            this.f2804d = 270;
        }
        this.f2801a.setStyle(Paint.Style.FILL);
        float f = width / 2;
        float f2 = height / 2;
        canvas.drawCircle(f, f2, this.f, this.f2801a);
        this.f2801a.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(f, f2, this.f + this.g, this.f2801a);
        this.f2802b.setStyle(Paint.Style.FILL);
        RectF rectF = this.h;
        int i = this.f;
        rectF.set(r0 - i, r1 - i, r0 + i, i + r1);
        canvas.drawArc(this.h, this.e, this.f2804d, true, this.f2802b);
        this.f += this.g;
        this.f2802b.setStyle(Paint.Style.STROKE);
        RectF rectF2 = this.h;
        int i2 = this.f;
        rectF2.set(r0 - i2, r1 - i2, r0 + i2, r1 + i2);
        canvas.drawArc(this.h, this.e, this.f2804d, false, this.f2802b);
        this.f -= this.g;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    public void a(int i) {
        this.f2802b.setColor((i & 16777215) | 1426063360);
    }

    public void b() {
        ValueAnimator valueAnimator = this.f2803c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f2803c.cancel();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f2803c;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }
}
