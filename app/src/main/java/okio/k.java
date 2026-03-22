package okio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: Okio.java */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f8584a = Logger.getLogger(k.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Okio.java */
    /* loaded from: classes2.dex */
    public final class a implements q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f8585a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OutputStream f8586b;

        a(s sVar, OutputStream outputStream) {
            this.f8585a = sVar;
            this.f8586b = outputStream;
        }

        @Override // okio.q
        public void a(okio.c cVar, long j) throws IOException {
            t.a(cVar.f8573b, 0L, j);
            while (j > 0) {
                this.f8585a.e();
                n nVar = cVar.f8572a;
                int min = (int) Math.min(j, nVar.f8597c - nVar.f8596b);
                this.f8586b.write(nVar.f8595a, nVar.f8596b, min);
                int i = nVar.f8596b + min;
                nVar.f8596b = i;
                long j2 = min;
                j -= j2;
                cVar.f8573b -= j2;
                if (i == nVar.f8597c) {
                    cVar.f8572a = nVar.b();
                    o.a(nVar);
                }
            }
        }

        @Override // okio.q
        public s b() {
            return this.f8585a;
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f8586b.close();
        }

        @Override // okio.q, java.io.Flushable
        public void flush() throws IOException {
            this.f8586b.flush();
        }

        public String toString() {
            return "sink(" + this.f8586b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Okio.java */
    /* loaded from: classes.dex */
    public final class c extends okio.a {
        final /* synthetic */ Socket k;

        c(Socket socket) {
            this.k = socket;
        }

        @Override // okio.a
        protected IOException b(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.a
        protected void i() {
            try {
                this.k.close();
            } catch (AssertionError e) {
                if (k.a(e)) {
                    k.f8584a.log(Level.WARNING, "Failed to close timed out socket " + this.k, (Throwable) e);
                    return;
                }
                throw e;
            } catch (Exception e2) {
                k.f8584a.log(Level.WARNING, "Failed to close timed out socket " + this.k, (Throwable) e2);
            }
        }
    }

    private k() {
    }

    public static e a(r rVar) {
        return new m(rVar);
    }

    public static r b(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                okio.a c2 = c(socket);
                return c2.a(a(socket.getInputStream(), c2));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static okio.a c(Socket socket) {
        return new c(socket);
    }

    public static d a(q qVar) {
        return new l(qVar);
    }

    private static q a(OutputStream outputStream, s sVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (sVar != null) {
            return new a(sVar, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static q a(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                okio.a c2 = c(socket);
                return c2.a(a(socket.getOutputStream(), c2));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Okio.java */
    /* loaded from: classes2.dex */
    public final class b implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f8587a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ InputStream f8588b;

        b(s sVar, InputStream inputStream) {
            this.f8587a = sVar;
            this.f8588b = inputStream;
        }

        @Override // okio.r
        public long b(okio.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (j == 0) {
                return 0L;
            }
            try {
                this.f8587a.e();
                n b2 = cVar.b(1);
                int read = this.f8588b.read(b2.f8595a, b2.f8597c, (int) Math.min(j, 8192 - b2.f8597c));
                if (read == -1) {
                    return -1L;
                }
                b2.f8597c += read;
                long j2 = read;
                cVar.f8573b += j2;
                return j2;
            } catch (AssertionError e) {
                if (k.a(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }

        @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f8588b.close();
        }

        public String toString() {
            return "source(" + this.f8588b + ")";
        }

        @Override // okio.r
        public s b() {
            return this.f8587a;
        }
    }

    public static r a(InputStream inputStream) {
        return a(inputStream, new s());
    }

    private static r a(InputStream inputStream, s sVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (sVar != null) {
            return new b(sVar, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
