package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum ForwardableEnum {
    YES(0, "YES"),
    NO(1, "NO"),
    UNKNOWN(0, "UNKNOWN");

    private int code;
    private String value;

    ForwardableEnum(int i, String str) {
        this.value = "";
        this.code = 0;
        this.code = i;
        this.value = str;
    }

    public static ForwardableEnum init(int i) {
        return i == YES.getCode() ? YES : i == NO.getCode() ? NO : UNKNOWN;
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
