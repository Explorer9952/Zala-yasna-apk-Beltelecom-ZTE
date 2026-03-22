package okio;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Source.java */
/* loaded from: classes.dex */
public interface r extends Closeable {
    long b(c cVar, long j) throws IOException;

    s b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
