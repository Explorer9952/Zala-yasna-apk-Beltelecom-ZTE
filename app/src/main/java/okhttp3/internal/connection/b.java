package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.k;

/* compiled from: ConnectionSpecSelector.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<k> f8364a;

    /* renamed from: b, reason: collision with root package name */
    private int f8365b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8366c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8367d;

    public b(List<k> list) {
        this.f8364a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.f8365b; i < this.f8364a.size(); i++) {
            if (this.f8364a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public k a(SSLSocket sSLSocket) throws IOException {
        k kVar;
        int i = this.f8365b;
        int size = this.f8364a.size();
        while (true) {
            if (i >= size) {
                kVar = null;
                break;
            }
            kVar = this.f8364a.get(i);
            if (kVar.a(sSLSocket)) {
                this.f8365b = i + 1;
                break;
            }
            i++;
        }
        if (kVar != null) {
            this.f8366c = b(sSLSocket);
            okhttp3.c0.a.f8265a.a(kVar, sSLSocket, this.f8367d);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f8367d + ", modes=" + this.f8364a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean a(IOException iOException) {
        this.f8367d = true;
        if (!this.f8366c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }
}
