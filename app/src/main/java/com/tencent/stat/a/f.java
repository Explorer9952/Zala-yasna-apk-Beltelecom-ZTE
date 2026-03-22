package com.tencent.stat.a;

import com.google.common.logging.nano.Vr;

/* loaded from: classes.dex */
public enum f {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(1000),
    ADDITION(Vr.VREvent.EventType.CYCLOPS_SHARE),
    MONITOR_STAT(Vr.VREvent.EventType.CYCLOPS_RECEIVE),
    MTA_GAME_USER(Vr.VREvent.EventType.CYCLOPS_DELETE),
    NETWORK_MONITOR(Vr.VREvent.EventType.CYCLOPS_VIEW);

    private int i;

    f(int i) {
        this.i = i;
    }

    public int a() {
        return this.i;
    }
}
