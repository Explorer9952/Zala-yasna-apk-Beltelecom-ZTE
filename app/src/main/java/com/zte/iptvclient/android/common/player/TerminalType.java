package com.zte.iptvclient.android.common.player;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public enum TerminalType {
    TYPE_TERMINAL_STB(1),
    TYPE_TERMINAL_MOBILE(2),
    TYPE_TERMINAL_PC(4),
    TYPE_TERMINAL_PAD(8);

    private final int miValue;

    TerminalType(int i) {
        this.miValue = i;
    }

    public static List<TerminalType> toList() {
        TerminalType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (TerminalType terminalType : values) {
            arrayList.add(terminalType);
        }
        return arrayList;
    }

    public int getIntValue() {
        return this.miValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.miValue);
    }
}
