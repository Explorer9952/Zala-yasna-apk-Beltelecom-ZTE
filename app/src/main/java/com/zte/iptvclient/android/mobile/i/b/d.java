package com.zte.iptvclient.android.mobile.i.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;

/* compiled from: DownloadSetStorageFragment.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b {
    private Button p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private RelativeLayout u;
    private RelativeLayout v;
    private RelativeLayout w;
    private ImageView x;
    private ImageView y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadSetStorageFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadSetStorageFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* compiled from: DownloadSetStorageFragment.java */
        /* loaded from: classes.dex */
        class a implements t.e {
            a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void b() {
                com.zte.iptvclient.android.mobile.download.helper.a.n().e(0);
                d.this.J();
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 0) {
                return;
            }
            t.a(((com.zte.fragmentlib.b) d.this).h, com.zte.iptvclient.android.common.i.a.a.a(R.string.switch_storage_path_confirm), new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadSetStorageFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {

        /* compiled from: DownloadSetStorageFragment.java */
        /* loaded from: classes.dex */
        class a implements t.e {
            a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void b() {
                com.zte.iptvclient.android.mobile.download.helper.a.n().e(1);
                d.this.J();
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 1) {
                return;
            }
            t.a(((com.zte.fragmentlib.b) d.this).h, com.zte.iptvclient.android.common.i.a.a.a(R.string.switch_storage_path_confirm), new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadSetStorageFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.i.b.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0279d implements View.OnClickListener {

        /* compiled from: DownloadSetStorageFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.i.b.d$d$a */
        /* loaded from: classes.dex */
        class a implements t.e {
            a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void b() {
                com.zte.iptvclient.android.mobile.download.helper.a.n().e(3);
                d.this.J();
            }
        }

        ViewOnClickListenerC0279d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 3) {
                return;
            }
            t.a(((com.zte.fragmentlib.b) d.this).h, com.zte.iptvclient.android.common.i.a.a.a(R.string.switch_storage_path_confirm), new a());
        }
    }

    private void I() {
        this.p.setOnClickListener(new a());
        this.u.setOnClickListener(new b());
        this.v.setOnClickListener(new c());
        this.w.setOnClickListener(new ViewOnClickListenerC0279d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 0) {
            this.x.setVisibility(0);
            this.y.setVisibility(4);
            this.z.setVisibility(4);
        } else if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 1) {
            this.x.setVisibility(4);
            this.y.setVisibility(0);
            this.z.setVisibility(4);
        } else {
            this.x.setVisibility(4);
            this.y.setVisibility(4);
            this.z.setVisibility(0);
        }
    }

    private void K() {
        Long valueOf = Long.valueOf(com.zte.iptvclient.android.mobile.download.helper.c.b.b(getActivity().getApplicationContext()));
        String a2 = com.zte.iptvclient.android.mobile.download.helper.c.b.a(valueOf.longValue(), false);
        LogEx.d("DownloadSetStorageFragment", "SDTotalSize =" + valueOf);
        Long valueOf2 = Long.valueOf(com.zte.iptvclient.android.mobile.download.helper.c.b.b());
        String a3 = com.zte.iptvclient.android.mobile.download.helper.c.b.a(valueOf2.longValue(), false);
        LogEx.d("DownloadSetStorageFragment", "RomTotalSize =" + valueOf2);
        if (valueOf.longValue() == 0) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
        }
        if (valueOf2.longValue() == 0) {
            this.u.setVisibility(8);
        } else {
            this.u.setVisibility(0);
        }
        Long valueOf3 = Long.valueOf(com.zte.iptvclient.android.mobile.download.helper.c.b.a(getActivity().getApplicationContext()));
        Long valueOf4 = Long.valueOf(com.zte.iptvclient.android.mobile.download.helper.c.b.a());
        String a4 = com.zte.iptvclient.android.mobile.download.helper.c.b.a(valueOf3.longValue(), false);
        String a5 = com.zte.iptvclient.android.mobile.download.helper.c.b.a(valueOf4.longValue(), false);
        this.r.setText(a5 + "/" + a3);
        this.s.setText(a4 + "/" + a2);
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (getActivity() instanceof MainActivity) {
            F();
            return true;
        }
        if (!(getActivity() instanceof HostActivity)) {
            return true;
        }
        getActivity().finish();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.download_set_storage_fragment, (ViewGroup) null);
        com.zte.iptvclient.common.uiframe.f.a(inflate);
        d(inflate);
        I();
        K();
        return inflate;
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.p = (Button) view.findViewById(R.id.btn_back);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        this.q = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.setting_storage_path));
        this.u = (RelativeLayout) view.findViewById(R.id.setting_btn_pathrom);
        this.v = (RelativeLayout) view.findViewById(R.id.setting_btn_pathsd);
        this.w = (RelativeLayout) view.findViewById(R.id.setting_btn_path_hc);
        this.x = (ImageView) view.findViewById(R.id.setting_path_selected_rom);
        this.y = (ImageView) view.findViewById(R.id.setting_path_selected_sd);
        this.z = (ImageView) view.findViewById(R.id.setting_path_selected_hc);
        TextView textView3 = (TextView) view.findViewById(R.id.setting_txt_pathsize_rom);
        this.r = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_size_default));
        TextView textView4 = (TextView) view.findViewById(R.id.setting_txt_pathsize_sd);
        this.s = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_size_default));
        TextView textView5 = (TextView) view.findViewById(R.id.setting_txt_pathsize_hc);
        this.t = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_size_default));
        if ("1".equals(ConfigMgr.readPropertie("SupportRemoteDownload", "0"))) {
            this.w.setVisibility(0);
            view.findViewById(R.id.line_4).setVisibility(0);
        }
        TextView textView6 = (TextView) view.findViewById(R.id.download_set_text);
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.select_storage_path));
        com.zte.iptvclient.common.uiframe.f.a(textView6);
        TextView textView7 = (TextView) view.findViewById(R.id.phone_rom);
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_rom));
        com.zte.iptvclient.common.uiframe.f.a(textView7);
        ((TextView) view.findViewById(R.id.sdcard_sd)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_sd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.sdcard_sd));
        TextView textView8 = (TextView) view.findViewById(R.id.sdcard_hc);
        textView8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_stb));
        com.zte.iptvclient.common.uiframe.f.a(textView8);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.header_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.line_1));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.setting_btn_pathrom));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.setting_path_selected_rom));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.setting_txt_pathsize_rom));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.line_2));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.setting_btn_pathsd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.setting_path_selected_sd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.setting_txt_pathsize_sd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.line_3));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.setting_btn_path_hc));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.setting_path_selected_hc));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.setting_txt_pathsize_hc));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.line_4));
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (BaseApp.a(this.h)) {
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
        }
        J();
    }
}
