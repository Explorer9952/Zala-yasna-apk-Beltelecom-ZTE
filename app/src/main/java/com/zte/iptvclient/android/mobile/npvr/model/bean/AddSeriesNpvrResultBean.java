package com.zte.iptvclient.android.mobile.npvr.model.bean;

/* loaded from: classes.dex */
public class AddSeriesNpvrResultBean {
    String channelcode;
    String prevuecode;
    String seriesheadid;

    public AddSeriesNpvrResultBean(String str, String str2, String str3) {
        this.prevuecode = str;
        this.channelcode = str2;
        this.seriesheadid = str3;
    }

    public String getChannelcode() {
        String str = this.channelcode;
        return str == null ? "" : str;
    }

    public String getPrevuecode() {
        String str = this.prevuecode;
        return str == null ? "" : str;
    }

    public String getSeriesheadid() {
        String str = this.seriesheadid;
        return str == null ? "" : str;
    }
}
