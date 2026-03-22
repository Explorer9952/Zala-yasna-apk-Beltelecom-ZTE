package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum PresenceContactTypeEnum {
    PresenceContactPending(0, "pending"),
    PresenceContactActive(1, "active"),
    PresenceContactTerminated(2, "terminated");

    private int code;
    private String value;

    PresenceContactTypeEnum(int i, String str) {
        this.code = i;
        this.value = str;
    }

    public static PresenceContactTypeEnum init(int i) {
        if (i == PresenceContactPending.getCode()) {
            return PresenceContactPending;
        }
        if (i == PresenceContactActive.getCode()) {
            return PresenceContactActive;
        }
        if (i == PresenceContactTerminated.getCode()) {
            return PresenceContactTerminated;
        }
        return null;
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
