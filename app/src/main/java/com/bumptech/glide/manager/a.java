package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle.java */
/* loaded from: classes.dex */
class a implements g {

    /* renamed from: a, reason: collision with root package name */
    private final Set<h> f2248a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private boolean f2249b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2250c;

    @Override // com.bumptech.glide.manager.g
    public void a(h hVar) {
        this.f2248a.add(hVar);
        if (this.f2250c) {
            hVar.onDestroy();
        } else if (this.f2249b) {
            hVar.b();
        } else {
            hVar.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f2249b = true;
        Iterator it2 = com.bumptech.glide.s.h.a(this.f2248a).iterator();
        while (it2.hasNext()) {
            ((h) it2.next()).b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f2249b = false;
        Iterator it2 = com.bumptech.glide.s.h.a(this.f2248a).iterator();
        while (it2.hasNext()) {
            ((h) it2.next()).onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f2250c = true;
        Iterator it2 = com.bumptech.glide.s.h.a(this.f2248a).iterator();
        while (it2.hasNext()) {
            ((h) it2.next()).onDestroy();
        }
    }
}
