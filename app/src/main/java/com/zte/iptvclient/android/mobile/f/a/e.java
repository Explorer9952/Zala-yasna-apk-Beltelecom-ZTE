package com.zte.iptvclient.android.mobile.f.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.e;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LevelModificationFragment.java */
/* loaded from: classes.dex */
public class e extends com.zte.fragmentlib.b implements View.OnClickListener {
    private TextView A;
    private LinearLayout B;
    private TextView C;
    private TextView D;
    private TextView E;
    private int F;
    private ListView p;
    private ArrayList<C0250e> q;
    private d r;
    private int s;
    private LayoutInflater t;
    private boolean u = false;
    private h v;
    private LinearLayout w;
    private RelativeLayout x;
    private Button y;
    private TextView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LevelModificationFragment.java */
    /* loaded from: classes.dex */
    public class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6207a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6208b;

        a(int i, String str) {
            this.f6207a = i;
            this.f6208b = str;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("LevelModifyFragment", "modifyLimitLevel:  onDataReturn,arg0= " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    e.this.v.a(this.f6207a);
                    e.this.x.setVisibility(0);
                    e.this.B.setVisibility(4);
                    e.this.F = e.this.K();
                    e.this.e(e.this.K());
                    e.this.b(false);
                    e.this.I().notifyDataSetChanged();
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.change_limit_level_success);
                    if ("0".equals(ConfigMgr.readPropertie("EuropeLogin"))) {
                        e.this.v.O(e.this.v.E());
                    } else {
                        e.this.v.O(this.f6208b);
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
            LogEx.d("LevelModifyFragment", "modifyLimitLevel onFailReturn,arg0= " + str + " ,arg1=" + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LevelModificationFragment.java */
    /* loaded from: classes.dex */
    public class b implements e.d {
        b() {
        }

        @Override // com.zte.iptvclient.common.uiframe.e.d
        public void a() {
            e eVar = e.this;
            eVar.a(eVar.J(), "0");
        }

        @Override // com.zte.iptvclient.common.uiframe.e.d
        public void b() {
            e eVar = e.this;
            eVar.a(eVar.J(), "1");
        }

        @Override // com.zte.iptvclient.common.uiframe.e.d
        public ViewGroup.LayoutParams e() {
            return null;
        }
    }

    /* compiled from: LevelModificationFragment.java */
    /* loaded from: classes.dex */
    static class c {

        /* renamed from: a, reason: collision with root package name */
        ImageView f6211a;

        /* renamed from: b, reason: collision with root package name */
        TextView f6212b;

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LevelModificationFragment.java */
    /* loaded from: classes.dex */
    public class d extends BaseAdapter {

        /* compiled from: LevelModificationFragment.java */
        /* loaded from: classes.dex */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6214a;

            a(int i) {
                this.f6214a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.u) {
                    int i = e.this.s;
                    int i2 = this.f6214a;
                    if (i == i2 + 1) {
                        e.this.s = i2;
                    } else {
                        e.this.s = i2 + 1;
                    }
                    e.this.r.notifyDataSetChanged();
                }
            }
        }

        d() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return e.this.q.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return e.this.q.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            c cVar;
            if (view == null) {
                cVar = new c();
                view2 = e.this.t.inflate(R.layout.level_modification_item, (ViewGroup) null);
                cVar.f6211a = (ImageView) view2.findViewById(R.id.level_selector);
                cVar.f6212b = (TextView) view2.findViewById(R.id.level_content);
                view2.setTag(cVar);
            } else {
                view2 = view;
                cVar = (c) view.getTag();
            }
            if (e.this.u) {
                cVar.f6211a.setVisibility(0);
            } else {
                cVar.f6211a.setVisibility(4);
            }
            if (e.this.s > i) {
                cVar.f6211a.setImageResource(R.drawable.select);
                cVar.f6211a.setVisibility(0);
            } else {
                cVar.f6211a.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.unselect));
                if (((com.zte.fragmentlib.b) e.this).h != null) {
                    ((com.zte.fragmentlib.b) e.this).h.a(cVar.f6211a, "background", R.drawable.unselect);
                }
            }
            cVar.f6212b.setText(((C0250e) e.this.q.get(i)).f6217b);
            view2.setOnClickListener(new a(i));
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LevelModificationFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.f.a.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0250e {

        /* renamed from: a, reason: collision with root package name */
        int f6216a;

        /* renamed from: b, reason: collision with root package name */
        String f6217b;

        /* synthetic */ C0250e(int i, String str, a aVar) {
            this(i, str);
        }

        private C0250e(int i, String str) {
            this.f6216a = i;
            this.f6217b = str;
        }
    }

    private void L() {
        com.zte.iptvclient.common.uiframe.e eVar = new com.zte.iptvclient.common.uiframe.e(this.h, R.style.FullScreenDialog, R.layout.common_confirm_dialog, 0, R.id.common_confirm_dlg_title, R.id.common_confirm_dlg_content, R.id.more_logout_dialog_ok, R.id.more_logout_dialog_cancel, new b());
        eVar.d(this.h.getString(R.string.confirmation));
        eVar.b(this.h.getString(R.string.show_block_title));
        eVar.c(this.h.getString(R.string.common_yes));
        eVar.a(this.h.getString(R.string.common_no));
    }

    private void M() {
        ArrayList<C0250e> arrayList = new ArrayList<>();
        this.q = arrayList;
        a aVar = null;
        arrayList.add(new C0250e(16, com.zte.iptvclient.android.common.i.a.a.a(R.string.parent_control_title_one), aVar));
        this.q.add(new C0250e(24, com.zte.iptvclient.android.common.i.a.a.a(R.string.parent_control_title_two), aVar));
        this.q.add(new C0250e(28, com.zte.iptvclient.android.common.i.a.a.a(R.string.parent_control_title_there), aVar));
        this.q.add(new C0250e(30, com.zte.iptvclient.android.common.i.a.a.a(R.string.parent_control_title_four), aVar));
        this.q.add(new C0250e(31, com.zte.iptvclient.android.common.i.a.a.a(R.string.parent_control_title_five), aVar));
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

    public d I() {
        return this.r;
    }

    public int J() {
        int i = this.s;
        if (i == 0) {
            return 0;
        }
        return this.q.get(i - 1).f6216a;
    }

    public int K() {
        return this.s;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.t = (LayoutInflater) getActivity().getSystemService("layout_inflater");
        M();
        h hVar = new h(getActivity());
        this.v = hVar;
        this.s = d(hVar.t());
        d dVar = new d();
        this.r = dVar;
        this.p.setAdapter((ListAdapter) dVar);
        this.r.notifyDataSetChanged();
        super.onActivityCreated(bundle);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back /* 2131296427 */:
                D();
                return;
            case R.id.lock_confrim_cancel /* 2131297387 */:
                this.x.setVisibility(0);
                this.B.setVisibility(4);
                e(this.F);
                b(false);
                I().notifyDataSetChanged();
                return;
            case R.id.lock_confrim_ok /* 2131297388 */:
                this.x.setVisibility(0);
                this.B.setVisibility(4);
                if ("1".equals(ConfigMgr.readPropertie("IsShowBlockTitle"))) {
                    L();
                    return;
                } else {
                    a(J(), "");
                    return;
                }
            case R.id.lock_nomal_btn_edit /* 2131297397 */:
                this.x.setVisibility(4);
                this.B.setVisibility(0);
                this.F = K();
                b(true);
                I().notifyDataSetChanged();
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_level_modification, viewGroup, false);
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
        this.p = (ListView) view.findViewById(R.id.Level_list);
        this.w = (LinearLayout) view.findViewById(R.id.lock_linearLayout_header);
        this.x = (RelativeLayout) view.findViewById(R.id.lock_nomal);
        this.y = (Button) view.findViewById(R.id.btn_back);
        this.z = (TextView) view.findViewById(R.id.lock_nomal_title);
        this.A = (TextView) view.findViewById(R.id.lock_nomal_btn_edit);
        this.B = (LinearLayout) view.findViewById(R.id.lock_confrim);
        this.C = (TextView) view.findViewById(R.id.lock_confrim_cancel);
        this.D = (TextView) view.findViewById(R.id.lock_confirm_title);
        this.E = (TextView) view.findViewById(R.id.lock_confrim_ok);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        this.y.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.level_modification));
        this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.level_modification));
        this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.lock_cancel));
        this.A.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_edit));
        this.E.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.lock_ok));
    }

    public void e(int i) {
        this.s = i;
    }

    public void a(int i, String str) {
        if (ConfigMgr.readPropertie("IsShowBlockTitle") == null || "0".equals(ConfigMgr.readPropertie("IsShowBlockTitle"))) {
            str = "0";
        }
        String replace = ("http://{epgdomain}:{port}/iptvepg/datasource/dochangeuserlevel.jsp?limitlevel=" + i + "&blocktitlelevel=" + str + "&password=" + this.v.u()).replace("http://{epgdomain}:{port}", i.b());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.startRequest(replace, "GET", new a(i, str));
    }

    public void b(boolean z) {
        this.u = z;
    }

    public int d(int i) {
        if ((i & 16) == 0) {
            return 0;
        }
        int i2 = 1;
        if ((i & 8) != 0) {
            int i3 = (i & 4) != 0 ? 3 : 2;
            if ((i & 2) != 0) {
                i3++;
                if ((i & 1) != 0) {
                    i2 = i3 + 1;
                }
            }
            i2 = i3;
        }
        LogEx.d("LevelModifiFragment", "countposition=" + i2);
        return i2;
    }
}
