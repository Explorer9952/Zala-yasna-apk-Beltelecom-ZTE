package com.zte.iptvclient.common.video;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum BookmarkType {
    TYPE_BOOKMARK_PROGRAM(1),
    TYPE_BOOKMARK_TVOD_RECORD(2),
    TYPE_BOOKMARK_NPVR(3),
    TYPE_BOOKMARK_SERIES(4);

    private final int m_iValue;

    BookmarkType(int i) {
        this.m_iValue = i;
    }

    public static List<BookmarkType> toList() {
        BookmarkType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (BookmarkType bookmarkType : values) {
            arrayList.add(bookmarkType);
        }
        return arrayList;
    }

    public int getIntValue() {
        return this.m_iValue;
    }
}
