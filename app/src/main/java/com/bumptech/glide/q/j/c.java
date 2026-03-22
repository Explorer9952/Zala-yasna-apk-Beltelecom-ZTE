package com.bumptech.glide.q.j;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: DrawableImageViewTarget.java */
/* loaded from: classes.dex */
public class c extends e<Drawable> {
    public c(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.q.j.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(Drawable drawable) {
        ((ImageView) this.f2326b).setImageDrawable(drawable);
    }
}
