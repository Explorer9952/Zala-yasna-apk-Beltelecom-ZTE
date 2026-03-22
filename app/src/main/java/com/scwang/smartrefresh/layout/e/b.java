package com.scwang.smartrefresh.layout.e;

import android.graphics.PointF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

/* compiled from: ScrollBoundaryUtil.java */
/* loaded from: classes.dex */
public class b {
    public static boolean a(View view, MotionEvent motionEvent) {
        if (a(view)) {
            return true;
        }
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF = new PointF();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (a(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(pointF.x, pointF.y);
                    return a(childAt, obtain);
                }
            }
        }
        return false;
    }

    public static boolean b(View view, MotionEvent motionEvent) {
        if (b(view)) {
            return true;
        }
        if (!(view instanceof ViewGroup) || motionEvent == null) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (a(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.offsetLocation(pointF.x, pointF.y);
                return b(childAt, obtain);
            }
        }
        return false;
    }

    public static boolean a(View view) {
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return view.getScrollY() < 0;
            }
            AbsListView absListView = (AbsListView) view;
            return absListView.getChildCount() > 0 && (absListView.getLastVisiblePosition() < absListView.getChildCount() - 1 || absListView.getChildAt(absListView.getChildCount() - 1).getBottom() > absListView.getPaddingBottom());
        }
        return view.canScrollVertically(1);
    }

    public static boolean b(View view) {
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return view.getScrollY() > 0;
            }
            AbsListView absListView = (AbsListView) view;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        return view.canScrollVertically(-1);
    }

    public static boolean a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) view.getWidth()) + f3 && f2 < ((float) view.getHeight()) + f3;
    }

    public static boolean a(ViewGroup viewGroup, View view, float f, float f2, PointF pointF) {
        float[] fArr = {f, f2};
        a(viewGroup, view, fArr);
        boolean a2 = a(view, fArr[0], fArr[1], 0.0f);
        if (a2 && pointF != null) {
            pointF.set(fArr[0] - f, fArr[1] - f2);
        }
        return a2;
    }

    public static void a(ViewGroup viewGroup, View view, float[] fArr) {
        fArr[0] = fArr[0] + (viewGroup.getScrollX() - view.getLeft());
        fArr[1] = fArr[1] + (viewGroup.getScrollY() - view.getTop());
    }
}
