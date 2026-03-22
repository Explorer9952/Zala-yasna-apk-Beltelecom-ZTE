package com.video.androidsdk.service.bean;

/* loaded from: classes.dex */
public class DelFavoritesReq {
    public String columncodes;
    public String contentcodes;
    public String dirid = "0";
    public String favoritetypes;

    public DelFavoritesReq(String str, String str2, String str3) {
        this.contentcodes = str;
        this.columncodes = str2;
        this.favoritetypes = str3;
    }

    public String getColumncodes() {
        return this.columncodes;
    }

    public String getContentcodes() {
        return this.contentcodes;
    }

    public String getDirid() {
        return this.dirid;
    }

    public String getFavoritetypes() {
        return this.favoritetypes;
    }

    public void setColumncodes(String str) {
        this.columncodes = str;
    }

    public void setContentcodes(String str) {
        this.contentcodes = str;
    }

    public void setDirid(String str) {
        this.dirid = str;
    }

    public void setFavoritetypes(String str) {
        this.favoritetypes = str;
    }
}
