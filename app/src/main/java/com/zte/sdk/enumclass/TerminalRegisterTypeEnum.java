package com.zte.sdk.enumclass;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum TerminalRegisterTypeEnum {
    TYPE_APP(0, "outbound"),
    TYPE_NATIVE(1, "common"),
    TYPE_UNKNOWN(99, "UNKNOWN");

    private int code;
    private String value;

    TerminalRegisterTypeEnum(int i, String str) {
        this.value = "";
        this.code = 0;
        this.code = i;
        this.value = str;
    }

    public static TerminalRegisterTypeEnum init(int i) {
        return i == TYPE_APP.getCode() ? TYPE_APP : i == TYPE_NATIVE.getCode() ? TYPE_NATIVE : TYPE_UNKNOWN;
    }

    public static List<TerminalRegisterTypeEnum> toList() {
        TerminalRegisterTypeEnum[] values = values();
        ArrayList arrayList = new ArrayList();
        for (TerminalRegisterTypeEnum terminalRegisterTypeEnum : values) {
            arrayList.add(terminalRegisterTypeEnum);
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
