package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: Sink.java */
/* loaded from: classes.dex */
public interface q extends Closeable, Flushable {
    void a(c cVar, long j) throws IOException;

    s b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;
}
