package com.zte.iptvclient.android.mobile.e0.f;

import android.widget.ImageView;
import com.zte.iptvclient.android.zala.R;

/* compiled from: VodPayOrFreeHelper.java */
/* loaded from: classes2.dex */
public class i {
    public static final void a(String str, boolean z, ImageView imageView, boolean z2) {
        if (!z2) {
            imageView.setVisibility(8);
            return;
        }
        int b2 = com.zte.iptvclient.android.common.k.g.b(str);
        if (b2 == 1) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.free);
        } else if (b2 == 2) {
            imageView.setVisibility(0);
            imageView.setImageResource(z ? R.drawable.vip_pay : R.drawable.pay);
        } else {
            imageView.setVisibility(8);
        }
    }
}
