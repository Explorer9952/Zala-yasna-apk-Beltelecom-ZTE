package com.zte.iptvclient.android.mobile.g.a.h;

import com.zte.iptvclient.android.mobile.g.a.d;
import com.zte.iptvclient.android.mobile.g.a.e;
import com.zte.iptvclient.android.mobile.g.a.f;
import java.util.ArrayList;

/* compiled from: PrevuePresenter.java */
/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: a, reason: collision with root package name */
    f f6263a;

    /* renamed from: b, reason: collision with root package name */
    e f6264b;

    public b(f fVar, e eVar) {
        this.f6263a = fVar;
        this.f6264b = eVar;
    }

    public void a(String str, String str2, String str3) {
        this.f6264b.a(str, str2, str3, this);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.d
    public void a(Object obj) {
        this.f6263a.a((ArrayList) obj);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.d
    public void a(String str) {
        this.f6263a.i(str);
    }
}
