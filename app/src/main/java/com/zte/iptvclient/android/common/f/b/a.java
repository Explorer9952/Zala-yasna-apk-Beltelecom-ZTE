package com.zte.iptvclient.android.common.f.b;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.auth.FeatureAuthAndOrderListReq;
import com.video.androidsdk.service.auth.SDKAuthMgr;
import com.video.androidsdk.service.bean.AuthReq;
import com.video.androidsdk.service.bean.AuthSuccRspInfo;
import com.video.androidsdk.service.bean.Product;
import com.zte.iptvclient.android.common.javabean.models.Feature;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.mobile.order.helper.f.b;
import com.zte.iptvclient.android.mobile.order.helper.f.c;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AuthManager.java */
/* loaded from: classes.dex */
public class a implements SDKAuthMgr.OnDoAuthReturnListener {
    private static final String l = "a";

    /* renamed from: a, reason: collision with root package name */
    private View f4532a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f4533b;

    /* renamed from: c, reason: collision with root package name */
    private String f4534c;

    /* renamed from: d, reason: collision with root package name */
    private AuthReq f4535d;
    private com.zte.iptvclient.android.mobile.order.helper.c e;
    private com.zte.iptvclient.android.mobile.order.helper.b f;
    private com.zte.iptvclient.android.common.customview.a.a.e.g g;
    private com.zte.iptvclient.android.common.javabean.b h;
    private Dialog i;
    private com.zte.iptvclient.android.common.j.h j;
    private i k;

