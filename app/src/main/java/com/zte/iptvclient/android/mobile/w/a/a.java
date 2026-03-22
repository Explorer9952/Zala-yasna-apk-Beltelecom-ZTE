package com.zte.iptvclient.android.mobile.w.a;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.io.File;

/* compiled from: SettingStoragePathFragment.java */
/* loaded from: classes2.dex */
public class a extends com.zte.fragmentlib.b {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private Button p;
    private TextView q;
    private LinearLayout r;
    private LinearLayout s;
    private LinearLayout t;
    private TextView u;
    private TextView v;
    private ImageView w;
    private ImageView x;
    private ImageView y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingStoragePathFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.w.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0381a implements View.OnClickListener {
        ViewOnClickListenerC0381a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.getFragmentManager().F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingStoragePathFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* compiled from: SettingStoragePathFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.w.a.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class DialogInterfaceOnClickListenerC0382a implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0382a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.zte.iptvclient.android.mobile.download.helper.a.n().e(0);
                a.this.J();
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 0) {
                return;
            }
            new AlertDialog.Builder(a.this.getActivity()).setTitle(R.string.change_confirm).setMessage(R.string.switch_storage_path_confirm).setIcon(R.drawable.ic_launcher).setPositiveButton(R.string.confirm, new DialogInterfaceOnClickListenerC0382a()).setNegativeButton(R.string.common_cancel, (DialogInterface.OnClickListener) null).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingStoragePathFragment.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* compiled from: SettingStoragePathFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.w.a.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class DialogInterfaceOnClickListenerC0383a implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0383a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.zte.iptvclient.android.mobile.download.helper.a.n().e(1);
                a.this.J();
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 1) {
                return;
            }
            new AlertDialog.Builder(a.this.getActivity()).setTitle(R.string.change_confirm).setMessage(R.string.switch_storage_path_confirm).setIcon(R.drawable.ic_launcher).setPositiveButton(R.string.confirm, new DialogInterfaceOnClickListenerC0383a()).setNegativeButton(R.string.common_cancel, (DialogInterface.OnClickListener) null).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingStoragePathFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {

        /* compiled from: SettingStoragePathFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.w.a.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class DialogInterfaceOnClickListenerC0384a implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0384a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.zte.iptvclient.android.mobile.download.helper.a.n().e(3);
                a.this.J();
            }
        }

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 3) {
                return;
            }
            new AlertDialog.Builder(a.this.getActivity()).setTitle(R.string.change_confirm).setMessage(R.string.switch_storage_path_confirm).setIcon(R.drawable.ic_launcher).setPositiveButton(R.string.confirm, new DialogInterfaceOnClickListenerC0384a()).setNegativeButton(R.string.common_cancel, (DialogInterface.OnClickListener) null).create().show();
        }
    }

    private void I() {
        this.p.setOnClickListener(new ViewOnClickListenerC0381a());
        this.r.setOnClickListener(new b());
        this.s.setOnClickListener(new c());
        this.t.setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 0) {
            this.w.setVisibility(0);
            this.x.setVisibility(4);
            this.y.setVisibility(4);
        } else if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 1) {
            this.w.setVisibility(4);
            this.x.setVisibility(0);
            this.y.setVisibility(4);
        } else {
            this.w.setVisibility(4);
            this.x.setVisibility(4);
            this.y.setVisibility(0);
        }
    }

    private void K() {
        String l = com.zte.iptvclient.android.mobile.download.helper.c.b.l();
        String d2 = com.zte.iptvclient.android.mobile.download.helper.c.b.d();
        String a2 = com.zte.iptvclient.android.mobile.download.helper.c.b.a(getActivity().getApplicationContext(), 1);
        if (a2 != null) {
            String c2 = com.zte.iptvclient.android.mobile.download.helper.c.b.c(new File(a2));
            this.v.setText(c2 + "/" + l);
        }
        String a3 = com.zte.iptvclient.android.mobile.download.helper.c.b.a(getActivity().getApplicationContext(), 0);
        if (a3 != null) {
            String c3 = com.zte.iptvclient.android.mobile.download.helper.c.b.c(new File(a3));
            this.u.setText(c3 + "/" + d2);
        }
    }

    private void d(View view) {
        this.p = (Button) view.findViewById(R.id.btn_back);
        this.q = (TextView) view.findViewById(R.id.title_txt);
        this.r = (LinearLayout) view.findViewById(R.id.ll_setting_path_rom);
        this.s = (LinearLayout) view.findViewById(R.id.ll_setting_path_sd);
        this.t = (LinearLayout) view.findViewById(R.id.ll_setting_path_stb);
        this.w = (ImageView) view.findViewById(R.id.setting_path_selected_rom);
        this.x = (ImageView) view.findViewById(R.id.setting_path_selected_sd);
        this.y = (ImageView) view.findViewById(R.id.setting_path_selected_stb);
        this.u = (TextView) view.findViewById(R.id.txt_setting_pathsize_rom);
        this.v = (TextView) view.findViewById(R.id.txt_setting_pathsize_sd);
        this.z = (ImageView) view.findViewById(R.id.bottom_line5);
        this.A = (TextView) view.findViewById(R.id.txt_download_storage_path);
        this.B = (TextView) view.findViewById(R.id.txt_setting_path_rom);
        this.C = (TextView) view.findViewById(R.id.txt_setting_path_sd);
        this.D = (TextView) view.findViewById(R.id.txt_setting_path_stb);
        if ("1".equals(ConfigMgr.readPropertie("SupportRemoteDownload", "0"))) {
            this.t.setVisibility(0);
            this.z.setVisibility(0);
        }
        f.a(this.p);
        f.a(this.q);
        f.a(this.r);
        f.a(this.s);
        f.a(this.t);
        f.a(this.w);
        f.a(this.x);
        f.a(this.y);
        f.a(this.u);
        f.a(this.A);
        f.a(this.B);
        f.a(this.v);
        f.a(this.C);
        f.a(this.D);
        f.a(view.findViewById(R.id.title_rlayout));
        f.a(view.findViewById(R.id.header_bottom_line));
        f.a(view.findViewById(R.id.ll_download_storage_path));
        f.a(view.findViewById(R.id.title_bottom_line2));
        f.a(view.findViewById(R.id.bottom_line3));
        f.a(view.findViewById(R.id.bottom_line4));
        this.A.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path));
        this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_rom));
        this.u.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_size_default));
        this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_sd));
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_size_default));
        this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_stb));
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.setting_storage_path));
        I();
        J();
        K();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.setting_storage_path_fragment, (ViewGroup) null);
        d(inflate);
        return inflate;
    }
}
