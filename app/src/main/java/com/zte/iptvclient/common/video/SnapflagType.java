package com.zte.iptvclient.common.video;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum SnapflagType {
    TYPE_SNAPFLAGTYPE_SIMPLETRAILER(0),
    TYPE_SNAPFLAGTYPE_HIGHETRAILER(1);

    private final int m_iValue;

    SnapflagType(int i) {
        this.m_iValue = i;
    }

    public static List<SnapflagType> toList() {
        SnapflagType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (SnapflagType snapflagType : values) {
            arrayList.add(snapflagType);
        }
        return arrayList;
    }

    public int getIntValue() {
        return this.m_iValue;
    }
}
