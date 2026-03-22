package com.bumptech.glide.m;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* compiled from: GifDecoder.java */
/* loaded from: classes.dex */
public class a {
    private static final String o = "a";
    private static final Bitmap.Config p = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    private int[] f2228a;

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f2229b;

    /* renamed from: d, reason: collision with root package name */
    private short[] f2231d;
    private byte[] e;
    private byte[] f;
    private byte[] g;
    private int[] h;
    private int i;
    private InterfaceC0069a k;
    private Bitmap l;
    private boolean m;
    private int n;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f2230c = new byte[256];
    private c j = new c();

    /* compiled from: GifDecoder.java */
    /* renamed from: com.bumptech.glide.m.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0069a {
        Bitmap a(int i, int i2, Bitmap.Config config);

        void a(Bitmap bitmap);
    }

    public a(InterfaceC0069a interfaceC0069a) {
        this.k = interfaceC0069a;
    }

    private Bitmap h() {
        InterfaceC0069a interfaceC0069a = this.k;
        c cVar = this.j;
        Bitmap a2 = interfaceC0069a.a(cVar.f, cVar.g, p);
        if (a2 == null) {
            c cVar2 = this.j;
            a2 = Bitmap.createBitmap(cVar2.f, cVar2.g, p);
        }
        a(a2);
        return a2;
    }

    private int i() {
        try {
            return this.f2229b.get() & 255;
        } catch (Exception unused) {
            this.n = 1;
            return 0;
        }
    }

    private int j() {
        int i = i();
        int i2 = 0;
        if (i > 0) {
            while (i2 < i) {
                int i3 = i - i2;
                try {
                    this.f2229b.get(this.f2230c, i2, i3);
                    i2 += i3;
                } catch (Exception e) {
                    Log.w(o, "Error Reading Block", e);
                    this.n = 1;
                }
            }
        }
        return i2;
    }

    public void a() {
        this.i = (this.i + 1) % this.j.f2238c;
    }

    public void b() {
        this.j = null;
        this.g = null;
        this.h = null;
        Bitmap bitmap = this.l;
        if (bitmap != null) {
            this.k.a(bitmap);
        }
        this.l = null;
        this.f2229b = null;
    }

    public int c() {
        return this.i;
    }

    public int d() {
        return this.j.f2238c;
    }

    public int e() {
        return this.j.m;
    }

    public int f() {
        int i;
        if (this.j.f2238c <= 0 || (i = this.i) < 0) {
            return -1;
        }
        return a(i);
    }

    public synchronized Bitmap g() {
        if (this.j.f2238c <= 0 || this.i < 0) {
            if (Log.isLoggable(o, 3)) {
                Log.d(o, "unable to decode frame, frameCount=" + this.j.f2238c + " framePointer=" + this.i);
            }
            this.n = 1;
        }
        if (this.n != 1 && this.n != 2) {
            int i = 0;
            this.n = 0;
            b bVar = this.j.e.get(this.i);
            int i2 = this.i - 1;
            b bVar2 = i2 >= 0 ? this.j.e.get(i2) : null;
            if (bVar.k == null) {
                this.f2228a = this.j.f2236a;
            } else {
                this.f2228a = bVar.k;
                if (this.j.j == bVar.h) {
                    this.j.l = 0;
                }
            }
            if (bVar.f) {
                int i3 = this.f2228a[bVar.h];
                this.f2228a[bVar.h] = 0;
                i = i3;
            }
            if (this.f2228a == null) {
                if (Log.isLoggable(o, 3)) {
                    Log.d(o, "No Valid Color Table");
                }
                this.n = 1;
                return null;
            }
            Bitmap a2 = a(bVar, bVar2);
            if (bVar.f) {
                this.f2228a[bVar.h] = i;
            }
            return a2;
        }
        if (Log.isLoggable(o, 3)) {
            Log.d(o, "Unable to decode frame, status=" + this.n);
        }
        return null;
    }

    public int a(int i) {
        if (i >= 0) {
            c cVar = this.j;
            if (i < cVar.f2238c) {
                return cVar.e.get(i).i;
            }
        }
        return -1;
    }

    public void a(c cVar, byte[] bArr) {
        this.j = cVar;
        this.n = 0;
        this.i = -1;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f2229b = wrap;
        wrap.rewind();
        this.f2229b.order(ByteOrder.LITTLE_ENDIAN);
        this.m = false;
        Iterator<b> it2 = cVar.e.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            } else if (it2.next().g == 3) {
                this.m = true;
                break;
            }
        }
        int i = cVar.f;
        int i2 = cVar.g;
        this.g = new byte[i * i2];
        this.h = new int[i * i2];
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a A[EDGE_INSN: B:47:0x009a->B:48:0x009a BREAK  A[LOOP:0: B:16:0x0042->B:44:0x0095], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap a(com.bumptech.glide.m.b r18, com.bumptech.glide.m.b r19) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.m.a.a(com.bumptech.glide.m.b, com.bumptech.glide.m.b):android.graphics.Bitmap");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0134 A[LOOP:5: B:63:0x0132->B:64:0x0134, LOOP_END] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v30, types: [short] */
    /* JADX WARN: Type inference failed for: r1v32 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.bumptech.glide.m.b r27) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.m.a.a(com.bumptech.glide.m.b):void");
    }

    @TargetApi(12)
    private static void a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }
}
