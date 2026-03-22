package com.zte.iptvclient.common.video;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum VideoType {
    TYPE_VIDEO_TRAILER(20),
    TYPE_VIDEO_POSTIVE(28);

    private final int m_iValue;

    VideoType(int i) {
        this.m_iValue = i;
    }

    public static List<VideoType> toList() {
        VideoType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (VideoType videoType : values) {
            arrayList.add(videoType);
        }
        return arrayList;
    }

    public int getIntValue() {
        return this.m_iValue;
    }

    public String getStrValue() {
        return String.valueOf(this.m_iValue);
    }
}
