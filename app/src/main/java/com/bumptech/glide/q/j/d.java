package com.bumptech.glide.q.j;

import android.widget.ImageView;

/* compiled from: GlideDrawableImageViewTarget.java */
/* loaded from: classes.dex */
public class d extends e<com.bumptech.glide.load.i.e.b> {
    private int e;
    private com.bumptech.glide.load.i.e.b f;

    public d(ImageView imageView) {
        this(imageView, -1);
    }

    @Override // com.bumptech.glide.q.j.e, com.bumptech.glide.q.j.j
    public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.q.i.c cVar) {
        a((com.bumptech.glide.load.i.e.b) obj, (com.bumptech.glide.q.i.c<? super com.bumptech.glide.load.i.e.b>) cVar);
    }

    @Override // com.bumptech.glide.q.j.a, com.bumptech.glide.manager.h
    public void b() {
        com.bumptech.glide.load.i.e.b bVar = this.f;
        if (bVar != null) {
            bVar.start();
        }
    }

    @Override // com.bumptech.glide.q.j.a, com.bumptech.glide.manager.h
    public void onStop() {
        com.bumptech.glide.load.i.e.b bVar = this.f;
        if (bVar != null) {
            bVar.stop();
        }
    }

    public d(ImageView imageView, int i) {
        super(imageView);
        this.e = i;
    }

    public void a(com.bumptech.glide.load.i.e.b bVar, com.bumptech.glide.q.i.c<? super com.bumptech.glide.load.i.e.b> cVar) {
        if (!bVar.a()) {
            float intrinsicWidth = bVar.getIntrinsicWidth() / bVar.getIntrinsicHeight();
            if (Math.abs((((ImageView) this.f2326b).getWidth() / ((ImageView) this.f2326b).getHeight()) - 1.0f) <= 0.05f && Math.abs(intrinsicWidth - 1.0f) <= 0.05f) {
                bVar = new i(bVar, ((ImageView) this.f2326b).getWidth());
            }
        }
        super.a((d) bVar, (com.bumptech.glide.q.i.c<? super d>) cVar);
        this.f = bVar;
        bVar.b(this.e);
        bVar.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.q.j.e
    public void a(com.bumptech.glide.load.i.e.b bVar) {
        ((ImageView) this.f2326b).setImageDrawable(bVar);
    }
}
