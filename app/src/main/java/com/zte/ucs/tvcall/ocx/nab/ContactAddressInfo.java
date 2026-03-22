package com.zte.ucs.tvcall.ocx.nab;

/* loaded from: classes2.dex */
public class ContactAddressInfo {
    private byte commonflag;
    private byte rcsflag;
    private String userpassword;
    public String contactid = "";
    public String accountid = "";
    public String firstname = "";
    public String familyname = "";
    public String addr = "";
    public String uri = "";
    public String tel = "";
    public String officetel = "";
    public String birthdate = "";
    public String officeaddr = "";
    public String employer = "";
    public String duty = "";
    public String email = "";
    public String icon = "";
    public String markname = "";
    public String area = "";
    public byte gender = 0;
    public String signature = "";
    public String etag = "";

    public String getAccountid() {
        return this.accountid;
    }

    public String getAddr() {
        return this.addr;
    }

    public String getArea() {
        return this.area;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public byte getCommonflag() {
        return this.commonflag;
    }

    public String getContactid() {
        return this.contactid;
    }

    public String getDuty() {
        return this.duty;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEmployer() {
        return this.employer;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getFamilyname() {
        return this.familyname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public byte getGender() {
        return this.gender;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getMarkname() {
        return this.markname;
    }

    public String getOfficeaddr() {
        return this.officeaddr;
    }

    public String getOfficetel() {
        return this.officetel;
    }

    public byte getRcsflag() {
        return this.rcsflag;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getTel() {
        return this.tel;
    }

    public String getUri() {
        return this.uri;
    }

    public String getUserpassword() {
        return this.userpassword;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setAddr(String str) {
        this.addr = str;
    }

    public void setArea(String str) {
        this.area = str;
    }

    public void setBirthdate(String str) {
        this.birthdate = str;
    }

    public void setCommonflag(byte b2) {
        this.commonflag = b2;
    }

    public void setContactid(String str) {
        this.contactid = str;
    }

    public void setDuty(String str) {
        this.duty = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setEmployer(String str) {
        this.employer = str;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setFamilyname(String str) {
        this.familyname = str;
    }

    public void setFirstname(String str) {
        this.firstname = str;
    }

    public void setGender(byte b2) {
        this.gender = b2;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setMarkname(String str) {
        this.markname = str;
    }

    public void setOfficeaddr(String str) {
        this.officeaddr = str;
    }

    public void setOfficetel(String str) {
        this.officetel = str;
    }

    public void setRcsflag(byte b2) {
        this.rcsflag = b2;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setTel(String str) {
        this.tel = str;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public void setUserpassword(String str) {
        this.userpassword = str;
    }
}
