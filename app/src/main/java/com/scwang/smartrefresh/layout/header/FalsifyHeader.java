package com.scwang.smartrefresh.layout.header;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.a.e;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.h;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.e.a;

/* loaded from: classes.dex */
public class FalsifyHeader extends View implements e {
    public FalsifyHeader(Context context) {
        super(context);
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public int a(h hVar, boolean z) {
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public View a() {
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(g gVar, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(h hVar, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.d.e
    public void a(h hVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(int... iArr) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public SpinnerStyle b() {
        return SpinnerStyle.Scale;
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void c(float f, int i, int i2, int i3) {
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void d(float f, int i, int i2, int i3) {
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            int b2 = a.b(5.0f);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(1157627903);
            paint.setStrokeWidth(a.b(1.0f));
            float f = b2;
            paint.setPathEffect(new DashPathEffect(new float[]{f, f, f, f}, 1.0f));
            canvas.drawRect(f, f, getWidth() - b2, getBottom() - b2, paint);
            TextView textView = new TextView(getContext());
            textView.setText(FalsifyHeader.class.getSimpleName() + " 虚假区域\n运行时代表下拉Header的高度【" + a.c(getHeight()) + "dp】\n而不会显示任何东西");
            textView.setTextColor(1157627903);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
