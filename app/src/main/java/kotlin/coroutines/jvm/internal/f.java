package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DebugMetadata.kt */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static a f8167b;

    /* renamed from: c, reason: collision with root package name */
    public static final f f8168c = new f();

    /* renamed from: a, reason: collision with root package name */
    private static final a f8166a = new a(null, null, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DebugMetadata.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public final Method f8169a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final Method f8170b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final Method f8171c;

        public a(@Nullable Method method, @Nullable Method method2, @Nullable Method method3) {
            this.f8169a = method;
            this.f8170b = method2;
            this.f8171c = method3;
        }
    }

    private f() {
    }

    private final a b(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f8167b = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f8166a;
            f8167b = aVar2;
            return aVar2;
        }
    }

    @Nullable
    public final String a(@NotNull BaseContinuationImpl baseContinuationImpl) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        kotlin.jvm.internal.f.b(baseContinuationImpl, "continuation");
        a aVar = f8167b;
        if (aVar == null) {
            aVar = b(baseContinuationImpl);
        }
        if (aVar == f8166a || (method = aVar.f8169a) == null || (invoke = method.invoke(baseContinuationImpl.getClass(), new Object[0])) == null || (method2 = aVar.f8170b) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.f8171c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        return (String) (invoke3 instanceof String ? invoke3 : null);
    }
}
