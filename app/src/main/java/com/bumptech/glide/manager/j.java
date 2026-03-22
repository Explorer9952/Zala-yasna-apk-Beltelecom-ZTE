package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.r;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever.java */
/* loaded from: classes.dex */
public class j implements Handler.Callback {
    private static final j e = new j();

    /* renamed from: a, reason: collision with root package name */
    private volatile com.bumptech.glide.k f2256a;

    /* renamed from: b, reason: collision with root package name */
    final Map<FragmentManager, RequestManagerFragment> f2257b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final Map<androidx.fragment.app.FragmentManager, m> f2258c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Handler f2259d = new Handler(Looper.getMainLooper(), this);

    j() {
    }

    public static j a() {
        return e;
    }

    private com.bumptech.glide.k b(Context context) {
        if (this.f2256a == null) {
            synchronized (this) {
                if (this.f2256a == null) {
                    this.f2256a = new com.bumptech.glide.k(context.getApplicationContext(), new b(), new f());
                }
            }
        }
        return this.f2256a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        int i = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.f2257b.remove(obj);
        } else if (i == 2) {
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.f2258c.remove(obj);
        } else {
            z = false;
            obj2 = null;
            if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z;
        }
        Object obj4 = obj;
        obj3 = remove;
        obj2 = obj4;
        if (z) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }

    public com.bumptech.glide.k a(Context context) {
        if (context != null) {
            if (com.bumptech.glide.s.h.d() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return a((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return a((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return a(((ContextWrapper) context).getBaseContext());
                }
            }
            return b(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @TargetApi(17)
    private static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public com.bumptech.glide.k a(FragmentActivity fragmentActivity) {
        if (com.bumptech.glide.s.h.c()) {
            return a(fragmentActivity.getApplicationContext());
        }
        b((Activity) fragmentActivity);
        return a(fragmentActivity, fragmentActivity.getSupportFragmentManager());
    }

    public com.bumptech.glide.k a(Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (com.bumptech.glide.s.h.c()) {
                return a(fragment.getActivity().getApplicationContext());
            }
            return a(fragment.getActivity(), fragment.getChildFragmentManager());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    @TargetApi(11)
    public com.bumptech.glide.k a(Activity activity) {
        if (!com.bumptech.glide.s.h.c() && Build.VERSION.SDK_INT >= 11) {
            b(activity);
            return a(activity, activity.getFragmentManager());
        }
        return a(activity.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(17)
    public RequestManagerFragment a(FragmentManager fragmentManager) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment != null) {
            return requestManagerFragment;
        }
        RequestManagerFragment requestManagerFragment2 = this.f2257b.get(fragmentManager);
        if (requestManagerFragment2 != null) {
            return requestManagerFragment2;
        }
        RequestManagerFragment requestManagerFragment3 = new RequestManagerFragment();
        this.f2257b.put(fragmentManager, requestManagerFragment3);
        fragmentManager.beginTransaction().add(requestManagerFragment3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f2259d.obtainMessage(1, fragmentManager).sendToTarget();
        return requestManagerFragment3;
    }

    @TargetApi(11)
    com.bumptech.glide.k a(Context context, FragmentManager fragmentManager) {
        RequestManagerFragment a2 = a(fragmentManager);
        com.bumptech.glide.k b2 = a2.b();
        if (b2 != null) {
            return b2;
        }
        com.bumptech.glide.k kVar = new com.bumptech.glide.k(context, a2.a(), a2.c());
        a2.a(kVar);
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m a(androidx.fragment.app.FragmentManager fragmentManager) {
        m mVar = (m) fragmentManager.c("com.bumptech.glide.manager");
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = this.f2258c.get(fragmentManager);
        if (mVar2 != null) {
            return mVar2;
        }
        m mVar3 = new m();
        this.f2258c.put(fragmentManager, mVar3);
        r b2 = fragmentManager.b();
        b2.a(mVar3, "com.bumptech.glide.manager");
        b2.b();
        this.f2259d.obtainMessage(2, fragmentManager).sendToTarget();
        return mVar3;
    }

    com.bumptech.glide.k a(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        m a2 = a(fragmentManager);
        com.bumptech.glide.k u = a2.u();
        if (u != null) {
            return u;
        }
        com.bumptech.glide.k kVar = new com.bumptech.glide.k(context, a2.getLifecycle(), a2.v());
        a2.a(kVar);
        return kVar;
    }
}
