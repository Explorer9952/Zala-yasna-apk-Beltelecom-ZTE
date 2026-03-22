package b.f;

import android.os.Trace;

/* compiled from: TraceApi18Impl.java */
/* loaded from: classes.dex */
final class b {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void a() {
        Trace.endSection();
    }
}
