package com.bumptech.glide.q.j;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: BitmapImageViewTarget.java */
/* loaded from: classes.dex */
public class b extends e<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.q.j.e
    public void a(Bitmap bitmap) {
        ((ImageView) this.f2326b).setImageBitmap(bitmap);
    }
}
