package d.e.b.n;

import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final BlockingQueue<b> f8069a = new LinkedBlockingQueue(10000);

    /* renamed from: b, reason: collision with root package name */
    private static final String f8070b = d.class.getName();

    /* renamed from: c, reason: collision with root package name */
    private static int f8071c = 2;

    private static void a(int i, String str, String str2, Exception exc) {
        if (str2 == null) {
            str2 = "";
        }
        if (str.length() >= 28) {
            str = str.substring(0, 28) + "..";
        }
        int length = str2.length();
        if (length < 800) {
            b(i, str, str2, exc);
            return;
        }
        while (length >= 800) {
            String substring = str2.substring(0, 800);
            str2 = str2.substring(800);
            int length2 = str2.length();
            b(i, str, substring, exc);
            length = length2;
        }
        b(i, str, str2, exc);
    }

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    public static void a(String str, String str2, Exception exc) {
        if (f8071c <= 2) {
            a(2, str, str2, exc);
        }
    }

    private static void b(int i, String str, String str2, Exception exc) {
        b bVar = new b();
        bVar.a(exc);
        bVar.a(str);
        bVar.b(str2);
        bVar.a(i);
        if (f8069a.offer(bVar)) {
            return;
        }
        Log.e(f8070b, "------------Write Oper Log Error:put---------------");
    }

    public static void b(String str, String str2) {
        if (f8071c <= 3) {
            a(3, str, str2, null);
        }
    }

    public static void b(String str, String str2, Exception exc) {
        if (f8071c <= 4) {
            a(4, str, str2, exc);
        }
    }

    public static void c(String str, String str2) {
        if (f8071c <= 1) {
            a(1, str, str2, null);
        }
    }

    public static void d(String str, String str2) {
        b(str, str2, null);
    }
}
