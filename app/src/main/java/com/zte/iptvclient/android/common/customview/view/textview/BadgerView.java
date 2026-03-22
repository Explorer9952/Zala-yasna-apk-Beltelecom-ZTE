package com.zte.iptvclient.android.common.customview.view.textview;

import android.R;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import android.widget.TextView;

/* loaded from: classes.dex */
public class BadgerView extends TextView {
    private static Animation j;
    private static Animation k;

    /* renamed from: a, reason: collision with root package name */
    private Context f4372a;

    /* renamed from: b, reason: collision with root package name */
    private View f4373b;

    /* renamed from: c, reason: collision with root package name */
    private int f4374c;

    /* renamed from: d, reason: collision with root package name */
    private int f4375d;
    private int e;
    private int f;
    private boolean g;
    private ShapeDrawable h;
    private int i;

    public BadgerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private void a(Context context, View view, int i) {
        this.f4372a = context;
        this.f4373b = view;
        this.i = i;
        this.f4374c = 2;
        int c2 = c(5);
        this.f4375d = c2;
        this.e = c2;
        this.f = -65536;
        setTypeface(Typeface.DEFAULT_BOLD);
        int c3 = c(5);
        setPadding(c3, 0, c3, 0);
        setTextColor(-1);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        j = alphaAnimation;
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        j.setDuration(200L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        k = alphaAnimation2;
        alphaAnimation2.setInterpolator(new AccelerateInterpolator());
        k.setDuration(200L);
        this.g = false;
        View view2 = this.f4373b;
        if (view2 != null) {
            a(view2);
        } else {
            b();
        }
    }

    private void c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i = this.f4374c;
        if (i == 1) {
            layoutParams.gravity = 51;
            layoutParams.setMargins(this.f4375d, this.e, 0, 0);
        } else if (i == 2) {
            layoutParams.gravity = 53;
            layoutParams.setMargins(0, this.e, this.f4375d, 0);
        } else if (i == 3) {
            layoutParams.gravity = 83;
            layoutParams.setMargins(this.f4375d, 0, 0, this.e);
        } else if (i == 4) {
            layoutParams.gravity = 85;
            layoutParams.setMargins(0, 0, this.f4375d, this.e);
        } else if (i == 5) {
            layoutParams.gravity = 17;
            layoutParams.setMargins(0, 0, 0, 0);
        }
        setLayoutParams(layoutParams);
    }

    private ShapeDrawable d() {
        float c2 = c(8);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{c2, c2, c2, c2, c2, c2, c2, c2}, null, null));
        shapeDrawable.getPaint().setColor(this.f);
        return shapeDrawable;
    }

    public void b() {
        b(false, null);
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.g;
    }

    public BadgerView(Context context, View view) {
        this(context, null, R.attr.textViewStyle, view, 0);
    }

    private void b(boolean z, Animation animation) {
        if (getBackground() == null) {
            if (this.h == null) {
                this.h = d();
            }
            setBackgroundDrawable(this.h);
        }
        c();
        if (z) {
            startAnimation(animation);
        }
        setVisibility(0);
        this.g = true;
    }

    public BadgerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null, 0);
    }

    public BadgerView(Context context, AttributeSet attributeSet, int i, View view, int i2) {
        super(context, attributeSet, i);
        a(context, view, i2);
    }

    public void b(int i) {
        this.f4374c = i;
    }

    private int c(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    private void a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewParent parent = view.getParent();
            FrameLayout frameLayout = new FrameLayout(this.f4372a);
            if (view instanceof TabWidget) {
                View childTabViewAt = ((TabWidget) view).getChildTabViewAt(this.i);
                this.f4373b = childTabViewAt;
                if (childTabViewAt != null) {
                    ((ViewGroup) childTabViewAt).addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
                }
                setVisibility(8);
                frameLayout.addView(this);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            viewGroup.addView(frameLayout, indexOfChild, layoutParams);
            frameLayout.addView(view);
            setVisibility(8);
            frameLayout.addView(this);
            viewGroup.invalidate();
        }
    }

    public void a() {
        a(false, null);
    }

    private void a(boolean z, Animation animation) {
        setVisibility(8);
        if (z) {
            startAnimation(animation);
        }
        this.g = false;
    }

    public void a(int i) {
        this.f = i;
        this.h = d();
    }
}
