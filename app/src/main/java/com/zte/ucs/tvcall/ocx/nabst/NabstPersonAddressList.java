package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstPersonAddressList {
    NabstPersonAddressInfo[] addressArray = new NabstPersonAddressInfo[0];
    private byte addressCount;

    public NabstPersonAddressInfo[] getAddressArray() {
        return this.addressArray;
    }

    public byte getAddressCount() {
        return this.addressCount;
    }

    public void setAddressArray(NabstPersonAddressInfo[] nabstPersonAddressInfoArr) {
        if (nabstPersonAddressInfoArr != null) {
            this.addressArray = (NabstPersonAddressInfo[]) nabstPersonAddressInfoArr.clone();
        }
    }

    public void setAddressCount(byte b2) {
        this.addressCount = b2;
    }
}
