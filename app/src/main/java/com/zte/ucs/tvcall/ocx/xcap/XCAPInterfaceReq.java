package com.zte.ucs.tvcall.ocx.xcap;

/* loaded from: classes2.dex */
public class XCAPInterfaceReq {
    private String sessionID;
    private XCAPReqInfo tXcapReqInfo;

    public String getSessionID() {
        return this.sessionID;
    }

    public XCAPReqInfo gettXcapReqInfo() {
        return this.tXcapReqInfo;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void settXcapReqInfo(XCAPReqInfo xCAPReqInfo) {
        this.tXcapReqInfo = xCAPReqInfo;
    }
}
