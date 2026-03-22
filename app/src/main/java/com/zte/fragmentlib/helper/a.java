package com.zte.fragmentlib.helper;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.zte.fragmentlib.anim.FragmentAnimator;
import com.zte.iptvclient.android.zala.R;

/* compiled from: AnimatorHelper.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Animation f4065a;

    /* renamed from: b, reason: collision with root package name */
    private Animation f4066b;

    /* renamed from: c, reason: collision with root package name */
    public Animation f4067c;

    /* renamed from: d, reason: collision with root package name */
    public Animation f4068d;
    public Animation e;
    public Animation f;
    private Context g;
    private FragmentAnimator h;

    /* compiled from: AnimatorHelper.java */
    /* renamed from: com.zte.fragmentlib.helper.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0109a extends Animation {
        C0109a(a aVar) {
        }
    }

    public a(Context context, FragmentAnimator fragmentAnimator) {
        this.g = context;
        this.h = fragmentAnimator;
        c();
        d();
        e();
        f();
    }

    private Animation c() {
        FragmentAnimator fragmentAnimator = this.h;
        if (fragmentAnimator == null) {
            this.f4067c = b();
        } else if (fragmentAnimator.a() == 0) {
            this.f4067c = b();
        } else {
            this.f4067c = AnimationUtils.loadAnimation(this.g, this.h.a());
        }
        return this.f4067c;
    }

    private Animation d() {
        FragmentAnimator fragmentAnimator = this.h;
        if (fragmentAnimator == null) {
            this.f4068d = b();
        } else if (fragmentAnimator.b() == 0) {
            this.f4068d = b();
        } else {
            this.f4068d = AnimationUtils.loadAnimation(this.g, this.h.b());
        }
        return this.f4068d;
    }

    private Animation e() {
        FragmentAnimator fragmentAnimator = this.h;
        if (fragmentAnimator == null) {
            this.e = b();
        } else if (fragmentAnimator.c() == 0) {
            this.e = b();
        } else {
            this.e = AnimationUtils.loadAnimation(this.g, this.h.c());
        }
        return this.e;
    }

    private Animation f() {
        FragmentAnimator fragmentAnimator = this.h;
        if (fragmentAnimator == null) {
            this.f = AnimationUtils.loadAnimation(this.g, R.anim.pop_exit_no_anim);
        } else if (fragmentAnimator.d() == 0) {
            this.f = AnimationUtils.loadAnimation(this.g, R.anim.pop_exit_no_anim);
        } else {
            this.f = AnimationUtils.loadAnimation(this.g, this.h.d());
        }
        return this.f;
    }

    public Animation a() {
        if (this.f4066b == null) {
            this.f4066b = new C0109a(this);
        }
        return this.f4066b;
    }

    public Animation b() {
        if (this.f4065a == null) {
            this.f4065a = AnimationUtils.loadAnimation(this.g, R.anim.no_anim);
        }
        return this.f4065a;
    }
}
