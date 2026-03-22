package com.bumptech.glide.load.engine;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EngineKey.java */
/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f1989a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1990b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1991c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.d f1992d;
    private final com.bumptech.glide.load.d e;
    private final com.bumptech.glide.load.f f;
    private final com.bumptech.glide.load.e g;
    private final com.bumptech.glide.load.i.i.c h;
    private final com.bumptech.glide.load.a i;
    private final com.bumptech.glide.load.b j;
    private String k;
    private int l;
    private com.bumptech.glide.load.b m;

    public e(String str, com.bumptech.glide.load.b bVar, int i, int i2, com.bumptech.glide.load.d dVar, com.bumptech.glide.load.d dVar2, com.bumptech.glide.load.f fVar, com.bumptech.glide.load.e eVar, com.bumptech.glide.load.i.i.c cVar, com.bumptech.glide.load.a aVar) {
        this.f1989a = str;
        this.j = bVar;
        this.f1990b = i;
        this.f1991c = i2;
        this.f1992d = dVar;
        this.e = dVar2;
        this.f = fVar;
        this.g = eVar;
        this.h = cVar;
        this.i = aVar;
    }

    public com.bumptech.glide.load.b a() {
        if (this.m == null) {
            this.m = new i(this.f1989a, this.j);
        }
        return this.m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.f1989a.equals(eVar.f1989a) || !this.j.equals(eVar.j) || this.f1991c != eVar.f1991c || this.f1990b != eVar.f1990b) {
            return false;
        }
        if ((this.f == null) ^ (eVar.f == null)) {
            return false;
        }
        com.bumptech.glide.load.f fVar = this.f;
        if (fVar != null && !fVar.a().equals(eVar.f.a())) {
            return false;
        }
        if ((this.e == null) ^ (eVar.e == null)) {
            return false;
        }
        com.bumptech.glide.load.d dVar = this.e;
        if (dVar != null && !dVar.a().equals(eVar.e.a())) {
            return false;
        }
        if ((this.f1992d == null) ^ (eVar.f1992d == null)) {
            return false;
        }
        com.bumptech.glide.load.d dVar2 = this.f1992d;
        if (dVar2 != null && !dVar2.a().equals(eVar.f1992d.a())) {
            return false;
        }
        if ((this.g == null) ^ (eVar.g == null)) {
            return false;
        }
        com.bumptech.glide.load.e eVar2 = this.g;
        if (eVar2 != null && !eVar2.a().equals(eVar.g.a())) {
            return false;
        }
        if ((this.h == null) ^ (eVar.h == null)) {
            return false;
        }
        com.bumptech.glide.load.i.i.c cVar = this.h;
        if (cVar != null && !cVar.a().equals(eVar.h.a())) {
            return false;
        }
        if ((this.i == null) ^ (eVar.i == null)) {
            return false;
        }
        com.bumptech.glide.load.a aVar = this.i;
        return aVar == null || aVar.a().equals(eVar.i.a());
    }

    public int hashCode() {
        if (this.l == 0) {
            int hashCode = this.f1989a.hashCode();
            this.l = hashCode;
            int hashCode2 = (hashCode * 31) + this.j.hashCode();
            this.l = hashCode2;
            int i = (hashCode2 * 31) + this.f1990b;
            this.l = i;
            int i2 = (i * 31) + this.f1991c;
            this.l = i2;
            int i3 = i2 * 31;
            com.bumptech.glide.load.d dVar = this.f1992d;
            int hashCode3 = i3 + (dVar != null ? dVar.a().hashCode() : 0);
            this.l = hashCode3;
            int i4 = hashCode3 * 31;
            com.bumptech.glide.load.d dVar2 = this.e;
            int hashCode4 = i4 + (dVar2 != null ? dVar2.a().hashCode() : 0);
            this.l = hashCode4;
            int i5 = hashCode4 * 31;
            com.bumptech.glide.load.f fVar = this.f;
            int hashCode5 = i5 + (fVar != null ? fVar.a().hashCode() : 0);
            this.l = hashCode5;
            int i6 = hashCode5 * 31;
            com.bumptech.glide.load.e eVar = this.g;
            int hashCode6 = i6 + (eVar != null ? eVar.a().hashCode() : 0);
            this.l = hashCode6;
            int i7 = hashCode6 * 31;
            com.bumptech.glide.load.i.i.c cVar = this.h;
            int hashCode7 = i7 + (cVar != null ? cVar.a().hashCode() : 0);
            this.l = hashCode7;
            int i8 = hashCode7 * 31;
            com.bumptech.glide.load.a aVar = this.i;
            this.l = i8 + (aVar != null ? aVar.a().hashCode() : 0);
        }
        return this.l;
    }

    public String toString() {
        if (this.k == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EngineKey{");
            sb.append(this.f1989a);
            sb.append('+');
            sb.append(this.j);
            sb.append("+[");
            sb.append(this.f1990b);
            sb.append('x');
            sb.append(this.f1991c);
            sb.append("]+");
            sb.append('\'');
            com.bumptech.glide.load.d dVar = this.f1992d;
            sb.append(dVar != null ? dVar.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            com.bumptech.glide.load.d dVar2 = this.e;
            sb.append(dVar2 != null ? dVar2.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            com.bumptech.glide.load.f fVar = this.f;
            sb.append(fVar != null ? fVar.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            com.bumptech.glide.load.e eVar = this.g;
            sb.append(eVar != null ? eVar.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            com.bumptech.glide.load.i.i.c cVar = this.h;
            sb.append(cVar != null ? cVar.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            com.bumptech.glide.load.a aVar = this.i;
            sb.append(aVar != null ? aVar.a() : "");
            sb.append('\'');
            sb.append('}');
            this.k = sb.toString();
        }
        return this.k;
    }

    @Override // com.bumptech.glide.load.b
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        byte[] array = ByteBuffer.allocate(8).putInt(this.f1990b).putInt(this.f1991c).array();
        this.j.a(messageDigest);
        messageDigest.update(this.f1989a.getBytes("UTF-8"));
        messageDigest.update(array);
        com.bumptech.glide.load.d dVar = this.f1992d;
        messageDigest.update((dVar != null ? dVar.a() : "").getBytes("UTF-8"));
        com.bumptech.glide.load.d dVar2 = this.e;
        messageDigest.update((dVar2 != null ? dVar2.a() : "").getBytes("UTF-8"));
        com.bumptech.glide.load.f fVar = this.f;
        messageDigest.update((fVar != null ? fVar.a() : "").getBytes("UTF-8"));
        com.bumptech.glide.load.e eVar = this.g;
        messageDigest.update((eVar != null ? eVar.a() : "").getBytes("UTF-8"));
        com.bumptech.glide.load.a aVar = this.i;
        messageDigest.update((aVar != null ? aVar.a() : "").getBytes("UTF-8"));
    }
}
