package okhttp3.c0.f;

import java.net.Proxy;
import okhttp3.s;
import okhttp3.x;

/* compiled from: RequestLine.java */
/* loaded from: classes2.dex */
public final class i {
    public static String a(x xVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(xVar.e());
        sb.append(' ');
        if (b(xVar, type)) {
            sb.append(xVar.g());
        } else {
            sb.append(a(xVar.g()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(x xVar, Proxy.Type type) {
        return !xVar.d() && type == Proxy.Type.HTTP;
    }

    public static String a(s sVar) {
        String c2 = sVar.c();
        String e = sVar.e();
        if (e == null) {
            return c2;
        }
        return c2 + '?' + e;
    }
}
