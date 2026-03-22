package com.tencent.mm.algorithm;

import java.util.Arrays;

/* loaded from: classes.dex */
public class Base64 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f2817a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f2818b;

    static {
        int[] iArr = new int[256];
        f2818b = iArr;
        Arrays.fill(iArr, -1);
        int length = f2817a.length;
        for (int i = 0; i < length; i++) {
            f2818b[f2817a[i]] = i;
        }
        f2818b[61] = 0;
    }

    public static final byte[] decode(String str) {
        int length = str != null ? str.length() : 0;
        if (length == 0) {
            return new byte[0];
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (f2818b[str.charAt(i2)] < 0) {
                i++;
            }
        }
        int i3 = length - i;
        if (i3 % 4 != 0) {
            return null;
        }
        int i4 = 0;
        while (length > 1) {
            length--;
            if (f2818b[str.charAt(length)] > 0) {
                break;
            }
            if (str.charAt(length) == '=') {
                i4++;
            }
        }
        int i5 = ((i3 * 6) >> 3) - i4;
        byte[] bArr = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            int i8 = 0;
            int i9 = 0;
            while (i8 < 4) {
                int i10 = i7 + 1;
                int i11 = f2818b[str.charAt(i7)];
                if (i11 >= 0) {
                    i9 |= i11 << (18 - (i8 * 6));
                } else {
                    i8--;
                }
                i8++;
                i7 = i10;
            }
            int i12 = i6 + 1;
            bArr[i6] = (byte) (i9 >> 16);
            if (i12 < i5) {
                i6 = i12 + 1;
                bArr[i12] = (byte) (i9 >> 8);
                if (i6 < i5) {
                    i12 = i6 + 1;
                    bArr[i6] = (byte) i9;
                }
            }
            i6 = i12;
        }
        return bArr;
    }

    public static final byte[] decode(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        for (byte b2 : bArr) {
            if (f2818b[b2 & 255] < 0) {
                i++;
            }
        }
        int i2 = length - i;
        if (i2 % 4 != 0) {
            return null;
        }
        int i3 = 0;
        while (length > 1) {
            length--;
            if (f2818b[bArr[length] & 255] > 0) {
                break;
            }
            if (bArr[length] == 61) {
                i3++;
            }
        }
        int i4 = ((i2 * 6) >> 3) - i3;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int i7 = 0;
            int i8 = 0;
            while (i7 < 4) {
                int i9 = i6 + 1;
                int i10 = f2818b[bArr[i6] & 255];
                if (i10 >= 0) {
                    i8 |= i10 << (18 - (i7 * 6));
                } else {
                    i7--;
                }
                i7++;
                i6 = i9;
            }
            int i11 = i5 + 1;
            bArr2[i5] = (byte) (i8 >> 16);
            if (i11 < i4) {
                i5 = i11 + 1;
                bArr2[i11] = (byte) (i8 >> 8);
                if (i5 < i4) {
                    i11 = i5 + 1;
                    bArr2[i5] = (byte) i8;
                }
            }
            i5 = i11;
        }
        return bArr2;
    }

    public static final byte[] decode(char[] cArr) {
        int length = cArr != null ? cArr.length : 0;
        if (length == 0) {
            return new byte[0];
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (f2818b[cArr[i2]] < 0) {
                i++;
            }
        }
        int i3 = length - i;
        if (i3 % 4 != 0) {
            return null;
        }
        int i4 = 0;
        while (length > 1) {
            length--;
            if (f2818b[cArr[length]] > 0) {
                break;
            }
            if (cArr[length] == '=') {
                i4++;
            }
        }
        int i5 = ((i3 * 6) >> 3) - i4;
        byte[] bArr = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            int i8 = 0;
            int i9 = 0;
            while (i8 < 4) {
                int i10 = i7 + 1;
                int i11 = f2818b[cArr[i7]];
                if (i11 >= 0) {
                    i9 |= i11 << (18 - (i8 * 6));
                } else {
                    i8--;
                }
                i8++;
                i7 = i10;
            }
            int i12 = i6 + 1;
            bArr[i6] = (byte) (i9 >> 16);
            if (i12 < i5) {
                i6 = i12 + 1;
                bArr[i12] = (byte) (i9 >> 8);
                if (i6 < i5) {
                    i12 = i6 + 1;
                    bArr[i6] = (byte) i9;
                }
            }
            i6 = i12;
        }
        return bArr;
    }

    public static final byte[] decodeFast(String str) {
        int i;
        int length = str.length();
        int i2 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i3 = length - 1;
        int i4 = 0;
        while (i4 < i3 && f2818b[str.charAt(i4) & 255] < 0) {
            i4++;
        }
        while (i3 > 0 && f2818b[str.charAt(i3) & 255] < 0) {
            i3--;
        }
        int i5 = str.charAt(i3) == '=' ? str.charAt(i3 + (-1)) == '=' ? 2 : 1 : 0;
        int i6 = (i3 - i4) + 1;
        if (length > 76) {
            i = (str.charAt(76) == '\r' ? i6 / 78 : 0) << 1;
        } else {
            i = 0;
        }
        int i7 = (((i6 - i) * 6) >> 3) - i5;
        byte[] bArr = new byte[i7];
        int i8 = (i7 / 3) * 3;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int i11 = i4 + 1;
            int i12 = i11 + 1;
            int i13 = (f2818b[str.charAt(i4)] << 18) | (f2818b[str.charAt(i11)] << 12);
            int i14 = i12 + 1;
            int i15 = i13 | (f2818b[str.charAt(i12)] << 6);
            int i16 = i14 + 1;
            int i17 = i15 | f2818b[str.charAt(i14)];
            int i18 = i9 + 1;
            bArr[i9] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            int i20 = i19 + 1;
            bArr[i19] = (byte) i17;
            if (i <= 0 || (i10 = i10 + 1) != 19) {
                i4 = i16;
            } else {
                i4 = i16 + 2;
                i10 = 0;
            }
            i9 = i20;
        }
        if (i9 < i7) {
            int i21 = 0;
            while (i4 <= i3 - i5) {
                i2 |= f2818b[str.charAt(i4)] << (18 - (i21 * 6));
                i21++;
                i4++;
            }
            int i22 = 16;
            while (i9 < i7) {
                bArr[i9] = (byte) (i2 >> i22);
                i22 -= 8;
                i9++;
            }
        }
        return bArr;
    }

    public static final byte[] decodeFast(byte[] bArr) {
        int i;
        int length = bArr.length;
        int i2 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i3 = length - 1;
        int i4 = 0;
        while (i4 < i3 && f2818b[bArr[i4] & 255] < 0) {
            i4++;
        }
        while (i3 > 0 && f2818b[bArr[i3] & 255] < 0) {
            i3--;
        }
        int i5 = bArr[i3] == 61 ? bArr[i3 + (-1)] == 61 ? 2 : 1 : 0;
        int i6 = (i3 - i4) + 1;
        if (length > 76) {
            i = (bArr[76] == 13 ? i6 / 78 : 0) << 1;
        } else {
            i = 0;
        }
        int i7 = (((i6 - i) * 6) >> 3) - i5;
        byte[] bArr2 = new byte[i7];
        int i8 = (i7 / 3) * 3;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int[] iArr = f2818b;
            int i11 = i4 + 1;
            int i12 = i11 + 1;
            int i13 = (iArr[bArr[i4]] << 18) | (iArr[bArr[i11]] << 12);
            int i14 = i12 + 1;
            int i15 = i13 | (iArr[bArr[i12]] << 6);
            int i16 = i14 + 1;
            int i17 = i15 | iArr[bArr[i14]];
            int i18 = i9 + 1;
            bArr2[i9] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr2[i18] = (byte) (i17 >> 8);
            int i20 = i19 + 1;
            bArr2[i19] = (byte) i17;
            if (i <= 0 || (i10 = i10 + 1) != 19) {
                i4 = i16;
            } else {
                i4 = i16 + 2;
                i10 = 0;
            }
            i9 = i20;
        }
        if (i9 < i7) {
            int i21 = 0;
            while (i4 <= i3 - i5) {
                i2 |= f2818b[bArr[i4]] << (18 - (i21 * 6));
                i21++;
                i4++;
            }
            int i22 = 16;
            while (i9 < i7) {
                bArr2[i9] = (byte) (i2 >> i22);
                i22 -= 8;
                i9++;
            }
        }
        return bArr2;
    }

    public static final byte[] decodeFast(char[] cArr) {
        int i;
        int length = cArr.length;
        int i2 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i3 = length - 1;
        int i4 = 0;
        while (i4 < i3 && f2818b[cArr[i4]] < 0) {
            i4++;
        }
        while (i3 > 0 && f2818b[cArr[i3]] < 0) {
            i3--;
        }
        int i5 = cArr[i3] == '=' ? cArr[i3 + (-1)] == '=' ? 2 : 1 : 0;
        int i6 = (i3 - i4) + 1;
        if (length > 76) {
            i = (cArr[76] == '\r' ? i6 / 78 : 0) << 1;
        } else {
            i = 0;
        }
        int i7 = (((i6 - i) * 6) >> 3) - i5;
        byte[] bArr = new byte[i7];
        int i8 = (i7 / 3) * 3;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int[] iArr = f2818b;
            int i11 = i4 + 1;
            int i12 = i11 + 1;
            int i13 = (iArr[cArr[i4]] << 18) | (iArr[cArr[i11]] << 12);
            int i14 = i12 + 1;
            int i15 = i13 | (iArr[cArr[i12]] << 6);
            int i16 = i14 + 1;
            int i17 = i15 | iArr[cArr[i14]];
            int i18 = i9 + 1;
            bArr[i9] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            int i20 = i19 + 1;
            bArr[i19] = (byte) i17;
            if (i <= 0 || (i10 = i10 + 1) != 19) {
                i4 = i16;
            } else {
                i4 = i16 + 2;
                i10 = 0;
            }
            i9 = i20;
        }
        if (i9 < i7) {
            int i21 = 0;
            while (i4 <= i3 - i5) {
                i2 |= f2818b[cArr[i4]] << (18 - (i21 * 6));
                i21++;
                i4++;
            }
            int i22 = 16;
            while (i9 < i7) {
                bArr[i9] = (byte) (i2 >> i22);
                i22 -= 8;
                i9++;
            }
        }
        return bArr;
    }

    public static final byte[] encodeToByte(byte[] bArr, boolean z) {
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return new byte[0];
        }
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = ((i2 / 3) + 1) << 2;
        int i4 = i3 + (z ? ((i3 - 1) / 76) << 1 : 0);
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i) {
            int i8 = i5 + 1;
            int i9 = i8 + 1;
            int i10 = ((bArr[i5] & 255) << 16) | ((bArr[i8] & 255) << 8);
            int i11 = i9 + 1;
            int i12 = i10 | (bArr[i9] & 255);
            int i13 = i6 + 1;
            char[] cArr = f2817a;
            bArr2[i6] = (byte) cArr[(i12 >>> 18) & 63];
            int i14 = i13 + 1;
            bArr2[i13] = (byte) cArr[(i12 >>> 12) & 63];
            int i15 = i14 + 1;
            bArr2[i14] = (byte) cArr[(i12 >>> 6) & 63];
            i6 = i15 + 1;
            bArr2[i15] = (byte) cArr[i12 & 63];
            if (z && (i7 = i7 + 1) == 19 && i6 < i4 - 2) {
                int i16 = i6 + 1;
                bArr2[i6] = 13;
                i6 = i16 + 1;
                bArr2[i16] = 10;
                i7 = 0;
            }
            i5 = i11;
        }
        int i17 = length - i;
        if (i17 > 0) {
            int i18 = ((bArr[i] & 255) << 10) | (i17 == 2 ? (bArr[i2] & 255) << 2 : 0);
            char[] cArr2 = f2817a;
            bArr2[i4 - 4] = (byte) cArr2[i18 >> 12];
            bArr2[i4 - 3] = (byte) cArr2[(i18 >>> 6) & 63];
            bArr2[i4 - 2] = i17 == 2 ? (byte) cArr2[i18 & 63] : (byte) 61;
            bArr2[i4 - 1] = 61;
        }
        return bArr2;
    }

    public static final char[] encodeToChar(byte[] bArr, boolean z) {
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return new char[0];
        }
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = ((i2 / 3) + 1) << 2;
        int i4 = i3 + (z ? ((i3 - 1) / 76) << 1 : 0);
        char[] cArr = new char[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i) {
            int i8 = i5 + 1;
            int i9 = i8 + 1;
            int i10 = ((bArr[i5] & 255) << 16) | ((bArr[i8] & 255) << 8);
            int i11 = i9 + 1;
            int i12 = i10 | (bArr[i9] & 255);
            int i13 = i6 + 1;
            char[] cArr2 = f2817a;
            cArr[i6] = cArr2[(i12 >>> 18) & 63];
            int i14 = i13 + 1;
            cArr[i13] = cArr2[(i12 >>> 12) & 63];
            int i15 = i14 + 1;
            cArr[i14] = cArr2[(i12 >>> 6) & 63];
            i6 = i15 + 1;
            cArr[i15] = cArr2[i12 & 63];
            if (z && (i7 = i7 + 1) == 19 && i6 < i4 - 2) {
                int i16 = i6 + 1;
                cArr[i6] = '\r';
                i6 = i16 + 1;
                cArr[i16] = '\n';
                i7 = 0;
            }
            i5 = i11;
        }
        int i17 = length - i;
        if (i17 > 0) {
            int i18 = ((bArr[i] & 255) << 10) | (i17 == 2 ? (bArr[i2] & 255) << 2 : 0);
            char[] cArr3 = f2817a;
            cArr[i4 - 4] = cArr3[i18 >> 12];
            cArr[i4 - 3] = cArr3[(i18 >>> 6) & 63];
            cArr[i4 - 2] = i17 == 2 ? cArr3[i18 & 63] : '=';
            cArr[i4 - 1] = '=';
        }
        return cArr;
    }

    public static final String encodeToString(byte[] bArr, boolean z) {
        return new String(encodeToChar(bArr, z));
    }
}
