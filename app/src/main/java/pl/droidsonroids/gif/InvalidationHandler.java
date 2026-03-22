package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InvalidationHandler extends Handler {
    private final WeakReference<GifDrawable> mDrawableRef;

    public InvalidationHandler(GifDrawable gifDrawable) {
        super(Looper.getMainLooper());
        this.mDrawableRef = new WeakReference<>(gifDrawable);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        GifDrawable gifDrawable = this.mDrawableRef.get();
        if (gifDrawable != null) {
            gifDrawable.invalidateSelf();
        }
    }
}
