package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Headers.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f8517a;

    r(a aVar) {
        List<String> list = aVar.f8518a;
        this.f8517a = (String[]) list.toArray(new String[list.size()]);
    }

    static void c(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(okhttp3.c0.c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }
        throw new NullPointerException("name == null");
    }

    @Nullable
    public String a(String str) {
        return a(this.f8517a, str);
    }

    public int b() {
        return this.f8517a.length / 2;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof r) && Arrays.equals(((r) obj).f8517a, this.f8517a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f8517a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b2 = b();
        for (int i = 0; i < b2; i++) {
            sb.append(a(i));
            sb.append(": ");
            sb.append(b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* compiled from: Headers.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final List<String> f8518a = new ArrayList(20);

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                b(str.substring(0, indexOf), str.substring(indexOf + 1));
                return this;
            }
            if (str.startsWith(":")) {
                b("", str.substring(1));
                return this;
            }
            b("", str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a b(String str, String str2) {
            this.f8518a.add(str);
            this.f8518a.add(str2.trim());
            return this;
        }

        public a c(String str, String str2) {
            r.c(str);
            r.a(str2, str);
            b(str);
            b(str, str2);
            return this;
        }

        public a b(String str) {
            int i = 0;
            while (i < this.f8518a.size()) {
                if (str.equalsIgnoreCase(this.f8518a.get(i))) {
                    this.f8518a.remove(i);
                    this.f8518a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public a a(String str, String str2) {
            r.c(str);
            r.a(str2, str);
            b(str, str2);
            return this;
        }

        public r a() {
            return new r(this);
        }
    }

    public String a(int i) {
        return this.f8517a[i * 2];
    }

    public String b(int i) {
        return this.f8517a[(i * 2) + 1];
    }

    public a a() {
        a aVar = new a();
        Collections.addAll(aVar.f8518a, this.f8517a);
        return aVar;
    }

    public List<String> b(String str) {
        int b2 = b();
        ArrayList arrayList = null;
        for (int i = 0; i < b2; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    static void a(String str, String str2) {
        if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                    throw new IllegalArgumentException(okhttp3.c0.c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }
}
