package com.zte.sdk.enumclass;

import com.facebook.share.internal.ShareConstants;

/* loaded from: classes2.dex */
public enum MessageTypeEnum {
    TEXT(1, "TEXT"),
    VOICE(2, "VOICE"),
    VIDEO(3, ShareConstants.VIDEO_URL),
    IMAGE(4, ShareConstants.IMAGE_URL),
    USERCARD(6, "USERCARD"),
    FILE(7, "FILE"),
    COMMON(0, "COMMON");

    private int code;
    private String value;

    MessageTypeEnum(int i, String str) {
        this.value = "";
        this.code = 0;
        this.code = i;
        this.value = str;
    }

    public static MessageTypeEnum init(int i) {
        return i == TEXT.getCode() ? TEXT : i == VOICE.getCode() ? VOICE : i == VIDEO.getCode() ? VIDEO : i == IMAGE.getCode() ? IMAGE : i == USERCARD.getCode() ? USERCARD : i == FILE.getCode() ? FILE : COMMON;
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
