package net.lucode.hackware.magicindicator.e.c.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* compiled from: CommonPagerTitleView.java */
/* loaded from: classes2.dex */
public class a extends FrameLayout implements net.lucode.hackware.magicindicator.e.c.b.b {

    /* renamed from: a, reason: collision with root package name */
    private b f8251a;

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC0425a f8252b;

    /* compiled from: CommonPagerTitleView.java */
    /* renamed from: net.lucode.hackware.magicindicator.e.c.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0425a {
        int a();

        int b();

        int c();

        int d();
    }

    /* compiled from: CommonPagerTitleView.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(int i, int i2);

        void a(int i, int i2, float f, boolean z);

        void b(int i, int i2);

        void b(int i, int i2, float f, boolean z);
    }

    public a(Context context) {
        super(context);
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.d
    public void a(int i, int i2) {
        b bVar = this.f8251a;
        if (bVar != null) {
            bVar.a(i, i2);
        }
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.d
    public void b(int i, int i2) {
        b bVar = this.f8251a;
        if (bVar != null) {
            bVar.b(i, i2);
        }
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.b
    public int c() {
        InterfaceC0425a interfaceC0425a = this.f8252b;
        if (interfaceC0425a != null) {
            return interfaceC0425a.c();
        }
        return getLeft();
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.b
    public int d() {
        InterfaceC0425a interfaceC0425a = this.f8252b;
        if (interfaceC0425a != null) {
            return interfaceC0425a.d();
        }
        return getRight();
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.d
    public void a(int i, int i2, float f, boolean z) {
        b bVar = this.f8251a;
        if (bVar != null) {
            bVar.a(i, i2, f, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.d
    public void b(int i, int i2, float f, boolean z) {
        b bVar = this.f8251a;
        if (bVar != null) {
            bVar.b(i, i2, f, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.b
    public int a() {
        InterfaceC0425a interfaceC0425a = this.f8252b;
        if (interfaceC0425a != null) {
            return interfaceC0425a.a();
        }
        return getTop();
    }

    @Override // net.lucode.hackware.magicindicator.e.c.b.b
    public int b() {
        InterfaceC0425a interfaceC0425a = this.f8252b;
        if (interfaceC0425a != null) {
            return interfaceC0425a.b();
        }
        return getBottom();
    }

    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        removeAllViews();
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            addView(view, layoutParams);
        }
    }

    public void a(int i) {
        a(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null), (FrameLayout.LayoutParams) null);
    }

    public void a(b bVar) {
        this.f8251a = bVar;
    }
}
