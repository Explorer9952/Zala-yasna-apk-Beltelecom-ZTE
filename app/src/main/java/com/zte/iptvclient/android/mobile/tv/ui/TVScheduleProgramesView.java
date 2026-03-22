package com.zte.iptvclient.android.mobile.tv.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.e.x.o;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.a0.b.h;
import com.zte.iptvclient.android.mobile.tv.ui.c;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import com.zte.servicesdk.util.PortalConst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.e.c.b.d;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public class TVScheduleProgramesView extends LinearLayout {
    private int A;
    private String B;
    private String C;
    private String D;
    private boolean E;

    /* renamed from: a, reason: collision with root package name */
    private String f7275a;

    /* renamed from: b, reason: collision with root package name */
    private Context f7276b;

    /* renamed from: c, reason: collision with root package name */
    private SupportActivity f7277c;

    /* renamed from: d, reason: collision with root package name */
    private MagicIndicator f7278d;
    private ArrayList<String> e;
    private String f;
    private int g;
    private int h;
    private ArrayList<h> i;
    private ViewPager j;
    private com.zte.iptvclient.android.mobile.a0.a.c k;
    private net.lucode.hackware.magicindicator.e.c.a l;
    private net.lucode.hackware.magicindicator.e.c.b.a m;
    private Channel n;
    private ColumnBean o;
    private LinearLayout p;
    private LinearLayout q;
    private TextView r;
    private ImageView s;
    private LinearLayout t;
    private TextView u;
    private TextView v;
    private ImageView w;
    private RelativeLayout x;
    private ProgressBar y;
    private PrevueBean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends net.lucode.hackware.magicindicator.e.c.b.a {

        /* renamed from: com.zte.iptvclient.android.mobile.tv.ui.TVScheduleProgramesView$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0353a implements c.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ TextView f7280a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ TextView f7281b;

            C0353a(TextView textView, TextView textView2) {
                this.f7280a = textView;
                this.f7281b = textView2;
            }

            @Override // com.zte.iptvclient.android.mobile.tv.ui.c.b
            public void a(int i, int i2) {
                this.f7280a.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_date_selected));
                this.f7281b.setBackground(TVScheduleProgramesView.this.f7277c.getResources().getDrawable(R.drawable.weekly_circle_shape));
                this.f7281b.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_date_selected));
            }

            @Override // com.zte.iptvclient.android.mobile.tv.ui.c.b
            public void a(int i, int i2, float f, boolean z) {
            }

            @Override // com.zte.iptvclient.android.mobile.tv.ui.c.b
            public void b(int i, int i2) {
                if (TVScheduleProgramesView.this.h == i) {
                    return;
                }
                if (i == 0) {
                    i = TVScheduleProgramesView.this.g;
                }
                this.f7280a.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_date_selected_light));
                this.f7281b.setBackground(TVScheduleProgramesView.this.f7277c.getResources().getDrawable(R.drawable.weekly_circle_shape_dark));
                this.f7281b.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_date_selected_light));
                if (i < TVScheduleProgramesView.this.e.size()) {
                    TVScheduleProgramesView.this.g = i;
                    TVScheduleProgramesView tVScheduleProgramesView = TVScheduleProgramesView.this;
                    tVScheduleProgramesView.h = tVScheduleProgramesView.g;
                    TVScheduleProgramesView tVScheduleProgramesView2 = TVScheduleProgramesView.this;
                    tVScheduleProgramesView2.f = (String) tVScheduleProgramesView2.e.get(i);
                    if (TVScheduleProgramesView.this.i == null || TVScheduleProgramesView.this.i.size() <= 0) {
                        return;
                    }
                    ((h) TVScheduleProgramesView.this.i.get(i)).b(TVScheduleProgramesView.this.n);
                    TVScheduleProgramesView.this.j.d(i);
                    ((h) TVScheduleProgramesView.this.i.get(i)).a(TVScheduleProgramesView.this.o);
                    ((h) TVScheduleProgramesView.this.i.get(i)).f();
                }
            }

            @Override // com.zte.iptvclient.android.mobile.tv.ui.c.b
            public void b(int i, int i2, float f, boolean z) {
            }
        }

        /* loaded from: classes2.dex */
        class b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f7283a;

            b(int i) {
                this.f7283a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f7283a != TVScheduleProgramesView.this.g && this.f7283a < TVScheduleProgramesView.this.e.size()) {
                    TVScheduleProgramesView.this.g = this.f7283a;
                    TVScheduleProgramesView tVScheduleProgramesView = TVScheduleProgramesView.this;
                    tVScheduleProgramesView.f = (String) tVScheduleProgramesView.e.get(this.f7283a);
                    if (TVScheduleProgramesView.this.i == null || TVScheduleProgramesView.this.i.size() <= TVScheduleProgramesView.this.g) {
                        return;
                    }
                    TVScheduleProgramesView.this.j.d(this.f7283a);
                }
            }
        }

        a() {
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public int a() {
            if (TVScheduleProgramesView.this.e == null) {
                return 0;
            }
            return TVScheduleProgramesView.this.e.size();
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public d a(Context context, int i) {
            if (i >= TVScheduleProgramesView.this.e.size()) {
                return null;
            }
            c cVar = new c(TVScheduleProgramesView.this.f7276b);
            cVar.a(R.layout.weekly_title_item_dark);
            TextView textView = (TextView) cVar.findViewById(R.id.date_text);
            TextView textView2 = (TextView) cVar.findViewById(R.id.weekly_text);
            textView.setText(x.a(TVScheduleProgramesView.this.f7276b, (String) TVScheduleProgramesView.this.e.get(i), Locale.ENGLISH));
            textView2.setText(x.a(TVScheduleProgramesView.this.f7276b, (String) TVScheduleProgramesView.this.e.get(i)));
            f.a(cVar);
            f.a(textView);
            f.a(textView2);
            cVar.a(new C0353a(textView, textView2));
            cVar.setOnClickListener(new b(i));
            return cVar;
        }

        @Override // net.lucode.hackware.magicindicator.e.c.b.a
        public net.lucode.hackware.magicindicator.e.c.b.c a(Context context) {
            net.lucode.hackware.magicindicator.e.c.c.a aVar = new net.lucode.hackware.magicindicator.e.c.c.a(context);
            aVar.a(Integer.valueOf(TVScheduleProgramesView.this.f7277c.getResources().getColor(R.color.line_pagerindicator_light)));
            return aVar;
        }
    }

    public TVScheduleProgramesView(Context context, SupportActivity supportActivity) {
        super(context);
        this.f7275a = "TVScheduleProgramesView";
        this.g = 0;
        this.h = 0;
        this.f7276b = context;
        this.f7277c = supportActivity;
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        h();
        e();
        f();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(o oVar) {
        PrevueBean b2 = oVar.b();
        if (b2 != null) {
            LogEx.d(this.f7275a, "get SearchData columncode= selectedChnnelcode=" + b2.getChannelcode() + " date=" + b2.getBegintime());
            a(b2.getBegintime());
        }
    }

    private void d() {
        if (this.e == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f)) {
            try {
                this.f = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(s.b());
            } catch (Exception e) {
                LogEx.e(this.f7275a, e.getMessage());
            }
            LogEx.d(this.f7275a, "mStrCurrentDate=" + this.f);
        }
        int i = 0;
        while (true) {
            if (i >= this.e.size()) {
                break;
            }
            if (TextUtils.equals(this.f, this.e.get(i))) {
                this.g = i;
                LogEx.d(this.f7275a, "mstrCurrentDate=" + this.f + " selectedDateIndex=" + this.g);
                break;
            }
            i++;
        }
        if (this.g >= this.e.size()) {
            this.g = 0;
            LogEx.w(this.f7275a, "selectedDate=" + this.g);
        }
    }

    private void e() {
        ArrayList<h> arrayList = new ArrayList<>();
        this.i = arrayList;
        com.zte.iptvclient.android.mobile.a0.a.c cVar = new com.zte.iptvclient.android.mobile.a0.a.c(arrayList);
        this.k = cVar;
        this.j.a(cVar);
        net.lucode.hackware.magicindicator.e.c.a aVar = new net.lucode.hackware.magicindicator.e.c.a(this.f7276b);
        this.l = aVar;
        aVar.a(0.5f);
        this.l.c(true);
        this.l.b(true);
        a aVar2 = new a();
        this.m = aVar2;
        this.l.a(aVar2);
        this.f7278d.a(this.l);
        net.lucode.hackware.magicindicator.c.a(this.f7278d, this.j);
    }

    private void f() {
        int i;
        LogEx.d(this.f7275a, " initSchduleDays start!");
        ArrayList<String> arrayList = new ArrayList<>();
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_PREVIEW_DAYOFTV);
        String c3 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_AFTER_DAYOFTV);
        int i2 = 7;
        try {
            i = Integer.parseInt(c2);
        } catch (NumberFormatException unused) {
            i = 7;
        }
        if (i < 0) {
            i *= -1;
        }
        try {
            i2 = Integer.parseInt(c3);
        } catch (NumberFormatException unused2) {
        }
        if (i2 < 0) {
            i2 *= -1;
        }
        Date b2 = s.b();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        for (int i3 = -i; i3 <= i2; i3++) {
            try {
                arrayList.add(simpleDateFormat.format(TimeUtil.addOffset(b2, 5, i3)));
            } catch (Exception unused3) {
                LogEx.e(this.f7275a, "translate time Failed.......");
            }
        }
        LogEx.d(this.f7275a, "listDays=" + arrayList);
        ArrayList<String> arrayList2 = this.e;
        if (arrayList2 != null) {
            if (arrayList2.size() > 0 && arrayList.size() > 0 && !TextUtils.equals(arrayList.get(0), this.e.get(0))) {
                this.e = arrayList;
                this.i = null;
            }
        } else {
            this.e = arrayList;
        }
        LogEx.d(this.f7275a, "initSchduleDays finish!");
        d();
        g();
    }

    private void g() {
        LogEx.d(this.f7275a, " initScheduleProgramsViewPage start!");
        ArrayList<h> arrayList = this.i;
        if (arrayList == null) {
            this.i = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        for (int i = 0; i < this.e.size(); i++) {
            this.i.add(new h(this.f7277c, this.e.get(i), false, 0));
        }
        if (this.g < this.e.size()) {
            this.f = this.e.get(this.g);
        } else {
            this.f = this.e.get(0);
        }
        this.k.a(this.i);
        LogEx.d(this.f7275a, "mstrCurrentDate=" + this.f + ";mListDate=" + this.e.toString() + " selectedDate=" + this.g);
        if (this.l.c() != null) {
            this.l.c().b();
        }
        int size = this.i.size();
        int i2 = this.g;
        if (size > i2) {
            this.j.d(i2);
        }
        LogEx.d(this.f7275a, " initProgramListViewPage finish");
    }

    private void h() {
        View inflate = View.inflate(this.f7277c, R.layout.tv_scheduler_programes_layout, this);
        this.f7278d = (MagicIndicator) inflate.findViewById(R.id.hlv_date);
        this.j = (ViewPager) inflate.findViewById(R.id.program_view_vpager);
        this.t = (LinearLayout) inflate.findViewById(R.id.ll_now_playing);
        this.p = (LinearLayout) inflate.findViewById(R.id.ll_play_now);
        this.q = (LinearLayout) inflate.findViewById(R.id.ll_today_empty);
        this.r = (TextView) inflate.findViewById(R.id.txt_program_name);
        this.s = (ImageView) inflate.findViewById(R.id.img_empty_tv);
        this.u = (TextView) inflate.findViewById(R.id.txt_program_duration);
        this.w = (ImageView) inflate.findViewById(R.id.img_tv);
        this.v = (TextView) inflate.findViewById(R.id.txt_program_title);
        this.x = (RelativeLayout) inflate.findViewById(R.id.rl_progressbar);
        this.y = (ProgressBar) inflate.findViewById(R.id.pb_playing_light);
        f.a(this.f7278d);
        f.a(this.j);
        f.a(this.t);
        f.a(this.v);
        f.a(this.u);
        f.a(this.x);
        f.a(this.y);
        f.a(this.p);
        f.a(this.q);
        f.a(this.r);
        f.a(this.w);
        f.a(this.s);
        f.a(inflate.findViewById(R.id.cl_program_item));
        f.a(inflate.findViewById(R.id.ll_program_describ));
        f.a(inflate.findViewById(R.id.ll_showdetail));
        f.a(inflate.findViewById(R.id.rl_tv));
        f.a(inflate.findViewById(R.id.rl_empty_tv));
    }

    public void c() {
        ArrayList<h> arrayList = this.i;
        if (arrayList == null || this.j == null || arrayList.size() <= this.j.c()) {
            return;
        }
        this.i.get(this.j.c()).f();
    }

    public void b() {
        a(new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(s.b()));
    }

    public void a(ColumnBean columnBean, Channel channel) {
        this.n = channel;
        this.o = columnBean;
        int c2 = this.j.c();
        if (c2 < this.i.size()) {
            this.i.get(c2).b(this.n);
            this.i.get(c2).a(this.o);
        }
        for (int i = 0; i < this.i.size(); i++) {
            if (i != c2) {
                this.i.get(c2).a(this.n);
                this.i.get(c2).a(this.o);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.h hVar) {
        LogEx.d(this.f7275a, "PlayNextDateEvent");
        int i = this.g + 1;
        this.g = i;
        if (i < this.i.size()) {
            this.j.d(this.g);
            this.i.get(this.g).a(this.B, this.D, this.C, this.E, true);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.f fVar) {
        if (fVar.c() != null) {
            String posterimage = fVar.c().getPosterimage();
            if (fVar.b() != null) {
                this.p.setVisibility(0);
                this.q.setVisibility(8);
                this.z = fVar.b();
                int a2 = fVar.a();
                this.A = a2;
                this.y.setProgress(a2);
                PrevueBean prevueBean = this.z;
                if (prevueBean != null) {
                    this.u.setText(prevueBean.getDuration());
                    this.v.setText(this.z.getPrevuename());
                }
                if (TextUtils.isEmpty(posterimage)) {
                    return;
                }
                int indexOf = posterimage.indexOf("/image", 1);
                String str = i.g() + posterimage.substring(indexOf);
                SupportActivity supportActivity = this.f7277c;
                if (supportActivity != null && !supportActivity.isFinishing()) {
                    com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.a((FragmentActivity) this.f7277c).a(str);
                    a3.a(R.drawable.default_video_thumb);
                    a3.b(126, 94);
                    a3.a(this.w);
                    return;
                }
                this.w.setImageResource(R.drawable.default_video_thumb);
                return;
            }
            this.r.setText(fVar.c().getChannelname());
            if (!TextUtils.isEmpty(posterimage)) {
                int indexOf2 = posterimage.indexOf("/image", 1);
                String str2 = i.g() + posterimage.substring(indexOf2);
                SupportActivity supportActivity2 = this.f7277c;
                if (supportActivity2 != null && !supportActivity2.isFinishing()) {
                    com.bumptech.glide.d<String> a4 = com.bumptech.glide.i.a((FragmentActivity) this.f7277c).a(str2);
                    a4.a(R.drawable.default_video_thumb);
                    a4.b(126, 94);
                    a4.a(this.s);
                } else {
                    this.s.setImageResource(R.drawable.default_video_thumb);
                }
            }
            this.p.setVisibility(8);
            this.q.setVisibility(0);
        }
    }

    public TVScheduleProgramesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7275a = "TVScheduleProgramesView";
        this.g = 0;
        this.h = 0;
    }

    public void a(String str) {
        try {
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).parse(str));
            for (int i = 0; i < this.e.size(); i++) {
                if (TextUtils.equals(this.e.get(i), format)) {
                    this.g = i;
                    this.f = this.e.get(i);
                    this.j.d(this.g);
                    LogEx.d(this.f7275a, "Switch mStrCurrentDate=" + this.f + " selectedDateIndex=" + this.g);
                    return;
                }
            }
        } catch (Exception e) {
            LogEx.e(this.f7275a, e.getMessage());
        }
    }

    public TVScheduleProgramesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7275a = "TVScheduleProgramesView";
        this.g = 0;
        this.h = 0;
    }

    public void a() {
        this.i.get(this.g).d();
    }

    public void a(String str, String str2, String str3, boolean z) {
        this.B = str;
        this.D = str2;
        this.C = str3;
        this.E = z;
        if (this.g < this.i.size()) {
            this.i.get(this.g).a(str, str2, str3, z, false);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.b bVar) {
        if (bVar != null) {
            a(new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(s.b()));
        }
    }
}
