package com.video.androidsdk.mes.bean.struct;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class RegisterOnlineReq {
    long DKey;
    String DeviceID;
    short MsgCode = 83;
    short MsgLen;
    int TerminalFlag;
    String Timestamp;
    String TransactionID;
    String UserID;
    String UserToken;

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

    public long getDKey() {
        return this.DKey;
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

    public String getUserToken() {
        return this.UserToken;
    }

    public int getUserTokenLen() {
        return 32;
    }

    public void setDKey(long j) {
        this.DKey = j;
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

    public void setUserToken(String str) {
        this.UserToken = str;
    }

    public byte[] toStruct() {
        int transactionIDLen = getTransactionIDLen() + getDeviceIDLen() + getUserIDLen() + getUserTokenLen() + getTimestampLen() + 16;
        ByteBuffer allocate = ByteBuffer.allocate(transactionIDLen);
        this.MsgLen = Integer.valueOf(transactionIDLen).shortValue();
        allocate.putShort(this.MsgCode);
        allocate.putShort(this.MsgLen);
        allocate.put(getFilledValue(this.TransactionID, getTransactionIDLen()));
        allocate.put(getFilledValue(this.DeviceID, getDeviceIDLen()));
        allocate.put(getFilledValue(this.UserID, getUserIDLen()));
        allocate.putInt(this.TerminalFlag);
        allocate.put(getFilledValue(this.UserToken, getUserTokenLen()));
        allocate.putLong(this.DKey);
        allocate.put(getFilledValue(this.Timestamp, getTimestampLen()));
        return (byte[]) allocate.array().clone();
    }
}
