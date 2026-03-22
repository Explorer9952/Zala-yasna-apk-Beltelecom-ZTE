package com.render.vrlib.w;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: MDHitEvent.java */
/* loaded from: classes.dex */
public class h {
    private static final Queue<h> e = new LinkedBlockingQueue();

    /* renamed from: a, reason: collision with root package name */
    private com.render.vrlib.j.a.a f2653a;

    /* renamed from: b, reason: collision with root package name */
    private long f2654b;

    /* renamed from: c, reason: collision with root package name */
    private o f2655c;

    /* renamed from: d, reason: collision with root package name */
    private i f2656d;

    public static h c() {
        h poll = e.poll();
        return poll == null ? new h() : poll;
    }

    public com.render.vrlib.j.a.a a() {
        return this.f2653a;
    }

    public void a(long j) {
    }

    public void a(i iVar) {
    }

    public o b() {
        return this.f2655c;
    }

    public void a(com.render.vrlib.j.a.a aVar) {
        this.f2653a = aVar;
    }

    public void a(o oVar) {
        this.f2655c = oVar;
    }

    public static void a(h hVar) {
        hVar.f2653a = null;
        hVar.f2654b = 0L;
        hVar.f2655c = null;
        hVar.f2656d = null;
        e.add(hVar);
    }
}
