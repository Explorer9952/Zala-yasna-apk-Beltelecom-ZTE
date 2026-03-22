package com.video.androidsdk.player.common;

/* loaded from: classes.dex */
public enum DecoderType {
    Decoder_SW(1),
    Decoder_HW(2),
    Decoder_HW_SW(3);


    /* renamed from: a, reason: collision with root package name */
    private final int f3342a;

    DecoderType(int i) {
        this.f3342a = i;
    }

    public int getValue() {
        return this.f3342a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.f3342a);
    }

    public static DecoderType valueOf(int i) {
        DecoderType[] values = values();
        for (int i2 = 0; i2 < values.length; i2++) {
            if (values[i2].getValue() == i) {
                return values[i2];
            }
        }
        return null;
    }
}
