package com.zte.iptvclient.android.mobile.npvr.model.bean;

/* loaded from: classes.dex */
public class DeleteNpvrResultBean {
    String prevuecode;

    public DeleteNpvrResultBean(String str) {
        this.prevuecode = str;
    }

    public String getPrevuecode() {
        String str = this.prevuecode;
        return str == null ? "" : str;
    }
}
