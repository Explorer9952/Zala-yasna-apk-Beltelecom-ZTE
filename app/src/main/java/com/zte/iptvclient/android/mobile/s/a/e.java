package com.zte.iptvclient.android.mobile.s.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.auth.SDKSubscribeMgr;
import com.video.androidsdk.service.bean.SubscribeInfo;
import com.video.androidsdk.service.bean.SubscribeReq;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.customview.viewgroup.gridview.RecomeGridView;
import com.zte.iptvclient.android.common.j.i;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.common.k.w;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.mobile.productpackage.fragment.bean.PackageBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: SecondMyPackageFragment.java */
/* loaded from: classes2.dex */
public class e extends com.zte.fragmentlib.b {
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private ImageView F;
    private ArrayList<com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a> G;
    private String J;
    private g K;
    private TextView L;
    private int M;
    private ArrayList<Channel> N;
    private ArrayList<Channel> O = i.d().b();
    private HandlerC0342e P = new HandlerC0342e(this);
    private Button p;
    private TextView q;
    private RecomeGridView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private LinearLayout x;
    private ImageView y;
    private PackageBean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SecondMyPackageFragment.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SecondMyPackageFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("dataBean", e.this.z);
            bundle.putInt(ParamConst.LIMIT_LIST_RSP_POSITION, e.this.M);
            if (!BaseApp.a(((com.zte.fragmentlib.b) e.this).h)) {
                e.this.a("packagedetailfragment", bundle);
                return;
            }
            com.zte.iptvclient.android.mobile.s.a.c cVar = new com.zte.iptvclient.android.mobile.s.a.c();
            cVar.setArguments(bundle);
            e.this.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SecondMyPackageFragment.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* compiled from: SecondMyPackageFragment.java */
        /* loaded from: classes2.dex */
        class a implements f.c {
            a() {
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void a() {
                e eVar = e.this;
                new f("0", eVar.J, "2").start();
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void b() {
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                new com.zte.iptvclient.android.common.customview.a.a.e.f(((com.zte.fragmentlib.b) e.this).h, R.drawable.custom_dialog_login_img, R.string.purchase_cancel, R.drawable.custom_dialog_button_blue, R.string.common_ok, 0, R.drawable.custom_dialog_button_blue, R.string.common_cancel, 0, new a()).a();
            } catch (Exception e) {
                LogEx.e("SecondMyPackageFragment", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SecondMyPackageFragment.java */
    /* loaded from: classes2.dex */
    public class d implements SDKSubscribeMgr.OnProdContentListReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnProdContentListReturnListener
        public void onProdContentListReturn(String str, String str2, String str3) {
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONArray(str3);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("data");
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            e.this.G.add(com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a.a(jSONArray2.getJSONObject(i2)));
                        }
                    }
                    if (e.this.G != null) {
                        e.this.K = new g(((com.zte.fragmentlib.b) e.this).h, e.this.G);
                        e.this.r.setAdapter((ListAdapter) e.this.K);
                        e.this.K.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* compiled from: SecondMyPackageFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.s.a.e$e, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class HandlerC0342e extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<e> f7113a;

        public HandlerC0342e(e eVar) {
            this.f7113a = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            e eVar = this.f7113a.get();
            if (eVar == null) {
                return;
            }
            switch (message.what) {
                case 1003521:
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.cancel_autocontinue) + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_select_setpwd));
                    EventBus.getDefault().post(new com.zte.iptvclient.android.mobile.s.a.a());
                    eVar.L.setVisibility(8);
                    return;
                case 1003522:
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a((String) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: SecondMyPackageFragment.java */
    /* loaded from: classes2.dex */
    private class f extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private String f7114a;

        /* renamed from: b, reason: collision with root package name */
        private String f7115b;

        /* renamed from: c, reason: collision with root package name */
        private String f7116c;

        /* compiled from: SecondMyPackageFragment.java */
        /* loaded from: classes2.dex */
        class a implements SDKSubscribeMgr.OnDoSubscribeReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnDoSubscribeReturnListener
            public void onDoSubscribeReturn(String str, String str2, SubscribeInfo subscribeInfo) {
                if (TextUtils.equals(str, "0")) {
                    e.this.P.sendEmptyMessage(1003521);
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 1003522;
                obtain.obj = str2;
                e.this.P.sendMessage(obtain);
            }
        }

        public f(String str, String str2, String str3) {
            this.f7114a = str;
            this.f7115b = str2;
            this.f7116c = str3;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            new SDKSubscribeMgr().doSubscribe(new SubscribeReq(this.f7114a, this.f7115b, this.f7116c), new a());
        }
    }

    /* compiled from: SecondMyPackageFragment.java */
    /* loaded from: classes2.dex */
    class g extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a> f7119a;

        /* renamed from: b, reason: collision with root package name */
        private LayoutInflater f7120b;

        /* renamed from: c, reason: collision with root package name */
        private Activity f7121c;

        /* compiled from: SecondMyPackageFragment.java */
        /* loaded from: classes2.dex */
        private class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            private com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a f7123a;

            public a(com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a aVar) {
                this.f7123a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.a(this.f7123a);
            }
        }

        /* compiled from: SecondMyPackageFragment.java */
        /* loaded from: classes2.dex */
        class b {

            /* renamed from: a, reason: collision with root package name */
            ImageView f7125a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f7126b;

            /* renamed from: c, reason: collision with root package name */
            TextView f7127c;

            /* renamed from: d, reason: collision with root package name */
            TextView f7128d;
            RelativeLayout e;

            b(g gVar) {
            }
        }

        public g(Activity activity, ArrayList<com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a> arrayList) {
            this.f7119a = arrayList;
            this.f7121c = activity;
            this.f7120b = (LayoutInflater) activity.getSystemService("layout_inflater");
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f7119a == null) {
                LogEx.d("SecondMyPackageFragment", "getCount is null!");
                return 0;
            }
            LogEx.d("SecondMyPackageFragment", "getCount=" + this.f7119a.size());
            return this.f7119a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            ArrayList<com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a> arrayList = this.f7119a;
            if (arrayList == null) {
                return null;
            }
            return arrayList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            b bVar;
            String str;
            if (view == null) {
                bVar = new b(this);
                view2 = this.f7120b.inflate(R.layout.order_videos_item, (ViewGroup) null);
                bVar.f7125a = (ImageView) view2.findViewById(R.id.poster_img);
                bVar.f7127c = (TextView) view2.findViewById(R.id.title_txt);
                bVar.f7128d = (TextView) view2.findViewById(R.id.rating_txt);
                bVar.f7126b = (ImageView) view2.findViewById(R.id.tv_icon);
                bVar.e = (RelativeLayout) view2.findViewById(R.id.img_rlayout);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.home_video_item_fl));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.img_rlayout));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.rating_rl));
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7128d);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7125a);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7127c);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7126b);
                view2.setTag(bVar);
                bVar.f7128d.setText("0.0");
            } else {
                b bVar2 = (b) view.getTag();
                bVar2.f7125a.setImageResource(R.drawable.default_poster_thumb);
                view2 = view;
                bVar = bVar2;
            }
            if (this.f7119a.get(i).b().contains("ch")) {
                if (e.this.N.size() > 0) {
                    e.this.N.clear();
                }
                bVar.f7127c.setText(this.f7119a.get(i).c());
                if (e.this.O == null) {
                    e.this.O = i.d().b();
                }
                if (e.this.O != null) {
                    for (int i2 = 0; i2 < e.this.O.size(); i2++) {
                        if (this.f7119a.get(i).b().equals(((Channel) e.this.O.get(i2)).getChannelcode()) && ((Channel) e.this.O.get(i2)).getColumncode().equals(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL))) {
                            str = ((Channel) e.this.O.get(i2)).getPosterimage();
                            bVar.f7127c.setText(((Channel) e.this.O.get(i2)).getChannelname());
                            break;
                        }
                    }
                }
                str = "";
                if (!TextUtils.isEmpty(str)) {
                    int indexOf = str.indexOf("/image", 1);
                    str = com.zte.iptvclient.android.common.f.b.i.g() + str.substring(indexOf);
                    LogEx.d("USee", "AdapterMovie image url = " + str);
                }
                Activity activity = this.f7121c;
                if (activity != null && !activity.isFinishing()) {
                    com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.a(this.f7121c).a(str);
                    a2.b(R.drawable.default_video_thumb);
                    a2.a(R.drawable.default_video_thumb);
                    a2.c(300);
                    a2.a(bVar.f7126b);
                }
                bVar.f7125a.setVisibility(8);
                bVar.f7126b.setVisibility(0);
            } else {
                com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a aVar = this.f7119a.get(i);
                if (aVar != null) {
                    String a3 = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(((com.zte.fragmentlib.b) e.this).h) ? 9 : 3, aVar.d());
                    if (!TextUtils.isEmpty(a3) && a3.contains("/image")) {
                        int indexOf2 = a3.indexOf("/image", 1);
                        a3 = com.zte.iptvclient.android.common.f.b.i.g() + a3.substring(indexOf2);
                    }
                    if (!((com.zte.fragmentlib.b) e.this).h.isFinishing()) {
                        com.bumptech.glide.d<String> a4 = com.bumptech.glide.i.a((FragmentActivity) ((com.zte.fragmentlib.b) e.this).h).a(a3);
                        a4.b(R.drawable.default_poster_thumb);
                        a4.a(R.drawable.default_poster_thumb);
                        a4.c(300);
                        a4.a(bVar.f7125a);
                    }
                    bVar.f7125a.setVisibility(0);
                    bVar.f7126b.setVisibility(8);
                    bVar.f7127c.setText(aVar.f());
                }
            }
            bVar.e.setOnClickListener(new a(this.f7119a.get(i)));
            return view2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a aVar) {
            String g = aVar.g();
            String e = aVar.e();
            String a2 = aVar.a();
            String b2 = aVar.b();
            if (TextUtils.isEmpty(g)) {
                return;
            }
            if (g.equals("1")) {
                Bundle bundle = new Bundle();
                bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, e);
                bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, a2);
                bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_RECOMMENDTYPE, "1");
                bundle.putBoolean("doAnim", false);
                Intent intent = new Intent(e.this.getActivity(), (Class<?>) HostActivity.class);
                bundle.putString("fragmenttype", "moviedetail");
                intent.putExtras(bundle);
                e.this.getActivity().startActivity(intent);
                return;
            }
            if (g.equals("2")) {
                e.this.s(b2);
                return;
            }
            if (g.equals("14")) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("programcode", e);
                bundle2.putString("columncode", a2);
                bundle2.putString("columncode", a2);
                bundle2.putString("recommendtype", "1");
                bundle2.putBoolean("doAnim", false);
                Intent intent2 = new Intent(e.this.getActivity(), (Class<?>) HostActivity.class);
                bundle2.putString("fragmenttype", "seriesdetail");
                intent2.putExtras(bundle2);
                e.this.getActivity().startActivity(intent2);
            }
        }
    }

    private void I() {
        K();
        this.p.setOnClickListener(new a());
        this.x.setOnClickListener(new b());
        this.L.setOnClickListener(new c());
    }

    private void J() {
        this.G = new ArrayList<>();
        this.N = new ArrayList<>();
        if (this.z != null) {
            this.q.setText(this.A);
            this.s.setText(this.A);
            if (!TextUtils.isEmpty(this.B) && !TextUtils.isEmpty(this.C)) {
                StringBuilder sb = new StringBuilder();
                sb.append(com.zte.iptvclient.android.common.i.a.a.a(R.string.tip_my_package_range_from));
                sb.append(" ");
                sb.append(this.B.substring(0, r5.length() - 5).replaceAll("/", "."));
                sb.append(" ");
                sb.append(com.zte.iptvclient.android.common.i.a.a.a(R.string.tip_my_package_range_to));
                sb.append(" ");
                sb.append(this.C.substring(0, r5.length() - 5).replaceAll("/", "."));
                this.t.setText(sb.toString());
            }
            String str = this.h.getString(R.string.detail_movie_price) + ":";
            if (!TextUtils.isEmpty(this.E)) {
                try {
                    str = this.h.getString(R.string.detail_movie_price) + ": " + w.b(Double.valueOf(this.E).doubleValue()) + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.money_unit_sign);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            this.u.setText(str);
            if (!"1".equals(this.D)) {
                this.L.setVisibility(4);
            }
            this.x.setVisibility(0);
            if (this.z.n().equals(DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT)) {
                this.y.setVisibility(8);
            } else {
                this.y.setVisibility(8);
            }
        }
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isShow"))) {
            this.F.setVisibility(8);
        }
    }

    private void K() {
        ArrayList<com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a> arrayList = this.G;
        if (arrayList != null) {
            arrayList.clear();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "500");
        hashMap.put("productcode", this.J);
        new SDKSubscribeMgr().getProdContentList(hashMap, new d());
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

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        I();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.z = (PackageBean) arguments.getParcelable("myDataBean");
            this.M = arguments.getInt(ParamConst.LIMIT_LIST_RSP_POSITION);
            PackageBean packageBean = this.z;
            if (packageBean != null) {
                this.A = packageBean.c();
                this.J = this.z.l();
                this.B = this.z.b();
                this.C = this.z.f();
                this.D = this.z.a();
                this.E = this.z.k();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.mypackagesecond_mobile_layout, (ViewGroup) null);
        d(inflate);
        J();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void s(String str) {
        if (!BaseApp.a(this.h)) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.c());
            if (getActivity() instanceof MainActivity) {
                F();
            } else if (getActivity() instanceof HostActivity) {
                getActivity().finish();
            }
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.e(str, ""));
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
        this.r = (RecomeGridView) view.findViewById(R.id.video_detail_mb_likes_grid);
        this.s = (TextView) view.findViewById(R.id.package_name);
        this.u = (TextView) view.findViewById(R.id.price);
        this.t = (TextView) view.findViewById(R.id.start_time);
        this.L = (TextView) view.findViewById(R.id.cancel_renewal);
        this.y = (ImageView) view.findViewById(R.id.est_icon);
        this.x = (LinearLayout) view.findViewById(R.id.detail);
        this.F = (ImageView) view.findViewById(R.id.order);
        this.v = (TextView) view.findViewById(R.id.txt_package);
        this.w = (TextView) view.findViewById(R.id.introduction_more);
        this.F.setVisibility(0);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.L);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.F);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.view));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.views));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.btn_back));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.lldetail));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.more_icon));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_package));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.llpackage_name));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_txt));
        this.L.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.cancel_autocontinue));
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.product_package));
        this.w.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_movie_detail));
        ImageView imageView = (ImageView) view.findViewById(R.id.view);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (BaseApp.a(this.h)) {
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent(this.h, (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", str);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
