package com.zte.iptvclient.android.common.customview.view.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.ahmobile.android.tvclient.R$styleable;

/* loaded from: classes.dex */
public class RoundImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private int f4361a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4362b;

    /* renamed from: c, reason: collision with root package name */
    private int f4363c;

    /* renamed from: d, reason: collision with root package name */
    private int f4364d;
    private int e;
    private int f;
    private int g;

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4361a = 0;
        this.f4363c = -1;
        this.f4364d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.f4362b = context;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f4362b.obtainStyledAttributes(attributeSet, R$styleable.RoundedImageView);
        this.f4361a = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f4364d = obtainStyledAttributes.getColor(1, this.f4363c);
        this.e = obtainStyledAttributes.getColor(0, this.f4363c);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        Drawable drawable = getDrawable();
        if (drawable == null || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        measure(0, 0);
        if (drawable.getClass() == NinePatchDrawable.class) {
            return;
        }
        Bitmap copy = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
        if (this.f == 0) {
            this.f = getWidth();
        }
        if (this.g == 0) {
            this.g = getHeight();
        }
        int i2 = this.e;
        int i3 = this.f4363c;
        if (i2 != i3 && this.f4364d != i3) {
            int i4 = this.f;
            int i5 = this.g;
            if (i4 >= i5) {
                i4 = i5;
            }
            int i6 = this.f4361a;
            i = (i4 / 2) - (i6 * 2);
            a(canvas, (i6 / 2) + i, this.e);
            int i7 = this.f4361a;
            a(canvas, i + i7 + (i7 / 2), this.f4364d);
        } else {
            int i8 = this.e;
            int i9 = this.f4363c;
            if (i8 != i9 && this.f4364d == i9) {
                int i10 = this.f;
                int i11 = this.g;
                if (i10 >= i11) {
                    i10 = i11;
                }
                int i12 = this.f4361a;
                i = (i10 / 2) - i12;
                a(canvas, (i12 / 2) + i, this.e);
            } else {
                int i13 = this.e;
                int i14 = this.f4363c;
                if (i13 == i14 && this.f4364d != i14) {
                    int i15 = this.f;
                    int i16 = this.g;
                    if (i15 >= i16) {
                        i15 = i16;
                    }
                    int i17 = this.f4361a;
                    i = (i15 / 2) - i17;
                    a(canvas, (i17 / 2) + i, this.f4364d);
                } else {
                    int i18 = this.f;
                    int i19 = this.g;
                    if (i18 >= i19) {
                        i18 = i19;
                    }
                    i = i18 / 2;
                }
            }
        }
        if (copy != null) {
            canvas.drawBitmap(a(copy, i), (this.f / 2) - i, (this.g / 2) - i, (Paint) null);
        }
    }

    public Bitmap a(Bitmap bitmap, int i) {
        int i2 = i * 2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height > width) {
            bitmap = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
        } else if (height < width) {
            bitmap = Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height);
        }
        if (bitmap.getWidth() != i2 || bitmap.getHeight() != i2) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i2, i2, true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4361a = 0;
        this.f4363c = -1;
        this.f4364d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.f4362b = context;
        a(attributeSet);
    }

    private void a(Canvas canvas, int i, int i2) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setColor(i2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f4361a);
        canvas.drawCircle(this.f / 2, this.g / 2, i, paint);
    }
}
