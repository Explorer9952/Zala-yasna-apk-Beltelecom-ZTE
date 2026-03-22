package com.zte.ucs.tvcall.ocx.precall;

/* loaded from: classes2.dex */
public class PrecallRecvLocInfo {
    private int type;
    private String subject = "";
    private String messageId = "";
    private String contactId = "";
    private int priority = 0;
    private String longitude = "";
    private String latidute = "";
    private String radius = "";
    private String locationName = "";
    private int receipt = 0;

    public String getContactId() {
        return this.contactId;
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

    public int getPriority() {
        return this.priority;
    }

    public String getRadius() {
        return this.radius;
    }

    public int getReceipt() {
        return this.receipt;
    }

    public String getSubject() {
        return this.subject;
    }

    public int getType() {
        return this.type;
    }

    public void setContactId(String str) {
        this.contactId = str;
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

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setRadius(String str) {
        this.radius = str;
    }

    public void setReceipt(int i) {
        this.receipt = i;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
