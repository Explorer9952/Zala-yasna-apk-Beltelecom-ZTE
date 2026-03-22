package com.video.androidsdk.common.util.security;

import com.video.androidsdk.common.NonidealDataException;

/* loaded from: classes.dex */
public class Base16 {
    public static byte[] decode(String str) {
        if (str != null) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
            }
            return bArr;
        }
        try {
            throw new NonidealDataException("hexString cannot be null", str);
        } catch (NonidealDataException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static String encode(byte[] bArr) {
        if (bArr != null) {
            StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
            for (int i = 0; i < bArr.length; i++) {
                if ((bArr[i] & 255) < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Long.toString(bArr[i] & 255, 16));
            }
            return stringBuffer.toString();
        }
        try {
            throw new NonidealDataException("src cannot be null", bArr);
        } catch (NonidealDataException e) {
            e.printStackTrace();
            return "";
        }
    }
}
