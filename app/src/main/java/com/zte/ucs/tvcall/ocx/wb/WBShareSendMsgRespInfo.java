package com.zte.ucs.tvcall.ocx.wb;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class WBShareSendMsgRespInfo {
    private String msgid = "";
    private String szSessionID = "";
    private ResultInfo tResultInfo;

    public String getMsgid() {
        return this.msgid;
    }

    public String getSzSessionID() {
        return this.szSessionID;
    }

    public ResultInfo gettResultInfo() {
        return this.tResultInfo;
    }

    public void setMsgid(String str) {
        this.msgid = str;
    }

    public void setSzSessionID(String str) {
        this.szSessionID = str;
    }

    public void settResultInfo(ResultInfo resultInfo) {
        this.tResultInfo = resultInfo;
    }
}
