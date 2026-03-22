package com.zte.iptvclient.android.common.customview.CustomTimePicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class TimePickerView extends View {

    /* renamed from: a, reason: collision with root package name */
    private String f4115a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4116b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4117c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f4118d;
    private int e;
    private Paint f;
    private Paint g;
    private float h;
    private float i;
    private float j;
    private float k;
    private int l;
    private int m;
    private float n;
    private float o;
    private boolean p;
    private boolean q;
    private c r;
    private Timer s;
    private b t;
    private int u;
    private Handler v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (Math.abs(TimePickerView.this.o) < 10.0f) {
                TimePickerView.this.o = 0.0f;
                if (TimePickerView.this.t != null) {
                    TimePickerView.this.t.cancel();
                    TimePickerView.this.t = null;
                    TimePickerView.this.f();
                }
            } else {
                TimePickerView.this.o -= (TimePickerView.this.o / Math.abs(TimePickerView.this.o)) * 10.0f;
            }
            TimePickerView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        Handler f4120a;

        /* synthetic */ b(Handler handler, a aVar) {
            this(handler);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Handler handler = this.f4120a;
            handler.sendMessage(handler.obtainMessage());
        }

        private b(Handler handler) {
            this.f4120a = handler;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4115a = "TimePickerView";
        this.f4117c = true;
        this.h = 60.0f;
        this.i = 30.0f;
        this.j = 255.0f;
        this.k = 120.0f;
        this.o = 0.0f;
        this.p = false;
        this.q = true;
        this.u = 0;
        this.v = new a();
        this.f4116b = context;
        c();
    }

    private void d() {
        if (this.f4117c) {
            String str = this.f4118d.get(0);
            this.f4118d.remove(0);
            this.f4118d.add(str);
        }
    }

    private void e() {
        if (this.f4117c) {
            String str = this.f4118d.get(r0.size() - 1);
            this.f4118d.remove(r1.size() - 1);
            this.f4118d.add(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        c cVar = this.r;
        if (cVar != null) {
            cVar.a(this.f4118d.get(this.e));
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return this.q && super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.p) {
            a(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.l = getMeasuredHeight();
        this.m = getMeasuredWidth();
        float f = this.l / 8.0f;
        this.h = f;
        this.i = f / 2.2f;
        this.p = true;
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(motionEvent);
        } else if (actionMasked == 1) {
            b();
        } else if (actionMasked == 2) {
            float y = this.o + (motionEvent.getY() - this.n);
            this.o = y;
            float f = this.i;
            if (y > (f * 2.8f) / 2.0f) {
                if (!this.f4117c && this.e == 0) {
                    this.n = motionEvent.getY();
                    invalidate();
                    return true;
                }
                if (!this.f4117c) {
                    this.e--;
                }
                e();
                this.o -= this.i * 2.8f;
            } else if (y < (f * (-2.8f)) / 2.0f) {
                if (this.e == this.f4118d.size() - 1) {
                    this.n = motionEvent.getY();
                    invalidate();
                    return true;
                }
                if (!this.f4117c) {
                    this.e++;
                }
                d();
                this.o += this.i * 2.8f;
            }
            this.n = motionEvent.getY();
            invalidate();
        }
        return true;
    }

    private void b() {
        if (Math.abs(this.o) < 1.0E-4d) {
            this.o = 0.0f;
            return;
        }
        b bVar = this.t;
        a aVar = null;
        if (bVar != null) {
            bVar.cancel();
            this.t = null;
        }
        b bVar2 = new b(this.v, aVar);
        this.t = bVar2;
        this.s.schedule(bVar2, 0L, 10L);
    }

    private void c() {
        this.s = new Timer();
        this.f4118d = new ArrayList();
        Paint paint = new Paint(1);
        this.f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f.setTextAlign(Paint.Align.CENTER);
        this.f.setColor(androidx.core.content.a.a(this.f4116b, R.color.white));
        Paint paint2 = new Paint(1);
        this.g = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.g.setTextAlign(Paint.Align.CENTER);
        this.g.setColor(androidx.core.content.a.a(this.f4116b, R.color.parental_control_point));
    }

    public void a(c cVar) {
        this.r = cVar;
    }

    public void a(List<String> list) {
        this.f4118d = list;
        this.e = list.size() / 6;
        invalidate();
    }

    public void a(int i) {
        this.e = i;
        if (this.f4117c) {
            int size = (this.f4118d.size() / 2) - this.e;
            int i2 = 0;
            if (size < 0) {
                while (i2 < (-size)) {
                    d();
                    this.e--;
                    i2++;
                }
            } else if (size > 0) {
                while (i2 < size) {
                    e();
                    this.e++;
                    i2++;
                }
            }
        }
        invalidate();
    }

    public void b(int i) {
        this.u = i;
    }

    public void a(String str) {
        for (int i = 0; i < this.f4118d.size(); i++) {
            if (TextUtils.equals(this.f4118d.get(i), str)) {
                a(i);
                LogEx.d(this.f4115a, "setSelected " + i);
                return;
            }
        }
    }

    public String a() {
        List<String> list = this.f4118d;
        return (list == null || this.e >= list.size()) ? "" : this.f4118d.get(this.e);
    }

    private void a(Canvas canvas) {
        float a2 = a(this.l / 6.0f, this.o);
        float f = this.h;
        float f2 = this.i;
        float f3 = ((f - f2) * a2) + f2;
        this.f.setTextSize(f3);
        Paint paint = this.f;
        float f4 = this.j;
        float f5 = this.k;
        paint.setAlpha((int) (((f4 - f5) * a2) + f5));
        int i = this.m;
        double d2 = i;
        Double.isNaN(d2);
        float f6 = (float) (d2 / 2.0d);
        if (this.u == 0) {
            double d3 = i;
            Double.isNaN(d3);
            f6 = (float) (d3 / 2.0d);
        }
        if (this.u == 1) {
            double d4 = this.m;
            Double.isNaN(d4);
            double d5 = f3;
            Double.isNaN(d5);
            f6 = (float) ((d4 / 2.0d) - (d5 / 2.0d));
        }
        if (this.u == 2) {
            double d6 = this.m;
            Double.isNaN(d6);
            double d7 = f3;
            Double.isNaN(d7);
            f6 = (float) ((d6 / 2.0d) + (d7 / 2.0d));
        }
        double d8 = this.l;
        Double.isNaN(d8);
        double d9 = this.o;
        Double.isNaN(d9);
        Paint.FontMetricsInt fontMetricsInt = this.f.getFontMetricsInt();
        double d10 = (float) ((d8 / 2.0d) + d9);
        double d11 = fontMetricsInt.bottom;
        Double.isNaN(d11);
        double d12 = fontMetricsInt.top;
        Double.isNaN(d12);
        Double.isNaN(d10);
        canvas.drawText(this.f4118d.get(this.e), f6, (float) (d10 - ((d11 / 2.0d) + (d12 / 2.0d))), this.f);
        for (int i2 = 1; this.e - i2 >= 0; i2++) {
            a(canvas, i2, -1);
        }
        for (int i3 = 1; this.e + i3 < this.f4118d.size(); i3++) {
            a(canvas, i3, 1);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        float f = i2;
        float f2 = (this.i * 2.8f * i) + (this.o * f);
        float a2 = a(this.l / 6.0f, f2);
        float f3 = this.h;
        float f4 = this.i;
        float f5 = ((f3 - f4) * a2) + f4;
        this.g.setTextSize(f5);
        Paint paint = this.g;
        float f6 = this.j;
        float f7 = this.k;
        paint.setAlpha((int) (((f6 - f7) * a2) + f7));
        double d2 = this.l;
        Double.isNaN(d2);
        double d3 = f * f2;
        Double.isNaN(d3);
        float f8 = (float) ((d2 / 2.0d) + d3);
        int i3 = this.m;
        double d4 = i3;
        Double.isNaN(d4);
        float f9 = (float) (d4 / 2.0d);
        if (this.u == 0) {
            double d5 = i3;
            Double.isNaN(d5);
            f9 = (float) (d5 / 2.0d);
        }
        if (this.u == 1) {
            double d6 = this.m;
            Double.isNaN(d6);
            double d7 = f5;
            Double.isNaN(d7);
            double d8 = d7 / 2.0d;
            double d9 = i;
            Double.isNaN(d9);
            f9 = (float) (((d6 / 2.0d) + (d9 * d8)) - d8);
        }
        if (this.u == 2) {
            double d10 = this.m;
            Double.isNaN(d10);
            double d11 = f5;
            Double.isNaN(d11);
            double d12 = d11 / 2.0d;
            double d13 = i;
            Double.isNaN(d13);
            f9 = (float) (((d10 / 2.0d) - (d13 * d12)) + d12);
        }
        Paint.FontMetricsInt fontMetricsInt = this.g.getFontMetricsInt();
        double d14 = f8;
        double d15 = fontMetricsInt.bottom;
        Double.isNaN(d15);
        double d16 = fontMetricsInt.top;
        Double.isNaN(d16);
        Double.isNaN(d14);
        canvas.drawText(this.f4118d.get(this.e + (i2 * i)), f9, (float) (d14 - ((d15 / 2.0d) + (d16 / 2.0d))), this.g);
    }

    private float a(float f, float f2) {
        float pow = (float) (1.0d - Math.pow(f2 / f, 2.0d));
        if (pow < 0.0f) {
            return 0.0f;
        }
        return pow;
    }

    private void a(MotionEvent motionEvent) {
        b bVar = this.t;
        if (bVar != null) {
            bVar.cancel();
            this.t = null;
        }
        this.n = motionEvent.getY();
    }

    public void a(boolean z) {
        this.f4117c = z;
    }
}
