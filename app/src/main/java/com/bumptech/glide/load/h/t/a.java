package com.bumptech.glide.load.h.t;

import android.content.Context;
import com.bumptech.glide.load.h.k;
import com.bumptech.glide.load.h.l;
import com.bumptech.glide.load.h.m;
import com.google.vr.cardboard.TransitionView;
import java.io.InputStream;

/* compiled from: HttpUrlGlideUrlLoader.java */
/* loaded from: classes.dex */
public class a implements l<com.bumptech.glide.load.h.d, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final k<com.bumptech.glide.load.h.d, com.bumptech.glide.load.h.d> f2107a;

    /* compiled from: HttpUrlGlideUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.h.t.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0068a implements m<com.bumptech.glide.load.h.d, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final k<com.bumptech.glide.load.h.d, com.bumptech.glide.load.h.d> f2108a = new k<>(TransitionView.TRANSITION_ANIMATION_DURATION_MS);

        @Override // com.bumptech.glide.load.h.m
        public l<com.bumptech.glide.load.h.d, InputStream> a(Context context, com.bumptech.glide.load.h.c cVar) {
            return new a(this.f2108a);
        }

        @Override // com.bumptech.glide.load.h.m
        public void a() {
        }
    }

    public a(k<com.bumptech.glide.load.h.d, com.bumptech.glide.load.h.d> kVar) {
        this.f2107a = kVar;
    }

    @Override // com.bumptech.glide.load.h.l
    public com.bumptech.glide.load.g.c<InputStream> a(com.bumptech.glide.load.h.d dVar, int i, int i2) {
        k<com.bumptech.glide.load.h.d, com.bumptech.glide.load.h.d> kVar = this.f2107a;
        if (kVar != null) {
            com.bumptech.glide.load.h.d a2 = kVar.a(dVar, 0, 0);
            if (a2 == null) {
                this.f2107a.a(dVar, 0, 0, dVar);
            } else {
                dVar = a2;
            }
        }
        return new com.bumptech.glide.load.g.f(dVar);
    }
}
