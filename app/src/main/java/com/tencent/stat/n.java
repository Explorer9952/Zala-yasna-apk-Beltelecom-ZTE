package com.tencent.stat;

/* loaded from: classes.dex */
/* synthetic */ class n {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f2902a;

    static {
        int[] iArr = new int[StatReportStrategy.values().length];
        f2902a = iArr;
        try {
            iArr[StatReportStrategy.INSTANT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2902a[StatReportStrategy.ONLY_WIFI.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f2902a[StatReportStrategy.APP_LAUNCH.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f2902a[StatReportStrategy.DEVELOPER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f2902a[StatReportStrategy.BATCH.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f2902a[StatReportStrategy.PERIOD.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f2902a[StatReportStrategy.ONLY_WIFI_NO_CACHE.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
