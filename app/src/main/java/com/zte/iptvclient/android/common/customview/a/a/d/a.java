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

/* compiled from: MultiNetOffHintDialog.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f4189a;

    /* renamed from: b, reason: collision with root package name */
    private AlertDialog f4190b;

    /* renamed from: c, reason: collision with root package name */
    private c f4191c;

    /* renamed from: d, reason: collision with root package name */
    private d f4192d;

    /* compiled from: MultiNetOffHintDialog.java */
    /* renamed from: com.zte.iptvclient.android.common.customview.a.a.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0117a implements View.OnClickListener {
        ViewOnClickListenerC0117a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f4191c != null) {
                a.this.f4191c.a();
                a.this.f4190b.dismiss();
            }
        }
    }

    /* compiled from: MultiNetOffHintDialog.java */
    /* loaded from: classes.dex */
    class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.f4192d != null) {
                a.this.f4192d.onDismiss();
            }
        }
    }

    /* compiled from: MultiNetOffHintDialog.java */
    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    /* compiled from: MultiNetOffHintDialog.java */
    /* loaded from: classes.dex */
    public interface d {
        void onDismiss();
    }

    public a(Context context, c cVar) {
        this.f4189a = context;
        this.f4191c = cVar;
    }

    public void a() {
        AlertDialog alertDialog = this.f4190b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void b() {
        WindowManager.LayoutParams attributes;
        this.f4190b = new AlertDialog.Builder(this.f4189a).create();
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.f4189a, R.layout.multi_player_net_off_hint, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.multi_net_off_hint_title1);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.multi_net_off_hint_title2);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multi_net_off_hint01));
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multi_net_off_hint02));
        ((TextView) linearLayout.findViewById(R.id.multi_net_off_hint_replay)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.retry));
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.ll_multi_net_off_hint_btn);
        f.a(linearLayout.findViewById(R.id.ll_multi_network_hint));
        f.a(linearLayout);
        f.a(linearLayout.findViewById(R.id.ll_multi_net_off_hint));
        f.a(textView);
        f.a(textView2);
        f.a(linearLayout2);
        f.a(linearLayout.findViewById(R.id.multi_net_off_hint_replay));
        linearLayout2.setOnClickListener(new ViewOnClickListenerC0117a());
        this.f4190b.setOnDismissListener(new b());
        this.f4190b.show();
        this.f4190b.setContentView(linearLayout);
        Window window = this.f4190b.getWindow();
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        double width = ((Activity) this.f4189a).getWindowManager().getDefaultDisplay().getWidth();
        Double.isNaN(width);
        attributes.width = (int) (width * 0.72d);
        attributes.height = -2;
        window.setAttributes(attributes);
    }
}
