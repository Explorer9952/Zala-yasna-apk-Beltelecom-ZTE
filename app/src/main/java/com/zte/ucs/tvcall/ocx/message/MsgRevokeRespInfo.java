package com.zte.ucs.tvcall.ocx.message;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class MsgRevokeRespInfo {
    private int messageType;
    private ResultInfo resultInfo;
    private String messageId = "";
    private String sessionId = "";

    public String getMessageId() {
        return this.messageId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }
}
