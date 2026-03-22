package com.zte.ucs.tvcall.ocx.videoconf;

/* loaded from: classes2.dex */
public class CallVideoConfSoundControlReq {
    private String confUri;
    private int iSoundControlType;
    private String participantUri;
    private String selfUri;

    public String getConfUri() {
        return this.confUri;
    }

    public String getParticipantUri() {
        return this.participantUri;
    }

    public String getSelfUri() {
        return this.selfUri;
    }

    public int getiSoundControlType() {
        return this.iSoundControlType;
    }

    public void setConfUri(String str) {
        this.confUri = str;
    }

    public void setParticipantUri(String str) {
        this.participantUri = str;
    }

    public void setSelfUri(String str) {
        this.selfUri = str;
    }

    public void setiSoundControlType(int i) {
        this.iSoundControlType = i;
    }
}
