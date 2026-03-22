package com.google.vr.cardboard;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CardboardGLSurfaceView extends GLSurfaceView {
    private static final String TAG = CardboardGLSurfaceView.class.getSimpleName();
    private final EglFactory eglFactory;
    private ArrayList eventQueueWhileDetached;
    private boolean isDetached;
    private boolean isRendererSet;
    private final DetachListener listener;

    /* loaded from: classes.dex */
    public interface DetachListener {
        void onSurfaceViewDetachedFromWindow();
    }

    public CardboardGLSurfaceView(Context context, AttributeSet attributeSet, DetachListener detachListener) {
        super(context, attributeSet);
        this.listener = detachListener;
        EglFactory eglFactory = new EglFactory();
        this.eglFactory = eglFactory;
        setEGLContextFactory(eglFactory);
        setEGLWindowSurfaceFactory(this.eglFactory);
    }

    public CardboardGLSurfaceView(Context context, DetachListener detachListener) {
        super(context);
        this.listener = detachListener;
        EglFactory eglFactory = new EglFactory();
        this.eglFactory = eglFactory;
        setEGLContextFactory(eglFactory);
        setEGLWindowSurfaceFactory(this.eglFactory);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isDetached = false;
        ArrayList arrayList = this.eventQueueWhileDetached;
        if (arrayList != null) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                super.queueEvent((Runnable) it2.next());
            }
            this.eventQueueWhileDetached.clear();
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        DetachListener detachListener;
        if (this.isRendererSet && (detachListener = this.listener) != null) {
            detachListener.onSurfaceViewDetachedFromWindow();
        }
        super.onDetachedFromWindow();
        this.isDetached = true;
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (this.isRendererSet) {
            super.onPause();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        if (this.isRendererSet) {
            super.onResume();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void queueEvent(Runnable runnable) {
        if (!this.isRendererSet) {
            runnable.run();
        } else {
            if (!this.isDetached) {
                super.queueEvent(runnable);
                return;
            }
            if (this.eventQueueWhileDetached == null) {
                this.eventQueueWhileDetached = new ArrayList();
            }
            this.eventQueueWhileDetached.add(runnable);
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void setEGLContextClientVersion(int i) {
        super.setEGLContextClientVersion(i);
        this.eglFactory.setEGLContextClientVersion(i);
    }

    @Override // android.opengl.GLSurfaceView
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        super.setRenderer(renderer);
        this.isRendererSet = true;
    }

    public void setUseProtectedBuffers(boolean z) {
        if (this.isRendererSet) {
            throw new IllegalStateException("setUseProtectedBuffers must be called before setRenderer");
        }
        this.eglFactory.setUseProtectedBuffers(z);
    }
}
