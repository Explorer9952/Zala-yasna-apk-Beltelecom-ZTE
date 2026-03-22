package okhttp3.logging;

import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.a0;
import okhttp3.c0.f.e;
import okhttp3.c0.h.f;
import okhttp3.i;
import okhttp3.r;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;
import okio.c;

/* loaded from: classes2.dex */
public final class HttpLoggingInterceptor implements t {

    /* renamed from: d, reason: collision with root package name */
    private static final Charset f8500d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    private final a f8501a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Set<String> f8502b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Level f8503c;

    /* loaded from: classes2.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* loaded from: classes2.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f8504a = new C0432a();

        /* renamed from: okhttp3.logging.HttpLoggingInterceptor$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0432a implements a {
            C0432a() {
            }

            @Override // okhttp3.logging.HttpLoggingInterceptor.a
            public void a(String str) {
                f.c().a(4, str, (Throwable) null);
            }
        }

        void a(String str);
    }

    public HttpLoggingInterceptor() {
        this(a.f8504a);
    }

    public HttpLoggingInterceptor a(Level level) {
        if (level != null) {
            this.f8503c = level;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public HttpLoggingInterceptor(a aVar) {
        this.f8502b = Collections.emptySet();
        this.f8503c = Level.NONE;
        this.f8501a = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.lang.Long] */
    @Override // okhttp3.t
    public z a(t.a aVar) throws IOException {
        long j;
        char c2;
        String sb;
        Level level = this.f8503c;
        x e = aVar.e();
        if (level == Level.NONE) {
            return aVar.a(e);
        }
        boolean z = level == Level.BODY;
        boolean z2 = z || level == Level.HEADERS;
        y a2 = e.a();
        boolean z3 = a2 != null;
        i c3 = aVar.c();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--> ");
        sb2.append(e.e());
        sb2.append(' ');
        sb2.append(e.g());
        sb2.append(c3 != null ? " " + c3.a() : "");
        String sb3 = sb2.toString();
        if (!z2 && z3) {
            sb3 = sb3 + " (" + a2.a() + "-byte body)";
        }
        this.f8501a.a(sb3);
        if (z2) {
            if (z3) {
                if (a2.b() != null) {
                    this.f8501a.a("Content-Type: " + a2.b());
                }
                if (a2.a() != -1) {
                    this.f8501a.a("Content-Length: " + a2.a());
                }
            }
            r c4 = e.c();
            int b2 = c4.b();
            for (int i = 0; i < b2; i++) {
                String a3 = c4.a(i);
                if (!"Content-Type".equalsIgnoreCase(a3) && !"Content-Length".equalsIgnoreCase(a3)) {
                    a(c4, i);
                }
            }
            if (z && z3) {
                if (a(e.c())) {
                    this.f8501a.a("--> END " + e.e() + " (encoded body omitted)");
                } else {
                    c cVar = new c();
                    a2.a(cVar);
                    Charset charset = f8500d;
                    u b3 = a2.b();
                    if (b3 != null) {
                        charset = b3.a(f8500d);
                    }
                    this.f8501a.a("");
                    if (a(cVar)) {
                        this.f8501a.a(cVar.a(charset));
                        this.f8501a.a("--> END " + e.e() + " (" + a2.a() + "-byte body)");
                    } else {
                        this.f8501a.a("--> END " + e.e() + " (binary " + a2.a() + "-byte body omitted)");
                    }
                }
            } else {
                this.f8501a.a("--> END " + e.e());
            }
        }
        long nanoTime = System.nanoTime();
        try {
            z a4 = aVar.a(e);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            a0 g = a4.g();
            long k = g.k();
            String str = k != -1 ? k + "-byte" : "unknown-length";
            a aVar2 = this.f8501a;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("<-- ");
            sb4.append(a4.l());
            if (a4.o().isEmpty()) {
                sb = "";
                j = k;
                c2 = ' ';
            } else {
                StringBuilder sb5 = new StringBuilder();
                j = k;
                c2 = ' ';
                sb5.append(' ');
                sb5.append(a4.o());
                sb = sb5.toString();
            }
            sb4.append(sb);
            sb4.append(c2);
            sb4.append(a4.s().g());
            sb4.append(" (");
            sb4.append(millis);
            sb4.append(LocaleUtil.MALAY);
            sb4.append(z2 ? "" : ", " + str + " body");
            sb4.append(')');
            aVar2.a(sb4.toString());
            if (z2) {
                r n = a4.n();
                int b4 = n.b();
                for (int i2 = 0; i2 < b4; i2++) {
                    a(n, i2);
                }
                if (z && e.b(a4)) {
                    if (a(a4.n())) {
                        this.f8501a.a("<-- END HTTP (encoded body omitted)");
                    } else {
                        okio.e m = g.m();
                        m.request(Long.MAX_VALUE);
                        c a5 = m.a();
                        okio.i iVar = null;
                        if ("gzip".equalsIgnoreCase(n.a("Content-Encoding"))) {
                            ?? valueOf = Long.valueOf(a5.p());
                            try {
                                okio.i iVar2 = new okio.i(a5.clone());
                                try {
                                    a5 = new c();
                                    a5.a(iVar2);
                                    iVar2.close();
                                    iVar = valueOf;
                                } catch (Throwable th) {
                                    th = th;
                                    iVar = iVar2;
                                    if (iVar != null) {
                                        iVar.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        Charset charset2 = f8500d;
                        u l = g.l();
                        if (l != null) {
                            charset2 = l.a(f8500d);
                        }
                        if (!a(a5)) {
                            this.f8501a.a("");
                            this.f8501a.a("<-- END HTTP (binary " + a5.p() + "-byte body omitted)");
                            return a4;
                        }
                        if (j != 0) {
                            this.f8501a.a("");
                            this.f8501a.a(a5.clone().a(charset2));
                        }
                        if (iVar != null) {
                            this.f8501a.a("<-- END HTTP (" + a5.p() + "-byte, " + iVar + "-gzipped-byte body)");
                        } else {
                            this.f8501a.a("<-- END HTTP (" + a5.p() + "-byte body)");
                        }
                    }
                } else {
                    this.f8501a.a("<-- END HTTP");
                }
            }
            return a4;
        } catch (Exception e2) {
            this.f8501a.a("<-- HTTP FAILED: " + e2);
            throw e2;
        }
    }

    private void a(r rVar, int i) {
        String b2 = this.f8502b.contains(rVar.a(i)) ? "██" : rVar.b(i);
        this.f8501a.a(rVar.a(i) + ": " + b2);
    }

    static boolean a(c cVar) {
        try {
            c cVar2 = new c();
            cVar.a(cVar2, 0L, cVar.p() < 64 ? cVar.p() : 64L);
            for (int i = 0; i < 16; i++) {
                if (cVar2.d()) {
                    return true;
                }
                int o = cVar2.o();
                if (Character.isISOControl(o) && !Character.isWhitespace(o)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    private static boolean a(r rVar) {
        String a2 = rVar.a("Content-Encoding");
        return (a2 == null || a2.equalsIgnoreCase("identity") || a2.equalsIgnoreCase("gzip")) ? false : true;
    }
}
