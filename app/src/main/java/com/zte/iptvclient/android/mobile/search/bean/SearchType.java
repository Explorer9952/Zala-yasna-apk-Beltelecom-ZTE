package com.zte.iptvclient.android.mobile.search.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum SearchType {
    TYPE_SEARCHTYPE_CHINESES(0),
    TYPE_SEARCHTYPE_GRADUAL(1),
    TYPE_SEARCHTYPE_ALL_VAGUE(2),
    TYPE_SEARCHTYPE_ACCURATE(3),
    TYPE_SEARCHTYPE_WORDS_CBT(4),
    TYPE_SEARCHTYPE_WORDS_PJ(5);

    private final int mValue;

    SearchType(int i) {
        this.mValue = i;
    }

    public static List<SearchType> toList() {
        SearchType[] values = values();
        ArrayList arrayList = new ArrayList();
        for (SearchType searchType : values) {
            arrayList.add(searchType);
        }
        return arrayList;
    }

    public int getIntValue() {
        return this.mValue;
    }
}
