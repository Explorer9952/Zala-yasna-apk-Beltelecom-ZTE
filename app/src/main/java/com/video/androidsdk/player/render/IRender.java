package com.video.androidsdk.player.render;

import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.widget.RelativeLayout;
import com.render.vrlib.MDVRLibrary;

/* loaded from: classes.dex */
public interface IRender {
    public static final int DISPLAY_MODE_GLASS = 102;
    public static final int DISPLAY_MODE_NORMAL = 101;
    public static final int INTERACTIVE_MODE_MOTION = 1;
    public static final int INTERACTIVE_MODE_MOTION_WITH_TOUCH = 3;
    public static final int INTERACTIVE_MODE_TOUCH = 2;
    public static final int PROJECTION_MODE_BULLET_TIME_16 = 218;
    public static final int PROJECTION_MODE_BULLET_TIME_4 = 215;
    public static final int PROJECTION_MODE_BULLET_TIME_8 = 216;
    public static final int PROJECTION_MODE_BULLET_TIME_9 = 217;
    public static final int PROJECTION_MODE_PLANE = 209;
    public static final int PROJECTION_MODE_SPHERE = 201;
    public static final int PROJECTION_MODE_SPHERE_3D_LEFT = 197;
    public static final int PROJECTION_MODE_SPHERE_3D_TOP = 196;
    public static final int REACH_BOTTOM = 4;
    public static final int REACH_LEFT = 1;
    public static final int REACH_RIGHT = 2;
    public static final int REACH_TOP = 3;
    public static final int STATUS_BULLET_END = 2;
    public static final int STATUS_BULLET_ERROR = 3;
    public static final int STATUS_BULLET_PLAYING = 1;
    public static final int STATUS_BULLET_START = 0;
    public static final int sMultiScreenSize = 2;

    /* loaded from: classes.dex */
    public interface GestureListener extends MDVRLibrary.g {
        @Override // com.render.vrlib.MDVRLibrary.g
        void onClick(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface IOnSurfaceDestroyCallback extends MDVRLibrary.i {
        @Override // com.render.vrlib.MDVRLibrary.i
        void onSurfaceDestroy();
    }

    /* loaded from: classes.dex */
    public interface IOnSurfaceReadyCallback extends MDVRLibrary.j {
        @Override // com.render.vrlib.MDVRLibrary.j
        void onSurfaceReady(Surface surface);
    }

    /* loaded from: classes.dex */
    public interface OnBulletIndexChangedListener extends MDVRLibrary.n {
        @Override // com.render.vrlib.MDVRLibrary.n
        void OnBulletIndexChanged(int i);
    }

    /* loaded from: classes.dex */
    public interface OnBulletTimeStateListener extends MDVRLibrary.o {
        @Override // com.render.vrlib.MDVRLibrary.o
        void onStateChanged(int i);
    }

    /* loaded from: classes.dex */
    public interface OnStateChangedListener extends MDVRLibrary.q {
        @Override // com.render.vrlib.MDVRLibrary.q
        void onStateChanged(int i);
    }

    void enableEnhance(boolean z);

    int getCurBulletId();

    float getCurrentScale();

    int getDisplayMode();

    int getInteractiveMode();

    int getProjectionMode();

    Rect getVideoWindow();

    void initRenderLibrary(Context context, RelativeLayout relativeLayout);

    boolean isAntiDistortionEnabled();

    boolean isPinchEnabled();

    void notifyPlayerChanged();

    void onConfigurationChanged();

    boolean onKeyTransform(KeyEvent keyEvent, int i, int i2);

    void onKeyZoom(KeyEvent keyEvent, float f);

    void onRenderDestory();

    void onRenderPause();

    void onRenderReset();

    void onRenderResume();

    void onTextureResize(int i, int i2);

    void onWindowResize(int i, int i2);

    void resetPerspective();

    void setAntiDistortionEnabled(boolean z);

    void setBulletIndex(int i);

    void setBulletTime(int i, boolean z);

    void setDisplayMode(int i);

    void setDisplayRotation(int i);

    void setEulerAngles(float f, float f2, float f3, int i);

    void setFlingEnabled(boolean z);

    void setFlingSensitivity(float f);

    void setGestureListener(GestureListener gestureListener);

    void setInteractiveMode(int i);

    void setOnBulletIndexChangedListener(OnBulletIndexChangedListener onBulletIndexChangedListener);

    void setOnBulletTimeStateListener(OnBulletTimeStateListener onBulletTimeStateListener);

    void setOnStateChangedListener(OnStateChangedListener onStateChangedListener);

    void setOnSurfaceDestroyCallback(IOnSurfaceDestroyCallback iOnSurfaceDestroyCallback);

    void setOnSurfaceReadyCallback(IOnSurfaceReadyCallback iOnSurfaceReadyCallback);

    void setPinchEnabled(boolean z);

    void setPinchMaxScale(float f);

    void setPinchMinScale(float f);

    void setPinchScale(float f);

    void setPinchSensitivity(float f);

    void setProjectionMode(int i);

    void setTouchSensitivity(float f);

    void setVideoWindow(Rect rect);
}
