package io.reactivex.internal.util;

import java.util.List;

/* loaded from: classes2.dex */
public enum ListAddBiConsumer implements io.reactivex.k.c<List, Object, List> {
    INSTANCE;

    public static <T> io.reactivex.k.c<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.k.c
    public List apply(List list, Object obj) throws Exception {
        list.add(obj);
        return list;
    }
}
