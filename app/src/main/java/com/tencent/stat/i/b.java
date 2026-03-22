package com.tencent.stat.i;

import android.util.Log;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private String f2868a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2869b = true;

    /* renamed from: c, reason: collision with root package name */
    private int f2870c = 2;

    public b(String str) {
        this.f2868a = MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY;
        this.f2868a = str;
    }

    private String b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(b.class.getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public void a(Exception exc) {
        if (a()) {
            b(exc);
        }
    }

    public void a(Object obj) {
        if (a()) {
            b(obj);
        }
    }

    public void a(boolean z) {
        this.f2869b = z;
    }

    public boolean a() {
        return this.f2869b;
    }

    public void b(Exception exc) {
        if (this.f2870c <= 6) {
            StringBuffer stringBuffer = new StringBuffer();
            String b2 = b();
            StackTraceElement[] stackTrace = exc.getStackTrace();
            stringBuffer.append(b2 != null ? b2 + " - " + exc + "\r\n" : exc + "\r\n");
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        stringBuffer.append("[ " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + " ]\r\n");
                    }
                }
            }
            Log.e(this.f2868a, stringBuffer.toString());
        }
    }

    public void b(Object obj) {
        String str;
        if (this.f2870c <= 3) {
            String b2 = b();
            if (b2 == null) {
                str = obj.toString();
            } else {
                str = b2 + " - " + obj;
            }
            Log.d(this.f2868a, str);
        }
    }

    public void c(Object obj) {
        if (a()) {
            d(obj);
        }
    }

    public void d(Object obj) {
        String str;
        if (this.f2870c <= 6) {
            String b2 = b();
            if (b2 == null) {
                str = obj.toString();
            } else {
                str = b2 + " - " + obj;
            }
            Log.e(this.f2868a, str);
        }
    }

    public void e(Object obj) {
        if (a()) {
            f(obj);
        }
    }

    public void f(Object obj) {
        String str;
        if (this.f2870c <= 4) {
            String b2 = b();
            if (b2 == null) {
                str = obj.toString();
            } else {
                str = b2 + " - " + obj;
            }
            Log.i(this.f2868a, str);
        }
    }

    public void g(Object obj) {
        if (a()) {
            h(obj);
        }
    }

    public void h(Object obj) {
        String str;
        if (this.f2870c <= 5) {
            String b2 = b();
            if (b2 == null) {
                str = obj.toString();
            } else {
                str = b2 + " - " + obj;
            }
            Log.w(this.f2868a, str);
        }
    }
}
