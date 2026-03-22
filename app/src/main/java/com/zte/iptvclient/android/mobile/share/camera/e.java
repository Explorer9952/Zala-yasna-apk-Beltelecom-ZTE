package com.zte.iptvclient.android.mobile.share.camera;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewCallback.java */
/* loaded from: classes2.dex */
public final class e implements Camera.PreviewCallback {
    private static final String e = e.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private final b f7194a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f7195b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f7196c;

    /* renamed from: d, reason: collision with root package name */
    private int f7197d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, boolean z) {
        this.f7194a = bVar;
        this.f7195b = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Handler handler, int i) {
        this.f7196c = handler;
        this.f7197d = i;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point a2 = this.f7194a.a();
        if (!this.f7195b) {
            camera.setPreviewCallback(null);
        }
        Handler handler = this.f7196c;
        if (handler != null) {
            handler.obtainMessage(this.f7197d, a2.x, a2.y, bArr).sendToTarget();
            this.f7196c = null;
        } else {
            Log.d(e, "Got preview callback, but no handler for it");
        }
    }
}
