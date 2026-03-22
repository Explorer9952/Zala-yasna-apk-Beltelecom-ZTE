package com.zte.iptvclient.android.common.customview.a.a.e;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;

/* compiled from: RemoteFeatureDialog.java */
/* loaded from: classes.dex */
public class j extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private TextView f4263a;

    /* compiled from: RemoteFeatureDialog.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.dismiss();
        }
    }

    public j(Context context, int i) {
        super(context, i);
    }

    public void a() {
        show();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.remotefeature_dialog);
        TextView textView = (TextView) findViewById(R.id.ok);
        this.f4263a = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_ok));
        com.zte.iptvclient.common.uiframe.f.a(this.f4263a);
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_order_dialog));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.title));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_ok));
        this.f4263a.setOnClickListener(new a());
    }
}
