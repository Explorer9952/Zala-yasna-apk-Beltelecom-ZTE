package com.video.androidsdk.mes;

import com.video.androidsdk.common.xml.DomParser;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.mes.bean.MsgPushReq;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public class MsgPushParser {
    private static final String LOG_TAG = "MsgPushParser";

    public static MsgPushReq parse(String str) {
        if (str == null) {
            LogEx.w(LOG_TAG, "content is null.Parse abnormal!");
            return null;
        }
        if (str.trim().length() == 0) {
            LogEx.w(LOG_TAG, "content is empty.Parse abnormal!");
            return null;
        }
        return parse(new ByteArrayInputStream(str.getBytes()));
    }

    public static MsgPushReq parse(InputStream inputStream) {
        Object parse2Bean = DomParser.parse2Bean(inputStream, MsgPushReq.class);
        if (parse2Bean instanceof MsgPushReq) {
            return (MsgPushReq) parse2Bean;
        }
        return null;
    }
}
