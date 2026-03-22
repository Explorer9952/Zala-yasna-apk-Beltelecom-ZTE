package com.unity3d.player;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
final class ReflectionHelper {
    protected static boolean LOG = false;
    protected static final boolean LOGV = false;

    /* renamed from: a, reason: collision with root package name */
    private static a[] f2926a = new a[4096];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public volatile Member f2929a;

        /* renamed from: b, reason: collision with root package name */
        private final Class f2930b;

        /* renamed from: c, reason: collision with root package name */
        private final String f2931c;

        /* renamed from: d, reason: collision with root package name */
        private final String f2932d;
        private final int e;

        a(Class cls, String str, String str2) {
            this.f2930b = cls;
            this.f2931c = str;
            this.f2932d = str2;
            this.e = ((((cls.hashCode() + 527) * 31) + this.f2931c.hashCode()) * 31) + this.f2932d.hashCode();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.e == aVar.e && this.f2932d.equals(aVar.f2932d) && this.f2931c.equals(aVar.f2931c) && this.f2930b.equals(aVar.f2930b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.e;
        }
    }

    ReflectionHelper() {
    }

    private static float a(Class cls, Class cls2) {
        if (cls.equals(cls2)) {
            return 1.0f;
        }
        if (cls.isPrimitive() || cls2.isPrimitive()) {
            return 0.0f;
        }
        try {
            if (cls.asSubclass(cls2) != null) {
                return 0.5f;
            }
        } catch (ClassCastException unused) {
        }
        try {
            return cls2.asSubclass(cls) != null ? 0.1f : 0.0f;
        } catch (ClassCastException unused2) {
            return 0.0f;
        }
    }

    private static float a(Class cls, Class[] clsArr, Class[] clsArr2) {
        if (clsArr2.length == 0) {
            return 0.1f;
        }
        int i = 0;
        if ((clsArr == null ? 0 : clsArr.length) + 1 != clsArr2.length) {
            return 0.0f;
        }
        float f = 1.0f;
        if (clsArr != null) {
            int length = clsArr.length;
            int i2 = 0;
            float f2 = 1.0f;
            while (i < length) {
                f2 *= a(clsArr[i], clsArr2[i2]);
                i++;
                i2++;
            }
            f = f2;
        }
        return f * a(cls, clsArr2[clsArr2.length - 1]);
    }

    private static Class a(String str, int[] iArr) {
        while (iArr[0] < str.length()) {
            int i = iArr[0];
            iArr[0] = i + 1;
            char charAt = str.charAt(i);
            if (charAt != '(' && charAt != ')') {
                if (charAt == 'L') {
                    int indexOf = str.indexOf(59, iArr[0]);
                    if (indexOf == -1) {
                        return null;
                    }
                    String substring = str.substring(iArr[0], indexOf);
                    iArr[0] = indexOf + 1;
                    try {
                        return Class.forName(substring.replace('/', '.'));
                    } catch (ClassNotFoundException unused) {
                        return null;
                    }
                }
                if (charAt == 'Z') {
                    return Boolean.TYPE;
                }
                if (charAt == 'I') {
                    return Integer.TYPE;
                }
                if (charAt == 'F') {
                    return Float.TYPE;
                }
                if (charAt == 'V') {
                    return Void.TYPE;
                }
                if (charAt == 'B') {
                    return Byte.TYPE;
                }
                if (charAt == 'S') {
                    return Short.TYPE;
                }
                if (charAt == 'J') {
                    return Long.TYPE;
                }
                if (charAt == 'D') {
                    return Double.TYPE;
                }
                if (charAt == '[') {
                    return Array.newInstance((Class<?>) a(str, iArr), 0).getClass();
                }
                c.Log(5, "! parseType; " + charAt + " is not known!");
                return null;
            }
        }
        return null;
    }

    private static void a(a aVar, Member member) {
        aVar.f2929a = member;
        f2926a[aVar.hashCode() & (f2926a.length - 1)] = aVar;
    }

    private static boolean a(a aVar) {
        a aVar2 = f2926a[aVar.hashCode() & (f2926a.length - 1)];
        if (!aVar.equals(aVar2)) {
            return false;
        }
        aVar.f2929a = aVar2.f2929a;
        return true;
    }

