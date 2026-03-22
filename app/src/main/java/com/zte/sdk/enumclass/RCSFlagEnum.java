package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum RCSFlagEnum {
    NO(0, 0),
    YES(1, 1),
    YES_REFUSE(2, 2);

    private int code;
    private int value;

    RCSFlagEnum(int i, int i2) {
        this.code = 0;
        this.value = 0;
        this.code = i;
        this.value = i2;
    }

    public static RCSFlagEnum initWithValue(int i) {
        return 1 == i ? YES : 2 == i ? YES_REFUSE : NO;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}
