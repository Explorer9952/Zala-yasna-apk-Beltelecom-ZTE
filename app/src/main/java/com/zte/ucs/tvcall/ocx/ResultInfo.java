package com.zte.ucs.tvcall.ocx;

/* loaded from: classes2.dex */
public class ResultInfo {
    public static final String KEY_errorCode = "KEY_errorCode";
    public static final String KEY_errorReason = "KEY_errorReason";
    public static final String KEY_result = "KEY_result";
    private int errorCode;
    private String errorReason = "";
    private int result;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorReason() {
        return this.errorReason;
    }

    public int getResult() {
        return this.result;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorReason(String str) {
        this.errorReason = str;
    }

    public void setResult(int i) {
        this.result = i;
    }
}
