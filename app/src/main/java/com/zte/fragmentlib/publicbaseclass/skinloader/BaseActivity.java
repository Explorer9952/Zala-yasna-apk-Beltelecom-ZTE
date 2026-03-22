package com.zte.fragmentlib.publicbaseclass.skinloader;

import android.app.Activity;
import android.os.Bundle;
import c.a.a.a.c.c;

/* loaded from: classes.dex */
public class BaseActivity extends Activity implements c, c.a.a.a.c.a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4070a = true;

    /* renamed from: b, reason: collision with root package name */
    private c.a.a.a.d.a f4071b;

    @Override // c.a.a.a.c.c
    public void a() {
        if (this.f4070a) {
            this.f4071b.a();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4071b = new c.a.a.a.d.a();
        getLayoutInflater().setFactory(this.f4071b);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        c.a.a.a.d.b.d().b(this);
        this.f4071b.b();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        c.a.a.a.d.b.d().a((c) this);
    }
}
