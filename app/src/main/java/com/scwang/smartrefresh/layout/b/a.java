package com.scwang.smartrefresh.layout.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.PointF;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.e.m;
import androidx.core.e.q;
import androidx.core.e.w;
import androidx.fragment.app.Fragment;
import androidx.legacy.widget.Space;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import java.util.Collections;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: RefreshContentWrapper.java */
/* loaded from: classes.dex */
public class a implements com.scwang.smartrefresh.layout.a.c {

    /* renamed from: c, reason: collision with root package name */
    private View f2713c;

    /* renamed from: d, reason: collision with root package name */
    private View f2714d;
    private View e;
    private View f;
    private View g;
    private MotionEvent j;

    /* renamed from: a, reason: collision with root package name */
    private int f2711a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    private int f2712b = Integer.MAX_VALUE - 1;
    private boolean h = true;
    private boolean i = true;
    private com.scwang.smartrefresh.layout.b.d k = new com.scwang.smartrefresh.layout.b.d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RefreshContentWrapper.java */
    /* renamed from: com.scwang.smartrefresh.layout.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0083a implements AppBarLayout.OnOffsetChangedListener {
        C0083a(a aVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RefreshContentWrapper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        int f2715a = 0;

        /* renamed from: b, reason: collision with root package name */
        g f2716b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f2717c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewPager f2718d;

