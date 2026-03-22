package com.zte.iptvclient.android.mobile.home.ui.layout.linearLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.zte.iptvclient.android.zala.R;

/* loaded from: classes.dex */
public class FootNoMoreView extends LinearLayout {
    public FootNoMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.loaddata_no_more, this);
    }

    public FootNoMoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FootNoMoreView(Context context) {
        super(context);
        a(context);
    }
}
