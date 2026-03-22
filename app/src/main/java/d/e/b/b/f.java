package d.e.b.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.Util;
import com.zte.sdk.exception.SipStatusException;
import com.zte.ucs.tvcall.assist.AgentController;
import com.zte.ucs.tvcall.media.AudioMsg;
import com.zte.ucs.tvcall.ocx.OcxEventCallBack;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f8051a = "f";

    /* renamed from: b, reason: collision with root package name */
    private static boolean[] f8052b;

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, Object> f8053c;

    /* renamed from: d, reason: collision with root package name */
    private static f f8054d;

    static {
        String str;
        String str2;
        String str3;
        String str4;
        d.e.b.n.d.d(f.class.getSimpleName(), "[load Library] begin");
        d.e.b.n.d.c(f8051a, "[loadZxinOSLibrary] begin");
        try {
            AgentController.loadZxinOSLibrary();
        } catch (Exception e) {
            d.e.b.n.d.b(f8051a, "[load Library] loadZxinOSLibrary Exception!", e);
        }
        d.e.b.n.d.c(f8051a, "[loadZxinOSLibrary] done");
        d.e.b.n.d.c(f8051a, "[loadMediaModuleLibrary] begin");
        try {
            AudioMsg.loadMediaModuleLibrary();
        } catch (RuntimeException e2) {
            e = e2;
            str = f8051a;
            str2 = "[load Library] loadMediaModuleLibrary RuntimeException!";
            d.e.b.n.d.b(str, str2, e);
        } catch (Exception e3) {
            e = e3;
            str = f8051a;
            str2 = "[load Library] loadMediaModuleLibrary error!";
            d.e.b.n.d.b(str, str2, e);
        } catch (UnsatisfiedLinkError e4) {
            d.e.b.n.d.b(f8051a, "[load Library] loadMediaModuleLibrary UnsatisfiedLinkError!", new SipStatusException(e4));
        }
        d.e.b.n.d.c(f8051a, "[loadMediaModuleLibrary] done");
        d.e.b.n.d.c(f8051a, "[loadocxLibrary] begin");
        try {
            OcxEventCallBack.loadocxLibrary();
        } catch (RuntimeException e5) {
            e = e5;
            str3 = f8051a;
            str4 = "[load Library] loadocxLibrary RuntimeException!";
            d.e.b.n.d.b(str3, str4, e);
        } catch (Exception e6) {
            e = e6;
            str3 = f8051a;
            str4 = "[load Library] loadocxLibrary error!";
            d.e.b.n.d.b(str3, str4, e);
        } catch (UnsatisfiedLinkError e7) {
            d.e.b.n.d.b(f8051a, "[load Library] loadocxLibrary UnsatisfiedLinkError!", new SipStatusException(e7));
        }
        d.e.b.n.d.c(f8051a, "[loadocxLibrary] done");
        d.e.b.n.d.d(f8051a, "[load Library] done");
        f8052b = new boolean[]{false, false, false, false, false, false, false, false};
        f8053c = new HashMap<>();
        new h(Looper.myLooper(), new g());
    }

    private f() {
        d.e.b.n.d.c(f8051a, "NativeFactory initFile begin.");
        Context a2 = d.e.b.n.c.a();
        a(a2, "zxup10_dtmf.wav");
        a(a2, "detach.wav");
        a(a2, "ringin.wav");
        a(a2, "ringback.wav");
        a(a2, "call_wait.wav");
        d.e.b.n.d.c(f8051a, "NativeFactory initFile done.");
        q();
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f8054d == null) {
                f8054d = new f();
            }
            fVar = f8054d;
        }
        return fVar;
    }

    private static Object a(String str) {
        if (str == null) {
            d.e.b.n.d.d(f8051a, "getServiceNative newInstance of name is null!");
            return null;
        }
        synchronized (str) {
            if (!f8053c.containsKey(str)) {
                try {
                    f8053c.put(str, Class.forName(str).newInstance());
                    d.e.b.n.d.a(f8051a, "getServiceNative newInstance:" + str + " and cached.");
                } catch (Exception e) {
                    d.e.b.n.d.b(f8051a, "getServiceNative newInstance:" + str + " error!", e);
                    return null;
                }
            }
        }
        return f8053c.get(str);
    }

    private static String a(Context context, String str) {
        d.e.b.n.d.a(f8051a, "copyFileToFiles");
        String str2 = context.getFilesDir().getAbsolutePath() + "/" + str;
        AssetManager assets = context.getAssets();
        if (!new File(str2).exists()) {
            d.e.b.n.d.a(f8051a, "copyFileToFiles,none exist file:" + str2);
            try {
                a(assets.open(str), new BufferedOutputStream(new FileOutputStream(str2)));
            } catch (FileNotFoundException e) {
                d.e.b.n.d.a(f8051a, "copyFileToFiles,ex1");
                e.printStackTrace();
            } catch (IOException e2) {
                d.e.b.n.d.a(f8051a, "copyFileToFiles,ex2");
                e2.printStackTrace();
            }
        }
        return str2;
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        try {
            try {
                inputStream.available();
                byte[] bArr = new byte[Util.BYTE_OF_KB];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        outputStream.write(bArr, 0, read);
                    }
                }
                outputStream.flush();
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                try {
                    outputStream.close();
                } catch (IOException unused2) {
                }
            } catch (Exception e) {
                d.e.b.n.d.a(f8051a, "copyFile(), file copy failed reason:" + e);
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
                try {
                    outputStream.close();
                } catch (IOException unused4) {
                }
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused5) {
            }
            try {
                outputStream.close();
            } catch (IOException unused6) {
            }
            throw th;
        }
    }

    public static d.e.b.f.b b() {
        return (d.e.b.f.b) a(d.e.b.f.a.class.getCanonicalName());
    }

    public static d.e.b.k.a c() {
        return (d.e.b.k.a) a(d.e.b.k.b.class.getCanonicalName());
    }

    public static d.e.b.g.a d() {
        return (d.e.b.g.a) a(d.e.b.g.b.class.getCanonicalName());
    }

    public static d.e.b.e.b e() {
        return (d.e.b.e.b) a(d.e.b.e.a.class.getCanonicalName());
    }

    public static d.e.b.l.a f() {
        return (d.e.b.l.a) a(d.e.b.l.b.class.getCanonicalName());
    }

    public static d.e.b.m.a g() {
        if (f8052b[4]) {
            return (d.e.b.m.a) a(d.e.b.m.b.class.getCanonicalName());
        }
        return null;
    }

    public static d.e.b.h.a h() {
        return (d.e.b.h.a) a(d.e.b.h.b.class.getCanonicalName());
    }

    public static d.e.b.h.c.a i() {
        return (d.e.b.h.c.a) a(d.e.b.h.c.b.class.getCanonicalName());
    }

    public static d.e.b.i.a j() {
        return (d.e.b.i.a) a(d.e.b.i.b.class.getCanonicalName());
    }

    public static d.e.b.a.a k() {
        return (d.e.b.a.a) a(d.e.b.a.b.class.getCanonicalName());
    }

    public static d.e.b.d.b l() {
        return (d.e.b.d.b) a(d.e.b.d.a.class.getCanonicalName());
    }

    public static d.e.b.c.b m() {
        return (d.e.b.c.b) a(d.e.b.c.a.class.getCanonicalName());
    }

    public static d.e.b.j.a n() {
        return (d.e.b.j.a) a(d.e.b.j.b.class.getCanonicalName());
    }

    public static d.e.b.o.a o() {
        return (d.e.b.o.a) a(d.e.b.o.b.class.getCanonicalName());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void q() {
        /*
            java.lang.String r0 = d.e.b.b.f.f8051a
            java.lang.String r1 = "NativeFactory initLicense begin."
            d.e.b.n.d.c(r0, r1)
            android.content.Context r0 = d.e.b.n.c.a()
            java.lang.String r1 = "license.srt"
            java.lang.String r0 = a(r0, r1)
            d.e.b.e.b r1 = e()
            r1.a(r0)
            d.e.b.e.b r0 = e()
            java.lang.String r0 = r0.a()
            r1 = 0
            if (r0 == 0) goto L40
            int r2 = r0.length()     // Catch: java.lang.Exception -> L2e java.lang.NumberFormatException -> L36
            if (r2 <= 0) goto L40
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L2e java.lang.NumberFormatException -> L36
            goto L41
        L2e:
            r0 = move-exception
            java.lang.String r2 = d.e.b.b.f.f8051a
            java.lang.String r3 = r0.getMessage()
            goto L3d
        L36:
            r0 = move-exception
            java.lang.String r2 = d.e.b.b.f.f8051a
            java.lang.String r3 = r0.getMessage()
        L3d:
            d.e.b.n.d.b(r2, r3, r0)
        L40:
            r0 = 0
        L41:
            r2 = 1
            r3 = 0
            r4 = 1
        L44:
            boolean[] r5 = d.e.b.b.f.f8052b
            int r6 = r5.length
            if (r3 >= r6) goto L57
            r6 = r0 & r4
            if (r6 != r4) goto L4f
            r6 = 1
            goto L50
        L4f:
            r6 = 0
        L50:
            r5[r3] = r6
            int r4 = r4 << 1
            int r3 = r3 + 1
            goto L44
        L57:
            java.util.Locale r3 = java.util.Locale.getDefault()
            r4 = 7
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4[r1] = r0
            boolean[] r0 = d.e.b.b.f.f8052b
            boolean r0 = r0[r1]
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r4[r2] = r0
            boolean[] r0 = d.e.b.b.f.f8052b
            boolean r0 = r0[r2]
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1 = 2
            r4[r1] = r0
            boolean[] r0 = d.e.b.b.f.f8052b
            boolean r0 = r0[r1]
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1 = 3
            r4[r1] = r0
            boolean[] r0 = d.e.b.b.f.f8052b
            boolean r0 = r0[r1]
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1 = 4
            r4[r1] = r0
            boolean[] r0 = d.e.b.b.f.f8052b
            boolean r0 = r0[r1]
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1 = 5
            r4[r1] = r0
            r0 = 6
            boolean[] r2 = d.e.b.b.f.f8052b
            boolean r1 = r2[r1]
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r4[r0] = r1
            java.lang.String r0 = "License[%d],[SOFT][%b],[SIP][%b],[XCAP][%b],[HTTP][%b],[MEDIA][%b],[MSRP][%b]"
            java.lang.String r0 = java.lang.String.format(r3, r0, r4)
            java.lang.String r1 = d.e.b.b.f.f8051a
            d.e.b.n.d.d(r1, r0)
            java.lang.String r0 = d.e.b.b.f.f8051a
            java.lang.String r1 = "NativeFactory initLicense done."
            d.e.b.n.d.c(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.e.b.b.f.q():void");
    }
}
