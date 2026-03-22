package com.zte.iptvclient.android.common.customview.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.e.a0;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public class SlideViewPager extends ViewPager {
    private int l0;
    private boolean m0;
    float n0;
    float o0;

    public SlideViewPager(Context context) {
        super(context);
        this.m0 = true;
        h();
    }

    private void h() {
        this.l0 = a0.b(ViewConfiguration.get(getContext()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (c() == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 1) {
                getParent().requestDisallowInterceptTouchEvent(false);
            } else if (action == 2) {
                float abs = Math.abs(x - this.o0);
                float abs2 = Math.abs(y - this.o0);
                if (abs > 0.0f && x - this.n0 < 0.0f && 0.5f * abs > abs2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    int i = this.l0;
                    if (abs2 > i && abs < i) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            }
            this.n0 = x;
            this.o0 = y;
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.m0 && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.m0 && super.onTouchEvent(motionEvent);
    }

    public SlideViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m0 = true;
        h();
    }
}
