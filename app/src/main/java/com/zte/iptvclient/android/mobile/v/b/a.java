package com.zte.iptvclient.android.mobile.v.b;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.search.SDKSearchMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.gridview.LineGridView;
import com.zte.iptvclient.android.common.customview.viewpager.CustomViewPage;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.common.player.multiplay.activity.MultiPlayActivity;
import com.zte.iptvclient.android.mobile.v.b.d;
import com.zte.iptvclient.android.zala.R;
import com.zte.sdk.enumclass.CapablityEnum;
import com.zte.servicesdk.util.PortalConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.e.c.e.a;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SearchFragmentNew.java */
/* loaded from: classes2.dex */
public class a extends com.zte.fragmentlib.b implements View.OnTouchListener {
    private RelativeLayout A;
    private ScrollView B;
    private LinearLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private ImageView F;
    private TextView G;
    private LinearLayout K;
    private Button L;
    private LinearLayout O;
    private com.zte.iptvclient.android.common.player.i.a P;
    private GridView Q;
    private ArrayList<com.zte.iptvclient.android.common.javabean.f> R;
    private TextView S;
    private com.zte.iptvclient.android.mobile.v.b.d T;
    private com.zte.iptvclient.android.mobile.v.b.c U;
    private com.zte.iptvclient.android.mobile.v.b.b V;
    private t W;
    private ArrayList<com.zte.iptvclient.android.mobile.search.bean.d> Y;
    private com.zte.iptvclient.android.mobile.v.a.b b0;
    private com.zte.iptvclient.android.mobile.v.a.a c0;
    private View d0;
    private ArrayList<Fragment> f0;
    private ArrayList<String> g0;
    private CustomViewPage h0;
    private MagicIndicator l0;
    private net.lucode.hackware.magicindicator.e.c.a m0;
    private EditText p;
    private Button q;
    private s q0;
    private ImageView r;
    private boolean r0;
    private LineGridView s;
    private boolean s0;
    private LineGridView t;
    private long t0;
    private ListView u;
    private ArrayList<String> v;
    private com.zte.iptvclient.android.mobile.v.a.c w;
    private com.zte.iptvclient.android.common.j.h y;
    private ArrayList<String> z;
    private String x = "";
    private boolean J = false;
    private boolean M = false;
    private boolean N = false;
    private long X = 0;
    private boolean Z = false;
    private u a0 = u.VOD;
    private boolean e0 = false;
    private int i0 = 0;
    private boolean j0 = false;
    private String k0 = "";
    private int n0 = 0;
    private int o0 = 1;
    private int p0 = 2;
    d.g u0 = new h();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* renamed from: com.zte.iptvclient.android.mobile.v.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0369a implements TextView.OnEditorActionListener {
        C0369a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            a.this.t0 = System.currentTimeMillis();
            if (i != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            a.this.r0 = true;
            if (a.this.p.getText() == null || TextUtils.isEmpty(a.this.p.getText().toString())) {
                if (!TextUtils.isEmpty(a.this.k0)) {
                    a aVar = a.this;
                    aVar.a(aVar.k0, false);
                }
            } else {
                a aVar2 = a.this;
                aVar2.a(aVar2.p.getText().toString(), false);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            LogEx.d("SearchFragmentNew", "edtSearch onFocusChange=" + z);
            if (z) {
                a.this.J = false;
            }
            if (z && !a.this.s0) {
                a.this.p.setHint("");
            }
            if (a.this.s0) {
                a.this.s0 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.w.a(!a.this.w.a());
            if (a.this.v.size() > 8 && a.this.w.a()) {
                a.this.L.setVisibility(8);
                if (a.this.w != null) {
                    a.this.w.notifyDataSetChanged();
                    a.this.e0 = false;
                    return;
                }
                return;
            }
            a.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.L();
            a.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zte.iptvclient.android.common.player.k.c J;
            boolean z = true;
            if (a.this.R.size() <= 1) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.multiscreen_program_too_less));
                return;
            }
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            a.this.getFragmentManager().F();
            int i = 0;
            if (a.this.I()) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.a());
            } else {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.c(false));
            }
            if (!(((com.zte.fragmentlib.b) a.this).h instanceof MultiPlayActivity)) {
                if (((com.zte.fragmentlib.b) a.this).h instanceof VOPlayerActivity) {
                    Intent intent = new Intent();
                    intent.setClass(((com.zte.fragmentlib.b) a.this).h, MultiPlayActivity.class);
                    ComponentName resolveActivity = intent.resolveActivity(((com.zte.fragmentlib.b) a.this).h.getPackageManager());
                    if (resolveActivity != null) {
                        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) ((com.zte.fragmentlib.b) a.this).h.getSystemService("activity")).getRunningTasks(10)) {
                            if (runningTaskInfo.topActivity.equals(resolveActivity) || runningTaskInfo.baseActivity.equals(resolveActivity)) {
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        Fragment parentFragment = a.this.getParentFragment();
                        if (parentFragment != null && (parentFragment instanceof com.zte.iptvclient.android.common.player.k.c)) {
                            while (true) {
                                if (i >= a.this.R.size()) {
                                    break;
                                }
                                com.zte.iptvclient.android.common.javabean.f fVar = (com.zte.iptvclient.android.common.javabean.f) a.this.R.get(i);
                                com.zte.iptvclient.android.common.player.k.c cVar = (com.zte.iptvclient.android.common.player.k.c) parentFragment;
                                if (fVar.d().equals(cVar.L1())) {
                                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.i.c(fVar.d(), cVar.O1()));
                                    break;
                                }
                                i++;
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(a.this.R);
                        EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.i(arrayList));
                    } else {
                        intent.addFlags(268435456);
                        ((com.zte.fragmentlib.b) a.this).h.startActivity(intent);
                    }
                    ((com.zte.fragmentlib.b) a.this).h.finish();
                    return;
                }
                Fragment parentFragment2 = a.this.getParentFragment();
                if (parentFragment2 != null && (parentFragment2 instanceof com.zte.iptvclient.android.common.player.k.c)) {
                    a.this.a((com.zte.iptvclient.android.common.player.k.c) parentFragment2);
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.a());
                } else if (parentFragment2 instanceof com.zte.iptvclient.android.mobile.e0.e.d) {
                    com.zte.iptvclient.android.common.player.k.c J2 = ((com.zte.iptvclient.android.mobile.e0.e.d) parentFragment2).J();
                    if (J2 != null) {
                        a.this.a(J2);
                    }
                } else if ((parentFragment2 instanceof com.zte.iptvclient.android.mobile.e0.e.i) && (J = ((com.zte.iptvclient.android.mobile.e0.e.i) parentFragment2).J()) != null) {
                    a.this.a(J);
                }
                Intent intent2 = new Intent(((com.zte.fragmentlib.b) a.this).h, (Class<?>) MultiPlayActivity.class);
                if (((com.zte.fragmentlib.b) a.this).h.getRequestedOrientation() == 0) {
                    intent2.putExtra("IsLandScape", true);
                }
                a.this.startActivity(intent2);
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.d(1));
                a.this.K();
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(a.this.R);
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.i(arrayList2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class f implements AdapterView.OnItemClickListener {
        f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.this.R.remove(a.this.P.getItem(i));
            a.this.P.notifyDataSetChanged();
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.y.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class g implements SDKSearchMgr.OnSearchHotListReturnListener {
        g() {
        }

        @Override // com.video.androidsdk.service.search.SDKSearchMgr.OnSearchHotListReturnListener
        public void onSearchHotListReturn(String str, String str2, String str3) {
            LogEx.d("SearchFragmentNew", "returncode : " + str + ", errormsg : " + str2 + ", data : " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("itemlist");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        a.this.z.add(jSONArray.get(i).toString());
                    }
                } catch (Exception e) {
                    LogEx.e("SearchFragmentNew", e.getMessage());
                }
            }
            if (a.this.b0 != null) {
                a.this.b0.notifyDataSetChanged();
            }
            a.this.a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class i {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7513a;

        static {
            int[] iArr = new int[u.values().length];
            f7513a = iArr;
            try {
                iArr[u.VOD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7513a[u.TVOD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7513a[u.LIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogEx.d("SearchFragmentNew", "mListPlayBundle=" + a.this.R.size());
            a.this.P = new com.zte.iptvclient.android.common.player.i.a(((com.zte.fragmentlib.b) a.this).h, a.this.R, a.this.N ? 1 : 0);
            a.this.Q.setAdapter((ListAdapter) a.this.P);
            if (a.this.P != null) {
                a.this.P.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class k extends net.lucode.hackware.magicindicator.e.c.b.a {

        /* compiled from: SearchFragmentNew.java */
        /* renamed from: com.zte.iptvclient.android.mobile.v.b.a$k$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0370a implements a.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ TextView f7516a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f7517b;

            C0370a(TextView textView, int i) {
                this.f7516a = textView;
                this.f7517b = i;
            }

            @Override // net.lucode.hackware.magicindicator.e.c.e.a.b
            public void a(int i, int i2) {
                this.f7516a.setTextColor(c.a.a.a.d.b.d().b(R.color.search_text_deselected));
                ((com.zte.fragmentlib.b) a.this).h.a(this.f7516a, "textColor", R.color.search_text_deselected);
                a.this.p.clearFocus();
            }

            @Override // net.lucode.hackware.magicindicator.e.c.e.a.b
            public void a(int i, int i2, float f, boolean z) {
            }

            @Override // net.lucode.hackware.magicindicator.e.c.e.a.b
            public void b(int i, int i2) {
                this.f7516a.setTextColor(c.a.a.a.d.b.d().b(R.color.search_column_text_selected));
                ((com.zte.fragmentlib.b) a.this).h.a(this.f7516a, "textColor", R.color.search_column_text_selected);
                a.this.p.clearFocus();
                a.this.i0 = this.f7517b;
                if (this.f7517b != a.this.n0) {
                    if (this.f7517b != a.this.o0) {
                        if (this.f7517b == a.this.p0) {
                            a.this.a(u.LIVE);
                        }
                    } else {
                        a.this.a(u.TVOD);
                    }
                } else {
                    a.this.a(u.VOD);
                }
                a.this.h0.a(this.f7517b, false);
            }

            @Override // net.lucode.hackware.magicindicator.e.c.e.a.b
            public void b(int i, int i2, float f, boolean z) {
            }
        }

        /* compiled from: SearchFragmentNew.java */
        /* loaded from: classes2.dex */
        class b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f7519a;

            b(int i) {
                this.f7519a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f7519a < a.this.g0.size()) {
                    a.this.p.clearFocus();
                    a.this.i0 = this.f7519a;
                    if (this.f7519a != a.this.n0) {
                        if (this.f7519a != a.this.o0) {
                            if (this.f7519a == a.this.p0) {
                                a.this.a(u.LIVE);
                            }
                        } else {
                            a.this.a(u.TVOD);
                        }
                    } else {
                        a.this.a(u.VOD);
                    }
                    a.this.h0.a(this.f7519a, false);
                }
            }
        }

        k() {
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public int a() {
            if (a.this.g0 == null) {
                return 0;
            }
            return a.this.g0.size();
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public net.lucode.hackware.magicindicator.e.c.b.d a(Context context, int i) {
            if (i >= a.this.g0.size()) {
                return null;
            }
            net.lucode.hackware.magicindicator.e.c.e.a aVar = new net.lucode.hackware.magicindicator.e.c.e.a(context);
            aVar.a(R.layout.simple_pager_title_layout);
            TextView textView = (TextView) aVar.findViewById(R.id.txt_simple_title);
            View findViewById = aVar.findViewById(R.id.view);
            textView.setText((CharSequence) a.this.g0.get(i));
            if (!BaseApp.f()) {
                textView.setTextSize(12.0f);
            }
            if (com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_tag_tvchannels).equals(a.this.g0.get(i))) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
            aVar.a(new C0370a(textView, i));
            aVar.setOnClickListener(new b(i));
            return aVar;
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public net.lucode.hackware.magicindicator.e.c.b.c a(Context context) {
            net.lucode.hackware.magicindicator.e.c.c.a aVar = new net.lucode.hackware.magicindicator.e.c.c.a(context);
            if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
                aVar.a(Integer.valueOf(((com.zte.fragmentlib.b) a.this).h.getResources().getColor(R.color.line_pagerindicator_dark)));
            } else {
                aVar.a(Integer.valueOf(((com.zte.fragmentlib.b) a.this).h.getResources().getColor(R.color.search_column_text_selected)));
            }
            aVar.a(3.0f);
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class l implements AdapterView.OnItemClickListener {
        l() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.c0 == null || i >= a.this.c0.getCount() || a.this.Y.get(i) == null) {
                return;
            }
            String a2 = ((com.zte.iptvclient.android.mobile.search.bean.d) a.this.Y.get(i)).a();
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            a.this.a(a2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class m implements AdapterView.OnItemClickListener {
        m() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == a.this.v.size()) {
                return;
            }
            String str = (String) a.this.v.get(i);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.this.a(str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class n implements AdapterView.OnItemClickListener {
        n() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == a.this.z.size()) {
                return;
            }
            String str = (String) a.this.z.get(i);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.this.a(str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class o implements View.OnClickListener {

        /* compiled from: SearchFragmentNew.java */
        /* renamed from: com.zte.iptvclient.android.mobile.v.b.a$o$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0371a implements Runnable {
            RunnableC0371a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.q0 != null) {
                    a.this.q0.b();
                }
                if (a.this.Z) {
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.d(2));
                }
                a.this.K();
            }
        }

        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Window window;
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            a.this.A();
            if (((com.zte.fragmentlib.b) a.this).h != null && (window = ((com.zte.fragmentlib.b) a.this).h.getWindow()) != null) {
                window.setSoftInputMode(32);
            }
            if (!(((com.zte.fragmentlib.b) a.this).h instanceof MultiPlayActivity)) {
                a.this.d0.postDelayed(new RunnableC0371a(), 30L);
                return;
            }
            a.this.getFragmentManager().F();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a.this.R);
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.i(arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.J = false;
            a.this.p.setText("");
            a.this.e0 = true;
            a.this.Y();
            a.this.p.requestFocus();
            a aVar = a.this;
            aVar.c(aVar.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.P()) {
                return;
            }
            a.this.r0 = true;
            if (a.this.p.getText() == null || TextUtils.isEmpty(a.this.p.getText().toString())) {
                if (TextUtils.isEmpty(a.this.k0)) {
                    return;
                }
                a aVar = a.this;
                aVar.a(aVar.k0, false);
                return;
            }
            a aVar2 = a.this;
            aVar2.a(aVar2.p.getText().toString(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class r implements TextWatcher {
        r() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(a.this.p.getText().toString())) {
                a.this.Y();
                return;
            }
            a.this.J = false;
            a.this.e0 = true;
            a.this.Y();
            a.this.p.requestFocus();
            a aVar = a.this;
            aVar.c(aVar.p);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes.dex */
    public interface s {
        void b();
    }

    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public class t extends androidx.fragment.app.n {
        ArrayList<Fragment> h;

        public t(a aVar, FragmentManager fragmentManager, ArrayList<Fragment> arrayList) {
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
    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    public enum u {
        VOD,
        TVOD,
        LIVE
    }

    private void X() {
        this.B.setVisibility(8);
        this.u.setVisibility(8);
        this.E.setVisibility(0);
        this.r.setVisibility(0);
        this.h0.a(this.i0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        com.zte.iptvclient.android.mobile.v.a.a aVar = this.c0;
        if (aVar != null) {
            aVar.a(this.p.getText().toString());
        }
        if (!TextUtils.isEmpty(this.p.getText().toString())) {
            this.r.setVisibility(0);
            Z();
        } else {
            this.u.setVisibility(8);
            this.r.setVisibility(8);
            this.B.setVisibility(0);
        }
        if (this.e0) {
            Q();
            this.e0 = false;
        }
    }

    private void Z() {
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        this.D.setVisibility(0);
        if (this.z.size() == 0) {
            this.t.setVisibility(8);
        } else {
            this.t.setVisibility(0);
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Window window;
        super.onActivityCreated(bundle);
        e(this.d0);
        N();
        V();
        O();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(48);
        }
        this.p.requestFocus();
        c(this.p);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.k0 = arguments.getString("InitCondition");
            this.M = arguments.getBoolean("MulitScreenEdit", false);
            this.N = arguments.getBoolean("DarkTheme", false);
            this.Z = arguments.getBoolean("IsFullScreen", false);
        }
        this.s0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.search_new, (ViewGroup) null);
        this.d0 = inflate;
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        this.v.clear();
        this.x = "";
        this.y.D("");
        com.zte.iptvclient.android.mobile.v.a.c cVar = this.w;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
            this.e0 = false;
        }
        J();
    }

    private void M() {
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
        J();
        LogEx.d("getmSearchHistoryList", this.v.toString());
        com.zte.iptvclient.android.mobile.v.a.c cVar = this.w;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    private void N() {
        String g2 = com.zte.iptvclient.android.common.k.o.j().g();
        if (!TextUtils.isEmpty(g2)) {
            this.j0 = true;
        }
        LogEx.d("SearchFragmentNew", "strSearchServer is exit=" + g2);
        this.y = new com.zte.iptvclient.android.common.j.h(this.h);
        this.z = new ArrayList<>();
        com.zte.iptvclient.android.mobile.v.a.b bVar = new com.zte.iptvclient.android.mobile.v.a.b(this.h, this.z);
        this.b0 = bVar;
        this.t.setAdapter((ListAdapter) bVar);
        this.Y = new ArrayList<>();
        com.zte.iptvclient.android.mobile.v.a.a aVar = new com.zte.iptvclient.android.mobile.v.a.a(this.h, this.Y);
        this.c0 = aVar;
        aVar.a(this.N);
        this.u.setAdapter((ListAdapter) this.c0);
        this.v = new ArrayList<>();
        com.zte.iptvclient.android.mobile.v.a.c cVar = new com.zte.iptvclient.android.mobile.v.a.c(this.h, this.v);
        this.w = cVar;
        cVar.b(this.N);
        this.s.setAdapter((ListAdapter) this.w);
        this.T = new com.zte.iptvclient.android.mobile.v.b.d();
        this.U = new com.zte.iptvclient.android.mobile.v.b.c();
        this.V = new com.zte.iptvclient.android.mobile.v.b.b();
        this.g0 = new ArrayList<>();
        ArrayList<Fragment> arrayList = this.f0;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.f0 = new ArrayList<>();
        }
        if (this.j0) {
            if (TextUtils.equals("1", ConfigMgr.readPropertie("IsSupportHideSearchVOD"))) {
                this.o0 = 0;
                this.p0 = 1;
                this.f0.add(this.U);
                this.g0.add(this.o0, com.zte.iptvclient.android.common.i.a.a.a(R.string.search_btn_right));
                this.f0.add(this.V);
                this.g0.add(this.p0, com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_tag_tvchannels));
                this.h0.e(this.f0.size());
            } else {
                this.n0 = 0;
                this.o0 = 1;
                this.p0 = 2;
                this.g0.add(0, com.zte.iptvclient.android.common.i.a.a.a(R.string.search_and_favorite_list_vod));
                this.f0.add(this.T);
                this.f0.add(this.U);
                this.g0.add(this.o0, com.zte.iptvclient.android.common.i.a.a.a(R.string.search_btn_right));
                this.f0.add(this.V);
                this.g0.add(this.p0, com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_tag_tvchannels));
                this.h0.e(this.f0.size());
            }
            R();
        } else {
            this.g0.add(com.zte.iptvclient.android.common.i.a.a.a(R.string.search_and_favorite_list_vod));
            this.g0.add(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_tag_tvchannels));
            this.n0 = 0;
            this.p0 = 1;
            this.D.setVisibility(8);
        }
        M();
        new HashSet();
    }

    private void O() {
        if (this.g0.size() == 0) {
            return;
        }
        if (this.M) {
            if (this.f0.size() > 0) {
                this.f0.clear();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("MulitScreenEdit", true);
            bundle.putBoolean("SmallView", this.N);
            this.T.setArguments(bundle);
            this.T.a(this.u0);
            this.f0.add(this.T);
            this.O.setVisibility(0);
            this.R = com.zte.iptvclient.android.common.player.multiplay.a.c().a();
            this.O.post(new j());
            this.l0.setVisibility(8);
        } else {
            this.l0.setVisibility(0);
            this.O.setVisibility(8);
        }
        if (this.W == null) {
            this.W = new t(this, getChildFragmentManager(), this.f0);
        }
        this.h0.a(this.W);
        this.W.b();
        if (this.m0 == null) {
            net.lucode.hackware.magicindicator.e.c.a aVar = new net.lucode.hackware.magicindicator.e.c.a(this.h);
            this.m0 = aVar;
            aVar.a(0.35f);
            this.m0.b(true);
            this.m0.a(true);
            this.l0.a(this.m0);
            net.lucode.hackware.magicindicator.c.a(this.l0, this.h0);
        }
        this.m0.a(new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.X <= 500) {
            LogEx.w("UseeTv", "Operate limit,less than 500(ms)!");
            return true;
        }
        this.X = currentTimeMillis;
        return false;
    }

    private void Q() {
        this.E.setVisibility(8);
        this.u.setVisibility(8);
        LogEx.d("SearchFragmentNew", "mSearchKeyWordHintLv.setVisibility(View.GONE);");
        this.B.setVisibility(0);
        M();
    }

    private void R() {
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
        if (!TextUtils.isEmpty(g2)) {
            sDKSearchMgr.setServerDomain(g2);
        }
        sDKSearchMgr.setServerDomain(g2);
        sDKSearchMgr.searchHotList(hashMap, new g());
    }

    private void S() {
        this.h0.a(this.p0, false);
    }

    private void T() {
        this.h0.a(this.o0, false);
    }

    private void U() {
        this.h0.a(this.n0, false);
    }

    private void V() {
        this.u.setOnItemClickListener(new l());
        this.s.setOnItemClickListener(new m());
        this.t.setOnItemClickListener(new n());
        this.q.setOnClickListener(new o());
        this.r.setOnClickListener(new p());
        this.F.setOnClickListener(new q());
        this.p.addTextChangedListener(new r());
        this.p.setOnEditorActionListener(new C0369a());
        this.p.setOnFocusChangeListener(new b());
        this.L.setOnClickListener(new c());
        this.G.setOnClickListener(new d());
        this.S.setOnClickListener(new e());
        this.Q.setOnItemClickListener(new f());
        this.B.setOnTouchListener(this);
        this.C.setOnTouchListener(this);
        this.D.setOnTouchListener(this);
        this.E.setOnTouchListener(this);
    }

    private void W() {
        this.J = false;
        A();
        X();
        EditText editText = this.p;
        if (editText != null && !TextUtils.isEmpty(editText.getText().toString())) {
            s(this.p.getText().toString().trim());
        } else {
            if (TextUtils.isEmpty(this.k0)) {
                return;
            }
            s(this.k0);
        }
    }

    private void e(View view) {
        if (this.N) {
            View view2 = this.d0;
            if (view2 != null) {
                view2.setBackgroundResource(R.color.search_view_main_theme_color_small_trance);
            }
            this.u.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_view_main_theme_color_small));
            this.h.a(this.u, "background", R.color.search_view_main_theme_color_small);
            this.u.setDividerHeight(1);
            View findViewById = view.findViewById(R.id.buttom_clear_line);
            findViewById.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_dark));
            this.h.a(findViewById, "background", R.color.multiplayer_theme_dividerline_dark);
            View findViewById2 = view.findViewById(R.id.header_clear_line);
            findViewById2.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_dark));
            this.h.a(findViewById2, "background", R.color.multiplayer_theme_dividerline_dark);
            View findViewById3 = view.findViewById(R.id.hot_buttom_line);
            findViewById3.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_dark));
            this.h.a(findViewById3, "background", R.color.multiplayer_theme_dividerline_dark);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_search_edit_layout);
            this.h.a(linearLayout, "src", R.drawable.search_edit_bg_small);
            linearLayout.setBackground(c.a.a.a.d.b.d().d(R.drawable.search_edit_bg_small));
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.ll_search_history_text);
            relativeLayout.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_history_bg_color_small));
            this.h.a(relativeLayout, "background", R.color.search_history_bg_color_small);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_search_mosted_text);
            linearLayout2.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_history_bg_color_small));
            this.h.a(linearLayout2, "background", R.color.search_history_bg_color_small);
            TextView textView = (TextView) view.findViewById(R.id.search_history_txt);
            textView.setTextColor(c.a.a.a.d.b.d().b(R.color.search_small_color));
            this.h.a(textView, "textColor", R.color.search_small_color);
            if (TextUtils.equals("0", ConfigMgr.readPropertie("isShow"))) {
                TextView textView2 = (TextView) view.findViewById(R.id.search_history_clear_all);
                textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.clear_all_history));
                textView2.setTextColor(c.a.a.a.d.b.d().b(R.color.search_small_color));
                this.h.a(textView2, "textColor", R.color.search_small_color);
                this.G.setTextColor(c.a.a.a.d.b.d().b(R.color.search_small_color));
                this.h.a(this.G, "textColor", R.color.search_small_color);
            }
            TextView textView3 = (TextView) view.findViewById(R.id.most_searched_des_txt);
            textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.most_searched));
            textView3.setTextColor(c.a.a.a.d.b.d().b(R.color.search_small_color));
            this.h.a(textView3, "textColor", R.color.search_small_color);
            this.q.setTextColor(c.a.a.a.d.b.d().b(R.color.white));
            this.h.a(this.q, "textColor", R.color.white);
            this.p.setTextColor(c.a.a.a.d.b.d().b(R.color.search_small_color));
            this.h.a(this.p, "textColor", R.color.search_small_color);
            View findViewById4 = view.findViewById(R.id.multiscreen_program_edit_view_top);
            findViewById4.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_dark));
            this.h.a(findViewById4, "background", R.color.multiplayer_theme_dividerline_dark);
            view.findViewById(R.id.multiscreen_program_edit_view_buttom).setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_dark));
            this.h.a(this.p, "background", R.color.multiplayer_theme_dividerline_dark);
            this.O.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_bg_dark));
            this.h.a(this.O, "background", R.color.multiplayer_theme_bg_dark);
            return;
        }
        this.A.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_view_main_theme_color));
        this.h.a(this.A, "background", R.color.search_view_main_theme_color);
        this.u.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.search_view_main_theme_color));
        this.h.a(this.u, "background", R.color.search_view_main_theme_color);
    }

    private void s(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ((TextUtils.isEmpty(str) || str.indexOf("zxiptv") == -1) && !TextUtils.isEmpty(str)) {
            int i2 = 0;
            if (this.v.size() < 10) {
                if (t(str)) {
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
            } else if (t(str)) {
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
    }

    private boolean t(String str) {
        ArrayList<String> arrayList = this.v;
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<String> it2 = this.v.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (next.length() == str.length()) {
                    int length = next.length();
                    for (int i2 = 0; i2 < length && next.charAt(i2) == str.charAt(i2); i2++) {
                        if (i2 == length - 1) {
                            LogEx.d("SearchFragmentNew", "contains :" + str);
                            return false;
                        }
                    }
                }
            }
        }
        LogEx.d("SearchFragmentNew", "not contains :" + str);
        return true;
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        if (this.Z) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.d(2));
        }
        s sVar = this.q0;
        if (sVar != null) {
            sVar.b();
        }
        K();
        return true;
    }

    public boolean I() {
        return getResources().getConfiguration().orientation == 2;
    }

    protected void J() {
        LogEx.d("SearchFragmentNew", "mSearchHistoryList " + this.v.size());
        if (this.v.size() <= 0) {
            if (BaseApp.a(this.h)) {
                this.C.setVisibility(0);
                this.G.setVisibility(8);
                b(true);
                return;
            } else {
                this.C.setVisibility(8);
                this.G.setVisibility(8);
                return;
            }
        }
        if (this.v.size() > 0 && this.v.size() <= 8) {
            this.C.setVisibility(0);
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            this.G.setVisibility(0);
            b(false);
            return;
        }
        this.C.setVisibility(0);
        this.K.setVisibility(0);
        if (BaseApp.a(this.h)) {
            this.L.setVisibility(8);
            b(false);
        } else {
            this.L.setVisibility(0);
        }
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

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (this.N) {
            textView.setVisibility(8);
        } else {
            if (a2 <= 0) {
                a2 = 60;
            }
            textView.setHeight(a2);
        }
        this.A = (RelativeLayout) view.findViewById(R.id.search_layout);
        this.p = (EditText) view.findViewById(R.id.edtSearch);
        if (!TextUtils.isEmpty(this.k0)) {
            this.p.setHint(this.k0);
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
        this.l0 = (MagicIndicator) view.findViewById(R.id.magic_indicator);
        this.h0 = (CustomViewPage) view.findViewById(R.id.viewpager);
        this.r = (ImageView) view.findViewById(R.id.search_clear_iv);
        this.O = (LinearLayout) view.findViewById(R.id.ll_multiscreen_program_edit_view);
        this.Q = (GridView) view.findViewById(R.id.gv_program_edit);
        TextView textView3 = (TextView) view.findViewById(R.id.txt_ok);
        this.S = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multiscreen_program_confirm));
        TextView textView4 = (TextView) view.findViewById(R.id.search_history_txt);
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.search_history));
        com.zte.iptvclient.common.uiframe.f.a(textView4);
        ((TextView) view.findViewById(R.id.most_searched_des_txt)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.most_searched));
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
        com.zte.iptvclient.common.uiframe.f.a(this.l0);
        com.zte.iptvclient.common.uiframe.f.a(this.h0);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.O);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_program_edit_main));
        com.zte.iptvclient.common.uiframe.f.a(this.Q);
        com.zte.iptvclient.common.uiframe.f.a(this.S);
    }

    private void b(boolean z) {
        if (BaseApp.a(this.h)) {
            if (z) {
                this.C.findViewById(R.id.tv_no_search_records_for_pad).setVisibility(0);
            } else {
                this.C.findViewById(R.id.tv_no_search_records_for_pad).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.zte.iptvclient.android.common.player.k.c cVar) {
        for (int i2 = 0; i2 < this.R.size(); i2++) {
            if (this.R.get(i2).d().equals(cVar.L1())) {
                this.R.get(i2).b(String.valueOf(cVar.O1() / 1000));
                return;
            }
        }
    }

    /* compiled from: SearchFragmentNew.java */
    /* loaded from: classes2.dex */
    class h implements d.g {
        h() {
        }

        @Override // com.zte.iptvclient.android.mobile.v.b.d.g
        public void a(com.zte.iptvclient.android.common.javabean.models.f fVar) {
            if (fVar != null) {
                com.zte.iptvclient.android.common.javabean.f a2 = com.zte.iptvclient.android.common.player.multiplay.a.a(fVar);
                LogEx.d("SearchFragmentNew", "AddVodToMultiScreenEvent!procode" + a2.d() + ";name" + a2.e());
                StringBuilder sb = new StringBuilder();
                sb.append("isPlayBundleListIncludeVOD");
                sb.append(com.zte.iptvclient.android.common.player.multiplay.a.c().a().size());
                LogEx.d("SearchFragmentNew", sb.toString());
                if (!com.zte.iptvclient.android.common.player.multiplay.a.c().a(a2) && com.zte.iptvclient.android.common.player.multiplay.a.c().b()) {
                    a.this.R.add(a2);
                } else {
                    if (!com.zte.iptvclient.android.common.player.multiplay.a.c().a(a2)) {
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.multiscreen_program_too_more));
                        return;
                    }
                    int i = 0;
                    while (true) {
                        if (i >= a.this.R.size()) {
                            break;
                        }
                        if (TextUtils.equals(a2.d(), ((com.zte.iptvclient.android.common.javabean.f) a.this.R.get(i)).d())) {
                            a.this.R.remove(i);
                            break;
                        }
                        i++;
                    }
                }
                if (a.this.P != null) {
                    a.this.P.notifyDataSetChanged();
                }
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.y.b());
            }
        }

        @Override // com.zte.iptvclient.android.mobile.v.b.d.g
        public void b() {
            if (a.this.P != null) {
                a.this.R = com.zte.iptvclient.android.common.player.multiplay.a.c().a();
                a.this.P.notifyDataSetChanged();
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.y.b());
            }
        }

        @Override // com.zte.iptvclient.android.mobile.v.b.d.g
        public void a() {
            a.this.getFragmentManager().F();
            if (a.this.I()) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.a());
            } else {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.c(false));
            }
            Intent intent = new Intent(((com.zte.fragmentlib.b) a.this).h, (Class<?>) MultiPlayActivity.class);
            if (((com.zte.fragmentlib.b) a.this).h.getRequestedOrientation() == 0) {
                intent.putExtra("IsLandScape", true);
            }
            a.this.startActivity(intent);
            if (((com.zte.fragmentlib.b) a.this).h instanceof MultiPlayActivity) {
                ((com.zte.fragmentlib.b) a.this).h.finish();
            }
            a.this.K();
        }
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
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u uVar) {
        this.u.setVisibility(8);
        if (uVar != this.a0) {
            this.a0 = uVar;
            int i2 = i.f7513a[uVar.ordinal()];
            if (i2 == 1) {
                U();
            } else if (i2 == 2) {
                T();
            } else {
                if (i2 != 3) {
                    return;
                }
                S();
            }
        }
    }

    public void a(s sVar) {
        this.q0 = sVar;
    }

    public static String[] a(String[] strArr) {
        for (int i2 = 0; i2 < strArr.length / 2; i2++) {
            String str = strArr[i2];
            strArr[i2] = strArr[(strArr.length - 1) - i2];
            strArr[(strArr.length - 1) - i2] = str;
        }
        return strArr;
    }

    public static String d(int i2) {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_VALUE);
        if (propertiesInfo == null) {
            return "";
        }
        String[] split = propertiesInfo.split(",");
        a(split);
        String str = "";
        for (int i3 = 0; i3 < split.length; i3++) {
            if ((Integer.parseInt(split[i3]) & i2) == Integer.parseInt(split[i3])) {
                str = str + split[i3] + CapablityEnum.SPLIT_CODE;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String substring = str.substring(0, str.length() - 1);
        LogEx.d("SearchFragmentNew", "countposition=" + substring);
        return String.valueOf(substring);
    }
}
