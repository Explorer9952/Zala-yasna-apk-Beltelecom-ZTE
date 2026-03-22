package com.zte.iptvclient.android.common.customview.a.a.e;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;

/* compiled from: RechargeDialog.java */
/* loaded from: classes.dex */
public class i extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private TextView f4258a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f4259b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f4260c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f4261d;
    private TextView e;
    private String f;
    private String g;
    private boolean h;
    private Context i;
    private SpannableStringBuilder j;
    private b k;

    /* compiled from: RechargeDialog.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.k.a();
        }
    }

    /* compiled from: RechargeDialog.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public i(Context context, int i, String str, boolean z, String str2) {
        super(context, i);
        this.i = context;
        this.f = str;
        this.h = z;
        this.g = str2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        WindowManager.LayoutParams attributes;
        super.onCreate(bundle);
        setContentView(R.layout.recharge_dialog);
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = -1;
            attributes.height = -1;
            window.setGravity(17);
        }
        this.f4258a = (TextView) findViewById(R.id.txt_recharge_detail);
        this.f4259b = (TextView) findViewById(R.id.txt_recharge_detail_success);
        this.f4260c = (TextView) findViewById(R.id.txt_failed_reason);
        this.f4261d = (TextView) findViewById(R.id.txt_failed_reason_detail);
        this.e = (TextView) findViewById(R.id.txt_ok);
        if (this.h) {
            this.j = new SpannableStringBuilder(com.zte.iptvclient.android.common.i.a.a.a(R.string.recharge_success) + " " + this.f);
            int length = com.zte.iptvclient.android.common.i.a.a.a(R.string.recharge_success).length();
            int i = length + 11;
            this.j.setSpan(new ForegroundColorSpan(this.i.getResources().getColor(R.color.concurrency_play_orange)), length, i, 33);
            this.j.setSpan(new RelativeSizeSpan(1.1f), length, i, 18);
            this.f4259b.setText(this.j);
            this.f4259b.setVisibility(0);
            this.f4260c.setVisibility(8);
            this.f4261d.setVisibility(8);
            this.e.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.input_lockpassword_ok));
        } else {
            this.f4258a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recharge_failure));
            this.f4258a.setVisibility(0);
            this.f4260c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.failed_reason));
            this.f4260c.setVisibility(0);
            this.f4261d.setVisibility(0);
            this.f4261d.setText(this.g);
            this.e.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.cancel_order));
        }
        this.e.setOnClickListener(new a());
    }

    public void a() {
        show();
    }

    public void a(b bVar) {
        this.k = bVar;
    }
}
