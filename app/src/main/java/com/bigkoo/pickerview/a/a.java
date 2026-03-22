package com.bigkoo.pickerview.a;

import android.database.DataSetObserver;

/* compiled from: WheelAdapter.java */
/* loaded from: classes.dex */
public interface a<T> {
    int a();

    T getItem(int i);

    int indexOf(T t);

    void unregisterDataSetObserver(DataSetObserver dataSetObserver);
}
