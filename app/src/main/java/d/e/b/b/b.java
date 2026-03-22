package d.e.b.b;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final String f8047b = "d.e.b.b.b";

    /* renamed from: c, reason: collision with root package name */
    static Handler f8048c = new d(Looper.myLooper(), new c());

    /* renamed from: a, reason: collision with root package name */
    private Handler f8049a;

    public Handler c() {
        Handler handler = this.f8049a;
        return handler == null ? f8048c : handler;
    }
}
