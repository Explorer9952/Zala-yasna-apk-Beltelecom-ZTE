package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public class FileSystemException extends IOException {

    @NotNull
    private final File file;

    @Nullable
    private final File other;

    @Nullable
    private final String reason;

    public /* synthetic */ FileSystemException(File file, File file2, String str, int i, d dVar) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    @NotNull
    public final File getFile() {
        return this.file;
    }

    @Nullable
    public final File getOther() {
        return this.other;
    }

    @Nullable
    public final String getReason() {
        return this.reason;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FileSystemException(@org.jetbrains.annotations.NotNull java.io.File r2, @org.jetbrains.annotations.Nullable java.io.File r3, @org.jetbrains.annotations.Nullable java.lang.String r4) {
        /*
            r1 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.f.b(r2, r0)
            java.lang.String r0 = kotlin.io.b.a(r2, r3, r4)
            r1.<init>(r0)
            r1.file = r2
            r1.other = r3
            r1.reason = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileSystemException.<init>(java.io.File, java.io.File, java.lang.String):void");
    }
}
