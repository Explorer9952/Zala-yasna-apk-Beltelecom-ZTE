package com.zte.iptvclient.common.video;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum ContentType {
    TYPE_CONTENT_NORMAL_VOD(1),
    TYPE_CONTENT_TV(2),
    TYPE_CONTENT_PVR(3),
    TYPE_CONTENT_TVOD(4),
    TYPE_CONTENT_LOOKBACK(5),
    TYPE_CONTENT_STARTOVER(6),
    TYPE_CONTENT_SERIES(10),
    TYPE_CONTENT_SIMPLE_TRAILER(11),
    TYPE_CONTENT_SENIOR_TRAILER(12),
    TYPE_CONTENT_TV_SERIES_HEAD(14),
    TYPE_CONTENT_IPPV(18),
    TYPE_CONTENT_VAS(26),
    TYPE_CONTENT_ALL(100);

    private final int m_iValue;

    ContentType(int i) {
        this.m_iValue = i;
    }

    public static List<ContentType> toList() {
        ContentType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (ContentType contentType : values) {
            arrayList.add(contentType);
        }
        return arrayList;
    }

    public int getIntValue() {
        return this.m_iValue;
    }

    public boolean isContentTypeValid(int i) {
        for (ContentType contentType : values()) {
            if (contentType.getIntValue() == i) {
                return true;
            }
        }
        return false;
    }
}
