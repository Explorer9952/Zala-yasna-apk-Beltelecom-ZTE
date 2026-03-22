package com.video.androidsdk.common.util;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class ThumbBitmap {
    Bitmap bitmap;
    byte[] cache;

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public byte[] getCache() {
        return this.cache;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setCache(byte[] bArr) {
        this.cache = bArr;
    }
}
