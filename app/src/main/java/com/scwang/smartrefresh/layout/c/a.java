package com.scwang.smartrefresh.layout.c;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;

/* compiled from: ProgressDrawable.java */
/* loaded from: classes.dex */
public class a extends Drawable implements Animatable {

    /* renamed from: b, reason: collision with root package name */
    private ValueAnimator f2748b;

    /* renamed from: d, reason: collision with root package name */
    private Paint f2750d;

    /* renamed from: a, reason: collision with root package name */
    private int f2747a = 0;

    /* renamed from: c, reason: collision with root package name */
    private Path f2749c = new Path();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProgressDrawable.java */
    /* renamed from: com.scwang.smartrefresh.layout.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0086a implements ValueAnimator.AnimatorUpdateListener {
        C0086a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f2747a = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
            a.this.invalidateSelf();
        }
    }

    public a() {
        Paint paint = new Paint();
        this.f2750d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f2750d.setAntiAlias(true);
        this.f2750d.setColor(-5592406);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        canvas.save();
        float f = width / 2;
        float f2 = height / 2;
        canvas.rotate(this.f2747a, f, f2);
        int max = Math.max(1, width / 20);
        for (int i = 0; i < 12; i++) {
            this.f2749c.reset();
            float f3 = width - max;
            float f4 = max;
            this.f2749c.addCircle(f3, f2, f4, Path.Direction.CW);
            float f5 = width - (max * 5);
            this.f2749c.addRect(f5, r0 - max, f3, r0 + max, Path.Direction.CW);
            this.f2749c.addCircle(f5, f2, f4, Path.Direction.CW);
            this.f2750d.setAlpha((i + 5) * 17);
            canvas.rotate(30.0f, f, f2);
            canvas.drawPath(this.f2749c, this.f2750d);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f2748b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2750d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2750d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f2748b.isRunning()) {
            return;
        }
        this.f2748b.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f2748b.isRunning()) {
            this.f2748b.cancel();
        }
    }

    public void a(int i) {
        this.f2750d.setColor(i);
    }

    private void a() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, 3600);
        this.f2748b = ofInt;
        ofInt.addUpdateListener(new C0086a());
        this.f2748b.setDuration(10000L);
        this.f2748b.setInterpolator(new LinearInterpolator());
        this.f2748b.setRepeatCount(-1);
        this.f2748b.setRepeatMode(1);
    }
}
