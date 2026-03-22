package ijk.media.player;

import android.util.Pair;
import ijk.media.player.QcsLicJNI;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IjkMediaPlayer.java */
/* loaded from: classes2.dex */
public class e implements QcsLicJNI.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IjkMediaPlayer f8091a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(IjkMediaPlayer ijkMediaPlayer) {
        this.f8091a = ijkMediaPlayer;
    }

    @Override // ijk.media.player.QcsLicJNI.a
    public void a(int i, String str) {
        this.f8091a.o = new Pair(Integer.valueOf(i), str);
        if (i == 0) {
            this.f8091a.n = true;
        } else {
            this.f8091a.n = false;
        }
    }
}
