package ijk.media.player.a;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import ijk.media.player.IjkMediaPlayer;

/* compiled from: TouchHelper.java */
/* loaded from: classes2.dex */
public class a implements GestureDetector.OnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    GestureDetector f8079a;

    /* renamed from: c, reason: collision with root package name */
    float f8081c;

    /* renamed from: d, reason: collision with root package name */
    private float f8082d = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    IjkMediaPlayer.b f8080b = null;

    public a(Context context) {
        GestureDetector gestureDetector = new GestureDetector(context, this);
        this.f8079a = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
        Log.d("TouchHelper", "TouchHelper..." + context);
    }

    private float b(float f) {
        return f * this.f8082d;
    }

    public void a(MotionEvent motionEvent) {
        this.f8079a.onTouchEvent(motionEvent);
        if (this.f8080b == null) {
            return;
        }
        if (motionEvent.getAction() == 1) {
            this.f8080b.b();
        } else if (motionEvent.getAction() == 0) {
            this.f8081c = motionEvent.getX();
            return;
        } else if (this.f8081c != 0.0f && motionEvent.getAction() == 2) {
            this.f8080b.a(this.f8081c - motionEvent.getX(), 0.0f);
        }
        this.f8081c = 0.0f;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        Log.d("TouchHelper", "onDown...");
        IjkMediaPlayer.b bVar = this.f8080b;
        if (bVar == null) {
            return false;
        }
        bVar.a();
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        IjkMediaPlayer.b bVar = this.f8080b;
        if (bVar == null) {
            return false;
        }
        bVar.a(b(f), b(f2));
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        IjkMediaPlayer.b bVar = this.f8080b;
        if (bVar == null) {
            return false;
        }
        bVar.c();
        return false;
    }

    public void a(float f) {
        this.f8082d = f;
    }

    public void a(IjkMediaPlayer.b bVar) {
        this.f8080b = bVar;
    }
}
