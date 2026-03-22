package com.scwang.smartrefresh.layout.header.bezierradar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class WaveView extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f2788a;

    /* renamed from: b, reason: collision with root package name */
    private int f2789b;

    /* renamed from: c, reason: collision with root package name */
    private Path f2790c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f2791d;

    public WaveView(Context context) {
        this(context, null, 0);
    }

    private void b() {
        this.f2790c = new Path();
        Paint paint = new Paint();
        this.f2791d = paint;
        paint.setColor(-14736346);
        this.f2791d.setAntiAlias(true);
    }

    public void a(int i) {
        this.f2789b = i;
    }

    public void c(int i) {
        this.f2788a = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        this.f2790c.reset();
        this.f2790c.lineTo(0.0f, this.f2789b);
        float f = width;
        this.f2790c.quadTo(width / 2, this.f2788a + r4, f, this.f2789b);
        this.f2790c.lineTo(f, 0.0f);
        canvas.drawPath(this.f2790c, this.f2791d);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int a() {
        return this.f2788a;
    }

    public WaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public void b(int i) {
        this.f2791d.setColor(i);
    }
}
