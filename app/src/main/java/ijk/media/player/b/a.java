package ijk.media.player.b;

import android.util.Log;
import java.util.Locale;

/* compiled from: DebugLog.java */
/* loaded from: classes2.dex */
public class a {
    public static void a(String str, String str2) {
        Log.e(str, str2);
    }

    public static void b(String str, String str2) {
        Log.i(str, str2);
    }

    public static void c(String str, String str2) {
        Log.w(str, str2);
    }

    public static void a(String str, String str2, Object... objArr) {
        Log.i(str, String.format(Locale.US, str2, objArr));
    }
}
