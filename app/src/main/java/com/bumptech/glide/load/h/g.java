package com.bumptech.glide.load.h;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: ImageVideoWrapper.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f2084a;

    /* renamed from: b, reason: collision with root package name */
    private final ParcelFileDescriptor f2085b;

    public g(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.f2084a = inputStream;
        this.f2085b = parcelFileDescriptor;
    }

    public ParcelFileDescriptor a() {
        return this.f2085b;
    }

    public InputStream b() {
        return this.f2084a;
    }
}
