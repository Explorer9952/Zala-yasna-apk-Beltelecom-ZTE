package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.e.m;
import androidx.core.e.n;
import androidx.core.e.q;
import androidx.core.e.r;
import androidx.core.e.w;
import androidx.core.e.z;
import androidx.viewpager.widget.ViewPager;
import com.google.common.logging.nano.Vr;
import com.scwang.smartrefresh.layout.constant.DimensionStatus;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;

/* loaded from: classes.dex */
public class SmartRefreshLayout extends ViewGroup implements com.scwang.smartrefresh.layout.a.h {
    protected static com.scwang.smartrefresh.layout.a.a k0 = new b();
    protected static com.scwang.smartrefresh.layout.a.b l0 = new c();
    protected boolean A;
    protected com.scwang.smartrefresh.layout.d.c B;
    protected com.scwang.smartrefresh.layout.d.a C;
    protected com.scwang.smartrefresh.layout.d.b D;
    protected int[] E;
    protected int[] F;
    protected int G;
    protected boolean J;
    protected n K;
    protected r L;
    protected com.scwang.smartrefresh.layout.a.g M;
    protected int N;
    protected DimensionStatus O;
    protected int P;
    protected DimensionStatus Q;
    protected int R;
    protected int S;
    protected float T;
    protected float U;
    protected com.scwang.smartrefresh.layout.a.e V;
    protected com.scwang.smartrefresh.layout.a.c W;

    /* renamed from: a, reason: collision with root package name */
    protected RefreshState f2693a;
    protected com.scwang.smartrefresh.layout.a.d a0;

    /* renamed from: b, reason: collision with root package name */
    protected int f2694b;
    protected long b0;

    /* renamed from: c, reason: collision with root package name */
    protected int f2695c;
    protected long c0;

