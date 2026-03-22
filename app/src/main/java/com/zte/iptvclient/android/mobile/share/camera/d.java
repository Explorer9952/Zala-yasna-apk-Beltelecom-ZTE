package com.zte.iptvclient.android.mobile.share.camera;

import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: FlashlightManager.java */
/* loaded from: classes2.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7191a = "d";

    /* renamed from: b, reason: collision with root package name */
    private static final Object f7192b;

    /* renamed from: c, reason: collision with root package name */
    private static final Method f7193c;

    static {
        Object c2 = c();
        f7192b = c2;
        f7193c = a(c2);
        if (f7192b == null) {
            Log.v(f7191a, "This device does supports control of a flashlight");
        } else {
            Log.v(f7191a, "This device does not support control of a flashlight");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        a(false);
    }

    private static Object c() {
        Method a2;
        Object a3;
        Class<?> a4;
        Method a5;
        Class<?> a6 = a("android.os.ServiceManager");
        if (a6 == null || (a2 = a(a6, "getService", (Class<?>[]) new Class[]{String.class})) == null || (a3 = a(a2, (Object) null, "hardware")) == null || (a4 = a("android.os.IHardwareService$Stub")) == null || (a5 = a(a4, "asInterface", (Class<?>[]) new Class[]{IBinder.class})) == null) {
            return null;
        }
        return a(a5, (Object) null, a3);
    }

    private static Method a(Object obj) {
        if (obj == null) {
            return null;
        }
        return a(obj.getClass(), "setFlashlightEnabled", (Class<?>[]) new Class[]{Boolean.TYPE});
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException e) {
            Log.w(f7191a, "Unexpected error while finding class " + str, e);
            return null;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (RuntimeException e) {
            Log.w(f7191a, "Unexpected error while finding method " + str, e);
            return null;
        }
    }

    private static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            Log.w(f7191a, "Unexpected error while invoking " + method, e);
            return null;
        } catch (RuntimeException e2) {
            Log.w(f7191a, "Unexpected error while invoking " + method, e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.w(f7191a, "Unexpected error while invoking " + method, e3.getCause());
            return null;
        }
    }

    private static void a(boolean z) {
        Object obj = f7192b;
        if (obj != null) {
            a(f7193c, obj, Boolean.valueOf(z));
        }
    }
}
