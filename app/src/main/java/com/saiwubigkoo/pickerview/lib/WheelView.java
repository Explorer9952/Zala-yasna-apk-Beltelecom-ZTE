package com.saiwubigkoo.pickerview.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.saiwubigkoo.pickerview.R$bool;
import com.saiwubigkoo.pickerview.R$color;
import com.saiwubigkoo.pickerview.R$dimen;
import com.saiwubigkoo.pickerview.R$styleable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class WheelView extends View {
    int A;
    int B;
    int C;
    int D;
    int E;
    private int F;
    private float G;
    long J;
    int K;
    private int L;
    private int M;
    private int N;

    /* renamed from: a, reason: collision with root package name */
    Handler f2679a;

    /* renamed from: b, reason: collision with root package name */
    private GestureDetector f2680b;

    /* renamed from: c, reason: collision with root package name */
    com.saiwubigkoo.pickerview.b.a f2681c;

    /* renamed from: d, reason: collision with root package name */
    ScheduledExecutorService f2682d;
    private ScheduledFuture<?> e;
    Paint f;
    Paint g;
    Paint h;
    com.saiwubigkoo.pickerview.a.a i;
    private String j;
    int k;
    int l;
    int m;
    float n;
    int o;
    int p;
    int q;
    boolean r;
    float s;
    float t;
    float u;
    int v;
    int w;
    private int x;
    int y;
    int z;

    /* loaded from: classes.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public WheelView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        this.f2679a = new c(this);
        GestureDetector gestureDetector = new GestureDetector(context, new b(this));
        this.f2680b = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.r = true;
        this.v = 0;
        this.w = -1;
        e();
    }

    private void e() {
        Paint paint = new Paint();
        this.f = paint;
        paint.setColor(this.o);
        this.f.setAntiAlias(true);
        this.f.setTypeface(Typeface.MONOSPACE);
        this.f.setTextSize(this.k);
        Paint paint2 = new Paint();
        this.g = paint2;
        paint2.setColor(this.p);
        this.g.setAntiAlias(true);
        this.g.setTextScaleX(1.1f);
        this.g.setTypeface(Typeface.MONOSPACE);
        this.g.setTextSize(this.k);
        Paint paint3 = new Paint();
        this.h = paint3;
        paint3.setColor(this.q);
        this.h.setAntiAlias(true);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    private void f() {
        Rect rect = new Rect();
        for (int i = 0; i < this.i.a(); i++) {
            String a2 = a(this.i.getItem(i));
            this.g.getTextBounds(a2, 0, a2.length(), rect);
            int width = rect.width();
            if (width > this.l) {
                this.l = width;
            }
            this.g.getTextBounds("星期", 0, 2, rect);
            int height = (int) (rect.height() * 1.2f);
            if (height > this.m) {
                this.m = height;
            }
        }
        this.n = this.m * 1.4f;
    }

    private void g() {
        if (this.i == null) {
            return;
        }
        f();
        int i = (int) (this.n * (this.A - 1));
        this.D = i;
        double d2 = i * 2;
        Double.isNaN(d2);
        this.B = (int) (d2 / 3.141592653589793d);
        double d3 = i;
        Double.isNaN(d3);
        this.E = (int) (d3 / 3.141592653589793d);
        this.C = View.MeasureSpec.getSize(this.K);
        int i2 = this.B;
        float f = this.n;
        this.s = (i2 - f) / 2.0f;
        this.t = (i2 + f) / 2.0f;
        this.u = ((i2 + this.m) / 2.0f) - 6.0f;
        if (this.w == -1) {
            if (this.r) {
                this.w = (this.i.a() + 1) / 2;
            } else {
                this.w = 0;
            }
        }
        this.y = this.w;
    }

    public final int b() {
        return this.x;
    }

    public int c() {
        com.saiwubigkoo.pickerview.a.a aVar = this.i;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        if (this.f2681c != null) {
            postDelayed(new d(this), 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        com.saiwubigkoo.pickerview.a.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        Object[] objArr = new Object[this.A];
        int i2 = (int) (this.v / this.n);
        this.z = i2;
        try {
            this.y = this.w + (i2 % aVar.a());
        } catch (ArithmeticException unused) {
            System.out.println("出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (!this.r) {
            if (this.y < 0) {
                this.y = 0;
            }
            if (this.y > this.i.a() - 1) {
                this.y = this.i.a() - 1;
            }
        } else {
            if (this.y < 0) {
                this.y = this.i.a() + this.y;
            }
            if (this.y > this.i.a() - 1) {
                this.y -= this.i.a();
            }
        }
        int i3 = (int) (this.v % this.n);
        int i4 = 0;
        while (true) {
            int i5 = this.A;
            if (i4 >= i5) {
                break;
            }
            int i6 = this.y - ((i5 / 2) - i4);
            if (this.r) {
                objArr[i4] = this.i.getItem(a(i6));
            } else if (i6 < 0) {
                objArr[i4] = "";
            } else if (i6 > this.i.a() - 1) {
                objArr[i4] = "";
            } else {
                objArr[i4] = this.i.getItem(i6);
            }
            i4++;
        }
        float f = this.s;
        canvas.drawLine(0.0f, f, this.C, f, this.h);
        float f2 = this.t;
        canvas.drawLine(0.0f, f2, this.C, f2, this.h);
        if (this.j != null) {
            canvas.drawText(this.j, (this.C - a(this.g, r1)) - 6.0f, this.u, this.g);
        }
        int i7 = 0;
        while (i7 < this.A) {
            canvas.save();
            float f3 = this.m * 1.4f;
            double d2 = (i7 * f3) - i3;
            Double.isNaN(d2);
            double d3 = this.D;
            Double.isNaN(d3);
            double d4 = (d2 * 3.141592653589793d) / d3;
            float f4 = (float) (90.0d - ((d4 / 3.141592653589793d) * 180.0d));
            if (f4 < 90.0f && f4 > -90.0f) {
                String a2 = a(objArr[i7]);
                a(a2);
                b(a2);
                double d5 = this.E;
                double cos = Math.cos(d4);
                i = i3;
                double d6 = this.E;
                Double.isNaN(d6);
                Double.isNaN(d5);
                double d7 = d5 - (cos * d6);
                double sin = Math.sin(d4);
                double d8 = this.m;
                Double.isNaN(d8);
                float f5 = (float) (d7 - ((sin * d8) / 2.0d));
                canvas.translate(0.0f, f5);
                canvas.scale(1.0f, (float) Math.sin(d4));
                float f6 = this.s;
                if (f5 <= f6 && this.m + f5 >= f6) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.C, this.s - f5);
                    canvas.scale(1.0f, ((float) Math.sin(d4)) * 0.8f);
                    canvas.drawText(a2, this.N, this.m, this.f);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.s - f5, this.C, (int) f3);
                    canvas.scale(1.0f, ((float) Math.sin(d4)) * 1.0f);
                    canvas.drawText(a2, this.M, this.m - 6.0f, this.g);
                    canvas.restore();
                } else {
                    float f7 = this.t;
                    if (f5 <= f7 && this.m + f5 >= f7) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.C, this.t - f5);
                        canvas.scale(1.0f, ((float) Math.sin(d4)) * 1.0f);
                        canvas.drawText(a2, this.M, this.m - 6.0f, this.g);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.t - f5, this.C, (int) f3);
                        canvas.scale(1.0f, ((float) Math.sin(d4)) * 0.8f);
                        canvas.drawText(a2, this.N, this.m, this.f);
                        canvas.restore();
                    } else if (f5 >= this.s && this.m + f5 <= this.t) {
                        canvas.clipRect(0, 0, this.C, (int) f3);
                        canvas.drawText(a2, this.M, this.m - 6.0f, this.g);
                        int indexOf = this.i.indexOf(objArr[i7]);
                        if (indexOf != -1) {
                            this.x = indexOf;
                        }
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.C, (int) f3);
                        canvas.scale(1.0f, ((float) Math.sin(d4)) * 0.8f);
                        canvas.drawText(a2, this.N, this.m, this.f);
                        canvas.restore();
                        canvas.restore();
                    }
                }
                canvas.restore();
            } else {
                i = i3;
                canvas.restore();
            }
            i7++;
            i3 = i;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.K = i;
        g();
        setMeasuredDimension(this.C, this.B);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f2680b.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.J = System.currentTimeMillis();
            a();
            this.G = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.G - motionEvent.getRawY();
            this.G = motionEvent.getRawY();
            this.v = (int) (this.v + rawY);
            if (!this.r) {
                float f = (-this.w) * this.n;
                float a2 = (this.i.a() - 1) - this.w;
                float f2 = this.n;
                float f3 = a2 * f2;
                int i = this.v;
                double d2 = i;
                double d3 = f2;
                Double.isNaN(d3);
                Double.isNaN(d2);
                if (d2 - (d3 * 0.3d) < f) {
                    f = i - rawY;
                } else {
                    double d4 = i;
                    double d5 = f2;
                    Double.isNaN(d5);
                    Double.isNaN(d4);
                    if (d4 + (d5 * 0.3d) > f3) {
                        f3 = i - rawY;
                    }
                }
                int i2 = this.v;
                if (i2 < f) {
                    this.v = (int) f;
                } else if (i2 > f3) {
                    this.v = (int) f3;
                }
            }
        } else if (!onTouchEvent) {
            float y = motionEvent.getY();
            int i3 = this.E;
            double acos = Math.acos((i3 - y) / i3);
            double d6 = this.E;
            Double.isNaN(d6);
            double d7 = acos * d6;
            float f4 = this.n;
            double d8 = f4 / 2.0f;
            Double.isNaN(d8);
            double d9 = d7 + d8;
            Double.isNaN(f4);
            this.F = (int) (((((int) (d9 / r4)) - (this.A / 2)) * f4) - (((this.v % f4) + f4) % f4));
            if (System.currentTimeMillis() - this.J > 120) {
                a(ACTION.DAGGLE);
            } else {
                a(ACTION.CLICK);
            }
        }
        invalidate();
        return true;
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2682d = Executors.newSingleThreadScheduledExecutor();
        this.A = 5;
        this.F = 0;
        this.G = 0.0f;
        this.J = 0L;
        this.L = 17;
        this.M = 0;
        this.N = 0;
        this.o = getResources().getColor(R$color.pickerview_wheelview_textcolor_out);
        this.p = getResources().getColor(R$color.pickerview_wheelview_textcolor_center);
        this.q = getResources().getColor(R$color.pickerview_wheelview_textcolor_divider);
        this.k = getResources().getDimensionPixelSize(R$dimen.pickerview_textsize);
        getResources().getBoolean(R$bool.pickerview_customTextSize);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.pickerview, 0, 0);
            this.L = obtainStyledAttributes.getInt(0, 17);
            this.o = obtainStyledAttributes.getColor(2, this.o);
            this.p = obtainStyledAttributes.getColor(3, this.p);
            this.q = obtainStyledAttributes.getColor(4, this.q);
            this.k = obtainStyledAttributes.getDimensionPixelOffset(1, this.k);
        }
        a(context);
    }

    private void b(String str) {
        Rect rect = new Rect();
        this.f.getTextBounds(str, 0, str.length(), rect);
        int i = this.L;
        if (i == 3) {
            this.N = 0;
            return;
        }
        if (i == 5) {
            this.N = this.C - rect.width();
            return;
        }
        if (i == 17) {
            double width = this.C - rect.width();
            Double.isNaN(width);
            this.N = (int) (width * 0.5d);
        } else {
            if (i == 102) {
                if (str.length() <= 1) {
                    this.f.getTextBounds("000", 0, 3, rect);
                } else {
                    this.f.getTextBounds("00", 0, 2, rect);
                }
                this.N = rect.width();
                return;
            }
            if (i != 104) {
                return;
            }
            if (str.length() <= 1) {
                this.f.getTextBounds("000", 0, 3, rect);
                this.N = this.C - rect.width();
            } else {
                this.f.getTextBounds("00", 0, 2, rect);
                this.N = this.C - (rect.width() * 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ACTION action) {
        a();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.v;
            float f2 = this.n;
            int i = (int) (((f % f2) + f2) % f2);
            this.F = i;
            if (i > f2 / 2.0f) {
                this.F = (int) (f2 - i);
            } else {
                this.F = -i;
            }
        }
        this.e = this.f2682d.scheduleWithFixedDelay(new e(this, this.F), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(float f) {
        a();
        this.e = this.f2682d.scheduleWithFixedDelay(new a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void a() {
        ScheduledFuture<?> scheduledFuture = this.e;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.e.cancel(true);
        this.e = null;
    }

    private int a(int i) {
        if (i < 0) {
            return a(i + this.i.a());
        }
        return i > this.i.a() + (-1) ? a(i - this.i.a()) : i;
    }

    private String a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.saiwubigkoo.pickerview.c.a) {
            return ((com.saiwubigkoo.pickerview.c.a) obj).a();
        }
        return obj.toString();
    }

    private void a(String str) {
        Rect rect = new Rect();
        this.g.getTextBounds(str, 0, str.length(), rect);
        int i = this.L;
        if (i == 3) {
            this.M = 0;
            return;
        }
        if (i == 5) {
            this.M = this.C - rect.width();
            return;
        }
        if (i == 17) {
            double width = this.C - rect.width();
            Double.isNaN(width);
            this.M = (int) (width * 0.5d);
        } else {
            if (i == 102) {
                if (str.length() <= 1) {
                    this.f.getTextBounds("000", 0, 3, rect);
                } else {
                    this.f.getTextBounds("00", 0, 2, rect);
                }
                this.M = rect.width();
                return;
            }
            if (i != 104) {
                return;
            }
            if (str.length() <= 1) {
                this.f.getTextBounds("000", 0, 3, rect);
                this.M = this.C - rect.width();
            } else {
                this.f.getTextBounds("00", 0, 2, rect);
                this.M = this.C - (rect.width() * 2);
            }
        }
    }

    public int a(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil(r2[i2]);
        }
        return i;
    }
}
