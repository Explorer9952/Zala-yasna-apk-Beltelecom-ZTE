package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.a.d;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.h;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.e.a;
import com.scwang.smartrefresh.layout.footer.ballpulse.BallPulseView;

/* loaded from: classes.dex */
public class BallPulseFooter extends ViewGroup implements d {

    /* renamed from: a, reason: collision with root package name */
    private BallPulseView f2755a;

    /* renamed from: b, reason: collision with root package name */
    private SpinnerStyle f2756b;

    public BallPulseFooter(Context context) {
        super(context);
        this.f2756b = SpinnerStyle.Translate;
        a(context, (AttributeSet) null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        BallPulseView ballPulseView = new BallPulseView(context);
        this.f2755a = ballPulseView;
        addView(ballPulseView, -2, -2);
        setMinimumHeight(a.b(60.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BallPulseFooter);
        int color = obtainStyledAttributes.getColor(R$styleable.BallPulseFooter_srlPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(R$styleable.BallPulseFooter_srlAccentColor, 0);
        if (color != 0) {
            this.f2755a.a(color);
        }
        if (color2 != 0) {
            this.f2755a.c(color);
        }
        this.f2756b = SpinnerStyle.values()[obtainStyledAttributes.getInt(R$styleable.BallPulseFooter_srlClassicsSpinnerStyle, this.f2756b.ordinal())];
        obtainStyledAttributes.recycle();
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public View a() {
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.d
    public void a(float f, int i, int i2, int i3) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(g gVar, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.d.e
    public void a(h hVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // com.scwang.smartrefresh.layout.a.d
    public boolean a(boolean z) {
        return false;
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public SpinnerStyle b() {
        return this.f2756b;
    }

    @Override // com.scwang.smartrefresh.layout.a.d
    public void b(float f, int i, int i2, int i3) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.f2755a.getMeasuredWidth();
        int measuredHeight2 = this.f2755a.getMeasuredHeight();
        int i5 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i6 = (measuredHeight / 2) - (measuredHeight2 / 2);
        this.f2755a.layout(i5, i6, measuredWidth2 + i5, measuredHeight2 + i6);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.f2755a.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Integer.MIN_VALUE));
        setMeasuredDimension(ViewGroup.resolveSize(this.f2755a.getMeasuredWidth(), i), ViewGroup.resolveSize(this.f2755a.getMeasuredHeight(), i2));
    }

    public BallPulseFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2756b = SpinnerStyle.Translate;
        a(context, attributeSet, 0);
    }

    public BallPulseFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2756b = SpinnerStyle.Translate;
        a(context, attributeSet, i);
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(h hVar, int i, int i2) {
        this.f2755a.a();
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public int a(h hVar, boolean z) {
        this.f2755a.b();
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(int... iArr) {
        if (iArr.length > 1) {
            this.f2755a.c(iArr[1]);
            this.f2755a.a(iArr[0]);
        } else if (iArr.length > 0) {
            this.f2755a.c(androidx.core.graphics.a.b(-1711276033, iArr[0]));
            this.f2755a.a(iArr[0]);
        }
    }
}
