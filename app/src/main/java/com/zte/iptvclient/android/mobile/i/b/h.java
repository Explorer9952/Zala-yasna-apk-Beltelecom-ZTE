package com.zte.iptvclient.android.mobile.i.b;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.download.Linstener.DownloadListReturnListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: SeriesDetailDownloadFragment.java */
/* loaded from: classes.dex */
public class h extends com.zte.fragmentlib.b {
    private ArrayList<String> B;
    private GridView C;
    private g D;
    private ArrayList<String> E;
    private ArrayList<String> F;
    private ArrayList<String> G;
    private HashMap<String, String> J;
    private LayoutInflater L;
    private View M;
    private InterfaceC0281h S;
    private String Y;
    private com.zte.iptvclient.android.common.j.h Z;
    private ArrayList<String> p;
    private LinearLayout r;
    private int s;
    private ArrayList<String> u;
    private HListView v;
    private i w;
    private ImageView x;
    private RelativeLayout y;
    private ImageView z;
    private String q = "";
    private int t = 30;
    private int A = 0;
    private String K = null;
    private long N = 0;
    private int O = 0;
    private Boolean P = false;
    private String Q = "";
    private String R = "";
    private boolean T = true;
    private String U = "";
    private String[] V = new String[0];
    private String W = "";
    private String[] X = new String[0];
    private DownloadListReturnListener a0 = new e();
    private DownloadListReturnListener b0 = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SeriesDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SeriesDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.K()) {
                return;
            }
            if (h.this.P.booleanValue()) {
                h.this.N();
            } else {
                h.this.O();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SeriesDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    public class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // it.sephiroth.android.library.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            h.this.A = i;
            if (h.this.S != null) {
                h.this.S.c(h.this.A + 1);
            }
            h.this.w.a();
            h hVar = h.this;
            hVar.B = hVar.a(hVar.A, (ArrayList<String>) h.this.u, h.this.s);
            h.this.D.a(h.this.B);
            h.this.D.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SeriesDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    public class d implements AdapterView.OnItemClickListener {

        /* compiled from: SeriesDetailDownloadFragment.java */
        /* loaded from: classes.dex */
        class a implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ EditText f6553a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f6554b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f6555c;

            a(EditText editText, String str, com.zte.iptvclient.android.common.customview.a.a.a.b bVar) {
                this.f6553a = editText;
                this.f6554b = str;
                this.f6555c = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6553a.getText().toString().equals(h.this.Z.u())) {
                    h.this.s(this.f6554b);
                    h.this.A();
                    this.f6555c.dismiss();
                } else {
                    this.f6553a.setText("");
                    this.f6555c.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.limitpwd_is_wrong));
                }
            }
        }

        /* compiled from: SeriesDetailDownloadFragment.java */
        /* loaded from: classes.dex */
        class b implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f6557a;

            b(com.zte.iptvclient.android.common.customview.a.a.a.b bVar) {
                this.f6557a = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f6557a.dismiss();
                h.this.A();
            }
        }

        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(android.widget.AdapterView<?> adapterView, View view, int i, long j) {
            String charSequence = ((TextView) view.findViewById(R.id.detail_series_episode_gvew_txtvew)).getText().toString();
            if (!h.this.G.contains(charSequence) || h.this.E.contains(charSequence) || h.this.F.contains(charSequence)) {
                return;
            }
            if (!TextUtils.equals("1", ConfigMgr.readPropertie("IsShowChildLock")) || h.this.Z == null || !h.this.Z.C() || !com.zte.iptvclient.android.mobile.f.b.a.b(h.this.Y, ((com.zte.fragmentlib.b) h.this).h)) {
                h.this.s(charSequence);
                return;
            }
            com.zte.iptvclient.android.common.customview.a.a.a.b bVar = new com.zte.iptvclient.android.common.customview.a.a.a.b(((com.zte.fragmentlib.b) h.this).h);
            bVar.setTitle(R.string.enter_passsword_check);
            bVar.b(R.string.common_ok, new a(bVar.a(), charSequence, bVar));
            bVar.a(R.string.common_cancel, new b(bVar));
            bVar.setCancelable(true);
            bVar.setCanceledOnTouchOutside(false);
            bVar.show();
        }
    }

    /* compiled from: SeriesDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    class e implements DownloadListReturnListener {

        /* compiled from: SeriesDetailDownloadFragment.java */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ArrayList f6560a;

            a(ArrayList arrayList) {
                this.f6560a = arrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.b((ArrayList<DownloadTask>) this.f6560a);
            }
        }

        e() {
        }

        @Override // com.video.androidsdk.download.Linstener.DownloadListReturnListener
        public void returnDownloadTaskList(String str, int i, String str2, ArrayList<DownloadTask> arrayList) {
            LogEx.d("SeriesDetailDownloadFragment", "status = " + str + " errorCode = " + i + " errorMsg = " + str2 + " arraylist = " + arrayList);
            if (!Looper.myLooper().equals(Looper.getMainLooper())) {
                ((com.zte.fragmentlib.b) h.this).h.runOnUiThread(new a(arrayList));
            } else {
                h.this.b(arrayList);
            }
        }
    }

    /* compiled from: SeriesDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    class f implements DownloadListReturnListener {

        /* compiled from: SeriesDetailDownloadFragment.java */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ArrayList f6563a;

            a(ArrayList arrayList) {
                this.f6563a = arrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.c((ArrayList<DownloadTask>) this.f6563a);
            }
        }

        f() {
        }

        @Override // com.video.androidsdk.download.Linstener.DownloadListReturnListener
        public void returnDownloadTaskList(String str, int i, String str2, ArrayList<DownloadTask> arrayList) {
            LogEx.d("SeriesDetailDownloadFragment", "status = " + str + " errorCode = " + i + " errorMsg = " + str2 + " arraylist = " + arrayList);
            if (Looper.myLooper() != Looper.getMainLooper()) {
                ((com.zte.fragmentlib.b) h.this).h.runOnUiThread(new a(arrayList));
            } else {
                h.this.c(arrayList);
            }
        }
    }

    /* compiled from: SeriesDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    public class g extends com.zte.iptvclient.common.uiframe.c {

        /* renamed from: d, reason: collision with root package name */
        List<String> f6565d;

        public g(Context context, List<String> list) {
            super(context, list);
            this.f6565d = new ArrayList();
            this.f6565d = list;
        }

        public void a(List<String> list) {
            this.f6565d = list;
        }

        @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
        public int getCount() {
            return this.f6565d.size();
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
            l lVar;
            LogEx.d("SeriesDetailDownloadFragment", " GridViewShowAdapter iPosition:" + i);
            if (view == null) {
                view = LayoutInflater.from(((com.zte.fragmentlib.b) h.this).h).inflate(R.layout.detail_series_episode_gvew_layout, (ViewGroup) null);
                lVar = new l(null);
                lVar.f6570a = (TextView) view.findViewById(R.id.detail_series_episode_gvew_txtvew);
                lVar.f6571b = (ImageView) view.findViewById(R.id.download_state);
                lVar.f6572c = (RelativeLayout) view.findViewById(R.id.rl_series_episode_gvew_txtvew_item);
                com.zte.iptvclient.common.uiframe.f.a(lVar.f6571b);
                com.zte.iptvclient.common.uiframe.f.a(lVar.f6570a);
                com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_series_episode_gvew_txtvew_item));
                view.setTag(lVar);
            } else {
                lVar = (l) view.getTag();
            }
            lVar.f6570a.setText(this.f6565d.get(i));
            if (h.this.E.contains(this.f6565d.get(i))) {
                if (((com.zte.fragmentlib.b) h.this).h != null) {
                    lVar.f6571b.setBackground(c.a.a.a.d.b.d().d(R.drawable.cache_done));
                    ((com.zte.fragmentlib.b) h.this).h.a(lVar.f6571b, "background", R.drawable.cache_done);
                }
                lVar.f6571b.setVisibility(0);
                lVar.f6572c.setEnabled(false);
            } else if (h.this.F.contains(this.f6565d.get(i))) {
                if (((com.zte.fragmentlib.b) h.this).h != null) {
                    lVar.f6571b.setBackground(c.a.a.a.d.b.d().d(R.drawable.cache_ing));
                    ((com.zte.fragmentlib.b) h.this).h.a(lVar.f6571b, "background", R.drawable.cache_ing);
                }
                lVar.f6571b.setVisibility(0);
                lVar.f6572c.setEnabled(false);
            } else {
                lVar.f6571b.setVisibility(8);
                lVar.f6572c.setEnabled(true);
            }
            LogEx.d("SeriesDetailDownloadFragment", "at arrayList=" + this.f6565d.get(i) + ",mLstSeriesNum=" + h.this.G.toString());
            StringBuilder sb = new StringBuilder();
            sb.append("mLstSelecttingNum");
            sb.append(h.this.F.toString());
            LogEx.d("SeriesDetailDownloadFragment", sb.toString());
            if (h.this.G.contains(this.f6565d.get(i))) {
                if (((com.zte.fragmentlib.b) h.this).h != null) {
                    lVar.f6570a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numunselect_textcolor));
                    ((com.zte.fragmentlib.b) h.this).h.a(lVar.f6570a, "textColor", R.color.eposideitem_numunselect_textcolor);
                    lVar.f6572c.setBackground(c.a.a.a.d.b.d().d(R.drawable.episode_item_bg));
                    ((com.zte.fragmentlib.b) h.this).h.a(lVar.f6572c, "background", R.drawable.episode_item_bg);
                }
            } else if (((com.zte.fragmentlib.b) h.this).h != null) {
                lVar.f6570a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numunpublish_textcolor));
                ((com.zte.fragmentlib.b) h.this).h.a(lVar.f6570a, "textColor", R.color.eposideitem_numunpublish_textcolor);
                lVar.f6572c.setBackground(c.a.a.a.d.b.d().d(R.drawable.episode_item_disable_bg));
                ((com.zte.fragmentlib.b) h.this).h.a(lVar.f6572c, "background", R.drawable.episode_item_disable_bg);
            }
            return view;
        }
    }

    /* compiled from: SeriesDetailDownloadFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.i.b.h$h, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0281h {
        void c(int i);

        void c(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SeriesDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    public class i extends com.zte.iptvclient.common.uiframe.c {

        /* renamed from: d, reason: collision with root package name */
        private List<String> f6566d;

        public i(Context context, List<String> list) {
            super(context, list);
            this.f6566d = new ArrayList();
            this.f6566d = list;
            LogEx.d("SeriesDetailDownloadFragment", "SeriesNumNavigationAdapter created");
        }

        @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
        public int getCount() {
            return this.f6566d.size();
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
            j jVar;
            LogEx.d("SeriesDetailDownloadFragment", "position:" + i);
            if (view == null) {
                view = LayoutInflater.from(((com.zte.fragmentlib.b) h.this).h).inflate(R.layout.detail_series_episode_nav_item_llayout, (ViewGroup) null);
                jVar = new j(null);
                TextView textView = (TextView) view.findViewById(R.id.detail_series_episode_nav_txtvew);
                jVar.f6567a = textView;
                com.zte.iptvclient.common.uiframe.f.a(textView);
                view.setTag(jVar);
            } else {
                jVar = (j) view.getTag();
            }
            jVar.f6567a.setText(this.f6566d.get(i));
            if (h.this.A == i) {
                if (((com.zte.fragmentlib.b) h.this).h != null) {
                    jVar.f6567a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_navnumselect_textcolor));
                    ((com.zte.fragmentlib.b) h.this).h.a(jVar.f6567a, "textColor", R.color.eposideitem_navnumselect_textcolor);
                }
            } else if (((com.zte.fragmentlib.b) h.this).h != null) {
                jVar.f6567a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numunselect_textcolor));
                ((com.zte.fragmentlib.b) h.this).h.a(jVar.f6567a, "textColor", R.color.eposideitem_numunselect_textcolor);
                jVar.f6567a.setTypeface(Typeface.defaultFromStyle(0));
            }
            return view;
        }
    }

    /* compiled from: SeriesDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    private static class j extends com.zte.iptvclient.common.uiframe.d {

        /* renamed from: a, reason: collision with root package name */
        TextView f6567a;

        private j() {
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SeriesDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private int f6568a;

        public k(int i) {
            this.f6568a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.K()) {
                return;
            }
            h.this.O = this.f6568a;
            if (h.this.p.size() > h.this.O) {
                String str = (String) h.this.p.get(h.this.O);
                h.this.p.remove(h.this.O);
                h.this.p.add(0, str);
                ArrayList arrayList = new ArrayList();
                arrayList.add(h.this.p.get(0));
                for (int i = 1; i < h.this.p.size(); i++) {
                    if (((String) h.this.p.get(i)).equals(h.this.t("1"))) {
                        arrayList.add(h.this.p.get(i));
                        LogEx.d("SeriesDetailDownloadFragment", "mDefinitionNameList.add = " + ((String) h.this.p.get(i)));
                    }
                }
                for (int i2 = 1; i2 < h.this.p.size(); i2++) {
                    if (((String) h.this.p.get(i2)).equals(h.this.t("2"))) {
                        arrayList.add(h.this.p.get(i2));
                        LogEx.d("SeriesDetailDownloadFragment", "mDefinitionNameList.add = " + ((String) h.this.p.get(i2)));
                    }
                }
                for (int i3 = 1; i3 < h.this.p.size(); i3++) {
                    if (((String) h.this.p.get(i3)).equals(h.this.t("4"))) {
                        arrayList.add(h.this.p.get(i3));
                        LogEx.d("SeriesDetailDownloadFragment", "mDefinitionNameList.add = " + ((String) h.this.p.get(i3)));
                    }
                }
                for (int i4 = 1; i4 < h.this.p.size(); i4++) {
                    if (((String) h.this.p.get(i4)).equals(h.this.t("8"))) {
                        arrayList.add(h.this.p.get(i4));
                        LogEx.d("SeriesDetailDownloadFragment", "mDefinitionNameList.add = " + ((String) h.this.p.get(i4)));
                    }
                }
                for (int i5 = 1; i5 < h.this.p.size(); i5++) {
                    if (((String) h.this.p.get(i5)).equals(h.this.t(GlobalConst.WINPHONE_CLIENT))) {
                        arrayList.add(h.this.p.get(i5));
                        LogEx.d("SeriesDetailDownloadFragment", "mDefinitionNameList.add = " + ((String) h.this.p.get(i5)));
                    }
                }
                for (int i6 = 1; i6 < h.this.p.size(); i6++) {
                    if (((String) h.this.p.get(i6)).equals(h.this.t(GlobalConst.ANDRIODSTB_CLIENT))) {
                        arrayList.add(h.this.p.get(i6));
                        LogEx.d("SeriesDetailDownloadFragment", "mDefinitionNameList.add = " + ((String) h.this.p.get(i6)));
                    }
                }
                h.this.p = arrayList;
            }
            h.this.N();
        }
    }

    /* compiled from: SeriesDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    private static class l extends com.zte.iptvclient.common.uiframe.d {

        /* renamed from: a, reason: collision with root package name */
        TextView f6570a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f6571b;

        /* renamed from: c, reason: collision with root package name */
        RelativeLayout f6572c;

        private l() {
        }

        /* synthetic */ l(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.P = true;
        this.r.removeAllViews();
        this.x.setBackgroundResource(R.drawable.details_arrow_left);
        if (this.p.size() > this.O) {
            this.q = this.p.get(0);
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                View inflate = this.L.inflate(R.layout.video_download_definition_title_layout, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.definition_title);
                com.zte.iptvclient.common.uiframe.f.a(textView);
                if (i2 == 0) {
                    textView.setText(this.q);
                    if (this.h != null) {
                        textView.setTextColor(c.a.a.a.d.b.d().b(R.color.video_definitionfoucus_textcolor));
                        this.h.a(textView, "textColor", R.color.video_definitionfoucus_textcolor);
                    }
                } else {
                    textView.setText(this.p.get(i2));
                    if (this.h != null) {
                        textView.setTextColor(c.a.a.a.d.b.d().b(R.color.video_definitionnormal_textcolor));
                        this.h.a(textView, "textColor", R.color.video_definitionnormal_textcolor);
                    }
                }
                this.r.addView(inflate);
                textView.setOnClickListener(new k(i2));
            }
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        I();
        J();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Z = new com.zte.iptvclient.android.common.j.h(this.h);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.Q = arguments.getString("Programcode");
            this.R = arguments.getString("ColumnCode");
            this.s = arguments.getInt("AllSeriesNum");
            this.u = arguments.getStringArrayList("EpisodeNavList");
            this.G = arguments.getStringArrayList("DefaultSeriesList");
            this.J = (HashMap) arguments.getSerializable("DefinitionMap");
            this.Y = arguments.getString("getRatingId");
        }
        LogEx.d("SeriesDetailDownloadFragment", "mStrProgramcode=" + this.Q + "mStrColumnCode=" + this.R);
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 3) {
            this.T = false;
        } else {
            this.T = true;
        }
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RATE_DEFINITION_LEVEL);
        this.U = c2;
        if (!TextUtils.isEmpty(c2)) {
            this.V = this.U.split(",");
        }
        String c3 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RATE_DEFINITION_TITLE);
        this.W = c3;
        if (TextUtils.isEmpty(c3)) {
            return;
        }
        this.X = this.W.split(",");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.L = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.series_detail_download_layout, (ViewGroup) null);
        this.M = inflate;
        d(inflate);
        L();
        return this.M;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    private void I() {
        this.p = new ArrayList<>();
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        if (BaseApp.a(this.h)) {
            this.t = 40;
        }
        if (DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT.equals(com.zte.iptvclient.common.uiframe.a.c("Android_Player_Type"))) {
            if (this.J.containsKey(DownloadConstant.REPORT_MSGTYPE_ADD)) {
                this.p.add(com.zte.iptvclient.android.common.i.a.a.a(R.string.definition_fdh));
                String str = this.J.get(DownloadConstant.REPORT_MSGTYPE_ADD) + com.zte.iptvclient.android.common.k.i.a();
                this.J.put(DownloadConstant.REPORT_MSGTYPE_ADD, str);
                LogEx.d("downloadUrl  == ", str);
            }
            if (this.J.containsKey("1")) {
                this.p.add(t("1"));
                String str2 = this.J.get("1") + com.zte.iptvclient.android.common.k.i.a();
                this.J.put("1", str2);
                LogEx.d("downloadUrl  == ", str2);
            }
            if (this.J.containsKey("2")) {
                this.p.add(t("2"));
                String str3 = this.J.get("2") + com.zte.iptvclient.android.common.k.i.a();
                this.J.put("2", str3);
                LogEx.d("downloadUrl  == ", str3);
            }
            if (this.J.containsKey("4")) {
                this.p.add(t("4"));
                String str4 = this.J.get("4") + com.zte.iptvclient.android.common.k.i.a();
                this.J.put("4", str4);
                LogEx.d("downloadUrl  == ", str4);
            }
            if (this.J.containsKey("8")) {
                this.p.add(t("8"));
                String str5 = this.J.get("8") + com.zte.iptvclient.android.common.k.i.a();
                this.J.put("8", str5);
                LogEx.d("downloadUrl  == ", str5);
            }
            if (this.J.containsKey(GlobalConst.WINPHONE_CLIENT)) {
                this.p.add(t(GlobalConst.WINPHONE_CLIENT));
                String str6 = this.J.get(GlobalConst.WINPHONE_CLIENT) + com.zte.iptvclient.android.common.k.i.a();
                this.J.put(GlobalConst.WINPHONE_CLIENT, str6);
                LogEx.d("downloadUrl  == ", str6);
            }
            if (this.J.containsKey(GlobalConst.ANDRIODSTB_CLIENT)) {
                this.p.add(t(GlobalConst.ANDRIODSTB_CLIENT));
                String str7 = this.J.get(GlobalConst.ANDRIODSTB_CLIENT) + com.zte.iptvclient.android.common.k.i.a();
                this.J.put(GlobalConst.ANDRIODSTB_CLIENT, str7);
                LogEx.d("downloadUrl  == ", str7);
                return;
            }
            return;
        }
        if (this.J.containsKey(DownloadConstant.REPORT_MSGTYPE_ADD)) {
            this.p.add(com.zte.iptvclient.android.common.i.a.a.a(R.string.definition_fdh));
        }
        if (this.J.containsKey("1")) {
            this.p.add(t("1"));
        }
        if (this.J.containsKey("2")) {
            this.p.add(t("2"));
        }
        if (this.J.containsKey("4")) {
            this.p.add(t("4"));
        }
        if (this.J.containsKey("8")) {
            this.p.add(t("8"));
        }
        if (this.J.containsKey(GlobalConst.WINPHONE_CLIENT)) {
            this.p.add(t(GlobalConst.WINPHONE_CLIENT));
        }
        if (this.J.containsKey(GlobalConst.ANDRIODSTB_CLIENT)) {
            this.p.add(t(GlobalConst.ANDRIODSTB_CLIENT));
        }
        LogEx.d("SeriesDetailDownloadFragment", "mDefinitionNameList=" + this.p.size() + "," + this.p.toString());
    }

    private void J() {
        if (this.s < this.t) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
        }
        M();
        N();
        i iVar = new i(this.h, this.u);
        this.w = iVar;
        this.v.setAdapter((ListAdapter) iVar);
        this.w.a();
        ArrayList<String> a2 = a(this.A, this.u, this.s);
        this.B = a2;
        g gVar = new g(this.h, a2);
        this.D = gVar;
        this.C.setAdapter((ListAdapter) gVar);
        this.D.a();
        if (TextUtils.isEmpty(this.Q)) {
            return;
        }
        if (!this.T) {
            SDKDownloadMgr.getInstance().getDownloadList("0", 2, this.Q, this.a0);
            SDKDownloadMgr.getInstance().getDownloadList("1", 2, this.Q, this.b0);
        } else {
            SDKDownloadMgr.getInstance().getDownloadList("0", 1, this.Q, this.a0);
            SDKDownloadMgr.getInstance().getDownloadList("1", 1, this.Q, this.b0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.N <= 500) {
            LogEx.w("UseeTv", "Operate limit,less than 1000(ms)!");
            return true;
        }
        this.N = currentTimeMillis;
        return false;
    }

    private void L() {
        this.y.setOnClickListener(new a());
        this.x.setOnClickListener(new b());
        this.v.setOnItemClickListener(new c());
        this.C.setOnItemClickListener(new d());
    }

    private void M() {
        ArrayList<String> arrayList = this.p;
        if (arrayList != null) {
            if (arrayList.size() > 1) {
                this.x.setVisibility(0);
            } else {
                this.x.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.P = false;
        this.r.removeAllViews();
        this.x.setBackgroundResource(R.drawable.details_arrow_right);
        if (this.p.size() > 0) {
            this.O = 0;
            this.q = this.p.get(0);
            View inflate = this.L.inflate(R.layout.video_download_definition_title_layout, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.definition_title);
            com.zte.iptvclient.common.uiframe.f.a(textView);
            textView.setText(this.q);
            if (this.h != null) {
                textView.setTextColor(c.a.a.a.d.b.d().b(R.color.video_definitionfoucus_textcolor));
                this.h.a(textView, "textColor", R.color.video_definitionfoucus_textcolor);
                this.r.addView(inflate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        if (TextUtils.equals(this.q, com.zte.iptvclient.android.common.i.a.a.a(R.string.definition_fdh))) {
            this.K = DownloadConstant.REPORT_MSGTYPE_ADD;
        } else if (TextUtils.equals(this.q, t("1"))) {
            this.K = "1";
        } else if (TextUtils.equals(this.q, t("2"))) {
            this.K = "2";
        } else if (TextUtils.equals(this.q, t("4"))) {
            this.K = "4";
        } else if (TextUtils.equals(this.q, t("8"))) {
            this.K = "8";
        } else if (TextUtils.equals(this.q, t(GlobalConst.WINPHONE_CLIENT))) {
            this.K = GlobalConst.WINPHONE_CLIENT;
        } else if (TextUtils.equals(this.q, t(GlobalConst.ANDRIODSTB_CLIENT))) {
            this.K = GlobalConst.ANDRIODSTB_CLIENT;
        }
        this.F.add(str);
        InterfaceC0281h interfaceC0281h = this.S;
        if (interfaceC0281h != null) {
            interfaceC0281h.c(str, this.K);
        }
        this.D.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String t(String str) {
        String str2 = "";
        int i2 = 0;
        while (true) {
            String[] strArr = this.V;
            if (i2 >= strArr.length) {
                return str2;
            }
            if (strArr[i2].equals(str)) {
                String[] strArr2 = this.X;
                if (i2 < strArr2.length) {
                    str2 = strArr2[i2];
                }
            }
            i2++;
        }
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        F();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ArrayList<DownloadTask> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).videoInfo != null && !TextUtils.isEmpty(arrayList.get(i2).videoInfo.get("seriesHeadID")) && !TextUtils.isEmpty(arrayList.get(i2).videoInfo.get("columnCode")) && this.Q.equals(arrayList.get(i2).videoInfo.get("seriesHeadID")) && this.R.equals(arrayList.get(i2).videoInfo.get("columnCode"))) {
                    LogEx.d("SeriesDetailDownloadFragment", "downloaingList=" + arrayList.get(i2).videoInfo.get("seriesIndex"));
                    this.F.add(arrayList.get(i2).videoInfo.get("seriesIndex"));
                }
            }
        }
        g gVar = this.D;
        if (gVar != null) {
            gVar.a();
        }
    }

    private void d(View view) {
        this.r = (LinearLayout) view.findViewById(R.id.download_definition_layout);
        this.x = (ImageView) view.findViewById(R.id.arrow_definition);
        this.y = (RelativeLayout) view.findViewById(R.id.rl_colse_img);
        this.z = (ImageView) view.findViewById(R.id.back_close);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_download_definition_title));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_download_source));
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        this.x.setBackgroundResource(R.drawable.details_arrow_right);
        this.x.setVisibility(8);
        this.v = (HListView) view.findViewById(R.id.navigation_hlistview);
        this.C = (GridView) view.findViewById(R.id.episode_gvew);
        if (BaseApp.a(this.h)) {
            this.C.setNumColumns(8);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<DownloadTask> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).videoInfo != null && !TextUtils.isEmpty(arrayList.get(i2).videoInfo.get("seriesHeadID")) && !TextUtils.isEmpty(arrayList.get(i2).videoInfo.get("columnCode")) && this.Q.equals(arrayList.get(i2).videoInfo.get("seriesHeadID")) && this.R.equals(arrayList.get(i2).videoInfo.get("columnCode"))) {
                    LogEx.d("SeriesDetailDownloadFragment", "downloadList=" + arrayList.get(i2).videoInfo.get("seriesIndex"));
                    this.E.add(arrayList.get(i2).videoInfo.get("seriesIndex"));
                }
            }
        }
        g gVar = this.D;
        if (gVar != null) {
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> a(int i2, ArrayList<String> arrayList, int i3) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int i4 = this.t;
        int i5 = i3 % i4;
        int i6 = i4 * i2;
        if (arrayList.size() > 0) {
            if (i2 == arrayList.size() - 1) {
                if (i5 == 0) {
                    int i7 = i6;
                    while (i7 < this.t + i6) {
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
                while (i9 < this.t + i6) {
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

    public void a(InterfaceC0281h interfaceC0281h) {
        this.S = interfaceC0281h;
    }
}
