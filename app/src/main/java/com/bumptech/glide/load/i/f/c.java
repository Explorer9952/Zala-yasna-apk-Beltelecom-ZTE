package com.bumptech.glide.load.i.f;

import com.bumptech.glide.load.engine.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileToStreamDecoder.java */
/* loaded from: classes.dex */
public class c<T> implements com.bumptech.glide.load.d<File, T> {

    /* renamed from: c, reason: collision with root package name */
    private static final a f2115c = new a();

    /* renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.load.d<InputStream, T> f2116a;

    /* renamed from: b, reason: collision with root package name */
    private final a f2117b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FileToStreamDecoder.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public InputStream a(File file) throws FileNotFoundException {
            return new FileInputStream(file);
        }
    }

    public c(com.bumptech.glide.load.d<InputStream, T> dVar) {
        this(dVar, f2115c);
    }

    @Override // com.bumptech.glide.load.d
    public String a() {
        return "";
    }

    c(com.bumptech.glide.load.d<InputStream, T> dVar, a aVar) {
        this.f2116a = dVar;
        this.f2117b = aVar;
    }

    @Override // com.bumptech.glide.load.d
    public j<T> a(File file, int i, int i2) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = this.f2117b.a(file);
            j<T> a2 = this.f2116a.a(inputStream, i, i2);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return a2;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
