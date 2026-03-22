package com.zte.iptvclient.android.mobile.j.b;

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
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.cache.SDKCacheMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.favorite.SDKFavoriteMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.javabean.models.VoDBean;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.mobile.favorite.ui.FavoriteView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FavoriteMobileFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private ArrayList<FavoriteView> A;
    private ImageView B;
    private RelativeLayout C;
    private AnimationDrawable D;
    private h E;
    private com.zte.iptvclient.android.mobile.j.b.a p;
    private ArrayList<VoDBean> q;
    private ArrayList<VoDBean> r;
    private ArrayList<VoDBean> s;
    private SmartRefreshLayout t;
    private RelativeLayout u;
    private TextView v;
    private LinearLayout w;
    private boolean x = true;
    private boolean y = false;
    private int z = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteMobileFragment.java */
    /* loaded from: classes.dex */
    public class a implements com.scwang.smartrefresh.layout.d.c {
        a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            if (b.this.p.I()) {
                hVar.c(2000);
            } else {
                b.this.O();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteMobileFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.j.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0286b implements SDKFavoriteMgr.OnDelFavoriteReturnListener {
        C0286b() {
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnDelFavoriteReturnListener
        public void onDelFavoriteReturn(String str, String str2) {
            if (TextUtils.equals(str, "0")) {
                ArrayList<VoDBean> b2 = ((FavoriteView) b.this.A.get(0)).b();
                if (b2 != null && b2.size() > 0) {
                    b.this.r.removeAll(b2);
                    b.this.q.removeAll(b2);
                }
                ArrayList<VoDBean> b3 = ((FavoriteView) b.this.A.get(1)).b();
                if (b3 != null && b3.size() > 0) {
                    b.this.s.removeAll(b3);
                    b.this.q.removeAll(b3);
                }
                Iterator it2 = b.this.A.iterator();
                while (it2.hasNext()) {
                    ((FavoriteView) it2.next()).a();
                }
                b.this.p.e(0);
                b.this.p.d(0);
                b.this.y = false;
                b.this.p.b(false);
                b.this.p.L();
                b.this.S();
                SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.f4110c + b.this.E.V(), b.this.q);
                b.this.p.K();
                return;
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a("2131624325 " + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteMobileFragment.java */
    /* loaded from: classes.dex */
    public class c implements SDKFavoriteMgr.OnUserFavoriteListReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnUserFavoriteListReturnListener
        public void onUserFavoriteListReturn(String str, String str2, String str3) {
            LogEx.d("FavoriteMobileFragment", " returncode : " + str + ", errormsg : " + str2 + ", data : " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        b.this.q.add(VoDBean.a(jSONArray.getJSONObject(i)));
                    }
                    SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.f4110c + b.this.E.V(), b.this.q);
                } catch (Exception e) {
                    LogEx.e("FavoriteMobileFragment", e.getMessage());
                }
                b.this.V();
            }
            b.this.T();
            b.this.S();
            b.this.p.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoriteMobileFragment.java */
    /* loaded from: classes.dex */
    public class d implements t.e {
        d() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void b() {
            b.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.A.get(0).a(this.r, com.zte.iptvclient.android.common.i.a.a.a(R.string.this_week));
        this.A.get(1).a(this.s, com.zte.iptvclient.android.common.i.a.a.a(R.string.earlier));
        this.x = true;
        this.t.a();
        if (this.q.size() == 0) {
            this.u.setVisibility(0);
            this.w.setVisibility(8);
            this.p.N();
        } else {
            this.u.setVisibility(8);
            this.w.setVisibility(0);
        }
        this.p.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        AnimationDrawable animationDrawable = this.D;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.D.stop();
        }
        this.C.setVisibility(8);
    }

    private void U() {
        ArrayList<VoDBean> arrayList = this.q;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.q = new ArrayList<>();
        }
        this.x = false;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("favoritetype", "1,4");
        new SDKFavoriteMgr().getUserFavoriteList(hashMap, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        ArrayList<VoDBean> arrayList = this.r;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.r = new ArrayList<>();
        }
        ArrayList<VoDBean> arrayList2 = this.s;
        if (arrayList2 != null) {
            arrayList2.clear();
        } else {
            this.s = new ArrayList<>();
        }
        for (int i = 0; i < this.q.size(); i++) {
            Date e = e(this.q.get(i).l(), "yyyy.MM.dd HH:mm:ss");
            if (e != null) {
                if (a(Long.valueOf(e.getTime()))) {
                    this.r.add(this.q.get(i));
                } else {
                    this.s.add(this.q.get(i));
                }
            } else {
                this.s.add(this.q.get(i));
            }
        }
    }

    protected void I() {
        ArrayList arrayList = new ArrayList();
        Iterator<FavoriteView> it2 = this.A.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(it2.next().b());
        }
        ArrayList arrayList2 = new ArrayList(this.q);
        if (arrayList.size() == 0) {
            return;
        }
        try {
            arrayList2.removeAll(arrayList);
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            for (int i = 0; i < arrayList.size(); i++) {
                VoDBean voDBean = (VoDBean) arrayList.get(i);
                stringBuffer.append(voDBean.d());
                stringBuffer2.append(voDBean.c());
                stringBuffer3.append(voDBean.f());
                if (i != arrayList.size() - 1) {
                    stringBuffer.append(",");
                    stringBuffer2.append(",");
                    stringBuffer3.append(",");
                }
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("contentcodes", stringBuffer.toString());
            hashMap.put("columncodes", stringBuffer2.toString());
            hashMap.put(ParamConst.FAVORITE_DELETE_BATCH_REQ_FAVORITETYPES, stringBuffer3.toString());
            new SDKFavoriteMgr().doDelFavorite(hashMap, new C0286b());
        } catch (Exception e) {
            LogEx.d("FavoriteMobileFragment", e.getMessage());
        }
    }

    public int J() {
        Iterator<FavoriteView> it2 = this.A.iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += it2.next().b().size();
        }
        return i;
    }

    public int K() {
        return this.q.size();
    }

    public ArrayList<VoDBean> L() {
        return this.q;
    }

    public void M() {
        boolean k = new h(this.h).k();
        this.A = new ArrayList<>();
        FavoriteView favoriteView = new FavoriteView(this.h);
        favoriteView.a(this, this.r, com.zte.iptvclient.android.common.i.a.a.a(R.string.this_week), k);
        this.w.addView(favoriteView);
        FavoriteView favoriteView2 = new FavoriteView(this.h);
        favoriteView2.a(this, this.s, com.zte.iptvclient.android.common.i.a.a.a(R.string.earlier), k);
        this.w.addView(favoriteView2);
        this.A.add(favoriteView);
        this.A.add(favoriteView2);
    }

    public boolean N() {
        ArrayList<VoDBean> arrayList = this.q;
        return arrayList != null && arrayList.size() > 0;
    }

    public void O() {
        ArrayList<VoDBean> arrayList = (ArrayList) SDKCacheMgr.getAsObject(com.zte.iptvclient.android.common.c.c.f4110c + this.E.V());
        this.q = arrayList;
        if (arrayList != null) {
            V();
            S();
            this.p.K();
        } else {
            this.q = new ArrayList<>();
            Q();
        }
        if (this.x) {
            U();
        }
    }

    public void P() {
        this.t.a(new a());
    }

    public void Q() {
        if (this.D != null) {
            this.C.setVisibility(0);
            this.D.start();
        }
    }

    public void R() {
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_delete_items);
        int J = J();
        this.z = J;
        if (J == 1) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_delete_item);
        }
        t.a(this.h, a2, new d());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.E = new h(this.h);
        M();
        P();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d("FavoriteMobileFragment", "FavoriteFragment create");
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.s = new ArrayList<>();
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.favorite_mobile_layout, viewGroup, false);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        LogEx.d("FavoriteMobileFragment", "Favorite onDestroy");
        EventBus.getDefault().unregister(this);
        T();
        super.onDestroy();
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.m.b bVar) {
        if (this.y) {
            return;
        }
        O();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        O();
    }

    public void b(boolean z) {
        this.A.get(0).a(this, this.r, com.zte.iptvclient.android.common.i.a.a.a(R.string.this_week), z);
        this.A.get(1).a(this, this.s, com.zte.iptvclient.android.common.i.a.a.a(R.string.earlier), z);
    }

    public void c(boolean z) {
        Iterator<FavoriteView> it2 = this.A.iterator();
        while (it2.hasNext()) {
            it2.next().a(z);
        }
    }

    public void d(boolean z) {
        Iterator<FavoriteView> it2 = this.A.iterator();
        while (it2.hasNext()) {
            it2.next().b(z);
        }
        this.y = z;
    }

    public void e(int i) {
        this.p.e(i);
    }

    public void a(com.zte.iptvclient.android.mobile.j.b.a aVar) {
        this.p = aVar;
    }

    public Date e(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.ENGLISH);
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean a(Long l) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(3);
        calendar.setTime(new Date(l.longValue()));
        return calendar.get(3) == i;
    }

    public void d(View view) {
        this.t = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.w = (LinearLayout) view.findViewById(R.id.fl_container);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.u = relativeLayout;
        f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        f.a(this.u.findViewById(R.id.img_pullrefresh_icon));
        f.a(this.u.findViewById(R.id.txt_pullrefresh));
        f.a(this.u.findViewById(R.id.refresh_image));
        this.u.setVisibility(8);
        TextView textView = (TextView) this.u.findViewById(R.id.txt_pullrefresh);
        this.v = textView;
        textView.setText(this.h.getString(R.string.there_is_no_collection_yet));
        this.t.a(new DefaultRefreshHeader(this.h));
        this.t.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.t;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.t;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.t.a(true);
        this.t.c(false);
        this.B = (ImageView) view.findViewById(R.id.img_animation_loading);
        this.C = (RelativeLayout) view.findViewById(R.id.rl_loading);
        f.a(this.B);
        f.a(this.C);
        this.D = (AnimationDrawable) this.B.getDrawable();
    }

    public void d(int i) {
        this.p.d(i);
    }
}
