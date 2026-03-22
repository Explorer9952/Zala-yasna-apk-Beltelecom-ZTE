package okhttp3.c0.h;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: OptionalMethod.java */
/* loaded from: classes2.dex */
class e<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f8335a;

    /* renamed from: b, reason: collision with root package name */
    private final String f8336b;

    /* renamed from: c, reason: collision with root package name */
    private final Class[] f8337c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Class<?> cls, String str, Class... clsArr) {
        this.f8335a = cls;
        this.f8336b = str;
        this.f8337c = clsArr;
    }

    public boolean a(T t) {
        return a(t.getClass()) != null;
    }

    public Object b(T t, Object... objArr) throws InvocationTargetException {
        Method a2 = a(t.getClass());
        if (a2 == null) {
            return null;
        }
        try {
            return a2.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object c(T t, Object... objArr) {
        try {
            return b(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object d(T t, Object... objArr) {
        try {
            return a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object a(T t, Object... objArr) throws InvocationTargetException {
        Method a2 = a(t.getClass());
        if (a2 != null) {
            try {
                return a2.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a2);
                assertionError.initCause(e);
                throw assertionError;
            }
        }
        throw new AssertionError("Method " + this.f8336b + " not supported for object " + t);
    }

    private Method a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f8336b;
        if (str == null) {
            return null;
        }
        Method a2 = a(cls, str, this.f8337c);
        if (a2 == null || (cls2 = this.f8335a) == null || cls2.isAssignableFrom(a2.getReturnType())) {
            return a2;
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
