package com.zte.iptvclient.android.common.customview.headview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class ShapeImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    int f4328a;

    /* renamed from: b, reason: collision with root package name */
    int f4329b;

    /* renamed from: c, reason: collision with root package name */
    int f4330c;

    public ShapeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4330c = 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i = this.f4328a;
        int i2 = this.f4330c;
        if (i > i2 && this.f4329b > i2) {
            Path path = new Path();
            path.moveTo(this.f4330c, 0.0f);
            path.lineTo(this.f4328a - this.f4330c, 0.0f);
            int i3 = this.f4328a;
            path.quadTo(i3, 0.0f, i3, this.f4330c);
            path.lineTo(this.f4328a, this.f4329b - this.f4330c);
            int i4 = this.f4328a;
            int i5 = this.f4329b;
            path.quadTo(i4, i5, i4 - this.f4330c, i5);
            path.lineTo(this.f4330c, this.f4329b);
            path.quadTo(0.0f, this.f4329b, 0.0f, r1 - this.f4330c);
            path.lineTo(0.0f, this.f4330c);
            path.quadTo(0.0f, 0.0f, this.f4330c, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f4328a = getWidth();
        this.f4329b = getHeight();
    }

    public ShapeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4330c = 0;
    }
}
