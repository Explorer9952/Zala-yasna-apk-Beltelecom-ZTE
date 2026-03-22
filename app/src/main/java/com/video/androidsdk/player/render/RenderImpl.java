package com.video.androidsdk.player.render;

import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.render.vrlib.MDVRLibrary;
import com.render.vrlib.a;
import com.render.vrlib.w.b;
import com.rendergl.google.android.apps.muzei.GLTextureView;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.render.IRender;

/* loaded from: classes.dex */
public class RenderImpl implements IRender {
    protected MDVRLibrary l;
    protected Context m;
    protected boolean n = false;
    protected int o = 1;

    private void a(View view) {
        if (this.o > 1) {
            LogEx.d("RenderLibrary", "there are " + this.o + " players");
            c(view);
            LogEx.d("RenderLibrary", "createVRLibraryForMultiPlayer end !");
            return;
        }
        b(view);
        LogEx.d("RenderLibrary", "createVRLibrary end !");
    }

    private void b(View view) {
        MDVRLibrary.a d2 = MDVRLibrary.d(this.m);
        d2.a(101);
        d2.b(2);
        d2.c(201);
        d2.a();
        d2.a(new MDVRLibrary.h() { // from class: com.video.androidsdk.player.render.RenderImpl.2
            @Override // com.render.vrlib.MDVRLibrary.h
            public void onNotSupport(int i) {
                LogEx.e("RenderLibrary", "not support !");
            }
        });
        b bVar = new b();
        bVar.c(1.0f);
        bVar.b(8.0f);
        bVar.a(1.0f);
        bVar.d(1.0f);
        d2.a(bVar);
        d2.a(true);
        d2.a(new com.render.vrlib.b() { // from class: com.video.androidsdk.player.render.RenderImpl.1
            @Override // com.render.vrlib.b
            public a createDirector(int i) {
                a.C0077a s = a.s();
                s.a(90.0f);
                return s.a();
            }
        });
        com.render.vrlib.w.a aVar = new com.render.vrlib.w.a();
        aVar.a(false);
        aVar.a(0.95f);
        d2.a(aVar);
        this.l = d2.a(view);
    }

