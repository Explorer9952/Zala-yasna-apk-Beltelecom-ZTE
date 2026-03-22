package com.bumptech.glide.q.j;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.q.i.c;

/* compiled from: ImageViewTarget.java */
/* loaded from: classes.dex */
public abstract class e<Z> extends k<ImageView, Z> implements c.a {
    public e(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.q.i.c.a
    public void a(Drawable drawable) {
        ((ImageView) this.f2326b).setImageDrawable(drawable);
    }

    protected abstract void a(Z z);

    @Override // com.bumptech.glide.q.j.a, com.bumptech.glide.q.j.j
    public void b(Drawable drawable) {
        ((ImageView) this.f2326b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.q.i.c.a
    public Drawable c() {
        return ((ImageView) this.f2326b).getDrawable();
    }

    @Override // com.bumptech.glide.q.j.a, com.bumptech.glide.q.j.j
    public void a(Exception exc, Drawable drawable) {
        ((ImageView) this.f2326b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.q.j.a, com.bumptech.glide.q.j.j
    public void c(Drawable drawable) {
        ((ImageView) this.f2326b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.q.j.j
    public void a(Z z, com.bumptech.glide.q.i.c<? super Z> cVar) {
        if (cVar == null || !cVar.a(z, this)) {
            a((e<Z>) z);
        }
    }
}
