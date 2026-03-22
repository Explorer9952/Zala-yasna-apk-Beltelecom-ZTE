package com.player;

import android.content.Context;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.util.Log;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OmafMediaPlayer.java */
/* loaded from: classes.dex */
public class d implements GLSurfaceView.Renderer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OmafMediaPlayer f2416a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(OmafMediaPlayer omafMediaPlayer) {
        this.f2416a = omafMediaPlayer;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        Context context;
        long j;
        context = this.f2416a.e;
        synchronized (context) {
            j = this.f2416a.f2389a;
            OmafMediaPlayer.nativeDraw(j);
            int glGetError = gl10.glGetError();
            if (glGetError != 0) {
                Log.e(OmafMediaPlayer.D, Thread.currentThread() + " 2 errorCode =" + glGetError);
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        gl10.glViewport(0, 0, i, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        boolean z;
        boolean f;
        Uri uri;
        Uri uri2;
        Uri uri3;
        Uri uri4;
        int i;
        int i2;
        int i3;
        int i4;
        z = this.f2416a.q;
        if (z) {
            this.f2416a.nativeOnSurfaceCreated();
            return;
        }
        String str = OmafMediaPlayer.D;
        StringBuilder sb = new StringBuilder();
        sb.append("onSurfaceCreated ");
        sb.append(Thread.currentThread().toString());
        sb.append(" main ");
        f = this.f2416a.f();
        sb.append(f);
        Log.d(str, sb.toString());
        this.f2416a.d();
        uri = this.f2416a.f2391c;
        if (uri != null) {
            String str2 = OmafMediaPlayer.D;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("start ");
            uri3 = this.f2416a.f2391c;
            sb2.append(uri3.toString());
            Log.i(str2, sb2.toString());
            uri4 = this.f2416a.f2391c;
            OmafMediaPlayer.nativeLoadContent(uri4.toString());
            String str3 = OmafMediaPlayer.D;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("1 SetTextureId  base:");
            i = this.f2416a.l;
            sb3.append(i);
            sb3.append("  enh:");
            i2 = this.f2416a.m;
            sb3.append(i2);
            Log.d(str3, sb3.toString());
            OmafMediaPlayer omafMediaPlayer = this.f2416a;
            i3 = omafMediaPlayer.l;
            omafMediaPlayer.nativeSetTextureId(0, i3);
            OmafMediaPlayer omafMediaPlayer2 = this.f2416a;
            i4 = omafMediaPlayer2.m;
            omafMediaPlayer2.nativeSetTextureId(1, i4);
            Log.d(OmafMediaPlayer.D, "1 SetTextureId");
        } else {
            Log.e(OmafMediaPlayer.D, "on uri!!");
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("start ");
        uri2 = this.f2416a.f2391c;
        sb4.append(uri2.toString());
        Log.i("jiang", sb4.toString());
        this.f2416a.q = true;
    }
}
