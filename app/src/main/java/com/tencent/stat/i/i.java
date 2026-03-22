package com.tencent.stat.i;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f2881a = !i.class.desiredAssertionStatus();

    private i() {
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        k kVar = new k(i3, new byte[(i2 * 3) / 4]);
        if (!kVar.a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i4 = kVar.f2883b;
        byte[] bArr2 = kVar.f2882a;
        if (i4 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr3, 0, i4);
        return bArr3;
    }

    public static byte[] b(byte[] bArr, int i) {
        return b(bArr, 0, bArr.length, i);
    }

    public static byte[] b(byte[] bArr, int i, int i2, int i3) {
        l lVar = new l(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!lVar.f) {
            int i5 = i2 % 3;
            if (i5 == 1) {
                i4 += 2;
            } else if (i5 == 2) {
                i4 += 3;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (lVar.g && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (lVar.h ? 2 : 1);
        }
        lVar.f2882a = new byte[i4];
        lVar.a(bArr, i, i2, true);
        if (f2881a || lVar.f2883b == i4) {
            return lVar.f2882a;
        }
        throw new AssertionError();
    }
}
