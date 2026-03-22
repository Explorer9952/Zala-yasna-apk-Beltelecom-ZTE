package com.zte.iptvclient.android.mobile.npvr.model.bean;

import com.video.androidsdk.log.LogEx;

/* loaded from: classes.dex */
public class DeleteSeriesNpvrResultBean {
    String mStrSeriesheadid;

    public DeleteSeriesNpvrResultBean(String str) {
        this.mStrSeriesheadid = str;
        LogEx.d("DeleteSeriesNpvrResultBean", "mStrSeriesheadid " + this.mStrSeriesheadid);
    }
}
