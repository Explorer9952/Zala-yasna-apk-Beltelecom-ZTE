package pl.droidsonroids.gif;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class SafeRunnable implements Runnable {
    final GifDrawable mGifDrawable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeRunnable(GifDrawable gifDrawable) {
        this.mGifDrawable = gifDrawable;
    }

    abstract void doWork();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.mGifDrawable.isRecycled()) {
                return;
            }
            doWork();
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            try {
                throw th;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }
}
