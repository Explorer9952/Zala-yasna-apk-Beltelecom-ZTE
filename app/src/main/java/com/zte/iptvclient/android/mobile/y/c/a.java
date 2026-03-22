package com.zte.iptvclient.android.mobile.y.c;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.a.h;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PlayFileSettingFragment.java */
/* loaded from: classes2.dex */
public class a extends com.zte.fragmentlib.b {
    private static ArrayList<String> w = new ArrayList<>();
    private SupportActivity p;
    private ImageView q;
    private TextView r;
    private GridView s;
    private f t;
    private SmartRefreshLayout u;
    private LinkedHashMap<String, ArrayList<VideoDetailBean>> v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayFileSettingFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.y.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0399a implements com.scwang.smartrefresh.layout.d.c {
        C0399a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(h hVar) {
            a.this.L();
            a.this.u.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayFileSettingFragment.java */
    /* loaded from: classes2.dex */
    public class b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.getInt("resultcode") == 0) {
                        JSONArray jSONArray = new JSONArray(Uri.decode(jSONObject.getString("datavalue")));
                        for (int i = 0; i < jSONArray.length(); i++) {
                            ArrayList arrayList = new ArrayList();
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("listName");
                            JSONArray optJSONArray = jSONObject2.optJSONArray("data");
                            if (optJSONArray == null) {
                                a.this.v.put(optString, null);
                            } else {
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                                    VideoDetailBean videoDetailBean = new VideoDetailBean();
                                    videoDetailBean.setProgramcode(jSONObject3.optString("programcode"));
                                    videoDetailBean.setPosterfilelist(jSONObject3.optString(ParamConst.COLUMN_INFO_RSP_NORMALPOSTER));
                                    videoDetailBean.setProgramname(jSONObject3.optString("programname"));
                                    arrayList.add(videoDetailBean);
                                }
                                a.this.v.put(optString, arrayList);
                            }
                            if (a.this.t != null) {
                                a.this.t.notifyDataSetChanged();
                            } else {
                                a.this.t = new f(a.this.p);
                                a.this.s.setAdapter((ListAdapter) a.this.t);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayFileSettingFragment.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayFileSettingFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayFileSettingFragment.java */
    /* loaded from: classes2.dex */
    public class e implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        e(a aVar) {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("PlayingFileSettingFragment", "del return:" + str);
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.w.a());
            com.zte.iptvclient.android.mobile.h.a.a.g().a(1, 0, 0, 6, "");
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("PlayingFileSettingFragment", "del fail:" + str);
        }
    }

    /* compiled from: PlayFileSettingFragment.java */
    /* loaded from: classes2.dex */
    class f extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private SupportActivity f7802a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<String> f7803b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        private LayoutInflater f7804c;

        /* compiled from: PlayFileSettingFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.y.c.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class ViewOnClickListenerC0400a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f7806a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f7807b;

            ViewOnClickListenerC0400a(int i, b bVar) {
                this.f7806a = i;
                this.f7807b = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.f7803b.clear();
                f.this.f7803b.addAll(a.this.v.keySet());
                a.this.v.remove(f.this.f7803b.get(this.f7806a));
                this.f7807b.f7809a.setText("");
                this.f7807b.f7810b.setText("");
                this.f7807b.f7809a.setVisibility(8);
                this.f7807b.f7810b.setVisibility(8);
                f.this.notifyDataSetChanged();
                a aVar = a.this;
                aVar.t(aVar.I().toString());
            }
        }

        /* compiled from: PlayFileSettingFragment.java */
        /* loaded from: classes2.dex */
        class b {

            /* renamed from: a, reason: collision with root package name */
            public TextView f7809a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f7810b;

            /* renamed from: c, reason: collision with root package name */
            public ImageView f7811c;

            /* renamed from: d, reason: collision with root package name */
            public ImageView f7812d;
            public ImageView e;
            public ImageView f;
            public ImageView g;
            public ImageView h;
            public ImageView i;
            public RelativeLayout j;
            private LinearLayout k;

            public b(f fVar) {
            }
        }

        public f(SupportActivity supportActivity) {
            this.f7802a = supportActivity;
            this.f7804c = LayoutInflater.from(supportActivity);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (a.this.v == null) {
                return 0;
            }
            return a.this.v.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            View view2;
            if (view == null) {
                bVar = new b(this);
                view2 = this.f7804c.inflate(R.layout.movie_file_show_one, viewGroup, false);
                bVar.f7809a = (TextView) view2.findViewById(R.id.tv_list_name_movie_file);
                bVar.f7810b = (TextView) view2.findViewById(R.id.tv_list_num_movie_file);
                bVar.f7811c = (ImageView) view2.findViewById(R.id.iv_delete_movie_setting);
                bVar.j = (RelativeLayout) view2.findViewById(R.id.fl_movie_setting);
                bVar.f7812d = (ImageView) view2.findViewById(R.id.iv_file_one);
                bVar.e = (ImageView) view2.findViewById(R.id.iv_file_two);
                bVar.f = (ImageView) view2.findViewById(R.id.iv_file_three);
                bVar.g = (ImageView) view2.findViewById(R.id.iv_file_four);
                bVar.h = (ImageView) view2.findViewById(R.id.iv_file_five);
                bVar.i = (ImageView) view2.findViewById(R.id.iv_file_six);
                bVar.k = (LinearLayout) view2.findViewById(R.id.ll_all_play_list_image);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7809a);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7810b);
                com.zte.iptvclient.common.uiframe.f.a(bVar.f7811c);
                com.zte.iptvclient.common.uiframe.f.a(bVar.j);
                view2.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            this.f7803b.clear();
            this.f7803b.addAll(a.this.v.keySet());
            if (this.f7803b.size() > 0) {
                bVar.f7809a.setText(this.f7803b.get(i));
                ArrayList arrayList = (ArrayList) a.this.v.get(this.f7803b.get(i));
                if (arrayList == null) {
                    bVar.k.setVisibility(4);
                    bVar.f7812d.setVisibility(4);
                    bVar.e.setVisibility(4);
                    bVar.f.setVisibility(4);
                    bVar.g.setVisibility(4);
                    bVar.h.setVisibility(4);
                    bVar.i.setVisibility(4);
                    bVar.f7810b.setText("0movies");
                } else if (arrayList.size() == 1) {
                    bVar.k.setVisibility(0);
                    bVar.f7812d.setVisibility(0);
                    bVar.e.setVisibility(4);
                    bVar.f.setVisibility(4);
                    bVar.g.setVisibility(4);
                    bVar.h.setVisibility(4);
                    bVar.i.setVisibility(4);
                    com.bumptech.glide.d<String> a2 = i.a((FragmentActivity) this.f7802a).a(a.this.u(((VideoDetailBean) arrayList.get(0)).getPosterfilelist()));
                    a2.a(DiskCacheStrategy.ALL);
                    a2.b(R.drawable.default_poster_thumb);
                    a2.a(R.drawable.default_poster_thumb);
                    a2.c(300);
                    a2.a(bVar.f7812d);
                    bVar.f7810b.setText(arrayList.size() + "movies");
                } else if (arrayList.size() == 2) {
                    bVar.k.setVisibility(0);
                    bVar.f7812d.setVisibility(0);
                    bVar.e.setVisibility(0);
                    bVar.f.setVisibility(4);
                    bVar.g.setVisibility(4);
                    bVar.h.setVisibility(4);
                    bVar.i.setVisibility(4);
                    String u = a.this.u(((VideoDetailBean) arrayList.get(0)).getPosterfilelist());
                    String u2 = a.this.u(((VideoDetailBean) arrayList.get(1)).getPosterfilelist());
                    com.bumptech.glide.d<String> a3 = i.a((FragmentActivity) this.f7802a).a(u);
                    a3.a(DiskCacheStrategy.ALL);
                    a3.b(R.drawable.default_poster_thumb);
                    a3.a(R.drawable.default_poster_thumb);
                    a3.c(300);
                    a3.a(bVar.f7812d);
                    com.bumptech.glide.d<String> a4 = i.a((FragmentActivity) this.f7802a).a(u2);
                    a4.a(DiskCacheStrategy.ALL);
                    a4.b(R.drawable.default_poster_thumb);
                    a4.a(R.drawable.default_poster_thumb);
                    a4.c(300);
                    a4.a(bVar.e);
                    bVar.f7810b.setText(arrayList.size() + "movies");
                } else if (arrayList.size() == 3) {
                    bVar.k.setVisibility(0);
                    bVar.f7812d.setVisibility(0);
                    bVar.e.setVisibility(0);
                    bVar.f.setVisibility(0);
                    bVar.g.setVisibility(4);
                    bVar.h.setVisibility(4);
                    bVar.i.setVisibility(4);
                    String u3 = a.this.u(((VideoDetailBean) arrayList.get(0)).getPosterfilelist());
                    String u4 = a.this.u(((VideoDetailBean) arrayList.get(1)).getPosterfilelist());
                    String u5 = a.this.u(((VideoDetailBean) arrayList.get(2)).getPosterfilelist());
                    com.bumptech.glide.d<String> a5 = i.a((FragmentActivity) this.f7802a).a(u3);
                    a5.a(DiskCacheStrategy.ALL);
                    a5.b(R.drawable.default_poster_thumb);
                    a5.a(R.drawable.default_poster_thumb);
                    a5.c(300);
                    a5.a(bVar.f7812d);
                    com.bumptech.glide.d<String> a6 = i.a((FragmentActivity) this.f7802a).a(u4);
                    a6.a(DiskCacheStrategy.ALL);
                    a6.b(R.drawable.default_poster_thumb);
                    a6.a(R.drawable.default_poster_thumb);
                    a6.c(300);
                    a6.a(bVar.e);
                    com.bumptech.glide.d<String> a7 = i.a((FragmentActivity) this.f7802a).a(u5);
                    a7.a(DiskCacheStrategy.ALL);
                    a7.b(R.drawable.default_poster_thumb);
                    a7.a(R.drawable.default_poster_thumb);
                    a7.c(300);
                    a7.a(bVar.f);
                    bVar.f7810b.setText(arrayList.size() + "movies");
                } else if (arrayList.size() == 4) {
                    bVar.k.setVisibility(0);
                    bVar.f7812d.setVisibility(0);
                    bVar.e.setVisibility(0);
                    bVar.f.setVisibility(0);
                    bVar.g.setVisibility(0);
                    bVar.h.setVisibility(4);
                    bVar.i.setVisibility(4);
                    String u6 = a.this.u(((VideoDetailBean) arrayList.get(0)).getPosterfilelist());
                    String u7 = a.this.u(((VideoDetailBean) arrayList.get(1)).getPosterfilelist());
                    String u8 = a.this.u(((VideoDetailBean) arrayList.get(2)).getPosterfilelist());
                    String u9 = a.this.u(((VideoDetailBean) arrayList.get(3)).getPosterfilelist());
                    com.bumptech.glide.d<String> a8 = i.a((FragmentActivity) this.f7802a).a(u6);
                    a8.a(DiskCacheStrategy.ALL);
                    a8.b(R.drawable.default_poster_thumb);
                    a8.a(R.drawable.default_poster_thumb);
                    a8.c(300);
                    a8.a(bVar.f7812d);
                    com.bumptech.glide.d<String> a9 = i.a((FragmentActivity) this.f7802a).a(u7);
                    a9.a(DiskCacheStrategy.ALL);
                    a9.b(R.drawable.default_poster_thumb);
                    a9.a(R.drawable.default_poster_thumb);
                    a9.c(300);
                    a9.a(bVar.e);
                    com.bumptech.glide.d<String> a10 = i.a((FragmentActivity) this.f7802a).a(u8);
                    a10.a(DiskCacheStrategy.ALL);
                    a10.b(R.drawable.default_poster_thumb);
                    a10.a(R.drawable.default_poster_thumb);
                    a10.c(300);
                    a10.a(bVar.f);
                    com.bumptech.glide.d<String> a11 = i.a((FragmentActivity) this.f7802a).a(u9);
                    a11.a(DiskCacheStrategy.ALL);
                    a11.b(R.drawable.default_poster_thumb);
                    a11.a(R.drawable.default_poster_thumb);
                    a11.c(300);
                    a11.a(bVar.g);
                    bVar.f7810b.setText(arrayList.size() + "movies");
                } else if (arrayList.size() == 5) {
                    bVar.k.setVisibility(0);
                    bVar.f7812d.setVisibility(0);
                    bVar.e.setVisibility(0);
                    bVar.f.setVisibility(0);
                    bVar.g.setVisibility(0);
                    bVar.h.setVisibility(0);
                    bVar.i.setVisibility(4);
                    com.bumptech.glide.d<String> a12 = i.a((FragmentActivity) this.f7802a).a(a.this.u(((VideoDetailBean) arrayList.get(0)).getPosterfilelist()));
                    a12.a(DiskCacheStrategy.ALL);
                    a12.b(R.drawable.default_poster_thumb);
                    a12.a(R.drawable.default_poster_thumb);
                    a12.c(300);
                    a12.a(bVar.f7812d);
                    com.bumptech.glide.d<String> a13 = i.a((FragmentActivity) this.f7802a).a(a.this.u(((VideoDetailBean) arrayList.get(1)).getPosterfilelist()));
                    a13.a(DiskCacheStrategy.ALL);
                    a13.b(R.drawable.default_poster_thumb);
                    a13.a(R.drawable.default_poster_thumb);
                    a13.c(300);
                    a13.a(bVar.e);
                    com.bumptech.glide.d<String> a14 = i.a((FragmentActivity) this.f7802a).a(a.this.u(((VideoDetailBean) arrayList.get(2)).getPosterfilelist()));
                    a14.a(DiskCacheStrategy.ALL);
                    a14.b(R.drawable.default_poster_thumb);
                    a14.a(R.drawable.default_poster_thumb);
                    a14.c(300);
                    a14.a(bVar.f);
                    com.bumptech.glide.d<String> a15 = i.a((FragmentActivity) this.f7802a).a(a.this.u(((VideoDetailBean) arrayList.get(3)).getPosterfilelist()));
                    a15.a(DiskCacheStrategy.ALL);
                    a15.b(R.drawable.default_poster_thumb);
                    a15.a(R.drawable.default_poster_thumb);
                    a15.c(300);
                    a15.a(bVar.g);
                    com.bumptech.glide.d<String> a16 = i.a((FragmentActivity) this.f7802a).a(a.this.u(((VideoDetailBean) arrayList.get(4)).getPosterfilelist()));
                    a16.a(DiskCacheStrategy.ALL);
                    a16.b(R.drawable.default_poster_thumb);
                    a16.a(R.drawable.default_poster_thumb);
                    a16.c(300);
                    a16.a(bVar.h);
                    bVar.f7810b.setText(arrayList.size() + "movies");
                } else if (arrayList.size() >= 6) {
                    bVar.k.setVisibility(0);
                    bVar.f7812d.setVisibility(0);
                    bVar.e.setVisibility(0);
                    bVar.f.setVisibility(0);
                    bVar.g.setVisibility(0);
                    bVar.h.setVisibility(0);
                    bVar.i.setVisibility(0);
                    com.bumptech.glide.d<String> a17 = i.a((FragmentActivity) this.f7802a).a(a.this.u(((VideoDetailBean) arrayList.get(0)).getPosterfilelist()));
                    a17.a(DiskCacheStrategy.ALL);
                    a17.b(R.drawable.default_poster_thumb);
                    a17.a(R.drawable.default_poster_thumb);
                    a17.c(300);
                    a17.a(bVar.f7812d);
                    com.bumptech.glide.d<String> a18 = i.a((FragmentActivity) this.f7802a).a(a.this.u(((VideoDetailBean) arrayList.get(1)).getPosterfilelist()));
                    a18.a(DiskCacheStrategy.ALL);
                    a18.b(R.drawable.default_poster_thumb);
                    a18.a(R.drawable.default_poster_thumb);
                    a18.c(300);
                    a18.a(bVar.e);
                    com.bumptech.glide.d<String> a19 = i.a((FragmentActivity) this.f7802a).a(a.this.u(((VideoDetailBean) arrayList.get(2)).getPosterfilelist()));
                    a19.a(DiskCacheStrategy.ALL);
                    a19.b(R.drawable.default_poster_thumb);
                    a19.a(R.drawable.default_poster_thumb);
                    a19.c(300);
                    a19.a(bVar.f);
                    com.bumptech.glide.d<String> a20 = i.a((FragmentActivity) this.f7802a).a(a.this.u(((VideoDetailBean) arrayList.get(3)).getPosterfilelist()));
                    a20.a(DiskCacheStrategy.ALL);
                    a20.b(R.drawable.default_poster_thumb);
                    a20.a(R.drawable.default_poster_thumb);
                    a20.c(300);
                    a20.a(bVar.g);
                    com.bumptech.glide.d<String> a21 = i.a((FragmentActivity) this.f7802a).a(a.this.u(((VideoDetailBean) arrayList.get(4)).getPosterfilelist()));
                    a21.a(DiskCacheStrategy.ALL);
                    a21.b(R.drawable.default_poster_thumb);
                    a21.a(R.drawable.default_poster_thumb);
                    a21.c(300);
                    a21.a(bVar.h);
                    com.bumptech.glide.d<String> a22 = i.a((FragmentActivity) this.f7802a).a(a.this.u(((VideoDetailBean) arrayList.get(5)).getPosterfilelist()));
                    a22.a(DiskCacheStrategy.ALL);
                    a22.b(R.drawable.default_poster_thumb);
                    a22.a(R.drawable.default_poster_thumb);
                    a22.c(300);
                    a22.a(bVar.i);
                    bVar.f7810b.setText(arrayList.size() + "movies");
                }
            }
            bVar.j.setOnClickListener(new ViewOnClickListenerC0400a(i, bVar));
            return view2;
        }
    }

    private void J() {
        this.u.a(new C0399a());
    }

    private void K() {
        this.q.setOnClickListener(new c());
        this.r.setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        LinkedHashMap<String, ArrayList<VideoDetailBean>> linkedHashMap = new LinkedHashMap<>();
        this.v = linkedHashMap;
        linkedHashMap.clear();
        String str = o.j().i() + "/getuserdata";
        d.e.a.a.d.a aVar = new d.e.a.a.d.a();
        aVar.a(s("").toString());
        aVar.b("UTF-8");
        aVar.a("Content-Type", "application/json");
        aVar.a(str, "POST", new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String u(String str) {
        if (!str.contains("poster")) {
            str = "/iptvepg/images/poster/" + str;
        }
        return com.zte.iptvclient.android.common.f.b.i.b() + str;
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.w.a());
        if (getActivity() == null) {
            return true;
        }
        getActivity().finish();
        return true;
    }

    public JSONObject I() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("usercode", com.zte.iptvclient.common.uiframe.a.d("UserID"));
            jSONObject.put("datatype", 6);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.v.size(); i++) {
                w.clear();
                w.addAll(this.v.keySet());
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                if (this.v.get(w.get(i)) == null) {
                    jSONObject2.put("listName", w.get(i));
                    jSONObject2.put("data", "");
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.v.get(w.get(i)));
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        VideoDetailBean videoDetailBean = (VideoDetailBean) it2.next();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("programcode", videoDetailBean.getProgramcode());
                        jSONObject3.put("programname", videoDetailBean.getProgramname());
                        jSONObject3.put(ParamConst.COLUMN_INFO_RSP_NORMALPOSTER, videoDetailBean.getPosterfilelist());
                        jSONArray2.put(jSONObject3);
                    }
                    jSONObject2.put("listName", w.get(i));
                    if (jSONArray2.length() == 0) {
                        jSONObject2.put("data", "");
                    } else {
                        jSONObject2.put("data", jSONArray2);
                    }
                }
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("datavalue", Uri.encode(jSONArray.toString()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        L();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.p = (SupportActivity) activity;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_movie_file_setting, viewGroup, false);
        d(inflate);
        K();
        J();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public JSONObject s(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("usercode", com.zte.iptvclient.common.uiframe.a.d("UserID"));
            jSONObject.put("datatype", 6);
            if (str != null) {
                jSONObject.put("datavalue", str);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void t(String str) {
        String str2 = o.j().i() + "/setuserdata";
        d.e.a.a.d.a aVar = new d.e.a.a.d.a();
        aVar.a(str);
        aVar.b("UTF-8");
        aVar.a("Content-Type", "application/json;charset=UTF-8");
        aVar.a(str2, "POST", new e(this));
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.q = (ImageView) view.findViewById(R.id.iv_back_movie_file_setting);
        this.r = (TextView) view.findViewById(R.id.tv_finish_movie_file_setting);
        this.s = (GridView) view.findViewById(R.id.grid_view_movie_setting);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.SmartRefreshLayout);
        this.u = smartRefreshLayout;
        com.zte.iptvclient.common.uiframe.f.a(smartRefreshLayout);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_title));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.layout_linear));
        this.u.a(new DefaultRefreshHeader(this.p));
        this.u.a(new DefaultRefreshFooter(this.p));
        SmartRefreshLayout smartRefreshLayout2 = this.u;
        SupportActivity supportActivity = this.p;
        smartRefreshLayout2.e(g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout3 = this.u;
        SupportActivity supportActivity2 = this.p;
        smartRefreshLayout3.f(g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.u.a(true);
        this.u.c(false);
    }
}
