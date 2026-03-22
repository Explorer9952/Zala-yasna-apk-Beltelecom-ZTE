package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum NSEnum {
    NO_RECEIPT(1, "NO_RECEIPT"),
    RECEIVE_RECEIPT(2, "RECEIVE_RECEIPT"),
    READ_RECEIPT(3, "READ_RECEIPT"),
    RECEIVE_READ_RECEIPT(4, "RECEIVE_READ_RECEIPT");

    private int code;
    private String value;

    NSEnum(int i, String str) {
        this.value = "";
        this.code = 1;
        this.code = i;
        this.value = str;
    }

    public static NSEnum init(int i) {
        return i == NO_RECEIPT.getCode() ? NO_RECEIPT : i == RECEIVE_RECEIPT.getCode() ? RECEIVE_RECEIPT : i == READ_RECEIPT.getCode() ? READ_RECEIPT : i == RECEIVE_READ_RECEIPT.getCode() ? RECEIVE_READ_RECEIPT : NO_RECEIPT;
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
