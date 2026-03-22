package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DebugMetadata.kt */
/* loaded from: classes2.dex */
public final class d {
    private static final c a(@NotNull BaseContinuationImpl baseContinuationImpl) {
        return (c) baseContinuationImpl.getClass().getAnnotation(c.class);
    }

    private static final int b(@NotNull BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            kotlin.jvm.internal.f.a((Object) declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @Nullable
    public static final StackTraceElement c(@NotNull BaseContinuationImpl baseContinuationImpl) {
        String str;
        kotlin.jvm.internal.f.b(baseContinuationImpl, "$this$getStackTraceElementImpl");
        c a2 = a(baseContinuationImpl);
        if (a2 == null) {
            return null;
        }
        a(1, a2.v());
        int b2 = b(baseContinuationImpl);
        int i = b2 < 0 ? -1 : a2.l()[b2];
        String a3 = f.f8168c.a(baseContinuationImpl);
        if (a3 == null) {
            str = a2.c();
        } else {
            str = a3 + '/' + a2.c();
        }
        return new StackTraceElement(str, a2.m(), a2.f(), i);
    }

    private static final void a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }
}
