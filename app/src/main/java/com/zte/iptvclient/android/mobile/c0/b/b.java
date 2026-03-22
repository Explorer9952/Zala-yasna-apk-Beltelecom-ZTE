package com.zte.iptvclient.android.mobile.c0.b;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.service.SDKUserMgr;
import com.video.androidsdk.service.bean.UserProperties;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.c0.c.a;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MenuFragmentHD.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private LinearLayout p;
    private ImageView q;
    private TextView r;
    TextView s;
    private View t;
    private RecyclerView u;
    private com.zte.iptvclient.android.mobile.c0.c.a v;
    private List<com.zte.iptvclient.android.mobile.l.c.a.b> w;
    private h x;
    private Bundle z;
    private String y = "fragment_remote";
    private String A = "";
    private boolean B = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuFragmentHD.java */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5629a;

        a(b bVar, View view) {
            this.f5629a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            RelativeLayout relativeLayout = (RelativeLayout) this.f5629a.findViewById(R.id.top_container);
            int measuredWidth = relativeLayout.getMeasuredWidth();
            int measuredHeight = relativeLayout.getMeasuredHeight();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = measuredWidth;
                layoutParams.height = measuredHeight;
                relativeLayout.setLayoutParams(layoutParams);
            }
            relativeLayout.setBackgroundResource(R.drawable.bg_account_left_top_cornor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuFragmentHD.java */
    /* renamed from: com.zte.iptvclient.android.mobile.c0.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0198b implements View.OnClickListener {
        ViewOnClickListenerC0198b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.y = "bookmark";
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if ("1".equals(ConfigMgr.readPropertie("isShowAccount"))) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("isSideMenu", false);
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a("at_account", bundle));
            } else {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a("login", (Bundle) null));
            }
            b.this.v.e(-1);
            b.this.v.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuFragmentHD.java */
    /* loaded from: classes2.dex */
    public class c implements a.d {
        c() {
        }

        @Override // com.zte.iptvclient.android.mobile.c0.c.a.d
        public void a(View view, int i) {
            b bVar = b.this;
            bVar.y = ((com.zte.iptvclient.android.mobile.l.c.a.b) bVar.w.get(i)).f6764c;
            if ((((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.DOWNLOAD || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.REMOTER || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.FAVORITE || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.RECORDING || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.REMINDER || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.BOOKMARK || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.PARENTAL || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.PPV || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.BINDING || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.CONSUMPTIONRECORDS || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.PACKAGE || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.FEATUREPACKAGE || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.CHANNELLINEUP || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.BALANCE || ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.ORDER) && !com.zte.iptvclient.android.mobile.n.c.b.t()) {
                t.a((Context) ((com.zte.fragmentlib.b) b.this).h, false);
                return;
            }
            String str = ((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6764c;
            if (((com.zte.iptvclient.android.mobile.l.c.a.b) b.this.w.get(i)).f6762a == TabHostManager.TabName.PARENTAL) {
                if (b.this.x != null && b.this.x.C() && !b.this.B) {
                    b.this.d(i);
                    return;
                }
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a("parentcontral", (Bundle) null));
                b.this.v.e(i);
                b.this.v.d();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSideMenu", false);
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a(str, bundle));
            b.this.B = false;
            b.this.v.e(i);
            b.this.v.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuFragmentHD.java */
    /* loaded from: classes2.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f5632a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f5633b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f5634c;

        d(EditText editText, int i, com.zte.iptvclient.android.common.customview.a.a.a.b bVar) {
            this.f5632a = editText;
            this.f5633b = i;
            this.f5634c = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (TextUtils.equals(this.f5632a.getText().toString(), b.this.x.u())) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a("parentcontral", (Bundle) null));
                b.this.v.e(this.f5633b);
                b.this.v.d();
                this.f5634c.dismiss();
                b.this.B = true;
                return;
            }
            if ("2".equals(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_INNOVATIVE_SERVICE_FLAG))) {
                this.f5634c.dismiss();
            } else if (this.f5632a.getText() != null && !TextUtils.isEmpty(this.f5632a.getText())) {
                this.f5632a.setText("");
                this.f5634c.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.limitpwd_is_wrong));
            } else {
                this.f5634c.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_select_empty));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuFragmentHD.java */
    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f5636a;

        e(b bVar, com.zte.iptvclient.android.common.customview.a.a.a.b bVar2) {
            this.f5636a = bVar2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5636a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuFragmentHD.java */
    /* loaded from: classes2.dex */
    public class f implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        f() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("MineFragment", "QueryUserDetail  onDataReturn,arg0= " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    b.this.x.e(jSONObject.getString("bossuercode"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("MineFragment", "QueryUserDetail  onFailReturn,arg0= " + str + " ,arg1=" + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuFragmentHD.java */
    /* loaded from: classes2.dex */
    public class g implements SDKUserMgr.OnUserPropertiesReturnListener {
        g() {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnUserPropertiesReturnListener
        public void onUserPropertiesReturn(String str, String str2, UserProperties userProperties) {
            LogEx.d("MineFragment", "QueryUserInfo:  onDataReturn,arg0= " + str);
            if (TextUtils.equals(str, "0")) {
                try {
                    String trim = userProperties.getSwitchvalue().trim();
                    if (!TextUtils.isEmpty(trim)) {
                        String binaryString = Long.toBinaryString(Long.valueOf(trim).longValue());
                        boolean z = TextUtils.equals(binaryString.substring(binaryString.length() + (-16), binaryString.length() + (-15)), "1");
                        if (b.this.x != null) {
                            b.this.x.o(z);
                        }
                    }
                } catch (Exception e) {
                    LogEx.e("MineFragment", "getParentalCheck String form Json=" + e.getMessage());
                }
            }
            if (b.this.x == null || !b.this.x.C()) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a("parentcontral", b.this.z));
                com.zte.iptvclient.android.mobile.c0.c.a aVar = b.this.v;
                b bVar = b.this;
                aVar.e(bVar.s(bVar.y));
                b.this.v.d();
            } else {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a("fragment_remote", b.this.z));
                b bVar2 = b.this;
                bVar2.d(bVar2.s(bVar2.y));
                b.this.v.d();
            }
            b.this.O();
        }
    }

    private int I() {
        List<com.zte.iptvclient.android.mobile.l.c.a.b> list = this.w;
        int i = -1;
        if (list != null) {
            Iterator<com.zte.iptvclient.android.mobile.l.c.a.b> it2 = list.iterator();
            while (it2.hasNext()) {
                i++;
                if (TextUtils.equals(it2.next().f6764c, "download")) {
                    break;
                }
            }
        }
        return i;
    }

    private void J() {
    }

    private void K() {
        this.x = new h(this.h);
        ArrayList arrayList = new ArrayList();
        this.w = arrayList;
        arrayList.addAll(TabHostManager.g().d());
        for (int i = 0; i < this.w.size(); i++) {
            LogEx.d("MineFragment", "mMenuItems " + this.w.get(i).f);
        }
        this.v = new com.zte.iptvclient.android.mobile.c0.c.a(this.h, this.w, this.A);
        this.u.a(new LinearLayoutManager(this.h));
        this.u.a(this.v);
        if (com.zte.iptvclient.android.mobile.n.c.b.t() && "1".equals(ConfigMgr.readPropertie("isShowAccount"))) {
            this.v.e(0);
            this.v.d();
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a("fragment_remote", (Bundle) null));
        }
    }

    private void L() {
        new SDKUserMgr().getUserProperties(new g());
    }

    private void M() {
        String replace = "http://{epgdomain}/iptvepg/{frame}/sdk_getuserdetailcommon.jsp".replace("http://{epgdomain}/iptvepg/{frame}/", i.f());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "gbk");
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_GET, new f());
    }

    private void N() {
        this.p.setOnClickListener(new ViewOnClickListenerC0198b());
        this.v.a(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
            this.r.setVisibility(0);
            h hVar = this.x;
            if (hVar == null || TextUtils.isEmpty(hVar.V())) {
                return;
            }
            this.r.setText(this.x.V());
            return;
        }
        this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mine_guest_account_nsername));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s(String str) {
        List<com.zte.iptvclient.android.mobile.l.c.a.b> list = this.w;
        int i = -1;
        if (list != null) {
            Iterator<com.zte.iptvclient.android.mobile.l.c.a.b> it2 = list.iterator();
            while (it2.hasNext()) {
                i++;
                if (TextUtils.equals(it2.next().f6764c, str)) {
                    break;
                }
            }
        }
        return i;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.z = new Bundle();
        K();
        N();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        this.t = layoutInflater.inflate(R.layout.fragment_menu_hd, viewGroup, false);
        h hVar = new h(this.h);
        this.x = hVar;
        this.A = hVar.c();
        d(this.t);
        return this.t;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.f fVar) {
        LogEx.d("MineFragment", "mStrBalance=" + this.A);
        this.A = this.x.c();
        this.w.clear();
        this.w.addAll(TabHostManager.g().d());
        LogEx.d("MineFragment", "mMenuItems.size = " + this.w.size());
        this.v.a(this.w, this.A);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        LogEx.d("MineFragment", "onHiddenChanged");
        if (!z && "1".equals(ConfigMgr.readPropertie("IsOpenHeadFunction")) && com.zte.iptvclient.android.mobile.n.c.b.t()) {
            J();
        }
        if (isHidden() || !com.zte.iptvclient.android.mobile.n.c.b.t()) {
            return;
        }
        this.r.setText(this.x.V());
    }

    private void d(View view) {
        this.s = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        this.s.setHeight(a2);
        this.p = (LinearLayout) view.findViewById(R.id.ll_my_account);
        this.r = (TextView) view.findViewById(R.id.tv_mine_account_username);
        this.q = (ImageView) view.findViewById(R.id.iv_mine_account_icon);
        this.u = (RecyclerView) view.findViewById(R.id.recycler_menu);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_root));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.top_navbar_logo_img));
        O();
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, view));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if ("0".equals(cVar.a())) {
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isSideMenu", false);
                this.B = false;
                if ("parentcontral".equals(this.y)) {
                    L();
                    return;
                }
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a(this.y, bundle));
                if (!"at_account".equals(this.y)) {
                    this.v.e(s(this.y));
                    this.v.d();
                }
            }
            O();
            M();
            LogEx.d("MineFragment", "mStrBalance=" + this.A);
            this.A = this.x.c();
            this.w.clear();
            this.w.addAll(TabHostManager.g().d());
            LogEx.d("MineFragment", "mMenuItems.size = " + this.w.size());
            this.v.a(this.w, this.A);
            return;
        }
        this.A = "";
        this.w.clear();
        this.w.addAll(TabHostManager.g().d());
        LogEx.d("MineFragment", "mMenuItems.size = " + this.w.size());
        this.v.a(this.w, this.A);
    }

    protected void d(int i) {
        com.zte.iptvclient.android.common.customview.a.a.a.b bVar = new com.zte.iptvclient.android.common.customview.a.a.a.b(this.h);
        bVar.setTitle(com.zte.iptvclient.android.common.i.a.a.a(R.string.please_enter_parental_lock_password));
        bVar.b(R.string.common_confirm, new d(bVar.a(), i, bVar));
        bVar.a(R.string.common_cancel, new e(this, bVar));
        bVar.setCancelable(true);
        bVar.setCanceledOnTouchOutside(false);
        bVar.show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.d dVar) {
        this.y = "fragment_remote";
        this.v.e(-1);
        this.v.d();
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a("login", (Bundle) null));
        O();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.z.a aVar) {
        if ("download".equals(aVar.b())) {
            this.v.e(I());
            this.v.d();
        }
    }
}
