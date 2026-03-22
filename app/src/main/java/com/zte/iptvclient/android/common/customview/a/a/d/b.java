package com.zte.iptvclient.android.common.customview.a.a.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: MultiNetworkHintDialog.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f4195a;

    /* renamed from: b, reason: collision with root package name */
    private AlertDialog f4196b;

    /* renamed from: c, reason: collision with root package name */
    private d f4197c;

    /* renamed from: d, reason: collision with root package name */
    private e f4198d;

    /* compiled from: MultiNetworkHintDialog.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f4197c != null) {
                b.this.f4197c.a();
                b.this.f4196b.dismiss();
            }
        }
    }

    /* compiled from: MultiNetworkHintDialog.java */
    /* renamed from: com.zte.iptvclient.android.common.customview.a.a.d.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0118b implements View.OnClickListener {
        ViewOnClickListenerC0118b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f4197c != null) {
                b.this.f4197c.b();
                b.this.f4196b.dismiss();
            }
        }
    }

    /* compiled from: MultiNetworkHintDialog.java */
    /* loaded from: classes.dex */
    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.f4198d != null) {
                b.this.f4198d.onDismiss();
            }
        }
    }

    /* compiled from: MultiNetworkHintDialog.java */
    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();
    }

    /* compiled from: MultiNetworkHintDialog.java */
    /* loaded from: classes.dex */
    public interface e {
        void onDismiss();
    }

    public b(Context context, d dVar) {
        this.f4195a = context;
        this.f4197c = dVar;
    }

    public void a() {
        AlertDialog alertDialog = this.f4196b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void b() {
        WindowManager.LayoutParams attributes;
        this.f4196b = new AlertDialog.Builder(this.f4195a).create();
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.f4195a, R.layout.multi_player_network_hint, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.multi_network_hint_title1);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.multi_network_hint_title2);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.network_hint));
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.network_hint2));
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.multi_network_hint_cancel);
        TextView textView4 = (TextView) linearLayout.findViewById(R.id.multi_network_hint_ok);
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.space_cancel));
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.continue_play));
        f.a(linearLayout.findViewById(R.id.ll_multi_network_hint));
        f.a(linearLayout.findViewById(R.id.ll_multi_network_hint_btn));
        f.a(linearLayout);
        f.a(textView);
        f.a(textView2);
        f.a(textView4);
        f.a(textView3);
        textView4.setOnClickListener(new a());
        textView3.setOnClickListener(new ViewOnClickListenerC0118b());
        this.f4196b.setOnDismissListener(new c());
        this.f4196b.show();
        this.f4196b.setContentView(linearLayout);
        Window window = this.f4196b.getWindow();
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        double width = ((Activity) this.f4195a).getWindowManager().getDefaultDisplay().getWidth();
        Double.isNaN(width);
        attributes.width = (int) (width * 0.72d);
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    public void a(boolean z) {
        AlertDialog alertDialog = this.f4196b;
        if (alertDialog != null) {
            alertDialog.setCancelable(z);
        }
    }

    public void b(boolean z) {
        AlertDialog alertDialog = this.f4196b;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(z);
        }
    }
}
