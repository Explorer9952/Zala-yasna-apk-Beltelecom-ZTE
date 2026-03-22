package d.b.a.a;

import android.content.Context;
import android.util.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* compiled from: BlockCanary.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f7957a;

    private a() {
    }

    public static a a(Context context, b bVar) {
        b.a(context, bVar);
        return b();
    }

    public static a b() {
        if (f7957a == null) {
            synchronized (a.class) {
                if (f7957a == null) {
                    f7957a = new a();
                }
            }
        }
        return f7957a;
    }

    public void a() {
        Log.i("BlockCanary-no-op", TtmlNode.START);
    }
}
