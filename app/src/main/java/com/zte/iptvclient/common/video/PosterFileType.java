package com.zte.iptvclient.common.video;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum PosterFileType {
    TYPE_POSTER_IPTV_ORDINARY(0),
    TYPE_POSTER_IPTV_STAGEPHOTO(1),
    TYPE_POSTER_IPTV_THUMBNAIL(2),
    TYPE_POSTER_MOBILE_ORDINARY(3),
    TYPE_POSTER_MOBILE_STAGEPHOTO(4),
    TYPE_POSTER_MOBILE_THUMBNAIL(5),
    TYPE_POSTER_PC_ORDINARY(6),
    TYPE_POSTER_PC_STAGEPHOTO(7),
    TYPE_POSTER_PC_THUMBNAIL(8),
    TYPE_POSTER_PAD_ORDINARY(9),
    TYPE_POSTER_PAD_STAGEPHOTO(10),
    TYPE_POSTER_PAD_THUMBNAIL(11);

    private final int m_iValue;

    PosterFileType(int i) {
        this.m_iValue = i;
    }

    public static List<PosterFileType> toList() {
        PosterFileType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (PosterFileType posterFileType : values) {
            arrayList.add(posterFileType);
        }
        return arrayList;
    }

    public int getIntValue() {
        return this.m_iValue;
    }

    public boolean isPosterFileTypeValid(int i) {
        for (PosterFileType posterFileType : values()) {
            if (posterFileType.getIntValue() == i) {
                return true;
            }
        }
        return false;
    }
}
