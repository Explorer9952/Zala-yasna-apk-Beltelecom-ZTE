package com.tencent.mm.sdk.openapi;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class WXImageObject implements WXMediaMessage.IMediaObject {
    public byte[] imageData;
    public String imagePath;
    public String imageUrl;

    public WXImageObject() {
    }

    public WXImageObject(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WXImageObject(byte[] bArr) {
        this.imageData = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean checkArgs() {
        /*
            r7 = this;
            byte[] r0 = r7.imageData
            java.lang.String r1 = "MicroMsg.SDK.WXImageObject"
            r2 = 0
            if (r0 == 0) goto La
            int r0 = r0.length
            if (r0 != 0) goto L1f
        La:
            java.lang.String r0 = r7.imagePath
            if (r0 == 0) goto L14
            int r0 = r0.length()
            if (r0 != 0) goto L1f
        L14:
            java.lang.String r0 = r7.imageUrl
            if (r0 == 0) goto L71
            int r0 = r0.length()
            if (r0 != 0) goto L1f
            goto L71
        L1f:
            byte[] r0 = r7.imageData
            r3 = 10485760(0xa00000, float:1.469368E-38)
            if (r0 == 0) goto L2e
            int r0 = r0.length
            if (r0 <= r3) goto L2e
            java.lang.String r0 = "checkArgs fail, content is too large"
        L2a:
            com.tencent.mm.sdk.platformtools.Log.e(r1, r0)
            return r2
        L2e:
            java.lang.String r0 = r7.imagePath
            r4 = 10240(0x2800, float:1.4349E-41)
            if (r0 == 0) goto L3d
            int r0 = r0.length()
            if (r0 <= r4) goto L3d
            java.lang.String r0 = "checkArgs fail, path is invalid"
            goto L2a
        L3d:
            java.lang.String r0 = r7.imagePath
            if (r0 == 0) goto L62
            if (r0 == 0) goto L5c
            int r5 = r0.length()
            if (r5 != 0) goto L4a
            goto L5c
        L4a:
            java.io.File r5 = new java.io.File
            r5.<init>(r0)
            boolean r0 = r5.exists()
            if (r0 != 0) goto L56
            goto L5c
        L56:
            long r5 = r5.length()
            int r0 = (int) r5
            goto L5d
        L5c:
            r0 = 0
        L5d:
            if (r0 <= r3) goto L62
            java.lang.String r0 = "checkArgs fail, image content is too large"
            goto L2a
        L62:
            java.lang.String r0 = r7.imageUrl
            if (r0 == 0) goto L6f
            int r0 = r0.length()
            if (r0 <= r4) goto L6f
            java.lang.String r0 = "checkArgs fail, url is invalid"
            goto L2a
        L6f:
            r0 = 1
            return r0
        L71:
            java.lang.String r0 = "checkArgs fail, all arguments are null"
            goto L2a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.openapi.WXImageObject.checkArgs():boolean");
    }

    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
        bundle.putString("_wximageobject_imageUrl", this.imageUrl);
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    public int type() {
        return 2;
    }

    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
        this.imageUrl = bundle.getString("_wximageobject_imageUrl");
    }
}
