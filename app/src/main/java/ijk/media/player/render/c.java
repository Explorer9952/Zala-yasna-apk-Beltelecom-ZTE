package ijk.media.player.render;

import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FVGlSurfaceView.java */
/* loaded from: classes2.dex */
public class c implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FVGlSurfaceView f8122a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FVGlSurfaceView fVGlSurfaceView) {
        this.f8122a = fVGlSurfaceView;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        int i;
        int i2;
        long j;
        int i3;
        String str;
        long j2;
        long j3;
        this.f8122a.requestRender();
        FVGlSurfaceView.a(this.f8122a);
        FVGlSurfaceView.b(this.f8122a);
        i = this.f8122a.v;
        if (i != 0) {
            i2 = this.f8122a.v;
            if (i2 == 100) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                j = this.f8122a.t;
                long j4 = elapsedRealtime - j;
                FVGlSurfaceView fVGlSurfaceView = this.f8122a;
                i3 = fVGlSurfaceView.v;
                fVGlSurfaceView.y = (i3 * 1000) / j4;
                str = FVGlSurfaceView.f8114c;
                StringBuilder sb = new StringBuilder();
                sb.append("totalRenderCount ");
                j2 = this.f8122a.u;
                sb.append(j2);
                sb.append("  FPS : ");
                j3 = this.f8122a.y;
                sb.append(j3);
                sb.append("  elapsedTimeMs is ");
                sb.append(j4);
                Log.d(str, sb.toString());
                this.f8122a.v = 0;
                this.f8122a.t = SystemClock.elapsedRealtime();
                return;
            }
            return;
        }
        this.f8122a.t = SystemClock.elapsedRealtime();
    }
}
