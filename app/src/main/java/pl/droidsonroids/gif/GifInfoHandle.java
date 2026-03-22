package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.Surface;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class GifInfoHandle {
    static final GifInfoHandle NULL_INFO = new GifInfoHandle(0, 0, 0, 0);
    final int frameCount;
    private volatile long gifInfoPtr;
    final int height;
    final int width;

    static {
        System.loadLibrary("pl_droidsonroids_gif");
    }

    private GifInfoHandle(long j, int i, int i2, int i3) {
        this.gifInfoPtr = j;
        this.width = i;
        this.height = i2;
        this.frameCount = i3;
    }

    private static native void bindSurface(long j, Surface surface, long[] jArr, boolean z);

    private static native void free(long j);

    private static native long getAllocationByteCount(long j);

    private static native String getComment(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getFrameDuration(long j, int i);

    private static native int getLoopCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native long[] getSavedState(long j);

    private static native long getSourceLength(long j);

    private static native boolean isAnimationCompleted(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifInfoHandle openAssetFileDescriptor(AssetFileDescriptor assetFileDescriptor, boolean z) throws IOException {
        try {
            return openFd(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), z);
        } finally {
            assetFileDescriptor.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native GifInfoHandle openByteArray(byte[] bArr, boolean z) throws GifIOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native GifInfoHandle openDirectByteBuffer(ByteBuffer byteBuffer, boolean z) throws GifIOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native GifInfoHandle openFd(FileDescriptor fileDescriptor, long j, boolean z) throws GifIOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native GifInfoHandle openFile(String str, boolean z) throws GifIOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifInfoHandle openMarkableInputStream(InputStream inputStream, boolean z) throws GifIOException {
        if (inputStream.markSupported()) {
            return openStream(inputStream, z);
        }
        throw new IllegalArgumentException("InputStream does not support marking");
    }

    static native GifInfoHandle openStream(InputStream inputStream, boolean z) throws GifIOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifInfoHandle openUri(ContentResolver contentResolver, Uri uri, boolean z) throws IOException {
        if (ParamConst.CHANNEL_PREVUE_INFO_RSP_FILENAME.equals(uri.getScheme())) {
            return openFile(uri.getPath(), z);
        }
        return openAssetFileDescriptor(contentResolver.openAssetFileDescriptor(uri, "r"), z);
    }

    private static native void postUnbindSurface(long j);

    private static native long renderFrame(long j, Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToFrame(long j, int i, Bitmap bitmap);

    private static native void seekToTime(long j, int i, Bitmap bitmap);

    private static native void setLoopCount(long j, int i);

    private static native void setSpeedFactor(long j, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bindSurface(Surface surface, long[] jArr, boolean z) {
        bindSurface(this.gifInfoPtr, surface, jArr, z);
    }

    protected void finalize() throws Throwable {
        try {
            recycle();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getAllocationByteCount() {
        return getAllocationByteCount(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String getComment() {
        return getComment(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getCurrentFrameIndex() {
        return getCurrentFrameIndex(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getCurrentLoop() {
        return getCurrentLoop(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getCurrentPosition() {
        return getCurrentPosition(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getDuration() {
        return getDuration(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getFrameDuration(int i) {
        if (i >= 0) {
            if (i < this.frameCount) {
            }
        }
        throw new IndexOutOfBoundsException("Frame index is out of bounds");
        return getFrameDuration(this.gifInfoPtr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getLoopCount() {
        return getLoopCount(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getNativeErrorCode() {
        return getNativeErrorCode(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long[] getSavedState() {
        return getSavedState(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getSourceLength() {
        return getSourceLength(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isAnimationCompleted() {
        return isAnimationCompleted(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isRecycled() {
        return this.gifInfoPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void postUnbindSurface() {
        postUnbindSurface(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void recycle() {
        free(this.gifInfoPtr);
        this.gifInfoPtr = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long renderFrame(Bitmap bitmap) {
        return renderFrame(this.gifInfoPtr, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean reset() {
        return reset(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long restoreRemainder() {
        return restoreRemainder(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int restoreSavedState(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.gifInfoPtr, jArr, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void saveRemainder() {
        saveRemainder(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void seekToFrame(int i, Bitmap bitmap) {
        seekToFrame(this.gifInfoPtr, i, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void seekToTime(int i, Bitmap bitmap) {
        seekToTime(this.gifInfoPtr, i, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoopCount(int i) {
        if (i >= 0 && i <= 65535) {
            synchronized (this) {
                setLoopCount(this.gifInfoPtr, i);
            }
            return;
        }
        throw new IllegalArgumentException("Loop count of range <0, 65535>");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSpeedFactor(float f) {
        if (f > 0.0f && !Float.isNaN(f)) {
            if (f < 4.656613E-10f) {
                f = 4.656613E-10f;
            }
            synchronized (this) {
                setSpeedFactor(this.gifInfoPtr, f);
            }
            return;
        }
        throw new IllegalArgumentException("Speed factor is not positive");
    }
}
