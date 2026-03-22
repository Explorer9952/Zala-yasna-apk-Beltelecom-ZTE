package pl.droidsonroids.gif;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.ahmobile.android.tvclient.R$styleable;
import java.io.IOException;

/* loaded from: classes2.dex */
final class GifViewUtils {
    static final String ANDROID_NS = "http://schemas.android.com/apk/res/android";

    /* loaded from: classes2.dex */
    static class InitResult {
        final int mBackgroundResId;
        final boolean mFreezesAnimation;
        final int mSourceResId;

        InitResult(int i, int i2, boolean z) {
            this.mSourceResId = i;
            this.mBackgroundResId = i2;
            this.mFreezesAnimation = z;
        }
    }

    private GifViewUtils() {
    }

    private static int getResourceId(ImageView imageView, AttributeSet attributeSet, boolean z) {
        int attributeResourceValue = attributeSet.getAttributeResourceValue(ANDROID_NS, z ? "src" : "background", 0);
        if (attributeResourceValue > 0) {
            String resourceTypeName = imageView.getResources().getResourceTypeName(attributeResourceValue);
            if (("drawable".equals(resourceTypeName) || "raw".equals(resourceTypeName)) && !setResource(imageView, z, attributeResourceValue)) {
                return attributeResourceValue;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InitResult initImageView(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null && !imageView.isInEditMode()) {
            return new InitResult(getResourceId(imageView, attributeSet, true), getResourceId(imageView, attributeSet, false), isFreezingAnimation(imageView, attributeSet, i, i2));
        }
        return new InitResult(0, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isFreezingAnimation(View view, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.GifView, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean setGifImageUri(ImageView imageView, Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            imageView.setImageDrawable(new GifDrawable(imageView.getContext().getContentResolver(), uri));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(16)
    public static boolean setResource(ImageView imageView, boolean z, int i) {
        Resources resources = imageView.getResources();
        if (resources == null) {
            return false;
        }
        try {
            GifDrawable gifDrawable = new GifDrawable(resources, i);
            if (z) {
                imageView.setImageDrawable(gifDrawable);
                return true;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                imageView.setBackground(gifDrawable);
                return true;
            }
            imageView.setBackgroundDrawable(gifDrawable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
