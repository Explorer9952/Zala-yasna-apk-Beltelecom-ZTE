package com.zte.iptvclient.android.common.customview.viewgroup.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.zte.iptvclient.common.uiframe.f;

/* loaded from: classes.dex */
public class RecentHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f4436a;

    public RecentHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f4436a = linearLayout;
        addView(linearLayout);
        f.a(this.f4436a);
    }
}
