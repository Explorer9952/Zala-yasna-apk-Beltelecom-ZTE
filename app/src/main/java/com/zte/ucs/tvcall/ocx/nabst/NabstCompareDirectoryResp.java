package com.zte.ucs.tvcall.ocx.nabst;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class NabstCompareDirectoryResp {
    private byte actionMode;
    public String accountid = "";
    private String sessionID = "";
    private byte pccchangedType = 0;
    private byte userperfchangedType = 0;
    private int nabEtag = 0;
    private int contactsCount = 0;
    private ResultInfo tResultInfo = new ResultInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public byte getActionMode() {
        return this.actionMode;
    }

    public int getContactsCount() {
        return this.contactsCount;
    }

    public int getNabEtag() {
        return this.nabEtag;
    }

    public byte getPccchangedType() {
        return this.pccchangedType;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public byte getUserperfchangedType() {
        return this.userperfchangedType;
    }

    public ResultInfo gettResultInfo() {
        return this.tResultInfo;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setActionMode(byte b2) {
        this.actionMode = b2;
    }

    public void setContactsCount(int i) {
        this.contactsCount = i;
    }

    public void setNabEtag(int i) {
        this.nabEtag = i;
    }

    public void setPccchangedType(byte b2) {
        this.pccchangedType = b2;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setUserperfchangedType(byte b2) {
        this.userperfchangedType = b2;
    }

    public void settResultInfo(ResultInfo resultInfo) {
        this.tResultInfo = resultInfo;
    }
}
