package com.tencent.stat;

import android.app.ListActivity;

/* loaded from: classes.dex */
public class EasyListActivity extends ListActivity {
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
