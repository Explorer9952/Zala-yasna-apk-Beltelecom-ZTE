package com.zte.iptvclient.android.common.customview.a.a.c;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.mobile.login.activity.LoginActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import org.greenrobot.eventbus.EventBus;

/* compiled from: LoginDialog.java */
/* loaded from: classes.dex */
public class a extends AlertDialog {

    /* renamed from: a, reason: collision with root package name */
    private TextView f4182a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f4183b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f4184c;

    /* renamed from: d, reason: collision with root package name */
    private Context f4185d;
    private t.d e;

    /* compiled from: LoginDialog.java */
    /* renamed from: com.zte.iptvclient.android.common.customview.a.a.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0116a implements View.OnClickListener {
        ViewOnClickListenerC0116a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!BaseApp.a(a.this.f4185d)) {
                a.this.f4185d.startActivity(new Intent(a.this.f4185d, (Class<?>) LoginActivity.class));
            } else if (a.this.e != null) {
                a.this.f4185d.startActivity(new Intent(a.this.f4185d, (Class<?>) LoginActivity.class));
            } else {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a("login", (Bundle) null));
            }
            a.this.dismiss();
        }
    }

    /* compiled from: LoginDialog.java */
    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    /* compiled from: LoginDialog.java */
    /* loaded from: classes.dex */
    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.e != null) {
                a.this.e.onDismiss();
            }
        }
    }

    public a(Context context, int i) {
        super(context, i);
        this.f4185d = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.login_dialog);
        this.f4182a = (TextView) findViewById(R.id.login);
        this.f4183b = (TextView) findViewById(R.id.cancel);
        this.f4184c = (TextView) findViewById(R.id.login_detail);
        f.a(findViewById(R.id.ll_login_dialog));
        f.a(findViewById(R.id.ll_ok));
        f.a(this.f4184c);
        f.a(this.f4182a);
        f.a(this.f4183b);
        this.f4182a.setOnClickListener(new ViewOnClickListenerC0116a());
        this.f4183b.setOnClickListener(new b());
        setOnDismissListener(new c());
    }

    public a(Context context, int i, t.d dVar) {
        super(context, i);
        this.f4185d = context;
        this.e = dVar;
    }
}
