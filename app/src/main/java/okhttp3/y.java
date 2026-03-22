package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: RequestBody.java */
/* loaded from: classes.dex */
public abstract class y {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBody.java */
    /* loaded from: classes.dex */
    public class a extends y {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f8553a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8554b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ byte[] f8555c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f8556d;

        a(u uVar, int i, byte[] bArr, int i2) {
            this.f8553a = uVar;
            this.f8554b = i;
            this.f8555c = bArr;
            this.f8556d = i2;
        }

        @Override // okhttp3.y
        public long a() {
            return this.f8554b;
        }

        @Override // okhttp3.y
        @Nullable
        public u b() {
            return this.f8553a;
        }

        @Override // okhttp3.y
        public void a(okio.d dVar) throws IOException {
            dVar.write(this.f8555c, this.f8556d, this.f8554b);
        }
    }

    public static y a(@Nullable u uVar, String str) {
        Charset charset = okhttp3.c0.c.i;
        if (uVar != null && (charset = uVar.a()) == null) {
            charset = okhttp3.c0.c.i;
            uVar = u.b(uVar + "; charset=utf-8");
        }
        return a(uVar, str.getBytes(charset));
    }

    public abstract long a() throws IOException;

    public abstract void a(okio.d dVar) throws IOException;

    @Nullable
    public abstract u b();

    public static y a(@Nullable u uVar, byte[] bArr) {
        return a(uVar, bArr, 0, bArr.length);
    }

    public static y a(@Nullable u uVar, byte[] bArr, int i, int i2) {
        if (bArr != null) {
            okhttp3.c0.c.a(bArr.length, i, i2);
            return new a(uVar, i2, bArr, i);
        }
        throw new NullPointerException("content == null");
    }
}
