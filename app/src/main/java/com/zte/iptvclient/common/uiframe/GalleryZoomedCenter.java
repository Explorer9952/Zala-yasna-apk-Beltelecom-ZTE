package com.zte.iptvclient.common.uiframe;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Transformation;
import com.video.androidsdk.log.LogEx;

/* loaded from: classes2.dex */
public class GalleryZoomedCenter extends GalleryEx {
    private int k;
    private int l;
    private boolean m;
    private boolean n;

    public GalleryZoomedCenter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = false;
    }

    private void a(Transformation transformation, float f, float f2) {
        LogEx.d("GalleryZoomedCenter", "fWidthScaleRate=" + f + ",fHeightScaleRate=" + f2);
        this.f7884a.save();
        Matrix matrix = transformation.getMatrix();
        LogEx.d("GalleryZoomedCenter", "iImageWidth=" + this.f7886c + ",iImageHeight=" + this.f7887d);
        this.f7884a.getMatrix(matrix);
        matrix.postScale(f, f2);
        int i = this.f7886c;
        float f3 = (((((float) i) * f) - (((float) i) * 1.0f)) * (-1.0f)) / 2.0f;
        int i2 = this.f7887d;
        float f4 = (((i2 * f2) - (i2 * 1.0f)) * (-1.0f)) / 2.0f;
        LogEx.d("GalleryZoomedCenter", "fDx=" + f3 + ",fDy=" + f4);
        matrix.postTranslate(f3, f4);
        this.f7884a.restore();
    }

    @Override // android.widget.Gallery, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.n && (i == 21 || i == 22)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.widget.AbsSpinner
    public int pointToPosition(int i, int i2) {
        Rect rect = new Rect();
        int childCount = getChildCount();
        if (childCount <= 0) {
            LogEx.w("GalleryZoomedCenter", "Invalid iChildCount=" + childCount);
            return -1;
        }
        int selectedItemPosition = getSelectedItemPosition() - getFirstVisiblePosition();
        View childAt = getChildAt(selectedItemPosition);
        if (childAt != null && childAt.getVisibility() == 0) {
            childAt.getHitRect(rect);
            int width = (this.k - rect.width()) / 2;
            int height = (this.l - rect.height()) / 2;
            rect.left -= width;
            rect.right += width;
            rect.top -= height;
            rect.bottom += height;
            if (rect.contains(i, i2)) {
                return getFirstVisiblePosition() + selectedItemPosition;
            }
        }
        for (int i3 = selectedItemPosition + 1; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            if (childAt2 != null && childAt2.getVisibility() == 0) {
                childAt2.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return getFirstVisiblePosition() + i3;
                }
            }
        }
        for (int i4 = selectedItemPosition - 1; i4 >= 0; i4--) {
            View childAt3 = getChildAt(i4);
            if (childAt3 != null && childAt3.getVisibility() == 0) {
                childAt3.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return getFirstVisiblePosition() + i4;
                }
            }
        }
        return -1;
    }

    public GalleryZoomedCenter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = false;
    }

    @Override // com.zte.iptvclient.common.uiframe.GalleryEx
    protected void a(Transformation transformation, int i) {
        LogEx.d("GalleryZoomedCenter", "iChildDistance2GalleryCenter=" + i);
        if (i < 2) {
            a(transformation, (this.k * 1.0f) / this.f7886c, (this.l * 1.0f) / this.f7887d);
            return;
        }
        if (i >= this.f7886c && !this.m) {
            a(transformation, 1.0f, 1.0f);
            return;
        }
        float f = ((this.k * 1.0f) / this.f7886c) - 1.0f;
        float f2 = ((this.l * 1.0f) / this.f7887d) - 1.0f;
        LogEx.d("GalleryZoomedCenter", "fMaxHeightScaleRate=" + f2);
        float f3 = (float) i;
        int i2 = this.f7886c;
        a(transformation, (f + 1.0f) - ((f * f3) / ((float) i2)), (1.0f + f2) - ((f3 * f2) / ((float) i2)));
    }
}
