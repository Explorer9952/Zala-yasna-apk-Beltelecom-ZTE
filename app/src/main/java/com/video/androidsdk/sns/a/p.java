package com.video.androidsdk.sns.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.tencent.mm.sdk.openapi.WXImageObject;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXTextObject;
import com.video.androidsdk.common.DeviceInfo;
import com.video.androidsdk.common.util.BitmapUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.ISNSActionListener;
import com.video.androidsdk.sns.bean.SNSMessage;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TencentWechat.java */
/* loaded from: classes.dex */
public class p extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SNSMessage f3861a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f3862b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ISNSActionListener f3863c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ n f3864d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar, SNSMessage sNSMessage, Context context, ISNSActionListener iSNSActionListener) {
        this.f3864d = nVar;
        this.f3861a = sNSMessage;
        this.f3862b = context;
        this.f3863c = iSNSActionListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        String str2;
        try {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            if (this.f3861a.getTitle() != null) {
                wXMediaMessage.title = this.f3861a.getTitle();
            }
            if (this.f3861a.getText() != null) {
                WXTextObject wXTextObject = new WXTextObject();
                wXTextObject.text = this.f3861a.getText();
                wXMediaMessage.mediaObject = wXTextObject;
            }
            if (this.f3861a.getBitmap() != null) {
                DisplayMetrics displayMetrix = DeviceInfo.getDisplayMetrix(this.f3862b);
                Bitmap bitmap = BitmapUtil.compressThumb(this.f3861a.getBitmap(), displayMetrix.widthPixels, displayMetrix.heightPixels, 65536, this.f3862b).getBitmap();
                wXMediaMessage.mediaObject = new WXImageObject(bitmap);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 150, 150, true);
                byte[] bitmap2Bytes = BitmapUtil.bitmap2Bytes(createScaledBitmap);
                if (bitmap2Bytes.length > 32768) {
                    double length = bitmap2Bytes.length;
                    Double.isNaN(length);
                    double d2 = 32768.0d / length;
                    double width = createScaledBitmap.getWidth();
                    Double.isNaN(width);
                    int intValue = Double.valueOf(width * d2).intValue();
                    double height = createScaledBitmap.getHeight();
                    Double.isNaN(height);
                    createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, intValue, Double.valueOf(height * d2).intValue(), true);
                    bitmap2Bytes = BitmapUtil.bitmap2Bytes(createScaledBitmap);
                }
                createScaledBitmap.recycle();
                bitmap.recycle();
                str2 = n.g;
                LogEx.d(str2, "Bitmap size:" + bitmap2Bytes.length);
                wXMediaMessage.thumbData = bitmap2Bytes;
            }
            if (this.f3861a.getDescription() != null) {
                wXMediaMessage.description = this.f3861a.getDescription();
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = UUID.randomUUID().toString();
            req.message = wXMediaMessage;
            req.scene = this.f3864d.f3857b;
            new Handler(Looper.getMainLooper()).post(new q(this, req));
        } catch (Exception e) {
            str = n.g;
            LogEx.e(str, "WX send request failed! " + e.getMessage());
            new Handler(Looper.getMainLooper()).post(new r(this, e));
        }
    }
}
