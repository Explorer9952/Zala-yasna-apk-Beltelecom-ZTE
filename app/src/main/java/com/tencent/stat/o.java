package com.tencent.stat;

import android.content.Context;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Context f2903a;

    public o(Context context) {
        this.f2903a = null;
        this.f2903a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.stat.i.b bVar;
        Iterator<File> it2 = StatNativeCrashReport.a(this.f2903a).iterator();
        while (it2.hasNext()) {
            File next = it2.next();
            String a2 = StatNativeCrashReport.a(next);
            Context context = this.f2903a;
            com.tencent.stat.a.a aVar = new com.tencent.stat.a.a(context, e.a(context, false), a2, 3, 10240);
            aVar.a(StatNativeCrashReport.b(next));
            if (e.c(this.f2903a) != null) {
                e.c(this.f2903a).post(new q(aVar));
            }
            next.delete();
            bVar = e.h;
            bVar.a("delete tombstone file:" + next.getAbsolutePath().toString());
        }
    }
}
