package com.zte.iptvclient.android.common.customview.view.imageview;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import com.video.androidsdk.log.LogEx;

/* loaded from: classes.dex */
public class LevelImageView extends AppCompatImageView {

    /* renamed from: c, reason: collision with root package name */
    private ObjectAnimator f4357c;

    public LevelImageView(Context context) {
        this(context, null);
    }

    public void g() {
        ObjectAnimator objectAnimator = this.f4357c;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        LogEx.d("LevelImageView", "cancel animation...");
        this.f4357c.cancel();
    }

    public void h() {
        LogEx.d("LevelImageView", "--init--");
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("rotation", 0.0f, 360.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f, 1.0f));
        this.f4357c = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(2000L);
        this.f4357c.setRepeatCount(-1);
        this.f4357c.setInterpolator(new LinearInterpolator());
        this.f4357c.setRepeatMode(1);
    }

    public void i() {
        ObjectAnimator objectAnimator = this.f4357c;
        if (objectAnimator == null || objectAnimator.isStarted()) {
            return;
        }
        LogEx.d("LevelImageView", "start animation...");
        this.f4357c.start();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    public LevelImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LevelImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        h();
    }
}
