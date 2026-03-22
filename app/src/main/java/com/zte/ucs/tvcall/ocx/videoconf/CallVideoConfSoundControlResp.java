package com.zte.ucs.tvcall.ocx.videoconf;

/* loaded from: classes2.dex */
public class CallVideoConfSoundControlResp {
    private String confUri;
    private String participantUri;
    private int result;
    private String sessionId;

    public String getConfUri() {
        return this.confUri;
    }

    public String getParticipantUri() {
        return this.participantUri;
    }

    public int getResult() {
        return this.result;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setConfUri(String str) {
        this.confUri = str;
    }

    public void setParticipantUri(String str) {
        this.participantUri = str;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }
}
