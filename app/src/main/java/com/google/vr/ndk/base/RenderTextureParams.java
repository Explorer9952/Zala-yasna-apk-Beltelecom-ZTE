package com.google.vr.ndk.base;

import com.google.vr.ndk.base.proto.nano.GvrApiData;

/* loaded from: classes.dex */
public class RenderTextureParams {
    public static final int EYE_TYPE_LEFT = 0;
    public static final int EYE_TYPE_NUM_EYES = 2;
    public static final int EYE_TYPE_RIGHT = 1;
    private final float[] eyeFov;
    private final int eyeType;
    private final float[] eyeViewportBounds;
    private final long nativePtr;

    public RenderTextureParams(GvrApiData.RenderTextureParamsListData.RenderTextureParamsData renderTextureParamsData) {
        if (renderTextureParamsData.eyeViewportBounds.length != 4 || renderTextureParamsData.eyeFov.length != 4) {
            throw new AssertionError("Invalid params for render texture.");
        }
        this.nativePtr = renderTextureParamsData.getNativePtr();
        this.eyeViewportBounds = renderTextureParamsData.eyeViewportBounds;
        this.eyeFov = renderTextureParamsData.eyeFov;
        this.eyeType = renderTextureParamsData.getEyeType();
    }

    protected void finalize() {
        try {
            GvrApi.nativeDestroyRenderTextureParams(this.nativePtr);
        } finally {
            super.finalize();
        }
    }

    public float[] getEyeFov() {
        return (float[]) this.eyeFov.clone();
    }

    public int getEyeType() {
        return this.eyeType;
    }

    public float[] getEyeViewportBounds() {
        return (float[]) this.eyeViewportBounds.clone();
    }

    public long getNativePtr() {
        return this.nativePtr;
    }
}
