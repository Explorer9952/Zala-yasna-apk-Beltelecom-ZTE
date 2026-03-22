package com.zte.iptvclient.android.common.player;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.common.e.r.m;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

/* compiled from: SwitchSettingDialog.java */
/* loaded from: classes.dex */
public class g extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private Activity f4910a;

    /* renamed from: b, reason: collision with root package name */
    private View f4911b;

    /* renamed from: c, reason: collision with root package name */
    private Button f4912c;

    /* renamed from: d, reason: collision with root package name */
    private ListView f4913d;
    private com.zte.iptvclient.android.common.player.i.c e;
    private LayoutInflater f;
    private ArrayList<String> g;
    private ArrayList<String> h;
    private ArrayList<String> i;
    private ArrayList<String> j;
    private RelativeLayout k;
    private TextView l;
    private View m;
    private RelativeLayout n;
    private TextView o;
    private View p;
    private RelativeLayout q;
    private TextView r;
    private View s;
    private int t;
    private String u;
    private String v;
    private int w;
    private int x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchSettingDialog.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchSettingDialog.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.t = 1;
            g.this.f4911b.findViewById(R.id.rl_video_setting).setVisibility(8);
            g.this.j.clear();
            g.this.j.addAll(g.this.i);
            g.this.e = new com.zte.iptvclient.android.common.player.i.c(g.this.f4910a, g.this.j, g.this.t, g.this.v, g.this.w, g.this.x, g.this.u);
            g.this.f4913d.setAdapter((ListAdapter) g.this.e);
            g.this.e.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchSettingDialog.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.t = 2;
            g.this.j.clear();
            g.this.j.addAll(g.this.h);
            g.this.f4911b.findViewById(R.id.rl_video_setting).setVisibility(8);
            g.this.e = new com.zte.iptvclient.android.common.player.i.c(g.this.f4910a, g.this.j, g.this.t, g.this.w, g.this.x, g.this.u);
            g.this.f4913d.setAdapter((ListAdapter) g.this.e);
            g.this.e.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchSettingDialog.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.t = 3;
            g.this.f4911b.findViewById(R.id.rl_video_setting).setVisibility(8);
            g.this.j.clear();
            g.this.j.addAll(g.this.g);
            g.this.e = new com.zte.iptvclient.android.common.player.i.c(g.this.f4910a, g.this.j, g.this.t, g.this.w, g.this.x, g.this.u);
            g.this.f4913d.setAdapter((ListAdapter) g.this.e);
            g.this.e.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchSettingDialog.java */
    /* loaded from: classes.dex */
    public class e implements AdapterView.OnItemClickListener {
        e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            EventBus.getDefault().post(new m((String) g.this.j.get(i), g.this.t, i, g.this.u));
            g.this.dismiss();
        }
    }

    public g(Activity activity, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str, String str2, int i, int i2) {
        super(activity);
        WindowManager.LayoutParams attributes;
        this.j = new ArrayList<>();
        this.w = 0;
        this.x = 0;
        this.f4910a = activity;
        this.g = arrayList;
        this.h = arrayList2;
        this.i = arrayList3;
        this.u = str;
        this.v = str2;
        this.w = i;
        this.x = i2;
        Window window = activity.getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.alpha = 0.5f;
            window.setAttributes(attributes);
        }
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        this.f = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.switch_setting, (ViewGroup) null);
        this.f4911b = inflate;
        setContentView(inflate);
        setWidth(-1);
        setHeight(-2);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
        setAnimationStyle(R.style.mypopwindow_anim_bottom_up);
        b();
        a();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        WindowManager.LayoutParams attributes;
        Window window = this.f4910a.getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.alpha = 1.0f;
            window.setAttributes(attributes);
        }
        super.dismiss();
    }

    @SuppressLint({"JavascriptInterface"})
    private void b() {
        Button button = (Button) this.f4911b.findViewById(R.id.btn_cancel);
        this.f4912c = button;
        button.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        this.f4913d = (ListView) this.f4911b.findViewById(R.id.lv_switch_setting);
        this.k = (RelativeLayout) this.f4911b.findViewById(R.id.rl_quality);
        this.l = (TextView) this.f4911b.findViewById(R.id.txt_quality);
        this.m = this.f4911b.findViewById(R.id.bottom_quality);
        this.n = (RelativeLayout) this.f4911b.findViewById(R.id.rl_subtitle);
        this.o = (TextView) this.f4911b.findViewById(R.id.txt_subtitle);
        this.p = this.f4911b.findViewById(R.id.bottom_subtitle);
        this.q = (RelativeLayout) this.f4911b.findViewById(R.id.rl_audio);
        this.r = (TextView) this.f4911b.findViewById(R.id.txt_audio);
        this.s = this.f4911b.findViewById(R.id.bottom_audio);
        com.zte.iptvclient.common.uiframe.f.a(this.f4911b.findViewById(R.id.rl_switch_setting));
        com.zte.iptvclient.common.uiframe.f.a(this.f4911b.findViewById(R.id.line_bottom));
        com.zte.iptvclient.common.uiframe.f.a(this.f4911b.findViewById(R.id.lv_switch_setting));
        com.zte.iptvclient.common.uiframe.f.a(this.f4912c);
        com.zte.iptvclient.common.uiframe.f.a(this.k);
        com.zte.iptvclient.common.uiframe.f.a(this.l);
        com.zte.iptvclient.common.uiframe.f.a(this.m);
        com.zte.iptvclient.common.uiframe.f.a(this.n);
        com.zte.iptvclient.common.uiframe.f.a(this.o);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        if (this.i.size() == 0) {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
        }
        if (this.g.size() == 1 || this.g.size() == 0) {
            this.n.setVisibility(8);
            this.p.setVisibility(8);
        }
        if (this.h.size() != 1 && this.h.size() != 0) {
            if (TextUtils.isEmpty(this.h.get(0))) {
                this.q.setVisibility(8);
                this.s.setVisibility(8);
                return;
            }
            return;
        }
        this.q.setVisibility(8);
        this.s.setVisibility(8);
    }

    private void a() {
        this.f4912c.setOnClickListener(new a());
        this.k.setOnClickListener(new b());
        this.q.setOnClickListener(new c());
        this.n.setOnClickListener(new d());
        this.f4913d.setOnItemClickListener(new e());
    }

    public void a(View view) {
        WindowManager.LayoutParams attributes;
        setSoftInputMode(16);
        Window window = this.f4910a.getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            window.setAttributes(attributes);
        }
        if (this.f4910a.getResources().getConfiguration().orientation == 2) {
            this.f4911b.setSystemUiVisibility(3846);
        }
        showAtLocation(view, 80, 0, 0);
    }
}
