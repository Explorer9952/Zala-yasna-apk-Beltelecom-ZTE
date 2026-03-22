package com.zte.fragmentlib.publicbaseclass.skinloader;

import android.os.Bundle;
import android.view.View;
import c.a.a.a.c.c;
import com.zte.iptvclient.android.common.swipeback.SwipeBackActivity;

/* loaded from: classes.dex */
public class BaseFragmentActivity extends SwipeBackActivity implements c, c.a.a.a.c.a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4072a = true;

    /* renamed from: b, reason: collision with root package name */
    private c.a.a.a.d.a f4073b;

    public void a(View view, String str, int i) {
        c.a.a.a.d.a aVar = this.f4073b;
        if (aVar != null) {
            aVar.a(this, view, str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        c.a.a.a.d.b.d().b(this);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.a.a.a.d.b.d().a((c) this);
    }

    @Override // c.a.a.a.c.c
    public void a() {
        c.a.a.a.d.a aVar;
        if (this.f4072a && (aVar = this.f4073b) != null) {
            aVar.a();
        }
    }
}
