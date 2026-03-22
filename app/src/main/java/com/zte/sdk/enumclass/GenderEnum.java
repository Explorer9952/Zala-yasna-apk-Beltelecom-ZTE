package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum GenderEnum {
    UNKNOWN(0, 0),
    MALE(1, 1),
    FEMALE(2, 2);

    private int code;
    private int value;

    GenderEnum(int i, int i2) {
        this.code = 0;
        this.value = 0;
        this.code = i;
        this.value = i2;
    }

    public static GenderEnum initWithValue(int i) {
        return 1 == i ? MALE : 2 == i ? FEMALE : UNKNOWN;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}
