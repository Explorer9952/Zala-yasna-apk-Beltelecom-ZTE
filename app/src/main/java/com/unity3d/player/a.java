package com.unity3d.player;

import android.os.Build;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class a extends SSLSocketFactory {

    /* renamed from: c, reason: collision with root package name */
    private static volatile SSLSocketFactory f2989c;

    /* renamed from: d, reason: collision with root package name */
    private static final Object[] f2990d = new Object[0];
    private static final boolean e;

    /* renamed from: a, reason: collision with root package name */
    private final SSLSocketFactory f2991a;

    /* renamed from: b, reason: collision with root package name */
    private final C0091a f2992b;

    /* renamed from: com.unity3d.player.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0091a implements HandshakeCompletedListener {
        C0091a() {
        }

        @Override // javax.net.ssl.HandshakeCompletedListener
        public final void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
            String str;
            SSLSession session = handshakeCompletedEvent.getSession();
            String cipherSuite = session.getCipherSuite();
            String protocol = session.getProtocol();
            try {
                str = session.getPeerPrincipal().getName();
            } catch (SSLPeerUnverifiedException unused) {
                str = "";
            }
            c.Log(2, "Connected to " + str + " using " + protocol + " protocol and " + cipherSuite + " cipher.");
        }
    }

    static {
        boolean z = false;
        int i = Build.VERSION.SDK_INT;
        if (i >= 16 && i < 20) {
            z = true;
        }
        e = z;
    }

    private a() {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, null, null);
        this.f2991a = sSLContext.getSocketFactory();
        this.f2992b = new C0091a();
    }

    private static Socket a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket) && e) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        }
        return socket;
    }

    public static SSLSocketFactory a() {
        synchronized (f2990d) {
            if (f2989c != null) {
                return f2989c;
            }
            try {
                a aVar = new a();
                f2989c = aVar;
                return aVar;
            } catch (Exception e2) {
                c.Log(5, "CustomSSLSocketFactory: Failed to create SSLSocketFactory (" + e2.getMessage() + ")");
                return null;
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() {
        return a(this.f2991a.createSocket());
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) {
        return a(this.f2991a.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return a(this.f2991a.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) {
        return a(this.f2991a.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return a(this.f2991a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return a(this.f2991a.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.f2991a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.f2991a.getSupportedCipherSuites();
    }
}
