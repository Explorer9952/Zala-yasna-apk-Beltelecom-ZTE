package com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class SlideRelativeLayout extends RelativeLayout {
    public SlideRelativeLayout(Context context) {
        super(context);
        a();
    }

    private void a() {
        ViewConfiguration.get(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    public SlideRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
