package com.video.androidsdk.mes.bean.struct;

import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class RegisterAccessRsp {
    long DKey;
    String Description;
    short MsgCode = 82;
    short MsgLen;
    short ProxySvrPort;
    String RegSvrID;
    String RegSvrIP;
    short RegSvrPort;
    String Result;
    String TransactionID;

    public static int getDescriptionLen() {
        return 256;
    }

    public static int getMaxPackageLen() {
        return getTransactionIDLen() + 16 + getResultLen() + getRegSvrIDLen() + getRegSvrIPLen() + getDescriptionLen();
    }

    public static int getRegSvrIDLen() {
        return 40;
    }

    public static int getRegSvrIPLen() {
        return 20;
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

    public static RegisterAccessRsp parsePackage(ByteBuffer byteBuffer) {
        if (byteBuffer != null && byteBuffer.array().length >= 2) {
            RegisterAccessRsp registerAccessRsp = new RegisterAccessRsp();
            try {
                if (byteBuffer.getShort() != registerAccessRsp.MsgCode) {
                    return null;
                }
                registerAccessRsp.MsgLen = byteBuffer.getShort();
                registerAccessRsp.TransactionID = getShorterString(byteBuffer, getTransactionIDLen());
                registerAccessRsp.Result = getShorterString(byteBuffer, getResultLen());
                registerAccessRsp.RegSvrID = getShorterString(byteBuffer, getRegSvrIDLen());
                registerAccessRsp.RegSvrIP = getShorterString(byteBuffer, getRegSvrIPLen());
                registerAccessRsp.RegSvrPort = byteBuffer.getShort();
                registerAccessRsp.ProxySvrPort = byteBuffer.getShort();
                registerAccessRsp.DKey = byteBuffer.getLong();
                registerAccessRsp.Description = getShorterString(byteBuffer, getMaxPackageLen() - registerAccessRsp.MsgLen);
                return registerAccessRsp;
            } catch (BufferUnderflowException unused) {
            }
        }
        return null;
    }

    public long getDKey() {
        return this.DKey;
    }

    public String getDescription() {
        return this.Description;
    }

    public short getMsgLen() {
        return this.MsgLen;
    }

    public short getProxySvrPort() {
        return this.ProxySvrPort;
    }

    public String getRegSvrID() {
        return this.RegSvrID;
    }

    public String getRegSvrIP() {
        return this.RegSvrIP;
    }

    public short getRegSvrPort() {
        return this.RegSvrPort;
    }

    public String getResult() {
        return this.Result;
    }

    public String getTransactionID() {
        return this.TransactionID;
    }
}
