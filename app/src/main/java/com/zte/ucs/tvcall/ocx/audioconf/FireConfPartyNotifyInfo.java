package com.zte.ucs.tvcall.ocx.audioconf;

import java.util.List;

/* loaded from: classes2.dex */
public class FireConfPartyNotifyInfo {
    private List<String> callednum;
    private String callingnum;
    private String confid;
    private int subType;
    private int type;

    public List<String> getCallednum() {
        return this.callednum;
    }

    public String getCallingnum() {
        return this.callingnum;
    }

    public String getConfid() {
        return this.confid;
    }

    public int getSubType() {
        return this.subType;
    }

    public int getType() {
        return this.type;
    }

    public void setCallednum(List<String> list) {
        this.callednum = list;
    }

    public void setCallingnum(String str) {
        this.callingnum = str;
    }

    public void setConfid(String str) {
        this.confid = str;
    }

    public void setSubType(int i) {
        this.subType = i;
    }

    public void setType(int i) {
        this.type = i;
    }
}
