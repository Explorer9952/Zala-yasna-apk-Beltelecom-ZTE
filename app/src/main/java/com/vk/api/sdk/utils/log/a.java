package com.vk.api.sdk.utils.log;

import com.vk.api.sdk.utils.log.Logger;

/* loaded from: classes.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f4027a;

    static {
        int[] iArr = new int[Logger.LogLevel.values().length];
        f4027a = iArr;
        iArr[Logger.LogLevel.NONE.ordinal()] = 1;
        f4027a[Logger.LogLevel.VERBOSE.ordinal()] = 2;
        f4027a[Logger.LogLevel.DEBUG.ordinal()] = 3;
        f4027a[Logger.LogLevel.WARNING.ordinal()] = 4;
        f4027a[Logger.LogLevel.ERROR.ordinal()] = 5;
    }
}
