package com.zte.iptvclient.android.mobile.share.decoding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.mobile.share.activity.CaptureActivity;
import com.zte.iptvclient.android.mobile.share.view.ViewfinderResultPointCallback;
import com.zte.iptvclient.android.zala.R;
import java.util.Vector;

/* compiled from: CaptureActivityHandler.java */
/* loaded from: classes2.dex */
public final class a extends Handler {

    /* renamed from: d, reason: collision with root package name */
    private static final String f7199d = a.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private final CaptureActivity f7200a;

    /* renamed from: b, reason: collision with root package name */
    private final d f7201b;

    /* renamed from: c, reason: collision with root package name */
    private EnumC0348a f7202c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CaptureActivityHandler.java */
    /* renamed from: com.zte.iptvclient.android.mobile.share.decoding.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0348a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public a(CaptureActivity captureActivity, Vector<BarcodeFormat> vector, String str) {
        this.f7200a = captureActivity;
        d dVar = new d(captureActivity, vector, str, new ViewfinderResultPointCallback(captureActivity.s()));
        this.f7201b = dVar;
        dVar.start();
        this.f7202c = EnumC0348a.SUCCESS;
        com.zte.iptvclient.android.mobile.share.camera.c.f().d();
        b();
    }

    private void b() {
        if (this.f7202c == EnumC0348a.SUCCESS) {
            this.f7202c = EnumC0348a.PREVIEW;
            com.zte.iptvclient.android.mobile.share.camera.c.f().b(this.f7201b.a(), R.id.decode);
            com.zte.iptvclient.android.mobile.share.camera.c.f().a(this, R.id.auto_focus);
            this.f7200a.r();
        }
    }

    public void a() {
        this.f7202c = EnumC0348a.DONE;
        com.zte.iptvclient.android.mobile.share.camera.c.f().e();
        Message.obtain(this.f7201b.a(), R.id.quit).sendToTarget();
        try {
            this.f7201b.join();
        } catch (InterruptedException e) {
            LogEx.d("e=", e.toString());
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case R.id.auto_focus /* 2131296365 */:
                if (this.f7202c == EnumC0348a.PREVIEW) {
                    com.zte.iptvclient.android.mobile.share.camera.c.f().a(this, R.id.auto_focus);
                    return;
                }
                return;
            case R.id.decode_failed /* 2131296640 */:
                this.f7202c = EnumC0348a.PREVIEW;
                com.zte.iptvclient.android.mobile.share.camera.c.f().b(this.f7201b.a(), R.id.decode);
                return;
            case R.id.decode_succeeded /* 2131296641 */:
                Log.d(f7199d, "Got decode succeeded message");
                this.f7202c = EnumC0348a.SUCCESS;
                Bundle data = message.getData();
                this.f7200a.a((Result) message.obj, data == null ? null : (Bitmap) data.getParcelable("barcode_bitmap"));
                return;
            case R.id.launch_product_query /* 2131297152 */:
                Log.d(f7199d, "Got product query message");
                String str = (String) message.obj;
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.addFlags(524288);
                this.f7200a.startActivity(intent);
                return;
            case R.id.restart_preview /* 2131297712 */:
                Log.d(f7199d, "Got restart preview message");
                b();
                return;
            case R.id.return_scan_result /* 2131297713 */:
                Log.d(f7199d, "Got return scan result message");
                this.f7200a.setResult(-1, (Intent) message.obj);
                this.f7200a.finish();
                return;
            default:
                return;
        }
    }
}
