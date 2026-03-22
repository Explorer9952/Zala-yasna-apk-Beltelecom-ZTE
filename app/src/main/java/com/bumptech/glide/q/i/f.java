package com.bumptech.glide.q.i;

import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.q.i.c;

/* compiled from: ViewAnimation.java */
/* loaded from: classes.dex */
public class f<R> implements c<R> {

    /* renamed from: a, reason: collision with root package name */
    private final a f2314a;

    /* compiled from: ViewAnimation.java */
    /* loaded from: classes.dex */
    interface a {
        Animation build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f2314a = aVar;
    }

    @Override // com.bumptech.glide.q.i.c
    public boolean a(R r, c.a aVar) {
        View a2 = aVar.a();
        if (a2 == null) {
            return false;
        }
        a2.clearAnimation();
        a2.startAnimation(this.f2314a.build());
        return false;
    }
}
