package com.zte.iptvclient.android.mobile.q.c;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.vr.cardboard.TransitionView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.a.h;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.auth.SDKSubscribeMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.order.entity.PurchaseHistoryEntity;
import com.zte.iptvclient.android.mobile.order.helper.e;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PurchaseHistoryFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b {
    private Button p;
    private RecyclerView q;
    private com.zte.iptvclient.android.mobile.q.a.a r;
    private SmartRefreshLayout s;
    private RelativeLayout t;
    private TextView u;
    private ArrayList<PurchaseHistoryEntity> v = new ArrayList<>();
    private ArrayList<PurchaseHistoryEntity> w = new ArrayList<>();
    private SDKSubscribeMgr x;
    private e y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PurchaseHistoryFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.getActivity() != null) {
                c.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PurchaseHistoryFragment.java */
    /* loaded from: classes.dex */
    public class b implements com.scwang.smartrefresh.layout.d.c {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(h hVar) {
            c.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PurchaseHistoryFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.q.c.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0338c implements SDKSubscribeMgr.OnUserConsumeListReturnListener {
        C0338c() {
        }

        @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnUserConsumeListReturnListener
        public void onUserConsumeListReturn(String str, String str2, String str3) {
            LogEx.d("PurchaseHistoryFragment", "queryConsumeList returncode : " + str + ", data : " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        c.this.v.add(PurchaseHistoryEntity.a(jSONArray.getJSONObject(i)));
                    }
                } catch (Exception e) {
                    LogEx.e("PurchaseHistoryFragment", e.getMessage());
                }
            }
            LogEx.d("PurchaseHistoryFragment", "size: " + c.this.v.size());
            if (c.this.v.size() == 0) {
                c.this.s.a();
                c.this.t.setVisibility(0);
                c.this.q.setVisibility(8);
            }
            for (int i2 = 0; i2 < c.this.v.size(); i2++) {
                c.this.d(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PurchaseHistoryFragment.java */
    /* loaded from: classes.dex */
    public class d implements e.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7084a;

        d(int i) {
            this.f7084a = i;
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.e.b
        public void a(String str, String str2, String str3) {
            int indexOf;
            LogEx.d("PurchaseHistoryFragment", str3);
            if (TextUtils.equals("0", str)) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    if (jSONArray.length() > 0) {
                        JSONObject jSONObject = jSONArray.getJSONObject(0);
                        LogEx.d("PurchaseHistoryFragment", jSONObject.getString("posterpath"));
                        String string = jSONObject.getString("posterfilelist");
                        LogEx.d("PurchaseHistoryFragment", string);
                        int i = BaseApp.f() ? 9 : 3;
                        String g = i.g();
                        String a2 = g.a(i, string);
                        if (a2 != null && (indexOf = a2.indexOf("/image", 1)) > 0) {
                            a2 = g + a2.substring(indexOf);
                        }
                        ((PurchaseHistoryEntity) c.this.v.get(this.f7084a)).g(a2);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (this.f7084a + 1 == c.this.v.size()) {
                c.this.K();
                c.this.O();
            }
        }
    }

    private void I() {
        SDKSubscribeMgr sDKSubscribeMgr = this.x;
        if (sDKSubscribeMgr != null) {
            sDKSubscribeMgr.cancelRequest();
            this.x = null;
        }
    }

    private void J() {
        e eVar = this.y;
        if (eVar != null) {
            eVar.a();
            this.y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        Collections.sort(this.v);
        if (this.v.size() < 1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < this.v.size()) {
            PurchaseHistoryEntity purchaseHistoryEntity = this.v.get(i);
            String g = x.g(purchaseHistoryEntity.a());
            if (!StringUtil.isEmptyString(g) && !arrayList.contains(g)) {
                arrayList.add(g);
                PurchaseHistoryEntity purchaseHistoryEntity2 = new PurchaseHistoryEntity();
                purchaseHistoryEntity2.j(s(g));
                purchaseHistoryEntity2.a(i == 0);
                ArrayList<PurchaseHistoryEntity> g2 = purchaseHistoryEntity2.g();
                g2.add(purchaseHistoryEntity2);
                g2.add(purchaseHistoryEntity);
                for (int i2 = i + 1; i2 < this.v.size(); i2++) {
                    PurchaseHistoryEntity purchaseHistoryEntity3 = this.v.get(i2);
                    if (TextUtils.equals(g, x.g(purchaseHistoryEntity3.a()))) {
                        g2.add(purchaseHistoryEntity3);
                    }
                }
                this.w.add(purchaseHistoryEntity2);
            }
            i++;
        }
    }

    private void L() {
        this.v.clear();
        this.w.clear();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", String.valueOf(TransitionView.TRANSITION_ANIMATION_DURATION_MS));
        hashMap.put("cdrtime", DownloadConstant.REPORT_MSGTYPE_URL_NULL);
        hashMap.put("contenttype", "100");
        hashMap.put("cdrtype", "100");
        hashMap.put("ordertype", "21");
        hashMap.put("filtertype", "0");
        SDKSubscribeMgr sDKSubscribeMgr = new SDKSubscribeMgr();
        this.x = sDKSubscribeMgr;
        sDKSubscribeMgr.getUserConsumeList(hashMap, new C0338c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        I();
        L();
    }

    private void N() {
        this.p.setOnClickListener(new a());
        this.s.a(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.r.e();
        this.s.a();
        if (this.v.size() == 0) {
            this.t.setVisibility(0);
            this.q.setVisibility(8);
        } else {
            this.t.setVisibility(8);
            this.q.setVisibility(0);
        }
    }

    private String s(String str) {
        String format = TimeUtil.format(TimeUtil.getNow(), "dd/MM/yyyy HH:mm:ss");
        return (str == null || format == null || !TextUtils.equals(str, x.g(format))) ? str : this.h.getResources().getString(R.string.order_month);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        N();
        com.zte.iptvclient.android.mobile.q.a.a aVar = new com.zte.iptvclient.android.mobile.q.a.a(this.h, this.w);
        this.r = aVar;
        this.q.a(aVar);
        M();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_purchase_history, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        I();
        J();
    }

    private void d(View view) {
        g.a(this.h, view, R.id.header_bottom_line);
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.p = button;
        if (this.o) {
            button.setVisibility(0);
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_purchase_history);
        this.q = recyclerView;
        recyclerView.a(new LinearLayoutManager(this.h, 1, false));
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_order));
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        f.a(view.findViewById(R.id.title_rlayout));
        f.a(textView2);
        f.a(imageView);
        f.a(this.p);
        f.a(this.q);
        this.s = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.t = relativeLayout;
        f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        f.a(this.t.findViewById(R.id.img_pullrefresh_icon));
        f.a(this.t.findViewById(R.id.txt_pullrefresh));
        f.a(this.t.findViewById(R.id.refresh_image));
        this.t.setVisibility(8);
        TextView textView3 = (TextView) this.t.findViewById(R.id.txt_pullrefresh);
        this.u = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.there_is_no_order_yet));
        this.s.a(new DefaultRefreshHeader(this.h));
        this.s.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.s;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.s;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.s.a(true);
        if (BaseApp.a(this.h)) {
            g.a(imageView, this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        LogEx.d("PurchaseHistoryFragment", "---queryVodThumbnail---" + i);
        String j = this.v.get(i).j();
        String b2 = this.v.get(i).b();
        String i2 = this.v.get(i).i();
        if (("1".equals(j) || "10".equals(j) || GlobalConst.WINPHONE_CLIENT.equals(j) || "14".equals(j) || "15".equals(j)) && !TextUtils.isEmpty(b2)) {
            this.y = new e();
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("contentcodes", b2);
            }
            if (!TextUtils.isEmpty(i2)) {
                hashMap.put("programcodes", i2);
            }
            this.y.a(hashMap, new d(i));
            return;
        }
        if (i + 1 == this.v.size()) {
            K();
            O();
        }
    }
}
