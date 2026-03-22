package com.scwang.smartrefresh.layout.internal.pathview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: PathsDrawable.java */
/* loaded from: classes.dex */
public class b extends Drawable {
    protected static final Region n = new Region();
    protected static final Region o = new Region(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

    /* renamed from: a, reason: collision with root package name */
    protected Paint f2811a;

    /* renamed from: b, reason: collision with root package name */
    protected List<Path> f2812b;

    /* renamed from: c, reason: collision with root package name */
    protected List<Integer> f2813c;

    /* renamed from: d, reason: collision with root package name */
    protected int f2814d = 1;
    protected int e = 1;
    protected int f = 0;
    protected int g = 0;
    protected int h;
    protected int i;
    protected List<Path> j;
    protected List<String> k;
    private Bitmap l;
    private boolean m;

    public b() {
        Paint paint = new Paint();
        this.f2811a = paint;
        paint.setColor(-15614977);
        this.f2811a.setStyle(Paint.Style.FILL);
        this.f2811a.setAntiAlias(true);
    }

    public void a(String... strArr) {
        this.i = 0;
        this.h = 0;
        this.k = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        this.f2812b = arrayList;
        for (String str : strArr) {
            this.k.add(str);
            this.j.add(a.b(str));
        }
        c();
    }

    public int b() {
        return getBounds().height();
    }

    protected void c() {
        Integer num;
        Integer num2;
        Integer num3;
        List<Path> list = this.f2812b;
        Integer num4 = null;
        if (list != null) {
            Iterator<Path> it2 = list.iterator();
            Integer num5 = null;
            num2 = null;
            num3 = null;
            while (it2.hasNext()) {
                n.setPath(it2.next(), o);
                Rect bounds = n.getBounds();
                num4 = Integer.valueOf(Math.min(num4 == null ? bounds.top : num4.intValue(), bounds.top));
                num5 = Integer.valueOf(Math.min(num5 == null ? bounds.left : num5.intValue(), bounds.left));
                num2 = Integer.valueOf(Math.max(num2 == null ? bounds.right : num2.intValue(), bounds.right));
                num3 = Integer.valueOf(Math.max(num3 == null ? bounds.bottom : num3.intValue(), bounds.bottom));
            }
            num = num4;
            num4 = num5;
        } else {
            num = null;
            num2 = null;
            num3 = null;
        }
        this.f = num4 == null ? 0 : num4.intValue();
        this.g = num == null ? 0 : num.intValue();
        this.f2814d = num2 == null ? 0 : num2.intValue() - this.f;
        this.e = num3 != null ? num3.intValue() - this.g : 0;
        if (this.h == 0) {
            this.h = this.f2814d;
        }
        if (this.i == 0) {
            this.i = this.e;
        }
        Rect bounds2 = getBounds();
        int i = bounds2.left;
        int i2 = bounds2.top;
        super.setBounds(i, i2, this.f2814d + i, this.e + i2);
    }

    public void d() {
        this.m = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (this.f2811a.getAlpha() == 255) {
            canvas.save();
            canvas.translate(bounds.left - this.f, bounds.top - this.g);
            if (this.f2812b != null) {
                for (int i = 0; i < this.f2812b.size(); i++) {
                    List<Integer> list = this.f2813c;
                    if (list != null && i < list.size()) {
                        this.f2811a.setColor(this.f2813c.get(i).intValue());
                    }
                    canvas.drawPath(this.f2812b.get(i), this.f2811a);
                }
                this.f2811a.setAlpha(255);
            }
            canvas.restore();
            return;
        }
        b(width, height);
        if (!a()) {
            c(width, height);
            d();
        }
        canvas.drawBitmap(this.l, bounds.left, bounds.top, this.f2811a);
    }

    public int e() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2811a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        List<Path> list = this.j;
        if (list != null && list.size() > 0 && (i5 != this.f2814d || i6 != this.e)) {
            this.f2812b = a.a((i5 * 1.0f) / this.h, (i6 * 1.0f) / this.i, this.j, this.k);
            c();
        } else {
            super.setBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2811a.setColorFilter(colorFilter);
    }

    public void b(int i, int i2) {
        if (this.l == null || !a(i, i2)) {
            this.l = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.m = true;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a(int... iArr) {
        this.f2813c = new ArrayList();
        for (int i : iArr) {
            this.f2813c.add(Integer.valueOf(i));
        }
    }

    private void a(Canvas canvas) {
        canvas.translate(-this.f, -this.g);
        if (this.f2812b != null) {
            for (int i = 0; i < this.f2812b.size(); i++) {
                List<Integer> list = this.f2813c;
                if (list != null && i < list.size()) {
                    this.f2811a.setColor(this.f2813c.get(i).intValue());
                }
                canvas.drawPath(this.f2812b.get(i), this.f2811a);
            }
        }
    }

    public boolean a(int i, int i2) {
        return i == this.l.getWidth() && i2 == this.l.getHeight();
    }

    public boolean a() {
        return !this.m;
    }

    public void c(int i, int i2) {
        this.l.eraseColor(0);
        a(new Canvas(this.l));
    }
}
