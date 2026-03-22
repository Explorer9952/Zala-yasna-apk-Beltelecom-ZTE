package com.bumptech.glide.load.engine;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* compiled from: OriginalKey.java */
/* loaded from: classes.dex */
class i implements com.bumptech.glide.load.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f2009a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.b f2010b;

    public i(String str, com.bumptech.glide.load.b bVar) {
        this.f2009a = str;
        this.f2010b = bVar;
    }

    @Override // com.bumptech.glide.load.b
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f2009a.getBytes("UTF-8"));
        this.f2010b.a(messageDigest);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f2009a.equals(iVar.f2009a) && this.f2010b.equals(iVar.f2010b);
    }

    public int hashCode() {
        return (this.f2009a.hashCode() * 31) + this.f2010b.hashCode();
    }
}
