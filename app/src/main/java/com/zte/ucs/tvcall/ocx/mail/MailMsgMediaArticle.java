package com.zte.ucs.tvcall.ocx.mail;

/* loaded from: classes2.dex */
public class MailMsgMediaArticle {
    private int attachedCount;
    private int forwardable;
    private MailAttachmentInfo[] mailAttachmentInfo;
    private int mailCount;
    private int needRpt;
    private String from = "";
    private String msgid = "";
    private String sendTime = "";
    private String version = "";
    private String fromAddress = "";
    private String fromNumber = "";
    private String toAddress = "";
    private String title = "";
    private String summary = "";
    private String mid = "";
    private String time = "";
    private String mailURL = "";

    public int getAttachedCount() {
        return this.attachedCount;
    }

    public int getForwardable() {
        return this.forwardable;
    }

    public String getFrom() {
        return this.from;
    }

    public String getFromAddress() {
        return this.fromAddress;
    }

    public String getFromNumber() {
        return this.fromNumber;
    }

    public MailAttachmentInfo[] getMailAttachmentInfo() {
        return this.mailAttachmentInfo;
    }

    public int getMailCount() {
        return this.mailCount;
    }

    public String getMailURL() {
        return this.mailURL;
    }

    public String getMid() {
        return this.mid;
    }

    public String getMsgid() {
        return this.msgid;
    }

    public int getNeedRpt() {
        return this.needRpt;
    }

    public String getSendTime() {
        return this.sendTime;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getTime() {
        return this.time;
    }

    public String getTitle() {
        return this.title;
    }

    public String getToAddress() {
        return this.toAddress;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAttachedCount(int i) {
        this.attachedCount = i;
    }

    public void setForwardable(int i) {
        this.forwardable = i;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setFromAddress(String str) {
        this.fromAddress = str;
    }

    public void setFromNumber(String str) {
        this.fromNumber = str;
    }

    public void setMailAttachmentInfo(MailAttachmentInfo[] mailAttachmentInfoArr) {
        if (mailAttachmentInfoArr != null) {
            this.mailAttachmentInfo = (MailAttachmentInfo[]) mailAttachmentInfoArr.clone();
        }
    }

    public void setMailCount(int i) {
        this.mailCount = i;
    }

    public void setMailURL(String str) {
        this.mailURL = str;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public void setMsgid(String str) {
        this.msgid = str;
    }

    public void setNeedRpt(int i) {
        this.needRpt = i;
    }

    public void setSendTime(String str) {
        this.sendTime = str;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setToAddress(String str) {
        this.toAddress = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
