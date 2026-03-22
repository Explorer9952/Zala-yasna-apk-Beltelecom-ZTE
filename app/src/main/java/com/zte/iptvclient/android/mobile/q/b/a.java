package com.zte.iptvclient.android.mobile.q.b;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.zte.ucs.tvcall.Commons;

/* compiled from: Base64.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static char f7069a = '=';

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f7070b = new byte[Commons.MSG_MCSP_INIT_SUCCESS];

    /* renamed from: c, reason: collision with root package name */
    private static char[] f7071c = new char[64];

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 128; i4++) {
            f7070b[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            f7070b[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            f7070b[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            f7070b[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = f7070b;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i8 = 0; i8 <= 25; i8++) {
            f7071c[i8] = (char) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            f7071c[i] = (char) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            f7071c[i2] = (char) (i3 + 48);
            i2++;
            i3++;
        }
        char[] cArr = f7071c;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i = length % 24;
        int i2 = length / 24;
        char[] cArr = new char[(i != 0 ? i2 + 1 : i2) * 4];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            int i6 = i4 + 1;
            byte b2 = bArr[i4];
            int i7 = i6 + 1;
            byte b3 = bArr[i6];
            int i8 = i7 + 1;
            byte b4 = bArr[i7];
            byte b5 = (byte) (b3 & 15);
            byte b6 = (byte) (b2 & 3);
            int i9 = b2 & Byte.MIN_VALUE;
            int i10 = b2 >> 2;
            if (i9 != 0) {
                i10 ^= PsExtractor.AUDIO_STREAM;
            }
            byte b7 = (byte) i10;
            int i11 = b3 & Byte.MIN_VALUE;
            int i12 = b3 >> 4;
            if (i11 != 0) {
                i12 ^= PsExtractor.VIDEO_STREAM_MASK;
            }
            byte b8 = (byte) i12;
            int i13 = (b4 & Byte.MIN_VALUE) == 0 ? b4 >> 6 : (b4 >> 6) ^ 252;
            int i14 = i5 + 1;
            char[] cArr2 = f7071c;
            cArr[i5] = cArr2[b7];
            int i15 = i14 + 1;
            cArr[i14] = cArr2[(b6 << 4) | b8];
            int i16 = i15 + 1;
            cArr[i15] = cArr2[(b5 << 2) | ((byte) i13)];
            cArr[i16] = cArr2[b4 & 63];
            i3++;
            i5 = i16 + 1;
            i4 = i8;
        }
        if (i == 8) {
            byte b9 = bArr[i4];
            byte b10 = (byte) (b9 & 3);
            int i17 = b9 & Byte.MIN_VALUE;
            int i18 = b9 >> 2;
            if (i17 != 0) {
                i18 ^= PsExtractor.AUDIO_STREAM;
            }
            int i19 = i5 + 1;
            char[] cArr3 = f7071c;
            cArr[i5] = cArr3[(byte) i18];
            int i20 = i19 + 1;
            cArr[i19] = cArr3[b10 << 4];
            char c2 = f7069a;
            cArr[i20] = c2;
            cArr[i20 + 1] = c2;
        } else if (i == 16) {
            byte b11 = bArr[i4];
            byte b12 = bArr[i4 + 1];
            byte b13 = (byte) (b12 & 15);
            byte b14 = (byte) (b11 & 3);
            int i21 = b11 & Byte.MIN_VALUE;
            int i22 = b11 >> 2;
            if (i21 != 0) {
                i22 ^= PsExtractor.AUDIO_STREAM;
            }
            byte b15 = (byte) i22;
            int i23 = b12 & Byte.MIN_VALUE;
            int i24 = b12 >> 4;
            if (i23 != 0) {
                i24 ^= PsExtractor.VIDEO_STREAM_MASK;
            }
            int i25 = i5 + 1;
            char[] cArr4 = f7071c;
            cArr[i5] = cArr4[b15];
            int i26 = i25 + 1;
            cArr[i25] = cArr4[((byte) i24) | (b14 << 4)];
            cArr[i26] = cArr4[b13 << 2];
            cArr[i26 + 1] = f7069a;
        }
        return new String(cArr);
    }
}
