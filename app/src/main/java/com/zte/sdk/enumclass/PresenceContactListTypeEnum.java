package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum PresenceContactListTypeEnum {
    PresenceContactRcsList(1, "RcsList"),
    PresenceContactRevokeList(2, "RevokeList"),
    PresenceContactBlockList(3, "BlockList");

    private int code;
    private String value;

    PresenceContactListTypeEnum(int i, String str) {
        this.code = i;
        this.value = str;
    }

    public static PresenceContactListTypeEnum init(int i) {
        if (i == PresenceContactRcsList.getCode()) {
            return PresenceContactRcsList;
        }
        if (i == PresenceContactRevokeList.getCode()) {
            return PresenceContactRevokeList;
        }
        if (i == PresenceContactBlockList.getCode()) {
            return PresenceContactBlockList;
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
