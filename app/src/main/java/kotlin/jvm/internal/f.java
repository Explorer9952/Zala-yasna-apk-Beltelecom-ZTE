package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* compiled from: Intrinsics.java */
/* loaded from: classes2.dex */
public class f {
    private f() {
    }

    public static void a() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        a(kotlinNullPointerException);
        throw kotlinNullPointerException;
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        a(str);
        throw null;
    }

    public static void c(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(str);
        a(uninitializedPropertyAccessException);
        throw uninitializedPropertyAccessException;
    }

    public static void d(String str) {
        c("lateinit property " + str + " has not been initialized");
        throw null;
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str + " must not be null");
        a(illegalStateException);
        throw illegalStateException;
    }

    public static void b() {
        b("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
        throw null;
    }

    private static void a(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str);
        a(illegalArgumentException);
        throw illegalArgumentException;
    }

    public static void b(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void a(int i, String str) {
        b();
        throw null;
    }

    private static <T extends Throwable> T a(T t) {
        a((Throwable) t, f.class.getName());
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Throwable> T a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }
}
