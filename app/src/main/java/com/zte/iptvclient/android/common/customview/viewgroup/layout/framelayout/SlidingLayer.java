package com.zte.iptvclient.android.common.customview.viewgroup.layout.framelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.core.e.a0;
import androidx.core.e.j;
import androidx.core.e.y;
import com.ahmobile.android.tvclient.R$styleable;
import java.security.SecureRandom;

/* loaded from: classes.dex */
public class SlidingLayer extends FrameLayout {
    private static final Interpolator A = new a();

    /* renamed from: a, reason: collision with root package name */
    protected int f4403a;

    /* renamed from: b, reason: collision with root package name */
    protected VelocityTracker f4404b;

    /* renamed from: c, reason: collision with root package name */
    protected int f4405c;

    /* renamed from: d, reason: collision with root package name */
    private Scroller f4406d;
    private int e;
    private Drawable f;
    private boolean g;
    private int h;
    private boolean i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private float q;
    private float r;
    private float s;
    private float t;
    private boolean u;
    private boolean v;
    private b w;
    private int x;
    private int y;
    private boolean z;

    /* loaded from: classes.dex */
    static class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return ((float) Math.pow(f - 1.0f, 5.0d)) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b();

        void c();

        void onClose();
    }

    public SlidingLayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void e() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f4406d = new Scroller(context, A);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.p = a0.b(viewConfiguration);
        this.x = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f4405c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.y = (int) (context.getResources().getDisplayMetrics().density * 25.0f);
    }

    private int f(int i) {
        if (this.u) {
            return 0;
        }
        int i2 = this.j;
        if (i2 == -5) {
            return (-getHeight()) + this.h;
        }
        if (i2 == -4) {
            return getHeight() - this.h;
        }
        if (i2 == -2 || i2 == -1) {
            return 0;
        }
        return i == 0 ? new SecureRandom().nextBoolean() ? -getHeight() : getHeight() : i > 0 ? -getHeight() : getHeight();
    }

    public void a(boolean z) {
        a(z, false);
    }

    public void b(boolean z) {
        b(z, false);
    }

    public void c(int i) {
        this.e = i;
        invalidate(getLeft(), getTop(), getRight(), getBottom());
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.f4406d.isFinished() && this.f4406d.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f4406d.getCurrX();
            int currY = this.f4406d.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
            invalidate(getLeft() + scrollX, getTop() + scrollY, getRight() - scrollX, getBottom() - scrollY);
            return;
        }
        a();
    }

    public void d(int i) {
        if (i != 0) {
            this.g = true;
        }
        this.j = i;
        a(false, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Drawable drawable;
        super.dispatchDraw(canvas);
        int i = this.e;
        if (i <= 0 || (drawable = this.f) == null) {
            return;
        }
        if (this.j == -1) {
            drawable.setBounds(0, 0, i, getHeight());
        }
        if (this.j == -4) {
            this.f.setBounds(0, getHeight() - this.e, getWidth(), getHeight());
        }
        if (this.j == -2) {
            this.f.setBounds(getWidth() - this.e, 0, getWidth(), getHeight());
        }
        if (this.j == -5) {
            this.f.setBounds(0, 0, getWidth(), this.e);
        }
        this.f.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.m) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.n) {
                    return true;
                }
                if (this.o) {
                    return false;
                }
            }
            if (action == 0) {
                int action2 = motionEvent.getAction();
                int i = Build.VERSION.SDK_INT;
                int i2 = action2 & 65280;
                this.f4403a = i2;
                float c2 = j.c(motionEvent, i2);
                this.s = c2;
                this.q = c2;
                float d2 = j.d(motionEvent, this.f4403a);
                this.t = d2;
                this.r = d2;
                if (a(motionEvent, this.s)) {
                    this.n = false;
                    this.o = false;
                    return super.onInterceptTouchEvent(motionEvent);
                }
                if (b(motionEvent, this.t)) {
                    this.n = false;
                    this.o = false;
                    return super.onInterceptTouchEvent(motionEvent);
                }
                this.o = true;
            } else if (action == 2) {
                int i3 = this.f4403a;
                if (i3 != -1) {
                    int a2 = j.a(motionEvent, i3);
                    if (a2 == -1) {
                        this.f4403a = -1;
                    } else {
                        float c3 = j.c(motionEvent, a2);
                        float f = c3 - this.q;
                        float abs = Math.abs(f);
                        float d3 = j.d(motionEvent, a2);
                        float f2 = this.r;
                        float f3 = d3 - f2;
                        float abs2 = Math.abs(d3 - f2);
                        if (abs > this.p && abs > abs2 && a(f, this.s)) {
                            this.n = true;
                            this.q = c3;
                            setDrawingCacheEnabled(true);
                        } else if (abs2 > this.p && abs2 > abs && b(f3, this.t)) {
                            this.n = true;
                            this.r = d3;
                            setDrawingCacheEnabled(true);
                        }
                    }
                }
            } else if (action == 6) {
                a(motionEvent);
            }
            if (!this.n) {
                if (this.f4404b == null) {
                    this.f4404b = VelocityTracker.obtain();
                }
                this.f4404b.addMovement(motionEvent);
            }
            return this.n;
        }
        this.n = false;
        this.o = false;
        this.f4403a = -1;
        VelocityTracker velocityTracker = this.f4404b;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4404b = null;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = this.j;
        if (i5 == 0) {
            i5 = a(i, i3);
        }
        if (i5 != this.j || this.g) {
            this.g = false;
            this.j = i5;
            a(false, true);
            int i6 = this.j;
            if (i6 == -1) {
                setPadding(getPaddingLeft() + this.e, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            } else if (i6 == -5) {
                setPadding(getPaddingLeft(), getPaddingTop() + this.e, getPaddingRight(), getPaddingBottom());
            } else if (i6 == -2) {
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight() + this.e, getPaddingBottom());
            } else if (i6 == -4) {
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.e);
            } else if (i6 == -3) {
                setPadding(getPaddingLeft() + this.e, getPaddingTop(), getPaddingRight() + this.e, getPaddingBottom());
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = FrameLayout.getDefaultSize(0, i);
        int defaultSize2 = FrameLayout.getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        super.onMeasure(FrameLayout.getChildMeasureSpec(i, 0, defaultSize), FrameLayout.getChildMeasureSpec(i2, 0, defaultSize2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a();
            scrollTo(c(), d());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        float f3;
        if (!this.m || (!this.n && !this.z && !a(motionEvent, this.s) && !b(motionEvent, this.t))) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 1 && action != 3 && action != 4) {
            this.z = true;
        } else {
            this.z = false;
        }
        if (this.f4404b == null) {
            this.f4404b = VelocityTracker.obtain();
        }
        this.f4404b.addMovement(motionEvent);
        int i = action & 255;
        if (i == 0) {
            a();
            float x = motionEvent.getX();
            this.s = x;
            this.q = x;
            float y = motionEvent.getY();
            this.t = y;
            this.r = y;
            this.f4403a = j.b(motionEvent, 0);
        } else if (i != 1) {
            if (i == 2) {
                if (!this.n) {
                    int a2 = j.a(motionEvent, this.f4403a);
                    if (a2 == -1) {
                        this.f4403a = -1;
                    } else {
                        float c2 = j.c(motionEvent, a2);
                        float abs = Math.abs(c2 - this.q);
                        float d2 = j.d(motionEvent, a2);
                        float abs2 = Math.abs(d2 - this.r);
                        if (abs > this.p && abs > abs2) {
                            this.n = true;
                            this.q = c2;
                            setDrawingCacheEnabled(true);
                        } else if (abs2 > this.p && abs2 > abs) {
                            this.n = true;
                            this.r = d2;
                            setDrawingCacheEnabled(true);
                        }
                    }
                }
                if (this.n) {
                    int a3 = j.a(motionEvent, this.f4403a);
                    if (a3 == -1) {
                        this.f4403a = -1;
                    } else {
                        float c3 = j.c(motionEvent, a3);
                        float d3 = j.d(motionEvent, a3);
                        float f4 = this.q - c3;
                        float f5 = this.r - d3;
                        this.q = c3;
                        this.r = d3;
                        float scrollX = getScrollX() + f4;
                        float scrollY = getScrollY() + f5;
                        int i2 = this.j;
                        float f6 = 0.0f;
                        if (i2 != -5) {
                            if (i2 == -4) {
                                f3 = getHeight();
                                f2 = 0.0f;
                            } else if (i2 != -3) {
                                if (i2 == -2) {
                                    f6 = getWidth();
                                } else if (i2 == -1) {
                                    f2 = -getWidth();
                                    f3 = 0.0f;
                                }
                                f2 = 0.0f;
                                f3 = 0.0f;
                            } else {
                                float height = getHeight();
                                float f7 = -getHeight();
                                float width = getWidth();
                                f = f7;
                                f2 = -getWidth();
                                f6 = width;
                                f3 = height;
                            }
                            f = 0.0f;
                        } else {
                            f = -getHeight();
                            f2 = 0.0f;
                            f3 = 0.0f;
                        }
                        if (scrollX > f6) {
                            scrollX = f6;
                        } else if (scrollX < f2) {
                            scrollX = f2;
                        }
                        if (scrollY > f3) {
                            scrollY = f3;
                        } else if (scrollY < f) {
                            scrollY = f;
                        }
                        int i3 = (int) scrollX;
                        this.q += scrollX - i3;
                        int i4 = (int) scrollY;
                        this.r += scrollY - i4;
                        scrollTo(i3, i4);
                    }
                }
            } else if (i != 3) {
                if (i == 5) {
                    int a4 = j.a(motionEvent);
                    this.q = j.c(motionEvent, a4);
                    this.r = j.d(motionEvent, a4);
                    this.f4403a = j.b(motionEvent, a4);
                } else if (i == 6) {
                    a(motionEvent);
                    this.q = j.c(motionEvent, j.a(motionEvent, this.f4403a));
                    this.r = j.d(motionEvent, j.a(motionEvent, this.f4403a));
                }
            } else if (this.n) {
                a(this.u, true, true);
                this.f4403a = -1;
                b();
            }
        } else if (this.n) {
            VelocityTracker velocityTracker = this.f4404b;
            velocityTracker.computeCurrentVelocity(1000, this.f4405c);
            int a5 = (int) y.a(velocityTracker, this.f4403a);
            int b2 = (int) y.b(velocityTracker, this.f4403a);
            int scrollX2 = getScrollX();
            int scrollY2 = getScrollY();
            int a6 = j.a(motionEvent, this.f4403a);
            a(a(this.u, scrollX2, scrollY2, a5, b2, (int) (j.c(motionEvent, a6) - this.s), (int) (j.d(motionEvent, a6) - this.t)), true, true, a5, b2);
            this.f4403a = -1;
            b();
        } else if (this.u && this.k) {
            a(true);
        } else if (!this.u && this.l) {
            b(true);
        }
        if (this.f4403a == -1) {
            this.z = false;
        }
        return true;
    }

    @Override // android.view.View
    public void setDrawingCacheEnabled(boolean z) {
        if (this.i != z) {
            super.setDrawingCacheEnabled(z);
            this.i = z;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    childAt.setDrawingCacheEnabled(z);
                }
            }
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable.equals(this.f);
    }

    public SlidingLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4403a = -1;
        this.j = 0;
        this.k = true;
        this.l = true;
        this.m = true;
        this.q = -1.0f;
        this.r = -1.0f;
        this.s = -1.0f;
        this.t = -1.0f;
        this.z = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SlidingLayer);
        d(obtainStyledAttributes.getInt(5, 0));
        int resourceId = obtainStyledAttributes.getResourceId(3, -1);
        if (resourceId != -1) {
            b(resourceId);
        }
        c((int) obtainStyledAttributes.getDimension(4, 0.0f));
        this.k = obtainStyledAttributes.getBoolean(0, true);
        this.l = obtainStyledAttributes.getBoolean(2, true);
        a(obtainStyledAttributes.getDimensionPixelOffset(1, 0));
        obtainStyledAttributes.recycle();
        e();
    }

    private void a(boolean z, boolean z2) {
        a(false, z, z2, 0, 0);
    }

    private void b(boolean z, boolean z2) {
        a(true, z, z2, 0, 0);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        a(z, z2, z3, 0, 0);
    }

    private int c() {
        return e(0);
    }

    public void b(int i) {
        a(getContext().getResources().getDrawable(i));
    }

    private void a(boolean z, boolean z2, boolean z3, int i, int i2) {
        if (!z3 && z == this.u) {
            setDrawingCacheEnabled(false);
            return;
        }
        if (z) {
            b bVar = this.w;
            if (bVar != null) {
                bVar.a();
            }
        } else {
            b bVar2 = this.w;
            if (bVar2 != null) {
                bVar2.onClose();
            }
        }
        this.u = z;
        int e = e(i);
        int f = f(i2);
        if (z2) {
            a(e, f, Math.max(i, i2));
        } else {
            a();
            scrollTo(e, f);
        }
    }

    private boolean b(MotionEvent motionEvent, float f) {
        int i = this.j;
        if (i != -5 && i != -4 && i != -3) {
            return false;
        }
        if (this.u) {
            return true;
        }
        int i2 = this.h;
        if (i2 <= 0) {
            return false;
        }
        int i3 = this.j;
        return i3 != -5 ? i3 == -4 && f <= ((float) i2) : f >= ((float) (getHeight() - this.h));
    }

    private int d() {
        return f(0);
    }

    private boolean b(float f, float f2) {
        int i;
        if ((this.u && getTop() <= f2) || getBottom() >= f2) {
            int i2 = this.j;
            if (i2 == -5) {
                return this.u && f > 0.0f;
            }
            if (i2 == -4) {
                return this.u && f < 0.0f;
            }
            if (i2 == -3) {
                return this.u && Double.doubleToLongBits((double) f) != Double.doubleToLongBits(0.0d);
            }
        }
        if (!this.u && (i = this.h) > 0 && f > 0.0f) {
            int i3 = this.j;
            return i3 != -5 ? i3 != -4 ? i3 == -3 && Double.doubleToLongBits((double) f) != Double.doubleToLongBits(0.0d) : f2 <= ((float) i) : f2 >= ((float) (getHeight() - this.h)) && f < 0.0f;
        }
        return false;
    }

    private int e(int i) {
        if (this.u) {
            return 0;
        }
        int i2 = this.j;
        if (i2 == -1) {
            return (-getWidth()) + this.h;
        }
        if (i2 == -2) {
            return getWidth() - this.h;
        }
        if (i2 == -4 || i2 == -5) {
            return 0;
        }
        return i == 0 ? new SecureRandom().nextBoolean() ? -getWidth() : getWidth() : i > 0 ? -getWidth() : getWidth();
    }

    public void a(Drawable drawable) {
        this.f = drawable;
        refreshDrawableState();
        setWillNotDraw(false);
        invalidate(getLeft(), getTop(), getRight(), getBottom());
    }

    private void b() {
        this.n = false;
        this.o = false;
        this.z = false;
        VelocityTracker velocityTracker = this.f4404b;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4404b = null;
        }
    }

    public void a(int i) {
        this.h = i;
        invalidate(getLeft(), getTop(), getRight(), getBottom());
    }

    private boolean a(MotionEvent motionEvent, float f) {
        int i = this.j;
        if (i != -3 && i != -2 && i != -1) {
            return false;
        }
        if (this.u) {
            return true;
        }
        int i2 = this.h;
        if (i2 <= 0) {
            return false;
        }
        int i3 = this.j;
        return i3 != -2 ? i3 == -1 && f >= ((float) (getWidth() - this.h)) : f <= ((float) i2);
    }

    private boolean a(float f, float f2) {
        int i;
        if ((this.u && getLeft() <= f2) || getRight() >= f2) {
            int i2 = this.j;
            if (i2 == -3) {
                return Double.doubleToLongBits((double) f) != 0;
            }
            if (i2 == -2) {
                return f < 0.0f;
            }
            if (i2 == -1) {
                return f > 0.0f;
            }
        }
        if (!this.u && (i = this.h) > 0 && f > 0.0f) {
            int i3 = this.j;
            return i3 != -3 ? i3 != -2 ? i3 == -1 && f2 >= ((float) (getWidth() - this.h)) && f < 0.0f : f2 <= ((float) i) : Double.doubleToLongBits((double) f) != Double.doubleToLongBits(0.0d);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r12 <= 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0099, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        if (r12 > 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0051, code lost:
    
        if (r13 <= 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0057, code lost:
    
        if (r13 > 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0076, code lost:
    
        if (r10 > ((-r9) / 2.0f)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007d, code lost:
    
        if (r10 < (r9 / 2.0f)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0088, code lost:
    
        if (java.lang.Math.abs(r10) < (r9 / 2.0f)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008f, code lost:
    
        if (r11 < (r12 / 2.0f)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0097, code lost:
    
        if (r11 > ((-r12) / 2.0f)) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(boolean r9, float r10, float r11, int r12, int r13, int r14, int r15) {
        /*
            r8 = this;
            int r9 = r8.j
            r0 = -3
            r1 = -1
            r2 = -2
            r3 = -4
            r4 = -5
            r5 = 0
            r6 = 1
            if (r9 == r4) goto L1a
            if (r9 == r3) goto L1a
            if (r9 == r0) goto L18
            if (r9 == r2) goto L15
            if (r9 == r1) goto L15
            r9 = 0
            goto L16
        L15:
            r9 = 1
        L16:
            r7 = 0
            goto L1c
        L18:
            r9 = 1
            goto L1b
        L1a:
            r9 = 0
        L1b:
            r7 = 1
        L1c:
            if (r9 == 0) goto L3b
            int r9 = java.lang.Math.abs(r14)
            int r14 = r8.y
            if (r9 <= r14) goto L3b
            int r9 = java.lang.Math.abs(r12)
            int r14 = r8.x
            if (r9 <= r14) goto L3b
            int r9 = r8.j
            if (r9 != r1) goto L34
            if (r12 <= 0) goto L99
        L34:
            int r9 = r8.j
            if (r9 != r2) goto L9a
            if (r12 <= 0) goto L9a
            goto L99
        L3b:
            if (r7 == 0) goto L5a
            int r9 = java.lang.Math.abs(r15)
            int r12 = r8.y
            if (r9 <= r12) goto L5a
            int r9 = java.lang.Math.abs(r13)
            int r12 = r8.x
            if (r9 <= r12) goto L5a
            int r9 = r8.j
            if (r9 != r4) goto L53
            if (r13 <= 0) goto L99
        L53:
            int r9 = r8.j
            if (r9 != r3) goto L9a
            if (r13 <= 0) goto L9a
            goto L99
        L5a:
            int r9 = r8.getWidth()
            int r12 = r8.getHeight()
            int r13 = r8.j
            r14 = 1073741824(0x40000000, float:2.0)
            if (r13 == r4) goto L92
            if (r13 == r3) goto L8b
            if (r13 == r0) goto L80
            if (r13 == r2) goto L79
            if (r13 == r1) goto L71
            goto L9b
        L71:
            int r9 = -r9
            float r9 = (float) r9
            float r9 = r9 / r14
            int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r9 <= 0) goto L9a
            goto L99
        L79:
            float r9 = (float) r9
            float r9 = r9 / r14
            int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r9 >= 0) goto L9a
            goto L99
        L80:
            float r10 = java.lang.Math.abs(r10)
            float r9 = (float) r9
            float r9 = r9 / r14
            int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r9 >= 0) goto L9a
            goto L99
        L8b:
            float r9 = (float) r12
            float r9 = r9 / r14
            int r9 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r9 >= 0) goto L9a
            goto L99
        L92:
            int r9 = -r12
            float r9 = (float) r9
            float r9 = r9 / r14
            int r9 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r9 <= 0) goto L9a
        L99:
            r5 = 1
        L9a:
            r6 = r5
        L9b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.customview.viewgroup.layout.framelayout.SlidingLayer.a(boolean, float, float, int, int, int, int):boolean");
    }

    void a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setDrawingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            a();
            if (this.u) {
                b bVar = this.w;
                if (bVar != null) {
                    bVar.c();
                    return;
                }
                return;
            }
            b bVar2 = this.w;
            if (bVar2 != null) {
                bVar2.b();
                return;
            }
            return;
        }
        setDrawingCacheEnabled(true);
        this.v = true;
        int width = getWidth();
        float f = width / 2;
        float a2 = f + (a(Math.min(1.0f, (Math.abs(i4) * 1.0f) / width)) * f);
        int abs = Math.abs(i3);
        this.f4406d.startScroll(scrollX, scrollY, i4, i5, Math.min(abs > 0 ? Math.round(Math.abs(a2 / abs) * 1000.0f) * 4 : 600, 600));
        invalidate();
    }

    float a(float f) {
        Double.isNaN(f - 0.5f);
        return (float) Math.sin((float) (r0 * 0.4712389167638204d));
    }

    private void a(MotionEvent motionEvent) {
        int a2 = j.a(motionEvent);
        if (j.b(motionEvent, a2) == this.f4403a) {
            int i = a2 == 0 ? 1 : 0;
            this.q = j.c(motionEvent, i);
            this.f4403a = j.b(motionEvent, i);
            VelocityTracker velocityTracker = this.f4404b;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void a() {
        boolean z = this.v;
        if (this.f4406d != null && z) {
            setDrawingCacheEnabled(false);
            this.f4406d.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f4406d.getCurrX();
            int currY = this.f4406d.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
            if (this.u) {
                b bVar = this.w;
                if (bVar != null) {
                    bVar.c();
                }
            } else {
                b bVar2 = this.w;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }
        }
        this.v = false;
    }

    private int a(int i, int i2) {
        int width;
        int i3 = this.j;
        if (i3 != 0) {
            return i3;
        }
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        try {
            Point point = new Point();
            Display.class.getMethod("getSize", Point.class).invoke(defaultDisplay, point);
            width = point.x;
        } catch (Exception unused) {
            width = defaultDisplay.getWidth();
        }
        boolean z = i == 0;
        boolean z2 = i2 == width;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (z != z2 || layoutParams == null) {
            if (z) {
                return -2;
            }
        } else {
            if (layoutParams.width == -1) {
                return -3;
            }
            if (z) {
                return -2;
            }
        }
        return -1;
    }
}
