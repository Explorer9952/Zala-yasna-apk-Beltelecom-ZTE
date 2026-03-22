package com.video.androidsdk.common.util.security;

import com.video.androidsdk.common.NonidealDataException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class DES {
    public static final String ALGORITHM_DEFAULT = "DES";
    public static final String ALGORITHM_MODE_CBC = "CBC";
    public static final String ALGORITHM_MODE_CFB = "CFB";
    public static final String ALGORITHM_MODE_ECB = "ECB";
    public static final String ALGORITHM_MODE_OFB = "OFB";
    public static final String ALGORITHM_PADDING_PKCS1 = "PKCS1Padding";
    public static final String ALGORITHM_PADDING_PKCS5 = "PKCS5Padding";
    public static final String ALGORITHM_PADDING_PKCS7 = "PKCS7Padding";
    public static final String ALGORITHM_TRIPLE = "DESede";

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, String str) {
        return decrypt(bArr, bArr2, str, null);
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, String str) {
        return encrypt(bArr, bArr2, str, null);
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, String str, String str2) {
        return decrypt(bArr, bArr2, str, str2, null);
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, String str, String str2) {
        return encrypt(bArr, bArr2, str, str2, null);
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, String str, String str2, String str3) {
        if (bArr == null) {
            return new byte[0];
        }
        if (bArr2 == null) {
            return new byte[0];
        }
        if (str == null) {
            return new byte[0];
        }
        StringBuilder sb = new StringBuilder(str);
        if (str2 != null || str3 != null) {
            if (str2 == null) {
                sb.append("/");
                sb.append(ALGORITHM_MODE_ECB);
            } else if (!ALGORITHM_MODE_ECB.equals(str2) && !ALGORITHM_MODE_CBC.equals(str2)) {
                if (ALGORITHM_TRIPLE.equals(str)) {
                    return new byte[0];
                }
                if (!ALGORITHM_MODE_CFB.equals(str2) && !ALGORITHM_MODE_OFB.equals(str2)) {
                    return new byte[0];
                }
                sb.append("/");
                sb.append(str2);
            } else {
                sb.append("/");
                sb.append(str2);
            }
            if (str3 == null) {
                sb.append("/");
                sb.append(ALGORITHM_PADDING_PKCS5);
            } else {
                sb.append("/");
                sb.append(str3);
            }
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, sb.toString());
            Cipher cipher = Cipher.getInstance(sb.toString());
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return new byte[0];
        } catch (Exception e3) {
            e3.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, String str, String str2, String str3) {
        if (bArr == null) {
            return new byte[0];
        }
        if (bArr2 == null) {
            return new byte[0];
        }
        if (str == null) {
            return new byte[0];
        }
        if (!ALGORITHM_DEFAULT.equals(str) && !ALGORITHM_TRIPLE.equals(str)) {
            try {
                throw new NonidealDataException("type's value is wrong", str);
            } catch (NonidealDataException e) {
                e.printStackTrace();
                return new byte[0];
            }
        }
        StringBuilder sb = new StringBuilder(str);
        if (str2 == null || str3 == null) {
            if (str2 == null) {
                sb.append("/");
                sb.append(ALGORITHM_MODE_ECB);
            } else if (!ALGORITHM_MODE_ECB.equals(str2) && !ALGORITHM_MODE_CBC.equals(str2)) {
                if (ALGORITHM_TRIPLE.equals(str)) {
                    return new byte[0];
                }
                if (!ALGORITHM_MODE_CFB.equals(str2) && !ALGORITHM_MODE_OFB.equals(str2)) {
                    return new byte[0];
                }
                sb.append("/");
                sb.append(str2);
            } else {
                sb.append("/");
                sb.append(str2);
            }
            if (str3 == null) {
                sb.append("/");
                sb.append(ALGORITHM_PADDING_PKCS5);
            } else {
                sb.append("/");
                sb.append(str3);
            }
        }
        try {
            Cipher cipher = Cipher.getInstance(sb.toString());
            cipher.init(1, SecretKeyFactory.getInstance(str).generateSecret(new DESedeKeySpec(bArr)));
            return cipher.doFinal(bArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new byte[0];
        }
    }
}
