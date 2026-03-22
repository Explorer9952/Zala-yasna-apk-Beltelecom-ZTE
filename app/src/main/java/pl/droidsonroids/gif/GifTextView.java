package pl.droidsonroids.gif;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes2.dex */
public class GifTextView extends TextView {
    private boolean mFreezesAnimation;

    public GifTextView(Context context) {
        super(context);
    }

    private Drawable getGifOrDefaultDrawable(int i) {
        if (i == 0) {
            return null;
        }
        Resources resources = getResources();
        if (!isInEditMode() && "drawable".equals(resources.getResourceTypeName(i))) {
            try {
                return new GifDrawable(resources, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resources.getDrawable(i);
    }

    private void hideCompoundDrawables(Drawable[] drawableArr) {
        for (Drawable drawable : drawableArr) {
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
        }
    }

    @TargetApi(17)
    private void init(AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            Drawable gifOrDefaultDrawable = getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableLeft", 0));
            Drawable gifOrDefaultDrawable2 = getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableTop", 0));
            Drawable gifOrDefaultDrawable3 = getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", 0));
            Drawable gifOrDefaultDrawable4 = getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableBottom", 0));
            Drawable gifOrDefaultDrawable5 = getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableStart", 0));
            Drawable gifOrDefaultDrawable6 = getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableEnd", 0));
            if (Build.VERSION.SDK_INT >= 17) {
                if (getLayoutDirection() == 0) {
                    if (gifOrDefaultDrawable5 == null) {
                        gifOrDefaultDrawable5 = gifOrDefaultDrawable;
                    }
                    if (gifOrDefaultDrawable6 == null) {
                        gifOrDefaultDrawable6 = gifOrDefaultDrawable3;
                    }
                } else {
                    if (gifOrDefaultDrawable5 == null) {
                        gifOrDefaultDrawable5 = gifOrDefaultDrawable3;
                    }
                    if (gifOrDefaultDrawable6 == null) {
                        gifOrDefaultDrawable6 = gifOrDefaultDrawable;
                    }
                }
                setCompoundDrawablesRelativeWithIntrinsicBounds(gifOrDefaultDrawable5, gifOrDefaultDrawable2, gifOrDefaultDrawable6, gifOrDefaultDrawable4);
                setCompoundDrawablesWithIntrinsicBounds(gifOrDefaultDrawable, gifOrDefaultDrawable2, gifOrDefaultDrawable3, gifOrDefaultDrawable4);
            } else {
                setCompoundDrawablesWithIntrinsicBounds(gifOrDefaultDrawable, gifOrDefaultDrawable2, gifOrDefaultDrawable3, gifOrDefaultDrawable4);
            }
            setBackgroundInternal(getGifOrDefaultDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0)));
        }
        this.mFreezesAnimation = GifViewUtils.isFreezingAnimation(this, attributeSet, i, i2);
    }

    @TargetApi(16)
    private void setBackgroundInternal(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    @Override // android.view.View
    @TargetApi(17)
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hideCompoundDrawables(getCompoundDrawables());
        if (Build.VERSION.SDK_INT >= 17) {
            hideCompoundDrawables(getCompoundDrawablesRelative());
        }
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRestoreInstanceState(Parcelable parcelable) {
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        Drawable[] compoundDrawables = getCompoundDrawables();
        gifViewSavedState.restoreState(compoundDrawables[0], 0);
        gifViewSavedState.restoreState(compoundDrawables[1], 1);
        gifViewSavedState.restoreState(compoundDrawables[2], 2);
        gifViewSavedState.restoreState(compoundDrawables[3], 3);
        if (Build.VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            gifViewSavedState.restoreState(compoundDrawablesRelative[0], 4);
            gifViewSavedState.restoreState(compoundDrawablesRelative[2], 5);
        }
        gifViewSavedState.restoreState(getBackground(), 6);
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public Parcelable onSaveInstanceState() {
        Drawable[] drawableArr = new Drawable[7];
        if (this.mFreezesAnimation) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            System.arraycopy(compoundDrawables, 0, drawableArr, 0, compoundDrawables.length);
            if (Build.VERSION.SDK_INT >= 17) {
                Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
                drawableArr[4] = compoundDrawablesRelative[0];
                drawableArr[5] = compoundDrawablesRelative[2];
            }
            drawableArr[6] = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawableArr);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundInternal(getGifOrDefaultDrawable(i));
    }

    @Override // android.widget.TextView
    @TargetApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(getGifOrDefaultDrawable(i), getGifOrDefaultDrawable(i2), getGifOrDefaultDrawable(i3), getGifOrDefaultDrawable(i4));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesWithIntrinsicBounds(getGifOrDefaultDrawable(i), getGifOrDefaultDrawable(i2), getGifOrDefaultDrawable(i3), getGifOrDefaultDrawable(i4));
    }

    public void setFreezesAnimation(boolean z) {
        this.mFreezesAnimation = z;
    }

    public GifTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0, 0);
    }

    public GifTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i, 0);
    }

    public GifTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        init(attributeSet, i, i2);
    }
}
