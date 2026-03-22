package com.zte.iptvclient.android.common.customview.viewgroup.gridview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.zte.fragmentlib.publicbaseclass.skinloader.b;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.zala.R;

/* loaded from: classes.dex */
public class LineGridView extends ScrollGridView {

    /* renamed from: a, reason: collision with root package name */
    private Context f4393a;

    /* renamed from: b, reason: collision with root package name */
    private int f4394b;

    public LineGridView(Context context) {
        super(context);
        this.f4394b = -1;
        this.f4393a = context;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int i = 0;
        View childAt = getChildAt(0);
        if (getWidth() == 0 || getChildAt(0) == null) {
            return;
        }
        int width = getWidth() / childAt.getWidth();
        int childCount = getChildCount();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        int i2 = this.f4394b;
        if (i2 != -1) {
            paint.setColor(i2);
        } else if (TextUtils.equals(b.f4075b, "black.skin")) {
            paint.setColor(Color.parseColor("#282832"));
        } else {
            paint.setColor(getResources().getColor(R.color.search_history_tab_bg));
        }
        if (BaseApp.a(this.f4393a)) {
            return;
        }
        while (i < childCount) {
            View childAt2 = getChildAt(i);
            i++;
            if (i % width == 0) {
                canvas.drawLine(childAt2.getLeft(), childAt2.getTop(), childAt2.getRight(), childAt2.getTop(), paint);
            } else if (i > childCount - (childCount % width)) {
                canvas.drawLine(childAt2.getLeft(), childAt2.getTop(), childAt2.getRight(), childAt2.getTop(), paint);
            } else {
                canvas.drawLine(childAt2.getLeft(), childAt2.getTop(), childAt2.getRight(), childAt2.getTop(), paint);
                canvas.drawLine(childAt2.getLeft(), childAt2.getTop(), childAt2.getRight(), childAt2.getTop(), paint);
            }
        }
    }

    public LineGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4394b = -1;
        this.f4393a = context;
    }

    public LineGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4394b = -1;
        this.f4393a = context;
    }
}
