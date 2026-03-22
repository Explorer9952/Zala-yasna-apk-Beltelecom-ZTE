package com.zte.iptvclient.android.common.k;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES.java */
/* loaded from: classes.dex */
public class a {
    public static String a(String str, byte[] bArr) throws UnsupportedEncodingException {
        return a(Base64.decode(str, 0), bArr);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws UnsupportedEncodingException {
        if (bArr2 != null && bArr2.length == 16) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
                cipher.init(1, secretKeySpec);
                return cipher.doFinal(bArr);
            } catch (Exception e) {
                e.printStackTrace();
                throw new UnsupportedEncodingException();
            }
        }
        throw new UnsupportedEncodingException("The key's length is invalid,should be 16 ");
    }

    public static String c(byte[] bArr, byte[] bArr2) throws UnsupportedEncodingException {
        return new String(Base64.encode(b(bArr, bArr2), 0), "utf-8");
    }

    public static String a(byte[] bArr, byte[] bArr2) throws UnsupportedEncodingException {
        if (bArr2 != null && bArr2.length == 16) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
                cipher.init(2, secretKeySpec);
                return new String(cipher.doFinal(bArr), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
                throw new UnsupportedEncodingException();
            }
        }
        throw new UnsupportedEncodingException("The key's length is invalid,should be 16 ");
    }

    public static String a(int i) {
        SecureRandom secureRandom = new SecureRandom();
        int[] iArr = {10, 26, 26};
        int[] iArr2 = {48, 65, 97};
        char[] cArr = new char[i];
        int nextInt = secureRandom.nextInt(3);
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = (char) (secureRandom.nextInt(iArr[nextInt]) + iArr2[nextInt]);
        }
        return new String(cArr);
    }
}
