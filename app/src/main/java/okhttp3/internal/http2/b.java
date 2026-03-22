package okhttp3.internal.http2;

import com.video.androidsdk.common.http.HttpConstant;
import com.zte.ucs.tvcall.Commons;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import okio.r;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Hpack.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    static final okhttp3.internal.http2.a[] f8387a = {new okhttp3.internal.http2.a(okhttp3.internal.http2.a.i, ""), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f, "GET"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f, "POST"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.g, "/"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.g, "/index.html"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.h, HttpConstant.PROTOCOL_HTTP), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.h, HttpConstant.PROTOCOL_HTTPS), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.e, "200"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.e, "204"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.e, "206"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.e, "304"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.e, "400"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.e, "404"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.e, "500"), new okhttp3.internal.http2.a("accept-charset", ""), new okhttp3.internal.http2.a("accept-encoding", "gzip, deflate"), new okhttp3.internal.http2.a("accept-language", ""), new okhttp3.internal.http2.a("accept-ranges", ""), new okhttp3.internal.http2.a("accept", ""), new okhttp3.internal.http2.a("access-control-allow-origin", ""), new okhttp3.internal.http2.a("age", ""), new okhttp3.internal.http2.a("allow", ""), new okhttp3.internal.http2.a("authorization", ""), new okhttp3.internal.http2.a("cache-control", ""), new okhttp3.internal.http2.a("content-disposition", ""), new okhttp3.internal.http2.a("content-encoding", ""), new okhttp3.internal.http2.a("content-language", ""), new okhttp3.internal.http2.a("content-length", ""), new okhttp3.internal.http2.a("content-location", ""), new okhttp3.internal.http2.a("content-range", ""), new okhttp3.internal.http2.a("content-type", ""), new okhttp3.internal.http2.a("cookie", ""), new okhttp3.internal.http2.a("date", ""), new okhttp3.internal.http2.a("etag", ""), new okhttp3.internal.http2.a("expect", ""), new okhttp3.internal.http2.a("expires", ""), new okhttp3.internal.http2.a("from", ""), new okhttp3.internal.http2.a("host", ""), new okhttp3.internal.http2.a("if-match", ""), new okhttp3.internal.http2.a("if-modified-since", ""), new okhttp3.internal.http2.a("if-none-match", ""), new okhttp3.internal.http2.a("if-range", ""), new okhttp3.internal.http2.a("if-unmodified-since", ""), new okhttp3.internal.http2.a("last-modified", ""), new okhttp3.internal.http2.a("link", ""), new okhttp3.internal.http2.a("location", ""), new okhttp3.internal.http2.a("max-forwards", ""), new okhttp3.internal.http2.a("proxy-authenticate", ""), new okhttp3.internal.http2.a("proxy-authorization", ""), new okhttp3.internal.http2.a("range", ""), new okhttp3.internal.http2.a("referer", ""), new okhttp3.internal.http2.a("refresh", ""), new okhttp3.internal.http2.a("retry-after", ""), new okhttp3.internal.http2.a("server", ""), new okhttp3.internal.http2.a("set-cookie", ""), new okhttp3.internal.http2.a("strict-transport-security", ""), new okhttp3.internal.http2.a("transfer-encoding", ""), new okhttp3.internal.http2.a("user-agent", ""), new okhttp3.internal.http2.a("vary", ""), new okhttp3.internal.http2.a("via", ""), new okhttp3.internal.http2.a("www-authenticate", "")};

    /* renamed from: b, reason: collision with root package name */
    static final Map<ByteString, Integer> f8388b = a();

    /* compiled from: Hpack.java */
    /* loaded from: classes2.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<okhttp3.internal.http2.a> f8389a;

        /* renamed from: b, reason: collision with root package name */
        private final okio.e f8390b;

        /* renamed from: c, reason: collision with root package name */
        private final int f8391c;

        /* renamed from: d, reason: collision with root package name */
        private int f8392d;
        okhttp3.internal.http2.a[] e;
        int f;
        int g;
        int h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, r rVar) {
            this(i, i, rVar);
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.e.length;
                while (true) {
                    length--;
                    if (length < this.f || i <= 0) {
                        break;
                    }
                    okhttp3.internal.http2.a[] aVarArr = this.e;
                    i -= aVarArr[length].f8386c;
                    this.h -= aVarArr[length].f8386c;
                    this.g--;
                    i2++;
                }
                okhttp3.internal.http2.a[] aVarArr2 = this.e;
                int i3 = this.f;
                System.arraycopy(aVarArr2, i3 + 1, aVarArr2, i3 + 1 + i2, this.g);
                this.f += i2;
            }
            return i2;
        }

        private void d() {
            int i = this.f8392d;
            int i2 = this.h;
            if (i < i2) {
                if (i == 0) {
                    e();
                } else {
                    b(i2 - i);
                }
            }
        }

        private void e() {
            Arrays.fill(this.e, (Object) null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        private void f(int i) throws IOException {
            a(-1, new okhttp3.internal.http2.a(c(i), b()));
        }

        private void g(int i) throws IOException {
            this.f8389a.add(new okhttp3.internal.http2.a(c(i), b()));
        }

        private void h() throws IOException {
            ByteString b2 = b();
            b.a(b2);
            this.f8389a.add(new okhttp3.internal.http2.a(b2, b()));
        }

        public List<okhttp3.internal.http2.a> a() {
            ArrayList arrayList = new ArrayList(this.f8389a);
            this.f8389a.clear();
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() throws IOException {
            while (!this.f8390b.d()) {
                int readByte = this.f8390b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & Commons.MSG_MCSP_INIT_SUCCESS) == 128) {
                    e(a(readByte, 127) - 1);
                } else if (readByte == 64) {
                    g();
                } else if ((readByte & 64) == 64) {
                    f(a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int a2 = a(readByte, 31);
                    this.f8392d = a2;
                    if (a2 >= 0 && a2 <= this.f8391c) {
                        d();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.f8392d);
                    }
                } else if (readByte != 16 && readByte != 0) {
                    g(a(readByte, 15) - 1);
                } else {
                    h();
                }
            }
        }

        a(int i, int i2, r rVar) {
            this.f8389a = new ArrayList();
            this.e = new okhttp3.internal.http2.a[8];
            this.f = r0.length - 1;
            this.g = 0;
            this.h = 0;
            this.f8391c = i;
            this.f8392d = i2;
            this.f8390b = okio.k.a(rVar);
        }

        private int a(int i) {
            return this.f + 1 + i;
        }

        private void a(int i, okhttp3.internal.http2.a aVar) {
            this.f8389a.add(aVar);
            int i2 = aVar.f8386c;
            if (i != -1) {
                i2 -= this.e[a(i)].f8386c;
            }
            int i3 = this.f8392d;
            if (i2 > i3) {
                e();
                return;
            }
            int b2 = b((this.h + i2) - i3);
            if (i == -1) {
                int i4 = this.g + 1;
                okhttp3.internal.http2.a[] aVarArr = this.e;
                if (i4 > aVarArr.length) {
                    okhttp3.internal.http2.a[] aVarArr2 = new okhttp3.internal.http2.a[aVarArr.length * 2];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f = this.e.length - 1;
                    this.e = aVarArr2;
                }
                int i5 = this.f;
                this.f = i5 - 1;
                this.e[i5] = aVar;
                this.g++;
            } else {
                this.e[i + a(i) + b2] = aVar;
            }
            this.h += i2;
        }

        private boolean d(int i) {
            return i >= 0 && i <= b.f8387a.length - 1;
        }

        private int f() throws IOException {
            return this.f8390b.readByte() & 255;
        }

        private void g() throws IOException {
            ByteString b2 = b();
            b.a(b2);
            a(-1, new okhttp3.internal.http2.a(b2, b()));
        }

        private void e(int i) throws IOException {
            if (d(i)) {
                this.f8389a.add(b.f8387a[i]);
                return;
            }
            int a2 = a(i - b.f8387a.length);
            if (a2 >= 0) {
                okhttp3.internal.http2.a[] aVarArr = this.e;
                if (a2 < aVarArr.length) {
                    this.f8389a.add(aVarArr[a2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        ByteString b() throws IOException {
            int f = f();
            boolean z = (f & Commons.MSG_MCSP_INIT_SUCCESS) == 128;
            int a2 = a(f, 127);
            if (z) {
                return ByteString.of(i.b().a(this.f8390b.d(a2)));
            }
            return this.f8390b.a(a2);
        }

        private ByteString c(int i) throws IOException {
            if (d(i)) {
                return b.f8387a[i].f8384a;
            }
            int a2 = a(i - b.f8387a.length);
            if (a2 >= 0) {
                okhttp3.internal.http2.a[] aVarArr = this.e;
                if (a2 < aVarArr.length) {
                    return aVarArr[a2].f8384a;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int f = f();
                if ((f & Commons.MSG_MCSP_INIT_SUCCESS) == 0) {
                    return i2 + (f << i4);
                }
                i2 += (f & 127) << i4;
                i4 += 7;
            }
        }
    }

    /* compiled from: Hpack.java */
    /* renamed from: okhttp3.internal.http2.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0430b {

        /* renamed from: a, reason: collision with root package name */
        private final okio.c f8393a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f8394b;

        /* renamed from: c, reason: collision with root package name */
        private int f8395c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f8396d;
        int e;
        okhttp3.internal.http2.a[] f;
        int g;
        int h;
        int i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0430b(okio.c cVar) {
            this(4096, true, cVar);
        }

        private void a(okhttp3.internal.http2.a aVar) {
            int i = aVar.f8386c;
            int i2 = this.e;
            if (i > i2) {
                b();
                return;
            }
            b((this.i + i) - i2);
            int i3 = this.h + 1;
            okhttp3.internal.http2.a[] aVarArr = this.f;
            if (i3 > aVarArr.length) {
                okhttp3.internal.http2.a[] aVarArr2 = new okhttp3.internal.http2.a[aVarArr.length * 2];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.g = this.f.length - 1;
                this.f = aVarArr2;
            }
            int i4 = this.g;
            this.g = i4 - 1;
            this.f[i4] = aVar;
            this.h++;
            this.i += i;
        }

        private void b() {
            Arrays.fill(this.f, (Object) null);
            this.g = this.f.length - 1;
            this.h = 0;
            this.i = 0;
        }

        C0430b(int i, boolean z, okio.c cVar) {
            this.f8395c = Integer.MAX_VALUE;
            this.f = new okhttp3.internal.http2.a[8];
            this.g = r0.length - 1;
            this.h = 0;
            this.i = 0;
            this.e = i;
            this.f8394b = z;
            this.f8393a = cVar;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f.length;
                while (true) {
                    length--;
                    if (length < this.g || i <= 0) {
                        break;
                    }
                    okhttp3.internal.http2.a[] aVarArr = this.f;
                    i -= aVarArr[length].f8386c;
                    this.i -= aVarArr[length].f8386c;
                    this.h--;
                    i2++;
                }
                okhttp3.internal.http2.a[] aVarArr2 = this.f;
                int i3 = this.g;
                System.arraycopy(aVarArr2, i3 + 1, aVarArr2, i3 + 1 + i2, this.h);
                okhttp3.internal.http2.a[] aVarArr3 = this.f;
                int i4 = this.g;
                Arrays.fill(aVarArr3, i4 + 1, i4 + 1 + i2, (Object) null);
                this.g += i2;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<okhttp3.internal.http2.a> list) throws IOException {
            int i;
            int i2;
            if (this.f8396d) {
                int i3 = this.f8395c;
                if (i3 < this.e) {
                    a(i3, 31, 32);
                }
                this.f8396d = false;
                this.f8395c = Integer.MAX_VALUE;
                a(this.e, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                okhttp3.internal.http2.a aVar = list.get(i4);
                ByteString asciiLowercase = aVar.f8384a.toAsciiLowercase();
                ByteString byteString = aVar.f8385b;
                Integer num = b.f8388b.get(asciiLowercase);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (i > 1 && i < 8) {
                        if (okhttp3.c0.c.a(b.f8387a[i - 1].f8385b, byteString)) {
                            i2 = i;
                        } else if (okhttp3.c0.c.a(b.f8387a[i].f8385b, byteString)) {
                            i2 = i;
                            i++;
                        }
                    }
                    i2 = i;
                    i = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i == -1) {
                    int i5 = this.g + 1;
                    int length = this.f.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (okhttp3.c0.c.a(this.f[i5].f8384a, asciiLowercase)) {
                            if (okhttp3.c0.c.a(this.f[i5].f8385b, byteString)) {
                                i = b.f8387a.length + (i5 - this.g);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.g) + b.f8387a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i != -1) {
                    a(i, 127, Commons.MSG_MCSP_INIT_SUCCESS);
                } else if (i2 == -1) {
                    this.f8393a.writeByte(64);
                    a(asciiLowercase);
                    a(byteString);
                    a(aVar);
                } else if (asciiLowercase.startsWith(okhttp3.internal.http2.a.f8383d) && !okhttp3.internal.http2.a.i.equals(asciiLowercase)) {
                    a(i2, 15, 0);
                    a(byteString);
                } else {
                    a(i2, 63, 64);
                    a(byteString);
                    a(aVar);
                }
            }
        }

        void a(int i, int i2, int i3) {
            if (i < i2) {
                this.f8393a.writeByte(i | i3);
                return;
            }
            this.f8393a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f8393a.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f8393a.writeByte(i4);
        }

        void a(ByteString byteString) throws IOException {
            if (this.f8394b && i.b().a(byteString) < byteString.size()) {
                okio.c cVar = new okio.c();
                i.b().a(byteString, cVar);
                ByteString m = cVar.m();
                a(m.size(), 127, Commons.MSG_MCSP_INIT_SUCCESS);
                this.f8393a.a(m);
                return;
            }
            a(byteString.size(), 127, 0);
            this.f8393a.a(byteString);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            int min = Math.min(i, 16384);
            int i2 = this.e;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.f8395c = Math.min(this.f8395c, min);
            }
            this.f8396d = true;
            this.e = min;
            a();
        }

        private void a() {
            int i = this.e;
            int i2 = this.i;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    b(i2 - i);
                }
            }
        }
    }

    private static Map<ByteString, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f8387a.length);
        int i = 0;
        while (true) {
            okhttp3.internal.http2.a[] aVarArr = f8387a;
            if (i < aVarArr.length) {
                if (!linkedHashMap.containsKey(aVarArr[i].f8384a)) {
                    linkedHashMap.put(f8387a[i].f8384a, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    static ByteString a(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b2 = byteString.getByte(i);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
