package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class SingleSendLocationInfo {
    private String longitude = "";
    private String latidute = "";
    private String radius = "";
    private String locationName = "";
    private String messageId = "";
    private String receiverUri = "";
    private int receipt = 0;
    private int msgFlag = 0;
    private int barcycleTime = 0;

    public int getBarcycleTime() {
        return this.barcycleTime;
    }

    public String getLatidute() {
        return this.latidute;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMsgFlag() {
        return this.msgFlag;
    }

    public String getRadius() {
        return this.radius;
    }

    public int getReceipt() {
        return this.receipt;
    }

    public String getReceiverUri() {
        return this.receiverUri;
    }

    public void setBarcycleTime(int i) {
        this.barcycleTime = i;
    }

    public void setLatidute(String str) {
        this.latidute = str;
    }

    public void setLocationName(String str) {
        this.locationName = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMsgFlag(int i) {
        this.msgFlag = i;
    }

    public void setRadius(String str) {
        this.radius = str;
    }

    public void setReceipt(int i) {
        this.receipt = i;
    }

    public void setReceiverUri(String str) {
        this.receiverUri = str;
    }
}
