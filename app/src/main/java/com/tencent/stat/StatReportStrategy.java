package com.tencent.stat;

/* loaded from: classes.dex */
public enum StatReportStrategy {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);


    /* renamed from: a, reason: collision with root package name */
    int f2824a;

    StatReportStrategy(int i) {
        this.f2824a = i;
    }

    public static StatReportStrategy getStatReportStrategy(int i) {
        for (StatReportStrategy statReportStrategy : values()) {
            if (i == statReportStrategy.a()) {
                return statReportStrategy;
            }
        }
        return null;
    }

    public int a() {
        return this.f2824a;
    }
}
