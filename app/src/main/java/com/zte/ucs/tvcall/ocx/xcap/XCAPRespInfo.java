package com.zte.ucs.tvcall.ocx.xcap;

/* loaded from: classes2.dex */
public class XCAPRespInfo {
    private String body;
    private int content_Length;
    private String content_Type;
    private String etag;
    private String location;
    private int returncode;

    public String getBody() {
        return this.body;
    }

    public int getContent_Length() {
        return this.content_Length;
    }

    public String getContent_Type() {
        return this.content_Type;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getLocation() {
        return this.location;
    }

    public int getReturncode() {
        return this.returncode;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setContent_Length(int i) {
        this.content_Length = i;
    }

    public void setContent_Type(String str) {
        this.content_Type = str;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setReturncode(int i) {
        this.returncode = i;
    }
}
