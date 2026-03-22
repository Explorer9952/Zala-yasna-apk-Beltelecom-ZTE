package zime.media;

import android.hardware.Camera;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements Camera.PreviewCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoDeviceCallBack f8620a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VideoDeviceCallBack videoDeviceCallBack) {
        this.f8620a = videoDeviceCallBack;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        byte[] bArr2;
        synchronized (this) {
            bArr2 = this.f8620a.mFrameYUV;
            if (bArr2 != null && bArr != null && bArr.length > 0) {
                this.f8620a.mCapReady = true;
            }
        }
    }
}
