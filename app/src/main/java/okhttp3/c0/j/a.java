package okhttp3.c0.j;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: BasicCertificateChainCleaner.java */
/* loaded from: classes2.dex */
public final class a extends c {

    /* renamed from: a, reason: collision with root package name */
    private final e f8340a;

    public a(e eVar) {
        this.f8340a = eVar;
    }

    @Override // okhttp3.c0.j.c
    public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate a2 = this.f8340a.a(x509Certificate);
            if (a2 != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(a2)) {
                    arrayList.add(a2);
                }
                if (a(a2, a2)) {
                    return arrayList;
                }
                z = true;
            } else {
                Iterator it2 = arrayDeque.iterator();
                while (it2.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it2.next();
                    if (a(x509Certificate, x509Certificate2)) {
                        it2.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && ((a) obj).f8340a.equals(this.f8340a);
    }

    public int hashCode() {
        return this.f8340a.hashCode();
    }

    private boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
