package com.zte.iptvclient.android.mobile.tv.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;

/* loaded from: classes2.dex */
public class DragListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    private int f7270a;

    /* renamed from: b, reason: collision with root package name */
    private int f7271b;

    /* renamed from: c, reason: collision with root package name */
    private int f7272c;

    /* renamed from: d, reason: collision with root package name */
    private int f7273d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private b j;
    private boolean k;
    private Bitmap l;
    private View m;
    private int n;
    private long o;
    private boolean p;
    private Runnable q;
    private float r;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DragListView.this.p = false;
            if (DragListView.this.l != null) {
                DragListView.this.o = System.currentTimeMillis();
                DragListView dragListView = DragListView.this;
                dragListView.b((int) dragListView.r);
                DragListView.this.invalidate();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        Bitmap a(View view, Bitmap bitmap);

        void a(int i, int i2, View view, View view2);

        void a(int i, View view);

        void a(int i, View view, int i2, int i3, int i4);

        void a(View view);

        boolean a(int i, int i2);

        boolean a(View view, int i, int i2);
    }

    public DragListView(Context context) {
        this(context, null);
    }

    private void c(int i) {
        b bVar;
        int i2 = this.f7271b;
        int i3 = this.f7270a;
        if (i2 == i3 || (bVar = this.j) == null || !bVar.a(i3, i2)) {
            return;
        }
        View view = this.m;
        View childAt = getChildAt(this.f7271b - getFirstVisiblePosition());
        this.m = childAt;
        this.j.a(this.f7270a, this.f7271b, view, childAt);
        this.f7270a = this.f7271b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Bitmap bitmap = this.l;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.l, 0.0f, this.f - this.i, (Paint) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        if (r0 != 4) goto L48;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.tv.ui.DragListView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int a2 = a(getContext(), 80.0f);
        this.f7272c = a2;
        this.f7273d = i2 - a2;
    }

    public DragListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(int r9) {
        /*
            r8 = this;
            int r0 = r8.getWidth()
            int r0 = r0 / 2
            int r0 = r8.pointToPosition(r0, r9)
            r1 = -1
            if (r0 != r1) goto L11
            r8.a(r9)
            return
        L11:
            int r2 = r8.f7270a
            r3 = 1
            if (r2 <= r0) goto L18
            r2 = -1
            goto L19
        L18:
            r2 = 1
        L19:
            int r4 = r8.f7270a
        L1b:
            if (r2 <= 0) goto L20
            if (r4 > r0) goto L6e
            goto L22
        L20:
            if (r4 < r0) goto L6e
        L22:
            int r5 = r8.getFirstVisiblePosition()
            int r5 = r4 - r5
            int r6 = r8.getChildCount()
            if (r5 >= r6) goto L6c
            if (r5 >= 0) goto L31
            goto L6c
        L31:
            android.view.View r5 = r8.getChildAt(r5)
            int r5 = r5.getTop()
            r6 = 0
            int r7 = r8.pointToPosition(r6, r5)
            if (r7 == r1) goto L42
            r8.f7271b = r7
        L42:
            android.view.View r7 = r8.getChildAt(r6)
            int r7 = r7.getTop()
            if (r5 >= r7) goto L4f
            r8.f7271b = r6
            goto L69
        L4f:
            int r6 = r8.getChildCount()
            int r6 = r6 - r3
            android.view.View r6 = r8.getChildAt(r6)
            int r6 = r6.getBottom()
            if (r5 <= r6) goto L69
            android.widget.ListAdapter r6 = r8.getAdapter()
            int r6 = r6.getCount()
            int r6 = r6 - r3
            r8.f7271b = r6
        L69:
            r8.c(r5)
        L6c:
            int r4 = r4 + r2
            goto L1b
        L6e:
            r8.a(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.tv.ui.DragListView.b(int):void");
    }

    public DragListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = false;
        this.p = false;
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.n = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.q = new a();
    }

    public void a(int i) {
        int i2;
        View childAt;
        if (i < this.f7272c) {
            if (i <= this.h - this.n) {
                i2 = a(getContext(), 6.0f);
            }
            i2 = 0;
        } else {
            if (i > this.f7273d && i >= this.h + this.n) {
                i2 = -a(getContext(), 6.0f);
            }
            i2 = 0;
        }
        if (i2 == 0 || (childAt = getChildAt(this.f7271b - getFirstVisiblePosition())) == null) {
            return;
        }
        setSelectionFromTop(this.f7271b, childAt.getTop() + i2);
        if (this.p) {
            return;
        }
        this.p = true;
        long currentTimeMillis = System.currentTimeMillis() - this.o;
        postDelayed(this.q, currentTimeMillis <= 15 ? 15 - currentTimeMillis : 15L);
    }

    /* loaded from: classes2.dex */
    public static abstract class c implements b {
        @Override // com.zte.iptvclient.android.mobile.tv.ui.DragListView.b
        public void a(int i, View view, int i2, int i3, int i4) {
            view.setVisibility(0);
            if (Math.abs(i2 - view.getTop()) > view.getHeight() / 5) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                alphaAnimation.setDuration(150L);
                view.clearAnimation();
                view.startAnimation(alphaAnimation);
            }
        }

        @Override // com.zte.iptvclient.android.mobile.tv.ui.DragListView.b
        public void a(int i, View view) {
            if (view != null) {
                view.setVisibility(4);
            }
        }

        @Override // com.zte.iptvclient.android.mobile.tv.ui.DragListView.b
        public void a(int i, int i2, View view, View view2) {
            if (view != null) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i > i2 ? -view.getHeight() : view.getHeight(), 0.0f);
                translateAnimation.setDuration(200L);
                view.clearAnimation();
                view.startAnimation(translateAnimation);
                view.setVisibility(0);
            }
            if (view2 != null) {
                view2.setVisibility(4);
            }
        }
    }

    public void a() {
        Bitmap bitmap = this.l;
        if (bitmap != null) {
            bitmap.recycle();
            this.l = null;
            b bVar = this.j;
            if (bVar != null) {
                int i = this.f7271b;
                View view = this.m;
                int i2 = this.f;
                bVar.a(i, view, i2 - this.i, this.e, i2);
            }
        }
        if (this.m != null) {
            this.m = null;
        }
        this.p = false;
        removeCallbacks(this.q);
    }

    public void a(b bVar) {
        this.j = bVar;
    }

    public int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
