package com.zte.ucs.tvcall.ocx.groupsm;

/* loaded from: classes2.dex */
public class SessGCMberInfo {
    private String contactId = "";
    private String contactName = "";
    private int roletype = 0;
    private int state = 0;

    public String getContactId() {
        return this.contactId;
    }

    public String getContactName() {
        return this.contactName;
    }

    public int getRoletype() {
        return this.roletype;
    }

    public int getState() {
        return this.state;
    }

    public void setContactId(String str) {
        this.contactId = str;
    }

    public void setContactName(String str) {
        this.contactName = str;
    }

    public void setRoletype(int i) {
        this.roletype = i;
    }

    public void setState(int i) {
        this.state = i;
    }
}