        b(g gVar, ViewPager viewPager) {
            this.f2717c = gVar;
            this.f2718d = viewPager;
            this.f2716b = this.f2717c;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2715a++;
            androidx.viewpager.widget.a b2 = this.f2718d.b();
            if (b2 != null) {
                if (b2 instanceof g) {
                    if (b2 == this.f2717c) {
                        this.f2718d.postDelayed(this, 500L);
                        return;
                    }
                    return;
                } else {
                    g gVar = this.f2716b;
                    if (gVar == null) {
                        this.f2716b = new g(b2);
                    } else {
                        gVar.a(b2);
                    }
                    this.f2716b.a(this.f2718d);
                    return;
                }
            }
            if (this.f2715a < 10) {
                this.f2718d.postDelayed(this, 500L);
            }
        }
    }

    /* compiled from: RefreshContentWrapper.java */
    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f2719a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f2720b;

        c(int i, int i2) {
            this.f2719a = i;
            this.f2720b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((AbsListView) a.this.e).smoothScrollBy(this.f2719a, this.f2720b);
        }
    }

    /* compiled from: RefreshContentWrapper.java */
    /* loaded from: classes.dex */
    class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        int f2722a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.scwang.smartrefresh.layout.a.g f2723b;

        d(com.scwang.smartrefresh.layout.a.g gVar) {
            this.f2723b = gVar;
            this.f2722a = this.f2723b.b();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (!(a.this.e instanceof AbsListView) || Build.VERSION.SDK_INT < 19) {
                a.this.e.scrollBy(0, intValue - this.f2722a);
            } else {
                ((AbsListView) a.this.e).scrollListBy(intValue - this.f2722a);
            }
            this.f2722a = intValue;
        }
    }

    /* compiled from: RefreshContentWrapper.java */
    /* loaded from: classes.dex */
    private class e implements AbsListView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        int f2725a;

        /* renamed from: b, reason: collision with root package name */
        int f2726b;

        /* renamed from: c, reason: collision with root package name */
        int f2727c;

        /* renamed from: d, reason: collision with root package name */
        int f2728d;
        com.scwang.smartrefresh.layout.a.g e;
        SparseArray<C0084a> f = new SparseArray<>(0);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RefreshContentWrapper.java */
        /* renamed from: com.scwang.smartrefresh.layout.b.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0084a {

            /* renamed from: a, reason: collision with root package name */
            int f2729a = 0;

            /* renamed from: b, reason: collision with root package name */
            int f2730b = 0;

            C0084a(e eVar) {
            }
        }

        e(com.scwang.smartrefresh.layout.a.g gVar) {
            this.e = gVar;
        }

        void a(AbsListView absListView) {
            absListView.setOnScrollListener(this);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int lastVisiblePosition;
            this.f2727c = this.f2725a;
            this.f2728d = this.f2726b;
            int a2 = a(absListView, i);
            this.f2725a = a2;
            int i4 = this.f2727c - a2;
            this.f2726b = i4;
            int i5 = this.f2728d + i4;
            if (i3 > 0) {
                com.scwang.smartrefresh.layout.a.h a3 = this.e.a();
                boolean z = a3.k() || a3.l() || a3.isLoading();
                if (a.this.j == null && i5 > 0 && i == 0) {
                    if (z && a3.d() && !com.scwang.smartrefresh.layout.e.b.b(absListView)) {
                        this.e.a(Math.min(i5, a.this.f2711a));
                        return;
                    }
                    return;
                }
                if (i5 >= 0 || (lastVisiblePosition = absListView.getLastVisiblePosition()) != i3 - 1 || lastVisiblePosition <= 0) {
                    return;
                }
                if (!a3.c() || a3.p() || !a3.m() || a3.getState() != RefreshState.None || com.scwang.smartrefresh.layout.e.b.a(absListView)) {
                    if (a.this.j == null && z && !com.scwang.smartrefresh.layout.e.b.a(absListView)) {
                        this.e.a(Math.max(i5, -a.this.f2712b));
                        return;
                    }
                    return;
                }
                this.e.a().a(0, 1.0f);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        private int a(AbsListView absListView, int i) {
            View childAt = absListView.getChildAt(0);
            if (childAt == null) {
                return 0;
            }
            C0084a c0084a = this.f.get(i);
            if (c0084a == null) {
                c0084a = new C0084a(this);
            }
            c0084a.f2729a = childAt.getHeight();
            c0084a.f2730b = childAt.getTop();
            this.f.append(i, c0084a);
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                C0084a c0084a2 = this.f.get(i4);
                if (c0084a2 != null) {
                    i3 = c0084a2.f2729a;
                }
                i2 += i3;
            }
            C0084a c0084a3 = this.f.get(i);
            if (c0084a3 == null) {
                c0084a3 = new C0084a(this);
            }
            return i2 - c0084a3.f2730b;
        }
    }

    /* compiled from: RefreshContentWrapper.java */
    /* loaded from: classes.dex */
    private class f implements View.OnScrollChangeListener {

        /* renamed from: a, reason: collision with root package name */
        long f2731a = 0;

        /* renamed from: b, reason: collision with root package name */
        long f2732b = 0;

        /* renamed from: c, reason: collision with root package name */
        int f2733c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f2734d = 0;
        com.scwang.smartrefresh.layout.a.g e;

        f(com.scwang.smartrefresh.layout.a.g gVar) {
            this.e = gVar;
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i, int i2, int i3, int i4) {
            if (this.f2733c == i2 && this.f2734d == i4) {
                return;
            }
            com.scwang.smartrefresh.layout.a.h a2 = this.e.a();
            boolean z = a2.k() || a2.l() || a2.isLoading();
            if (i2 > 0 || i4 <= 0 || a.this.j != null || this.f2731a - this.f2732b <= 1000 || !z || !a2.d()) {
                if (i4 < i2 && a.this.j == null && z && a2.c() && this.f2731a - this.f2732b > 1000 && !com.scwang.smartrefresh.layout.e.b.a(a.this.e)) {
                    this.e.a(Math.max(((this.f2734d - i4) * 16000) / ((int) (((float) (this.f2731a - this.f2732b)) / 1000.0f)), -a.this.f2712b));
                }
            } else {
                this.e.a(Math.min(((this.f2734d - i4) * 16000) / ((int) (((float) (this.f2731a - this.f2732b)) / 1000.0f)), a.this.f2711a));
            }
            this.f2733c = i2;
            this.f2734d = i4;
            this.f2732b = this.f2731a;
            this.f2731a = System.nanoTime();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RefreshContentWrapper.java */
    /* loaded from: classes.dex */
    public class g extends androidx.viewpager.widget.b {

        /* renamed from: d, reason: collision with root package name */
        private ViewPager f2735d;

        g(androidx.viewpager.widget.a aVar) {
            super(aVar);
        }

        void a(androidx.viewpager.widget.a aVar) {
            this.f1777c = aVar;
        }

        @Override // androidx.viewpager.widget.b, androidx.viewpager.widget.a
        public void b(DataSetObserver dataSetObserver) {
            super.b(dataSetObserver);
            if (dataSetObserver == null) {
                a.this.a(this.f2735d, this);
            }
        }

        @Override // androidx.viewpager.widget.b
        public void a(ViewPager viewPager) {
            this.f2735d = viewPager;
            super.a(viewPager);
        }

        @Override // androidx.viewpager.widget.b, androidx.viewpager.widget.a
        public void b(ViewGroup viewGroup, int i, Object obj) {
            super.b(viewGroup, i, obj);
            if (obj instanceof View) {
                a.this.e = (View) obj;
            } else if (obj instanceof Fragment) {
                a.this.e = ((Fragment) obj).getView();
            }
            if (a.this.e != null) {
                a aVar = a.this;
                aVar.e = aVar.a(aVar.e, true);
                if (!(a.this.e instanceof q) || (a.this.e instanceof m)) {
                    return;
                }
                a aVar2 = a.this;
                aVar2.e = aVar2.a(aVar2.e, false);
            }
        }
    }

    public a(View view) {
        this.f2714d = view;
        this.f2713c = view;
        view.setTag(1685825348, "TAG_REFRESH_CONTENT_WRAPPER");
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public ViewGroup.LayoutParams e() {
        return this.f2713c.getLayoutParams();
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public int f() {
        return this.f2713c.getMeasuredHeight();
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public void g() {
        this.j = null;
        this.k.a((MotionEvent) null);
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public boolean h() {
        return this.k.a(this.f2713c);
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public boolean i() {
        return this.k.b(this.f2713c);
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public int j() {
        return this.f2713c.getMeasuredWidth();
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public View k() {
        return this.e;
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public boolean b(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(-this.f2713c.getLeft(), (-this.f2713c.getTop()) - this.f2714d.getTranslationY());
        boolean a2 = a(this.f2713c, obtain);
        obtain.recycle();
        return a2;
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public boolean c() {
        return this.i;
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public boolean d() {
        return this.h;
    }

    public static boolean a(View view) {
        return "TAG_REFRESH_CONTENT_WRAPPER".equals(view.getTag(1685825348));
    }

    private void a(View view, com.scwang.smartrefresh.layout.a.g gVar) {
        View a2 = a(view, true);
        this.e = a2;
        try {
            if (a2 instanceof CoordinatorLayout) {
                gVar.a().setNestedScrollingEnabled(false);
                a((CoordinatorLayout) this.e);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        View view2 = this.e;
        if ((view2 instanceof q) && !(view2 instanceof m)) {
            this.e = a(view2, false);
        }
        View view3 = this.e;
        if (view3 instanceof ViewPager) {
            a((ViewPager) view3);
        }
        if (this.e == null) {
            this.e = view;
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public void b(int i, int i2) {
        this.f2713c.measure(i, i2);
    }

    private static int b(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
        return view.getMeasuredHeight();
    }

    public a(Context context) {
        View view = new View(context);
        this.f2714d = view;
        this.f2713c = view;
        view.setTag(1685825348, "TAG_REFRESH_CONTENT_WRAPPER");
    }

    /* compiled from: RefreshContentWrapper.java */
    /* loaded from: classes.dex */
    private class h extends RecyclerView.s {

        /* renamed from: a, reason: collision with root package name */
        int f2736a;

        /* renamed from: b, reason: collision with root package name */
        long f2737b;

        /* renamed from: c, reason: collision with root package name */
        com.scwang.smartrefresh.layout.a.g f2738c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RefreshContentWrapper.java */
        /* renamed from: com.scwang.smartrefresh.layout.b.a$h$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0085a extends RecyclerView.q {
            C0085a() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.q
            public boolean a(int i, int i2) {
                h.this.f2737b = System.currentTimeMillis();
                return false;
            }
        }

        h(com.scwang.smartrefresh.layout.a.g gVar) {
            this.f2738c = gVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int i) {
            com.scwang.smartrefresh.layout.a.h a2 = this.f2738c.a();
            if (i == 0 && a.this.j == null) {
                boolean z = System.currentTimeMillis() - this.f2737b < 1000;
                boolean z2 = a2.k() || a2.l() || a2.isLoading();
                if (this.f2736a < -1 && z && z2 && a2.d()) {
                    this.f2738c.a(Math.min((-this.f2736a) * 2, a.this.f2711a));
                } else if ((!a2.c() || a2.p() || !a2.m() || a2.getState() != RefreshState.None) && this.f2736a > 1 && z && z2 && a2.c()) {
                    this.f2738c.a(Math.max((-this.f2736a) * 2, -a.this.f2712b));
                }
                this.f2736a = 0;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int i, int i2) {
            LinearLayoutManager linearLayoutManager;
            int H;
            this.f2736a = i2;
            com.scwang.smartrefresh.layout.a.h a2 = this.f2738c.a();
            if (i2 > 0 && a2.c() && !a2.p() && a2.m() && a2.getState() == RefreshState.None) {
                RecyclerView.o t = recyclerView.t();
                if (!(t instanceof LinearLayoutManager) || (H = (linearLayoutManager = (LinearLayoutManager) t).H()) < linearLayoutManager.j() - 1 || H <= 0 || com.scwang.smartrefresh.layout.e.b.a(recyclerView)) {
                    return;
                }
                this.f2738c.a().a(0, 1.0f);
            }
        }

        void a(RecyclerView recyclerView) {
            recyclerView.a(this);
            recyclerView.a(new C0085a());
        }
    }

    private void a(CoordinatorLayout coordinatorLayout) {
        for (int childCount = coordinatorLayout.getChildCount() - 1; childCount >= 0; childCount--) {
            AppBarLayout childAt = coordinatorLayout.getChildAt(childCount);
            if (childAt instanceof AppBarLayout) {
                childAt.addOnOffsetChangedListener(new C0083a(this));
            }
        }
    }

    private void a(ViewPager viewPager) {
        a(viewPager, (g) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewPager viewPager, g gVar) {
        viewPager.post(new b(gVar, viewPager));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View a(View view, boolean z) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(Collections.singletonList(view));
        View view2 = null;
        while (!linkedBlockingQueue.isEmpty() && view2 == null) {
            View view3 = (View) linkedBlockingQueue.poll();
            if (view3 != null) {
                if ((z || view3 != view) && ((view3 instanceof AbsListView) || (view3 instanceof ScrollView) || (view3 instanceof w) || (view3 instanceof m) || (view3 instanceof q) || (view3 instanceof WebView) || (view3 instanceof ViewPager))) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        linkedBlockingQueue.add(viewGroup.getChildAt(i));
                    }
                }
            }
        }
        return view2;
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public View a() {
        return this.f2713c;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        if (view instanceof m) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 21 && view.isNestedScrollingEnabled()) {
            return true;
        }
        if (!(view instanceof ViewGroup) || motionEvent == null) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (com.scwang.smartrefresh.layout.e.b.a(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.offsetLocation(pointF.x, pointF.y);
                return a(childAt, obtain);
            }
        }
        return false;
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public void a(int i) {
        this.f2714d.setTranslationY(i);
        View view = this.f;
        if (view != null) {
            view.setTranslationY(Math.max(0, i));
        }
        View view2 = this.g;
        if (view2 != null) {
            view2.setTranslationY(Math.min(0, i));
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public void a(int i, int i2, int i3, int i4) {
        this.f2713c.layout(i, i2, i3, i4);
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public void a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.j = obtain;
        obtain.offsetLocation(-this.f2713c.getLeft(), -this.f2713c.getTop());
        this.k.a(this.j);
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public void a(com.scwang.smartrefresh.layout.a.g gVar, View view, View view2) {
        a(this.f2713c, gVar);
        try {
            if (this.e instanceof RecyclerView) {
                new h(gVar).a((RecyclerView) this.e);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        View view3 = this.e;
        if (view3 instanceof AbsListView) {
            new e(gVar).a((AbsListView) this.e);
        } else if (Build.VERSION.SDK_INT >= 23 && view3 != null) {
            view3.setOnScrollChangeListener(new f(gVar));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            View view4 = this.e;
            if ((view4 instanceof ListView) && !(view4 instanceof m)) {
                view4.setNestedScrollingEnabled(true);
            }
        }
        if (view == null && view2 == null) {
            return;
        }
        this.f = view;
        this.g = view2;
        FrameLayout frameLayout = new FrameLayout(this.f2713c.getContext());
        gVar.a().n().removeView(this.f2713c);
        ViewGroup.LayoutParams layoutParams = this.f2713c.getLayoutParams();
        frameLayout.addView(this.f2713c, -1, -1);
        gVar.a().n().addView(frameLayout, layoutParams);
        this.f2713c = frameLayout;
        if (view != null) {
            view.setClickable(true);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams2.height = b(view);
            viewGroup.addView(new Space(this.f2713c.getContext()), indexOfChild, layoutParams2);
            frameLayout.addView(view);
        }
        if (view2 != null) {
            view2.setClickable(true);
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int indexOfChild2 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
            layoutParams3.height = b(view2);
            viewGroup2.addView(new Space(this.f2713c.getContext()), indexOfChild2, layoutParams3);
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, layoutParams4);
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public void a(int i, int i2) {
        this.f2711a = i;
        this.f2712b = i2;
    }

    @Override // com.scwang.smartrefresh.layout.a.c
    public ValueAnimator.AnimatorUpdateListener a(com.scwang.smartrefresh.layout.a.g gVar, int i, int i2, Interpolator interpolator, int i3) {
        if (this.e == null || !gVar.a().o()) {
            return null;
        }
        View view = this.e;
        if (!(view instanceof AbsListView) || Build.VERSION.SDK_INT >= 19) {
            if (com.scwang.smartrefresh.layout.e.b.a(this.e)) {
                return new d(gVar);
            }
            return null;
        }
        if (i2 > 0) {
            gVar.a().n().postDelayed(new c(i, i3), i2);
        } else {
            ((AbsListView) view).smoothScrollBy(i, i3);
        }
        return null;
    }
}
