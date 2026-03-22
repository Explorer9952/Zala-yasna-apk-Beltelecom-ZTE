package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum VideoConfSoundControlEnum {
    FORBIDDEN("FORBIDDEN", 1),
    ALLOW("ALLOW", 2),
    APPLY_TALK("APPLY_TALK", 3),
    APPLY_REJECTED("APPLY_REJECTED", 4),
    UNKNOWN("UNKNOWN", 0);

    private int code;
    private String value;

    VideoConfSoundControlEnum(String str, int i) {
        this.value = "UNKNOWN";
        this.code = 0;
        this.value = str;
        this.code = i;
    }

    public static VideoConfSoundControlEnum init(int i) {
        return i == FORBIDDEN.getCode() ? FORBIDDEN : i == ALLOW.getCode() ? ALLOW : i == APPLY_TALK.getCode() ? APPLY_TALK : i == APPLY_REJECTED.getCode() ? APPLY_REJECTED : UNKNOWN;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getValue() {
        return this.value;
    }
}
