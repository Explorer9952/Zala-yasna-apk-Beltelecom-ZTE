package com.render.vrlib.j;

import android.content.Context;
import android.util.Log;
import com.render.vrlib.a;
import com.render.vrlib.i;
import com.render.vrlib.l.e.o;
import com.render.vrlib.m;
import com.render.vrlib.p;
import com.render.vrlib.w.k;
import com.render.vrlib.w.l;
import com.rendergl.google.android.apps.muzei.GLTextureView;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: MDPanoramaPlugin.java */
/* loaded from: classes.dex */
public class g extends c {

    /* renamed from: d, reason: collision with root package name */
    private com.render.vrlib.h f2507d;
    private com.render.vrlib.n.c e;
    private o f;
    private m g;
    private p h;
    private boolean i;

    public g(k kVar) {
        this.i = false;
        this.e = kVar.a();
        this.f2507d = new com.render.vrlib.h(kVar.b());
        this.f = kVar.c();
        this.g = kVar.d();
        this.h = kVar.e();
        if (this.f.d() == 148) {
            this.g.f(10.0f);
            this.g.c(1.0f);
        } else if (this.f.d() != 150 && this.f.d() != 149) {
            this.g.e(0.0f);
            this.g.f(0.0f);
            this.g.c(-1.0f);
            this.g.a(0.0d);
        } else {
            this.g.e(10.0f);
            this.g.f(10.0f);
            this.g.c(-1.0f);
            this.g.a(0.17453292519943295d);
        }
        this.i = false;
    }

    @Override // com.render.vrlib.j.c
    public void a(Context context, boolean z) {
        if (this.i) {
            Log.d("MDPanoramaPlugin", "isDestroyed initInGL invalid");
            return;
        }
        this.f2507d.a(context);
        this.e.a(z);
        this.e.g();
    }

    @Override // com.render.vrlib.j.c
    public void b() {
        Log.d("MDPanoramaPlugin", " stopping destroyInGL");
        com.render.vrlib.h hVar = this.f2507d;
        if (hVar != null) {
            hVar.i();
            this.f2507d = null;
        }
        this.e = null;
        this.i = true;
    }

    protected l c() {
        return this.f.c();
    }

    public void d() {
        if (this.i) {
            Log.d("MDPanoramaPlugin", "isDestroyed triggerGlListener invalid");
        } else {
            this.e.e();
        }
    }

    public void a(GLTextureView.a aVar) {
        if (this.i) {
            Log.d("MDPanoramaPlugin", "isDestroyed setGlListener invalid");
        } else {
            this.e.a(aVar);
        }
    }

    @Override // com.render.vrlib.j.c
    public void a(int i, int i2) {
        if (this.i) {
            Log.d("MDPanoramaPlugin", "isDestroyed beforeRenderer invalid");
            return;
        }
        ConcurrentLinkedQueue<a> f = this.f.f();
        if (f != null) {
            Iterator<a> it2 = f.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (this.g.s()) {
                    next.a(this.g);
                }
                next.a(this.h);
            }
            this.g.t();
        }
    }

    @Override // com.render.vrlib.j.c
    public void a(int i, int i2, int i3, a aVar) {
        if (this.i) {
            Log.d("MDPanoramaPlugin", "isDestroyed renderer invalid");
            return;
        }
        i.b b2 = this.f.b();
        if (b2 == null) {
            return;
        }
        this.f2507d.a();
        com.render.vrlib.a.b.a("MDPanoramaPlugin mProgram use");
        this.e.a(this.f2507d);
        b2.a(this.f2507d, i);
        b2.b(this.f2507d, i);
        this.f.d();
        aVar.c();
        aVar.a(this.f2507d, c());
        b2.c();
    }
}
