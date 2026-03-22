package com.zte.sdk.enumclass;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum TerminalTypeEnum {
    TYPE_MOBILE_ANDRIOD(1, "ZIMECLIENT-MOBILE-ANDRIOD"),
    TYPE_STB(2, "ZIMECLIENT-STB"),
    TYPE_MOBILE_IOS(3, "ZIMECLIENT-MOBILE-IOS"),
    TYPE_UNKNOWN(99, "UNKNOWN");

    private int code;
    private String value;

    TerminalTypeEnum(int i, String str) {
        this.value = "";
        this.code = 0;
        this.code = i;
        this.value = str;
    }

    public static TerminalTypeEnum init(int i) {
        return i == TYPE_MOBILE_ANDRIOD.getCode() ? TYPE_MOBILE_ANDRIOD : i == TYPE_STB.getCode() ? TYPE_STB : i == TYPE_MOBILE_IOS.getCode() ? TYPE_MOBILE_IOS : TYPE_UNKNOWN;
    }

    public static List<TerminalTypeEnum> toList() {
        TerminalTypeEnum[] values = values();
        ArrayList arrayList = new ArrayList();
        for (TerminalTypeEnum terminalTypeEnum : values) {
            arrayList.add(terminalTypeEnum);
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
