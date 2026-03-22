package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum MsgSpecialEnum {
    COMMON(0, "COMMON"),
    READ_AND_BURN(1, "READ_AND_BURN");

    private int code;
    private String value;

    MsgSpecialEnum(int i, String str) {
        this.value = "";
        this.code = 1;
        this.code = i;
        this.value = str;
    }

    public static MsgSpecialEnum init(int i) {
        return i == READ_AND_BURN.getCode() ? READ_AND_BURN : COMMON;
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
