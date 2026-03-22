package com.zte.iptvclient.android.mobile.npvr.model.bean;

/* loaded from: classes.dex */
public class AddNpvrResultBean {
    String channelcode;
    String prevuecode;

    public AddNpvrResultBean(String str, String str2) {
        this.prevuecode = str;
        this.channelcode = str2;
    }

    public String getChannelcode() {
        String str = this.channelcode;
        return str == null ? "" : str;
    }

    public String getPrevuecode() {
        String str = this.prevuecode;
        return str == null ? "" : str;
    }
}
