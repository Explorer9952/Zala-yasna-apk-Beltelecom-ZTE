package net.lucode.hackware.magicindicator.e.c;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.R$id;
import net.lucode.hackware.magicindicator.R$layout;
import net.lucode.hackware.magicindicator.b;
import net.lucode.hackware.magicindicator.e.c.b.c;
import net.lucode.hackware.magicindicator.e.c.b.d;

/* compiled from: CommonNavigator.java */
/* loaded from: classes2.dex */
public class a extends FrameLayout implements net.lucode.hackware.magicindicator.d.a, b.a {

    /* renamed from: a, reason: collision with root package name */
    private HorizontalScrollView f8237a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayout f8238b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f8239c;

    /* renamed from: d, reason: collision with root package name */
    private c f8240d;
    private net.lucode.hackware.magicindicator.e.c.b.a e;
    private b f;
    private boolean g;
    private boolean h;
    private float i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private List<net.lucode.hackware.magicindicator.e.c.d.a> p;
    private DataSetObserver q;

    /* compiled from: CommonNavigator.java */
    /* renamed from: net.lucode.hackware.magicindicator.e.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0424a extends DataSetObserver {
        C0424a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a.this.f.c(a.this.e.a());
            a.this.d();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
        }
    }

    public a(Context context) {
        super(context);
        this.i = 0.5f;
        this.j = true;
        this.k = true;
        this.o = true;
        this.p = new ArrayList();
        this.q = new C0424a();
        b bVar = new b();
        this.f = bVar;
        bVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        View inflate;
        removeAllViews();
        if (this.g) {
            inflate = LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout_no_scroll, this);
        } else {
            inflate = LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout, this);
        }
        this.f8237a = (HorizontalScrollView) inflate.findViewById(R$id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.title_container);
        this.f8238b = linearLayout;
        linearLayout.setPadding(this.m, 0, this.l, 0);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R$id.indicator_container);
        this.f8239c = linearLayout2;
        if (this.n) {
            linearLayout2.getParent().bringChildToFront(this.f8239c);
        }
        e();
    }

    private void e() {
        LinearLayout.LayoutParams layoutParams;
        int c2 = this.f.c();
        for (int i = 0; i < c2; i++) {
            Object a2 = this.e.a(getContext(), i);
            if (a2 instanceof View) {
                View view = (View) a2;
                if (this.g) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.e.b(getContext(), i);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                this.f8238b.addView(view, layoutParams);
            }
        }
        net.lucode.hackware.magicindicator.e.c.b.a aVar = this.e;
        if (aVar != null) {
            c a3 = aVar.a(getContext());
            this.f8240d = a3;
            if (a3 instanceof View) {
                this.f8239c.addView((View) this.f8240d, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        this.p.clear();
        int c2 = this.f.c();
        for (int i = 0; i < c2; i++) {
            net.lucode.hackware.magicindicator.e.c.d.a aVar = new net.lucode.hackware.magicindicator.e.c.d.a();
            View childAt = this.f8238b.getChildAt(i);
            if (childAt != 0) {
                aVar.f8247a = childAt.getLeft();
                aVar.f8248b = childAt.getTop();
                aVar.f8249c = childAt.getRight();
                int bottom = childAt.getBottom();
                aVar.f8250d = bottom;
                if (childAt instanceof net.lucode.hackware.magicindicator.e.c.b.b) {
                    net.lucode.hackware.magicindicator.e.c.b.b bVar = (net.lucode.hackware.magicindicator.e.c.b.b) childAt;
                    aVar.e = bVar.c();
                    aVar.f = bVar.a();
                    aVar.g = bVar.d();
                    aVar.h = bVar.b();
                } else {
                    aVar.e = aVar.f8247a;
                    aVar.f = aVar.f8248b;
                    aVar.g = aVar.f8249c;
                    aVar.h = bottom;
                }
            }
            this.p.add(aVar);
        }
    }

    @Override // net.lucode.hackware.magicindicator.d.a
    public void b() {
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.e != null) {
            f();
            c cVar = this.f8240d;
            if (cVar != null) {
                cVar.a(this.p);
            }
            if (this.o && this.f.b() == 0) {
                b(this.f.a());
                a(this.f.a(), 0.0f, 0);
            }
        }
    }

    public void a(boolean z) {
        this.g = z;
    }

    @Override // net.lucode.hackware.magicindicator.d.a
    public void b(int i) {
        if (this.e != null) {
            this.f.b(i);
            c cVar = this.f8240d;
            if (cVar != null) {
                cVar.b(i);
            }
        }
    }

    public net.lucode.hackware.magicindicator.e.c.b.a c() {
        return this.e;
    }

    public void a(net.lucode.hackware.magicindicator.e.c.b.a aVar) {
        net.lucode.hackware.magicindicator.e.c.b.a aVar2 = this.e;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.b(this.q);
        }
        this.e = aVar;
        if (aVar != null) {
            aVar.a(this.q);
            this.f.c(this.e.a());
            if (this.f8238b != null) {
                this.e.b();
                return;
            }
            return;
        }
        this.f.c(0);
        d();
    }

    public void c(boolean z) {
        this.j = z;
    }

    @Override // net.lucode.hackware.magicindicator.b.a
    public void b(int i, int i2, float f, boolean z) {
        LinearLayout linearLayout = this.f8238b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i);
        if (childAt instanceof d) {
            ((d) childAt).b(i, i2, f, z);
        }
    }

    public void b(boolean z) {
        this.f.a(z);
    }

    @Override // net.lucode.hackware.magicindicator.b.a
    public void b(int i, int i2) {
        LinearLayout linearLayout = this.f8238b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i);
        if (childAt instanceof d) {
            ((d) childAt).b(i, i2);
        }
        if (this.g || this.k || this.f8237a == null || this.p.size() <= 0) {
            return;
        }
        net.lucode.hackware.magicindicator.e.c.d.a aVar = this.p.get(Math.min(this.p.size() - 1, i));
        if (this.h) {
            float a2 = aVar.a() - (this.f8237a.getWidth() * this.i);
            if (this.j) {
                this.f8237a.smoothScrollTo((int) a2, 0);
                return;
            } else {
                this.f8237a.scrollTo((int) a2, 0);
                return;
            }
        }
        int scrollX = this.f8237a.getScrollX();
        int i3 = aVar.f8247a;
        if (scrollX > i3) {
            if (this.j) {
                this.f8237a.smoothScrollTo(i3, 0);
                return;
            } else {
                this.f8237a.scrollTo(i3, 0);
                return;
            }
        }
        int scrollX2 = this.f8237a.getScrollX() + getWidth();
        int i4 = aVar.f8249c;
        if (scrollX2 < i4) {
            if (this.j) {
                this.f8237a.smoothScrollTo(i4 - getWidth(), 0);
            } else {
                this.f8237a.scrollTo(i4 - getWidth(), 0);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.d.a
    public void a(int i, float f, int i2) {
        if (this.e != null) {
            this.f.a(i, f, i2);
            c cVar = this.f8240d;
            if (cVar != null) {
                cVar.a(i, f, i2);
            }
            if (this.f8237a == null || this.p.size() <= 0 || i < 0 || i >= this.p.size() || !this.k) {
                return;
            }
            int min = Math.min(this.p.size() - 1, i);
            int min2 = Math.min(this.p.size() - 1, i + 1);
            net.lucode.hackware.magicindicator.e.c.d.a aVar = this.p.get(min);
            net.lucode.hackware.magicindicator.e.c.d.a aVar2 = this.p.get(min2);
            float a2 = aVar.a() - (this.f8237a.getWidth() * this.i);
            this.f8237a.scrollTo((int) (a2 + (((aVar2.a() - (this.f8237a.getWidth() * this.i)) - a2) * f)), 0);
        }
    }

    public void a(float f) {
        this.i = f;
    }

    @Override // net.lucode.hackware.magicindicator.d.a
    public void a(int i) {
        if (this.e != null) {
            this.f.a(i);
            c cVar = this.f8240d;
            if (cVar != null) {
                cVar.a(i);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.d.a
    public void a() {
        d();
    }

    @Override // net.lucode.hackware.magicindicator.b.a
    public void a(int i, int i2, float f, boolean z) {
        LinearLayout linearLayout = this.f8238b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i);
        if (childAt instanceof d) {
            ((d) childAt).a(i, i2, f, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.b.a
    public void a(int i, int i2) {
        LinearLayout linearLayout = this.f8238b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i);
        if (childAt instanceof d) {
            ((d) childAt).a(i, i2);
        }
    }
}
