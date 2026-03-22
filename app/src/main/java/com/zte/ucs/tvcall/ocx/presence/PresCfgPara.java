package com.zte.ucs.tvcall.ocx.presence;

/* loaded from: classes2.dex */
public class PresCfgPara {
    int nAddrFormat;
    int nPresServerPort;
    String szPresIconPath = "";
    String szPresDomain = "";
    String szPresAPServiceName = "";
    String szPresServerAddr = "";

    public String getSzPresAPServiceName() {
        return this.szPresAPServiceName;
    }

    public String getSzPresDomain() {
        return this.szPresDomain;
    }

    public String getSzPresIconPath() {
        return this.szPresIconPath;
    }

    public String getSzPresServerAddr() {
        return this.szPresServerAddr;
    }

    public int getnAddrFormat() {
        return this.nAddrFormat;
    }

    public int getnPresServerPort() {
        return this.nPresServerPort;
    }

    public void setSzPresAPServiceName(String str) {
        this.szPresAPServiceName = str;
    }

    public void setSzPresDomain(String str) {
        this.szPresDomain = str;
    }

    public void setSzPresIconPath(String str) {
        this.szPresIconPath = str;
    }

    public void setSzPresServerAddr(String str) {
        this.szPresServerAddr = str;
    }

    public void setnAddrFormat(int i) {
        this.nAddrFormat = i;
    }

    public void setnPresServerPort(int i) {
        this.nPresServerPort = i;
    }
}
