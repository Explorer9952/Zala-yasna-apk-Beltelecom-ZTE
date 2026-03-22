package com.player;

import android.util.Log;
import android.view.Surface;
import com.player.b;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OmafMediaPlayer.java */
/* loaded from: classes.dex */
public class h implements b.g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OmafMediaPlayer f2421a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(OmafMediaPlayer omafMediaPlayer) {
        this.f2421a = omafMediaPlayer;
    }

    @Override // com.player.b.g
    public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
        Surface surface;
        surface = this.f2421a.k;
        return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, surface, null);
    }

    @Override // com.player.b.g
    public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        Log.i(OmafMediaPlayer.D, "eglDestroySurface 3");
        egl10.eglDestroySurface(eGLDisplay, eGLSurface);
    }
}
