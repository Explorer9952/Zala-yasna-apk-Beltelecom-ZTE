package com.player;

import android.util.Log;
import android.view.Surface;
import com.player.b;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: OmafMediaPlayer.java */
/* loaded from: classes.dex */
class g implements b.g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Surface f2419a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OmafMediaPlayer f2420b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(OmafMediaPlayer omafMediaPlayer, Surface surface) {
        this.f2420b = omafMediaPlayer;
        this.f2419a = surface;
    }

    @Override // com.player.b.g
    public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
        return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, this.f2419a, null);
    }

    @Override // com.player.b.g
    public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        Log.i(OmafMediaPlayer.D, "eglDestroySurface 2");
        egl10.eglDestroySurface(eGLDisplay, eGLSurface);
    }
}
