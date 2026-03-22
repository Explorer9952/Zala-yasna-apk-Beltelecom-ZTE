package com.zte.ucs.tvcall.ocx.xcap;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class XCAPInterfaceResp {
    private String sessionID;
    private ResultInfo tResultInfo;
    private XCAPRespInfo tXcapRespInfo;

    public String getSessionID() {
        return this.sessionID;
    }

    public ResultInfo gettResultInfo() {
        return this.tResultInfo;
    }

    public XCAPRespInfo gettXcapRespInfo() {
        return this.tXcapRespInfo;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void settResultInfo(ResultInfo resultInfo) {
        this.tResultInfo = resultInfo;
    }

    public void settXcapRespInfo(XCAPRespInfo xCAPRespInfo) {
        this.tXcapRespInfo = xCAPRespInfo;
    }
}
