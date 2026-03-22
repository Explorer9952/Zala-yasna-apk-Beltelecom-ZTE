package com.zte.iptvclient.android.common.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.ahmobile.android.tvclient.R$styleable;

/* loaded from: classes.dex */
public class RoundProgressBar extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f4335a;

    /* renamed from: b, reason: collision with root package name */
    private int f4336b;

    /* renamed from: c, reason: collision with root package name */
    private int f4337c;

    /* renamed from: d, reason: collision with root package name */
    private int f4338d;
    private float e;
    private float f;
    private int g;
    private int h;
    private boolean i;
    private int j;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public synchronized void a(int i) {
        if (i >= 0) {
            if (i > this.g) {
                i = this.g;
            }
            if (i <= this.g) {
                this.h = i;
                postInvalidate();
            }
        } else {
            throw new IllegalArgumentException("mProgress not less than 0");
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f = width;
        int i = (int) (f - (this.f / 2.0f));
        this.f4335a.setColor(this.f4336b);
        this.f4335a.setStyle(Paint.Style.STROKE);
        this.f4335a.setStrokeWidth(this.f);
        this.f4335a.setAntiAlias(true);
        canvas.drawCircle(f, f, i, this.f4335a);
        this.f4335a.setStrokeWidth(0.0f);
        this.f4335a.setColor(this.f4338d);
        this.f4335a.setTextSize(this.e);
        this.f4335a.setTypeface(Typeface.DEFAULT_BOLD);
        int i2 = (int) ((this.h / this.g) * 100.0f);
        float measureText = this.f4335a.measureText(i2 + "%");
        if (this.i && i2 >= 0 && this.j == 0) {
            canvas.drawText(i2 + "%", f - (measureText / 2.0f), f + (this.e / 2.0f), this.f4335a);
        }
        this.f4335a.setStrokeWidth(this.f);
        this.f4335a.setColor(this.f4337c);
        float f2 = width - i;
        float f3 = width + i;
        RectF rectF = new RectF(f2, f2, f3, f3);
        int i3 = this.j;
        if (i3 == 0) {
            this.f4335a.setStyle(Paint.Style.STROKE);
            canvas.drawArc(rectF, -90.0f, (this.h * 360) / this.g, false, this.f4335a);
        } else {
            if (i3 != 1) {
                return;
            }
            this.f4335a.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.h != 0) {
                canvas.drawArc(rectF, -90.0f, (r0 * 360) / this.g, true, this.f4335a);
            }
        }
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4335a = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundProgressBar);
        this.f4336b = obtainStyledAttributes.getColor(1, 2139654280);
        this.f4337c = obtainStyledAttributes.getColor(2, 2130771712);
        this.f4338d = obtainStyledAttributes.getColor(5, 2130771712);
        this.e = obtainStyledAttributes.getDimension(7, 30.0f);
        this.f = obtainStyledAttributes.getDimension(3, 8.0f);
        this.g = obtainStyledAttributes.getInteger(0, 100);
        this.i = obtainStyledAttributes.getBoolean(6, true);
        this.j = obtainStyledAttributes.getInt(4, 0);
        obtainStyledAttributes.recycle();
    }
}
