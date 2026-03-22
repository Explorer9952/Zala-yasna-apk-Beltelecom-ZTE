package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstContactNodeInDirectory {
    private String contactid = "";
    private int eTag = 0;
    private byte changedType = 0;

    public byte getChangedType() {
        return this.changedType;
    }

    public String getContactid() {
        return this.contactid;
    }

    public int geteTag() {
        return this.eTag;
    }

    public void setChangedType(byte b2) {
        this.changedType = b2;
    }

    public void setContactid(String str) {
        this.contactid = str;
    }

    public void seteTag(int i) {
        this.eTag = i;
    }
}
