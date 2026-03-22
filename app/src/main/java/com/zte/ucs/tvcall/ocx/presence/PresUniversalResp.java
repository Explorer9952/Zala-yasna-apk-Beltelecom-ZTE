package com.zte.ucs.tvcall.ocx.presence;

/* loaded from: classes2.dex */
public class PresUniversalResp {
    int actionMode;
    int documentType;
    String accountid = "";
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

    public String getIconFilename() {
        return this.iconFilename;
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

    public void setIconFilename(String str) {
        this.iconFilename = str;
    }

    public void seteTag(String str) {
        this.eTag = str;
    }
}
