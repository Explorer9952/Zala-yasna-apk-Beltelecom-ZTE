package com.unity3d.player;

import android.os.Build;
import java.lang.Thread;

/* loaded from: classes.dex */
final class g implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private volatile Thread.UncaughtExceptionHandler f3009a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean a() {
        boolean z;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            z = false;
        } else {
            this.f3009a = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
            z = true;
        }
        return z;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        try {
            Error error = new Error(String.format("FATAL EXCEPTION [%s]\n", thread.getName()) + String.format("Unity version     : %s\n", "5.5.2f1") + String.format("Device model      : %s %s\n", Build.MANUFACTURER, Build.MODEL) + String.format("Device fingerprint: %s\n", Build.FINGERPRINT));
            error.setStackTrace(new StackTraceElement[0]);
            error.initCause(th);
            this.f3009a.uncaughtException(thread, error);
        } catch (Throwable unused) {
            this.f3009a.uncaughtException(thread, th);
        }
    }
}
