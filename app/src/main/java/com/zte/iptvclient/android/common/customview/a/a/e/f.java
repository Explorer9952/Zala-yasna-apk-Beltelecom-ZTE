package com.zte.iptvclient.android.common.customview.a.a.e;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.util.StringUtil;
import com.zte.iptvclient.android.zala.R;

/* compiled from: CustomDialog.java */
/* loaded from: classes.dex */
public class f extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private Context f4246a;

    /* renamed from: b, reason: collision with root package name */
    ImageView f4247b;

    /* renamed from: c, reason: collision with root package name */
    TextView f4248c;

    /* renamed from: d, reason: collision with root package name */
    FrameLayout f4249d;
    LinearLayout e;
    RelativeLayout f;
    TextView g;
    ImageView h;
    RelativeLayout i;
    TextView j;
    ImageView k;
    private int l;
    private int m;
    private LinearLayout n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private String u;
    private c v;
    private d w;
    private View x;
    private View y;
    private View z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CustomDialog.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.v != null) {
                f.this.v.a();
                f.this.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CustomDialog.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.v != null) {
                f.this.v.b();
                f.this.dismiss();
            }
        }
    }

    /* compiled from: CustomDialog.java */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b();
    }

    /* compiled from: CustomDialog.java */
    /* loaded from: classes.dex */
    public interface d {
        void onDismiss();
    }

    public f(Context context, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, c cVar) {
        super(context, R.style.dialogstyle);
        this.l = 0;
        this.m = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.f4246a = context;
        this.l = i;
        this.m = i2;
        this.o = i3;
        this.p = i4;
        this.q = i5;
        this.r = i6;
        this.s = i7;
        this.t = i8;
        this.v = cVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        d dVar = this.w;
        if (dVar != null) {
            dVar.onDismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = View.inflate(this.f4246a, R.layout.horizontal_dialog_layout, null);
        this.x = inflate;
        this.f4249d = (FrameLayout) inflate.findViewById(R.id.fl_dialog_head);
        this.e = (LinearLayout) this.x.findViewById(R.id.customdialog_ll);
        this.y = this.x.findViewById(R.id.customdialog_view1);
        this.z = this.x.findViewById(R.id.customdialog_view2);
        this.n = (LinearLayout) this.x.findViewById(R.id.llayout);
        com.zte.iptvclient.common.uiframe.f.a(this.f4249d);
        com.zte.iptvclient.common.uiframe.f.a(this.n);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        a(this.x);
        setContentView(this.x);
    }

    private void a(View view) {
        this.f4247b = (ImageView) view.findViewById(R.id.image);
        this.f4248c = (TextView) view.findViewById(R.id.message);
        this.f = (RelativeLayout) view.findViewById(R.id.rl_button_ok);
        this.g = (TextView) view.findViewById(R.id.text_ok);
        this.h = (ImageView) view.findViewById(R.id.img_ok_left);
        this.i = (RelativeLayout) view.findViewById(R.id.rl_button_cancel);
        this.j = (TextView) view.findViewById(R.id.text_cancel);
        this.k = (ImageView) view.findViewById(R.id.img_cancel_left);
        com.zte.iptvclient.common.uiframe.f.a(this.f4247b);
        com.zte.iptvclient.common.uiframe.f.a(this.f4248c);
        com.zte.iptvclient.common.uiframe.f.a(this.f);
        com.zte.iptvclient.common.uiframe.f.a(this.g);
        com.zte.iptvclient.common.uiframe.f.a(this.h);
        com.zte.iptvclient.common.uiframe.f.a(this.i);
        com.zte.iptvclient.common.uiframe.f.a(this.j);
        com.zte.iptvclient.common.uiframe.f.a(this.k);
        this.g.setText(this.f4246a.getResources().getString(R.string.common_confirm));
        this.j.setText(this.f4246a.getResources().getString(R.string.common_cancel));
        this.f.setOnClickListener(new a());
        this.i.setOnClickListener(new b());
    }

    public void a(String str) {
        this.u = str;
    }

    public void a() {
        RelativeLayout relativeLayout;
        View view;
        ImageView imageView;
        int i;
        if (this.f4246a == null) {
            return;
        }
        show();
        if (this.i == null || (relativeLayout = this.f) == null) {
            return;
        }
        if (this.l == R.drawable.custom_dialog_login_img && (i = this.m) != R.string.confirm_delete_item && i != R.string.cancel_sub_order_content && i != R.string.purchase_cancel) {
            this.l = R.drawable.dialog_login_head;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = com.zte.iptvclient.android.common.k.g.a(getContext(), 38.0f);
                layoutParams.bottomMargin = com.zte.iptvclient.android.common.k.g.a(getContext(), 15.0f);
                layoutParams.rightMargin = com.zte.iptvclient.android.common.k.g.a(getContext(), 10.0f);
                layoutParams.leftMargin = com.zte.iptvclient.android.common.k.g.a(getContext(), 10.0f);
                this.f.setLayoutParams(layoutParams);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = com.zte.iptvclient.android.common.k.g.a(getContext(), 38.0f);
                layoutParams2.bottomMargin = com.zte.iptvclient.android.common.k.g.a(getContext(), 15.0f);
                layoutParams2.rightMargin = com.zte.iptvclient.android.common.k.g.a(getContext(), 10.0f);
                layoutParams2.leftMargin = com.zte.iptvclient.android.common.k.g.a(getContext(), 10.0f);
                this.i.setLayoutParams(layoutParams2);
            }
        } else {
            this.l = 0;
        }
        if (this.o != 0 && this.p != 0 && this.r != 0 && this.s != 0 && this.e != null) {
            if (this.l != 0) {
                View view2 = this.y;
                if (view2 != null && this.z != null) {
                    view2.setVisibility(8);
                    this.z.setVisibility(8);
                }
                this.e.setOrientation(1);
                RelativeLayout relativeLayout2 = this.f;
                if (relativeLayout2 != null && this.j != null) {
                    this.e.removeView(relativeLayout2);
                    this.e.removeView(this.i);
                    this.e.addView(this.f);
                    this.e.addView(this.i);
                }
                this.o = R.drawable.login_btn_bg;
                this.r = R.drawable.login_btn_bg;
            }
        } else if (this.o != 0 && this.p != 0 && this.r == 0 && this.t == 0 && (view = this.z) != null) {
            view.setVisibility(8);
        }
        ImageView imageView2 = this.f4247b;
        if (imageView2 != null && this.f4249d != null && this.n != null) {
            if (this.l == 0) {
                imageView2.setVisibility(8);
                this.f4249d.setVisibility(8);
                this.n.setBackground(c.a.a.a.d.b.d().d(R.drawable.common_dialog_corner));
            } else {
                imageView2.setImageDrawable(c.a.a.a.d.b.d().d(this.l));
                this.f4247b.setVisibility(0);
            }
        }
        if (this.f4248c == null) {
            return;
        }
        if (!StringUtil.isEmptyString(this.u)) {
            this.f4248c.setText(this.u);
        } else {
            int i2 = this.m;
            if (i2 != 0) {
                this.f4248c.setText(com.zte.iptvclient.android.common.i.a.a.a(i2));
            }
        }
        if (this.f != null && this.g != null && this.h != null) {
            View view3 = this.z;
            if (view3 != null && view3.getVisibility() == 8) {
                this.h.setVisibility(8);
            }
            this.f.setBackground(c.a.a.a.d.b.d().d(this.o));
            if (this.p != 0) {
                this.f.setVisibility(0);
                this.g.setText(com.zte.iptvclient.android.common.i.a.a.a(this.p));
                if (this.q != 0) {
                    this.h.setVisibility(0);
                    this.h.setBackground(c.a.a.a.d.b.d().d(this.q));
                }
            }
        }
        RelativeLayout relativeLayout3 = this.i;
        if (relativeLayout3 != null && this.j != null && (imageView = this.k) != null) {
            if (this.r == 0) {
                imageView.setVisibility(8);
            } else {
                relativeLayout3.setVisibility(0);
                this.i.setBackground(c.a.a.a.d.b.d().d(this.r));
            }
            if (this.s != 0) {
                this.i.setVisibility(0);
                this.j.setText(com.zte.iptvclient.android.common.i.a.a.a(this.s));
                if (this.t != 0) {
                    this.k.setVisibility(0);
                    this.i.setBackground(c.a.a.a.d.b.d().d(this.t));
                }
            }
        }
        if (this.l == 0) {
            TextView textView = this.g;
            if (textView != null) {
                textView.setTextColor(this.f4246a.getResources().getColor(R.color.dialog_btn_txt_bg));
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setTextColor(this.f4246a.getResources().getColor(R.color.dialog_btn_txt_bg));
            }
        }
    }
}
