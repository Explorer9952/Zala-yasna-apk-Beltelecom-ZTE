package com.video.androidsdk.log;

/* loaded from: classes.dex */
public class ErrorLogReq extends BaseUploadLogReq {
    private String errorCode = "";
    private String errorDesc = "";

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorDesc(String str) {
        this.errorDesc = str;
    }
}
