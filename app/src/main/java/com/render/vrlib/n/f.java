package com.render.vrlib.n;

import android.graphics.SurfaceTexture;
import com.rendergl.google.android.apps.muzei.GLTextureView;

/* compiled from: MD360VideoTexture.java */
/* loaded from: classes.dex */
class f implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f2593a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.f2593a = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        GLTextureView.a aVar = this.f2593a.f2590c;
        if (aVar != null) {
            aVar.a(surfaceTexture);
        }
    }
}
