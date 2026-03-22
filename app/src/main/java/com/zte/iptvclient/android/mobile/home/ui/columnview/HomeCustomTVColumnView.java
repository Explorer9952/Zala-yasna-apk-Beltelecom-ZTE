package com.zte.iptvclient.android.mobile.home.ui.columnview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.channel.SDKChannelMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.e.x.e;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.mobile.e0.f.g;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.mobile.home.ui.layout.linearLayout.GeneralColumnView;
import com.zte.iptvclient.android.mobile.l.a.a;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class HomeCustomTVColumnView extends GeneralColumnView {

    /* renamed from: a, reason: collision with root package name */
    private Context f6427a;

    /* renamed from: b, reason: collision with root package name */
    private d f6428b;

    /* renamed from: c, reason: collision with root package name */
    private RecyclerView f6429c;

    /* renamed from: d, reason: collision with root package name */
    private com.zte.iptvclient.android.mobile.l.a.a f6430d;
    private ArrayList<Channel> e;
    private ConstraintLayout f;
    private RelativeLayout g;
    private TextView h;
    private ImageView i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a.b {

        /* renamed from: com.zte.iptvclient.android.mobile.home.ui.columnview.HomeCustomTVColumnView$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0272a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f6432a;

            RunnableC0272a(a aVar, String str) {
                this.f6432a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                LogEx.d("HomeCustomTVColumnView", "swicth current Channel=" + this.f6432a);
                EventBus.getDefault().post(new e(this.f6432a, com.zte.iptvclient.common.uiframe.a.c("Home_TV_Column")));
            }
        }

        a() {
        }

        @Override // com.zte.iptvclient.android.mobile.l.a.a.b
        public void a(View view, int i) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
            HomeCustomTVColumnView.this.f6429c.postDelayed(new RunnableC0272a(this, ((Channel) HomeCustomTVColumnView.this.e.get(i)).getChannelcode()), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                EventBus.getDefault().post(new e("", com.zte.iptvclient.common.uiframe.a.c("Home_TV_Column")));
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
            HomeCustomTVColumnView.this.g.postDelayed(new a(this), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements SDKChannelMgr.OnChannelListReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelListReturnListener
        public void onChannelListReturn(String str, String str2, String str3) {
            LogEx.d("HomeCustomTVColumnView", "s2= " + str3);
            if (!"0".equals(str)) {
                LogEx.e("HomeCustomTVColumnView", str2);
                HomeCustomTVColumnView.this.setVisibility(8);
                if (HomeCustomTVColumnView.this.f6428b != null) {
                    HomeCustomTVColumnView.this.f6428b.a();
                    return;
                }
                return;
            }
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Channel.getChannelFromJSon(jSONArray.getJSONObject(i)));
                }
                HomeCustomTVColumnView.this.e.addAll(arrayList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (HomeCustomTVColumnView.this.e.size() > 0) {
                HomeCustomTVColumnView.this.setVisibility(0);
            } else {
                HomeCustomTVColumnView.this.setVisibility(8);
            }
            if (HomeCustomTVColumnView.this.f6430d != null) {
                HomeCustomTVColumnView.this.f6430d.d();
            }
            if (HomeCustomTVColumnView.this.f6428b != null) {
                HomeCustomTVColumnView.this.f6428b.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();
    }

    public HomeCustomTVColumnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new ArrayList<>();
    }

    private void a(Context context) {
        View inflate = View.inflate(context, R.layout.home_custom_tv_column_view_grid, this);
        this.f = (ConstraintLayout) inflate.findViewById(R.id.common_column_header_rlayout);
        this.g = (RelativeLayout) inflate.findViewById(R.id.rl_next_all);
        f.a(this.f);
        f.a(this.g);
        TextView textView = (TextView) inflate.findViewById(R.id.column_title_txt);
        f.a(textView);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.home_tv_recommend_channel));
        g.a((ImageView) inflate.findViewById(R.id.column_img), textView);
        this.h = (TextView) inflate.findViewById(R.id.more_text);
        this.i = (ImageView) inflate.findViewById(R.id.more_icon);
        f.a(this.h);
        f.a(this.i);
        d();
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.home_rv_custom_tv);
        this.f6429c = recyclerView;
        f.a(recyclerView);
    }

    private void b() {
        this.f6429c.a(new GridLayoutManager(this.f6427a, BaseApp.a(this.f6427a) ? 10 : 5));
        this.f6429c.a(new com.zte.iptvclient.android.common.customview.viewgroup.a.d(com.zte.iptvclient.android.common.k.g.a(this.f6427a, 30.0f)));
        com.zte.iptvclient.android.mobile.l.a.a aVar = new com.zte.iptvclient.android.mobile.l.a.a(this.f6427a, this.e);
        this.f6430d = aVar;
        this.f6429c.a(aVar);
    }

    private void c() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Home_TV_Column");
        SDKChannelMgr sDKChannelMgr = new SDKChannelMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("columncode", c2);
        hashMap.put("ordertype", "4");
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "20");
        hashMap.put("mediaservices", "2");
        sDKChannelMgr.getChannelList(hashMap, new c());
    }

    private void d() {
        this.h.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_all));
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        this.g.setOnClickListener(new b());
    }

    private void e() {
        this.f6430d.a(new a());
    }

    public HomeCustomTVColumnView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new ArrayList<>();
    }

    public HomeCustomTVColumnView(Context context, d dVar) {
        super(context);
        this.e = new ArrayList<>();
        this.f6427a = context;
        this.f6428b = dVar;
        a(context);
        b();
        e();
    }

    public void a() {
        this.e.clear();
        c();
    }
}
