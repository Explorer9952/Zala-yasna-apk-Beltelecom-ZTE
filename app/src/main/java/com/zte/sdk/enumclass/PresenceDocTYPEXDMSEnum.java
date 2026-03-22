package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum PresenceDocTYPEXDMSEnum {
    PresenceDocRLSXDMS(1, "PresenceDocRLSXDMS"),
    PresenceDocTypePresenceruleXDMS(2, "PresenceDocTypePresenceruleXDMS"),
    PresenceDocTypepermPresenceXDMS(3, "PresenceDocTypepermPresenceXDMS"),
    PresenceDocTypeSharedXDMS(4, "PresenceDocTypeSharedXDMS"),
    PresenceDocTypeContentXDMS(5, "PresenceDocTypeContentXDMS");

    private int code;
    private String value;

    PresenceDocTYPEXDMSEnum(int i, String str) {
        this.code = i;
        this.value = str;
    }

    public static PresenceDocTYPEXDMSEnum init(int i) {
        if (i == PresenceDocRLSXDMS.getCode()) {
            return PresenceDocRLSXDMS;
        }
        if (i == PresenceDocTypePresenceruleXDMS.getCode()) {
            return PresenceDocTypePresenceruleXDMS;
        }
        if (i == PresenceDocTypepermPresenceXDMS.getCode()) {
            return PresenceDocTypepermPresenceXDMS;
        }
        if (i == PresenceDocTypeSharedXDMS.getCode()) {
            return PresenceDocTypeSharedXDMS;
        }
        if (i == PresenceDocTypeContentXDMS.getCode()) {
            return PresenceDocTypeContentXDMS;
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
