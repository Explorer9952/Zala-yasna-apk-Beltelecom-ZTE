package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.openapi.WXMediaMessage;

/* loaded from: classes.dex */
public class WXFileObject implements WXMediaMessage.IMediaObject {
    public byte[] fileData;
    public String filePath;

    public WXFileObject() {
        this.fileData = null;
        this.filePath = null;
    }

    public WXFileObject(String str) {
        this.filePath = str;
    }

    public WXFileObject(byte[] bArr) {
        this.fileData = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean checkArgs() {
        /*
            r6 = this;
            byte[] r0 = r6.fileData
            java.lang.String r1 = "MicroMsg.SDK.WXFileObject"
            r2 = 0
            if (r0 == 0) goto La
            int r0 = r0.length
            if (r0 != 0) goto L15
        La:
            java.lang.String r0 = r6.filePath
            if (r0 == 0) goto L4b
            int r0 = r0.length()
            if (r0 != 0) goto L15
            goto L4b
        L15:
            byte[] r0 = r6.fileData
            r3 = 10485760(0xa00000, float:1.469368E-38)
            if (r0 == 0) goto L24
            int r0 = r0.length
            if (r0 <= r3) goto L24
            java.lang.String r0 = "checkArgs fail, fileData is too large"
        L20:
            com.tencent.mm.sdk.platformtools.Log.e(r1, r0)
            return r2
        L24:
            java.lang.String r0 = r6.filePath
            if (r0 == 0) goto L49
            if (r0 == 0) goto L43
            int r4 = r0.length()
            if (r4 != 0) goto L31
            goto L43
        L31:
            java.io.File r4 = new java.io.File
            r4.<init>(r0)
            boolean r0 = r4.exists()
            if (r0 != 0) goto L3d
            goto L43
        L3d:
            long r4 = r4.length()
            int r0 = (int) r4
            goto L44
        L43:
            r0 = 0
        L44:
            if (r0 <= r3) goto L49
            java.lang.String r0 = "checkArgs fail, fileSize is too large"
            goto L20
        L49:
            r0 = 1
            return r0
        L4b:
            java.lang.String r0 = "checkArgs fail, both arguments is null"
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.openapi.WXFileObject.checkArgs():boolean");
    }

    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxfileobject_fileData", this.fileData);
        bundle.putString("_wxfileobject_filePath", this.filePath);
    }

    public void setFileData(byte[] bArr) {
        this.fileData = bArr;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    public int type() {
        return 6;
    }

    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.fileData = bundle.getByteArray("_wxfileobject_fileData");
        this.filePath = bundle.getString("_wxfileobject_filePath");
    }
}
