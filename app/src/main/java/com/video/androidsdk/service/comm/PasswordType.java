package com.video.androidsdk.service.comm;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public enum PasswordType {
    TYPE_PASSWORD_LOGIN(0),
    TYPE_PASSWORD_USER_LOCK(1),
    TYPE_PASSWORD_PC(2),
    TYPE_PASSWORD_ORDER(3),
    TYPE_PASSWORD_ADULT(4);

    private final int m_iValue;

    PasswordType(int i) {
        this.m_iValue = i;
    }

    public static List<PasswordType> toList() {
        PasswordType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (PasswordType passwordType : values) {
            arrayList.add(passwordType);
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
