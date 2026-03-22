package com.google.vr.ndk.base;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.cardboard.DisplaySynchronizer;
import com.google.vr.cardboard.DisplayUtils;
import com.google.vr.cardboard.UsedByNative;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.cardboard.VrParamsProviderFactory;
import com.google.vr.ndk.base.proto.nano.GvrApiData;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;

/* loaded from: classes.dex */
public class GvrApi {
    private static PoseTracker sPoseTrackerForTesting;
    private final Context context;
    private final DisplaySynchronizer displaySynchronizer;
    private long nativeGvrContext;
    private final VrParamsProvider vrParamsProvider;

    /* loaded from: classes.dex */
    public final class BoolParameterId {
        public static final int CHROMATIC_ABERRATION_CORRECTION_ID = 0;
        public static final int NUM_PARAM_IDS = 2;
        public static final int SCANLINE_RACING_ID = 1;

        private BoolParameterId() {
        }
    }

    @UsedByNative
    /* loaded from: classes.dex */
    public interface PoseTracker {
        @UsedByNative
        void getHeadPoseInStartSpace(float[] fArr, long j);
    }

    static {
        try {
            System.loadLibrary("gvr");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public GvrApi(Context context, DisplaySynchronizer displaySynchronizer) {
        this.context = context;
        this.displaySynchronizer = displaySynchronizer;
        long retainNativeDisplaySynchronizer = displaySynchronizer == null ? 0L : displaySynchronizer.retainNativeDisplaySynchronizer();
        this.vrParamsProvider = VrParamsProviderFactory.create(context);
        DisplayMetrics computeCurrentDisplayMetrics = computeCurrentDisplayMetrics();
        this.nativeGvrContext = nativeCreate(GvrApi.class.getClassLoader(), context.getApplicationContext(), retainNativeDisplaySynchronizer, computeCurrentDisplayMetrics.widthPixels, computeCurrentDisplayMetrics.heightPixels, computeCurrentDisplayMetrics.xdpi, computeCurrentDisplayMetrics.ydpi, sPoseTrackerForTesting);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplaySynchronizer createDefaultDisplaySynchronizer(Context context) {
        return new DisplaySynchronizer(DisplayUtils.getDefaultDisplay(context));
    }

    private native float[] nativeComputeDistortedPoint(long j, int i, float[] fArr);

    private native long nativeCreate(ClassLoader classLoader, Context context, long j, int i, int i2, float f, float f2, PoseTracker poseTracker);

    private native int nativeCreateOffscreenFramebuffer(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeDestroyRenderTextureParams(long j);

    private native void nativeDistortOffscreenFramebufferToScreen(long j, int i, byte[] bArr, float[] fArr, long j2);

    private native void nativeDistortToScreen(long j, int i, byte[] bArr, float[] fArr, long j2);

    private native boolean nativeGetBoolParameter(long j, int i);

    private native long nativeGetCardboardApi(long j);

    private native float[] nativeGetEyeFromHeadMatrix(long j, int i);

    private native void nativeGetHeadPoseInStartSpace(long j, float[] fArr, long j2);

    private native int nativeGetOffscreenFramebufferResourceId(long j, int i);

    private native int[] nativeGetOffscreenFramebufferSize(long j, int i);

    private native byte[] nativeGetRecommendedRenderParams(long j);

    private native int[] nativeGetRecommendedRenderTargetSize(long j);

    private native byte[] nativeGetScreenRenderParams(long j);

    private native int[] nativeGetScreenTargetSize(long j);

    private native String nativeGetViewerModel(long j);

    private native String nativeGetViewerVendor(long j);

    private native int[] nativeGetWindowBounds(long j);

    private native void nativeInitializeGl(long j);

    private native void nativeInitializeGlScanlineThread(long j);

    private native void nativeOnPauseScanlineThread(long j);

    private native void nativeOnResumeScanlineThread(long j);

    private native void nativePauseTracking(long j);

    private native void nativeRecenterTracking(long j);

    private native void nativeReconnectSensors(long j);

    private native void nativeReleaseGvrContext(long j);

    private native void nativeReleaseOffscreenFramebuffer(long j, int i);

    private native void nativeRenderScanlineThread(long j);

    private native void nativeResetTracking(long j);

    private native void nativeResizeOffscreenFramebuffer(long j, int i, int i2, int i3);

    private native void nativeResumeTracking(long j);

    private native void nativeSetActiveOffscreenFramebuffer(long j, int i);

    private native boolean nativeSetBoolParameter(long j, int i, boolean z);

    private native void nativeSetDefaultFramebufferActive(long j);

    private native boolean nativeSetDefaultViewerProfile(long j, String str);

    private native void nativeSetDisplayMetrics(long j, int i, int i2, float f, float f2);

    private native void nativeSetSurfaceSize(long j, int i, int i2);

    private native void nativeSetUseProtectedBuffers(long j);

    private native boolean nativeSetViewerParams(long j, byte[] bArr);

    private native boolean nativeUsingProtectedBuffers(long j);

    public static void setPoseTrackerForTesting(PoseTracker poseTracker) {
        sPoseTrackerForTesting = poseTracker;
    }

    private boolean setViewerParams(byte[] bArr) {
        return nativeSetViewerParams(this.nativeGvrContext, bArr);
    }

    public DisplayMetrics computeCurrentDisplayMetrics() {
        DisplaySynchronizer displaySynchronizer = this.displaySynchronizer;
        return DisplayUtils.getDisplayMetricsWithOverride(displaySynchronizer == null ? DisplayUtils.getDefaultDisplay(this.context) : displaySynchronizer.getDisplay(), this.vrParamsProvider.readPhoneParams());
    }

    public float[] computeDistortedPoint(int i, float[] fArr) {
        float[] nativeComputeDistortedPoint = nativeComputeDistortedPoint(this.nativeGvrContext, i, fArr);
        if (nativeComputeDistortedPoint.length == 6) {
            return nativeComputeDistortedPoint;
        }
        throw new AssertionError("Implementation error: invalid UV coordinates output.");
    }

    public int createOffscreenFramebuffer(int i, int i2) {
        return nativeCreateOffscreenFramebuffer(this.nativeGvrContext, i, i2);
    }

    public void distortAndRenderOffscreenFramebuffer(int i, RenderTextureParamsList renderTextureParamsList, float[] fArr, long j) {
        long j2 = this.nativeGvrContext;
        byte[] byteArray = renderTextureParamsList.toByteArray();
        if (fArr == null) {
            nativeDistortOffscreenFramebufferToScreen(j2, i, byteArray, null, j);
        } else {
            nativeDistortOffscreenFramebufferToScreen(j2, i, byteArray, fArr, j);
        }
    }

    public void distortAndRenderTexture(int i, RenderTextureParamsList renderTextureParamsList, float[] fArr, long j) {
        long j2 = this.nativeGvrContext;
        byte[] byteArray = renderTextureParamsList.toByteArray();
        if (fArr == null) {
            nativeDistortToScreen(j2, i, byteArray, null, j);
        } else {
            nativeDistortToScreen(j2, i, byteArray, fArr, j);
        }
    }

    protected void finalize() {
        try {
            if (this.nativeGvrContext != 0) {
                nativeReleaseGvrContext(this.nativeGvrContext);
            }
        } finally {
            super.finalize();
        }
    }

    public boolean getBoolParameter(int i) {
        return nativeGetBoolParameter(this.nativeGvrContext, i);
    }

    public float[] getEyeFromHeadMatrix(int i) {
        float[] nativeGetEyeFromHeadMatrix = nativeGetEyeFromHeadMatrix(this.nativeGvrContext, i);
        if (nativeGetEyeFromHeadMatrix.length == 16) {
            return nativeGetEyeFromHeadMatrix;
        }
        throw new AssertionError("Implementation error: invalid eye from head matrix.");
    }

    public void getHeadPoseInStartSpace(float[] fArr, long j) {
        if (fArr == null || fArr.length != 16) {
            throw new IllegalArgumentException("Invalid head pose argument, must be a float[16].");
        }
        nativeGetHeadPoseInStartSpace(this.nativeGvrContext, fArr, j);
    }

    public long getNativeCardboardApi() {
        return nativeGetCardboardApi(this.nativeGvrContext);
    }

    public long getNativeGvrContext() {
        return this.nativeGvrContext;
    }

    public int getOffscreenFramebufferResourceId(int i) {
        return nativeGetOffscreenFramebufferResourceId(this.nativeGvrContext, i);
    }

    public int[] getOffscreenFramebufferSize(int i) {
        int[] nativeGetOffscreenFramebufferSize = nativeGetOffscreenFramebufferSize(this.nativeGvrContext, i);
        if (nativeGetOffscreenFramebufferSize.length == 2) {
            return nativeGetOffscreenFramebufferSize;
        }
        throw new AssertionError("Implementation error: invalid framebuffer size.");
    }

    public RenderTextureParamsList getRecommendedRenderParams() {
        try {
            return new RenderTextureParamsList(GvrApiData.RenderTextureParamsListData.parseFrom(nativeGetRecommendedRenderParams(this.nativeGvrContext)));
        } catch (InvalidProtocolBufferNanoException e) {
            throw new AssertionError(e);
        }
    }

    public int[] getRecommendedRenderTargetSize() {
        int[] nativeGetRecommendedRenderTargetSize = nativeGetRecommendedRenderTargetSize(this.nativeGvrContext);
        if (nativeGetRecommendedRenderTargetSize.length == 2) {
            return nativeGetRecommendedRenderTargetSize;
        }
        throw new AssertionError("Implementation error: invalid render target size.");
    }

    public RenderTextureParamsList getScreenRenderParams() {
        try {
            return new RenderTextureParamsList(GvrApiData.RenderTextureParamsListData.parseFrom(nativeGetScreenRenderParams(this.nativeGvrContext)));
        } catch (InvalidProtocolBufferNanoException e) {
            throw new AssertionError(e);
        }
    }

    public int[] getScreenTargetSize() {
        int[] nativeGetScreenTargetSize = nativeGetScreenTargetSize(this.nativeGvrContext);
        if (nativeGetScreenTargetSize.length == 2) {
            return nativeGetScreenTargetSize;
        }
        throw new AssertionError("Implementation error: invalid render target size.");
    }

    public boolean getUsingProtectedBuffers() {
        return nativeUsingProtectedBuffers(this.nativeGvrContext);
    }

    public String getViewerModel() {
        return nativeGetViewerModel(this.nativeGvrContext);
    }

    public String getViewerVendor() {
        return nativeGetViewerVendor(this.nativeGvrContext);
    }

    public int[] getWindowBounds() {
        int[] nativeGetWindowBounds = nativeGetWindowBounds(this.nativeGvrContext);
        if (nativeGetWindowBounds.length == 4) {
            return nativeGetWindowBounds;
        }
        throw new AssertionError("Implementation error: invalid window bounds.");
    }

    public void initializeGl() {
        nativeInitializeGl(this.nativeGvrContext);
    }

    public void initializeGlScanlineThread() {
        nativeInitializeGlScanlineThread(this.nativeGvrContext);
    }

    public void onPauseScanlineThread() {
        nativeOnPauseScanlineThread(this.nativeGvrContext);
    }

    public void onResumeScanlineThread() {
        nativeOnResumeScanlineThread(this.nativeGvrContext);
    }

    public void pauseTracking() {
        nativePauseTracking(this.nativeGvrContext);
    }

    public void recenterTracking() {
        nativeRecenterTracking(this.nativeGvrContext);
    }

    public void reconnectSensors() {
        nativeReconnectSensors(this.nativeGvrContext);
    }

    public void refreshDisplayMetrics() {
        setDisplayMetrics(computeCurrentDisplayMetrics());
    }

    public void refreshViewerProfile() {
        CardboardDevice.DeviceParams readDeviceParams = this.vrParamsProvider.readDeviceParams();
        if (readDeviceParams != null) {
            setViewerParams(MessageNano.toByteArray(readDeviceParams));
        }
    }

    public void releaseOffscreenFramebuffer(int i) {
        nativeReleaseOffscreenFramebuffer(this.nativeGvrContext, i);
    }

    public void renderScanlineThread() {
        nativeRenderScanlineThread(this.nativeGvrContext);
    }

    public void resetTracking() {
        nativeResetTracking(this.nativeGvrContext);
    }

    public void resizeOffscreenFramebuffer(int i, int i2, int i3) {
        nativeResizeOffscreenFramebuffer(this.nativeGvrContext, i, i2, i3);
    }

    public void resumeTracking() {
        nativeResumeTracking(this.nativeGvrContext);
    }

    public void setActiveOffscreenFramebuffer(int i) {
        nativeSetActiveOffscreenFramebuffer(this.nativeGvrContext, i);
    }

    public boolean setBoolParameter(int i, boolean z) {
        return nativeSetBoolParameter(this.nativeGvrContext, i, z);
    }

    public void setDefaultFramebufferActive() {
        nativeSetDefaultFramebufferActive(this.nativeGvrContext);
    }

    public boolean setDefaultViewerProfile(String str) {
        return nativeSetDefaultViewerProfile(this.nativeGvrContext, str);
    }

    public void setDisplayMetrics(DisplayMetrics displayMetrics) {
        nativeSetDisplayMetrics(this.nativeGvrContext, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.xdpi, displayMetrics.ydpi);
    }

    public void setSurfaceSize(int i, int i2) {
        nativeSetSurfaceSize(this.nativeGvrContext, i, i2);
    }

    public void setUseProtectedBuffers() {
        nativeSetUseProtectedBuffers(this.nativeGvrContext);
    }

    public void shutdown() {
        if (this.nativeGvrContext != 0) {
            this.vrParamsProvider.close();
            nativeReleaseGvrContext(this.nativeGvrContext);
            this.nativeGvrContext = 0L;
        }
    }
}
