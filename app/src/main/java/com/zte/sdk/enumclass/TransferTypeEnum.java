package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum TransferTypeEnum {
    BLIND_TRANSFER(0, "BLIND_TRANSFER"),
    CONSULT_TRANSFER(1, "CONSULT_TRANSFER"),
    UNKNOWN(2, "UNKNOWN");

    private int code;
    private String value;

    TransferTypeEnum(int i, String str) {
        this.value = "";
        this.code = 0;
        this.code = i;
        this.value = str;
    }

    public static TransferTypeEnum init(int i) {
        return i == BLIND_TRANSFER.getCode() ? BLIND_TRANSFER : i == CONSULT_TRANSFER.getCode() ? CONSULT_TRANSFER : UNKNOWN;
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
