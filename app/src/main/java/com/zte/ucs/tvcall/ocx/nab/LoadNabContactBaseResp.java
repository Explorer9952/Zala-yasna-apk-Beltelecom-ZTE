package com.zte.ucs.tvcall.ocx.nab;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class LoadNabContactBaseResp {
    private List<ContactBaseInfo> ContactBaseInfoList = new ArrayList();
    private String accountid;
    private String etag;
    private int result;
    private String sessionid;

    public String getAccountid() {
        return this.accountid;
    }

    public List<ContactBaseInfo> getContactBaseInfoList() {
        return this.ContactBaseInfoList;
    }

    public String getEtag() {
        return this.etag;
    }

    public int getResult() {
        return this.result;
    }

    public String getSessionid() {
        return this.sessionid;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setContactBaseInfoList(List<ContactBaseInfo> list) {
        if (list != null) {
            this.ContactBaseInfoList = list;
        }
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setSessionid(String str) {
        this.sessionid = str;
    }
}