    private void c(View view) {
        MDVRLibrary.a d2 = MDVRLibrary.d(this.m);
        d2.a(101);
        d2.b(2);
        d2.c(201);
        d2.a();
        d2.a(new MDVRLibrary.h() { // from class: com.video.androidsdk.player.render.RenderImpl.4
            @Override // com.render.vrlib.MDVRLibrary.h
            public void onNotSupport(int i) {
                LogEx.e("RenderLibrary", "not support !");
            }
        });
        b bVar = new b();
        bVar.c(1.0f);
        bVar.b(8.0f);
        bVar.a(1.0f);
        bVar.d(1.0f);
        d2.a(bVar);
        d2.a(true);
        d2.a(new com.render.vrlib.b() { // from class: com.video.androidsdk.player.render.RenderImpl.3
            @Override // com.render.vrlib.b
            public a createDirector(int i) {
                a.C0077a s = a.s();
                s.a(90.0f);
                return s.a();
            }
        });
        com.render.vrlib.w.a aVar = new com.render.vrlib.w.a();
        aVar.a(false);
        aVar.a(0.95f);
        d2.a(aVar);
        d2.d(this.o);
        this.l = d2.a(view);
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void enableEnhance(boolean z) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(this.m, z);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public int getCurBulletId() {
        MDVRLibrary mDVRLibrary = this.l;
        int d2 = mDVRLibrary != null ? mDVRLibrary.d() : 0;
        LogEx.d("RenderLibrary", "getCurBulletId:  " + d2);
        return d2;
    }

    @Override // com.video.androidsdk.player.render.IRender
    public float getCurrentScale() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            return mDVRLibrary.e();
        }
        return 1.0f;
    }

    @Override // com.video.androidsdk.player.render.IRender
    public int getDisplayMode() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.d("RenderLibrary", "mMDVRLibrary is null ");
            return -1;
        }
        return mDVRLibrary.f();
    }

    @Override // com.video.androidsdk.player.render.IRender
    public int getInteractiveMode() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.d("RenderLibrary", "mMDVRLibrary is null ");
            return -1;
        }
        return mDVRLibrary.g();
    }

    @Override // com.video.androidsdk.player.render.IRender
    public int getProjectionMode() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.d("RenderLibrary", "mMDVRLibrary is null ");
            return -1;
        }
        return mDVRLibrary.h();
    }

    @Override // com.video.androidsdk.player.render.IRender
    public Rect getVideoWindow() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            return mDVRLibrary.i();
        }
        return null;
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void initRenderLibrary(Context context, RelativeLayout relativeLayout) {
        this.m = context;
        if (com.video.androidsdk.license.a.h) {
            LogEx.d("RenderLibrary", "initVRLibrary");
            GLTextureView gLTextureView = new GLTextureView(this.m);
            gLTextureView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            relativeLayout.addView(gLTextureView);
            if (com.video.androidsdk.license.a.i) {
                if (new com.video.androidsdk.player.view.a().a(context, relativeLayout)) {
                    a(gLTextureView);
                    return;
                } else {
                    LogEx.w("RenderLibrary", "cannot find watermark picture");
                    return;
                }
            }
            a(gLTextureView);
            return;
        }
        LogEx.d("RenderLibrary", "you should check license");
    }

    @Override // com.video.androidsdk.player.render.IRender
    public boolean isAntiDistortionEnabled() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.d("RenderLibrary", "mMDVRLibrary is null ");
            return false;
        }
        return mDVRLibrary.j();
    }

    @Override // com.video.androidsdk.player.render.IRender
    public boolean isPinchEnabled() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.d("RenderLibrary", "mMDVRLibrary is null ");
            return false;
        }
        return mDVRLibrary.k();
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void notifyPlayerChanged() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.l();
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void onConfigurationChanged() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(this.m);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public boolean onKeyTransform(KeyEvent keyEvent, int i, int i2) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            return mDVRLibrary.a(keyEvent, i, i2);
        }
        return false;
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void onKeyZoom(KeyEvent keyEvent, float f) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(keyEvent, f);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void onRenderDestory() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.m();
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void onRenderPause() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.b(this.m);
            this.n = true;
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void onRenderReset() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.n();
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void onRenderResume() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.c(this.m);
            this.n = false;
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void onTextureResize(int i, int i2) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(i, i2);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void onWindowResize(int i, int i2) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(i, i2);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void resetPerspective() {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.w("RenderLibrary", "mMDVRLibrary is null ");
        } else {
            mDVRLibrary.n();
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setAntiDistortionEnabled(boolean z) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.d("RenderLibrary", "mMDVRLibrary is null ");
        } else {
            mDVRLibrary.a(z);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setBulletIndex(int i) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(i);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setBulletTime(int i, boolean z) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(i, z);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setDisplayMode(int i) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.d("RenderLibrary", "mMDVRLibrary is null ");
        } else {
            mDVRLibrary.a(this.m, i);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setDisplayRotation(int i) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.d("RenderLibrary", "mMDVRLibrary is null ");
        } else {
            mDVRLibrary.b(i);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setEulerAngles(float f, float f2, float f3, int i) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(f, f2, f3, i);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setFlingEnabled(boolean z) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.d(z);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setFlingSensitivity(float f) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(f);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setGestureListener(IRender.GestureListener gestureListener) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(gestureListener);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setInteractiveMode(int i) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.d("RenderLibrary", "mMDVRLibrary is null ");
        } else {
            mDVRLibrary.b(this.m, i);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setOnBulletIndexChangedListener(IRender.OnBulletIndexChangedListener onBulletIndexChangedListener) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(onBulletIndexChangedListener);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setOnBulletTimeStateListener(IRender.OnBulletTimeStateListener onBulletTimeStateListener) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(onBulletTimeStateListener);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setOnStateChangedListener(IRender.OnStateChangedListener onStateChangedListener) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(onStateChangedListener);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setOnSurfaceDestroyCallback(IRender.IOnSurfaceDestroyCallback iOnSurfaceDestroyCallback) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(iOnSurfaceDestroyCallback);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setOnSurfaceReadyCallback(IRender.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
        LogEx.d("RenderLibrary", "setOnSurfaceReadyCallback");
        if (this.l != null) {
            LogEx.d("RenderLibrary", "setOnSurfaceReadyCallback");
            this.l.a(iOnSurfaceReadyCallback);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setPinchEnabled(boolean z) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.d("RenderLibrary", "mMDVRLibrary is null ");
        } else {
            mDVRLibrary.e(z);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setPinchMaxScale(float f) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.b(f);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setPinchMinScale(float f) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.c(f);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setPinchScale(float f) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.d(f);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setPinchSensitivity(float f) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.e(f);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setProjectionMode(int i) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary == null) {
            LogEx.d("RenderLibrary", "mMDVRLibrary is null ");
        } else {
            mDVRLibrary.c(this.m, i);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setTouchSensitivity(float f) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.f(f);
        }
    }

    @Override // com.video.androidsdk.player.render.IRender
    public void setVideoWindow(Rect rect) {
        MDVRLibrary mDVRLibrary = this.l;
        if (mDVRLibrary != null) {
            mDVRLibrary.a(rect);
        }
    }
}
