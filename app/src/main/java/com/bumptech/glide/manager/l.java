package com.bumptech.glide.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final Set<com.bumptech.glide.q.c> f2260a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.q.c> f2261b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private boolean f2262c;

    public void a(com.bumptech.glide.q.c cVar) {
        this.f2260a.remove(cVar);
        this.f2261b.remove(cVar);
    }

    public void b(com.bumptech.glide.q.c cVar) {
        this.f2260a.add(cVar);
        if (!this.f2262c) {
            cVar.d();
        } else {
            this.f2261b.add(cVar);
        }
    }

    public void c() {
        for (com.bumptech.glide.q.c cVar : com.bumptech.glide.s.h.a(this.f2260a)) {
            if (!cVar.e() && !cVar.isCancelled()) {
                cVar.pause();
                if (!this.f2262c) {
                    cVar.d();
                } else {
                    this.f2261b.add(cVar);
                }
            }
        }
    }

    public void d() {
        this.f2262c = false;
        for (com.bumptech.glide.q.c cVar : com.bumptech.glide.s.h.a(this.f2260a)) {
            if (!cVar.e() && !cVar.isCancelled() && !cVar.isRunning()) {
                cVar.d();
            }
        }
        this.f2261b.clear();
    }

    public void a() {
        Iterator it2 = com.bumptech.glide.s.h.a(this.f2260a).iterator();
        while (it2.hasNext()) {
            ((com.bumptech.glide.q.c) it2.next()).clear();
        }
        this.f2261b.clear();
    }

    public void b() {
        this.f2262c = true;
        for (com.bumptech.glide.q.c cVar : com.bumptech.glide.s.h.a(this.f2260a)) {
            if (cVar.isRunning()) {
                cVar.pause();
                this.f2261b.add(cVar);
            }
        }
    }
}
