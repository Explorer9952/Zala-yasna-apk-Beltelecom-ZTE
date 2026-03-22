package com.video.androidsdk.service.bean;

/* loaded from: classes.dex */
public class DelBookMarksReq {
    public String bookmarktypes;
    public String columncodes;
    public String contentcodes;

    public DelBookMarksReq(String str, String str2, String str3) {
        this.contentcodes = str;
        this.columncodes = str2;
        this.bookmarktypes = str3;
    }

    public String getBookmarktypes() {
        return this.bookmarktypes;
    }

    public String getColumncodes() {
        return this.columncodes;
    }

    public String getContentcodes() {
        return this.contentcodes;
    }

    public void setBookmarktypes(String str) {
        this.bookmarktypes = str;
    }

    public void setColumncodes(String str) {
        this.columncodes = str;
    }

    public void setContentcodes(String str) {
        this.contentcodes = str;
    }
}
