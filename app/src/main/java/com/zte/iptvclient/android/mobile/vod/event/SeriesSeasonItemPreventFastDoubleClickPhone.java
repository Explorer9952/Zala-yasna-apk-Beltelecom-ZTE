package com.zte.iptvclient.android.mobile.vod.event;

import android.view.View;
import com.video.androidsdk.log.LogEx;
import it.sephiroth.android.library.widget.AdapterView;

/* loaded from: classes2.dex */
public class SeriesSeasonItemPreventFastDoubleClickPhone implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    private long f7655a;

    /* renamed from: b, reason: collision with root package name */
    private AdapterView.OnItemClickListener f7656b;

    public SeriesSeasonItemPreventFastDoubleClickPhone(AdapterView.OnItemClickListener onItemClickListener) {
        this.f7656b = onItemClickListener;
    }

    @Override // it.sephiroth.android.library.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.f7655a;
        LogEx.d("SeriesSeasonItemPreventFastDoubleClickPhone", "--onItemClick--> lGap: " + j2);
        if (j2 > 300) {
            this.f7655a = currentTimeMillis;
            this.f7656b.onItemClick(adapterView, view, i, j);
        }
    }
}
