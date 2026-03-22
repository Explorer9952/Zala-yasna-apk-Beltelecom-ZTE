package com.gyf.barlibrary;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;

/* compiled from: FitsKeyboard.java */
/* loaded from: classes.dex */
public class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    private final int f2369a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2370b;

    /* renamed from: c, reason: collision with root package name */
    private e f2371c;

    /* renamed from: d, reason: collision with root package name */
    private Activity f2372d;
    private Window e;
    private View f;
    private View g;
    private View h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View] */
    public c(e eVar, Activity activity, Window window) {
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.f2371c = eVar;
        this.f2372d = activity;
        this.e = window;
        View decorView = window.getDecorView();
        this.f = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(R.id.content);
        View childAt = frameLayout.getChildAt(0);
        this.h = childAt;
        if (childAt != null) {
            this.i = childAt.getPaddingLeft();
            this.j = this.h.getPaddingTop();
            this.k = this.h.getPaddingRight();
            this.l = this.h.getPaddingBottom();
        }
        ?? r3 = this.h;
        this.g = r3 != 0 ? r3 : frameLayout;
        a aVar = new a(this.f2372d);
        this.f2369a = aVar.d();
        this.f2370b = aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.e.setSoftInputMode(i);
            if (this.n) {
                return;
            }
            this.f.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.n = true;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        e eVar = this.f2371c;
        if (eVar == null || eVar.a() == null || !this.f2371c.a().u) {
            return;
        }
        int a2 = e.a(this.f2372d);
        Rect rect = new Rect();
        this.f.getWindowVisibleDisplayFrame(rect);
        int height = this.g.getHeight() - rect.bottom;
        if (height != this.m) {
            this.m = height;
            boolean z = true;
            if (e.a(this.e.getDecorView().findViewById(R.id.content))) {
                height -= a2;
                if (height <= a2) {
                    z = false;
                }
            } else if (this.h != null) {
                if (this.f2371c.a().t) {
                    height += this.f2370b;
                }
                if (this.f2371c.a().p) {
                    height += this.f2369a;
                }
                if (height > a2) {
                    i = this.l + height;
                } else {
                    i = 0;
                    z = false;
                }
                this.g.setPadding(this.i, this.j, this.k, i);
            } else {
                int b2 = this.f2371c.b();
                height -= a2;
                if (height > a2) {
                    b2 = height + a2;
                } else {
                    z = false;
                }
                this.g.setPadding(this.f2371c.c(), this.f2371c.e(), this.f2371c.d(), b2);
            }
            int i2 = height >= 0 ? height : 0;
            if (this.f2371c.a().y != null) {
                this.f2371c.a().y.a(z, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (Build.VERSION.SDK_INT < 19 || !this.n) {
            return;
        }
        if (this.h != null) {
            this.g.setPadding(this.i, this.j, this.k, this.l);
        } else {
            this.g.setPadding(this.f2371c.c(), this.f2371c.e(), this.f2371c.d(), this.f2371c.b());
        }
    }
}
