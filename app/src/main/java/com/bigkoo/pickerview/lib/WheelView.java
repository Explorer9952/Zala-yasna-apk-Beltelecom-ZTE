package com.bigkoo.pickerview.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
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
import com.bigkoo.pickerview.R$styleable;
import java.lang.reflect.InvocationTargetException;
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
    int F;
    private int G;
    private float J;
    long K;
    int L;
    private int M;
    private int N;
    private int O;

    /* renamed from: a, reason: collision with root package name */
    Context f1898a;

    /* renamed from: b, reason: collision with root package name */
    Handler f1899b;

    /* renamed from: c, reason: collision with root package name */
    private GestureDetector f1900c;

    /* renamed from: d, reason: collision with root package name */
    com.bigkoo.pickerview.b.a f1901d;
    ScheduledExecutorService e;
    private ScheduledFuture<?> f;
    Paint g;
    Paint h;
    Paint i;
    com.bigkoo.pickerview.a.a j;
    a k;
    private String l;
    int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    boolean s;
    int t;
    int u;
    int v;
    int w;
    int x;
    private int y;
    int z;

    /* loaded from: classes.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* loaded from: classes.dex */
    class a extends DataSetObserver {
    }

    public WheelView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        this.f1898a = context;
        this.f1899b = new c(this);
        GestureDetector gestureDetector = new GestureDetector(context, new b(this));
        this.f1900c = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.s = false;
        this.m = 0;
        this.p = -5263441;
        this.q = -13553359;
        this.r = -3815995;
        this.w = 0;
        this.x = -1;
        e();
        b(16.0f);
    }

    private void e() {
        Paint paint = new Paint();
        this.g = paint;
        paint.setColor(this.p);
        this.g.setAntiAlias(true);
        this.g.setTypeface(Typeface.MONOSPACE);
        this.g.setTextSize(this.m);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setColor(this.q);
        this.h.setAntiAlias(true);
        this.h.setTextScaleX(1.1f);
        this.h.setTypeface(Typeface.MONOSPACE);
        this.h.setTextSize(this.m);
        Paint paint3 = new Paint();
        this.i = paint3;
        paint3.setColor(this.r);
        this.i.setAntiAlias(true);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    private void f() {
        Rect rect = new Rect();
        for (int i = 0; i < this.j.a(); i++) {
            String a2 = a(this.j.getItem(i));
            this.h.getTextBounds(a2, 0, a2.length(), rect);
            int width = rect.width();
            if (width > this.n) {
                this.n = width;
            }
            this.h.getTextBounds("星期", 0, 2, rect);
            int height = rect.height() + 20;
            if (height > this.o) {
                this.o = height;
            }
        }
    }

    private void g() {
        if (this.j == null) {
            return;
        }
        f();
        int i = (int) (this.o * 2.0f * (this.B - 1));
        this.E = i;
        double d2 = i * 2;
        Double.isNaN(d2);
        this.C = (int) (d2 / 3.141592653589793d);
        double d3 = i;
        Double.isNaN(d3);
        this.F = (int) (d3 / 3.141592653589793d);
        this.D = View.MeasureSpec.getSize(this.L);
        int i2 = this.C;
        int i3 = this.o;
        this.t = (int) ((i2 - (i3 * 2.0f)) / 2.0f);
        this.u = (int) ((i2 + (i3 * 2.0f)) / 2.0f);
        this.v = (int) (((i2 + i3) / 2.0f) - 6.0f);
        if (this.x == -1) {
            if (this.s) {
                this.x = (this.j.a() + 1) / 2;
            } else {
                this.x = 0;
            }
        }
        this.z = this.x;
    }

    public final void b(float f) {
        if (f > 0.0f) {
            int i = (int) (this.f1898a.getResources().getDisplayMetrics().density * f);
            this.m = i;
            this.g.setTextSize(i);
            this.h.setTextSize(this.m);
        }
    }

    public int c() {
        com.bigkoo.pickerview.a.a aVar = this.j;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        if (this.f1901d != null) {
            post(new d(this));
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bigkoo.pickerview.a.a aVar = this.j;
        if (aVar != null) {
            aVar.unregisterDataSetObserver(this.k);
            this.k = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        com.bigkoo.pickerview.a.a aVar = this.j;
        if (aVar == null) {
            return;
        }
        Object[] objArr = new Object[this.B];
        float f = 2.0f;
        int i = (int) (this.w / (this.o * 2.0f));
        this.A = i;
        try {
            this.z = this.x + (i % aVar.a());
        } catch (ArithmeticException unused) {
            System.out.println("出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (!this.s) {
            if (this.z < 0) {
                this.z = 0;
            }
            if (this.z > this.j.a() - 1) {
                this.z = this.j.a() - 1;
            }
        } else {
            if (this.z < 0) {
                this.z = this.j.a() + this.z;
            }
            if (this.z > this.j.a() - 1) {
                this.z -= this.j.a();
            }
        }
        int i2 = (int) (this.w % (this.o * 2.0f));
        int i3 = 0;
        while (true) {
            int i4 = this.B;
            if (i3 >= i4) {
                break;
            }
            int i5 = this.z - ((i4 / 2) - i3);
            if (this.s) {
                if (i5 < 0 && (i5 = i5 + this.j.a()) < 0) {
                    i5 = 0;
                }
                if (i5 > this.j.a() - 1 && (i5 = i5 - this.j.a()) > this.j.a() - 1) {
                    i5 = this.j.a() - 1;
                }
                objArr[i3] = this.j.getItem(i5);
            } else if (i5 < 0) {
                objArr[i3] = "";
            } else if (i5 > this.j.a() - 1) {
                objArr[i3] = "";
            } else {
                objArr[i3] = this.j.getItem(i5);
            }
            i3++;
        }
        int i6 = this.t;
        canvas.drawLine(0.0f, i6, this.D, i6, this.i);
        int i7 = this.u;
        canvas.drawLine(0.0f, i7, this.D, i7, this.i);
        if (this.l != null) {
            canvas.drawText(this.l, (this.D - a(this.h, r1)) - 6.0f, this.v, this.h);
        }
        int i8 = 0;
        while (i8 < this.B) {
            canvas.save();
            float f2 = this.o * f;
            double d2 = (i8 * f2) - i2;
            Double.isNaN(d2);
            double d3 = this.E;
            Double.isNaN(d3);
            double d4 = (d2 * 3.141592653589793d) / d3;
            float f3 = (float) (90.0d - ((d4 / 3.141592653589793d) * 180.0d));
            if (f3 < 90.0f && f3 > -90.0f) {
                String a2 = a(objArr[i8]);
                a(a2);
                b(a2);
                double d5 = this.F;
                double cos = Math.cos(d4);
                double d6 = this.F;
                Double.isNaN(d6);
                Double.isNaN(d5);
                double d7 = d5 - (cos * d6);
                double sin = Math.sin(d4);
                double d8 = this.o;
                Double.isNaN(d8);
                int i9 = (int) (d7 - ((sin * d8) / 2.0d));
                canvas.translate(0.0f, i9);
                canvas.scale(1.0f, (float) Math.sin(d4));
                int i10 = this.t;
                if (i9 <= i10 && this.o + i9 >= i10) {
                    canvas.save();
                    canvas.clipRect(0, 0, this.D, this.t - i9);
                    canvas.scale(1.0f, ((float) Math.sin(d4)) * 0.8f);
                    canvas.drawText(a2, this.O, this.o, this.g);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0, this.t - i9, this.D, (int) f2);
                    canvas.scale(1.0f, ((float) Math.sin(d4)) * 1.0f);
                    canvas.drawText(a2, this.N, this.o - 6.0f, this.h);
                    canvas.restore();
                } else {
                    int i11 = this.u;
                    if (i9 <= i11 && this.o + i9 >= i11) {
                        canvas.save();
                        canvas.clipRect(0, 0, this.D, this.u - i9);
                        canvas.scale(1.0f, ((float) Math.sin(d4)) * 1.0f);
                        canvas.drawText(a2, this.N, this.o - 6.0f, this.h);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0, this.u - i9, this.D, (int) f2);
                        canvas.scale(1.0f, ((float) Math.sin(d4)) * 0.8f);
                        canvas.drawText(a2, this.O, this.o, this.g);
                        canvas.restore();
                    } else {
                        if (i9 >= this.t && this.o + i9 <= this.u) {
                            canvas.clipRect(0, 0, this.D, (int) f2);
                            canvas.drawText(a2, this.N, this.o - 6.0f, this.h);
                            int indexOf = this.j.indexOf(objArr[i8]);
                            if (indexOf != -1) {
                                this.y = indexOf;
                            }
                        } else {
                            canvas.save();
                            canvas.clipRect(0, 0, this.D, (int) f2);
                            canvas.scale(1.0f, ((float) Math.sin(d4)) * 0.8f);
                            canvas.drawText(a2, this.O, this.o, this.g);
                            canvas.restore();
                        }
                        canvas.restore();
                    }
                }
                canvas.restore();
            } else {
                canvas.restore();
            }
            i8++;
            f = 2.0f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.L = i;
        g();
        setMeasuredDimension(this.D, this.C);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f1900c.onTouchEvent(motionEvent);
        float f = this.o * 2.0f;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.K = System.currentTimeMillis();
            a();
            this.J = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.J - motionEvent.getRawY();
            this.J = motionEvent.getRawY();
            this.w = (int) (this.w + rawY);
            if (!this.s) {
                float f2 = (-this.x) * f;
                float a2 = ((this.j.a() - 1) - this.x) * f;
                int i = this.w;
                if (i < f2) {
                    this.w = (int) f2;
                } else if (i > a2) {
                    this.w = (int) a2;
                }
            }
        } else if (!onTouchEvent) {
            float y = motionEvent.getY();
            int i2 = this.F;
            double acos = Math.acos((i2 - y) / i2);
            double d2 = this.F;
            Double.isNaN(d2);
            double d3 = f / 2.0f;
            Double.isNaN(d3);
            double d4 = (acos * d2) + d3;
            Double.isNaN(f);
            this.G = (int) (((((int) (d4 / r2)) - (this.B / 2)) * f) - (((this.w % f) + f) % f));
            if (System.currentTimeMillis() - this.K > 120) {
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
        this.e = Executors.newSingleThreadScheduledExecutor();
        this.B = 11;
        this.G = 0;
        this.K = 0L;
        this.M = 17;
        this.N = 0;
        this.O = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.wheelview, 0, 0);
            this.M = obtainStyledAttributes.getInt(R$styleable.wheelview_gravity, 17);
            obtainStyledAttributes.recycle();
        }
        a(context);
    }

    public final int b() {
        return this.y;
    }

    private void b(String str) {
        Rect rect = new Rect();
        this.g.getTextBounds(str, 0, str.length(), rect);
        int i = this.M;
        if (i == 3) {
            this.O = 0;
            return;
        }
        if (i == 5) {
            this.O = this.D - rect.width();
        } else {
            if (i != 17) {
                return;
            }
            double width = this.D - rect.width();
            Double.isNaN(width);
            this.O = (int) (width * 0.5d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ACTION action) {
        a();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.o * 2.0f;
            int i = (int) (((this.w % f) + f) % f);
            this.G = i;
            if (i > f / 2.0f) {
                this.G = (int) (f - i);
            } else {
                this.G = -i;
            }
        }
        this.f = this.e.scheduleWithFixedDelay(new e(this, this.G), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(float f) {
        a();
        this.f = this.e.scheduleWithFixedDelay(new com.bigkoo.pickerview.lib.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void a() {
        ScheduledFuture<?> scheduledFuture = this.f;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f.cancel(true);
        this.f = null;
    }

    private String a(Object obj) {
        String obj2 = obj.toString();
        try {
            return obj.getClass().getMethod("getPickerViewText", new Class[0]).invoke(obj, new Object[0]).toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return obj2;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return obj2;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return obj2;
        } catch (Exception e4) {
            e4.printStackTrace();
            return obj2;
        }
    }

    private void a(String str) {
        Rect rect = new Rect();
        this.h.getTextBounds(str, 0, str.length(), rect);
        int i = this.M;
        if (i == 3) {
            this.N = 0;
            return;
        }
        if (i == 5) {
            this.N = this.D - rect.width();
        } else {
            if (i != 17) {
                return;
            }
            double width = this.D - rect.width();
            Double.isNaN(width);
            this.N = (int) (width * 0.5d);
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
