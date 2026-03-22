package com.zte.iptvclient.android.mobile.f.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.SDKUserMgr;
import com.video.androidsdk.service.bean.UserSwitchReq;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ATLevelModificationFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b {
    private String A;
    private String[] B = new String[0];
    private String[] C = new String[0];
    private String[] D = new String[0];
    private String[] E = new String[0];
    private String F = "";
    private int G;
    private h J;
    private int K;
    private int L;
    private Button p;
    private TextView q;
    private ListView r;
    private ImageView s;
    private TextView t;
    private List<String> u;
    private List<g> v;
    private e w;
    private String x;
    private String y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ATLevelModificationFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.f.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0244a implements View.OnClickListener {
        ViewOnClickListenerC0244a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ATLevelModificationFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.s.isSelected()) {
                a.this.s.setSelected(false);
                a.this.s.setBackground(((com.zte.fragmentlib.b) a.this).h.getResources().getDrawable(R.drawable.unselect));
            } else {
                a.this.s.setSelected(true);
                a.this.s.setBackground(((com.zte.fragmentlib.b) a.this).h.getResources().getDrawable(R.drawable.select));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ATLevelModificationFragment.java */
    /* loaded from: classes.dex */
    public class c implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6139a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6140b;

        c(int i, String str) {
            this.f6139a = i;
            this.f6140b = str;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("ATLevelModificationFragment", "modifyLimitLevel:  onDataReturn,arg0= " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    a.this.J.a(this.f6139a);
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.change_limit_level_success);
                    if ("0".equals(ConfigMgr.readPropertie("EuropeLogin"))) {
                        a.this.J.O(a.this.J.E());
                    } else {
                        a.this.J.O(this.f6140b);
                    }
                } else {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(jSONObject.getString("errormsg"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("ATLevelModificationFragment", "modifyLimitLevel onFailReturn,arg0= " + str + " ,arg1=" + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ATLevelModificationFragment.java */
    /* loaded from: classes.dex */
    public class d implements SDKUserMgr.OnChangeUserSwitchReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6142a;

        d(String str) {
            this.f6142a = str;
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnChangeUserSwitchReturnListener
        public void onChangeUserSwitchReturn(String str, String str2) {
            if (TextUtils.equals(str, "0")) {
                if (this.f6142a.equals("0")) {
                    a.this.J.n(false);
                } else {
                    a.this.J.n(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ATLevelModificationFragment.java */
    /* loaded from: classes.dex */
    public class e extends BaseAdapter {

        /* compiled from: ATLevelModificationFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.f.a.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class ViewOnClickListenerC0245a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6145a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ f f6146b;

            ViewOnClickListenerC0245a(int i, f fVar) {
                this.f6145a = i;
                this.f6146b = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (((g) a.this.v.get(this.f6145a)).f6153b.equals(((com.zte.fragmentlib.b) a.this).h.getResources().getString(R.string.cancel_purchase_password))) {
                    if (a.this.F.equals("1")) {
                        a.this.F = "0";
                        this.f6146b.f6148a.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.select));
                        this.f6146b.f6148a.setVisibility(0);
                        ((com.zte.fragmentlib.b) a.this).h.a(this.f6146b.f6148a, "src", R.drawable.select);
                        return;
                    }
                    a.this.F = "1";
                    this.f6146b.f6148a.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.unselect));
                    if (((com.zte.fragmentlib.b) a.this).h != null) {
                        ((com.zte.fragmentlib.b) a.this).h.a(this.f6146b.f6148a, "background", R.drawable.unselect);
                        return;
                    }
                    return;
                }
                int i = a.this.G;
                int i2 = this.f6145a;
                if (i == i2 + 1) {
                    a.this.G = i2;
                } else {
                    a.this.G = i2 + 1;
                }
                a.this.w.notifyDataSetChanged();
            }
        }

        private e() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (a.this.v.size() == 0) {
                return 0;
            }
            return a.this.v.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                f fVar = new f();
                View inflate = LayoutInflater.from(((com.zte.fragmentlib.b) a.this).h).inflate(R.layout.item_level_at, (ViewGroup) null);
                fVar.f6148a = (ImageView) inflate.findViewById(R.id.img_selected);
                fVar.f6149b = (ImageView) inflate.findViewById(R.id.img_level);
                fVar.f6150c = (TextView) inflate.findViewById(R.id.txt_level);
                fVar.f6151d = (TextView) inflate.findViewById(R.id.txt_name);
                fVar.e = (LinearLayout) inflate.findViewById(R.id.ll_layout);
                com.zte.iptvclient.common.uiframe.f.a(fVar.f6148a);
                com.zte.iptvclient.common.uiframe.f.a(fVar.f6149b);
                com.zte.iptvclient.common.uiframe.f.a(fVar.f6150c);
                com.zte.iptvclient.common.uiframe.f.a(fVar.f6151d);
                com.zte.iptvclient.common.uiframe.f.a(fVar.e);
                inflate.setTag(fVar);
                view = inflate;
            }
            f fVar2 = (f) view.getTag();
            if (!((g) a.this.v.get(i)).f6153b.equals(((com.zte.fragmentlib.b) a.this).h.getResources().getString(R.string.cancel_purchase_password))) {
                fVar2.f6150c.setText(((g) a.this.v.get(i)).f6153b);
                for (int i2 = 0; i2 < a.this.E.length; i2++) {
                    if (a.this.B[i2].equals(((g) a.this.v.get(i)).f6154c)) {
                        String str = i.f() + "images/" + a.this.D[i2];
                        fVar2.f6149b.setVisibility(0);
                        com.bumptech.glide.i.b(SDKMgr.getApplicationContext()).a(str).a(fVar2.f6149b);
                        LogEx.d("ATLevelModificationFragment", "imageUrl = " + str);
                    }
                }
                fVar2.f6151d.setVisibility(8);
                if (a.this.G <= i) {
                    fVar2.f6148a.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.unselect));
                    if (((com.zte.fragmentlib.b) a.this).h != null) {
                        ((com.zte.fragmentlib.b) a.this).h.a(fVar2.f6148a, "background", R.drawable.unselect);
                    }
                } else {
                    fVar2.f6148a.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.select));
                    fVar2.f6148a.setVisibility(0);
                    ((com.zte.fragmentlib.b) a.this).h.a(fVar2.f6148a, "src", R.drawable.select);
                    a.this.u.add(((g) a.this.v.get(i)).f6154c);
                }
            } else {
                fVar2.f6150c.setText(((g) a.this.v.get(i)).f6153b);
                fVar2.f6149b.setVisibility(8);
                fVar2.f6151d.setVisibility(8);
                if (a.this.F.equals("1")) {
                    fVar2.f6148a.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.unselect));
                    if (((com.zte.fragmentlib.b) a.this).h != null) {
                        ((com.zte.fragmentlib.b) a.this).h.a(fVar2.f6148a, "background", R.drawable.unselect);
                    }
                } else {
                    fVar2.f6148a.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.select));
                    fVar2.f6148a.setVisibility(0);
                    ((com.zte.fragmentlib.b) a.this).h.a(fVar2.f6148a, "src", R.drawable.select);
                }
            }
            fVar2.e.setOnClickListener(new ViewOnClickListenerC0245a(i, fVar2));
            return view;
        }

        /* synthetic */ e(a aVar, ViewOnClickListenerC0244a viewOnClickListenerC0244a) {
            this();
        }
    }

    /* compiled from: ATLevelModificationFragment.java */
    /* loaded from: classes.dex */
    static class f {

        /* renamed from: a, reason: collision with root package name */
        private ImageView f6148a;

        /* renamed from: b, reason: collision with root package name */
        private ImageView f6149b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f6150c;

        /* renamed from: d, reason: collision with root package name */
        private TextView f6151d;
        private LinearLayout e;

        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ATLevelModificationFragment.java */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        int f6152a;

        /* renamed from: b, reason: collision with root package name */
        String f6153b;

        /* renamed from: c, reason: collision with root package name */
        String f6154c;

        /* synthetic */ g(int i, String str, String str2, ViewOnClickListenerC0244a viewOnClickListenerC0244a) {
            this(i, str, str2);
        }

        private g(int i, String str, String str2) {
            this.f6152a = i;
            this.f6153b = str;
            this.f6154c = str2;
        }
    }

    private void J() {
        this.y = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_VALUE);
        this.x = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_NAME);
        this.z = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_IMG);
        this.A = o.j().b(com.zte.iptvclient.android.common.i.a.a.a(R.string.limit_level_description));
        if (!TextUtils.isEmpty(this.y)) {
            this.C = this.y.split(",");
        }
        if (!TextUtils.isEmpty(this.x)) {
            this.B = this.x.split(",");
        }
        if (!TextUtils.isEmpty(this.z)) {
            this.D = this.z.split(",");
        }
        if (!TextUtils.isEmpty(this.A)) {
            this.E = this.A.split("\\|");
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.C;
            if (i2 >= strArr.length) {
                break;
            }
            this.K += Integer.parseInt(strArr[i2]);
            i2++;
        }
        this.L = this.J.t();
        this.v = new ArrayList();
        String[] strArr2 = this.E;
        ViewOnClickListenerC0244a viewOnClickListenerC0244a = null;
        if (strArr2 != null && this.C.length == strArr2.length) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.E.length; i4++) {
                if (i4 == 0) {
                    i3 = Integer.parseInt(this.C[i4]);
                } else {
                    i3 += Integer.parseInt(this.C[i4]);
                }
                this.v.add(new g(i3, this.E[i4], String.valueOf(this.B[i4]), viewOnClickListenerC0244a));
                LogEx.d("ATLevelModificationFragment", "levelValue = " + i3);
            }
        }
        this.v.add(new g(i, this.h.getResources().getString(R.string.cancel_purchase_password), "", viewOnClickListenerC0244a));
        int i5 = this.K;
        int i6 = this.L;
        if (i5 - i6 == 0) {
            this.G = 0;
        } else {
            this.G = d(i5 - i6);
        }
        if (this.J.A()) {
            this.F = "1";
        }
        e eVar = new e(this, viewOnClickListenerC0244a);
        this.w = eVar;
        this.r.setAdapter((ListAdapter) eVar);
    }

    private void K() {
        this.p.setOnClickListener(new ViewOnClickListenerC0244a());
        this.s.setOnClickListener(new b());
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (this.K - I() != this.L) {
            if (this.s.isSelected()) {
                a(I(), "1");
            } else {
                a(I(), "0");
            }
        }
        if (this.F.length() != 0) {
            s(this.F);
        }
        if (getActivity() instanceof MainActivity) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a("parentcontral", true));
        } else if (getActivity() instanceof HostActivity) {
            getActivity().finish();
        }
        return true;
    }

    public int I() {
        List<g> list = this.v;
        if (list == null || this.G == 0 || list.size() == 1 || this.v.size() <= 0) {
            return 0;
        }
        return this.v.get(this.G - 1).f6152a;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.J = new h(this.h);
        this.u = new ArrayList();
        if ("1".equals(this.J.Y())) {
            this.s.setSelected(true);
            this.s.setBackground(this.h.getResources().getDrawable(R.drawable.select));
        } else {
            this.s.setSelected(false);
        }
        J();
        K();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_level_modification_at, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.p = button;
        button.setVisibility(0);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        this.q = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_pd_rating));
        this.r = (ListView) view.findViewById(R.id.lst_level);
        this.s = (ImageView) view.findViewById(R.id.img_selected);
        this.t = (TextView) view.findViewById(R.id.txt_block_title);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.layout_l));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.level_lock_point));
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_rat_txt));
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (BaseApp.a(this.h)) {
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
        }
    }

    private void s(String str) {
        UserSwitchReq userSwitchReq = new UserSwitchReq(str, 3);
        userSwitchReq.setPassword(this.J.u());
        new SDKUserMgr().changeUserSwitch(userSwitchReq, new d(str));
    }

    public void a(int i, String str) {
        int i2 = this.K - i;
        if (ConfigMgr.readPropertie("IsShowBlockTitle") == null || "0".equals(ConfigMgr.readPropertie("IsShowBlockTitle"))) {
            str = "0";
        }
        String replace = ("http://{epgdomain}:{port}/iptvepg/datasource/dochangeuserlevel.jsp?limitlevel=" + i2 + "&blocktitlelevel=" + str + "&password=" + this.J.u()).replace("http://{epgdomain}:{port}", i.b());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.startRequest(replace, "GET", new c(i2, str));
    }

    public int d(int i) {
        int i2 = 0;
        if (this.C == null) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            String[] strArr = this.C;
            if (i2 < strArr.length) {
                if ((Integer.parseInt(strArr[i2]) & i) != 0) {
                    i3++;
                }
                i2++;
            } else {
                LogEx.d("ATLevelModificationFragment", "countposition=" + i3);
                return i3;
            }
        }
    }
}
