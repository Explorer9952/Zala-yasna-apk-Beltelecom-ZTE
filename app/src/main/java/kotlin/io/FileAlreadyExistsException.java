package kotlin.io;

import com.video.androidsdk.service.comm.ParamConst;
import java.io.File;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public final class FileAlreadyExistsException extends FileSystemException {
    public /* synthetic */ FileAlreadyExistsException(File file, File file2, String str, int i, d dVar) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileAlreadyExistsException(@NotNull File file, @Nullable File file2, @Nullable String str) {
        super(file, file2, str);
        f.b(file, ParamConst.CHANNEL_PREVUE_INFO_RSP_FILENAME);
    }
}
