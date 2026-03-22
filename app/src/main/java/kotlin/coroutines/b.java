package kotlin.coroutines;

import kotlin.coroutines.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: ContinuationInterceptor.kt */
/* loaded from: classes2.dex */
public interface b extends c.b {
    public static final a I = a.f8161a;

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: classes2.dex */
    public static final class a implements c.InterfaceC0419c<b> {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f8161a = new a();

        private a() {
        }
    }

    void a(@NotNull kotlin.coroutines.a<?> aVar);

    @NotNull
    <T> kotlin.coroutines.a<T> b(@NotNull kotlin.coroutines.a<? super T> aVar);
}
