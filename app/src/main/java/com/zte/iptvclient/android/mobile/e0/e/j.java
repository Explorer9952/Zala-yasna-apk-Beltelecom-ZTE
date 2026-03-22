package com.zte.iptvclient.android.mobile.e0.e;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.javabean.models.SeriesHeadBean;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/* compiled from: DetailSeriesFragment_HD.java */
/* loaded from: classes.dex */
public class j extends com.zte.fragmentlib.b {
    private String p = "";
    private TextView q;
    private RelativeLayout r;
    private Button s;
    private TextView t;
    private FrameLayout u;
    private i v;
    private h w;
    private Bundle x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment_HD.java */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f6011a;

        a(View view) {
            this.f6011a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            LogEx.d("DetailSeriesFragment_HD", " onGlobalLayout invoke.");
            j.this.J();
            this.f6011a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment_HD.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.i());
            if (j.this.getActivity() instanceof MainActivity) {
                j.this.F();
            } else if (j.this.getActivity() instanceof HostActivity) {
                j.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        LogEx.d("DetailSeriesFragment_HD", " lazyInflater method is called");
        i iVar = new i();
        this.v = iVar;
        iVar.setArguments(this.x);
        a(R.id.series_left_fragment_container_hd, this.v);
        h hVar = new h();
        this.w = hVar;
        hVar.setArguments(this.x);
        a(R.id.series_right_fragment_container_hd, this.w);
    }

    private void K() {
        this.s.setOnClickListener(new b());
    }

    private void d(View view) {
        this.q = (TextView) view.findViewById(R.id.series_detail_top_hd);
        this.r = (RelativeLayout) view.findViewById(R.id.series_detail_title_hd);
        this.s = (Button) view.findViewById(R.id.series_detail_back_hd);
        this.t = (TextView) view.findViewById(R.id.series_detail_program_name_hd);
        this.u = (FrameLayout) view.findViewById(R.id.series_right_fragment_container_hd);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        this.q.setHeight(a2);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.series_detail_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.series_detail_top_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.series_detail_program_name_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.series_detail_title_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.series_detail_back_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.series_title_bottom_line_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.series_detail_fragment_container));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.series_left_fragment_container_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.series_right_fragment_container_hd));
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            view.findViewById(R.id.series_detail_hd).setBackgroundResource(R.drawable.bg_child);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view));
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.f());
        com.zte.iptvclient.android.common.player.k.c cVar = this.v.S;
        if (cVar != null && cVar.v2()) {
            return true;
        }
        if (getActivity() instanceof MainActivity) {
            F();
        } else if (getActivity() instanceof HostActivity) {
            getActivity().finish();
        }
        return true;
    }

    public void I() {
        LogEx.d("DetailSeriesFragment_HD", "---cancelRecommendDataRequest---");
        h hVar = this.w;
        if (hVar != null) {
            hVar.I();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        K();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d("DetailSeriesFragment_HD", "onCreate");
        Bundle arguments = getArguments();
        this.x = arguments;
        if (arguments != null) {
            String string = arguments.getString("seriesprogramcode");
            this.p = string;
            if (TextUtils.isEmpty(string)) {
                this.p = this.x.getString("programcode");
            }
        }
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.detail_series_fragment_hd, viewGroup, false);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.i.a());
        EventBus.getDefault().unregister(this);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.a, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.b0.b bVar) {
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        this.u.setVisibility(8);
    }

    public void s(String str) {
        this.p = str;
        this.v.u(str);
    }

    public void t(String str) {
        this.v.t(str);
    }

    public void a(SeriesHeadBean seriesHeadBean) {
        this.t.setText(seriesHeadBean.getProgramname());
        h hVar = this.w;
        if (hVar != null) {
            hVar.a(seriesHeadBean);
        }
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.b0.d dVar) {
        this.q.setVisibility(0);
        this.r.setVisibility(0);
        this.u.setVisibility(0);
    }

    public void a(String str, String str2, String str3, SeriesHeadBean seriesHeadBean) {
        LogEx.d("DetailSeriesFragment_HD", "---notifyPadObtainAllSeason---");
        h hVar = this.w;
        if (hVar != null) {
            hVar.a(str, str2, str3, seriesHeadBean);
        }
    }
}
