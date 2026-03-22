package com.zte.iptvclient.android.common.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.ahmobile.android.tvclient.R$styleable;

/* loaded from: classes.dex */
public class AbsVerticalSeekBar extends VerticalProgressBar {
    private float A;
    private Drawable v;
    private int w;
    float x;
    boolean y;
    private int z;

    public AbsVerticalSeekBar(Context context) {
        super(context);
        this.y = true;
        this.z = 1;
    }

    private void j() {
        ViewParent viewParent = this.u;
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // com.zte.iptvclient.android.common.customview.view.VerticalProgressBar
    public void a(int i) {
        super.a(i);
        if (this.z == 0 || c() / this.z > 20) {
            d(Math.max(1, Math.round(c() / 20.0f)));
        }
    }

    public void b(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            this.w = drawable.getIntrinsicHeight() / 2;
        }
        this.v = drawable;
        invalidate();
    }

    public void d(int i) {
        if (i < 0) {
            i = -i;
        }
        this.z = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.iptvclient.android.common.customview.view.VerticalProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable e = e();
        if (e != null) {
            e.setAlpha(isEnabled() ? 255 : (int) (this.A * 255.0f));
        }
        Drawable drawable = this.v;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.v.setState(getDrawableState());
    }

    public void e(int i) {
        this.w = i;
        invalidate();
    }

    public int f() {
        return this.w;
    }

    void g() {
    }

    void h() {
    }

    void i() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.iptvclient.android.common.customview.view.VerticalProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.v != null) {
            canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop() - f());
            this.v.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int d2 = d();
        if (i != 19) {
            if (i == 20 && d2 > 0) {
                a(d2 - this.z, true);
                g();
                return true;
            }
        } else if (d2 < c()) {
            a(d2 + this.z, true);
            g();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.zte.iptvclient.android.common.customview.view.VerticalProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        int i3;
        Drawable a2 = a();
        int i4 = 0;
        int intrinsicWidth = this.v == null ? 0 : this.v.getIntrinsicWidth();
        if (a2 != null) {
            Math.max(this.f4347a, Math.min(this.f4348b, a2.getIntrinsicWidth()));
            i4 = Math.max(intrinsicWidth, 0);
            i3 = Math.max(this.f4349c, Math.min(this.f4350d, a2.getIntrinsicHeight()));
        } else {
            i3 = 0;
        }
        setMeasuredDimension(View.resolveSize(i4 + this.q + this.r, i), View.resolveSize(i3 + this.s + this.t, i2));
    }

    @Override // com.zte.iptvclient.android.common.customview.view.VerticalProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        Drawable a2 = a();
        Drawable drawable = this.v;
        int intrinsicWidth = drawable == null ? 0 : drawable.getIntrinsicWidth();
        int min = Math.min(this.f4348b, (i - this.r) - this.q);
        int c2 = c();
        float d2 = c2 > 0 ? d() / c2 : 0.0f;
        if (intrinsicWidth > min) {
            int i5 = (intrinsicWidth - min) / 2;
            if (drawable != null) {
                a(i2, drawable, d2, i5 * (-1));
            }
            if (a2 != null) {
                a2.setBounds(i5, 0, ((i - this.r) - this.q) - i5, (i2 - this.t) - this.s);
                return;
            }
            return;
        }
        if (a2 != null) {
            a2.setBounds(0, 0, (i - this.r) - this.q, (i2 - this.t) - this.s);
        }
        int i6 = (min - intrinsicWidth) / 2;
        if (drawable != null) {
            a(i2, drawable, d2, i6);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.y || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setPressed(true);
            h();
            a(motionEvent);
        } else if (action == 1) {
            a(motionEvent);
            i();
            setPressed(false);
            invalidate();
        } else if (action == 2) {
            a(motionEvent);
            j();
        } else if (action == 3) {
            i();
            setPressed(false);
            invalidate();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.iptvclient.android.common.customview.view.VerticalProgressBar, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return drawable.equals(this.v) || super.verifyDrawable(drawable);
    }

    public AbsVerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = true;
        this.z = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.zte.iptvclient.android.common.customview.view.VerticalProgressBar
    public void a(float f, boolean z) {
        Drawable drawable = this.v;
        if (drawable != null) {
            a(getHeight(), drawable, f, Integer.MIN_VALUE);
            invalidate();
        }
    }

    public AbsVerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = true;
        this.z = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SeekBar, i, 0);
        b(obtainStyledAttributes.getDrawable(0));
        e(obtainStyledAttributes.getDimensionPixelOffset(1, f()));
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.Theme, 0, 0);
        this.A = obtainStyledAttributes2.getFloat(0, 0.5f);
        obtainStyledAttributes2.recycle();
    }

    private void a(int i, Drawable drawable, float f, int i2) {
        int i3;
        int i4 = (i - this.s) - this.t;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i5 = (int) ((1.0f - f) * ((i4 - intrinsicHeight) + (this.w * 2)));
        if (i2 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            i2 = bounds.left;
            i3 = bounds.right;
        } else {
            i3 = i2 + intrinsicWidth;
        }
        drawable.setBounds(i2, i5, i3, intrinsicHeight + i5);
    }

    private void a(MotionEvent motionEvent) {
        float f;
        int height = getHeight();
        int i = (height - this.s) - this.t;
        int y = height - ((int) motionEvent.getY());
        float f2 = 0.0f;
        if (y < this.t) {
            f = 0.0f;
        } else if (y > height - this.s) {
            f = 1.0f;
        } else {
            f2 = this.x;
            f = (y - r2) / i;
        }
        a((int) (f2 + (f * c())), true);
    }
}
