package com.video.androidsdk.common;

import android.text.TextUtils;
import android.util.Base64;
import com.video.androidsdk.license.a;
import com.video.androidsdk.log.LogEx;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.StringTokenizer;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class AES {
    public static final String LOG_TAG = "AES";
    public static final String STR_AES_ALGORITHM = "AES";
    public static final String strFirst = "WlRFY2xpZW50";
    public static final String strSecond = "ODkyMmExNw==";

    public static String aesDecode(String str, byte[] bArr) throws UnsupportedEncodingException {
        return aesDecryptByBase64(URLDecoder.decode(str, "UTF-8"), bArr);
    }

    public static byte[] aesDecrypt(byte[] bArr, byte[] bArr2) throws UnsupportedEncodingException {
        if (bArr2 != null && bArr2.length == 16) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
                cipher.init(2, secretKeySpec);
                return cipher.doFinal(bArr);
            } catch (Exception e) {
                e.printStackTrace();
                throw new UnsupportedEncodingException();
            }
        }
        throw new UnsupportedEncodingException("The key's length is invalid,should be 16 ");
    }

    public static String aesDecryptByBase64(String str, byte[] bArr) throws UnsupportedEncodingException {
        return new String(aesDecrypt(Base64.decode(str, 2), bArr));
    }

    public static String aesEncode(byte[] bArr, byte[] bArr2) throws UnsupportedEncodingException {
        return URLEncoder.encode(aesEncryptByBase64(bArr, bArr2), "UTF-8");
    }

    public static byte[] aesEncrypt(byte[] bArr, byte[] bArr2) throws UnsupportedEncodingException {
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

    public static String aesEncryptByBase64(byte[] bArr, byte[] bArr2) throws UnsupportedEncodingException {
        return new String(Base64.encode(aesEncrypt(bArr, bArr2), 2));
    }

    public static String aesEncryptByHex(String str, byte[] bArr) throws UnsupportedEncodingException {
        return byte2hex(aesEncrypt(str.getBytes(), bArr));
    }

    public static String byte2hex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(hexString);
            } else {
                stringBuffer.append(hexString);
            }
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static String formatHexString(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        if (length > 8) {
            return str;
        }
        for (int i = 0; i < 8 - length; i++) {
            stringBuffer.append("0");
        }
        return stringBuffer.toString() + str;
    }

    public static String getEncryptKey(String str) {
        if (TextUtils.isEmpty(str)) {
            LogEx.e("AES", "input param is empty!");
            return "";
        }
        return a.a(str);
    }

    public static byte[] hex2byte(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 2 != 0) {
            return null;
        }
        int i = length / 2;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 != i; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    public static String ipToHex(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        int i = 24;
        long j = 0;
        while (stringTokenizer.hasMoreTokens()) {
            j += Integer.parseInt(stringTokenizer.nextToken()) << i;
            i -= 8;
        }
        return Long.toHexString(j);
    }

    public static byte[] join(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] joinAll(byte[][] bArr) {
        byte[] bArr2 = new byte[0];
        for (byte[] bArr3 : bArr) {
            bArr2 = join(bArr2, bArr3);
        }
        return bArr2;
    }

    public static byte[] joinAuthInfo(String str, String str2, String str3, String str4, String str5) {
        return joinAll(new byte[][]{(str + "$$").getBytes(), hex2byte(formatHexString(ipToHex(str2))), ("$$" + str3).getBytes(), ("$$" + str4).getBytes(), ("$$" + str5).getBytes()});
    }

    public static String randomString(int i) {
        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            secureRandom = null;
        }
        int[] iArr = {10, 26, 26};
        int[] iArr2 = {48, 65, 97};
        char[] cArr = new char[i];
        if (secureRandom != null) {
            int nextInt = secureRandom.nextInt(3);
            for (int i2 = 0; i2 < i; i2++) {
                cArr[i2] = (char) (secureRandom.nextInt(iArr[nextInt]) + iArr2[nextInt]);
            }
        }
        return new String(cArr);
    }

    public void epgCrpt() {
    }

    public static String aesDecode(String str, String str2) throws UnsupportedEncodingException {
        return aesDecode(str, str2.getBytes());
    }

    public static String aesDecryptByBase64(String str, byte[] bArr, String str2) throws UnsupportedEncodingException {
        return new String(aesDecrypt(Base64.decode(str, 2), bArr), str2);
    }

    public static String aesEncode(byte[] bArr, String str) throws UnsupportedEncodingException {
        return aesEncode(bArr, str.getBytes());
    }
}
