package com.zte.iptvclient.android.mobile.w.a;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.download.Linstener.OnTaskOperReturnListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.SDKUserMgr;
import com.video.androidsdk.service.bean.UserProperties;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.view.ShSwitchView;
import com.zte.iptvclient.android.common.k.b;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.login.activity.LoginActivity;
import com.zte.iptvclient.android.zala.R;
import java.math.BigInteger;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: SettingsFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private TextView A;
    private TextView B;
    private LinearLayout C;
    private LinearLayout D;
    private RelativeLayout E;
    private s F;
    private com.zte.iptvclient.android.common.j.h G;
    private LinearLayout J;
    private TextView K;
    private ShSwitchView L;
    private TextView M;
    private RelativeLayout N;
    private String O;
    private TextView P;
    private LinearLayout Q;
    private LinearLayout R;
    private RelativeLayout S;
    private TextView T;
    private RelativeLayout U;
    private String V;
    private RelativeLayout W;
    private ShSwitchView X;
    private TextView Y;
    private TextView Z;
    private RelativeLayout a0;
    private OnTaskOperReturnListener b0 = new j(this);
    private Button p;
    private ShSwitchView q;
    private ToggleButton r;
    private ToggleButton s;
    private ShSwitchView t;
    private ToggleButton u;
    private LinearLayout v;
    private TextView w;
    private TextView x;
    private ImageView y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BaseApp.a(((com.zte.fragmentlib.b) b.this).h)) {
                b.this.a(new com.zte.iptvclient.android.mobile.i.b.d());
                return;
            }
            Intent intent = new Intent(b.this.getActivity(), (Class<?>) HostActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("fragmenttype", "DownloadSetStorage");
            intent.putExtras(bundle);
            b.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.w.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0385b implements ShSwitchView.e {
        C0385b() {
        }

        @Override // com.zte.iptvclient.android.common.customview.view.ShSwitchView.e
        public void a(boolean z) {
            if (z) {
                b.this.G.i(true);
                if (b.this.F != null) {
                    b.this.F.a(true);
                    return;
                }
                return;
            }
            b.this.G.i(false);
            if (b.this.F != null) {
                b.this.F.a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class c implements ShSwitchView.e {
        c(b bVar) {
        }

        @Override // com.zte.iptvclient.android.common.customview.view.ShSwitchView.e
        public void a(boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BaseApp.a(((com.zte.fragmentlib.b) b.this).h)) {
                b.this.a(R.id.settings, new com.zte.iptvclient.android.common.update.c());
                return;
            }
            Intent intent = new Intent(b.this.getActivity(), (Class<?>) HostActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("fragmenttype", "VersionUpdate");
            intent.putExtras(bundle);
            b.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String c2 = com.zte.iptvclient.common.uiframe.a.c("Privacy_Policy_Address");
            Intent intent = new Intent("android.intent.action.VIEW");
            if (TextUtils.isEmpty(c2)) {
                c2 = "https://www.beltelecom.by/private/tv/smart/privacy_policy";
            }
            intent.setData(Uri.parse(c2));
            b.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {

        /* compiled from: SettingsFragment.java */
        /* loaded from: classes2.dex */
        class a implements t.e {
            a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void b() {
                Toast.makeText(((com.zte.fragmentlib.b) b.this).h, "清除成功", 0).show();
            }
        }

        /* compiled from: SettingsFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.w.a.b$g$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0386b implements t.d {
            C0386b(g gVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                t.a(((com.zte.fragmentlib.b) b.this).h, "确定清除吗", new a());
            } else {
                t.a(((com.zte.fragmentlib.b) b.this).h, new C0386b(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class h implements ShSwitchView.e {

        /* compiled from: SettingsFragment.java */
        /* loaded from: classes2.dex */
        class a implements SDKUserMgr.OnUserPropertiesReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.SDKUserMgr.OnUserPropertiesReturnListener
            public void onUserPropertiesReturn(String str, String str2, UserProperties userProperties) {
                if (str.equals("0")) {
                    Toast.makeText(((com.zte.fragmentlib.b) b.this).h, userProperties.getSwitchvalue(), 0).show();
                    String switchvalue = userProperties.getSwitchvalue();
                    LogEx.d("SettingsFragment", switchvalue);
                    LogEx.d("SettingsFragment", Integer.parseInt(switchvalue) + "");
                    LogEx.d("SettingsFragment", new BigInteger(switchvalue).toString(2));
                }
            }
        }

        /* compiled from: SettingsFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.w.a.b$h$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0387b implements t.d {
            C0387b(h hVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        h() {
        }

        @Override // com.zte.iptvclient.android.common.customview.view.ShSwitchView.e
        public void a(boolean z) {
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                t.a(((com.zte.fragmentlib.b) b.this).h, new C0387b(this));
            } else if (z) {
                Toast.makeText(((com.zte.fragmentlib.b) b.this).h, "打开了", 0).show();
                new SDKUserMgr().getUserProperties(new a());
            } else {
                Toast.makeText(((com.zte.fragmentlib.b) b.this).h, "关闭了", 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class i implements b.d {
        i() {
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void a() {
            b.this.K();
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void b() {
        }
    }

    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    class j implements OnTaskOperReturnListener {
        j(b bVar) {
        }

        @Override // com.video.androidsdk.download.Linstener.OnTaskOperReturnListener
        public void onTaskOperReturn(String str, String str2, String str3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.getActivity() instanceof MainActivity) {
                b.this.F();
            } else if (b.this.getActivity() instanceof HostActivity) {
                b.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.d(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class m implements View.OnClickListener {

        /* compiled from: SettingsFragment.java */
        /* loaded from: classes2.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                b.this.r.setChecked(false);
                com.zte.iptvclient.android.mobile.download.helper.a.n().c(1);
            }
        }

        /* compiled from: SettingsFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.w.a.b$m$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class DialogInterfaceOnClickListenerC0388b implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0388b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                b.this.r.setChecked(true);
                com.zte.iptvclient.android.mobile.download.helper.a.n().c(0);
            }
        }

        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.download.helper.a.n().g() == 0) {
                b.this.r.setChecked(false);
                com.zte.iptvclient.android.mobile.download.helper.a.n().c(1);
            } else {
                new AlertDialog.Builder(b.this.getActivity()).setTitle(com.zte.iptvclient.android.common.i.a.a.a(R.string.change_confirm)).setMessage(com.zte.iptvclient.android.common.i.a.a.a(R.string.permit_2G_3G_network_download_confirm)).setIcon(R.drawable.ic_launcher).setPositiveButton(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm), new DialogInterfaceOnClickListenerC0388b()).setNegativeButton(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel), new a()).create().show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class n implements ShSwitchView.e {

        /* compiled from: SettingsFragment.java */
        /* loaded from: classes2.dex */
        class a implements t.e {
            a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void a() {
                b.this.q.a(true);
                com.zte.iptvclient.android.mobile.download.helper.a.n().c(1);
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void b() {
                b.this.q.a(false);
                com.zte.iptvclient.android.mobile.download.helper.a.n().c(0);
            }
        }

        n() {
        }

        @Override // com.zte.iptvclient.android.common.customview.view.ShSwitchView.e
        public void a(boolean z) {
            if (z) {
                com.zte.iptvclient.android.mobile.download.helper.a.n().c(1);
                SDKDownloadMgr.getInstance().pauseALL(2, b.this.b0);
                SDKDownloadMgr.getInstance().pauseALL(1, b.this.b0);
            } else {
                t.a(((com.zte.fragmentlib.b) b.this).h, com.zte.iptvclient.android.common.i.a.a.a(R.string.permit_2G_3G_network_download_confirm), new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class o implements CompoundButton.OnCheckedChangeListener {
        o(b bVar) {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                com.zte.iptvclient.android.mobile.download.helper.a.n().d(0);
            } else {
                com.zte.iptvclient.android.mobile.download.helper.a.n().d(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class p implements CompoundButton.OnCheckedChangeListener {
        p(b bVar) {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                com.zte.iptvclient.android.mobile.download.helper.a.n().b(0);
            } else {
                com.zte.iptvclient.android.mobile.download.helper.a.n().b(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class q implements View.OnClickListener {

        /* compiled from: SettingsFragment.java */
        /* loaded from: classes2.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.zte.iptvclient.android.mobile.download.helper.a.n().e(0);
                b.this.N();
            }
        }

        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 0) {
                return;
            }
            new AlertDialog.Builder(b.this.getActivity()).setTitle(com.zte.iptvclient.android.common.i.a.a.a(R.string.change_confirm)).setMessage(com.zte.iptvclient.android.common.i.a.a.a(R.string.switch_storage_path_confirm)).setIcon(R.drawable.ic_launcher).setPositiveButton(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm), new a()).setNegativeButton(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel), (DialogInterface.OnClickListener) null).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public class r implements View.OnClickListener {

        /* compiled from: SettingsFragment.java */
        /* loaded from: classes2.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.zte.iptvclient.android.mobile.download.helper.a.n().e(1);
                b.this.N();
            }
        }

        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 1) {
                return;
            }
            new AlertDialog.Builder(b.this.getActivity()).setTitle(com.zte.iptvclient.android.common.i.a.a.a(R.string.change_confirm)).setMessage(com.zte.iptvclient.android.common.i.a.a.a(R.string.switch_storage_path_confirm)).setIcon(R.drawable.ic_launcher).setPositiveButton(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm), new a()).setNegativeButton(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel), (DialogInterface.OnClickListener) null).create().show();
        }
    }

    /* compiled from: SettingsFragment.java */
    /* loaded from: classes2.dex */
    public interface s {
        void a(Boolean bool);
    }

    private void J() {
        this.p.setOnClickListener(new k());
        this.v.setOnClickListener(new l());
        this.r.setOnClickListener(new m());
        this.q.a(new n());
        this.s.setOnCheckedChangeListener(new o(this));
        this.u.setOnCheckedChangeListener(new p(this));
        this.C.setOnClickListener(new q());
        this.D.setOnClickListener(new r());
        this.E.setOnClickListener(new a());
        this.t.a(new C0385b());
        this.L.a(new c(this));
        this.J.setOnClickListener(new d());
        this.S.setOnClickListener(new e());
        this.U.setOnClickListener(new f());
        this.W.setOnClickListener(new g());
        this.X.a(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        com.zte.iptvclient.android.common.f.b.d.a(this.h);
        P();
    }

    private void L() {
        try {
            String b2 = com.zte.iptvclient.android.common.f.b.d.b(this.h);
            this.V = b2;
            this.K.setText(b2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String M() {
        try {
            String str = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
            if (!str.startsWith("V")) {
                str = "V" + str;
            }
            LogEx.d("HelpFeedBackFragment", "version is : " + str);
            return !StringUtil.isEmptyString(str) ? str : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        com.zte.iptvclient.android.common.j.h hVar = new com.zte.iptvclient.android.common.j.h(getActivity());
        this.G = hVar;
        if (hVar.p()) {
            this.t.a(true);
        } else {
            this.t.a(false);
        }
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().g() == 0) {
            this.r.setChecked(true);
        } else {
            this.r.setChecked(false);
        }
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().g() == 0) {
            this.q.a(false);
        } else {
            this.q.a(true);
        }
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().h() == 0) {
            this.s.setChecked(true);
        } else {
            this.s.setChecked(false);
        }
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().f() == 0) {
            this.u.setChecked(true);
        } else {
            this.u.setChecked(false);
        }
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 3) {
            this.w.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_stb));
            this.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_stb));
        } else if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 0) {
            this.w.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_rom));
            this.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_rom));
            this.y.setVisibility(0);
            this.z.setVisibility(4);
        } else {
            this.w.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_sd));
            this.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_sd));
            this.y.setVisibility(4);
            this.z.setVisibility(0);
        }
        this.L.a(this.G.a());
    }

    private void O() {
        Long valueOf = Long.valueOf(com.zte.iptvclient.android.mobile.download.helper.c.b.b(getActivity().getApplicationContext()));
        String a2 = com.zte.iptvclient.android.mobile.download.helper.c.b.a(valueOf.longValue(), false);
        LogEx.d("SettingsFragment", "SDTotalSize =" + valueOf);
        Long valueOf2 = Long.valueOf(com.zte.iptvclient.android.mobile.download.helper.c.b.b());
        String a3 = com.zte.iptvclient.android.mobile.download.helper.c.b.a(valueOf2.longValue(), false);
        LogEx.d("SettingsFragment", "RomTotalSize =" + valueOf2);
        if (valueOf.longValue() == 0) {
            this.D.setVisibility(8);
        } else {
            this.D.setVisibility(0);
        }
        if (valueOf2.longValue() == 0) {
            this.C.setVisibility(8);
        } else {
            this.C.setVisibility(0);
        }
        Long valueOf3 = Long.valueOf(com.zte.iptvclient.android.mobile.download.helper.c.b.a(getActivity().getApplicationContext()));
        Long valueOf4 = Long.valueOf(com.zte.iptvclient.android.mobile.download.helper.c.b.a());
        String a4 = com.zte.iptvclient.android.mobile.download.helper.c.b.a(valueOf3.longValue(), false);
        String a5 = com.zte.iptvclient.android.mobile.download.helper.c.b.a(valueOf4.longValue(), false);
        this.A.setText(a5 + "/" + a3);
        this.B.setText(a4 + "/" + a2);
    }

    private void P() {
        L();
    }

    public void I() {
        com.zte.iptvclient.android.common.k.b.a(this.h, com.zte.iptvclient.android.common.i.a.a.a(R.string.clear_app_date), new i());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d("SettingsFragment", "SettingsFragment onCreate");
        this.G = new com.zte.iptvclient.android.common.j.h(getActivity());
        EventBus.getDefault().register(this);
        com.zte.iptvclient.android.mobile.n.c.b.k();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.download_activity_setting, (ViewGroup) null);
        this.O = ConfigMgr.readPropertie("IsShowVoicePrintSwitch", "0");
        new com.zte.iptvclient.android.common.f.b.d();
        d(inflate);
        L();
        if (this.o) {
            this.p.setVisibility(0);
        }
        N();
        J();
        O();
        d(0);
        return inflate;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.d dVar) {
        if (!BaseApp.a(this.h) && "account".equals(dVar.a())) {
            if (getActivity() instanceof MainActivity) {
                F();
            } else if (getActivity() instanceof HostActivity) {
                getActivity().finish();
            }
            getActivity().startActivity(new Intent(getActivity(), (Class<?>) LoginActivity.class));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogEx.d("SettingsFragment", "SettingsFragment onResume");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LogEx.d("SettingsFragment", "SettingsFragment onStart");
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.S = (RelativeLayout) view.findViewById(R.id.rl_version);
        TextView textView2 = (TextView) view.findViewById(R.id.txt_version_number);
        this.T = textView2;
        textView2.setText(M());
        com.zte.iptvclient.common.uiframe.f.a(this.S);
        com.zte.iptvclient.common.uiframe.f.a(this.T);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_private);
        this.U = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        this.p = (Button) view.findViewById(R.id.btn_back);
        this.v = (LinearLayout) view.findViewById(R.id.setting_btn_path_layout);
        TextView textView3 = (TextView) view.findViewById(R.id.setting_btn_path);
        this.w = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_sd));
        TextView textView4 = (TextView) view.findViewById(R.id.storage_path);
        this.x = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_sd));
        this.K = (TextView) view.findViewById(R.id.storage_empty);
        this.J = (LinearLayout) view.findViewById(R.id.clear_storage_layout);
        this.r = (ToggleButton) view.findViewById(R.id.setting_btn_net);
        this.s = (ToggleButton) view.findViewById(R.id.setting_btn_wifi);
        this.u = (ToggleButton) view.findViewById(R.id.setting_btn_auto);
        this.t = (ShSwitchView) view.findViewById(R.id.setting_btn_notice);
        this.y = (ImageView) view.findViewById(R.id.setting_path_selected_rom);
        this.z = (ImageView) view.findViewById(R.id.setting_path_selected_sd);
        TextView textView5 = (TextView) view.findViewById(R.id.setting_txt_pathsize_rom);
        this.A = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_size_default));
        TextView textView6 = (TextView) view.findViewById(R.id.setting_txt_pathsize_sd);
        this.B = textView6;
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_size_default));
        this.C = (LinearLayout) view.findViewById(R.id.setting_btn_pathrom);
        this.D = (LinearLayout) view.findViewById(R.id.setting_btn_pathsd);
        this.q = (ShSwitchView) view.findViewById(R.id.float_view_switch);
        this.E = (RelativeLayout) view.findViewById(R.id.set_storage_layout);
        this.L = (ShSwitchView) view.findViewById(R.id.float_view_switch2);
        TextView textView7 = (TextView) view.findViewById(R.id.txt_set_ad);
        this.M = textView7;
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.ad_settings));
        this.N = (RelativeLayout) view.findViewById(R.id.rl_accept_voice_ad);
        this.P = (TextView) view.findViewById(R.id.storage_text);
        this.Q = (LinearLayout) view.findViewById(R.id.ll_notice_setting);
        this.R = (LinearLayout) view.findViewById(R.id.ll_settting_meaasge_notice);
        if (this.O.equals("0")) {
            this.N.setVisibility(8);
        } else if (this.G.a()) {
            this.L.a(true);
        } else {
            this.L.a(false);
        }
        ((TextView) view.findViewById(R.id.title_txt)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.setting_title));
        view.findViewById(R.id.header_bottom_line).setVisibility(8);
        TextView textView8 = (TextView) view.findViewById(R.id.download_set_text);
        textView8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting));
        com.zte.iptvclient.common.uiframe.f.a(textView8);
        TextView textView9 = (TextView) view.findViewById(R.id.wifi_download);
        textView9.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.only_download_in_wifi));
        com.zte.iptvclient.common.uiframe.f.a(textView9);
        TextView textView10 = (TextView) view.findViewById(R.id.storage_text);
        textView10.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.setting_storage_path));
        com.zte.iptvclient.common.uiframe.f.a(textView10);
        TextView textView11 = (TextView) view.findViewById(R.id.txt_accept_voice_ad);
        textView11.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.accetp_voice_ad));
        com.zte.iptvclient.common.uiframe.f.a(textView11);
        TextView textView12 = (TextView) view.findViewById(R.id.txt_notice_setting);
        textView12.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.setting_message));
        com.zte.iptvclient.common.uiframe.f.a(textView12);
        TextView textView13 = (TextView) view.findViewById(R.id.txt_notice_message);
        textView13.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.setting_message));
        com.zte.iptvclient.common.uiframe.f.a(textView13);
        TextView textView14 = (TextView) view.findViewById(R.id.txt_clear_storage);
        textView14.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.storage_clean_setting));
        com.zte.iptvclient.common.uiframe.f.a(textView14);
        TextView textView15 = (TextView) view.findViewById(R.id.clear_storage_text);
        textView15.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.clear_app_storage));
        com.zte.iptvclient.common.uiframe.f.a(textView15);
        TextView textView16 = (TextView) view.findViewById(R.id.txt_title_version);
        textView16.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.about_us));
        com.zte.iptvclient.common.uiframe.f.a(textView16);
        TextView textView17 = (TextView) view.findViewById(R.id.txt_version);
        textView17.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.temp_version));
        com.zte.iptvclient.common.uiframe.f.a(textView17);
        TextView textView18 = (TextView) view.findViewById(R.id.txt_network_hint);
        textView18.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_net));
        com.zte.iptvclient.common.uiframe.f.a(textView18);
        TextView textView19 = (TextView) view.findViewById(R.id.txt_wifi_hint);
        textView19.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_wifi));
        com.zte.iptvclient.common.uiframe.f.a(textView19);
        TextView textView20 = (TextView) view.findViewById(R.id.txt_auto);
        textView20.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_auto));
        com.zte.iptvclient.common.uiframe.f.a(textView20);
        TextView textView21 = (TextView) view.findViewById(R.id.txt_path);
        textView21.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path));
        com.zte.iptvclient.common.uiframe.f.a(textView21);
        TextView textView22 = (TextView) view.findViewById(R.id.txt_path_rom);
        textView22.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_rom));
        com.zte.iptvclient.common.uiframe.f.a(textView22);
        TextView textView23 = (TextView) view.findViewById(R.id.txt_path_sd);
        textView23.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_sd));
        com.zte.iptvclient.common.uiframe.f.a(textView23);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.layout_setting));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.line_1));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.layout_1));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.float_view_switch));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.line_2));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.set_storage_layout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.storage_path));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.arrow_1));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.line_3));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.bottom_line4));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.bottom_line5));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.bottom_line6));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_notice_setting));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_settting_meaasge_notice));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.line_4));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_accept_voice_ad));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.float_view_switch2));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_clear_storage_title));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.clear_storage_layout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.storage_empty));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.bottom_line7));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_title_private));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_private));
        this.a0 = (RelativeLayout) view.findViewById(R.id.mine_set_datacollect_rl);
        this.X = (ShSwitchView) view.findViewById(R.id.mine_set_datacollect_toggle);
        this.Z = (TextView) view.findViewById(R.id.mine_set_datacollect_top);
        TextView textView24 = (TextView) view.findViewById(R.id.mine_set_datacollect_toptxt);
        TextView textView25 = (TextView) view.findViewById(R.id.mine_set_datacollect_txt);
        ImageView imageView = (ImageView) view.findViewById(R.id.mine_set_record_iv);
        this.W = (RelativeLayout) view.findViewById(R.id.mine_set_record_rl);
        this.Y = (TextView) view.findViewById(R.id.mine_set_record_top);
        TextView textView26 = (TextView) view.findViewById(R.id.mine_set_record_tv);
        TextView textView27 = (TextView) view.findViewById(R.id.mine_set_record_tvbottom);
        TextView textView28 = (TextView) view.findViewById(R.id.mine_set_record_tvtop);
        com.zte.iptvclient.common.uiframe.f.a(this.a0);
        com.zte.iptvclient.common.uiframe.f.a(this.X);
        com.zte.iptvclient.common.uiframe.f.a(this.Z);
        com.zte.iptvclient.common.uiframe.f.a(textView24);
        com.zte.iptvclient.common.uiframe.f.a(textView25);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        com.zte.iptvclient.common.uiframe.f.a(this.W);
        com.zte.iptvclient.common.uiframe.f.a(this.Y);
        com.zte.iptvclient.common.uiframe.f.a(textView26);
        com.zte.iptvclient.common.uiframe.f.a(textView27);
        com.zte.iptvclient.common.uiframe.f.a(textView28);
        this.Y.setText("清空记录");
        textView28.setText("一键清空个人数据");
        textView27.setText("清空收藏,书签等个人数据");
        textView26.setText("清空");
        this.Z.setText("数据收集");
        textView24.setText("个人数据收集");
        textView25.setText("允许记录收藏,书签,直播提醒等数据");
        if ("1".equals(ConfigMgr.readPropertie("IsShanDongVersion")) || "1".equals(ConfigMgr.readPropertie("IsSupportSingtel"))) {
            this.M.setVisibility(8);
            this.N.setVisibility(8);
            view.findViewById(R.id.line_4).setVisibility(8);
        }
        if ("0".equals(ConfigMgr.readPropertie("IsSupportDownload"))) {
            view.findViewById(R.id.download_set_text).setVisibility(8);
            view.findViewById(R.id.line_1).setVisibility(8);
            view.findViewById(R.id.line_2).setVisibility(8);
            view.findViewById(R.id.line_3).setVisibility(8);
            view.findViewById(R.id.layout_1).setVisibility(8);
            this.E.setVisibility(8);
        }
        if ("1".equals(ConfigMgr.readPropertie("IsSupportGDPR"))) {
            this.Y.setVisibility(0);
            this.W.setVisibility(0);
            this.Z.setVisibility(0);
            this.a0.setVisibility(0);
            this.X.a(true);
        }
        if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
        }
        ImageView imageView2 = (ImageView) view.findViewById(R.id.header_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(imageView2);
        if (BaseApp.a(this.h)) {
            imageView2.setVisibility(0);
            com.zte.iptvclient.android.common.k.g.a(imageView2, this.h);
        }
    }

    @Override // com.zte.fragmentlib.b
    public void a(int i2, com.zte.fragmentlib.b bVar) {
        this.i.a(this.h.getSupportFragmentManager(), i2, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        if (i2 != 1) {
            return;
        }
        O();
    }
}
