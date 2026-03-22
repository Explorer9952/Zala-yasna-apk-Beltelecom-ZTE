package com.video.androidsdk.service.bean;

/* loaded from: classes.dex */
public class SubscribeReq extends BaseReqParams {
    public String action;
    public String billdate;
    public String columncode;
    public String contentcode;
    public String contenttype;
    public String ordertime;
    public String productcode;
    public String purchasetype;
    public String subcode;
    public String isautocontinue = "1";
    public String definition = "0";
    public String recommendtype = "0";

    public SubscribeReq(String str, String str2, String str3) {
        this.purchasetype = str;
        this.productcode = str2;
        this.action = str3;
    }

    public String getAction() {
        return this.action;
    }

    public String getBilldate() {
        return this.billdate;
    }

    public String getColumncode() {
        return this.columncode;
    }

    public String getContentcode() {
        return this.contentcode;
    }

    public String getContenttype() {
        return this.contenttype;
    }

    public String getDefinition() {
        return this.definition;
    }

    public String getIsautocontinue() {
        return this.isautocontinue;
    }

    public String getOrdertime() {
        return this.ordertime;
    }

    public String getProductcode() {
        return this.productcode;
    }

    public String getPurchasetype() {
        return this.purchasetype;
    }

    public String getRecommendtype() {
        return this.recommendtype;
    }

    public String getSubcode() {
        return this.subcode;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setBilldate(String str) {
        this.billdate = str;
    }

    public void setColumncode(String str) {
        this.columncode = str;
    }

    public void setContentcode(String str) {
        this.contentcode = str;
    }

    public void setContenttype(String str) {
        this.contenttype = str;
    }

    public void setDefinition(String str) {
        this.definition = str;
    }

    public void setIsAutoContinue(boolean z) {
        this.isautocontinue = z ? "1" : "0";
    }

    public void setIsautocontinue(String str) {
        this.isautocontinue = str;
    }

    public void setOrdertime(String str) {
        this.ordertime = str;
    }

    public void setProductcode(String str) {
        this.productcode = str;
    }

    public void setPurchasetype(String str) {
        this.purchasetype = str;
    }

    public void setRecommendtype(String str) {
        this.recommendtype = str;
    }

    public void setSubcode(String str) {
        this.subcode = str;
    }
}
