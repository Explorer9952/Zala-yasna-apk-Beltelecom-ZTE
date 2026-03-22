package com.render.vrlib;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.View;
import com.rendergl.google.android.apps.muzei.GLTextureView;

/* compiled from: MDGLScreenWrapper.java */
/* loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MDGLScreenWrapper.java */
    /* loaded from: classes.dex */
    public static class a extends q {

        /* renamed from: a, reason: collision with root package name */
        GLSurfaceView f2599a;

        @Override // com.render.vrlib.q
        public View a() {
            return this.f2599a;
        }

        @Override // com.render.vrlib.q
        public void b() {
            this.f2599a.onResume();
        }

        @Override // com.render.vrlib.q
        public void c() {
            this.f2599a.onPause();
        }

        @Override // com.render.vrlib.q
        public void d() {
        }

        private a(GLSurfaceView gLSurfaceView) {
            this.f2599a = gLSurfaceView;
        }

        @Override // com.render.vrlib.q
        public void a(GLSurfaceView.Renderer renderer) {
            this.f2599a.setRenderer(renderer);
        }

        @Override // com.render.vrlib.q
        public void a(Context context) {
            this.f2599a.setEGLContextClientVersion(2);
            this.f2599a.setPreserveEGLContextOnPause(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MDGLScreenWrapper.java */
    /* loaded from: classes.dex */
    public static class b extends q {

        /* renamed from: a, reason: collision with root package name */
        GLTextureView f2600a;

        public b(GLTextureView gLTextureView) {
            this.f2600a = gLTextureView;
        }

        @Override // com.render.vrlib.q
        public View a() {
            return this.f2600a;
        }

        @Override // com.render.vrlib.q
        public void a(Context context) {
        }

        @Override // com.render.vrlib.q
        public void b() {
            this.f2600a.a(false);
        }

        @Override // com.render.vrlib.q
        public void c() {
            this.f2600a.a(true);
        }

        @Override // com.render.vrlib.q
        public void d() {
            this.f2600a.b();
        }

        @Override // com.render.vrlib.q
        public void a(GLSurfaceView.Renderer renderer) {
            this.f2600a.a(renderer);
        }
    }

    public static q a(GLSurfaceView gLSurfaceView) {
        return new a(gLSurfaceView);
    }

    public abstract View a();

    public abstract void a(Context context);

    public abstract void a(GLSurfaceView.Renderer renderer);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public static q a(GLTextureView gLTextureView) {
        return new b(gLTextureView);
    }
}
