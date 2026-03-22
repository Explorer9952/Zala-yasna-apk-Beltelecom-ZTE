package com.bumptech.glide.r;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* compiled from: StringSignature.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f2335a;

    public c(String str) {
        if (str != null) {
            this.f2335a = str;
            return;
        }
        throw new NullPointerException("Signature cannot be null!");
    }

    @Override // com.bumptech.glide.load.b
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f2335a.getBytes("UTF-8"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f2335a.equals(((c) obj).f2335a);
    }

    public int hashCode() {
        return this.f2335a.hashCode();
    }

    public String toString() {
        return "StringSignature{signature='" + this.f2335a + "'}";
    }
}
