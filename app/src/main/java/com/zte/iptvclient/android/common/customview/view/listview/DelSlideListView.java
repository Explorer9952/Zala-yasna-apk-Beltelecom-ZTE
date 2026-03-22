package com.zte.iptvclient.android.common.customview.view.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.linearlayout.ScrollLinerLayout;
import com.zte.iptvclient.android.common.g.a;
import com.zte.iptvclient.android.common.g.b;
import com.zte.iptvclient.android.zala.R;

/* loaded from: classes.dex */
public class DelSlideListView extends ListView implements GestureDetector.OnGestureListener, View.OnTouchListener {
    public static boolean m = false;

    /* renamed from: a, reason: collision with root package name */
    private GestureDetector f4367a;

    /* renamed from: b, reason: collision with root package name */
    private b f4368b;

    /* renamed from: c, reason: collision with root package name */
    private int f4369c;

    /* renamed from: d, reason: collision with root package name */
    private a f4370d;
    private int e;
    private float f;
    public boolean g;
    private ScrollLinerLayout h;
    private boolean i;
    private int j;
    private boolean k;
    private boolean l;

    public DelSlideListView(Context context) {
        super(context);
        this.e = 0;
        this.g = false;
        this.i = false;
        this.l = false;
        a(context);
    }

    public void a(b bVar) {
        this.f4368b = bVar;
    }

    public boolean b() {
        return this.l;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        a aVar = this.f4370d;
        if (aVar != null) {
            aVar.a();
        }
        this.f = motionEvent.getX();
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        this.j = pointToPosition;
        int firstVisiblePosition = pointToPosition - getFirstVisiblePosition();
        ScrollLinerLayout scrollLinerLayout = this.h;
        if (scrollLinerLayout != null) {
            scrollLinerLayout.a();
            this.h.a(true);
        }
        if (this.g && firstVisiblePosition != this.f4369c) {
            this.g = false;
            ScrollLinerLayout scrollLinerLayout2 = this.h;
            if (scrollLinerLayout2 != null) {
                scrollLinerLayout2.a(0);
                this.h.a(false);
            }
            this.f4369c = firstVisiblePosition;
            this.i = false;
            return true;
        }
        this.f4369c = firstVisiblePosition;
        this.i = false;
        this.k = false;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ScrollLinerLayout scrollLinerLayout;
        int measuredWidth;
        if (motionEvent.getAction() == 0 && (scrollLinerLayout = this.h) != null && (measuredWidth = scrollLinerLayout.getMeasuredWidth() - this.e) > 0) {
            if (this.g && motionEvent.getX() < measuredWidth) {
                super.requestDisallowInterceptTouchEvent(true);
                return true;
            }
            requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.k && !this.i) {
            ScrollLinerLayout scrollLinerLayout = this.h;
            if (scrollLinerLayout != null) {
                scrollLinerLayout.a(0);
            }
            return false;
        }
        if (this.i) {
            if (this.h != null) {
                int x = (int) (this.f - motionEvent2.getX());
                if (this.g) {
                    x += this.e;
                }
                if (x >= 0 && x <= this.e) {
                    ScrollLinerLayout scrollLinerLayout2 = this.h;
                    scrollLinerLayout2.scrollBy(x - scrollLinerLayout2.getScrollX(), 0);
                }
            }
        } else if (Math.abs(f) > Math.abs(f2)) {
            int pointToPosition = pointToPosition((int) motionEvent2.getX(), (int) motionEvent2.getY()) - getFirstVisiblePosition();
            b bVar = this.f4368b;
            if (bVar != null && pointToPosition == this.f4369c && bVar.a(pointToPosition)) {
                ScrollLinerLayout scrollLinerLayout3 = (ScrollLinerLayout) getChildAt(pointToPosition);
                this.h = scrollLinerLayout3;
                if (scrollLinerLayout3 != null) {
                    int x2 = (int) (this.f - motionEvent2.getX());
                    if (this.g) {
                        x2 += this.e;
                    }
                    if (x2 >= 0 && x2 <= this.e && Math.abs(f2) < 5.0f) {
                        this.i = true;
                        this.k = false;
                        this.h.a(false);
                        this.h.scrollBy((int) (motionEvent.getX() - motionEvent2.getX()), 0);
                    }
                }
            }
        }
        return this.i;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (!this.g) {
            return false;
        }
        this.f4369c = -1;
        this.g = false;
        this.h.a(0);
        this.i = false;
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (b()) {
            return false;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            int x = (int) (this.f - motionEvent.getX());
            if (this.i) {
                if (!this.g) {
                    int i = this.e;
                    if (x >= i / 2) {
                        this.h.a(i);
                        this.f4369c = this.j - getFirstVisiblePosition();
                        this.g = true;
                        this.i = false;
                        return true;
                    }
                }
                this.f4369c = -1;
                this.g = false;
                this.h.a(0);
                this.i = false;
                return true;
            }
        }
        if (m) {
            return false;
        }
        return this.f4367a.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.i || this.g) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void a(Context context) {
        GestureDetector gestureDetector = new GestureDetector(context, this);
        this.f4367a = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.e = (int) getResources().getDimension(R.dimen.delete_action_len);
        setOnTouchListener(this);
    }

    public void a() {
        this.f4369c = -1;
        this.g = false;
        this.i = false;
        ScrollLinerLayout scrollLinerLayout = this.h;
        if (scrollLinerLayout != null) {
            scrollLinerLayout.a(0);
        }
    }

    public DelSlideListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
        this.g = false;
        this.i = false;
        this.l = false;
        a(context);
    }

    public DelSlideListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0;
        this.g = false;
        this.i = false;
        this.l = false;
        a(context);
    }
}
