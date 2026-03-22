package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum PAStatusEnum {
    OPEN(0, "OPEN"),
    PAUSE(1, "PAUSE"),
    CLOSE(1, "CLOSE"),
    UNKNOWN(0, "UNKNOWN");

    private int code;
    private String value;

    PAStatusEnum(int i, String str) {
        this.value = "";
        this.code = 0;
        this.code = i;
        this.value = str;
    }

    public static PAStatusEnum init(int i) {
        return i == OPEN.getCode() ? OPEN : i == PAUSE.getCode() ? PAUSE : i == CLOSE.getCode() ? CLOSE : UNKNOWN;
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
