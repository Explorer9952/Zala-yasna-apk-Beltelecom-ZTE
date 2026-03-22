package com.tencent.stat;

import android.content.Context;
import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2901a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context) {
        this.f2901a = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        com.tencent.stat.i.b bVar;
        com.tencent.stat.i.b bVar2;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        com.tencent.stat.i.b bVar3;
        com.tencent.stat.i.b bVar4;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2;
        if (c.u()) {
            t b2 = t.b(this.f2901a);
            Context context = this.f2901a;
            b2.a(new com.tencent.stat.a.a(context, e.a(context, false), 2, th), (h) null);
            bVar = e.h;
            bVar.b("MTA has caught the following uncaught exception:");
            bVar2 = e.h;
            bVar2.d(th);
            uncaughtExceptionHandler = e.i;
            if (uncaughtExceptionHandler == null) {
                bVar3 = e.h;
                bVar3.b("Original uncaught exception handler not set.");
            } else {
                bVar4 = e.h;
                bVar4.b("Call the original uncaught exception handler.");
                uncaughtExceptionHandler2 = e.i;
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
        }
    }
}
