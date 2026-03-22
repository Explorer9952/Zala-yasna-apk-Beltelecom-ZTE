package com.zte.iptvclient.android.common.k;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.zte.iptvclient.android.zala.R;

/* compiled from: AccountCommonDialog.java */
/* loaded from: classes.dex */
public class b extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private Context f4791a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayout f4792b;

    /* renamed from: c, reason: collision with root package name */
    TextView f4793c;

    /* renamed from: d, reason: collision with root package name */
    RelativeLayout f4794d;
    TextView e;
    ImageView f;
    RelativeLayout g;
    TextView h;
    ImageView i;
    private View j;
    private View k;
    private View l;
    private d m;
    private String n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccountCommonDialog.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.m != null) {
                b.this.m.a();
                b.this.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccountCommonDialog.java */
    /* renamed from: com.zte.iptvclient.android.common.k.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0137b implements View.OnClickListener {
        ViewOnClickListenerC0137b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.m != null) {
                b.this.m.b();
                b.this.dismiss();
            }
        }
    }

    /* compiled from: AccountCommonDialog.java */
    /* loaded from: classes.dex */
    static class c implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f4797a;

        c(d dVar) {
            this.f4797a = dVar;
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void a() {
            d dVar = this.f4797a;
            if (dVar != null) {
                dVar.a();
            }
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void b() {
            d dVar = this.f4797a;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    /* compiled from: AccountCommonDialog.java */
    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();
    }

    public b(Context context, d dVar) {
        super(context, R.style.dialogstyle);
        this.f4791a = context;
        this.m = dVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = View.inflate(this.f4791a, R.layout.dialog_account_common, null);
        this.j = inflate;
        this.k = inflate.findViewById(R.id.customdialog_view1);
        this.l = this.j.findViewById(R.id.customdialog_view2);
        LinearLayout linearLayout = (LinearLayout) this.j.findViewById(R.id.llayout);
        this.f4792b = linearLayout;
        com.zte.iptvclient.common.uiframe.f.a(linearLayout);
        com.zte.iptvclient.common.uiframe.f.a(this.k);
        com.zte.iptvclient.common.uiframe.f.a(this.l);
        setContentView(this.j);
        a(this.j);
    }

    private void a(View view) {
        this.f4793c = (TextView) view.findViewById(R.id.message);
        this.f4794d = (RelativeLayout) view.findViewById(R.id.rl_button_ok);
        this.e = (TextView) view.findViewById(R.id.text_ok);
        this.f = (ImageView) view.findViewById(R.id.img_ok_left);
        this.g = (RelativeLayout) view.findViewById(R.id.rl_button_cancel);
        this.h = (TextView) view.findViewById(R.id.text_cancel);
        this.i = (ImageView) view.findViewById(R.id.img_cancel_left);
        com.zte.iptvclient.common.uiframe.f.a(this.f4793c);
        com.zte.iptvclient.common.uiframe.f.a(this.f4794d);
        com.zte.iptvclient.common.uiframe.f.a(this.e);
        com.zte.iptvclient.common.uiframe.f.a(this.f);
        com.zte.iptvclient.common.uiframe.f.a(this.g);
        com.zte.iptvclient.common.uiframe.f.a(this.h);
        com.zte.iptvclient.common.uiframe.f.a(this.i);
        this.e.setText(this.f4791a.getResources().getString(R.string.common_confirm));
        this.h.setText(this.f4791a.getResources().getString(R.string.common_cancel));
        this.f4794d.setOnClickListener(new a());
        this.g.setOnClickListener(new ViewOnClickListenerC0137b());
    }

    public void a(String str) {
        this.n = str;
    }

    public void a() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        if (this.f4791a == null) {
            return;
        }
        show();
        if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
            RelativeLayout relativeLayout = this.f4794d;
            if (relativeLayout != null && (layoutParams2 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams()) != null) {
                layoutParams2.height = g.a(getContext(), 42.0f);
                this.f4794d.setLayoutParams(layoutParams2);
            }
            RelativeLayout relativeLayout2 = this.g;
            if (relativeLayout2 != null && (layoutParams = (LinearLayout.LayoutParams) relativeLayout2.getLayoutParams()) != null) {
                layoutParams.height = g.a(getContext(), 42.0f);
                this.g.setLayoutParams(layoutParams);
            }
        }
        if (this.f4793c == null || StringUtil.isEmptyString(this.n)) {
            return;
        }
        this.f4793c.setText(this.n);
    }

    public static void a(Context context, String str, d dVar) {
        b bVar = new b(context, new c(dVar));
        bVar.a(str);
        bVar.a();
        bVar.setCanceledOnTouchOutside(false);
    }
}
