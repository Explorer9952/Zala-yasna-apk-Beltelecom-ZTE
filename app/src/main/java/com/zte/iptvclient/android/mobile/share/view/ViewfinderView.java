package com.zte.iptvclient.android.mobile.share.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.ahmobile.android.tvclient.R$styleable;
import com.google.zxing.ResultPoint;
import com.zte.iptvclient.android.mobile.share.camera.c;
import java.util.Collection;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class ViewfinderView extends View {
    public static int l = 0;
    public static int m = 0;

    /* renamed from: a, reason: collision with root package name */
    private final Paint f7223a;

    /* renamed from: b, reason: collision with root package name */
    private final int f7224b;

    /* renamed from: c, reason: collision with root package name */
    private final int f7225c;

    /* renamed from: d, reason: collision with root package name */
    private final int f7226d;
    private final int e;
    private final int f;
    private final String g;
    private final int h;
    private final float i;
    private Collection<ResultPoint> j;
    private Collection<ResultPoint> k;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewfinderView);
        this.f7226d = obtainStyledAttributes.getColor(5, 65280);
        this.e = obtainStyledAttributes.getColor(0, 65280);
        this.f7225c = obtainStyledAttributes.getColor(1, 16777215);
        this.f = obtainStyledAttributes.getColor(8, -1056964864);
        obtainStyledAttributes.getColor(6, 1610612736);
        this.f7224b = obtainStyledAttributes.getColor(7, -1342177280);
        this.h = obtainStyledAttributes.getColor(3, -1862270977);
        this.g = obtainStyledAttributes.getString(2);
        this.i = obtainStyledAttributes.getFloat(4, 36.0f);
        Paint paint = new Paint();
        this.f7223a = paint;
        paint.setAntiAlias(true);
        this.j = new HashSet(5);
        obtainStyledAttributes.recycle();
    }

    private void a(Canvas canvas, Rect rect) {
        this.f7223a.setColor(this.e);
        canvas.drawRect(rect.left, rect.top, r0 + 8, r1 + 40, this.f7223a);
        canvas.drawRect(rect.left, rect.top, r0 + 40, r1 + 8, this.f7223a);
        int i = rect.right;
        canvas.drawRect(i - 8, rect.top, i, r1 + 40, this.f7223a);
        int i2 = rect.right;
        canvas.drawRect(i2 - 40, rect.top, i2, r1 + 8, this.f7223a);
        canvas.drawRect(rect.left, r1 - 8, r0 + 40, rect.bottom, this.f7223a);
        canvas.drawRect(rect.left, r1 - 40, r0 + 8, rect.bottom, this.f7223a);
        canvas.drawRect(r0 - 8, r1 - 40, rect.right, rect.bottom, this.f7223a);
        canvas.drawRect(r0 - 40, r10 - 8, rect.right, rect.bottom, this.f7223a);
    }

    private void b(Canvas canvas, Rect rect) {
        this.f7223a.setColor(this.f7225c);
        canvas.drawRect(rect.left, rect.top, rect.right + 1, r0 + 2, this.f7223a);
        canvas.drawRect(rect.left, rect.top + 2, r0 + 2, rect.bottom - 1, this.f7223a);
        int i = rect.right;
        canvas.drawRect(i - 1, rect.top, i + 1, rect.bottom - 1, this.f7223a);
        float f = rect.left;
        int i2 = rect.bottom;
        canvas.drawRect(f, i2 - 1, rect.right + 1, i2 + 1, this.f7223a);
    }

    private void c(Canvas canvas, Rect rect) {
        this.f7223a.setColor(this.f7226d);
        float width = rect.left + (rect.width() / 2);
        float f = l + 5;
        int i = this.f7226d;
        this.f7223a.setShader(new RadialGradient(width, f, 360.0f, i, a(i), Shader.TileMode.MIRROR));
        if (l <= m) {
            canvas.drawOval(new RectF(rect.left + 20, l, rect.right - 20, r2 + 10), this.f7223a);
            l += 5;
        } else {
            l = rect.top;
        }
        this.f7223a.setShader(null);
    }

    private void d(Canvas canvas, Rect rect) {
        this.f7223a.setColor(this.h);
        this.f7223a.setTextSize(this.i);
        this.f7223a.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(this.g, rect.left + (rect.width() / 2), rect.top - 40, this.f7223a);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect b2 = c.f().b();
        if (b2 == null) {
            return;
        }
        if (l == 0 || m == 0) {
            l = b2.top;
            m = b2.bottom;
        }
        a(canvas, b2, canvas.getWidth(), canvas.getHeight());
        b(canvas, b2);
        a(canvas, b2);
        d(canvas, b2);
        c(canvas, b2);
        Collection<ResultPoint> collection = this.j;
        Collection<ResultPoint> collection2 = this.k;
        if (collection.isEmpty()) {
            this.k = null;
        } else {
            this.j = new HashSet(5);
            this.k = collection;
            this.f7223a.setAlpha(255);
            this.f7223a.setColor(this.f);
            for (ResultPoint resultPoint : collection) {
                canvas.drawCircle(b2.left + resultPoint.getX(), b2.top + resultPoint.getY(), 6.0f, this.f7223a);
            }
        }
        if (collection2 != null) {
            this.f7223a.setAlpha(127);
            this.f7223a.setColor(this.f);
            for (ResultPoint resultPoint2 : collection2) {
                canvas.drawCircle(b2.left + resultPoint2.getX(), b2.top + resultPoint2.getY(), 3.0f, this.f7223a);
            }
        }
        postInvalidateDelayed(10L, b2.left, b2.top, b2.right, b2.bottom);
    }

    public int a(int i) {
        return Integer.valueOf("20" + Integer.toHexString(i).substring(2), 16).intValue();
    }

    private void a(Canvas canvas, Rect rect, int i, int i2) {
        this.f7223a.setColor(this.f7224b);
        float f = i;
        canvas.drawRect(0.0f, 0.0f, f, rect.top, this.f7223a);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f7223a);
        canvas.drawRect(rect.right + 1, rect.top, f, rect.bottom + 1, this.f7223a);
        canvas.drawRect(0.0f, rect.bottom + 1, f, i2, this.f7223a);
    }

    public void a() {
        invalidate();
    }

    public void a(ResultPoint resultPoint) {
        this.j.add(resultPoint);
    }
}
