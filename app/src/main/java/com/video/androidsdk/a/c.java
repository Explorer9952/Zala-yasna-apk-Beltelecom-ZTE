package com.video.androidsdk.a;

import com.video.androidsdk.a.a;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ACache.java */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a.C0092a f3029a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.C0092a c0092a) {
        this.f3029a = c0092a;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicLong atomicLong;
        AtomicInteger atomicInteger;
        long b2;
        Map map;
        File[] listFiles = this.f3029a.f3025a.listFiles();
        if (listFiles != null) {
            int i = 0;
            int i2 = 0;
            for (File file : listFiles) {
                b2 = this.f3029a.b(file);
                i = (int) (i + b2);
                i2++;
                map = this.f3029a.f;
                map.put(file, Long.valueOf(file.lastModified()));
            }
            atomicLong = this.f3029a.f3026b;
            atomicLong.set(i);
            atomicInteger = this.f3029a.f3027c;
            atomicInteger.set(i2);
        }
    }
}
