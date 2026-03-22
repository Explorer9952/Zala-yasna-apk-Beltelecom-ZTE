package com.zte.iptvclient.android.mobile.v.c;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.gridview.ScrollGridView;
import com.zte.iptvclient.android.common.javabean.models.SeriesEpisodeBean;
import com.zte.iptvclient.android.common.javabean.models.SeriesHeadBean;
import com.zte.iptvclient.android.zala.R;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
/* loaded from: classes2.dex */
public class a extends PopupWindow {
    private LinearLayout A;
    private com.zte.iptvclient.android.common.player.i.a B;
    private GridView C;
    private ArrayList<com.zte.iptvclient.android.common.javabean.f> D;
    private TextView E;
    private SupportActivity F;
    private LinearLayout G;

    /* renamed from: a, reason: collision with root package name */
    private Context f7605a;

    /* renamed from: b, reason: collision with root package name */
    private int f7606b;

    /* renamed from: c, reason: collision with root package name */
    private int f7607c;

    /* renamed from: d, reason: collision with root package name */
    private long f7608d;
    private ArrayList<String> e;
    private SeriesHeadBean f;
    private ArrayList<SeriesEpisodeBean> g;
    private List<Integer> h;
    private ArrayList<String> i;
    private HListView j;
    private l k;
    private RelativeLayout l;
    private RelativeLayout m;
    private ImageView n;
    private TextView o;
    private ArrayList<String> p;
    private ScrollGridView q;
    private boolean r;
    private j s;
    private String t;
    private View u;
    private k v;
    private TextView w;
    private int x;
    private com.zte.iptvclient.android.common.javabean.models.f y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
    /* renamed from: com.zte.iptvclient.android.mobile.v.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0376a implements View.OnClickListener {
        ViewOnClickListenerC0376a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.D.size() <= 1) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.multiscreen_program_too_less));
            } else {
                if (com.zte.iptvclient.android.common.k.c.a() || a.this.v == null) {
                    return;
                }
                a.this.v.a();
                a.this.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
    /* loaded from: classes2.dex */
    public class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // it.sephiroth.android.library.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.g()) {
                return;
            }
            a.this.x = i;
            a.this.k.a();
            if (!a.this.h.contains(Integer.valueOf(a.this.x + 1))) {
                if (a.this.r) {
                    return;
                }
                a aVar = a.this;
                aVar.a(aVar.x + 1);
                return;
            }
            a aVar2 = a.this;
            aVar2.p = aVar2.a(aVar2.x, a.this.i, a.this.f7606b);
            a.this.s.a(a.this.p);
            a.this.s.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
    /* loaded from: classes2.dex */
    public class e implements AdapterView.OnItemClickListener {
        e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(android.widget.AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.g()) {
                return;
            }
            int i2 = i + 1;
            int indexOf = a.this.e.contains(String.valueOf((a.this.x * a.this.f7607c) + i2)) ? a.this.e.indexOf(String.valueOf(String.valueOf((a.this.x * a.this.f7607c) + i2))) : -1;
            if (indexOf < 0) {
                return;
            }
            com.zte.iptvclient.android.common.javabean.models.f fVar = new com.zte.iptvclient.android.common.javabean.models.f();
            fVar.t(((SeriesEpisodeBean) a.this.g.get(indexOf)).j());
            if (indexOf < 10) {
                fVar.e("0" + ((String) a.this.e.get(indexOf)) + "" + ((SeriesEpisodeBean) a.this.g.get(indexOf)).k());
            } else {
                fVar.e(((String) a.this.e.get(indexOf)) + "" + ((SeriesEpisodeBean) a.this.g.get(indexOf)).k());
            }
            fVar.x((String) a.this.e.get(indexOf));
            fVar.y(a.this.t);
            fVar.z(a.this.f.getColumncode());
            fVar.d(a.this.f.getContentcode());
            a.this.a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
    /* loaded from: classes2.dex */
    public class f implements AdapterView.OnItemClickListener {
        f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(android.widget.AdapterView<?> adapterView, View view, int i, long j) {
            if (i < a.this.D.size()) {
                a.this.D.remove(i);
                com.zte.iptvclient.android.common.player.multiplay.a.c().a(a.this.D);
                if (a.this.v != null) {
                    a.this.v.b();
                }
                a.this.B.notifyDataSetChanged();
                if (a.this.s != null) {
                    a.this.s.a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
    /* loaded from: classes2.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            a.this.C.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            a.this.B = new com.zte.iptvclient.android.common.player.i.a(a.this.f7605a, a.this.D, a.this.z ? 1 : 0);
            a.this.C.setAdapter((ListAdapter) a.this.B);
            a.this.B.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
    /* loaded from: classes2.dex */
    public class h implements SDKVodMgr.OnSeriesHeadInfoReturnListener {
        h() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnSeriesHeadInfoReturnListener
        public void onSeriesHeadInfoReturn(String str, String str2, String str3) {
            if (!TextUtils.equals(str, "0")) {
                if (a.this.v != null) {
                    a.this.v.c();
                }
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.no_event_data_available));
                return;
            }
            try {
                JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                LogEx.d("SearchSeriesEpisodesMulitiScreenView", "query series head info ,data : " + str3);
                if (jSONArray.length() <= 0) {
                    if (a.this.v != null) {
                        a.this.v.c();
                    }
                } else {
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    if (jSONObject != null) {
                        a.this.f = SeriesHeadBean.getSeriesHeadBeanFromJSon(jSONObject);
                    }
                    a.this.f();
                    a.this.a(a.this.x + 1);
                }
            } catch (Exception e) {
                if (a.this.v != null) {
                    a.this.v.c();
                }
                LogEx.e("SearchSeriesEpisodesMulitiScreenView", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
    /* loaded from: classes2.dex */
    public class i implements SDKVodMgr.OnSeriesChildListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7617a;

        i(int i) {
            this.f7617a = i;
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnSeriesChildListReturnListener
        public void onSeriesChildListReturn(String str, String str2, String str3) {
            LogEx.d("SearchSeriesEpisodesMulitiScreenView", "returncode : " + str + " ,  errormsg : " + str2 + " , data : " + str3);
            a.this.r = false;
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            SeriesEpisodeBean a2 = SeriesEpisodeBean.a(jSONObject);
                            a.this.g.add(a2);
                            String n = a2.n();
                            if (!a.this.e.contains(n) && !TextUtils.isEmpty(n)) {
                                a.this.e.add(n);
                            }
                        }
                    }
                    a.this.p = a.this.a(a.this.x, a.this.i, a.this.f7606b);
                    a.this.s.a(a.this.p);
                    a.this.s.a();
                    if (a.this.s != null) {
                        a.this.s.a();
                    }
                } catch (Exception e) {
                    LogEx.e("SearchSeriesEpisodesMulitiScreenView", e.getMessage());
                }
            }
            a.this.h.add(Integer.valueOf(this.f7617a));
            a.this.l.setVisibility(0);
            a.this.j.setVisibility(0);
            if (a.this.v != null) {
                a.this.v.c();
            }
        }
    }

    /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
    /* loaded from: classes2.dex */
    public class j extends com.zte.iptvclient.common.uiframe.c {

        /* renamed from: d, reason: collision with root package name */
        List<String> f7619d;

        /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
        /* renamed from: com.zte.iptvclient.android.mobile.v.c.a$j$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0377a extends com.zte.iptvclient.common.uiframe.d {

            /* renamed from: a, reason: collision with root package name */
            TextView f7620a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f7621b;

            /* renamed from: c, reason: collision with root package name */
            RelativeLayout f7622c;

            private C0377a(j jVar) {
            }

            /* synthetic */ C0377a(j jVar, ViewOnClickListenerC0376a viewOnClickListenerC0376a) {
                this(jVar);
            }
        }

        public j(Context context, List<String> list) {
            super(context, list);
            this.f7619d = new ArrayList();
            this.f7619d = list;
        }

        public void a(List<String> list) {
            this.f7619d = list;
        }

        @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
        public int getCount() {
            return this.f7619d.size();
        }

        @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0377a c0377a;
            View view2;
            LogEx.d("SearchSeriesEpisodesMulitiScreenView", " GridViewShowAdapter iPosition:" + i);
            if (view == null) {
                view2 = LayoutInflater.from(a.this.f7605a).inflate(R.layout.series_episode_muliti_screen_item, (ViewGroup) null);
                c0377a = new C0377a(this, null);
                c0377a.f7620a = (TextView) view2.findViewById(R.id.detail_series_episode_gvew_txtvew);
                c0377a.f7621b = (ImageView) view2.findViewById(R.id.download_state);
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.rl_series_episode_gvew_txtvew_item);
                c0377a.f7622c = relativeLayout;
                com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
                com.zte.iptvclient.common.uiframe.f.a(c0377a.f7620a);
                com.zte.iptvclient.common.uiframe.f.a(c0377a.f7621b);
                view2.setTag(c0377a);
            } else {
                c0377a = (C0377a) view.getTag();
                view2 = view;
            }
            c0377a.f7620a.setText(this.f7619d.get(i));
            c0377a.f7620a.setTypeface(Typeface.defaultFromStyle(0));
            if (a.this.e.indexOf(this.f7619d.get(i)) >= 0) {
                if (a.this.g.get(a.this.e.indexOf(this.f7619d.get(i))) == null) {
                    if (a.this.F != null) {
                        c0377a.f7620a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numunpublish_textcolor));
                        a.this.F.a(c0377a.f7620a, "textColor", R.color.eposideitem_numunpublish_textcolor);
                        c0377a.f7620a.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_seriesitem_bg));
                        a.this.F.a(c0377a.f7620a, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_seriesitem_bg);
                    }
                } else {
                    c0377a.f7620a.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_seriesitem_bg));
                    if (a.this.F != null) {
                        a.this.F.a(c0377a.f7620a, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_seriesitem_bg);
                    }
                    c0377a.f7621b.setVisibility(0);
                    com.zte.iptvclient.android.common.player.multiplay.a c2 = com.zte.iptvclient.android.common.player.multiplay.a.c();
                    a aVar = a.this;
                    if (c2.a(aVar.a((SeriesEpisodeBean) aVar.g.get(a.this.e.indexOf(this.f7619d.get(i)))))) {
                        c0377a.f7621b.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_delete_blue));
                        if (a.this.F != null) {
                            a.this.F.a(c0377a.f7621b, "src", R.drawable.multiscreen_delete_blue);
                        }
                    } else {
                        c0377a.f7621b.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_add_blue));
                        if (a.this.F != null) {
                            a.this.F.a(c0377a.f7621b, "src", R.drawable.multiscreen_add_blue);
                        }
                    }
                }
            } else {
                c0377a.f7621b.setVisibility(8);
                if (a.this.z) {
                    if (a.this.F != null) {
                        c0377a.f7620a.setTextColor(c.a.a.a.d.b.d().b(R.color.white));
                        a.this.F.a(c0377a.f7620a, "textColor", R.color.white);
                        c0377a.f7620a.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_seriesitem_small_bg));
                        a.this.F.a(c0377a.f7620a, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_seriesitem_small_bg);
                    }
                } else if (a.this.F != null) {
                    c0377a.f7620a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numunpublish_textcolor));
                    a.this.F.a(c0377a.f7620a, "textColor", R.color.eposideitem_numunpublish_textcolor);
                    c0377a.f7620a.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_seriesitem_bg));
                    a.this.F.a(c0377a.f7620a, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_seriesitem_bg);
                }
            }
            if (!a.this.e.contains(this.f7619d.get(i))) {
                if (a.this.F != null) {
                    c0377a.f7621b.setVisibility(8);
                    c0377a.f7620a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numunpublish_textcolor));
                    a.this.F.a(c0377a.f7620a, "textColor", R.color.eposideitem_numunpublish_textcolor);
                    c0377a.f7620a.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_seriesitem_bg));
                    a.this.F.a(c0377a.f7620a, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_seriesitem_bg);
                }
            } else {
                c0377a.f7621b.setVisibility(0);
                if (a.this.z) {
                    if (a.this.F != null) {
                        c0377a.f7620a.setTextColor(c.a.a.a.d.b.d().b(R.color.white));
                        a.this.F.a(c0377a.f7620a, "textColor", R.color.white);
                        c0377a.f7620a.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_seriesitem_small_bg));
                        a.this.F.a(c0377a.f7620a, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_seriesitem_small_bg);
                    }
                } else if (a.this.F != null) {
                    c0377a.f7620a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numunselect_textcolor));
                    a.this.F.a(c0377a.f7620a, "textColor", R.color.eposideitem_numunselect_textcolor);
                    c0377a.f7620a.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_seriesitem_bg));
                    a.this.F.a(c0377a.f7620a, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_seriesitem_bg);
                }
            }
            return view2;
        }
    }

    /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
    /* loaded from: classes2.dex */
    public interface k {
        void a();

        void b();

        void c();

        void d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
    /* loaded from: classes2.dex */
    public class l extends com.zte.iptvclient.common.uiframe.c {

        /* renamed from: d, reason: collision with root package name */
        private List<String> f7623d;

        /* compiled from: SearchSeriesEpisodesMulitiScreenView.java */
        /* renamed from: com.zte.iptvclient.android.mobile.v.c.a$l$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0378a extends com.zte.iptvclient.common.uiframe.d {

            /* renamed from: a, reason: collision with root package name */
            TextView f7624a;

            private C0378a(l lVar) {
            }

            /* synthetic */ C0378a(l lVar, ViewOnClickListenerC0376a viewOnClickListenerC0376a) {
                this(lVar);
            }
        }

        public l(Context context, List<String> list) {
            super(context, list);
            this.f7623d = new ArrayList();
            this.f7623d = list;
            LogEx.d("SearchSeriesEpisodesMulitiScreenView", "SeriesNumNavigationAdapter created");
        }

        @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
        public int getCount() {
            return this.f7623d.size();
        }

        @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0378a c0378a;
            LogEx.d("SearchSeriesEpisodesMulitiScreenView", "position:" + i);
            if (view == null) {
                view = LayoutInflater.from(a.this.f7605a).inflate(R.layout.detail_series_episode_nav_item_llayout, (ViewGroup) null);
                c0378a = new C0378a(this, null);
                TextView textView = (TextView) view.findViewById(R.id.detail_series_episode_nav_txtvew);
                c0378a.f7624a = textView;
                com.zte.iptvclient.common.uiframe.f.a(textView);
                view.setTag(c0378a);
            } else {
                c0378a = (C0378a) view.getTag();
            }
            c0378a.f7624a.setText(this.f7623d.get(i));
            if (a.this.x == i) {
                if (a.this.z) {
                    c0378a.f7624a.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_switchitem_selected_color_small));
                    if (a.this.F != null) {
                        a.this.F.a(c0378a.f7624a, "textColor", R.color.multiplayer_switchitem_selected_color_small);
                    }
                    c0378a.f7624a.setTypeface(Typeface.defaultFromStyle(1));
                } else {
                    c0378a.f7624a.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_switchitem_selected_color));
                    if (a.this.F != null) {
                        a.this.F.a(c0378a.f7624a, "textColor", R.color.multiplayer_switchitem_selected_color);
                    }
                    c0378a.f7624a.setTypeface(Typeface.defaultFromStyle(1));
                }
            } else if (a.this.z) {
                c0378a.f7624a.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_seriesitem_bg));
                if (a.this.F != null) {
                    a.this.F.a(c0378a.f7624a, "textColor", R.color.multiplayer_seriesitem_bg);
                }
                c0378a.f7624a.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                c0378a.f7624a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numunselect_textcolor));
                if (a.this.F != null) {
                    a.this.F.a(c0378a.f7624a, "textColor", R.color.eposideitem_numunselect_textcolor);
                }
                c0378a.f7624a.setTypeface(Typeface.defaultFromStyle(0));
            }
            return view;
        }
    }

    public a(Context context, View view, boolean z, com.zte.iptvclient.android.common.javabean.models.f fVar, k kVar) {
        super(context);
        this.f7607c = 30;
        this.f7608d = 0L;
        this.g = new ArrayList<>();
        this.h = new ArrayList();
        this.r = false;
        this.t = "";
        this.x = 0;
        this.z = false;
        this.f7605a = context;
        this.v = kVar;
        this.y = fVar;
        this.z = z;
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.mulit_screen_sereis_epsiode_view, (ViewGroup) null);
        this.u = inflate;
        setContentView(inflate);
        if (this.z) {
            setWidth(view.getMeasuredWidth());
            LogEx.d("SearchSeriesEpisodesMulitiScreenView", "setWidth" + view.getMeasuredWidth());
        } else {
            setWidth(-1);
            LogEx.d("SearchSeriesEpisodesMulitiScreenView", "setWidth-1");
        }
        setHeight(-2);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
        setSoftInputMode(1);
        setAnimationStyle(R.style.mypopwindow_anim_bottom_up);
        setSoftInputMode(16);
        d();
        c();
        e();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Window window;
        WindowManager.LayoutParams attributes;
        Context context = this.f7605a;
        if ((context instanceof FragmentActivity) && (window = ((FragmentActivity) context).getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.alpha = 1.0f;
            window.setAttributes(attributes);
        }
        super.dismiss();
    }

    private void c() {
        TextView textView = this.E;
        if (textView != null) {
            textView.setOnClickListener(new b());
        }
        this.m.setOnClickListener(new c());
        this.j.setOnItemClickListener(new d());
        this.q.setOnItemClickListener(new e());
        this.C.setOnItemClickListener(new f());
    }

    private void d() {
        LinearLayout linearLayout = (LinearLayout) this.u.findViewById(R.id.common_detail_layout_samll);
        LinearLayout linearLayout2 = (LinearLayout) this.u.findViewById(R.id.common_detail_layout);
        ((RelativeLayout) this.u.findViewById(R.id.rl_colse_img_samll)).setOnClickListener(new ViewOnClickListenerC0376a());
        RelativeLayout relativeLayout = (RelativeLayout) this.u.findViewById(R.id.common_detail_rlayout);
        this.l = relativeLayout;
        relativeLayout.setVisibility(8);
        this.w = (TextView) this.u.findViewById(R.id.detail_title);
        this.m = (RelativeLayout) this.u.findViewById(R.id.rl_colse_img);
        this.n = (ImageView) this.u.findViewById(R.id.img_close);
        TextView textView = (TextView) this.u.findViewById(R.id.detail_title_samll);
        this.o = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_season));
        com.zte.iptvclient.common.uiframe.f.a(this.u.findViewById(R.id.common_detail_layout_samll));
        com.zte.iptvclient.common.uiframe.f.a(this.u.findViewById(R.id.common_detail_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(this.u.findViewById(R.id.detail_title_samll));
        com.zte.iptvclient.common.uiframe.f.a(this.u.findViewById(R.id.rl_colse_img_samll));
        com.zte.iptvclient.common.uiframe.f.a(this.u.findViewById(R.id.img_close));
        com.zte.iptvclient.common.uiframe.f.a(this.u.findViewById(R.id.img_close_small));
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.m);
        com.zte.iptvclient.common.uiframe.f.a(this.n);
        HListView hListView = (HListView) this.u.findViewById(R.id.navigation_hlistview);
        this.j = hListView;
        hListView.setVisibility(8);
        this.q = (ScrollGridView) this.u.findViewById(R.id.episode_gvew);
        com.zte.iptvclient.common.uiframe.f.a(this.j);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        this.A = (LinearLayout) this.u.findViewById(R.id.ll_multiscreen_program_edit_view);
        this.G = (LinearLayout) this.u.findViewById(R.id.ll_program_edit_main);
        this.C = (GridView) this.u.findViewById(R.id.gv_program_edit);
        TextView textView2 = (TextView) this.u.findViewById(R.id.txt_ok);
        this.E = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multiscreen_program_confirm));
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.u.findViewById(R.id.ll_program_edit_main));
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        this.G.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_bg));
        SupportActivity supportActivity = this.F;
        if (supportActivity != null) {
            supportActivity.a(this.G, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.search_bg);
        }
        if (this.z) {
            linearLayout.setVisibility(0);
            linearLayout2.setVisibility(8);
            ((LinearLayout) this.u.findViewById(R.id.pop_view_series_epsiode)).setBackgroundColor(this.f7605a.getResources().getColor(R.color.search_view_main_theme_color_small));
            ((TextView) this.u.findViewById(R.id.detail_title)).setTextColor(this.f7605a.getResources().getColor(R.color.search_small_color));
            this.A.setBackgroundResource(R.color.parental_control_text_initial_color);
        } else {
            linearLayout2.setVisibility(0);
            this.A.setBackgroundResource(R.color.search_view_main_theme_color);
        }
        this.A.setVisibility(0);
    }

    private void e() {
        this.e = new ArrayList<>();
        this.i = new ArrayList<>();
        this.p = new ArrayList<>();
        com.zte.iptvclient.android.common.javabean.models.f fVar = this.y;
        if (fVar != null) {
            this.w.setText(fVar.e());
            this.t = this.y.r();
            h();
        } else {
            this.w.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_season));
            k kVar = this.v;
            if (kVar != null) {
                kVar.c();
            }
        }
        this.D = com.zte.iptvclient.android.common.player.multiplay.a.c().a();
        this.C.getViewTreeObserver().addOnGlobalLayoutListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        i();
        ArrayList<String> a2 = a(this.x, this.i, this.f7606b);
        this.p = a2;
        j jVar = this.s;
        if (jVar == null) {
            j jVar2 = new j(this.f7605a, a2);
            this.s = jVar2;
            this.q.setAdapter((ListAdapter) jVar2);
        } else {
            jVar.a();
        }
        this.k.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f7608d <= 1000) {
            LogEx.w("UseeTv", "Operate limit,less than 500(ms)!");
            return true;
        }
        this.f7608d = currentTimeMillis;
        return false;
    }

    private void h() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("programcode", this.t);
        new SDKVodMgr().getSeriesHeadInfo(hashMap, new h());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        r1 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i() {
        /*
            r3 = this;
            r0 = 0
            com.zte.iptvclient.android.common.javabean.models.SeriesHeadBean r1 = r3.f     // Catch: java.lang.Exception -> L37
            java.lang.String r1 = r1.getSeriesnum()     // Catch: java.lang.Exception -> L37
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L37
            if (r1 != 0) goto L1c
            com.zte.iptvclient.android.common.javabean.models.SeriesHeadBean r1 = r3.f     // Catch: java.lang.Exception -> L37
            java.lang.String r1 = r1.getSeriesnum()     // Catch: java.lang.Exception -> L37
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L37
            int r1 = r1.intValue()     // Catch: java.lang.Exception -> L37
            goto L3c
        L1c:
            com.zte.iptvclient.android.common.javabean.models.SeriesHeadBean r1 = r3.f     // Catch: java.lang.Exception -> L37
            java.lang.String r1 = r1.getUpdatenum()     // Catch: java.lang.Exception -> L37
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L37
            if (r1 != 0) goto L3b
            com.zte.iptvclient.android.common.javabean.models.SeriesHeadBean r1 = r3.f     // Catch: java.lang.Exception -> L37
            java.lang.String r1 = r1.getUpdatenum()     // Catch: java.lang.Exception -> L37
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L37
            int r1 = r1.intValue()     // Catch: java.lang.Exception -> L37
            goto L3c
        L37:
            r1 = move-exception
            r1.printStackTrace()
        L3b:
            r1 = 0
        L3c:
            if (r1 >= 0) goto L3f
            r1 = 0
        L3f:
            r3.f7606b = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "mSeriesAllNum = "
            r1.append(r2)
            int r2 = r3.f7606b
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "SearchSeriesEpisodesMulitiScreenView"
            com.video.androidsdk.log.LogEx.d(r2, r1)
            int r1 = r3.f7606b
            int r2 = r3.f7607c
            if (r1 >= r2) goto L67
            it.sephiroth.android.library.widget.HListView r0 = r3.j
            r1 = 8
            r0.setVisibility(r1)
            goto L6c
        L67:
            it.sephiroth.android.library.widget.HListView r1 = r3.j
            r1.setVisibility(r0)
        L6c:
            r3.j()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.v.c.a.i():void");
    }

    private void j() {
        int i2 = this.f7606b;
        int i3 = this.f7607c;
        if (i2 <= i3) {
            this.i.add("1-" + this.f7606b);
        } else {
            int i4 = i2 / i3;
            int i5 = 0;
            while (i5 < i4) {
                int i6 = this.f7607c;
                int i7 = (i5 * i6) + 1;
                i5++;
                this.i.add(i7 + "-" + (i6 * i5));
            }
            int i8 = this.f7606b;
            int i9 = this.f7607c;
            if (i8 % i9 > 0) {
                this.i.add(((i4 * i9) + 1) + "-" + this.f7606b);
            }
        }
        ArrayList<String> arrayList = this.i;
        if (arrayList != null) {
            l lVar = new l(this.f7605a, arrayList);
            this.k = lVar;
            this.j.setAdapter((ListAdapter) lVar);
        }
    }

    protected void b() {
        Window window;
        Context context = this.f7605a;
        if (context == null || (window = ((FragmentActivity) context).getWindow()) == null) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 11 && i2 < 19) {
            window.getDecorView().setSystemUiVisibility(8);
        } else if (Build.VERSION.SDK_INT >= 19) {
            window.getDecorView().setSystemUiVisibility(4102);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.zte.iptvclient.android.common.javabean.models.f fVar) {
        if (fVar != null) {
            com.zte.iptvclient.android.common.javabean.f a2 = com.zte.iptvclient.android.common.player.multiplay.a.a(fVar);
            LogEx.d("SearchSeriesEpisodesMulitiScreenView", "AddVodToMultiScreenEvent!procode" + a2.d() + ";name" + a2.e());
            StringBuilder sb = new StringBuilder();
            sb.append("isPlayBundleListIncludeVOD");
            sb.append(com.zte.iptvclient.android.common.player.multiplay.a.c().a().size());
            LogEx.d("SearchSeriesEpisodesMulitiScreenView", sb.toString());
            if (!com.zte.iptvclient.android.common.player.multiplay.a.c().a(a2) && com.zte.iptvclient.android.common.player.multiplay.a.c().b()) {
                this.D.add(a2);
            } else {
                if (!com.zte.iptvclient.android.common.player.multiplay.a.c().a(a2)) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.multiscreen_program_too_more));
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= this.D.size()) {
                        break;
                    }
                    if (TextUtils.equals(a2.d(), this.D.get(i2).d())) {
                        this.D.remove(i2);
                        break;
                    }
                    i2++;
                }
            }
            if (this.B != null) {
                com.zte.iptvclient.android.common.player.multiplay.a.c().a(this.D);
                this.B.notifyDataSetChanged();
                LogEx.d("SearchSeriesEpisodesMulitiScreenView", "opreation getCount=" + this.D.size());
                k kVar = this.v;
                if (kVar != null) {
                    kVar.b();
                }
            }
            j jVar = this.s;
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        this.r = true;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", String.valueOf(i2));
        hashMap.put("numperpage", String.valueOf(this.f7607c));
        hashMap.put("seriesprogramcode", this.f.getProgramcode());
        new SDKVodMgr().getSeriesChildlList(hashMap, new i(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> a(int i2, ArrayList<String> arrayList, int i3) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int i4 = this.f7607c;
        int i5 = i3 % i4;
        int i6 = i4 * i2;
        if (arrayList.size() > 0) {
            if (i2 == arrayList.size() - 1) {
                if (i5 == 0) {
                    int i7 = i6;
                    while (i7 < this.f7607c + i6) {
                        StringBuilder sb = new StringBuilder();
                        i7++;
                        sb.append(i7);
                        sb.append("");
                        arrayList2.add(sb.toString());
                    }
                } else {
                    int i8 = i6;
                    while (i8 < i6 + i5) {
                        StringBuilder sb2 = new StringBuilder();
                        i8++;
                        sb2.append(i8);
                        sb2.append("");
                        arrayList2.add(sb2.toString());
                    }
                }
            } else if (arrayList.size() == 1) {
                while (i2 < i3) {
                    StringBuilder sb3 = new StringBuilder();
                    i2++;
                    sb3.append(i2);
                    sb3.append("");
                    arrayList2.add(sb3.toString());
                }
            } else {
                int i9 = i6;
                while (i9 < this.f7607c + i6) {
                    StringBuilder sb4 = new StringBuilder();
                    i9++;
                    sb4.append(i9);
                    sb4.append("");
                    arrayList2.add(sb4.toString());
                }
            }
        }
        return arrayList2;
    }

    public void a(View view) {
        if (this.e.size() != 0 && this.g.size() != 0 && this.f7606b != 0) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            LogEx.d("SearchSeriesEpisodesMulitiScreenView", "v.getX=" + iArr[0] + ";getXDp=" + a(this.f7605a, iArr[0]));
            if (this.z) {
                if (a() > 0) {
                    b();
                    showAtLocation(view, 85, a() - a(this.f7605a, 8.0f), 0);
                    return;
                } else {
                    b();
                    showAtLocation(view, 85, a(this.f7605a, 8.0f), 0);
                    return;
                }
            }
            showAtLocation(view, 80, 0, 0);
            return;
        }
        k kVar = this.v;
        if (kVar != null) {
            kVar.d();
        }
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int a() {
        WindowManager windowManager = (WindowManager) this.f7605a.getSystemService("window");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.zte.iptvclient.android.common.javabean.f a(SeriesEpisodeBean seriesEpisodeBean) {
        if (seriesEpisodeBean == null) {
            return null;
        }
        com.zte.iptvclient.android.common.javabean.f fVar = new com.zte.iptvclient.android.common.javabean.f();
        fVar.e(seriesEpisodeBean.j());
        fVar.d("2");
        return fVar;
    }
}
