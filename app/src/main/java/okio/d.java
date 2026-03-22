package okio;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink.java */
/* loaded from: classes.dex */
public interface d extends q, WritableByteChannel {
    c a();

    d a(String str) throws IOException;

    d c(long j) throws IOException;

    d e() throws IOException;

    @Override // okio.q, java.io.Flushable
    void flush() throws IOException;

    d write(byte[] bArr) throws IOException;

    d write(byte[] bArr, int i, int i2) throws IOException;

    d writeByte(int i) throws IOException;

    d writeInt(int i) throws IOException;

    d writeShort(int i) throws IOException;
}
