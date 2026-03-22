package com.render.vrlib.l.e;

import android.content.Context;
import android.graphics.RectF;
import com.render.vrlib.i;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.player.render.IRender;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: ProjectionModeManager.java */
/* loaded from: classes.dex */
public class o extends com.render.vrlib.l.d<com.render.vrlib.l.e.a> implements k {
    private RectF e;
    private com.render.vrlib.b f;
    private com.render.vrlib.j.c g;
    private com.render.vrlib.w.k h;
    private j i;
    private final ConcurrentLinkedQueue<com.render.vrlib.a> j;
    private final com.render.vrlib.w.d k;
    private final com.render.vrlib.j.c l;
    private int m;

    /* compiled from: ProjectionModeManager.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public RectF f2566a;

        /* renamed from: b, reason: collision with root package name */
        public com.render.vrlib.b f2567b;

        /* renamed from: c, reason: collision with root package name */
        public com.render.vrlib.w.k f2568c;

        /* renamed from: d, reason: collision with root package name */
        public j f2569d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProjectionModeManager.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private com.render.vrlib.j.c f2570a;

        public b(com.render.vrlib.j.c cVar) {
            this.f2570a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.render.vrlib.a.h.b("must call in gl thread");
            this.f2570a.b();
            this.f2570a = null;
        }
    }

    public o(int i, com.render.vrlib.a.d dVar, a aVar) {
        super(i, dVar);
        this.j = new ConcurrentLinkedQueue<>();
        this.e = aVar.f2566a;
        this.f = aVar.f2567b;
        this.i = aVar.f2569d;
        com.render.vrlib.w.k kVar = aVar.f2568c;
        this.h = kVar;
        this.m = kVar.b();
        this.h.a(this);
        this.k = new com.render.vrlib.w.d();
        this.l = new p(this);
    }

    @Override // com.render.vrlib.l.e.k
    public com.render.vrlib.w.l c() {
        return e().c();
    }

    public ConcurrentLinkedQueue<com.render.vrlib.a> f() {
        return this.j;
    }

    public com.render.vrlib.j.c h() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.render.vrlib.l.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.render.vrlib.l.e.a a(int i) {
        com.render.vrlib.l.e.a a2;
        j jVar = this.i;
        if (jVar != null && (a2 = jVar.a(i)) != null) {
            return a2;
        }
        switch (i) {
            case 148:
                return f.a(i, this.e);
            case 149:
                return new d();
            case 150:
                return new i(true);
            default:
                switch (i) {
                    case 195:
                        return m.a(i, this.e);
                    case IRender.PROJECTION_MODE_SPHERE_3D_TOP /* 196 */:
                        return new r(0);
                    case IRender.PROJECTION_MODE_SPHERE_3D_LEFT /* 197 */:
                        return new r(1);
                    default:
                        switch (i) {
                            case 202:
                                return new h(this.e, 180.0f, false);
                            case 203:
                                return new h(this.e, 230.0f, false);
                            case ErrCode.ERRCODE_THREADPOOL_NULL /* 204 */:
                                return new h(this.e, 180.0f, true);
                            case 205:
                                return new h(this.e, 230.0f, true);
                            case 206:
                            case 213:
                                return new s(com.render.vrlib.a.c.VERTICAL);
                            case 207:
                            case 208:
                            case IRender.PROJECTION_MODE_PLANE /* 209 */:
                                return m.a(i, this.e);
                            case 210:
                                return new l(1.0f, com.render.vrlib.a.c.HORIZONTAL);
                            case 211:
                                return new l(1.0f, com.render.vrlib.a.c.VERTICAL);
                            case 212:
                                return new s(com.render.vrlib.a.c.HORIZONTAL);
                            case 214:
                                return new e();
                            case IRender.PROJECTION_MODE_BULLET_TIME_4 /* 215 */:
                                return com.render.vrlib.l.e.b.a(this.e, 2, 2);
                            case IRender.PROJECTION_MODE_BULLET_TIME_8 /* 216 */:
                                return com.render.vrlib.l.e.b.a(this.e, 2, 4);
                            case IRender.PROJECTION_MODE_BULLET_TIME_9 /* 217 */:
                                return com.render.vrlib.l.e.b.a(this.e, 3, 3);
                            case IRender.PROJECTION_MODE_BULLET_TIME_16 /* 218 */:
                                return com.render.vrlib.l.e.b.a(this.e, 4, 4);
                            default:
                                return new q();
                        }
                }
        }
    }

    public com.render.vrlib.j.c a() {
        if (this.g == null) {
            this.g = e().a(this.h);
        }
        return this.g;
    }

    public void a(Context context, boolean z) {
        if (z) {
            this.h.a(4);
        } else {
            this.h.a(this.m);
        }
        if (this.g != null) {
            g().a(new b(this.g));
            this.g = null;
        }
    }

    @Override // com.render.vrlib.l.d
    public void a(Context context, int i) {
        super.a(context, i);
        if (i == 195) {
            this.h.a(5);
        } else {
            this.h.a(this.m);
        }
        if (this.g != null) {
            g().a(new b(this.g));
            this.g = null;
        }
    }

    @Override // com.render.vrlib.l.d
    public void a(Context context) {
        super.a(context);
        if (this.g != null) {
            g().a(new b(this.g));
            this.g = null;
        }
        this.j.clear();
        com.render.vrlib.b a2 = e().a();
        if (a2 == null) {
            a2 = this.f;
        }
        for (int i = 0; i < 2; i++) {
            this.j.add(a2.createDirector(i));
        }
    }

    @Override // com.render.vrlib.l.e.k
    public i.b b() {
        return e().b();
    }
}
