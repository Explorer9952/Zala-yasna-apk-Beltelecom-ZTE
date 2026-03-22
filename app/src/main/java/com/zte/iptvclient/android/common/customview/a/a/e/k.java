package com.zte.iptvclient.android.common.customview.a.a.e;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;

/* compiled from: ShutDownDialog.java */
/* loaded from: classes.dex */
public class k extends AlertDialog {

    /* renamed from: a, reason: collision with root package name */
    private TextView f4265a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f4266b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f4267c;

    /* renamed from: d, reason: collision with root package name */
    private Context f4268d;

    /* compiled from: ShutDownDialog.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(com.zte.iptvclient.common.uiframe.a.c("User_Manager_Address"))) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://my.beltelecom.by/login"));
                k.this.f4268d.startActivity(intent);
            }
        }
    }

    /* compiled from: ShutDownDialog.java */
    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k.this.dismiss();
        }
    }

    public k(Context context, int i) {
        super(context, i);
        this.f4268d = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.showdown_dialog);
        this.f4265a = (TextView) findViewById(R.id.ok);
        this.f4266b = (TextView) findViewById(R.id.shutdown);
        this.f4267c = (TextView) findViewById(R.id.shutdownskip);
        this.f4265a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_ok_order));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_shutdown_dialog));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_ok));
        com.zte.iptvclient.common.uiframe.f.a(this.f4266b);
        com.zte.iptvclient.common.uiframe.f.a(this.f4265a);
        com.zte.iptvclient.common.uiframe.f.a(this.f4267c);
        this.f4267c.setText("https://my.beltelecom.by/login");
        this.f4267c.getPaint().setFlags(8);
        this.f4267c.setOnClickListener(new a());
        this.f4265a.setOnClickListener(new b());
    }
}
