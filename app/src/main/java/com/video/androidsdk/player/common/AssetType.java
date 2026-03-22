package com.video.androidsdk.player.common;

/* loaded from: classes.dex */
public enum AssetType {
    Asset_Video(1),
    Asset_Audio(2),
    Asset_Subtitle(3);


    /* renamed from: a, reason: collision with root package name */
    private final int f3340a;

    AssetType(int i) {
        this.f3340a = i;
    }

    public int getValue() {
        return this.f3340a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.f3340a);
    }

    public static AssetType valueOf(int i) {
        AssetType[] values = values();
        for (int i2 = 0; i2 < values.length; i2++) {
            if (values[i2].getValue() == i) {
                return values[i2];
            }
        }
        return null;
    }
}
