package com.zte.iptvclient.android.mobile.share.decoding;

import com.google.zxing.LuminanceSource;

/* loaded from: classes2.dex */
public final class RGBLuminanceSource extends LuminanceSource {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f7198a;

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        return this.f7198a;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int i, byte[] bArr) {
        if (i >= 0 && i < getHeight()) {
            int width = getWidth();
            if (bArr == null || bArr.length < width) {
                bArr = new byte[width];
            }
            System.arraycopy(this.f7198a, i * width, bArr, 0, width);
            return bArr;
        }
        throw new IllegalArgumentException("Requested row is outside the image: " + i);
    }
}
