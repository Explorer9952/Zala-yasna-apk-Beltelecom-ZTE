package com.video.androidsdk.service.bean;

/* loaded from: classes.dex */
public class AuthReq {
    public String columncode;
    public String contenttype;
    public String ip;
    public String playtime;
    public String programcode;
    public String terminalflag;
    public String definition = "0";
    public String isplay = "0";

    public AuthReq(String str, String str2, String str3) {
        this.programcode = str2;
        this.columncode = str;
        this.contenttype = str3;
    }

    public String getColumncode() {
        return this.columncode;
    }

    public String getContenttype() {
        return this.contenttype;
    }

    public String getDefinition() {
        return this.definition;
    }

    public String getIp() {
        return this.ip;
    }

    public String getIsplay() {
        return this.isplay;
    }

    public String getPlaytime() {
        return this.playtime;
    }

    public String getProgramcode() {
        return this.programcode;
    }

    public String getTerminalflag() {
        return this.terminalflag;
    }

    public void setColumncode(String str) {
        this.columncode = str;
    }

    public void setContenttype(String str) {
        this.contenttype = str;
    }

    public void setDefinition(String str) {
        this.definition = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setIsplay(String str) {
        this.isplay = str;
    }

    public void setPlaytime(String str) {
        this.playtime = str;
    }

    public void setProgramcode(String str) {
        this.programcode = str;
    }

    public void setTerminalflag(String str) {
        this.terminalflag = str;
    }
}
