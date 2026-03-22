package com.zte.iptvclient.android.common.customview.viewgroup.scrollview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/* loaded from: classes.dex */
public class ScrollViewEx extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    private int f4437a;

    /* renamed from: b, reason: collision with root package name */
    private int f4438b;

    public ScrollViewEx(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4438b = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.widget.ScrollView
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && Math.abs(((int) motionEvent.getRawY()) - this.f4437a) > this.f4438b) {
                return true;
            }
        } else {
            this.f4437a = (int) motionEvent.getRawY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public ScrollViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4438b = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public ScrollViewEx(Context context) {
        super(context);
        this.f4438b = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
