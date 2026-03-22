package com.video.androidsdk.common.util;

import java.util.UUID;

/* loaded from: classes.dex */
public class SessionUtil {
    public static String genSessionID() {
        return UUID.randomUUID().toString();
    }
}
