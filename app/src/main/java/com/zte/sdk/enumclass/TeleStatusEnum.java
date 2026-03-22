package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum TeleStatusEnum {
    OK(0, "OK"),
    INTERNAL_ERROR(1, "INTERNAL_ERROR"),
    ACCOUNT_NOTMATCH(2, "ACCOUNT_NOTMATCH"),
    FAILED(3, "FAILED"),
    TIMEOUT(4, "TIMEOUT"),
    SERVER_PADDING(491, "SERVER_PADDING"),
    UNKOWN(99, "UNKOWN");

    private int code;
    private String value;

    TeleStatusEnum(int i, String str) {
        this.value = "";
        this.code = 0;
        this.code = i;
        this.value = str;
    }

    public static TeleStatusEnum init(int i) {
        return i == OK.getCode() ? OK : i == INTERNAL_ERROR.getCode() ? INTERNAL_ERROR : i == ACCOUNT_NOTMATCH.getCode() ? ACCOUNT_NOTMATCH : i == FAILED.getCode() ? FAILED : i == TIMEOUT.getCode() ? TIMEOUT : i == SERVER_PADDING.getCode() ? SERVER_PADDING : OK;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
