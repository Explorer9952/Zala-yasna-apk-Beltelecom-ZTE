package com.zte.iptvclient.android.common.customview.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private List<List<View>> f4377a;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f4378b;

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4377a = new ArrayList();
        this.f4378b = new ArrayList();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        this.f4377a.clear();
        this.f4378b.clear();
        int width = getWidth();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (marginLayoutParams2 != null) {
                if (measuredWidth + i6 + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.f4378b.add(Integer.valueOf(i5));
                    this.f4377a.add(arrayList);
                    i5 = marginLayoutParams2.bottomMargin + marginLayoutParams2.topMargin + measuredHeight;
                    arrayList = new ArrayList();
                    i6 = 0;
                }
                i6 += measuredWidth + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                i5 = Math.max(i5, measuredHeight + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin);
                arrayList.add(childAt);
            }
        }
        this.f4378b.add(Integer.valueOf(i5));
        this.f4377a.add(arrayList);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f4377a.size();
        for (int i8 = 0; i8 < size; i8++) {
            List<View> list = this.f4377a.get(i8);
            int intValue = this.f4378b.get(i8).intValue();
            for (int i9 = 0; i9 < list.size(); i9++) {
                View view = list.get(i9);
                if (view.getVisibility() != 8 && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
                    int i10 = marginLayoutParams.leftMargin + paddingLeft;
                    int i11 = marginLayoutParams.topMargin + paddingTop;
                    view.layout(i10, i11, view.getMeasuredWidth() + i10, view.getMeasuredHeight() + i11);
                    paddingLeft += view.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                }
            }
            paddingLeft = getPaddingLeft();
            paddingTop += intValue;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            measureChild(childAt, i, i2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (marginLayoutParams != null) {
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i8 = i4 + measuredWidth;
                if (i8 > (size - getPaddingLeft()) - getPaddingRight()) {
                    i3 = Math.max(i3, i4);
                    i6 += i5;
                    i5 = measuredHeight;
                    i4 = measuredWidth;
                } else {
                    i5 = Math.max(i5, measuredHeight);
                    i4 = i8;
                }
            }
            if (i7 == childCount - 1) {
                i3 = Math.max(i4, i3);
                i6 += i5;
            }
        }
        Log.e("TAG", "sizeWidth = " + size);
        Log.e("TAG", "sizeHeight = " + size2);
        if (mode != 1073741824) {
            size = getPaddingRight() + i3 + getPaddingLeft();
        }
        if (mode2 != 1073741824) {
            size2 = i6 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
