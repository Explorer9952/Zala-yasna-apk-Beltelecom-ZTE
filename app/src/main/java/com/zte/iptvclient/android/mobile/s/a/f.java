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

/* compiled from: SecondPackageFragment.java */
/* loaded from: classes2.dex */
public class f extends com.zte.fragmentlib.b {
    private String A;
    private String B;
    private String C;
    private String D;
    private int E;
    private String F;
    private ArrayList<com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a> G;
    private String J;
    private h K;
    private TextView L;
    private ArrayList<Channel> N;
    private TextView O;
    private TextView P;
    private Button p;
    private TextView q;
    private RecomeGridView r;
    private TextView s;
    private TextView t;
    private ImageView u;
    private ImageView v;
    private LinearLayout w;
    private ImageView x;
    private PackageBean y;
    private String z;
    private ArrayList<Channel> M = i.d().b();
    private HandlerC0344f Q = new HandlerC0344f(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SecondPackageFragment.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SecondPackageFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("dataBean", f.this.y);
            bundle.putInt(ParamConst.LIMIT_LIST_RSP_POSITION, f.this.E);
            if (!BaseApp.a(((com.zte.fragmentlib.b) f.this).h)) {
                f.this.a("packagedetailfragment", bundle);
                return;
            }
            com.zte.iptvclient.android.mobile.s.a.c cVar = new com.zte.iptvclient.android.mobile.s.a.c();
            cVar.setArguments(bundle);
            f.this.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SecondPackageFragment.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* compiled from: SecondPackageFragment.java */
        /* loaded from: classes2.dex */
        class a implements f.c {
            a() {
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void a() {
                f fVar = f.this;
                new g("0", fVar.J, "2").start();
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void b() {
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.D.equals("0")) {
                return;
            }
            try {
                new com.zte.iptvclient.android.common.customview.a.a.e.f(((com.zte.fragmentlib.b) f.this).h, R.drawable.custom_dialog_login_img, R.string.purchase_cancel, R.drawable.custom_dialog_button_blue, R.string.common_ok, 0, R.drawable.custom_dialog_button_blue, R.string.common_cancel, 0, new a()).a();
            } catch (Exception e) {
                LogEx.e("SecondPackageFragment", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SecondPackageFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {

        /* compiled from: SecondPackageFragment.java */
        /* loaded from: classes2.dex */
        class a implements f.c {

            /* compiled from: SecondPackageFragment.java */
            /* renamed from: com.zte.iptvclient.android.mobile.s.a.f$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            class C0343a implements SDKSubscribeMgr.OnDoSubscribeReturnListener {
                C0343a() {
                }

                @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnDoSubscribeReturnListener
                public void onDoSubscribeReturn(String str, String str2, SubscribeInfo subscribeInfo) {
                    if (TextUtils.equals(str, "0")) {
                        if (f.this.C.equals("0")) {
                            if (TextUtils.equals("0", ConfigMgr.readPropertie("isShow"))) {
                                f.this.u.setVisibility(0);
                            }
                            f.this.L.setVisibility(0);
                            f.this.v.setVisibility(4);
                            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.pay_success);
                            f.this.C = "1";
                        }
                        EventBus.getDefault().post(new com.zte.iptvclient.android.mobile.s.a.a());
                        return;
                    }
                    if (TextUtils.equals(str, "70116677")) {
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.purchase_error);
                    } else {
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(str2);
                    }
                }
            }

            a() {
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void a() {
                new SDKSubscribeMgr().doSubscribe(new SubscribeReq("0", f.this.J, "1"), new C0343a());
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void b() {
            }
        }

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.D.equals("0")) {
                return;
            }
            try {
                new com.zte.iptvclient.android.common.customview.a.a.e.f(((com.zte.fragmentlib.b) f.this).h, R.drawable.custom_dialog_title_img, R.string.order_confirm_tip, R.drawable.custom_dialog_button_blue, R.string.common_ok, 0, R.drawable.custom_dialog_button_blue, R.string.common_cancel, 0, new a()).a();
            } catch (Exception e) {
                LogEx.e("SecondPackageFragment", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SecondPackageFragment.java */
    /* loaded from: classes2.dex */
    public class e implements SDKSubscribeMgr.OnProdContentListReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnProdContentListReturnListener
        public void onProdContentListReturn(String str, String str2, String str3) {
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONArray(str3);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("data");
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            f.this.G.add(com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a.a(jSONArray2.getJSONObject(i2)));
                        }
                    }
                    if (f.this.G.size() > 0) {
                        f.this.K = new h(((com.zte.fragmentlib.b) f.this).h, f.this.G);
                        f.this.r.setAdapter((ListAdapter) f.this.K);
                        f.this.K.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* compiled from: SecondPackageFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.s.a.f$f, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class HandlerC0344f extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<f> f7137a;

        public HandlerC0344f(f fVar) {
            this.f7137a = new WeakReference<>(fVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            f fVar = this.f7137a.get();
            if (fVar == null) {
                return;
            }
            switch (message.what) {
                case 999425:
                    if ("1".equals(fVar.C)) {
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.cancel_autocontinue) + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_select_setpwd));
                        fVar.L.setVisibility(8);
                        fVar.C = "0";
                    }
                    EventBus.getDefault().post(new com.zte.iptvclient.android.mobile.s.a.a());
                    return;
                case 999426:
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a((String) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: SecondPackageFragment.java */
    /* loaded from: classes2.dex */
    private class g extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private String f7138a;

        /* renamed from: b, reason: collision with root package name */
        private String f7139b;

        /* renamed from: c, reason: collision with root package name */
        private String f7140c;

        /* compiled from: SecondPackageFragment.java */
        /* loaded from: classes2.dex */
        class a implements SDKSubscribeMgr.OnDoSubscribeReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnDoSubscribeReturnListener
            public void onDoSubscribeReturn(String str, String str2, SubscribeInfo subscribeInfo) {
                if (TextUtils.equals(str, "0")) {
                    f.this.Q.sendEmptyMessage(999425);
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 999426;
                obtain.obj = str2;
                f.this.Q.sendMessage(obtain);
            }
        }

        public g(String str, String str2, String str3) {
            this.f7138a = str;
            this.f7139b = str2;
            this.f7140c = str3;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            new SDKSubscribeMgr().doSubscribe(new SubscribeReq(this.f7138a, this.f7139b, this.f7140c), new a());
        }
    }

    /* compiled from: SecondPackageFragment.java */
    /* loaded from: classes2.dex */
    class h extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a> f7143a;

        /* renamed from: b, reason: collision with root package name */
        private LayoutInflater f7144b;

        /* renamed from: c, reason: collision with root package name */
        private Activity f7145c;

        /* compiled from: SecondPackageFragment.java */
        /* loaded from: classes2.dex */
        private class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            private com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a f7147a;

            public a(com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a aVar) {
                this.f7147a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a(this.f7147a);
            }
        }

        /* compiled from: SecondPackageFragment.java */
        /* loaded from: classes2.dex */
        class b {

            /* renamed from: a, reason: collision with root package name */
            ImageView f7149a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f7150b;

            /* renamed from: c, reason: collision with root package name */
            TextView f7151c;

            /* renamed from: d, reason: collision with root package name */
            TextView f7152d;
            RelativeLayout e;

            b(h hVar) {
            }
        }

        public h(Activity activity, ArrayList<com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a> arrayList) {
            this.f7143a = arrayList;
            this.f7145c = activity;
            this.f7144b = (LayoutInflater) activity.getSystemService("layout_inflater");
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f7143a == null) {
                LogEx.d("SecondPackageFragment", "getCount is null!");
                return 0;
            }
            LogEx.d("SecondPackageFragment", "getCount=" + this.f7143a.size());
            return this.f7143a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            ArrayList<com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a> arrayList = this.f7143a;
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
                view2 = this.f7144b.inflate(R.layout.order_videos_item, (ViewGroup) null);
                bVar.f7149a = (ImageView) view2.findViewById(R.id.poster_img);
                bVar.f7151c = (TextView) view2.findViewById(R.id.title_txt);
                bVar.f7152d = (TextView) view2.findViewById(R.id.rating_txt);
                bVar.f7150b = (ImageView) view2.findViewById(R.id.tv_icon);
                bVar.e = (RelativeLayout) view2.findViewById(R.id.img_rlayout);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.home_video_item_fl));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.img_rlayout));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.rating_rl));
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7152d);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7149a);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7151c);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7150b);
                view2.setTag(bVar);
                bVar.f7152d.setText("0.0");
            } else {
                b bVar2 = (b) view.getTag();
                bVar2.f7149a.setImageResource(R.drawable.default_poster_thumb);
                view2 = view;
                bVar = bVar2;
            }
            if (this.f7143a.get(i).b().contains("ch")) {
                if (f.this.N.size() > 0) {
                    f.this.N.clear();
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= f.this.M.size()) {
                        str = "";
                        break;
                    }
                    if (this.f7143a.get(i).b().equals(((Channel) f.this.M.get(i2)).getChannelcode()) && ((Channel) f.this.M.get(i2)).getColumncode().equals(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL))) {
                        str = ((Channel) f.this.M.get(i2)).getPosterimage();
                        bVar.f7151c.setText(((Channel) f.this.M.get(i2)).getChannelname());
                        break;
                    }
                    i2++;
                }
                try {
                    if (!TextUtils.isEmpty(str)) {
                        int indexOf = str.indexOf("/image", 1);
                        str = com.zte.iptvclient.android.common.f.b.i.g() + str.substring(indexOf);
                        LogEx.d("USee", "AdapterMovie image url = " + str);
                    }
                    if (this.f7145c != null && !this.f7145c.isFinishing()) {
                        com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.a(this.f7145c).a(str);
                        a2.b(R.drawable.default_video_thumb);
                        a2.a(R.drawable.default_video_thumb);
                        a2.c(300);
                        a2.a(bVar.f7150b);
                    }
                } catch (Exception e) {
                    LogEx.d("e=", e.toString());
                }
                bVar.f7149a.setVisibility(8);
                bVar.f7150b.setVisibility(0);
            } else {
                com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a aVar = this.f7143a.get(i);
                if (aVar != null) {
                    String a3 = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(((com.zte.fragmentlib.b) f.this).h) ? 9 : 3, aVar.d());
                    if (!TextUtils.isEmpty(a3) && a3.contains("/image")) {
                        int indexOf2 = a3.indexOf("/image", 1);
                        a3 = com.zte.iptvclient.android.common.f.b.i.g() + a3.substring(indexOf2);
                    }
                    if (!((com.zte.fragmentlib.b) f.this).h.isFinishing()) {
                        com.bumptech.glide.d<String> a4 = com.bumptech.glide.i.a((FragmentActivity) ((com.zte.fragmentlib.b) f.this).h).a(a3);
                        a4.b(R.drawable.default_poster_thumb);
                        a4.a(R.drawable.default_poster_thumb);
                        a4.c(300);
                        a4.a(bVar.f7149a);
                    }
                    bVar.f7149a.setVisibility(0);
                    bVar.f7150b.setVisibility(8);
                    bVar.f7151c.setText(aVar.f());
                }
            }
            bVar.e.setOnClickListener(new a(this.f7143a.get(i)));
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
                Intent intent = new Intent(f.this.getActivity(), (Class<?>) HostActivity.class);
                bundle.putString("fragmenttype", "moviedetail");
                intent.putExtras(bundle);
                f.this.getActivity().startActivity(intent);
                return;
            }
            if (g.equals("2")) {
                f.this.s(b2);
                return;
            }
            if (g.equals("14")) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, e);
                bundle2.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, a2);
                Intent intent2 = new Intent(f.this.getActivity(), (Class<?>) HostActivity.class);
                bundle2.putString("fragmenttype", "seriesdetail");
                intent2.putExtras(bundle2);
                f.this.getActivity().startActivity(intent2);
            }
        }
    }

    private void I() {
        K();
        this.p.setOnClickListener(new a());
        this.w.setOnClickListener(new b());
        this.L.setOnClickListener(new c());
    }

    private void J() {
        this.G = new ArrayList<>();
        String str = this.B;
        if (str != null) {
            if (str.equals("0")) {
                this.B = "";
            }
            if (this.B.equals("1")) {
                this.B = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_day);
            } else if (this.B.equals("2")) {
                this.B = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_week);
            } else if (this.B.equals("3")) {
                this.B = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_month);
            } else if (this.B.equals("4")) {
                this.B = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_half_year);
            } else if (this.B.equals(DownloadConstant.REPORT_MSGTYPE_ADD)) {
                this.B = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_year);
            } else if (this.B.equals(DownloadConstant.REPORT_MSGTYPE_URL_NULL)) {
                this.B = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_hour);
            } else if (this.B.equals(DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT)) {
                this.B = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_min);
            } else if (this.B.equals("8")) {
                this.B = com.zte.iptvclient.android.common.i.a.a.a(R.string.time_season);
            }
        }
        if (this.y != null) {
            this.q.setText(this.z);
            this.s.setText(this.z);
            Double valueOf = Double.valueOf(com.zte.iptvclient.android.mobile.s.a.g.a.a(Integer.valueOf(this.A)));
            if (!TextUtils.isEmpty(this.B) && !"0".equals(this.A)) {
                this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_movie_price) + ":" + (valueOf.doubleValue() / 100.0d) + "0/" + this.B);
            } else {
                this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_movie_price) + ":" + (valueOf.doubleValue() / 100.0d) + "0");
            }
            if (this.C.equals("1")) {
                if (TextUtils.equals("1", ConfigMgr.readPropertie("isShow"))) {
                    this.u.setVisibility(8);
                }
                this.v.setVisibility(4);
                this.L.setVisibility(0);
            }
            if (this.F.equals("0")) {
                this.L.setVisibility(8);
            }
            if (this.y.n().equals(DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT)) {
                this.x.setVisibility(0);
            } else {
                this.x.setVisibility(8);
            }
        }
        this.v.setOnClickListener(new d());
    }

    private void K() {
        this.N = new ArrayList<>();
        ArrayList<com.zte.iptvclient.android.mobile.productpackage.fragment.bean.a> arrayList = this.G;
        if (arrayList != null) {
            arrayList.clear();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "500");
        hashMap.put("productcode", this.J);
        new SDKSubscribeMgr().getProdContentList(hashMap, new e());
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
            this.y = (PackageBean) arguments.getParcelable("dataBean");
            this.E = arguments.getInt(ParamConst.LIMIT_LIST_RSP_POSITION);
            PackageBean packageBean = this.y;
            if (packageBean != null) {
                this.z = packageBean.m();
                this.A = this.y.k();
                this.B = this.y.d();
                this.C = this.y.i();
                this.J = this.y.l();
                this.D = this.y.g();
                this.F = this.y.h();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.packagesecond_mobile_layout, (ViewGroup) null);
        d(inflate);
        J();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
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
        this.t = (TextView) view.findViewById(R.id.order_price);
        this.u = (ImageView) view.findViewById(R.id.order);
        this.v = (ImageView) view.findViewById(R.id.unorder);
        this.w = (LinearLayout) view.findViewById(R.id.detail);
        this.L = (TextView) view.findViewById(R.id.cancel_renewal);
        this.x = (ImageView) view.findViewById(R.id.est_icon);
        this.O = (TextView) view.findViewById(R.id.txt_package);
        this.P = (TextView) view.findViewById(R.id.introduction_more);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.L);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.view));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.views));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.btn_back));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.lldetail));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.more_icon));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_package));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.llpackage_name));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_txt));
        com.zte.iptvclient.common.uiframe.f.a(this.O);
        this.L.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.cancel_autocontinue));
        this.O.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.termial_binding_package));
        this.P.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_movie_detail));
        ImageView imageView = (ImageView) view.findViewById(R.id.view);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (BaseApp.a(this.h)) {
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
        }
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
