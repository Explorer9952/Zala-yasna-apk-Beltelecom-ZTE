package com.zte.iptvclient.android.mobile.a0.b;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.PortalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.lock.SDKLockMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.j.i;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: TvChannelsLockFragment.java */
/* loaded from: classes2.dex */
public class c extends com.zte.fragmentlib.b {
    private TextView A;
    private LinearLayout B;
    private TextView C;
    private TextView D;
    private TextView E;
    private Activity F;
    private ArrayList<Channel> p;
    private ArrayList<Channel> q;
    private ArrayList<Boolean> r;
    private ArrayList<Boolean> s;
    private ListView t;
    private com.zte.iptvclient.android.mobile.a0.a.b u;
    private String v;
    private LinearLayout w;
    private RelativeLayout x;
    private Button y;
    private TextView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsLockFragment.java */
    /* loaded from: classes2.dex */
    public class a implements SDKLockMgr.OnDelLockReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5381a;

        a(String str) {
            this.f5381a = str;
        }

        @Override // com.video.androidsdk.service.lock.SDKLockMgr.OnDelLockReturnListener
        public void onDelLockReturn(String str, String str2) {
            if ("0".equals(str)) {
                for (int i = 0; i < c.this.s.size(); i++) {
                    if (((Channel) c.this.q.get(i)).getChannelcode().equals(this.f5381a)) {
                        c.this.s.set(i, false);
                    }
                }
                c.this.u.notifyDataSetChanged();
                com.zte.iptvclient.android.mobile.f.b.a.b(((com.zte.fragmentlib.b) c.this).h);
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.change_limit_level_success);
                return;
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsLockFragment.java */
    /* loaded from: classes2.dex */
    public class b implements SDKLockMgr.OnAddLockReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5383a;

        b(String str) {
            this.f5383a = str;
        }

        @Override // com.video.androidsdk.service.lock.SDKLockMgr.OnAddLockReturnListener
        public void onAddLockReturn(String str, String str2) {
            if ("0".equals(str)) {
                for (int i = 0; i < c.this.s.size(); i++) {
                    if (((Channel) c.this.q.get(i)).getChannelcode().equals(this.f5383a)) {
                        c.this.s.set(i, true);
                    }
                }
                c.this.u.notifyDataSetChanged();
                com.zte.iptvclient.android.mobile.f.b.a.b(((com.zte.fragmentlib.b) c.this).h);
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.change_limit_level_success);
                return;
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsLockFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.a0.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0176c implements View.OnClickListener {
        ViewOnClickListenerC0176c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsLockFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.x.setVisibility(4);
            c.this.B.setVisibility(0);
            c.this.M().a(true);
            c.this.M().notifyDataSetChanged();
            c.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsLockFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.x.setVisibility(0);
            c.this.B.setVisibility(4);
            c.this.M().a(false);
            c.this.M().a();
            c.this.J();
            c.this.M().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsLockFragment.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.x.setVisibility(0);
            c.this.B.setVisibility(4);
            c.this.M().a(false);
            c.this.K();
            c.this.J();
            c.this.M().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsLockFragment.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!"1".equals(ConfigMgr.readPropertie("IsShowBlockTitle"))) {
                c.this.x.setVisibility(0);
                c.this.B.setVisibility(4);
                c.this.s("");
                c.this.M().a(false);
                c.this.J();
                c.this.M().notifyDataSetChanged();
                return;
            }
            c.this.t("lock");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChannelsLockFragment.java */
    /* loaded from: classes2.dex */
    public class h implements e.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5390a;

        h(String str) {
            this.f5390a = str;
        }

        @Override // com.zte.iptvclient.common.uiframe.e.d
        public void a() {
            c.this.e(this.f5390a, "0");
        }

        @Override // com.zte.iptvclient.common.uiframe.e.d
        public void b() {
            c.this.e(this.f5390a, "1");
        }

        @Override // com.zte.iptvclient.common.uiframe.e.d
        public ViewGroup.LayoutParams e() {
            return null;
        }
    }

    private void O() {
        ArrayList<Channel> arrayList = this.p;
        if (arrayList != null) {
            Iterator<Channel> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Channel next = it2.next();
                if (next.getColumncode().equals(this.v)) {
                    this.q.add(next);
                    this.r.add(Boolean.FALSE);
                    this.s.add(Boolean.FALSE);
                }
            }
            N();
        }
    }

    private void P() {
        this.y.setOnClickListener(new ViewOnClickListenerC0176c());
        this.A.setOnClickListener(new d());
        this.C.setOnClickListener(new e());
        this.D.setOnClickListener(new f());
        this.E.setOnClickListener(new g());
    }

    private void u(String str) {
        SDKLockMgr sDKLockMgr = new SDKLockMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("limittype", DownloadConstant.REPORT_MSGTYPE_ADD);
        hashMap.put("contentcode", str);
        hashMap.put("isshared", com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_IS_SHARE));
        sDKLockMgr.doDelLock(hashMap, new a(str));
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

