package com.zte.iptvclient.android.common.customview.viewgroup.layout.linearlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.Scroller;

/* loaded from: classes.dex */
public class ScrollLinerLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Scroller f4411a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4412b;

    public ScrollLinerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4412b = true;
        a(context);
    }

    private void a(Context context) {
        this.f4411a = new Scroller(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f4411a.computeScrollOffset()) {
            scrollTo(this.f4411a.getCurrX(), 0);
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        boolean z2 = this.f4412b;
        if (z2) {
            super.setPressed(z);
        } else {
            super.setPressed(z2);
        }
    }

    public void a() {
        if (this.f4411a.isFinished()) {
            return;
        }
        this.f4411a.abortAnimation();
    }

    public void a(boolean z) {
        this.f4412b = z;
    }

    public void a(int i) {
        this.f4411a.startScroll(i, 0, 0, 0, 50);
        invalidate();
    }
}
