package it.sephiroth.android.library.util.v16;

import android.annotation.TargetApi;
import android.view.View;
import it.sephiroth.android.library.util.v14.ViewHelper14;

/* loaded from: classes2.dex */
public class ViewHelper16 extends ViewHelper14 {
    public ViewHelper16(View view) {
        super(view);
    }

    @Override // it.sephiroth.android.library.util.ViewHelperFactory.ViewHelperDefault, it.sephiroth.android.library.util.ViewHelperFactory.ViewHelper
    @TargetApi(16)
    public void postOnAnimation(Runnable runnable) {
        this.view.postOnAnimation(runnable);
    }
}
