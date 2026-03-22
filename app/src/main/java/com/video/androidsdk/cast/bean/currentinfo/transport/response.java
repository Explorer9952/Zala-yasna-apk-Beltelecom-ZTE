package com.video.androidsdk.cast.bean.currentinfo.transport;

/* loaded from: classes.dex */
public class response {
    String CurrentSpeed;
    String CurrentTransportState;
    String CurrentTransportStatus;
    String errormsg;
    String returncode;

    public String getCurrentSpeed() {
        return this.CurrentSpeed;
    }

    public String getCurrentTransportState() {
        return this.CurrentTransportState;
    }

    public String getCurrentTransportStatus() {
        return this.CurrentTransportStatus;
    }

    public String getErrormsg() {
        return this.errormsg;
    }

    public String getReturncode() {
        return this.returncode;
    }

    public void setCurrentSpeed(String str) {
        this.CurrentSpeed = str;
    }

    public void setCurrentTransportState(String str) {
        this.CurrentTransportState = str;
    }

    public void setCurrentTransportStatus(String str) {
        this.CurrentTransportStatus = str;
    }

    public void setErrormsg(String str) {
        this.errormsg = str;
    }

    public void setReturncode(String str) {
        this.returncode = str;
    }
}
