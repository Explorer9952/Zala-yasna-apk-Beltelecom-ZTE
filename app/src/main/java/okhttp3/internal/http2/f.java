package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.b;
import okio.ByteString;
import okio.r;
import okio.s;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Http2Reader.java */
/* loaded from: classes2.dex */
public final class f implements Closeable {
    static final Logger e = Logger.getLogger(c.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final okio.e f8445a;

    /* renamed from: b, reason: collision with root package name */
    private final a f8446b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f8447c;

    /* renamed from: d, reason: collision with root package name */
    final b.a f8448d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<okhttp3.internal.http2.a> list) throws IOException;

        void a(int i, long j);

        void a(int i, ErrorCode errorCode);

        void a(int i, ErrorCode errorCode, ByteString byteString);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, int i2, List<okhttp3.internal.http2.a> list);

        void a(boolean z, int i, okio.e eVar, int i2) throws IOException;

        void a(boolean z, k kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(okio.e eVar, boolean z) {
        this.f8445a = eVar;
        this.f8447c = z;
        a aVar = new a(eVar);
        this.f8446b = aVar;
        this.f8448d = new b.a(4096, aVar);
    }

    private void b(b bVar, int i, byte b2, int i2) throws IOException {
        if (i < 8) {
            c.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 == 0) {
            int readInt = this.f8445a.readInt();
            int readInt2 = this.f8445a.readInt();
            int i3 = i - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
            if (fromHttp2 == null) {
                c.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
                throw null;
            }
            ByteString byteString = ByteString.EMPTY;
            if (i3 > 0) {
                byteString = this.f8445a.a(i3);
            }
            bVar.a(readInt, fromHttp2, byteString);
            return;
        }
        c.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        throw null;
    }

    private void c(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            boolean z = (b2 & 1) != 0;
            short readByte = (b2 & 8) != 0 ? (short) (this.f8445a.readByte() & 255) : (short) 0;
            if ((b2 & 32) != 0) {
                a(bVar, i2);
                i -= 5;
            }
            bVar.a(z, i2, -1, a(a(i, b2, readByte), readByte, b2, i2));
            return;
        }
        c.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    private void d(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 8) {
            c.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 == 0) {
            bVar.a((b2 & 1) != 0, this.f8445a.readInt(), this.f8445a.readInt());
            return;
        }
        c.b("TYPE_PING streamId != 0", new Object[0]);
        throw null;
    }

    private void e(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 5) {
            c.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            a(bVar, i2);
        } else {
            c.b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void f(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            short readByte = (b2 & 8) != 0 ? (short) (this.f8445a.readByte() & 255) : (short) 0;
            bVar.a(i2, this.f8445a.readInt() & Integer.MAX_VALUE, a(a(i - 4, b2, readByte), readByte, b2, i2));
        } else {
            c.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void g(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            c.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            int readInt = this.f8445a.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 != null) {
                bVar.a(i2, fromHttp2);
                return;
            } else {
                c.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                throw null;
            }
        }
        c.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        throw null;
    }

    private void h(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            c.b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        }
        if ((b2 & 1) != 0) {
            if (i == 0) {
                bVar.a();
                return;
            } else {
                c.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        }
        if (i % 6 != 0) {
            c.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        }
        k kVar = new k();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int readShort = this.f8445a.readShort() & 65535;
            int readInt = this.f8445a.readInt();
            if (readShort != 2) {
                if (readShort == 3) {
                    readShort = 4;
                } else if (readShort == 4) {
                    readShort = 7;
                    if (readInt < 0) {
                        c.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        throw null;
                    }
                } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                    c.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                    throw null;
                }
            } else if (readInt != 0 && readInt != 1) {
                c.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                throw null;
            }
            kVar.a(readShort, readInt);
        }
        bVar.a(false, kVar);
    }

    private void i(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            c.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            throw null;
        }
        long readInt = this.f8445a.readInt() & 2147483647L;
        if (readInt != 0) {
            bVar.a(i2, readInt);
        } else {
            c.b("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
    }

    public void a(b bVar) throws IOException {
        if (this.f8447c) {
            if (a(true, bVar)) {
                return;
            }
            c.b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        ByteString a2 = this.f8445a.a(c.f8397a.size());
        if (e.isLoggable(Level.FINE)) {
            e.fine(okhttp3.c0.c.a("<< CONNECTION %s", a2.hex()));
        }
        if (c.f8397a.equals(a2)) {
            return;
        }
        c.b("Expected a connection header but was %s", a2.utf8());
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8445a.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Reader.java */
    /* loaded from: classes2.dex */
    public static final class a implements r {

        /* renamed from: a, reason: collision with root package name */
        private final okio.e f8449a;

        /* renamed from: b, reason: collision with root package name */
        int f8450b;

        /* renamed from: c, reason: collision with root package name */
        byte f8451c;

        /* renamed from: d, reason: collision with root package name */
        int f8452d;
        int e;
        short f;

        a(okio.e eVar) {
            this.f8449a = eVar;
        }

        private void g() throws IOException {
            int i = this.f8452d;
            int a2 = f.a(this.f8449a);
            this.e = a2;
            this.f8450b = a2;
            byte readByte = (byte) (this.f8449a.readByte() & 255);
            this.f8451c = (byte) (this.f8449a.readByte() & 255);
            if (f.e.isLoggable(Level.FINE)) {
                f.e.fine(c.a(true, this.f8452d, this.f8450b, readByte, this.f8451c));
            }
            int readInt = this.f8449a.readInt() & Integer.MAX_VALUE;
            this.f8452d = readInt;
            if (readByte != 9) {
                c.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            }
            if (readInt == i) {
                return;
            }
            c.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }

        @Override // okio.r
        public long b(okio.c cVar, long j) throws IOException {
            while (true) {
                int i = this.e;
                if (i == 0) {
                    this.f8449a.skip(this.f);
                    this.f = (short) 0;
                    if ((this.f8451c & 4) != 0) {
                        return -1L;
                    }
                    g();
                } else {
                    long b2 = this.f8449a.b(cVar, Math.min(j, i));
                    if (b2 == -1) {
                        return -1L;
                    }
                    this.e = (int) (this.e - b2);
                    return b2;
                }
            }
        }

        @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.r
        public s b() {
            return this.f8449a.b();
        }
    }

    public boolean a(boolean z, b bVar) throws IOException {
        try {
            this.f8445a.e(9L);
            int a2 = a(this.f8445a);
            if (a2 < 0 || a2 > 16384) {
                c.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
                throw null;
            }
            byte readByte = (byte) (this.f8445a.readByte() & 255);
            if (z && readByte != 4) {
                c.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                throw null;
            }
            byte readByte2 = (byte) (this.f8445a.readByte() & 255);
            int readInt = this.f8445a.readInt() & Integer.MAX_VALUE;
            if (e.isLoggable(Level.FINE)) {
                e.fine(c.a(true, readInt, a2, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    a(bVar, a2, readByte2, readInt);
                    return true;
                case 1:
                    c(bVar, a2, readByte2, readInt);
                    return true;
                case 2:
                    e(bVar, a2, readByte2, readInt);
                    return true;
                case 3:
                    g(bVar, a2, readByte2, readInt);
                    return true;
                case 4:
                    h(bVar, a2, readByte2, readInt);
                    return true;
                case 5:
                    f(bVar, a2, readByte2, readInt);
                    return true;
                case 6:
                    d(bVar, a2, readByte2, readInt);
                    return true;
                case 7:
                    b(bVar, a2, readByte2, readInt);
                    return true;
                case 8:
                    i(bVar, a2, readByte2, readInt);
                    return true;
                default:
                    this.f8445a.skip(a2);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private List<okhttp3.internal.http2.a> a(int i, short s, byte b2, int i2) throws IOException {
        a aVar = this.f8446b;
        aVar.e = i;
        aVar.f8450b = i;
        aVar.f = s;
        aVar.f8451c = b2;
        aVar.f8452d = i2;
        this.f8448d.c();
        return this.f8448d.a();
    }

    private void a(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            c.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b2 & 1) != 0;
        if (!((b2 & 32) != 0)) {
            short readByte = (b2 & 8) != 0 ? (short) (this.f8445a.readByte() & 255) : (short) 0;
            bVar.a(z, i2, this.f8445a, a(i, b2, readByte));
            this.f8445a.skip(readByte);
            return;
        }
        c.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        throw null;
    }

    private void a(b bVar, int i) throws IOException {
        int readInt = this.f8445a.readInt();
        bVar.a(i, readInt & Integer.MAX_VALUE, (this.f8445a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    static int a(okio.e eVar) throws IOException {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    static int a(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        c.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }
}
