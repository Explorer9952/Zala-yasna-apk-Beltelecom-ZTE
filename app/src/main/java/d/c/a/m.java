package d.c.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import d.c.a.a;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: ValueAnimator.java */
/* loaded from: classes.dex */
public class m extends d.c.a.a {
    private static ThreadLocal<f> s = new ThreadLocal<>();
    private static final ThreadLocal<ArrayList<m>> t = new a();
    private static final ThreadLocal<ArrayList<m>> u = new b();
    private static final ThreadLocal<ArrayList<m>> v = new c();
    private static final ThreadLocal<ArrayList<m>> w = new d();
    private static final ThreadLocal<ArrayList<m>> x = new e();
    private static final Interpolator y = new AccelerateDecelerateInterpolator();
    private static long z;

    /* renamed from: b, reason: collision with root package name */
    long f7995b;
    private long g;
    k[] q;
    HashMap<String, k> r;

    /* renamed from: c, reason: collision with root package name */
    long f7996c = -1;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7997d = false;
    private int e = 0;
    private boolean f = false;
    int h = 0;
    private boolean i = false;
    boolean j = false;
    private long k = 300;
    private long l = 0;
    private int m = 0;
    private int n = 1;
    private Interpolator o = y;
    private ArrayList<g> p = null;

    /* compiled from: ValueAnimator.java */
    /* loaded from: classes.dex */
    class a extends ThreadLocal<ArrayList<m>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ArrayList<m> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: ValueAnimator.java */
    /* loaded from: classes.dex */
    class b extends ThreadLocal<ArrayList<m>> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ArrayList<m> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: ValueAnimator.java */
    /* loaded from: classes.dex */
    class c extends ThreadLocal<ArrayList<m>> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ArrayList<m> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: ValueAnimator.java */
    /* loaded from: classes.dex */
    class d extends ThreadLocal<ArrayList<m>> {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ArrayList<m> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: ValueAnimator.java */
    /* loaded from: classes.dex */
    class e extends ThreadLocal<ArrayList<m>> {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ArrayList<m> initialValue() {
            return new ArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ValueAnimator.java */
    /* loaded from: classes.dex */
    public static class f extends Handler {
        private f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z;
            ArrayList arrayList = (ArrayList) m.t.get();
            ArrayList arrayList2 = (ArrayList) m.v.get();
            int i = message.what;
            if (i == 0) {
                ArrayList arrayList3 = (ArrayList) m.u.get();
                boolean z2 = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        m mVar = (m) arrayList4.get(i2);
                        if (mVar.l == 0) {
                            mVar.m();
                        } else {
                            arrayList2.add(mVar);
                        }
                    }
                }
                z = z2;
            } else if (i != 1) {
                return;
            } else {
                z = true;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) m.x.get();
            ArrayList arrayList6 = (ArrayList) m.w.get();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                m mVar2 = (m) arrayList2.get(i3);
                if (mVar2.d(currentAnimationTimeMillis)) {
                    arrayList5.add(mVar2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i4 = 0; i4 < size3; i4++) {
                    m mVar3 = (m) arrayList5.get(i4);
                    mVar3.m();
                    mVar3.i = true;
                    arrayList2.remove(mVar3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i5 = 0;
            while (i5 < size4) {
                m mVar4 = (m) arrayList.get(i5);
                if (mVar4.b(currentAnimationTimeMillis)) {
                    arrayList6.add(mVar4);
                }
                if (arrayList.size() == size4) {
                    i5++;
                } else {
                    size4--;
                    arrayList6.remove(mVar4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i6 = 0; i6 < arrayList6.size(); i6++) {
                    ((m) arrayList6.get(i6)).l();
                }
                arrayList6.clear();
            }
            if (z) {
                if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                    return;
                }
                sendEmptyMessageDelayed(1, Math.max(0L, m.z - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }

        /* synthetic */ f(f fVar) {
            this();
        }
    }

    /* compiled from: ValueAnimator.java */
    /* loaded from: classes.dex */
    public interface g {
        void a(m mVar);
    }

    static {
        new d.c.a.f();
        new d.c.a.d();
        z = 10L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        ArrayList<a.InterfaceC0407a> arrayList;
        t.get().remove(this);
        u.get().remove(this);
        v.get().remove(this);
        this.h = 0;
        if (this.i && (arrayList = this.f7958a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                ((a.InterfaceC0407a) arrayList2.get(i)).c(this);
            }
        }
        this.i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ArrayList<a.InterfaceC0407a> arrayList;
        d();
        t.get().add(this);
        if (this.l <= 0 || (arrayList = this.f7958a) == null) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            ((a.InterfaceC0407a) arrayList2.get(i)).b(this);
        }
    }

    public void c(long j) {
        d();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.h != 1) {
            this.f7996c = j;
            this.h = 2;
        }
        this.f7995b = currentAnimationTimeMillis - j;
        b(currentAnimationTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.j) {
            return;
        }
        int length = this.q.length;
        for (int i = 0; i < length; i++) {
            this.q[i].c();
        }
        this.j = true;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.q != null) {
            for (int i = 0; i < this.q.length; i++) {
                str = String.valueOf(str) + "\n    " + this.q[i].toString();
            }
        }
        return str;
    }

    public static m b(float... fArr) {
        m mVar = new m();
        mVar.a(fArr);
        return mVar;
    }

    @Override // d.c.a.a
    /* renamed from: clone */
    public m m12clone() {
        m mVar = (m) super.m12clone();
        ArrayList<g> arrayList = this.p;
        if (arrayList != null) {
            mVar.p = new ArrayList<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                mVar.p.add(arrayList.get(i));
            }
        }
        mVar.f7996c = -1L;
        mVar.f7997d = false;
        mVar.e = 0;
        mVar.j = false;
        mVar.h = 0;
        mVar.f = false;
        k[] kVarArr = this.q;
        if (kVarArr != null) {
            int length = kVarArr.length;
            mVar.q = new k[length];
            mVar.r = new HashMap<>(length);
            for (int i2 = 0; i2 < length; i2++) {
                k m16clone = kVarArr[i2].m16clone();
                mVar.q[i2] = m16clone;
                mVar.r.put(m16clone.b(), m16clone);
            }
        }
        return mVar;
    }

