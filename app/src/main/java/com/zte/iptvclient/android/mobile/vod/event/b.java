package com.zte.iptvclient.android.mobile.vod.event;

import android.view.View;
import android.widget.AdapterView;
import com.video.androidsdk.log.LogEx;

/* compiled from: SeriesSeasonItemPreventFastDoubleClick.java */
/* loaded from: classes2.dex */
public class b implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    private long f7657a;

    /* renamed from: b, reason: collision with root package name */
    private AdapterView.OnItemClickListener f7658b;

    public b(AdapterView.OnItemClickListener onItemClickListener) {
        this.f7658b = onItemClickListener;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.f7657a;
        LogEx.d("SeriesSeasonItemPreventFastDoubleClick", "--onItemClick--> lGap: " + j2);
        if (j2 > 300) {
            this.f7657a = currentTimeMillis;
            this.f7658b.onItemClick(adapterView, view, i, j);
        }
    }
}
