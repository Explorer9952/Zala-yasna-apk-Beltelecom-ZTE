package pl.droidsonroids.gif;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: classes2.dex */
public class GifIOException extends IOException {
    private static final long serialVersionUID = 13038402904505L;
    public final GifError reason;

    private GifIOException(GifError gifError) {
        super(gifError.getFormattedDescription());
        this.reason = gifError;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifIOException fromCode(int i) {
        if (i == GifError.NO_ERROR.errorCode) {
            return null;
        }
        return new GifIOException(i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(GifIOException.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(GifIOException.class.getName(), "writeObject");
    }

    GifIOException(int i) {
        this(GifError.fromCode(i));
    }
}
