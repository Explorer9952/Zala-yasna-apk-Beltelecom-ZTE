package com.zte.iptvclient.android.mobile.search.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum ChannelType {
    TYPE_CHANNEL_LIVETV(1),
    TYPE_CHANNEL_CAROUSEL(2),
    TYPE_CHANNEL_MASIC(1),
    TYPE_CHANNEL_PIP(2),
    TYPE_CHANNEL_LOCALWEB(1),
    TYPE_CHANNEL_WHOLEWEB(2);

    private final int mValue;

    ChannelType(int i) {
        this.mValue = i;
    }

    public static List<SortType> toList() {
        SortType[] values = SortType.values();
        ArrayList arrayList = new ArrayList();
        for (SortType sortType : values) {
            arrayList.add(sortType);
        }
        return arrayList;
    }

    public int getIntValue() {
        return this.mValue;
    }

    public static ChannelType valueOf(int i) {
        ChannelType[] values = values();
        int length = values.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (values[i2].mValue == i) {
                return values[i2];
            }
        }
        return null;
    }
}
