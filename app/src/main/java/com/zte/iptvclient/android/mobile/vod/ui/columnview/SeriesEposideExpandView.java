package com.zte.iptvclient.android.mobile.vod.ui.columnview;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.mobile.home.ui.layout.linearLayout.GeneralColumnView;
import com.zte.iptvclient.android.zala.R;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SeriesEposideExpandView extends GeneralColumnView {
    private static String r = SeriesEposideExpandView.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private TextView f7659a;

    /* renamed from: b, reason: collision with root package name */
    private RelativeLayout f7660b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f7661c;

    /* renamed from: d, reason: collision with root package name */
    private long f7662d;
    private int e;
    private int f;
    private int g;
    private int h;
    private ArrayList<String> i;
    private ArrayList<String> j;
    private HListView k;
    private g l;
    private ArrayList<String> m;
    private GridView n;
    private e o;
    private String p;
    private f q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SeriesEposideExpandView.this.k.setSelection(SeriesEposideExpandView.this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SeriesEposideExpandView.this.q != null) {
                SeriesEposideExpandView.this.q.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // it.sephiroth.android.library.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SeriesEposideExpandView.this.d()) {
                return;
            }
            SeriesEposideExpandView.this.h = i;
            LogEx.d(SeriesEposideExpandView.r, "mCurNavPosition = " + SeriesEposideExpandView.this.h);
            if (SeriesEposideExpandView.this.q != null) {
                SeriesEposideExpandView.this.q.a(SeriesEposideExpandView.this.h);
                SeriesEposideExpandView seriesEposideExpandView = SeriesEposideExpandView.this;
                seriesEposideExpandView.a(seriesEposideExpandView.a(seriesEposideExpandView.h, SeriesEposideExpandView.this.j, SeriesEposideExpandView.this.e));
                SeriesEposideExpandView.this.l.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(android.widget.AdapterView<?> adapterView, View view, int i, long j) {
            String valueOf = String.valueOf((SeriesEposideExpandView.this.h * SeriesEposideExpandView.this.f) + i + 1);
            int indexOf = SeriesEposideExpandView.this.i.contains(valueOf) ? SeriesEposideExpandView.this.i.indexOf(valueOf) : -1;
            if (SeriesEposideExpandView.this.d() || indexOf < 0) {
                return;
            }
            SeriesEposideExpandView.this.p = valueOf;
            SeriesEposideExpandView.this.g = i;
            if (SeriesEposideExpandView.this.o != null) {
                SeriesEposideExpandView.this.o.a();
            }
            if (SeriesEposideExpandView.this.q != null) {
                SeriesEposideExpandView.this.q.a(SeriesEposideExpandView.this.h, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e extends com.zte.iptvclient.common.uiframe.c {

        /* renamed from: d, reason: collision with root package name */
        List<String> f7667d;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public class a extends com.zte.iptvclient.common.uiframe.d {

            /* renamed from: a, reason: collision with root package name */
            TextView f7668a;

            /* renamed from: b, reason: collision with root package name */
            RelativeLayout f7669b;

            private a(e eVar) {
            }

            /* synthetic */ a(e eVar, a aVar) {
                this(eVar);
            }
        }

        /* synthetic */ e(SeriesEposideExpandView seriesEposideExpandView, Context context, List list, a aVar) {
            this(context, list);
        }

        private void b(a aVar) {
            aVar.f7668a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numselect_textcolor));
            aVar.f7669b.setBackground(c.a.a.a.d.b.d().d(R.drawable.episode_item_foucs_bg));
            aVar.f7669b.setEnabled(true);
        }

        private void c(a aVar) {
            aVar.f7668a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numunselect_textcolor));
            aVar.f7669b.setBackground(c.a.a.a.d.b.d().d(R.drawable.episode_item_bg));
            aVar.f7669b.setEnabled(true);
        }

        public void a(List<String> list) {
            this.f7667d = list;
            a();
        }

        @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
        public int getCount() {
            return this.f7667d.size();
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
            a aVar;
            LogEx.d(SeriesEposideExpandView.r, " GridViewShowAdapter iPosition:" + i);
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_series_episode_gvew_layout, (ViewGroup) null);
                aVar = new a(this, null);
                aVar.f7668a = (TextView) view.findViewById(R.id.detail_series_episode_gvew_txtvew);
                aVar.f7669b = (RelativeLayout) view.findViewById(R.id.rl_series_episode_gvew_txtvew_item);
                com.zte.iptvclient.common.uiframe.f.a(aVar.f7668a);
                com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_series_episode_gvew_txtvew_item));
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            LogEx.d(SeriesEposideExpandView.r, "mCurGVewPosition =" + SeriesEposideExpandView.this.g + ";mCurNavPosition=" + SeriesEposideExpandView.this.h);
            String str = SeriesEposideExpandView.r;
            StringBuilder sb = new StringBuilder();
            sb.append("mLstSeriesAllNum = ");
            sb.append(SeriesEposideExpandView.this.i.toString());
            LogEx.d(str, sb.toString());
            aVar.f7668a.setText(this.f7667d.get(i));
            LogEx.d(SeriesEposideExpandView.r, "currentSeriesNum = " + SeriesEposideExpandView.this.p);
            if (SeriesEposideExpandView.this.g != i || !SeriesEposideExpandView.this.i.contains(SeriesEposideExpandView.this.p) || !TextUtils.equals(SeriesEposideExpandView.this.p, this.f7667d.get(i))) {
                if (SeriesEposideExpandView.this.i.contains(this.f7667d.get(i))) {
                    c(aVar);
                } else {
                    a(aVar);
                }
            } else {
                b(aVar);
            }
            return view;
        }

        private e(Context context, List<String> list) {
            super(context, list);
            this.f7667d = new ArrayList();
            this.f7667d = list;
        }

        private void a(a aVar) {
            aVar.f7668a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_numunpublish_textcolor));
            aVar.f7669b.setBackground(c.a.a.a.d.b.d().d(R.drawable.episode_item_disable_bg));
            aVar.f7669b.setEnabled(false);
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();

        void a(int i);

        void a(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g extends com.zte.iptvclient.common.uiframe.c {

        /* renamed from: d, reason: collision with root package name */
        private List<String> f7670d;

        /* synthetic */ g(SeriesEposideExpandView seriesEposideExpandView, Context context, List list, a aVar) {
            this(context, list);
        }

        @Override // com.zte.iptvclient.common.uiframe.c, android.widget.Adapter
        public int getCount() {
            return this.f7670d.size();
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
            h hVar;
            LogEx.d(SeriesEposideExpandView.r, "position:" + i);
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_series_episode_nav_item_llayout, (ViewGroup) null);
                hVar = new h(null);
                TextView textView = (TextView) view.findViewById(R.id.detail_series_episode_nav_txtvew);
                hVar.f7671a = textView;
                com.zte.iptvclient.common.uiframe.f.a(textView);
                view.setTag(hVar);
            } else {
                hVar = (h) view.getTag();
            }
            hVar.f7671a.setText(this.f7670d.get(i));
            if (SeriesEposideExpandView.this.h == i) {
                hVar.f7671a.setTextColor(c.a.a.a.d.b.d().b(R.color.movie_spisodeitem_foucs_bg));
            } else {
                hVar.f7671a.setTextColor(c.a.a.a.d.b.d().b(R.color.eposideitem_navnumunselect_textcolor));
                hVar.f7671a.setTypeface(Typeface.defaultFromStyle(0));
            }
            return view;
        }

        private g(Context context, List<String> list) {
            super(context, list);
            this.f7670d = new ArrayList();
            this.f7670d = list;
            LogEx.d(SeriesEposideExpandView.r, "SeriesNumNavigationAdapter created");
        }
    }

    /* loaded from: classes2.dex */
    private static class h extends com.zte.iptvclient.common.uiframe.d {

        /* renamed from: a, reason: collision with root package name */
        TextView f7671a;

        private h() {
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    public SeriesEposideExpandView(Context context) {
        this(context, null);
    }

    public SeriesEposideExpandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private void c() {
        this.m = new ArrayList<>();
        this.i = new ArrayList<>();
    }

    private void e() {
        this.f7660b.setOnClickListener(new b());
        this.k.setOnItemClickListener(new c());
        this.n.setOnItemClickListener(new d());
    }

    private void f() {
        int i = 0;
        if (this.e <= this.f) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
        }
        if (this.j != null) {
            g gVar = this.l;
            a aVar = null;
            if (gVar == null) {
                g gVar2 = new g(this, getContext(), this.j, aVar);
                this.l = gVar2;
                this.k.setAdapter((ListAdapter) gVar2);
                this.k.post(new a());
            } else {
                gVar.a();
            }
            ArrayList<String> arrayList = this.m;
            if (arrayList != null) {
                arrayList.clear();
                int i2 = this.e;
                int i3 = this.f;
                if (i2 >= i3) {
                    int i4 = this.h;
                    int i5 = (i4 + 1) * i3;
                    if (i5 < i2) {
                        int i6 = i4 * i3;
                        while (i6 < i5) {
                            i6++;
                            this.m.add(String.valueOf(i6));
                        }
                    } else {
                        int i7 = i4 * i3;
                        while (i7 < this.e) {
                            i7++;
                            this.m.add(String.valueOf(i7));
                        }
                    }
                } else {
                    while (i < this.e) {
                        i++;
                        this.m.add(String.valueOf(i));
                    }
                }
                LogEx.d(r, "mListGridNum=" + this.m.toString());
                e eVar = this.o;
                if (eVar == null) {
                    e eVar2 = new e(this, getContext(), this.m, aVar);
                    this.o = eVar2;
                    this.n.setAdapter((ListAdapter) eVar2);
                    return;
                }
                eVar.a();
                return;
            }
            return;
        }
        this.l.a();
    }

    public void d(ArrayList<String> arrayList) {
        this.i = arrayList;
    }

    public SeriesEposideExpandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7662d = 0L;
        this.f = 30;
        this.g = 0;
        this.h = 0;
        c();
        a(context);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f7662d <= 1000) {
            LogEx.w("UseeTv", "Operate limit,less than 500(ms)!");
            return true;
        }
        this.f7662d = currentTimeMillis;
        return false;
    }

    public void a(f fVar) {
        this.q = fVar;
    }

    public void b(int i) {
        this.h = i;
    }

    public void c(int i) {
        this.e = i;
    }

    public void a(int i) {
        this.g = i;
    }

    public void b(ArrayList<String> arrayList) {
        a(arrayList);
    }

    public void c(ArrayList<String> arrayList) {
        LogEx.d(r, "mLstEpisodeNav = " + arrayList);
        this.j = arrayList;
    }

    public void e(ArrayList<String> arrayList) {
        LogEx.d(r, "--updateSeriesChildNameMixList--maxlist: " + arrayList.toString());
        this.i = arrayList;
        e eVar = this.o;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void a() {
        if (BaseApp.f()) {
            this.f = 40;
        }
        this.p = String.valueOf((this.h * this.f) + this.g + 1);
        this.f7659a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_series_episode));
        f();
    }

    public void a(ArrayList<String> arrayList) {
        this.m = arrayList;
        e eVar = this.o;
        if (eVar != null) {
            eVar.a(arrayList);
        }
    }

    public ArrayList<String> a(int i, ArrayList<String> arrayList, int i2) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int i3 = this.f;
        int i4 = i2 % i3;
        int i5 = i3 * i;
        if (arrayList.size() > 0) {
            if (i == arrayList.size() - 1) {
                if (i4 == 0) {
                    int i6 = i5;
                    while (i6 < this.f + i5) {
                        StringBuilder sb = new StringBuilder();
                        i6++;
                        sb.append(i6);
                        sb.append("");
                        arrayList2.add(sb.toString());
                    }
                } else {
                    int i7 = i5;
                    while (i7 < i5 + i4) {
                        StringBuilder sb2 = new StringBuilder();
                        i7++;
                        sb2.append(i7);
                        sb2.append("");
                        arrayList2.add(sb2.toString());
                    }
                }
            } else if (arrayList.size() == 1) {
                while (i < i2) {
                    StringBuilder sb3 = new StringBuilder();
                    i++;
                    sb3.append(i);
                    sb3.append("");
                    arrayList2.add(sb3.toString());
                }
            } else {
                int i8 = i5;
                while (i8 < this.f + i5) {
                    StringBuilder sb4 = new StringBuilder();
                    i8++;
                    sb4.append(i8);
                    sb4.append("");
                    arrayList2.add(sb4.toString());
                }
            }
        } else {
            LogEx.w(r, "There is no episode");
        }
        LogEx.d(r, "gridShowList=" + arrayList2.toString());
        return arrayList2;
    }

    private void a(Context context) {
        View inflate = View.inflate(context, R.layout.series_detail_epsiode_more_layout, this);
        this.f7659a = (TextView) inflate.findViewById(R.id.detail_title);
        this.f7660b = (RelativeLayout) inflate.findViewById(R.id.rl_colse_img);
        this.f7661c = (ImageView) inflate.findViewById(R.id.img_close);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.common_detail_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(this.f7659a);
        com.zte.iptvclient.common.uiframe.f.a(this.f7660b);
        com.zte.iptvclient.common.uiframe.f.a(this.f7661c);
        this.k = (HListView) inflate.findViewById(R.id.navigation_hlistview);
        this.n = (GridView) inflate.findViewById(R.id.episode_gvew);
        if (BaseApp.f()) {
            this.n.setNumColumns(8);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.k);
        com.zte.iptvclient.common.uiframe.f.a(this.n);
    }

    public void a(int i, int i2) {
        this.h = i2;
        int i3 = this.f;
        int i4 = (i - (i2 * i3)) - 1;
        this.g = i4;
        this.p = String.valueOf((i2 * i3) + i4 + 1);
        LogEx.d(r, "mCurGVewPosition = " + this.g + " mCurNavPosition " + this.h + " mStrCurSeiresEpsiodeNum " + this.p);
        g gVar = this.l;
        if (gVar != null) {
            gVar.a();
        }
        if (this.o == null || this.i.size() <= 0) {
            return;
        }
        this.o.a();
    }

    public void a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i2, int i3) {
        this.e = i;
        this.j = arrayList;
        this.i = arrayList2;
        this.h = i2;
        this.g = i3;
        this.p = String.valueOf((i2 * this.f) + i3 + 1);
        f();
    }
}