    public void I() {
        this.E.setClickable(true);
        this.D.setClickable(true);
        this.E.setTextColor(c.a.a.a.d.b.d().b(R.color.vod_programname_textcolor));
        this.D.setTextColor(c.a.a.a.d.b.d().b(R.color.vod_programname_textcolor));
        SupportActivity supportActivity = this.h;
        if (supportActivity != null) {
            supportActivity.a(this.E, "textColor", R.color.vod_programname_textcolor);
            this.h.a(this.D, "textColor", R.color.vod_programname_textcolor);
        }
    }

    public void J() {
        for (int i = 0; i < this.r.size(); i++) {
            this.r.set(i, false);
        }
    }

    public void K() {
        for (int i = 0; i < this.q.size(); i++) {
            if (this.r.get(i).booleanValue()) {
                u(this.q.get(i).getChannelcode());
            }
        }
    }

    public void L() {
        this.E.setClickable(false);
        this.D.setClickable(false);
        this.E.setTextColor(c.a.a.a.d.b.d().b(R.color.mine_booking_posternote_textcolor));
        this.D.setTextColor(c.a.a.a.d.b.d().b(R.color.mine_booking_posternote_textcolor));
        SupportActivity supportActivity = this.h;
        if (supportActivity != null) {
            supportActivity.a(this.E, "textColor", R.color.mine_booking_posternote_textcolor);
            this.h.a(this.D, "textColor", R.color.mine_booking_posternote_textcolor);
        }
    }

    public com.zte.iptvclient.android.mobile.a0.a.b M() {
        return this.u;
    }

    public void N() {
        HashMap<String, String> a2 = com.zte.iptvclient.android.common.j.e.b().a();
        if (a2 != null && a2.size() != 0) {
            for (String str : a2.keySet()) {
                for (int i = 0; i < this.q.size(); i++) {
                    if (str.equals(this.q.get(i).getChannelcode())) {
                        this.s.set(i, true);
                    }
                }
            }
        }
        this.u.notifyDataSetChanged();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.p = i.d().b();
        this.v = com.zte.iptvclient.common.uiframe.a.c(com.zte.servicesdk.util.PortalConst.STR_RECORD_TV_COLUMN_ALL);
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.s = new ArrayList<>();
        com.zte.iptvclient.android.mobile.a0.a.b bVar = new com.zte.iptvclient.android.mobile.a0.a.b(this.F, this.q, this.r, this.s, this);
        this.u = bVar;
        this.t.setAdapter((ListAdapter) bVar);
        O();
        P();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.F = activity;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d("TvChannelsLockFragment", "onCreate");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tvchanel_lock, viewGroup, false);
        d(inflate);
        return inflate;
    }

    public void s(String str) {
        for (int i = 0; i < this.q.size(); i++) {
            if (this.r.get(i).booleanValue()) {
                f(this.q.get(i).getChannelcode(), str);
            }
        }
    }

    public void t(String str) {
        com.zte.iptvclient.common.uiframe.e eVar = new com.zte.iptvclient.common.uiframe.e(this.h, R.style.FullScreenDialog, R.layout.common_confirm_dialog, 0, R.id.common_confirm_dlg_title, R.id.common_confirm_dlg_content, R.id.more_logout_dialog_ok, R.id.more_logout_dialog_cancel, new h(str));
        eVar.d(this.h.getString(R.string.confirmation));
        eVar.b(this.h.getString(R.string.show_block_title));
        eVar.c(this.h.getString(R.string.common_yes));
        eVar.a(this.h.getString(R.string.common_no));
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.w = (LinearLayout) view.findViewById(R.id.lock_linearLayout_header);
        this.x = (RelativeLayout) view.findViewById(R.id.lock_nomal);
        this.y = (Button) view.findViewById(R.id.btn_back);
        this.z = (TextView) view.findViewById(R.id.lock_nomal_title);
        this.A = (TextView) view.findViewById(R.id.lock_nomal_btn_edit);
        this.B = (LinearLayout) view.findViewById(R.id.lock_edit);
        this.C = (TextView) view.findViewById(R.id.lock_edit_btn_cancel);
        this.D = (TextView) view.findViewById(R.id.lock_edit_btn_unlock);
        this.E = (TextView) view.findViewById(R.id.lock_edit_btn_lock);
        this.t = (ListView) view.findViewById(R.id.tv_lock_lv);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.lock_tv_channels));
        this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.lock_cancel));
        this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.unlock));
        this.E.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.lock));
        this.A.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_edit));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, String str2) {
        if (str.equals("lock")) {
            this.x.setVisibility(0);
            this.B.setVisibility(4);
            s(str2);
            M().a(false);
            J();
            M().notifyDataSetChanged();
            return;
        }
        if (str.equals("unlock")) {
            this.x.setVisibility(0);
            this.B.setVisibility(4);
            M().a(false);
            K();
            J();
            M().notifyDataSetChanged();
        }
    }

    private void f(String str, String str2) {
        SDKLockMgr sDKLockMgr = new SDKLockMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("limittype", DownloadConstant.REPORT_MSGTYPE_ADD);
        hashMap.put("contentcode", str);
        hashMap.put("isshared", com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_IS_SHARE));
        if ("1".equals(ConfigMgr.readPropertie("IsShowBlockTitle"))) {
            hashMap.put("blocktitleenable", str2);
        }
        sDKLockMgr.doAddLock(hashMap, new b(str));
    }
}
