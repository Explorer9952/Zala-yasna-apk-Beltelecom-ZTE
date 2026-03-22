package com.zte.iptvclient.android.common.customview.edittext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

/* loaded from: classes.dex */
public class DividerEditText extends EditText {

    /* renamed from: a, reason: collision with root package name */
    private Rect f4326a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f4327b;

    public DividerEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.f4326a = new Rect();
        Paint paint = new Paint();
        this.f4327b = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f4327b.setColor(-1);
        this.f4327b.setStrokeWidth(3.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int lineCount = getLineCount();
        Rect rect = this.f4326a;
        Paint paint = this.f4327b;
        for (int i = 0; i < lineCount - 1; i++) {
            float lineBounds = getLineBounds(i, rect) + 1;
            canvas.drawLine(rect.left, lineBounds, rect.right, lineBounds, paint);
        }
    }

    public DividerEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
