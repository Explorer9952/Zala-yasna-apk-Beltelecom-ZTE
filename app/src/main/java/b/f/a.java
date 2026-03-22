package b.f;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Trace.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f1853a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f1854b;

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a(str);
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean b() {
        try {
            if (f1854b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return c();
    }

    private static boolean c() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f1854b == null) {
                    f1853a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    f1854b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                return ((Boolean) f1854b.invoke(null, Long.valueOf(f1853a))).booleanValue();
            } catch (Exception e) {
                a("isTagEnabled", e);
            }
        }
        return false;
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a();
        }
    }

    private static void a(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }
}
