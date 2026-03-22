package com.bumptech.glide.s;

import android.util.Log;
import java.util.Queue;

/* compiled from: ByteArrayPool.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final a f2336b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Queue<byte[]> f2337a = h.a(0);

    private a() {
    }

    public static a b() {
        return f2336b;
    }

    public byte[] a() {
        byte[] poll;
        synchronized (this.f2337a) {
            poll = this.f2337a.poll();
        }
        if (poll == null) {
            poll = new byte[65536];
            if (Log.isLoggable("ByteArrayPool", 3)) {
                Log.d("ByteArrayPool", "Created temp bytes");
            }
        }
        return poll;
    }

    public boolean a(byte[] bArr) {
        boolean z = false;
        if (bArr.length != 65536) {
            return false;
        }
        synchronized (this.f2337a) {
            if (this.f2337a.size() < 32) {
                z = true;
                this.f2337a.offer(bArr);
            }
        }
        return z;
    }
}
