package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum MemberStateEnum {
    ONLINE(1, "connected"),
    OFFLINE(2, "disconnected"),
    ON_HOLD(3, "on-hold"),
    ALERTING(4, "alerting"),
    PENDING(5, "pending"),
    MUTED_FOCUS(6, "muted-via-focus"),
    DIALING_IN(7, "dialing-in"),
    DIALING_OUT(8, "dialing-out"),
    DISCONNECTING(9, "disconnecting"),
    NULL(0, "UNKNOWN");

    private int code;
    private String value;

    MemberStateEnum(int i, String str) {
        this.value = "";
        this.code = 0;
        this.code = i;
        this.value = str;
    }

    public static MemberStateEnum init(int i) {
        return i == ONLINE.getCode() ? ONLINE : i == OFFLINE.getCode() ? OFFLINE : i == ON_HOLD.getCode() ? ON_HOLD : i == ALERTING.getCode() ? ALERTING : i == PENDING.getCode() ? PENDING : i == MUTED_FOCUS.getCode() ? MUTED_FOCUS : i == DIALING_IN.getCode() ? DIALING_IN : i == DIALING_OUT.getCode() ? DIALING_OUT : i == DISCONNECTING.getCode() ? DISCONNECTING : NULL;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
