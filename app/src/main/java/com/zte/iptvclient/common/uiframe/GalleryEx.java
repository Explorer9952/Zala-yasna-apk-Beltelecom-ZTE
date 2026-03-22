package com.zte.iptvclient.common.uiframe;

import android.content.Context;
import android.graphics.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;

/* loaded from: classes2.dex */
public class GalleryEx extends Gallery {

    /* renamed from: a, reason: collision with root package name */
    protected Camera f7884a;

    /* renamed from: b, reason: collision with root package name */
    protected int f7885b;

    /* renamed from: c, reason: collision with root package name */
    protected int f7886c;

    /* renamed from: d, reason: collision with root package name */
    protected int f7887d;
    protected int e;
    protected int f;
    protected int g;
    protected boolean h;
    protected a i;
    protected int j;

    /* loaded from: classes2.dex */
    public interface a {
        void a(View view, int i);
    }

    public GalleryEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7884a = new Camera();
        this.f7885b = 0;
        this.f7886c = 0;
        this.f7887d = 0;
        this.e = 255;
        this.f = 125;
        this.g = 4;
        this.h = false;
        this.i = null;
        this.j = 1;
        setStaticTransformationsEnabled(true);
        setChildrenDrawingOrderEnabled(true);
    }

    protected int a() {
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    protected void a(Transformation transformation, int i) {
    }

    @Override // android.widget.Gallery, android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int selectedItemPosition = getSelectedItemPosition() - getFirstVisiblePosition();
        return (selectedItemPosition >= 0 && i2 >= selectedItemPosition) ? ((i - 1) - i2) + selectedItemPosition : i2;
    }

    @Override // android.widget.Gallery, android.view.ViewGroup
    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        int a2 = a(view);
        this.f7886c = view.getMeasuredWidth();
        this.f7887d = view.getMeasuredHeight();
        transformation.clear();
        transformation.setTransformationType(2);
        int i = a2 - this.f7885b;
        int abs = Math.abs(i);
        if (abs < 2) {
            a aVar = this.i;
            if (aVar != null) {
                aVar.a(view, this.e);
            }
            a(transformation, abs);
        } else {
            int i2 = this.f7886c;
            int i3 = 0;
            if (abs >= i2) {
                a aVar2 = this.i;
                if (aVar2 != null) {
                    if (1 != this.j && i <= 0) {
                        aVar2.a(view, 0);
                    } else {
                        this.i.a(view, this.f);
                    }
                }
                a(transformation, abs);
            } else {
                if (this.i != null) {
                    if (1 == this.j) {
                        int i4 = this.f;
                        int i5 = this.e;
                        i3 = ((i5 - i4) + i4) - (((i5 - i4) * abs) / i2);
                    } else if (i > 0) {
                        int i6 = this.f;
                        int i7 = this.e;
                        i3 = ((i7 - i6) + i6) - ((i * (i7 - i6)) / i2);
                    } else {
                        int i8 = i2 / 3;
                        if (abs < i8) {
                            int i9 = this.e;
                            i3 = i9 - ((i9 * abs) / i8);
                        }
                    }
                    this.i.a(view, i3);
                }
                a(transformation, abs);
            }
        }
        return true;
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.h) {
            return true;
        }
        return super.onFling(motionEvent, motionEvent2, f / this.g, f2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f7885b = a();
        super.onSizeChanged(i, i2, i3, i4);
    }

    protected int a(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    public GalleryEx(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7884a = new Camera();
        this.f7885b = 0;
        this.f7886c = 0;
        this.f7887d = 0;
        this.e = 255;
        this.f = 125;
        this.g = 4;
        this.h = false;
        this.i = null;
        this.j = 1;
        setStaticTransformationsEnabled(true);
        setChildrenDrawingOrderEnabled(true);
    }
}
