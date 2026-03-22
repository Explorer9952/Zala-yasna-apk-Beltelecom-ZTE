package com.google.vr.cardboard;

import com.google.vr.ndk.base.GvrApi;
import com.google.vr.ndk.base.GvrSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public class ScanlineRacingRenderer implements GvrSurfaceView.Renderer {
    private static final String TAG = "ScanlineRacingRenderer";
    private final GvrApi gvrApi;

    public ScanlineRacingRenderer(GvrApi gvrApi) {
        if (gvrApi == null) {
            throw new IllegalArgumentException("GvrApi must be supplied for proper scanline rendering");
        }
        this.gvrApi = gvrApi;
    }

    @Override // com.google.vr.ndk.base.GvrSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        this.gvrApi.renderScanlineThread();
    }

    public void onPause() {
        this.gvrApi.onPauseScanlineThread();
    }

    public void onResume() {
        this.gvrApi.onResumeScanlineThread();
    }

    @Override // com.google.vr.ndk.base.GvrSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
    }

    @Override // com.google.vr.ndk.base.GvrSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Thread.currentThread().setPriority(10);
        this.gvrApi.initializeGlScanlineThread();
    }
}
