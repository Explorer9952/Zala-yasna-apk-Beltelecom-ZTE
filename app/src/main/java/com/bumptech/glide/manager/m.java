package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.fragment.app.Fragment;
import java.util.HashSet;

/* compiled from: SupportRequestManagerFragment.java */
/* loaded from: classes.dex */
public class m extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.k f2263a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.manager.a f2264b;

    /* renamed from: c, reason: collision with root package name */
    private final k f2265c;

    /* renamed from: d, reason: collision with root package name */
    private final HashSet<m> f2266d;
    private m e;

    /* compiled from: SupportRequestManagerFragment.java */
    /* loaded from: classes.dex */
    private class b implements k {
        private b(m mVar) {
        }
    }

    public m() {
        this(new com.bumptech.glide.manager.a());
    }

    private void b(m mVar) {
        this.f2266d.remove(mVar);
    }

    public void a(com.bumptech.glide.k kVar) {
        this.f2263a = kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.manager.a getLifecycle() {
        return this.f2264b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        m a2 = j.a().a(getActivity().getSupportFragmentManager());
        this.e = a2;
        if (a2 != this) {
            a2.a(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f2264b.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        m mVar = this.e;
        if (mVar != null) {
            mVar.b(this);
            this.e = null;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        com.bumptech.glide.k kVar = this.f2263a;
        if (kVar != null) {
            kVar.e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f2264b.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f2264b.c();
    }

    public com.bumptech.glide.k u() {
        return this.f2263a;
    }

    public k v() {
        return this.f2265c;
    }

    @SuppressLint({"ValidFragment"})
    public m(com.bumptech.glide.manager.a aVar) {
        this.f2265c = new b();
        this.f2266d = new HashSet<>();
        this.f2264b = aVar;
    }

    private void a(m mVar) {
        this.f2266d.add(mVar);
    }
}
