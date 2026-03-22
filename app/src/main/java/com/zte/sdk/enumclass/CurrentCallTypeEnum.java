package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum CurrentCallTypeEnum {
    SINGLE_AUDIO(0, "SINGLE_AUDIO"),
    SINGLE_VIDEO(1, "SINGLE_VIDEO"),
    MULTI_AUDIO(2, "MULTI_AUDIO"),
    MULTI_VIDEO(3, "MULTI_VIDEO"),
    UNKNOWN(99, "UNKNOWN");

    private int code;
    private String value;

    CurrentCallTypeEnum(int i, String str) {
        this.value = "";
        this.code = 1;
        this.code = i;
        this.value = str;
    }

    public static CurrentCallTypeEnum init(int i) {
        return i == SINGLE_AUDIO.getCode() ? SINGLE_AUDIO : i == SINGLE_VIDEO.getCode() ? SINGLE_VIDEO : i == MULTI_AUDIO.getCode() ? MULTI_AUDIO : i == MULTI_VIDEO.getCode() ? MULTI_VIDEO : UNKNOWN;
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
