package com.video.androidsdk.mes.bean.struct;

import com.video.androidsdk.log.LogEx;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class MsgPushSliceReq {
    public static final short MsgCode = 103;
    int CurrentIdx;
    String MsgContent;
    int MsgID;
    short MsgLen;
    int MsgSize;
    int SliceNum;
    String TransactionID;

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

    public static MsgPushSliceReq parsePackage(ByteBuffer byteBuffer) {
        if (byteBuffer != null && byteBuffer.array().length >= 2) {
            MsgPushSliceReq msgPushSliceReq = new MsgPushSliceReq();
            try {
                msgPushSliceReq.MsgLen = byteBuffer.getShort();
                msgPushSliceReq.TransactionID = getShorterString(byteBuffer, getTransactionIDLen());
                msgPushSliceReq.MsgID = byteBuffer.getInt();
                msgPushSliceReq.MsgSize = byteBuffer.getShort() & 65535;
                msgPushSliceReq.SliceNum = byteBuffer.getShort() & 65535;
                msgPushSliceReq.CurrentIdx = byteBuffer.getShort() & 65535;
                msgPushSliceReq.MsgContent = getShorterString(byteBuffer, msgPushSliceReq.MsgSize);
                return msgPushSliceReq;
            } catch (BufferUnderflowException e) {
                e.printStackTrace();
                return null;
            }
        }
        LogEx.w("MsgPushSliceReq", "buf" + byteBuffer);
        return null;
    }

    public int getCurrentIdx() {
        return this.CurrentIdx;
    }

    public String getMsgContent() {
        return this.MsgContent;
    }

    public int getMsgID() {
        return this.MsgID;
    }

    public short getMsgLen() {
        return this.MsgLen;
    }

    public int getSliceNum() {
        return this.SliceNum;
    }

    public String getTransactionID() {
        return this.TransactionID;
    }
}
