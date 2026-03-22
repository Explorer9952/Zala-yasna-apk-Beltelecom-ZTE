package com.zte.iptvclient.android.common.customview.viewgroup.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.log.LogEx;

/* compiled from: GridViewItemSpacingDecoration.java */
/* loaded from: classes.dex */
public final class c extends RecyclerView.n {
    private static String g = "GridViewItemSpacingDecoration";

    /* renamed from: a, reason: collision with root package name */
    private int f4387a;

    /* renamed from: b, reason: collision with root package name */
    private int f4388b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4389c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f4390d;
    private Drawable e;
    private int f = 2;

    public c(int i, int i2, boolean z) {
        this.f4387a = i;
        this.f4388b = i2;
        this.f4389c = z;
    }

    private void c(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (layoutParams != null) {
                int left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                int right = childAt.getRight() - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int i2 = this.f + bottom;
                Drawable drawable = this.e;
                if (drawable != null) {
                    drawable.setBounds(left, bottom, right, i2);
                    this.e.draw(canvas);
                }
                Paint paint = this.f4390d;
                if (paint != null) {
                    canvas.drawRect(left, bottom, right, i2, paint);
                }
            }
        }
    }

    private void d(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (layoutParams != null) {
                int top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + this.f;
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int i2 = this.f + right;
                Drawable drawable = this.e;
                if (drawable != null) {
                    drawable.setBounds(right, top, i2, bottom);
                    this.e.draw(canvas);
                }
                Paint paint = this.f4390d;
                if (paint != null) {
                    canvas.drawRect(right, top, i2, bottom, paint);
                }
            }
        }
    }

    public void a(int i, int i2) {
        this.f = i;
        Paint paint = new Paint(1);
        this.f4390d = paint;
        paint.setColor(i2);
        this.f4390d.setStyle(Paint.Style.FILL);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        c(canvas, recyclerView);
        d(canvas, recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        int e = recyclerView.e(view);
        int i = this.f4387a;
        int i2 = e % i;
        if (this.f4389c) {
            int i3 = this.f4388b;
            rect.left = i3 - ((i2 * i3) / i);
            rect.right = ((i2 + 1) * i3) / i;
            rect.top = i3;
        } else {
            int i4 = this.f4388b;
            rect.left = (i2 * i4) / i;
            rect.right = i4 - (((i2 + 1) * i4) / i);
        }
        LogEx.d(g, " position = " + e);
    }
}
