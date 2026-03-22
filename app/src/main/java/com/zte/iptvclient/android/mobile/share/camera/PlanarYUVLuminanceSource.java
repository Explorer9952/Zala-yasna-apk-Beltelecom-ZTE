package com.zte.iptvclient.android.mobile.share.camera;

import android.graphics.Bitmap;
import com.google.zxing.LuminanceSource;

/* loaded from: classes2.dex */
public final class PlanarYUVLuminanceSource extends LuminanceSource {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f7176a;

    /* renamed from: b, reason: collision with root package name */
    private final int f7177b;

    /* renamed from: c, reason: collision with root package name */
    private final int f7178c;

    /* renamed from: d, reason: collision with root package name */
    private final int f7179d;
    private final int e;

    public PlanarYUVLuminanceSource(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i5 + i3 <= i && i6 + i4 <= i2) {
            this.f7176a = bArr;
            this.f7177b = i;
            this.f7178c = i2;
            this.f7179d = i3;
            this.e = i4;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }

    public Bitmap a() {
        int width = getWidth();
        int height = getHeight();
        int[] iArr = new int[width * height];
        byte[] bArr = this.f7176a;
        int i = (this.e * this.f7177b) + this.f7179d;
        for (int i2 = 0; i2 < height; i2++) {
            int i3 = i2 * width;
            for (int i4 = 0; i4 < width; i4++) {
                iArr[i3 + i4] = ((bArr[i + i4] & 255) * 65793) | (-16777216);
            }
            i += this.f7177b;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        if (width == this.f7177b && height == this.f7178c) {
            return this.f7176a;
        }
        int i = width * height;
        byte[] bArr = new byte[i];
        int i2 = this.e;
        int i3 = this.f7177b;
        int i4 = (i2 * i3) + this.f7179d;
        if (width == i3) {
            System.arraycopy(this.f7176a, i4, bArr, 0, i);
            return bArr;
        }
        byte[] bArr2 = this.f7176a;
        for (int i5 = 0; i5 < height; i5++) {
            System.arraycopy(bArr2, i4, bArr, i5 * width, width);
            i4 += this.f7177b;
        }
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int i, byte[] bArr) {
        if (i >= 0 && i < getHeight()) {
            int width = getWidth();
            if (bArr == null || bArr.length < width) {
                bArr = new byte[width];
            }
            System.arraycopy(this.f7176a, ((i + this.e) * this.f7177b) + this.f7179d, bArr, 0, width);
            return bArr;
        }
        throw new IllegalArgumentException("Requested row is outside the image: " + i);
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }
}
