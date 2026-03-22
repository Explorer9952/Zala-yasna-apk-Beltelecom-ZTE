package com.zte.ucs.tvcall.ocx.publicaccount;

/* loaded from: classes2.dex */
public class FirePaMsgContentRecvInfo {
    private int activeStatus;
    private FirePaMsgMediaArticle[] articalMult;
    private FirePaMsgMediaArticle articalSingle;
    private int articanum;
    private FirePaMsgMediaBasic audio;
    private String createTime;
    private int forwardable;
    private int mediaType;
    private String msgUuid;
    private String msgid;
    private String paUuid;
    private FirePaMsgMediaBasic pic;
    private int rptType;
    private String smsDigest;
    private String text;
    private String userId;
    private FirePaMsgMediaBasic video;

    public int getActiveStatus() {
        return this.activeStatus;
    }

    public FirePaMsgMediaArticle[] getArticalMult() {
        return this.articalMult;
    }

    public FirePaMsgMediaArticle getArticalSingle() {
        return this.articalSingle;
    }

    public int getArticanum() {
        return this.articanum;
    }

    public FirePaMsgMediaBasic getAudio() {
        return this.audio;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public int getForwardable() {
        return this.forwardable;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public String getMsgUuid() {
        return this.msgUuid;
    }

    public String getMsgid() {
        return this.msgid;
    }

    public String getPaUuid() {
        return this.paUuid;
    }

    public FirePaMsgMediaBasic getPic() {
        return this.pic;
    }

    public int getRptType() {
        return this.rptType;
    }

    public String getSmsDigest() {
        return this.smsDigest;
    }

    public String getText() {
        return this.text;
    }

    public String getUserId() {
        return this.userId;
    }

    public FirePaMsgMediaBasic getVideo() {
        return this.video;
    }

    public void setActiveStatus(int i) {
        this.activeStatus = i;
    }

    public void setArticalMult(FirePaMsgMediaArticle[] firePaMsgMediaArticleArr) {
        if (firePaMsgMediaArticleArr != null) {
            this.articalMult = (FirePaMsgMediaArticle[]) firePaMsgMediaArticleArr.clone();
        }
    }

    public void setArticalSingle(FirePaMsgMediaArticle firePaMsgMediaArticle) {
        this.articalSingle = firePaMsgMediaArticle;
    }

    public void setArticanum(int i) {
        this.articanum = i;
    }

    public void setAudio(FirePaMsgMediaBasic firePaMsgMediaBasic) {
        this.audio = firePaMsgMediaBasic;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setForwardable(int i) {
        this.forwardable = i;
    }

    public void setMediaType(int i) {
        this.mediaType = i;
    }

    public void setMsgUuid(String str) {
        this.msgUuid = str;
    }

    public void setMsgid(String str) {
        this.msgid = str;
    }

    public void setPaUuid(String str) {
        this.paUuid = str;
    }

    public void setPic(FirePaMsgMediaBasic firePaMsgMediaBasic) {
        this.pic = firePaMsgMediaBasic;
    }

    public void setRptType(int i) {
        this.rptType = i;
    }

    public void setSmsDigest(String str) {
        this.smsDigest = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setVideo(FirePaMsgMediaBasic firePaMsgMediaBasic) {
        this.video = firePaMsgMediaBasic;
    }
}
