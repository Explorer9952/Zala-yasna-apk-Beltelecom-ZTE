package pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes2.dex */
final class GifRenderingExecutor extends ScheduledThreadPoolExecutor {
    private static volatile GifRenderingExecutor instance;

    private GifRenderingExecutor() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }

    public static synchronized GifRenderingExecutor getInstance() {
        GifRenderingExecutor gifRenderingExecutor;
        synchronized (GifRenderingExecutor.class) {
            if (instance == null) {
                instance = new GifRenderingExecutor();
            }
            gifRenderingExecutor = instance;
        }
        return gifRenderingExecutor;
    }
}
