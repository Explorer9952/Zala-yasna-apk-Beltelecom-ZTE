package com.bumptech.glide.n;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: LZWEncoder.java */
/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private int f2271a;

    /* renamed from: b, reason: collision with root package name */
    private int f2272b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f2273c;

    /* renamed from: d, reason: collision with root package name */
    private int f2274d;
    private int e;
    private int f;
    int g;
    int i;
    int p;
    int q;
    int r;
    int v;
    int h = 12;
    int j = 4096;
    int[] k = new int[5003];
    int[] l = new int[5003];
    int m = 5003;
    int n = 0;
    boolean o = false;
    int s = 0;
    int t = 0;
    int[] u = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] w = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.f2271a = i;
        this.f2272b = i2;
        this.f2273c = bArr;
        this.f2274d = Math.max(2, i3);
    }

    final int a(int i) {
        return (1 << i) - 1;
    }

    void a(byte b2, OutputStream outputStream) throws IOException {
        byte[] bArr = this.w;
        int i = this.v;
        int i2 = i + 1;
        this.v = i2;
        bArr[i] = b2;
        if (i2 >= 254) {
            c(outputStream);
        }
    }

    void b(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2] = -1;
        }
    }

    void c(OutputStream outputStream) throws IOException {
        int i = this.v;
        if (i > 0) {
            outputStream.write(i);
            outputStream.write(this.w, 0, this.v);
            this.v = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(OutputStream outputStream) throws IOException {
        outputStream.write(this.f2274d);
        this.e = this.f2271a * this.f2272b;
        this.f = 0;
        a(this.f2274d + 1, outputStream);
        outputStream.write(0);
    }

    void a(OutputStream outputStream) throws IOException {
        b(this.m);
        int i = this.q;
        this.n = i + 2;
        this.o = true;
        b(i, outputStream);
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int[] iArr;
        this.p = i;
        int i2 = 0;
        this.o = false;
        this.g = i;
        this.i = a(i);
        int i3 = 1 << (i - 1);
        this.q = i3;
        this.r = i3 + 1;
        this.n = i3 + 2;
        this.v = 0;
        int a2 = a();
        for (int i4 = this.m; i4 < 65536; i4 *= 2) {
            i2++;
        }
        int i5 = 8 - i2;
        int i6 = this.m;
        b(i6);
        b(this.q, outputStream);
        while (true) {
            int a3 = a();
            if (a3 != -1) {
                int i7 = (a3 << this.h) + a2;
                int i8 = (a3 << i5) ^ a2;
                int[] iArr2 = this.k;
                if (iArr2[i8] == i7) {
                    a2 = this.l[i8];
                } else {
                    if (iArr2[i8] >= 0) {
                        int i9 = i6 - i8;
                        if (i8 == 0) {
                            i9 = 1;
                        }
                        do {
                            i8 -= i9;
                            if (i8 < 0) {
                                i8 += i6;
                            }
                            iArr = this.k;
                            if (iArr[i8] == i7) {
                                a2 = this.l[i8];
                                break;
                            }
                        } while (iArr[i8] >= 0);
                    }
                    b(a2, outputStream);
                    int i10 = this.n;
                    if (i10 < this.j) {
                        int[] iArr3 = this.l;
                        this.n = i10 + 1;
                        iArr3[i8] = i10;
                        this.k[i8] = i7;
                    } else {
                        a(outputStream);
                    }
                    a2 = a3;
                }
            } else {
                b(a2, outputStream);
                b(this.r, outputStream);
                return;
            }
        }
    }

    void b(int i, OutputStream outputStream) throws IOException {
        int i2 = this.s;
        int[] iArr = this.u;
        int i3 = this.t;
        int i4 = i2 & iArr[i3];
        this.s = i4;
        if (i3 > 0) {
            this.s = i4 | (i << i3);
        } else {
            this.s = i;
        }
        this.t += this.g;
        while (this.t >= 8) {
            a((byte) (this.s & 255), outputStream);
            this.s >>= 8;
            this.t -= 8;
        }
        if (this.n > this.i || this.o) {
            if (this.o) {
                int i5 = this.p;
                this.g = i5;
                this.i = a(i5);
                this.o = false;
            } else {
                int i6 = this.g + 1;
                this.g = i6;
                if (i6 == this.h) {
                    this.i = this.j;
                } else {
                    this.i = a(i6);
                }
            }
        }
        if (i == this.r) {
            while (this.t > 0) {
                a((byte) (this.s & 255), outputStream);
                this.s >>= 8;
                this.t -= 8;
            }
            c(outputStream);
        }
    }

    private int a() {
        int i = this.e;
        if (i == 0) {
            return -1;
        }
        this.e = i - 1;
        byte[] bArr = this.f2273c;
        int i2 = this.f;
        this.f = i2 + 1;
        return bArr[i2] & 255;
    }
}
