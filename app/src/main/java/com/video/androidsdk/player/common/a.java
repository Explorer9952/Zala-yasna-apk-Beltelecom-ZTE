package com.video.androidsdk.player.common;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES.java */
/* loaded from: classes.dex */
public class a {
    public static String a(byte[] bArr, byte[] bArr2) throws UnsupportedEncodingException {
        return new String(Base64.encode(c(bArr, bArr2), 2));
    }

    public static String b(byte[] bArr, byte[] bArr2) throws UnsupportedEncodingException {
        return URLEncoder.encode(a(bArr, bArr2), "UTF-8");
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) throws UnsupportedEncodingException {
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

    public static String a(byte[] bArr, String str) throws UnsupportedEncodingException {
        return b(bArr, str.getBytes());
    }
}
