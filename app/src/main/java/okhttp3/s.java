package okhttp3;

import com.video.androidsdk.common.http.HttpConstant;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: HttpUrl.java */
/* loaded from: classes.dex */
public final class s {
    private static final char[] i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    final String f8519a;

    /* renamed from: b, reason: collision with root package name */
    private final String f8520b;

    /* renamed from: c, reason: collision with root package name */
    private final String f8521c;

    /* renamed from: d, reason: collision with root package name */
    final String f8522d;
    final int e;

    @Nullable
    private final List<String> f;

    @Nullable
    private final String g;
    private final String h;

    /* compiled from: HttpUrl.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        String f8523a;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        String f8526d;
        final List<String> f;

        @Nullable
        List<String> g;

        @Nullable
        String h;

        /* renamed from: b, reason: collision with root package name */
        String f8524b = "";

        /* renamed from: c, reason: collision with root package name */
        String f8525c = "";
        int e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public a a(int i) {
            if (i > 0 && i <= 65535) {
                this.e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        public a b(String str) {
            if (str != null) {
                String a2 = a(str, 0, str.length());
                if (a2 != null) {
                    this.f8526d = a2;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        public a c(String str) {
            if (str != null) {
                this.f8525c = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public a d(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase(HttpConstant.PROTOCOL_HTTP)) {
                    this.f8523a = HttpConstant.PROTOCOL_HTTP;
                } else if (str.equalsIgnoreCase(HttpConstant.PROTOCOL_HTTPS)) {
                    this.f8523a = HttpConstant.PROTOCOL_HTTPS;
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public a e(String str) {
            if (str != null) {
                this.f8524b = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f8523a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f8524b.isEmpty() || !this.f8525c.isEmpty()) {
                sb.append(this.f8524b);
                if (!this.f8525c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f8525c);
                }
                sb.append('@');
            }
            String str2 = this.f8526d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f8526d);
                    sb.append(']');
                } else {
                    sb.append(this.f8526d);
                }
            }
            if (this.e != -1 || this.f8523a != null) {
                int b2 = b();
                String str3 = this.f8523a;
                if (str3 == null || b2 != s.c(str3)) {
                    sb.append(':');
                    sb.append(b2);
                }
            }
            s.b(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                s.a(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        private static int f(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int e(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public a a(@Nullable String str) {
            this.g = str != null ? s.e(s.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        a c() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, s.a(this.f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, s.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = s.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        int b() {
            int i = this.e;
            return i != -1 ? i : s.c(this.f8523a);
        }

        private static int b(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(s.a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        public s a() {
            if (this.f8523a != null) {
                if (this.f8526d != null) {
                    return new s(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        private void d(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt != '/' && charAt != '\\') {
                List<String> list = this.f;
                list.set(list.size() - 1, "");
            } else {
                this.f.clear();
                this.f.add("");
                i++;
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = okhttp3.c0.c.a(str, i3, i2, "/\\");
                boolean z = i < i2;
                a(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        a a(@Nullable s sVar, String str) {
            int a2;
            int i;
            int b2 = okhttp3.c0.c.b(str, 0, str.length());
            int c2 = okhttp3.c0.c.c(str, b2, str.length());
            int e = e(str, b2, c2);
            if (e != -1) {
                if (str.regionMatches(true, b2, "https:", 0, 6)) {
                    this.f8523a = HttpConstant.PROTOCOL_HTTPS;
                    b2 += 6;
                } else if (str.regionMatches(true, b2, "http:", 0, 5)) {
                    this.f8523a = HttpConstant.PROTOCOL_HTTP;
                    b2 += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, e) + "'");
                }
            } else if (sVar != null) {
                this.f8523a = sVar.f8519a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int f = f(str, b2, c2);
            char c3 = '?';
            char c4 = '#';
            if (f < 2 && sVar != null && sVar.f8519a.equals(this.f8523a)) {
                this.f8524b = sVar.f();
                this.f8525c = sVar.b();
                this.f8526d = sVar.f8522d;
                this.e = sVar.e;
                this.f.clear();
                this.f.addAll(sVar.d());
                if (b2 == c2 || str.charAt(b2) == '#') {
                    a(sVar.e());
                }
            } else {
                int i2 = b2 + f;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a2 = okhttp3.c0.c.a(str, i2, c2, "@/\\?#");
                    char charAt = a2 != c2 ? str.charAt(a2) : (char) 65535;
                    if (charAt == 65535 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int a3 = okhttp3.c0.c.a(str, i2, a2, ':');
                            i = a2;
                            String a4 = s.a(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a4 = this.f8524b + "%40" + a4;
                            }
                            this.f8524b = a4;
                            if (a3 != i) {
                                this.f8525c = s.a(str, a3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = a2;
                            this.f8525c += "%40" + s.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                    }
                    c3 = '?';
                    c4 = '#';
                }
                int c5 = c(str, i2, a2);
                int i3 = c5 + 1;
                if (i3 < a2) {
                    this.f8526d = a(str, i2, c5);
                    int b3 = b(str, i3, a2);
                    this.e = b3;
                    if (b3 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, a2) + '\"');
                    }
                } else {
                    this.f8526d = a(str, i2, c5);
                    this.e = s.c(this.f8523a);
                }
                if (this.f8526d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, c5) + '\"');
                }
                b2 = a2;
            }
            int a5 = okhttp3.c0.c.a(str, b2, c2, "?#");
            d(str, b2, a5);
            if (a5 < c2 && str.charAt(a5) == '?') {
                int a6 = okhttp3.c0.c.a(str, a5, c2, '#');
                this.g = s.e(s.a(str, a5 + 1, a6, " \"'<>#", true, false, true, true, null));
                a5 = a6;
            }
            if (a5 < c2 && str.charAt(a5) == '#') {
                this.h = s.a(str, 1 + a5, c2, "", true, false, false, false, null);
            }
            return this;
        }

        private void d() {
            if (this.f.remove(r0.size() - 1).isEmpty() && !this.f.isEmpty()) {
                this.f.set(r0.size() - 1, "");
            } else {
                this.f.add("");
            }
        }

        private static int c(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt != '[') {
                    i++;
                }
                do {
                    i++;
                    if (i < i2) {
                    }
                    i++;
                } while (str.charAt(i) != ']');
                i++;
            }
            return i2;
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a2 = s.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (f(a2)) {
                return;
            }
            if (g(a2)) {
                d();
                return;
            }
            if (this.f.get(r11.size() - 1).isEmpty()) {
                this.f.set(r11.size() - 1, a2);
            } else {
                this.f.add(a2);
            }
            if (z) {
                this.f.add("");
            }
        }

        private static String a(String str, int i, int i2) {
            return okhttp3.c0.c.a(s.a(str, i, i2, false));
        }
    }

    s(a aVar) {
        this.f8519a = aVar.f8523a;
        this.f8520b = a(aVar.f8524b, false);
        this.f8521c = a(aVar.f8525c, false);
        this.f8522d = aVar.f8526d;
        this.e = aVar.b();
        a(aVar.f, false);
        List<String> list = aVar.g;
        this.f = list != null ? a(list, true) : null;
        String str = aVar.h;
        this.g = str != null ? a(str, false) : null;
        this.h = aVar.toString();
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static int c(String str) {
        if (str.equals(HttpConstant.PROTOCOL_HTTP)) {
            return 80;
        }
        return str.equals(HttpConstant.PROTOCOL_HTTPS) ? 443 : -1;
    }

    public String b() {
        if (this.f8521c.isEmpty()) {
            return "";
        }
        return this.h.substring(this.h.indexOf(58, this.f8519a.length() + 3) + 1, this.h.indexOf(64));
    }

    public List<String> d() {
        int indexOf = this.h.indexOf(47, this.f8519a.length() + 3);
        String str = this.h;
        int a2 = okhttp3.c0.c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = okhttp3.c0.c.a(this.h, i2, a2, '/');
            arrayList.add(this.h.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    @Nullable
    public String e() {
        if (this.f == null) {
            return null;
        }
        int indexOf = this.h.indexOf(63) + 1;
        String str = this.h;
        return this.h.substring(indexOf, okhttp3.c0.c.a(str, indexOf, str.length(), '#'));
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof s) && ((s) obj).h.equals(this.h);
    }

    public String f() {
        if (this.f8520b.isEmpty()) {
            return "";
        }
        int length = this.f8519a.length() + 3;
        String str = this.h;
        return this.h.substring(length, okhttp3.c0.c.a(str, length, str.length(), ":@"));
    }

    public String g() {
        return this.f8522d;
    }

    public boolean h() {
        return this.f8519a.equals(HttpConstant.PROTOCOL_HTTPS);
    }

    public int hashCode() {
        return this.h.hashCode();
    }

    public a i() {
        a aVar = new a();
        aVar.f8523a = this.f8519a;
        aVar.f8524b = f();
        aVar.f8525c = b();
        aVar.f8526d = this.f8522d;
        aVar.e = this.e != c(this.f8519a) ? this.e : -1;
        aVar.f.clear();
        aVar.f.addAll(d());
        aVar.a(e());
        aVar.h = a();
        return aVar;
    }

    public int j() {
        return this.e;
    }

    @Nullable
    public String k() {
        if (this.f == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(sb, this.f);
        return sb.toString();
    }

    public String l() {
        a a2 = a("/...");
        a2.e("");
        a2.c("");
        return a2.a().toString();
    }

    public String m() {
        return this.f8519a;
    }

    public URI n() {
        a i2 = i();
        i2.c();
        String aVar = i2.toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String toString() {
        return this.h;
    }

    public String c() {
        int indexOf = this.h.indexOf(47, this.f8519a.length() + 3);
        String str = this.h;
        return this.h.substring(indexOf, okhttp3.c0.c.a(str, indexOf, str.length(), "?#"));
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    static List<String> e(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add(null);
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public static s d(String str) {
        a aVar = new a();
        aVar.a(null, str);
        return aVar.a();
    }

    @Nullable
    public String a() {
        if (this.g == null) {
            return null;
        }
        return this.h.substring(this.h.indexOf(35) + 1);
    }

    @Nullable
    public s b(String str) {
        a a2 = a(str);
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    @Nullable
    public a a(String str) {
        try {
            a aVar = new a();
            aVar.a(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                okio.c cVar = new okio.c();
                cVar.a(str, i2, i4);
                a(cVar, str, i4, i3, z);
                return cVar.n();
            }
        }
        return str.substring(i2, i3);
    }

    static void a(okio.c cVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int a2 = okhttp3.c0.c.a(str.charAt(i2 + 1));
                int a3 = okhttp3.c0.c.a(str.charAt(i4));
                if (a2 != -1 && a3 != -1) {
                    cVar.writeByte((a2 << 4) + a3);
                    i2 = i4;
                }
                cVar.c(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    cVar.writeByte(32);
                }
                cVar.c(codePointAt);
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && okhttp3.c0.c.a(str.charAt(i2 + 1)) != -1 && okhttp3.c0.c.a(str.charAt(i4)) != -1;
    }

    static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            okio.c cVar = new okio.c();
            cVar.a(str, i2, i4);
            a(cVar, str, i4, i3, str2, z, z2, z3, z4, charset);
            return cVar.n();
        }
        return str.substring(i2, i3);
    }

    static void a(okio.c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        okio.c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.a(z ? "+" : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || a(str, i2, i3)))))) {
                    cVar.c(codePointAt);
                } else {
                    if (cVar2 == null) {
                        cVar2 = new okio.c();
                    }
                    if (charset != null && !charset.equals(okhttp3.c0.c.i)) {
                        cVar2.a(str, i2, Character.charCount(codePointAt) + i2, charset);
                    } else {
                        cVar2.c(codePointAt);
                    }
                    while (!cVar2.d()) {
                        int readByte = cVar2.readByte() & 255;
                        cVar.writeByte(37);
                        cVar.writeByte((int) i[(readByte >> 4) & 15]);
                        cVar.writeByte((int) i[readByte & 15]);
                    }
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
