package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import java.util.HashSet;

@TargetApi(11)
/* loaded from: classes.dex */
public class RequestManagerFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.manager.a f2244a;

    /* renamed from: b, reason: collision with root package name */
    private final k f2245b;

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.k f2246c;

    /* renamed from: d, reason: collision with root package name */
    private final HashSet<RequestManagerFragment> f2247d;
    private RequestManagerFragment e;

    /* loaded from: classes.dex */
    private class b implements k {
        private b(RequestManagerFragment requestManagerFragment) {
        }
    }

    public RequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    public void a(com.bumptech.glide.k kVar) {
        this.f2246c = kVar;
    }

    public com.bumptech.glide.k b() {
        return this.f2246c;
    }

    public k c() {
        return this.f2245b;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        RequestManagerFragment a2 = j.a().a(getActivity().getFragmentManager());
        this.e = a2;
        if (a2 != this) {
            a2.a(this);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f2244a.a();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        RequestManagerFragment requestManagerFragment = this.e;
        if (requestManagerFragment != null) {
            requestManagerFragment.b(this);
            this.e = null;
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        com.bumptech.glide.k kVar = this.f2246c;
        if (kVar != null) {
            kVar.e();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f2244a.b();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f2244a.c();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        com.bumptech.glide.k kVar = this.f2246c;
        if (kVar != null) {
            kVar.a(i);
        }
    }

    @SuppressLint({"ValidFragment"})
    RequestManagerFragment(com.bumptech.glide.manager.a aVar) {
        this.f2245b = new b();
        this.f2247d = new HashSet<>();
        this.f2244a = aVar;
    }

    private void b(RequestManagerFragment requestManagerFragment) {
        this.f2247d.remove(requestManagerFragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.manager.a a() {
        return this.f2244a;
    }

    private void a(RequestManagerFragment requestManagerFragment) {
        this.f2247d.add(requestManagerFragment);
    }
}
