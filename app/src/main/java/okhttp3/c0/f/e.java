package okhttp3.c0.f;

import java.util.List;
import okhttp3.l;
import okhttp3.m;
import okhttp3.r;
import okhttp3.s;
import okhttp3.z;
import okio.ByteString;

/* compiled from: HttpHeaders.java */
/* loaded from: classes2.dex */
public final class e {
    static {
        ByteString.encodeUtf8("\"\\");
        ByteString.encodeUtf8("\t ,=");
    }

    public static long a(z zVar) {
        return a(zVar.n());
    }

    public static boolean b(z zVar) {
        if (zVar.s().e().equals("HEAD")) {
            return false;
        }
        int l = zVar.l();
        return (((l >= 100 && l < 200) || l == 204 || l == 304) && a(zVar) == -1 && !"chunked".equalsIgnoreCase(zVar.b("Transfer-Encoding"))) ? false : true;
    }

    public static long a(r rVar) {
        return a(rVar.a("Content-Length"));
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void a(m mVar, s sVar, r rVar) {
        if (mVar == m.f8505a) {
            return;
        }
        List<l> a2 = l.a(sVar, rVar);
        if (a2.isEmpty()) {
            return;
        }
        mVar.a(sVar, a2);
    }

    public static int b(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
