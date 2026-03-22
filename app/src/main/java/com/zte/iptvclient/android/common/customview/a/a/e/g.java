package com.zte.iptvclient.android.common.customview.a.a.e;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.zte.iptvclient.android.zala.R;

/* compiled from: FrameAnimationLoadingDialog.java */
/* loaded from: classes.dex */
public class g extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private a f4252a;

    /* compiled from: FrameAnimationLoadingDialog.java */
    /* loaded from: classes.dex */
    public interface a {
        void h();
    }

    public g(Context context) {
        super(context, R.style.commoncustomdialog);
        super.setContentView(R.layout.frame_animation_loading_dialog);
        ImageView imageView = (ImageView) findViewById(R.id.animation_iv);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        ((AnimationDrawable) imageView.getDrawable()).start();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private boolean a(float f) {
        return f > 25.0f && 40.0f > f;
    }

    private boolean b(float f) {
        return f > 90.0f && 120.0f > f;
    }

    public void a(a aVar) {
        this.f4252a = aVar;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        a aVar = this.f4252a;
        if (aVar != null) {
            aVar.h();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f4252a != null && a(motionEvent.getRawX()) && b(motionEvent.getRawY())) {
            this.f4252a.h();
        }
        return super.onTouchEvent(motionEvent);
    }
}
