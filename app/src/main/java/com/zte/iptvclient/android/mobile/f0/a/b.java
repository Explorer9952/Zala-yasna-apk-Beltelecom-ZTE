package com.zte.iptvclient.android.mobile.f0.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.r;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.e.x.i;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.f0.a.c;
import com.zte.iptvclient.android.zala.R;
import com.zte.ucs.tvcall.Commons;
import d.e.a.a.b;
import java.util.ArrayList;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* compiled from: MobileWebFragment.java */
/* loaded from: classes2.dex */
public class b extends com.zte.fragmentlib.b {
    Button p;
    TextView q;
    private FrameLayout v;
    private RelativeLayout w;
    public String r = "";
    private String s = "MobileWebFragment";
    private com.zte.iptvclient.android.mobile.f0.a.c t = null;
    public String u = "";
    private ArrayList<String> x = null;
    private ArrayList<String> y = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MobileWebFragment.java */
    /* loaded from: classes2.dex */
    public class a implements b.InterfaceC0411b {
        a() {
        }

        @Override // d.e.a.a.b.InterfaceC0411b
        public void a(int i, String str, Map<String, Object> map) {
            if (i == 0) {
                LogEx.d(b.this.s, "return map=" + map.toString());
                String str2 = (String) map.get("contenttype");
                String str3 = (String) map.get("contentcode");
                String str4 = (String) map.get("columncode");
                String str5 = (String) map.get("programcode");
                LogEx.d(b.this.s, "contenttype=" + str2 + ",contentcode" + str3 + ",columncode" + str4 + ",programcode=" + str5);
                if ("1".equals(str2)) {
                    b.this.t(str5);
                    return;
                }
                if ("14".equals(str2)) {
                    b.this.e(str5, str4);
                } else if ("2".equals(str2)) {
                    EventBus.getDefault().post(new i(str5));
                } else if ("4".equals(str2)) {
                    b.this.s(str5);
                }
            }
        }
    }

    /* compiled from: MobileWebFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.f0.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0253b implements c.InterfaceC0254c {
        C0253b(b bVar) {
        }

        @Override // com.zte.iptvclient.android.mobile.f0.a.c.InterfaceC0254c
        public void a(String str, String str2) {
        }
    }

    /* compiled from: MobileWebFragment.java */
    /* loaded from: classes2.dex */
    class c implements c.a {
        c() {
        }

        @Override // com.zte.iptvclient.android.mobile.f0.a.c.a
        public void onCancel() {
            b.this.getFragmentManager().F();
        }
    }

    /* compiled from: MobileWebFragment.java */
    /* loaded from: classes2.dex */
    class d implements c.d {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.f0.a.c.d
        public void b() {
            if (!TextUtils.isEmpty(b.this.r) && b.this.r.equals("RegistFragment")) {
                b.this.w.setVisibility(0);
            }
        }
    }

    /* compiled from: MobileWebFragment.java */
    /* loaded from: classes2.dex */
    class e implements c.b {
        e() {
        }

        @Override // com.zte.iptvclient.android.mobile.f0.a.c.b
        public void a(String str, String str2, String str3, String str4) {
            b.this.b(str, str2, str3, str4);
        }
    }

