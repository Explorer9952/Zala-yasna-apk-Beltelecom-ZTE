package com.video.androidsdk.player.view;

import android.content.Context;
import android.widget.RelativeLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Watermarking.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f3404a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RelativeLayout f3405b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f3406c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Context context, RelativeLayout relativeLayout) {
        this.f3406c = aVar;
        this.f3404a = context;
        this.f3405b = relativeLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3406c.b(this.f3404a, this.f3405b);
    }
}
