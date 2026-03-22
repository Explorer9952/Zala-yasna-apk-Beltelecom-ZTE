package it.sephiroth.android.library.util.v14;

import android.annotation.TargetApi;
import android.view.View;
import it.sephiroth.android.library.util.ViewHelperFactory;

/* loaded from: classes2.dex */
public class ViewHelper14 extends ViewHelperFactory.ViewHelperDefault {
    public ViewHelper14(View view) {
        super(view);
    }

    @Override // it.sephiroth.android.library.util.ViewHelperFactory.ViewHelperDefault, it.sephiroth.android.library.util.ViewHelperFactory.ViewHelper
    @TargetApi(11)
    public boolean isHardwareAccelerated() {
        return this.view.isHardwareAccelerated();
    }

    @Override // it.sephiroth.android.library.util.ViewHelperFactory.ViewHelperDefault, it.sephiroth.android.library.util.ViewHelperFactory.ViewHelper
    @TargetApi(14)
    public void setScrollX(int i) {
        this.view.setScrollX(i);
    }
}
