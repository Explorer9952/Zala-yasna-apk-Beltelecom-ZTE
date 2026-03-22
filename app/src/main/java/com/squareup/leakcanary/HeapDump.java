package com.squareup.leakcanary;

import java.io.File;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class HeapDump implements Serializable {
    public final long gcDurationMs;
    public final long heapDumpDurationMs;
    public final File heapDumpFile;
    public final String referenceKey;
    public final String referenceName;
    public final long watchDurationMs;

    /* loaded from: classes.dex */
    public interface a {
    }

    public HeapDump(File file, String str, String str2, long j, long j2, long j3) {
        e.a(file, "heapDumpFile");
        this.heapDumpFile = file;
        e.a(str, "referenceKey");
        this.referenceKey = str;
        e.a(str2, "referenceName");
        this.referenceName = str2;
        this.watchDurationMs = j;
        this.gcDurationMs = j2;
        this.heapDumpDurationMs = j3;
    }

    public HeapDump renameFile(File file) {
        this.heapDumpFile.renameTo(file);
        return new HeapDump(file, this.referenceKey, this.referenceName, this.watchDurationMs, this.gcDurationMs, this.heapDumpDurationMs);
    }
}
