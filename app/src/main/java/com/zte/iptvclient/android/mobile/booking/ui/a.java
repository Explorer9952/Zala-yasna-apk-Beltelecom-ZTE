package com.zte.iptvclient.android.mobile.booking.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zte.fragmentlib.publicbaseclass.skinloader.b;
import com.zte.iptvclient.android.zala.R;
import java.util.Map;

/* compiled from: FloatingBarItemDecoration.java */
/* loaded from: classes.dex */
public class a extends RecyclerView.n {

    /* renamed from: a, reason: collision with root package name */
    private Context f5583a;

    /* renamed from: b, reason: collision with root package name */
    private int f5584b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f5585c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f5586d;
    private int e;
    private int f;
    private int g;
    private Map<Integer, String> h;

    public a(Context context, Map<Integer, String> map) {
        this.f5583a = context;
        Resources resources = context.getResources();
        this.h = map;
        this.f5584b = resources.getDimensionPixelSize(R.dimen.item_decoration_title_height);
        this.f5585c = new Paint();
        this.f5586d = new Paint();
        if (TextUtils.equals(b.f4075b, "black.skin")) {
            this.f5585c.setColor(androidx.core.content.a.a(this.f5583a, R.color.item_decoration_title_dark_background));
            this.f5586d.setColor(androidx.core.content.a.a(this.f5583a, R.color.item_decoration_title_dark_fontcolor));
        } else {
            this.f5585c.setColor(androidx.core.content.a.a(this.f5583a, R.color.item_decoration_title_background));
            this.f5586d.setColor(androidx.core.content.a.a(this.f5583a, R.color.item_decoration_title_fontcolor));
        }
        this.f5586d.setTextSize(this.f5583a.getResources().getDimensionPixelSize(R.dimen.item_decoration_title_fontsize));
        Paint.FontMetrics fontMetrics = this.f5586d.getFontMetrics();
        float f = fontMetrics.bottom;
        this.e = (int) (f - fontMetrics.top);
        this.f = (int) f;
        this.g = resources.getDimensionPixelOffset(R.dimen.item_decoration_title_start_margin);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        super.a(rect, view, recyclerView, yVar);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (layoutParams != null) {
            rect.set(0, this.h.containsKey(Integer.valueOf(layoutParams.a())) ? this.f5584b : 0, 0, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        super.b(canvas, recyclerView, yVar);
        int G = ((LinearLayoutManager) recyclerView.t()).G();
        if (G == -1 || recyclerView.d(G) == null) {
            return;
        }
        View view = recyclerView.d(G).f1492a;
        String a2 = a(G);
        if (a2 == null) {
            return;
        }
        boolean z = false;
        int i = G + 1;
        if (a(i) != null && !a2.equals(a(i)) && view.getHeight() + view.getTop() < this.f5584b) {
            canvas.save();
            canvas.translate(0.0f, (view.getHeight() + view.getTop()) - this.f5584b);
            z = true;
        }
        canvas.drawRect(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getRight() - recyclerView.getPaddingRight(), recyclerView.getPaddingTop() + this.f5584b, this.f5585c);
        float paddingLeft = view.getPaddingLeft() + this.g;
        int paddingTop = recyclerView.getPaddingTop();
        int i2 = this.f5584b;
        canvas.drawText(a2, paddingLeft, ((paddingTop + i2) - ((i2 - this.e) / 2)) - this.f, this.f5586d);
        if (z) {
            canvas.restore();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        super.a(canvas, recyclerView, yVar);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (layoutParams != null) {
                int a2 = layoutParams.a();
                if (this.h.containsKey(Integer.valueOf(a2))) {
                    a(canvas, paddingLeft, width, childAt, layoutParams, a2);
                }
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, View view, RecyclerView.LayoutParams layoutParams, int i3) {
        canvas.drawRect(i, r0 - this.f5584b, i2, view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, this.f5585c);
        canvas.drawText(this.h.get(Integer.valueOf(i3)), view.getPaddingLeft() + this.g, (r0 - ((this.f5584b - this.e) / 2)) - this.f, this.f5586d);
    }

    private String a(int i) {
        while (i >= 0) {
            if (this.h.containsKey(Integer.valueOf(i))) {
                return this.h.get(Integer.valueOf(i));
            }
            i--;
        }
        return null;
    }
}
