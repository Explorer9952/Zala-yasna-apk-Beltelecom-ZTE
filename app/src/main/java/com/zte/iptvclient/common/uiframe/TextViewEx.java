package com.zte.iptvclient.common.uiframe;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes2.dex */
public class TextViewEx extends TextView {
    public TextViewEx(Context context) {
        super(context);
    }

    public void a(boolean z) {
        a(z, -1);
    }

    public TextViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(boolean z, int i) {
        if (z) {
            setEllipsize(TextUtils.TruncateAt.MARQUEE);
            setMarqueeRepeatLimit(i);
            setSingleLine(true);
            setFocusable(true);
            setSelected(true);
            return;
        }
        setFocusable(false);
    }

    public TextViewEx(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
