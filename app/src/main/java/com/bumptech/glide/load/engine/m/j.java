package com.bumptech.glide.load.engine.m;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SafeKeyGenerator.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.s.e<com.bumptech.glide.load.b, String> f2056a = new com.bumptech.glide.s.e<>(1000);

    public String a(com.bumptech.glide.load.b bVar) {
        String a2;
        synchronized (this.f2056a) {
            a2 = this.f2056a.a(bVar);
        }
        if (a2 == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                bVar.a(messageDigest);
                a2 = com.bumptech.glide.s.h.a(messageDigest.digest());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
            synchronized (this.f2056a) {
                this.f2056a.b(bVar, a2);
            }
        }
        return a2;
    }
}
