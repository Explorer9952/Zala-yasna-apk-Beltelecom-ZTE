package com.player;

import android.net.Uri;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OmafMediaPlayer.java */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OmafMediaPlayer f2418a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(OmafMediaPlayer omafMediaPlayer) {
        this.f2418a = omafMediaPlayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        Uri uri;
        String a2;
        OmafMediaPlayer omafMediaPlayer = this.f2418a;
        uri = omafMediaPlayer.f2390b;
        a2 = omafMediaPlayer.a(uri);
        this.f2418a.f2391c = Uri.parse(a2);
        Log.d(OmafMediaPlayer.D, "getRedirectedUrl " + a2);
    }
}
