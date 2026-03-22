package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum LiveStatusEnum {
    INVITED(1, "INVITED"),
    INITIATED(2, "INITIATED"),
    STARTED(3, "STARTED"),
    TERMINATED(4, "TERMINATED"),
    CLOSED_BY_USER(5, "CLOSED_BY_USER"),
    ABORTED(6, "ABORTED"),
    FAILED(7, "FAILED"),
    OK(0, "OK");

    private int code;
    private String value;

    LiveStatusEnum(int i, String str) {
        this.value = "";
        this.code = 0;
        this.code = i;
        this.value = str;
    }

    public static LiveStatusEnum init(int i) {
        return i == INVITED.getCode() ? INVITED : i == INITIATED.getCode() ? INITIATED : i == STARTED.getCode() ? STARTED : i == TERMINATED.getCode() ? TERMINATED : i == CLOSED_BY_USER.getCode() ? CLOSED_BY_USER : i == ABORTED.getCode() ? ABORTED : i == FAILED.getCode() ? FAILED : OK;
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
