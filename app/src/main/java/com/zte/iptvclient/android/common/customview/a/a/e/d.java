package com.zte.iptvclient.android.common.customview.a.a.e;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;

/* compiled from: BalanceDialog.java */
/* loaded from: classes.dex */
public class d extends AlertDialog {

    /* renamed from: a, reason: collision with root package name */
    private TextView f4235a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f4236b;

    /* renamed from: c, reason: collision with root package name */
    private String f4237c;

    /* renamed from: d, reason: collision with root package name */
    private b f4238d;

    /* compiled from: BalanceDialog.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.f4238d.a();
            d.this.dismiss();
        }
    }

    /* compiled from: BalanceDialog.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public d(Context context, int i, String str, b bVar) {
        super(context, i);
        this.f4237c = str;
        this.f4238d = bVar;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.balance_dialog);
        this.f4235a = (TextView) findViewById(R.id.ok);
        TextView textView = (TextView) findViewById(R.id.balance);
        this.f4236b = textView;
        textView.setText(this.f4237c);
        this.f4235a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.balance_common));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_order_dialog));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_ok));
        com.zte.iptvclient.common.uiframe.f.a(this.f4236b);
        com.zte.iptvclient.common.uiframe.f.a(this.f4235a);
        this.f4235a.setOnClickListener(new a());
    }
}
