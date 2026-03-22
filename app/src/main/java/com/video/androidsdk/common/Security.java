package com.video.androidsdk.common;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class Security {
    private String bytes2Hex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String encrypt(String str, String str2) {
        Security security = new Security();
        byte[] bytes = str.getBytes();
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "SHA-256";
            }
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(bytes);
            return security.bytes2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Invalid algorithm./n" + e.getMessage());
            return null;
        }
    }
}
