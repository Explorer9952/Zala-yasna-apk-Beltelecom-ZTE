package com.zte.ucs.tvcall.ocx.publicaccount;

/* loaded from: classes2.dex */
public class PaMsgContent {
    private int activestatus;
    private PaMsgMediaArticle[] artical;
    private int articanum;
    private PaMsgMediaBasic audio;
    private String createtime;
    private int forwardable;
    private int mediatype;
    private String msguuid;
    private String pauuid;
    private PaMsgMediaBasic pic;
    private String smsdigest;
    private String text;
    private PaMsgMediaBasic vcard;
    private PaMsgMediaBasic video;

    public int getActivestatus() {
        return this.activestatus;
    }

    public PaMsgMediaArticle[] getArtical() {
        return this.artical;
    }

    public int getArticanum() {
        return this.articanum;
    }

    public PaMsgMediaBasic getAudio() {
        return this.audio;
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

    public String getMsguuid() {
        return this.msguuid;
    }

    public String getPauuid() {
        return this.pauuid;
    }

    public PaMsgMediaBasic getPic() {
        return this.pic;
    }

    public String getSmsdigest() {
        return this.smsdigest;
    }

    public String getText() {
        return this.text;
    }

    public PaMsgMediaBasic getVcard() {
        return this.vcard;
    }

    public PaMsgMediaBasic getVideo() {
        return this.video;
    }

    public void setActivestatus(int i) {
        this.activestatus = i;
    }

    public void setArtical(PaMsgMediaArticle[] paMsgMediaArticleArr) {
        if (paMsgMediaArticleArr != null) {
            this.artical = (PaMsgMediaArticle[]) paMsgMediaArticleArr.clone();
        }
    }

    public void setArticanum(int i) {
        this.articanum = i;
    }

    public void setAudio(PaMsgMediaBasic paMsgMediaBasic) {
        this.audio = paMsgMediaBasic;
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

    public void setMsguuid(String str) {
        this.msguuid = str;
    }

    public void setPauuid(String str) {
        this.pauuid = str;
    }

    public void setPic(PaMsgMediaBasic paMsgMediaBasic) {
        this.pic = paMsgMediaBasic;
    }

    public void setSmsdigest(String str) {
        this.smsdigest = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setVcard(PaMsgMediaBasic paMsgMediaBasic) {
        this.vcard = paMsgMediaBasic;
    }

    public void setVideo(PaMsgMediaBasic paMsgMediaBasic) {
        this.video = paMsgMediaBasic;
    }
}
