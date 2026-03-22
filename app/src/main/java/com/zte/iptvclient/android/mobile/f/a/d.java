package com.zte.iptvclient.android.mobile.f.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.CustomTimePicker.a;
import com.zte.iptvclient.android.common.f.b.a;
import com.zte.iptvclient.android.common.javabean.models.Feature;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.sdk.enumclass.CapablityEnum;
import com.zte.servicesdk.util.PortalConst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;

/* compiled from: ChildModeFrament.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b {
    private int D;
    private int E;
    private int F;
    private String G;
    private String J;
    private String K;
    private String L;
    private String M;
    private Button N;
    private Button O;
    private com.zte.iptvclient.android.common.f.b.a Q;
    private Button p;
    private TextView q;
    private ListView r;
    private List<String> s;
    private List<l> t;
    private f u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String[] z = new String[0];
    private String[] A = new String[0];
    private String[] B = new String[0];
    private String[] C = new String[0];
    private SimpleDateFormat P = new SimpleDateFormat("HH:mm", Locale.ENGLISH);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildModeFrament.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildModeFrament.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            d.this.A();
            d.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildModeFrament.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {

        /* compiled from: ChildModeFrament.java */
        /* loaded from: classes.dex */
        class a implements t.e {
            a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void b() {
                d.this.K();
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            d.this.A();
            if (TextUtils.equals(com.zte.iptvclient.common.uiframe.a.c("Is_ChildMode_Allow_Guest"), "1")) {
                d.this.L();
                return;
            }
            ArrayList<Feature> a2 = com.zte.iptvclient.android.common.j.c.e().a();
            if (a2 == null || a2.size() <= 0) {
                t.a(((com.zte.fragmentlib.b) d.this).h, com.zte.iptvclient.android.common.i.a.a.a(R.string.switch_childe_mode_to_order_tip), new a());
            } else {
                d.this.L();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildModeFrament.java */
    /* renamed from: com.zte.iptvclient.android.mobile.f.a.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0247d implements com.zte.iptvclient.android.mobile.order.helper.c {
        C0247d() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            LogEx.d("ChildModeFrament", "AuthManager payCallback returnCode=" + i + ",returnMsg=" + str);
            d.this.f(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildModeFrament.java */
    /* loaded from: classes.dex */
    public class e implements a.h {
        e(d dVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChildModeFrament.java */
    /* loaded from: classes.dex */
    public class f extends BaseAdapter {

        /* compiled from: ChildModeFrament.java */
        /* loaded from: classes.dex */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6176a;

            a(int i) {
                this.f6176a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                d.this.A();
                int i = d.this.D;
                int i2 = this.f6176a;
                if (i == i2 + 1) {
                    d.this.D = i2;
                } else {
                    d.this.D = i2 + 1;
                }
                d.this.u.notifyDataSetChanged();
            }
        }

        /* compiled from: ChildModeFrament.java */
        /* loaded from: classes.dex */
        class b implements View.OnClickListener {

            /* compiled from: ChildModeFrament.java */
            /* loaded from: classes.dex */
            class a implements a.e {
                a() {
                }

                @Override // com.zte.iptvclient.android.common.customview.CustomTimePicker.a.e
                public void a(String str) {
                    LogEx.d("ChildModeFrament", "onConfirmTimeBack=" + str);
                    try {
                        if (d.this.P.parse(str).before(TextUtils.isEmpty(d.this.J) ? d.this.P.parse("11:59") : d.this.P.parse(d.this.J))) {
                            d.this.G = str;
                        } else {
                            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.enter_time_error_tip));
                        }
                        f.this.notifyDataSetChanged();
                    } catch (Exception e) {
                        LogEx.e("ChildModeFrament", "parse date getXecption=" + e.getMessage());
                    }
                }
            }

            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                d.this.A();
                com.zte.iptvclient.android.common.customview.CustomTimePicker.a aVar = new com.zte.iptvclient.android.common.customview.CustomTimePicker.a(((com.zte.fragmentlib.b) d.this).h, 0, d.this.G);
                aVar.a(new a());
                aVar.a(d.this.r);
            }
        }

        /* compiled from: ChildModeFrament.java */
        /* loaded from: classes.dex */
        class c implements View.OnClickListener {

            /* compiled from: ChildModeFrament.java */
            /* loaded from: classes.dex */
            class a implements a.e {
                a() {
                }

                @Override // com.zte.iptvclient.android.common.customview.CustomTimePicker.a.e
                public void a(String str) {
                    LogEx.d("ChildModeFrament", "onConfirmTimeBack=" + str);
                    try {
                        if ((TextUtils.isEmpty(d.this.G) ? d.this.P.parse("00:00") : d.this.P.parse(d.this.G)).before(d.this.P.parse(str))) {
                            d.this.J = str;
                        } else {
                            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.enter_time_error_tip));
                        }
                        f.this.notifyDataSetChanged();
                    } catch (Exception e) {
                        LogEx.e("ChildModeFrament", "parse date getXecption=" + e.getMessage());
                    }
                }
            }

            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                d.this.A();
                com.zte.iptvclient.android.common.customview.CustomTimePicker.a aVar = new com.zte.iptvclient.android.common.customview.CustomTimePicker.a(((com.zte.fragmentlib.b) d.this).h, 0, d.this.J);
                aVar.a(new a());
                aVar.a(d.this.r);
            }
        }

        /* compiled from: ChildModeFrament.java */
        /* renamed from: com.zte.iptvclient.android.mobile.f.a.d$f$d, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class ViewOnClickListenerC0248d implements View.OnClickListener {

            /* compiled from: ChildModeFrament.java */
            /* renamed from: com.zte.iptvclient.android.mobile.f.a.d$f$d$a */
            /* loaded from: classes.dex */
            class a implements a.e {
                a() {
                }

                @Override // com.zte.iptvclient.android.common.customview.CustomTimePicker.a.e
                public void a(String str) {
                    LogEx.d("ChildModeFrament", "onConfirmTimeBack=" + str);
                    try {
                        if (d.this.P.parse(str).before(TextUtils.isEmpty(d.this.L) ? d.this.P.parse("23:59") : d.this.P.parse(d.this.L))) {
                            d.this.K = str;
                        } else {
                            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.enter_time_error_tip));
                        }
                        f.this.notifyDataSetChanged();
                    } catch (Exception e) {
                        LogEx.e("ChildModeFrament", "parse date getXecption=" + e.getMessage());
                    }
                }
            }

            ViewOnClickListenerC0248d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                d.this.A();
                com.zte.iptvclient.android.common.customview.CustomTimePicker.a aVar = new com.zte.iptvclient.android.common.customview.CustomTimePicker.a(((com.zte.fragmentlib.b) d.this).h, 1, d.this.K);
                aVar.a(new a());
                aVar.a(d.this.r);
            }
        }

        /* compiled from: ChildModeFrament.java */
        /* loaded from: classes.dex */
        class e implements View.OnClickListener {

            /* compiled from: ChildModeFrament.java */
            /* loaded from: classes.dex */
            class a implements a.e {
                a() {
                }

                @Override // com.zte.iptvclient.android.common.customview.CustomTimePicker.a.e
                public void a(String str) {
                    LogEx.d("ChildModeFrament", "onConfirmTimeBack=" + str);
                    try {
                        if ((TextUtils.isEmpty(d.this.K) ? d.this.P.parse("12:00") : d.this.P.parse(d.this.K)).before(d.this.P.parse(str))) {
                            d.this.L = str;
                        } else {
                            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.enter_time_error_tip));
                        }
                        f.this.notifyDataSetChanged();
                    } catch (Exception e) {
                        LogEx.e("ChildModeFrament", "parse date getXecption=" + e.getMessage());
                    }
                }
            }

            e() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                d.this.A();
                com.zte.iptvclient.android.common.customview.CustomTimePicker.a aVar = new com.zte.iptvclient.android.common.customview.CustomTimePicker.a(((com.zte.fragmentlib.b) d.this).h, 1, d.this.L);
                aVar.a(new a());
                aVar.a(d.this.r);
            }
        }

        /* compiled from: ChildModeFrament.java */
        /* renamed from: com.zte.iptvclient.android.mobile.f.a.d$f$f, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0249f implements TextWatcher {
            C0249f() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    LogEx.d("ChildModeFrament", "afterTextChanged=" + editable.toString().trim());
                    d.this.M = editable.toString().trim();
                } catch (Exception unused) {
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        }

        /* compiled from: ChildModeFrament.java */
        /* loaded from: classes.dex */
        class g implements TextView.OnEditorActionListener {
            g() {
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (keyEvent == null || keyEvent.getKeyCode() != 66) {
                    return false;
                }
                d.this.A();
                if (textView.getText() != null) {
                    d.this.M = textView.getText().toString().trim();
                }
                LogEx.d("ChildModeFrament", "currentInputPlayMaxDuration " + d.this.M);
                return true;
            }
        }

        private f() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (d.this.t == null) {
                return 0;
            }
            return d.this.t.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return ((l) d.this.t.get(i)).f6206d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            k kVar;
            j jVar;
            g gVar;
            g gVar2;
            g gVar3;
            h hVar;
            h hVar2;
            j jVar2;
            View inflate;
            j jVar3;
            g gVar4;
            l lVar = (l) d.this.t.get(i);
            i iVar = null;
            if (view == null) {
                int itemViewType = getItemViewType(i);
                if (itemViewType == 0) {
                    i iVar2 = new i();
                    inflate = LayoutInflater.from(((com.zte.fragmentlib.b) d.this).h).inflate(R.layout.rate_list_view_title, (ViewGroup) null);
                    iVar2.f6195a = (TextView) inflate.findViewById(R.id.title_name);
                    iVar2.f6196b = (LinearLayout) inflate.findViewById(R.id.ll_rate_title_container);
                    com.zte.iptvclient.common.uiframe.f.a(iVar2.f6196b);
                    com.zte.iptvclient.common.uiframe.f.a(iVar2.f6195a);
                    inflate.setTag(iVar2);
                    kVar = null;
                    jVar3 = null;
                    gVar4 = null;
                    iVar = iVar2;
                } else if (itemViewType == 1) {
                    g gVar5 = new g();
                    View inflate2 = LayoutInflater.from(((com.zte.fragmentlib.b) d.this).h).inflate(R.layout.item_level_at, (ViewGroup) null);
                    gVar5.f6188a = (ImageView) inflate2.findViewById(R.id.img_selected);
                    gVar5.f6189b = (ImageView) inflate2.findViewById(R.id.img_level);
                    gVar5.f6190c = (TextView) inflate2.findViewById(R.id.txt_level);
                    gVar5.f6191d = (TextView) inflate2.findViewById(R.id.txt_name);
                    gVar5.f = (LinearLayout) inflate2.findViewById(R.id.ll_layout);
                    gVar5.e = (ImageView) inflate2.findViewById(R.id.img_divider);
                    com.zte.iptvclient.common.uiframe.f.a(gVar5.f6188a);
                    com.zte.iptvclient.common.uiframe.f.a(gVar5.f6189b);
                    com.zte.iptvclient.common.uiframe.f.a(gVar5.f6190c);
                    com.zte.iptvclient.common.uiframe.f.a(gVar5.f6191d);
                    com.zte.iptvclient.common.uiframe.f.a(gVar5.f);
                    inflate2.setTag(gVar5);
                    kVar = null;
                    jVar2 = 0;
                    hVar2 = 0;
                    gVar2 = gVar5;
                    view = inflate2;
                } else if (itemViewType == 2) {
                    k kVar2 = new k();
                    inflate = LayoutInflater.from(((com.zte.fragmentlib.b) d.this).h).inflate(R.layout.select_child_mode_title_layout, (ViewGroup) null);
                    kVar2.f6201a = (TextView) inflate.findViewById(R.id.title_name);
                    kVar2.f6202b = (LinearLayout) inflate.findViewById(R.id.ll_child_title_container);
                    com.zte.iptvclient.common.uiframe.f.a(kVar2.f6202b);
                    com.zte.iptvclient.common.uiframe.f.a(kVar2.f6201a);
                    inflate.setTag(kVar2);
                    kVar = kVar2;
                    jVar3 = null;
                    gVar4 = null;
                } else if (itemViewType != 3) {
                    if (itemViewType == 4) {
                        h hVar3 = new h();
                        View inflate3 = LayoutInflater.from(((com.zte.fragmentlib.b) d.this).h).inflate(R.layout.select_child_mode_edit_time_layout, (ViewGroup) null);
                        hVar3.f6193b = (TextView) inflate3.findViewById(R.id.txt_name);
                        hVar3.f6192a = (EditText) inflate3.findViewById(R.id.below_edit);
                        hVar3.f6194c = (RelativeLayout) inflate3.findViewById(R.id.ll_layout);
                        com.zte.iptvclient.common.uiframe.f.a(hVar3.f6194c);
                        com.zte.iptvclient.common.uiframe.f.a(hVar3.f6193b);
                        com.zte.iptvclient.common.uiframe.f.a(hVar3.f6192a);
                        inflate3.setTag(hVar3);
                        hVar = hVar3;
                        kVar = null;
                        gVar3 = null;
                        view = inflate3;
                        gVar2 = gVar3;
                        jVar2 = gVar3;
                        hVar2 = hVar;
                    }
                    gVar2 = null;
                    kVar = null;
                    k kVar3 = kVar;
                    hVar2 = kVar3;
                    jVar2 = kVar3;
                } else {
                    j jVar4 = new j();
                    inflate = LayoutInflater.from(((com.zte.fragmentlib.b) d.this).h).inflate(R.layout.select_time_itme_for_child_mode, (ViewGroup) null);
                    jVar4.f6199c = (TextView) inflate.findViewById(R.id.txt_name);
                    jVar4.f6198b = (TextView) inflate.findViewById(R.id.txt_time_title);
                    jVar4.f6200d = (TextView) inflate.findViewById(R.id.txt_time);
                    jVar4.f6197a = (ImageView) inflate.findViewById(R.id.img_time_select_arrow);
                    jVar4.e = (RelativeLayout) inflate.findViewById(R.id.ll_layout);
                    com.zte.iptvclient.common.uiframe.f.a(jVar4.e);
                    com.zte.iptvclient.common.uiframe.f.a(jVar4.f6199c);
                    com.zte.iptvclient.common.uiframe.f.a(jVar4.f6198b);
                    com.zte.iptvclient.common.uiframe.f.a(jVar4.f6197a);
                    inflate.setTag(jVar4);
                    jVar3 = jVar4;
                    kVar = null;
                    gVar4 = null;
                }
                view = inflate;
                jVar = jVar3;
                gVar = gVar4;
                gVar2 = gVar;
                jVar2 = jVar;
                hVar2 = gVar;
            } else {
                int itemViewType2 = getItemViewType(i);
                if (itemViewType2 == 0) {
                    kVar = null;
                    jVar = null;
                    gVar = null;
                    iVar = (i) view.getTag();
                } else if (itemViewType2 == 1) {
                    gVar2 = (g) view.getTag();
                    kVar = null;
                    k kVar32 = kVar;
                    hVar2 = kVar32;
                    jVar2 = kVar32;
                } else if (itemViewType2 == 2) {
                    jVar = null;
                    gVar = null;
                    kVar = (k) view.getTag();
                } else if (itemViewType2 != 3) {
                    if (itemViewType2 == 4) {
                        kVar = null;
                        gVar3 = null;
                        hVar = (h) view.getTag();
                        gVar2 = gVar3;
                        jVar2 = gVar3;
                        hVar2 = hVar;
                    }
                    gVar2 = null;
                    kVar = null;
                    k kVar322 = kVar;
                    hVar2 = kVar322;
                    jVar2 = kVar322;
                } else {
                    kVar = null;
                    gVar = null;
                    jVar = (j) view.getTag();
                }
                gVar2 = gVar;
                jVar2 = jVar;
                hVar2 = gVar;
            }
            int itemViewType3 = getItemViewType(i);
            if (itemViewType3 != 0) {
                if (itemViewType3 != 1) {
                    if (itemViewType3 != 2) {
                        if (itemViewType3 != 3) {
                            if (itemViewType3 == 4 && hVar2 != 0) {
                                hVar2.f6193b.setText(lVar.f6205c);
                                LogEx.d("ChildModeFrament", "currentInputPlayMaxDuration " + d.this.M);
                                try {
                                    if (TextUtils.isEmpty(d.this.M)) {
                                        hVar2.f6192a.setText("");
                                    } else {
                                        hVar2.f6192a.setText(d.this.M);
                                        if (!TextUtils.isEmpty(hVar2.f6192a.getText())) {
                                            hVar2.f6192a.setSelection(hVar2.f6192a.getText().length());
                                        }
                                    }
                                } catch (Exception unused) {
                                }
                                hVar2.f6192a.setInputType(2);
                                hVar2.f6192a.addTextChangedListener(new C0249f());
                                hVar2.f6192a.setOnEditorActionListener(new g());
                            }
                        } else if (jVar2 != 0) {
                            jVar2.f6199c.setText(lVar.f6205c);
                            jVar2.f6198b.setText(lVar.e);
                            if (!TextUtils.equals(lVar.f6205c, com.zte.iptvclient.android.common.i.a.a.a(R.string.morning_txt)) || !TextUtils.equals(lVar.e, com.zte.iptvclient.android.common.i.a.a.a(R.string.start_time))) {
                                if (!TextUtils.equals(lVar.f6205c, com.zte.iptvclient.android.common.i.a.a.a(R.string.morning_txt)) || !TextUtils.equals(lVar.e, com.zte.iptvclient.android.common.i.a.a.a(R.string.end_time))) {
                                    if (!TextUtils.equals(lVar.f6205c, com.zte.iptvclient.android.common.i.a.a.a(R.string.evening_txt)) || !TextUtils.equals(lVar.e, com.zte.iptvclient.android.common.i.a.a.a(R.string.start_time))) {
                                        if (TextUtils.equals(lVar.f6205c, com.zte.iptvclient.android.common.i.a.a.a(R.string.evening_txt)) && TextUtils.equals(lVar.e, com.zte.iptvclient.android.common.i.a.a.a(R.string.end_time))) {
                                            jVar2.f6200d.setText(d.this.L);
                                            jVar2.e.setOnClickListener(new e());
                                        }
                                    } else {
                                        jVar2.f6200d.setText(d.this.K);
                                        jVar2.e.setOnClickListener(new ViewOnClickListenerC0248d());
                                    }
                                } else {
                                    jVar2.f6200d.setText(d.this.J);
                                    jVar2.e.setOnClickListener(new c());
                                }
                            } else {
                                jVar2.f6200d.setText(d.this.G);
                                jVar2.e.setOnClickListener(new b());
                            }
                        }
                    } else if (kVar != null) {
                        kVar.f6201a.setText(lVar.f6205c);
                    }
                } else if (gVar2 != null) {
                    gVar2.e.setVisibility(0);
                    gVar2.f6190c.setText(lVar.f6204b);
                    for (int i2 = 0; i2 < d.this.C.length; i2++) {
                        if (TextUtils.equals(d.this.z[i2], lVar.f6205c)) {
                            String str = com.zte.iptvclient.android.common.f.b.i.f() + "images/" + d.this.B[i2];
                            gVar2.f6189b.setVisibility(0);
                            com.bumptech.glide.i.b(SDKMgr.getApplicationContext()).a(str).a(gVar2.f6189b);
                            LogEx.d("ChildModeFrament", "imageUrl = " + str);
                        }
                    }
                    gVar2.f6191d.setVisibility(8);
                    if (d.this.D <= i) {
                        gVar2.f6188a.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.unselect));
                        if (((com.zte.fragmentlib.b) d.this).h != null) {
                            ((com.zte.fragmentlib.b) d.this).h.a(gVar2.f6188a, "background", R.drawable.unselect);
                        }
                    } else {
                        gVar2.f6188a.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.select));
                        gVar2.f6188a.setVisibility(0);
                        ((com.zte.fragmentlib.b) d.this).h.a(gVar2.f6188a, "src", R.drawable.select);
                        d.this.s.add(lVar.f6205c);
                    }
                    gVar2.f.setOnClickListener(new a(i));
                }
            } else if (iVar != null) {
                iVar.f6195a.setText(lVar.f6205c);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 5;
        }

        /* synthetic */ f(d dVar, a aVar) {
            this();
        }
    }

    /* compiled from: ChildModeFrament.java */
    /* loaded from: classes.dex */
    static class g {

        /* renamed from: a, reason: collision with root package name */
        private ImageView f6188a;

        /* renamed from: b, reason: collision with root package name */
        private ImageView f6189b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f6190c;

        /* renamed from: d, reason: collision with root package name */
        private TextView f6191d;
        private ImageView e;
        private LinearLayout f;

        g() {
        }
    }

    /* compiled from: ChildModeFrament.java */
    /* loaded from: classes.dex */
    static class h {

        /* renamed from: a, reason: collision with root package name */
        private EditText f6192a;

        /* renamed from: b, reason: collision with root package name */
        private TextView f6193b;

        /* renamed from: c, reason: collision with root package name */
        private RelativeLayout f6194c;

        h() {
        }
    }

    /* compiled from: ChildModeFrament.java */
    /* loaded from: classes.dex */
    static class i {

        /* renamed from: a, reason: collision with root package name */
        private TextView f6195a;

        /* renamed from: b, reason: collision with root package name */
        private LinearLayout f6196b;

        i() {
        }
    }

    /* compiled from: ChildModeFrament.java */
    /* loaded from: classes.dex */
    static class j {

        /* renamed from: a, reason: collision with root package name */
        private ImageView f6197a;

        /* renamed from: b, reason: collision with root package name */
        private TextView f6198b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f6199c;

        /* renamed from: d, reason: collision with root package name */
        private TextView f6200d;
        private RelativeLayout e;

        j() {
        }
    }

    /* compiled from: ChildModeFrament.java */
    /* loaded from: classes.dex */
    static class k {

        /* renamed from: a, reason: collision with root package name */
        private TextView f6201a;

        /* renamed from: b, reason: collision with root package name */
        private LinearLayout f6202b;

        k() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChildModeFrament.java */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        private int f6203a;

        /* renamed from: b, reason: collision with root package name */
        private String f6204b;

        /* renamed from: c, reason: collision with root package name */
        private String f6205c;

        /* renamed from: d, reason: collision with root package name */
        private int f6206d;
        private String e;

        /* synthetic */ l(int i, String str, String str2, int i2, a aVar) {
            this(i, str, str2, i2);
        }

        /* synthetic */ l(String str, String str2, int i, a aVar) {
            this(str, str2, i);
        }

        private l(int i, String str, String str2, int i2) {
            this.f6203a = i;
            this.f6204b = str;
            this.f6205c = str2;
            this.f6206d = i2;
        }

        private l(String str, String str2, int i) {
            this.f6203a = 0;
            this.f6204b = "";
            this.f6205c = str;
            this.f6206d = i;
            this.e = str2;
        }
    }

    private void M() {
        this.s = new ArrayList();
        this.w = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_VALUE);
        this.v = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_NAME);
        this.x = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_IMG);
        this.y = o.j().b(com.zte.iptvclient.android.common.i.a.a.a(R.string.limit_level_description));
        if (!TextUtils.isEmpty(this.w)) {
            this.A = this.w.split(",");
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = this.A;
            if (i3 >= strArr.length) {
                break;
            }
            this.E += Integer.parseInt(strArr[i3]);
            i3++;
        }
        if (!TextUtils.isEmpty(this.w)) {
            String substring = this.w.substring(0, this.w.lastIndexOf(","));
            this.w = substring;
            this.A = substring.split(",");
        }
        if (!TextUtils.isEmpty(this.v)) {
            String substring2 = this.v.substring(0, this.v.lastIndexOf(","));
            this.v = substring2;
            this.z = substring2.split(",");
        }
        if (!TextUtils.isEmpty(this.x)) {
            String substring3 = this.x.substring(0, this.x.lastIndexOf(","));
            this.x = substring3;
            this.B = substring3.split(",");
        }
        if (!TextUtils.isEmpty(this.y)) {
            String substring4 = this.y.substring(0, this.y.lastIndexOf(CapablityEnum.SPLIT_CODE));
            this.y = substring4;
            this.C = substring4.split("\\|");
        }
        this.F = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().i();
        LogEx.d("ChildModeFrament", " mIntOldLevelValue " + this.F + "; mIntTotalLevelValue " + this.E);
        ArrayList arrayList = new ArrayList();
        this.t = arrayList;
        String str = "";
        a aVar = null;
        arrayList.add(new l(com.zte.iptvclient.android.common.i.a.a.a(R.string.select_rate_txt), str, i2, aVar));
        String[] strArr2 = this.C;
        if (strArr2 != null && this.A.length == strArr2.length) {
            int i4 = 0;
            while (i2 < this.C.length) {
                if (i2 == 0) {
                    i4 = Integer.parseInt(this.A[i2]);
                } else {
                    i4 += Integer.parseInt(this.A[i2]);
                }
                this.t.add(new l(i4, this.C[i2], String.valueOf(this.z[i2]), 1, null));
                LogEx.d("ChildModeFrament", "levelValue = " + i4);
                i2++;
            }
        }
        this.t.add(new l(com.zte.iptvclient.android.common.i.a.a.a(R.string.watch_time_period_txt), str, 2, aVar));
        int i5 = 3;
        this.t.add(new l(com.zte.iptvclient.android.common.i.a.a.a(R.string.morning_txt), com.zte.iptvclient.android.common.i.a.a.a(R.string.start_time), i5, aVar));
        this.t.add(new l(com.zte.iptvclient.android.common.i.a.a.a(R.string.morning_txt), com.zte.iptvclient.android.common.i.a.a.a(R.string.end_time), i5, aVar));
        this.t.add(new l(com.zte.iptvclient.android.common.i.a.a.a(R.string.evening_txt), com.zte.iptvclient.android.common.i.a.a.a(R.string.start_time), i5, aVar));
        this.t.add(new l(com.zte.iptvclient.android.common.i.a.a.a(R.string.evening_txt), com.zte.iptvclient.android.common.i.a.a.a(R.string.end_time), i5, aVar));
        this.t.add(new l(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_duration_per_day), str, 4, aVar));
        int i6 = this.E;
        int i7 = this.F;
        if (i6 - i7 == 0) {
            this.D = 1;
        } else {
            this.D = d(i6 - i7) + 1;
        }
        this.G = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().c();
        this.J = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().b();
        this.K = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().h();
        this.L = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().g();
        String d2 = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().d();
        if (!TextUtils.isEmpty(d2)) {
            try {
                int parseInt = Integer.parseInt(d2);
                if (parseInt < 0) {
                    this.M = "";
                } else if (parseInt == 0) {
                    this.M = "0";
                } else {
                    this.M = String.valueOf(parseInt / 60);
                }
            } catch (Exception unused) {
            }
        }
        LogEx.d("ChildModeFrament", "init load mStrPlayAmStartTime " + this.G + "; mStrPlayAmEndTime" + this.J + "; mStrPlayPmStartTime " + this.K + "; mStrPlayPmEndTime" + this.L + "; mStrPlayEnableMaxDuration" + this.M + "; PlayedLeftMinutes" + com.zte.iptvclient.android.mobile.home.tab.helper.a.n().e());
        f fVar = new f(this, aVar);
        this.u = fVar;
        this.r.setAdapter((ListAdapter) fVar);
    }

    private void N() {
        String d2 = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().d();
        if (!TextUtils.isEmpty(d2)) {
            try {
                int parseInt = Integer.parseInt(d2);
                if (parseInt < 0) {
                    this.M = "";
                } else if (parseInt == 0) {
                    this.M = "0";
                } else {
                    this.M = String.valueOf(parseInt / 60);
                }
            } catch (Exception unused) {
            }
        }
        f fVar = this.u;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    private void O() {
        this.p.setOnClickListener(new a());
        this.N.setOnClickListener(new b());
        this.O.setOnClickListener(new c());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        M();
        O();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.child_mode_fragment_layout, viewGroup, false);
        d(inflate);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (TextUtils.isEmpty(this.G) && !TextUtils.isEmpty(this.J)) {
            this.G = "00:00";
        } else if (!TextUtils.isEmpty(this.G) && TextUtils.isEmpty(this.J)) {
            this.J = "11:59";
        } else if (!TextUtils.isEmpty(this.G) && !TextUtils.isEmpty(this.J)) {
            try {
                if (this.P.parse(this.G).after(this.P.parse(this.J))) {
                    this.G = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().c();
                    this.J = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().b();
                    if (this.u != null) {
                        this.u.notifyDataSetChanged();
                    }
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.enter_time_error_tip));
                    LogEx.e("ChildModeFrament", "current seted Time is Invalide!");
                    return;
                }
            } catch (Exception e2) {
                LogEx.e("ChildModeFrament", "parse time getexception " + e2.getMessage());
            }
        }
        if (TextUtils.isEmpty(this.K) && !TextUtils.isEmpty(this.L)) {
            this.K = "12:00";
        } else if (!TextUtils.isEmpty(this.K) && TextUtils.isEmpty(this.L)) {
            this.L = "23:59";
        } else if (!TextUtils.isEmpty(this.K) && !TextUtils.isEmpty(this.L)) {
            try {
                if (this.P.parse(this.K).after(this.P.parse(this.L))) {
                    this.K = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().h();
                    this.L = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().g();
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.enter_time_error_tip));
                    if (this.u != null) {
                        this.u.notifyDataSetChanged();
                    }
                    LogEx.e("ChildModeFrament", "current seted Time is Invalide!");
                    return;
                }
            } catch (Exception e3) {
                LogEx.e("ChildModeFrament", "parse time getexception " + e3.getMessage());
            }
        }
        try {
            if (!TextUtils.isEmpty(this.M)) {
                int parseInt = Integer.parseInt(this.M);
                LogEx.d("ChildModeFrament", "iCurrentMaxTime = " + parseInt);
                if (parseInt > 1440) {
                    N();
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.enter_time_error_tip));
                    return;
                }
                this.M = String.valueOf(parseInt);
            }
            com.zte.iptvclient.android.mobile.home.tab.helper.a.n().b(this.G);
            com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a(this.J);
            com.zte.iptvclient.android.mobile.home.tab.helper.a.n().f(this.K);
            com.zte.iptvclient.android.mobile.home.tab.helper.a.n().e(this.L);
            String e4 = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().e();
            LogEx.d("ChildModeFrament", "load strOldPlayedLeftTime " + e4);
            String d2 = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().d();
            LogEx.d("ChildModeFrament", "load strOldPlayMaxTime " + d2);
            try {
                if (!TextUtils.isEmpty(this.M)) {
                    int parseInt2 = Integer.parseInt(this.M) * 60;
                    if (!TextUtils.isEmpty(e4)) {
                        if (!TextUtils.isEmpty(d2)) {
                            int parseInt3 = (parseInt2 - Integer.parseInt(d2)) + Integer.parseInt(e4);
                            LogEx.d("ChildModeFrament", "Update setChildModePlayedLeftMinutes " + parseInt3);
                            com.zte.iptvclient.android.mobile.home.tab.helper.a.n().d(String.valueOf(parseInt3));
                        } else {
                            LogEx.d("ChildModeFrament", "Update setChildModePlayedLeftMinutes " + parseInt2);
                            com.zte.iptvclient.android.mobile.home.tab.helper.a.n().d(String.valueOf(parseInt2));
                        }
                    } else {
                        LogEx.d("ChildModeFrament", "Update setChildModePlayedLeftMinutes " + parseInt2);
                        com.zte.iptvclient.android.mobile.home.tab.helper.a.n().d(String.valueOf(parseInt2));
                    }
                    com.zte.iptvclient.android.mobile.home.tab.helper.a.n().c(String.valueOf(parseInt2));
                } else {
                    com.zte.iptvclient.android.mobile.home.tab.helper.a.n().d("0");
                    com.zte.iptvclient.android.mobile.home.tab.helper.a.n().c(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
                }
            } catch (Exception unused) {
            }
            e(I());
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.seted_success_tip));
            f fVar = this.u;
            if (fVar != null) {
                fVar.notifyDataSetChanged();
            }
            LogEx.d("ChildModeFrament", "Update mStrPlayAmStartTime " + this.G + "; mStrPlayAmEndTime" + this.J + "; mStrPlayPmStartTime " + this.K + "; mStrPlayPmEndTime" + this.L + "; mStrPlayEnableMaxDuration" + this.M);
        } catch (Exception unused2) {
            N();
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.enter_time_error_tip));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        com.zte.iptvclient.android.common.f.b.a aVar = new com.zte.iptvclient.android.common.f.b.a(this.h, new com.zte.iptvclient.android.common.javabean.b(), new C0247d(), new e(this));
        this.Q = aVar;
        aVar.a(this.O);
        this.Q.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a(true);
        D();
        Intent intent = new Intent(getActivity(), (Class<?>) MainActivity.class);
        intent.putExtra("ChildMode", true);
        getActivity().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i2) {
        if (i2 == 0) {
            com.zte.iptvclient.android.mobile.n.c.b.k().c();
            L();
        }
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (getActivity() instanceof MainActivity) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.z.a("parentcontral", true));
        } else if (getActivity() instanceof HostActivity) {
            getActivity().finish();
        }
        return true;
    }

    public int I() {
        List<l> list = this.t;
        if (list == null || this.D == 0 || list.size() == 1 || this.t.size() <= 0) {
            return 0;
        }
        return this.t.get(this.D - 1).f6203a;
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.p = button;
        button.setVisibility(0);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        this.q = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.chilld_mode_txt));
        this.r = (ListView) view.findViewById(R.id.lst_level);
        this.N = (Button) view.findViewById(R.id.btnconfirm);
        this.O = (Button) view.findViewById(R.id.btnSwitch);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.container_child_btn));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.child_confirm_btn_layout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.child_switch_btn_layout));
        com.zte.iptvclient.common.uiframe.f.a(this.N);
        com.zte.iptvclient.common.uiframe.f.a(this.O);
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (BaseApp.a(this.h)) {
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
        }
    }

    public void e(int i2) {
        int i3 = this.E - i2;
        LogEx.d("ChildModeFrament", "modifyLimitLevel " + i3);
        com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a(i3);
    }

    public int d(int i2) {
        int i3 = 0;
        if (this.A == null) {
            return 0;
        }
        int i4 = 0;
        while (true) {
            String[] strArr = this.A;
            if (i3 < strArr.length) {
                if ((Integer.parseInt(strArr[i3]) & i2) != 0) {
                    i4++;
                }
                i3++;
            } else {
                LogEx.d("ChildModeFrament", "countposition=" + i4);
                return i4;
            }
        }
    }
}
