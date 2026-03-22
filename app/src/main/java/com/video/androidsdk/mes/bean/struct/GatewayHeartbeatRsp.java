package com.video.androidsdk.mes.bean.struct;

import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class GatewayHeartbeatRsp {
    public static final short MsgCode = 86;
    String Description;
    short MsgLen;
    String Result;
    String TransactionID;

    public static int getDescriptionLen() {
        return 256;
    }

    public static int getMaxPackageLen() {
        return getTransactionIDLen() + 4 + getResultLen() + getDescriptionLen();
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

    public static GatewayHeartbeatRsp parsePackage(ByteBuffer byteBuffer) {
        if (byteBuffer != null && byteBuffer.array().length >= 2) {
            GatewayHeartbeatRsp gatewayHeartbeatRsp = new GatewayHeartbeatRsp();
            try {
                gatewayHeartbeatRsp.MsgLen = byteBuffer.getShort();
                gatewayHeartbeatRsp.TransactionID = getShorterString(byteBuffer, getTransactionIDLen());
                gatewayHeartbeatRsp.Result = getShorterString(byteBuffer, getResultLen());
                gatewayHeartbeatRsp.Description = getShorterString(byteBuffer, getMaxPackageLen() - gatewayHeartbeatRsp.MsgLen);
                return gatewayHeartbeatRsp;
            } catch (BufferUnderflowException unused) {
            }
        }
        return null;
    }

    public String getDescription() {
        return this.Description;
    }

    public short getMsgLen() {
        return this.MsgLen;
    }

    public String getResult() {
        return this.Result;
    }

    public String getTransactionID() {
        return this.TransactionID;
    }
}
