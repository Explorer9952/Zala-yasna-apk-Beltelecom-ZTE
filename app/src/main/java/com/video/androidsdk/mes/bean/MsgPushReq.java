package com.video.androidsdk.mes.bean;

/* loaded from: classes.dex */
public class MsgPushReq {
    String DestList;
    Msg Msg;
    String PushType;
    String ReportURL;

    public String getDestList() {
        return this.DestList;
    }

    public Msg getMsg() {
        return this.Msg;
    }

    public String getPushType() {
        return this.PushType;
    }

    public String getReportURL() {
        return this.ReportURL;
    }

    public void setDestList(String str) {
        this.DestList = str;
    }

    public void setMsg(Msg msg) {
        this.Msg = msg;
    }

    public void setPushType(String str) {
        this.PushType = str;
    }

    public void setReportURL(String str) {
        this.ReportURL = str;
    }
}
