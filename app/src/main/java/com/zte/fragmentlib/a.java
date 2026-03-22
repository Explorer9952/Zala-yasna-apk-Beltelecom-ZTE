package com.zte.fragmentlib;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import androidx.fragment.app.s;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.helper.FragmentResultRecord;
import com.zte.iptvclient.android.mobile.n.b.f;
import java.util.List;

/* compiled from: Fragmentation.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private SupportActivity f4038a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f4039b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Fragmentation.java */
    /* renamed from: com.zte.fragmentlib.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0107a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.fragmentlib.b f4040a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FragmentResultRecord f4041b;

        RunnableC0107a(a aVar, com.zte.fragmentlib.b bVar, FragmentResultRecord fragmentResultRecord) {
            this.f4040a = bVar;
            this.f4041b = fragmentResultRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.zte.fragmentlib.b bVar = this.f4040a;
            FragmentResultRecord fragmentResultRecord = this.f4041b;
            bVar.a(fragmentResultRecord.f4062a, fragmentResultRecord.f4063b, fragmentResultRecord.f4064c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Fragmentation.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentManager f4042a;

        b(a aVar, FragmentManager fragmentManager) {
            this.f4042a = fragmentManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.a(this.f4042a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Fragmentation.java */
    /* loaded from: classes.dex */
    public class c implements com.zte.fragmentlib.helper.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f4043a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f4044b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewGroup f4045c;

        c(a aVar, ViewGroup viewGroup, View view, ViewGroup viewGroup2) {
            this.f4043a = viewGroup;
            this.f4044b = view;
            this.f4045c = viewGroup2;
        }

        @Override // com.zte.fragmentlib.helper.d
        public void a() {
            this.f4043a.removeView(this.f4044b);
            ViewGroup viewGroup = this.f4045c;
            if (viewGroup instanceof LinearLayout) {
                viewGroup.addView(this.f4044b, 0);
            } else {
                viewGroup.addView(this.f4044b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Fragmentation.java */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f4046a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f4047b;

        d(a aVar, ViewGroup viewGroup, View view) {
            this.f4046a = viewGroup;
            this.f4047b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4046a.removeView(this.f4047b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Fragmentation.java */
    /* loaded from: classes.dex */
    public class e implements com.zte.fragmentlib.helper.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f4048a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f4049b;

        e(a aVar, ViewGroup viewGroup, View view) {
            this.f4048a = viewGroup;
            this.f4049b = view;
        }

        @Override // com.zte.fragmentlib.helper.c
        public void a() {
            this.f4048a.removeView(this.f4049b);
        }
    }

    public a(SupportActivity supportActivity) {
        this.f4038a = supportActivity;
        this.f4039b = supportActivity.j();
    }

    public void a(FragmentManager fragmentManager, int i, com.zte.fragmentlib.b bVar) {
        a(i, bVar);
        a(fragmentManager, null, bVar, 0, 0, 0, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(FragmentManager fragmentManager, int i, com.zte.fragmentlib.b bVar) {
        a(i, bVar);
        String name = bVar.getClass().getName();
        r b2 = fragmentManager.b();
        b2.a(0);
        b2.a(bVar.getArguments().getInt("fragmentation_arg_container"), bVar, name);
        Bundle arguments = bVar.getArguments();
        arguments.putBoolean("fragmentation_arg_is_root", true);
        arguments.putBoolean("fragmentation_arg_is_shared_element", true);
        b2.a(name);
        b2.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(FragmentManager fragmentManager, int i, com.zte.fragmentlib.b bVar) {
        List<Fragment> u = fragmentManager.u();
        if (u != null) {
            u.clear();
        }
        String name = bVar.getClass().getName();
        a(i, bVar);
        r b2 = fragmentManager.b();
        b2.a(0);
        b2.b(bVar.getArguments().getInt("fragmentation_arg_container"), bVar, name);
        bVar.getArguments().putBoolean("fragmentation_arg_is_root", true);
        b2.a(name);
        b2.b();
        fragmentManager.p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FragmentManager fragmentManager, int i, com.zte.fragmentlib.b bVar, com.zte.fragmentlib.b bVar2) {
        String name = bVar.getClass().getName();
        if (bVar.isAdded()) {
            a(fragmentManager, bVar, bVar2);
            return;
        }
        a(i, bVar);
        r b2 = fragmentManager.b();
        b2.a(0);
        if (bVar2 != null) {
            b2.c(bVar2);
        }
        b2.a(bVar.getArguments().getInt("fragmentation_arg_container"), bVar, name);
        bVar.getArguments().putBoolean("fragmentation_arg_is_root", true);
        b2.a(name);
        b2.b();
        fragmentManager.p();
    }

    void b(FragmentManager fragmentManager, int i, com.zte.fragmentlib.b bVar, boolean z) {
        a(i, bVar);
        r b2 = fragmentManager.b();
        b2.b(i, bVar, bVar.getClass().getName());
        if (z) {
            b2.a(bVar.getClass().getName());
        }
        bVar.getArguments().putBoolean("fragmentation_arg_is_root", true);
        b2.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FragmentManager fragmentManager, int i, com.zte.fragmentlib.b bVar, boolean z) {
        b(fragmentManager, i, bVar, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FragmentManager fragmentManager, int i, int i2, List<com.zte.fragmentlib.b> list) {
        r b2 = fragmentManager.b();
        b2.a(4097);
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.zte.fragmentlib.b bVar = list.get(i3);
            a(i, list.get(i3));
            b2.a(i, bVar, bVar.getClass().getName());
            if (i3 != i2) {
                b2.c(bVar);
            }
            bVar.getArguments().putBoolean("fragmentation_arg_is_root", true);
        }
        b2.b();
    }

    void b(FragmentManager fragmentManager, com.zte.fragmentlib.b bVar, com.zte.fragmentlib.b bVar2) {
        r b2;
        com.zte.fragmentlib.b a2 = a((Fragment) bVar);
        r b3 = fragmentManager.b();
        b3.d(bVar);
        b3.b();
        a(fragmentManager, true);
        String name = bVar2.getClass().getName();
        if (!(bVar2 instanceof f) && !(bVar2 instanceof com.zte.iptvclient.android.mobile.o.a.a)) {
            b2 = fragmentManager.b();
            b2.a(0);
            b2.a(bVar.u(), bVar2, name);
            b2.a(name);
        } else {
            b2 = fragmentManager.b();
            b2.a(4097);
            b2.a(bVar.u(), bVar2, name);
            b2.a(name);
        }
        if (a2 != null) {
            b2.c(a2);
        }
        b2.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FragmentManager fragmentManager, com.zte.fragmentlib.b bVar, com.zte.fragmentlib.b bVar2, int i, int i2, int i3, View view, String str) {
        if (view != null) {
            s.a(fragmentManager);
        }
        if (i3 == 2) {
            a(bVar2, i);
        }
        if (bVar != null) {
            a(bVar.u(), bVar2);
        }
        if (a(fragmentManager, bVar2, i2)) {
            return;
        }
        this.f4038a.b(false);
        if (i3 != 0) {
            if (i3 == 1) {
                if (bVar != null) {
                    b(fragmentManager, bVar, bVar2);
                    return;
                }
                throw new RuntimeException("startWithPop(): getTopFragment() is null");
            }
            if (i3 != 2) {
                return;
            }
        }
        a(fragmentManager, bVar, bVar2, view, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.zte.fragmentlib.b b(FragmentManager fragmentManager) {
        List<Fragment> u;
        if (fragmentManager == null || (u = fragmentManager.u()) == null) {
            return null;
        }
        for (int size = u.size() - 1; size >= 0; size--) {
            Fragment fragment = u.get(size);
            if (fragment instanceof com.zte.fragmentlib.b) {
                return (com.zte.fragmentlib.b) fragment;
            }
        }
        return null;
    }

    private void a(int i, com.zte.fragmentlib.b bVar) {
        Bundle arguments = bVar.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            bVar.setArguments(arguments);
        }
        arguments.putInt("fragmentation_arg_container", i);
    }

    private boolean b(Fragment fragment) {
        if (!(fragment instanceof com.zte.fragmentlib.b)) {
            return false;
        }
        com.zte.fragmentlib.b bVar = (com.zte.fragmentlib.b) fragment;
        bVar.b(bVar.w());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FragmentManager fragmentManager, com.zte.fragmentlib.b bVar, com.zte.fragmentlib.b bVar2) {
        if (bVar.equals(bVar2)) {
            return;
        }
        r b2 = fragmentManager.b();
        b2.e(bVar);
        b2.c(bVar2);
        b2.b();
    }

    void a(FragmentManager fragmentManager, com.zte.fragmentlib.b bVar, com.zte.fragmentlib.b bVar2, View view, String str) {
        String name = bVar2.getClass().getName();
        r b2 = fragmentManager.b();
        if (view == null) {
            b2.a(4097);
        } else {
            bVar2.getArguments().putBoolean("fragmentation_arg_is_shared_element", true);
            b2.a(view, str);
        }
        if (bVar == null) {
            b2.a(bVar2.getArguments().getInt("fragmentation_arg_container"), bVar2, name);
            bVar2.getArguments().putBoolean("fragmentation_arg_is_root", true);
        } else {
            b2.a(bVar.u(), bVar2, name);
            b2.c(bVar);
        }
        b2.a(name);
        b2.b();
    }

    com.zte.fragmentlib.b a(Fragment fragment) {
        List<Fragment> u = fragment.getFragmentManager().u();
        if (u == null) {
            return null;
        }
        for (int indexOf = u.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
            Fragment fragment2 = u.get(indexOf);
            if (fragment2 instanceof com.zte.fragmentlib.b) {
                return (com.zte.fragmentlib.b) fragment2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T extends com.zte.fragmentlib.b> T a(Class<T> cls, FragmentManager fragmentManager, boolean z) {
        Fragment c2;
        if (z) {
            List<Fragment> u = fragmentManager.u();
            if (u != null) {
                int size = u.size() - 1;
                while (true) {
                    if (size < 0) {
                        c2 = null;
                        break;
                    }
                    c2 = u.get(size);
                    if ((c2 instanceof com.zte.fragmentlib.b) && c2.getClass() == cls) {
                        break;
                    }
                    size--;
                }
            } else {
                return null;
            }
        } else {
            c2 = fragmentManager.c(cls.getName());
        }
        if (c2 == null) {
            return null;
        }
        return (T) c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.zte.fragmentlib.b a(com.zte.fragmentlib.b bVar, FragmentManager fragmentManager) {
        List<Fragment> u = fragmentManager.u();
        if (u == null) {
            return bVar;
        }
        for (int size = u.size() - 1; size >= 0; size--) {
            Fragment fragment = u.get(size);
            if (fragment instanceof com.zte.fragmentlib.b) {
                com.zte.fragmentlib.b bVar2 = (com.zte.fragmentlib.b) fragment;
                if (!bVar2.isHidden() && bVar2.getUserVisibleHint()) {
                    return a(bVar2, bVar2.getChildFragmentManager());
                }
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(com.zte.fragmentlib.b bVar) {
        if (bVar != null) {
            return bVar.D() || a((com.zte.fragmentlib.b) bVar.getParentFragment());
        }
        return false;
    }

    private boolean a(FragmentManager fragmentManager, com.zte.fragmentlib.b bVar, int i) {
        com.zte.fragmentlib.b b2 = b(fragmentManager);
        if (b2 != null) {
            if (i == 1) {
                if ((bVar.equals(b2) || bVar.getClass() == b2.getClass()) && b(bVar)) {
                    return true;
                }
            } else if (i == 2 && a((Class) bVar.getClass(), fragmentManager, false) != null) {
                a(bVar.getClass(), 0, fragmentManager);
                if (b(bVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(Fragment fragment, int i) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            fragment.setArguments(arguments);
        }
        FragmentResultRecord fragmentResultRecord = new FragmentResultRecord();
        fragmentResultRecord.f4062a = i;
        arguments.putParcelable("fragment_arg_result_record", fragmentResultRecord);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FragmentManager fragmentManager) {
        if (fragmentManager != null && fragmentManager.q() > 1) {
            a(fragmentManager, false);
        }
    }

    private void a(FragmentManager fragmentManager, boolean z) {
        FragmentResultRecord fragmentResultRecord;
        List<Fragment> u = fragmentManager.u();
        if (u == null) {
            return;
        }
        boolean z2 = false;
        FragmentResultRecord fragmentResultRecord2 = null;
        long j = 0;
        for (int size = u.size() - 1; size >= 0; size--) {
            Fragment fragment = u.get(size);
            if (fragment instanceof com.zte.fragmentlib.b) {
                com.zte.fragmentlib.b bVar = (com.zte.fragmentlib.b) fragment;
                if (!z2) {
                    Bundle arguments = bVar.getArguments();
                    if (arguments == null || !arguments.containsKey("fragment_arg_result_record") || (fragmentResultRecord = (FragmentResultRecord) arguments.getParcelable("fragment_arg_result_record")) == null) {
                        break;
                    }
                    j = bVar.v();
                    fragmentResultRecord2 = fragmentResultRecord;
                    z2 = true;
                } else {
                    long x = bVar.x();
                    if (z) {
                        fragmentManager.F();
                    } else {
                        fragmentManager.G();
                    }
                    this.f4039b.postDelayed(new RunnableC0107a(this, bVar, fragmentResultRecord2), Math.max(x, j));
                    return;
                }
            }
        }
        fragmentManager.F();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Class<?> cls, boolean z, Runnable runnable, FragmentManager fragmentManager) {
        int i;
        if (fragmentManager == null) {
            return;
        }
        Fragment c2 = fragmentManager.c(cls.getName());
        if (c2 == null) {
            LogEx.e("Fragmentation", "Pop failure! Can't find " + cls.getSimpleName() + " in the FragmentManager's Stack.");
            return;
        }
        if (z) {
            i = 1;
            c2 = a(c2);
        } else {
            i = 0;
        }
        com.zte.fragmentlib.b b2 = b(fragmentManager);
        if (runnable != null) {
            if (b2 != null) {
                if (b2.equals(c2)) {
                    this.f4039b.post(runnable);
                    return;
                }
                a(c2, b2);
            }
            a(cls, i, fragmentManager);
            this.f4039b.post(runnable);
            return;
        }
        a(cls, i, fragmentManager);
    }

    private void a(Class<?> cls, int i, FragmentManager fragmentManager) {
        if (fragmentManager.u() == null) {
            return;
        }
        this.f4038a.p();
        fragmentManager.a(cls.getName(), i);
        this.f4038a.o();
        this.f4039b.post(new b(this, fragmentManager));
    }

    private void a(Fragment fragment, com.zte.fragmentlib.b bVar) {
        if (fragment != null) {
            a(bVar, fragment.getView(), (com.zte.fragmentlib.b) null);
        }
    }

    private void a(com.zte.fragmentlib.b bVar, View view, com.zte.fragmentlib.b bVar2) {
        com.zte.fragmentlib.b a2;
        View view2;
        View view3;
        if (view != null) {
            ViewGroup viewGroup = null;
            if (bVar2 == null) {
                try {
                    if (Build.VERSION.SDK_INT < 21) {
                        a2 = a((Fragment) bVar);
                        if (a2 != null && (view2 = a2.getView()) != null && (view2 instanceof ViewGroup)) {
                            viewGroup = (ViewGroup) view2;
                        }
                        view.setVisibility(0);
                        view3 = bVar.getView();
                        if (view3 == null && (view instanceof ViewGroup)) {
                            ViewGroup viewGroup2 = (ViewGroup) view;
                            ViewGroup viewGroup3 = (ViewGroup) this.f4038a.findViewById(bVar.u());
                            if (viewGroup3 != null) {
                                viewGroup3.removeView(view3);
                                ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                                if (layoutParams != null && layoutParams.height != -1) {
                                    layoutParams.height = -1;
                                }
                                if (viewGroup != null) {
                                    a2.a(new c(this, viewGroup, view3, viewGroup2));
                                }
                                if (viewGroup2 instanceof LinearLayout) {
                                    if (viewGroup != null) {
                                        viewGroup.addView(view3, 0);
                                    } else {
                                        viewGroup2.addView(view3, 0);
                                    }
                                } else if (viewGroup != null) {
                                    viewGroup.addView(view3);
                                } else {
                                    viewGroup2.addView(view3);
                                }
                                if (bVar2 == null) {
                                    this.f4039b.postDelayed(new d(this, viewGroup2, view3), Math.max(bVar.v(), 300L));
                                    return;
                                } else {
                                    bVar2.a(new e(this, viewGroup2, view3));
                                    return;
                                }
                            }
                            return;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            a2 = null;
            view.setVisibility(0);
            view3 = bVar.getView();
            if (view3 == null) {
            }
        }
    }
}
