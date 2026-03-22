package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: Handshake.java */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final TlsVersion f8513a;

    /* renamed from: b, reason: collision with root package name */
    private final h f8514b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Certificate> f8515c;

    /* renamed from: d, reason: collision with root package name */
    private final List<Certificate> f8516d;

    private q(TlsVersion tlsVersion, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f8513a = tlsVersion;
        this.f8514b = hVar;
        this.f8515c = list;
        this.f8516d = list2;
    }

    public static q a(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
                h a2 = h.a(cipherSuite);
                String protocol = sSLSession.getProtocol();
                if (protocol != null) {
                    if (!"NONE".equals(protocol)) {
                        TlsVersion forJavaName = TlsVersion.forJavaName(protocol);
                        try {
                            certificateArr = sSLSession.getPeerCertificates();
                        } catch (SSLPeerUnverifiedException unused) {
                            certificateArr = null;
                        }
                        if (certificateArr != null) {
                            emptyList = okhttp3.c0.c.a(certificateArr);
                        } else {
                            emptyList = Collections.emptyList();
                        }
                        Certificate[] localCertificates = sSLSession.getLocalCertificates();
                        if (localCertificates != null) {
                            emptyList2 = okhttp3.c0.c.a(localCertificates);
                        } else {
                            emptyList2 = Collections.emptyList();
                        }
                        return new q(forJavaName, a2, emptyList, emptyList2);
                    }
                    throw new IOException("tlsVersion == NONE");
                }
                throw new IllegalStateException("tlsVersion == null");
            }
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public List<Certificate> b() {
        return this.f8515c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f8513a.equals(qVar.f8513a) && this.f8514b.equals(qVar.f8514b) && this.f8515c.equals(qVar.f8515c) && this.f8516d.equals(qVar.f8516d);
    }

    public int hashCode() {
        return ((((((527 + this.f8513a.hashCode()) * 31) + this.f8514b.hashCode()) * 31) + this.f8515c.hashCode()) * 31) + this.f8516d.hashCode();
    }

    public h a() {
        return this.f8514b;
    }
}
