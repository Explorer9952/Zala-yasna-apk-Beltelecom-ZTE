package com.EasyMovieTexture;

import android.content.Intent;
import android.view.View;

/* compiled from: MainActivity.java */
/* loaded from: classes.dex */
class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f1879a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MainActivity mainActivity) {
        this.f1879a = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1879a.f1874d = 0;
        Intent intent = new Intent();
        intent.setClassName(this.f1879a, "com.EasyMovieTexture.VRSettings");
        this.f1879a.startActivity(intent);
    }
}
