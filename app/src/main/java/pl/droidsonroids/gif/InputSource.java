package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes2.dex */
public abstract class InputSource {
    private boolean mIsOpaque;

    /* loaded from: classes2.dex */
    public static class AssetFileDescriptorSource extends InputSource {
        private final AssetFileDescriptor mAssetFileDescriptor;

        public AssetFileDescriptorSource(AssetFileDescriptor assetFileDescriptor) {
            this.mAssetFileDescriptor = assetFileDescriptor;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws IOException {
            return GifInfoHandle.openAssetFileDescriptor(this.mAssetFileDescriptor, false);
        }
    }

    /* loaded from: classes2.dex */
    public static final class AssetSource extends InputSource {
        private final AssetManager mAssetManager;
        private final String mAssetName;

        public AssetSource(AssetManager assetManager, String str) {
            this.mAssetManager = assetManager;
            this.mAssetName = str;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws IOException {
            return GifInfoHandle.openAssetFileDescriptor(this.mAssetManager.openFd(this.mAssetName), false);
        }
    }

    /* loaded from: classes2.dex */
    public static final class ByteArraySource extends InputSource {
        private final byte[] bytes;

        public ByteArraySource(byte[] bArr) {
            this.bytes = bArr;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws GifIOException {
            return GifInfoHandle.openByteArray(this.bytes, false);
        }
    }

    /* loaded from: classes2.dex */
    public static final class DirectByteBufferSource extends InputSource {
        private final ByteBuffer byteBuffer;

        public DirectByteBufferSource(ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws GifIOException {
            return GifInfoHandle.openDirectByteBuffer(this.byteBuffer, false);
        }
    }

    /* loaded from: classes2.dex */
    public static final class FileDescriptorSource extends InputSource {
        private final FileDescriptor mFd;

        public FileDescriptorSource(FileDescriptor fileDescriptor) {
            this.mFd = fileDescriptor;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws IOException {
            return GifInfoHandle.openFd(this.mFd, 0L, false);
        }
    }

    /* loaded from: classes2.dex */
    public static final class InputStreamSource extends InputSource {
        private final InputStream inputStream;

        public InputStreamSource(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws IOException {
            return GifInfoHandle.openMarkableInputStream(this.inputStream, false);
        }
    }

    /* loaded from: classes2.dex */
    public static class ResourcesSource extends InputSource {
        private final int mResourceId;
        private final Resources mResources;

        public ResourcesSource(Resources resources, int i) {
            this.mResources = resources;
            this.mResourceId = i;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws IOException {
            return GifInfoHandle.openAssetFileDescriptor(this.mResources.openRawResourceFd(this.mResourceId), false);
        }
    }

    /* loaded from: classes2.dex */
    public static final class UriSource extends InputSource {
        private final ContentResolver mContentResolver;
        private final Uri mUri;

        public UriSource(ContentResolver contentResolver, Uri uri) {
            this.mContentResolver = contentResolver;
            this.mUri = uri;
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws IOException {
            return GifInfoHandle.openUri(this.mContentResolver, this.mUri, false);
        }
    }

    InputSource() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GifDrawable build(GifDrawable gifDrawable, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z) throws IOException {
        return new GifDrawable(open(), gifDrawable, scheduledThreadPoolExecutor, z);
    }

    final boolean isOpaque() {
        return this.mIsOpaque;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract GifInfoHandle open() throws IOException;

    final InputSource setOpaque(boolean z) {
        this.mIsOpaque = z;
        return this;
    }

    /* loaded from: classes2.dex */
    public static final class FileSource extends InputSource {
        private final String mPath;

        public FileSource(File file) {
            this.mPath = file.getPath();
        }

        @Override // pl.droidsonroids.gif.InputSource
        GifInfoHandle open() throws GifIOException {
            return GifInfoHandle.openFile(this.mPath, false);
        }

        public FileSource(String str) {
            this.mPath = str;
        }
    }
}
