package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.widget.MediaController;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SuppressLint({"Override"})
/* loaded from: classes2.dex */
public final class GifDrawable extends Drawable implements Animatable, MediaController.MediaPlayerControl {
    final Bitmap mBuffer;
    private final Rect mDstRect;
    final ScheduledThreadPoolExecutor mExecutor;
    final InvalidationHandler mInvalidationHandler;
    final boolean mIsRenderingTriggeredOnDraw;
    volatile boolean mIsRunning;
    final ConcurrentLinkedQueue<AnimationListener> mListeners;
    final GifInfoHandle mNativeInfoHandle;
    long mNextFrameRenderTime;
    protected final Paint mPaint;
    private final RenderTask mRenderTask;
    ScheduledFuture<?> mSchedule;
    private final Rect mSrcRect;
    private ColorStateList mTint;
    private PorterDuffColorFilter mTintFilter;
    private PorterDuff.Mode mTintMode;

    public GifDrawable(Resources resources, int i) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i));
    }

    public static GifDrawable createFromResource(Resources resources, int i) {
        try {
            return new GifDrawable(resources, i);
        } catch (IOException unused) {
            return null;
        }
    }

    private void shutdown() {
        this.mIsRunning = false;
        this.mInvalidationHandler.removeMessages(0);
        this.mNativeInfoHandle.recycle();
    }

    private PorterDuffColorFilter updateTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void waitForPendingRenderTask() {
        this.mExecutor.remove(this.mRenderTask);
        ScheduledFuture<?> scheduledFuture = this.mSchedule;
        if (scheduledFuture != null) {
            try {
                scheduledFuture.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mInvalidationHandler.removeMessages(0);
    }

    public void addAnimationListener(AnimationListener animationListener) {
        this.mListeners.add(animationListener);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return getNumberOfFrames() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return getNumberOfFrames() > 1;
    }

    @Override // android.graphics.drawable.Drawable
    @SuppressLint({"Override"})
    public void draw(Canvas canvas) {
        boolean z;
        if (this.mTintFilter == null || this.mPaint.getColorFilter() != null) {
            z = false;
        } else {
            this.mPaint.setColorFilter(this.mTintFilter);
            z = true;
        }
        if (this.mPaint.getShader() == null) {
            canvas.drawBitmap(this.mBuffer, this.mSrcRect, this.mDstRect, this.mPaint);
        } else {
            canvas.drawRect(this.mDstRect, this.mPaint);
        }
        if (z) {
            this.mPaint.setColorFilter(null);
        }
        if (this.mIsRenderingTriggeredOnDraw && this.mIsRunning) {
            long j = this.mNextFrameRenderTime;
            if (j != Long.MIN_VALUE) {
                long max = Math.max(0L, j - SystemClock.uptimeMillis());
                this.mNextFrameRenderTime = Long.MIN_VALUE;
                this.mExecutor.remove(this.mRenderTask);
                this.mSchedule = this.mExecutor.schedule(this.mRenderTask, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    @TargetApi(1)
    public long getAllocationByteCount() {
        long rowBytes;
        long allocationByteCount = this.mNativeInfoHandle.getAllocationByteCount();
        if (Build.VERSION.SDK_INT >= 1) {
            rowBytes = this.mBuffer.getByteCount();
        } else {
            rowBytes = this.mBuffer.getRowBytes() * this.mBuffer.getHeight();
        }
        return allocationByteCount + rowBytes;
    }

    @Override // android.graphics.drawable.Drawable
    @SuppressLint({"Override"})
    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    public String getComment() {
        return this.mNativeInfoHandle.getComment();
    }

    public Bitmap getCurrentFrame() {
        Bitmap bitmap = this.mBuffer;
        return bitmap.copy(bitmap.getConfig(), this.mBuffer.isMutable());
    }

    public int getCurrentFrameIndex() {
        return this.mNativeInfoHandle.getCurrentFrameIndex();
    }

    public int getCurrentLoop() {
        return this.mNativeInfoHandle.getCurrentLoop();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.mNativeInfoHandle.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.mNativeInfoHandle.getDuration();
    }

    public GifError getError() {
        return GifError.fromCode(this.mNativeInfoHandle.getNativeErrorCode());
    }

    public int getFrameByteCount() {
        return this.mBuffer.getRowBytes() * this.mBuffer.getHeight();
    }

    public int getFrameDuration(int i) {
        return this.mNativeInfoHandle.getFrameDuration(i);
    }

    public long getInputSourceByteCount() {
        return this.mNativeInfoHandle.getSourceLength();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mNativeInfoHandle.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mNativeInfoHandle.width;
    }

    public int getLoopCount() {
        return this.mNativeInfoHandle.getLoopCount();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.mNativeInfoHandle.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.mNativeInfoHandle.width;
    }

    public int getNumberOfFrames() {
        return this.mNativeInfoHandle.frameCount;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    public int getPixel(int i, int i2) {
        GifInfoHandle gifInfoHandle = this.mNativeInfoHandle;
        if (i < gifInfoHandle.width) {
            if (i2 < gifInfoHandle.height) {
                return this.mBuffer.getPixel(i, i2);
            }
            throw new IllegalArgumentException("y must be < height");
        }
        throw new IllegalArgumentException("x must be < width");
    }

    public void getPixels(int[] iArr) {
        Bitmap bitmap = this.mBuffer;
        GifInfoHandle gifInfoHandle = this.mNativeInfoHandle;
        int i = gifInfoHandle.width;
        bitmap.getPixels(iArr, 0, i, 0, 0, i, gifInfoHandle.height);
    }

    public boolean isAnimationCompleted() {
        return this.mNativeInfoHandle.isAnimationCompleted();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.mIsRunning;
    }

    public boolean isRecycled() {
        return this.mNativeInfoHandle.isRecycled();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        return super.isStateful() || ((colorStateList = this.mTint) != null && colorStateList.isStateful());
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mDstRect.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.mTint;
        if (colorStateList == null || (mode = this.mTintMode) == null) {
            return false;
        }
        this.mTintFilter = updateTintFilter(colorStateList, mode);
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    public void recycle() {
        shutdown();
        this.mBuffer.recycle();
    }

    public boolean removeAnimationListener(AnimationListener animationListener) {
        return this.mListeners.remove(animationListener);
    }

    public void reset() {
        this.mExecutor.execute(new SafeRunnable(this) { // from class: pl.droidsonroids.gif.GifDrawable.1
            @Override // pl.droidsonroids.gif.SafeRunnable
            public void doWork() {
                if (GifDrawable.this.mNativeInfoHandle.reset()) {
                    GifDrawable.this.start();
                }
            }
        });
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(final int i) {
        if (i >= 0) {
            this.mExecutor.execute(new SafeRunnable(this) { // from class: pl.droidsonroids.gif.GifDrawable.2
                @Override // pl.droidsonroids.gif.SafeRunnable
                public void doWork() {
                    GifDrawable gifDrawable = GifDrawable.this;
                    gifDrawable.mNativeInfoHandle.seekToTime(i, gifDrawable.mBuffer);
                    this.mGifDrawable.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    public void seekToFrame(final int i) {
        if (i >= 0) {
            this.mExecutor.execute(new SafeRunnable(this) { // from class: pl.droidsonroids.gif.GifDrawable.3
                @Override // pl.droidsonroids.gif.SafeRunnable
                public void doWork() {
                    GifDrawable gifDrawable = GifDrawable.this;
                    gifDrawable.mNativeInfoHandle.seekToFrame(i, gifDrawable.mBuffer);
                    GifDrawable.this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
                }
            });
            return;
        }
        throw new IndexOutOfBoundsException("Frame index is not positive");
    }

    public Bitmap seekToFrameAndGet(int i) {
        Bitmap currentFrame;
        if (i >= 0) {
            synchronized (this.mNativeInfoHandle) {
                this.mNativeInfoHandle.seekToFrame(i, this.mBuffer);
                currentFrame = getCurrentFrame();
            }
            this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
            return currentFrame;
        }
        throw new IndexOutOfBoundsException("Frame index is not positive");
    }

    public Bitmap seekToPositionAndGet(int i) {
        Bitmap currentFrame;
        if (i >= 0) {
            synchronized (this.mNativeInfoHandle) {
                this.mNativeInfoHandle.seekToTime(i, this.mBuffer);
                currentFrame = getCurrentFrame();
            }
            this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
            return currentFrame;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.mPaint.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setLoopCount(int i) {
        this.mNativeInfoHandle.setLoopCount(i);
    }

    public void setSpeed(float f) {
        this.mNativeInfoHandle.setSpeedFactor(f);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.mTint = colorStateList;
        this.mTintFilter = updateTintFilter(colorStateList, this.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        this.mTintFilter = updateTintFilter(this.mTint, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.mIsRenderingTriggeredOnDraw) {
            if (z) {
                if (z2) {
                    reset();
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.mIsRunning = true;
        startAnimation(this.mNativeInfoHandle.restoreRemainder());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startAnimation(long j) {
        if (j >= 0) {
            if (this.mIsRenderingTriggeredOnDraw) {
                this.mNextFrameRenderTime = 0L;
                this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
            } else {
                waitForPendingRenderTask();
                this.mSchedule = this.mExecutor.schedule(this.mRenderTask, j, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mIsRunning = false;
        waitForPendingRenderTask();
        this.mNativeInfoHandle.saveRemainder();
    }

    public String toString() {
        return String.format(Locale.US, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.mNativeInfoHandle.width), Integer.valueOf(this.mNativeInfoHandle.height), Integer.valueOf(this.mNativeInfoHandle.frameCount), Integer.valueOf(this.mNativeInfoHandle.getNativeErrorCode()));
    }

    public GifDrawable(AssetManager assetManager, String str) throws IOException {
        this(assetManager.openFd(str));
    }

    public GifDrawable(String str) throws IOException {
        this(GifInfoHandle.openFile(str, false), null, null, true);
    }

    public GifDrawable(File file) throws IOException {
        this(GifInfoHandle.openFile(file.getPath(), false), null, null, true);
    }

    public GifDrawable(InputStream inputStream) throws IOException {
        this(GifInfoHandle.openMarkableInputStream(inputStream, false), null, null, true);
    }

    public GifDrawable(AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(GifInfoHandle.openAssetFileDescriptor(assetFileDescriptor, false), null, null, true);
    }

    public GifDrawable(FileDescriptor fileDescriptor) throws IOException {
        this(GifInfoHandle.openFd(fileDescriptor, 0L, false), null, null, true);
    }

    public GifDrawable(byte[] bArr) throws IOException {
        this(GifInfoHandle.openByteArray(bArr, false), null, null, true);
    }

    public GifDrawable(ByteBuffer byteBuffer) throws IOException {
        this(GifInfoHandle.openDirectByteBuffer(byteBuffer, false), null, null, true);
    }

    public GifDrawable(ContentResolver contentResolver, Uri uri) throws IOException {
        this(GifInfoHandle.openUri(contentResolver, uri, false), null, null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifDrawable(GifInfoHandle gifInfoHandle, GifDrawable gifDrawable, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z) {
        this.mIsRunning = true;
        this.mNextFrameRenderTime = Long.MIN_VALUE;
        this.mDstRect = new Rect();
        this.mPaint = new Paint(6);
        this.mListeners = new ConcurrentLinkedQueue<>();
        this.mRenderTask = new RenderTask(this);
        this.mIsRenderingTriggeredOnDraw = z;
        this.mExecutor = scheduledThreadPoolExecutor == null ? GifRenderingExecutor.getInstance() : scheduledThreadPoolExecutor;
        this.mNativeInfoHandle = gifInfoHandle;
        Bitmap bitmap = null;
        if (gifDrawable != null && !gifDrawable.mNativeInfoHandle.isRecycled()) {
            GifInfoHandle gifInfoHandle2 = gifDrawable.mNativeInfoHandle;
            int i = gifInfoHandle2.height;
            GifInfoHandle gifInfoHandle3 = this.mNativeInfoHandle;
            if (i >= gifInfoHandle3.height && gifInfoHandle2.width >= gifInfoHandle3.width) {
                gifDrawable.shutdown();
                bitmap = gifDrawable.mBuffer;
                bitmap.eraseColor(0);
            }
        }
        if (bitmap == null) {
            GifInfoHandle gifInfoHandle4 = this.mNativeInfoHandle;
            this.mBuffer = Bitmap.createBitmap(gifInfoHandle4.width, gifInfoHandle4.height, Bitmap.Config.ARGB_8888);
        } else {
            this.mBuffer = bitmap;
        }
        GifInfoHandle gifInfoHandle5 = this.mNativeInfoHandle;
        this.mSrcRect = new Rect(0, 0, gifInfoHandle5.width, gifInfoHandle5.height);
        this.mInvalidationHandler = new InvalidationHandler(this);
        this.mRenderTask.doWork();
    }
}
