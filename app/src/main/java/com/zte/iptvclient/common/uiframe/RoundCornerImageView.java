package com.zte.iptvclient.common.uiframe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class RoundCornerImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Paint f7889a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f7890b;

    /* renamed from: c, reason: collision with root package name */
    private int f7891c;

    /* renamed from: d, reason: collision with root package name */
    private int f7892d;
    private boolean e;

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7891c = 5;
        this.f7892d = 5;
        this.e = true;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            float f = context.getResources().getDisplayMetrics().density;
            this.f7891c = (int) (this.f7891c * f);
            this.f7892d = (int) (this.f7892d * f);
        }
        Paint paint = new Paint(1);
        this.f7889a = paint;
        paint.setAntiAlias(true);
        this.f7889a.setFilterBitmap(true);
        this.f7889a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint(1);
        this.f7890b = paint2;
        paint2.setAntiAlias(true);
        this.f7890b.setFilterBitmap(true);
        this.f7890b.setXfermode(null);
    }

    private void b(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, this.f7892d);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.f7891c, 0.0f);
        path.arcTo(new RectF(0.0f, 0.0f, this.f7891c * 2, this.f7892d * 2), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.f7889a);
    }

    private void c(Canvas canvas) {
        Path path = new Path();
        path.moveTo(getWidth() - this.f7891c, getHeight());
        path.lineTo(getWidth(), getHeight());
        path.lineTo(getWidth(), getHeight() - this.f7892d);
        path.arcTo(new RectF(getWidth() - (this.f7891c * 2), getHeight() - (this.f7892d * 2), getWidth(), getHeight()), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f7889a);
    }

    private void d(Canvas canvas) {
        Path path = new Path();
        path.moveTo(getWidth(), this.f7892d);
        path.lineTo(getWidth(), 0.0f);
        path.lineTo(getWidth() - this.f7891c, 0.0f);
        path.arcTo(new RectF(getWidth() - (this.f7891c * 2), 0.0f, getWidth(), (this.f7892d * 2) + 0), -90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f7889a);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.e) {
            super.draw(canvas);
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        super.draw(canvas2);
        b(canvas2);
        d(canvas2);
        a(canvas2);
        c(canvas2);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.f7890b);
        createBitmap.recycle();
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7891c = 5;
        this.f7892d = 5;
        this.e = true;
        a(context, attributeSet);
    }

    private void a(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, getHeight() - this.f7892d);
        path.lineTo(0.0f, getHeight());
        path.lineTo(this.f7891c, getHeight());
        path.arcTo(new RectF(0.0f, getHeight() - (this.f7892d * 2), (this.f7891c * 2) + 0, getHeight()), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f7889a);
    }
}
