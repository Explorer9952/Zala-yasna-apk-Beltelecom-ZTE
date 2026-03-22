package com.zte.ucs.tvcall.ocx.videoconf;

/* loaded from: classes2.dex */
public class VideoConferenceInfo {
    private String from = "";
    private String conferenceAS = "";
    public String uri = "";

    public String getConferenceAS() {
        return this.conferenceAS;
    }

    public String getFrom() {
        return this.from;
    }

    public String getUri() {
        return this.uri;
    }

    public void setConferenceAS(String str) {
        this.conferenceAS = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setUri(String str) {
        this.uri = str;
    }
}
