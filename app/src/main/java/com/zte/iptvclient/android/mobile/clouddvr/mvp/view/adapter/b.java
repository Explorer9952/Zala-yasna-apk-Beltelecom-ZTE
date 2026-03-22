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
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CloudDvrManagerAdapter.java */
/* loaded from: classes.dex */
public class b extends RecyclerView.g {
    private static String i = "com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.b";

    /* renamed from: c, reason: collision with root package name */
    ArrayList<RecordFileListBean.DataBean> f5665c;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<Integer> f5666d;
    g e;
    boolean f;
    private Context g;
    private LayoutInflater h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrManagerAdapter.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5667a;

        a(int i) {
            this.f5667a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            b bVar = b.this;
            if (bVar.f || (gVar = bVar.e) == null) {
                return;
            }
            gVar.a(this.f5667a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrManagerAdapter.java */
    /* renamed from: com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0204b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f5669a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f5670b;

        ViewOnClickListenerC0204b(f fVar, int i) {
            this.f5669a = fVar;
            this.f5670b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            if (b.this.f) {
                this.f5669a.x.setChecked(!this.f5669a.x.isChecked());
            } else {
                if (com.zte.iptvclient.android.common.k.c.a() || (gVar = b.this.e) == null) {
                    return;
                }
                gVar.b(this.f5670b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrManagerAdapter.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5672a;

        c(int i) {
            this.f5672a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            b bVar = b.this;
            if (bVar.f || (gVar = bVar.e) == null) {
                return;
            }
            gVar.c(this.f5672a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrManagerAdapter.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f5674a;

        d(b bVar, f fVar) {
            this.f5674a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f5674a.x.setChecked(!this.f5674a.x.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrManagerAdapter.java */
    /* loaded from: classes.dex */
    public class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5675a;

        e(int i) {
            this.f5675a = i;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            g gVar = b.this.e;
            if (gVar != null) {
                gVar.a(this.f5675a, z);
            }
        }
    }

    /* compiled from: CloudDvrManagerAdapter.java */
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
            return Boolean.valueOf(b.this.f);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview.a
        public View c() {
            return this.y;
        }
    }

    /* compiled from: CloudDvrManagerAdapter.java */
    /* loaded from: classes.dex */
    public interface g {
        void a(int i);

        void a(int i, boolean z);

        void b(int i);

        void c(int i);
    }

    public b(Context context, boolean z, ArrayList<RecordFileListBean.DataBean> arrayList, ArrayList<Integer> arrayList2) {
        this.f = false;
        this.f5665c = arrayList;
        this.h = LayoutInflater.from(context);
        this.g = context;
        this.f = z;
        this.f5666d = arrayList2;
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
        ArrayList<RecordFileListBean.DataBean> arrayList = this.f5665c;
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
            Iterator<Integer> it2 = this.f5666d.iterator();
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
        String iconurl = this.f5665c.get(i2).getIconurl();
        LogEx.d(i, "history icon url = " + iconurl);
        if (!TextUtils.isEmpty(iconurl) && (indexOf = iconurl.indexOf("/image", 1)) >= 0) {
            com.bumptech.glide.d<String> a2 = i.b(this.g).a(com.zte.iptvclient.android.common.f.b.i.g() + iconurl.substring(indexOf));
            a2.e();
            a2.a(fVar.z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0200  */
    @Override // androidx.recyclerview.widget.RecyclerView.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(androidx.recyclerview.widget.RecyclerView.b0 r13, int r14) {
        /*
            Method dump skipped, instructions count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.b.b(androidx.recyclerview.widget.RecyclerView$b0, int):void");
    }
}
