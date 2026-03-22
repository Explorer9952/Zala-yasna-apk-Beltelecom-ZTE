package okhttp3.c0.h;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JdkWithJettyBootPlatform.java */
/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: c, reason: collision with root package name */
    private final Method f8330c;

    /* renamed from: d, reason: collision with root package name */
    private final Method f8331d;
    private final Method e;
    private final Class<?> f;
    private final Class<?> g;

    /* compiled from: JdkWithJettyBootPlatform.java */
    /* loaded from: classes2.dex */
    private static class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f8332a;

        /* renamed from: b, reason: collision with root package name */
        boolean f8333b;

        /* renamed from: c, reason: collision with root package name */
        String f8334c;

        a(List<String> list) {
            this.f8332a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = okhttp3.c0.c.f8268b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f8333b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f8332a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                List list = (List) objArr[0];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (this.f8332a.contains(list.get(i))) {
                        String str = (String) list.get(i);
                        this.f8334c = str;
                        return str;
                    }
                }
                String str2 = this.f8332a.get(0);
                this.f8334c = str2;
                return str2;
            }
            if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                this.f8334c = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }

    d(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f8330c = method;
        this.f8331d = method2;
        this.e = method3;
        this.f = cls;
        this.g = cls2;
    }

    @Override // okhttp3.c0.h.f
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            this.f8330c.invoke(null, sSLSocket, Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f, this.g}, new a(f.a(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.c0.c.a("unable to set alpn", (Exception) e);
        }
    }

    @Override // okhttp3.c0.h.f
    @Nullable
    public String b(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f8331d.invoke(null, sSLSocket));
            if (!aVar.f8333b && aVar.f8334c == null) {
                f.c().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (aVar.f8333b) {
                return null;
            }
            return aVar.f8334c;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.c0.c.a("unable to get selected protocol", (Exception) e);
        }
    }

    @Override // okhttp3.c0.h.f
    public void a(SSLSocket sSLSocket) {
        try {
            this.e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.c0.c.a("unable to remove alpn", (Exception) e);
        }
    }

    public static f b() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new d(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
