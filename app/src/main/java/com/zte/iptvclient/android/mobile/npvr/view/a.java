package com.zte.iptvclient.android.mobile.npvr.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.DefinitionType;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview;
import com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrBean;
import com.zte.iptvclient.android.zala.R;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* compiled from: NpvrRecordingsAdapter.java */
/* loaded from: classes.dex */
public class a extends RecyclerView.g {
    private static String m = "com.zte.iptvclient.android.mobile.npvr.view.a";

    /* renamed from: c, reason: collision with root package name */
    ArrayList<NpvrBean> f6888c;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<Integer> f6889d;
    f e;
    boolean f;
    private Context g;
    private LayoutInflater h;
    private Drawable i;
    private Drawable j;
    private Drawable k;
    private Drawable l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NpvrRecordingsAdapter.java */
    /* renamed from: com.zte.iptvclient.android.mobile.npvr.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0320a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6890a;

        ViewOnClickListenerC0320a(int i) {
            this.f6890a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            a aVar = a.this;
            if (aVar.f || (fVar = aVar.e) == null) {
                return;
            }
            fVar.a(this.f6890a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NpvrRecordingsAdapter.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NpvrBean f6892a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f6893b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f6894c;

        b(NpvrBean npvrBean, e eVar, int i) {
            this.f6892a = npvrBean;
            this.f6893b = eVar;
            this.f6894c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            LogEx.d("Test the starting speed", "startPlay for NPVR");
            if (TextUtils.equals(this.f6892a.getStatus(), "0")) {
                return;
            }
            if (a.this.f) {
                this.f6893b.w.setChecked(!this.f6893b.w.isChecked());
            } else {
                if (com.zte.iptvclient.android.common.k.c.a() || (fVar = a.this.e) == null) {
                    return;
                }
                fVar.b(this.f6894c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NpvrRecordingsAdapter.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f6896a;

        c(a aVar, e eVar) {
            this.f6896a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f6896a.w.setChecked(!this.f6896a.w.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NpvrRecordingsAdapter.java */
    /* loaded from: classes.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6897a;

        d(int i) {
            this.f6897a = i;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            f fVar = a.this.e;
            if (fVar != null) {
                fVar.a(this.f6897a, z);
            }
        }
    }

    /* compiled from: NpvrRecordingsAdapter.java */
    /* loaded from: classes.dex */
    public class e extends RecyclerView.b0 implements LeftSlideDeleteRecyclerview.a {
        private TextView A;
        private TextView B;
        private ImageView C;
        public RelativeLayout t;
        public RelativeLayout u;
        private RelativeLayout v;
        public CheckBox w;
        public LinearLayout x;
        private ImageView y;
        private TextView z;

