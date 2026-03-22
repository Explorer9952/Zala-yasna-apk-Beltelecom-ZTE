package it.sephiroth.android.library.util;

import android.os.Build;
import android.view.View;
import com.video.androidsdk.log.LogEx;
import it.sephiroth.android.library.util.v14.ViewHelper14;
import it.sephiroth.android.library.util.v16.ViewHelper16;

/* loaded from: classes2.dex */
public class ViewHelperFactory {
    private static final String LOG_TAG = "ViewHelper";

    /* loaded from: classes2.dex */
    public static abstract class ViewHelper {
        protected View view;

        protected ViewHelper(View view) {
            this.view = view;
        }

        public abstract boolean isHardwareAccelerated();

        public abstract void postOnAnimation(Runnable runnable);

        public abstract void setScrollX(int i);
    }

    /* loaded from: classes2.dex */
    public static class ViewHelperDefault extends ViewHelper {
        public ViewHelperDefault(View view) {
            super(view);
        }

        @Override // it.sephiroth.android.library.util.ViewHelperFactory.ViewHelper
        public boolean isHardwareAccelerated() {
            return false;
        }

        @Override // it.sephiroth.android.library.util.ViewHelperFactory.ViewHelper
        public void postOnAnimation(Runnable runnable) {
            this.view.post(runnable);
        }

        @Override // it.sephiroth.android.library.util.ViewHelperFactory.ViewHelper
        public void setScrollX(int i) {
            LogEx.d(ViewHelperFactory.LOG_TAG, "setScrollX: " + i);
            View view = this.view;
            view.scrollTo(i, view.getScrollY());
        }
    }

    public static final ViewHelper create(View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            return new ViewHelper16(view);
        }
        if (i >= 14) {
            return new ViewHelper14(view);
        }
        return new ViewHelperDefault(view);
    }
}
