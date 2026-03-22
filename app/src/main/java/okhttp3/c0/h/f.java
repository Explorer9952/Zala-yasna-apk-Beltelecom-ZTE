package okhttp3.c0.h;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.v;

/* compiled from: Platform.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final f f8338a = b();

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f8339b = Logger.getLogger(v.class.getName());

    private static f b() {
        b b2;
        f b3 = a.b();
        if (b3 != null) {
            return b3;
        }
        if (d() && (b2 = b.b()) != null) {
            return b2;
        }
        c b4 = c.b();
        if (b4 != null) {
            return b4;
        }
        f b5 = d.b();
        return b5 != null ? b5 : new f();
    }

    public static f c() {
        return f8338a;
    }

    public static boolean d() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, @Nullable String str, List<Protocol> list) {
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
    }

    @Nullable
    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public boolean b(String str) {
        return true;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void a(int i, String str, @Nullable Throwable th) {
        f8339b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (f8339b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b(List<Protocol> list) {
        okio.c cVar = new okio.c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                cVar.writeByte(protocol.toString().length());
                cVar.a(protocol.toString());
            }
        }
        return cVar.c();
    }

    public static List<String> a(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public okhttp3.c0.j.c a(X509TrustManager x509TrustManager) {
        return new okhttp3.c0.j.a(b(x509TrustManager));
    }

    public SSLContext a() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public okhttp3.c0.j.e b(X509TrustManager x509TrustManager) {
        return new okhttp3.c0.j.b(x509TrustManager.getAcceptedIssuers());
    }
}
