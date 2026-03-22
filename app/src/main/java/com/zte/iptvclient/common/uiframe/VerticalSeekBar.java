package com.zte.iptvclient.common.uiframe;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsSeekBar;

/* loaded from: classes2.dex */
public class VerticalSeekBar extends AbsSeekBar {

    /* renamed from: a, reason: collision with root package name */
    private int f7893a;

    /* renamed from: b, reason: collision with root package name */
    private int f7894b;

    /* renamed from: c, reason: collision with root package name */
    private a f7895c;

    /* loaded from: classes2.dex */
    public interface a {
        void a(VerticalSeekBar verticalSeekBar);

        void b(VerticalSeekBar verticalSeekBar);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    private void c() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    void a() {
        a aVar = this.f7895c;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    void b() {
        a aVar = this.f7895c;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        KeyEvent keyEvent2;
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 19:
                keyEvent2 = new KeyEvent(0, 22);
                break;
            case 20:
                keyEvent2 = new KeyEvent(0, 21);
                break;
            case 21:
                keyEvent2 = new KeyEvent(0, 20);
                break;
            case 22:
                keyEvent2 = new KeyEvent(0, 19);
                break;
            default:
                keyEvent2 = new KeyEvent(0, keyEvent.getKeyCode());
                break;
        }
        return keyEvent2.dispatch(this);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        canvas.rotate(-90.0f);
        canvas.translate(-this.f7893a, 0.0f);
        super.onDraw(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        this.f7893a = View.MeasureSpec.getSize(i2);
        int size = View.MeasureSpec.getSize(i);
        this.f7894b = size;
        setMeasuredDimension(size, this.f7893a);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setPressed(true);
            a();
            a(motionEvent);
        } else if (action == 1) {
            a(motionEvent);
            b();
            setPressed(false);
        } else if (action == 2) {
            a(motionEvent);
            c();
        } else if (action == 3) {
            b();
            setPressed(false);
        }
        return true;
    }

    @Override // android.widget.AbsSeekBar
    public void setThumb(Drawable drawable) {
        super.setThumb(drawable);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private synchronized void a(MotionEvent motionEvent) {
        float paddingBottom;
        int height = getHeight();
        int paddingBottom2 = (height - getPaddingBottom()) - getPaddingTop();
        int y = (int) motionEvent.getY();
        if (y > height - getPaddingBottom()) {
            paddingBottom = 0.0f;
        } else {
            paddingBottom = y < getPaddingTop() ? 1.0f : ((height - getPaddingBottom()) - y) / paddingBottom2;
        }
        setProgress((int) (paddingBottom * getMax()));
    }
}
