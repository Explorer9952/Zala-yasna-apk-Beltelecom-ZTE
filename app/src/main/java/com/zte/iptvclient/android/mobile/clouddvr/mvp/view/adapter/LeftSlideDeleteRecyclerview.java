package com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class LeftSlideDeleteRecyclerview extends RecyclerView {
    private static final String X0 = LeftSlideDeleteRecyclerview.class.getName();
    private VelocityTracker L0;
    private int M0;
    private Rect N0;
    private Scroller O0;
    private float P0;
    private float Q0;
    private float R0;
    private boolean S0;
    private boolean T0;
    private View U0;
    private int V0;
    private int W0;

    /* loaded from: classes.dex */
    public interface a {
        int a();

        Boolean b();

        View c();
    }

    public LeftSlideDeleteRecyclerview(Context context) {
        this(context, null);
    }

    private void N() {
        VelocityTracker velocityTracker = this.L0;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.L0.recycle();
            this.L0 = null;
        }
    }

    private void a(MotionEvent motionEvent) {
        if (this.L0 == null) {
            this.L0 = VelocityTracker.obtain();
        }
        this.L0.addMovement(motionEvent);
    }

    public void M() {
        View view = this.U0;
        if (view == null || view.getScrollX() == 0) {
            return;
        }
        this.U0.scrollTo(0, 0);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.O0.computeScrollOffset()) {
            this.U0.scrollTo(this.O0.getCurrX(), this.O0.getCurrY());
            invalidate();
        }
    }

    public int k(int i, int i2) {
        int G = ((LinearLayoutManager) t()).G();
        Rect rect = this.N0;
        if (rect == null) {
            rect = new Rect();
            this.N0 = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return G + childCount;
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006c, code lost:
    
        if (java.lang.Math.abs(r0 - r7.Q0) > java.lang.Math.abs(r1 - r7.R0)) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.S0 && this.V0 != -1 && !this.T0) {
            float x = motionEvent.getX();
            a(motionEvent);
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2 && this.W0 != -1) {
                    float f = this.P0 - x;
                    if (this.U0.getScrollX() + f <= this.W0 && this.U0.getScrollX() + f > 0.0f) {
                        this.U0.scrollBy((int) f, 0);
                    }
                    this.P0 = x;
                }
            } else {
                if (this.W0 != -1) {
                    int scrollX = this.U0.getScrollX();
                    this.L0.computeCurrentVelocity(1000);
                    if (this.L0.getXVelocity() < -600.0f) {
                        Scroller scroller = this.O0;
                        int i = this.W0;
                        scroller.startScroll(scrollX, 0, i - scrollX, 0, Math.abs(i - scrollX));
                    } else if (this.L0.getXVelocity() >= 600.0f) {
                        this.O0.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX));
                    } else {
                        int i2 = this.W0;
                        if (scrollX >= i2 / 2) {
                            this.O0.startScroll(scrollX, 0, i2 - scrollX, 0, Math.abs(i2 - scrollX));
                        } else {
                            this.O0.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX));
                        }
                    }
                    invalidate();
                }
                this.W0 = -1;
                this.S0 = false;
                this.V0 = -1;
                N();
            }
            return true;
        }
        M();
        N();
        return super.onTouchEvent(motionEvent);
    }

    public LeftSlideDeleteRecyclerview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LeftSlideDeleteRecyclerview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.M0 = ViewConfiguration.get(context).getScaledTouchSlop();
        this.O0 = new Scroller(context);
    }
}
