package com.picovr.picovrlib;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public class PassThroughCamera implements SurfaceTexture.OnFrameAvailableListener {
    public static final String TAG = "VrCamera";
    Camera camera;
    SurfaceTexture cameraTexture;
    boolean gotFirstFrame;
    boolean hackVerticalFov = false;
    boolean previewStarted;
    long startPreviewTime;

    public void disableCameraPreview() {
        if (this.previewStarted) {
            stopCameraPreview();
        }
    }

    public void enableCameraPreview() {
        if (this.previewStarted) {
            return;
        }
        startCameraPreview();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Camera camera;
        if (this.gotFirstFrame || (camera = this.camera) == null) {
            return;
        }
        this.gotFirstFrame = true;
        Camera.Parameters parameters = camera.getParameters();
        float horizontalViewAngle = parameters.getHorizontalViewAngle();
        parameters.getVerticalViewAngle();
        if (this.hackVerticalFov) {
            double d2 = horizontalViewAngle;
            Double.isNaN(d2);
            Math.atan((Math.tan(((d2 / 180.0d) * 3.141592653589793d) * 0.5d) / 16.0d) * 9.0d);
        }
        System.nanoTime();
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.cameraTexture = surfaceTexture;
    }

    public void startCameraPreview() {
        this.startPreviewTime = System.nanoTime();
        SurfaceTexture surfaceTexture = this.cameraTexture;
        if (surfaceTexture == null && surfaceTexture == null) {
            return;
        }
        this.cameraTexture.setOnFrameAvailableListener(this);
        Camera camera = this.camera;
        if (camera != null) {
            this.gotFirstFrame = false;
            camera.startPreview();
            this.previewStarted = true;
            return;
        }
        Camera open = Camera.open();
        this.camera = open;
        Camera.Parameters parameters = open.getParameters();
        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(parameters.get("vrmode-supported"))) {
            parameters.set("vrmode", 1);
            parameters.setRecordingHint(true);
            this.hackVerticalFov = true;
            parameters.setPreviewSize(960, 540);
            parameters.set("fast-fps-mode", 2);
            parameters.setPreviewFpsRange(120000, 120000);
            parameters.set("focus-mode", "continuous-video");
        } else {
            for (int i = 0; i < parameters.getSupportedPreviewFormats().size(); i++) {
            }
            for (int i2 = 0; i2 < parameters.getSupportedPreviewSizes().size(); i2++) {
            }
            parameters.getHorizontalViewAngle();
            parameters.getVerticalViewAngle();
            parameters.setPreviewSize(640, 480);
            List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            for (int i3 = 0; i3 < supportedPreviewFpsRange.size(); i3++) {
            }
            int[] iArr = supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1);
            this.hackVerticalFov = false;
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        }
        this.camera.setParameters(parameters);
        try {
            this.camera.setPreviewTexture(this.cameraTexture);
        } catch (IOException unused) {
        }
        this.gotFirstFrame = false;
        this.camera.startPreview();
        this.previewStarted = true;
    }

    public void startExposureLock(boolean z) {
        Camera camera = this.camera;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setAutoExposureLock(z);
        parameters.setAutoWhiteBalanceLock(z);
        this.camera.setParameters(parameters);
    }

    public void stopCameraPreview() {
        this.previewStarted = false;
        SurfaceTexture surfaceTexture = this.cameraTexture;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
        }
        Camera camera = this.camera;
        if (camera != null) {
            camera.stopPreview();
            this.camera.release();
            this.camera = null;
        }
    }
}
