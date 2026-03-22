package com.video.androidsdk.mes.bean.struct;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class MsgPushSliceRsp {
    public static final short MsgCode = 104;
    String Description;
    short MsgLen;
    String Result;
    String TransactionID;

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

    public static int getTransactionIDLen() {
        return 40;
    }

    public int getDescriptionLen() {
        return 256;
    }

    public short getMsgLen() {
        return this.MsgLen;
    }

    public int getResultLen() {
        return 8;
    }

    public String getTransactionID() {
        return this.TransactionID;
    }

    public void setDescription(String str) {
        this.Description = str;
    }

    public void setResult(String str) {
        this.Result = str;
    }

    public void setTransactionID(String str) {
        this.TransactionID = str;
    }

    public byte[] toStruct() {
        int transactionIDLen = getTransactionIDLen() + getResultLen() + getDescriptionLen() + 4;
        ByteBuffer allocate = ByteBuffer.allocate(transactionIDLen);
        this.MsgLen = Integer.valueOf(transactionIDLen).shortValue();
        try {
            allocate.putShort(MsgCode);
            allocate.putShort(this.MsgLen);
            allocate.put(getFilledValue(this.TransactionID, getTransactionIDLen()));
            allocate.put(getFilledValue(this.Result, getResultLen()));
            allocate.put(getFilledValue(this.Description, getDescriptionLen()));
            return (byte[]) allocate.array().clone();
        } catch (BufferOverflowException e) {
            e.printStackTrace();
            return null;
        }
    }
}