        public e(View view) {
            super(view);
            this.y = (ImageView) view.findViewById(R.id.recording_npvr_item_icon_img);
            this.z = (TextView) view.findViewById(R.id.recording_npvr_item_time_txt);
            this.A = (TextView) view.findViewById(R.id.recording_npvr_item_title_txt);
            this.B = (TextView) view.findViewById(R.id.recording_npvr_item_date_txt);
            this.v = (RelativeLayout) view.findViewById(R.id.recording_npvr_item_delete_rl);
            this.u = (RelativeLayout) view.findViewById(R.id.recording_npvr_body_rl);
            this.t = (RelativeLayout) view.findViewById(R.id.recording_npvr_item_select_rl);
            this.w = (CheckBox) view.findViewById(R.id.recording_npvr_item_select_checkbox);
            this.x = (LinearLayout) view.findViewById(R.id.recording_npvr_item_whole_ll);
            this.C = (ImageView) view.findViewById(R.id.recording_npvr_item_record_status_img);
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.recording_npvr_img_container));
            com.zte.iptvclient.common.uiframe.f.a(this.y);
            com.zte.iptvclient.common.uiframe.f.a(this.z);
            com.zte.iptvclient.common.uiframe.f.a(this.A);
            com.zte.iptvclient.common.uiframe.f.a(this.B);
            com.zte.iptvclient.common.uiframe.f.a(this.v);
            com.zte.iptvclient.common.uiframe.f.a(this.t);
            com.zte.iptvclient.common.uiframe.f.a(this.w);
            com.zte.iptvclient.common.uiframe.f.a(this.x);
            com.zte.iptvclient.common.uiframe.f.a(this.C);
            com.zte.iptvclient.common.uiframe.f.a(this.u);
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
            return this.x;
        }
    }

    /* compiled from: NpvrRecordingsAdapter.java */
    /* loaded from: classes.dex */
    public interface f {
        void a(int i);

        void a(int i, boolean z);

        void b(int i);
    }

    public a(Context context, boolean z, ArrayList<NpvrBean> arrayList, ArrayList<Integer> arrayList2) {
        this.f = false;
        this.f6888c = arrayList;
        this.h = LayoutInflater.from(context);
        this.g = context;
        this.f = z;
        this.f6889d = arrayList2;
        this.i = androidx.core.content.a.c(context, R.drawable.icon_waitrecording);
        this.j = androidx.core.content.a.c(context, R.drawable.icon_recorded_circle);
        this.k = androidx.core.content.a.c(context, R.drawable.icon_waitrecording);
        this.l = androidx.core.content.a.c(context, R.drawable.icon_notrecord_circle);
        androidx.core.content.a.a(context, R.color.icon_recorded_recordfailed);
        androidx.core.content.a.a(context, R.color.icon_recorded_recorded);
        androidx.core.content.a.a(context, R.color.icon_recorded_recordfailed);
        androidx.core.content.a.a(context, R.color.icon_recorded_recordfailed);
        com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_status_waiting);
        com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_status_finished);
        com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_status_ongoing);
        com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_status_failed);
    }

    public void a(f fVar) {
        this.e = fVar;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public boolean e() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        ArrayList<NpvrBean> arrayList = this.f6888c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        return new e(this.h.inflate(R.layout.recording_npvr_item_layout, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void a(RecyclerView.b0 b0Var, int i, List list) {
        Log.d(m, "onBindViewHolder payload: " + list);
        if (list.isEmpty()) {
            LogEx.d(m, "payloads.isEmpty()");
            b(b0Var, i);
            return;
        }
        e eVar = (e) b0Var;
        if (this.f) {
            eVar.t.setVisibility(0);
            Iterator<Integer> it2 = this.f6889d.iterator();
            boolean z = false;
            while (it2.hasNext()) {
                if (it2.next().intValue() == i) {
                    LogEx.d(m, "position = " + i + " is finded");
                    z = true;
                }
            }
            if (z) {
                eVar.w.setChecked(true);
                return;
            } else {
                eVar.w.setChecked(false);
                return;
            }
        }
        eVar.t.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        e eVar = (e) b0Var;
        Log.d(m, "onBindViewHolder# position=" + i);
        NpvrBean npvrBean = this.f6888c.get(i);
        eVar.A.setText(npvrBean.getPrevuename());
        String filename = npvrBean.getFilename();
        if (TextUtils.isEmpty(filename)) {
            com.bumptech.glide.d<Integer> a2 = i.b(this.g).a(Integer.valueOf(R.drawable.default_poster_thumb));
            a2.e();
            a2.a(eVar.y);
        } else {
            int indexOf = filename.indexOf("/image", 1);
            if (indexOf >= 0) {
                com.bumptech.glide.d<String> a3 = i.b(this.g).a(com.zte.iptvclient.android.common.f.b.i.g() + filename.substring(indexOf));
                a3.a(R.drawable.default_video_thumb);
                a3.b(126, 94);
                a3.a(eVar.y);
            }
        }
        String begintime = npvrBean.getBegintime();
        String endtime = npvrBean.getEndtime();
        try {
            Date a4 = com.zte.iptvclient.android.mobile.g.b.a.a(begintime, "yyyy.MM.dd HH:mm:ss");
            Date a5 = com.zte.iptvclient.android.mobile.g.b.a.a(endtime, "yyyy.MM.dd HH:mm:ss");
            String str = " " + com.zte.iptvclient.android.mobile.g.b.a.a(a4, "dd.MM.yyyy");
            LogEx.d(m, "Date = " + str);
            begintime = com.zte.iptvclient.android.mobile.g.b.a.a(a4, "HH:mm");
            endtime = com.zte.iptvclient.android.mobile.g.b.a.a(a5, "HH:mm");
            String str2 = begintime + "-" + endtime + str;
            LogEx.d(m, "Time = " + str2);
            eVar.B.setText(str);
            eVar.z.setText(str2);
        } catch (ParseException unused) {
            LogEx.d(m, "Time is incorrect, startTime = " + begintime + " endTime = " + endtime);
        }
        if (TextUtils.equals(npvrBean.getStatus(), "0")) {
            eVar.C.setImageDrawable(this.i);
        } else if (TextUtils.equals(npvrBean.getStatus(), DefinitionType.TYPE_DEFINITION_OTHER)) {
            eVar.C.setImageDrawable(this.k);
        } else if (TextUtils.equals(npvrBean.getStatus(), WeiboAuthException.DEFAULT_AUTH_ERROR_CODE)) {
            eVar.C.setImageDrawable(this.l);
        } else if (TextUtils.equals(npvrBean.getStatus(), "1")) {
            eVar.C.setImageDrawable(this.j);
        } else {
            eVar.C.setImageDrawable(this.i);
        }
        eVar.v.setOnClickListener(new ViewOnClickListenerC0320a(i));
        eVar.u.setOnClickListener(new b(npvrBean, eVar, i));
        if (this.f) {
            eVar.t.setVisibility(0);
            eVar.t.setOnClickListener(new c(this, eVar));
            eVar.w.setOnCheckedChangeListener(new d(i));
            Iterator<Integer> it2 = this.f6889d.iterator();
            boolean z = false;
            while (it2.hasNext()) {
                if (it2.next().intValue() == i) {
                    LogEx.d(m, "position = " + i + " is finded");
                    z = true;
                }
            }
            if (z) {
                eVar.w.setChecked(true);
                return;
            } else {
                eVar.w.setChecked(false);
                return;
            }
        }
        eVar.t.setVisibility(8);
    }
}
