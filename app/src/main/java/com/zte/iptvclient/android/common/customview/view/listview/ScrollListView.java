package com.zte.iptvclient.android.common.customview.view.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* loaded from: classes.dex */
public class ScrollListView extends ListView {
    public ScrollListView(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public ScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
