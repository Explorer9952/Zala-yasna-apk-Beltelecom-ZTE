package com.rendergl.google.android.apps.muzei;

import android.graphics.SurfaceTexture;
import com.rendergl.google.android.apps.muzei.GLTextureView;

/* compiled from: GLTextureView.java */
/* loaded from: classes.dex */
class b implements GLTextureView.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GLTextureView.b f2678a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GLTextureView.b bVar) {
        this.f2678a = bVar;
    }

    @Override // com.rendergl.google.android.apps.muzei.GLTextureView.a
    public void a(SurfaceTexture surfaceTexture) {
        GLTextureView.this.x = true;
    }
}
