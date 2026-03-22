package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum CommonFlagEnum {
    NO(0, 0),
    YES(1, 1);

    private int code;
    private int value;

    CommonFlagEnum(int i, int i2) {
        this.code = 0;
        this.value = 0;
        this.code = i;
        this.value = i2;
    }

    public static CommonFlagEnum initWithValue(int i) {
        return 1 == i ? YES : NO;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}
