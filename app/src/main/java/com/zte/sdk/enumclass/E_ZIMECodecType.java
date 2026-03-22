package com.zte.sdk.enumclass;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum E_ZIMECodecType {
    enumZIME_SOFTWARE("SOFTWARE", 0),
    enumZIME_NvidiaHARDWARE("NvidiaHARDWARE", 1),
    enumZIME_MstarHARDWARE("MstarHARDWARE", 2),
    enumZIME_MTKHARDWARE("MTKHARDWARE", 3),
    enumZIME_GOTAEXTERNENCODER("GOTAEXTERNENCODER", 4),
    enumZIME_AMLOGICHARDWARE("AMLOGICHARDWARE", 5),
    enumZIME_MediaCodec("MediaCodec", 6),
    enumZIME_TranscodeToH264("TranscodeToH264", 7);

    private int code;
    private String value;

    E_ZIMECodecType(String str, int i) {
        this.value = "SOFTWARE";
        this.code = 0;
        this.value = str;
        this.code = i;
    }

    public static E_ZIMECodecType init(int i) {
        return i == enumZIME_SOFTWARE.getCode() ? enumZIME_SOFTWARE : i == enumZIME_NvidiaHARDWARE.getCode() ? enumZIME_NvidiaHARDWARE : i == enumZIME_MstarHARDWARE.getCode() ? enumZIME_MstarHARDWARE : i == enumZIME_MTKHARDWARE.getCode() ? enumZIME_MTKHARDWARE : i == enumZIME_GOTAEXTERNENCODER.getCode() ? enumZIME_GOTAEXTERNENCODER : i == enumZIME_AMLOGICHARDWARE.getCode() ? enumZIME_AMLOGICHARDWARE : i == enumZIME_MediaCodec.getCode() ? enumZIME_MediaCodec : i == enumZIME_TranscodeToH264.getCode() ? enumZIME_TranscodeToH264 : enumZIME_SOFTWARE;
    }

    public static List<E_ZIMECodecType> toList() {
        E_ZIMECodecType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (E_ZIMECodecType e_ZIMECodecType : values) {
            arrayList.add(e_ZIMECodecType);
        }
        return arrayList;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getValue() {
        return this.value;
    }
}
