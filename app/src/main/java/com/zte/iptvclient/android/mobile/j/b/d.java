package com.zte.iptvclient.android.mobile.j.b;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.cache.SDKCacheMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.customview.a.a.e.l;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.javabean.StbVideoBean;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.favorite.ui.FavoriteView;
import com.zte.iptvclient.android.zala.R;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FavoriteStbFragment.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b implements FavoriteView.c {
    private ArrayList<StbVideoBean> A;
    private ArrayList<FavoriteView> B;
    private ImageView C;
    private RelativeLayout D;
    private AnimationDrawable E;
    private com.zte.iptvclient.android.mobile.j.b.a p;
    private SmartRefreshLayout q;
    private RelativeLayout r;
    private TextView s;
    private LinearLayout t;
    private ArrayList<StbVideoBean> u;
    private h v;
    private String w;
    public l x;
    private StbVideoBean y;
    private ArrayList<StbVideoBean> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteStbFragment.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteStbFragment.java */
    /* loaded from: classes.dex */
    public class b implements l.h {
        b() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.l.h
        public void c() {
            d.this.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteStbFragment.java */
    /* loaded from: classes.dex */
    public class c implements com.scwang.smartrefresh.layout.d.c {
        c() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            if (!TextUtils.isEmpty(d.this.w)) {
                d.this.P();
            } else {
                hVar.c(2000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteStbFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.j.b.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0288d implements f.c {
        C0288d() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            d.this.Q();
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteStbFragment.java */
    /* loaded from: classes.dex */
    public class e implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            String str2;
            String str3 = "FavoriteStbFragment";
            LogEx.d("FavoriteStbFragment", "sdkQuerystbFavorite success = " + str);
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
                if (d.this.u != null) {
                    d.this.u.clear();
                } else {
                    d.this.u = new ArrayList();
                }
                int i = 0;
                while (i < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    JSONArray jSONArray2 = jSONArray;
                    StbVideoBean stbVideoBean = new StbVideoBean();
                    if (jSONObject.has("contentcode")) {
                        str2 = str3;
                        try {
                            stbVideoBean.setContentcode(jSONObject.getString("contentcode"));
                        } catch (Exception e) {
                            e = e;
                            LogEx.e(str2, e.getMessage());
                            d.this.M();
                            d.this.p.K();
                        }
                    } else {
                        str2 = str3;
                    }
                    if (jSONObject.has("favoritetype")) {
                        stbVideoBean.setFavoritetype(jSONObject.getString("favoritetype"));
                    }
                    if (jSONObject.has("posterurl")) {
                        stbVideoBean.setPosterurl(jSONObject.getString("posterurl"));
                    }
                    if (jSONObject.has("updatetime")) {
                        stbVideoBean.setUpdatetime(jSONObject.getString("updatetime"));
                    }
                    if (jSONObject.has("programcode")) {
                        stbVideoBean.setProgramcode(jSONObject.getString("programcode"));
                    }
                    if (jSONObject.has("programname")) {
                        stbVideoBean.setProgramname(jSONObject.getString("programname"));
                    }
                    if (jSONObject.has("isprotection")) {
                        stbVideoBean.setIsprotection(jSONObject.getString("isprotection"));
                    }
                    if (jSONObject.has("posterfileList")) {
                        stbVideoBean.setPosterfileList(jSONObject.getString("posterfileList"));
                    }
                    if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE)) {
                        stbVideoBean.setTelecomcode(jSONObject.getString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE));
                    }
                    if (jSONObject.has("columncode")) {
                        stbVideoBean.setColumncode(jSONObject.getString("columncode"));
                    }
                    if (jSONObject.has("contentname")) {
                        stbVideoBean.setContentname(jSONObject.getString("contentname"));
                    }
                    d.this.u.add(stbVideoBean);
                    i++;
                    jSONArray = jSONArray2;
                    str3 = str2;
                }
                str2 = str3;
                SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.f4111d, d.this.u);
                d.this.T();
            } catch (Exception e2) {
                e = e2;
                str2 = str3;
            }
            d.this.M();
            d.this.p.K();
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("FavoriteStbFragment", "sdkQuerystbFavorite  failed = " + str + " ,arg1=" + i);
            d.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FavoriteStbFragment.java */
    /* loaded from: classes.dex */
    public static class f implements Comparator<StbVideoBean> {
        private f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(StbVideoBean stbVideoBean, StbVideoBean stbVideoBean2) {
            return Long.parseLong(stbVideoBean2.getUpdatetime()) - Long.parseLong(stbVideoBean.getUpdatetime()) > 0 ? 1 : -1;
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    private void L() {
        this.q.a(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        N();
        this.B.get(0).b(this.z, com.zte.iptvclient.android.common.i.a.a.a(R.string.this_week));
        this.B.get(1).b(this.A, com.zte.iptvclient.android.common.i.a.a.a(R.string.earlier));
        this.q.a();
        ArrayList<StbVideoBean> arrayList = this.u;
        if (arrayList != null && arrayList.size() > 0) {
            this.t.setVisibility(0);
            this.r.setVisibility(8);
        } else {
            this.t.setVisibility(8);
            this.r.setVisibility(0);
        }
        this.p.J();
    }

    private void N() {
        AnimationDrawable animationDrawable = this.E;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.E.stop();
        }
        this.D.setVisibility(8);
    }

    private void O() {
        l lVar = new l(this.h, false);
        this.x = lVar;
        lVar.a(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        ArrayList<StbVideoBean> arrayList = (ArrayList) SDKCacheMgr.getAsObject(com.zte.iptvclient.android.common.c.c.f4111d);
        this.u = arrayList;
        if (arrayList != null) {
            T();
            M();
            this.p.K();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("usercode", this.w);
        sDKNetHTTPRequest.setParam(ParamConst.COLUMN_INFO_RSP_PARENTCODE, this.w);
        sDKNetHTTPRequest.setParam("authinfo", f(com.zte.iptvclient.common.uiframe.a.d("UserID"), "1"));
        sDKNetHTTPRequest.setParam("favoritetype", "");
        sDKNetHTTPRequest.setParam("terminalflag", "2");
        sDKNetHTTPRequest.setParam("userToken", com.zte.iptvclient.common.uiframe.a.d("UserToken"));
        sDKNetHTTPRequest.setParam("cpid", "");
        String replace = "http://{epgdomain}/iptvepg/{frame}/queryfavoritelist.jsp".replace("http://{epgdomain}/iptvepg/{frame}/", i.f());
        LogEx.d("FavoriteStbFragment", "url = " + replace);
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.startRequest(replace, "GET", new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        String a2;
        if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
            l lVar = this.x;
            if (lVar != null) {
                if (lVar.isShowing()) {
                    this.x.dismiss();
                    return;
                } else {
                    this.x.show();
                    this.x.a();
                    return;
                }
            }
            return;
        }
        StbVideoBean stbVideoBean = this.y;
        if (stbVideoBean != null) {
            if ("1".equals(stbVideoBean.getIsprotection())) {
                a2 = com.zte.iptvclient.android.mobile.h.a.b.b(this.y.getContentcode(), this.y.getContentcode(), "1", this.y.getContentcode(), this.y.getContentcode(), this.y.getContentcode());
            } else {
                a2 = com.zte.iptvclient.android.mobile.h.a.b.a(this.y.getContentcode(), this.y.getContentcode(), "2", this.y.getContentcode(), "0", this.y.getContentcode(), this.y.getContentcode(), "1", this.y.getContentcode());
            }
            LogEx.d("FavoriteStbFragment", "urlDLNATemp = " + a2);
            com.zte.iptvclient.android.mobile.h.a.a.g().c(a2);
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.hava_pushed_to_stb_play);
        }
    }

    private void R() {
        if (this.E != null) {
            this.D.setVisibility(0);
            this.E.start();
        }
    }

    private void S() {
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.no_rights_push_to_stb);
        com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.h, R.drawable.custom_dialog_title_img, 0, R.drawable.custom_dialog_button_blue, R.string.push, 0, R.drawable.custom_dialog_button_blue, R.string.common_cancel, 0, new C0288d());
        fVar.a(a2);
        fVar.a();
        fVar.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        ArrayList<StbVideoBean> arrayList = this.z;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.z = new ArrayList<>();
        }
        ArrayList<StbVideoBean> arrayList2 = this.A;
        if (arrayList2 != null) {
            arrayList2.clear();
        } else {
            this.A = new ArrayList<>();
        }
        if (this.u == null) {
            this.u = new ArrayList<>();
        }
        Collections.sort(this.u, new f(null));
        for (int i = 0; i < this.u.size(); i++) {
            Date e2 = e(x.c(this.u.get(i).getUpdatetime(), "yyyyMMddHHmmss", "yyyy.MM.dd HH:mm:ss", 1), "yyyy.MM.dd HH:mm:ss");
            if (e2 != null) {
                if (a(Long.valueOf(e2.getTime()))) {
                    this.z.add(this.u.get(i));
                } else {
                    this.A.add(this.u.get(i));
                }
            } else {
                this.A.add(this.u.get(i));
            }
        }
    }

    public ArrayList<StbVideoBean> I() {
        ArrayList<StbVideoBean> arrayList = this.u;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void J() {
        this.u = new ArrayList<>();
        this.z = new ArrayList<>();
        this.A = new ArrayList<>();
        boolean k = new h(this.h).k();
        this.B = new ArrayList<>();
        FavoriteView favoriteView = new FavoriteView(this.h);
        favoriteView.a(this, this.z, com.zte.iptvclient.android.common.i.a.a.a(R.string.this_week), k);
        favoriteView.a(this);
        this.t.addView(favoriteView);
        FavoriteView favoriteView2 = new FavoriteView(this.h);
        favoriteView2.a(this, this.A, com.zte.iptvclient.android.common.i.a.a.a(R.string.earlier), k);
        favoriteView2.a(this);
        this.t.addView(favoriteView2);
        this.B.add(favoriteView);
        this.B.add(favoriteView2);
    }

    public boolean K() {
        ArrayList<StbVideoBean> arrayList = this.u;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        J();
        L();
        O();
        if (!TextUtils.isEmpty(this.w)) {
            R();
            this.q.postDelayed(new a(), 500L);
        } else {
            M();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h hVar = new h(this.h);
        this.v = hVar;
        this.w = hVar.j();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.favorite_stb_fragment_layout, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        N();
    }

    private void d(View view) {
        this.q = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.r = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.t = (LinearLayout) view.findViewById(R.id.fl_container);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.r.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.r.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.r.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.r.findViewById(R.id.refresh_image));
        this.r.setVisibility(8);
        TextView textView = (TextView) this.r.findViewById(R.id.txt_pullrefresh);
        this.s = textView;
        textView.setText(this.h.getString(R.string.there_is_no_collection_yet));
        this.q.a(new DefaultRefreshHeader(this.h));
        this.q.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.q;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.q;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.q.a(true);
        this.q.c(false);
        this.C = (ImageView) view.findViewById(R.id.img_animation_loading);
        this.D = (RelativeLayout) view.findViewById(R.id.rl_loading);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        this.E = (AnimationDrawable) this.C.getDrawable();
    }

    private static String f(String str, String str2) {
        String str3;
        String str4 = str + "$$";
        Calendar calendar = Calendar.getInstance();
        calendar.add(11, 1);
        String str5 = str2 + "$$";
        byte[] bArr = new byte[0];
        try {
            bArr = (str4 + (Long.toHexString(calendar.getTimeInMillis() / 1000) + "$$") + str5 + com.zte.iptvclient.android.common.k.a.a(10)).getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        try {
            str3 = com.zte.iptvclient.android.common.k.a.c(bArr, AES.getEncryptKey("impkey").getBytes("utf-8"));
        } catch (Exception e3) {
            e3.printStackTrace();
            str3 = "";
        }
        String str6 = str3 != null ? str3 : "";
        LogEx.d("encryptionAES", "encriptStr: " + str6);
        return str6;
    }

    private void g(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "seriesdetail");
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }

    public void b(boolean z) {
        this.B.get(0).a(this, this.z, com.zte.iptvclient.android.common.i.a.a.a(R.string.this_week), z);
        this.B.get(1).a(this, this.A, com.zte.iptvclient.android.common.i.a.a.a(R.string.earlier), z);
    }

    public Date e(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(com.zte.iptvclient.android.mobile.j.b.a aVar) {
        this.p = aVar;
    }

    private boolean a(Long l) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(3);
        calendar.setTime(new Date(l.longValue()));
        return calendar.get(3) == i;
    }

    private void b(StbVideoBean stbVideoBean) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, stbVideoBean.getProgramcode());
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "moviedetail");
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }

    @Override // com.zte.iptvclient.android.mobile.favorite.ui.FavoriteView.c
    public void a(StbVideoBean stbVideoBean) {
        if (this.p.I()) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.please_delete_on_stb);
            return;
        }
        this.y = stbVideoBean;
        if (!StringUtil.isEmptyString(stbVideoBean.getProgramcode())) {
            String favoritetype = stbVideoBean.getFavoritetype();
            if (favoritetype != null) {
                if (favoritetype.equals("1")) {
                    if (StringUtil.isEmptyString(stbVideoBean.getProgramcode())) {
                        return;
                    }
                    b(stbVideoBean);
                    return;
                }
                String programcode = stbVideoBean.getProgramcode();
                String columncode = stbVideoBean.getColumncode();
                LogEx.i(columncode, columncode);
                if (programcode == null && columncode == null) {
                    return;
                }
                g(programcode, columncode);
                return;
            }
            return;
        }
        S();
    }
}
