package com.zte.iptvclient.android.mobile.f.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.lock.SDKLockMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AtTvChannelsLockFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private static HashMap<String, String> O;
    private ArrayList<String> A;
    private ArrayList<String> B;
    private ArrayList<String> C;
    private String D;
    private ArrayList<Channel> E;
    private ArrayList<Channel> F;
    private h G;
    private String J;
    private boolean K;
    private ArrayList<Boolean> L;
    private ArrayList<String> M;
    private com.zte.iptvclient.android.common.j.h N;
    private LinearLayout p;
    private RelativeLayout q;
    private Button r;
    private TextView s;
    private TextView t;
    private LinearLayout u;
    private ListView v;
    private LinearLayout w;
    private CheckBox x;
    private TextView y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtTvChannelsLockFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtTvChannelsLockFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.f.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0246b implements View.OnClickListener {
        ViewOnClickListenerC0246b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.x.isSelected()) {
                b.this.x.setSelected(false);
            } else {
                b.this.x.setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtTvChannelsLockFragment.java */
    /* loaded from: classes.dex */
    public class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((String) b.this.M.get(i)).equals("1")) {
                b.this.M.set(i, "0");
                ((Channel) b.this.E.get(i)).setAfterChannelLock("1");
            } else {
                b.this.M.set(i, "1");
                ((Channel) b.this.E.get(i)).setAfterChannelLock("0");
            }
            b.this.G.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtTvChannelsLockFragment.java */
    /* loaded from: classes.dex */
    public class d extends TimerTask {
        d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com.zte.iptvclient.android.mobile.f.b.a.b(((com.zte.fragmentlib.b) b.this).h);
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.change_tv_channel_lock);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtTvChannelsLockFragment.java */
    /* loaded from: classes.dex */
    public class e implements SDKLockMgr.OnAddLockReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Channel f6159a;

        e(b bVar, Channel channel) {
            this.f6159a = channel;
        }

        @Override // com.video.androidsdk.service.lock.SDKLockMgr.OnAddLockReturnListener
        public void onAddLockReturn(String str, String str2) {
            if ("0".equals(str)) {
                this.f6159a.setIsChannelLock("1");
                this.f6159a.setAfterChannelLock("1");
            } else {
                Channel channel = this.f6159a;
                channel.setAfterChannelLock(channel.getIsChannelLock());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtTvChannelsLockFragment.java */
    /* loaded from: classes.dex */
    public class f implements SDKLockMgr.OnDelLockReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Channel f6160a;

        f(b bVar, Channel channel) {
            this.f6160a = channel;
        }

        @Override // com.video.androidsdk.service.lock.SDKLockMgr.OnDelLockReturnListener
        public void onDelLockReturn(String str, String str2) {
            if (TextUtils.equals("0", str)) {
                this.f6160a.setIsChannelLock("0");
                this.f6160a.setAfterChannelLock("0");
            } else {
                Channel channel = this.f6160a;
                channel.setAfterChannelLock(channel.getIsChannelLock());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AtTvChannelsLockFragment.java */
    /* loaded from: classes.dex */
    public class g implements SDKLockMgr.OnUserLockListReturnListener {
        g() {
        }

        @Override // com.video.androidsdk.service.lock.SDKLockMgr.OnUserLockListReturnListener
        public void onUserLockMarkListReturn(String str, String str2, String str3) {
            if (TextUtils.equals(str, "0") || TextUtils.equals(str, "50991021")) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    if ("0".equals(jSONObject.optString("returncode"))) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("contentcode");
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("blocktitleenable");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            if ("1".equals(optJSONArray2.get(i).toString())) {
                                b.O.put(optJSONArray.get(i).toString(), "1");
                            } else {
                                b.O.put(optJSONArray.get(i).toString(), "0");
                            }
                        }
                        com.zte.iptvclient.android.common.j.e.b().a(b.O);
                    } else if (TextUtils.equals(jSONObject.optString("returncode"), "50991021")) {
                        com.zte.iptvclient.android.common.j.e.b().a(b.O);
                    }
                    b.this.J();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AtTvChannelsLockFragment.java */
    /* loaded from: classes.dex */
    public class h extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private List<Channel> f6162a;

        public h(Context context, ArrayList<Channel> arrayList) {
            this.f6162a = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<Channel> list = this.f6162a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f6162a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            i iVar;
            String mixno;
            if (view == null) {
                view = View.inflate(((com.zte.fragmentlib.b) b.this).h, R.layout.at_lock_tvchannels_item, null);
                iVar = new i();
                iVar.f6164a = (LinearLayout) view.findViewById(R.id.ll_tv_lock_item);
                iVar.f6165b = (CheckBox) view.findViewById(R.id.tv_lock_selector);
                iVar.f6166c = (ImageView) view.findViewById(R.id.tv_lock_icon);
                iVar.f6167d = (LinearLayout) view.findViewById(R.id.tv_lock_rightll);
                iVar.e = (RelativeLayout) view.findViewById(R.id.tv_lock_contentll);
                iVar.f = (TextView) view.findViewById(R.id.lock_tv_name);
                iVar.g = (ImageView) view.findViewById(R.id.lock_img);
                iVar.h = (ImageView) view.findViewById(R.id.img_divider);
                com.zte.iptvclient.common.uiframe.f.a(iVar.f6164a);
                com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.tv_lock_icon_container));
                com.zte.iptvclient.common.uiframe.f.a(iVar.f6165b);
                com.zte.iptvclient.common.uiframe.f.a(iVar.f6166c);
                com.zte.iptvclient.common.uiframe.f.a(iVar.f6167d);
                com.zte.iptvclient.common.uiframe.f.a(iVar.e);
                com.zte.iptvclient.common.uiframe.f.a(iVar.f);
                com.zte.iptvclient.common.uiframe.f.a(iVar.g);
                com.zte.iptvclient.common.uiframe.f.a(iVar.h);
                view.setTag(iVar);
            } else {
                iVar = (i) view.getTag();
            }
            if (!TextUtils.isEmpty(this.f6162a.get(i).getCustomsort())) {
                mixno = this.f6162a.get(i).getCustomsort();
            } else {
                mixno = this.f6162a.get(i).getMixno();
            }
            String str = "0";
            if (!TextUtils.isEmpty(mixno)) {
                while (mixno.length() < 3) {
                    mixno = "0" + mixno;
                }
                str = mixno;
            }
            iVar.f.setText(str + " " + this.f6162a.get(i).getChannelname());
            try {
                String posterimage = this.f6162a.get(i).getPosterimage();
                com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.a((FragmentActivity) ((com.zte.fragmentlib.b) b.this).h).a(d.e.a.a.c.a() + posterimage.substring(1));
                a2.a(R.drawable.default_video_thumb);
                a2.b(126, 94);
                a2.a(iVar.f6166c);
            } catch (Exception e) {
                LogEx.e("TvChannelsLockFragmentN", e.getMessage());
            }
            if (((String) b.this.M.get(i)).equals("1")) {
                iVar.f6165b.setChecked(true);
            } else {
                iVar.f6165b.setChecked(false);
            }
            return view;
        }
    }

    /* compiled from: AtTvChannelsLockFragment.java */
    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        LinearLayout f6164a;

        /* renamed from: b, reason: collision with root package name */
        CheckBox f6165b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f6166c;

        /* renamed from: d, reason: collision with root package name */
        LinearLayout f6167d;
        RelativeLayout e;
        TextView f;
        ImageView g;
        ImageView h;
    }

    private void L() {
        try {
            JSONArray jSONArray = new JSONArray(this.z);
            if (jSONArray.length() != 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    String str = (String) jSONObject.get("channelcode");
                    String str2 = (String) jSONObject.get("mixno");
                    String str3 = (String) jSONObject.get("isblocktitle");
                    this.A.add(str);
                    this.B.add(str2);
                    this.C.add(str3);
                }
                if (this.C != null) {
                    this.D = this.C.get(0);
                }
                if (this.D == null) {
                    this.K = false;
                } else if (this.D.equals("1")) {
                    this.K = true;
                } else if (this.D.equals("0")) {
                    this.K = false;
                }
                this.x.setChecked(this.K);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void M() {
        ArrayList<Channel> arrayList = this.F;
        if (arrayList != null) {
            Iterator<Channel> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Channel next = it2.next();
                if (next.getColumncode().equals(this.J)) {
                    this.E.add(next);
                    this.L.add(Boolean.FALSE);
                    this.M.add("0");
                }
            }
            N();
        }
    }

    private void N() {
        O = new HashMap<>();
        SDKLockMgr sDKLockMgr = new SDKLockMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "500");
        hashMap.put("limittype", DownloadConstant.REPORT_MSGTYPE_ADD);
        hashMap.put("state", "1");
        sDKLockMgr.getUserLockList(hashMap, new g());
    }

    private void O() {
        this.r.setOnClickListener(new a());
        this.x.setOnClickListener(new ViewOnClickListenerC0246b());
        this.v.setOnItemClickListener(new c());
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        I();
        if (getActivity() instanceof MainActivity) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a("parentcontral", true));
        } else if (getActivity() instanceof HostActivity) {
            getActivity().finish();
        }
        return true;
    }

    public void I() {
        boolean z = false;
        for (int i2 = 0; i2 < this.E.size(); i2++) {
            Channel channel = this.E.get(i2);
            if (!this.M.get(i2).equals(channel.getAfterChannelLock())) {
                if (this.M.get(i2).equals("0")) {
                    a(channel);
                } else {
                    a(channel, "1");
                }
                z = true;
            }
        }
        if (z) {
            new Timer().schedule(new d(), 1000L);
        }
    }

    public void J() {
        HashMap<String, String> a2 = com.zte.iptvclient.android.common.j.e.b().a();
        if (a2 == null || a2.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < this.E.size(); i2++) {
            this.M.set(i2, this.E.get(i2).getAfterChannelLock());
        }
        this.G.notifyDataSetChanged();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        L();
        this.A = new ArrayList<>();
        this.B = new ArrayList<>();
        this.E = new ArrayList<>();
        this.C = new ArrayList<>();
        this.L = new ArrayList<>();
        this.M = new ArrayList<>();
        this.J = "";
        this.F = new ArrayList<>();
        this.F = com.zte.iptvclient.android.common.j.i.d().c();
        this.J = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL);
        this.G = new h(this.h, this.E);
        M();
        this.v.setAdapter((ListAdapter) this.G);
        O();
        com.zte.iptvclient.android.common.j.h hVar = new com.zte.iptvclient.android.common.j.h(this.h);
        this.N = hVar;
        if (TextUtils.equals(hVar.e(), "1")) {
            this.x.setChecked(true);
        } else {
            this.x.setChecked(false);
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d("TvChannelsLockFragmentN", "onCreate");
        this.z = getArguments().getString("channels", "");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tvchanel_lock, viewGroup, false);
        d(inflate);
        return inflate;
    }

    private void a(Channel channel, String str) {
        SDKLockMgr sDKLockMgr = new SDKLockMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("limittype", DownloadConstant.REPORT_MSGTYPE_ADD);
        hashMap.put("contentcode", channel.getChannelcode());
        hashMap.put("isshared", com.zte.iptvclient.common.uiframe.a.c(com.video.androidsdk.common.PortalConst.STR_IS_SHARE));
        if (TextUtils.equals(ConfigMgr.readPropertie("IsShowBlockTitle"), "1")) {
            hashMap.put("blocktitleenable", str);
        }
        sDKLockMgr.doAddLock(hashMap, new e(this, channel));
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.p = (LinearLayout) view.findViewById(R.id.lock_linearLayout_header);
        this.q = (RelativeLayout) view.findViewById(R.id.lock_nomal);
        this.r = (Button) view.findViewById(R.id.btn_back);
        this.s = (TextView) view.findViewById(R.id.lock_nomal_title);
        this.t = (TextView) view.findViewById(R.id.lock_nomal_btn_edit);
        this.u = (LinearLayout) view.findViewById(R.id.ll_tv_channel_lock);
        this.v = (ListView) view.findViewById(R.id.tv_lock_lv);
        this.w = (LinearLayout) view.findViewById(R.id.ll_blocktitle);
        this.x = (CheckBox) view.findViewById(R.id.cb_block);
        this.y = (TextView) view.findViewById(R.id.txt_block);
        this.y = (TextView) view.findViewById(R.id.channel_lock_point);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_pcb_title));
        this.t.setVisibility(8);
        this.w.setVisibility(8);
        this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_edit));
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (BaseApp.a(this.h)) {
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
        }
    }

    private void a(Channel channel) {
        SDKLockMgr sDKLockMgr = new SDKLockMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("limittype", DownloadConstant.REPORT_MSGTYPE_ADD);
        hashMap.put("contentcode", channel.getChannelcode());
        hashMap.put("isshared", com.zte.iptvclient.common.uiframe.a.c(com.video.androidsdk.common.PortalConst.STR_IS_SHARE));
        sDKLockMgr.doDelLock(hashMap, new f(this, channel));
    }
}
