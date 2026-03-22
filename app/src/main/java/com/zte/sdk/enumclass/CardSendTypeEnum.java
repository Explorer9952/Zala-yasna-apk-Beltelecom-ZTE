package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum CardSendTypeEnum {
    SINGLE_CHAT(1, "SINGLE_CHAT"),
    GROUP_CHAT(2, "GROUP_CHAT"),
    NULL(0, "UNKNOWN");

    private int code;
    private String value;

    CardSendTypeEnum(int i, String str) {
        this.value = "";
        this.code = 0;
        this.code = i;
        this.value = str;
    }

    public static CardSendTypeEnum init(int i) {
        return i == SINGLE_CHAT.getCode() ? SINGLE_CHAT : i == GROUP_CHAT.getCode() ? GROUP_CHAT : NULL;
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
