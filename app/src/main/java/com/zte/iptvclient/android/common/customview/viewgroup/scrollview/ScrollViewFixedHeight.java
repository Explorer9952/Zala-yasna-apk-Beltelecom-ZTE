package com.zte.iptvclient.android.common.customview.viewgroup.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;

/* loaded from: classes.dex */
public class ScrollViewFixedHeight extends ScrollView {
    public ScrollViewFixedHeight(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private int a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        float a2 = a(getContext()) * 0.4f;
        if (mode == 1073741824 && size > a2) {
            size = (int) a2;
        }
        if (mode == 0 && size > a2) {
            size = (int) a2;
        }
        if (mode == Integer.MIN_VALUE && size > a2) {
            size = (int) a2;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public ScrollViewFixedHeight(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScrollViewFixedHeight(Context context) {
        super(context);
    }
}
