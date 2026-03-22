package com.video.androidsdk.service.bean;

/* loaded from: classes.dex */
public class UserRegisterReq {
    public String CNIC;
    public String authinfo;
    public String checkcode;
    public String citycode;
    public String customername;
    public String email;
    public String mobileno;
    public String ottuserid;
    public String password;

    public UserRegisterReq(String str, String str2, String str3) {
        this.ottuserid = str;
        this.customername = str2;
        this.mobileno = str3;
    }

    public String getAuthinfo() {
        return this.authinfo;
    }

    public String getCNIC() {
        return this.CNIC;
    }

    public String getCheckcode() {
        return this.checkcode;
    }

    public String getCitycode() {
        return this.citycode;
    }

    public String getCustomername() {
        return this.customername;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMobileno() {
        return this.mobileno;
    }

    public String getOttuserid() {
        return this.ottuserid;
    }

    public String getPassword() {
        return this.password;
    }

    public void setAuthinfo(String str) {
        this.authinfo = str;
    }

    public void setCNIC(String str) {
        this.CNIC = str;
    }

    public void setCheckcode(String str) {
        this.checkcode = str;
    }

    public void setCitycode(String str) {
        this.citycode = str;
    }

    public void setCustomername(String str) {
        this.customername = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setMobileno(String str) {
        this.mobileno = str;
    }

    public void setOttuserid(String str) {
        this.ottuserid = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }
}
