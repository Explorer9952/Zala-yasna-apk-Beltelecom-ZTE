package kotlin.collections;

import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Collections.kt */
/* loaded from: classes2.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1<T> extends Lambda implements kotlin.jvm.b.l<T, Integer> {
    final /* synthetic */ Comparable $key;
    final /* synthetic */ kotlin.jvm.b.l $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(kotlin.jvm.b.l lVar, Comparable comparable) {
        super(1);
        this.$selector = lVar;
        this.$key = comparable;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(T t) {
        int a2;
        a2 = kotlin.m.b.a((Comparable) this.$selector.invoke(t), this.$key);
        return a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return Integer.valueOf(invoke2((CollectionsKt__CollectionsKt$binarySearchBy$1<T>) obj));
    }
}
