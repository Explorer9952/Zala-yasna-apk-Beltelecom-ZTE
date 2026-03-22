package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.openapi.WXMediaMessage;

/* loaded from: classes.dex */
public class WXAppExtendObject implements WXMediaMessage.IMediaObject {
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    public WXAppExtendObject() {
    }

    public WXAppExtendObject(String str, String str2) {
        this.extInfo = str;
        this.filePath = str2;
    }

    public WXAppExtendObject(String str, byte[] bArr) {
        this.extInfo = str;
        this.fileData = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean checkArgs() {
        /*
            r6 = this;
            java.lang.String r0 = r6.extInfo
            java.lang.String r1 = "MicroMsg.SDK.WXAppExtendObject"
            r2 = 0
            if (r0 == 0) goto Ld
            int r0 = r0.length()
            if (r0 != 0) goto L1f
        Ld:
            java.lang.String r0 = r6.filePath
            if (r0 == 0) goto L17
            int r0 = r0.length()
            if (r0 != 0) goto L1f
        L17:
            byte[] r0 = r6.fileData
            if (r0 == 0) goto L73
            int r0 = r0.length
            if (r0 != 0) goto L1f
            goto L73
        L1f:
            java.lang.String r0 = r6.extInfo
            if (r0 == 0) goto L31
            int r0 = r0.length()
            r3 = 2048(0x800, float:2.87E-42)
            if (r0 <= r3) goto L31
            java.lang.String r0 = "checkArgs fail, extInfo is invalid"
        L2d:
            com.tencent.mm.sdk.platformtools.Log.e(r1, r0)
            return r2
        L31:
            java.lang.String r0 = r6.filePath
            if (r0 == 0) goto L40
            int r0 = r0.length()
            r3 = 10240(0x2800, float:1.4349E-41)
            if (r0 <= r3) goto L40
            java.lang.String r0 = "checkArgs fail, filePath is invalid"
            goto L2d
        L40:
            java.lang.String r0 = r6.filePath
            r3 = 10485760(0xa00000, float:1.469368E-38)
            if (r0 == 0) goto L67
            if (r0 == 0) goto L61
            int r4 = r0.length()
            if (r4 != 0) goto L4f
            goto L61
        L4f:
            java.io.File r4 = new java.io.File
            r4.<init>(r0)
            boolean r0 = r4.exists()
            if (r0 != 0) goto L5b
            goto L61
        L5b:
            long r4 = r4.length()
            int r0 = (int) r4
            goto L62
        L61:
            r0 = 0
        L62:
            if (r0 <= r3) goto L67
            java.lang.String r0 = "checkArgs fail, fileSize is too large"
            goto L2d
        L67:
            byte[] r0 = r6.fileData
            if (r0 == 0) goto L71
            int r0 = r0.length
            if (r0 <= r3) goto L71
            java.lang.String r0 = "checkArgs fail, fileData is too large"
            goto L2d
        L71:
            r0 = 1
            return r0
        L73:
            java.lang.String r0 = "checkArgs fail, all arguments is null"
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.openapi.WXAppExtendObject.checkArgs():boolean");
    }

    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxappextendobject_extInfo", this.extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", this.fileData);
        bundle.putString("_wxappextendobject_filePath", this.filePath);
    }

    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    public int type() {
        return 7;
    }

    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.extInfo = bundle.getString("_wxappextendobject_extInfo");
        this.fileData = bundle.getByteArray("_wxappextendobject_fileData");
        this.filePath = bundle.getString("_wxappextendobject_filePath");
    }
}
