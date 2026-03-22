package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum PriorityEnum {
    NORMAL(1, "NORMAL"),
    URGENT(2, "URGENT"),
    UNKNOWN(0, "UNKNOWN");

    private int code;
    private String value;

    PriorityEnum(int i, String str) {
        this.value = "";
        this.code = 1;
        this.code = i;
        this.value = str;
    }

    public static PriorityEnum init(int i) {
        return i == NORMAL.getCode() ? NORMAL : i == URGENT.getCode() ? URGENT : UNKNOWN;
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
