package com.video.androidsdk.player.agama;

import tv.agama.emp.client.Definitions$Measurement;
import tv.agama.emp.client.Definitions$SessionMetadata;

/* compiled from: AgamaIntegration.java */
/* loaded from: classes.dex */
/* synthetic */ class c {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f3330a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f3331b;

    static {
        int[] iArr = new int[Definitions$SessionMetadata.values().length];
        f3331b = iArr;
        try {
            iArr[Definitions$SessionMetadata.MANIFEST_URI.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f3331b[Definitions$SessionMetadata.NUMBER_OF_CONTENT_PROFILES.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f3331b[Definitions$SessionMetadata.DS_INITIAL_PROFILE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[Definitions$Measurement.values().length];
        f3330a = iArr2;
        try {
            iArr2[Definitions$Measurement.BYTES_RECEIVED.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f3330a[Definitions$Measurement.SEGMENT_READ_BITRATE.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f3330a[Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_1XX.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f3330a[Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_2XX.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f3330a[Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_3XX.ordinal()] = 5;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f3330a[Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_4XX.ordinal()] = 6;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f3330a[Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_5XX.ordinal()] = 7;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f3330a[Definitions$Measurement.NR_OF_FRAMES_DROPPED.ordinal()] = 8;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f3330a[Definitions$Measurement.SEGMENT_PROFILE_BITRATE.ordinal()] = 9;
        } catch (NoSuchFieldError unused12) {
        }
    }
}
