package com.zte.ucs.tvcall.ocx.groupchat;

/* loaded from: classes2.dex */
public class GroupChatAddMembReq {
    private String chatid = "";
    private String memberUri = "";
    private String displayname = "";
    private String displaynameEn = "";

    public String getChatid() {
        return this.chatid;
    }

    public String getDisplayname() {
        return this.displayname;
    }

    public String getDisplaynameEn() {
        return this.displaynameEn;
    }

    public String getMemberUri() {
        return this.memberUri;
    }

    public void setChatid(String str) {
        this.chatid = str;
    }

    public void setDisplayname(String str) {
        this.displayname = str;
    }

    public void setDisplaynameEn(String str) {
        this.displaynameEn = str;
    }

    public void setMemberUri(String str) {
        this.memberUri = str;
    }
}
