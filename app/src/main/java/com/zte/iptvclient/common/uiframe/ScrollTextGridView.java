package com.zte.iptvclient.common.uiframe;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

/* loaded from: classes2.dex */
public class ScrollTextGridView extends GridView {
    public ScrollTextGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            View view = null;
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                Rect rect = new Rect();
                if (childAt != null) {
                    childAt.getDrawingRect(rect);
                    offsetDescendantRectToMyCoords(childAt, rect);
                    if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        view = childAt;
                    }
                }
            }
            if (view == null) {
                return true;
            }
            view.dispatchTouchEvent(motionEvent);
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ScrollTextGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
