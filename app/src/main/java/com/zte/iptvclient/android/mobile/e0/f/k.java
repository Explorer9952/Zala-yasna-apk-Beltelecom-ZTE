package com.zte.iptvclient.android.mobile.e0.f;

import android.text.TextUtils;

/* compiled from: VodStarMarkHelper.java */
/* loaded from: classes2.dex */
public class k {
    public static final float a(String str, String str2) {
        if (str2.equals("0")) {
            return 10.0f;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1.0f;
        }
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            if (parseInt2 != 0) {
                return (parseInt * 1.0f) / parseInt2;
            }
            return -1.0f;
        } catch (Exception e) {
            e.printStackTrace();
            return -1.0f;
        }
    }
}
