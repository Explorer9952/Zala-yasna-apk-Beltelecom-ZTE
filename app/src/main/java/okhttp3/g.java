package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* compiled from: CertificatePinner.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final g f8351c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final Set<b> f8352a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final okhttp3.c0.j.c f8353b;

    /* compiled from: CertificatePinner.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<b> f8354a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.f8354a), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CertificatePinner.java */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final String f8355a;

        /* renamed from: b, reason: collision with root package name */
        final String f8356b;

        /* renamed from: c, reason: collision with root package name */
        final String f8357c;

        /* renamed from: d, reason: collision with root package name */
        final ByteString f8358d;

        boolean a(String str) {
            if (this.f8355a.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.f8356b.length()) {
                    String str2 = this.f8356b;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.f8356b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f8355a.equals(bVar.f8355a) && this.f8357c.equals(bVar.f8357c) && this.f8358d.equals(bVar.f8358d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f8355a.hashCode()) * 31) + this.f8357c.hashCode()) * 31) + this.f8358d.hashCode();
        }

        public String toString() {
            return this.f8357c + this.f8358d.base64();
        }
    }

    g(Set<b> set, @Nullable okhttp3.c0.j.c cVar) {
        this.f8352a = set;
        this.f8353b = cVar;
    }

    static ByteString b(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> a2 = a(str);
        if (a2.isEmpty()) {
            return;
        }
        okhttp3.c0.j.c cVar = this.f8353b;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = a2.size();
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                b bVar = a2.get(i2);
                if (bVar.f8357c.equals("sha256/")) {
                    if (byteString == null) {
                        byteString = b(x509Certificate);
                    }
                    if (bVar.f8358d.equals(byteString)) {
                        return;
                    }
                } else if (bVar.f8357c.equals("sha1/")) {
                    if (byteString2 == null) {
                        byteString2 = a(x509Certificate);
                    }
                    if (bVar.f8358d.equals(byteString2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + bVar.f8357c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = a2.size();
        for (int i4 = 0; i4 < size4; i4++) {
            b bVar2 = a2.get(i4);
            sb.append("\n    ");
            sb.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (okhttp3.c0.c.a(this.f8353b, gVar.f8353b) && this.f8352a.equals(gVar.f8352a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        okhttp3.c0.j.c cVar = this.f8353b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f8352a.hashCode();
    }

    List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f8352a) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g a(@Nullable okhttp3.c0.j.c cVar) {
        return okhttp3.c0.c.a(this.f8353b, cVar) ? this : new g(this.f8352a, cVar);
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString a(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }
}
