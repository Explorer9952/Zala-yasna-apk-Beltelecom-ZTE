package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstContactInfo {
    private String contactid = "";
    private String birthday = "";
    private String note = "";
    private String orgName = "";
    private NabstCommAddrInfo tCommAddr = new NabstCommAddrInfo();
    private NabstPersonNameInfo tName = new NabstPersonNameInfo();
    private NabstPersonAddressList tAddress = new NabstPersonAddressList();
    private NabstGroupList tGroup = new NabstGroupList();

    public String getBirthday() {
        return this.birthday;
    }

    public String getContactid() {
        return this.contactid;
    }

    public String getNote() {
        return this.note;
    }

    public String getOrgName() {
        return this.orgName;
    }

    public NabstPersonAddressList gettAddress() {
        return this.tAddress;
    }

    public NabstCommAddrInfo gettCommAddr() {
        return this.tCommAddr;
    }

    public NabstGroupList gettGroup() {
        return this.tGroup;
    }

    public NabstPersonNameInfo gettName() {
        return this.tName;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setContactid(String str) {
        this.contactid = str;
    }

    public void setNote(String str) {
        this.note = str;
    }

    public void setOrgName(String str) {
        this.orgName = str;
    }

    public void settAddress(NabstPersonAddressList nabstPersonAddressList) {
        this.tAddress = nabstPersonAddressList;
    }

    public void settCommAddr(NabstCommAddrInfo nabstCommAddrInfo) {
        this.tCommAddr = nabstCommAddrInfo;
    }

    public void settGroup(NabstGroupList nabstGroupList) {
        this.tGroup = nabstGroupList;
    }

    public void settName(NabstPersonNameInfo nabstPersonNameInfo) {
        this.tName = nabstPersonNameInfo;
    }
}
