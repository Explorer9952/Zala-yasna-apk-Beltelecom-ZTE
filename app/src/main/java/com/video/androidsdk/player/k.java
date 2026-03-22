package com.video.androidsdk.player;

import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.video.androidsdk.log.LogEx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidMediaPlayer.java */
/* loaded from: classes.dex */
public class k extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3380a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.f3380a = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        SurfaceHolder surfaceHolder;
        boolean z5;
        SurfaceView surfaceView;
        SurfaceView surfaceView2;
        int i = message.what;
        if (i == 1) {
            z = this.f3380a.s;
            if (z) {
                LogEx.d("AndroidMediaPlayer", "MSG_OPEN 1");
                StringBuilder sb = new StringBuilder();
                sb.append("AndroidMediaPlayer open, misPlayerRelease is ");
                z2 = this.f3380a.v;
                sb.append(z2);
                LogEx.d("AndroidMediaPlayer", sb.toString());
                z3 = this.f3380a.v;
                if (z3) {
                    return;
                }
                this.f3380a.f();
                return;
            }
            LogEx.d("AndroidMediaPlayer", "MSG_OPEN 2 ,delay 50ms");
            sendEmptyMessageDelayed(1, 50L);
            return;
        }
        if (i == 2) {
            this.f3380a.c();
            sendEmptyMessageDelayed(2, 1000L);
            return;
        }
        if (i == 3) {
            z4 = this.f3380a.C;
            if (!z4) {
                surfaceHolder = this.f3380a.r;
                if (surfaceHolder.getSurface().isValid()) {
                    LogEx.d("AndroidMediaPlayer", "MSG_RESUME 1");
                    z5 = this.f3380a.t;
                    if (z5) {
                        LogEx.d("AndroidMediaPlayer", "MSG_RESUME 2");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("AndroidMediaPlayer resume, the view is ");
                        surfaceView = this.f3380a.q;
                        sb2.append(surfaceView);
                        LogEx.d("AndroidMediaPlayer", sb2.toString());
                        if (this.f3380a.j != null) {
                            c cVar = this.f3380a;
                            if (cVar.h) {
                                cVar.j.start();
                                this.f3380a.y = 3;
                                this.f3380a.i.sendEmptyMessage(2);
                            }
                        }
                        this.f3380a.t = false;
                        this.f3380a.h = false;
                        return;
                    }
                    return;
                }
                LogEx.d("AndroidMediaPlayer", "MSG_RESUME 3");
                sendEmptyMessageDelayed(3, 200L);
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("AndroidMediaPlayer resume, the view is ");
            surfaceView2 = this.f3380a.q;
            sb3.append(surfaceView2);
            LogEx.d("AndroidMediaPlayer", sb3.toString());
            if (this.f3380a.j != null) {
                c cVar2 = this.f3380a;
                if (cVar2.h) {
                    cVar2.j.start();
                    this.f3380a.y = 3;
                    this.f3380a.i.sendEmptyMessage(2);
                }
            }
            this.f3380a.t = false;
            this.f3380a.h = false;
            return;
        }
        LogEx.w("AndroidMediaPlayer", "unkown msg");
    }
}
