package kotlin.coroutines;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes2.dex */
public interface c {

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* compiled from: CoroutineContext.kt */
        /* renamed from: kotlin.coroutines.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static final class C0418a extends Lambda implements p<c, b, c> {

            /* renamed from: a, reason: collision with root package name */
            public static final C0418a f8162a = new C0418a();

            C0418a() {
                super(2);
            }

            @Override // kotlin.jvm.b.p
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final c invoke(@NotNull c cVar, @NotNull b bVar) {
                f.b(cVar, "acc");
                f.b(bVar, "element");
                c minusKey = cVar.minusKey(bVar.getKey());
                if (minusKey == EmptyCoroutineContext.INSTANCE) {
                    return bVar;
                }
                kotlin.coroutines.b bVar2 = (kotlin.coroutines.b) minusKey.get(kotlin.coroutines.b.I);
                if (bVar2 == null) {
                    return new CombinedContext(minusKey, bVar);
                }
                c minusKey2 = minusKey.minusKey(kotlin.coroutines.b.I);
                return minusKey2 == EmptyCoroutineContext.INSTANCE ? new CombinedContext(bVar, bVar2) : new CombinedContext(new CombinedContext(minusKey2, bVar), bVar2);
            }
        }

        @NotNull
        public static c a(c cVar, @NotNull c cVar2) {
            f.b(cVar2, "context");
            return cVar2 == EmptyCoroutineContext.INSTANCE ? cVar : (c) cVar2.fold(cVar, C0418a.f8162a);
        }
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes2.dex */
    public interface b extends c {
        @Override // kotlin.coroutines.c
        @Nullable
        <E extends b> E get(@NotNull InterfaceC0419c<E> interfaceC0419c);

        @NotNull
        InterfaceC0419c<?> getKey();
    }

    /* compiled from: CoroutineContext.kt */
    /* renamed from: kotlin.coroutines.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0419c<E extends b> {
    }

    <R> R fold(R r, @NotNull p<? super R, ? super b, ? extends R> pVar);

    @Nullable
    <E extends b> E get(@NotNull InterfaceC0419c<E> interfaceC0419c);

    @NotNull
    c minusKey(@NotNull InterfaceC0419c<?> interfaceC0419c);

    @NotNull
    c plus(@NotNull c cVar);
}
