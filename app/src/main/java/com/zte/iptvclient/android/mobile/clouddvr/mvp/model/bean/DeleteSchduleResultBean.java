package com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean;

/* loaded from: classes.dex */
public class DeleteSchduleResultBean {
    private String errormsg;
    private String mac;
    private String returncode;
    private String scheduleid;

    public String getErrormsg() {
        String str = this.errormsg;
        return str == null ? "" : str;
    }

    public String getMac() {
        String str = this.mac;
        return str == null ? "" : str;
    }

    public String getReturncode() {
        String str = this.returncode;
        return str == null ? "" : str;
    }

    public String getScheduleid() {
        String str = this.scheduleid;
        return str == null ? "" : str;
    }

    public void setErrormsg(String str) {
        this.errormsg = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setReturncode(String str) {
        this.returncode = str;
    }

    public void setScheduleid(String str) {
        this.scheduleid = str;
    }
}
