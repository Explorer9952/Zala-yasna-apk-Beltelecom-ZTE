package com.zte.ucs.tvcall.ocx.nab;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class NabCallbackInfo {
    private int contactNum;
    private int contactpackage;
    private int currentpackage;
    private ProfileInfo profileInfo;
    private UserPrefsInfo userPrefsInfo;
    private String sessionID = "";
    private List<ContactAddressInfo> addressInfoList = new ArrayList();

    public List<ContactAddressInfo> getAddressInfoList() {
        return this.addressInfoList;
    }

    public int getContactNum() {
        return this.contactNum;
    }

    public int getContactpackage() {
        return this.contactpackage;
    }

    public int getCurrentpackage() {
        return this.currentpackage;
    }

    public ProfileInfo getProfileInfo() {
        return this.profileInfo;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public UserPrefsInfo getUserPrefsInfo() {
        return this.userPrefsInfo;
    }

    public void setAddressInfoList(List<ContactAddressInfo> list) {
        this.addressInfoList = list;
    }

    public void setContactNum(int i) {
        this.contactNum = i;
    }

    public void setContactpackage(int i) {
        this.contactpackage = i;
    }

    public void setCurrentpackage(int i) {
        this.currentpackage = i;
    }

    public void setProfileInfo(ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setUserPrefsInfo(UserPrefsInfo userPrefsInfo) {
        this.userPrefsInfo = userPrefsInfo;
    }
}
