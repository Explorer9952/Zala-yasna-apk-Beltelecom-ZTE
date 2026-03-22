package com.zte.iptvclient.android.common.customview.b.a;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: RecycleViewDivider.java */
/* loaded from: classes.dex */
public final class a extends RecyclerView.n {
    private static final int[] g = {R.attr.listDivider};

    /* renamed from: a, reason: collision with root package name */
    private Paint f4322a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f4323b;

    /* renamed from: c, reason: collision with root package name */
    private int f4324c;

    /* renamed from: d, reason: collision with root package name */
    private int f4325d;
    private int e;
    private int f;

    public a(Context context, int i) {
        this.f4324c = 2;
        this.e = 0;
        this.f = 0;
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("Error Attributes！");
        }
        this.f4325d = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(g);
        this.f4323b = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    private void c(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft() + this.e;
        int measuredWidth = (recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight()) - this.f;
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != childCount - 1) {
                View childAt = recyclerView.getChildAt(i);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null) {
                    int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    int i2 = this.f4324c + bottom;
                    Drawable drawable = this.f4323b;
                    if (drawable != null) {
                        drawable.setBounds(paddingLeft, bottom, measuredWidth, i2);
                        this.f4323b.draw(canvas);
                    }
                    Paint paint = this.f4322a;
                    if (paint != null) {
                        canvas.drawRect(paddingLeft, bottom, measuredWidth, i2, paint);
                    }
                }
            }
        }
    }

    private void d(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (layoutParams != null) {
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int i2 = this.f4324c + right;
                Drawable drawable = this.f4323b;
                if (drawable != null) {
                    drawable.setBounds(right, paddingTop, i2, measuredHeight);
                    this.f4323b.draw(canvas);
                }
                Paint paint = this.f4322a;
                if (paint != null) {
                    canvas.drawRect(right, paddingTop, i2, measuredHeight, paint);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        super.a(rect, view, recyclerView, yVar);
        rect.set(0, 0, 0, this.f4324c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        super.a(canvas, recyclerView, yVar);
        if (this.f4325d == 1) {
            d(canvas, recyclerView);
        } else {
            c(canvas, recyclerView);
        }
    }

    public a(Context context, int i, int i2, int i3, int i4) {
        this(context, i);
        this.e = i2;
        this.f = i3;
        Drawable c2 = androidx.core.content.a.c(context, i4);
        this.f4323b = c2;
        this.f4324c = c2.getIntrinsicHeight();
    }

    public a(Context context, int i, int i2, int i3) {
        this(context, i);
        this.f4324c = i2;
        Paint paint = new Paint(1);
        this.f4322a = paint;
        paint.setColor(i3);
        this.f4322a.setStyle(Paint.Style.FILL);
    }
}
