package com.zte.iptvclient.android.mobile.e0.e;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.player.common.CommonFunc;
import com.video.androidsdk.service.cache.SDKCacheMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.favorite.SDKFavoriteMgr;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.gridview.RecomeGridView;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.javabean.models.SeriesEpisodeBean;
import com.zte.iptvclient.android.common.javabean.models.SeriesHeadBean;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.javabean.models.VoDBean;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.e0.b;
import com.zte.iptvclient.android.mobile.i.b.h;
import com.zte.iptvclient.android.mobile.vod.entity.GetUserStarRatingEntity;
import com.zte.iptvclient.android.mobile.vod.event.SeriesSeasonItemPreventFastDoubleClickPhone;
import com.zte.iptvclient.android.mobile.vod.ui.columnview.SeriesEposideExpandView;
import com.zte.iptvclient.android.mobile.x.b.c.b;
import com.zte.iptvclient.android.zala.R;
import it.sephiroth.android.library.widget.AbsHListView;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DetailSeriesInfoFragment.java */
/* loaded from: classes.dex */
public class k extends com.zte.fragmentlib.b {
    private ArrayList<String> A;
    private ImageView A0;
    private ArrayList<String> B;
    private ImageView B0;
    private ArrayList<String> C;
    private ImageView C0;
    private RelativeLayout D;
    private TextView D0;
    private TextView E;
    private TextView E0;
    private TextView F;
    private TextView F0;
    private TextView G0;
    private TextView H0;
    private TextView I0;
    private Button J;
    private TextView J0;
    private LinearLayout K;
    private e0 K0;
    private LinearLayout L;
    private RelativeLayout L0;
    private LinearLayout M;
    private ImageView M0;
    private RelativeLayout N;
    private FrameLayout N0;
    private RelativeLayout O;
    private LinearLayout O0;
    private RelativeLayout P;
    private LinearLayout P0;
    private RecomeGridView Q;
    private View Q0;
    private RecomeGridView R;
    private TextView R0;
    private RecomeGridView S;
    private TextView S0;
    private int T;
    private String T0;
    private String U0;
    private SeriesHeadBean V;
    private TextView V0;
    private ImageView W0;
    private SeriesEpisodeBean X;
    private RelativeLayout X0;
    private com.zte.iptvclient.android.common.j.h Y;
    private TextView Y0;
    private TextView Z0;
    private RelativeLayout a1;
    private com.zte.iptvclient.android.mobile.i.b.h b0;
    private TextView b1;
    private com.zte.iptvclient.android.mobile.e0.e.i c0;
    private com.zte.iptvclient.android.mobile.e0.e.g c1;
    private RelativeLayout d1;
    private HListView e1;
    private View f0;
    private View f1;
    private com.zte.iptvclient.android.mobile.e0.d.f g1;
    private LinearLayout i0;
    private View j0;
    private boolean j1;
    private FrameLayout k0;
    private LinearLayout l0;
    private View m0;
    private RelativeLayout n0;
    private ImageView o0;
    private TextView p0;
    private RelativeLayout q;
    private FrameLayout q0;
    private LinearLayout r;
    private LinearLayout r0;
    private TextView s;
    private RelativeLayout s0;
    private TextView t;
    private ImageView t0;
    private ImageView u;
    private TextView u0;
    private HListView v;
    private LinearLayout v0;
    private c0 w;
    private ImageView w0;
    private d0 x;
    private ImageView x0;
    private ImageView y0;
    private ImageView z0;
    private ArrayList<String> p = new ArrayList<>();
    private int y = 0;
    private int z = 0;
    private float G = 0.0f;
    private long U = 0;
    private HashMap<String, String> W = new HashMap<>();
    public Bitmap Z = null;
    private int a0 = 30;
    private boolean d0 = false;
    private String e0 = "";
    private int g0 = 0;
    private int h0 = 0;
    private ArrayList<com.zte.iptvclient.android.mobile.vod.entity.a> h1 = new ArrayList<>();
    private String i1 = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* compiled from: DetailSeriesInfoFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.e0.e.k$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class ViewOnClickListenerC0239a implements View.OnClickListener {
            ViewOnClickListenerC0239a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.I();
            }
        }

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.U() || k.this.V == null) {
                return;
            }
            com.zte.iptvclient.android.mobile.e0.e.g gVar = new com.zte.iptvclient.android.mobile.e0.e.g();
            Bundle bundle = new Bundle();
            k kVar = k.this;
            bundle.putSerializable("VideoDetailBean", kVar.d(kVar.V));
            gVar.setArguments(bundle);
            k.this.N0.setVisibility(0);
            k.this.O0.setVisibility(8);
            k.this.a(R.id.fl_series_info_container, gVar);
            gVar.e(k.this.T0, k.this.U0);
            if (((com.zte.fragmentlib.b) k.this).h != null) {
                if (k.this.m0 != null) {
                    k.this.q0.removeView(k.this.m0);
                } else {
                    k kVar2 = k.this;
                    kVar2.m0 = LayoutInflater.from(((com.zte.fragmentlib.b) kVar2).h).inflate(R.layout.detail_middle_video_title_for_phone, (ViewGroup) null);
                    k kVar3 = k.this;
                    kVar3.n0 = (RelativeLayout) kVar3.m0.findViewById(R.id.rl_close_img_for_phone);
                    k.this.n0.setOnClickListener(new ViewOnClickListenerC0239a());
                    k kVar4 = k.this;
                    kVar4.o0 = (ImageView) kVar4.m0.findViewById(R.id.img_close);
                    k kVar5 = k.this;
                    kVar5.p0 = (TextView) kVar5.m0.findViewById(R.id.tv_video_title_name);
                    com.zte.iptvclient.common.uiframe.f.a(k.this.m0);
                    com.zte.iptvclient.common.uiframe.f.a(k.this.n0);
                    com.zte.iptvclient.common.uiframe.f.a(k.this.o0);
                    com.zte.iptvclient.common.uiframe.f.a(k.this.p0);
                }
                k.this.p0.setText(k.this.V.getProgramname());
                k.this.q0.addView(k.this.m0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class a0 implements View.OnClickListener {

        /* compiled from: DetailSeriesInfoFragment.java */
        /* loaded from: classes2.dex */
        class a implements t.d {
            a(a0 a0Var) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        /* compiled from: DetailSeriesInfoFragment.java */
        /* loaded from: classes2.dex */
        class b implements t.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ NetworkInfo f6017a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f6018b;

            b(NetworkInfo networkInfo, View view) {
                this.f6017a = networkInfo;
                this.f6018b = view;
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void b() {
                k.this.a(this.f6017a, this.f6018b);
            }
        }

        a0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ("1".equals(ConfigMgr.readPropertie("isShowInConstructionTip"))) {
                com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) k.this).h);
                return;
            }
            if (k.this.V == null) {
                return;
            }
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (!k.this.d0) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.lownlaod_enable_tip));
                    return;
                }
                if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 3) {
                    if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                        k.this.V();
                        return;
                    } else {
                        if (com.zte.iptvclient.android.mobile.download.helper.c.c.b()) {
                            return;
                        }
                        k.this.f0();
                        return;
                    }
                }
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) ((com.zte.fragmentlib.b) k.this).h.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    String typeName = activeNetworkInfo.getTypeName();
                    if (typeName.equalsIgnoreCase("mobile")) {
                        com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) k.this).h, com.zte.iptvclient.android.common.i.a.a.a(R.string.permit_2G_3G_network_download_confirm), new b(activeNetworkInfo, view));
                        return;
                    } else {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            k.this.a(activeNetworkInfo, view);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) k.this).h, new a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // it.sephiroth.android.library.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = i + 1;
            int indexOf = k.this.A.contains(String.valueOf(i2)) ? k.this.A.indexOf(String.valueOf(String.valueOf(i2))) : -1;
            if (k.this.U() || k.this.V == null || indexOf < 0) {
                return;
            }
            k.this.y = i;
            k kVar = k.this;
            kVar.z = kVar.i(kVar.y + 1);
            LogEx.d("DetailSeriesInfoFragment", "mCurHLVewPosition=" + k.this.y + ";mCurNavPosition=" + k.this.z + ";index" + indexOf);
            if (k.this.w != null) {
                LogEx.d("DetailSeriesInfoFragment", "mHListViewShowAdapter.notifyDataSetChanged();");
                k.this.w.a();
            }
            if (k.this.x != null) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.i());
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.j());
                k.this.x.a(k.this.z, k.this.y);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class b0 implements View.OnClickListener {

        /* compiled from: DetailSeriesInfoFragment.java */
        /* loaded from: classes2.dex */
        class a implements b.d {
            a() {
            }

            @Override // com.zte.iptvclient.android.mobile.x.b.c.b.d
            public void a(int i) {
                String format;
                String str;
                k kVar = k.this;
                Bitmap bitmap = kVar.Z;
                if (bitmap == null) {
                    bitmap = BitmapFactory.decodeResource(((com.zte.fragmentlib.b) kVar).h.getResources(), R.drawable.share_img);
                }
                Bitmap bitmap2 = bitmap;
                String c2 = com.zte.iptvclient.common.uiframe.a.c("Share_Video_Title");
                if (!TextUtils.isEmpty(k.this.V.getProgramname()) && !TextUtils.isEmpty(c2) && c2.contains("$CONTENTNAME$")) {
                    format = String.format(c2.replace("$CONTENTNAME$", "%1$s"), k.this.V.getProgramname());
                } else {
                    format = String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.share_message), k.this.E.getText().toString());
                }
                String str2 = format;
                long currentPosition = (CommonFunc.getPlayer() != null ? CommonFunc.getPlayer().getCurrentPosition() : 0L) / 1000;
                long j = i;
                int i2 = currentPosition < j ? 0 : (int) (currentPosition - j);
                String c3 = com.zte.iptvclient.common.uiframe.a.c("APP_Share_URL");
                if (TextUtils.isEmpty(c3)) {
                    str = null;
                } else {
                    str = c3 + String.format("?pcode=%1$s,%2$s,%3$d,%4$d,%5$s&ptype=0", k.this.V.getProgramcode(), "14", Integer.valueOf(i2), Integer.valueOf(i), k.this.e0);
                }
                String str3 = str;
                String str4 = com.zte.iptvclient.android.common.i.a.a.a(R.string.share_content_title) + com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name);
                LogEx.d("DetailSeriesInfoFragment", "shareURL=" + str3);
                new com.zte.iptvclient.android.mobile.x.b.c.c(((com.zte.fragmentlib.b) k.this).h, str2, str3, null, str4, bitmap2, null, k.this.V.getProgramcode()).a(k.this.f0);
            }
        }

        b0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap bitmap;
            if (k.this.V == null || com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            if (!"1".equals(ConfigMgr.readPropertie("SupportFaceBook"))) {
                new com.zte.iptvclient.android.mobile.x.b.c.b(((com.zte.fragmentlib.b) k.this).h, new a()).a(k.this.f0);
                return;
            }
            LogEx.d("DetailSeriesInfoFragment", "eas_dns=" + com.zte.iptvclient.common.uiframe.a.c("EAS_Domain"));
            String str = com.zte.iptvclient.common.uiframe.a.c("Share_Link_Address") + "?vt=14&vc=" + k.this.V.getProgramcode();
            String charSequence = k.this.E.getText().toString();
            if (!TextUtils.isEmpty(k.this.V.getProgramname())) {
                charSequence = k.this.V.getProgramname();
            }
            String str2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.let_us_watch) + " " + charSequence + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.on_app_click_link_below);
            int i = k.this.j1 ? 9 : 3;
            String description = k.this.V.getDescription();
            String c2 = com.zte.iptvclient.android.common.k.g.c(i, k.this.V.getPosterfilelist());
            LogEx.d("DetailSeriesInfoFragment", "strImgUrl = " + c2);
            k kVar = k.this;
            Bitmap bitmap2 = kVar.Z;
            if (bitmap2 == null) {
                bitmap = ((com.zte.fragmentlib.b) kVar).h != null ? BitmapFactory.decodeResource(((com.zte.fragmentlib.b) k.this).h.getResources(), R.drawable.share_img) : null;
            } else {
                bitmap = bitmap2;
            }
            if (((com.zte.fragmentlib.b) k.this).h != null) {
                new com.zte.iptvclient.android.mobile.x.b.c.c(((com.zte.fragmentlib.b) k.this).h, description, str, c2, str2, bitmap, null, k.this.V.getProgramcode()).a(k.this.f0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class c implements AbsHListView.OnScrollListener {
        c() {
        }

        @Override // it.sephiroth.android.library.widget.AbsHListView.OnScrollListener
        public void onScroll(AbsHListView absHListView, int i, int i2, int i3) {
            k.this.g0 = i;
            k.this.h0 = i2;
        }

        @Override // it.sephiroth.android.library.widget.AbsHListView.OnScrollListener
        public void onScrollStateChanged(AbsHListView absHListView, int i) {
            if (i != 0) {
                return;
            }
            int i2 = k.this.g0 + 1;
            int i3 = k.this.g0 + k.this.h0;
            if (i2 >= k.this.a0 || i3 >= k.this.a0) {
                if (i3 <= k.this.a0 || i2 >= k.this.a0) {
                    int i4 = i2 / k.this.a0;
                    int i5 = i3 / k.this.a0;
                    if (i4 == i5) {
                        if (i2 % k.this.a0 > 0) {
                            int i6 = i4 + 1;
                            if (k.this.g(i3).booleanValue()) {
                                k.this.j(i6);
                                return;
                            }
                            return;
                        }
                        if (k.this.g(i2).booleanValue()) {
                            k.this.j(i4);
                            return;
                        }
                        return;
                    }
                    if (k.this.g(i2).booleanValue()) {
                        k.this.j(i4);
                    }
                    if (k.this.g(i3).booleanValue()) {
                        k.this.j(i5);
                        return;
                    }
                    return;
                }
                if (k.this.g(i3).booleanValue()) {
                    k.this.j(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class c0 extends com.zte.iptvclient.common.uiframe.c {

        /* renamed from: d, reason: collision with root package name */
        ArrayList<String> f6024d;

        /* synthetic */ c0(k kVar, Context context, ArrayList arrayList, C0240k c0240k) {
            this(context, arrayList);
        }

        private void b(h0 h0Var) {
            if (((com.zte.fragmentlib.b) k.this).h != null) {
                h0Var.f6049a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numselect_textcolor));
                ((com.zte.fragmentlib.b) k.this).h.a(h0Var.f6049a, "textColor", R.color.eposideitem_numselect_textcolor);
                h0Var.f6050b.setBackground(c.a.a.a.d.b.d().d(R.drawable.episode_item_foucs_bg));
                ((com.zte.fragmentlib.b) k.this).h.a(h0Var.f6050b, "background", R.drawable.episode_item_foucs_bg);
            }
        }

        private void c(h0 h0Var) {
            if (((com.zte.fragmentlib.b) k.this).h != null) {
                h0Var.f6049a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numunselect_textcolor));
                ((com.zte.fragmentlib.b) k.this).h.a(h0Var.f6049a, "textColor", R.color.eposideitem_numunselect_textcolor);
                h0Var.f6050b.setBackground(c.a.a.a.d.b.d().d(R.drawable.episode_item_bg));
                ((com.zte.fragmentlib.b) k.this).h.a(h0Var.f6050b, "background", R.drawable.episode_item_bg);
            }
        }

        public void a(ArrayList<String> arrayList) {
            ArrayList<String> arrayList2 = this.f6024d;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            this.f6024d = arrayList;
            a();
        }

        @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
        public int getCount() {
            ArrayList<String> arrayList = this.f6024d;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            h0 h0Var;
            if (view == null) {
                view = LayoutInflater.from(((com.zte.fragmentlib.b) k.this).h).inflate(R.layout.detail_series_episode_hlvew_layout, (ViewGroup) null);
                h0Var = new h0(null);
                h0Var.f6049a = (TextView) view.findViewById(R.id.detail_series_episode_hlvew_txtvew);
                h0Var.f6050b = (RelativeLayout) view.findViewById(R.id.rl_series_episode_hlvew_txtvew_item);
                com.zte.iptvclient.common.uiframe.f.a(h0Var.f6049a);
                com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_series_episode_hlvew_txtvew_item));
                view.setTag(h0Var);
            } else {
                h0Var = (h0) view.getTag();
            }
            h0Var.f6049a.setText(this.f6024d.get(i));
            if (k.this.y == i) {
                if (k.this.y < this.f6024d.size()) {
                    if (k.this.A.contains(this.f6024d.get(k.this.y))) {
                        b(h0Var);
                    } else {
                        a(h0Var);
                    }
                }
            } else if (k.this.A.contains(this.f6024d.get(i))) {
                c(h0Var);
            } else {
                a(h0Var);
            }
            return view;
        }

        private c0(Context context, ArrayList<String> arrayList) {
            super(context, arrayList);
            this.f6024d = arrayList;
        }

        private void a(h0 h0Var) {
            if (((com.zte.fragmentlib.b) k.this).h != null) {
                h0Var.f6049a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numunpublish_textcolor));
                ((com.zte.fragmentlib.b) k.this).h.a(h0Var.f6049a, "textColor", R.color.eposideitem_numunpublish_textcolor);
                h0Var.f6050b.setBackground(c.a.a.a.d.b.d().d(R.drawable.episode_item_disable_bg));
                ((com.zte.fragmentlib.b) k.this).h.a(h0Var.f6050b, "background", R.drawable.episode_item_disable_bg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.V == null || k.this.U()) {
                return;
            }
            SeriesEposideExpandView seriesEposideExpandView = new SeriesEposideExpandView(k.this.getContext());
            seriesEposideExpandView.c(Integer.valueOf(k.this.V.getSeriesnum()).intValue());
            seriesEposideExpandView.c(k.this.C);
            seriesEposideExpandView.d(k.this.A);
            k kVar = k.this;
            kVar.z = kVar.i(kVar.y + 1);
            seriesEposideExpandView.b(k.this.z);
            k kVar2 = k.this;
            seriesEposideExpandView.a(kVar2.h(kVar2.y));
            if (k.this.c0 != null) {
                seriesEposideExpandView.a(new a());
                k.this.c0.d(seriesEposideExpandView);
                seriesEposideExpandView.a();
            }
        }

        /* compiled from: DetailSeriesInfoFragment.java */
        /* loaded from: classes2.dex */
        class a implements SeriesEposideExpandView.f {
            a() {
            }

            @Override // com.zte.iptvclient.android.mobile.vod.ui.columnview.SeriesEposideExpandView.f
            public void a(int i) {
                if (k.this.c0 != null) {
                    k.this.c0.d(i);
                }
            }

            @Override // com.zte.iptvclient.android.mobile.vod.ui.columnview.SeriesEposideExpandView.f
            public void a(int i, int i2) {
                if (k.this.c0 != null) {
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.i());
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.j());
                    k.this.c0.b(i, i2);
                }
            }

            @Override // com.zte.iptvclient.android.mobile.vod.ui.columnview.SeriesEposideExpandView.f
            public void a() {
                if (k.this.c0 != null) {
                    k.this.c0.N();
                }
            }
        }
    }

    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes.dex */
    public interface d0 {
        void a(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((com.zte.iptvclient.android.mobile.e0.e.i) k.this.getParentFragment()).J0) {
                k.this.u("0");
            } else {
                k.this.u("1");
            }
        }
    }

    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes.dex */
    public interface e0 {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a() || k.this.c0 == null) {
                return;
            }
            k.this.c0.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class f0 extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<CommonVideoBean> f6029a;

        /* renamed from: b, reason: collision with root package name */
        private LayoutInflater f6030b;

        /* compiled from: DetailSeriesInfoFragment.java */
        /* loaded from: classes2.dex */
        private class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            private CommonVideoBean f6032a;

            public a(CommonVideoBean commonVideoBean, com.zte.iptvclient.common.video.a aVar) {
                this.f6032a = commonVideoBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((((com.zte.fragmentlib.b) k.this).h instanceof MainActivity) && ((MainActivity) ((com.zte.fragmentlib.b) k.this).h).s()) {
                    return;
                }
                com.zte.iptvclient.android.common.player.k.c cVar = (com.zte.iptvclient.android.common.player.k.c) k.this.getChildFragmentManager().c("PlayerFragment");
                if (cVar != null) {
                    cVar.v2();
                }
                if (k.this.U()) {
                    return;
                }
                if (TextUtils.equals(this.f6032a.f(), "1")) {
                    k.this.a(this.f6032a);
                } else if (TextUtils.equals(this.f6032a.f(), "14")) {
                    k.this.b(this.f6032a);
                }
            }
        }

        /* compiled from: DetailSeriesInfoFragment.java */
        /* loaded from: classes2.dex */
        class b {

            /* renamed from: a, reason: collision with root package name */
            ImageView f6034a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f6035b;

            /* renamed from: c, reason: collision with root package name */
            TextView f6036c;

            /* renamed from: d, reason: collision with root package name */
            TextView f6037d;

            b(f0 f0Var) {
            }
        }

        /* synthetic */ f0(k kVar, Context context, ArrayList arrayList, C0240k c0240k) {
            this(context, arrayList);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<CommonVideoBean> arrayList = this.f6029a;
            if (arrayList == null) {
                LogEx.d("DetailSeriesInfoFragment", "getCount =0");
                return 0;
            }
            if (arrayList.size() > 6) {
                return 6;
            }
            return this.f6029a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            ArrayList<CommonVideoBean> arrayList = this.f6029a;
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
                view2 = this.f6030b.inflate(R.layout.home_video_item, (ViewGroup) null);
                bVar.f6034a = (ImageView) view2.findViewById(R.id.poster_img);
                bVar.f6035b = (ImageView) view2.findViewById(R.id.ivi_logo_top);
                bVar.f6036c = (TextView) view2.findViewById(R.id.title_txt);
                bVar.f6037d = (TextView) view2.findViewById(R.id.rating_txt);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.home_video_item_fl));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.img_rlayout));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.rating_rl));
                com.zte.iptvclient.common.uiframe.f.a(bVar.f6037d);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f6034a);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f6035b);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f6036c);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            CommonVideoBean commonVideoBean = (CommonVideoBean) getItem(i);
            if (commonVideoBean != null) {
                if (commonVideoBean.b().equals("ivi")) {
                    bVar.f6035b.setVisibility(0);
                    bVar.f6035b.setImageDrawable(((com.zte.fragmentlib.b) k.this).h.getResources().getDrawable(R.drawable.ivi_logo));
                } else if (commonVideoBean.b().equals("Megogo")) {
                    bVar.f6035b.setVisibility(0);
                    bVar.f6035b.setImageDrawable(((com.zte.fragmentlib.b) k.this).h.getResources().getDrawable(R.drawable.megogo_logo));
                } else {
                    bVar.f6035b.setVisibility(8);
                }
                String splitedString = StringUtil.getSplitedString(commonVideoBean.c(), ";", 3);
                LogEx.i("DetailSeriesInfoFragment", "posterfilelist=" + splitedString);
                if (TextUtils.isEmpty(splitedString)) {
                    str = "";
                } else {
                    str = "../images/poster/" + splitedString;
                    if (!StringUtil.isEmptyString(str) && str.contains("/image")) {
                        int indexOf = str.indexOf("/image", 1);
                        str = com.zte.iptvclient.android.common.f.b.i.g() + str.substring(indexOf);
                    }
                }
                com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.a((FragmentActivity) ((com.zte.fragmentlib.b) k.this).h).a(str);
                a2.b(R.drawable.default_poster_thumb);
                a2.a(R.drawable.default_poster_thumb);
                a2.c(300);
                a2.a(bVar.f6034a);
                bVar.f6036c.setText(commonVideoBean.e());
                bVar.f6034a.setOnClickListener(new a(commonVideoBean, null));
            }
            return view2;
        }

        private f0(Context context, ArrayList<CommonVideoBean> arrayList) {
            this.f6029a = arrayList;
            this.f6030b = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zte.iptvclient.android.common.player.multiplay.a.c().a().clear();
            com.zte.iptvclient.android.common.javabean.f Q = k.this.Q();
            if (Q != null && !com.zte.iptvclient.android.common.player.multiplay.a.c().a(Q)) {
                com.zte.iptvclient.android.common.player.multiplay.a.c().a().add(0, Q);
            }
            if (com.zte.iptvclient.android.common.player.multiplay.a.c().a().size() > 4) {
                com.zte.iptvclient.android.common.player.multiplay.a.c().a().remove(4);
            }
            com.zte.iptvclient.android.mobile.a0.b.b bVar = new com.zte.iptvclient.android.mobile.a0.b.b();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isMultiScreenMode", true);
            bundle.putBoolean("doAnim", true);
            bVar.setArguments(bundle);
            k.this.a(bVar);
            if (k.this.K0 != null) {
                k.this.K0.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class g0 extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<CommonVideoBean> f6039a;

        /* renamed from: b, reason: collision with root package name */
        private LayoutInflater f6040b;

        /* compiled from: DetailSeriesInfoFragment.java */
        /* loaded from: classes2.dex */
        private class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            private CommonVideoBean f6042a;

            public a(CommonVideoBean commonVideoBean) {
                this.f6042a = commonVideoBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((((com.zte.fragmentlib.b) k.this).h instanceof MainActivity) && ((MainActivity) ((com.zte.fragmentlib.b) k.this).h).s()) {
                    return;
                }
                com.zte.iptvclient.android.common.player.k.c cVar = (com.zte.iptvclient.android.common.player.k.c) k.this.getChildFragmentManager().c("PlayerFragment");
                if (cVar != null) {
                    cVar.v2();
                }
                if (k.this.U()) {
                    return;
                }
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.i());
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.j());
                if (TextUtils.equals(this.f6042a.f(), "14")) {
                    k.this.b(this.f6042a);
                } else if (TextUtils.equals(this.f6042a.f(), "1")) {
                    k.this.a(this.f6042a);
                }
            }
        }

        /* compiled from: DetailSeriesInfoFragment.java */
        /* loaded from: classes2.dex */
        class b {

            /* renamed from: a, reason: collision with root package name */
            ImageView f6044a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f6045b;

            /* renamed from: c, reason: collision with root package name */
            TextView f6046c;

            /* renamed from: d, reason: collision with root package name */
            TextView f6047d;

            b(g0 g0Var) {
            }
        }

        /* synthetic */ g0(k kVar, Context context, ArrayList arrayList, C0240k c0240k) {
            this(context, arrayList);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<CommonVideoBean> arrayList = this.f6039a;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            ArrayList<CommonVideoBean> arrayList = this.f6039a;
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
            if (view == null) {
                bVar = new b(this);
                view2 = this.f6040b.inflate(R.layout.home_video_item, (ViewGroup) null);
                bVar.f6044a = (ImageView) view2.findViewById(R.id.poster_img);
                bVar.f6045b = (ImageView) view2.findViewById(R.id.ivi_logo_top);
                bVar.f6046c = (TextView) view2.findViewById(R.id.title_txt);
                bVar.f6047d = (TextView) view2.findViewById(R.id.rating_txt);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.home_video_item_fl));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.img_rlayout));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.rating_rl));
                com.zte.iptvclient.common.uiframe.f.a(bVar.f6047d);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f6044a);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f6045b);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f6046c);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            CommonVideoBean commonVideoBean = this.f6039a.get(i);
            if (commonVideoBean != null) {
                if (commonVideoBean.b().equals("ivi")) {
                    bVar.f6045b.setVisibility(0);
                    bVar.f6045b.setImageDrawable(((com.zte.fragmentlib.b) k.this).h.getResources().getDrawable(R.drawable.ivi_logo));
                } else if (commonVideoBean.b().equals("Megogo")) {
                    bVar.f6045b.setVisibility(0);
                    bVar.f6045b.setImageDrawable(((com.zte.fragmentlib.b) k.this).h.getResources().getDrawable(R.drawable.megogo_logo));
                } else {
                    bVar.f6045b.setVisibility(8);
                }
                String a2 = com.zte.iptvclient.android.common.k.g.a(k.this.j1 ? 9 : 3, commonVideoBean.c());
                if (!TextUtils.isEmpty(a2) && a2.contains("/image")) {
                    int indexOf = a2.indexOf("/image", 1);
                    a2 = com.zte.iptvclient.android.common.f.b.i.g() + a2.substring(indexOf);
                }
                LogEx.d("DetailSeriesInfoFragment", "postimg url = " + a2);
                if (((com.zte.fragmentlib.b) k.this).h != null && !((com.zte.fragmentlib.b) k.this).h.isFinishing()) {
                    com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.a((FragmentActivity) ((com.zte.fragmentlib.b) k.this).h).a(a2);
                    a3.b(R.drawable.default_poster_thumb);
                    a3.a(R.drawable.default_poster_thumb);
                    a3.c(300);
                    a3.a(bVar.f6044a);
                }
                bVar.f6046c.setText(commonVideoBean.e());
                bVar.f6047d.setVisibility(8);
                bVar.f6044a.setOnClickListener(new a(commonVideoBean));
            }
            return view2;
        }

        private g0(Context context, ArrayList<CommonVideoBean> arrayList) {
            this.f6039a = arrayList;
            this.f6040b = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k.this.d(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public static class h0 extends com.zte.iptvclient.common.uiframe.d {

        /* renamed from: a, reason: collision with root package name */
        TextView f6049a;

        /* renamed from: b, reason: collision with root package name */
        RelativeLayout f6050b;

        private h0() {
        }

        /* synthetic */ h0(C0240k c0240k) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class i implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        i() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("DetailSeriesInfoFragment", "sdkDoStarRating onDataReturn,s= " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!"0".equals(jSONObject.getString("returncode"))) {
                    k.this.d0();
                } else {
                    k.this.a(GetUserStarRatingEntity.a(jSONObject));
                    k.this.e0();
                }
            } catch (JSONException unused) {
                k.this.d0();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            k.this.d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class j implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6052a;

        j(String str) {
            this.f6052a = str;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("DetailSeriesInfoFragment", "onDataReturn s = " + str);
            try {
                if ("0".equals(new JSONObject(str).optString("returncode"))) {
                    if ("0".equals(this.f6052a)) {
                        LogEx.d("DetailSeriesInfoFragment", "mDelete success");
                        k.this.c0.b(false);
                    } else {
                        LogEx.d("DetailSeriesInfoFragment", "add success");
                        k.this.c0.b(true);
                    }
                    k.this.N();
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.q.a());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("DetailSeriesInfoFragment", "onFailReturn i = " + i + "  s = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.e0.e.k$k, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0240k implements AdapterView.OnItemClickListener {
        C0240k() {
        }

        @Override // it.sephiroth.android.library.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            LogEx.d("DetailSeriesInfoFragment", "--onItemClick--position : " + i);
            Object adapter = adapterView.getAdapter();
            if (adapter instanceof com.zte.iptvclient.android.mobile.e0.d.f) {
                com.zte.iptvclient.android.mobile.e0.d.f fVar = (com.zte.iptvclient.android.mobile.e0.d.f) adapter;
                com.zte.iptvclient.android.mobile.vod.entity.a item = fVar.getItem(i);
                if (item.f()) {
                    return;
                }
                Fragment parentFragment = k.this.getParentFragment();
                if (parentFragment instanceof com.zte.iptvclient.android.mobile.e0.e.i) {
                    ((com.zte.iptvclient.android.mobile.e0.e.i) parentFragment).u(item.c());
                }
                fVar.a(i);
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.i());
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.j());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class l implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private float f6055a;

        /* renamed from: b, reason: collision with root package name */
        private BigDecimal f6056b;

        /* compiled from: DetailSeriesInfoFragment.java */
        /* loaded from: classes2.dex */
        class a implements t.d {
            a(l lVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (k.this.V == null) {
                    return;
                }
                com.zte.iptvclient.android.mobile.e0.e.a aVar = new com.zte.iptvclient.android.mobile.e0.e.a();
                Bundle bundle = new Bundle();
                String ePGHome = SDKLoginMgr.getInstance().getEPGHome();
                String c2 = com.zte.iptvclient.common.uiframe.a.c("Frame_resource");
                String ratingsum = k.this.V.getRatingsum();
                String ratingnum = k.this.V.getRatingnum();
                float parseFloat = Float.parseFloat(ratingsum);
                float parseFloat2 = Float.parseFloat(ratingnum);
                if (parseFloat2 <= 0.0f) {
                    this.f6055a = 0.0f;
                } else {
                    this.f6055a = parseFloat / parseFloat2;
                }
                try {
                    this.f6056b = new BigDecimal(this.f6055a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String str = ePGHome + c2 + "/vod_commend.jsp?contentcode=" + k.this.V.getContentcode() + "&contenttype=" + k.this.V.getProgramtype() + "&starrating=" + this.f6056b.setScale(1, 4).doubleValue() + "&isPhone=1";
                bundle.putString("weburl", str);
                bundle.putString("contentCode", k.this.V.getContentcode());
                aVar.setArguments(bundle);
                Intent intent = new Intent(k.this.getActivity(), (Class<?>) HostActivity.class);
                bundle.putString("fragmenttype", "fragment_bt_comment");
                bundle.putString("weburl", str);
                bundle.putString("contentCode", k.this.V.getContentcode());
                intent.putExtras(bundle);
                if (k.this.j1) {
                    k.this.c0.L();
                    return;
                } else {
                    k.this.startActivity(intent);
                    return;
                }
            }
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) k.this).h, new a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class m implements SDKFavoriteMgr.OnAddFavoriteReturnListener {
        m() {
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnAddFavoriteReturnListener
        public void onAddFavoriteReturn(String str, String str2) {
            LogEx.d("DetailSeriesInfoFragment", "onAddFavoriteReturn " + str);
            if (TextUtils.equals(str, "0")) {
                k.this.V.setIsfavorite("1");
                ArrayList arrayList = (ArrayList) SDKCacheMgr.getAsObject(com.zte.iptvclient.android.common.c.c.f4110c + k.this.Y.V());
                if (arrayList != null) {
                    arrayList.add(new VoDBean(k.this.V));
                }
                SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.f4110c + k.this.Y.V(), arrayList);
                k.this.y0.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_selected));
                ((com.zte.fragmentlib.b) k.this).h.a(k.this.y0, "background", R.drawable.function_fav_selected);
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.m.b());
                return;
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.add_favourite_msg5));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class n implements SDKFavoriteMgr.OnDelFavoriteReturnListener {
        n() {
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnDelFavoriteReturnListener
        public void onDelFavoriteReturn(String str, String str2) {
            LogEx.d("DetailSeriesInfoFragment", "onAddFavoriteReturn " + str);
            if (TextUtils.equals(str, "0")) {
                k.this.V.setIsfavorite("0");
                k kVar = k.this;
                kVar.w(kVar.V.getProgramcode());
                k.this.y0.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_normal));
                ((com.zte.fragmentlib.b) k.this).h.a(k.this.y0, "background", R.drawable.function_fav_normal);
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.m.b());
                return;
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.del_favourite_msg));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class o implements DialogInterface.OnClickListener {
        o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ((com.zte.fragmentlib.b) k.this).h.getSupportFragmentManager().F();
            ((MainActivity) ((com.zte.fragmentlib.b) k.this).h).y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class p implements DialogInterface.OnClickListener {
        p(k kVar) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class q extends com.bumptech.glide.q.j.g<Bitmap> {
        q(k kVar) {
        }

        public void a(Bitmap bitmap, com.bumptech.glide.q.i.c<? super Bitmap> cVar) {
        }

        @Override // com.bumptech.glide.q.j.j
        public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.q.i.c cVar) {
            a((Bitmap) obj, (com.bumptech.glide.q.i.c<? super Bitmap>) cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class s implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6062a;

        s(int i) {
            this.f6062a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int firstVisiblePosition = k.this.v.getFirstVisiblePosition();
            int lastVisiblePosition = k.this.v.getLastVisiblePosition();
            int i = ((firstVisiblePosition + lastVisiblePosition) / 2) + 1;
            int i2 = i - 1;
            int i3 = i + 1;
            int i4 = this.f6062a;
            if ((i4 < i2 || i4 > i3) && lastVisiblePosition < k.this.T - 1 && this.f6062a > 3) {
                k.this.v.setSelection(this.f6062a - 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class t implements b.InterfaceC0216b {
        t() {
        }

        @Override // com.zte.iptvclient.android.mobile.e0.b.InterfaceC0216b
        public void a(float f) {
            k.this.f((int) (f * 2.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class u implements SDKVodMgr.OnSeriesChildListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6065a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SeriesHeadBean f6066b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f6067c;

        u(String str, SeriesHeadBean seriesHeadBean, String str2) {
            this.f6065a = str;
            this.f6066b = seriesHeadBean;
            this.f6067c = str2;
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnSeriesChildListReturnListener
        public void onSeriesChildListReturn(String str, String str2, String str3) {
            LogEx.d("DetailSeriesInfoFragment", "Season Data --> returncode : " + str + " , error : " + str2 + " , data : " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    k.this.t(jSONObject.optString("totalcount"));
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        com.zte.iptvclient.android.mobile.vod.entity.a a2 = com.zte.iptvclient.android.mobile.vod.entity.a.a(jSONArray.getJSONObject(i));
                        if (this.f6065a != null && this.f6065a.equals(a2.c())) {
                            a2.a(true);
                        }
                        arrayList.add(a2);
                    }
                    k.this.h1.clear();
                    if (!arrayList.isEmpty()) {
                        k.this.h1.addAll(arrayList);
                    } else {
                        k.this.h1.add(com.zte.iptvclient.android.mobile.vod.entity.a.a(this.f6066b));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (TextUtils.equals(this.f6067c, "3")) {
                k kVar = k.this;
                kVar.i1 = ((com.zte.iptvclient.android.mobile.vod.entity.a) kVar.h1.get(0)).c();
                Fragment parentFragment = k.this.getParentFragment();
                if (parentFragment instanceof com.zte.iptvclient.android.mobile.e0.e.i) {
                    ((com.zte.iptvclient.android.mobile.e0.e.i) parentFragment).u(k.this.i1);
                }
            }
            k.this.g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class v implements View.OnClickListener {
        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.V == null) {
                return;
            }
            k.this.k(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class w implements View.OnClickListener {
        w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.V == null) {
                return;
            }
            k.this.k(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class x implements View.OnClickListener {
        x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.V == null) {
                return;
            }
            k.this.k(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class y implements View.OnClickListener {
        y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.U() || k.this.V == null || k.this.c0 == null) {
                return;
            }
            k.this.c0.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class z implements View.OnClickListener {

        /* compiled from: DetailSeriesInfoFragment.java */
        /* loaded from: classes2.dex */
        class a implements t.d {
            a(z zVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.U() || k.this.V == null) {
                return;
            }
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (TextUtils.equals(k.this.V.getIsfavorite(), "0")) {
                    k.this.W();
                    return;
                } else {
                    k.this.X();
                    return;
                }
            }
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) k.this).h, new a(this));
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        T();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        LogEx.d("DetailSeriesInfoFragment", "detail onConfigurationChanged");
        super.onConfigurationChanged(configuration);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        this.Y = new com.zte.iptvclient.android.common.j.h(this.h);
        this.j1 = BaseApp.f();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.detail_series_info_layout, viewGroup, false);
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        inflate.requestFocus();
        f(inflate);
        e(inflate);
        this.f0 = inflate;
        a0();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.b0.g.a aVar) {
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.j.d dVar) {
        LogEx.d("DetailSeriesInfoFragment", "recv UnLockSeriesDetailEvent event");
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z2) {
        super.onHiddenChanged(z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesInfoFragment.java */
    /* loaded from: classes2.dex */
    public class r implements com.bumptech.glide.q.f<String, Bitmap> {
        r() {
        }

        @Override // com.bumptech.glide.q.f
        public boolean a(Exception exc, String str, com.bumptech.glide.q.j.j<Bitmap> jVar, boolean z) {
            LogEx.d("DetailSeriesInfoFragment", "loaded bitmap image  is onException");
            return false;
        }

        @Override // com.bumptech.glide.q.f
        public boolean a(Bitmap bitmap, String str, com.bumptech.glide.q.j.j<Bitmap> jVar, boolean z, boolean z2) {
            LogEx.d("DetailSeriesInfoFragment", "loaded bitmap image  is onResourceReady");
            k.this.Z = bitmap;
            return false;
        }
    }

    private void P() {
        Y();
        R();
        b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.zte.iptvclient.android.common.javabean.f Q() {
        if (this.V == null || this.X == null) {
            return null;
        }
        com.zte.iptvclient.android.common.javabean.f fVar = new com.zte.iptvclient.android.common.javabean.f();
        fVar.e(this.X.j());
        fVar.j(this.V.getSeriesprogramcode());
        fVar.a(this.X.n());
        fVar.i(this.V.getContentcode());
        fVar.h(this.V.getColumncode());
        String n2 = this.X.n();
        if (n2.length() == 1) {
            n2 = "0" + n2;
        }
        fVar.f((n2 + " ") + this.X.k());
        fVar.d("2");
        return fVar;
    }

    private void R() {
        if (TextUtils.equals(this.V.getIsfavorite(), "1")) {
            this.y0.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_selected));
            SupportActivity supportActivity = this.h;
            if (supportActivity != null) {
                supportActivity.a(this.y0, "background", R.drawable.function_fav_selected);
                return;
            }
            return;
        }
        this.y0.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_normal));
        SupportActivity supportActivity2 = this.h;
        if (supportActivity2 != null) {
            supportActivity2.a(this.y0, "background", R.drawable.function_fav_normal);
        }
    }

    private void S() {
        this.v0.findViewById(R.id.rl_function_play_push).setVisibility(8);
        this.v0.findViewById(R.id.rl_function_favorite).setVisibility(8);
        this.v0.findViewById(R.id.rl_function_score).setVisibility(8);
        this.v0.findViewById(R.id.rl_function_share).setVisibility(8);
        this.v0.findViewById(R.id.rl_function_comment).setVisibility(8);
    }

    private void T() {
        this.Y = new com.zte.iptvclient.android.common.j.h(this.h);
        this.A = new ArrayList<>();
        this.B = new ArrayList<>();
        this.C = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.U <= 500) {
            LogEx.w("UseeTv", "Operate limit,less than 500(ms)!");
            return true;
        }
        this.U = currentTimeMillis;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        com.zte.iptvclient.android.common.customview.a.a.a.a aVar = new com.zte.iptvclient.android.common.customview.a.a.a.a(this.h);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setTitle(R.string.not_connected_stb);
        aVar.a(R.string.connect_hc100_stb_prompt);
        aVar.b(R.string.confirm, new o());
        aVar.a(R.string.common_cancel, null);
        aVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("favoritetype", "4");
        hashMap.put("contentcode", this.V.getContentcode());
        hashMap.put("columncode", this.V.getColumncode());
        new SDKFavoriteMgr().doAddFavorite(hashMap, new m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ParamConst.FAVORITE_DELETE_BATCH_REQ_FAVORITETYPES, "4");
        hashMap.put("contentcodes", this.V.getContentcode());
        hashMap.put("columncodes", this.V.getColumncode());
        new SDKFavoriteMgr().doDelFavorite(hashMap, new n());
    }

    private void Y() {
        try {
            int parseInt = Integer.parseInt(this.V.getSeriesnum());
            int parseInt2 = Integer.parseInt(this.V.getUpdatenum());
            String format = String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.series_updated_num), Integer.valueOf(parseInt));
            String format2 = String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.series_update_num), Integer.valueOf(parseInt2));
            this.t.setText(format2 + " / " + format);
            int intValue = Integer.valueOf(this.V.getSeriesnum()).intValue();
            this.T = intValue;
            if (intValue < 1) {
                this.u.setVisibility(8);
            } else {
                this.u.setVisibility(0);
            }
        } catch (Exception e2) {
            LogEx.e("DetailSeriesInfoFragment", "get Update series Num getException=" + e2.getMessage());
        }
        c0 c0Var = this.w;
        if (c0Var == null) {
            if (!TextUtils.isEmpty(this.V.getSeriesnum())) {
                c0 c0Var2 = new c0(this, this.h, d(Integer.parseInt(this.V.getSeriesnum())), null);
                this.w = c0Var2;
                this.v.setAdapter((ListAdapter) c0Var2);
            }
        } else {
            c0Var.a(d(Integer.parseInt(this.V.getSeriesnum())));
        }
        v(this.V.getBreakpoint());
    }

    private void Z() {
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            S();
        }
    }

    private void a0() {
        this.M0.setOnClickListener(new l());
        this.N.setOnClickListener(new v());
        this.P.setOnClickListener(new w());
        this.O.setOnClickListener(new x());
        this.w0.setOnClickListener(new y());
        this.y0.setOnClickListener(new z());
        this.B0.setOnClickListener(new a0());
        this.C0.setOnClickListener(new b0());
        this.D.setOnClickListener(new a());
        this.v.setOnItemClickListener(new b());
        this.v.setOnScrollListener(new c());
        this.q.setOnClickListener(new d());
        this.J.setOnClickListener(new e());
        this.A0.setOnClickListener(new f());
        this.s0.setOnClickListener(new g());
        this.z0.setOnClickListener(new h());
    }

    private void b0() {
        String a2 = com.zte.iptvclient.android.common.k.g.a(this.j1 ? 9 : 3, this.V.getPosterfilelist());
        LogEx.d("DetailSeriesInfoFragment", "load bitmap image url is " + a2);
        SupportActivity supportActivity = this.h;
        if (supportActivity == null || supportActivity.isFinishing()) {
            return;
        }
        com.bumptech.glide.b<String> f2 = com.bumptech.glide.i.a((FragmentActivity) this.h).a(a2).f();
        f2.a(DiskCacheStrategy.NONE);
        f2.c();
        f2.a((com.bumptech.glide.q.f<? super String, TranscodeType>) new r());
        f2.a((com.bumptech.glide.b<String>) new q(this));
    }

    private void c0() {
        SeriesHeadBean seriesHeadBean = this.V;
        if (seriesHeadBean == null) {
            return;
        }
        this.E.setText(seriesHeadBean.getProgramname());
        if (!TextUtils.isEmpty(this.V.getPrice())) {
            try {
                Double valueOf = Double.valueOf(this.V.getPrice());
                if (valueOf.doubleValue() > 0.0d) {
                    this.V0.setText(com.zte.iptvclient.android.common.k.w.c(valueOf.doubleValue()) + com.zte.iptvclient.android.common.i.a.a.a(R.string.money_unit_sign));
                } else {
                    this.V0.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.price_free));
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        } else {
            this.V0.setText("");
        }
        com.zte.iptvclient.android.common.k.p.a(this.W0, this.V.getRatingid());
        if (!TextUtils.isEmpty(this.V.getElapsedtime())) {
            this.X0.setVisibility(0);
            this.Y0.setText(com.zte.iptvclient.android.common.k.k.b(this.V.getElapsedtime()));
        } else {
            this.X0.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.V.getReleasedate())) {
            this.Z0.setVisibility(0);
            this.Z0.setText(this.V.getReleasedate());
        } else {
            this.Z0.setVisibility(8);
        }
        float f2 = 0.0f;
        if ("1".equals(ConfigMgr.readPropertie("IsShowDefaultRatingFunction"))) {
            if (!TextUtils.isEmpty(this.V.getStarlevel())) {
                try {
                    f2 = Integer.parseInt(this.V.getStarlevel()) * 1.0f;
                } catch (Exception e3) {
                    LogEx.e("DetailSeriesInfoFragment", "getStartLevel getException=" + e3.getMessage());
                    e3.printStackTrace();
                }
            }
            String a2 = com.zte.iptvclient.android.common.k.w.a(f2);
            this.F.setText(a2);
            if (this.j1) {
                this.c1.I().setText(a2);
            }
        } else {
            float a3 = com.zte.iptvclient.android.mobile.e0.f.k.a(this.V.getRatingsum(), this.V.getRatingnum());
            this.G = a3 < 0.0f ? 0.0f : a3;
            if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
                this.F.setText(a3 < 0.0f ? "--" : com.zte.iptvclient.android.common.k.w.a(a3));
            }
        }
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        com.zte.iptvclient.android.mobile.e0.f.e.b(com.zte.iptvclient.android.common.i.a.a.a(R.string.rating_failed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        com.zte.iptvclient.android.mobile.e0.f.e.b(com.zte.iptvclient.android.common.i.a.a.a(R.string.rating_success));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        com.zte.iptvclient.android.common.customview.a.a.a.a aVar = new com.zte.iptvclient.android.common.customview.a.a.a.a(this.h);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setTitle(R.string.stb_login_failed_title);
        aVar.a(R.string.stb_login_failed_info);
        aVar.b(R.string.confirm, new p(this));
        aVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        this.d1.setVisibility(0);
        this.f1.setVisibility(0);
        this.e1.setVisibility(0);
        this.g1.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i2) {
        com.zte.iptvclient.android.mobile.e0.e.i iVar = this.c0;
        if (iVar != null) {
            iVar.e(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i2) {
        if (U() || this.V == null) {
            return;
        }
        com.zte.iptvclient.android.mobile.l.b.b bVar = new com.zte.iptvclient.android.mobile.l.b.b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("VideoDetailBean", d(this.V));
        bundle.putInt("recommendType", i2);
        bVar.setArguments(bundle);
        a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str) {
        String replace = "http://{ipadd:port}/iptvepg/{frame}/sdk_upcomingset.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f());
        LogEx.d("DetailSeriesInfoFragment", "addSubscribe url = " + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        String d2 = com.zte.iptvclient.common.uiframe.a.d("UserToken");
        String d3 = com.zte.iptvclient.common.uiframe.a.d("UserID");
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Recommend_Server_CpCode");
        sDKNetHTTPRequest.setParam("usertoken", d2);
        sDKNetHTTPRequest.setParam("usercode", d3);
        sDKNetHTTPRequest.setParam("action", str);
        sDKNetHTTPRequest.setParam("contentcode", this.V.getContentcode());
        sDKNetHTTPRequest.setParam("contentname", this.V.getProgramname());
        sDKNetHTTPRequest.setParam("contentmediacode", c2);
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.startRequest(replace, "GET", new j(str));
    }

    private void v(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            e(Integer.valueOf(str).intValue());
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str) {
        ArrayList arrayList = (ArrayList) SDKCacheMgr.getAsObject(com.zte.iptvclient.android.common.c.c.f4110c + this.Y.V());
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size() && TextUtils.equals(((VoDBean) arrayList.get(i2)).h(), str); i2++) {
                arrayList.remove(i2);
            }
        }
        SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.f4110c + this.Y.V(), arrayList);
    }

    public void I() {
        if (this.O0.getVisibility() == 0) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof com.zte.iptvclient.android.mobile.e0.e.i) {
                ((com.zte.iptvclient.android.mobile.e0.e.i) parentFragment).D();
                return;
            }
            return;
        }
        this.q0.removeView(this.m0);
        K();
    }

    public void J() {
        this.P0.setVisibility(8);
        this.Q0.setVisibility(8);
    }

    public void K() {
        this.N0.setVisibility(8);
        this.O0.setVisibility(0);
        this.N0.removeAllViews();
    }

    public void L() {
        if (com.zte.iptvclient.android.mobile.e0.f.b.b()) {
            this.L0.setVisibility(0);
        } else {
            this.L0.setVisibility(8);
        }
    }

    public void M() {
        ImageView imageView = this.A0;
        if (imageView != null) {
            imageView.setBackgroundResource(R.drawable.push_disable);
            this.A0.setEnabled(false);
        }
    }

    public void N() {
        com.zte.iptvclient.android.mobile.e0.e.i iVar = this.c0;
        if (iVar != null) {
            if (iVar.I0) {
                this.J.setVisibility(0);
                if (this.c0.J0) {
                    this.J.setBackgroundResource(R.drawable.detail_online_has_order);
                    this.J.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_reminder_booked));
                    return;
                } else {
                    this.J.setBackgroundResource(R.drawable.detail_online_order);
                    this.J.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_reminder_booking));
                    return;
                }
            }
            this.J.setVisibility(8);
        }
    }

    public void O() {
        this.P0.setVisibility(0);
        this.Q0.setVisibility(0);
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.j.a aVar) {
        this.E.setText(this.V.getProgramname());
        LogEx.d("DetailSeriesInfoFragment", "UnLockBlockTitleEvent event");
    }

    public void s(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.w0.setEnabled(true);
            this.w0.setBackgroundResource(R.drawable.function_trailer_normal);
        } else {
            this.w0.setEnabled(false);
            this.w0.setBackgroundResource(R.drawable.icon_trailer_white);
        }
    }

    public void t(String str) {
        if (this.j1) {
            com.zte.iptvclient.android.mobile.e0.e.g gVar = this.c1;
            if (gVar != null) {
                gVar.s(str);
                return;
            }
            return;
        }
        this.a1.setVisibility(0);
        this.b1.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoDetailBean d(SeriesHeadBean seriesHeadBean) {
        VideoDetailBean videoDetailBean = new VideoDetailBean();
        videoDetailBean.setProgramcode(seriesHeadBean.getProgramcode());
        videoDetailBean.setColumncode(seriesHeadBean.getColumncode());
        videoDetailBean.setProgramname(seriesHeadBean.getProgramname());
        videoDetailBean.setDirector(seriesHeadBean.getDirector());
        videoDetailBean.setActor(seriesHeadBean.getActor());
        videoDetailBean.setPrice(seriesHeadBean.getPrice());
        videoDetailBean.setDescription(seriesHeadBean.getDescription());
        videoDetailBean.setProgramtype(seriesHeadBean.getProgramtype());
        videoDetailBean.setGenre(seriesHeadBean.getGenre());
        videoDetailBean.setCpcode(seriesHeadBean.getCpcode());
        videoDetailBean.setBocode(seriesHeadBean.getBocode());
        videoDetailBean.setContentcode(seriesHeadBean.getContentcode());
        videoDetailBean.setRatingnum(seriesHeadBean.getRatingnum());
        videoDetailBean.setRatingsum(seriesHeadBean.getRatingsum());
        videoDetailBean.setRatingid(seriesHeadBean.getRatingid());
        videoDetailBean.setTrailer(seriesHeadBean.getTrailer());
        videoDetailBean.setTelecomcode(seriesHeadBean.getTelecomcode());
        videoDetailBean.setIsprotection(seriesHeadBean.getIsprotection());
        videoDetailBean.setMediaservices(seriesHeadBean.getMediaservices());
        videoDetailBean.setAudiolang(seriesHeadBean.getAudiolang());
        videoDetailBean.setSubtitlelang(seriesHeadBean.getSubtitlelang());
        videoDetailBean.setPosterfilelist(seriesHeadBean.getPosterfilelist());
        videoDetailBean.setReleasedate(seriesHeadBean.getReleasedate());
        videoDetailBean.setWriter(seriesHeadBean.getWriter());
        videoDetailBean.setVideoelapsedtime(seriesHeadBean.getElapsedtime());
        videoDetailBean.setLanguage(seriesHeadBean.getLanguage());
        videoDetailBean.setCountryname(seriesHeadBean.getCountryname());
        videoDetailBean.setOfflinetime(seriesHeadBean.getOfflinetime());
        videoDetailBean.setVideoelapsedtime(seriesHeadBean.getElapsedtime());
        videoDetailBean.setPubcompany(seriesHeadBean.getPubcompany());
        videoDetailBean.setSeriestype(seriesHeadBean.getSeriestype());
        return videoDetailBean;
    }

    private void e(View view) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.j1) {
            this.a0 = 40;
        }
        this.L0 = (RelativeLayout) view.findViewById(R.id.rl_function_comment);
        L();
        this.M0 = (ImageView) view.findViewById(R.id.iv_function_comment);
        this.q0 = (FrameLayout) view.findViewById(R.id.fl_oper_bar_container);
        this.r0 = (LinearLayout) view.findViewById(R.id.ll_detail_function_menu);
        if (this.j1) {
            int a2 = com.zte.iptvclient.android.common.k.g.a(getContext(), 40.0f);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.q0.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = a2;
                this.q0.setLayoutParams(layoutParams2);
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.r0.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.height = a2;
                this.r0.setLayoutParams(layoutParams3);
            }
        }
        this.s0 = (RelativeLayout) view.findViewById(R.id.rl_more_screen_watching);
        if ("1".equals(ConfigMgr.readPropertie("ForbiddenMulScreenPlay", "0"))) {
            this.s0.setVisibility(4);
        }
        this.t0 = (ImageView) view.findViewById(R.id.iv_more_screen_watching);
        TextView textView = (TextView) view.findViewById(R.id.tv_more_screen_watching);
        this.u0 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multi_play_title));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_right_function_menu);
        this.v0 = linearLayout;
        if (this.j1) {
            int childCount = linearLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.v0.getChildAt(0);
                if ((childAt instanceof ImageView) && (layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams()) != null) {
                    layoutParams.height = com.zte.iptvclient.android.common.k.g.a(getContext(), 25.0f);
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_function_trailer);
        this.w0 = imageView;
        imageView.setBackgroundResource(R.drawable.icon_trailer_white);
        this.w0.setEnabled(false);
        this.x0 = (ImageView) view.findViewById(R.id.iv_function_rating);
        this.y0 = (ImageView) view.findViewById(R.id.iv_function_favorite);
        view.findViewById(R.id.rl_function_score).setVisibility(0);
        this.z0 = (ImageView) view.findViewById(R.id.iv_function_score);
        this.A0 = (ImageView) view.findViewById(R.id.iv_function_play_push);
        this.B0 = (ImageView) view.findViewById(R.id.iv_function_download);
        this.C0 = (ImageView) view.findViewById(R.id.iv_function_share);
        this.A0.setBackgroundResource(R.drawable.push_disable);
        this.A0.setEnabled(false);
        this.i0 = (LinearLayout) view.findViewById(R.id.video_detail_bottom_btn_rating);
        this.j0 = view.findViewById(R.id.separate_line);
        this.k0 = (FrameLayout) view.findViewById(R.id.series_detail_info_hd);
        this.l0 = (LinearLayout) view.findViewById(R.id.ll_recommend);
        com.zte.iptvclient.common.uiframe.f.a(this.M0);
        com.zte.iptvclient.common.uiframe.f.a(this.q0);
        com.zte.iptvclient.common.uiframe.f.a(this.r0);
        com.zte.iptvclient.common.uiframe.f.a(this.s0);
        com.zte.iptvclient.common.uiframe.f.a(this.t0);
        com.zte.iptvclient.common.uiframe.f.a(this.u0);
        com.zte.iptvclient.common.uiframe.f.a(this.v0);
        com.zte.iptvclient.common.uiframe.f.a(this.w0);
        com.zte.iptvclient.common.uiframe.f.a(this.x0);
        com.zte.iptvclient.common.uiframe.f.a(this.y0);
        com.zte.iptvclient.common.uiframe.f.a(this.z0);
        com.zte.iptvclient.common.uiframe.f.a(this.A0);
        com.zte.iptvclient.common.uiframe.f.a(this.B0);
        com.zte.iptvclient.common.uiframe.f.a(this.C0);
        com.zte.iptvclient.common.uiframe.f.a(this.i0);
        com.zte.iptvclient.common.uiframe.f.a(this.j0);
        com.zte.iptvclient.common.uiframe.f.a(this.k0);
        com.zte.iptvclient.common.uiframe.f.a(this.l0);
        this.x0.setVisibility(8);
        this.D = (RelativeLayout) view.findViewById(R.id.rl_introduction);
        this.E = (TextView) view.findViewById(R.id.txt_summary);
        this.F = (TextView) view.findViewById(R.id.txt_summary_sum);
        TextView textView2 = (TextView) view.findViewById(R.id.introduction_more);
        this.D0 = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_introduction));
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_summary_title));
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.F);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_introduction_more));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.introduction_more));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.more_icon));
        this.P0 = (LinearLayout) view.findViewById(R.id.ll_episodes_wrapper);
        this.Q0 = view.findViewById(R.id.view_series_separator);
        TextView textView3 = (TextView) view.findViewById(R.id.episode_header_txtvew);
        this.s = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_series_episode));
        this.q = (RelativeLayout) view.findViewById(R.id.episode_header_rlayout);
        this.r = (LinearLayout) view.findViewById(R.id.episode_more_llayout);
        this.t = (TextView) view.findViewById(R.id.episode_more_txt);
        this.u = (ImageView) view.findViewById(R.id.episode_more_img);
        HListView hListView = (HListView) view.findViewById(R.id.episode_hListview);
        this.v = hListView;
        com.zte.iptvclient.common.uiframe.f.a(hListView);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.episode_header_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.episode_header_txtvew));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.episode_list_rlayout));
        Button button = (Button) view.findViewById(R.id.btn_order);
        this.J = button;
        com.zte.iptvclient.common.uiframe.f.a(button);
        this.K = (LinearLayout) view.findViewById(R.id.llRecDirector_contaioner);
        this.N = (RelativeLayout) view.findViewById(R.id.rl_rec_directo_header);
        this.L = (LinearLayout) view.findViewById(R.id.llRecStars_contaioner);
        this.O = (RelativeLayout) view.findViewById(R.id.rl_rec_stars_header);
        this.M = (LinearLayout) view.findViewById(R.id.llMb_Likes_contaioner);
        this.P = (RelativeLayout) view.findViewById(R.id.rl_mb_likes_header);
        this.Q = (RecomeGridView) view.findViewById(R.id.video_detail_rec_director_grid);
        this.R = (RecomeGridView) view.findViewById(R.id.video_detail_rec_stars_grid);
        this.S = (RecomeGridView) view.findViewById(R.id.video_detail_mb_likes_grid);
        TextView textView4 = (TextView) view.findViewById(R.id.rec_director_text);
        this.E0 = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_rel_dir));
        TextView textView5 = (TextView) view.findViewById(R.id.rec_director_more_txt);
        this.F0 = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.more));
        TextView textView6 = (TextView) view.findViewById(R.id.rec_stars_text);
        this.G0 = textView6;
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_rel_stars));
        TextView textView7 = (TextView) view.findViewById(R.id.rec_stars_more_txt);
        this.H0 = textView7;
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.more));
        TextView textView8 = (TextView) view.findViewById(R.id.mb_likes_text);
        this.I0 = textView8;
        textView8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_may_likes));
        TextView textView9 = (TextView) view.findViewById(R.id.mb_likes_more_txt);
        this.J0 = textView9;
        textView9.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.more));
        this.R0 = (TextView) view.findViewById(R.id.txt_imdb);
        this.S0 = (TextView) view.findViewById(R.id.txt_kino_poisk);
        this.V0 = (TextView) view.findViewById(R.id.txt_price);
        this.W0 = (ImageView) view.findViewById(R.id.iv_rating_pic);
        this.X0 = (RelativeLayout) this.i0.findViewById(R.id.rl_duration_wrapper);
        this.Y0 = (TextView) this.i0.findViewById(R.id.txt_movie_duration);
        this.Z0 = (TextView) this.i0.findViewById(R.id.txt_movie_release_year);
        this.a1 = (RelativeLayout) this.i0.findViewById(R.id.rl_series_season_wrapper);
        this.b1 = (TextView) this.i0.findViewById(R.id.txt_series_season_num);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_comment));
        com.zte.iptvclient.common.uiframe.f.a(this.K);
        com.zte.iptvclient.common.uiframe.f.a(this.L);
        com.zte.iptvclient.common.uiframe.f.a(this.M);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_rec_directo_header));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_director_more_llayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_director_more_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_director_more_img));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_director_text));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_rec_stars_header));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_stars_more_llayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_stars_more_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_stars_more_img));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_stars_text));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_mb_likes_header));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.mb_likes_more_llayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.mb_likes_more_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.mb_likes_more_img));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.mb_likes_text));
        com.zte.iptvclient.common.uiframe.f.a(this.Q);
        com.zte.iptvclient.common.uiframe.f.a(this.R);
        com.zte.iptvclient.common.uiframe.f.a(this.S);
        com.zte.iptvclient.common.uiframe.f.a(this.R0);
        com.zte.iptvclient.common.uiframe.f.a(this.S0);
        com.zte.iptvclient.common.uiframe.f.a(this.V0);
        com.zte.iptvclient.common.uiframe.f.a(this.W0);
        com.zte.iptvclient.common.uiframe.f.a(this.Y0);
        com.zte.iptvclient.common.uiframe.f.a(this.Z0);
        com.zte.iptvclient.common.uiframe.f.a(this.b1);
        this.X0.setVisibility(8);
        this.Z0.setVisibility(8);
        if (!"on".equals(ConfigMgr.readPropertie("DownloadModuleSwith"))) {
            this.B0.setVisibility(8);
        }
        if ("0".equals(ConfigMgr.readPropertie("IsSupportDownload"))) {
            this.B0.setVisibility(8);
        }
        if (TextUtils.equals(ConfigMgr.readPropertie("IsShowTrailer"), "1")) {
            this.w0.setVisibility(0);
        } else {
            this.w0.setVisibility(8);
        }
        if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
            this.x0.setVisibility(8);
            this.y0.setVisibility(0);
            this.A0.setVisibility(0);
            this.C0.setVisibility(0);
            this.i0.setVisibility(8);
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.j0.getLayoutParams();
            SupportActivity supportActivity = this.h;
            if (supportActivity != null && layoutParams4 != null) {
                layoutParams4.height = com.zte.iptvclient.android.common.k.g.a(supportActivity, 1.0f);
                this.j0.setLayoutParams(layoutParams4);
            }
            if (this.j1) {
                this.s0.setVisibility(8);
                this.D.setVisibility(8);
                this.l0.setVisibility(8);
                this.j0.setVisibility(8);
                this.k0.setVisibility(0);
                this.c1 = new com.zte.iptvclient.android.mobile.e0.e.g();
                Bundle bundle = new Bundle();
                bundle.putBoolean("isSeriesDetailHD", true);
                this.c1.setArguments(bundle);
                a(R.id.series_detail_info_hd, this.c1);
                LogEx.d("DetailSeriesInfoFragment", "is AT PAD");
            } else {
                this.s0.setVisibility(8);
                this.k0.setVisibility(8);
                LogEx.d("DetailSeriesInfoFragment", "is AT Phone");
            }
            i2 = 0;
        } else {
            i2 = 0;
            this.i0.setVisibility(0);
            this.k0.setVisibility(8);
            LogEx.d("DetailSeriesInfoFragment", "is not AT version");
        }
        this.i0.setVisibility(i2);
        this.N0 = (FrameLayout) view.findViewById(R.id.fl_series_info_container);
        this.O0 = (LinearLayout) view.findViewById(R.id.ll_series_indicate_wrapper);
        Z();
    }

    private void f(View view) {
        this.d1 = (RelativeLayout) view.findViewById(R.id.rl_season_title);
        this.f1 = view.findViewById(R.id.view_separator_season);
        this.e1 = (HListView) view.findViewById(R.id.series_season_hListview);
        com.zte.iptvclient.common.uiframe.f.a(this.d1);
        com.zte.iptvclient.common.uiframe.f.a(this.d1.findViewById(R.id.tv_season_title));
        com.zte.iptvclient.common.uiframe.f.a(this.e1);
        com.zte.iptvclient.android.mobile.e0.d.f fVar = new com.zte.iptvclient.android.mobile.e0.d.f(getContext(), this.h1);
        this.g1 = fVar;
        this.e1.setAdapter((ListAdapter) fVar);
        this.e1.setOnItemClickListener(new SeriesSeasonItemPreventFastDoubleClickPhone(new C0240k()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean g(int i2) {
        int i3;
        Boolean bool = false;
        if (!this.A.contains(String.valueOf(i2))) {
            i3 = -1;
            bool = true;
        } else {
            i3 = this.A.indexOf(String.valueOf(String.valueOf(i2)));
        }
        if (i3 < 0) {
            return true;
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(int i2) {
        int i3 = this.a0;
        if (i2 < i3) {
            return i2;
        }
        if (i2 % i3 > 0) {
            return i2 % i3;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i(int i2) {
        int i3 = this.T;
        int i4 = this.a0;
        int i5 = i3 / i4;
        int i6 = 0;
        if (i2 > i4) {
            int i7 = 0;
            while (i6 < i5) {
                int i8 = this.a0;
                int i9 = (i6 * i8) + 1;
                int i10 = i6 + 1;
                int i11 = i8 * i10;
                if (i2 >= i9 && i2 <= i11) {
                    i7 = i6;
                }
                i6 = i10;
            }
            int i12 = this.T;
            int i13 = this.a0;
            if (i12 % i13 <= 0 || i2 < (i13 * i5) + 1 || i2 > i12) {
                i5 = i7;
            }
        } else {
            i5 = 0;
        }
        LogEx.d("DetailSeriesInfoFragment", "---getCurrNavFlagByPosition iCurHLVewPosition: " + i2 + ", index: " + i5);
        return i5;
    }

    public void c(SeriesHeadBean seriesHeadBean) {
        this.V = seriesHeadBean;
        c0();
        N();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.i.b bVar) {
        this.y = Integer.parseInt(bVar.a()) - 1;
    }

    public void b(SeriesHeadBean seriesHeadBean) {
        com.zte.iptvclient.android.mobile.e0.e.g gVar;
        if (this.j1) {
            if (seriesHeadBean != null && (gVar = this.c1) != null) {
                gVar.a(d(seriesHeadBean));
            }
            P();
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        this.T0 = str3;
        this.U0 = str4;
        if (this.j1) {
            com.zte.iptvclient.android.mobile.e0.e.g gVar = this.c1;
            if (gVar != null) {
                gVar.e(str3, str4);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            this.R0.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating), "--"));
        } else {
            this.R0.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating), com.zte.iptvclient.android.common.k.w.b(str3)));
        }
        if (TextUtils.isEmpty(str4)) {
            this.S0.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating_kinopoisk), "--"));
        } else {
            this.S0.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating_kinopoisk), com.zte.iptvclient.android.common.k.w.b(str4)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NetworkInfo networkInfo, View view) {
        String typeName = networkInfo.getTypeName();
        if (typeName.equalsIgnoreCase("mobile")) {
            this.b0 = new com.zte.iptvclient.android.mobile.i.b.h();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("EpisodeNavList", this.C);
            bundle.putStringArrayList("DefaultSeriesList", this.p);
            bundle.putString("Programcode", this.V.getProgramcode());
            bundle.putString("ColumnCode", this.V.getColumncode());
            bundle.putInt("AllSeriesNum", Integer.valueOf(this.V.getSeriesnum()).intValue());
            HashMap<String, String> hashMap = this.W;
            if (hashMap != null) {
                bundle.putSerializable("DefinitionMap", hashMap);
            }
            bundle.putString("getRatingId", this.V.getRatingid());
            this.b0.setArguments(bundle);
            com.zte.iptvclient.android.mobile.e0.e.i iVar = this.c0;
            if (iVar != null) {
                this.b0.a((h.InterfaceC0281h) iVar);
            }
            a(this.b0);
            return;
        }
        if (typeName.equalsIgnoreCase("WIFI")) {
            this.b0 = new com.zte.iptvclient.android.mobile.i.b.h();
            Bundle bundle2 = new Bundle();
            bundle2.putStringArrayList("EpisodeNavList", this.C);
            bundle2.putStringArrayList("DefaultSeriesList", this.p);
            bundle2.putString("Programcode", this.V.getProgramcode());
            bundle2.putString("ColumnCode", this.V.getColumncode());
            bundle2.putInt("AllSeriesNum", Integer.valueOf(this.V.getSeriesnum()).intValue());
            HashMap<String, String> hashMap2 = this.W;
            if (hashMap2 != null) {
                bundle2.putSerializable("DefinitionMap", hashMap2);
            }
            bundle2.putString("getRatingId", this.V.getRatingid());
            this.b0.setArguments(bundle2);
            com.zte.iptvclient.android.mobile.e0.e.i iVar2 = this.c0;
            if (iVar2 != null) {
                this.b0.a((h.InterfaceC0281h) iVar2);
            }
            a(this.b0);
        }
    }

    public void f(int i2) {
        String valueOf = String.valueOf(i2);
        SeriesHeadBean seriesHeadBean = this.V;
        if (seriesHeadBean != null) {
            String contentcode = seriesHeadBean.getContentcode();
            String programtype = this.V.getProgramtype();
            if (StringUtil.isEmptyString(contentcode) || StringUtil.isEmptyString(programtype)) {
                return;
            }
            String replace = "http://{ipadd:port}/iptvepg/{frame}/dostarrating.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f());
            LogEx.d("DetailSeriesInfoFragment", "sdkDoStarRating url: " + replace);
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
            sDKNetHTTPRequest.setCharset("gbk");
            sDKNetHTTPRequest.setParam("contentcode", contentcode);
            sDKNetHTTPRequest.setParam("contenttype", programtype);
            sDKNetHTTPRequest.setParam("starrating", valueOf);
            sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_GET, new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CommonVideoBean commonVideoBean) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, commonVideoBean.d());
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, commonVideoBean.a());
        bundle.putString("recommendtype", "1");
        bundle.putBoolean("doAnim", false);
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "seriesdetail");
        intent.putExtras(bundle);
        intent.setFlags(536870912);
        getActivity().startActivity(intent);
    }

    public void b(ArrayList<String> arrayList) {
        LogEx.d("DetailSeriesInfoFragment", "updateSeriesChildNameMixList=" + arrayList.toString());
        this.A = arrayList;
        if (this.w != null) {
            LogEx.d("DetailSeriesInfoFragment", "mHListViewShowAdapter.notifyDataSetChanged();");
            this.w.a();
        }
    }

    public void d(View view) {
        if (U() || this.V == null || com.zte.iptvclient.android.mobile.e0.f.a.a(this.h, view)) {
            return;
        }
        new com.zte.iptvclient.android.mobile.e0.b(getActivity(), this.G / 2.0f, new t()).a(view);
    }

    public void b(int i2, int i3) {
        this.y = i2 - 1;
        this.z = i3;
        LogEx.d("DetailSeriesInfoFragment", "updatePosition:mCurHLVewPosition" + this.y + " ,CurNavPosition" + i3);
        if (this.w == null || this.B.size() <= 0) {
            return;
        }
        LogEx.d("DetailSeriesInfoFragment", "mHListViewShowAdapter.notifyDataSetChanged();");
        this.w.a();
    }

    public ArrayList<String> d(int i2) {
        ArrayList<String> arrayList = new ArrayList<>();
        int i3 = 0;
        while (i3 < i2) {
            StringBuilder sb = new StringBuilder();
            i3++;
            sb.append(i3);
            sb.append("");
            arrayList.add(sb.toString());
        }
        LogEx.d("DetailSeriesInfoFragment", "gridShowList=" + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CommonVideoBean commonVideoBean) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, commonVideoBean.d());
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, commonVideoBean.a());
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_RECOMMENDTYPE, "1");
        bundle.putBoolean("doAnim", false);
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "moviedetail");
        intent.putExtras(bundle);
        intent.setFlags(536870912);
        getActivity().startActivity(intent);
    }

    public void b(boolean z2) {
        ImageView imageView = this.A0;
        if (imageView != null) {
            if (z2) {
                imageView.setBackgroundResource(R.drawable.play_push_new);
                this.A0.setEnabled(true);
            } else {
                imageView.setBackgroundResource(R.drawable.push_disable);
                this.A0.setEnabled(false);
            }
        }
    }

    public void a(ArrayList<String> arrayList, ArrayList<String> arrayList2, int i2, int i3) {
        SeriesEposideExpandView I;
        if (arrayList2 != null) {
            this.C = arrayList;
            this.B = arrayList2;
            this.z = i2;
            this.y = i3 - 1;
            com.zte.iptvclient.android.mobile.e0.e.i iVar = this.c0;
            if (iVar != null && (I = iVar.I()) != null) {
                I.a(Integer.valueOf(this.V.getSeriesnum()).intValue(), this.C, this.A, i(this.y + 1), h(this.y));
            }
        }
        LogEx.d("DetailSeriesInfoFragment", "updateSeriesChildListView= ,listSeriesNavNum=" + arrayList.toString() + " ,listSeriesNum=" + arrayList2 + " ,mCurNavPosition=" + i2 + " ,mCurHLVewPosition" + this.y);
    }

    public void a(d0 d0Var) {
        this.x = d0Var;
    }

    public void a(com.zte.iptvclient.android.mobile.e0.e.i iVar) {
        this.c0 = iVar;
    }

    public void a(SeriesEpisodeBean seriesEpisodeBean, Boolean... boolArr) {
        this.X = seriesEpisodeBean;
        if (TextUtils.equals(this.V.getIsprotection(), "0")) {
            this.V.setIsprotection(TextUtils.equals(seriesEpisodeBean.h(), "1") ? "1" : "0");
            if (boolArr.length <= 0 || boolArr[0].booleanValue()) {
            }
        }
    }

    public void a(ArrayList<CommonVideoBean> arrayList, int i2) {
        C0240k c0240k = null;
        if (i2 != 2) {
            if (i2 == 1) {
                if (arrayList != null && arrayList.size() != 0) {
                    this.Q.setAdapter((ListAdapter) new f0(this, this.h, arrayList, c0240k));
                    this.K.setVisibility(0);
                    return;
                } else {
                    this.K.setVisibility(8);
                    return;
                }
            }
            if (i2 == 0) {
                if (arrayList != null && arrayList.size() != 0) {
                    this.L.setVisibility(0);
                    this.R.setAdapter((ListAdapter) new f0(this, this.h, arrayList, c0240k));
                    return;
                } else {
                    this.L.setVisibility(8);
                    return;
                }
            }
            return;
        }
        if (arrayList != null && arrayList.size() != 0) {
            if (TextUtils.isEmpty(com.zte.iptvclient.android.common.k.o.j().f())) {
                this.S.setAdapter((ListAdapter) new g0(this, this.h, arrayList, c0240k));
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (i3 == 2) {
                        this.e0 = arrayList.get(i3).d();
                    }
                }
            } else {
                this.S.setAdapter((ListAdapter) new f0(this, this.h, arrayList, c0240k));
                String str = "";
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                for (int i4 = 0; i4 < arrayList.size() && i4 < 6; i4++) {
                    if (i4 == 0) {
                        str = arrayList.get(i4).d();
                    } else if (i4 == 1) {
                        str2 = arrayList.get(i4).d();
                    } else if (i4 == 2) {
                        str3 = arrayList.get(i4).d();
                    } else if (i4 == 3) {
                        str4 = arrayList.get(i4).d();
                    } else if (i4 == 4) {
                        str5 = arrayList.get(i4).d();
                    } else if (i4 == 5) {
                        str6 = arrayList.get(i4).d();
                    }
                }
                this.e0 = str + "," + str2 + "," + str3 + "," + str4 + "," + str5 + "," + str6;
            }
            this.M.setVisibility(0);
            return;
        }
        this.M.setVisibility(8);
    }

    public void a(GetUserStarRatingEntity getUserStarRatingEntity) {
        SeriesHeadBean seriesHeadBean = this.V;
        if (seriesHeadBean != null) {
            seriesHeadBean.setRatingnum(getUserStarRatingEntity.f7632b);
            this.V.setRatingsum(getUserStarRatingEntity.f7631a);
            c0();
        }
    }

    public void a(e0 e0Var) {
        this.K0 = e0Var;
    }

    public void a(SeriesHeadBean seriesHeadBean) {
        if (this.h1.size() > 0) {
            return;
        }
        String seriesprogramcode = seriesHeadBean.getSeriesprogramcode();
        String programcode = seriesHeadBean.getProgramcode();
        String seriestype = seriesHeadBean.getSeriestype();
        LogEx.d("DetailSeriesInfoFragment", "---obtainAllSeasonPhone---seriesprogramcode : " + seriesprogramcode + " , programcode : " + programcode);
        SDKVodMgr sDKVodMgr = new SDKVodMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("seriestype", "3");
        hashMap.put("seriesprogramcode", seriesprogramcode);
        sDKVodMgr.getSeriesChildlList(hashMap, new u(programcode, seriesHeadBean, seriestype));
    }

    public void e(int i2) {
        this.v.post(new s(i2));
    }
}
