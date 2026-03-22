package com.video.androidsdk.player.common;

/* loaded from: classes.dex */
public enum ZoomModeType {
    ZOOM_FITWINDOW(3),
    ZOOM_LETTERBOX(1),
    ZOOM_MAX(-1),
    ZOOM_ORIGINAL(4),
    ZOOM_PANSCAN(2),
    ZOOM_ZOOMIN(5),
    ZOOM_PILLARBOX(6),
    ZOOM_MODE_FIT(7),
    ZOOM_MODE_FIXED_WIDTH(8),
    ZOOM_MODE_FIXED_HEIGHT(9),
    ZOOM_MODE_FILL(10),
    ZOOM_MODE_ZOOM(11);


    /* renamed from: a, reason: collision with root package name */
    private int f3359a;

    ZoomModeType(int i) {
        this.f3359a = i;
    }

    public int getValue() {
        return this.f3359a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.f3359a);
    }

    public static ZoomModeType valueOf(int i) {
        ZoomModeType[] values = values();
        for (int i2 = 0; i2 < values.length; i2++) {
            if (values[i2].getValue() == i) {
                return values[i2];
            }
        }
        return null;
    }
}
