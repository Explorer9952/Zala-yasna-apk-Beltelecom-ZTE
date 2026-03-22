package com.tencent.stat;

import android.app.Activity;

/* loaded from: classes.dex */
public class EasyActivity extends Activity {
    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        e.f(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        e.g(this);
    }
}
