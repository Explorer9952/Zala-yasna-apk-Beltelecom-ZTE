package ijk.media.player;

import ijk.media.player.IjkMediaPlayer;
import java.util.Timer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IjkMediaPlayer.java */
/* loaded from: classes2.dex */
public class g implements IjkMediaPlayer.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IjkMediaPlayer f8093a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(IjkMediaPlayer ijkMediaPlayer) {
        this.f8093a = ijkMediaPlayer;
    }

    @Override // ijk.media.player.IjkMediaPlayer.b
    public void a(float f, float f2) {
        float f3;
        Timer timer;
        Timer timer2;
        IjkMediaPlayer ijkMediaPlayer = this.f8093a;
        f3 = ijkMediaPlayer.x;
        ijkMediaPlayer.x = f3 + f;
        timer = this.f8093a.u;
        if (timer == null) {
            this.f8093a.u = new Timer();
            h hVar = new h(this);
            timer2 = this.f8093a.u;
            timer2.schedule(hVar, 0L, 40L);
        }
    }

    @Override // ijk.media.player.IjkMediaPlayer.b
    public void b() {
        Timer timer;
        Timer timer2;
        timer = this.f8093a.u;
        if (timer != null) {
            timer2 = this.f8093a.u;
            timer2.cancel();
            this.f8093a.u = null;
        }
    }

    @Override // ijk.media.player.IjkMediaPlayer.b
    public void c() {
        if (this.f8093a.isPlaying()) {
            this.f8093a.pause();
        } else {
            this.f8093a.start();
        }
    }

    @Override // ijk.media.player.IjkMediaPlayer.b
    public void a() {
        Timer timer;
        Timer timer2;
        this.f8093a.x = 0.0f;
        timer = this.f8093a.u;
        if (timer != null) {
            timer2 = this.f8093a.u;
            timer2.cancel();
            this.f8093a.u = null;
        }
        this.f8093a.v = 0;
        this.f8093a.w = 0;
    }
}
