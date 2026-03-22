package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.a.e;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.h;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.bezierradar.WaveView;

/* loaded from: classes.dex */
public class BezierRadarHeader extends FrameLayout implements e {

    /* renamed from: a, reason: collision with root package name */
    private WaveView f2771a;

    /* renamed from: b, reason: collision with root package name */
    private com.scwang.smartrefresh.layout.header.bezierradar.a f2772b;

    /* renamed from: c, reason: collision with root package name */
    private com.scwang.smartrefresh.layout.header.bezierradar.b f2773c;

    /* renamed from: d, reason: collision with root package name */
    private com.scwang.smartrefresh.layout.header.bezierradar.c f2774d;

    /* loaded from: classes.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierRadarHeader.this.f2771a.c(((Integer) valueAnimator.getAnimatedValue()).intValue() / 2);
            BezierRadarHeader.this.f2771a.invalidate();
        }
    }

    /* loaded from: classes.dex */
    class b extends AnimatorListenerAdapter {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BezierRadarHeader.this.f2774d.a();
            }
        }

        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            BezierRadarHeader.this.f2773c.setVisibility(4);
            BezierRadarHeader.this.f2774d.animate().scaleX(1.0f);
            BezierRadarHeader.this.f2774d.animate().scaleY(1.0f);
            BezierRadarHeader.this.f2774d.postDelayed(new a(), 200L);
        }
    }

    /* loaded from: classes.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierRadarHeader.this.f2773c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2779a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f2779a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2779a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2779a[RefreshState.PullToUpLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2779a[RefreshState.Refreshing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2779a[RefreshState.Loading.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public BezierRadarHeader(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public View a() {
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(g gVar, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void d(float f, int i, int i2, int i3) {
        c(f, i, i2, i3);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        setMinimumHeight(com.scwang.smartrefresh.layout.e.a.b(100.0f));
        this.f2771a = new WaveView(getContext());
        this.f2772b = new com.scwang.smartrefresh.layout.header.bezierradar.a(getContext());
        this.f2773c = new com.scwang.smartrefresh.layout.header.bezierradar.b(getContext());
        this.f2774d = new com.scwang.smartrefresh.layout.header.bezierradar.c(getContext());
        if (isInEditMode()) {
            addView(this.f2771a, -1, -1);
            addView(this.f2774d, -1, -1);
            this.f2771a.a(1000);
        } else {
            addView(this.f2771a, -1, -1);
            addView(this.f2773c, -1, -1);
            addView(this.f2774d, -1, -1);
            addView(this.f2772b, -1, -1);
            this.f2774d.setScaleX(0.0f);
            this.f2774d.setScaleY(0.0f);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BezierRadarHeader);
        int color = obtainStyledAttributes.getColor(R$styleable.BezierRadarHeader_srlPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(R$styleable.BezierRadarHeader_srlAccentColor, 0);
        if (color != 0) {
            b(color);
        }
        if (color2 != 0) {
            a(color);
        }
        obtainStyledAttributes.recycle();
    }

    public BezierRadarHeader b(int i) {
        this.f2771a.b(i);
        this.f2774d.a(i);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void c(float f, int i, int i2, int i3) {
        this.f2771a.a(Math.min(i2, i));
        this.f2771a.c((int) (Math.max(0, i - i2) * 1.9f));
        this.f2773c.a(f);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public SpinnerStyle b() {
        return SpinnerStyle.Scale;
    }

    public BezierRadarHeader a(int i) {
        this.f2773c.a(i);
        this.f2772b.a(i);
        this.f2774d.b(i);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(int... iArr) {
        if (iArr.length > 0) {
            b(iArr[0]);
        }
        if (iArr.length > 1) {
            a(iArr[1]);
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(h hVar, int i, int i2) {
        this.f2771a.a(i);
        double a2 = this.f2771a.a();
        Double.isNaN(a2);
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f2771a.a(), 0, -((int) (a2 * 0.8d)), 0, -((int) (this.f2771a.a() * 0.4f)), 0);
        ofInt.addUpdateListener(new a());
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(800L);
        ofInt.start();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addListener(new b());
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new c());
        ofFloat.start();
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public int a(h hVar, boolean z) {
        this.f2774d.b();
        this.f2774d.animate().scaleX(0.0f);
        this.f2774d.animate().scaleY(0.0f);
        this.f2772b.setVisibility(0);
        this.f2772b.a();
        return DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
    }

    @Override // com.scwang.smartrefresh.layout.d.e
    public void a(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        int i = d.f2779a[refreshState2.ordinal()];
        if (i == 1) {
            this.f2772b.setVisibility(8);
            this.f2773c.setAlpha(1.0f);
            this.f2773c.setVisibility(0);
        } else {
            if (i != 2) {
                return;
            }
            this.f2774d.setScaleX(0.0f);
            this.f2774d.setScaleY(0.0f);
        }
    }
}
