package com.zte.iptvclient.android.common.customview.view.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public abstract class MaskedImage extends ImageView {

    /* renamed from: c, reason: collision with root package name */
    private static final Xfermode f4358c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f4359a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f4360b;

    public MaskedImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public abstract Bitmap a();

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        try {
            if (this.f4360b == null) {
                Paint paint = new Paint();
                this.f4360b = paint;
                paint.setFilterBitmap(false);
                this.f4360b.setXfermode(f4358c);
            }
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            drawable.setBounds(0, 0, getWidth(), getHeight());
            drawable.draw(canvas);
            if (this.f4359a == null || this.f4359a.isRecycled()) {
                this.f4359a = a();
            }
            canvas.drawBitmap(this.f4359a, 0.0f, 0.0f, this.f4360b);
            canvas.restoreToCount(saveLayer);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Attempting to draw with recycled bitmap. View ID = ");
            System.out.println("localStringBuilder==" + ((Object) sb));
        }
    }

    public MaskedImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
