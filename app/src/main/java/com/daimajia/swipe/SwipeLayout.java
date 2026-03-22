package com.daimajia.swipe;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.core.e.z;
import androidx.customview.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class SwipeLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private androidx.customview.a.a f2353a;

    /* renamed from: b, reason: collision with root package name */
    private int f2354b;

    /* renamed from: c, reason: collision with root package name */
    private DragEdge f2355c;

    /* renamed from: d, reason: collision with root package name */
    private ShowMode f2356d;
    private float e;
    private float f;
    private List<h> g;
    private List<f> h;
    private Map<View, ArrayList<e>> i;
    private Map<View, Boolean> j;
    private c k;
    private boolean l;
    private a.c m;
    private int n;
    private List<d> o;
    private boolean p;
    private float q;
    private float r;
    private GestureDetector s;

    /* loaded from: classes.dex */
    public enum DragEdge {
        Left,
        Right,
        Top,
        Bottom
    }

    /* loaded from: classes.dex */
    public enum ShowMode {
        LayDown,
        PullOut
    }

    /* loaded from: classes.dex */
    public enum Status {
        Middle,
        Open,
        Close
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2358a;

        static {
            int[] iArr = new int[DragEdge.values().length];
            f2358a = iArr;
            try {
                iArr[DragEdge.Top.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2358a[DragEdge.Bottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2358a[DragEdge.Left.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2358a[DragEdge.Right.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(SwipeLayout swipeLayout, boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(SwipeLayout swipeLayout);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(View view, DragEdge dragEdge, float f, int i);
    }

    /* loaded from: classes.dex */
    public interface f {
        boolean a(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    class g extends GestureDetector.SimpleOnGestureListener {
        g() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwipeLayout.this.k != null) {
                ViewGroup b2 = SwipeLayout.this.b();
                ViewGroup f = SwipeLayout.this.f();
                if (motionEvent.getX() <= b2.getLeft() || motionEvent.getX() >= b2.getRight() || motionEvent.getY() <= b2.getTop() || motionEvent.getY() >= b2.getBottom()) {
                    b2 = f;
                }
                SwipeLayout.this.k.a(SwipeLayout.this, b2 == f);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            SwipeLayout.this.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (SwipeLayout.this.k == null) {
                return true;
            }
            SwipeLayout.this.a(motionEvent);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (SwipeLayout.this.k != null) {
                return true;
            }
            SwipeLayout.this.a(motionEvent);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(SwipeLayout swipeLayout);

        void a(SwipeLayout swipeLayout, float f, float f2);

        void a(SwipeLayout swipeLayout, int i, int i2);

        void b(SwipeLayout swipeLayout);

        void c(SwipeLayout swipeLayout);

        void d(SwipeLayout swipeLayout);
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private AdapterView k() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof AdapterView) {
                return (AdapterView) parent;
            }
        }
        return null;
    }

    private boolean l() {
        Adapter adapter;
        AdapterView k = k();
        if (k != null && (adapter = k.getAdapter()) != null) {
            int positionForView = k.getPositionForView(this);
            if (adapter instanceof BaseAdapter) {
                return ((BaseAdapter) adapter).isEnabled(positionForView);
            }
            if (adapter instanceof ListAdapter) {
                return ((ListAdapter) adapter).isEnabled(positionForView);
            }
        }
        return true;
    }

    private void m() {
        Status d2 = d();
        ViewGroup b2 = b();
        if (d2 == Status.Close) {
            if (b2.getVisibility() != 4) {
                b2.setVisibility(4);
            }
        } else if (b2.getVisibility() != 0) {
            b2.setVisibility(0);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f2353a.a(true)) {
            z.H(this);
        }
    }

    public ViewGroup f() {
        return (ViewGroup) getChildAt(1);
    }

    public boolean g() {
        return this.l;
    }

    void h() {
        Rect a2 = a(false);
        f().layout(a2.left, a2.top, a2.right, a2.bottom);
        Rect a3 = a(ShowMode.LayDown, a2);
        b().layout(a3.left, a3.top, a3.right, a3.bottom);
        bringChildToFront(f());
    }

    void i() {
        Rect a2 = a(false);
        f().layout(a2.left, a2.top, a2.right, a2.bottom);
        Rect a3 = a(ShowMode.PullOut, a2);
        b().layout(a3.left, a3.top, a3.right, a3.bottom);
        bringChildToFront(f());
    }

    public void j() {
        b(true, true);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !l()) {
            return true;
        }
        if (!g()) {
            return false;
        }
        for (f fVar : this.h) {
            if (fVar != null && fVar.a(motionEvent)) {
                return false;
            }
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Status d2 = d();
            if (d2 == Status.Close) {
                this.p = a(f(), motionEvent) != null;
            } else if (d2 == Status.Open) {
                this.p = a(b(), motionEvent) != null;
            }
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.p = false;
        }
        if (this.p) {
            return false;
        }
        return this.f2353a.b(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() == 2) {
            if ((getChildAt(0) instanceof ViewGroup) && (getChildAt(1) instanceof ViewGroup)) {
                ShowMode showMode = this.f2356d;
                if (showMode == ShowMode.PullOut) {
                    i();
                } else if (showMode == ShowMode.LayDown) {
                    h();
                }
                m();
                if (this.o != null) {
                    for (int i5 = 0; i5 < this.o.size(); i5++) {
                        this.o.get(i5).a(this);
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("The 2 children in SwipeLayout must be an instance of ViewGroup");
        }
        throw new IllegalStateException("You need 2  views in SwipeLayout");
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        DragEdge dragEdge = this.f2355c;
        if (dragEdge != DragEdge.Left && dragEdge != DragEdge.Right) {
            this.f2354b = b().getMeasuredHeight() - a(this.f);
        } else {
            this.f2354b = b().getMeasuredWidth() - a(this.e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (r0 != 3) goto L123;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f3  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.daimajia.swipe.SwipeLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2354b = 0;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new HashMap();
        this.j = new HashMap();
        this.l = true;
        this.m = new a();
        this.n = 0;
        this.p = false;
        this.q = -1.0f;
        this.r = -1.0f;
        this.s = new GestureDetector(getContext(), new g());
        this.f2353a = androidx.customview.a.a.a(this, this.m);
        int ordinal = DragEdge.Right.ordinal();
        this.e = 0.0f;
        this.f = 0.0f;
        this.f2355c = DragEdge.values()[ordinal];
        this.f2356d = ShowMode.values()[ShowMode.PullOut.ordinal()];
    }

    public Status d() {
        int left = f().getLeft();
        int top = f().getTop();
        if (left == getPaddingLeft() && top == getPaddingTop()) {
            return Status.Close;
        }
        if (left != getPaddingLeft() - this.f2354b && left != getPaddingLeft() + this.f2354b && top != getPaddingTop() - this.f2354b && top != getPaddingTop() + this.f2354b) {
            return Status.Middle;
        }
        return Status.Open;
    }

    public ShowMode e() {
        return this.f2356d;
    }

    protected boolean b(View view, Rect rect, DragEdge dragEdge, int i, int i2, int i3, int i4) {
        if (this.j.get(view).booleanValue()) {
            return false;
        }
        int i5 = rect.left;
        int i6 = rect.right;
        int i7 = rect.top;
        int i8 = rect.bottom;
        if (e() == ShowMode.LayDown) {
            if ((dragEdge != DragEdge.Right || i3 > i5) && ((dragEdge != DragEdge.Left || i < i6) && ((dragEdge != DragEdge.Top || i2 < i8) && (dragEdge != DragEdge.Bottom || i4 > i7)))) {
                return false;
            }
        } else {
            if (e() != ShowMode.PullOut) {
                return false;
            }
            if ((dragEdge != DragEdge.Right || i6 > getWidth()) && ((dragEdge != DragEdge.Left || i5 < getPaddingLeft()) && ((dragEdge != DragEdge.Top || i7 < getPaddingTop()) && (dragEdge != DragEdge.Bottom || i8 > getHeight())))) {
                return false;
            }
        }
        return true;
    }

    public DragEdge c() {
        return this.f2355c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, float f3) {
        if (f2 == 0.0f && d() == Status.Middle) {
            a();
        }
        DragEdge dragEdge = this.f2355c;
        if (dragEdge == DragEdge.Left || dragEdge == DragEdge.Right) {
            if (f2 > 0.0f) {
                if (this.f2355c == DragEdge.Left) {
                    j();
                } else {
                    a();
                }
            }
            if (f2 < 0.0f) {
                if (this.f2355c == DragEdge.Left) {
                    a();
                    return;
                } else {
                    j();
                    return;
                }
            }
            return;
        }
        if (f3 > 0.0f) {
            if (dragEdge == DragEdge.Top) {
                j();
            } else {
                a();
            }
        }
        if (f3 < 0.0f) {
            if (this.f2355c == DragEdge.Top) {
                a();
            } else {
                j();
            }
        }
    }

    protected boolean a(View view, Rect rect, DragEdge dragEdge, int i, int i2, int i3, int i4) {
        int i5 = rect.left;
        int i6 = rect.right;
        int i7 = rect.top;
        int i8 = rect.bottom;
        if (e() == ShowMode.LayDown) {
            int i9 = b.f2358a[dragEdge.ordinal()];
            return i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 == 4 && i3 > i5 && i3 <= i6 : i < i6 && i >= i5 : i4 > i7 && i4 <= i8 : i2 >= i7 && i2 < i8;
        }
        if (e() != ShowMode.PullOut) {
            return false;
        }
        int i10 = b.f2358a[dragEdge.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 == 4 && i5 <= getWidth() && i6 > getWidth() : i6 >= getPaddingLeft() && i5 < getPaddingLeft() : i7 < getHeight() && i7 >= getPaddingTop() : i7 < getPaddingTop() && i8 >= getPaddingTop();
    }

    protected void b(int i, int i2, int i3, int i4) {
        DragEdge c2 = c();
        boolean z = false;
        if (c2 != DragEdge.Left ? c2 != DragEdge.Right ? c2 != DragEdge.Top ? c2 != DragEdge.Bottom || i4 <= 0 : i4 >= 0 : i3 <= 0 : i3 >= 0) {
            z = true;
        }
        a(i, i2, z);
    }

    protected Rect a(View view) {
        Rect rect = new Rect(view.getLeft(), view.getTop(), 0, 0);
        View view2 = view;
        while (view2.getParent() != null && view2 != getRootView() && (view2 = (View) view2.getParent()) != this) {
            rect.left += view2.getLeft();
            rect.top += view2.getTop();
        }
        rect.right = rect.left + view.getMeasuredWidth();
        rect.bottom = rect.top + view.getMeasuredHeight();
        return rect;
    }

    public ViewGroup b() {
        return (ViewGroup) getChildAt(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, float f3) {
        if (f2 == 0.0f && d() == Status.Middle) {
            a();
        }
        DragEdge dragEdge = this.f2355c;
        if (dragEdge == DragEdge.Left || dragEdge == DragEdge.Right) {
            if (f2 > 0.0f) {
                if (this.f2355c == DragEdge.Left) {
                    j();
                } else {
                    a();
                }
            }
            if (f2 < 0.0f) {
                if (this.f2355c == DragEdge.Left) {
                    a();
                    return;
                } else {
                    j();
                    return;
                }
            }
            return;
        }
        if (f3 > 0.0f) {
            if (dragEdge == DragEdge.Top) {
                j();
            } else {
                a();
            }
        }
        if (f3 < 0.0f) {
            if (this.f2355c == DragEdge.Top) {
                a();
            } else {
                j();
            }
        }
    }

    /* loaded from: classes.dex */
    class a extends a.c {
        a() {
        }

        @Override // androidx.customview.a.a.c
        public int a(View view, int i, int i2) {
            if (view == SwipeLayout.this.f()) {
                int i3 = b.f2358a[SwipeLayout.this.f2355c.ordinal()];
                if (i3 == 1 || i3 == 2) {
                    return SwipeLayout.this.getPaddingLeft();
                }
                if (i3 != 3) {
                    if (i3 == 4) {
                        if (i <= SwipeLayout.this.getPaddingLeft()) {
                            if (i < SwipeLayout.this.getPaddingLeft() - SwipeLayout.this.f2354b) {
                                return SwipeLayout.this.getPaddingLeft() - SwipeLayout.this.f2354b;
                            }
                        } else {
                            return SwipeLayout.this.getPaddingLeft();
                        }
                    }
                } else if (i >= SwipeLayout.this.getPaddingLeft()) {
                    if (i > SwipeLayout.this.getPaddingLeft() + SwipeLayout.this.f2354b) {
                        return SwipeLayout.this.getPaddingLeft() + SwipeLayout.this.f2354b;
                    }
                } else {
                    return SwipeLayout.this.getPaddingLeft();
                }
            } else if (view == SwipeLayout.this.b()) {
                int i4 = b.f2358a[SwipeLayout.this.f2355c.ordinal()];
                if (i4 == 1 || i4 == 2) {
                    return SwipeLayout.this.getPaddingLeft();
                }
                if (i4 != 3) {
                    if (i4 == 4 && SwipeLayout.this.f2356d == ShowMode.PullOut && i < SwipeLayout.this.getMeasuredWidth() - SwipeLayout.this.f2354b) {
                        return SwipeLayout.this.getMeasuredWidth() - SwipeLayout.this.f2354b;
                    }
                } else if (SwipeLayout.this.f2356d == ShowMode.PullOut && i > SwipeLayout.this.getPaddingLeft()) {
                    return SwipeLayout.this.getPaddingLeft();
                }
            }
            return i;
        }

        @Override // androidx.customview.a.a.c
        public int b(View view, int i, int i2) {
            if (view == SwipeLayout.this.f()) {
                int i3 = b.f2358a[SwipeLayout.this.f2355c.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3 || i3 == 4) {
                            return SwipeLayout.this.getPaddingTop();
                        }
                    } else {
                        if (i < SwipeLayout.this.getPaddingTop() - SwipeLayout.this.f2354b) {
                            return SwipeLayout.this.getPaddingTop() - SwipeLayout.this.f2354b;
                        }
                        if (i > SwipeLayout.this.getPaddingTop()) {
                            return SwipeLayout.this.getPaddingTop();
                        }
                    }
                } else if (i >= SwipeLayout.this.getPaddingTop()) {
                    if (i > SwipeLayout.this.getPaddingTop() + SwipeLayout.this.f2354b) {
                        return SwipeLayout.this.getPaddingTop() + SwipeLayout.this.f2354b;
                    }
                } else {
                    return SwipeLayout.this.getPaddingTop();
                }
            } else {
                int i4 = b.f2358a[SwipeLayout.this.f2355c.ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3 || i4 == 4) {
                            return SwipeLayout.this.getPaddingTop();
                        }
                    } else if (SwipeLayout.this.f2356d == ShowMode.PullOut) {
                        if (i < SwipeLayout.this.getMeasuredHeight() - SwipeLayout.this.f2354b) {
                            return SwipeLayout.this.getMeasuredHeight() - SwipeLayout.this.f2354b;
                        }
                    } else if (SwipeLayout.this.f().getTop() + i2 < SwipeLayout.this.getPaddingTop()) {
                        if (SwipeLayout.this.f().getTop() + i2 <= SwipeLayout.this.getPaddingTop() - SwipeLayout.this.f2354b) {
                            return SwipeLayout.this.getPaddingTop() - SwipeLayout.this.f2354b;
                        }
                    } else {
                        return SwipeLayout.this.getPaddingTop();
                    }
                } else if (SwipeLayout.this.f2356d == ShowMode.PullOut) {
                    if (i > SwipeLayout.this.getPaddingTop()) {
                        return SwipeLayout.this.getPaddingTop();
                    }
                } else if (SwipeLayout.this.f().getTop() + i2 >= SwipeLayout.this.getPaddingTop()) {
                    if (SwipeLayout.this.f().getTop() + i2 > SwipeLayout.this.getPaddingTop() + SwipeLayout.this.f2354b) {
                        return SwipeLayout.this.getPaddingTop() + SwipeLayout.this.f2354b;
                    }
                } else {
                    return SwipeLayout.this.getPaddingTop();
                }
            }
            return i;
        }

        @Override // androidx.customview.a.a.c
        public int a(View view) {
            return SwipeLayout.this.f2354b;
        }

        @Override // androidx.customview.a.a.c
        public void a(View view, float f, float f2) {
            super.a(view, f, f2);
            Iterator it2 = SwipeLayout.this.g.iterator();
            while (it2.hasNext()) {
                ((h) it2.next()).a(SwipeLayout.this, f, f2);
            }
            if (view == SwipeLayout.this.f()) {
                SwipeLayout.this.c(f, f2);
            } else if (view == SwipeLayout.this.b()) {
                if (SwipeLayout.this.e() == ShowMode.PullOut) {
                    SwipeLayout.this.b(f, f2);
                } else if (SwipeLayout.this.e() == ShowMode.LayDown) {
                    SwipeLayout.this.a(f, f2);
                }
            }
            SwipeLayout.this.invalidate();
        }

        @Override // androidx.customview.a.a.c
        public boolean b(View view, int i) {
            return view == SwipeLayout.this.f() || view == SwipeLayout.this.b();
        }

        @Override // androidx.customview.a.a.c
        public int b(View view) {
            return SwipeLayout.this.f2354b;
        }

        @Override // androidx.customview.a.a.c
        public void a(View view, int i, int i2, int i3, int i4) {
            int left = SwipeLayout.this.f().getLeft();
            int right = SwipeLayout.this.f().getRight();
            int top = SwipeLayout.this.f().getTop();
            int bottom = SwipeLayout.this.f().getBottom();
            if (view == SwipeLayout.this.f()) {
                if (SwipeLayout.this.f2356d == ShowMode.PullOut) {
                    if (SwipeLayout.this.f2355c != DragEdge.Left && SwipeLayout.this.f2355c != DragEdge.Right) {
                        SwipeLayout.this.b().offsetTopAndBottom(i4);
                    } else {
                        SwipeLayout.this.b().offsetLeftAndRight(i3);
                    }
                }
            } else if (view == SwipeLayout.this.b()) {
                if (SwipeLayout.this.f2356d == ShowMode.PullOut) {
                    SwipeLayout.this.f().offsetLeftAndRight(i3);
                    SwipeLayout.this.f().offsetTopAndBottom(i4);
                } else {
                    SwipeLayout swipeLayout = SwipeLayout.this;
                    Rect a2 = swipeLayout.a(swipeLayout.f2355c);
                    SwipeLayout.this.b().layout(a2.left, a2.top, a2.right, a2.bottom);
                    int left2 = SwipeLayout.this.f().getLeft() + i3;
                    int top2 = SwipeLayout.this.f().getTop() + i4;
                    if (SwipeLayout.this.f2355c == DragEdge.Left && left2 < SwipeLayout.this.getPaddingLeft()) {
                        left2 = SwipeLayout.this.getPaddingLeft();
                    } else if (SwipeLayout.this.f2355c == DragEdge.Right && left2 > SwipeLayout.this.getPaddingLeft()) {
                        left2 = SwipeLayout.this.getPaddingLeft();
                    } else if (SwipeLayout.this.f2355c == DragEdge.Top && top2 < SwipeLayout.this.getPaddingTop()) {
                        top2 = SwipeLayout.this.getPaddingTop();
                    } else if (SwipeLayout.this.f2355c == DragEdge.Bottom && top2 > SwipeLayout.this.getPaddingTop()) {
                        top2 = SwipeLayout.this.getPaddingTop();
                    }
                    SwipeLayout.this.f().layout(left2, top2, SwipeLayout.this.getMeasuredWidth() + left2, SwipeLayout.this.getMeasuredHeight() + top2);
                }
            }
            SwipeLayout.this.a(left, top, right, bottom);
            SwipeLayout.this.b(left, top, i3, i4);
            SwipeLayout.this.invalidate();
        }
    }

    protected void a(int i, int i2, boolean z) {
        m();
        Status d2 = d();
        if (this.g.isEmpty()) {
            return;
        }
        this.n++;
        for (h hVar : this.g) {
            if (this.n == 1) {
                if (z) {
                    hVar.a(this);
                } else {
                    hVar.b(this);
                }
            }
            hVar.a(this, i - getPaddingLeft(), i2 - getPaddingTop());
        }
        if (d2 == Status.Close) {
            Iterator<h> it2 = this.g.iterator();
            while (it2.hasNext()) {
                it2.next().d(this);
            }
            this.n = 0;
        }
        if (d2 == Status.Open) {
            b().setEnabled(true);
            Iterator<h> it3 = this.g.iterator();
            while (it3.hasNext()) {
                it3.next().c(this);
            }
            this.n = 0;
        }
    }

    public void b(boolean z, boolean z2) {
        ViewGroup f2 = f();
        ViewGroup b2 = b();
        Rect a2 = a(true);
        if (z) {
            this.f2353a.b(f(), a2.left, a2.top);
        } else {
            int left = a2.left - f2.getLeft();
            int top = a2.top - f2.getTop();
            f2.layout(a2.left, a2.top, a2.right, a2.bottom);
            ShowMode e2 = e();
            ShowMode showMode = ShowMode.PullOut;
            if (e2 == showMode) {
                Rect a3 = a(showMode, a2);
                b2.layout(a3.left, a3.top, a3.right, a3.bottom);
            }
            if (z2) {
                a(a2.left, a2.top, a2.right, a2.bottom);
                b(a2.left, a2.top, left, top);
            } else {
                m();
            }
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void a(int r16, int r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.daimajia.swipe.SwipeLayout.a(int, int, int, int):void");
    }

    private View a(ViewGroup viewGroup, MotionEvent motionEvent) {
        if (viewGroup == null) {
            return null;
        }
        if (viewGroup.onTouchEvent(motionEvent)) {
            return viewGroup;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                View a2 = a((ViewGroup) childAt, motionEvent);
                if (a2 != null) {
                    return a2;
                }
            } else if (a(viewGroup.getChildAt(childCount), motionEvent)) {
                return viewGroup.getChildAt(childCount);
            }
        }
        return null;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (motionEvent.getRawX() <= i || motionEvent.getRawX() >= i + view.getWidth() || motionEvent.getRawY() <= i2 || motionEvent.getRawY() >= i2 + view.getHeight()) {
            return false;
        }
        return view.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent) {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof AdapterView) {
                AdapterView adapterView = (AdapterView) parent;
                int positionForView = adapterView.getPositionForView(this);
                if (positionForView != -1 && adapterView.performItemClick(adapterView.getChildAt(positionForView - adapterView.getFirstVisiblePosition()), positionForView, adapterView.getAdapter().getItemId(positionForView))) {
                    return;
                }
            } else if ((parent instanceof View) && ((View) parent).performClick()) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2, float f3) {
        if (f2 == 0.0f && d() == Status.Middle) {
            a();
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (f2 < 0.0f && this.f2355c == DragEdge.Right) {
            paddingLeft -= this.f2354b;
        }
        if (f2 > 0.0f && this.f2355c == DragEdge.Left) {
            paddingLeft += this.f2354b;
        }
        if (f3 > 0.0f && this.f2355c == DragEdge.Top) {
            paddingTop += this.f2354b;
        }
        if (f3 < 0.0f && this.f2355c == DragEdge.Bottom) {
            paddingTop -= this.f2354b;
        }
        this.f2353a.b(f(), paddingLeft, paddingTop);
        invalidate();
    }

    public void a() {
        a(true, true);
    }

    public void a(boolean z, boolean z2) {
        ViewGroup f2 = f();
        if (z) {
            this.f2353a.b(f(), getPaddingLeft(), getPaddingTop());
        } else {
            Rect a2 = a(false);
            int left = a2.left - f2.getLeft();
            int top = a2.top - f2.getTop();
            f2.layout(a2.left, a2.top, a2.right, a2.bottom);
            if (z2) {
                a(a2.left, a2.top, a2.right, a2.bottom);
                b(a2.left, a2.top, left, top);
            } else {
                m();
            }
        }
        invalidate();
    }

    private Rect a(boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (z) {
            DragEdge dragEdge = this.f2355c;
            if (dragEdge == DragEdge.Left) {
                paddingLeft = this.f2354b + getPaddingLeft();
            } else if (dragEdge == DragEdge.Right) {
                paddingLeft = getPaddingLeft() - this.f2354b;
            } else if (dragEdge == DragEdge.Top) {
                paddingTop = this.f2354b + getPaddingTop();
            } else {
                paddingTop = getPaddingTop() - this.f2354b;
            }
        }
        return new Rect(paddingLeft, paddingTop, getMeasuredWidth() + paddingLeft, getMeasuredHeight() + paddingTop);
    }

    private Rect a(ShowMode showMode, Rect rect) {
        int i;
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        if (showMode == ShowMode.PullOut) {
            DragEdge dragEdge = this.f2355c;
            if (dragEdge == DragEdge.Left) {
                i2 -= this.f2354b;
            } else if (dragEdge == DragEdge.Right) {
                i2 = i4;
            } else {
                i3 = dragEdge == DragEdge.Top ? i3 - this.f2354b : i5;
            }
            DragEdge dragEdge2 = this.f2355c;
            if (dragEdge2 != DragEdge.Left && dragEdge2 != DragEdge.Right) {
                i5 = i3 + b().getMeasuredHeight();
                i4 = rect.right;
            } else {
                i5 = rect.bottom;
                i = b().getMeasuredWidth();
                i4 = i2 + i;
            }
        } else if (showMode == ShowMode.LayDown) {
            DragEdge dragEdge3 = this.f2355c;
            if (dragEdge3 == DragEdge.Left) {
                i = this.f2354b;
                i4 = i2 + i;
            } else if (dragEdge3 == DragEdge.Right) {
                i2 = i4 - this.f2354b;
            } else if (dragEdge3 == DragEdge.Top) {
                i5 = i3 + this.f2354b;
            } else {
                i3 = i5 - this.f2354b;
            }
        }
        return new Rect(i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect a(DragEdge dragEdge) {
        int i;
        int measuredHeight;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (dragEdge == DragEdge.Right) {
            paddingLeft = getMeasuredWidth() - this.f2354b;
        } else if (dragEdge == DragEdge.Bottom) {
            paddingTop = getMeasuredHeight() - this.f2354b;
        }
        if (dragEdge != DragEdge.Left && dragEdge != DragEdge.Right) {
            i = getMeasuredWidth() + paddingLeft;
            measuredHeight = this.f2354b;
        } else {
            i = this.f2354b + paddingLeft;
            measuredHeight = getMeasuredHeight();
        }
        return new Rect(paddingLeft, paddingTop, i, measuredHeight + paddingTop);
    }

    private int a(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
