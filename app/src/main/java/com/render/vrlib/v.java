package com.render.vrlib;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.render.vrlib.MDVRLibrary;
import java.util.LinkedList;
import java.util.List;

/* compiled from: MDTouchHelper.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private MDVRLibrary.c f2620a;

    /* renamed from: c, reason: collision with root package name */
    private GestureDetector f2622c;
    private boolean f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private ValueAnimator l;
    private boolean m;
    private com.render.vrlib.w.g n;
    private boolean o;
    private float p;

    /* renamed from: b, reason: collision with root package name */
    private List<MDVRLibrary.g> f2621b = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    private int f2623d = 0;
    private a e = new a(this, null);
    private float q = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MDTouchHelper.java */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private float f2624a;

        /* renamed from: b, reason: collision with root package name */
        private float f2625b;

        /* renamed from: c, reason: collision with root package name */
        private float f2626c;

        private a() {
        }

        public float b(float f) {
            this.f2625b = f;
            this.f2626c = f;
            return f;
        }

        /* synthetic */ a(v vVar, x xVar) {
            this();
        }

        public void a(float f, float f2, float f3, float f4) {
            this.f2624a = v.c(f, f2, f3, f4);
            this.f2625b = this.f2626c;
        }

        public float a(float f) {
            if (this.f2624a == 0.0f) {
                this.f2624a = f;
            }
            float f2 = this.f2624a;
            float f3 = this.f2625b + ((f < f2 ? (f / f2) - 1.0f : 1.0f - (f2 / f)) * v.this.i * 3.0f);
            this.f2626c = f3;
            float max = Math.max(f3, v.this.g);
            this.f2626c = max;
            float min = Math.min(max, v.this.h);
            this.f2626c = min;
            return min;
        }

        public float a() {
            float f = v.this.j;
            b(f);
            return f;
        }
    }

    public v(Context context) {
        this.f2622c = new GestureDetector(context, new x(this));
    }

    private void e() {
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float g(float f) {
        return (f / this.k) * this.p;
    }

    private void h(float f) {
        if (this.f) {
            i(this.e.a(f));
        }
    }

    private void i(float f) {
        MDVRLibrary.c cVar = this.f2620a;
        if (cVar != null) {
            cVar.a(f);
        }
        this.k = f;
    }

    public void c() {
        i(this.e.a());
    }

    public boolean d() {
        return this.f;
    }

    public void f(float f) {
        this.i = f;
    }

    private void b(float f, float f2) {
        MDVRLibrary.c cVar = this.f2620a;
        if (cVar != null) {
            cVar.a(f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float c(float f, float f2, float f3, float f4) {
        return (float) Math.sqrt(Math.pow(f - f3, 2.0d) + Math.pow(f2 - f4, 2.0d));
    }

    public void d(float f) {
        this.p = f;
    }

    public void c(float f) {
        this.h = f;
    }

    public void e(float f) {
        this.n.a(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, float f2) {
        e();
        ValueAnimator duration = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("vx", f, 0.0f), PropertyValuesHolder.ofFloat("vy", f2, 0.0f)).setDuration(this.n.b());
        this.l = duration;
        duration.setInterpolator(this.n.a());
        this.l.addUpdateListener(new y(this));
        this.l.start();
    }

    public float b() {
        return this.e.f2626c;
    }

    public void c(boolean z) {
        this.m = z;
    }

    private void b(float f, float f2, float f3, float f4) {
        this.e.a(f, f2, f3, f4);
    }

    public void b(boolean z) {
        this.f = z;
    }

    public void b(float f) {
        this.g = f;
    }

    public boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            this.f2623d = 0;
        } else if (action == 6) {
            if (this.f2623d == 1 && motionEvent.getPointerCount() > 2) {
                if ((motionEvent.getAction() >> 8) == 0) {
                    b(motionEvent.getX(1), motionEvent.getY(1), motionEvent.getX(2), motionEvent.getY(2));
                } else if ((motionEvent.getAction() >> 8) == 1) {
                    b(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(2), motionEvent.getY(2));
                }
            }
        } else if (action == 5) {
            this.f2623d = 1;
            b(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
            float x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            float y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
            if (this.f) {
                b(x, y);
            }
        } else if (action == 2) {
            if (this.f2623d == 1 && motionEvent.getPointerCount() > 1) {
                h(c(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1)));
            }
        } else if (action == 0) {
            e();
            this.q = 0.0f;
            a();
        }
        this.f2622c.onTouchEvent(motionEvent);
        return true;
    }

    public void a() {
        MDVRLibrary.c cVar = this.f2620a;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void a(float f) {
        this.e.b(f);
        i(f);
    }

    public void a(MDVRLibrary.g gVar) {
        if (gVar != null) {
            this.f2621b.add(gVar);
        }
    }

    public void a(MDVRLibrary.c cVar) {
        this.f2620a = cVar;
    }

    public void a(boolean z) {
        this.o = z;
    }

    public void a(com.render.vrlib.w.b bVar) {
        this.g = bVar.c();
        this.h = bVar.b();
        this.i = bVar.d();
        float a2 = bVar.a();
        this.j = a2;
        float max = Math.max(this.g, a2);
        this.j = max;
        float min = Math.min(this.h, max);
        this.j = min;
        i(min);
    }

    public void a(com.render.vrlib.w.g gVar) {
        this.n = gVar;
    }
}
