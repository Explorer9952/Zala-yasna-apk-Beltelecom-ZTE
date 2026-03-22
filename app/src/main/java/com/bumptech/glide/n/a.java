package com.bumptech.glide.n;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.zte.ucs.tvcall.Commons;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: AnimatedGifEncoder.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f2267a;

    /* renamed from: b, reason: collision with root package name */
    private int f2268b;

    /* renamed from: d, reason: collision with root package name */
    private int f2270d;
    private OutputStream h;
    private Bitmap i;
    private byte[] j;
    private byte[] k;
    private int l;
    private byte[] m;
    private boolean u;

    /* renamed from: c, reason: collision with root package name */
    private Integer f2269c = null;
    private int e = -1;
    private int f = 0;
    private boolean g = false;
    private boolean[] n = new boolean[256];
    private int o = 7;
    private int p = -1;
    private boolean q = false;
    private boolean r = true;
    private boolean s = false;
    private int t = 10;

    private void b() {
        byte[] bArr = this.j;
        int length = bArr.length;
        int i = length / 3;
        this.k = new byte[i];
        c cVar = new c(bArr, length, this.t);
        this.m = cVar.d();
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.m;
            if (i2 >= bArr2.length) {
                break;
            }
            byte b2 = bArr2[i2];
            int i3 = i2 + 2;
            bArr2[i2] = bArr2[i3];
            bArr2[i3] = b2;
            this.n[i2 / 3] = false;
            i2 += 3;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            byte[] bArr3 = this.j;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int b3 = cVar.b(bArr3[i5] & 255, bArr3[i6] & 255, bArr3[i7] & 255);
            this.n[b3] = true;
            this.k[i4] = (byte) b3;
            i4++;
            i5 = i7 + 1;
        }
        this.j = null;
        this.l = 8;
        this.o = 7;
        Integer num = this.f2269c;
        if (num != null) {
            this.f2270d = b(num.intValue());
        } else if (this.u) {
            this.f2270d = b(0);
        }
    }

    private void c() {
        int width = this.i.getWidth();
        int height = this.i.getHeight();
        if (width != this.f2267a || height != this.f2268b) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f2267a, this.f2268b, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
            this.i = createBitmap;
        }
        int i = width * height;
        int[] iArr = new int[i];
        this.i.getPixels(iArr, 0, width, 0, 0, width, height);
        this.j = new byte[i * 3];
        this.u = false;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            int i5 = iArr[i2];
            if (i5 == 0) {
                i3++;
            }
            byte[] bArr = this.j;
            int i6 = i4 + 1;
            bArr[i4] = (byte) (i5 & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((i5 >> 8) & 255);
            bArr[i7] = (byte) ((i5 >> 16) & 255);
            i2++;
            i4 = i7 + 1;
        }
        double d2 = i3 * 100;
        double d3 = i;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 / d3;
        this.u = d4 > 4.0d;
        if (Log.isLoggable("AnimatedGifEncoder", 3)) {
            Log.d("AnimatedGifEncoder", "got pixels for frame with " + d4 + "% transparent pixels");
        }
    }

    private void d() throws IOException {
        int i;
        int i2;
        this.h.write(33);
        this.h.write(249);
        this.h.write(4);
        if (this.f2269c != null || this.u) {
            i = 1;
            i2 = 2;
        } else {
            i = 0;
            i2 = 0;
        }
        int i3 = this.p;
        if (i3 >= 0) {
            i2 = i3 & 7;
        }
        this.h.write(i | (i2 << 2) | 0 | 0);
        c(this.f);
        this.h.write(this.f2270d);
        this.h.write(0);
    }

    private void e() throws IOException {
        this.h.write(44);
        c(0);
        c(0);
        c(this.f2267a);
        c(this.f2268b);
        if (this.r) {
            this.h.write(0);
        } else {
            this.h.write(this.o | Commons.MSG_MCSP_INIT_SUCCESS);
        }
    }

    private void f() throws IOException {
        c(this.f2267a);
        c(this.f2268b);
        this.h.write(this.o | PsExtractor.VIDEO_STREAM_MASK);
        this.h.write(0);
        this.h.write(0);
    }

    private void g() throws IOException {
        this.h.write(33);
        this.h.write(255);
        this.h.write(11);
        a("NETSCAPE2.0");
        this.h.write(3);
        this.h.write(1);
        c(this.e);
        this.h.write(0);
    }

    private void h() throws IOException {
        OutputStream outputStream = this.h;
        byte[] bArr = this.m;
        outputStream.write(bArr, 0, bArr.length);
        int length = 768 - this.m.length;
        for (int i = 0; i < length; i++) {
            this.h.write(0);
        }
    }

    private void i() throws IOException {
        new b(this.f2267a, this.f2268b, this.k, this.l).b(this.h);
    }

    public void a(int i) {
        this.f = Math.round(i / 10.0f);
    }

    public boolean a(Bitmap bitmap) {
        if (bitmap == null || !this.g) {
            return false;
        }
        try {
            if (!this.s) {
                a(bitmap.getWidth(), bitmap.getHeight());
            }
            this.i = bitmap;
            c();
            b();
            if (this.r) {
                f();
                h();
                if (this.e >= 0) {
                    g();
                }
            }
            d();
            e();
            if (!this.r) {
                h();
            }
            i();
            this.r = false;
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean a() {
        boolean z;
        if (!this.g) {
            return false;
        }
        this.g = false;
        try {
            this.h.write(59);
            this.h.flush();
            if (this.q) {
                this.h.close();
            }
            z = true;
        } catch (IOException unused) {
            z = false;
        }
        this.f2270d = 0;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = null;
        this.q = false;
        this.r = true;
        return z;
    }

    private void c(int i) throws IOException {
        this.h.write(i & 255);
        this.h.write((i >> 8) & 255);
    }

    private int b(int i) {
        if (this.m == null) {
            return -1;
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int i2 = 16777216;
        int length = this.m.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            byte[] bArr = this.m;
            int i5 = i3 + 1;
            int i6 = red - (bArr[i3] & 255);
            int i7 = i5 + 1;
            int i8 = green - (bArr[i5] & 255);
            int i9 = blue - (bArr[i7] & 255);
            int i10 = (i6 * i6) + (i8 * i8) + (i9 * i9);
            int i11 = i7 / 3;
            if (this.n[i11] && i10 < i2) {
                i2 = i10;
                i4 = i11;
            }
            i3 = i7 + 1;
        }
        return i4;
    }

    public void a(int i, int i2) {
        if (!this.g || this.r) {
            this.f2267a = i;
            this.f2268b = i2;
            if (i < 1) {
                this.f2267a = 320;
            }
            if (this.f2268b < 1) {
                this.f2268b = PsExtractor.VIDEO_STREAM_MASK;
            }
            this.s = true;
        }
    }

    public boolean a(OutputStream outputStream) {
        boolean z = false;
        if (outputStream == null) {
            return false;
        }
        this.q = false;
        this.h = outputStream;
        try {
            a("GIF89a");
            z = true;
        } catch (IOException unused) {
        }
        this.g = z;
        return z;
    }

    private void a(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.h.write((byte) str.charAt(i));
        }
    }
}
