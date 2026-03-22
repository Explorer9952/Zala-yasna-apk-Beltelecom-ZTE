package okio;

import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSource.java */
/* loaded from: classes.dex */
public interface e extends r, ReadableByteChannel {
    long a(byte b2) throws IOException;

    String a(Charset charset) throws IOException;

    ByteString a(long j) throws IOException;

    c a();

    boolean a(long j, ByteString byteString) throws IOException;

    String b(long j) throws IOException;

    byte[] c() throws IOException;

    boolean d() throws IOException;

    byte[] d(long j) throws IOException;

    void e(long j) throws IOException;

    String f() throws IOException;

    int h() throws IOException;

    short i() throws IOException;

    long j() throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    boolean request(long j) throws IOException;

    void skip(long j) throws IOException;
}
