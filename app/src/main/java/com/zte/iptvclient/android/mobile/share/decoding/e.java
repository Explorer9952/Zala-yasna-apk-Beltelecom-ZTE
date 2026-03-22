package com.zte.iptvclient.android.mobile.share.decoding;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: FinishListener.java */
/* loaded from: classes2.dex */
public final class e implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f7218a;

    public e(Activity activity) {
        this.f7218a = activity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        run();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7218a.finish();
    }
}
