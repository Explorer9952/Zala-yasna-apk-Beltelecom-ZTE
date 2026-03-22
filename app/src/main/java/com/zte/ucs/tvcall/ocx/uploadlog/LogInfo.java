package com.zte.ucs.tvcall.ocx.uploadlog;

/* loaded from: classes2.dex */
public class LogInfo {
    private String accountid = "";
    private String logcontent = "";
    private String stepid = "";
    private int testflag = -1;

    public String getAccountid() {
        return this.accountid;
    }

    public String getLogcontent() {
        return this.logcontent;
    }

    public String getStepid() {
        return this.stepid;
    }

    public int getTestflag() {
        return this.testflag;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setLogcontent(String str) {
        this.logcontent = str;
    }

    public void setStepid(String str) {
        this.stepid = str;
    }

    public void setTestflag(int i) {
        this.testflag = i;
    }
}
