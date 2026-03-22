package com.bumptech.glide.m;

import android.util.Log;
import com.zte.ucs.tvcall.Commons;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f2241b;

    /* renamed from: c, reason: collision with root package name */
    private c f2242c;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2240a = new byte[256];

    /* renamed from: d, reason: collision with root package name */
    private int f2243d = 0;

    private boolean c() {
        return this.f2242c.f2237b != 0;
    }

    private int d() {
        try {
            return this.f2241b.get() & 255;
        } catch (Exception unused) {
            this.f2242c.f2237b = 1;
            return 0;
        }
    }

    private void e() {
        this.f2242c.f2239d.f2232a = l();
        this.f2242c.f2239d.f2233b = l();
        this.f2242c.f2239d.f2234c = l();
        this.f2242c.f2239d.f2235d = l();
        int d2 = d();
        boolean z = (d2 & Commons.MSG_MCSP_INIT_SUCCESS) != 0;
        int pow = (int) Math.pow(2.0d, (d2 & 7) + 1);
        this.f2242c.f2239d.e = (d2 & 64) != 0;
        if (z) {
            this.f2242c.f2239d.k = a(pow);
        } else {
            this.f2242c.f2239d.k = null;
        }
        this.f2242c.f2239d.j = this.f2241b.position();
        o();
        if (c()) {
            return;
        }
        c cVar = this.f2242c;
        cVar.f2238c++;
        cVar.e.add(cVar.f2239d);
    }

    private int f() {
        int d2 = d();
        this.f2243d = d2;
        int i = 0;
        if (d2 > 0) {
            int i2 = 0;
            while (i < this.f2243d) {
                try {
                    i2 = this.f2243d - i;
                    this.f2241b.get(this.f2240a, i, i2);
                    i += i2;
                } catch (Exception e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f2243d, e);
                    }
                    this.f2242c.f2237b = 1;
                }
            }
        }
        return i;
    }

    private void g() {
        boolean z = false;
        while (!z && !c()) {
            int d2 = d();
            if (d2 == 33) {
                int d3 = d();
                if (d3 == 1) {
                    n();
                } else if (d3 == 249) {
                    this.f2242c.f2239d = new b();
                    h();
                } else if (d3 == 254) {
                    n();
                } else if (d3 != 255) {
                    n();
                } else {
                    f();
                    String str = "";
                    for (int i = 0; i < 11; i++) {
                        str = str + ((char) this.f2240a[i]);
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        k();
                    } else {
                        n();
                    }
                }
            } else if (d2 == 44) {
                c cVar = this.f2242c;
                if (cVar.f2239d == null) {
                    cVar.f2239d = new b();
                }
                e();
            } else if (d2 != 59) {
                this.f2242c.f2237b = 1;
            } else {
                z = true;
            }
        }
    }

    private void h() {
        d();
        int d2 = d();
        b bVar = this.f2242c.f2239d;
        int i = (d2 & 28) >> 2;
        bVar.g = i;
        if (i == 0) {
            bVar.g = 1;
        }
        this.f2242c.f2239d.f = (d2 & 1) != 0;
        int l = l();
        if (l < 3) {
            l = 10;
        }
        b bVar2 = this.f2242c.f2239d;
        bVar2.i = l * 10;
        bVar2.h = d();
        d();
    }

    private void i() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) d());
        }
        if (!str.startsWith("GIF")) {
            this.f2242c.f2237b = 1;
            return;
        }
        j();
        if (!this.f2242c.h || c()) {
            return;
        }
        c cVar = this.f2242c;
        cVar.f2236a = a(cVar.i);
        c cVar2 = this.f2242c;
        cVar2.l = cVar2.f2236a[cVar2.j];
    }

    private void j() {
        this.f2242c.f = l();
        this.f2242c.g = l();
        int d2 = d();
        this.f2242c.h = (d2 & Commons.MSG_MCSP_INIT_SUCCESS) != 0;
        c cVar = this.f2242c;
        cVar.i = 2 << (d2 & 7);
        cVar.j = d();
        this.f2242c.k = d();
    }

    private void k() {
        do {
            f();
            byte[] bArr = this.f2240a;
            if (bArr[0] == 1) {
                this.f2242c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f2243d <= 0) {
                return;
            }
        } while (!c());
    }

    private int l() {
        return this.f2241b.getShort();
    }

    private void m() {
        this.f2241b = null;
        Arrays.fill(this.f2240a, (byte) 0);
        this.f2242c = new c();
        this.f2243d = 0;
    }

    private void n() {
        int d2;
        do {
            d2 = d();
            ByteBuffer byteBuffer = this.f2241b;
            byteBuffer.position(byteBuffer.position() + d2);
        } while (d2 > 0);
    }

    private void o() {
        d();
        n();
    }

    public d a(byte[] bArr) {
        m();
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f2241b = wrap;
            wrap.rewind();
            this.f2241b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f2241b = null;
            this.f2242c.f2237b = 2;
        }
        return this;
    }

    public c b() {
        if (this.f2241b != null) {
            if (c()) {
                return this.f2242c;
            }
            i();
            if (!c()) {
                g();
                c cVar = this.f2242c;
                if (cVar.f2238c < 0) {
                    cVar.f2237b = 1;
                }
            }
            return this.f2242c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public void a() {
        this.f2241b = null;
        this.f2242c = null;
    }

    private int[] a(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f2241b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.f2242c.f2237b = 1;
        }
        return iArr;
    }
}
