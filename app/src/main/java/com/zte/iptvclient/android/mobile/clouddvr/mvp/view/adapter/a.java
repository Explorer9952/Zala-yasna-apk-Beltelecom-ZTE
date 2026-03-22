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

/* compiled from: CloudDvrHistoryAdapter.java */
/* loaded from: classes.dex */
public class a extends RecyclerView.g {
    private static String i = "com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.a";

    /* renamed from: c, reason: collision with root package name */
    ArrayList<RecordFileListBean.DataBean> f5653c;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<Integer> f5654d;
    g e;
    boolean f;
    private Context g;
    private LayoutInflater h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrHistoryAdapter.java */
    /* renamed from: com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0203a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5655a;

        ViewOnClickListenerC0203a(int i) {
            this.f5655a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            a aVar = a.this;
            if (aVar.f || (gVar = aVar.e) == null) {
                return;
            }
            gVar.a(this.f5655a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrHistoryAdapter.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f5657a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f5658b;

        b(f fVar, int i) {
            this.f5657a = fVar;
            this.f5658b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            if (a.this.f) {
                this.f5657a.x.setChecked(!this.f5657a.x.isChecked());
            } else {
                if (com.zte.iptvclient.android.common.k.c.a() || (gVar = a.this.e) == null) {
                    return;
                }
                gVar.b(this.f5658b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrHistoryAdapter.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5660a;

        c(int i) {
            this.f5660a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            a aVar = a.this;
            if (aVar.f || (gVar = aVar.e) == null) {
                return;
            }
            gVar.c(this.f5660a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrHistoryAdapter.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f5662a;

        d(a aVar, f fVar) {
            this.f5662a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f5662a.x.setChecked(!this.f5662a.x.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrHistoryAdapter.java */
    /* loaded from: classes.dex */
    public class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5663a;

        e(int i) {
            this.f5663a = i;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            g gVar = a.this.e;
            if (gVar != null) {
                gVar.a(this.f5663a, z);
            }
        }
    }

    /* compiled from: CloudDvrHistoryAdapter.java */
    /* loaded from: classes.dex */
    public class f extends RecyclerView.b0 implements LeftSlideDeleteRecyclerview.a {
        private TextView A;
        private TextView B;
        private TextView C;
        private ImageView D;
        private ImageView E;
        private TextView F;
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
            ImageView imageView = (ImageView) view.findViewById(R.id.recording_clouddvr_history_item_error_img);
            this.E = imageView;
            com.zte.iptvclient.common.uiframe.f.a(imageView);
            TextView textView = (TextView) view.findViewById(R.id.recording_clouddvr_history_item_error_txt);
            this.F = textView;
            com.zte.iptvclient.common.uiframe.f.a(textView);
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
            return Boolean.valueOf(a.this.f);
        }

        @Override // com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview.a
        public View c() {
            return this.y;
        }
    }

    /* compiled from: CloudDvrHistoryAdapter.java */
    /* loaded from: classes.dex */
    public interface g {
        void a(int i);

        void a(int i, boolean z);

        void b(int i);

        void c(int i);
    }

    public a(Context context, boolean z, ArrayList<RecordFileListBean.DataBean> arrayList, ArrayList<Integer> arrayList2) {
        this.f = false;
        this.f5653c = arrayList;
        this.h = LayoutInflater.from(context);
        this.g = context;
        this.f = z;
        this.f5654d = arrayList2;
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
        ArrayList<RecordFileListBean.DataBean> arrayList = this.f5653c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i2) {
        return new f(this.h.inflate(R.layout.recording_clouddvr_history_item_layout, viewGroup, false));
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
            Iterator<Integer> it2 = this.f5654d.iterator();
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
        String iconurl = this.f5653c.get(i2).getIconurl();
        LogEx.d(i, "history icon url = " + iconurl);
        if (!TextUtils.isEmpty(iconurl) && (indexOf = iconurl.indexOf("/image", 1)) >= 0) {
            com.bumptech.glide.d<String> a2 = i.b(this.g).a(com.zte.iptvclient.android.common.f.b.i.g() + iconurl.substring(indexOf));
            a2.e();
            a2.a(fVar.z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02b1  */
    @Override // androidx.recyclerview.widget.RecyclerView.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(androidx.recyclerview.widget.RecyclerView.b0 r13, int r14) {
        /*
            Method dump skipped, instructions count: 695
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.a.b(androidx.recyclerview.widget.RecyclerView$b0, int):void");
    }
}
