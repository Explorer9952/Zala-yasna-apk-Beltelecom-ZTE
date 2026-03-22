package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.r;

/* compiled from: Request.java */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    final s f8545a;

    /* renamed from: b, reason: collision with root package name */
    final String f8546b;

    /* renamed from: c, reason: collision with root package name */
    final r f8547c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    final y f8548d;
    final Map<Class<?>, Object> e;

    @Nullable
    private volatile d f;

    x(a aVar) {
        this.f8545a = aVar.f8549a;
        this.f8546b = aVar.f8550b;
        this.f8547c = aVar.f8551c.a();
        this.f8548d = aVar.f8552d;
        this.e = okhttp3.c0.c.a(aVar.e);
    }

    @Nullable
    public String a(String str) {
        return this.f8547c.a(str);
    }

    public d b() {
        d dVar = this.f;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f8547c);
        this.f = a2;
        return a2;
    }

    public r c() {
        return this.f8547c;
    }

    public boolean d() {
        return this.f8545a.h();
    }

    public String e() {
        return this.f8546b;
    }

    public a f() {
        return new a(this);
    }

    public s g() {
        return this.f8545a;
    }

    public String toString() {
        return "Request{method=" + this.f8546b + ", url=" + this.f8545a + ", tags=" + this.e + '}';
    }

    /* compiled from: Request.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        s f8549a;

        /* renamed from: b, reason: collision with root package name */
        String f8550b;

        /* renamed from: c, reason: collision with root package name */
        r.a f8551c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        y f8552d;
        Map<Class<?>, Object> e;

        public a() {
            this.e = Collections.emptyMap();
            this.f8550b = "GET";
            this.f8551c = new r.a();
        }

        public a a(s sVar) {
            if (sVar != null) {
                this.f8549a = sVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a b(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                a(s.d(str));
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a a(String str, String str2) {
            this.f8551c.c(str, str2);
            return this;
        }

        public a a(String str) {
            this.f8551c.b(str);
            return this;
        }

        a(x xVar) {
            Map<Class<?>, Object> linkedHashMap;
            this.e = Collections.emptyMap();
            this.f8549a = xVar.f8545a;
            this.f8550b = xVar.f8546b;
            this.f8552d = xVar.f8548d;
            if (xVar.e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(xVar.e);
            }
            this.e = linkedHashMap;
            this.f8551c = xVar.f8547c.a();
        }

        public a a(r rVar) {
            this.f8551c = rVar.a();
            return this;
        }

        public a a(d dVar) {
            String dVar2 = dVar.toString();
            if (dVar2.isEmpty()) {
                a("Cache-Control");
                return this;
            }
            a("Cache-Control", dVar2);
            return this;
        }

        public a a(y yVar) {
            a("POST", yVar);
            return this;
        }

        public a a(String str, @Nullable y yVar) {
            if (str != null) {
                if (str.length() != 0) {
                    if (yVar != null && !okhttp3.c0.f.f.b(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    }
                    if (yVar == null && okhttp3.c0.f.f.e(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    }
                    this.f8550b = str;
                    this.f8552d = yVar;
                    return this;
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public <T> a a(Class<? super T> cls, @Nullable T t) {
            if (cls == null) {
                throw new NullPointerException("type == null");
            }
            if (t == null) {
                this.e.remove(cls);
            } else {
                if (this.e.isEmpty()) {
                    this.e = new LinkedHashMap();
                }
                this.e.put(cls, cls.cast(t));
            }
            return this;
        }

        public x a() {
            if (this.f8549a != null) {
                return new x(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    @Nullable
    public y a() {
        return this.f8548d;
    }
}
