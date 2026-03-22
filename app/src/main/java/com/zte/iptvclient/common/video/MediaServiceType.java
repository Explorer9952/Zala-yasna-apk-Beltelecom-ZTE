package com.zte.iptvclient.common.video;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum MediaServiceType {
    TYPE_MEDIASERVICE_RTSP(1),
    TYPE_MEDIASERVICE_HLS(2),
    TYPE_MEDIASERVICE_SILVERLIGHT(4),
    TYPE_MEDIASERVICE_ADOBE(8);

    private final int m_iValue;

    MediaServiceType(int i) {
        this.m_iValue = i;
    }

    public static List<MediaServiceType> toList() {
        MediaServiceType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (MediaServiceType mediaServiceType : values) {
            arrayList.add(mediaServiceType);
        }
        return arrayList;
    }

    public int getIntValue() {
        return this.m_iValue;
    }

    public static MediaServiceType valueOf(int i) {
        MediaServiceType[] values = values();
        int length = values.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (values[i2].m_iValue == i) {
                return values[i2];
            }
        }
        return null;
    }
}
