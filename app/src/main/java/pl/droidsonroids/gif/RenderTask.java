package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class RenderTask extends SafeRunnable {
    private final Runnable mNotifyListenersTask;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderTask(GifDrawable gifDrawable) {
        super(gifDrawable);
        this.mNotifyListenersTask = new Runnable() { // from class: pl.droidsonroids.gif.RenderTask.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator<AnimationListener> it2 = RenderTask.this.mGifDrawable.mListeners.iterator();
                while (it2.hasNext()) {
                    it2.next().onAnimationCompleted();
                }
            }
        };
    }

    @Override // pl.droidsonroids.gif.SafeRunnable
    public void doWork() {
        GifDrawable gifDrawable = this.mGifDrawable;
        long renderFrame = gifDrawable.mNativeInfoHandle.renderFrame(gifDrawable.mBuffer);
        if (renderFrame >= 0) {
            this.mGifDrawable.mNextFrameRenderTime = SystemClock.uptimeMillis() + renderFrame;
            if (this.mGifDrawable.isVisible() && this.mGifDrawable.mIsRunning) {
                GifDrawable gifDrawable2 = this.mGifDrawable;
                if (!gifDrawable2.mIsRenderingTriggeredOnDraw) {
                    gifDrawable2.mExecutor.remove(this);
                    GifDrawable gifDrawable3 = this.mGifDrawable;
                    gifDrawable3.mSchedule = gifDrawable3.mExecutor.schedule(this, renderFrame, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.mGifDrawable.mListeners.isEmpty()) {
                int currentFrameIndex = this.mGifDrawable.getCurrentFrameIndex();
                GifDrawable gifDrawable4 = this.mGifDrawable;
                if (currentFrameIndex == gifDrawable4.mNativeInfoHandle.frameCount - 1) {
                    gifDrawable4.scheduleSelf(this.mNotifyListenersTask, gifDrawable4.mNextFrameRenderTime);
                }
            }
        } else {
            GifDrawable gifDrawable5 = this.mGifDrawable;
            gifDrawable5.mNextFrameRenderTime = Long.MIN_VALUE;
            gifDrawable5.mIsRunning = false;
        }
        if (!this.mGifDrawable.isVisible() || this.mGifDrawable.mInvalidationHandler.hasMessages(0)) {
            return;
        }
        this.mGifDrawable.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
    }
}
