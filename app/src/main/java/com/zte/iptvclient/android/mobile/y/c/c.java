package com.zte.iptvclient.android.mobile.y.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.search.SDKSearchMgr;
import com.zte.iptvclient.android.common.customview.viewgroup.gridview.LineGridView;
import com.zte.iptvclient.android.common.customview.viewpager.CustomViewPage;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.y.c.d;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.e.c.e.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SearchPlayListFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b implements View.OnTouchListener {
    private LinearLayout A;
    private ScrollView B;
    private LinearLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private ImageView F;
    private TextView G;
    private LinearLayout K;
    private Button L;
    private LinearLayout N;
    private GridView O;
    private TextView P;
    private ArrayList<VideoDetailBean> Q;
    private com.zte.iptvclient.android.mobile.y.c.d R;
    private t S;
    private ArrayList<com.zte.iptvclient.android.mobile.search.bean.d> U;
    private com.zte.iptvclient.android.mobile.v.b.c X;
    private com.zte.iptvclient.android.mobile.v.b.b Y;
    private LinearLayout Z;
    private com.zte.iptvclient.android.mobile.y.a.a a0;
    private com.zte.iptvclient.android.mobile.v.a.b c0;
    private com.zte.iptvclient.android.mobile.v.a.a d0;
    private View e0;
    private ArrayList<Fragment> g0;
    private ArrayList<String> h0;
    private CustomViewPage i0;
    private MagicIndicator m0;
    private net.lucode.hackware.magicindicator.e.c.a n0;
    private EditText p;
    private Button q;
    private ImageView r;
    private LineGridView s;
    private LineGridView t;
    private ListView u;
    private ArrayList<String> v;
    private com.zte.iptvclient.android.mobile.v.a.c w;
    private com.zte.iptvclient.android.common.j.h y;
    private ArrayList<String> z;
    private String x = "";
    private boolean J = false;
    private boolean M = false;
    private long T = 0;
    private boolean V = false;
    private boolean W = true;
    private u b0 = u.VOD;
    private boolean f0 = false;
    private int j0 = 0;
    private boolean k0 = false;
    private String l0 = "";
    private int o0 = 0;
    private int p0 = 1;
    private int q0 = 2;
    d.e r0 = new i();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class a implements TextView.OnEditorActionListener {
        a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            if (c.this.p.getText() == null || TextUtils.isEmpty(c.this.p.getText().toString())) {
                if (TextUtils.isEmpty(c.this.l0)) {
                    return true;
                }
                c cVar = c.this;
                cVar.a(cVar.l0, false);
                return true;
            }
            c cVar2 = c.this;
            cVar2.a(cVar2.p.getText().toString(), false);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            LogEx.d("SearchFragmentNew", "edtSearch onFocusChange=" + z);
            if (z) {
                c.this.J = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.y.c.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0402c implements View.OnClickListener {
        ViewOnClickListenerC0402c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.w.a(!c.this.w.a());
            if (c.this.v.size() > 8 && c.this.w.a()) {
                c.this.L.setVisibility(8);
                if (c.this.w != null) {
                    c.this.w.notifyDataSetChanged();
                    c.this.f0 = false;
                    return;
                }
                return;
            }
            c.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.J();
            c.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = c.this.Q.iterator();
            while (it2.hasNext()) {
                VideoDetailBean videoDetailBean = (VideoDetailBean) it2.next();
                String[] split = videoDetailBean.getPosterfilelist().split(";");
                if (split.length >= 4) {
                    videoDetailBean.setPosterfilelist(split[3]);
                } else {
                    videoDetailBean.setPosterfilelist("");
                }
                arrayList.add(videoDetailBean);
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.w.b(arrayList));
            c.this.Q.clear();
            if (c.this.getActivity() != null) {
                c.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class f implements AdapterView.OnItemClickListener {
        f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (c.this.Q != null) {
                c.this.Q.remove(c.this.a0.getItem(i));
                c.this.a0.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class g implements SDKSearchMgr.OnSearchHintKeyWordListReturnListener {
        g() {
        }

        @Override // com.video.androidsdk.service.search.SDKSearchMgr.OnSearchHintKeyWordListReturnListener
        public void onSearchHintKeyWordListReturn(String str, String str2, String str3) {
            LogEx.d("SearchFragmentNew", " data : " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    JSONArray optJSONArray = jSONObject.optJSONArray("contentname");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("itemlist");
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("wordtype");
                    JSONArray optJSONArray4 = jSONObject.optJSONArray("toppick");
                    JSONArray optJSONArray5 = jSONObject.optJSONArray("totalgroups");
                    JSONArray optJSONArray6 = jSONObject.optJSONArray("bytitle");
                    JSONArray optJSONArray7 = jSONObject.optJSONArray("byactor");
                    JSONArray optJSONArray8 = jSONObject.optJSONArray("bydirector");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            com.zte.iptvclient.android.mobile.search.bean.d dVar = new com.zte.iptvclient.android.mobile.search.bean.d();
                            if (i < optJSONArray.length()) {
                                dVar.d(optJSONArray.get(i).toString());
                            }
                            if (optJSONArray2 != null && i < optJSONArray2.length()) {
                                dVar.e(optJSONArray2.get(i).toString());
                            }
                            if (optJSONArray3 != null && i < optJSONArray3.length()) {
                                dVar.h(optJSONArray3.get(i).toString());
                            }
                            if (optJSONArray4 != null && i < optJSONArray4.length()) {
                                dVar.f(optJSONArray4.get(i).toString());
                            }
                            if (optJSONArray5 != null && i < optJSONArray5.length()) {
                                dVar.g(optJSONArray5.get(i).toString());
                            }
                            if (optJSONArray6 != null && i < optJSONArray6.length()) {
                                dVar.c(optJSONArray6.get(i).toString());
                            }
                            if (optJSONArray7 != null && i < optJSONArray7.length()) {
                                dVar.a(optJSONArray7.get(i).toString());
                            }
                            if (optJSONArray8 != null && i < optJSONArray8.length()) {
                                dVar.b(optJSONArray8.get(i).toString());
                            }
                            c.this.U.add(dVar);
                        }
                    }
                } catch (Exception e) {
                    LogEx.e("SearchFragmentNew", e.getMessage());
                }
            }
            c.this.d0.notifyDataSetChanged();
            if (c.this.U.size() == 0 || c.this.p == null || TextUtils.isEmpty(c.this.p.getText().toString())) {
                return;
            }
            c.this.u.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class h implements SDKSearchMgr.OnSearchHotListReturnListener {
        h() {
        }

        @Override // com.video.androidsdk.service.search.SDKSearchMgr.OnSearchHotListReturnListener
        public void onSearchHotListReturn(String str, String str2, String str3) {
            LogEx.d("SearchFragmentNew", "returncode : " + str + ", errormsg : " + str2 + ", data : " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("itemlist");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        c.this.z.add(jSONArray.get(i).toString());
                    }
                } catch (Exception e) {
                    LogEx.e("SearchFragmentNew", e.getMessage());
                }
            }
            if (c.this.c0 != null) {
                c.this.c0.notifyDataSetChanged();
            }
            c.this.Y();
        }
    }

    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    class i implements d.e {
        i() {
        }

        @Override // com.zte.iptvclient.android.mobile.y.c.d.e
        public void a(com.zte.iptvclient.android.common.javabean.models.f fVar) {
            VideoDetailBean a2;
            if (fVar == null || (a2 = com.zte.iptvclient.android.mobile.y.b.a.a(fVar)) == null) {
                return;
            }
            if (!com.zte.iptvclient.android.mobile.y.b.a.c().a(a2) && com.zte.iptvclient.android.mobile.y.b.a.c().b()) {
                c.this.Q.add(a2);
            } else {
                if (!com.zte.iptvclient.android.mobile.y.b.a.c().a(a2)) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= c.this.Q.size()) {
                        break;
                    }
                    if (TextUtils.equals(a2.getProgramcode(), ((VideoDetailBean) c.this.Q.get(i)).getProgramcode())) {
                        c.this.Q.remove(i);
                        break;
                    }
                    i++;
                }
            }
            if (c.this.a0 != null) {
                c.this.a0.notifyDataSetChanged();
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.w.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class j {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7834a;

        static {
            int[] iArr = new int[u.values().length];
            f7834a = iArr;
            try {
                iArr[u.VOD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7834a[u.TVOD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7834a[u.LIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a0 = new com.zte.iptvclient.android.mobile.y.a.a(((com.zte.fragmentlib.b) c.this).h, c.this.Q);
            c.this.O.setAdapter((ListAdapter) c.this.a0);
            if (c.this.a0 != null) {
                c.this.a0.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class l extends net.lucode.hackware.magicindicator.e.c.b.a {

        /* compiled from: SearchPlayListFragment.java */
        /* loaded from: classes2.dex */
        class a implements a.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ TextView f7837a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f7838b;

            a(TextView textView, int i) {
                this.f7837a = textView;
                this.f7838b = i;
            }

            @Override // net.lucode.hackware.magicindicator.e.c.e.a.b
            public void a(int i, int i2) {
                this.f7837a.setTextColor(c.a.a.a.d.b.d().b(R.color.black_old));
                ((com.zte.fragmentlib.b) c.this).h.a(this.f7837a, "textColor", R.color.black_old);
                c.this.p.clearFocus();
            }

            @Override // net.lucode.hackware.magicindicator.e.c.e.a.b
            public void a(int i, int i2, float f, boolean z) {
            }

            @Override // net.lucode.hackware.magicindicator.e.c.e.a.b
            public void b(int i, int i2) {
                this.f7837a.setTextColor(c.a.a.a.d.b.d().b(R.color.common_column_text_selected));
                ((com.zte.fragmentlib.b) c.this).h.a(this.f7837a, "textColor", R.color.common_column_text_selected);
                c.this.p.clearFocus();
                c.this.j0 = this.f7838b;
                if (this.f7838b != c.this.o0) {
                    if (this.f7838b != c.this.p0) {
                        if (this.f7838b == c.this.q0) {
                            c.this.a(u.LIVE);
                        }
                    } else {
                        c.this.a(u.TVOD);
                    }
                } else {
                    c.this.a(u.VOD);
                }
                c.this.i0.a(this.f7838b, false);
            }

            @Override // net.lucode.hackware.magicindicator.e.c.e.a.b
            public void b(int i, int i2, float f, boolean z) {
            }
        }

        /* compiled from: SearchPlayListFragment.java */
        /* loaded from: classes2.dex */
        class b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f7840a;

            b(int i) {
                this.f7840a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f7840a < c.this.h0.size()) {
                    c.this.p.clearFocus();
                    c.this.j0 = this.f7840a;
                    if (this.f7840a != c.this.o0) {
                        if (this.f7840a != c.this.p0) {
                            if (this.f7840a == c.this.q0) {
                                c.this.a(u.LIVE);
                            }
                        } else {
                            c.this.a(u.TVOD);
                        }
                    } else {
                        c.this.a(u.VOD);
                    }
                    c.this.i0.a(this.f7840a, false);
                }
            }
        }

        l() {
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public int a() {
            if (c.this.h0 == null) {
                return 0;
            }
            return c.this.h0.size();
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public net.lucode.hackware.magicindicator.e.c.b.d a(Context context, int i) {
            if (i >= c.this.h0.size()) {
                return null;
            }
            net.lucode.hackware.magicindicator.e.c.e.a aVar = new net.lucode.hackware.magicindicator.e.c.e.a(context);
            aVar.a(R.layout.simple_pager_title_layout);
            TextView textView = (TextView) aVar.findViewById(R.id.txt_simple_title);
            textView.setText((CharSequence) c.this.h0.get(i));
            aVar.a(new a(textView, i));
            aVar.setOnClickListener(new b(i));
            return aVar;
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public net.lucode.hackware.magicindicator.e.c.b.c a(Context context) {
            net.lucode.hackware.magicindicator.e.c.c.a aVar = new net.lucode.hackware.magicindicator.e.c.c.a(context);
            if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
                aVar.a(Integer.valueOf(((com.zte.fragmentlib.b) c.this).h.getResources().getColor(R.color.line_pagerindicator_dark)));
            } else {
                aVar.a(Integer.valueOf(((com.zte.fragmentlib.b) c.this).h.getResources().getColor(R.color.common_column_text_selected)));
            }
            aVar.a(7.0f);
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class m implements AdapterView.OnItemClickListener {
        m() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (c.this.d0 == null || i >= c.this.d0.getCount() || c.this.U.get(i) == null) {
                return;
            }
            String a2 = ((com.zte.iptvclient.android.mobile.search.bean.d) c.this.U.get(i)).a();
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            c.this.a(a2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class n implements AdapterView.OnItemClickListener {
        n() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == c.this.v.size()) {
                return;
            }
            String str = (String) c.this.v.get(i);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.this.a(str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class o implements AdapterView.OnItemClickListener {
        o() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == c.this.z.size()) {
                return;
            }
            String str = (String) c.this.z.get(i);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.this.a(str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class p implements View.OnClickListener {

        /* compiled from: SearchPlayListFragment.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.getActivity() != null) {
                    c.this.getActivity().finish();
                }
                if (c.this.V) {
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.d(2));
                }
            }
        }

        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Window window;
            c.this.A();
            FragmentActivity activity = c.this.getActivity();
            if (activity != null && (window = activity.getWindow()) != null) {
                window.setSoftInputMode(32);
            }
            c.this.e0.postDelayed(new a(), 30L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.J = false;
            c.this.p.setText("");
            c.this.f0 = true;
            c.this.W();
            c.this.p.requestFocus();
            c cVar = c.this;
            cVar.c(cVar.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.N()) {
                return;
            }
            if (c.this.p.getText() == null || TextUtils.isEmpty(c.this.p.getText().toString())) {
                if (TextUtils.isEmpty(c.this.l0)) {
                    return;
                }
                c cVar = c.this;
                cVar.a(cVar.l0, false);
                return;
            }
            c cVar2 = c.this;
            cVar2.a(cVar2.p.getText().toString(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public class s implements TextWatcher {
        s() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(c.this.p.getText().toString())) {
                c.this.W();
                return;
            }
            c.this.J = false;
            c.this.f0 = true;
            c.this.W();
            c.this.p.requestFocus();
            c cVar = c.this;
            cVar.c(cVar.p);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public static class t extends androidx.fragment.app.n {
        ArrayList<Fragment> h;

        public t(FragmentManager fragmentManager, ArrayList<Fragment> arrayList) {
            super(fragmentManager);
            this.h = arrayList;
        }

        @Override // androidx.viewpager.widget.a
        public int a() {
            return this.h.size();
        }

        @Override // androidx.fragment.app.n
        public Fragment c(int i) {
            return this.h.get(i);
        }

        @Override // androidx.fragment.app.n, androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i, Object obj) {
            super.a(viewGroup, i, obj);
        }

        @Override // androidx.fragment.app.n, androidx.viewpager.widget.a
        public Object a(ViewGroup viewGroup, int i) {
            return super.a(viewGroup, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SearchPlayListFragment.java */
    /* loaded from: classes2.dex */
    public enum u {
        VOD,
        TVOD,
        LIVE
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.v.clear();
        this.x = "";
        this.y.D("");
        com.zte.iptvclient.android.mobile.v.a.c cVar = this.w;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
            this.f0 = false;
        }
        I();
    }

    private void K() {
        this.v.clear();
        this.x = this.y.M();
        LogEx.d("SearchFragmentNew", "getmStrSearchHistory=" + this.x);
        if (!TextUtils.isEmpty(this.x)) {
            String[] split = this.x.split(",");
            if (split.length > 0) {
                for (String str : split) {
                    this.v.add(str);
                }
                LogEx.d("SearchFragmentNew", "mSearchHistoryListget=" + this.v.size());
            }
        }
        I();
        LogEx.d("getmSearchHistoryList", this.v.toString());
        com.zte.iptvclient.android.mobile.v.a.c cVar = this.w;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    private void L() {
        String g2 = com.zte.iptvclient.android.common.k.o.j().g();
        if (!TextUtils.isEmpty(g2)) {
            this.k0 = true;
        }
        LogEx.d("SearchFragmentNew", "SearchServer is exit=" + g2);
        this.y = new com.zte.iptvclient.android.common.j.h(this.h);
        this.Q = new ArrayList<>();
        this.z = new ArrayList<>();
        com.zte.iptvclient.android.mobile.v.a.b bVar = new com.zte.iptvclient.android.mobile.v.a.b(this.h, this.z);
        this.c0 = bVar;
        bVar.a(this.M);
        this.t.setAdapter((ListAdapter) this.c0);
        this.U = new ArrayList<>();
        com.zte.iptvclient.android.mobile.v.a.a aVar = new com.zte.iptvclient.android.mobile.v.a.a(this.h, this.U);
        this.d0 = aVar;
        aVar.a(this.M);
        this.u.setAdapter((ListAdapter) this.d0);
        this.v = new ArrayList<>();
        com.zte.iptvclient.android.mobile.v.a.c cVar = new com.zte.iptvclient.android.mobile.v.a.c(this.h, this.v);
        this.w = cVar;
        cVar.b(this.M);
        this.s.setAdapter((ListAdapter) this.w);
        this.R = new com.zte.iptvclient.android.mobile.y.c.d();
        this.X = new com.zte.iptvclient.android.mobile.v.b.c();
        this.Y = new com.zte.iptvclient.android.mobile.v.b.b();
        ArrayList<String> arrayList = new ArrayList<>();
        this.h0 = arrayList;
        if (this.k0) {
            arrayList.add(0, com.zte.iptvclient.android.common.i.a.a.a(R.string.search_and_favorite_list_vod));
            this.o0 = 0;
            P();
        } else {
            arrayList.add(0, com.zte.iptvclient.android.common.i.a.a.a(R.string.search_and_favorite_list_vod));
            this.o0 = 0;
            this.q0 = 1;
            this.D.setVisibility(8);
        }
        K();
    }

    private void M() {
        if (this.h0.size() == 0) {
            return;
        }
        ArrayList<Fragment> arrayList = this.g0;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.g0 = new ArrayList<>();
        }
        if (this.W) {
            Bundle bundle = new Bundle();
            bundle.getBoolean("mIsForSowingList", true);
            this.g0.add(this.R);
            this.R.setArguments(bundle);
            this.R.a(this.r0);
            this.R.b(this.Q);
            this.N.setVisibility(0);
            this.Q = com.zte.iptvclient.android.mobile.y.b.a.c().a();
            this.N.post(new k());
            this.m0.setVisibility(8);
        } else {
            this.m0.setVisibility(0);
            this.N.setVisibility(8);
            if (this.k0) {
                this.g0.add(this.R);
                this.g0.add(this.X);
                this.g0.add(this.Y);
                this.i0.e(3);
            } else {
                this.g0.add(this.R);
                this.g0.add(this.Y);
                this.i0.e(2);
            }
        }
        if (this.S == null) {
            this.S = new t(getChildFragmentManager(), this.g0);
        }
        this.i0.a(this.S);
        this.S.b();
        if (this.n0 == null) {
            net.lucode.hackware.magicindicator.e.c.a aVar = new net.lucode.hackware.magicindicator.e.c.a(this.h);
            this.n0 = aVar;
            aVar.a(0.35f);
            this.n0.b(true);
            this.n0.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.common_column_background));
            this.h.a(this.n0, "background", R.color.common_column_background);
            this.n0.a(true);
            this.m0.a(this.n0);
            net.lucode.hackware.magicindicator.c.a(this.m0, this.i0);
        }
        this.n0.a(new l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.T <= 500) {
            LogEx.w("UseeTv", "Operate limit,less than 500(ms)!");
            return true;
        }
        this.T = currentTimeMillis;
        return false;
    }

    private void O() {
        this.E.setVisibility(8);
        this.u.setVisibility(8);
        LogEx.d("SearchFragmentNew", "mSearchKeyWordHintLv.setVisibility(View.GONE);");
        this.B.setVisibility(0);
        K();
    }

    private void P() {
        ArrayList<String> arrayList = this.z;
        if (arrayList != null) {
            arrayList.clear();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("platformid", "0");
        hashMap.put("languagetype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Search_Server_CpCode");
        if (TextUtils.isEmpty(c2)) {
            c2 = "";
        }
        hashMap.put("cpcode", c2);
        String g2 = com.zte.iptvclient.android.common.k.o.j().g();
        SDKSearchMgr sDKSearchMgr = new SDKSearchMgr();
        sDKSearchMgr.setServerDomain(g2);
        sDKSearchMgr.searchHotList(hashMap, new h());
    }

    private void Q() {
        this.i0.a(this.q0, false);
    }

    private void R() {
        this.i0.a(this.p0, false);
    }

    private void S() {
        this.i0.a(this.o0, false);
    }

    private void T() {
        this.u.setOnItemClickListener(new m());
        this.s.setOnItemClickListener(new n());
        this.t.setOnItemClickListener(new o());
        this.q.setOnClickListener(new p());
        this.r.setOnClickListener(new q());
        this.F.setOnClickListener(new r());
        this.p.addTextChangedListener(new s());
        this.p.setOnEditorActionListener(new a());
        this.p.setOnFocusChangeListener(new b());
        this.L.setOnClickListener(new ViewOnClickListenerC0402c());
        this.G.setOnClickListener(new d());
        this.P.setOnClickListener(new e());
        this.O.setOnItemClickListener(new f());
        this.B.setOnTouchListener(this);
        this.C.setOnTouchListener(this);
        this.D.setOnTouchListener(this);
        this.E.setOnTouchListener(this);
    }

    private void U() {
        this.J = false;
        A();
        V();
        EditText editText = this.p;
        if (editText != null) {
            s(editText.getText().toString());
        }
    }

    private void V() {
        this.B.setVisibility(8);
        this.u.setVisibility(8);
        this.E.setVisibility(0);
        this.r.setVisibility(0);
        this.i0.a(this.j0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        com.zte.iptvclient.android.mobile.v.a.a aVar = this.d0;
        if (aVar != null) {
            aVar.a(this.p.getText().toString());
        }
        if (!TextUtils.isEmpty(this.p.getText().toString())) {
            if (!this.J && this.k0) {
                t(this.p.getText().toString());
            }
            this.r.setVisibility(0);
            X();
        } else {
            this.u.setVisibility(8);
            this.r.setVisibility(8);
            this.B.setVisibility(0);
        }
        if (this.f0) {
            O();
            this.f0 = false;
        }
    }

    private void X() {
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        if (this.z.size() == 0) {
            this.D.setVisibility(8);
        } else {
            this.D.setVisibility(0);
        }
    }

    protected void I() {
        LogEx.d("SearchFragmentNew", "mSearchHistoryList " + this.v.size());
        if (this.v.size() <= 0) {
            this.C.setVisibility(8);
            return;
        }
        if (this.v.size() > 0 && this.v.size() <= 8) {
            this.C.setVisibility(0);
            this.K.setVisibility(0);
            this.L.setVisibility(8);
            this.G.setVisibility(0);
            return;
        }
        this.C.setVisibility(0);
        this.K.setVisibility(0);
        this.L.setVisibility(0);
        this.G.setVisibility(0);
        this.L.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.more_history));
        Drawable drawable = getResources().getDrawable(R.drawable.detail_more_normal);
        drawable.setBounds(5, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.L.setCompoundDrawables(null, null, drawable, null);
        com.zte.iptvclient.android.mobile.v.a.c cVar = this.w;
        if (cVar != null) {
            cVar.a(false);
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Window window;
        super.onActivityCreated(bundle);
        L();
        T();
        M();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(48);
        }
        this.p.requestFocus();
        c(this.p);
        EventBus.getDefault().register(this);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.l0 = arguments.getString("InitCondition");
            this.W = arguments.getBoolean("mIsForSowingList", true);
            this.M = arguments.getBoolean("DarkTheme", false);
            this.V = arguments.getBoolean("IsFullScreen", false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_search_movie, (ViewGroup) null);
        this.e0 = inflate;
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.w.b bVar) {
        com.zte.iptvclient.android.mobile.y.a.a aVar = this.a0;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.most_searched_llayout /* 2131297452 */:
            case R.id.re_scro_view /* 2131297642 */:
            case R.id.search_history_layout /* 2131297960 */:
            case R.id.search_result_layout /* 2131297974 */:
                if (motionEvent.getAction() != 0 || (view instanceof EditText)) {
                    return false;
                }
                A();
                break;
            default:
                return false;
        }
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (this.M) {
            textView.setVisibility(8);
        } else {
            if (a2 <= 0) {
                a2 = 60;
            }
            textView.setHeight(a2);
        }
        this.A = (LinearLayout) view.findViewById(R.id.search_layout);
        this.p = (EditText) view.findViewById(R.id.edtSearch);
        if (!TextUtils.isEmpty(this.l0)) {
            this.p.setHint(this.l0);
        } else {
            this.p.setHint(com.zte.iptvclient.android.common.i.a.a.a(R.string.default_search_hint));
        }
        com.zte.iptvclient.android.common.customview.a.b.a.a(this.h.getApplicationContext(), this.p);
        this.F = (ImageView) view.findViewById(R.id.search_image);
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.q = button;
        button.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        this.s = (LineGridView) view.findViewById(R.id.search_history_lv);
        this.K = (LinearLayout) view.findViewById(R.id.ll_search_history_clear);
        Button button2 = (Button) view.findViewById(R.id.search_history_more_btn);
        this.L = button2;
        button2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.more_history));
        this.D = (LinearLayout) view.findViewById(R.id.most_searched_llayout);
        this.t = (LineGridView) view.findViewById(R.id.most_searched_lv);
        this.B = (ScrollView) view.findViewById(R.id.re_scro_view);
        this.C = (LinearLayout) view.findViewById(R.id.search_history_layout);
        this.E = (LinearLayout) view.findViewById(R.id.search_result_layout);
        this.u = (ListView) view.findViewById(R.id.search_lenovo_lv);
        TextView textView2 = (TextView) view.findViewById(R.id.search_history_clear_all);
        this.G = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.clear_all_history));
        this.m0 = (MagicIndicator) view.findViewById(R.id.magic_indicator);
        this.i0 = (CustomViewPage) view.findViewById(R.id.viewpager);
        this.r = (ImageView) view.findViewById(R.id.search_clear_iv);
        this.N = (LinearLayout) view.findViewById(R.id.ll_multiscreen_program_edit_view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_program_edit_main);
        this.Z = linearLayout;
        this.O = (GridView) linearLayout.findViewById(R.id.gv_program_edit);
        TextView textView3 = (TextView) this.Z.findViewById(R.id.txt_ok);
        this.P = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multiscreen_program_confirm));
        TextView textView4 = (TextView) view.findViewById(R.id.search_history_txt);
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.search_history));
        com.zte.iptvclient.common.uiframe.f.a(textView4);
        TextView textView5 = (TextView) view.findViewById(R.id.most_searched_des_txt);
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.most_searched));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.most_searched_des_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.header_clear_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.buttom_clear_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.hot_buttom_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_llayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_search_edit_layout));
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.F);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.K);
        com.zte.iptvclient.common.uiframe.f.a(this.L);
        com.zte.iptvclient.common.uiframe.f.a(this.G);
        com.zte.iptvclient.common.uiframe.f.a(this.m0);
        com.zte.iptvclient.common.uiframe.f.a(this.i0);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.N);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_program_edit_main));
        com.zte.iptvclient.common.uiframe.f.a(this.O);
        com.zte.iptvclient.common.uiframe.f.a(this.P);
        if (this.M) {
            View view2 = this.e0;
            if (view2 != null) {
                view2.setBackgroundResource(R.color.search_view_main_theme_color_small_trance);
            }
            this.u.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_view_main_theme_color_small));
            this.h.a(this.u, "background", R.color.search_view_main_theme_color_small);
            this.u.setDividerHeight(1);
            this.s.setBackground(null);
            this.t.setBackground(null);
            View findViewById = view.findViewById(R.id.buttom_clear_line);
            findViewById.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_dark));
            this.h.a(findViewById, "background", R.color.multiplayer_theme_dividerline_dark);
            View findViewById2 = view.findViewById(R.id.header_clear_line);
            findViewById2.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_dark));
            this.h.a(findViewById2, "background", R.color.multiplayer_theme_dividerline_dark);
            View findViewById3 = view.findViewById(R.id.hot_buttom_line);
            findViewById3.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_dark));
            this.h.a(findViewById3, "background", R.color.multiplayer_theme_dividerline_dark);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_search_edit_layout);
            linearLayout2.setBackground(c.a.a.a.d.b.d().d(R.drawable.search_edit_bg_small));
            this.h.a(linearLayout2, "src", R.drawable.search_edit_bg_small);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.ll_search_history_text);
            relativeLayout.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_history_bg_color_small));
            this.h.a(relativeLayout, "background", R.color.search_history_bg_color_small);
            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_search_mosted_text);
            linearLayout3.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_history_bg_color_small));
            this.h.a(linearLayout3, "background", R.color.search_history_bg_color_small);
            TextView textView6 = (TextView) view.findViewById(R.id.search_history_txt);
            textView6.setTextColor(c.a.a.a.d.b.d().b(R.color.search_small_color));
            this.h.a(textView6, "textColor", R.color.search_small_color);
            TextView textView7 = (TextView) view.findViewById(R.id.search_history_clear_all);
            textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.clear_all_history));
            textView7.setTextColor(c.a.a.a.d.b.d().b(R.color.search_small_color));
            this.h.a(textView7, "textColor", R.color.search_small_color);
            textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.most_searched));
            textView5.setTextColor(c.a.a.a.d.b.d().b(R.color.search_small_color));
            this.h.a(textView5, "textColor", R.color.search_small_color);
            this.G.setTextColor(c.a.a.a.d.b.d().b(R.color.search_small_color));
            this.h.a(this.G, "textColor", R.color.search_small_color);
            this.q.setTextColor(c.a.a.a.d.b.d().b(R.color.white));
            this.h.a(this.q, "textColor", R.color.white);
            this.p.setTextColor(c.a.a.a.d.b.d().b(R.color.search_small_color));
            this.h.a(this.p, "textColor", R.color.search_small_color);
            View findViewById4 = view.findViewById(R.id.multiscreen_program_edit_view_top);
            findViewById4.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_dark));
            this.h.a(findViewById4, "background", R.color.multiplayer_theme_dividerline_dark);
            view.findViewById(R.id.multiscreen_program_edit_view_buttom).setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_dark));
            this.h.a(this.p, "background", R.color.multiplayer_theme_dividerline_dark);
            this.N.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_bg_dark));
            this.h.a(this.N, "background", R.color.multiplayer_theme_bg_dark);
            return;
        }
        this.A.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_view_main_theme_color));
        this.h.a(this.A, "background", R.color.search_view_main_theme_color);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_search_layout);
        relativeLayout2.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_view_main_theme_color));
        this.h.a(relativeLayout2, "background", R.color.search_view_main_theme_color);
        this.i0.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_view_main_theme_color));
        this.h.a(this.i0, "background", R.color.search_view_main_theme_color);
        this.E.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_view_main_theme_color));
        this.h.a(this.E, "background", R.color.search_view_main_theme_color);
        this.C.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_view_main_theme_color));
        this.h.a(this.C, "background", R.color.search_view_main_theme_color);
        this.B.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_view_main_theme_color));
        this.h.a(this.B, "background", R.color.search_view_main_theme_color);
        this.s.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_view_main_theme_color));
        this.h.a(this.s, "background", R.color.search_view_main_theme_color);
        this.u.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_view_main_theme_color));
        this.h.a(this.u, "background", R.color.search_view_main_theme_color);
        this.t.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_view_main_theme_color));
        this.h.a(this.t, "background", R.color.search_view_main_theme_color);
    }

    private void s(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = 0;
        if (this.v.size() < 10) {
            if (!this.v.contains(str)) {
                if (!StringUtil.isEmptyString(this.x)) {
                    this.x = str + "," + this.x;
                } else {
                    this.x = str;
                }
            } else {
                this.v.remove(str);
                LogEx.d("SearchFragmentNew", "removeStrAccountmaccountLoginedList=" + this.v.toString());
                this.x = "";
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str + ",");
                while (i2 < this.v.size()) {
                    stringBuffer.append(this.v.get(i2));
                    if (i2 != this.v.size() - 1) {
                        stringBuffer.append(",");
                    }
                    i2++;
                }
                this.x = stringBuffer.toString();
                LogEx.d("SearchFragmentNew", "SavemStrSearchHistory=" + this.x);
            }
        } else if (!this.v.contains(str)) {
            this.v.remove(r0.size() - 1);
            this.x = "";
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str + ",");
            while (i2 < this.v.size()) {
                stringBuffer2.append(this.v.get(i2));
                if (i2 != this.v.size() - 1) {
                    stringBuffer2.append(",");
                }
                i2++;
            }
            LogEx.d("SearchFragmentNew", "updateStorageSearchHistorydList=" + this.v.toString());
            this.x = stringBuffer2.toString();
            LogEx.d("SearchFragmentNew", "SavemmcontainsSearchHistory=" + this.x);
        } else {
            this.v.remove(str);
            LogEx.d("SearchFragmentNew", "removemSearchHistoryListList=" + this.v);
            this.x = "";
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(str + ",");
            while (i2 < this.v.size()) {
                stringBuffer3.append(this.v.get(i2));
                if (i2 != this.v.size() - 1) {
                    stringBuffer3.append(",");
                }
                i2++;
            }
            this.x = stringBuffer3.toString();
            LogEx.d("SearchFragmentNew", "SaveSearchHistory=" + this.x);
        }
        LogEx.d("SearchFragmentNew", "SaveSearchHistory=" + this.x);
        this.y.D(this.x);
    }

    private void t(String str) {
        ArrayList<com.zte.iptvclient.android.mobile.search.bean.d> arrayList = this.U;
        if (arrayList != null && this.d0 != null) {
            arrayList.clear();
            this.d0.notifyDataSetChanged();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("condition", str);
        hashMap.put("conditiontype", "16|17|18|19|20|21");
        hashMap.put("searchtype", "2");
        hashMap.put("platformid", "0");
        hashMap.put("languagetype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "20");
        hashMap.put("filtertype", "0");
        hashMap.put("sorttype", "0|1");
        SDKSearchMgr sDKSearchMgr = new SDKSearchMgr();
        sDKSearchMgr.setServerDomain(com.zte.iptvclient.android.common.k.o.j().g());
        sDKSearchMgr.searchHintKeyWordList(hashMap, new g());
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        if (this.V) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.d(2));
        }
        if (getActivity() == null) {
            return true;
        }
        getActivity().finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        this.u.setVisibility(8);
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.v.b(str));
        this.J = z;
        EditText editText = this.p;
        if (editText != null) {
            if (z) {
                editText.setText(str);
                this.p.setSelection(str.length());
            } else {
                editText.clearFocus();
            }
        }
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u uVar) {
        this.u.setVisibility(8);
        if (uVar != this.b0) {
            this.b0 = uVar;
            int i2 = j.f7834a[uVar.ordinal()];
            if (i2 == 1) {
                S();
            } else if (i2 == 2) {
                R();
            } else {
                if (i2 != 3) {
                    return;
                }
                Q();
            }
        }
    }
}
