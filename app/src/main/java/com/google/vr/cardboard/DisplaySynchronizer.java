package com.google.vr.cardboard;

import android.os.Build;
import android.util.Log;
import android.view.Choreographer;
import android.view.Display;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class DisplaySynchronizer implements Choreographer.FrameCallback {
    private static final boolean DEBUG = false;
    public static final long DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS = TimeUnit.SECONDS.toNanos(1);
    private static final int INVALID_DISPLAY_ROTATION = -1;
    private static final float MIN_VALID_DISPLAY_REFRESH_RATE = 30.0f;
    private static final String TAG = "DisplaySynchronizer";
    private volatile Display display;
    private final FrameMonitor frameMonitor;
    private int displayRotationDegrees = -1;
    private long lastDisplayRotationUpdateTimeNanos = 0;
    private long nativeDisplaySynchronizer = nativeInit();

    public DisplaySynchronizer(Display display) {
        setDisplay(display);
        this.frameMonitor = new FrameMonitor(this);
    }

    private void checkNativeDisplaySynchronizer() {
        if (this.nativeDisplaySynchronizer == 0) {
            throw new IllegalStateException("DisplaySynchronizer has already been shut down.");
        }
    }

    private void invalidateDisplayRotation() {
        this.displayRotationDegrees = -1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        int i;
        checkNativeDisplaySynchronizer();
        if (this.displayRotationDegrees == -1 || j - this.lastDisplayRotationUpdateTimeNanos > DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS) {
            int rotation = this.display.getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i = 90;
                } else if (rotation == 2) {
                    i = 180;
                } else if (rotation != 3) {
                    Log.e(TAG, "Unknown display rotation, defaulting to 0");
                } else {
                    i = 270;
                }
                this.displayRotationDegrees = i;
                this.lastDisplayRotationUpdateTimeNanos = j;
            }
            this.displayRotationDegrees = 0;
            this.lastDisplayRotationUpdateTimeNanos = j;
        }
        nativeUpdate(this.nativeDisplaySynchronizer, j, this.displayRotationDegrees);
    }

    protected void finalize() {
        try {
            if (this.nativeDisplaySynchronizer != 0) {
                nativeDestroy(this.nativeDisplaySynchronizer);
            }
        } finally {
            super.finalize();
        }
    }

    public Display getDisplay() {
        return this.display;
    }

    protected native void nativeDestroy(long j);

    protected native long nativeInit();

    protected native void nativeReset(long j, long j2, long j3);

    protected native long nativeRetainNativeDisplaySynchronizer(long j);

    protected native long nativeSyncToNextVsync(long j);

    protected native void nativeUpdate(long j, long j2, int i);

    public void onConfigurationChanged() {
        invalidateDisplayRotation();
    }

    public void onPause() {
        this.frameMonitor.onPause();
    }

    public void onResume() {
        invalidateDisplayRotation();
        this.frameMonitor.onResume();
    }

    public long retainNativeDisplaySynchronizer() {
        checkNativeDisplaySynchronizer();
        return nativeRetainNativeDisplaySynchronizer(this.nativeDisplaySynchronizer);
    }

    public void setDisplay(Display display) {
        checkNativeDisplaySynchronizer();
        this.display = display;
        invalidateDisplayRotation();
        nativeReset(this.nativeDisplaySynchronizer, display.getRefreshRate() >= MIN_VALID_DISPLAY_REFRESH_RATE ? ((float) TimeUnit.SECONDS.toNanos(1L)) / r0 : 0L, Build.VERSION.SDK_INT >= 21 ? display.getAppVsyncOffsetNanos() : 0L);
    }

    public void shutdown() {
        if (this.nativeDisplaySynchronizer != 0) {
            onPause();
            nativeDestroy(this.nativeDisplaySynchronizer);
            this.nativeDisplaySynchronizer = 0L;
        }
    }

    public long syncToNextVsync() {
        checkNativeDisplaySynchronizer();
        return nativeSyncToNextVsync(this.nativeDisplaySynchronizer);
    }
}
