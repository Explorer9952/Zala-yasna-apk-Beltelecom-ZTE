package com.zte.iptvclient.android.mobile.e0.e;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/* compiled from: DetailMovieFragment_HD.java */
/* loaded from: classes.dex */
public class e extends com.zte.fragmentlib.b {
    private TextView p;
    private RelativeLayout q;
    private Button r;
    private TextView s;
    private FrameLayout t;
    private d u;
    private h v;
    private Bundle w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment_HD.java */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5902a;

        a(View view) {
            this.f5902a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            LogEx.d("DetailMovieFragment_HD", " onGlobalLayout invoke.");
            e.this.I();
            this.f5902a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment_HD.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.i());
            if (e.this.getActivity() instanceof MainActivity) {
                e.this.F();
            } else if (e.this.getActivity() instanceof HostActivity) {
                e.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        LogEx.d("DetailMovieFragment_HD", " lazyInflater method is called.");
        d dVar = new d();
        this.u = dVar;
        dVar.setArguments(this.w);
        a(R.id.movie_left_fragment_container_hd, this.u);
        h hVar = new h();
        this.v = hVar;
        hVar.setArguments(this.w);
        a(R.id.movie_right_fragment_container_hd, this.v);
    }

    private void J() {
        this.r.setOnClickListener(new b());
    }

    private void d(View view) {
        this.p = (TextView) view.findViewById(R.id.movie_detail_top_hd);
        this.q = (RelativeLayout) view.findViewById(R.id.movie_detail_title_hd);
        this.r = (Button) view.findViewById(R.id.movie_detail_back_hd);
        this.s = (TextView) view.findViewById(R.id.movie_detail_program_name_hd);
        this.t = (FrameLayout) view.findViewById(R.id.movie_right_fragment_container_hd);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        this.p.setHeight(a2);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.movie_detail_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.movie_detail_top_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.movie_detail_program_name_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.movie_detail_title_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.movie_detail_back_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.movie_title_bottom_line_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.movie_detail_fragment_container));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.movie_left_fragment_container_hd));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.movie_right_fragment_container_hd));
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            view.findViewById(R.id.movie_detail_hd).setBackgroundResource(R.drawable.bg_child);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view));
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.f());
        com.zte.iptvclient.android.common.player.k.c cVar = this.u.E;
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

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        J();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d("DetailMovieFragment_HD", "onCreate");
        this.w = getArguments();
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.detail_movie_fragment_hd, viewGroup, false);
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
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        this.t.setVisibility(8);
    }

    public void a(VideoDetailBean videoDetailBean) {
        this.s.setText(videoDetailBean.getProgramname());
        h hVar = this.v;
        if (hVar != null) {
            hVar.a(videoDetailBean);
        }
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.b0.d dVar) {
        this.p.setVisibility(0);
        this.q.setVisibility(0);
        this.t.setVisibility(0);
    }
}
