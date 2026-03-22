package com.zte.ucs.tvcall.ocx.card;

/* loaded from: classes2.dex */
public class CardMsgInfo {
    private int activestatus;
    private int articanum;
    private CardMediaArticle[] article;
    private int barcycleTime;
    private int forwardable;
    private int mediatype;
    private int msgFlag;
    private CardMediaBasic pav;
    private int rptType;
    private int sendType;
    private int sendUiResp;
    private String receiverUri = "";
    private String chatid = "";
    private String sendUrl = "";
    private String msgid = "";
    private String createtime = "";
    private String msguuid = "";
    private String smsdigest = "";
    private String text = "";
    private String pauuid = "";

    public int getActivestatus() {
        return this.activestatus;
    }

    public int getArticanum() {
        return this.articanum;
    }

    public CardMediaArticle[] getArticle() {
        return this.article;
    }

    public int getBarcycleTime() {
        return this.barcycleTime;
    }

    public String getChatid() {
        return this.chatid;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public int getForwardable() {
        return this.forwardable;
    }

    public int getMediatype() {
        return this.mediatype;
    }

    public int getMsgFlag() {
        return this.msgFlag;
    }

    public String getMsgid() {
        return this.msgid;
    }

    public String getMsguuid() {
        return this.msguuid;
    }

    public String getPauuid() {
        return this.pauuid;
    }

    public CardMediaBasic getPav() {
        return this.pav;
    }

    public String getReceiverUri() {
        return this.receiverUri;
    }

    public int getRptType() {
        return this.rptType;
    }

    public int getSendType() {
        return this.sendType;
    }

    public int getSendUiResp() {
        return this.sendUiResp;
    }

    public String getSendUrl() {
        return this.sendUrl;
    }

    public String getSmsdigest() {
        return this.smsdigest;
    }

    public String getText() {
        return this.text;
    }

    public void setActivestatus(int i) {
        this.activestatus = i;
    }

    public void setArticanum(int i) {
        this.articanum = i;
    }

    public void setArticle(CardMediaArticle[] cardMediaArticleArr) {
        if (cardMediaArticleArr != null) {
            this.article = (CardMediaArticle[]) cardMediaArticleArr.clone();
        }
    }

    public void setBarcycleTime(int i) {
        this.barcycleTime = i;
    }

    public void setChatid(String str) {
        this.chatid = str;
    }

    public void setCreatetime(String str) {
        this.createtime = str;
    }

    public void setForwardable(int i) {
        this.forwardable = i;
    }

    public void setMediatype(int i) {
        this.mediatype = i;
    }

    public void setMsgFlag(int i) {
        this.msgFlag = i;
    }

    public void setMsgid(String str) {
        this.msgid = str;
    }

    public void setMsguuid(String str) {
        this.msguuid = str;
    }

    public void setPauuid(String str) {
        this.pauuid = str;
    }

    public void setPav(CardMediaBasic cardMediaBasic) {
        this.pav = cardMediaBasic;
    }

    public void setReceiverUri(String str) {
        this.receiverUri = str;
    }

    public void setRptType(int i) {
        this.rptType = i;
    }

    public void setSendType(int i) {
        this.sendType = i;
    }

    public void setSendUiResp(int i) {
        this.sendUiResp = i;
    }

    public void setSendUrl(String str) {
        this.sendUrl = str;
    }

    public void setSmsdigest(String str) {
        this.smsdigest = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
