package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentPool.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    static n f8599a;

    /* renamed from: b, reason: collision with root package name */
    static long f8600b;

    private o() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n a() {
        synchronized (o.class) {
            if (f8599a != null) {
                n nVar = f8599a;
                f8599a = nVar.f;
                nVar.f = null;
                f8600b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return nVar;
            }
            return new n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(n nVar) {
        if (nVar.f == null && nVar.g == null) {
            if (nVar.f8598d) {
                return;
            }
            synchronized (o.class) {
                if (f8600b + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                f8600b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                nVar.f = f8599a;
                nVar.f8597c = 0;
                nVar.f8596b = 0;
                f8599a = nVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
