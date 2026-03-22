package com.zte.sdk.enumclass;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.video.androidsdk.login.impl.IIPTVLogin;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum VideoFormateEnum {
    CIF("QVGA", 2, 320, PsExtractor.VIDEO_STREAM_MASK),
    VGA("VGA", 1, 640, 480),
    P720("720P", 0, 1280, 720),
    P1080("1080P", 3, 1920, IIPTVLogin.REQUESTID_80),
    AUTO("AUTO", -1, -1, -1);

    private int code;
    private int height;
    private String value;
    private int width;

    VideoFormateEnum(String str, int i, int i2, int i3) {
        this.value = "AUTO";
        this.code = 0;
        this.width = 0;
        this.height = 0;
        this.value = str;
        this.code = i;
        this.height = i2;
        this.width = i3;
    }

    public static VideoFormateEnum init(int i) {
        return i == CIF.getCode() ? CIF : i == VGA.getCode() ? VGA : i == P720.getCode() ? P720 : i == P1080.getCode() ? P1080 : AUTO;
    }

    public static List<VideoFormateEnum> toList() {
        VideoFormateEnum[] values = values();
        ArrayList arrayList = new ArrayList();
        for (VideoFormateEnum videoFormateEnum : values) {
            arrayList.add(videoFormateEnum);
        }
        return arrayList;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getValue() {
        return this.value;
    }

    public final int getWidth() {
        return this.width;
    }
}
