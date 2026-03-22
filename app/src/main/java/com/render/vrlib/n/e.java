package com.render.vrlib.n;

import android.graphics.SurfaceTexture;
import com.rendergl.google.android.apps.muzei.GLTextureView;

/* compiled from: MD360VideoTexture.java */
/* loaded from: classes.dex */
class e implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f2592a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f2592a = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        GLTextureView.a aVar = this.f2592a.f2590c;
        if (aVar != null) {
            aVar.a(surfaceTexture);
        }
    }
}
