package com.nineoldandroids.util;

/* compiled from: FloatProperty.java */
/* loaded from: classes.dex */
public abstract class a<T> extends c<T, Float> {
    public a(String str) {
        super(Float.class, str);
    }

    public abstract void a(T t, float f);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nineoldandroids.util.c
    public /* bridge */ /* synthetic */ void a(Object obj, Float f) {
        a2((a<T>) obj, f);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public final void a2(T t, Float f) {
        a((a<T>) t, f.floatValue());
    }
}
