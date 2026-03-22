package com.video.androidsdk.cast.bean;

/* loaded from: classes.dex */
public class DLNAInitReq {
    private String multiGateHost = "";
    private String multiGatePort = "";
    private String userID = "";
    private String userToken = "";
    private String deviceId = "";
    private int opflag = 2;
    private boolean needDlna = true;
    private boolean isztedevice = true;

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getMultiGateHost() {
        return this.multiGateHost;
    }

    public String getMultiGatePort() {
        return this.multiGatePort;
    }

    public int getOpflag() {
        return this.opflag;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getUserToken() {
        return this.userToken;
    }

    public boolean isIsztedevice() {
        return this.isztedevice;
    }

    public boolean isNeedDlna() {
        return this.needDlna;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setGateDomain(String str, String str2) {
        this.multiGateHost = str;
        this.multiGatePort = str2;
    }

    public void setUpnpPares(int i, boolean z, boolean z2) {
        this.opflag = i;
        this.needDlna = z;
        this.isztedevice = z2;
    }

    public void setUserInfo(String str, String str2) {
        this.userID = str;
        this.userToken = str2;
    }
}
