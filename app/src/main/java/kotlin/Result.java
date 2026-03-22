package kotlin;

import com.video.androidsdk.common.ErrMessage;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Result.kt */
/* loaded from: classes2.dex */
public final class Result<T> implements Serializable {
    public static final a Companion = new a(null);

    @Nullable
    private final Object value;

    /* compiled from: Result.kt */
    /* loaded from: classes2.dex */
    public static final class Failure implements Serializable {

        @NotNull
        public final Throwable exception;

        public Failure(@NotNull Throwable th) {
            kotlin.jvm.internal.f.b(th, ErrMessage.ERRCODE_EXCEPTION);
            this.exception = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Failure) && kotlin.jvm.internal.f.a(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @NotNull
        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    /* compiled from: Result.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.d dVar) {
            this();
        }
    }

    private /* synthetic */ Result(@Nullable Object obj) {
        this.value = obj;
    }

    @NotNull
    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Result m18boximpl(@Nullable Object obj) {
        return new Result(obj);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static Object m19constructorimpl(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m20equalsimpl(Object obj, @Nullable Object obj2) {
        return (obj2 instanceof Result) && kotlin.jvm.internal.f.a(obj, ((Result) obj2).m28unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m21equalsimpl0(@Nullable Object obj, @Nullable Object obj2) {
        return kotlin.jvm.internal.f.a(obj, obj2);
    }

    @Nullable
    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m22exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl, reason: not valid java name */
    private static final T m23getOrNullimpl(Object obj) {
        if (m25isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m24hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m25isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m26isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m27toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public static /* synthetic */ void value$annotations() {
    }

    public boolean equals(Object obj) {
        return m20equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m24hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m27toStringimpl(this.value);
    }

    @Nullable
    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m28unboximpl() {
        return this.value;
    }
}
