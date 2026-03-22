package com.zte.iptvclient.android.common.customview.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public class CustomViewPage extends ViewPager {
    private int l0;

    public CustomViewPage(Context context) {
        super(context);
        this.l0 = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public void a(int i, float f, int i2) {
        int i3 = this.l0;
        if (i3 == i) {
            if (f >= 0.5f) {
                super.a(i, f, i2);
            }
        } else if (i3 > i && f <= 0.5f) {
            super.a(i, f, i2);
        }
        super.a(i, f, i2);
    }

    public CustomViewPage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l0 = 0;
    }
}
