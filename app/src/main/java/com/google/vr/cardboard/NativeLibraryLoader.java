package com.google.vr.cardboard;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class NativeLibraryLoader {
    private static final String TAG = "NativeLibraryLoader";

    static {
        try {
            System.loadLibrary("gvr");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static boolean closeNativeLibrary(long j) {
        if (j == 0) {
            return false;
        }
        return nativeDlclose(j);
    }

    private static String findNativeLibrary(ClassLoader classLoader, String str) {
        if (Build.VERSION.SDK_INT >= 14 && (classLoader instanceof BaseDexClassLoader)) {
            return ((BaseDexClassLoader) classLoader).findLibrary(str);
        }
        try {
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(classLoader, str);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 45);
            sb.append("ClassLoader.findLibrary() invocation failed: ");
            sb.append(valueOf);
            Log.w(TAG, sb.toString());
            return null;
        }
    }

    private static native boolean nativeDlclose(long j);

    private static native long nativeDlopen(String str);

    public static long openNativeLibrary(Context context, String str) {
        String findNativeLibrary = findNativeLibrary(context.getClassLoader(), str);
        if (findNativeLibrary != null && !findNativeLibrary.isEmpty()) {
            return nativeDlopen(findNativeLibrary);
        }
        String valueOf = String.valueOf(str);
        Log.w(TAG, valueOf.length() != 0 ? "Failed to find native library: ".concat(valueOf) : new String("Failed to find native library: "));
        return 0L;
    }
}
