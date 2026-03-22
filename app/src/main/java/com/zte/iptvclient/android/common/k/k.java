package com.zte.iptvclient.android.common.k;

import android.text.TextUtils;
import com.zte.iptvclient.android.zala.R;

/* compiled from: DurationUnit.java */
/* loaded from: classes.dex */
public class k {
    private static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("parameter src cannot be null!!!");
        }
    }

    public static final String b(String str) {
        String str2;
        a(str);
        String[] split = str.split(":");
        int length = split.length;
        if (length == 3) {
            str2 = String.valueOf((Integer.valueOf(split[0]).intValue() * 60) + Integer.valueOf(split[1]).intValue());
        } else if (length == 2) {
            str2 = split[0];
        } else {
            str2 = length == 1 ? "0" : null;
        }
        return str2 + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.vod_detail_duration_unit_min);
    }
}
