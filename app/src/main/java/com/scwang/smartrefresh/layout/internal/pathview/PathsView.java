package com.scwang.smartrefresh.layout.internal.pathview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class PathsView extends View {

    /* renamed from: a, reason: collision with root package name */
    protected b f2806a;

    public PathsView(Context context) {
        super(context);
        this.f2806a = new b();
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.f2806a = new b();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2806a.draw(canvas);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getTag() instanceof String) {
            a(getTag().toString());
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f2806a.setBounds(getPaddingLeft(), getPaddingTop(), Math.max((i3 - i) - getPaddingRight(), getPaddingLeft()), Math.max((i4 - i2) - getPaddingTop(), getPaddingTop()));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(this.f2806a.e() + getPaddingLeft() + getPaddingRight(), i), View.resolveSize(this.f2806a.b() + getPaddingTop() + getPaddingBottom(), i2));
    }

    public void a(String... strArr) {
        this.f2806a.a(strArr);
    }

    public void a(int... iArr) {
        this.f2806a.a(iArr);
    }

    public PathsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2806a = new b();
        a(context, attributeSet, 0);
    }

    public PathsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2806a = new b();
        a(context, attributeSet, i);
    }
}
