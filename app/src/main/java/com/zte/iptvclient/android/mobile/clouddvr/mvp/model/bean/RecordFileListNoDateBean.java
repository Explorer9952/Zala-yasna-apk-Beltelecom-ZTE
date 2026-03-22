package com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean;

/* loaded from: classes.dex */
public class RecordFileListNoDateBean {
    private String data;
    private String returncode;
    private String totalcount;

    public String getData() {
        String str = this.data;
        return str == null ? "" : str;
    }

    public String getReturncode() {
        return this.returncode;
    }

    public String getTotalcount() {
        return this.totalcount;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setReturncode(String str) {
        this.returncode = str;
    }

    public void setTotalcount(String str) {
        this.totalcount = str;
    }
}
