package com.zte.iptvclient.android.common.customview.view.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class CircularImage extends MaskedImage {
    public CircularImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.zte.iptvclient.android.common.customview.view.imageview.MaskedImage
    public Bitmap a() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        canvas.drawOval(new RectF(0.0f, 0.0f, getWidth(), getHeight()), paint);
        return createBitmap;
    }

    public CircularImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
