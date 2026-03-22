package com.video.androidsdk.cast.bean.operation.play;

/* loaded from: classes.dex */
public class response {
    String SessionID;
    String errormsg;
    String returncode;

    public String getErrormsg() {
        return this.errormsg;
    }

    public String getReturncode() {
        return this.returncode;
    }

    public String getSessionID() {
        return this.SessionID;
    }

    public void setErrormsg(String str) {
        this.errormsg = str;
    }

    public void setReturncode(String str) {
        this.returncode = str;
    }

    public void setSessionID(String str) {
        this.SessionID = str;
    }
}
