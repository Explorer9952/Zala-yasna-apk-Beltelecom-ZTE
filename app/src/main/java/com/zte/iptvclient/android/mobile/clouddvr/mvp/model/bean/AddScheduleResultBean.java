package com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean;

/* loaded from: classes.dex */
public class AddScheduleResultBean {
    private String data;
    private String errormsg;
    private String mac;
    private String recordstarttime;
    private int returncode;
    private int scheduleid;
    private int taskid;

    public String getData() {
        String str = this.data;
        return str == null ? "" : str;
    }

    public String getErrormsg() {
        String str = this.errormsg;
        return str == null ? "" : str;
    }

    public String getMac() {
        String str = this.mac;
        return str == null ? "" : str;
    }

    public String getRecordstarttime() {
        String str = this.recordstarttime;
        return str == null ? "" : str;
    }

    public int getReturncode() {
        return this.returncode;
    }

    public int getScheduleid() {
        return this.scheduleid;
    }

    public int getTaskid() {
        return this.taskid;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setErrormsg(String str) {
        this.errormsg = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setRecordstarttime(String str) {
        this.recordstarttime = str;
    }

    public void setReturncode(int i) {
        this.returncode = i;
    }

    public void setScheduleid(int i) {
        this.scheduleid = i;
    }

    public void setTaskid(int i) {
        this.taskid = i;
    }
}
