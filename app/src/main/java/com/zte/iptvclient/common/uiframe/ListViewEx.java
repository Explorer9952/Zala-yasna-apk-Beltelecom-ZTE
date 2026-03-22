package com.zte.iptvclient.common.uiframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.video.androidsdk.log.LogEx;

/* loaded from: classes2.dex */
public class ListViewEx extends ListView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7888a;

    public ListViewEx(Context context, AttributeSet attributeSet, int i) {
        super(context.getApplicationContext(), attributeSet, i);
        this.f7888a = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        LogEx.d("ListViewEx", "isCenter =" + this.f7888a);
        if (!this.f7888a) {
            return false;
        }
        LogEx.d("ListViewEx", "dispatchTouchEvent now");
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f7888a) {
            return false;
        }
        LogEx.d("ListViewEx", "onInterceptTouchEvent now");
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f7888a) {
            return false;
        }
        LogEx.d("ListViewEx", "ontouch now");
        return super.onTouchEvent(motionEvent);
    }

    public ListViewEx(Context context, AttributeSet attributeSet) {
        super(context.getApplicationContext(), attributeSet);
        this.f7888a = false;
    }
}