    private static Class[] a(String str) {
        Class a2;
        int i = 0;
        int[] iArr = {0};
        ArrayList arrayList = new ArrayList();
        while (iArr[0] < str.length() && (a2 = a(str, iArr)) != null) {
            arrayList.add(a2);
        }
        Class[] clsArr = new Class[arrayList.size()];
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            clsArr[i] = (Class) it2.next();
            i++;
        }
        return clsArr;
    }

    protected static Constructor getConstructorID(Class cls, String str) {
        Constructor<?> constructor;
        a aVar = new a(cls, "", str);
        if (a(aVar)) {
            constructor = (Constructor) aVar.f2929a;
        } else {
            Class[] a2 = a(str);
            float f = 0.0f;
            Constructor<?> constructor2 = null;
            for (Constructor<?> constructor3 : cls.getConstructors()) {
                float a3 = a(Void.TYPE, constructor3.getParameterTypes(), a2);
                if (a3 > f) {
                    constructor2 = constructor3;
                    if (a3 == 1.0f) {
                        break;
                    }
                    f = a3;
                }
            }
            a(aVar, constructor2);
            constructor = constructor2;
        }
        if (constructor != null) {
            return constructor;
        }
        throw new NoSuchMethodError("<init>" + str + " in class " + cls.getName());
    }

    protected static Field getFieldID(Class cls, String str, String str2, boolean z) {
        Field field;
        Class cls2 = cls;
        a aVar = new a(cls2, str, str2);
        if (a(aVar)) {
            field = (Field) aVar.f2929a;
        } else {
            Class[] a2 = a(str2);
            float f = 0.0f;
            Field field2 = null;
            while (cls2 != null) {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Field field3 = declaredFields[i];
                    if (z == Modifier.isStatic(field3.getModifiers()) && field3.getName().compareTo(str) == 0) {
                        float a3 = a(field3.getType(), (Class[]) null, a2);
                        if (a3 > f) {
                            field2 = field3;
                            if (a3 == 1.0f) {
                                f = a3;
                                break;
                            }
                            f = a3;
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (f == 1.0f || cls2.isPrimitive() || cls2.isInterface() || cls2.equals(Object.class) || cls2.equals(Void.TYPE)) {
                    break;
                }
                cls2 = cls2.getSuperclass();
            }
            a(aVar, field2);
            field = field2;
        }
        if (field != null) {
            return field;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z ? "static" : "non-static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls2.getName();
        throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", objArr));
    }

    protected static Method getMethodID(Class cls, String str, String str2, boolean z) {
        Method method;
        a aVar = new a(cls, str, str2);
        if (a(aVar)) {
            method = (Method) aVar.f2929a;
        } else {
            Class[] a2 = a(str2);
            float f = 0.0f;
            Method method2 = null;
            while (cls != null) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Method method3 = declaredMethods[i];
                    if (z == Modifier.isStatic(method3.getModifiers()) && method3.getName().compareTo(str) == 0) {
                        float a3 = a(method3.getReturnType(), method3.getParameterTypes(), a2);
                        if (a3 > f) {
                            method2 = method3;
                            if (a3 == 1.0f) {
                                f = a3;
                                break;
                            }
                            f = a3;
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (f == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            a(aVar, method2);
            method = method2;
        }
        if (method != null) {
            return method;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z ? "static" : "non-static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls.getName();
        throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyFinalize(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native Object nativeProxyInvoke(int i, String str, Object[] objArr);

    protected static Object newProxyInstance(int i, Class cls) {
        return newProxyInstance(i, new Class[]{cls});
    }

    protected static Object newProxyInstance(final int i, final Class[] clsArr) {
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), clsArr, new InvocationHandler() { // from class: com.unity3d.player.ReflectionHelper.1
            protected final void finalize() {
                try {
                    ReflectionHelper.nativeProxyFinalize(i);
                } finally {
                    super.finalize();
                }
            }

            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return ReflectionHelper.nativeProxyInvoke(i, method.getName(), objArr);
            }
        });
    }
}
