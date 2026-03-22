package com.EasyMovieTexture;

import android.content.Intent;
import android.view.View;

/* compiled from: MainActivity.java */
/* loaded from: classes.dex */
class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f1878a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MainActivity mainActivity) {
        this.f1878a = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1878a.f1874d = 0;
        Intent intent = new Intent();
        intent.setClassName(this.f1878a, "com.unity3d.player.UnityPlayerActivity");
        this.f1878a.startActivity(intent);
    }
}
