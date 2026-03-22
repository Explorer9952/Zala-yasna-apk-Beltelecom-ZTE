package kotlin.coroutines;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.Serializable;
import kotlin.TypeCastException;
import kotlin.coroutines.c;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.f;
import kotlin.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes2.dex */
public final class CombinedContext implements kotlin.coroutines.c, Serializable {
    private final c.b element;
    private final kotlin.coroutines.c left;

    /* compiled from: CoroutineContextImpl.kt */
    /* loaded from: classes2.dex */
    private static final class a implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlin.coroutines.c[] f8157a;

        /* compiled from: CoroutineContextImpl.kt */
        /* renamed from: kotlin.coroutines.CombinedContext$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0417a {
            private C0417a() {
            }

            public /* synthetic */ C0417a(d dVar) {
                this();
            }
        }

        static {
            new C0417a(null);
        }

        public a(@NotNull kotlin.coroutines.c[] cVarArr) {
            f.b(cVarArr, MessengerShareContentUtility.ELEMENTS);
            this.f8157a = cVarArr;
        }

        private final Object readResolve() {
            kotlin.coroutines.c[] cVarArr = this.f8157a;
            kotlin.coroutines.c cVar = EmptyCoroutineContext.INSTANCE;
            for (kotlin.coroutines.c cVar2 : cVarArr) {
                cVar = cVar.plus(cVar2);
            }
            return cVar;
        }
    }

    /* compiled from: CoroutineContextImpl.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements p<String, c.b, String> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f8158a = new b();

        b() {
            super(2);
        }

        @Override // kotlin.jvm.b.p
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(@NotNull String str, @NotNull c.b bVar) {
            f.b(str, "acc");
            f.b(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    /* compiled from: CoroutineContextImpl.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements p<l, c.b, l> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.c[] f8159a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref$IntRef f8160b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.coroutines.c[] cVarArr, Ref$IntRef ref$IntRef) {
            super(2);
            this.f8159a = cVarArr;
            this.f8160b = ref$IntRef;
        }

        public final void a(@NotNull l lVar, @NotNull c.b bVar) {
            f.b(lVar, "<anonymous parameter 0>");
            f.b(bVar, "element");
            kotlin.coroutines.c[] cVarArr = this.f8159a;
            Ref$IntRef ref$IntRef = this.f8160b;
            int i = ref$IntRef.element;
            ref$IntRef.element = i + 1;
            cVarArr[i] = bVar;
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ l invoke(l lVar, c.b bVar) {
            a(lVar, bVar);
            return l.f8186a;
        }
    }

    public CombinedContext(@NotNull kotlin.coroutines.c cVar, @NotNull c.b bVar) {
        f.b(cVar, "left");
        f.b(bVar, "element");
        this.left = cVar;
        this.element = bVar;
    }

    private final boolean contains(c.b bVar) {
        return f.a(get(bVar.getKey()), bVar);
    }

    private final boolean containsAll(CombinedContext combinedContext) {
        while (contains(combinedContext.element)) {
            kotlin.coroutines.c cVar = combinedContext.left;
            if (!(cVar instanceof CombinedContext)) {
                if (cVar != null) {
                    return contains((c.b) cVar);
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
            combinedContext = (CombinedContext) cVar;
        }
        return false;
    }

    private final int size() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            kotlin.coroutines.c cVar = combinedContext.left;
            if (!(cVar instanceof CombinedContext)) {
                cVar = null;
            }
            combinedContext = (CombinedContext) cVar;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    private final Object writeReplace() {
        int size = size();
        kotlin.coroutines.c[] cVarArr = new kotlin.coroutines.c[size];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        fold(l.f8186a, new c(cVarArr, ref$IntRef));
        if (ref$IntRef.element == size) {
            return new a(cVarArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.size() != size() || !combinedContext.containsAll(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.c
    public <R> R fold(R r, @NotNull p<? super R, ? super c.b, ? extends R> pVar) {
        f.b(pVar, "operation");
        return pVar.invoke((Object) this.left.fold(r, pVar), this.element);
    }

    @Override // kotlin.coroutines.c
    @Nullable
    public <E extends c.b> E get(@NotNull c.InterfaceC0419c<E> interfaceC0419c) {
        f.b(interfaceC0419c, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e = (E) combinedContext.element.get(interfaceC0419c);
            if (e != null) {
                return e;
            }
            kotlin.coroutines.c cVar = combinedContext.left;
            if (cVar instanceof CombinedContext) {
                combinedContext = (CombinedContext) cVar;
            } else {
                return (E) cVar.get(interfaceC0419c);
            }
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public kotlin.coroutines.c minusKey(@NotNull c.InterfaceC0419c<?> interfaceC0419c) {
        f.b(interfaceC0419c, "key");
        if (this.element.get(interfaceC0419c) != null) {
            return this.left;
        }
        kotlin.coroutines.c minusKey = this.left.minusKey(interfaceC0419c);
        return minusKey == this.left ? this : minusKey == EmptyCoroutineContext.INSTANCE ? this.element : new CombinedContext(minusKey, this.element);
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public kotlin.coroutines.c plus(@NotNull kotlin.coroutines.c cVar) {
        f.b(cVar, "context");
        return c.a.a(this, cVar);
    }

    @NotNull
    public String toString() {
        return "[" + ((String) fold("", b.f8158a)) + "]";
    }
}
