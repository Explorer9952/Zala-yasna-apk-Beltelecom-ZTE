package ijk.media.player;

import java.util.TimerTask;

/* compiled from: IjkMediaPlayer.java */
/* loaded from: classes2.dex */
class h extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f8094a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f8094a = gVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        float f;
        float f2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        f = this.f8094a.f8093a.x;
        if (f <= 0.0f) {
            f2 = this.f8094a.f8093a.x;
            if (f2 < 0.0f) {
                IjkMediaPlayer.access$1510(this.f8094a.f8093a);
            }
        } else {
            IjkMediaPlayer.access$1508(this.f8094a.f8093a);
        }
        this.f8094a.f8093a.x = 0.0f;
        i = this.f8094a.f8093a.w;
        i2 = this.f8094a.f8093a.v;
        if (i <= i2) {
            i3 = this.f8094a.f8093a.w;
            i4 = this.f8094a.f8093a.v;
            if (i3 < i4) {
                this.f8094a.f8093a.switchLeft();
                IjkMediaPlayer ijkMediaPlayer = this.f8094a.f8093a;
                i5 = ijkMediaPlayer.v;
                ijkMediaPlayer.w = i5;
                return;
            }
            return;
        }
        this.f8094a.f8093a.switchRight();
        IjkMediaPlayer ijkMediaPlayer2 = this.f8094a.f8093a;
        i6 = ijkMediaPlayer2.v;
        ijkMediaPlayer2.w = i6;
    }
}
