package com.zte.ucs.tvcall.ocx.presence;

/* loaded from: classes2.dex */
public class PresUniversalReq {
    int actionMode;
    int documentType;
    int expires;
    String accountid = "";
    String password = "";
    String contactid = "";
    String iconFilename = "";
    String eTag = "";

    public String getAccountid() {
        return this.accountid;
    }

    public int getActionMode() {
        return this.actionMode;
    }

    public String getContactid() {
        return this.contactid;
    }

    public int getDocumentType() {
        return this.documentType;
    }

    public int getExpires() {
        return this.expires;
    }

    public String getIconFilename() {
        return this.iconFilename;
    }

    public String getPassword() {
        return this.password;
    }

    public String geteTag() {
        return this.eTag;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setActionMode(int i) {
        this.actionMode = i;
    }

    public void setContactid(String str) {
        this.contactid = str;
    }

    public void setDocumentType(int i) {
        this.documentType = i;
    }

    public void setExpires(int i) {
        this.expires = i;
    }

    public void setIconFilename(String str) {
        this.iconFilename = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void seteTag(String str) {
        this.eTag = str;
    }
}
