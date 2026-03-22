package c.a.a.a.a;

import android.content.Context;
import c.a.a.a.e.c;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;

/* compiled from: SkinConfig.java */
/* loaded from: classes.dex */
public class a {
    public static String a(Context context) {
        return c.a(context, "skin_path", MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY);
    }

    public static void a(Context context, String str) {
        c.b(context, "skin_path", str);
    }
}