    public void a(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        k[] kVarArr = this.q;
        if (kVarArr == null || kVarArr.length == 0) {
            a(k.a("", fArr));
        } else {
            kVarArr[0].a(fArr);
        }
        this.j = false;
    }

    @Override // d.c.a.a
    public void b() {
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(long j) {
        if (!this.f) {
            this.f = true;
            this.g = j;
            return false;
        }
        long j2 = j - this.g;
        long j3 = this.l;
        if (j2 <= j3) {
            return false;
        }
        this.f7995b = j - (j2 - j3);
        this.h = 1;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean b(long r10) {
        /*
            r9 = this;
            int r0 = r9.h
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L1a
            r9.h = r3
            long r4 = r9.f7996c
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L12
            r9.f7995b = r10
            goto L1a
        L12:
            long r4 = r10 - r4
            r9.f7995b = r4
            r4 = -1
            r9.f7996c = r4
        L1a:
            int r0 = r9.h
            r4 = 2
            r5 = 0
            if (r0 == r3) goto L23
            if (r0 == r4) goto L23
            goto L83
        L23:
            long r6 = r9.k
            r0 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 <= 0) goto L32
            long r1 = r9.f7995b
            long r10 = r10 - r1
            float r10 = (float) r10
            float r11 = (float) r6
            float r10 = r10 / r11
            goto L34
        L32:
            r10 = 1065353216(0x3f800000, float:1.0)
        L34:
            int r11 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r11 < 0) goto L78
            int r11 = r9.e
            int r1 = r9.m
            if (r11 < r1) goto L47
            r11 = -1
            if (r1 != r11) goto L42
            goto L47
        L42:
            float r10 = java.lang.Math.min(r10, r0)
            goto L79
        L47:
            java.util.ArrayList<d.c.a.a$a> r11 = r9.f7958a
            if (r11 == 0) goto L61
            int r11 = r11.size()
            r1 = 0
        L50:
            if (r1 < r11) goto L53
            goto L61
        L53:
            java.util.ArrayList<d.c.a.a$a> r2 = r9.f7958a
            java.lang.Object r2 = r2.get(r1)
            d.c.a.a$a r2 = (d.c.a.a.InterfaceC0407a) r2
            r2.a(r9)
            int r1 = r1 + 1
            goto L50
        L61:
            int r11 = r9.n
            if (r11 != r4) goto L6a
            boolean r11 = r9.f7997d
            r11 = r11 ^ r3
            r9.f7997d = r11
        L6a:
            int r11 = r9.e
            int r1 = (int) r10
            int r11 = r11 + r1
            r9.e = r11
            float r10 = r10 % r0
            long r1 = r9.f7995b
            long r3 = r9.k
            long r1 = r1 + r3
            r9.f7995b = r1
        L78:
            r3 = 0
        L79:
            boolean r11 = r9.f7997d
            if (r11 == 0) goto L7f
            float r10 = r0 - r10
        L7f:
            r9.a(r10)
            r5 = r3
        L83:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.a.m.b(long):boolean");
    }

    public long c() {
        if (!this.j || this.h == 0) {
            return 0L;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f7995b;
    }

    public void a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        k[] kVarArr = this.q;
        if (kVarArr == null || kVarArr.length == 0) {
            a(k.a("", (l) null, objArr));
        } else {
            kVarArr[0].a(objArr);
        }
        this.j = false;
    }

    public void a(k... kVarArr) {
        int length = kVarArr.length;
        this.q = kVarArr;
        this.r = new HashMap<>(length);
        for (k kVar : kVarArr) {
            this.r.put(kVar.b(), kVar);
        }
        this.j = false;
    }

    @Override // d.c.a.a
    public m a(long j) {
        if (j >= 0) {
            this.k = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    public void a(g gVar) {
        if (this.p == null) {
            this.p = new ArrayList<>();
        }
        this.p.add(gVar);
    }

    @Override // d.c.a.a
    public void a(Interpolator interpolator) {
        if (interpolator != null) {
            this.o = interpolator;
        } else {
            this.o = new LinearInterpolator();
        }
    }

    public void a(l lVar) {
        k[] kVarArr;
        if (lVar == null || (kVarArr = this.q) == null || kVarArr.length <= 0) {
            return;
        }
        kVarArr[0].a(lVar);
    }

    private void a(boolean z2) {
        if (Looper.myLooper() != null) {
            this.f7997d = z2;
            this.e = 0;
            this.h = 0;
            this.f = false;
            u.get().add(this);
            if (this.l == 0) {
                c(c());
                this.h = 0;
                this.i = true;
                ArrayList<a.InterfaceC0407a> arrayList = this.f7958a;
                if (arrayList != null) {
                    ArrayList arrayList2 = (ArrayList) arrayList.clone();
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        ((a.InterfaceC0407a) arrayList2.get(i)).b(this);
                    }
                }
            }
            f fVar = s.get();
            if (fVar == null) {
                fVar = new f(null);
                s.set(fVar);
            }
            fVar.sendEmptyMessage(0);
            return;
        }
        throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f2) {
        float interpolation = this.o.getInterpolation(f2);
        int length = this.q.length;
        for (int i = 0; i < length; i++) {
            this.q[i].a(interpolation);
        }
        ArrayList<g> arrayList = this.p;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.p.get(i2).a(this);
            }
        }
    }
}
