package com.zte.iptvclient.common.video;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum FavoriteType {
    TYPE_FAVORITE_PROGRAM(1),
    TYPE_FAVORITE_TVOD_RECORD(2),
    TYPE_FAVORITE_NPVR(3),
    TYPE_FAVORITE_SERIES(4),
    TYPE_FAVORITE_CHANNEL(5);

    private final int m_iValue;

    FavoriteType(int i) {
        this.m_iValue = i;
    }

    public static List<FavoriteType> toList() {
        FavoriteType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (FavoriteType favoriteType : values) {
            arrayList.add(favoriteType);
        }
        return arrayList;
    }

    public int getIntValue() {
        return this.m_iValue;
    }
}
