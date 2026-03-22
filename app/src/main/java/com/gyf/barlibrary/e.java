package com.gyf.barlibrary;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.facebook.internal.Utility;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImmersionBar.java */
@TargetApi(19)
/* loaded from: classes.dex */
public class e {
    private static final int t = R$id.immersion_status_bar_view;
    private static final int u = R$id.immersion_navigation_bar_view;
    private static Map<String, e> v = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private Activity f2377a;

    /* renamed from: b, reason: collision with root package name */
    private Window f2378b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f2379c;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f2380d;
    private com.gyf.barlibrary.b e;
    private com.gyf.barlibrary.a f;
    private int g = 0;
    private int h = 0;
    private boolean i = false;
    private ContentObserver j = null;
    private com.gyf.barlibrary.c k = null;
    private boolean l;
    private int m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImmersionBar.java */
    /* loaded from: classes.dex */
    public class a extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2381a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Handler handler, View view) {
            super(handler);
            this.f2381a = view;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            int i;
            if (e.this.e.w && e.this.e.x) {
                e eVar = e.this;
                eVar.f = new com.gyf.barlibrary.a(eVar.f2377a);
                int paddingBottom = e.this.f2380d.getPaddingBottom();
                int paddingRight = e.this.f2380d.getPaddingRight();
                if (e.this.f2377a != null && e.this.f2377a.getContentResolver() != null) {
                    if (Settings.System.getInt(e.this.f2377a.getContentResolver(), "navigationbar_is_min", 0) != 1) {
                        if (e.this.g == 0) {
                            e eVar2 = e.this;
                            eVar2.g = eVar2.f.b();
                        }
                        if (e.this.h == 0) {
                            e eVar3 = e.this;
                            eVar3.h = eVar3.f.c();
                        }
                        if (!e.this.e.g) {
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2381a.getLayoutParams();
                            if (e.this.f.f()) {
                                layoutParams.height = e.this.g;
                                layoutParams.gravity = 80;
                                i = e.this.g;
                                paddingRight = 0;
                            } else {
                                layoutParams.width = e.this.h;
                                layoutParams.gravity = 8388613;
                                paddingRight = e.this.h;
                                i = 0;
                            }
                            this.f2381a.setLayoutParams(layoutParams);
                            this.f2381a.setVisibility(0);
                            paddingBottom = i;
                        }
                    } else {
                        this.f2381a.setVisibility(8);
                        paddingBottom = 0;
                        paddingRight = 0;
                    }
                }
                e eVar4 = e.this;
                eVar4.a(0, eVar4.f2380d.getPaddingTop(), paddingRight, paddingBottom);
                return;
            }
            this.f2381a.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImmersionBar.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f2383a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2384b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f2385c;

        b(ViewGroup.LayoutParams layoutParams, View view, Activity activity) {
            this.f2383a = layoutParams;
            this.f2384b = view;
            this.f2385c = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2383a.height = this.f2384b.getHeight() + e.b(this.f2385c);
            View view = this.f2384b;
            view.setPadding(view.getPaddingLeft(), this.f2384b.getPaddingTop() + e.b(this.f2385c), this.f2384b.getPaddingRight(), this.f2384b.getPaddingBottom());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImmersionBar.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2386a;

        static {
            int[] iArr = new int[BarHide.values().length];
            f2386a = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2386a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2386a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2386a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private e(Activity activity) {
        new HashMap();
        this.l = false;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.f2377a = activity;
        this.f2378b = activity.getWindow();
        this.f2377a.toString();
        this.e = new com.gyf.barlibrary.b();
        ViewGroup viewGroup = (ViewGroup) this.f2378b.getDecorView();
        this.f2379c = viewGroup;
        this.f2380d = (ViewGroup) viewGroup.findViewById(R.id.content);
    }

    private void g() {
        if (Build.VERSION.SDK_INT >= 19) {
            if (!this.i) {
                if (this.e.u) {
                    if (this.k == null) {
                        this.k = new com.gyf.barlibrary.c(this, this.f2377a, this.f2378b);
                    }
                    this.k.a(this.e.v);
                    return;
                } else {
                    com.gyf.barlibrary.c cVar = this.k;
                    if (cVar != null) {
                        cVar.a();
                        return;
                    }
                    return;
                }
            }
            e eVar = v.get(this.f2377a.toString());
            if (eVar != null) {
                if (eVar.e.u) {
                    if (eVar.k == null) {
                        eVar.k = new com.gyf.barlibrary.c(eVar, eVar.f2377a, eVar.f2378b);
                    }
                    eVar.k.a(eVar.e.v);
                } else {
                    com.gyf.barlibrary.c cVar2 = eVar.k;
                    if (cVar2 != null) {
                        cVar2.a();
                    }
                }
            }
        }
    }

    private void h() {
        if (Build.VERSION.SDK_INT < 19 || this.l) {
            return;
        }
        int i = this.m;
        if (i == 1) {
            b(this.f2377a, this.e.q);
            this.l = true;
        } else if (i == 2) {
            c(this.f2377a, this.e.q);
            this.l = true;
        } else {
            if (i != 3) {
                return;
            }
            a(this.f2377a, this.e.r);
            this.l = true;
        }
    }

    private void i() {
        if (Build.VERSION.SDK_INT < 28 || this.o) {
            return;
        }
        WindowManager.LayoutParams attributes = this.f2378b.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        this.f2378b.setAttributes(attributes);
        this.o = true;
    }

    private void j() {
        if (Build.VERSION.SDK_INT >= 21 && !g.g()) {
            k();
            return;
        }
        l();
        if (this.i || !g.h()) {
            return;
        }
        m();
    }

    private void k() {
        if (a(this.f2379c.findViewById(R.id.content))) {
            if (this.e.t) {
                a(0, this.f.a(), 0, 0);
            }
        } else {
            int d2 = (this.e.p && this.m == 4) ? this.f.d() : 0;
            if (this.e.t) {
                d2 = this.f.d() + this.f.a();
            }
            a(0, d2, 0, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void l() {
        /*
            r5 = this;
            android.view.ViewGroup r0 = r5.f2379c
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r1)
            boolean r0 = a(r0)
            r1 = 0
            if (r0 == 0) goto L20
            com.gyf.barlibrary.b r0 = r5.e
            boolean r0 = r0.t
            if (r0 == 0) goto L1f
            com.gyf.barlibrary.a r0 = r5.f
            int r0 = r0.a()
            r5.a(r1, r0, r1, r1)
        L1f:
            return
        L20:
            com.gyf.barlibrary.b r0 = r5.e
            boolean r0 = r0.p
            if (r0 == 0) goto L32
            int r0 = r5.m
            r2 = 4
            if (r0 != r2) goto L32
            com.gyf.barlibrary.a r0 = r5.f
            int r0 = r0.d()
            goto L33
        L32:
            r0 = 0
        L33:
            com.gyf.barlibrary.b r2 = r5.e
            boolean r2 = r2.t
            if (r2 == 0) goto L46
            com.gyf.barlibrary.a r0 = r5.f
            int r0 = r0.d()
            com.gyf.barlibrary.a r2 = r5.f
            int r2 = r2.a()
            int r0 = r0 + r2
        L46:
            com.gyf.barlibrary.a r2 = r5.f
            boolean r2 = r2.e()
            if (r2 == 0) goto L96
            com.gyf.barlibrary.b r2 = r5.e
            boolean r3 = r2.w
            if (r3 == 0) goto L96
            boolean r3 = r2.x
            if (r3 == 0) goto L96
            boolean r2 = r2.f
            if (r2 != 0) goto L74
            com.gyf.barlibrary.a r2 = r5.f
            boolean r2 = r2.f()
            if (r2 == 0) goto L6d
            com.gyf.barlibrary.a r2 = r5.f
            int r2 = r2.b()
            r3 = r2
            r2 = 0
            goto L76
        L6d:
            com.gyf.barlibrary.a r2 = r5.f
            int r2 = r2.c()
            goto L75
        L74:
            r2 = 0
        L75:
            r3 = 0
        L76:
            com.gyf.barlibrary.b r4 = r5.e
            boolean r4 = r4.g
            if (r4 == 0) goto L87
            com.gyf.barlibrary.a r4 = r5.f
            boolean r4 = r4.f()
            if (r4 == 0) goto L85
            goto L97
        L85:
            r2 = 0
            goto L98
        L87:
            com.gyf.barlibrary.a r4 = r5.f
            boolean r4 = r4.f()
            if (r4 != 0) goto L98
            com.gyf.barlibrary.a r2 = r5.f
            int r2 = r2.c()
            goto L98
        L96:
            r2 = 0
        L97:
            r3 = 0
        L98:
            r5.a(r1, r0, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.barlibrary.e.l():void");
    }

    private void m() {
        View findViewById = this.f2379c.findViewById(u);
        if (findViewById == null || this.j != null) {
            return;
        }
        this.j = new a(new Handler(), findViewById);
        Activity activity = this.f2377a;
        if (activity == null || activity.getContentResolver() == null || this.j == null) {
            return;
        }
        this.f2377a.getContentResolver().registerContentObserver(Settings.System.getUriFor("navigationbar_is_min"), true, this.j);
    }

    private void n() {
        this.f2378b.addFlags(67108864);
        r();
        if (this.f.e() || g.g() || g.f()) {
            com.gyf.barlibrary.b bVar = this.e;
            if (bVar.w && bVar.x) {
                this.f2378b.addFlags(134217728);
            } else {
                this.f2378b.clearFlags(134217728);
            }
            if (this.g == 0) {
                this.g = this.f.b();
            }
            if (this.h == 0) {
                this.h = this.f.c();
            }
            q();
        }
    }

    public static boolean o() {
        return g.l() || g.j() || Build.VERSION.SDK_INT >= 23;
    }

    private void p() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            int i2 = 256;
            if (i >= 21 && !g.g()) {
                i();
                i2 = c(d(b(256)));
            } else {
                n();
            }
            int a2 = a(i2);
            j();
            this.f2379c.setSystemUiVisibility(a2);
        }
        if (g.l()) {
            a(this.f2378b, this.e.i);
        }
        if (g.j()) {
            com.gyf.barlibrary.b bVar = this.e;
            int i3 = bVar.s;
            if (i3 != 0) {
                d.a(this.f2377a, i3);
            } else if (Build.VERSION.SDK_INT < 23) {
                d.a(this.f2377a, bVar.i);
            }
        }
    }

    private void q() {
        FrameLayout.LayoutParams layoutParams;
        View findViewById = this.f2379c.findViewById(u);
        if (findViewById == null) {
            findViewById = new View(this.f2377a);
            findViewById.setId(u);
            this.f2379c.addView(findViewById);
        }
        if (this.f.f()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f.b());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f.c(), -1);
            layoutParams.gravity = 8388613;
        }
        findViewById.setLayoutParams(layoutParams);
        com.gyf.barlibrary.b bVar = this.e;
        findViewById.setBackgroundColor(androidx.core.graphics.a.a(bVar.f2366b, bVar.m, bVar.e));
        com.gyf.barlibrary.b bVar2 = this.e;
        if (bVar2.w && bVar2.x && !bVar2.g) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    private void r() {
        View findViewById = this.f2379c.findViewById(t);
        if (findViewById == null) {
            findViewById = new View(this.f2377a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f.d());
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(t);
            this.f2379c.addView(findViewById);
        }
        com.gyf.barlibrary.b bVar = this.e;
        if (bVar.k) {
            findViewById.setBackgroundColor(androidx.core.graphics.a.a(bVar.f2365a, bVar.l, bVar.f2368d));
        } else {
            findViewById.setBackgroundColor(androidx.core.graphics.a.a(bVar.f2365a, 0, bVar.f2368d));
        }
    }

    private void s() {
        if (this.e.n.size() != 0) {
            for (Map.Entry<View, Map<Integer, Integer>> entry : this.e.n.entrySet()) {
                View key = entry.getKey();
                Map<Integer, Integer> value = entry.getValue();
                Integer valueOf = Integer.valueOf(this.e.f2365a);
                Integer valueOf2 = Integer.valueOf(this.e.l);
                for (Map.Entry<Integer, Integer> entry2 : value.entrySet()) {
                    Integer key2 = entry2.getKey();
                    valueOf2 = entry2.getValue();
                    valueOf = key2;
                }
                if (key != null) {
                    if (Math.abs(this.e.o - 0.0f) == 0.0f) {
                        key.setBackgroundColor(androidx.core.graphics.a.a(valueOf.intValue(), valueOf2.intValue(), this.e.f2368d));
                    } else {
                        key.setBackgroundColor(androidx.core.graphics.a.a(valueOf.intValue(), valueOf2.intValue(), this.e.o));
                    }
                }
            }
        }
    }

    private void t() {
        e eVar;
        if (Build.VERSION.SDK_INT >= 19) {
            this.f = new com.gyf.barlibrary.a(this.f2377a);
            if (!this.i || (eVar = v.get(this.f2377a.toString())) == null) {
                return;
            }
            eVar.e = this.e;
        }
    }

    public static e c(Activity activity) {
        e eVar = v.get(activity.toString());
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(activity);
        v.put(activity.toString(), eVar2);
        return eVar2;
    }

    private int d(int i) {
        return (Build.VERSION.SDK_INT < 23 || !this.e.i) ? i : i | Utility.DEFAULT_STREAM_BUFFER_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.q;
    }

    public void f() {
        t();
        p();
        h();
        g();
        s();
    }

    private int b(int i) {
        if (!this.n) {
            this.e.f2367c = this.f2378b.getNavigationBarColor();
            this.n = true;
        }
        int i2 = i | Util.BYTE_OF_KB;
        com.gyf.barlibrary.b bVar = this.e;
        if (bVar.f && bVar.w) {
            i2 |= 512;
        }
        this.f2378b.clearFlags(67108864);
        if (this.f.e()) {
            this.f2378b.clearFlags(134217728);
        }
        this.f2378b.addFlags(Integer.MIN_VALUE);
        com.gyf.barlibrary.b bVar2 = this.e;
        if (bVar2.k) {
            this.f2378b.setStatusBarColor(androidx.core.graphics.a.a(bVar2.f2365a, bVar2.l, bVar2.f2368d));
        } else {
            this.f2378b.setStatusBarColor(androidx.core.graphics.a.a(bVar2.f2365a, 0, bVar2.f2368d));
        }
        com.gyf.barlibrary.b bVar3 = this.e;
        if (bVar3.w) {
            this.f2378b.setNavigationBarColor(androidx.core.graphics.a.a(bVar3.f2366b, bVar3.m, bVar3.e));
        } else {
            this.f2378b.setNavigationBarColor(bVar3.f2367c);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.r;
    }

    private int c(int i) {
        return (Build.VERSION.SDK_INT < 26 || !this.e.j) ? i : i | 16;
    }

    public e a(boolean z) {
        a(z, 0.0f);
        return this;
    }

    public e a(boolean z, float f) {
        com.gyf.barlibrary.b bVar = this.e;
        bVar.i = z;
        if (!z) {
            bVar.s = 0;
        }
        if (o()) {
            this.e.f2368d = 0.0f;
        } else {
            this.e.f2368d = f;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.p;
    }

    public static void c(Activity activity, View view) {
        if (activity == null || view == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + b(activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
    }

    private int a(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            int i2 = c.f2386a[this.e.h.ordinal()];
            if (i2 == 1) {
                i |= 518;
            } else if (i2 == 2) {
                i |= 1028;
            } else if (i2 == 3) {
                i |= 514;
            } else if (i2 == 4) {
                i |= 0;
            }
        }
        return i | 4096;
    }

    @SuppressLint({"PrivateApi"})
    private void a(Window window, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.s;
    }

    public static void b(Activity activity, View view) {
        if (activity == null || view == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = layoutParams.height;
        if (i != -2 && i != -1) {
            layoutParams.height = i + b(activity);
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + b(activity), view.getPaddingRight(), view.getPaddingBottom());
        } else {
            view.post(new b(layoutParams, view, activity));
        }
    }

    public com.gyf.barlibrary.b a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4) {
        ViewGroup viewGroup = this.f2380d;
        if (viewGroup != null) {
            viewGroup.setPadding(i, i2, i3, i4);
        }
        this.p = i;
        this.q = i2;
        this.r = i3;
        this.s = i4;
    }

    @TargetApi(14)
    public static int b(Activity activity) {
        return new com.gyf.barlibrary.a(activity).d();
    }

    public static void a(Activity activity, View view) {
        if (activity == null || view == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = b(activity);
        view.setLayoutParams(layoutParams);
    }

    public static boolean a(View view) {
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (!(childAt instanceof DrawerLayout) && childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    @TargetApi(14)
    public static int a(Activity activity) {
        return new com.gyf.barlibrary.a(activity).b();
    }
}
