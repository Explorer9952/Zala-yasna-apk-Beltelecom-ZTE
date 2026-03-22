package com.zte.iptvclient.android.mobile.v.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.favorite.SDKFavoriteMgr;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.video.androidsdk.service.search.SDKSearchMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SearchLiveFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b implements View.OnTouchListener {
    private RelativeLayout A;
    private com.zte.iptvclient.android.common.j.h C;
    private SimpleDateFormat E;
    private RelativeLayout G;
    private RelativeLayout J;
    private RelativeLayout K;
    private TextView L;
    private TextView M;
    private ImageView N;
    private ImageView O;
    private int R;
    private int S;
    private m p;
    private String q;
    private ListView v;
    private SmartRefreshLayout z;
    private long r = 0;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private int w = 1;
    private int x = 1;
    private String y = "";
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.f> B = new ArrayList<>();
    private ArrayList<Channel> D = new ArrayList<>();
    private ArrayList<Channel> F = new ArrayList<>();
    private String P = "";
    private String Q = "";
    private String[] T = new String[0];
    private String[] U = new String[0];
    private Handler V = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchLiveFragment.java */
    /* loaded from: classes2.dex */
    public class a implements SDKFavoriteMgr.OnAddFavoriteReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.javabean.models.f f7533a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f7534b;

        a(com.zte.iptvclient.android.common.javabean.models.f fVar, ImageView imageView) {
            this.f7533a = fVar;
            this.f7534b = imageView;
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnAddFavoriteReturnListener
        public void onAddFavoriteReturn(String str, String str2) {
            LogEx.d(com.video.androidsdk.b.a.TAG, str2);
            if (!TextUtils.equals(str, "0")) {
                LogEx.w(com.video.androidsdk.b.a.TAG, str2);
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.add_favourite_msg5));
            } else {
                this.f7533a.m("1");
                this.f7534b.setImageDrawable(b.this.getResources().getDrawable(R.drawable.function_fav_selected));
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.m.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchLiveFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.v.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0372b implements SDKFavoriteMgr.OnDelFavoriteReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.javabean.models.f f7536a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f7537b;

        C0372b(com.zte.iptvclient.android.common.javabean.models.f fVar, ImageView imageView) {
            this.f7536a = fVar;
            this.f7537b = imageView;
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnDelFavoriteReturnListener
        public void onDelFavoriteReturn(String str, String str2) {
            LogEx.d(com.video.androidsdk.b.a.TAG, str2);
            if (!TextUtils.equals(str, "0")) {
                LogEx.w(com.video.androidsdk.b.a.TAG, str2);
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.del_favourite_msg) + " " + str2);
                return;
            }
            this.f7536a.m("0");
            this.f7537b.setImageDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.function_fav_normal));
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.m.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchLiveFragment.java */
    /* loaded from: classes2.dex */
    public class c implements SDKFavoriteMgr.OnUserFavoriteListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f7539a;

        c(ArrayList arrayList) {
            this.f7539a = arrayList;
        }

        @Override // com.video.androidsdk.service.favorite.SDKFavoriteMgr.OnUserFavoriteListReturnListener
        public void onUserFavoriteListReturn(String str, String str2, String str3) {
            try {
                LogEx.d(com.video.androidsdk.b.a.TAG, "returncode is " + str + "   errormsg is " + str2 + ",msg is " + str3);
                JSONObject jSONObject = new JSONObject(str3);
                if ("0".equals(jSONObject.optString("returncode"))) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (this.f7539a != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= this.f7539a.size()) {
                                    break;
                                }
                                if (((Channel) this.f7539a.get(i2)).getChannelcode().equals(jSONObject2.getString("contentcode")) && ((Channel) this.f7539a.get(i2)).getColumncode().equals(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL))) {
                                    b.this.D.add(this.f7539a.get(i2));
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                LogEx.e(com.video.androidsdk.b.a.TAG, "query channel favorite: " + e.getMessage());
            }
            b.this.t = false;
            b.this.V.sendEmptyMessage(0);
        }
    }

    /* compiled from: SearchLiveFragment.java */
    /* loaded from: classes2.dex */
    class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 0 || b.this.u || b.this.t) {
                return;
            }
            b.this.s = false;
            Iterator it2 = b.this.B.iterator();
            while (it2.hasNext()) {
                com.zte.iptvclient.android.common.javabean.models.f fVar = (com.zte.iptvclient.android.common.javabean.models.f) it2.next();
                Iterator it3 = b.this.D.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (TextUtils.equals(fVar.b(), ((Channel) it3.next()).getChannelcode())) {
                            fVar.m("1");
                            break;
                        }
                    }
                }
            }
            b.this.p.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchLiveFragment.java */
    /* loaded from: classes2.dex */
    public class e implements SDKSearchMgr.OnSearchProgramListByEPGReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.service.search.SDKSearchMgr.OnSearchProgramListByEPGReturnListener
        public void onSearchProgramListReturn(String str, String str2, String str3) {
            LogEx.d("SearchLiveFragment", "returncode : " + str + ", errormsg : " + str2 + " , data : " + str3);
            if (!TextUtils.equals(str, "0")) {
                b.this.P();
                b.this.u = false;
                b.this.V.sendEmptyMessage(0);
                return;
            }
            b.this.t(str3);
            if (b.this.B.size() == 0) {
                b.this.P();
                b.this.u = false;
                b.this.V.sendEmptyMessage(0);
                return;
            }
            b.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchLiveFragment.java */
    /* loaded from: classes2.dex */
    public class f implements SDKSearchMgr.OnSearchProgramListReturnListener {
        f() {
        }

        @Override // com.video.androidsdk.service.search.SDKSearchMgr.OnSearchProgramListReturnListener
        public void onSearchProgramListReturn(String str, String str2, String str3) {
            LogEx.d("SearchLiveFragment", "returncode : " + str + ", errormsg : " + str2 + " , data : " + str3);
            if (!TextUtils.equals(str, "0")) {
                b.this.P();
                b.this.u = false;
                b.this.V.sendEmptyMessage(0);
                return;
            }
            b.this.t(str3);
            if (b.this.B.size() == 0) {
                b.this.P();
                b.this.u = false;
                b.this.V.sendEmptyMessage(0);
                return;
            }
            b.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchLiveFragment.java */
    /* loaded from: classes2.dex */
    public class g implements SDKPrevueMgr.OnCurrentPrevueReturnListener {
        g() {
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnCurrentPrevueReturnListener
        public void onCurrentPrevueReturn(String str, String str2, String str3) {
            LogEx.d("SearchLiveFragment", " returncode : " + str + " , errormsg : " + str2 + " , data :" + str3);
            ArrayList arrayList = new ArrayList();
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        if (jSONArray2 != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= jSONArray2.length()) {
                                    break;
                                }
                                if (b.this.a(jSONArray2.optJSONObject(i2))) {
                                    arrayList.add(PrevueBean.getPrevueBeanFromJSon(jSONArray2.optJSONObject(i2)));
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                } catch (Exception e) {
                    LogEx.e("SearchLiveFragment", e.getMessage());
                }
            }
            b.this.b((ArrayList<PrevueBean>) arrayList);
            b.this.P();
            b.this.u = false;
            b.this.V.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchLiveFragment.java */
    /* loaded from: classes2.dex */
    public class h implements com.scwang.smartrefresh.layout.d.a {
        h() {
        }

        @Override // com.scwang.smartrefresh.layout.d.a
        public void b(com.scwang.smartrefresh.layout.a.h hVar) {
            if (b.this.s) {
                return;
            }
            b.d(b.this);
            if (b.this.x >= b.this.w) {
                if (!TextUtils.isEmpty(b.this.y)) {
                    b.this.O();
                    return;
                } else {
                    b.this.N();
                    return;
                }
            }
            hVar.j();
            hVar.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchLiveFragment.java */
    /* loaded from: classes2.dex */
    public class i implements com.scwang.smartrefresh.layout.d.c {
        i() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            b.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchLiveFragment.java */
    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.L.setTextColor(((com.zte.fragmentlib.b) b.this).h.getResources().getColor(R.color.white));
            b.this.O.setImageDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up));
            b.this.J.setBackgroundDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.search_sort_bg));
            b.this.Q = "";
            b.this.K.setBackgroundDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.search_sort_select_bg));
            if (b.this.N.getDrawable().getCurrent().getConstantState() == ((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up).getConstantState()) {
                b.this.N.setImageDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select));
                b.this.M.setTextColor(((com.zte.fragmentlib.b) b.this).h.getResources().getColor(R.color.black));
                b.this.P = GlobalConst.WINPHONE_CLIENT;
                b.this.L();
                return;
            }
            if (b.this.M.getText().equals("A-Z")) {
                b.this.M.setText("Z-A");
                b.this.M.setTextColor(((com.zte.fragmentlib.b) b.this).h.getResources().getColor(R.color.black));
                b.this.N.setImageDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.icon_search_sort_down_select));
                b.this.P = "17";
            } else {
                b.this.M.setText("A-Z");
                b.this.M.setTextColor(((com.zte.fragmentlib.b) b.this).h.getResources().getColor(R.color.black));
                b.this.N.setImageDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select));
                b.this.P = GlobalConst.WINPHONE_CLIENT;
            }
            b.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchLiveFragment.java */
    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.M.setText("A-Z");
            b.this.M.setTextColor(((com.zte.fragmentlib.b) b.this).h.getResources().getColor(R.color.white));
            b.this.N.setImageDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up));
            b.this.K.setBackgroundDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.search_sort_bg));
            b.this.P = "";
            b.this.J.setBackgroundDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.search_sort_select_bg));
            if (b.this.O.getDrawable().getCurrent().getConstantState() == ((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up).getConstantState()) {
                b.this.O.setImageDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select));
                b.this.L.setTextColor(((com.zte.fragmentlib.b) b.this).h.getResources().getColor(R.color.black));
                b.this.Q = "3";
                b.this.L();
                return;
            }
            if (b.this.O.getDrawable().getCurrent().getConstantState() == ((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select).getConstantState()) {
                b.this.O.setImageDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.icon_search_sort_down_select));
                b.this.L.setTextColor(((com.zte.fragmentlib.b) b.this).h.getResources().getColor(R.color.black));
                b.this.Q = "4";
            } else {
                b.this.O.setImageDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.icon_search_sort_up_select));
                b.this.L.setTextColor(((com.zte.fragmentlib.b) b.this).h.getResources().getColor(R.color.black));
                b.this.Q = "3";
            }
            b.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchLiveFragment.java */
    /* loaded from: classes2.dex */
    public class l implements AdapterView.OnItemClickListener {

        /* compiled from: SearchLiveFragment.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f7550a;

            a(String str) {
                this.f7550a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.e(this.f7550a, com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL)));
                if (b.this.getActivity() != null) {
                    if (b.this.getActivity() instanceof HostActivity) {
                        b.this.getActivity().finish();
                        return;
                    }
                    Fragment parentFragment = b.this.getParentFragment();
                    if (parentFragment == null || !(parentFragment instanceof com.zte.iptvclient.android.mobile.v.b.a)) {
                        return;
                    }
                    ((com.zte.iptvclient.android.mobile.v.b.a) parentFragment).F();
                }
            }
        }

        l() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.zte.iptvclient.android.common.javabean.models.f fVar;
            if (b.this.B == null || i >= b.this.B.size() || (fVar = (com.zte.iptvclient.android.common.javabean.models.f) b.this.B.get(i)) == null) {
                return;
            }
            String b2 = fVar.b();
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
            b.this.v.postDelayed(new a(b2), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SearchLiveFragment.java */
    /* loaded from: classes2.dex */
    public class m extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private LayoutInflater f7552a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<com.zte.iptvclient.android.common.javabean.models.f> f7553b;

        /* renamed from: c, reason: collision with root package name */
        private Context f7554c;

        /* compiled from: SearchLiveFragment.java */
        /* loaded from: classes2.dex */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.zte.iptvclient.android.common.javabean.models.f f7556a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ n f7557b;

            a(com.zte.iptvclient.android.common.javabean.models.f fVar, n nVar) {
                this.f7556a = fVar;
                this.f7557b = nVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                    if (com.zte.iptvclient.android.common.k.c.a()) {
                        return;
                    }
                    t.a((Context) ((com.zte.fragmentlib.b) b.this).h, false);
                } else {
                    if (b.this.d(1000)) {
                        return;
                    }
                    if (!TextUtils.equals(this.f7556a.k(), "1")) {
                        b.this.a(this.f7556a, this.f7557b.f7561c);
                    } else {
                        b.this.b(this.f7556a, this.f7557b.f7561c);
                    }
                }
            }
        }

        public m(Context context, ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList) {
            this.f7554c = context;
            this.f7552a = (LayoutInflater) context.getSystemService("layout_inflater");
            this.f7553b = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList = this.f7553b;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            n nVar;
            if (view == null) {
                nVar = new n(null);
                view2 = this.f7552a.inflate(R.layout.search_tv_channels_item, (ViewGroup) null);
                nVar.f7559a = (ImageView) view2.findViewById(R.id.img_channel_icon);
                nVar.f7561c = (ImageView) view2.findViewById(R.id.img_channel_fav);
                nVar.f7560b = (RelativeLayout) view2.findViewById(R.id.rl_fav);
                nVar.f7562d = (LinearLayout) view2.findViewById(R.id.ll_channel_item_describ);
                nVar.f = (TextView) view2.findViewById(R.id.txt_channel_current_program_name);
                nVar.g = (TextView) view2.findViewById(R.id.txt_channel_current_program_duration);
                nVar.e = (TextView) view2.findViewById(R.id.txt_channel_name);
                com.zte.iptvclient.common.uiframe.f.a(nVar.f7559a);
                com.zte.iptvclient.common.uiframe.f.a(nVar.f7561c);
                com.zte.iptvclient.common.uiframe.f.a(nVar.f7560b);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.img_channel_fav));
                com.zte.iptvclient.common.uiframe.f.a(nVar.f);
                com.zte.iptvclient.common.uiframe.f.a(nVar.g);
                com.zte.iptvclient.common.uiframe.f.a(nVar.e);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.ll_channel_item));
                com.zte.iptvclient.common.uiframe.f.a(nVar.f7562d);
                view2.setTag(nVar);
            } else {
                view2 = view;
                nVar = (n) view.getTag();
            }
            nVar.f7559a.setImageResource(R.drawable.default_video_thumb);
            com.zte.iptvclient.android.common.javabean.models.f fVar = this.f7553b.get(i);
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                nVar.f7561c.setImageDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.function_fav_normal));
            } else if (TextUtils.equals(fVar.k(), "1")) {
                nVar.f7561c.setImageDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.function_fav_selected));
            } else {
                nVar.f7561c.setImageDrawable(((com.zte.fragmentlib.b) b.this).h.getResources().getDrawable(R.drawable.function_fav_normal));
            }
            nVar.f7560b.findViewById(R.id.rl_fav_layout).setOnClickListener(new a(fVar, nVar));
            if (TextUtils.isEmpty(fVar.q())) {
                nVar.f.setText("");
            } else {
                nVar.f.setText(fVar.q());
            }
            if (TextUtils.isEmpty(fVar.e())) {
                nVar.e.setText("");
            } else {
                nVar.e.setText(fVar.A() + " " + fVar.e());
            }
            String str = com.zte.iptvclient.android.common.f.b.i.b() + "/iptvepg/images/markurl/" + fVar.l();
            if (!TextUtils.isEmpty(str)) {
                Context context = this.f7554c;
                if (context != null && !((Activity) context).isFinishing()) {
                    com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.b(this.f7554c).a(str);
                    a2.a(R.drawable.default_video_thumb);
                    a2.b(252, 198);
                    a2.a(nVar.f7559a);
                }
            } else {
                nVar.f7559a.setImageResource(R.drawable.default_video_thumb);
            }
            String x = fVar.x();
            if (TextUtils.isEmpty(x)) {
                nVar.g.setText("");
            } else {
                try {
                    Date a3 = x.a(x, "yyyy.MM.dd HH:mm:ss");
                    Date a4 = x.a(fVar.j(), "yyyy.MM.dd HH:mm:ss");
                    nVar.g.setText(TimeUtil.format(a3, "HH:mm") + " - " + TimeUtil.format(a4, "HH:mm"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return view2;
        }
    }

    /* compiled from: SearchLiveFragment.java */
    /* loaded from: classes2.dex */
    private static class n extends com.zte.iptvclient.common.uiframe.d {

        /* renamed from: a, reason: collision with root package name */
        ImageView f7559a;

        /* renamed from: b, reason: collision with root package name */
        RelativeLayout f7560b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f7561c;

        /* renamed from: d, reason: collision with root package name */
        LinearLayout f7562d;
        TextView e;
        TextView f;
        TextView g;

        private n() {
        }

        /* synthetic */ n(d dVar) {
            this();
        }
    }

    static /* synthetic */ int d(b bVar) {
        int i2 = bVar.w;
        bVar.w = i2 + 1;
        return i2;
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        return false;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Window window;
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(48);
        }
        EventBus.getDefault().register(this);
        J();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.C = new com.zte.iptvclient.android.common.j.h(this.h);
        this.y = o.j().g();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.search_live_fragment, viewGroup, false);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.v.b bVar) {
        if (TextUtils.isEmpty(bVar.a())) {
            return;
        }
        this.q = bVar.a();
        K();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id == R.id.refreshLayout || id == R.id.rl_empty || id == R.id.search_live_lv) {
            LogEx.d(com.video.androidsdk.b.a.TAG, "onTouch");
            if (motionEvent.getAction() != 0 || (view instanceof EditText)) {
                return false;
            }
            A();
        }
        return false;
    }

    private void J() {
        if (this.h != null) {
            this.p = new m(this.h, this.B);
        }
        this.E = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ENGLISH);
        this.v.setAdapter((ListAdapter) this.p);
        this.v.setOnItemClickListener(new l());
    }

    private void K() {
        this.s = true;
        this.w = 1;
        this.z.a(false);
        if (!TextUtils.isEmpty(this.y)) {
            O();
        } else {
            N();
        }
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.s) {
            return;
        }
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        HashMap<String, String> hashMap = new HashMap<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.B.size(); i2++) {
            stringBuffer.append(this.B.get(i2).b());
            if (i2 != this.B.size() - 1) {
                stringBuffer.append(",");
            }
        }
        hashMap.put(ParamConst.BATCH_PREVUE_LIST_REQ_CHANNELCODES, stringBuffer.toString());
        LogEx.d("SearchLiveFragment", " request channelcodes is " + stringBuffer.toString());
        new SDKPrevueMgr().getCurrentPrevue(hashMap, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.u = true;
        ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList = this.B;
        if (arrayList != null && this.w == 1) {
            arrayList.clear();
            this.p.notifyDataSetChanged();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("condition", this.q);
        hashMap.put("conditiontype", "16|17|18|19|20|21");
        hashMap.put("contenttype", "2");
        hashMap.put("languagetype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put("pageno", String.valueOf(this.w));
        hashMap.put("numperpage", "15");
        hashMap.put("contentcode", com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL));
        new SDKSearchMgr().searchProgramListByEPG(hashMap, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.u = true;
        int i2 = 0;
        if (TextUtils.isEmpty(this.q)) {
            this.u = false;
            this.V.sendEmptyMessage(0);
            return;
        }
        ArrayList<com.zte.iptvclient.android.common.javabean.models.f> arrayList = this.B;
        if (arrayList != null && this.w == 1) {
            arrayList.clear();
            this.p.notifyDataSetChanged();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("condition", this.q);
        hashMap.put("conditiontype", "16|17|18|19|20|21");
        if (ConfigMgr.readPropertie("SearchType_Chinese") != null && ConfigMgr.readPropertie("SearchType_Chinese").equals("1")) {
            hashMap.put("searchtype", "0");
        } else {
            hashMap.put("searchtype", "2");
        }
        hashMap.put("platformid", "0");
        hashMap.put("languagetype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put("pageno", String.valueOf(this.w));
        hashMap.put("numperpage", "15");
        hashMap.put("contenttype", "2");
        hashMap.put("contentcode", com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL));
        hashMap.put("subtype", "");
        hashMap.put("filtertype", "2|5");
        hashMap.put("mediaservices", "2");
        if (this.C.t() != 0) {
            this.R = 0;
            this.S = 0;
            String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_VALUE);
            if (!TextUtils.isEmpty(propertiesInfo)) {
                this.U = propertiesInfo.split(",");
                this.T = propertiesInfo.substring(0, propertiesInfo.lastIndexOf(",")).split(",");
            }
            int i3 = 0;
            while (true) {
                String[] strArr = this.T;
                if (i3 >= strArr.length) {
                    break;
                }
                this.R += Integer.parseInt(strArr[i3]);
                i3++;
            }
            while (true) {
                String[] strArr2 = this.U;
                if (i2 >= strArr2.length) {
                    break;
                }
                this.S += Integer.parseInt(strArr2[i2]);
                i2++;
            }
            hashMap.put("ratingid", String.valueOf(this.S - this.R));
        }
        if (TextUtils.isEmpty(this.P) && TextUtils.isEmpty(this.Q)) {
            hashMap.put("ordertype", "0");
        } else if (!TextUtils.isEmpty(this.P)) {
            hashMap.put("ordertype", this.P);
            LogEx.d("SearchLiveFragment", "ordertype mStrLetterSort =" + this.P);
        } else {
            hashMap.put("ordertype", this.Q);
            LogEx.d("SearchLiveFragment", "ordertype mStrTimeSort =" + this.Q);
        }
        SDKSearchMgr sDKSearchMgr = new SDKSearchMgr();
        if (!TextUtils.isEmpty(this.y)) {
            sDKSearchMgr.setServerDomain(this.y);
        }
        sDKSearchMgr.searchProgramList(hashMap, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.p.notifyDataSetChanged();
        this.z.a();
        this.z.j();
        if (this.B.size() == 0) {
            this.A.setVisibility(0);
            this.v.setVisibility(8);
        } else {
            this.A.setVisibility(8);
            this.v.setVisibility(0);
        }
    }

    private void d(View view) {
        ListView listView = (ListView) view.findViewById(R.id.search_live_lv);
        this.v = listView;
        com.zte.iptvclient.common.uiframe.f.a(listView);
        this.z = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.A = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.G = (RelativeLayout) view.findViewById(R.id.rl_lineup);
        this.J = (RelativeLayout) view.findViewById(R.id.lineup_two);
        this.K = (RelativeLayout) view.findViewById(R.id.lineup_one);
        this.M = (TextView) view.findViewById(R.id.txt_lineup_one);
        this.L = (TextView) view.findViewById(R.id.txt_lineup_two);
        this.N = (ImageView) view.findViewById(R.id.img_lineup_one);
        this.O = (ImageView) view.findViewById(R.id.img_lineup_two);
        com.zte.iptvclient.common.uiframe.f.a(this.G);
        com.zte.iptvclient.common.uiframe.f.a(this.J);
        com.zte.iptvclient.common.uiframe.f.a(this.K);
        com.zte.iptvclient.common.uiframe.f.a(this.K.findViewById(R.id.img_lineup_one));
        com.zte.iptvclient.common.uiframe.f.a(this.K.findViewById(R.id.txt_lineup_one));
        com.zte.iptvclient.common.uiframe.f.a(this.J.findViewById(R.id.txt_lineup_two));
        com.zte.iptvclient.common.uiframe.f.a(this.J.findViewById(R.id.img_lineup_two));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.refresh_image));
        ((TextView) this.A.findViewById(R.id.txt_pullrefresh)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_not_found));
        this.A.setVisibility(8);
        this.z.a(new DefaultRefreshHeader(this.h));
        this.z.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.z;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.z;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.z.c(false);
        this.z.a(new h());
        this.z.a(new i());
        this.z.setOnTouchListener(this);
        this.A.setOnTouchListener(this);
        this.v.setOnTouchListener(this);
        this.K.setOnClickListener(new j());
        this.J.setOnClickListener(new k());
    }

    private String s(String str) {
        ArrayList<Channel> c2 = com.zte.iptvclient.android.common.j.i.d().c();
        if (c2 != null) {
            Iterator<Channel> it2 = c2.iterator();
            while (it2.hasNext()) {
                Channel next = it2.next();
                if (TextUtils.equals(next.getChannelcode(), str)) {
                    String customsort = next.getCustomsort();
                    while (customsort.length() < 3) {
                        customsort = "0" + customsort;
                    }
                    return customsort;
                }
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        int i2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.x = jSONObject.getInt("totalpages");
            JSONArray optJSONArray = jSONObject.optJSONArray("contentcode");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("contenttype");
            JSONArray optJSONArray3 = jSONObject.optJSONArray("subtype");
            JSONArray optJSONArray4 = jSONObject.optJSONArray("subjectcode");
            JSONArray optJSONArray5 = jSONObject.optJSONArray("subjectname");
            JSONArray optJSONArray6 = jSONObject.optJSONArray("channelcode");
            JSONArray optJSONArray7 = jSONObject.optJSONArray("programcode");
            JSONArray optJSONArray8 = jSONObject.optJSONArray("starttime");
            JSONArray optJSONArray9 = jSONObject.optJSONArray("endtime");
            JSONArray optJSONArray10 = jSONObject.optJSONArray("ratingid");
            JSONArray optJSONArray11 = jSONObject.optJSONArray("cpcode");
            JSONArray optJSONArray12 = jSONObject.optJSONArray("postfilelist");
            JSONArray optJSONArray13 = jSONObject.optJSONArray("seriesnum");
            JSONArray optJSONArray14 = jSONObject.optJSONArray("actor");
            JSONArray optJSONArray15 = jSONObject.optJSONArray("genre");
            JSONArray optJSONArray16 = jSONObject.optJSONArray("subgenre");
            JSONArray optJSONArray17 = jSONObject.optJSONArray("releasedate");
            JSONArray optJSONArray18 = jSONObject.optJSONArray("elapsedtime");
            JSONArray optJSONArray19 = jSONObject.optJSONArray("prevuecode");
            JSONArray optJSONArray20 = jSONObject.optJSONArray("countryname");
            JSONArray optJSONArray21 = jSONObject.optJSONArray("director");
            JSONArray optJSONArray22 = jSONObject.optJSONArray("toppick");
            JSONArray optJSONArray23 = jSONObject.optJSONArray("contentname");
            JSONArray jSONArray3 = optJSONArray12;
            JSONArray optJSONArray24 = jSONObject.optJSONArray("channelname");
            JSONArray optJSONArray25 = jSONObject.optJSONArray("mediaservice");
            JSONArray optJSONArray26 = jSONObject.optJSONArray("markfilename");
            JSONArray optJSONArray27 = jSONObject.optJSONArray("isfavorite");
            int i3 = jSONObject.getInt("totalcount");
            if (i3 > Integer.valueOf("15").intValue()) {
                i3 = Integer.valueOf("15").intValue();
            }
            int i4 = 0;
            while (i4 < i3) {
                com.zte.iptvclient.android.common.javabean.models.f fVar = new com.zte.iptvclient.android.common.javabean.models.f();
                if (optJSONArray != null) {
                    i2 = i3;
                    fVar.d(optJSONArray.get(i4).toString());
                } else {
                    i2 = i3;
                }
                if (optJSONArray23 != null) {
                    fVar.e(optJSONArray23.get(i4).toString());
                }
                if (optJSONArray2 != null) {
                    fVar.f(optJSONArray2.get(i4).toString());
                }
                if (optJSONArray3 != null) {
                    fVar.F(optJSONArray3.get(i4).toString());
                }
                if (optJSONArray4 != null) {
                    fVar.D(optJSONArray4.get(i4).toString());
                }
                if (optJSONArray5 != null) {
                    fVar.E(optJSONArray5.get(i4).toString());
                }
                if (optJSONArray6 != null) {
                    fVar.b(optJSONArray6.get(i4).toString());
                    fVar.H(s(optJSONArray6.get(i4).toString()));
                }
                if (optJSONArray7 != null) {
                    fVar.t(optJSONArray7.get(i4).toString());
                }
                if (optJSONArray8 != null) {
                    fVar.B(optJSONArray8.get(i4).toString());
                }
                if (optJSONArray9 != null) {
                    fVar.k(optJSONArray9.get(i4).toString());
                }
                if (optJSONArray10 != null) {
                    fVar.u(optJSONArray10.get(i4).toString());
                }
                if (optJSONArray11 != null) {
                    fVar.h(optJSONArray11.get(i4).toString());
                }
                if (jSONArray3 != null) {
                    JSONArray jSONArray4 = jSONArray3;
                    jSONArray = jSONArray4;
                    fVar.q(jSONArray4.get(i4).toString());
                } else {
                    jSONArray = jSONArray3;
                }
                if (optJSONArray13 != null) {
                    fVar.A(optJSONArray13.get(i4).toString());
                }
                if (optJSONArray14 != null) {
                    JSONArray jSONArray5 = optJSONArray14;
                    jSONArray2 = jSONArray5;
                    fVar.a(jSONArray5.get(i4).toString());
                } else {
                    jSONArray2 = optJSONArray14;
                }
                if (optJSONArray15 != null) {
                    fVar.l(optJSONArray15.get(i4).toString());
                }
                if (optJSONArray16 != null) {
                    fVar.C(optJSONArray16.get(i4).toString());
                }
                if (optJSONArray17 != null) {
                    fVar.w(optJSONArray17.get(i4).toString());
                }
                if (optJSONArray18 != null) {
                    fVar.j(optJSONArray18.get(i4).toString());
                }
                if (optJSONArray19 != null) {
                    fVar.r(optJSONArray19.get(i4).toString());
                }
                if (optJSONArray20 != null) {
                    fVar.g(optJSONArray20.get(i4).toString());
                }
                if (optJSONArray21 != null) {
                    fVar.i(optJSONArray21.get(i4).toString());
                }
                if (optJSONArray22 != null) {
                    fVar.G(optJSONArray22.get(i4).toString());
                }
                if (optJSONArray23 != null) {
                    fVar.e(optJSONArray23.get(i4).toString());
                }
                if (optJSONArray24 != null) {
                    fVar.c(optJSONArray24.get(i4).toString());
                }
                if (optJSONArray25 != null) {
                    fVar.o(optJSONArray25.get(i4).toString());
                }
                if (optJSONArray26 != null) {
                    fVar.n(optJSONArray26.get(i4).toString());
                }
                if (optJSONArray27 != null) {
                    fVar.m(optJSONArray27.get(i4).toString());
                }
                this.B.add(fVar);
                i4++;
                optJSONArray14 = jSONArray2;
                jSONArray3 = jSONArray;
                i3 = i2;
            }
        } catch (Exception e2) {
            LogEx.e("SearchLiveFragment", e2.getMessage());
        }
    }

    public void I() {
        this.t = true;
        ArrayList<Channel> arrayList = this.D;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
        SDKFavoriteMgr sDKFavoriteMgr = new SDKFavoriteMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("favoritetype", DownloadConstant.REPORT_MSGTYPE_ADD);
        sDKFavoriteMgr.getUserFavoriteList(hashMap, new c(b2));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if (cVar.a().equals("0")) {
            L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<PrevueBean> arrayList) {
        if (arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < this.B.size() && this.B.get(i2) != null; i2++) {
            Iterator<PrevueBean> it2 = arrayList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    PrevueBean next = it2.next();
                    if (TextUtils.equals(this.B.get(i2).b(), next.getChannelcode())) {
                        this.B.get(i2).r(next.getPrevuecode());
                        this.B.get(i2).s(next.getPrevuename());
                        this.B.get(i2).B(next.getBegintime());
                        this.B.get(i2).k(next.getEndtime());
                        this.B.get(i2).J(next.getUtcbegintime());
                        this.B.get(i2).I(next.getUtcendtime());
                        break;
                    }
                }
            }
        }
        this.F = com.zte.iptvclient.android.common.j.i.d().c();
        for (int i3 = 0; i3 < this.B.size(); i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.F.size()) {
                    break;
                }
                if (this.B.get(i3).b().equals(this.F.get(i4).getChannelcode())) {
                    this.B.get(i3).p(this.F.get(i4).getMixno());
                    break;
                }
                i4++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(JSONObject jSONObject) throws ParseException {
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("begintime")) || TextUtils.isEmpty(jSONObject.optString("endtime"))) {
            return false;
        }
        Date parse = this.E.parse(jSONObject.optString("begintime"));
        Date parse2 = this.E.parse(jSONObject.optString("endtime"));
        Date now = TimeUtil.getNow();
        LogEx.d("SearchLiveFragment", "startDate=" + parse + "; endDate=" + parse2 + "curentDate=" + now);
        if (now.before(parse) || now.after(parse2)) {
            return false;
        }
        LogEx.d("SearchLiveFragment", "startDate=" + parse + "; curentDate=" + now + "endDate=" + parse2 + " isCurrentTime=false");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.zte.iptvclient.android.common.javabean.models.f fVar, ImageView imageView) {
        SDKFavoriteMgr sDKFavoriteMgr = new SDKFavoriteMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("favoritetype", DownloadConstant.REPORT_MSGTYPE_ADD);
        hashMap.put("contentcode", fVar.b());
        hashMap.put("columncode", com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL));
        sDKFavoriteMgr.doAddFavorite(hashMap, new a(fVar, imageView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.zte.iptvclient.android.common.javabean.models.f fVar, ImageView imageView) {
        SDKFavoriteMgr sDKFavoriteMgr = new SDKFavoriteMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ParamConst.FAVORITE_DELETE_BATCH_REQ_FAVORITETYPES, DownloadConstant.REPORT_MSGTYPE_ADD);
        hashMap.put("contentcodes", fVar.b());
        hashMap.put("columncodes", com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL));
        sDKFavoriteMgr.doDelFavorite(hashMap, new C0372b(fVar, imageView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.r <= i2) {
            LogEx.w("UseeTv", "Operate limit,less than " + i2 + "(ms)!");
            return true;
        }
        this.r = currentTimeMillis;
        return false;
    }
}
