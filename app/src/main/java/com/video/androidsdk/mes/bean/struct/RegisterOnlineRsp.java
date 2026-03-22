package com.video.androidsdk.mes.bean.struct;

import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class RegisterOnlineRsp {
    public static final short MsgCode = 84;
    String Description;
    short HeatTimer;
    short MsgLen;
    String Result;
    short TimeOutTimer;
    String TransactionID;

    public static int getDescriptionLen() {
        return 256;
    }

    public static int getMaxPackageLen() {
        return getTransactionIDLen() + 8 + getResultLen() + getDescriptionLen();
    }

    public static int getResultLen() {
        return 8;
    }

    private static String getShorterString(ByteBuffer byteBuffer, int i) {
        int min;
        if (byteBuffer == null || (min = Math.min(byteBuffer.array().length, i)) <= 0) {
            return null;
        }
        byte[] bArr = new byte[min];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "UTF-8").trim();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getTransactionIDLen() {
        return 40;
    }

    public static RegisterOnlineRsp parsePackage(ByteBuffer byteBuffer) {
        if (byteBuffer != null && byteBuffer.array().length >= 2) {
            RegisterOnlineRsp registerOnlineRsp = new RegisterOnlineRsp();
            try {
                registerOnlineRsp.MsgLen = byteBuffer.getShort();
                registerOnlineRsp.TransactionID = getShorterString(byteBuffer, getTransactionIDLen());
                registerOnlineRsp.Result = getShorterString(byteBuffer, getResultLen());
                registerOnlineRsp.HeatTimer = byteBuffer.getShort();
                registerOnlineRsp.TimeOutTimer = byteBuffer.getShort();
                registerOnlineRsp.Description = getShorterString(byteBuffer, getMaxPackageLen() - registerOnlineRsp.MsgLen);
                return registerOnlineRsp;
            } catch (BufferUnderflowException unused) {
            }
        }
        return null;
    }

    public String getDescription() {
        return this.Description;
    }

    public short getHeatTimer() {
        return this.HeatTimer;
    }

    public short getMsgLen() {
        return this.MsgLen;
    }

    public String getResult() {
        return this.Result;
    }

    public short getTimeOutTimer() {
        return this.TimeOutTimer;
    }

    public String getTransactionID() {
        return this.TransactionID;
    }
}
