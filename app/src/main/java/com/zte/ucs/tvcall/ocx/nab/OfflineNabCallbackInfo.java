package com.zte.ucs.tvcall.ocx.nab;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class OfflineNabCallbackInfo {
    private int contactNum;
    private OfflineCheckNab offlineCheckNab;
    private OfflineContactInfo offlineContactInfo;
    private String sessionID = "";
    private List<ContactAddressResp> addressInfoList = new ArrayList();

    public List<ContactAddressResp> getAddressInfoList() {
        return this.addressInfoList;
    }

    public int getContactNum() {
        return this.contactNum;
    }

    public OfflineCheckNab getOfflineCheckNab() {
        return this.offlineCheckNab;
    }

    public OfflineContactInfo getOfflineContactInfo() {
        return this.offlineContactInfo;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setAddressInfoList(List<ContactAddressResp> list) {
        this.addressInfoList = list;
    }

    public void setContactNum(int i) {
        this.contactNum = i;
    }

    public void setOfflineCheckNab(OfflineCheckNab offlineCheckNab) {
        this.offlineCheckNab = offlineCheckNab;
    }

    public void setOfflineContactInfo(OfflineContactInfo offlineContactInfo) {
        this.offlineContactInfo = offlineContactInfo;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
