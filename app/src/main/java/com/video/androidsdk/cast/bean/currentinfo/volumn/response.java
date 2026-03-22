package com.video.androidsdk.cast.bean.currentinfo.volumn;

/* loaded from: classes.dex */
public class response {
    String CurrentVolume;
    String SessionID;
    String errormsg;
    String returncode;

    public String getCurrentVolume() {
        return this.CurrentVolume;
    }

    public String getErrormsg() {
        return this.errormsg;
    }

    public String getReturncode() {
        return this.returncode;
    }

    public String getSessionID() {
        return this.SessionID;
    }

    public void setCurrentVolume(String str) {
        this.CurrentVolume = str;
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
