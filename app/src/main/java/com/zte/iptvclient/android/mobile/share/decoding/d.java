package com.zte.iptvclient.android.mobile.share.decoding;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.mobile.share.activity.CaptureActivity;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeThread.java */
/* loaded from: classes2.dex */
public final class d extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final CaptureActivity f7214a;

    /* renamed from: c, reason: collision with root package name */
    private Handler f7216c;

    /* renamed from: d, reason: collision with root package name */
    private final CountDownLatch f7217d = new CountDownLatch(1);

    /* renamed from: b, reason: collision with root package name */
    private final Hashtable<DecodeHintType, Object> f7215b = new Hashtable<>(3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CaptureActivity captureActivity, Vector<BarcodeFormat> vector, String str, ResultPointCallback resultPointCallback) {
        this.f7214a = captureActivity;
        if (vector == null || vector.isEmpty()) {
            vector = new Vector<>();
            vector.addAll(b.f7208b);
            vector.addAll(b.f7209c);
            vector.addAll(b.f7210d);
        }
        this.f7215b.put(DecodeHintType.POSSIBLE_FORMATS, vector);
        if (str != null) {
            this.f7215b.put(DecodeHintType.CHARACTER_SET, str);
        }
        this.f7215b.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultPointCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler a() {
        try {
            this.f7217d.await();
        } catch (InterruptedException e) {
            LogEx.d("ie=", e.toString());
        }
        return this.f7216c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Looper.prepare();
        this.f7216c = new c(this.f7214a, this.f7215b);
        this.f7217d.countDown();
        Looper.loop();
    }
}
