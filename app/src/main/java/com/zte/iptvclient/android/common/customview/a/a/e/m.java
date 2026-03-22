package com.zte.iptvclient.android.common.customview.a.a.e;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;

/* compiled from: TipsDialog.java */
/* loaded from: classes.dex */
public class m extends AlertDialog {

    /* renamed from: a, reason: collision with root package name */
    private TextView f4287a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f4288b;

    /* renamed from: c, reason: collision with root package name */
    private String f4289c;

    /* compiled from: TipsDialog.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m.this.dismiss();
        }
    }

    public m(Context context, int i, String str) {
        super(context, i);
        this.f4289c = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.balance_dialog);
        this.f4287a = (TextView) findViewById(R.id.ok);
        TextView textView = (TextView) findViewById(R.id.balance);
        this.f4288b = textView;
        textView.setText(this.f4289c);
        this.f4287a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_order_dialog));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_ok));
        com.zte.iptvclient.common.uiframe.f.a(this.f4288b);
        com.zte.iptvclient.common.uiframe.f.a(this.f4287a);
        this.f4287a.setOnClickListener(new a());
    }
}
