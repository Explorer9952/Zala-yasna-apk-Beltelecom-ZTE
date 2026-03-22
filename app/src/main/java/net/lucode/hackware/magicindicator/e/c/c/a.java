package net.lucode.hackware.magicindicator.e.c.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.e.b;
import net.lucode.hackware.magicindicator.e.c.b.c;

/* compiled from: LinePagerIndicator.java */
/* loaded from: classes2.dex */
public class a extends View implements c {

    /* renamed from: a, reason: collision with root package name */
    private int f8243a;

    /* renamed from: b, reason: collision with root package name */
    private Interpolator f8244b;

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f8245c;

    /* renamed from: d, reason: collision with root package name */
    private float f8246d;
    private float e;
    private float f;
    private float g;
    private float h;
    private Paint i;
    private List<net.lucode.hackware.magicindicator.e.c.d.a> j;
    private List<Integer> k;
    private RectF l;

    public a(Context context) {
        super(context);
        this.f8244b = new LinearInterpolator();
        this.f8245c = new LinearInterpolator();
        this.l = new RectF();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.e = b.a(context, 3.0d);
        this.g = b.a(context, 10.0d);
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.c
    public void a(int i) {
    }

    public void b(float f) {
        this.h = f;
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.c
    public void b(int i) {
    }

    public void c(float f) {
        this.f = f;
    }

    public void d(float f) {
        this.f8246d = f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.l;
        float f = this.h;
        canvas.drawRoundRect(rectF, f, f, this.i);
    }

    public void c(int i) {
        if (i != 2 && i != 0 && i != 1) {
            throw new IllegalArgumentException("mode " + i + " not supported.");
        }
        this.f8243a = i;
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.c
    public void a(int i, float f, int i2) {
        float b2;
        float b3;
        float b4;
        float f2;
        float f3;
        int i3;
        List<net.lucode.hackware.magicindicator.e.c.d.a> list = this.j;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<Integer> list2 = this.k;
        if (list2 != null && list2.size() > 0) {
            this.i.setColor(net.lucode.hackware.magicindicator.e.a.a(f, this.k.get(Math.abs(i) % this.k.size()).intValue(), this.k.get(Math.abs(i + 1) % this.k.size()).intValue()));
        }
        net.lucode.hackware.magicindicator.e.c.d.a a2 = net.lucode.hackware.magicindicator.a.a(this.j, i);
        net.lucode.hackware.magicindicator.e.c.d.a a3 = net.lucode.hackware.magicindicator.a.a(this.j, i + 1);
        int i4 = this.f8243a;
        if (i4 == 0) {
            float f4 = a2.f8247a;
            f3 = this.f;
            b2 = f4 + f3;
            f2 = a3.f8247a + f3;
            b3 = a2.f8249c - f3;
            i3 = a3.f8249c;
        } else if (i4 == 1) {
            float f5 = a2.e;
            f3 = this.f;
            b2 = f5 + f3;
            f2 = a3.e + f3;
            b3 = a2.g - f3;
            i3 = a3.g;
        } else {
            b2 = a2.f8247a + ((a2.b() - this.g) / 2.0f);
            float b5 = a3.f8247a + ((a3.b() - this.g) / 2.0f);
            b3 = ((a2.b() + this.g) / 2.0f) + a2.f8247a;
            b4 = ((a3.b() + this.g) / 2.0f) + a3.f8247a;
            f2 = b5;
            this.l.left = b2 + ((f2 - b2) * this.f8244b.getInterpolation(f));
            this.l.right = b3 + ((b4 - b3) * this.f8245c.getInterpolation(f));
            this.l.top = (getHeight() - this.e) - this.f8246d;
            this.l.bottom = getHeight() - this.f8246d;
            invalidate();
        }
        b4 = i3 - f3;
        this.l.left = b2 + ((f2 - b2) * this.f8244b.getInterpolation(f));
        this.l.right = b3 + ((b4 - b3) * this.f8245c.getInterpolation(f));
        this.l.top = (getHeight() - this.e) - this.f8246d;
        this.l.bottom = getHeight() - this.f8246d;
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.c
    public void a(List<net.lucode.hackware.magicindicator.e.c.d.a> list) {
        this.j = list;
    }

    public void a(float f) {
        this.e = f;
    }

    public void a(Integer... numArr) {
        this.k = Arrays.asList(numArr);
    }
}
