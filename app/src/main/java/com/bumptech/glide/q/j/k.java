package com.bumptech.glide.q.j;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ViewTarget.java */
/* loaded from: classes.dex */
public abstract class k<T extends View, Z> extends com.bumptech.glide.q.j.a<Z> {

    /* renamed from: d, reason: collision with root package name */
    private static Integer f2325d;

    /* renamed from: b, reason: collision with root package name */
    protected final T f2326b;

    /* renamed from: c, reason: collision with root package name */
    private final a f2327c;

    /* compiled from: ViewTarget.java */
    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final View f2328a;

        /* renamed from: b, reason: collision with root package name */
        private final List<h> f2329b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private ViewTreeObserverOnPreDrawListenerC0071a f2330c;

        /* renamed from: d, reason: collision with root package name */
        private Point f2331d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ViewTarget.java */
        /* renamed from: com.bumptech.glide.q.j.k$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class ViewTreeObserverOnPreDrawListenerC0071a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f2332a;

            public ViewTreeObserverOnPreDrawListenerC0071a(a aVar) {
                this.f2332a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
                }
                a aVar = this.f2332a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        public a(View view) {
            this.f2328a = view;
        }

        private boolean a(int i) {
            return i > 0 || i == -2;
        }

        @TargetApi(13)
        private Point b() {
            Point point = this.f2331d;
            if (point != null) {
                return point;
            }
            Display defaultDisplay = ((WindowManager) this.f2328a.getContext().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point2 = new Point();
                this.f2331d = point2;
                defaultDisplay.getSize(point2);
            } else {
                this.f2331d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
            }
            return this.f2331d;
        }

        private int c() {
            ViewGroup.LayoutParams layoutParams = this.f2328a.getLayoutParams();
            if (a(this.f2328a.getHeight())) {
                return this.f2328a.getHeight();
            }
            if (layoutParams != null) {
                return a(layoutParams.height, true);
            }
            return 0;
        }

        private int d() {
            ViewGroup.LayoutParams layoutParams = this.f2328a.getLayoutParams();
            if (a(this.f2328a.getWidth())) {
                return this.f2328a.getWidth();
            }
            if (layoutParams != null) {
                return a(layoutParams.width, false);
            }
            return 0;
        }

        private void a(int i, int i2) {
            Iterator<h> it2 = this.f2329b.iterator();
            while (it2.hasNext()) {
                it2.next().a(i, i2);
            }
            this.f2329b.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.f2329b.isEmpty()) {
                return;
            }
            int d2 = d();
            int c2 = c();
            if (a(d2) && a(c2)) {
                a(d2, c2);
                ViewTreeObserver viewTreeObserver = this.f2328a.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.f2330c);
                }
                this.f2330c = null;
            }
        }

        public void a(h hVar) {
            int d2 = d();
            int c2 = c();
            if (a(d2) && a(c2)) {
                hVar.a(d2, c2);
                return;
            }
            if (!this.f2329b.contains(hVar)) {
                this.f2329b.add(hVar);
            }
            if (this.f2330c == null) {
                ViewTreeObserver viewTreeObserver = this.f2328a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC0071a viewTreeObserverOnPreDrawListenerC0071a = new ViewTreeObserverOnPreDrawListenerC0071a(this);
                this.f2330c = viewTreeObserverOnPreDrawListenerC0071a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0071a);
            }
        }

        private int a(int i, boolean z) {
            if (i != -2) {
                return i;
            }
            Point b2 = b();
            return z ? b2.y : b2.x;
        }
    }

    public k(T t) {
        if (t != null) {
            this.f2326b = t;
            this.f2327c = new a(t);
            return;
        }
        throw new NullPointerException("View must not be null!");
    }

    private Object e() {
        Integer num = f2325d;
        if (num == null) {
            return this.f2326b.getTag();
        }
        return this.f2326b.getTag(num.intValue());
    }

    public T a() {
        return this.f2326b;
    }

    @Override // com.bumptech.glide.q.j.a, com.bumptech.glide.q.j.j
    public com.bumptech.glide.q.c d() {
        Object e = e();
        if (e == null) {
            return null;
        }
        if (e instanceof com.bumptech.glide.q.c) {
            return (com.bumptech.glide.q.c) e;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public String toString() {
        return "Target for: " + this.f2326b;
    }

    @Override // com.bumptech.glide.q.j.j
    public void a(h hVar) {
        this.f2327c.a(hVar);
    }

    @Override // com.bumptech.glide.q.j.a, com.bumptech.glide.q.j.j
    public void a(com.bumptech.glide.q.c cVar) {
        a((Object) cVar);
    }

    private void a(Object obj) {
        Integer num = f2325d;
        if (num == null) {
            this.f2326b.setTag(obj);
        } else {
            this.f2326b.setTag(num.intValue(), obj);
        }
    }
}
