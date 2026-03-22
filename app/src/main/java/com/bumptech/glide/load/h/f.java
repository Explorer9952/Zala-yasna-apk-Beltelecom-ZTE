package com.bumptech.glide.load.h;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: ImageVideoModelLoader.java */
/* loaded from: classes.dex */
public class f<A> implements l<A, g> {

    /* renamed from: a, reason: collision with root package name */
    private final l<A, InputStream> f2080a;

    /* renamed from: b, reason: collision with root package name */
    private final l<A, ParcelFileDescriptor> f2081b;

    /* compiled from: ImageVideoModelLoader.java */
    /* loaded from: classes.dex */
    static class a implements com.bumptech.glide.load.g.c<g> {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.g.c<InputStream> f2082a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.load.g.c<ParcelFileDescriptor> f2083b;

        public a(com.bumptech.glide.load.g.c<InputStream> cVar, com.bumptech.glide.load.g.c<ParcelFileDescriptor> cVar2) {
            this.f2082a = cVar;
            this.f2083b = cVar2;
        }

        @Override // com.bumptech.glide.load.g.c
        public void b() {
            com.bumptech.glide.load.g.c<InputStream> cVar = this.f2082a;
            if (cVar != null) {
                cVar.b();
            }
            com.bumptech.glide.load.g.c<ParcelFileDescriptor> cVar2 = this.f2083b;
            if (cVar2 != null) {
                cVar2.b();
            }
        }

        @Override // com.bumptech.glide.load.g.c
        public void cancel() {
            com.bumptech.glide.load.g.c<InputStream> cVar = this.f2082a;
            if (cVar != null) {
                cVar.cancel();
            }
            com.bumptech.glide.load.g.c<ParcelFileDescriptor> cVar2 = this.f2083b;
            if (cVar2 != null) {
                cVar2.cancel();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.bumptech.glide.load.g.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.bumptech.glide.load.h.g a(com.bumptech.glide.Priority r6) throws java.lang.Exception {
            /*
                r5 = this;
                com.bumptech.glide.load.g.c<java.io.InputStream> r0 = r5.f2082a
                r1 = 2
                r2 = 0
                java.lang.String r3 = "IVML"
                if (r0 == 0) goto L21
                java.lang.Object r0 = r0.a(r6)     // Catch: java.lang.Exception -> Lf
                java.io.InputStream r0 = (java.io.InputStream) r0     // Catch: java.lang.Exception -> Lf
                goto L22
            Lf:
                r0 = move-exception
                boolean r4 = android.util.Log.isLoggable(r3, r1)
                if (r4 == 0) goto L1b
                java.lang.String r4 = "Exception fetching input stream, trying ParcelFileDescriptor"
                android.util.Log.v(r3, r4, r0)
            L1b:
                com.bumptech.glide.load.g.c<android.os.ParcelFileDescriptor> r4 = r5.f2083b
                if (r4 == 0) goto L20
                goto L21
            L20:
                throw r0
            L21:
                r0 = r2
            L22:
                com.bumptech.glide.load.g.c<android.os.ParcelFileDescriptor> r4 = r5.f2083b
                if (r4 == 0) goto L3e
                java.lang.Object r6 = r4.a(r6)     // Catch: java.lang.Exception -> L2e
                android.os.ParcelFileDescriptor r6 = (android.os.ParcelFileDescriptor) r6     // Catch: java.lang.Exception -> L2e
                r2 = r6
                goto L3e
            L2e:
                r6 = move-exception
                boolean r1 = android.util.Log.isLoggable(r3, r1)
                if (r1 == 0) goto L3a
                java.lang.String r1 = "Exception fetching ParcelFileDescriptor"
                android.util.Log.v(r3, r1, r6)
            L3a:
                if (r0 == 0) goto L3d
                goto L3e
            L3d:
                throw r6
            L3e:
                com.bumptech.glide.load.h.g r6 = new com.bumptech.glide.load.h.g
                r6.<init>(r0, r2)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.h.f.a.a(com.bumptech.glide.Priority):com.bumptech.glide.load.h.g");
        }

        @Override // com.bumptech.glide.load.g.c
        public String a() {
            com.bumptech.glide.load.g.c<InputStream> cVar = this.f2082a;
            if (cVar != null) {
                return cVar.a();
            }
            return this.f2083b.a();
        }
    }

    public f(l<A, InputStream> lVar, l<A, ParcelFileDescriptor> lVar2) {
        if (lVar == null && lVar2 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.f2080a = lVar;
        this.f2081b = lVar2;
    }

    @Override // com.bumptech.glide.load.h.l
    public com.bumptech.glide.load.g.c<g> a(A a2, int i, int i2) {
        l<A, InputStream> lVar = this.f2080a;
        com.bumptech.glide.load.g.c<InputStream> a3 = lVar != null ? lVar.a(a2, i, i2) : null;
        l<A, ParcelFileDescriptor> lVar2 = this.f2081b;
        com.bumptech.glide.load.g.c<ParcelFileDescriptor> a4 = lVar2 != null ? lVar2.a(a2, i, i2) : null;
        if (a3 == null && a4 == null) {
            return null;
        }
        return new a(a3, a4);
    }
}
