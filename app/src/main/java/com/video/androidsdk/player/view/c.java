package com.video.androidsdk.player.view;

import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Watermarking.java */
/* loaded from: classes.dex */
public class c implements ViewTreeObserver.OnDrawListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f3407a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RelativeLayout f3408b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f3409c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, Context context, RelativeLayout relativeLayout) {
        this.f3409c = aVar;
        this.f3407a = context;
        this.f3408b = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        this.f3409c.b(this.f3407a, this.f3408b);
    }
}
