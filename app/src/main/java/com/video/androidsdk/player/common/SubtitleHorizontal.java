package com.video.androidsdk.player.common;

/* loaded from: classes.dex */
public enum SubtitleHorizontal {
    RIGHT(3),
    CENTER(2),
    LEFT(1),
    HORIZONTAL_DEFAULT(0),
    HORIZONTAL_MAX(-1);


    /* renamed from: a, reason: collision with root package name */
    private final int f3348a;

    SubtitleHorizontal(int i) {
        this.f3348a = i;
    }

    public int getValue() {
        return this.f3348a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.f3348a);
    }

    public static SubtitleHorizontal valueOf(int i) {
        SubtitleHorizontal[] values = values();
        for (int i2 = 0; i2 < values.length; i2++) {
            if (values[i2].getValue() == i) {
                return values[i2];
            }
        }
        return null;
    }
}
