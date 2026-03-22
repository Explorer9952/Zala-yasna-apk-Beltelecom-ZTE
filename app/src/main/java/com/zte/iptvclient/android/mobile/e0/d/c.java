package com.zte.iptvclient.android.mobile.e0.d;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: AdapterRecycleHelpVideo.java */
/* loaded from: classes2.dex */
public class c extends RecyclerView.g<RecyclerView.b0> {

    /* renamed from: c, reason: collision with root package name */
    private b f5803c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<CommonVideoBean> f5804d;
    private InterfaceC0220c e;

    /* compiled from: AdapterRecycleHelpVideo.java */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.b0 {
        private TextView t;
        private ImageView u;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AdapterRecycleHelpVideo.java */
        /* renamed from: com.zte.iptvclient.android.mobile.e0.d.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class ViewOnClickListenerC0219a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CommonVideoBean f5805a;

            ViewOnClickListenerC0219a(CommonVideoBean commonVideoBean) {
                this.f5805a = commonVideoBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.zte.iptvclient.android.common.k.c.a() || c.this.e == null) {
                    return;
                }
                c.this.e.a(this.f5805a);
            }
        }

        public a(View view) {
            super(view);
            this.t = (TextView) view.findViewById(R.id.txt_program_name);
            this.u = (ImageView) view.findViewById(R.id.img_play);
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_help_video_item));
            com.zte.iptvclient.common.uiframe.f.a(this.u);
            com.zte.iptvclient.common.uiframe.f.a(this.t);
        }

        public void a(CommonVideoBean commonVideoBean) {
            LogEx.d("AdapterRecycleHelpVideo", "setVideoItemView ");
            if (commonVideoBean != null) {
                if (TextUtils.isEmpty(commonVideoBean.e())) {
                    this.t.setText("");
                } else {
                    this.t.setText(commonVideoBean.e());
                }
                this.u.setOnClickListener(new ViewOnClickListenerC0219a(commonVideoBean));
            }
        }
    }

    /* compiled from: AdapterRecycleHelpVideo.java */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.b0 {
        private View t;
        private LinearLayout u;
        private ImageView v;
        private TextView w;

        public b(c cVar, View view) {
            super(view);
            this.t = view;
            view.setVisibility(8);
            this.u = (LinearLayout) view.findViewById(R.id.ll_no_more);
            this.v = (ImageView) view.findViewById(R.id.img_no_more);
            this.w = (TextView) view.findViewById(R.id.txt_no_more);
            com.zte.iptvclient.common.uiframe.f.a(this.u);
            com.zte.iptvclient.common.uiframe.f.a(this.v);
            com.zte.iptvclient.common.uiframe.f.a(this.w);
            this.u.setVisibility(8);
        }

        public View D() {
            return this.t;
        }
    }

    /* compiled from: AdapterRecycleHelpVideo.java */
    /* renamed from: com.zte.iptvclient.android.mobile.e0.d.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0220c {
        void a(CommonVideoBean commonVideoBean);
    }

    public c(Activity activity, ArrayList<CommonVideoBean> arrayList, InterfaceC0220c interfaceC0220c) {
        this.f5804d = arrayList;
        this.e = interfaceC0220c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        if (i == 2) {
            if (this.f5803c == null) {
                this.f5803c = new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.no_content_layout, (ViewGroup) null));
            }
            return this.f5803c;
        }
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.help_adpater_video_item, (ViewGroup) null));
    }

    public boolean e(int i) {
        return i == a() - 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        LogEx.d("AdapterRecycleHelpVideo", "getItemCount " + this.f5804d.size() + 1);
        return this.f5804d.size() + 1;
    }

    public void b(boolean z) {
        if (this.f5803c != null) {
            LogEx.d("AdapterRecycleHelpVideo", "setFooterViewVisible =" + z);
            this.f5803c.D().setVisibility(z ? 0 : 8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        if (e(i)) {
            return;
        }
        ((a) b0Var).a(this.f5804d.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int b(int i) {
        return e(i) ? 2 : 1;
    }
}
