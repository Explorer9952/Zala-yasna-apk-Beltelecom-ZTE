package com.zte.sdk.enumclass;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum AudioCodecPriorityEnum {
    AMRWB_SILK_G711(1, "AMR-WB, SILK, G711"),
    SILK_G711_AMRWB(2, "SILK, G711, AMR-WB"),
    G711_AMRWB_SILK(3, "G711, AMR-WB, SILK"),
    AMRWB_G711_SILK(4, "AMR-WB, G711, SILK"),
    SILK_AMRWB_G711(5, "SILK, AMR-WB, G711"),
    G711_SILK_AMRWB(6, "G711, SILK, AMR-WB"),
    UNKNOWN(99, "UNKNOWN");

    private int code;
    private String value;

    AudioCodecPriorityEnum(int i, String str) {
        this.value = "";
        this.code = 0;
        this.code = i;
        this.value = str;
    }

    public static AudioCodecPriorityEnum init(int i) {
        return i == AMRWB_SILK_G711.getCode() ? AMRWB_SILK_G711 : i == SILK_G711_AMRWB.getCode() ? SILK_G711_AMRWB : i == G711_AMRWB_SILK.getCode() ? G711_AMRWB_SILK : i == AMRWB_G711_SILK.getCode() ? AMRWB_G711_SILK : i == SILK_AMRWB_G711.getCode() ? SILK_AMRWB_G711 : i == G711_SILK_AMRWB.getCode() ? G711_SILK_AMRWB : UNKNOWN;
    }

    public static List<AudioCodecPriorityEnum> toList() {
        AudioCodecPriorityEnum[] values = values();
        ArrayList arrayList = new ArrayList();
        for (AudioCodecPriorityEnum audioCodecPriorityEnum : values) {
            arrayList.add(audioCodecPriorityEnum);
        }
        return arrayList;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
