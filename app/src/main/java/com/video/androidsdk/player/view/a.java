package com.video.androidsdk.player.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.sdkrender.R;

/* compiled from: Watermarking.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f3401a;

    /* renamed from: b, reason: collision with root package name */
    private int f3402b;

    /* renamed from: c, reason: collision with root package name */
    private int f3403c;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, RelativeLayout relativeLayout) {
        int width = relativeLayout.getWidth();
        int height = relativeLayout.getHeight();
        if (this.f3402b == width && this.f3403c == height) {
            return;
        }
        float width2 = (relativeLayout.getWidth() * 1.0f) / 1920.0f;
        float height2 = (relativeLayout.getHeight() * 1.0f) / 1080.0f;
        LogEx.d("watermarking", "run: width = " + width + "   height = " + height);
        if (this.f3401a == null) {
            ImageView imageView = new ImageView(context);
            this.f3401a = imageView;
            imageView.setImageResource(R.drawable.img_watermarking);
            relativeLayout.addView(this.f3401a);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (206.0f * width2), (int) (103.0f * height2));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = (int) (width2 * 50.0f);
        layoutParams.topMargin = (int) (height2 * 50.0f);
        this.f3401a.setLayoutParams(layoutParams);
        this.f3402b = width;
        this.f3403c = height;
    }

    public boolean a(Context context, RelativeLayout relativeLayout) {
        if (context.getResources().getIdentifier("img_watermarking", "drawable", context.getPackageName()) <= 0) {
            return false;
        }
        relativeLayout.post(new b(this, context, relativeLayout));
        relativeLayout.getViewTreeObserver().addOnDrawListener(new c(this, context, relativeLayout));
        return true;
    }
}