    /* renamed from: d, reason: collision with root package name */
    protected int f2696d;
    protected Paint d0;
    protected int e;
    protected int e0;
    protected float f;
    protected int f0;
    protected float g;
    MotionEvent g0;
    protected float h;
    protected ValueAnimator h0;
    protected float i;
    protected Animator.AnimatorListener i0;
    protected Interpolator j;
    protected ValueAnimator.AnimatorUpdateListener j0;
    protected View k;
    protected View l;
    protected int m;
    protected int n;
    protected int[] o;
    protected boolean p;
    protected boolean q;
    protected boolean r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    protected boolean v;
    protected boolean w;
    protected boolean x;
    protected boolean y;
    protected boolean z;

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f2697a;

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0082a implements ValueAnimator.AnimatorUpdateListener {
            C0082a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.c(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        }

        /* loaded from: classes.dex */
        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.h0 = null;
                if (smartRefreshLayout.f2693a != RefreshState.ReleaseToLoad) {
                    smartRefreshLayout.s();
                }
                SmartRefreshLayout.this.b();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SmartRefreshLayout.this.q();
            }
        }

        a(float f) {
            this.f2697a = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.h0 = ValueAnimator.ofInt(smartRefreshLayout.f2695c, -((int) (smartRefreshLayout.P * this.f2697a)));
            SmartRefreshLayout.this.h0.setDuration(r0.f2696d);
            SmartRefreshLayout.this.h0.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout.this.h0.addUpdateListener(new C0082a());
            SmartRefreshLayout.this.h0.addListener(new b());
            SmartRefreshLayout.this.h0.start();
        }
    }

    /* loaded from: classes.dex */
    static class b implements com.scwang.smartrefresh.layout.a.a {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.a.a
        public com.scwang.smartrefresh.layout.a.d a(Context context, com.scwang.smartrefresh.layout.a.h hVar) {
            return new BallPulseFooter(context);
        }
    }

    /* loaded from: classes.dex */
    static class c implements com.scwang.smartrefresh.layout.a.b {
        c() {
        }

        @Override // com.scwang.smartrefresh.layout.a.b
        public com.scwang.smartrefresh.layout.a.e a(Context context, com.scwang.smartrefresh.layout.a.h hVar) {
            return new BezierRadarHeader(context);
        }
    }

    /* loaded from: classes.dex */
    class d implements com.scwang.smartrefresh.layout.d.c {
        d() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            hVar.c(Vr.VREvent.EventType.START_VR_LAUNCHER_COLD);
        }
    }

    /* loaded from: classes.dex */
    class e implements com.scwang.smartrefresh.layout.d.a {
        e() {
        }

        @Override // com.scwang.smartrefresh.layout.d.a
        public void b(com.scwang.smartrefresh.layout.a.h hVar) {
            hVar.b(2000);
        }
    }

    /* loaded from: classes.dex */
    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout smartRefreshLayout;
            RefreshState refreshState;
            SmartRefreshLayout.this.h0 = null;
            if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() != 0 || (refreshState = (smartRefreshLayout = SmartRefreshLayout.this).f2693a) == RefreshState.None || refreshState == RefreshState.Refreshing || refreshState == RefreshState.Loading) {
                return;
            }
            smartRefreshLayout.a(RefreshState.None);
        }
    }

    /* loaded from: classes.dex */
    class g implements ValueAnimator.AnimatorUpdateListener {
        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.c(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f2705a;

        h(boolean z) {
            this.f2705a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.scwang.smartrefresh.layout.a.e eVar;
            int a2;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f2693a != RefreshState.Refreshing || (eVar = smartRefreshLayout.V) == null || (a2 = eVar.a(smartRefreshLayout, this.f2705a)) == Integer.MAX_VALUE) {
                return;
            }
            SmartRefreshLayout.this.a(RefreshState.RefreshFinish);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            com.scwang.smartrefresh.layout.d.b bVar = smartRefreshLayout2.D;
            if (bVar != null) {
                bVar.a(smartRefreshLayout2.V, this.f2705a);
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (smartRefreshLayout3.f2695c == 0) {
                smartRefreshLayout3.e();
            } else {
                smartRefreshLayout3.a(0, a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f2707a;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SmartRefreshLayout.this.e();
            }
        }

        i(boolean z) {
            this.f2707a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.scwang.smartrefresh.layout.a.d dVar;
            int a2;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f2693a != RefreshState.Loading || (dVar = smartRefreshLayout.a0) == null || (a2 = dVar.a(smartRefreshLayout, this.f2707a)) == Integer.MAX_VALUE) {
                return;
            }
            SmartRefreshLayout.this.a(RefreshState.LoadingFinish);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            ValueAnimator.AnimatorUpdateListener a3 = smartRefreshLayout2.W.a(smartRefreshLayout2.M, smartRefreshLayout2.P, a2, smartRefreshLayout2.j, smartRefreshLayout2.f2696d);
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            com.scwang.smartrefresh.layout.d.b bVar = smartRefreshLayout3.D;
            if (bVar != null) {
                bVar.a(smartRefreshLayout3.a0, this.f2707a);
            }
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            if (smartRefreshLayout4.f2695c == 0) {
                smartRefreshLayout4.postDelayed(new a(), 500L);
                return;
            }
            ValueAnimator a4 = smartRefreshLayout4.a(0, a2);
            if (a3 == null || a4 == null) {
                return;
            }
            a4.addUpdateListener(a3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class j implements com.scwang.smartrefresh.layout.a.g {
        protected j() {
        }

        @Override // com.scwang.smartrefresh.layout.a.g
        public com.scwang.smartrefresh.layout.a.h a() {
            return SmartRefreshLayout.this;
        }

        @Override // com.scwang.smartrefresh.layout.a.g
        public int b() {
            return SmartRefreshLayout.this.f2695c;
        }

        @Override // com.scwang.smartrefresh.layout.a.g
        public com.scwang.smartrefresh.layout.a.g a(int i) {
            SmartRefreshLayout.this.d(i);
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        super(context);
        this.f2693a = RefreshState.None;
        this.f2696d = 250;
        this.h = 0.5f;
        this.p = true;
        this.q = true;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = false;
        this.z = true;
        this.A = false;
        this.E = new int[2];
        this.F = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.O = dimensionStatus;
        this.Q = dimensionStatus;
        this.T = 2.0f;
        this.U = 3.0f;
        this.b0 = 0L;
        this.c0 = 0L;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = null;
        this.i0 = new f();
        this.j0 = new g();
        a(context, (AttributeSet) null);
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public /* bridge */ /* synthetic */ com.scwang.smartrefresh.layout.a.h a(boolean z) {
        a(z);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public /* bridge */ /* synthetic */ com.scwang.smartrefresh.layout.a.h b(int i2) {
        b(i2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public /* bridge */ /* synthetic */ com.scwang.smartrefresh.layout.a.h c(int i2) {
        c(i2);
        return this;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected ValueAnimator d(int i2) {
        if (this.h0 == null) {
            if (this.f2693a == RefreshState.Refreshing && i2 > 0) {
                ValueAnimator ofInt = ValueAnimator.ofInt(this.f2695c, Math.min(i2 * 2, this.N));
                this.h0 = ofInt;
                ofInt.setDuration(250L);
            } else if (this.f2693a == RefreshState.Loading && i2 < 0) {
                ValueAnimator ofInt2 = ValueAnimator.ofInt(this.f2695c, Math.max(i2 * 2, -this.P));
                this.h0 = ofInt2;
                ofInt2.setDuration(250L);
            } else if (this.f2695c == 0 && this.w) {
                ValueAnimator ofInt3 = ValueAnimator.ofInt(0, i2, 0);
                this.h0 = ofInt3;
                ofInt3.setDuration(500L);
            }
            ValueAnimator valueAnimator = this.h0;
            if (valueAnimator != null) {
                valueAnimator.setInterpolator(new DecelerateInterpolator());
                this.h0.addUpdateListener(this.j0);
                this.h0.addListener(this.i0);
                this.h0.start();
            }
        }
        return this.h0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        boolean z = this.v && isInEditMode();
        if (this.e0 != 0 && (this.f2695c > 0 || z)) {
            this.d0.setColor(this.e0);
            canvas.drawRect(0.0f, 0.0f, getWidth(), z ? this.N : this.f2695c, this.d0);
        } else if (this.f0 != 0 && (this.f2695c < 0 || z)) {
            this.d0.setColor(this.f0);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight() + (z ? -this.P : this.f2695c), this.d0);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.K.a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.K.a(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.K.a(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.K.a(i2, i3, i4, i5, iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        if (r2 != 3) goto L100;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void e() {
        RefreshState refreshState = this.f2693a;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2 && this.f2695c == 0) {
            a(refreshState2);
        }
        if (this.f2695c != 0) {
            a(0);
        }
    }

    protected void f() {
        this.b0 = System.currentTimeMillis();
        a(RefreshState.Loading);
        a(-this.P);
        com.scwang.smartrefresh.layout.d.a aVar = this.C;
        if (aVar != null) {
            aVar.b(this);
        }
        com.scwang.smartrefresh.layout.a.d dVar = this.a0;
        if (dVar != null) {
            dVar.a(this, this.P, this.S);
        }
        com.scwang.smartrefresh.layout.d.b bVar = this.D;
        if (bVar != null) {
            bVar.b(this);
            this.D.a(this.a0, this.P, this.S);
        }
    }

    protected void g() {
        a(RefreshState.PullDownCanceled);
        e();
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.L.a();
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public RefreshState getState() {
        return this.f2693a;
    }

    protected void h() {
        a(RefreshState.PullDownToRefresh);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.K.a();
    }

    protected void i() {
        a(RefreshState.PullUpCanceled);
        e();
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public boolean isLoading() {
        return this.f2693a == RefreshState.Loading;
    }

    @Override // android.view.View, androidx.core.e.m
    public boolean isNestedScrollingEnabled() {
        return this.K.b();
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public /* bridge */ /* synthetic */ com.scwang.smartrefresh.layout.a.h j() {
        j();
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public boolean k() {
        return this.w;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public boolean l() {
        return this.f2693a == RefreshState.Refreshing;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public boolean m() {
        return this.x;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public /* bridge */ /* synthetic */ ViewGroup n() {
        n();
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public SmartRefreshLayout n() {
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public boolean o() {
        return this.z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        com.scwang.smartrefresh.layout.a.d dVar;
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        if (this.W == null && this.V == null && this.a0 == null) {
            onFinishInflate();
        }
        if (this.M == null) {
            this.M = new j();
        }
        if (this.W == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                com.scwang.smartrefresh.layout.a.e eVar = this.V;
                if ((eVar == null || childAt != eVar.a()) && ((dVar = this.a0) == null || childAt != dVar.a())) {
                    this.W = new com.scwang.smartrefresh.layout.b.a(childAt);
                }
            }
            if (this.W == null) {
                com.scwang.smartrefresh.layout.b.a aVar = new com.scwang.smartrefresh.layout.b.a(getContext());
                this.W = aVar;
                aVar.a().setLayoutParams(new LayoutParams(-1, -1));
            }
        }
        int i3 = this.m;
        if (i3 > 0 && this.k == null) {
            this.k = findViewById(i3);
        }
        int i4 = this.n;
        if (i4 > 0 && this.l == null) {
            this.l = findViewById(i4);
        }
        this.W.a(this.M, this.k, this.l);
        if (this.V == null) {
            if (this.y) {
                this.V = new FalsifyHeader(getContext());
            } else {
                this.V = l0.a(getContext(), this);
            }
            if (!(this.V.a().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                if (this.V.b() == SpinnerStyle.Scale) {
                    addView(this.V.a(), -1, -1);
                } else {
                    addView(this.V.a(), -1, -2);
                }
            }
        }
        if (this.a0 == null) {
            if (this.y) {
                this.a0 = new com.scwang.smartrefresh.layout.b.b(new FalsifyHeader(getContext()));
            } else {
                this.a0 = k0.a(getContext(), this);
            }
            if (!(this.a0.a().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                if (this.a0.b() == SpinnerStyle.Scale) {
                    addView(this.a0.a(), -1, -1);
                } else {
                    addView(this.a0.a(), -1, -2);
                }
            }
        }
        bringChildToFront(this.W.a());
        if (this.V.b() != SpinnerStyle.FixedBehind) {
            bringChildToFront(this.V.a());
        }
        if (this.a0.b() != SpinnerStyle.FixedBehind) {
            bringChildToFront(this.a0.a());
        }
        if (this.B == null) {
            this.B = new d();
        }
        if (this.C == null) {
            this.C = new e();
        }
        int[] iArr = this.o;
        if (iArr != null) {
            this.V.a(iArr);
            this.a0.a(this.o);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.M = null;
        this.V = null;
        this.a0 = null;
        this.W = null;
        this.k = null;
        this.l = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount <= 3) {
            if (this.y && childCount > 1) {
                throw new RuntimeException("PureScrollMode模式只支持一个子View，Most only support one sub view in PureScrollMode");
            }
            boolean[] zArr = new boolean[childCount];
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if ((childAt instanceof com.scwang.smartrefresh.layout.a.e) && this.V == null) {
                    this.V = (com.scwang.smartrefresh.layout.a.e) childAt;
                } else if ((childAt instanceof com.scwang.smartrefresh.layout.a.d) && this.a0 == null) {
                    this.a0 = (com.scwang.smartrefresh.layout.a.d) childAt;
                } else if (this.W == null && ((childAt instanceof AbsListView) || (childAt instanceof WebView) || (childAt instanceof ScrollView) || (childAt instanceof w) || (childAt instanceof m) || (childAt instanceof q) || (childAt instanceof ViewPager))) {
                    this.W = new com.scwang.smartrefresh.layout.b.a(childAt);
                } else if (com.scwang.smartrefresh.layout.b.c.a(childAt) && this.V == null) {
                    this.V = new com.scwang.smartrefresh.layout.b.c(childAt);
                } else if (com.scwang.smartrefresh.layout.b.b.a(childAt) && this.a0 == null) {
                    this.a0 = new com.scwang.smartrefresh.layout.b.b(childAt);
                } else if (com.scwang.smartrefresh.layout.b.a.a(childAt) && this.W == null) {
                    this.W = new com.scwang.smartrefresh.layout.b.a(childAt);
                } else {
                    zArr[i2] = true;
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                if (zArr[i3]) {
                    View childAt2 = getChildAt(i3);
                    if (childCount == 1 && this.W == null) {
                        this.W = new com.scwang.smartrefresh.layout.b.a(childAt2);
                    } else if (i3 == 0 && this.V == null) {
                        this.V = new com.scwang.smartrefresh.layout.b.c(childAt2);
                    } else if (childCount == 2 && this.W == null) {
                        this.W = new com.scwang.smartrefresh.layout.b.a(childAt2);
                    } else if (i3 == 2 && this.a0 == null) {
                        this.a0 = new com.scwang.smartrefresh.layout.b.b(childAt2);
                    } else if (this.W == null) {
                        this.W = new com.scwang.smartrefresh.layout.b.a(childAt2);
                    }
                }
            }
            if (isInEditMode()) {
                int[] iArr = this.o;
                if (iArr != null) {
                    com.scwang.smartrefresh.layout.a.e eVar = this.V;
                    if (eVar != null) {
                        eVar.a(iArr);
                    }
                    com.scwang.smartrefresh.layout.a.d dVar = this.a0;
                    if (dVar != null) {
                        dVar.a(this.o);
                    }
                }
                bringChildToFront(this.W.a());
                com.scwang.smartrefresh.layout.a.e eVar2 = this.V;
                if (eVar2 != null && eVar2.b() != SpinnerStyle.FixedBehind) {
                    bringChildToFront(this.V.a());
                }
                com.scwang.smartrefresh.layout.a.d dVar2 = this.a0;
                if (dVar2 != null && dVar2.b() != SpinnerStyle.FixedBehind) {
                    bringChildToFront(this.a0.a());
                }
                if (this.M == null) {
                    this.M = new j();
                    return;
                }
                return;
            }
            return;
        }
        throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002a, code lost:
    
        if (r0 != 3) goto L49;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.scwang.smartrefresh.layout.constant.RefreshState r0 = r6.f2693a
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
            if (r0 == r1) goto La
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
            if (r0 != r1) goto La4
        La:
            int r0 = androidx.core.e.j.b(r7)
            boolean r1 = r6.isNestedScrollingEnabled()
            r2 = 0
            if (r1 == 0) goto L20
            com.scwang.smartrefresh.layout.a.c r1 = r6.W
            if (r1 == 0) goto L20
            boolean r1 = r1.b(r7)
            if (r1 == 0) goto L20
            return r2
        L20:
            if (r0 == 0) goto L96
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L91
            r3 = 2
            if (r0 == r3) goto L2e
            r1 = 3
            if (r0 == r1) goto L91
            goto La4
        L2e:
            float r0 = r7.getY()
            float r3 = r6.g
            float r0 = r0 - r3
            float r3 = r7.getX()
            float r4 = r6.f
            float r3 = r3 - r4
            float r4 = java.lang.Math.abs(r0)
            int r5 = r6.f2694b
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto La4
            float r3 = java.lang.Math.abs(r3)
            float r4 = java.lang.Math.abs(r0)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto La4
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 >= 0) goto L65
            int r3 = r6.f2695c
            if (r3 > 0) goto L77
            com.scwang.smartrefresh.layout.a.c r3 = r6.W
            if (r3 == 0) goto L65
            boolean r3 = r3.i()
            if (r3 == 0) goto L77
        L65:
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 <= 0) goto La4
            int r3 = r6.f2695c
            if (r3 < 0) goto L77
            com.scwang.smartrefresh.layout.a.c r3 = r6.W
            if (r3 == 0) goto La4
            boolean r3 = r3.h()
            if (r3 != 0) goto La4
        L77:
            float r7 = r6.g
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L7f
            r2 = -1
            goto L80
        L7f:
            r2 = 1
        L80:
            int r3 = r6.f2694b
            int r2 = r2 * r3
            float r2 = (float) r2
            float r0 = r0 + r2
            float r7 = r7 + r0
            r6.g = r7
            int r7 = r6.f2695c
            float r7 = (float) r7
            r6.i = r7
            r6.G = r1
            return r1
        L91:
            r6.f = r2
            r6.g = r2
            goto La4
        L96:
            float r0 = r7.getX()
            r6.f = r0
            float r0 = r7.getY()
            r6.g = r0
            r6.G = r2
        La4:
            boolean r7 = super.onInterceptTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int max;
        com.scwang.smartrefresh.layout.a.e eVar;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        boolean z2 = isInEditMode() && this.v;
        com.scwang.smartrefresh.layout.a.c cVar = this.W;
        if (cVar != null) {
            LayoutParams layoutParams = (LayoutParams) cVar.e();
            int i7 = paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            int i8 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int j2 = this.W.j() + i7;
            int f2 = this.W.f() + i8;
            if (z2 && (eVar = this.V) != null && (this.t || eVar.b() == SpinnerStyle.FixedBehind)) {
                int i9 = this.N;
                i8 += i9;
                f2 += i9;
            }
            this.W.a(i7, i8, j2, f2);
        }
        com.scwang.smartrefresh.layout.a.e eVar2 = this.V;
        if (eVar2 != null) {
            View a2 = eVar2.a();
            LayoutParams layoutParams2 = (LayoutParams) a2.getLayoutParams();
            int i10 = ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
            int i11 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
            int measuredWidth = a2.getMeasuredWidth() + i10;
            int measuredHeight = a2.getMeasuredHeight() + i11;
            if (!z2) {
                if (this.V.b() == SpinnerStyle.Translate) {
                    i11 = (i11 - this.N) + Math.max(0, this.f2695c);
                    max = a2.getMeasuredHeight();
                } else if (this.V.b() == SpinnerStyle.Scale) {
                    max = Math.max(Math.max(0, this.f2695c) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 0);
                }
                measuredHeight = i11 + max;
            }
            a2.layout(i10, i11, measuredWidth, measuredHeight);
        }
        com.scwang.smartrefresh.layout.a.d dVar = this.a0;
        if (dVar != null) {
            View a3 = dVar.a();
            LayoutParams layoutParams3 = (LayoutParams) a3.getLayoutParams();
            SpinnerStyle b2 = this.a0.b();
            int i12 = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin;
            int measuredHeight2 = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + getMeasuredHeight();
            if (!z2 && b2 != SpinnerStyle.FixedFront && b2 != SpinnerStyle.FixedBehind) {
                if (b2 == SpinnerStyle.Scale || b2 == SpinnerStyle.Translate) {
                    i6 = Math.max(Math.max(-this.f2695c, 0) - ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin, 0);
                }
                a3.layout(i12, measuredHeight2, a3.getMeasuredWidth() + i12, a3.getMeasuredHeight() + measuredHeight2);
            }
            i6 = this.P;
            measuredHeight2 -= i6;
            a3.layout(i12, measuredHeight2, a3.getMeasuredWidth() + i12, a3.getMeasuredHeight() + measuredHeight2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0267  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.e.q
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.e.q
    public boolean onNestedPreFling(View view, float f2, float f3) {
        RefreshState refreshState;
        return this.h0 != null || (refreshState = this.f2693a) == RefreshState.PullDownToRefresh || refreshState == RefreshState.PullToUpLoad || refreshState == RefreshState.ReleaseToRefresh || refreshState == RefreshState.ReleaseToLoad || (refreshState == RefreshState.Refreshing && this.f2695c != 0) || ((this.f2693a == RefreshState.Loading && this.f2695c != 0) || dispatchNestedPreFling(f2, f3));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.e.q
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        int i4;
        int i5;
        RefreshState refreshState = this.f2693a;
        int i6 = 0;
        if (refreshState != RefreshState.Refreshing && refreshState != RefreshState.Loading) {
            if (d() && i3 > 0 && (i5 = this.G) > 0) {
                if (i3 > i5) {
                    iArr[1] = i3 - i5;
                    this.G = 0;
                } else {
                    this.G = i5 - i3;
                    iArr[1] = i3;
                }
                a(this.G);
            } else if (this.q && i3 < 0 && (i4 = this.G) < 0) {
                if (i3 < i4) {
                    iArr[1] = i3 - i4;
                    this.G = 0;
                } else {
                    this.G = i4 - i3;
                    iArr[1] = i3;
                }
                a(this.G);
            }
            int[] iArr2 = this.E;
            if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
                iArr[0] = iArr[0] + iArr2[0];
                iArr[1] = iArr[1] + iArr2[1];
                return;
            }
            return;
        }
        int[] iArr3 = this.E;
        if (dispatchNestedPreScroll(i2, i3, iArr3, null)) {
            i3 -= iArr3[1];
        }
        if (this.f2693a == RefreshState.Refreshing && i3 > 0) {
            iArr[1] = 0;
            int i7 = this.G;
            if (i7 <= 0) {
                i6 = i3;
            } else if (i3 > i7) {
                iArr[1] = iArr[1] + i7;
                this.G = 0;
                i6 = i3 + 0;
                if (this.i <= 0.0f) {
                    a(0.0f);
                }
            } else {
                int i8 = i7 - i3;
                this.G = i8;
                iArr[1] = iArr[1] + i3;
                a(i8 + this.i);
            }
            if (i6 > 0) {
                float f2 = this.i;
                if (f2 > 0.0f) {
                    float f3 = i6;
                    if (f3 > f2) {
                        iArr[1] = (int) (iArr[1] + f2);
                        this.i = 0.0f;
                    } else {
                        this.i = f2 - f3;
                        iArr[1] = iArr[1] + i6;
                    }
                    a(this.i);
                    return;
                }
                return;
            }
            return;
        }
        if (this.f2693a != RefreshState.Loading || i3 >= 0) {
            return;
        }
        iArr[1] = 0;
        int i9 = this.G;
        if (i9 >= 0) {
            i6 = i3;
        } else if (i3 < i9) {
            iArr[1] = iArr[1] + i9;
            this.G = 0;
            i6 = i3 + 0;
            if (this.i >= 0.0f) {
                a(0.0f);
            }
        } else {
            int i10 = i9 - i3;
            this.G = i10;
            iArr[1] = iArr[1] + i3;
            a(i10 + this.i);
        }
        if (i6 < 0) {
            float f4 = this.i;
            if (f4 < 0.0f) {
                float f5 = i6;
                if (f5 < f4) {
                    iArr[1] = (int) (iArr[1] + f4);
                    this.i = 0.0f;
                } else {
                    this.i = f4 - f5;
                    iArr[1] = iArr[1] + i6;
                }
                a(this.i);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.e.q
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        com.scwang.smartrefresh.layout.a.c cVar;
        com.scwang.smartrefresh.layout.a.c cVar2;
        dispatchNestedScroll(i2, i3, i4, i5, this.F);
        int i6 = i5 + this.F[1];
        RefreshState refreshState = this.f2693a;
        if (refreshState != RefreshState.Refreshing && refreshState != RefreshState.Loading) {
            if (d() && i6 < 0 && ((cVar2 = this.W) == null || !cVar2.h())) {
                if (this.f2693a == RefreshState.None) {
                    h();
                }
                int abs = this.G + Math.abs(i6);
                this.G = abs;
                a(abs);
                return;
            }
            if (!this.q || i6 <= 0) {
                return;
            }
            com.scwang.smartrefresh.layout.a.c cVar3 = this.W;
            if (cVar3 == null || !cVar3.i()) {
                if (this.f2693a == RefreshState.None && !this.A) {
                    q();
                }
                int abs2 = this.G - Math.abs(i6);
                this.G = abs2;
                a(abs2);
                return;
            }
            return;
        }
        if (d() && i6 < 0 && ((cVar = this.W) == null || !cVar.h())) {
            int abs3 = this.G + Math.abs(i6);
            this.G = abs3;
            a(abs3 + this.i);
        } else {
            if (!c() || i6 <= 0) {
                return;
            }
            com.scwang.smartrefresh.layout.a.c cVar4 = this.W;
            if (cVar4 == null || !cVar4.i()) {
                int abs4 = this.G - Math.abs(i6);
                this.G = abs4;
                a(abs4 + this.i);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.e.q
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.L.a(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.G = 0;
        this.i = this.f2695c;
        this.J = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.e.q
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (isEnabled() && isNestedScrollingEnabled() && (i2 & 2) != 0) && (d() || c());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.e.q
    public void onStopNestedScroll(View view) {
        this.L.a(view);
        this.J = false;
        this.G = 0;
        b();
        stopNestedScroll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        if (r0 != 3) goto L53;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public boolean p() {
        return this.A;
    }

    protected void q() {
        a(RefreshState.PullToUpLoad);
    }

    protected void r() {
        this.c0 = System.currentTimeMillis();
        a(RefreshState.Refreshing);
        a(this.N);
        com.scwang.smartrefresh.layout.d.c cVar = this.B;
        if (cVar != null) {
            cVar.a(this);
        }
        com.scwang.smartrefresh.layout.a.e eVar = this.V;
        if (eVar != null) {
            eVar.a(this, this.N, this.R);
        }
        com.scwang.smartrefresh.layout.d.b bVar = this.D;
        if (bVar != null) {
            bVar.a(this);
            this.D.a(this.V, this.N, this.R);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        View k = this.W.k();
        if (Build.VERSION.SDK_INT >= 21 || !(k instanceof AbsListView)) {
            if (k == null || z.F(k)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    protected void s() {
        a(RefreshState.ReleaseToLoad);
    }

    @Override // android.view.View, androidx.core.e.m
    public void setNestedScrollingEnabled(boolean z) {
        this.K.a(z);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return this.K.b(i2);
    }

    @Override // android.view.View, androidx.core.e.m
    public void stopNestedScroll() {
        this.K.c();
    }

    protected void t() {
        a(RefreshState.ReleaseToRefresh);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setClipToPadding(false);
        this.e = context.getResources().getDisplayMetrics().heightPixels;
        this.j = new com.scwang.smartrefresh.layout.e.c();
        this.f2694b = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.L = new r(this);
        this.K = new n(this);
        com.scwang.smartrefresh.layout.e.a aVar = new com.scwang.smartrefresh.layout.e.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout);
        z.a(this, obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableNestedScrolling, true));
        this.h = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlDragRate, this.h);
        this.T = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.T);
        this.U = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.U);
        this.p = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableRefresh, this.p);
        this.f2696d = obtainStyledAttributes.getInt(R$styleable.SmartRefreshLayout_srlReboundDuration, this.f2696d);
        this.q = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableLoadmore, this.q);
        this.N = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlHeaderHeight, aVar.a(100.0f));
        this.P = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlFooterHeight, aVar.a(60.0f));
        this.r = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.r);
        this.s = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.s);
        this.t = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent, this.t);
        this.u = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.u);
        this.v = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.v);
        this.x = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableAutoLoadmore, this.x);
        this.w = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableAutoLoadmore, this.w);
        this.y = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.y);
        this.z = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.z);
        this.m = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedHeaderViewId, -1);
        this.n = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedFooterViewId, -1);
        this.S = (int) Math.max(this.P * (this.T - 1.0f), 0.0f);
        this.R = (int) Math.max(this.N * (this.T - 1.0f), 0.0f);
        if (obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_srlHeaderHeight)) {
            this.O = DimensionStatus.XmlLayoutUnNotify;
        }
        if (obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_srlFooterHeight)) {
            this.Q = DimensionStatus.XmlLayoutUnNotify;
        }
        int color = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.o = new int[]{color2, color};
            } else {
                this.o = new int[]{color2};
            }
        }
        obtainStyledAttributes.recycle();
    }

    protected boolean b() {
        RefreshState refreshState = this.f2693a;
        if (refreshState == RefreshState.Loading) {
            int i2 = this.f2695c;
            int i3 = this.P;
            if (i2 < (-i3)) {
                this.G = -i3;
                a(-i3);
                return true;
            }
            if (i2 <= 0) {
                return false;
            }
            this.G = 0;
            a(0);
            return true;
        }
        if (refreshState == RefreshState.Refreshing) {
            int i4 = this.f2695c;
            int i5 = this.N;
            if (i4 > i5) {
                this.G = i5;
                a(i5);
                return true;
            }
            if (i4 >= 0) {
                return false;
            }
            this.G = 0;
            a(0);
            return true;
        }
        if (refreshState != RefreshState.PullDownToRefresh && (!this.y || refreshState != RefreshState.ReleaseToRefresh)) {
            RefreshState refreshState2 = this.f2693a;
            if (refreshState2 != RefreshState.PullToUpLoad && (!this.y || refreshState2 != RefreshState.ReleaseToLoad)) {
                RefreshState refreshState3 = this.f2693a;
                if (refreshState3 == RefreshState.ReleaseToRefresh) {
                    r();
                    return true;
                }
                if (refreshState3 == RefreshState.ReleaseToLoad) {
                    f();
                    return true;
                }
                if (this.f2695c == 0) {
                    return false;
                }
                a(0);
                return true;
            }
            i();
            return true;
        }
        g();
        return true;
    }

    protected void c(int i2, boolean z) {
        com.scwang.smartrefresh.layout.a.d dVar;
        com.scwang.smartrefresh.layout.a.e eVar;
        RefreshState refreshState;
        int i3 = this.f2695c;
        if (i3 == i2) {
            return;
        }
        this.f2695c = i2;
        if (!z && (refreshState = this.f2693a) != RefreshState.Refreshing && refreshState != RefreshState.Loading) {
            if (i2 > this.N) {
                t();
            } else if ((-i2) > this.P && !this.A) {
                s();
            } else if (this.f2695c < 0 && !this.A) {
                q();
            } else if (this.f2695c > 0) {
                h();
            }
        }
        if (this.W != null) {
            if (i2 >= 0) {
                if (this.t || (eVar = this.V) == null || eVar.b() == SpinnerStyle.FixedBehind) {
                    this.W.a(i2);
                    if (this.e0 != 0) {
                        invalidate();
                    }
                }
            } else if (this.u || (dVar = this.a0) == null || dVar.b() == SpinnerStyle.FixedBehind) {
                this.W.a(i2);
                if (this.e0 != 0) {
                    invalidate();
                }
            }
        }
        if ((i2 >= 0 || i3 > 0) && this.V != null) {
            i2 = Math.max(i2, 0);
            if (d() && (this.V.b() == SpinnerStyle.Scale || this.V.b() == SpinnerStyle.Translate)) {
                this.V.a().requestLayout();
            }
            if (z) {
                com.scwang.smartrefresh.layout.a.e eVar2 = this.V;
                float f2 = i2 * 1.0f;
                int i4 = this.N;
                eVar2.d(f2 / i4, i2, i4, this.R);
                com.scwang.smartrefresh.layout.d.b bVar = this.D;
                if (bVar != null) {
                    com.scwang.smartrefresh.layout.a.e eVar3 = this.V;
                    int i5 = this.N;
                    bVar.b(eVar3, f2 / i5, i2, i5, this.R);
                }
            } else {
                com.scwang.smartrefresh.layout.a.e eVar4 = this.V;
                float f3 = i2 * 1.0f;
                int i6 = this.N;
                eVar4.c(f3 / i6, i2, i6, this.R);
                com.scwang.smartrefresh.layout.d.b bVar2 = this.D;
                if (bVar2 != null) {
                    com.scwang.smartrefresh.layout.a.e eVar5 = this.V;
                    int i7 = this.N;
                    bVar2.a(eVar5, f3 / i7, i2, i7, this.R);
                }
            }
        }
        if ((i2 <= 0 || i3 < 0) && this.a0 != null) {
            int min = Math.min(i2, 0);
            if (this.q && (this.a0.b() == SpinnerStyle.Scale || this.a0.b() == SpinnerStyle.Translate)) {
                this.a0.a().requestLayout();
            }
            if (z) {
                com.scwang.smartrefresh.layout.a.d dVar2 = this.a0;
                float f4 = min * 1.0f;
                int i8 = this.P;
                dVar2.b(f4 / i8, min, i8, this.S);
                com.scwang.smartrefresh.layout.d.b bVar3 = this.D;
                if (bVar3 != null) {
                    com.scwang.smartrefresh.layout.a.d dVar3 = this.a0;
                    int i9 = this.P;
                    bVar3.a(dVar3, f4 / i9, min, i9, this.S);
                    return;
                }
                return;
            }
            com.scwang.smartrefresh.layout.a.d dVar4 = this.a0;
            float f5 = min * 1.0f;
            int i10 = this.P;
            dVar4.a(f5 / i10, min, i10, this.S);
            com.scwang.smartrefresh.layout.d.b bVar4 = this.D;
            if (bVar4 != null) {
                com.scwang.smartrefresh.layout.a.d dVar5 = this.a0;
                int i11 = this.P;
                bVar4.b(dVar5, f5 / i11, min, i11, this.S);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public SmartRefreshLayout j() {
        b(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.b0))));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SmartRefreshLayout e(int i2) {
        if (this.Q.canReplaceWith(DimensionStatus.CodeExact)) {
            this.P = i2;
            int max = (int) Math.max(i2 * (this.U - 1.0f), 0.0f);
            this.S = max;
            com.scwang.smartrefresh.layout.a.d dVar = this.a0;
            if (dVar != null) {
                this.Q = DimensionStatus.CodeExact;
                dVar.a(this.M, this.P, max);
            } else {
                this.Q = DimensionStatus.CodeExactUnNotify;
            }
        }
        return this;
    }

    public SmartRefreshLayout f(int i2) {
        if (this.O.canReplaceWith(DimensionStatus.CodeExact)) {
            this.N = i2;
            int max = (int) Math.max(i2 * (this.T - 1.0f), 0.0f);
            this.R = max;
            com.scwang.smartrefresh.layout.a.e eVar = this.V;
            if (eVar != null) {
                this.O = DimensionStatus.CodeExact;
                eVar.a(this.M, this.N, max);
            } else {
                this.O = DimensionStatus.CodeExactUnNotify;
            }
        }
        return this;
    }

    public SmartRefreshLayout d(boolean z) {
        this.p = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public boolean d() {
        com.scwang.smartrefresh.layout.a.c cVar;
        return this.p && (cVar = this.W) != null && cVar.d();
    }

    public SmartRefreshLayout b(boolean z) {
        this.q = z;
        return this;
    }

    public SmartRefreshLayout b(int i2, boolean z) {
        h hVar = new h(z);
        if (i2 > 0) {
            postDelayed(hVar, i2);
        } else {
            hVar.run();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public SmartRefreshLayout b(int i2) {
        a(i2, true);
        return this;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2693a = RefreshState.None;
        this.f2696d = 250;
        this.h = 0.5f;
        this.p = true;
        this.q = true;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = false;
        this.z = true;
        this.A = false;
        this.E = new int[2];
        this.F = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.O = dimensionStatus;
        this.Q = dimensionStatus;
        this.T = 2.0f;
        this.U = 3.0f;
        this.b0 = 0L;
        this.c0 = 0L;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = null;
        this.i0 = new f();
        this.j0 = new g();
        a(context, attributeSet);
    }

    protected void a(RefreshState refreshState) {
        RefreshState refreshState2 = this.f2693a;
        if (refreshState2 != refreshState) {
            this.f2693a = refreshState;
            com.scwang.smartrefresh.layout.a.d dVar = this.a0;
            if (dVar != null) {
                dVar.a(this, refreshState2, refreshState);
            }
            com.scwang.smartrefresh.layout.a.e eVar = this.V;
            if (eVar != null) {
                eVar.a(this, refreshState2, refreshState);
            }
            com.scwang.smartrefresh.layout.d.b bVar = this.D;
            if (bVar != null) {
                bVar.a(this, refreshState2, refreshState);
            }
        }
    }

    public SmartRefreshLayout c(boolean z) {
        this.w = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public SmartRefreshLayout c(int i2) {
        b(i2, true);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public boolean c() {
        com.scwang.smartrefresh.layout.a.c cVar;
        return this.q && !this.A && (cVar = this.W) != null && cVar.c();
    }

    protected ValueAnimator a(int i2) {
        return a(i2, 0);
    }

    protected ValueAnimator a(int i2, int i3) {
        return a(i2, i3, this.j);
    }

    protected ValueAnimator a(int i2, int i3, Interpolator interpolator) {
        if (this.f2695c != i2) {
            ValueAnimator valueAnimator = this.h0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f2695c, i2);
            this.h0 = ofInt;
            ofInt.setDuration(this.f2696d);
            this.h0.setInterpolator(interpolator);
            this.h0.addUpdateListener(this.j0);
            this.h0.addListener(this.i0);
            this.h0.setStartDelay(i3);
            this.h0.start();
        }
        return this.h0;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2693a = RefreshState.None;
        this.f2696d = 250;
        this.h = 0.5f;
        this.p = true;
        this.q = true;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = false;
        this.z = true;
        this.A = false;
        this.E = new int[2];
        this.F = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.O = dimensionStatus;
        this.Q = dimensionStatus;
        this.T = 2.0f;
        this.U = 3.0f;
        this.b0 = 0L;
        this.c0 = 0L;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = null;
        this.i0 = new f();
        this.j0 = new g();
        a(context, attributeSet);
    }

    protected void a(float f2) {
        if (this.f2693a == RefreshState.Refreshing && f2 >= 0.0f) {
            if (f2 < this.N) {
                c((int) f2, false);
                return;
            }
            double d2 = this.R;
            int max = Math.max((this.e * 4) / 3, getHeight());
            int i2 = this.N;
            double d3 = max - i2;
            double max2 = Math.max(0.0f, (f2 - i2) * this.h);
            Double.isNaN(max2);
            Double.isNaN(d3);
            double pow = 1.0d - Math.pow(100.0d, (-max2) / d3);
            Double.isNaN(d2);
            c(((int) Math.min(d2 * pow, max2)) + this.N, false);
            return;
        }
        if (this.f2693a == RefreshState.Loading && f2 < 0.0f) {
            if (f2 > (-this.P)) {
                c((int) f2, false);
                return;
            }
            double d4 = this.S;
            double max3 = Math.max((this.e * 4) / 3, getHeight()) - this.P;
            double d5 = -Math.min(0.0f, (f2 + this.N) * this.h);
            Double.isNaN(d5);
            Double.isNaN(max3);
            double pow2 = 1.0d - Math.pow(100.0d, (-d5) / max3);
            Double.isNaN(d4);
            c(((int) (-Math.min(d4 * pow2, d5))) - this.P, false);
            return;
        }
        if (f2 >= 0.0f) {
            double d6 = this.R + this.N;
            double max4 = Math.max(this.e / 2, getHeight());
            double max5 = Math.max(0.0f, f2 * this.h);
            Double.isNaN(max5);
            Double.isNaN(max4);
            double pow3 = 1.0d - Math.pow(100.0d, (-max5) / max4);
            Double.isNaN(d6);
            c((int) Math.min(d6 * pow3, max5), false);
            return;
        }
        double d7 = this.S + this.P;
        double max6 = Math.max(this.e / 2, getHeight());
        double d8 = -Math.min(0.0f, f2 * this.h);
        Double.isNaN(d8);
        Double.isNaN(max6);
        double pow4 = 1.0d - Math.pow(100.0d, (-d8) / max6);
        Double.isNaN(d7);
        c((int) (-Math.min(d7 * pow4, d8)), false);
    }

    public SmartRefreshLayout a(com.scwang.smartrefresh.layout.a.e eVar) {
        com.scwang.smartrefresh.layout.a.e eVar2 = this.V;
        if (eVar2 != null) {
            removeView(eVar2.a());
        }
        this.V = eVar;
        this.O = this.O.unNotify();
        addView(this.V.a());
        return this;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f2693a = RefreshState.None;
        this.f2696d = 250;
        this.h = 0.5f;
        this.p = true;
        this.q = true;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = false;
        this.z = true;
        this.A = false;
        this.E = new int[2];
        this.F = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.O = dimensionStatus;
        this.Q = dimensionStatus;
        this.T = 2.0f;
        this.U = 3.0f;
        this.b0 = 0L;
        this.c0 = 0L;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = null;
        this.i0 = new f();
        this.j0 = new g();
        a(context, attributeSet);
    }

    public SmartRefreshLayout a(com.scwang.smartrefresh.layout.a.d dVar) {
        com.scwang.smartrefresh.layout.a.d dVar2 = this.a0;
        if (dVar2 != null) {
            removeView(dVar2.a());
        }
        this.a0 = dVar;
        this.Q = this.Q.unNotify();
        addView(this.a0.a());
        return this;
    }

    public SmartRefreshLayout a(com.scwang.smartrefresh.layout.d.c cVar) {
        this.B = cVar;
        return this;
    }

    public SmartRefreshLayout a(com.scwang.smartrefresh.layout.d.a aVar) {
        this.C = aVar;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public SmartRefreshLayout a(boolean z) {
        this.A = z;
        com.scwang.smartrefresh.layout.a.d dVar = this.a0;
        if (dVar != null) {
            dVar.a(z);
        }
        return this;
    }

    public SmartRefreshLayout a() {
        c(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.c0))));
        return this;
    }

    public SmartRefreshLayout a(int i2, boolean z) {
        i iVar = new i(z);
        if (i2 > 0) {
            postDelayed(iVar, i2);
        } else {
            iVar.run();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.h
    public boolean a(int i2, float f2) {
        if (this.f2693a != RefreshState.None || !c()) {
            return false;
        }
        ValueAnimator valueAnimator = this.h0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.h0 = new ValueAnimator();
        postDelayed(new a(f2), i2);
        return true;
    }
}
