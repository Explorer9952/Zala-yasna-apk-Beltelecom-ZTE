package com.zte.iptvclient.android.mobile.e0.f;

import com.video.androidsdk.log.LogEx;

/* compiled from: VodPriceHelper.java */
/* loaded from: classes2.dex */
public class j {
    public static final int a() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Fee_Rate");
        LogEx.d("VodPriceHelper", "fee_rate : " + c2);
        if (c2 == null) {
            return 100;
        }
        try {
            return Integer.valueOf(c2).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 100;
        }
    }
}