    /* compiled from: MobileWebFragment.java */
    /* loaded from: classes2.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.d(b.this.s, "liuyang popup");
            b.this.getFragmentManager().F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "seriesdetail");
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "moviedetail");
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.a, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = this.h.getWindow();
        if (window != null) {
            window.addFlags(16777216);
            window.setFlags(16777216, 16777216);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        this.y = arrayList;
        arrayList.add("SunshineFMFragment");
        this.y.add("CinemaFragment");
        this.y.add("Column_Discovery_ColorRing_Url");
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.x = arrayList2;
        arrayList2.add("ActivityCenterFragment");
        this.x.add("SpecialFragment");
        this.x.add("FlowCenterFragment");
        this.x.add("XingxingColud");
        this.x.add("SunshineFMFragment");
        this.x.add("CinemaFragment");
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.r = arguments.getString("FragmentType");
            this.u = arguments.getString("LoadUrl");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        SupportActivity supportActivity;
        Window window;
        if (this.y.contains(this.r) && (supportActivity = this.h) != null && (window = supportActivity.getWindow()) != null) {
            window.setFlags(Commons.MSG_MCSP_INIT_SUCCESS, Commons.MSG_MCSP_INIT_SUCCESS);
        }
        View inflate = layoutInflater.inflate(R.layout.mobi_web_fragment, viewGroup, false);
        com.zte.iptvclient.common.uiframe.f.a(inflate);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.title_rlayout));
        this.w = (RelativeLayout) inflate.findViewById(R.id.title_rlayout);
        Button button = (Button) inflate.findViewById(R.id.btn_back);
        this.p = button;
        com.zte.iptvclient.common.uiframe.f.a(button);
        TextView textView = (TextView) inflate.findViewById(R.id.title_txt);
        this.q = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.title));
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.web_farment_view);
        this.v = frameLayout;
        com.zte.iptvclient.common.uiframe.f.a(frameLayout);
        com.zte.iptvclient.android.mobile.f0.a.c cVar = new com.zte.iptvclient.android.mobile.f0.a.c();
        this.t = cVar;
        cVar.a(this.h);
        this.t.s(this.r);
        if (!TextUtils.isEmpty(this.u)) {
            this.t.t(this.u);
        }
        this.t.a(new C0253b(this));
        this.t.a(new c());
        this.t.a(new d());
        this.t.a(new e());
        this.t.setArguments(getArguments());
        r b2 = getFragmentManager().b();
        b2.a(R.id.web_farment_view, this.t);
        b2.a();
        this.p.setOnClickListener(new f());
        if (this.h != null) {
            if (TextUtils.equals(this.r, "TermsFragment")) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.statement_and_conditions));
            } else if (TextUtils.equals(this.r, "FAQFragment")) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.faqs));
            } else if (TextUtils.equals(this.r, "AboutFragment")) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.about));
            } else if (TextUtils.equals(this.r, "CustomerFragment")) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.customer_feedback));
            } else if (TextUtils.equals(this.r, "RegistFragment")) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.phonenum_regist));
                this.w.setVisibility(8);
            } else if (TextUtils.equals(this.r, "ActivityCenterFragment")) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.activity_center));
            } else if (TextUtils.equals(this.r, "Column_Discovery_Game_Url")) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.discovery_game));
            } else if (TextUtils.equals(this.r, "Column_Discovery_Read_Url")) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.discovery_read));
            } else if (TextUtils.equals(this.r, "Column_Discovery_FacilitatePeople_Url")) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.discovery_service));
            } else if (TextUtils.equals(this.r, "Column_Discovery_ColorRing_Url")) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.discovery_ring));
            } else if (TextUtils.equals(this.r, "ServiceAgreementFragment")) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.service_agreement));
            } else if (TextUtils.equals(this.r, "SpecialFragment")) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.special_topic));
            } else if (TextUtils.equals(this.r, "FlowCenterFragment")) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.flow_center));
            } else if (TextUtils.equals("CustomerServiceAgreement", this.r)) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.user_service_agreement));
            } else if (TextUtils.equals("SunshineFMFragment", this.r)) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.discovery_sunshineFM));
            } else if (TextUtils.equals("CinemaFragment", this.r)) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.discovery_cinema));
            } else if (TextUtils.equals("ShortVideoFragment", this.r)) {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.short_video_consultation_hotspot));
            } else if (TextUtils.equals("AHMobile_VIP_Service", this.r)) {
                this.q.setText(this.h.getResources().getString(R.string.vip_member_instruction));
            } else if (!TextUtils.isEmpty(this.r)) {
                this.q.setText(this.r);
            } else if (TextUtils.isEmpty(this.r)) {
                this.w.setVisibility(8);
            }
        }
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        SupportActivity supportActivity;
        Window window;
        LogEx.d(this.s, "onDestroyView");
        if (this.y.contains(this.r) && (supportActivity = this.h) != null && (window = supportActivity.getWindow()) != null) {
            window.clearFlags(Commons.MSG_MCSP_INIT_SUCCESS);
        }
        this.t.I();
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4) {
        if (!"1".equals(str) && !"14".equals(str) && ("2".equals(str) || "4".equals(str))) {
            str2 = str3;
        }
        new d.e.a.a.b().a(str, str2, str4, new a());
    }
}
