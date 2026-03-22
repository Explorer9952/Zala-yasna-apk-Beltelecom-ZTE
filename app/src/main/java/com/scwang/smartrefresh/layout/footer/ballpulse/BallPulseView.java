package com.scwang.smartrefresh.layout.footer.ballpulse;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class BallPulseView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f2765a;

    /* renamed from: b, reason: collision with root package name */
    private int f2766b;

    /* renamed from: c, reason: collision with root package name */
    private int f2767c;

    /* renamed from: d, reason: collision with root package name */
    private float f2768d;
    private float[] e;
    private boolean f;
    private ArrayList<ValueAnimator> g;
    private Map<ValueAnimator, ValueAnimator.AnimatorUpdateListener> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f2769a;

        a(int i) {
            this.f2769a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BallPulseView.this.e[this.f2769a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BallPulseView.this.postInvalidate();
        }
    }

    public BallPulseView(Context context) {
        this(context, null);
    }

    private void c() {
        this.g = new ArrayList<>();
        int[] iArr = {120, PsExtractor.VIDEO_STREAM_MASK, 360};
        for (int i = 0; i < 3; i++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(750L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(iArr[i]);
            this.h.put(ofFloat, new a(i));
            this.g.add(ofFloat);
        }
    }

    private boolean d() {
        return this.f;
    }

    public void b(int i) {
        this.f2765a.setColor(i);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                this.g.get(i).cancel();
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float min = (Math.min(getWidth(), getHeight()) - (this.f2768d * 2.0f)) / 6.0f;
        float f = 2.0f * min;
        float width = (getWidth() / 2) - (this.f2768d + f);
        float height = getHeight() / 2;
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float f2 = i;
            canvas.translate((f * f2) + width + (this.f2768d * f2), height);
            float[] fArr = this.e;
            canvas.scale(fArr[i], fArr[i]);
            canvas.drawCircle(0.0f, 0.0f, min, this.f2765a);
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int b2 = com.scwang.smartrefresh.layout.e.a.b(50.0f);
        setMeasuredDimension(View.resolveSize(b2, i), View.resolveSize(b2, i2));
    }

    public BallPulseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(int i) {
        this.f2767c = i;
    }

    public void b() {
        ArrayList<ValueAnimator> arrayList = this.g;
        if (arrayList != null && this.f) {
            this.f = false;
            Iterator<ValueAnimator> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ValueAnimator next = it2.next();
                if (next != null) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
            this.e = new float[]{1.0f, 1.0f, 1.0f};
        }
        b(this.f2766b);
    }

    public BallPulseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2766b = -1118482;
        this.f2767c = -1615546;
        this.e = new float[]{1.0f, 1.0f, 1.0f};
        this.f = false;
        this.h = new HashMap();
        this.f2768d = com.scwang.smartrefresh.layout.e.a.b(4.0f);
        Paint paint = new Paint();
        this.f2765a = paint;
        paint.setColor(-1);
        this.f2765a.setStyle(Paint.Style.FILL);
        this.f2765a.setAntiAlias(true);
    }

    public void a() {
        if (this.g == null) {
            c();
        }
        if (this.g == null || d()) {
            return;
        }
        for (int i = 0; i < this.g.size(); i++) {
            ValueAnimator valueAnimator = this.g.get(i);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.h.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
        }
        this.f = true;
        b(this.f2767c);
    }

    public void c(int i) {
        this.f2766b = i;
    }
}
