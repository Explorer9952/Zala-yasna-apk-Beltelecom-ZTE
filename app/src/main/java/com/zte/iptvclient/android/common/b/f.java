package com.zte.iptvclient.android.common.b;

import java.security.SecureRandom;

/* compiled from: CharacterUtils.java */
/* loaded from: classes.dex */
public class f {
    public static String a(int i) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890".charAt(secureRandom.nextInt(62)));
        }
        return stringBuffer.toString();
    }
}
