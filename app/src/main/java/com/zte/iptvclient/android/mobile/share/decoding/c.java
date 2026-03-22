package com.zte.iptvclient.android.mobile.share.decoding;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.mobile.share.activity.CaptureActivity;
import com.zte.iptvclient.android.mobile.share.camera.PlanarYUVLuminanceSource;
import com.zte.iptvclient.android.zala.R;
import java.util.Hashtable;

/* compiled from: DecodeHandler.java */
/* loaded from: classes2.dex */
final class c extends Handler {

    /* renamed from: c, reason: collision with root package name */
    private static final String f7211c = c.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private final CaptureActivity f7212a;

    /* renamed from: b, reason: collision with root package name */
    private final MultiFormatReader f7213b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CaptureActivity captureActivity, Hashtable<DecodeHintType, Object> hashtable) {
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.f7213b = multiFormatReader;
        multiFormatReader.setHints(hashtable);
        this.f7212a = captureActivity;
    }

    private void a(byte[] bArr, int i, int i2) {
        Result result;
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        PlanarYUVLuminanceSource a2 = com.zte.iptvclient.android.mobile.share.camera.c.f().a(bArr2, i2, i);
        try {
            try {
                result = this.f7213b.decodeWithState(new BinaryBitmap(new HybridBinarizer(a2)));
            } catch (ReaderException e) {
                LogEx.d("re=", e.toString());
                this.f7213b.reset();
                result = null;
            }
            if (result != null) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d(f7211c, "Found barcode (" + (currentTimeMillis2 - currentTimeMillis) + " ms):\n" + result.toString());
                Message obtain = Message.obtain(this.f7212a.j(), R.id.decode_succeeded, result);
                Bundle bundle = new Bundle();
                bundle.putParcelable("barcode_bitmap", a2.a());
                obtain.setData(bundle);
                obtain.sendToTarget();
                return;
            }
            Message.obtain(this.f7212a.j(), R.id.decode_failed).sendToTarget();
        } finally {
            this.f7213b.reset();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == R.id.decode) {
            a((byte[]) message.obj, message.arg1, message.arg2);
        } else {
            if (i != R.id.quit) {
                return;
            }
            Looper.myLooper().quit();
        }
    }
}
