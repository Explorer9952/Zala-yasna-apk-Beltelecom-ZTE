package com.video.androidsdk.player.common;

/* loaded from: classes.dex */
public enum AssetStatus {
    Asset_Playing(1),
    Asset_Selected(2);


    /* renamed from: a, reason: collision with root package name */
    private final int f3338a;

    AssetStatus(int i) {
        this.f3338a = i;
    }

    public int getValue() {
        return this.f3338a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.f3338a);
    }

    public static AssetStatus valueOf(int i) {
        AssetStatus[] values = values();
        for (int i2 = 0; i2 < values.length; i2++) {
            if (values[i2].getValue() == i) {
                return values[i2];
            }
        }
        return null;
    }
}
