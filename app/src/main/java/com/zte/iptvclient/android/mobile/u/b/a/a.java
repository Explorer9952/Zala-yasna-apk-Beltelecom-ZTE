package com.zte.iptvclient.android.mobile.u.b.a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: RemoteNumLayout.java */
/* loaded from: classes2.dex */
public class a extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private com.zte.iptvclient.android.mobile.u.a.a f7331a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f7332b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f7333c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f7334d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private ImageView m;
    private TextView n;
    private LinearLayout o;
    private Handler p;
    private Context q;
    private Runnable r;

    /* compiled from: RemoteNumLayout.java */
    /* renamed from: com.zte.iptvclient.android.mobile.u.b.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0359a implements Runnable {
        RunnableC0359a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.n.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteNumLayout.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private int f7336a;

        public b(int i) {
            this.f7336a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f7331a.J()) {
                a.this.f7331a.M();
            } else if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                a.this.f7331a.N();
            } else {
                com.zte.iptvclient.android.mobile.h.a.a.g().a(this.f7336a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteNumLayout.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private int f7338a;

        /* renamed from: b, reason: collision with root package name */
        private int f7339b;

        public c(int i, int i2) {
            this.f7338a = i;
            this.f7339b = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f7331a.J()) {
                a.this.f7331a.M();
            } else if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                a.this.f7331a.N();
            } else {
                a.this.a(this.f7338a);
                com.zte.iptvclient.android.mobile.h.a.a.g().a(this.f7339b);
            }
        }
    }

    public a(Context context, com.zte.iptvclient.android.mobile.u.a.a aVar) {
        super(context);
        this.r = new RunnableC0359a();
        this.q = context;
        a(context);
        this.f7331a = aVar;
    }

    private void c() {
        this.m.setOnClickListener(new b(4116));
        this.f7332b.setOnClickListener(new c(R.string.remote_num_0, 48));
        this.f7333c.setOnClickListener(new c(R.string.remote_num_1, 49));
        this.f7334d.setOnClickListener(new c(R.string.remote_num_2, 50));
        this.e.setOnClickListener(new c(R.string.remote_num_3, 51));
        this.f.setOnClickListener(new c(R.string.remote_num_4, 52));
        this.g.setOnClickListener(new c(R.string.remote_num_5, 53));
        this.h.setOnClickListener(new c(R.string.remote_num_6, 54));
        this.i.setOnClickListener(new c(R.string.remote_num_7, 55));
        this.j.setOnClickListener(new c(R.string.remote_num_8, 56));
        this.k.setOnClickListener(new c(R.string.remote_num_9, 57));
        this.l.setOnClickListener(new c(R.string.remote_num_dot, 46));
    }

    public void b() {
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isShow"))) {
            this.f7332b.setTextColor(this.q.getResources().getColor(R.color.remote_numbershow_textcolor));
            this.f7333c.setTextColor(this.q.getResources().getColor(R.color.remote_numbershow_textcolor));
            this.f7334d.setTextColor(this.q.getResources().getColor(R.color.remote_numbershow_textcolor));
            this.e.setTextColor(this.q.getResources().getColor(R.color.remote_numbershow_textcolor));
            this.f.setTextColor(this.q.getResources().getColor(R.color.remote_numbershow_textcolor));
            this.g.setTextColor(this.q.getResources().getColor(R.color.remote_numbershow_textcolor));
            this.h.setTextColor(this.q.getResources().getColor(R.color.remote_numbershow_textcolor));
            this.i.setTextColor(this.q.getResources().getColor(R.color.remote_numbershow_textcolor));
            this.j.setTextColor(this.q.getResources().getColor(R.color.remote_numbershow_textcolor));
            this.k.setTextColor(this.q.getResources().getColor(R.color.remote_numbershow_textcolor));
            this.n.setTextColor(this.q.getResources().getColor(R.color.remote_numbershow_textcolor));
        }
        this.f7332b.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg));
        ((SupportActivity) this.q).a(this.f7332b, "background", R.drawable.remote_btn_num_bg);
        this.f7333c.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg));
        ((SupportActivity) this.q).a(this.f7333c, "background", R.drawable.remote_btn_num_bg);
        this.f7334d.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg));
        ((SupportActivity) this.q).a(this.f7334d, "background", R.drawable.remote_btn_num_bg);
        this.e.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg));
        ((SupportActivity) this.q).a(this.e, "background", R.drawable.remote_btn_num_bg);
        this.f.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg));
        ((SupportActivity) this.q).a(this.f, "background", R.drawable.remote_btn_num_bg);
        this.g.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg));
        ((SupportActivity) this.q).a(this.g, "background", R.drawable.remote_btn_num_bg);
        this.h.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg));
        ((SupportActivity) this.q).a(this.h, "background", R.drawable.remote_btn_num_bg);
        this.i.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg));
        ((SupportActivity) this.q).a(this.i, "background", R.drawable.remote_btn_num_bg);
        this.j.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg));
        ((SupportActivity) this.q).a(this.j, "background", R.drawable.remote_btn_num_bg);
        this.k.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg));
        ((SupportActivity) this.q).a(this.k, "background", R.drawable.remote_btn_num_bg);
        this.l.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_dot_bg));
        ((SupportActivity) this.q).a(this.l, "background", R.drawable.remote_btn_num_dot_bg);
        this.m.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_del_bg));
        ((SupportActivity) this.q).a(this.m, "background", R.drawable.remote_btn_num_del_bg);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.remote_num_fragment, this);
        inflate.setLayoutDirection(0);
        a(inflate);
        this.p = new Handler();
        c();
    }

    private void a(View view) {
        this.f7332b = (TextView) view.findViewById(R.id.num0);
        this.f7333c = (TextView) view.findViewById(R.id.num1);
        this.f7334d = (TextView) view.findViewById(R.id.num2);
        this.e = (TextView) view.findViewById(R.id.num3);
        this.f = (TextView) view.findViewById(R.id.num4);
        this.g = (TextView) view.findViewById(R.id.num5);
        this.h = (TextView) view.findViewById(R.id.num6);
        this.i = (TextView) view.findViewById(R.id.num7);
        this.j = (TextView) view.findViewById(R.id.num8);
        this.k = (TextView) view.findViewById(R.id.num9);
        this.l = (ImageView) view.findViewById(R.id.num_dot);
        this.m = (ImageView) view.findViewById(R.id.num_del);
        this.n = (TextView) view.findViewById(R.id.txt_num_show);
        this.o = (LinearLayout) view.findViewById(R.id.ll_num);
        f.a(this.f7332b);
        f.a(this.f7333c);
        f.a(this.f7334d);
        f.a(this.e);
        f.a(this.f);
        f.a(this.g);
        f.a(this.h);
        f.a(this.i);
        f.a(this.j);
        f.a(this.k);
        f.a(this.l);
        f.a(this.m);
        f.a(this.n);
        f.a(this.o);
        this.f7333c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_num_1));
        this.f7334d.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_num_2));
        this.e.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_num_3));
        this.f.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_num_4));
        this.g.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_num_5));
        this.h.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_num_6));
        this.i.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_num_7));
        this.j.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_num_8));
        this.k.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_num_9));
        this.f7332b.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_num_0));
    }

    public void a() {
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isShow"))) {
            this.f7332b.setTextColor(-1);
            this.f7333c.setTextColor(-1);
            this.f7334d.setTextColor(-1);
            this.e.setTextColor(-1);
            this.f.setTextColor(-1);
            this.g.setTextColor(-1);
            this.h.setTextColor(-1);
            this.i.setTextColor(-1);
            this.j.setTextColor(-1);
            this.k.setTextColor(-1);
            this.n.setTextColor(this.q.getResources().getColor(R.color.remote_numbershow_textcolor));
            this.o.setBackgroundColor(-16777216);
        } else {
            this.o.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_munber_bg_night));
            ((SupportActivity) this.q).a(this.o, "background", R.drawable.remote_munber_bg_night);
        }
        this.f7332b.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg_night));
        ((SupportActivity) this.q).a(this.f7332b, "background", R.drawable.remote_btn_num_bg_night);
        this.f7333c.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg_night));
        ((SupportActivity) this.q).a(this.f7333c, "background", R.drawable.remote_btn_num_bg_night);
        this.f7334d.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg_night));
        ((SupportActivity) this.q).a(this.f7334d, "background", R.drawable.remote_btn_num_bg_night);
        this.e.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg_night));
        ((SupportActivity) this.q).a(this.e, "background", R.drawable.remote_btn_num_bg_night);
        this.f.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg_night));
        ((SupportActivity) this.q).a(this.f, "background", R.drawable.remote_btn_num_bg_night);
        this.g.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg_night));
        ((SupportActivity) this.q).a(this.g, "background", R.drawable.remote_btn_num_bg_night);
        this.h.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg_night));
        ((SupportActivity) this.q).a(this.h, "background", R.drawable.remote_btn_num_bg_night);
        this.i.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg_night));
        ((SupportActivity) this.q).a(this.i, "background", R.drawable.remote_btn_num_bg_night);
        this.j.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg_night));
        ((SupportActivity) this.q).a(this.j, "background", R.drawable.remote_btn_num_bg_night);
        this.k.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_bg_night));
        ((SupportActivity) this.q).a(this.k, "background", R.drawable.remote_btn_num_bg_night);
        this.l.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_dot_bg_night));
        ((SupportActivity) this.q).a(this.l, "background", R.drawable.remote_btn_num_dot_bg_night);
        this.m.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_num_del_bg_night));
        ((SupportActivity) this.q).a(this.m, "background", R.drawable.remote_btn_num_del_bg_night);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.p.removeCallbacks(this.r);
        this.n.setText(i);
        this.p.postDelayed(this.r, 1000L);
    }
}
