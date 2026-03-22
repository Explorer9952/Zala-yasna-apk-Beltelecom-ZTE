package com.bumptech.glide.load.h;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* compiled from: StringLoader.java */
/* loaded from: classes.dex */
public class p<T> implements l<String, T> {

    /* renamed from: a, reason: collision with root package name */
    private final l<Uri, T> f2103a;

    public p(l<Uri, T> lVar) {
        this.f2103a = lVar;
    }

    @Override // com.bumptech.glide.load.h.l
    public com.bumptech.glide.load.g.c<T> a(String str, int i, int i2) {
        Uri a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("/")) {
            a2 = a(str);
        } else {
            Uri parse = Uri.parse(str);
            a2 = parse.getScheme() == null ? a(str) : parse;
        }
        return this.f2103a.a(a2, i, i2);
    }

    private static Uri a(String str) {
        return Uri.fromFile(new File(str));
    }
}
