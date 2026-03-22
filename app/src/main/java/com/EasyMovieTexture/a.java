package com.EasyMovieTexture;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;

/* compiled from: MainActivity.java */
/* loaded from: classes.dex */
class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f1877a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MainActivity mainActivity) {
        this.f1877a = mainActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Button button;
        if (message.what == 1) {
            MainActivity.a(this.f1877a);
            button = this.f1877a.f1872b;
            button.setText("Start VR (" + this.f1877a.f1874d + ")");
            if (this.f1877a.f1874d == 0) {
                Intent intent = new Intent();
                intent.setClassName(this.f1877a, "com.unity3d.player.UnityPlayerActivity");
                this.f1877a.startActivity(intent);
            }
        }
    }
}
