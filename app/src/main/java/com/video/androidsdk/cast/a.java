package com.video.androidsdk.cast;

import com.video.androidsdk.log.LogEx;

/* compiled from: DLNAObjectFactory.java */
/* loaded from: classes.dex */
public class a {
    public static b a(String str, String str2, String str3, String str4, String str5, int i, boolean z, boolean z2, String str6) {
        int i2;
        LogEx.d("DLNAObjectFactory", "IDLNA.createObject");
        try {
            i2 = Integer.parseInt(str3);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i2 = 0;
        }
        return com.video.androidsdk.cast.a.a.a(str, str2, i2, str4, str5, i, z, z2, str6);
    }

    public static b a() {
        LogEx.d("DLNAObjectFactory", "IDLNA.getObject");
        return com.video.androidsdk.cast.a.a.d();
    }
}
