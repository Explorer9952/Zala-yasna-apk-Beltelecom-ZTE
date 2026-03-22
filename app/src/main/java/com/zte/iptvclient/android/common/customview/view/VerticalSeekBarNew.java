package com.zte.iptvclient.android.common.customview.view;

import android.R;
import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class VerticalSeekBarNew extends AbsVerticalSeekBar {
    private a B;

    /* loaded from: classes.dex */
    public interface a {
        void a(VerticalSeekBarNew verticalSeekBarNew);

        void a(VerticalSeekBarNew verticalSeekBarNew, int i, boolean z);

        void b(VerticalSeekBarNew verticalSeekBarNew);
    }

    public VerticalSeekBarNew(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.zte.iptvclient.android.common.customview.view.AbsVerticalSeekBar, com.zte.iptvclient.android.common.customview.view.VerticalProgressBar
    public void a(float f, boolean z) {
        super.a(f, z);
        a aVar = this.B;
        if (aVar != null) {
            aVar.a(this, d(), z);
        }
    }

    @Override // com.zte.iptvclient.android.common.customview.view.AbsVerticalSeekBar
    void h() {
        a aVar = this.B;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.zte.iptvclient.android.common.customview.view.AbsVerticalSeekBar
    void i() {
        a aVar = this.B;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public VerticalSeekBarNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    public VerticalSeekBarNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(a aVar) {
        this.B = aVar;
    }
}
