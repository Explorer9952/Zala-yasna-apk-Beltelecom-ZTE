package com.zte.iptvclient.android.common.customview.viewgroup.gridview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* loaded from: classes.dex */
public class RecomeGridView extends GridView {
    public RecomeGridView(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public RecomeGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecomeGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
