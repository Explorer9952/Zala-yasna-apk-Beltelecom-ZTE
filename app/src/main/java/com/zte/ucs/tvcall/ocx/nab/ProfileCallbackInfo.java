package com.zte.ucs.tvcall.ocx.nab;

/* loaded from: classes2.dex */
public class ProfileCallbackInfo {
    private ProfileInfo profileInfo;
    private String sessionID = "";

    public ProfileInfo getProfileInfo() {
        return this.profileInfo;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setProfileInfo(ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
