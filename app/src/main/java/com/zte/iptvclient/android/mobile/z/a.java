package com.zte.iptvclient.android.mobile.z;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.common.e.g;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import org.greenrobot.eventbus.EventBus;

/* compiled from: SwitchSkinFragment.java */
/* loaded from: classes2.dex */
public class a extends com.zte.fragmentlib.b {
    private Button p;
    private TextView q;
    private TextView r;
    private TextView s;
    private RelativeLayout t;
    private RelativeLayout u;
    private h v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchSkinFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.z.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0404a implements View.OnClickListener {
        ViewOnClickListenerC0404a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.getActivity() instanceof MainActivity) {
                a.this.F();
            } else if (a.this.getActivity() instanceof HostActivity) {
                a.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchSkinFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* compiled from: SwitchSkinFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.z.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0405a implements c.a.a.a.c.b {
            C0405a() {
            }

            @Override // c.a.a.a.c.b
            public void a() {
            }

            @Override // c.a.a.a.c.b
            public void b() {
            }

            @Override // c.a.a.a.c.b
            public void onSuccess() {
                a.this.t.setVisibility(4);
                a.this.u.setVisibility(0);
                a.this.v.F("black.skin");
                com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b = "black.skin";
                EventBus.getDefault().post(new g());
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
                return;
            }
            c.a.a.a.d.b.d().a(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4074a + "//black.skin", new C0405a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwitchSkinFragment.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* compiled from: SwitchSkinFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.z.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0406a implements c.a.a.a.c.b {
            C0406a() {
            }

            @Override // c.a.a.a.c.b
            public void a() {
            }

            @Override // c.a.a.a.c.b
            public void b() {
            }

            @Override // c.a.a.a.c.b
            public void onSuccess() {
                a.this.t.setVisibility(0);
                a.this.u.setVisibility(4);
                a.this.v.F("white.skin");
                com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b = "white.skin";
                EventBus.getDefault().post(new g());
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "white.skin")) {
                return;
            }
            c.a.a.a.d.b.d().a(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4074a + "//white.skin", new C0406a());
        }
    }

    private void I() {
        this.p.setOnClickListener(new ViewOnClickListenerC0404a());
        this.s.setOnClickListener(new b());
        this.r.setOnClickListener(new c());
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.p = (Button) view.findViewById(R.id.btn_back);
        this.q = (TextView) view.findViewById(R.id.title_txt);
        TextView textView2 = (TextView) view.findViewById(R.id.txt_light_apply);
        this.r = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.theme_apply));
        TextView textView3 = (TextView) view.findViewById(R.id.txt_dark_apply);
        this.s = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.theme_apply));
        this.t = (RelativeLayout) view.findViewById(R.id.rl_light_theme_focus);
        this.u = (RelativeLayout) view.findViewById(R.id.rl_dark_theme_focus);
        ((TextView) view.findViewById(R.id.txt_light_focus)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.current_theme));
        ((TextView) view.findViewById(R.id.txt_light_theme)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.light_theme));
        ((TextView) view.findViewById(R.id.txt_dark_focus)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.current_theme));
        ((TextView) view.findViewById(R.id.txt_dark_theme)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.dark_theme));
        f.a(view.findViewById(R.id.title_rlayout));
        f.a(this.p);
        f.a(this.q);
        f.a(view.findViewById(R.id.header_bottom_line));
        f.a(view.findViewById(R.id.light_theme));
        f.a(view.findViewById(R.id.rl_light_theme));
        f.a(view.findViewById(R.id.img_light_theme));
        f.a(view.findViewById(R.id.rl_light_theme_focus));
        f.a(view.findViewById(R.id.txt_light_focus));
        f.a(view.findViewById(R.id.txt_light_theme));
        f.a(view.findViewById(R.id.txt_light_apply));
        f.a(view.findViewById(R.id.dark_theme));
        f.a(view.findViewById(R.id.rl_dark_theme));
        f.a(view.findViewById(R.id.img_dark_theme));
        f.a(view.findViewById(R.id.rl_dark_theme_focus));
        f.a(view.findViewById(R.id.txt_dark_focus));
        f.a(view.findViewById(R.id.txt_dark_theme));
        f.a(view.findViewById(R.id.txt_dark_apply));
        if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
            this.t.setVisibility(4);
            this.u.setVisibility(0);
        } else {
            this.t.setVisibility(0);
            this.u.setVisibility(4);
        }
        this.p.setVisibility(0);
        this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.switch_skin));
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.v = new h(this.h);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.switch_skin_fragment, viewGroup, false);
        d(inflate);
        I();
        return inflate;
    }
}
