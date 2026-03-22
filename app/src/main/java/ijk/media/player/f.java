package ijk.media.player;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IjkMediaPlayer.java */
/* loaded from: classes2.dex */
public class f implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IjkMediaPlayer f8092a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(IjkMediaPlayer ijkMediaPlayer) {
        this.f8092a = ijkMediaPlayer;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean a2;
        a2 = this.f8092a.a(motionEvent);
        return a2;
    }
}
