package com.player;

import android.util.Log;
import android.view.SurfaceHolder;
import com.player.b;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OmafMediaPlayer.java */
/* loaded from: classes.dex */
public class e implements b.g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OmafMediaPlayer f2417a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(OmafMediaPlayer omafMediaPlayer) {
        this.f2417a = omafMediaPlayer;
    }

    @Override // com.player.b.g
    public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
        SurfaceHolder surfaceHolder;
        Log.i(OmafMediaPlayer.D, "eglCreateWindowSurface");
        surfaceHolder = this.f2417a.f2392d;
        return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, surfaceHolder.getSurface(), null);
    }

    @Override // com.player.b.g
    public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        Log.i(OmafMediaPlayer.D, "eglDestroySurface 1");
        egl10.eglDestroySurface(eGLDisplay, eGLSurface);
    }
}
