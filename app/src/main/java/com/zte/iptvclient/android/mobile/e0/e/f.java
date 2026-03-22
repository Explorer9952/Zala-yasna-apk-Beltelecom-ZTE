package com.zte.iptvclient.android.mobile.e0.e;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.video.androidsdk.common.PortalConst;
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
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.gridview.RecomeGridView;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.javabean.models.VoDBean;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.e0.b;
import com.zte.iptvclient.android.mobile.vod.entity.GetUserStarRatingEntity;
import com.zte.iptvclient.android.mobile.vod.entity.QueryStarRatingEntity;
import com.zte.iptvclient.android.mobile.x.b.c.b;
import com.zte.iptvclient.android.zala.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DetailMovieInfoFragment.java */
/* loaded from: classes.dex */
public class f extends com.zte.fragmentlib.b {
    private RelativeLayout A;
    private String A0;
    private Button B;
    private String B0;
    private LinearLayout C;
    private TextView C0;
    private RelativeLayout D;
    private ImageView D0;
    private LinearLayout E;
    private RelativeLayout E0;
    private RelativeLayout F;
    private TextView F0;
    private LinearLayout G;
    private TextView G0;
    private boolean H0;
    private RelativeLayout J;
    private com.zte.iptvclient.android.mobile.e0.e.g J0;
    private RecomeGridView K;
    private FrameLayout K0;
    private RecomeGridView L;
    private LinearLayout L0;
    private RecomeGridView M;
    private View O;
    private ScrollView P;
    private FrameLayout Q;
    private View R;
    private View S;
    private View U;
    private RelativeLayout V;
    private ImageView W;
    private TextView X;
    private FrameLayout Y;
    private LinearLayout Z;
    private RelativeLayout a0;
    private ImageView b0;
    private TextView c0;
    private LinearLayout d0;
    private ImageView e0;
    private ImageView f0;
    private ImageView g0;
    private ImageView h0;
    private ImageView i0;
    private ImageView j0;
    private x k0;
    private LinearLayout l0;
    private ImageView m0;
    private TextView n0;
    private TextView o0;
    private VideoDetailBean p;
    private TextView p0;
    private com.zte.iptvclient.android.mobile.e0.e.d q;
    private TextView q0;
    private TextView r0;
    protected com.zte.iptvclient.android.common.j.h s;
    private TextView s0;
    private TextView t;
    private TextView t0;
    private TextView u;
    private RelativeLayout u0;
    private TextView v;
    private ImageView v0;
    private TextView w;
    private TextView w0;
    private TextView x;
    private TextView x0;
    private String y0;
    private String z0;
    public Bitmap r = null;
    private float y = 0.0f;
    private String z = "";
    private long N = 0;
    private boolean T = false;
    private boolean I0 = false;
    private y M0 = new y(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.q != null) {
                if (f.this.q.O) {
                    f.this.t("0");
                } else {
                    f.this.t("1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.q != null) {
                if (f.this.q.O) {
                    f.this.t("0");
                } else {
                    f.this.t("1");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a() || f.this.q == null) {
                return;
            }
            f.this.q.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zte.iptvclient.android.common.player.multiplay.a.c().a().clear();
            com.zte.iptvclient.android.common.javabean.f a2 = com.zte.iptvclient.android.common.player.multiplay.a.a(f.this.p);
            if (a2 != null && !com.zte.iptvclient.android.common.player.multiplay.a.c().a(a2)) {
                com.zte.iptvclient.android.common.player.multiplay.a.c().a().add(0, a2);
                if (com.zte.iptvclient.android.common.player.multiplay.a.c().a().size() > 4) {
                    com.zte.iptvclient.android.common.player.multiplay.a.c().a().remove(4);
                }
            }
            com.zte.iptvclient.android.mobile.a0.b.b bVar = new com.zte.iptvclient.android.mobile.a0.b.b();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isMultiScreenMode", true);
            bundle.putBoolean("doAnim", true);
            bVar.setArguments(bundle);
            f.this.a(bVar);
            if (f.this.k0 != null) {
                f.this.k0.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.d(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.e0.e.f$f, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0232f implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        C0232f() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("DetailMovieInfoFragment", "sdkDoStarRating onDataReturn,s= " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!"0".equals(jSONObject.getString("returncode"))) {
                    f.this.M0.sendEmptyMessage(36873);
                } else {
                    GetUserStarRatingEntity a2 = GetUserStarRatingEntity.a(jSONObject);
                    Message obtain = Message.obtain();
                    obtain.what = 36872;
                    obtain.obj = a2;
                    f.this.M0.sendMessage(obtain);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                f.this.M0.sendEmptyMessage(36873);
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("DetailMovieInfoFragment", "sdkDoStarRating onFailReturn,s= " + str);
            f.this.M0.sendEmptyMessage(36873);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class g implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5911a;

        g(String str) {
            this.f5911a = str;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("DetailMovieInfoFragment", "onDataReturn s = " + str);
            try {
                if ("0".equals(new JSONObject(str).optString("returncode"))) {
                    Message obtain = Message.obtain();
                    obtain.what = 36865;
                    obtain.obj = this.f5911a;
                    f.this.M0.sendMessage(obtain);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("DetailMovieInfoFragment", "onFailReturn i = " + i + "  s = " + str);
            f.this.M0.sendEmptyMessage(36866);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class h implements DialogInterface.OnClickListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ((com.zte.fragmentlib.b) f.this).h.getSupportFragmentManager().F();
            ((MainActivity) ((com.zte.fragmentlib.b) f.this).h).y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class i implements DialogInterface.OnClickListener {
        i(f fVar) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class j extends com.bumptech.glide.q.j.g<Bitmap> {
        j(f fVar) {
        }

        public void a(Bitmap bitmap, com.bumptech.glide.q.i.c<? super Bitmap> cVar) {
        }

        @Override // com.bumptech.glide.q.j.j
        public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.q.i.c cVar) {
            a((Bitmap) obj, (com.bumptech.glide.q.i.c<? super Bitmap>) cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.e(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class m implements b.InterfaceC0216b {
        m() {
        }

        @Override // com.zte.iptvclient.android.mobile.e0.b.InterfaceC0216b
        public void a(float f) {
            f.this.d((int) (f * 2.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class n implements SDKFavoriteMgr.OnAddFavoriteReturnListener {
        n() {
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnAddFavoriteReturnListener
        public void onAddFavoriteReturn(String str, String str2) {
            LogEx.d("DetailMovieInfoFragment", "onAddFavoriteReturn " + str);
            if (!TextUtils.equals(str, "0")) {
                f.this.M0.sendEmptyMessage(36868);
            } else {
                LogEx.d("DetailMovieInfoFragment", "add favourite success");
                f.this.M0.sendEmptyMessage(36867);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class o implements SDKFavoriteMgr.OnDelFavoriteReturnListener {
        o() {
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnDelFavoriteReturnListener
        public void onDelFavoriteReturn(String str, String str2) {
            LogEx.d("DetailMovieInfoFragment", "onDelFavoriteReturn " + str);
            if (TextUtils.equals(str, "0")) {
                f.this.M0.sendEmptyMessage(36869);
            } else {
                f.this.M0.sendEmptyMessage(36874);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.e(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.e(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class r implements View.OnClickListener {

        /* compiled from: DetailMovieInfoFragment.java */
        /* loaded from: classes2.dex */
        class a implements b.d {
            a() {
            }

            @Override // com.zte.iptvclient.android.mobile.x.b.c.b.d
            public void a(int i) {
                String format;
                String str;
                f fVar = f.this;
                Bitmap bitmap = fVar.r;
                if (bitmap == null) {
                    bitmap = BitmapFactory.decodeResource(((com.zte.fragmentlib.b) fVar).h.getResources(), R.drawable.share_img);
                }
                Bitmap bitmap2 = bitmap;
                String c2 = com.zte.iptvclient.common.uiframe.a.c("Share_Video_Title");
                if (!TextUtils.isEmpty(f.this.p.getProgramname()) && !TextUtils.isEmpty(c2) && c2.contains("$CONTENTNAME$")) {
                    format = String.format(c2.replace("$CONTENTNAME$", "%1$s"), f.this.p.getProgramname());
                } else {
                    format = String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.share_message), f.this.w.getText().toString());
                }
                String str2 = format;
                long currentPosition = (CommonFunc.getPlayer() != null ? CommonFunc.getPlayer().getCurrentPosition() : 0L) / 1000;
                long j = i;
                int i2 = currentPosition < j ? 0 : (int) (currentPosition - j);
                String c3 = com.zte.iptvclient.common.uiframe.a.c("APP_Share_URL");
                if (TextUtils.isEmpty(c3)) {
                    str = null;
                } else {
                    str = c3 + String.format("?pcode=%1$s,%2$s,%3$d,%4$d,%5$s&ptype=0", f.this.p.getProgramcode(), "2", Integer.valueOf(i2), Integer.valueOf(i), f.this.z);
                }
                String str3 = str;
                String str4 = com.zte.iptvclient.android.common.i.a.a.a(R.string.share_content_title) + com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name);
                LogEx.d("DetailMovieInfoFragment", "shareURL=" + str3);
                if (((com.zte.fragmentlib.b) f.this).h != null) {
                    new com.zte.iptvclient.android.mobile.x.b.c.c(((com.zte.fragmentlib.b) f.this).h, str2, str3, null, str4, bitmap2, null, f.this.p.getProgramcode()).a(f.this.O);
                }
            }
        }

        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.p == null || com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            if (!"1".equals(ConfigMgr.readPropertie("SupportFaceBook"))) {
                new com.zte.iptvclient.android.mobile.x.b.c.b(((com.zte.fragmentlib.b) f.this).h, new a()).a(f.this.O);
                return;
            }
            LogEx.d("DetailMovieInfoFragment", "SerIpAddress ==" + SDKLoginMgr.getInstance().getUserInfo("SerIpAddress"));
            LogEx.d("DetailMovieInfoFragment", "eas_dns=" + com.zte.iptvclient.common.uiframe.a.c("EAS_Domain"));
            String str = com.zte.iptvclient.common.uiframe.a.c("Share_Link_Address") + "?vt=" + f.this.p.getProgramtype() + "&vc=" + f.this.p.getProgramcode();
            String charSequence = f.this.w.getText().toString();
            if (!TextUtils.isEmpty(f.this.p.getProgramname())) {
                charSequence = f.this.p.getProgramname();
            }
            String str2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.let_us_watch) + " " + charSequence + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.on_app_click_link_below);
            f fVar = f.this;
            Bitmap bitmap = fVar.r;
            Bitmap decodeResource = bitmap == null ? BitmapFactory.decodeResource(((com.zte.fragmentlib.b) fVar).h.getResources(), R.drawable.share_img) : bitmap;
            String description = f.this.p.getDescription();
            if (((com.zte.fragmentlib.b) f.this).h != null) {
                String c2 = com.zte.iptvclient.android.common.k.g.c(f.this.H0 ? 9 : 3, f.this.p.getPosterfilelist());
                LogEx.d("DetailMovieInfoFragment", "strImgUrl = " + c2);
                LogEx.d("DetailMovieInfoFragment", "title = " + str2);
                new com.zte.iptvclient.android.mobile.x.b.c.c(((com.zte.fragmentlib.b) f.this).h, description, str, c2, str2, decodeResource, null, f.this.p.getProgramcode()).a(f.this.O);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.p == null || f.this.P() || f.this.q == null) {
                return;
            }
            f.this.q.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class t implements View.OnClickListener {

        /* compiled from: DetailMovieInfoFragment.java */
        /* loaded from: classes2.dex */
        class a implements t.d {
            a(t tVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) f.this).h, new a(this));
            } else {
                if (f.this.p == null) {
                    return;
                }
                Bundle bundle = new Bundle();
                Intent intent = new Intent(f.this.getActivity(), (Class<?>) HostActivity.class);
                bundle.putString("fragmenttype", "fragment_bt_comment");
                bundle.putString("contentCode", f.this.p.getContentcode());
                intent.putExtras(bundle);
                if (f.this.H0) {
                    f.this.q.L();
                } else {
                    f.this.startActivity(intent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class u implements View.OnClickListener {

        /* compiled from: DetailMovieInfoFragment.java */
        /* loaded from: classes2.dex */
        class a implements t.d {
            a(u uVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) f.this).h, new a(this));
            } else if (f.this.p != null) {
                if (TextUtils.equals(f.this.p.getIsfavourite(), "1")) {
                    f.this.S();
                } else {
                    f.this.R();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class v implements View.OnClickListener {

        /* compiled from: DetailMovieInfoFragment.java */
        /* loaded from: classes2.dex */
        class a implements t.d {
            a(v vVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        /* compiled from: DetailMovieInfoFragment.java */
        /* loaded from: classes2.dex */
        class b implements t.e {
            b() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void b() {
                f.this.V();
            }
        }

        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ("1".equals(ConfigMgr.readPropertie("isShowInConstructionTip"))) {
                com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) f.this).h);
                return;
            }
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (f.this.T) {
                    if (f.this.P() || f.this.p == null) {
                        return;
                    }
                    if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 3) {
                        if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                            f.this.Q();
                            return;
                        } else if (!com.zte.iptvclient.android.mobile.download.helper.c.c.b()) {
                            f.this.W();
                            return;
                        }
                    }
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) ((com.zte.fragmentlib.b) f.this).h.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        String typeName = activeNetworkInfo.getTypeName();
                        if (typeName.equalsIgnoreCase("mobile")) {
                            com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) f.this).h, com.zte.iptvclient.android.common.i.a.a.a(R.string.permit_2G_3G_network_download_confirm), new b());
                            return;
                        } else {
                            if (typeName.equalsIgnoreCase("WIFI")) {
                                f.this.V();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.lownlaod_enable_tip));
                return;
            }
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            com.zte.iptvclient.android.common.k.t.a(((com.zte.fragmentlib.b) f.this).h, new a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class w implements View.OnClickListener {

        /* compiled from: DetailMovieInfoFragment.java */
        /* loaded from: classes2.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.I();
            }
        }

        w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.P() || f.this.p == null) {
                return;
            }
            com.zte.iptvclient.android.mobile.e0.e.g gVar = new com.zte.iptvclient.android.mobile.e0.e.g();
            Bundle bundle = new Bundle();
            bundle.putSerializable("VideoDetailBean", f.this.p);
            gVar.setArguments(bundle);
            f.this.K0.setVisibility(0);
            f.this.L0.setVisibility(8);
            f.this.a(R.id.detail_ifo_layout_container, gVar);
            gVar.e(f.this.A0, f.this.B0);
            if (((com.zte.fragmentlib.b) f.this).h != null) {
                if (f.this.U != null) {
                    f.this.Y.removeView(f.this.U);
                } else {
                    f fVar = f.this;
                    fVar.U = LayoutInflater.from(((com.zte.fragmentlib.b) fVar).h).inflate(R.layout.detail_middle_video_title_for_phone, (ViewGroup) null);
                    f fVar2 = f.this;
                    fVar2.V = (RelativeLayout) fVar2.U.findViewById(R.id.rl_close_img_for_phone);
                    f.this.V.setOnClickListener(new a());
                    f fVar3 = f.this;
                    fVar3.W = (ImageView) fVar3.U.findViewById(R.id.img_close);
                    f fVar4 = f.this;
                    fVar4.X = (TextView) fVar4.U.findViewById(R.id.tv_video_title_name);
                    com.zte.iptvclient.common.uiframe.f.a(f.this.U);
                    com.zte.iptvclient.common.uiframe.f.a(f.this.V);
                    com.zte.iptvclient.common.uiframe.f.a(f.this.W);
                    com.zte.iptvclient.common.uiframe.f.a(f.this.X);
                }
                f.this.X.setText(f.this.p.getProgramname());
                f.this.Y.addView(f.this.U);
            }
        }
    }

    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes.dex */
    public interface x {
        void a();
    }

    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    private static final class y extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<f> f5930a;

        public y(f fVar) {
            this.f5930a = new WeakReference<>(fVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            f fVar = this.f5930a.get();
            if (fVar == null) {
                return;
            }
            switch (message.what) {
                case 36865:
                    if ("0".equals((String) message.obj)) {
                        LogEx.d("DetailMovieInfoFragment", "mDelete success");
                        fVar.q.b(false);
                    } else {
                        LogEx.d("DetailMovieInfoFragment", "add success");
                        fVar.q.b(true);
                    }
                    fVar.N();
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.q.a());
                    return;
                case 36866:
                default:
                    return;
                case 36867:
                    fVar.p.setIsfavourite("1");
                    ArrayList arrayList = (ArrayList) SDKCacheMgr.getAsObject(com.zte.iptvclient.android.common.c.c.f4110c + fVar.s.V());
                    if (arrayList != null) {
                        arrayList.add(new VoDBean(fVar.p));
                    }
                    SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.f4110c + fVar.s.V(), arrayList);
                    fVar.M();
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.m.b());
                    return;
                case 36868:
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.add_favourite_msg5));
                    return;
                case 36869:
                    fVar.p.setIsfavourite("0");
                    fVar.u(fVar.p.getProgramcode());
                    fVar.L();
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.m.b());
                    return;
                case 36870:
                    QueryStarRatingEntity queryStarRatingEntity = (QueryStarRatingEntity) message.obj;
                    if (queryStarRatingEntity != null) {
                        if (queryStarRatingEntity.f7649a != null) {
                            fVar.p.setRatingnum(queryStarRatingEntity.f7649a);
                        }
                        if (queryStarRatingEntity.f7650b != null) {
                            fVar.p.setRatingsum(queryStarRatingEntity.f7650b);
                        }
                        fVar.a(fVar.p);
                        return;
                    }
                    return;
                case 36871:
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.rating_failed));
                    return;
                case 36872:
                    GetUserStarRatingEntity getUserStarRatingEntity = (GetUserStarRatingEntity) message.obj;
                    Fragment parentFragment = fVar.getParentFragment();
                    if (parentFragment instanceof com.zte.iptvclient.android.mobile.e0.e.d) {
                        ((com.zte.iptvclient.android.mobile.e0.e.d) parentFragment).a(getUserStarRatingEntity);
                    }
                    com.zte.iptvclient.android.mobile.e0.f.e.b(com.zte.iptvclient.android.common.i.a.a.a(R.string.rating_success));
                    return;
                case 36873:
                    com.zte.iptvclient.android.mobile.e0.f.e.b(com.zte.iptvclient.android.common.i.a.a.a(R.string.rating_failed));
                    return;
                case 36874:
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.del_favourite_msg));
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class z extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<CommonVideoBean> f5931a;

        /* renamed from: b, reason: collision with root package name */
        private LayoutInflater f5932b;

        /* renamed from: c, reason: collision with root package name */
        private Activity f5933c;

        /* compiled from: DetailMovieInfoFragment.java */
        /* loaded from: classes2.dex */
        private class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            private CommonVideoBean f5935a;

            public a(CommonVideoBean commonVideoBean) {
                this.f5935a = commonVideoBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((((com.zte.fragmentlib.b) f.this).h instanceof MainActivity) && ((MainActivity) ((com.zte.fragmentlib.b) f.this).h).s()) {
                    return;
                }
                z.this.a(this.f5935a);
            }
        }

        /* compiled from: DetailMovieInfoFragment.java */
        /* loaded from: classes2.dex */
        class b {

            /* renamed from: a, reason: collision with root package name */
            ImageView f5937a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f5938b;

            /* renamed from: c, reason: collision with root package name */
            TextView f5939c;

            /* renamed from: d, reason: collision with root package name */
            TextView f5940d;

            b(z zVar) {
            }
        }

        public z(Activity activity, ArrayList<CommonVideoBean> arrayList) {
            this.f5931a = arrayList;
            this.f5933c = activity;
            this.f5932b = (LayoutInflater) activity.getSystemService("layout_inflater");
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<CommonVideoBean> arrayList = this.f5931a;
            if (arrayList == null) {
                LogEx.d("DetailMovieInfoFragment", "getCount is null!");
                return 0;
            }
            if (arrayList.size() > 6) {
                LogEx.d("DetailMovieInfoFragment", "getCount=" + this.f5931a.size());
                return 6;
            }
            LogEx.d("DetailMovieInfoFragment", "getCount=" + this.f5931a.size());
            return this.f5931a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            ArrayList<CommonVideoBean> arrayList = this.f5931a;
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
                view2 = this.f5932b.inflate(R.layout.home_video_item, (ViewGroup) null);
                bVar.f5937a = (ImageView) view2.findViewById(R.id.poster_img);
                bVar.f5938b = (ImageView) view2.findViewById(R.id.ivi_logo_top);
                bVar.f5939c = (TextView) view2.findViewById(R.id.title_txt);
                bVar.f5940d = (TextView) view2.findViewById(R.id.rating_txt);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.home_video_item_fl));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.img_rlayout));
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.rating_rl));
                com.zte.iptvclient.common.uiframe.f.a(bVar.f5940d);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f5937a);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f5938b);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f5939c);
                view2.setTag(bVar);
            } else {
                b bVar2 = (b) view.getTag();
                bVar2.f5937a.setImageResource(R.drawable.default_poster_thumb);
                view2 = view;
                bVar = bVar2;
            }
            CommonVideoBean commonVideoBean = this.f5931a.get(i);
            if (commonVideoBean != null) {
                if (commonVideoBean.b().equals("ivi")) {
                    bVar.f5938b.setVisibility(0);
                    bVar.f5938b.setImageDrawable(this.f5933c.getResources().getDrawable(R.drawable.ivi_logo));
                } else if (commonVideoBean.b().equals("Megogo")) {
                    bVar.f5938b.setVisibility(0);
                    bVar.f5938b.setImageDrawable(this.f5933c.getResources().getDrawable(R.drawable.megogo_logo));
                } else {
                    bVar.f5938b.setVisibility(8);
                }
                String a2 = com.zte.iptvclient.android.common.k.g.a(f.this.H0 ? 9 : 3, commonVideoBean.c());
                if (!TextUtils.isEmpty(a2) && a2.contains("/image")) {
                    int indexOf = a2.indexOf("/image", 1);
                    a2 = com.zte.iptvclient.android.common.f.b.i.g() + a2.substring(indexOf);
                }
                LogEx.d("DetailMovieInfoFragment", "postimg url = " + a2);
                if (((com.zte.fragmentlib.b) f.this).h != null && !((com.zte.fragmentlib.b) f.this).h.isFinishing()) {
                    com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.a((FragmentActivity) ((com.zte.fragmentlib.b) f.this).h).a(a2);
                    a3.b(R.drawable.default_poster_thumb);
                    a3.a(R.drawable.default_poster_thumb);
                    a3.c(300);
                    a3.a(bVar.f5937a);
                }
                bVar.f5939c.setText(commonVideoBean.e());
                if (commonVideoBean.k() != null) {
                    try {
                        float parseInt = Integer.parseInt(r11) * 1.0f;
                        if (parseInt > 0.0f) {
                            String valueOf = String.valueOf(parseInt);
                            if (valueOf != null) {
                                bVar.f5940d.setText(valueOf);
                                bVar.f5940d.setVisibility(0);
                            } else {
                                bVar.f5940d.setVisibility(4);
                            }
                        }
                    } catch (Exception e) {
                        LogEx.d("UseeTv", e.getMessage());
                    }
                }
                bVar.f5937a.setOnClickListener(new a(this.f5931a.get(i)));
            }
            return view2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CommonVideoBean commonVideoBean) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.i());
            String f = commonVideoBean.f();
            if (TextUtils.isEmpty(f)) {
                return;
            }
            if ("1".equals(f)) {
                Bundle bundle = new Bundle();
                bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, commonVideoBean.d());
                bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, commonVideoBean.a());
                bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_RECOMMENDTYPE, "1");
                bundle.putBoolean("doAnim", false);
                Intent intent = new Intent(f.this.getActivity(), (Class<?>) HostActivity.class);
                bundle.putString("fragmenttype", "moviedetail");
                intent.putExtras(bundle);
                intent.setFlags(536870912);
                f.this.getActivity().startActivity(intent);
                return;
            }
            if ("14".equals(f)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, commonVideoBean.d());
                bundle2.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, commonVideoBean.a());
                bundle2.putString("recommendtype", "1");
                bundle2.putBoolean("doAnim", false);
                Intent intent2 = new Intent(f.this.getActivity(), (Class<?>) HostActivity.class);
                bundle2.putString("fragmenttype", "seriesdetail");
                intent2.putExtras(bundle2);
                intent2.setFlags(536870912);
                f.this.getActivity().startActivity(intent2);
                return;
            }
            if ("10".equals(f)) {
                Bundle bundle3 = new Bundle();
                bundle3.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, commonVideoBean.i());
                bundle3.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, commonVideoBean.a());
                bundle3.putString(MovieDetailBundleBean.SERIES_BUNDLEPARAMS_SERIES_NUM, commonVideoBean.h());
                Intent intent3 = new Intent(f.this.getActivity(), (Class<?>) HostActivity.class);
                bundle3.putString("fragmenttype", "seriesdetail");
                intent3.putExtras(bundle3);
                intent3.setFlags(536870912);
                f.this.getActivity().startActivity(intent3);
            }
        }
    }

    private void U() {
        this.D.setOnClickListener(new k());
        this.J.setOnClickListener(new p());
        this.F.setOnClickListener(new q());
        this.i0.setOnClickListener(new r());
        this.m0.setOnClickListener(new s());
        this.v0.setOnClickListener(new t());
        this.e0.setOnClickListener(new u());
        this.h0.setOnClickListener(new v());
        this.A.setOnClickListener(new w());
        this.B.setOnClickListener(new a());
        this.B.setOnClickListener(new b());
        this.g0.setOnClickListener(new c());
        this.a0.setOnClickListener(new d());
        this.f0.setOnClickListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (this.p == null) {
            return;
        }
        com.zte.iptvclient.android.mobile.i.b.i iVar = new com.zte.iptvclient.android.mobile.i.b.i();
        Bundle bundle = new Bundle();
        bundle.putSerializable("VideoBean", this.p);
        iVar.setArguments(bundle);
        a(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        com.zte.iptvclient.android.common.customview.a.a.a.a aVar = new com.zte.iptvclient.android.common.customview.a.a.a.a(this.h);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setTitle(R.string.stb_login_failed_title);
        aVar.a(R.string.stb_login_failed_info);
        aVar.b(R.string.confirm, new i(this));
        aVar.show();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = new com.zte.iptvclient.android.common.j.h(this.h);
        EventBus.getDefault().register(this);
        this.H0 = BaseApp.f();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.detail_move_info_fragment, viewGroup, false);
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        inflate.requestFocus();
        e(inflate);
        U();
        this.O = inflate;
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.b0.g.a aVar) {
        this.I0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z2) {
        super.onHiddenChanged(z2);
        if (z2 || !this.I0) {
            return;
        }
        LogEx.d("DetailMovieInfoFragment", "onHiddenChanged comment success to notify");
        this.I0 = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieInfoFragment.java */
    /* loaded from: classes2.dex */
    public class l implements com.bumptech.glide.q.f<String, Bitmap> {
        l() {
        }

        @Override // com.bumptech.glide.q.f
        public boolean a(Exception exc, String str, com.bumptech.glide.q.j.j<Bitmap> jVar, boolean z) {
            LogEx.d("DetailMovieInfoFragment", "loaded bitmap image  is onException");
            return false;
        }

        @Override // com.bumptech.glide.q.f
        public boolean a(Bitmap bitmap, String str, com.bumptech.glide.q.j.j<Bitmap> jVar, boolean z, boolean z2) {
            LogEx.d("DetailMovieInfoFragment", "loaded bitmap image  is onResourceReady");
            f.this.r = bitmap;
            return false;
        }
    }

    private void O() {
        this.d0.findViewById(R.id.rl_function_play_push).setVisibility(8);
        this.d0.findViewById(R.id.rl_function_favorite).setVisibility(8);
        this.d0.findViewById(R.id.rl_function_score).setVisibility(8);
        this.d0.findViewById(R.id.rl_function_share).setVisibility(8);
        this.d0.findViewById(R.id.rl_function_comment).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.N <= 500) {
            LogEx.w("UseeTv", "Operate limit,less than 500(ms)!");
            return true;
        }
        this.N = currentTimeMillis;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        com.zte.iptvclient.android.common.customview.a.a.a.a aVar = new com.zte.iptvclient.android.common.customview.a.a.a.a(this.h);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setTitle(R.string.not_connected_stb);
        aVar.a(R.string.connect_hc100_stb_prompt);
        aVar.b(R.string.confirm, new h());
        aVar.a(R.string.common_cancel, null);
        aVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        String str = "1".equals(SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_IS_SHARE)) ? "1" : "0";
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("favoritetype", "1");
        hashMap.put("contentcode", this.p.getContentcode());
        hashMap.put("columncode", this.p.getColumncode());
        hashMap.put("isshared", str);
        new SDKFavoriteMgr().doAddFavorite(hashMap, new n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ParamConst.FAVORITE_DELETE_BATCH_REQ_FAVORITETYPES, "1");
        hashMap.put("contentcodes", this.p.getContentcode());
        hashMap.put("columncodes", this.p.getColumncode());
        new SDKFavoriteMgr().doDelFavorite(hashMap, new o());
    }

    private void T() {
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            O();
        }
    }

    private void e(View view) {
        int i2;
        int i3;
        LinearLayout.LayoutParams layoutParams;
        this.Y = (FrameLayout) view.findViewById(R.id.fl_oper_bar_container);
        this.Z = (LinearLayout) view.findViewById(R.id.ll_detail_function_menu);
        if (this.H0) {
            int a2 = com.zte.iptvclient.android.common.k.g.a(getContext(), 40.0f);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.Y.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = a2;
                this.Y.setLayoutParams(layoutParams2);
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.Z.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.height = a2;
                this.Z.setLayoutParams(layoutParams3);
            }
        }
        this.a0 = (RelativeLayout) view.findViewById(R.id.rl_more_screen_watching);
        if ("1".equals(ConfigMgr.readPropertie("ForbiddenMulScreenPlay", "0"))) {
            this.a0.setVisibility(4);
        }
        this.b0 = (ImageView) view.findViewById(R.id.iv_more_screen_watching);
        TextView textView = (TextView) view.findViewById(R.id.tv_more_screen_watching);
        this.c0 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multi_play_title));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_right_function_menu);
        this.d0 = linearLayout;
        if (this.H0) {
            int childCount = linearLayout.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = this.d0.getChildAt(0);
                if ((childAt instanceof ImageView) && (layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams()) != null) {
                    layoutParams.height = com.zte.iptvclient.android.common.k.g.a(getContext(), 25.0f);
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_function_trailer);
        this.m0 = imageView;
        imageView.setEnabled(false);
        this.m0.setBackgroundResource(R.drawable.icon_trailer_white);
        this.j0 = (ImageView) view.findViewById(R.id.iv_function_rating);
        this.e0 = (ImageView) view.findViewById(R.id.iv_function_favorite);
        this.g0 = (ImageView) view.findViewById(R.id.iv_function_play_push);
        this.h0 = (ImageView) view.findViewById(R.id.iv_function_download);
        this.i0 = (ImageView) view.findViewById(R.id.iv_function_share);
        this.l0 = (LinearLayout) view.findViewById(R.id.video_detail_bottom_btn_rating);
        view.findViewById(R.id.rl_function_score).setVisibility(0);
        this.f0 = (ImageView) view.findViewById(R.id.iv_function_score);
        this.u0 = (RelativeLayout) view.findViewById(R.id.rl_function_comment);
        K();
        this.v0 = (ImageView) view.findViewById(R.id.iv_function_comment);
        this.w0 = (TextView) view.findViewById(R.id.txt_imdb);
        this.x0 = (TextView) view.findViewById(R.id.txt_kino_poisk);
        this.C0 = (TextView) view.findViewById(R.id.txt_price);
        this.D0 = (ImageView) view.findViewById(R.id.iv_rating_pic);
        this.E0 = (RelativeLayout) this.l0.findViewById(R.id.rl_duration_wrapper);
        this.F0 = (TextView) this.l0.findViewById(R.id.txt_movie_duration);
        this.G0 = (TextView) this.l0.findViewById(R.id.txt_movie_release_year);
        this.g0.setBackgroundResource(R.drawable.push_disable);
        this.g0.setEnabled(false);
        com.zte.iptvclient.common.uiframe.f.a(this.Y);
        com.zte.iptvclient.common.uiframe.f.a(this.Z);
        com.zte.iptvclient.common.uiframe.f.a(this.a0);
        com.zte.iptvclient.common.uiframe.f.a(this.b0);
        com.zte.iptvclient.common.uiframe.f.a(this.c0);
        com.zte.iptvclient.common.uiframe.f.a(this.d0);
        com.zte.iptvclient.common.uiframe.f.a(this.m0);
        com.zte.iptvclient.common.uiframe.f.a(this.j0);
        com.zte.iptvclient.common.uiframe.f.a(this.e0);
        com.zte.iptvclient.common.uiframe.f.a(this.f0);
        com.zte.iptvclient.common.uiframe.f.a(this.g0);
        com.zte.iptvclient.common.uiframe.f.a(this.h0);
        com.zte.iptvclient.common.uiframe.f.a(this.i0);
        com.zte.iptvclient.common.uiframe.f.a(this.l0);
        com.zte.iptvclient.common.uiframe.f.a(this.v0);
        com.zte.iptvclient.common.uiframe.f.a(this.w0);
        com.zte.iptvclient.common.uiframe.f.a(this.x0);
        com.zte.iptvclient.common.uiframe.f.a(this.C0);
        com.zte.iptvclient.common.uiframe.f.a(this.D0);
        com.zte.iptvclient.common.uiframe.f.a(this.F0);
        com.zte.iptvclient.common.uiframe.f.a(this.G0);
        this.E0.setVisibility(8);
        this.G0.setVisibility(8);
        this.j0.setVisibility(8);
        this.A = (RelativeLayout) view.findViewById(R.id.rl_introduction);
        this.w = (TextView) view.findViewById(R.id.txt_summary);
        this.x = (TextView) view.findViewById(R.id.txt_summary_sum);
        TextView textView2 = (TextView) view.findViewById(R.id.introduction_more);
        this.t0 = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_introduction));
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_summary_title));
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_introduction_more));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.introduction_more));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.more_icon));
        Button button = (Button) view.findViewById(R.id.btn_order);
        this.B = button;
        com.zte.iptvclient.common.uiframe.f.a(button);
        TextView textView3 = (TextView) view.findViewById(R.id.rec_director_text);
        this.n0 = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_rel_dir));
        TextView textView4 = (TextView) view.findViewById(R.id.rec_director_more_txt);
        this.o0 = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.more));
        TextView textView5 = (TextView) view.findViewById(R.id.rec_stars_text);
        this.p0 = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_rel_stars));
        TextView textView6 = (TextView) view.findViewById(R.id.rec_stars_more_txt);
        this.q0 = textView6;
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.more));
        TextView textView7 = (TextView) view.findViewById(R.id.mb_likes_text);
        this.r0 = textView7;
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rec_may_likes));
        TextView textView8 = (TextView) view.findViewById(R.id.mb_likes_more_txt);
        this.s0 = textView8;
        textView8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.more));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_comment));
        ScrollView scrollView = (ScrollView) view.findViewById(R.id.video_detail_scrollv);
        this.P = scrollView;
        com.zte.iptvclient.common.uiframe.f.a(scrollView);
        this.Q = (FrameLayout) view.findViewById(R.id.detail_info_hd);
        this.R = view.findViewById(R.id.detail_movie_separate_line);
        com.zte.iptvclient.common.uiframe.f.a(this.Q);
        com.zte.iptvclient.common.uiframe.f.a(this.R);
        View findViewById = view.findViewById(R.id.separate_line);
        this.S = findViewById;
        com.zte.iptvclient.common.uiframe.f.a(findViewById);
        this.C = (LinearLayout) view.findViewById(R.id.llRecDirector_contaioner);
        this.E = (LinearLayout) view.findViewById(R.id.llRecStars_contaioner);
        this.G = (LinearLayout) view.findViewById(R.id.llMb_Likes_contaioner);
        this.D = (RelativeLayout) view.findViewById(R.id.rl_rec_directo_header);
        this.F = (RelativeLayout) view.findViewById(R.id.rl_rec_stars_header);
        this.J = (RelativeLayout) view.findViewById(R.id.rl_mb_likes_header);
        this.t = (TextView) view.findViewById(R.id.rec_director_text);
        this.K = (RecomeGridView) view.findViewById(R.id.video_detail_rec_director_grid);
        this.u = (TextView) view.findViewById(R.id.rec_stars_text);
        this.L = (RecomeGridView) view.findViewById(R.id.video_detail_rec_stars_grid);
        this.v = (TextView) view.findViewById(R.id.mb_likes_text);
        this.M = (RecomeGridView) view.findViewById(R.id.video_detail_mb_likes_grid);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.K);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.L);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.M);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.G);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.re_scro_view));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_rec_directo_header));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_director_more_llayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_director_more_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_director_more_img));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_rec_stars_header));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_stars_more_llayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_stars_more_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rec_stars_more_img));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_mb_likes_header));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.mb_likes_more_llayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.mb_likes_more_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.mb_likes_more_img));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.recomment_contaioner));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.llRecDirector_contaioner));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.llRecStars_contaioner));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.llMb_Likes_contaioner));
        if (!"on".equals(ConfigMgr.readPropertie("DownloadModuleSwith")) || "0".equals(ConfigMgr.readPropertie("IsSupportDownload"))) {
            i2 = 8;
            this.h0.setVisibility(8);
        } else {
            i2 = 8;
        }
        if (TextUtils.equals(ConfigMgr.readPropertie("IsShowTrailer"), "1")) {
            this.m0.setVisibility(0);
        } else {
            this.m0.setVisibility(i2);
        }
        if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
            this.j0.setVisibility(i2);
            this.e0.setVisibility(0);
            this.m0.setVisibility(0);
            this.g0.setVisibility(0);
            this.i0.setVisibility(0);
            this.l0.setVisibility(i2);
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.S.getLayoutParams();
            if (layoutParams4 != null) {
                layoutParams4.height = com.zte.iptvclient.android.common.k.g.a(this.h, 1.0f);
                this.S.setLayoutParams(layoutParams4);
            }
            if (this.H0) {
                this.a0.setVisibility(8);
                this.P.setVisibility(8);
                this.R.setVisibility(0);
                this.Q.setVisibility(0);
                com.zte.iptvclient.android.mobile.e0.e.g gVar = new com.zte.iptvclient.android.mobile.e0.e.g();
                this.J0 = gVar;
                gVar.a(this.q);
                a(R.id.detail_info_hd, this.J0);
                LogEx.d("DetailMovieInfoFragment", "is AT PAD");
            } else {
                this.a0.setVisibility(8);
                this.R.setVisibility(8);
                this.Q.setVisibility(8);
                LogEx.d("DetailMovieInfoFragment", "is AT Phone");
            }
            i3 = 0;
        } else {
            i3 = 0;
            this.l0.setVisibility(0);
            this.R.setVisibility(i2);
            this.Q.setVisibility(i2);
            LogEx.d("DetailMovieInfoFragment", "is not AT version");
        }
        this.l0.setVisibility(i3);
        this.K0 = (FrameLayout) view.findViewById(R.id.detail_ifo_layout_container);
        this.L0 = (LinearLayout) view.findViewById(R.id.ll_phone_indicate_container);
        if (!this.H0) {
            if (TextUtils.isEmpty(this.A0)) {
                this.w0.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating), "--"));
            } else {
                this.w0.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating), com.zte.iptvclient.android.common.k.w.b(this.A0)));
            }
            if (TextUtils.isEmpty(this.B0)) {
                this.x0.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating_kinopoisk), "--"));
            } else {
                this.x0.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating_kinopoisk), com.zte.iptvclient.android.common.k.w.b(this.B0)));
            }
        }
        T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        String replace = "http://{ipadd:port}/iptvepg/{frame}/sdk_upcomingset.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f());
        LogEx.d("DetailMovieInfoFragment", "addSubscribe url = " + replace);
        String d2 = com.zte.iptvclient.common.uiframe.a.d("UserToken");
        String d3 = com.zte.iptvclient.common.uiframe.a.d("UserID");
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Recommend_Server_CpCode");
        LogEx.d("DetailMovieInfoFragment", "contentmediacode = " + c2 + " contentcode =  " + this.p.getContentcode());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("usertoken", d2);
        sDKNetHTTPRequest.setParam("usercode", d3);
        sDKNetHTTPRequest.setParam("action", str);
        sDKNetHTTPRequest.setParam("contentcode", this.p.getContentcode());
        sDKNetHTTPRequest.setParam("contentname", this.p.getProgramname());
        sDKNetHTTPRequest.setParam("contentmediacode", c2);
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.startRequest(replace, "GET", new g(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str) {
        ArrayList arrayList = (ArrayList) SDKCacheMgr.getAsObject(com.zte.iptvclient.android.common.c.c.f4110c + this.s.V());
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size() && TextUtils.equals(((VoDBean) arrayList.get(i2)).h(), str); i2++) {
                arrayList.remove(i2);
            }
        }
        SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.f4110c + this.s.V(), arrayList);
    }

    public void I() {
        if (this.L0.getVisibility() == 0) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof com.zte.iptvclient.android.mobile.e0.e.d) {
                ((com.zte.iptvclient.android.mobile.e0.e.d) parentFragment).D();
                return;
            }
            return;
        }
        this.Y.removeView(this.U);
        J();
    }

    public void J() {
        this.K0.setVisibility(8);
        this.L0.setVisibility(0);
        this.K0.removeAllViews();
    }

    public void K() {
        if (com.zte.iptvclient.android.mobile.e0.f.b.b()) {
            this.u0.setVisibility(0);
        } else {
            this.u0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L() {
        this.e0.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_normal));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M() {
        this.e0.setBackground(c.a.a.a.d.b.d().d(R.drawable.function_fav_selected));
    }

    public void N() {
        com.zte.iptvclient.android.mobile.e0.e.d dVar = this.q;
        if (dVar != null) {
            if (dVar.N) {
                this.B.setVisibility(0);
                if (this.q.O) {
                    this.B.setBackgroundResource(R.drawable.detail_online_has_order);
                    this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_reminder_booked));
                    return;
                } else {
                    this.B.setBackgroundResource(R.drawable.detail_online_order);
                    this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_reminder_booking));
                    return;
                }
            }
            this.B.setVisibility(8);
        }
    }

    public void d(int i2) {
        String valueOf = String.valueOf(i2);
        VideoDetailBean videoDetailBean = this.p;
        if (videoDetailBean != null) {
            String contentcode = videoDetailBean.getContentcode();
            String programtype = this.p.getProgramtype();
            if (StringUtil.isEmptyString(contentcode) || StringUtil.isEmptyString(programtype)) {
                return;
            }
            String replace = "http://{ipadd:port}/iptvepg/{frame}/dostarrating.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f());
            LogEx.d("DetailMovieInfoFragment", "sdkDoStarRating url: " + replace);
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
            sDKNetHTTPRequest.setCharset("gbk");
            sDKNetHTTPRequest.setParam("contentcode", contentcode);
            sDKNetHTTPRequest.setParam("contenttype", programtype);
            sDKNetHTTPRequest.setParam("starrating", valueOf);
            sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_GET, new C0232f());
        }
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.j.a aVar) {
        this.w.setText(this.p.getProgramname());
        LogEx.d("DetailMovieInfoFragment", "UnLockBlockTitleEvent event");
    }

    public void s(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.m0.setEnabled(true);
            this.m0.setBackgroundResource(R.drawable.function_trailer_normal);
        } else {
            this.m0.setEnabled(false);
            this.m0.setBackgroundResource(R.drawable.icon_trailer_white);
        }
    }

    public void b(VideoDetailBean videoDetailBean) {
        com.zte.iptvclient.android.mobile.e0.e.g gVar;
        this.p = videoDetailBean;
        if (videoDetailBean == null || !this.H0 || (gVar = this.J0) == null) {
            return;
        }
        gVar.a(videoDetailBean);
    }

    public void b(String str, String str2, String str3, String str4) {
        this.y0 = str;
        this.z0 = str2;
        if (!TextUtils.isEmpty(str3)) {
            this.A0 = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            this.B0 = str4;
        }
        if (this.H0) {
            com.zte.iptvclient.android.mobile.e0.e.g gVar = this.J0;
            if (gVar != null) {
                gVar.e(this.A0, this.B0);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            this.w0.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating), "--"));
        } else {
            this.w0.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating), com.zte.iptvclient.android.common.k.w.b(str3)));
        }
        if (TextUtils.isEmpty(str4)) {
            this.x0.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating_kinopoisk), "--"));
        } else {
            this.x0.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating_kinopoisk), com.zte.iptvclient.android.common.k.w.b(str4)));
        }
    }

    public void a(x xVar) {
        this.k0 = xVar;
    }

    public void a(com.zte.iptvclient.android.mobile.e0.e.d dVar) {
        this.q = dVar;
    }

    public void a(VideoDetailBean videoDetailBean) {
        com.zte.iptvclient.android.mobile.e0.e.g gVar;
        TextView I;
        com.zte.iptvclient.android.mobile.e0.e.g gVar2;
        TextView I2;
        String str;
        String str2;
        if (videoDetailBean == null) {
            return;
        }
        this.p = videoDetailBean;
        if (videoDetailBean != null) {
            if (TextUtils.isEmpty(videoDetailBean.getRatingsum()) && (str2 = this.y0) != null) {
                this.p.setRatingsum(str2);
            }
            if (TextUtils.isEmpty(this.p.getRatingnum()) && (str = this.z0) != null) {
                this.p.setRatingnum(str);
            }
        }
        N();
        this.w.setText(this.p.getProgramname());
        if (!TextUtils.isEmpty(this.p.getPrice())) {
            try {
                Double valueOf = Double.valueOf(this.p.getPrice());
                if (valueOf.doubleValue() > 0.0d) {
                    this.C0.setText(com.zte.iptvclient.android.common.k.w.c(valueOf.doubleValue()) + com.zte.iptvclient.android.common.i.a.a.a(R.string.money_unit_sign));
                } else {
                    this.C0.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.price_free));
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        com.zte.iptvclient.android.common.k.p.a(this.D0, this.p.getRatingid());
        if (!TextUtils.isEmpty(this.p.getVideoelapsedtime())) {
            this.E0.setVisibility(0);
            this.F0.setText(com.zte.iptvclient.android.common.k.k.b(this.p.getVideoelapsedtime()));
        }
        if (!TextUtils.isEmpty(this.p.getReleasedate())) {
            this.G0.setVisibility(0);
            this.G0.setText(this.p.getReleasedate());
        }
        float f = 0.0f;
        if ("1".equals(ConfigMgr.readPropertie("IsShowDefaultRatingFunction"))) {
            if (!TextUtils.isEmpty(this.p.getStarlevel())) {
                try {
                    f = Integer.parseInt(this.p.getStarlevel()) * 1.0f;
                } catch (Exception e3) {
                    LogEx.e("DetailMovieInfoFragment", "getStartLevel getException=" + e3.getMessage());
                    e3.printStackTrace();
                }
            }
            String format = String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating), com.zte.iptvclient.android.common.k.w.a(f));
            this.x.setText(format);
            if (this.H0 && (gVar2 = this.J0) != null && (I2 = gVar2.I()) != null) {
                I2.setText(format);
            }
        } else {
            float a2 = com.zte.iptvclient.android.mobile.e0.f.k.a(videoDetailBean.getRatingsum(), videoDetailBean.getRatingnum());
            this.y = a2 < 0.0f ? 0.0f : a2;
            if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
                String a3 = a2 < 0.0f ? "--" : com.zte.iptvclient.android.common.k.w.a(a2);
                this.x.setText(a3);
                if (this.H0 && (gVar = this.J0) != null && (I = gVar.I()) != null) {
                    I.setText(a3);
                }
            }
        }
        if (TextUtils.equals(this.p.getIsfavourite(), "1")) {
            M();
        } else {
            L();
        }
        String a4 = com.zte.iptvclient.android.common.k.g.a(this.H0 ? 9 : 3, this.p.getPosterfilelist());
        LogEx.d("DetailMovieInfoFragment", "load bitmap image url is " + a4);
        SupportActivity supportActivity = this.h;
        if (supportActivity == null || supportActivity.isFinishing()) {
            return;
        }
        com.bumptech.glide.b<String> f2 = com.bumptech.glide.i.a((FragmentActivity) this.h).a(a4).f();
        f2.a(DiskCacheStrategy.NONE);
        f2.c();
        f2.a((com.bumptech.glide.q.f<? super String, TranscodeType>) new l());
        f2.a((com.bumptech.glide.b<String>) new j(this));
    }

    public void d(View view) {
        if (P() || this.p == null || com.zte.iptvclient.android.mobile.e0.f.a.a(this.h, view)) {
            return;
        }
        new com.zte.iptvclient.android.mobile.e0.b(getActivity(), this.y / 2.0f, new m()).a(view);
    }

    public void b(boolean z2) {
        ImageView imageView = this.g0;
        if (imageView != null) {
            if (z2) {
                imageView.setBackgroundResource(R.drawable.play_push_new);
                this.g0.setEnabled(true);
            } else {
                imageView.setBackgroundResource(R.drawable.push_disable);
                this.g0.setEnabled(false);
            }
        }
    }

    public void a(float f) {
        this.y = f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, ArrayList<CommonVideoBean> arrayList) {
        if (arrayList == null) {
            return;
        }
        if (i2 == 0 && arrayList.size() > 0) {
            this.C.setVisibility(0);
            this.K.setAdapter((ListAdapter) new z(this.h, arrayList));
            return;
        }
        if (i2 == 1 && arrayList.size() > 0) {
            this.E.setVisibility(0);
            this.L.setAdapter((ListAdapter) new z(this.h, arrayList));
            return;
        }
        if (i2 != 2 || arrayList.size() <= 0) {
            return;
        }
        this.G.setVisibility(0);
        this.M.setAdapter((ListAdapter) new z(this.h, arrayList));
        if (TextUtils.isEmpty(com.zte.iptvclient.android.common.k.o.j().f())) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (i3 == 2) {
                    this.z = arrayList.get(i3).d();
                }
            }
            return;
        }
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
        this.z = str + "," + str2 + "," + str3 + "," + str4 + "," + str5 + "," + str6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        if (P() || this.p == null) {
            return;
        }
        com.zte.iptvclient.android.mobile.l.b.b bVar = new com.zte.iptvclient.android.mobile.l.b.b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("VideoDetailBean", this.p);
        bundle.putInt("recommendType", i2);
        bVar.setArguments(bundle);
        a(bVar);
    }
}
