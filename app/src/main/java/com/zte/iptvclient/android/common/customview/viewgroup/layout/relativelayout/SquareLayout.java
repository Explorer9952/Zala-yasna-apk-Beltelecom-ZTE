package com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class SquareLayout extends RelativeLayout {
    public SquareLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(RelativeLayout.getDefaultSize(0, i), RelativeLayout.getDefaultSize(0, i2));
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() * 103) / 160, 1073741824));
    }

    public SquareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareLayout(Context context) {
        super(context);
    }
}
