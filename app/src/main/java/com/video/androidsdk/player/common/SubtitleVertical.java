package com.video.androidsdk.player.common;

/* loaded from: classes.dex */
public enum SubtitleVertical {
    BOTTOM(3),
    MIDDLE(2),
    TOP(1),
    VERTICAL_DEFAULT(0),
    VERTICAL_MAX(-1);


    /* renamed from: a, reason: collision with root package name */
    private final int f3350a;

    SubtitleVertical(int i) {
        this.f3350a = i;
    }

    public int getValue() {
        return this.f3350a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.f3350a);
    }

    public static SubtitleVertical valueOf(int i) {
        SubtitleVertical[] values = values();
        for (int i2 = 0; i2 < values.length; i2++) {
            if (values[i2].getValue() == i) {
                return values[i2];
            }
        }
        return null;
    }
}
