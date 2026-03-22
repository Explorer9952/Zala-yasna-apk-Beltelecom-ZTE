package okhttp3.c0.h;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Jdk9Platform.java */
/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: c, reason: collision with root package name */
    final Method f8328c;

    /* renamed from: d, reason: collision with root package name */
    final Method f8329d;

    c(Method method, Method method2) {
        this.f8328c = method;
        this.f8329d = method2;
    }

    @Override // okhttp3.c0.h.f
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a2 = f.a(list);
            this.f8328c.invoke(sSLParameters, a2.toArray(new String[a2.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.c0.c.a("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // okhttp3.c0.h.f
    @Nullable
    public String b(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f8329d.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.c0.c.a("unable to get selected protocols", (Exception) e);
        }
    }

    public static c b() {
        try {
            return new c(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
