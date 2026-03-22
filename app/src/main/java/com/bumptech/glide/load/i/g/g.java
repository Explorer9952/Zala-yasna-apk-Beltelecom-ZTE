package com.bumptech.glide.load.i.g;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.h.l;

/* compiled from: GifFrameModelLoader.java */
/* loaded from: classes.dex */
class g implements l<com.bumptech.glide.m.a, com.bumptech.glide.m.a> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GifFrameModelLoader.java */
    /* loaded from: classes.dex */
    public static class a implements com.bumptech.glide.load.g.c<com.bumptech.glide.m.a> {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.m.a f2143a;

        public a(com.bumptech.glide.m.a aVar) {
            this.f2143a = aVar;
        }

        @Override // com.bumptech.glide.load.g.c
        public void b() {
        }

        @Override // com.bumptech.glide.load.g.c
        public void cancel() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.g.c
        public com.bumptech.glide.m.a a(Priority priority) {
            return this.f2143a;
        }

        @Override // com.bumptech.glide.load.g.c
        public String a() {
            return String.valueOf(this.f2143a.c());
        }
    }

    @Override // com.bumptech.glide.load.h.l
    public com.bumptech.glide.load.g.c<com.bumptech.glide.m.a> a(com.bumptech.glide.m.a aVar, int i, int i2) {
        return new a(aVar);
    }
}
