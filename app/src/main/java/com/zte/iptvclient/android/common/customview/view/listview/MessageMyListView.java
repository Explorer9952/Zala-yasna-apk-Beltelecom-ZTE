package com.zte.iptvclient.android.common.customview.view.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/* loaded from: classes.dex */
public class MessageMyListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    private a f4371a;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(int i);
    }

    public MessageMyListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f4371a == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        if (pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY()) == -1) {
            super.onTouchEvent(motionEvent);
            return this.f4371a.a(motionEvent.getActionMasked());
        }
        return super.onTouchEvent(motionEvent);
    }

    public MessageMyListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
