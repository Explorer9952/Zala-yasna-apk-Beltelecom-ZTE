package com.zte.ucs.tvcall.ocx.nab;

/* loaded from: classes2.dex */
public class ContactBaseInfo {
    public byte commonflag;
    public String displayname;
    public String friendisdnaddr;
    public byte rcsflag;
    public String remarkname;
    public String tel;

    public byte getCommonflag() {
        return this.commonflag;
    }

    public String getDisplayname() {
        return this.displayname;
    }

    public String getFriendisdnaddr() {
        return this.friendisdnaddr;
    }

    public byte getRcsflag() {
        return this.rcsflag;
    }

    public String getRemarkname() {
        return this.remarkname;
    }

    public String getTel() {
        return this.tel;
    }

    public void setCommonflag(byte b2) {
        this.commonflag = b2;
    }

    public void setDisplayname(String str) {
        this.displayname = str;
    }

    public void setFriendisdnaddr(String str) {
        this.friendisdnaddr = str;
    }

    public void setRcsflag(byte b2) {
        this.rcsflag = b2;
    }

    public void setRemarkname(String str) {
        this.remarkname = str;
    }

    public void setTel(String str) {
        this.tel = str;
    }
}
