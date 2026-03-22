package com.video.androidsdk.service.bean;

import com.video.androidsdk.service.comm.ParamConst;
import java.util.Map;

/* loaded from: classes.dex */
public class AuthSuccRspInfo {
    private String authinfo;
    private String authorizationid;
    private String balance;
    private String contentcode;
    private String effectivedate;
    private String endtime;
    private String expiredtime;
    private String isfree;
    private String previewendtime;
    private String previewstarttime;
    private String prevuename;
    private String productcode;
    private String producttype;
    private String servicecode;
    private String starttime;

    public AuthSuccRspInfo(Map<String, String> map) {
        authSuccMapToBean(map);
    }

    private void authSuccMapToBean(Map<String, String> map) {
        if (map == null) {
            return;
        }
        setAuthorizationid(map.get("authorizationid"));
        setBalance(map.get("balance"));
        setContentcode(map.get("contentcode"));
        setEffectivedate(map.get(ParamConst.AUTH_RSP_EFFECTIVEDATE));
        setEndtime(map.get("endtime"));
        setExpiredtime(map.get("expiredtime"));
        setIsfree(map.get(ParamConst.AUTH_RSP_ISFREE));
        setPreviewendtime(map.get(ParamConst.AUTH_RSP_PREVIEWENDTIME));
        setPreviewstarttime(map.get(ParamConst.AUTH_RSP_PREVIEWSTARTTIME));
        setPrevuename(map.get("prevuename"));
        setProductcode(map.get("productcode"));
        setProducttype(map.get("producttype"));
        setServicecode(map.get("servicecode"));
        setStarttime(map.get("starttime"));
        setAuthinfo(map.get("authinfo"));
    }

    public String getAuthinfo() {
        return this.authinfo;
    }

    public String getAuthorizationid() {
        return this.authorizationid;
    }

    public String getBalance() {
        return this.balance;
    }

    public String getContentcode() {
        return this.contentcode;
    }

    public String getEffectivedate() {
        return this.effectivedate;
    }

    public String getEndtime() {
        return this.endtime;
    }

    public String getExpiredtime() {
        return this.expiredtime;
    }

    public String getIsfree() {
        return this.isfree;
    }

    public String getPreviewendtime() {
        return this.previewendtime;
    }

    public String getPreviewstarttime() {
        return this.previewstarttime;
    }

    public String getPrevuename() {
        return this.prevuename;
    }

    public String getProductcode() {
        return this.productcode;
    }

    public String getProducttype() {
        return this.producttype;
    }

    public String getServicecode() {
        return this.servicecode;
    }

    public String getStarttime() {
        return this.starttime;
    }

    public void setAuthinfo(String str) {
        this.authinfo = str;
    }

    public void setAuthorizationid(String str) {
        this.authorizationid = str;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public void setContentcode(String str) {
        this.contentcode = str;
    }

    public void setEffectivedate(String str) {
        this.effectivedate = str;
    }

    public void setEndtime(String str) {
        this.endtime = str;
    }

    public void setExpiredtime(String str) {
        this.expiredtime = str;
    }

    public void setIsfree(String str) {
        this.isfree = str;
    }

    public void setPreviewendtime(String str) {
        this.previewendtime = str;
    }

    public void setPreviewstarttime(String str) {
        this.previewstarttime = str;
    }

    public void setPrevuename(String str) {
        this.prevuename = str;
    }

    public void setProductcode(String str) {
        this.productcode = str;
    }

    public void setProducttype(String str) {
        this.producttype = str;
    }

    public void setServicecode(String str) {
        this.servicecode = str;
    }

    public void setStarttime(String str) {
        this.starttime = str;
    }
}
