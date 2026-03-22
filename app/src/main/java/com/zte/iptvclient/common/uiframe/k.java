package com.zte.iptvclient.common.uiframe;

import com.video.androidsdk.common.ErrCode;

/* compiled from: UIErrCode.java */
/* loaded from: classes2.dex */
public class k extends ErrCode {

    /* renamed from: a, reason: collision with root package name */
    public static int f7919a = 1800000000;

    public static int getErrCode(int i, int i2) {
        return f7919a + (i * 1000) + i2;
    }
}
