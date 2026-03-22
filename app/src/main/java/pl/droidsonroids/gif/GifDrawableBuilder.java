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
import pl.droidsonroids.gif.InputSource;

/* loaded from: classes2.dex */
public class GifDrawableBuilder {
    private ScheduledThreadPoolExecutor mExecutor;
    private InputSource mInputSource;
    private boolean mIsRenderingTriggeredOnDraw = true;
    private GifDrawable mOldDrawable;

    public GifDrawable build() throws IOException {
        InputSource inputSource = this.mInputSource;
        if (inputSource != null) {
            return inputSource.build(this.mOldDrawable, this.mExecutor, this.mIsRenderingTriggeredOnDraw);
        }
        throw new NullPointerException("Source is not set");
    }

    public GifDrawableBuilder from(InputStream inputStream) {
        this.mInputSource = new InputSource.InputStreamSource(inputStream);
        return this;
    }

    public GifDrawableBuilder setRenderingTriggeredOnDraw(boolean z) {
        this.mIsRenderingTriggeredOnDraw = z;
        return this;
    }

    public GifDrawableBuilder taskExecutor(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.mExecutor = scheduledThreadPoolExecutor;
        return this;
    }

    public GifDrawableBuilder threadPoolSize(int i) {
        this.mExecutor = new ScheduledThreadPoolExecutor(i);
        return this;
    }

    public GifDrawableBuilder with(GifDrawable gifDrawable) {
        this.mOldDrawable = gifDrawable;
        return this;
    }

    public GifDrawableBuilder from(AssetFileDescriptor assetFileDescriptor) {
        this.mInputSource = new InputSource.AssetFileDescriptorSource(assetFileDescriptor);
        return this;
    }

    public GifDrawableBuilder from(FileDescriptor fileDescriptor) {
        this.mInputSource = new InputSource.FileDescriptorSource(fileDescriptor);
        return this;
    }

    public GifDrawableBuilder from(AssetManager assetManager, String str) {
        this.mInputSource = new InputSource.AssetSource(assetManager, str);
        return this;
    }

    public GifDrawableBuilder from(ContentResolver contentResolver, Uri uri) {
        this.mInputSource = new InputSource.UriSource(contentResolver, uri);
        return this;
    }

    public GifDrawableBuilder from(File file) {
        this.mInputSource = new InputSource.FileSource(file);
        return this;
    }

    public GifDrawableBuilder from(String str) {
        this.mInputSource = new InputSource.FileSource(str);
        return this;
    }

    public GifDrawableBuilder from(byte[] bArr) {
        this.mInputSource = new InputSource.ByteArraySource(bArr);
        return this;
    }

    public GifDrawableBuilder from(ByteBuffer byteBuffer) {
        this.mInputSource = new InputSource.DirectByteBufferSource(byteBuffer);
        return this;
    }

    public GifDrawableBuilder from(Resources resources, int i) {
        this.mInputSource = new InputSource.ResourcesSource(resources, i);
        return this;
    }
}
