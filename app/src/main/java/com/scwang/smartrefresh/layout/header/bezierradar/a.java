package com.scwang.smartrefresh.layout.header.bezierradar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* compiled from: RippleView.java */
/* loaded from: classes.dex */
public class a extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f2792a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f2793b;

    /* renamed from: c, reason: collision with root package name */
    private ValueAnimator f2794c;

    /* compiled from: RippleView.java */
    /* renamed from: com.scwang.smartrefresh.layout.header.bezierradar.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0087a implements ValueAnimator.AnimatorUpdateListener {
        C0087a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f2792a = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            a.this.invalidate();
        }
    }

    /* compiled from: RippleView.java */
    /* loaded from: classes.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }
    }

    public a(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f2793b = paint;
        paint.setAntiAlias(true);
        this.f2793b.setColor(-1);
        this.f2793b.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f2792a, this.f2793b);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    public void a(int i) {
        this.f2793b.setColor(i);
    }

    public void a() {
        if (this.f2794c == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) Math.sqrt(Math.pow(getHeight(), 2.0d) + Math.pow(getWidth(), 2.0d)));
            this.f2794c = ofInt;
            ofInt.setDuration(400L);
            this.f2794c.addUpdateListener(new C0087a());
            this.f2794c.addListener(new b());
        }
        this.f2794c.start();
    }
}
