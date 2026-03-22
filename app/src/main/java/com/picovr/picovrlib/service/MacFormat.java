package com.picovr.picovrlib.service;

/* loaded from: classes.dex */
public class MacFormat {
    public static byte[] String2byte(String str) {
        String[] split = str.split(":");
        int length = split.length;
        if (length != 6) {
            return null;
        }
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) Integer.parseInt(split[i], 16);
        }
        return bArr;
    }

    public static String byte2String(byte[] bArr) {
        if (bArr == null || bArr.length != 6) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (byte b2 : bArr) {
            i++;
            sb.append(String.format("%02X", Byte.valueOf(b2)));
            if (i < 6) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    public static String versionByte2String(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append((char) b2);
        }
        return sb.toString();
    }
}
