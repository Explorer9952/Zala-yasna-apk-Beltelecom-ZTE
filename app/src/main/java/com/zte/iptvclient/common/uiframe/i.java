package com.zte.iptvclient.common.uiframe;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.RatingBar;
import com.video.androidsdk.common.util.BitmapUtil;

/* compiled from: RatingBarUtil.java */
/* loaded from: classes2.dex */
public class i {
    private static void a(RatingBar ratingBar, Drawable drawable, Drawable drawable2) {
        if (ratingBar == null || drawable == null || drawable2 == null) {
            return;
        }
        LayerDrawable layerDrawable = (LayerDrawable) ratingBar.getProgressDrawable();
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i = 0; i < numberOfLayers; i++) {
            Drawable drawable3 = layerDrawable.getDrawable(i);
            int id = layerDrawable.getId(i);
            if (id == 16908288) {
                drawableArr[i] = drawable2;
            } else if (id == 16908301) {
                ClipDrawable clipDrawable = new ClipDrawable(drawable, 3, 1);
                if (drawable3 != null && (drawable3 instanceof ClipDrawable)) {
                    clipDrawable.setLevel(((ClipDrawable) drawable3).getLevel());
                }
                drawableArr[i] = clipDrawable;
            } else if (id != 16908303) {
                drawableArr[i] = drawable3;
            } else {
                ClipDrawable clipDrawable2 = new ClipDrawable(drawable2, 3, 1);
                if (drawable3 != null && (drawable3 instanceof ClipDrawable)) {
                    clipDrawable2.setLevel(((ClipDrawable) drawable3).getLevel());
                }
                drawableArr[i] = clipDrawable2;
            }
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable2.setId(i2, layerDrawable.getId(i2));
        }
        ratingBar.setProgressDrawable(layerDrawable2);
    }

    public static void b(RatingBar ratingBar, Drawable drawable, Drawable drawable2) {
        if (ratingBar == null || drawable == null || drawable2 == null) {
            return;
        }
        int numStars = ratingBar.getNumStars();
        Drawable[] drawableArr = new Drawable[numStars];
        for (int i = 0; i < numStars; i++) {
            drawableArr[i] = drawable;
        }
        int numStars2 = ratingBar.getNumStars();
        Drawable[] drawableArr2 = new Drawable[numStars2];
        for (int i2 = 0; i2 < numStars2; i2++) {
            drawableArr2[i2] = drawable2;
        }
        a(ratingBar, BitmapUtil.joinDrawable(drawableArr, 0), BitmapUtil.joinDrawable(drawableArr2, 0));
    }
}
