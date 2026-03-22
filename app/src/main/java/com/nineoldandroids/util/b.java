package com.nineoldandroids.util;

/* compiled from: IntProperty.java */
/* loaded from: classes.dex */
public abstract class b<T> extends c<T, Integer> {
    public b(String str) {
        super(Integer.class, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nineoldandroids.util.c
    public /* bridge */ /* synthetic */ void a(Object obj, Integer num) {
        a2((b<T>) obj, num);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public final void a2(T t, Integer num) {
        a2((b<T>) t, Integer.valueOf(num.intValue()));
    }
}
