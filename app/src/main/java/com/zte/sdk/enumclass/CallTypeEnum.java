package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum CallTypeEnum {
    PRE_CALL(1, "PRE_CALL"),
    POST_CALL(2, "POST_CALL"),
    WHITEBOARD_SHARE(3, "WHITEBOARD_SHARE"),
    UNKNOWN(0, "UNKNOWN");

    private int code;
    private String value;

    CallTypeEnum(int i, String str) {
        this.value = "";
        this.code = 1;
        this.code = i;
        this.value = str;
    }

    public static CallTypeEnum init(int i) {
        return i == PRE_CALL.getCode() ? PRE_CALL : i == POST_CALL.getCode() ? POST_CALL : i == WHITEBOARD_SHARE.getCode() ? WHITEBOARD_SHARE : UNKNOWN;
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
