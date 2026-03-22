package com.rendergl.google.android.apps.muzei;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import com.render.vrlib.MDVRLibrary;
import com.render.vrlib.i;

/* loaded from: classes.dex */
public class GLVrSurfaceView extends GLSurfaceView {

    /* renamed from: a, reason: collision with root package name */
    GLSurfaceView.Renderer f2676a;

    /* renamed from: b, reason: collision with root package name */
    private MDVRLibrary.i f2677b;

    public GLVrSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(MDVRLibrary.i iVar) {
        this.f2677b = iVar;
    }

    @Override // android.opengl.GLSurfaceView
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        super.setRenderer(renderer);
        this.f2676a = renderer;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
        Log.d("GLVrSurfaceView", "surfaceCreated");
        GLSurfaceView.Renderer renderer = this.f2676a;
        if (renderer == null || !(renderer instanceof i)) {
            return;
        }
        ((i) renderer).a();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
        Log.d("GLVrSurfaceView", "surfaceDestroyed");
        this.f2677b.onSurfaceDestroy();
    }
}
