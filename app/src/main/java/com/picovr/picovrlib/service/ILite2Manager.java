package com.picovr.picovrlib.service;

import android.os.IInterface;

/* loaded from: classes.dex */
public interface ILite2Manager extends IInterface {
    public static final String DESCRIPTOR = "com.picovr.picovrlib.service.ILite2Manager";
    public static final String LITE2_MANAGER = "lite2manager";
    public static final int SEND_MESSAGE = 3;
    public static final int SET_SCHED_FIFO = 2;

    int sendMessage(int i);

    int setThreadSchedFifo(int i, int i2);
}
