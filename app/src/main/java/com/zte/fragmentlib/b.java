package com.zte.fragmentlib;

import android.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.r;
import com.zte.fragmentlib.anim.FragmentAnimator;
import com.zte.fragmentlib.helper.c;
import com.zte.fragmentlib.helper.d;
import java.util.List;

/* compiled from: SupportFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.publicbaseclass.skinloader.a {

    /* renamed from: a, reason: collision with root package name */
    private Bundle f4054a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4055b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4056c;
    private InputMethodManager e;
    private boolean f;
    private c g;
    protected SupportActivity h;
    protected com.zte.fragmentlib.a i;
    private int j;
    private FragmentAnimator k;
    private com.zte.fragmentlib.helper.a l;
    private d n;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4057d = true;
    private boolean m = false;
    protected boolean o = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SupportFragment.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f4058a;

        a(Bundle bundle) {
            this.f4058a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f4058a);
        }
    }

    /* compiled from: SupportFragment.java */
    /* renamed from: com.zte.fragmentlib.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0108b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f4060a;

        RunnableC0108b(View view) {
            this.f4060a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.e.showSoftInput(this.f4060a, 2);
        }
    }

    private void I() {
        com.zte.fragmentlib.helper.a aVar = new com.zte.fragmentlib.helper.a(this.h.getApplicationContext(), this.k);
        this.l = aVar;
        if (aVar.f4067c.equals(aVar.b())) {
            this.m = true;
        }
        this.l.f4067c.setAnimationListener(new com.zte.fragmentlib.helper.b(this));
    }

    private void J() {
        SupportActivity supportActivity;
        if (this.e != null || (supportActivity = this.h) == null) {
            return;
        }
        this.e = (InputMethodManager) supportActivity.getSystemService("input_method");
    }

    private void c(Bundle bundle) {
        this.h.j().post(new a(bundle));
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            r b2 = getFragmentManager().b();
            if (B()) {
                b2.c(this);
            } else {
                b2.e(this);
            }
            b2.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A() {
        if (getView() != null) {
            J();
            this.e.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        }
    }

    public boolean B() {
        return this.f4057d;
    }

    public final void C() {
        c((Bundle) null);
        this.h.b(true);
        c cVar = this.g;
        if (cVar != null) {
            cVar.a();
        }
    }

    public boolean D() {
        return false;
    }

    protected FragmentAnimator E() {
        return this.h.g();
    }

    public void F() {
        this.i.a(getFragmentManager());
    }

    public void G() {
        this.i.a(getChildFragmentManager());
    }

    protected boolean H() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, int i2, Bundle bundle) {
    }

    protected void a(Bundle bundle) {
    }

    protected void a(View view) {
        b(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Bundle bundle) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View view = getView();
        a(view);
        if (view != null) {
            view.setClickable(true);
        }
        if (bundle != null) {
            c(bundle);
            this.h.b(true);
        } else if (this.m) {
            c((Bundle) null);
            this.h.b(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof SupportActivity) {
            SupportActivity supportActivity = (SupportActivity) activity;
            this.h = supportActivity;
            this.i = supportActivity.h();
        } else {
            throw new RuntimeException(activity.toString() + "must extends SupportActivity!");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = this.h.getWindow();
        if (window != null) {
            window.setSoftInputMode(32);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.getBoolean("enable_title_back")) {
                this.o = true;
            }
            this.f4055b = arguments.getBoolean("fragmentation_arg_is_root", false);
            this.f4056c = arguments.getBoolean("fragmentation_arg_is_shared_element", false);
            this.j = arguments.getInt("fragmentation_arg_container");
        }
        if (bundle == null) {
            FragmentAnimator E = E();
            this.k = E;
            if (E == null) {
                this.k = this.h.g();
            }
        } else {
            this.k = (FragmentAnimator) bundle.getParcelable("fragmentation_state_save_animator");
            this.f4057d = bundle.getBoolean("fragmentation_state_save_status");
        }
        if (H()) {
            d(bundle);
        }
        I();
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        if (Build.VERSION.SDK_INT < 16) {
            this.m = true;
            return this.l.b();
        }
        if (this.h.f) {
            if (i == 8194 && z) {
                return this.l.a();
            }
            return this.l.b();
        }
        if (i == 4097) {
            if (z) {
                if (this.f4055b) {
                    this.m = true;
                    return this.l.b();
                }
                return this.l.f4067c;
            }
            return this.l.f;
        }
        if (i == 8194) {
            if (z) {
                return this.l.e;
            }
            return this.l.f4068d;
        }
        if (this.f4056c) {
            if (z) {
                this.m = true;
            } else if (getEnterTransition() == null) {
                return this.l.f4068d;
            }
        }
        return super.onCreateAnimation(i, z, i2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.g = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        d dVar = this.n;
        if (dVar != null) {
            dVar.a();
        }
        super.onDestroyView();
        this.n = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f) {
            A();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("fragmentation_state_save_animator", this.k);
        bundle.putBoolean("fragmentation_state_save_status", isHidden());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int u() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long v() {
        com.zte.fragmentlib.helper.a aVar = this.l;
        if (aVar == null) {
            return 300L;
        }
        return aVar.f4068d.getDuration();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle w() {
        return this.f4054a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long x() {
        com.zte.fragmentlib.helper.a aVar = this.l;
        if (aVar == null) {
            return 300L;
        }
        return aVar.e.getDuration();
    }

    public b y() {
        return this.i.b(getChildFragmentManager());
    }

    protected int z() {
        TypedArray obtainStyledAttributes = this.h.getTheme().obtainStyledAttributes(new int[]{R.attr.windowBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public void a(int i, b bVar) {
        this.i.a(getChildFragmentManager(), i, bVar);
    }

    protected void b(View view) {
        if (view == null || view.getBackground() != null) {
            return;
        }
        int f = this.h.f();
        if (f == 0) {
            view.setBackgroundResource(z());
        } else {
            view.setBackgroundResource(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view) {
        if (view == null) {
            return;
        }
        J();
        view.requestFocus();
        this.f = true;
        view.postDelayed(new RunnableC0108b(view), 200L);
    }

    public void a(int i, b bVar, b bVar2) {
        this.i.a(getChildFragmentManager(), i, bVar, bVar2);
    }

    public void a(int i, b bVar, boolean z) {
        this.i.a(getChildFragmentManager(), i, bVar, z);
    }

    public void a(int i, int i2, List<b> list) {
        this.i.a(getChildFragmentManager(), i, i2, list);
    }

    public void a(b bVar, b bVar2) {
        this.i.a(getChildFragmentManager(), bVar, bVar2);
    }

    public void c(int i, b bVar) {
        this.i.c(getChildFragmentManager(), i, bVar);
    }

    public void a(b bVar) {
        a(bVar, 0);
    }

    public void b(int i, b bVar) {
        this.i.b(getChildFragmentManager(), i, bVar);
    }

    public void a(b bVar, int i) {
        this.i.a(getFragmentManager(), this, bVar, 0, i, 0, null, null);
    }

    public <T extends b> T a(Class<T> cls) {
        return (T) this.i.a((Class) cls, getChildFragmentManager(), true);
    }

    public void a(Class<?> cls, boolean z) {
        a(cls, z, (Runnable) null);
    }

    public void a(Class<?> cls, boolean z, Runnable runnable) {
        this.i.a(cls, z, runnable, getChildFragmentManager());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.g = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        this.n = dVar;
    }
}