    /* compiled from: AuthManager.java */
    /* renamed from: com.zte.iptvclient.android.common.f.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0128a implements com.zte.iptvclient.android.mobile.order.helper.b {

        /* compiled from: AuthManager.java */
        /* renamed from: com.zte.iptvclient.android.common.f.b.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0129a implements c.InterfaceC0328c {
            C0129a(int i, String str) {
            }

            @Override // com.zte.iptvclient.android.mobile.order.helper.f.c.InterfaceC0328c
            public void a() {
                a aVar = a.this;
                aVar.b(aVar.f4535d);
            }
        }

        C0128a() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.b
        public void a(int i, String str) {
            if (a.this.f4533b == null || a.this.f4533b.isFinishing()) {
                return;
            }
            if (i == 6) {
                new com.zte.iptvclient.android.mobile.order.helper.f.c(a.this.f4533b, new C0129a(i, str)).a(a.this.f4532a);
                return;
            }
            a.this.a(i, str);
            if (a.this.k == null) {
                a.this.e.a(i, str);
            }
        }
    }

    /* compiled from: AuthManager.java */
    /* loaded from: classes.dex */
    class b implements com.zte.iptvclient.android.mobile.order.helper.b {
        b() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.b
        public void a(int i, String str) {
            if (a.this.f4533b == null || a.this.f4533b.isFinishing()) {
                return;
            }
            a.this.a(i, str);
            a.this.e.a(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthManager.java */
    /* loaded from: classes.dex */
    public class c implements b.InterfaceC0327b {
        c() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.f.b.InterfaceC0327b
        public void a() {
            if (a.this.k != null) {
                a.this.k.a(0, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthManager.java */
    /* loaded from: classes.dex */
    public class d implements b.InterfaceC0327b {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.f.b.InterfaceC0327b
        public void a() {
            if (a.this.k != null) {
                a.this.k.a(1, "");
            }
        }
    }

    /* compiled from: AuthManager.java */
    /* loaded from: classes.dex */
    class e implements i {
        e() {
        }

        @Override // com.zte.iptvclient.android.common.f.b.a.i
        public void a(int i, String str) {
            if (a.this.e != null) {
                a.this.e.a(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthManager.java */
    /* loaded from: classes.dex */
    public class f implements SDKAuthMgr.OnDoAuthReturnListener {
        f() {
        }

        @Override // com.video.androidsdk.service.auth.SDKAuthMgr.OnDoAuthReturnListener
        public void onDoAuthNotPassProductListReturn(String str, String str2, List<Product> list) {
            if (a.this.g != null) {
                a.this.g.dismiss();
            }
            a.this.e.a(1, "");
            com.zte.iptvclient.android.common.f.b.h.a().a(str, " [order_error] do auth error, returncode:" + str + ",errormsg:" + str2);
        }

        @Override // com.video.androidsdk.service.auth.SDKAuthMgr.OnDoAuthReturnListener
        public void onDoAuthOtherFailReturn(String str, String str2) {
            if (a.this.g != null) {
                a.this.g.dismiss();
            }
            a.this.e.a(1, "");
            String str3 = " [order_error] do auth error, returncode:" + str + ",errormsg:" + str2;
            if (com.zte.iptvclient.android.common.f.b.h.a() != null) {
                com.zte.iptvclient.android.common.f.b.h.a().a(str, str3);
            }
        }

        @Override // com.video.androidsdk.service.auth.SDKAuthMgr.OnDoAuthReturnListener
        public void onDoAuthSuccReturn(AuthSuccRspInfo authSuccRspInfo) {
            if (a.this.g != null) {
                a.this.g.dismiss();
            }
            a.this.e.a(0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthManager.java */
    /* loaded from: classes.dex */
    public class g implements SDKAuthMgr.OnFeatureAuthAndOrderListReturnListener {
        g() {
        }

        @Override // com.video.androidsdk.service.auth.SDKAuthMgr.OnFeatureAuthAndOrderListReturnListener
        public void onFeatureAuthAndOrderListReturn(String str, String str2, String str3) {
            if (a.this.g != null) {
                a.this.g.dismiss();
            }
            LogEx.d(a.l, "onFeatureAuthAndOrderListReturn " + str + " ermsg" + str2 + " json=" + str3);
            if (TextUtils.equals("0", str)) {
                if (a.this.e != null) {
                    a.this.e.a(0, "");
                    return;
                }
                return;
            }
            if (!TextUtils.equals(DownloadConstant.REPORT_MSGTYPE_ADD, str) && !TextUtils.equals("98", str)) {
                if (a.this.e != null) {
                    a.this.e.a(1, "");
                }
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(a.this.f4534c + str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray optJSONArray = new JSONObject(str3).optJSONObject("data").optJSONArray("productlist");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        Feature channelFromJSon = Feature.getChannelFromJSon(optJSONArray.getJSONObject(i));
                        if (channelFromJSon != null && TextUtils.equals("childrenframe", channelFromJSon.getFeaturecode())) {
                            arrayList.add(Feature.switchCommonProduct(channelFromJSon));
                        }
                    }
                }
            } catch (Exception e) {
                LogEx.e(a.l, "doOrderFuatureProductAboutChildMode getException=" + e.getMessage());
            }
            if (arrayList.size() > 0) {
                com.zte.iptvclient.android.common.javabean.models.h hVar = new com.zte.iptvclient.android.common.javabean.models.h();
                hVar.e(com.zte.iptvclient.android.common.i.a.a.a(R.string.termial_binding_package));
                a.this.i = new com.zte.iptvclient.android.mobile.order.helper.f.a(a.this.f4533b, R.style.dialog_order, arrayList, a.this.f, hVar);
                a.this.i.show();
                return;
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.l());
        }
    }

    /* compiled from: AuthManager.java */
    /* loaded from: classes.dex */
    public interface h {
    }

    /* compiled from: AuthManager.java */
    /* loaded from: classes.dex */
    public interface i {
        void a(int i, String str);
    }

    public a(Activity activity, com.zte.iptvclient.android.common.javabean.b bVar, com.zte.iptvclient.android.mobile.order.helper.c cVar, h hVar) {
        this.f4533b = activity;
        this.e = cVar;
        this.h = bVar;
        this.f4534c = com.zte.iptvclient.android.common.i.a.a.a(R.string.auth_fail);
        this.g = new com.zte.iptvclient.android.common.customview.a.a.e.g(activity);
        this.j = new com.zte.iptvclient.android.common.j.h(this.f4533b);
        this.f = new C0128a();
    }

    @Override // com.video.androidsdk.service.auth.SDKAuthMgr.OnDoAuthReturnListener
    public void onDoAuthNotPassProductListReturn(String str, String str2, List<Product> list) {
        Activity activity;
        LogEx.d(l, "auth fail with productList " + list);
        if (this.f4532a != null && (activity = this.f4533b) != null && !activity.isFinishing()) {
            com.zte.iptvclient.android.common.customview.a.a.e.g gVar = this.g;
            if (gVar != null) {
                gVar.dismiss();
            }
            try {
                com.zte.iptvclient.android.common.f.b.h.a().a(str, " [order_error] do auth error, returncode:" + str + ",errormsg:" + str2);
            } catch (NoClassDefFoundError e2) {
                e2.printStackTrace();
            }
            int i2 = 0;
            if (this.j.Z().equals("中国移动")) {
                i2 = this.j.a0().equals("安徽") ? 1 : 2;
            }
            if (list != null && list.size() > 0) {
                com.zte.iptvclient.android.common.javabean.models.h hVar = new com.zte.iptvclient.android.common.javabean.models.h();
                hVar.c(this.h.b());
                hVar.b(this.h.a());
                hVar.d(this.h.d());
                hVar.g(this.h.g());
                hVar.e(this.h.e());
                hVar.a(String.valueOf(i2));
                if (TextUtils.isEmpty(this.h.f())) {
                    this.h.f("0");
                }
                hVar.f(this.h.f());
                com.zte.iptvclient.android.mobile.order.helper.f.a aVar = new com.zte.iptvclient.android.mobile.order.helper.f.a(this.f4533b, R.style.dialog_order, list, this.f, hVar);
                this.i = aVar;
                aVar.show();
                return;
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(o.j().a(this.f4533b.getResources().getString(R.string.order_error_msg)));
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.l());
            return;
        }
        LogEx.d(l, "auth fail with product tokenView or activity is null");
    }

    @Override // com.video.androidsdk.service.auth.SDKAuthMgr.OnDoAuthReturnListener
    public void onDoAuthOtherFailReturn(String str, String str2) {
        LogEx.d(l, "auth fail without product" + str + " errmsg " + str2);
        com.zte.iptvclient.android.common.customview.a.a.e.g gVar = this.g;
        if (gVar != null) {
            gVar.dismiss();
        }
        com.zte.iptvclient.android.mobile.order.helper.c cVar = this.e;
        if (cVar != null) {
            cVar.a(1, "");
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(o.j().a(this.f4533b.getResources().getString(R.string.order_error_msg)));
        String str3 = " [order_error] do auth error, returncode:" + str + ",errormsg:" + str2;
        if (com.zte.iptvclient.android.common.f.b.h.a() != null) {
            com.zte.iptvclient.android.common.f.b.h.a().a(str, str3);
        }
    }

    @Override // com.video.androidsdk.service.auth.SDKAuthMgr.OnDoAuthReturnListener
    public void onDoAuthSuccReturn(AuthSuccRspInfo authSuccRspInfo) {
        LogEx.d(l, "auth success");
        com.zte.iptvclient.android.common.customview.a.a.e.g gVar = this.g;
        if (gVar != null) {
            gVar.dismiss();
        }
        com.zte.iptvclient.android.mobile.order.helper.c cVar = this.e;
        if (cVar != null) {
            cVar.a(0, "");
        }
    }

    private void d() {
        SDKAuthMgr sDKAuthMgr = new SDKAuthMgr();
        FeatureAuthAndOrderListReq featureAuthAndOrderListReq = new FeatureAuthAndOrderListReq();
        featureAuthAndOrderListReq.authandorderlist = "3";
        featureAuthAndOrderListReq.featurecode = "childrenframe";
        sDKAuthMgr.doFeatureAuthAndOrderList(featureAuthAndOrderListReq, new g());
    }

    private void e() {
        if (com.zte.iptvclient.android.common.k.c.a(this.f4533b)) {
            com.zte.iptvclient.android.common.customview.a.a.e.g gVar = this.g;
            if (gVar != null) {
                gVar.show();
            }
            d();
            return;
        }
        com.zte.iptvclient.android.mobile.order.helper.c cVar = this.e;
        if (cVar != null) {
            cVar.a(1, "");
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.net_disable);
    }

    public void b() {
        AuthReq authReq = new AuthReq(this.h.a(), this.h.d(), this.h.b());
        authReq.definition = "0";
        this.f4535d = authReq;
        this.k = new e();
        LogEx.d(l, "commonFeatureAuthAndOrder = " + this.f4535d);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        if (i2 != 0) {
            Activity activity = this.f4533b;
            com.zte.iptvclient.android.mobile.order.helper.f.b bVar = new com.zte.iptvclient.android.mobile.order.helper.f.b(activity, R.style.commonDialogTheme, activity.getResources().getString(R.string.pay_fail), new d());
            bVar.dismiss();
            bVar.show();
            return;
        }
        Activity activity2 = this.f4533b;
        com.zte.iptvclient.android.mobile.order.helper.f.b bVar2 = new com.zte.iptvclient.android.mobile.order.helper.f.b(activity2, R.style.commonDialogTheme, activity2.getResources().getString(R.string.pay_success), new c());
        bVar2.dismiss();
        bVar2.show();
    }

    public a(String str, Activity activity, com.zte.iptvclient.android.common.javabean.b bVar, com.zte.iptvclient.android.mobile.order.helper.c cVar, h hVar) {
        this.f4533b = activity;
        this.e = cVar;
        this.h = bVar;
        this.f4534c = com.zte.iptvclient.android.common.i.a.a.a(R.string.auth_fail);
        this.g = new com.zte.iptvclient.android.common.customview.a.a.e.g(activity);
        this.j = new com.zte.iptvclient.android.common.j.h(this.f4533b);
        this.f = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AuthReq authReq) {
        if (com.zte.iptvclient.android.common.k.c.a(this.f4533b)) {
            this.g.show();
            new SDKAuthMgr().doAuth(authReq, new f());
        } else {
            com.zte.iptvclient.android.mobile.order.helper.c cVar = this.e;
            if (cVar != null) {
                cVar.a(1, "");
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.net_disable);
        }
    }

    public void a() {
        AuthReq authReq = new AuthReq(this.h.a(), this.h.d(), this.h.b());
        if (TextUtils.isEmpty(this.h.c())) {
            authReq.definition = "0";
        } else {
            authReq.definition = this.h.c();
        }
        this.f4535d = authReq;
        LogEx.d(l, "commonAuth = " + this.f4535d);
        a(authReq);
    }

    private void a(AuthReq authReq) {
        if (com.zte.iptvclient.android.common.k.c.a(this.f4533b)) {
            this.g.show();
            new SDKAuthMgr().doAuth(authReq, this);
        } else {
            com.zte.iptvclient.android.mobile.order.helper.c cVar = this.e;
            if (cVar != null) {
                cVar.a(1, "");
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.net_disable);
        }
    }

    public void a(View view) {
        this.f4532a = view;
    }
}
