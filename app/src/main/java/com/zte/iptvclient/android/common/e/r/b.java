package com.zte.iptvclient.android.common.e.r;

import com.zte.iptvclient.android.common.javabean.models.PrevueBean;

/* compiled from: PlayLiveTvodQueryEvent.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4473a;

    /* renamed from: b, reason: collision with root package name */
    private PrevueBean f4474b;

    public b(PrevueBean prevueBean, boolean z) {
        this.f4473a = true;
        this.f4474b = prevueBean;
        this.f4473a = z;
    }

    public PrevueBean a() {
        if (this.f4474b == null) {
            this.f4474b = new PrevueBean();
        }
        return this.f4474b;
    }

    public boolean b() {
        return this.f4473a;
    }
}
