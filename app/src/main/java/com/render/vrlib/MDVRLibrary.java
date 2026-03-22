package com.render.vrlib;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.SensorEventListener;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.widget.Toast;
import com.render.vrlib.b;
import com.render.vrlib.h;
import com.render.vrlib.i;
import com.render.vrlib.l.c.g;
import com.render.vrlib.l.e.o;
import com.render.vrlib.n.a;
import com.render.vrlib.s;
import com.rendergl.google.android.apps.muzei.GLTextureView;
import com.rendergl.google.android.apps.muzei.GLVrSurfaceView;
import com.video.androidsdk.player.render.IRender;
import ijk.media.player.IMediaPlayer;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class MDVRLibrary {
    private static int r = 1;
    private static int s = 400;

    /* renamed from: a, reason: collision with root package name */
    private RectF f2426a;

    /* renamed from: b, reason: collision with root package name */
    private com.render.vrlib.l.c.g f2427b;

    /* renamed from: c, reason: collision with root package name */
    private com.render.vrlib.l.a.b f2428c;

    /* renamed from: d, reason: collision with root package name */
    private com.render.vrlib.l.e.o f2429d;
    private com.render.vrlib.j.i e;
    private com.render.vrlib.s f;
    private com.render.vrlib.q g;
    private v h;
    private com.render.vrlib.n.c i;
    private com.render.vrlib.a.d j;
    private com.render.vrlib.m k;
    private com.render.vrlib.p l;
    private boolean m;
    private int n;
    private p o;
    private o p;
    private com.render.vrlib.w.c.b q;

    /* loaded from: classes.dex */
    public enum BulletTimeMode {
        MODE_TO_RIGHT_ONLY,
        MODE_TO_LEFT_ONLY,
        MODE_FIRST_RIGHT_THEN_LEFT,
        MODE_FIRST_LEFT_THEN_RIGHT
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f2431a;

        /* renamed from: b, reason: collision with root package name */
        private int f2432b;

        /* renamed from: c, reason: collision with root package name */
        private int f2433c;

        /* renamed from: d, reason: collision with root package name */
        private Context f2434d;
        private int e;
        private com.render.vrlib.n.c f;
        private h g;
        private boolean h;
        private boolean i;
        private com.render.vrlib.w.a j;
        private f k;
        private l l;
        private com.render.vrlib.b m;
        private int n;
        private SensorEventListener o;
        private com.render.vrlib.q p;
        private com.render.vrlib.l.e.j q;
        private com.render.vrlib.w.b r;
        private e s;
        private boolean t;
        private com.render.vrlib.w.g u;
        private float v;
        private int w;

        /* synthetic */ a(Context context, com.render.vrlib.c cVar) {
            this(context);
        }

        private a(Context context) {
            this.f2431a = 101;
            this.f2432b = 1;
            this.f2433c = IRender.PROJECTION_MODE_BULLET_TIME_4;
            this.e = 0;
            this.i = true;
            this.n = 1;
            this.t = true;
            this.v = 0.8f;
            this.w = 1;
            this.f2434d = context;
        }

        public a a(int i) {
            this.f2431a = i;
            return this;
        }

        public a b(int i) {
            this.f2432b = i;
            return this;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
        
            return r0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.render.vrlib.MDVRLibrary.a c(int r1) {
            /*
                r0 = this;
                r0.f2433c = r1
                switch(r1) {
                    case 215: goto L18;
                    case 216: goto L12;
                    case 217: goto Lc;
                    case 218: goto L6;
                    default: goto L5;
                }
            L5:
                goto L1c
            L6:
                r1 = 16
                com.render.vrlib.MDVRLibrary.c(r1)
                goto L1c
            Lc:
                r1 = 9
                com.render.vrlib.MDVRLibrary.c(r1)
                goto L1c
            L12:
                r1 = 8
                com.render.vrlib.MDVRLibrary.c(r1)
                goto L1c
            L18:
                r1 = 4
                com.render.vrlib.MDVRLibrary.c(r1)
            L1c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.render.vrlib.MDVRLibrary.a.c(int):com.render.vrlib.MDVRLibrary$a");
        }

        public a d(int i) {
            this.w = i;
            return this;
        }

        public a a(h hVar) {
            this.g = hVar;
            return this;
        }

        public a a() {
            this.f = new com.render.vrlib.n.d();
            this.e = 0;
            return this;
        }

        public a a(d dVar) {
            com.render.vrlib.a.h.a(dVar, "bitmap Provider can't be null!");
            this.f = new com.render.vrlib.n.a(dVar);
            this.e = 1;
            return this;
        }

        public a a(boolean z) {
            this.h = z;
            return this;
        }

        public a a(m mVar) {
            this.l = new h.b(mVar);
            return this;
        }

        public a a(com.render.vrlib.b bVar) {
            this.m = bVar;
            return this;
        }

        public a a(com.render.vrlib.w.a aVar) {
            this.j = aVar;
            return this;
        }

        public a a(com.render.vrlib.w.b bVar) {
            this.r = bVar;
            return this;
        }

        public MDVRLibrary a(View view) {
            if (view instanceof GLSurfaceView) {
                return a((GLSurfaceView) view);
            }
            if (view instanceof GLTextureView) {
                return a((GLTextureView) view);
            }
            throw new RuntimeException("Please ensure the glViewId is instance of GLSurfaceView or GLTextureView");
        }

        public MDVRLibrary a(GLSurfaceView gLSurfaceView) {
            Log.d("MDVRLibrary", "GLSurfaceView");
            return a(com.render.vrlib.q.a(gLSurfaceView));
        }

        public MDVRLibrary a(GLTextureView gLTextureView) {
            return a(com.render.vrlib.q.a(gLTextureView));
        }

        private MDVRLibrary a(com.render.vrlib.q qVar) {
            com.render.vrlib.a.h.a(this.f, "You must call video/bitmap function before build");
            if (this.m == null) {
                this.m = new b.a();
            }
            if (this.j == null) {
                this.j = new com.render.vrlib.w.a();
            }
            if (this.r == null) {
                this.r = new com.render.vrlib.w.b();
            }
            if (this.u == null) {
                this.u = new com.render.vrlib.w.g();
            }
            this.p = qVar;
            return new MDVRLibrary(this, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private boolean f2435a;

        /* renamed from: b, reason: collision with root package name */
        private int f2436b;

        /* renamed from: c, reason: collision with root package name */
        private BulletTimeMode f2437c;

        b(int i, BulletTimeMode bulletTimeMode, boolean z) {
            this.f2435a = false;
            this.f2436b = IMediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK;
            this.f2435a = z;
            this.f2436b = i;
            this.f2437c = bulletTimeMode;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d("MDVRLibrary", "BulletTimeThread enter");
            MDVRLibrary.this.m = true;
            if (MDVRLibrary.this.p != null) {
                MDVRLibrary.this.p.onStateChanged(0);
            }
            MDVRLibrary.this.e(false);
            MDVRLibrary.this.b(false);
            if (this.f2435a && (MDVRLibrary.this.i instanceof com.render.vrlib.n.d)) {
                ((com.render.vrlib.n.d) MDVRLibrary.this.i).b(false);
            }
            int i = com.render.vrlib.f.f2474a[this.f2437c.ordinal()];
            if (i == 1) {
                Log.d("BulletTimeProjection", "-- MODE_TO_RIGHT_ONLY --");
                MDVRLibrary.this.f2427b.a();
                MDVRLibrary.this.d(this.f2436b);
            } else if (i == 2) {
                Log.d("BulletTimeProjection", "-- MODE_TO_LEFT_ONLY --");
                MDVRLibrary.this.f2427b.f();
                MDVRLibrary.this.e(this.f2436b);
            } else if (i == 3) {
                Log.d("BulletTimeProjection", "-- MODE_FIRST_RIGHT_THEN_LEFT --");
                MDVRLibrary.this.f2427b.a();
                MDVRLibrary.this.d(this.f2436b);
                MDVRLibrary.this.e(this.f2436b);
            } else if (i == 4) {
                Log.d("BulletTimeProjection", "-- MODE_FIRST_RIGHT_THEN_LEFT --");
                MDVRLibrary.this.f2427b.f();
                MDVRLibrary.this.e(this.f2436b);
                MDVRLibrary.this.d(this.f2436b);
            }
            if (!MDVRLibrary.this.m) {
                Log.d("MDVRLibrary", "BulletTimeThread interrupt");
                return;
            }
            MDVRLibrary.this.b(true);
            MDVRLibrary.this.e(true);
            if (this.f2435a && (MDVRLibrary.this.i instanceof com.render.vrlib.n.d)) {
                ((com.render.vrlib.n.d) MDVRLibrary.this.i).b(true);
            }
            if (MDVRLibrary.this.p != null) {
                MDVRLibrary.this.p.onStateChanged(2);
            }
            MDVRLibrary.this.m = false;
            Log.d("MDVRLibrary", "BulletTimeThread exit");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void a(float f);

        void a(float f, float f2);

        void a(float f, float f2, float f3);
    }

    /* loaded from: classes.dex */
    public interface d {
        void onProvideBitmap(a.b bVar);
    }

    /* loaded from: classes.dex */
    public interface e {
        float a(float f);

        float b(float f);

        float c(float f);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(com.render.vrlib.w.h hVar);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onClick(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface h {
        void onNotSupport(int i);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onSurfaceDestroy();
    }

    /* loaded from: classes.dex */
    public interface j {
        void onSurfaceReady(Surface surface);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onSurfaceTexturesReady(ArrayList<com.render.vrlib.a.g> arrayList);
    }

    /* loaded from: classes.dex */
    public interface l {
        void a(com.render.vrlib.w.h hVar);
    }

    /* loaded from: classes.dex */
    public interface m {
        void onHotspotHit(com.render.vrlib.j.a.a aVar, com.render.vrlib.w.o oVar);
    }

    /* loaded from: classes.dex */
    public interface n {
        void OnBulletIndexChanged(int i);
    }

    /* loaded from: classes.dex */
    public interface o {
        void onStateChanged(int i);
    }

    /* loaded from: classes.dex */
    public interface q {
        void onStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class r implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private float f2443a;

        /* renamed from: b, reason: collision with root package name */
        private float f2444b;

        private r() {
        }

        public void a(float f, float f2) {
            this.f2443a = f;
            this.f2444b = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<com.render.vrlib.a> it2 = MDVRLibrary.this.f2429d.f().iterator();
            if (it2.hasNext()) {
                it2.next().a(this.f2443a, this.f2444b);
            }
        }

        /* synthetic */ r(MDVRLibrary mDVRLibrary, com.render.vrlib.c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class s implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private float f2446a;

        private s() {
        }

        public void a(float f) {
            this.f2446a = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<com.render.vrlib.a> it2 = MDVRLibrary.this.f2429d.f().iterator();
            while (it2.hasNext()) {
                it2.next().d(this.f2446a);
            }
        }

        /* synthetic */ s(MDVRLibrary mDVRLibrary, com.render.vrlib.c cVar) {
            this();
        }
    }

    /* synthetic */ MDVRLibrary(a aVar, com.render.vrlib.c cVar) {
        this(aVar);
    }

    private void p() {
        a(this.f2429d.h());
    }

    private void q() {
        d(1.0f);
        Iterator<com.render.vrlib.a> it2 = this.f2429d.f().iterator();
        if (it2.hasNext()) {
            it2.next().o();
        }
    }

    private void r() {
        this.j.a(new com.render.vrlib.e(this));
    }

    private void s() {
        this.h.c();
    }

    private void t() {
        Log.d("MDVRLibrary", "vr library fireDestroy");
        Iterator<com.render.vrlib.j.c> it2 = this.e.a().iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
        com.render.vrlib.j.c a2 = this.f2429d.a();
        if (a2 != null) {
            a2.b();
        }
        if (this.i != null) {
            Log.d("MDVRLibrary", "mTexture.destroy()");
            this.i.b();
            this.i.c();
            this.i = null;
        }
    }

    public boolean j() {
        return this.f2428c.f();
    }

    public boolean k() {
        return this.h.d();
    }

    public void l() {
    }

    public void m() {
        this.m = false;
        com.render.vrlib.q qVar = this.g;
        if (qVar != null) {
            qVar.d();
        }
        t();
        this.j.b();
    }

    public void n() {
        o();
        s();
        r();
        q();
    }

    public void o() {
        this.f.c();
    }

    private MDVRLibrary(a aVar) {
        this.f2426a = new RectF(0.0f, 0.0f, 1024.0f, 1024.0f);
        this.m = false;
        this.n = 0;
        this.q = null;
        com.render.vrlib.a.e.a();
        this.j = new com.render.vrlib.a.d();
        b(aVar);
        c(aVar);
        a(aVar.f2434d, aVar.p);
        com.render.vrlib.n.c cVar = aVar.f;
        this.i = cVar;
        cVar.a(aVar.w);
        this.h = new v(aVar.f2434d);
        a(aVar);
        d(aVar);
        p();
        c(aVar.f2434d);
    }

    public int d() {
        Iterator<com.render.vrlib.a> it2 = this.f2429d.f().iterator();
        if (it2.hasNext()) {
            return it2.next().e();
        }
        return -1;
    }

    public void e(float f2) {
        this.h.f(f2);
    }

    public void f(float f2) {
        this.h.d(f2);
    }

    public int g() {
        return this.f2427b.d();
    }

    public int h() {
        return this.f2429d.d();
    }

    public Rect i() {
        Iterator<com.render.vrlib.a> it2 = this.f2429d.f().iterator();
        Rect rect = null;
        while (it2.hasNext() && (rect = it2.next().i()) == null) {
        }
        return rect;
    }

    /* loaded from: classes.dex */
    private class p extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private KeyEvent f2439a;

        /* renamed from: b, reason: collision with root package name */
        private float f2440b;

        /* renamed from: c, reason: collision with root package name */
        private int f2441c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f2442d;
        private boolean e = false;

        p(KeyEvent keyEvent, int i, int i2) {
            this.f2441c = 1;
            this.f2442d = true;
            this.f2439a = keyEvent;
            this.f2441c = i2 * 100;
            this.f2440b = (i * 1.0f) / 100;
            this.f2442d = true;
        }

        public void a(KeyEvent keyEvent, int i, int i2) {
            this.f2439a = keyEvent;
            this.f2441c = i2 * 100;
            this.f2440b = (i * 1.0f) / 100;
        }

        public void b() {
            this.e = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            while (this.f2442d && this.f2441c != 0) {
                if (MDVRLibrary.this.n != 0 || this.e) {
                    switch (this.f2439a.getKeyCode()) {
                        case 19:
                            if (MDVRLibrary.this.f2427b != null && MDVRLibrary.this.h() < 215) {
                                com.render.vrlib.l.c.g gVar = MDVRLibrary.this.f2427b;
                                float f = this.f2440b;
                                gVar.a(0.0f, -f, -f);
                                break;
                            }
                            break;
                        case 20:
                            if (MDVRLibrary.this.f2427b != null && MDVRLibrary.this.h() < 215) {
                                com.render.vrlib.l.c.g gVar2 = MDVRLibrary.this.f2427b;
                                float f2 = this.f2440b;
                                gVar2.a(0.0f, f2, f2);
                                break;
                            }
                            break;
                        case 21:
                            if (MDVRLibrary.this.f2427b != null) {
                                com.render.vrlib.l.c.g gVar3 = MDVRLibrary.this.f2427b;
                                float f3 = this.f2440b;
                                gVar3.a(-f3, 0.0f, -f3);
                                break;
                            }
                            break;
                        case 22:
                            if (MDVRLibrary.this.f2427b != null) {
                                com.render.vrlib.l.c.g gVar4 = MDVRLibrary.this.f2427b;
                                float f4 = this.f2440b;
                                gVar4.a(f4, 0.0f, f4);
                                break;
                            }
                            break;
                        default:
                            com.render.vrlib.l.c.g gVar5 = MDVRLibrary.this.f2427b;
                            float f5 = this.f2440b;
                            gVar5.a(f5, 0.0f, f5);
                            break;
                    }
                    try {
                        Thread.sleep(0L);
                    } catch (InterruptedException unused) {
                    }
                    if (this.e) {
                        this.f2441c--;
                    }
                }
            }
        }

        public void a() {
            this.f2442d = false;
        }
    }

    public void b(float f2) {
        this.h.c(f2);
    }

    public void c(float f2) {
        this.h.b(f2);
    }

    public float e() {
        return this.h.b();
    }

    public int f() {
        return this.f2428c.d();
    }

    private void a(a aVar) {
        this.h = new v(aVar.f2434d);
        com.render.vrlib.c cVar = null;
        this.h.a(new com.render.vrlib.c(this, new s(this, cVar), new r(this, cVar)));
        this.h.b(aVar.h);
        this.h.a(aVar.r);
        this.h.c(aVar.t);
        this.h.a(aVar.u);
        this.h.a(true);
        this.h.d(aVar.v);
        this.g.a().setOnTouchListener(new com.render.vrlib.d(this));
        if (this.g.a() instanceof GLTextureView) {
            ((GLTextureView) this.g.a()).a(this.j);
        }
    }

    private void b(a aVar) {
        this.k = new com.render.vrlib.m();
        com.render.vrlib.p pVar = new com.render.vrlib.p();
        this.l = pVar;
        pVar.a(aVar.s);
        o.a aVar2 = new o.a();
        aVar2.f2566a = this.f2426a;
        aVar2.f2567b = aVar.m;
        aVar2.f2569d = aVar.q;
        com.render.vrlib.w.k kVar = new com.render.vrlib.w.k();
        kVar.a(this.k);
        kVar.a(this.l);
        kVar.a(aVar.e);
        kVar.a(aVar.f);
        aVar2.f2568c = kVar;
        com.render.vrlib.l.e.o oVar = new com.render.vrlib.l.e.o(aVar.f2433c, this.j, aVar2);
        this.f2429d = oVar;
        oVar.a(aVar.f2434d, aVar.g);
        com.render.vrlib.l.a.b bVar = new com.render.vrlib.l.a.b(aVar.f2431a, this.j);
        this.f2428c = bVar;
        bVar.a(aVar.j);
        this.f2428c.a(aVar.j.e());
        this.f2428c.a(aVar.f2434d, aVar.g);
        g.a aVar3 = new g.a();
        aVar3.f2518c = this.f2429d;
        aVar3.f2516a = aVar.n;
        aVar3.f2517b = aVar.o;
        com.render.vrlib.l.c.g gVar = new com.render.vrlib.l.c.g(aVar.f2432b, this.j, aVar3);
        this.f2427b = gVar;
        gVar.a(aVar.f2434d, aVar.g);
    }

    private void c(a aVar) {
        this.e = new com.render.vrlib.j.i();
    }

    public void e(boolean z) {
        this.h.b(z);
    }

    private void d(a aVar) {
        s.a d2 = com.render.vrlib.s.d();
        d2.a(this.e);
        d2.a(this.f2428c);
        d2.a(this.f2429d);
        this.f = d2.a();
        c(aVar.i);
        this.f.a(aVar.k);
        this.f.a(aVar.l);
        this.h.a(this.f.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        try {
            this.h.a();
            for (int i3 = 1; i3 < r; i3++) {
                Thread.sleep(i2);
                if (!this.m) {
                    return;
                }
                this.f2427b.a(-s, 0.0f, (-s) * i3);
            }
        } catch (InterruptedException unused) {
        }
    }

    public void c(Context context, int i2) {
        this.f2429d.a(context, i2);
        switch (i2) {
            case IRender.PROJECTION_MODE_BULLET_TIME_4 /* 215 */:
                r = 4;
                return;
            case IRender.PROJECTION_MODE_BULLET_TIME_8 /* 216 */:
                r = 8;
                return;
            case IRender.PROJECTION_MODE_BULLET_TIME_9 /* 217 */:
                r = 9;
                return;
            case IRender.PROJECTION_MODE_BULLET_TIME_16 /* 218 */:
                r = 16;
                return;
            default:
                return;
        }
    }

    public void c(boolean z) {
        this.f.a(z);
    }

    public void c(Context context) {
        this.f2427b.d(context);
        com.render.vrlib.q qVar = this.g;
        if (qVar != null) {
            qVar.b();
        }
    }

    public int c() {
        return r;
    }

    public void d(float f2) {
        this.h.a(f2);
    }

    public void d(boolean z) {
        this.h.c(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        try {
            this.h.a();
            for (int i3 = 1; i3 < r; i3++) {
                Thread.sleep(i2);
                if (!this.m) {
                    return;
                }
                this.f2427b.a(s, 0.0f, s * i3);
            }
        } catch (InterruptedException unused) {
        }
    }

    public boolean a(KeyEvent keyEvent, int i2, int i3) {
        com.render.vrlib.l.c.g gVar;
        this.h.a();
        if (h() >= 215) {
            int i4 = s;
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                com.render.vrlib.l.c.g gVar2 = this.f2427b;
                if (gVar2 != null) {
                    float f2 = -i4;
                    gVar2.a(f2, 0.0f, f2);
                }
            } else if (keyCode == 22 && (gVar = this.f2427b) != null) {
                float f3 = i4;
                gVar.a(f3, 0.0f, f3);
            }
            return false;
        }
        if (keyEvent.getAction() == 0) {
            int repeatCount = keyEvent.getRepeatCount();
            this.n = repeatCount;
            if (repeatCount == 0) {
                p pVar = this.o;
                if (pVar != null && pVar.getState() != Thread.State.TERMINATED) {
                    this.o.a();
                    this.o.interrupt();
                }
                p pVar2 = new p(keyEvent, i2, i3);
                this.o = pVar2;
                pVar2.start();
            } else {
                this.o.a(keyEvent, i2, i3);
            }
        } else if (keyEvent.getAction() == 1) {
            if (this.n == 0) {
                p pVar3 = this.o;
                if (pVar3 != null) {
                    pVar3.b();
                }
            } else {
                Log.d("MDVRLibrary", "OnKeyListener longPressEnd");
                p pVar4 = this.o;
                if (pVar4 != null && pVar4.getState() != Thread.State.TERMINATED) {
                    this.o.a();
                    this.o.interrupt();
                }
            }
        }
        return false;
    }

    public static a d(Context context) {
        return new a(context, null);
    }

    public void b(Context context, int i2) {
        this.f2427b.a(context, i2);
    }

    public void b(boolean z) {
        this.h.a(z);
    }

    public void b(Context context) {
        this.f2427b.e(context);
        com.render.vrlib.q qVar = this.g;
        if (qVar != null) {
            qVar.c();
        }
    }

    public com.render.vrlib.a.g b() {
        com.render.vrlib.n.c cVar = this.i;
        if (cVar instanceof com.render.vrlib.n.d) {
            return ((com.render.vrlib.n.d) cVar).j();
        }
        return null;
    }

    public void b(int i2) {
        com.render.vrlib.a.h.a(i2);
    }

    public void a(KeyEvent keyEvent, float f2) {
        p pVar = this.o;
        if (pVar != null && pVar.getState() != Thread.State.TERMINATED) {
            this.o.interrupt();
        }
        if (keyEvent.getAction() == 0) {
            d(f2 + e());
        }
    }

    public void a(float f2) {
        this.h.e(f2);
    }

    public void a(Rect rect) {
        Iterator<com.render.vrlib.a> it2 = this.f2429d.f().iterator();
        if (it2.hasNext()) {
            it2.next().a(rect);
        }
    }

    private void a(Context context, com.render.vrlib.q qVar) {
        if (com.render.vrlib.a.b.a(context)) {
            qVar.a(context);
            i.a a2 = com.render.vrlib.i.a(context);
            a2.a(this.j);
            a2.a(this.e);
            a2.a(this.f2429d);
            a2.a(this.f2428c);
            qVar.a(a2.a());
            this.g = qVar;
            return;
        }
        this.g.a().setVisibility(8);
        Toast.makeText(context, "OpenGLES2 not supported.", 0).show();
    }

    public void a(Context context, int i2) {
        this.f2428c.a(context, i2);
    }

    public void a(boolean z) {
        this.f2428c.a(z);
    }

    public void a(com.render.vrlib.j.c cVar) {
        this.e.a(cVar);
    }

    public void a(float f2, float f3) {
        if (this.f2426a.height() == f3 && this.f2426a.width() == f2) {
            return;
        }
        this.f2426a.set(0.0f, 0.0f, f2, f3);
        Log.d("MDVRLibrary", "jiang onTextureResize " + f2 + "  " + f3);
        Iterator<com.render.vrlib.a> it2 = this.f2429d.f().iterator();
        if (it2.hasNext()) {
            it2.next().a(this.f2426a);
        }
    }

    public void a(int i2, int i3) {
        if (this.g.a() instanceof GLTextureView) {
            ((GLTextureView) this.g.a()).onSurfaceTextureSizeChanged(null, i2, i3);
        }
    }

    public void a(Context context) {
        this.f2427b.b(context);
    }

    public void a(o oVar) {
        this.p = oVar;
    }

    public void a(int i2, boolean z) {
        if (h() < 215) {
            return;
        }
        a(i2, z, false);
    }

    public void a(int i2, boolean z, boolean z2) {
        if (z) {
            a(i2, BulletTimeMode.MODE_FIRST_RIGHT_THEN_LEFT, z2);
        } else {
            a(i2, BulletTimeMode.MODE_TO_RIGHT_ONLY, z2);
        }
    }

    public void a(int i2, BulletTimeMode bulletTimeMode) {
        if (h() < 215) {
            return;
        }
        a(i2, bulletTimeMode, false);
    }

    public void a(int i2, BulletTimeMode bulletTimeMode, boolean z) {
        if (h() < 215) {
            return;
        }
        d(1.0f);
        new Thread(new b(i2, bulletTimeMode, z)).start();
    }

    public void a(int i2) {
        d(1.0f);
        ConcurrentLinkedQueue<com.render.vrlib.a> f2 = this.f2429d.f();
        this.h.a();
        Iterator<com.render.vrlib.a> it2 = f2.iterator();
        while (it2.hasNext()) {
            it2.next().a(i2);
        }
    }

    public void a(q qVar) {
        Iterator<com.render.vrlib.a> it2 = this.f2429d.f().iterator();
        while (it2.hasNext()) {
            it2.next().a(qVar);
        }
    }

    public void a(n nVar) {
        Iterator<com.render.vrlib.a> it2 = this.f2429d.f().iterator();
        while (it2.hasNext()) {
            it2.next().a(nVar);
        }
    }

    public void a(j jVar) {
        com.render.vrlib.n.c cVar = this.i;
        if (cVar instanceof com.render.vrlib.n.d) {
            ((com.render.vrlib.n.d) cVar).a(jVar);
        }
    }

    public void a(k kVar) {
        com.render.vrlib.n.c cVar = this.i;
        if (cVar instanceof com.render.vrlib.n.d) {
            ((com.render.vrlib.n.d) cVar).a(kVar);
        }
    }

    public void a(com.render.vrlib.a.g gVar) {
        com.render.vrlib.n.c cVar = this.i;
        if (cVar instanceof com.render.vrlib.n.d) {
            ((com.render.vrlib.n.d) cVar).a(gVar);
        }
    }

    public void a(i iVar) {
        com.render.vrlib.q qVar = this.g;
        if (qVar != null) {
            if (qVar.a() instanceof GLTextureView) {
                ((GLTextureView) this.g.a()).a(iVar);
            } else if (this.g.a() instanceof GLVrSurfaceView) {
                ((GLVrSurfaceView) this.g.a()).a(iVar);
            }
        }
    }

    public void a(g gVar) {
        this.h.a(gVar);
    }

    public void a() {
        this.h.a();
    }

    public void a(float f2, float f3, float f4, int i2) {
        if (this.q == null) {
            if (i2 == 0) {
                this.q = new com.render.vrlib.w.c.a(0.0f, 0.0f, 0.0f);
            } else {
                Log.d("MDVRLibrary", "Device is not supported now !");
                return;
            }
        }
        this.q.a(f2, f3, f4);
        Iterator<com.render.vrlib.a> it2 = this.f2429d.f().iterator();
        if (it2.hasNext()) {
            it2.next().a(this.q.b());
        }
    }

    public void a(Context context, boolean z) {
        this.f2429d.a(context, z);
    }
}
