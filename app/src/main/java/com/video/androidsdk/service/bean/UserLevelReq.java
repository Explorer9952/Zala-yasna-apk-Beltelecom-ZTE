package com.video.androidsdk.service.bean;

/* loaded from: classes.dex */
public class UserLevelReq {
    public String blocktitlelevel;
    public String limitlevel;
    public String password;

    public UserLevelReq(String str, String str2, String str3) {
        this.limitlevel = str;
        this.blocktitlelevel = str2;
        this.password = str3;
    }

    public String getBlocktitlelevel() {
        return this.blocktitlelevel;
    }

    public String getLimitlevel() {
        return this.limitlevel;
    }

    public String getPassword() {
        return this.password;
    }

    public void setBlocktitlelevel(String str) {
        this.blocktitlelevel = str;
    }

    public void setLimitlevel(String str) {
        this.limitlevel = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }
}
