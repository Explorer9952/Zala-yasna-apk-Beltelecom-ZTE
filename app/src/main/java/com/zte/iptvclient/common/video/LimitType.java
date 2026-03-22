package com.zte.iptvclient.common.video;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum LimitType {
    TYPE_LIMIT_PROGRAM(1),
    TYPE_LIMIT_TVOD(2),
    TYPE_LIMIT_NPVR(3),
    TYPE_LIMIT_SERIES(4),
    TYPE_LIMIT_CHANNEL(5),
    TYPE_LIMIT_PREVUE(6);

    private final int m_iValue;

    LimitType(int i) {
        this.m_iValue = i;
    }

    public static List<LimitType> toList() {
        LimitType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (LimitType limitType : values) {
            arrayList.add(limitType);
        }
        return arrayList;
    }

    public int getIntValue() {
        return this.m_iValue;
    }
}
