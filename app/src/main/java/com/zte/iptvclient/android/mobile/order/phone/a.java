package com.zte.iptvclient.android.mobile.order.phone;

import android.util.Base64;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.k.s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AuthInfoEascrypt.java */
/* loaded from: classes.dex */
public class a {
    public static String a(String str) {
        try {
            return a((str + "$$" + new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(s.b()) + "$$" + a(10)).getBytes(), AES.getEncryptKey("thirdpaykey").getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws Exception {
        if (bArr2 != null && bArr2.length == 16) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
                cipher.init(1, secretKeySpec);
                return cipher.doFinal(bArr);
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
        throw new Exception("The key's length is invalid,should be 16 ");
    }

    public static String c(byte[] bArr, byte[] bArr2) throws Exception {
        String str = new String(Base64.encode(b(bArr, bArr2), 0));
        LogEx.d("AuthInfoEascrypt", "--------- res=[" + str + "]");
        return str;
    }

    public static String a(String str, String str2) {
        byte[] bArr = new byte[0];
        try {
            bArr = (str + "$$" + str2 + "$$" + new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(s.b()) + "$$" + a(10)).getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            return a(bArr, AES.getEncryptKey("thirdpaykey").getBytes("utf-8"));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
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

    public static String a(byte[] bArr, byte[] bArr2) throws Exception {
        String encode = URLEncoder.encode(c(bArr, bArr2), "UTF-8");
        LogEx.d("AuthInfoEascrypt", "--------- res=[" + encode + "]");
        return encode;
    }
}
