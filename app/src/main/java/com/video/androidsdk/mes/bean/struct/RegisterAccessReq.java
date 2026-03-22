package com.video.androidsdk.mes.bean.struct;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class RegisterAccessReq {
    String DeviceID;
    short MsgCode = 81;
    short MsgLen;
    int TerminalFlag;
    String Timestamp;
    String TransactionID;
    String UserID;

    private byte[] getFilledValue(String str, int i) {
        if (i < 0 || i == 0) {
            return new byte[0];
        }
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            int length = i - str.length();
            if (length <= 0) {
                sb.append(str.substring(0, i));
                return sb.toString().getBytes();
            }
            sb.append(str);
            i = length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            sb.append((char) 0);
        }
        return sb.toString().getBytes();
    }

    public String getDeviceID() {
        return this.DeviceID;
    }

    public short getDeviceIDLen() {
        return (short) 50;
    }

    public int getTerminalFlag() {
        return this.TerminalFlag;
    }

    public String getTimestamp() {
        return this.Timestamp;
    }

    public short getTimestampLen() {
        return (short) 14;
    }

    public String getTransactionID() {
        return this.TransactionID;
    }

    public short getTransactionIDLen() {
        return (short) 40;
    }

    public String getUserID() {
        return this.UserID;
    }

    public short getUserIDLen() {
        return (short) 40;
    }

    public void setDeviceID(String str) {
        this.DeviceID = str;
    }

    public void setTerminalFlag(int i) {
        this.TerminalFlag = i;
    }

    public void setTimestamp(String str) {
        this.Timestamp = str;
    }

    public void setTransactionID(String str) {
        this.TransactionID = str;
    }

    public void setUserID(String str) {
        this.UserID = str;
    }

    public byte[] toStruct() {
        int transactionIDLen = getTransactionIDLen() + getUserIDLen() + getDeviceIDLen() + getTimestampLen() + 8;
        ByteBuffer allocate = ByteBuffer.allocate(transactionIDLen);
        this.MsgLen = Integer.valueOf(transactionIDLen).shortValue();
        allocate.putShort(this.MsgCode);
        allocate.putShort(this.MsgLen);
        allocate.put(getFilledValue(this.TransactionID, getTransactionIDLen()));
        allocate.put(getFilledValue(this.UserID, getUserIDLen()));
        allocate.putInt(this.TerminalFlag);
        allocate.put(getFilledValue(this.DeviceID, getDeviceIDLen()));
        allocate.put(getFilledValue(this.Timestamp, getTimestampLen()));
        return (byte[]) allocate.array().clone();
    }
}
