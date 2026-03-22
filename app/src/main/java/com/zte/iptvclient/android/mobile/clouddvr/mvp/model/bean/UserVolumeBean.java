package com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean;

/* loaded from: classes.dex */
public class UserVolumeBean {
    private double availablevolume;
    private String errormsg;
    private int returncode;
    private double totalvolume;
    private double usedvolume;

    public double getAvailablevolume() {
        return this.availablevolume;
    }

    public String getErrormsg() {
        String str = this.errormsg;
        return str == null ? "" : str;
    }

    public int getReturncode() {
        return this.returncode;
    }

    public double getTotalvolume() {
        return this.totalvolume;
    }

    public double getUsedvolume() {
        return this.usedvolume;
    }

    public void setAvailablevolume(double d2) {
        this.availablevolume = d2;
    }

    public void setErrormsg(String str) {
        this.errormsg = str;
    }

    public void setReturncode(int i) {
        this.returncode = i;
    }

    public void setTotalvolume(double d2) {
        this.totalvolume = d2;
    }

    public void setUsedvolume(double d2) {
        this.usedvolume = d2;
    }
}
