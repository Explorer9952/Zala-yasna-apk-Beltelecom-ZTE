package com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.i;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview;
import com.zte.iptvclient.android.zala.R;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* compiled from: CloudDvrSchedulesAdapter.java */
/* loaded from: classes.dex */
public class c extends RecyclerView.g {
    private static String i = "com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.c";

    /* renamed from: c, reason: collision with root package name */
    ArrayList<ScheduleBean> f5677c;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<Integer> f5678d;
    g e;
    boolean f;
    private Context g;
    private LayoutInflater h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5679a;

        a(int i) {
            this.f5679a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            c cVar = c.this;
            if (cVar.f || (gVar = cVar.e) == null) {
                return;
            }
            gVar.a(this.f5679a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f5681a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f5682b;

        b(f fVar, int i) {
            this.f5681a = fVar;
            this.f5682b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            if (c.this.f) {
                this.f5681a.x.setChecked(!this.f5681a.x.isChecked());
            } else {
                if (com.zte.iptvclient.android.common.k.c.a() || (gVar = c.this.e) == null) {
                    return;
                }
                gVar.b(this.f5682b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrSchedulesAdapter.java */
    /* renamed from: com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0205c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5684a;

        ViewOnClickListenerC0205c(int i) {
            this.f5684a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            c cVar = c.this;
            if (cVar.f || (gVar = cVar.e) == null) {
                return;
            }
            gVar.c(this.f5684a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f5686a;

        d(c cVar, f fVar) {
            this.f5686a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f5686a.x.setChecked(!this.f5686a.x.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5687a;

        e(int i) {
            this.f5687a = i;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            g gVar = c.this.e;
            if (gVar != null) {
                gVar.a(this.f5687a, z);
            }
        }
    }

    /* compiled from: CloudDvrSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class f extends RecyclerView.b0 implements LeftSlideDeleteRecyclerview.a {
        private TextView A;
        private TextView B;
        private TextView C;
        private ImageView D;
        public RelativeLayout t;
        public RelativeLayout u;
        private RelativeLayout v;
        public RelativeLayout w;
        public CheckBox x;
        public LinearLayout y;
        private ImageView z;

        public f(View view) {
            super(view);
            this.z = (ImageView) view.findViewById(R.id.recording_npvr_item_icon_img);
            this.A = (TextView) view.findViewById(R.id.recording_npvr_item_time_txt);
            this.B = (TextView) view.findViewById(R.id.recording_npvr_item_title_txt);
            this.C = (TextView) view.findViewById(R.id.recording_npvr_item_date_txt);
            this.v = (RelativeLayout) view.findViewById(R.id.recording_npvr_item_delete_rl);
            this.u = (RelativeLayout) view.findViewById(R.id.recording_npvr_body_rl);
            this.t = (RelativeLayout) view.findViewById(R.id.recording_npvr_item_select_rl);
            this.x = (CheckBox) view.findViewById(R.id.recording_npvr_item_select_checkbox);
            this.y = (LinearLayout) view.findViewById(R.id.recording_npvr_item_whole_ll);
            this.w = (RelativeLayout) view.findViewById(R.id.recording_clouddvr_item_edit_rl);
            this.D = (ImageView) view.findViewById(R.id.recording_clouddvr_item_edit_img);
            com.zte.iptvclient.common.uiframe.f.a(this.z);
            com.zte.iptvclient.common.uiframe.f.a(this.A);
            com.zte.iptvclient.common.uiframe.f.a(this.B);
            com.zte.iptvclient.common.uiframe.f.a(this.C);
            com.zte.iptvclient.common.uiframe.f.a(this.v);
            com.zte.iptvclient.common.uiframe.f.a(this.t);
            com.zte.iptvclient.common.uiframe.f.a(this.x);
            com.zte.iptvclient.common.uiframe.f.a(this.y);
            com.zte.iptvclient.common.uiframe.f.a(this.u);
            com.zte.iptvclient.common.uiframe.f.a(this.w);
            com.zte.iptvclient.common.uiframe.f.a(this.D);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview.a
        public int a() {
            RelativeLayout relativeLayout = this.v;
            if (relativeLayout != null) {
                return relativeLayout.getWidth();
            }
            return 0;
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview.a
        public Boolean b() {
            return Boolean.valueOf(c.this.f);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview.a
        public View c() {
            return this.y;
        }
    }

    /* compiled from: CloudDvrSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public interface g {
        void a(int i);

        void a(int i, boolean z);

        void b(int i);

        void c(int i);
    }

    public c(Context context, boolean z, ArrayList<ScheduleBean> arrayList, ArrayList<Integer> arrayList2) {
        this.f = false;
        this.f5677c = arrayList;
        this.h = LayoutInflater.from(context);
        this.g = context;
        this.f = z;
        this.f5678d = arrayList2;
    }

    public void a(g gVar) {
        this.e = gVar;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public boolean e() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        ArrayList<ScheduleBean> arrayList = this.f5677c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i2) {
        return new f(this.h.inflate(R.layout.recording_clouddvr_schedules_item_layout, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void a(RecyclerView.b0 b0Var, int i2, List list) {
        int indexOf;
        Log.d(i, "onBindViewHolder payload: " + list);
        if (list.isEmpty()) {
            LogEx.d(i, "payloads.isEmpty()");
            b(b0Var, i2);
            return;
        }
        f fVar = (f) b0Var;
        if (this.f) {
            fVar.t.setVisibility(0);
            Iterator<Integer> it2 = this.f5678d.iterator();
            boolean z = false;
            while (it2.hasNext()) {
                if (it2.next().intValue() == i2) {
                    LogEx.d(i, "position = " + i2 + " is finded");
                    z = true;
                }
            }
            if (z) {
                fVar.x.setChecked(true);
            } else {
                fVar.x.setChecked(false);
            }
        } else {
            fVar.t.setVisibility(8);
        }
        String iconurl = this.f5677c.get(i2).getIconurl();
        LogEx.d(i, "history icon url = " + iconurl);
        if (!TextUtils.isEmpty(iconurl) && (indexOf = iconurl.indexOf("/image", 1)) >= 0) {
            com.bumptech.glide.d<String> a2 = i.b(this.g).a(com.zte.iptvclient.android.common.f.b.i.g() + iconurl.substring(indexOf));
            a2.e();
            a2.a(fVar.z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i2) {
        f fVar = (f) b0Var;
        Log.d(i, "onBindViewHolder# position=" + i2);
        ScheduleBean scheduleBean = this.f5677c.get(i2);
        fVar.B.setText(scheduleBean.getName());
        String iconurl = scheduleBean.getIconurl();
        if (TextUtils.isEmpty(iconurl)) {
            com.bumptech.glide.d<Integer> a2 = i.b(this.g).a(Integer.valueOf(R.drawable.default_poster_thumb));
            a2.e();
            a2.a(fVar.z);
        } else {
            int indexOf = iconurl.indexOf("/image", 1);
            if (indexOf >= 0) {
                com.bumptech.glide.d<String> a3 = i.b(this.g).a(com.zte.iptvclient.android.common.f.b.i.g() + iconurl.substring(indexOf));
                a3.e();
                a3.a(fVar.z);
            }
        }
        String starttimeutc = scheduleBean.getStarttimeutc();
        String endtimeutc = scheduleBean.getEndtimeutc();
        try {
            Date b2 = com.zte.iptvclient.android.mobile.g.b.a.b(starttimeutc, "yyyy.MM.dd HH:mm:ss");
            Date b3 = com.zte.iptvclient.android.mobile.g.b.a.b(endtimeutc, "yyyy.MM.dd HH:mm:ss");
            String str = com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_date_record) + " " + com.zte.iptvclient.android.mobile.g.b.a.a(b2, "yyyy-MM-dd").substring(2);
            LogEx.d(i, "Date = " + str);
            starttimeutc = com.zte.iptvclient.android.mobile.g.b.a.a(b2, "HH:mm");
            endtimeutc = com.zte.iptvclient.android.mobile.g.b.a.a(b3, "HH:mm");
            String str2 = starttimeutc + "-" + endtimeutc;
            LogEx.d(i, "Time = " + str2);
            fVar.C.setText(str);
            fVar.A.setText(str2);
        } catch (ParseException unused) {
            LogEx.d(i, "Time is incorrect, startTime = " + starttimeutc + " endTime = " + endtimeutc);
        }
        fVar.v.setOnClickListener(new a(i2));
        fVar.u.setOnClickListener(new b(fVar, i2));
        fVar.w.setOnClickListener(new ViewOnClickListenerC0205c(i2));
        if (this.f) {
            fVar.t.setVisibility(0);
            fVar.t.setOnClickListener(new d(this, fVar));
            fVar.x.setOnCheckedChangeListener(new e(i2));
            Iterator<Integer> it2 = this.f5678d.iterator();
            boolean z = false;
            while (it2.hasNext()) {
                if (it2.next().intValue() == i2) {
                    LogEx.d(i, "position = " + i2 + " is finded");
                    z = true;
                }
            }
            if (z) {
                fVar.x.setChecked(true);
                return;
            } else {
                fVar.x.setChecked(false);
                return;
            }
        }
        fVar.t.setVisibility(8);
    }
}
