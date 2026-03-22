package com.zte.iptvclient.common.video;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum EncryptType {
    TYPE_ENCRYPT_NOPASSWORD(0),
    TYPE_ENCRYPT_SELF_PASSWORD(1),
    TYPE_ENCRYPT_IRDETO_PASSWORD(2);

    private final int m_iValue;

    EncryptType(int i) {
        this.m_iValue = i;
    }

    public static List<EncryptType> toList() {
        EncryptType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (EncryptType encryptType : values) {
            arrayList.add(encryptType);
        }
        return arrayList;
    }

    public int getIntValue() {
        return this.m_iValue;
    }

    public String getStrValue() {
        return String.valueOf(this.m_iValue);
    }
}
