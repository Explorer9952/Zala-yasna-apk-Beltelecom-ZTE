package com.zte.iptvclient.android.mobile.order.helper;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public enum ActionType {
    TYPE_ACTION_ORDER(1),
    TYPE_ACTION_CANCEL_AUTO_CONTINUE_ORDER(2),
    TYPE_ACTION_AUTO_CONTINUE_ORDER(3),
    TYPE_ACTION_CANCEL_ORDR(4),
    TYPE_ACTION_EFFECTIVE_TIME_ORDER(5),
    TYPE_ACTION_ORDER_EFFECTIVE_NOW(6),
    TYPE_ACTION_SCORE_ORDER(10),
    TYPE_ACTION_TV_ORDER(11);

    private final int m_iValue;

    ActionType(int i) {
        this.m_iValue = i;
    }

    public static List<ActionType> toList() {
        ActionType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (ActionType actionType : values) {
            arrayList.add(actionType);
        }
        return arrayList;
    }

    public int getIntValue() {
        return this.m_iValue;
    }
}
