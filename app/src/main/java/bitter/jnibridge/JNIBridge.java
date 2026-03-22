package bitter.jnibridge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class JNIBridge {

    /* loaded from: classes.dex */
    private static class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private Object f1855a = new Object[0];

        /* renamed from: b, reason: collision with root package name */
        private long f1856b;

        public a(long j) {
            this.f1856b = j;
        }

        public final void a() {
            synchronized (this.f1855a) {
                this.f1856b = 0L;
            }
        }

        public final void finalize() {
            synchronized (this.f1855a) {
                if (this.f1856b == 0) {
                    return;
                }
                JNIBridge.delete(this.f1856b);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            synchronized (this.f1855a) {
                if (this.f1856b == 0) {
                    return null;
                }
                return JNIBridge.invoke(this.f1856b, method.getDeclaringClass(), method, objArr);
            }
        }
    }

    static native void delete(long j);

    static void disableInterfaceProxy(Object obj) {
        ((a) Proxy.getInvocationHandler(obj)).a();
    }

    static native Object invoke(long j, Class cls, Method method, Object[] objArr);

    static Object newInterfaceProxy(long j, Class[] clsArr) {
        return Proxy.newProxyInstance(JNIBridge.class.getClassLoader(), clsArr, new a(j));
    }
}
