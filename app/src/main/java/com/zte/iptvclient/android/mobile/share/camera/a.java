package com.zte.iptvclient.android.mobile.share.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* compiled from: AutoFocusCallback.java */
/* loaded from: classes2.dex */
final class a implements Camera.AutoFocusCallback {

    /* renamed from: c, reason: collision with root package name */
    private static final String f7180c = a.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private Handler f7181a;

    /* renamed from: b, reason: collision with root package name */
    private int f7182b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Handler handler, int i) {
        this.f7181a = handler;
        this.f7182b = i;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z, Camera camera) {
        Handler handler = this.f7181a;
        if (handler != null) {
            this.f7181a.sendMessageDelayed(handler.obtainMessage(this.f7182b, Boolean.valueOf(z)), 1500L);
            this.f7181a = null;
            return;
        }
        Log.d(f7180c, "Got auto-focus callback, but no handler for it");
    }
}
