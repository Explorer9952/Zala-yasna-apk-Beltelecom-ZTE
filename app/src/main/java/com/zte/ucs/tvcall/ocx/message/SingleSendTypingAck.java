package com.zte.ucs.tvcall.ocx.message;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class SingleSendTypingAck {
    public String szSessionID;
    public ResultInfo tResultInfo;

    public String getSzSessionID() {
        return this.szSessionID;
    }

    public ResultInfo gettResultInfo() {
        return this.tResultInfo;
    }

    public void setSzSessionID(String str) {
        this.szSessionID = str;
    }

    public void settResultInfo(ResultInfo resultInfo) {
        this.tResultInfo = resultInfo;
    }
}
