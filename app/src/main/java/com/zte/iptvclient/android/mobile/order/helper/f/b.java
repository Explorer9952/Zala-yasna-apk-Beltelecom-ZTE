package com.zte.iptvclient.android.mobile.order.helper.f;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: PayResultDialog.java */
/* loaded from: classes.dex */
public class b extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private TextView f6968a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayout f6969b;

    /* renamed from: c, reason: collision with root package name */
    private String f6970c;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC0327b f6971d;

    /* compiled from: PayResultDialog.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            if (b.this.f6971d != null) {
                b.this.f6971d.a();
            }
        }
    }

    /* compiled from: PayResultDialog.java */
    /* renamed from: com.zte.iptvclient.android.mobile.order.helper.f.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0327b {
        void a();
    }

    public b(Context context, int i, String str, InterfaceC0327b interfaceC0327b) {
        super(context, i);
        this.f6970c = str;
        this.f6971d = interfaceC0327b;
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pay_result_dialog);
        this.f6968a = (TextView) findViewById(R.id.title);
        this.f6969b = (LinearLayout) findViewById(R.id.ll_ok);
        f.a(this.f6968a);
        f.a(this.f6969b);
        f.a(findViewById(R.id.rl_result_dialog));
        f.a(findViewById(R.id.ok));
        this.f6968a.setText(this.f6970c);
        this.f6969b.setOnClickListener(new a());
    }
}
