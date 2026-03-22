package com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter;

import android.content.Context;
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
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: RecordingSchedulesAdapter.java */
/* loaded from: classes.dex */
public class e extends RecyclerView.g {
    private static String k = "com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.e";

    /* renamed from: c, reason: collision with root package name */
    ArrayList<ScheduleBean> f5695c;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<RecordFileListBean.DataBean> f5696d;
    ArrayList<Integer> e;
    j f;
    boolean g;
    private Context h;
    private LayoutInflater i;
    private int j = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordingSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5697a;

        a(int i) {
            this.f5697a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar;
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            e eVar = e.this;
            if (eVar.g || (jVar = eVar.f) == null) {
                return;
            }
            jVar.c(this.f5697a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordingSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5699a;

        b(int i) {
            this.f5699a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar;
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            e eVar = e.this;
            if (eVar.g || (jVar = eVar.f) == null) {
                return;
            }
            jVar.a(this.f5699a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordingSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5701a;

        c(int i) {
            this.f5701a = i;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            j jVar = e.this.f;
            if (jVar != null) {
                jVar.a(this.f5701a, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordingSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5703a;

        d(int i) {
            this.f5703a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar;
            e eVar = e.this;
            if (eVar.g || (jVar = eVar.f) == null) {
                return;
            }
            jVar.c(this.f5703a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordingSchedulesAdapter.java */
    /* renamed from: com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0207e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5705a;

        ViewOnClickListenerC0207e(int i) {
            this.f5705a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar;
            e eVar = e.this;
            if (eVar.g || (jVar = eVar.f) == null) {
                return;
            }
            jVar.a(this.f5705a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordingSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class f implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5707a;

        f(int i) {
            this.f5707a = i;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            j jVar = e.this.f;
            if (jVar != null) {
                jVar.a(this.f5707a, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordingSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5709a;

        g(int i) {
            this.f5709a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar;
            e eVar = e.this;
            if (eVar.g || (jVar = eVar.f) == null) {
                return;
            }
            jVar.a(this.f5709a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordingSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class h implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5711a;

        h(int i) {
            this.f5711a = i;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            j jVar = e.this.f;
            if (jVar != null) {
                jVar.a(this.f5711a, z);
            }
        }
    }

    /* compiled from: RecordingSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class i extends RecyclerView.b0 implements LeftSlideDeleteRecyclerview.a {
        private RelativeLayout A;
        private TextView B;
        public CheckBox t;
        public LinearLayout u;
        private ImageView v;
        private TextView w;
        private TextView x;
        private TextView y;
        private RelativeLayout z;

        public i(View view) {
            super(view);
            this.v = (ImageView) view.findViewById(R.id.recording_history_item_icon_img);
            this.w = (TextView) view.findViewById(R.id.recording_history_item_time_txt);
            this.x = (TextView) view.findViewById(R.id.recording_history_item_title_txt);
            this.B = (TextView) view.findViewById(R.id.recording_history_item_reason_txt);
            this.y = (TextView) view.findViewById(R.id.recording_history_item_date_txt);
            this.z = (RelativeLayout) view.findViewById(R.id.recording_history_item_delete_rl);
            this.A = (RelativeLayout) view.findViewById(R.id.recording_history_item_select_rl);
            this.t = (CheckBox) view.findViewById(R.id.recording_history_item_select_checkbox);
            this.u = (LinearLayout) view.findViewById(R.id.recording_history_item_whole_ll);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview.a
        public int a() {
            RelativeLayout relativeLayout = this.z;
            if (relativeLayout != null) {
                return relativeLayout.getWidth();
            }
            return 0;
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview.a
        public Boolean b() {
            return Boolean.valueOf(e.this.g);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview.a
        public View c() {
            return this.u;
        }
    }

    /* compiled from: RecordingSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public interface j {
        void a(int i);

        void a(int i, boolean z);

        void c(int i);
    }

    /* compiled from: RecordingSchedulesAdapter.java */
    /* loaded from: classes.dex */
    public class k extends RecyclerView.b0 implements LeftSlideDeleteRecyclerview.a {
        private ImageView A;
        private RelativeLayout B;
        public RelativeLayout t;
        public CheckBox u;
        public LinearLayout v;
        private ImageView w;
        private TextView x;
        private TextView y;
        private TextView z;

        public k(View view) {
            super(view);
            this.w = (ImageView) view.findViewById(R.id.recording_schedules_item_icon_img);
            this.x = (TextView) view.findViewById(R.id.recording_schedules_item_time_txt);
            this.y = (TextView) view.findViewById(R.id.recording_schedules_item_title_txt);
            this.z = (TextView) view.findViewById(R.id.recording_schedules_item_date_txt);
            this.A = (ImageView) view.findViewById(R.id.recording_schedules_item_edit_img);
            this.B = (RelativeLayout) view.findViewById(R.id.recording_schedules_item_delete_rl);
            this.t = (RelativeLayout) view.findViewById(R.id.recording_schedules_item_select_rl);
            this.u = (CheckBox) view.findViewById(R.id.recording_schedules_item_select_checkbox);
            this.v = (LinearLayout) view.findViewById(R.id.recording_schedules_item_whole_ll);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview.a
        public int a() {
            RelativeLayout relativeLayout = this.B;
            if (relativeLayout != null) {
                return relativeLayout.getWidth();
            }
            return 0;
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview.a
        public Boolean b() {
            return Boolean.valueOf(e.this.g);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview.a
        public View c() {
            return this.v;
        }
    }

    public e(Context context, boolean z, ArrayList<ScheduleBean> arrayList, ArrayList<RecordFileListBean.DataBean> arrayList2, ArrayList<Integer> arrayList3) {
        this.g = false;
        this.f5695c = arrayList;
        this.f5696d = arrayList2;
        this.i = LayoutInflater.from(context);
        this.h = context;
        this.g = z;
        this.e = arrayList3;
    }

    public void a(j jVar) {
        this.f = jVar;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public boolean e() {
        return this.g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        int i2 = this.j;
        if (i2 == 1) {
            ArrayList<ScheduleBean> arrayList = this.f5695c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        if (i2 != 2 && i2 != 3) {
            ArrayList<ScheduleBean> arrayList2 = this.f5695c;
            if (arrayList2 == null) {
                return 0;
            }
            return arrayList2.size();
        }
        ArrayList<RecordFileListBean.DataBean> arrayList3 = this.f5696d;
        if (arrayList3 == null) {
            return 0;
        }
        return arrayList3.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i2) {
        int i3 = this.j;
        if (i3 == 1) {
            return new k(this.i.inflate(R.layout.recording_schedules_item_layout, viewGroup, false));
        }
        if (i3 == 2) {
            return new k(this.i.inflate(R.layout.recording_schedules_item_layout, viewGroup, false));
        }
        if (i3 != 3) {
            return new k(this.i.inflate(R.layout.recording_schedules_item_layout, viewGroup, false));
        }
        return new i(this.i.inflate(R.layout.recording_history_item_layout, viewGroup, false));
    }

    public void e(int i2) {
        this.j = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void a(RecyclerView.b0 b0Var, int i2, List list) {
        Log.d(k, "onBindViewHolder payload: " + list);
        if (list.isEmpty()) {
            LogEx.d(k, "payloads.isEmpty()");
            b(b0Var, i2);
            return;
        }
        int k2 = b0Var.k();
        if (k2 == 1 || k2 == 2) {
            k kVar = (k) b0Var;
            if (this.g) {
                kVar.t.setVisibility(0);
                Iterator<Integer> it2 = this.e.iterator();
                boolean z = false;
                while (it2.hasNext()) {
                    if (it2.next().intValue() == i2) {
                        LogEx.d(k, "position = " + i2 + " is finded");
                        z = true;
                    }
                }
                if (z) {
                    kVar.u.setChecked(true);
                    return;
                } else {
                    kVar.u.setChecked(false);
                    return;
                }
            }
            kVar.t.setVisibility(8);
            return;
        }
        if (k2 != 3) {
            return;
        }
        i iVar = (i) b0Var;
        if (this.g) {
            iVar.A.setVisibility(0);
            Iterator<Integer> it3 = this.e.iterator();
            boolean z2 = false;
            while (it3.hasNext()) {
                if (it3.next().intValue() == i2) {
                    LogEx.d(k, "position = " + i2 + " is finded");
                    z2 = true;
                }
            }
            if (z2) {
                iVar.t.setChecked(true);
                return;
            } else {
                iVar.t.setChecked(false);
                return;
            }
        }
        iVar.A.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0376  */
    @Override // androidx.recyclerview.widget.RecyclerView.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(androidx.recyclerview.widget.RecyclerView.b0 r21, int r22) {
        /*
            Method dump skipped, instructions count: 1277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.e.b(androidx.recyclerview.widget.RecyclerView$b0, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int b(int i2) {
        return this.j;
    }
}
