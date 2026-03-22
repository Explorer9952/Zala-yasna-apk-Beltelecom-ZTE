package com.zte.iptvclient.android.common.e.x;

import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;

/* compiled from: LoadPlayNowTvEvent.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private PrevueBean f4502a;

    /* renamed from: b, reason: collision with root package name */
    private int f4503b;

    /* renamed from: c, reason: collision with root package name */
    private Channel f4504c;

    public f(PrevueBean prevueBean, int i, Channel channel) {
        this.f4502a = prevueBean;
        this.f4503b = i;
        this.f4504c = channel;
    }

    public int a() {
        return this.f4503b;
    }

    public PrevueBean b() {
        return this.f4502a;
    }

    public Channel c() {
        return this.f4504c;
    }
}
