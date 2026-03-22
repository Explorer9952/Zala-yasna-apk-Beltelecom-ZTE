package com.video.androidsdk.service.bean;

/* loaded from: classes.dex */
public class UserSwitchReq {
    public String password;
    public int switchtype;
    public String switchvalue;

    public UserSwitchReq(String str, int i) {
        this.switchvalue = str;
        this.switchtype = i;
    }

    public String getPassword() {
        return this.password;
    }

    public int getSwitchtype() {
        return this.switchtype;
    }

    public String getSwitchvalue() {
        return this.switchvalue;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setSwitchtype(int i) {
        this.switchtype = i;
    }

    public void setSwitchvalue(String str) {
        this.switchvalue = str;
    }
}
