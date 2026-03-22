package com.scwang.smartrefresh.layout.header.bezierradar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* compiled from: RoundDotView.java */
/* loaded from: classes.dex */
public class b extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f2797a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f2798b;

    /* renamed from: c, reason: collision with root package name */
    private float f2799c;

    /* renamed from: d, reason: collision with root package name */
    private float f2800d;

    public b(Context context) {
        super(context);
        this.f2797a = 7;
        Paint paint = new Paint();
        this.f2798b = paint;
        paint.setAntiAlias(true);
        this.f2798b.setColor(-1);
        this.f2799c = com.scwang.smartrefresh.layout.e.a.b(7.0f);
    }

    public void a(int i) {
        this.f2798b.setColor(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i = this.f2797a;
        float f = this.f2800d;
        float f2 = ((width / i) * f) - (f > 1.0f ? ((f - 1.0f) * (width / i)) / f : 0.0f);
        float f3 = height;
        float f4 = this.f2800d;
        float f5 = 2.0f;
        float f6 = f3 - (f4 > 1.0f ? (((f4 - 1.0f) * f3) / 2.0f) / f4 : 0.0f);
        int i2 = 0;
        while (true) {
            int i3 = this.f2797a;
            if (i2 >= i3) {
                return;
            }
            float f7 = (i2 + 1.0f) - ((i3 + 1.0f) / f5);
            float abs = (1.0f - ((Math.abs(f7) / this.f2797a) * f5)) * 255.0f;
            float c2 = com.scwang.smartrefresh.layout.e.a.c(f3);
            Paint paint = this.f2798b;
            double d2 = abs;
            double d3 = c2;
            Double.isNaN(d3);
            double pow = 1.0d - (1.0d / Math.pow((d3 / 800.0d) + 1.0d, 15.0d));
            Double.isNaN(d2);
            paint.setAlpha((int) (d2 * pow));
            float f8 = this.f2799c * (1.0f - (1.0f / ((c2 / 10.0f) + 1.0f)));
            canvas.drawCircle(((width / 2) - (f8 / 2.0f)) + (f7 * f2), f6 / 2.0f, f8, this.f2798b);
            i2++;
            f5 = 2.0f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    public void a(float f) {
        this.f2800d = f;
    }
}
