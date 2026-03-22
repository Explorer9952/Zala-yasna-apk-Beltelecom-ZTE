package com.zte.iptvclient.android.mobile.e0.e;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.k.w;
import com.zte.iptvclient.android.zala.R;

/* compiled from: DetailProgramsInfoFragment.java */
/* loaded from: classes2.dex */
public class g extends com.zte.fragmentlib.b {
    private static String j0 = "DetailProgramsInfoFragment";
    private TextView A;
    private VideoDetailBean B;
    private LinearLayout C;
    private TextView D;
    private ImageView E;
    private RelativeLayout F;
    private ImageView G;
    private RelativeLayout J;
    private ImageView K;
    private ImageView L;
    private RelativeLayout M;
    private LinearLayout N;
    private LinearLayout O;
    private TextView P;
    private String Q;
    private TextView R;
    private String S;
    private TextView T;
    private ImageView U;
    private TextView V;
    private LinearLayout W;
    private TextView X;
    private LinearLayout Y;
    private TextView Z;
    private LinearLayout a0;
    private TextView b0;
    private RelativeLayout c0;
    private TextView d0;
    private TextView e0;
    private RelativeLayout f0;
    private RelativeLayout g0;
    private TextView h0;
    private boolean i0;
    private ImageView p;
    private RelativeLayout q;
    private boolean r = false;
    private LinearLayout s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private LinearLayout z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailProgramsInfoFragment.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.M();
            if (g.this.r) {
                Fragment parentFragment = g.this.getParentFragment();
                if (parentFragment instanceof k) {
                    ((k) parentFragment).J();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailProgramsInfoFragment.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.i0) {
                g.this.N();
                if (g.this.r) {
                    Fragment parentFragment = g.this.getParentFragment();
                    if (parentFragment instanceof k) {
                        ((k) parentFragment).O();
                        return;
                    }
                    return;
                }
                return;
            }
            Fragment parentFragment2 = g.this.getParentFragment();
            if (parentFragment2 instanceof f) {
                ((f) parentFragment2).J();
            }
            if (parentFragment2 instanceof k) {
                ((k) parentFragment2).K();
            }
        }
    }

    private void J() {
        String str = this.Q;
        if (str != null) {
            this.P.setText(str);
        }
        String str2 = this.S;
        if (str2 != null) {
            this.R.setText(str2);
        }
    }

    private void K() {
        VideoDetailBean videoDetailBean = this.B;
        if (videoDetailBean != null) {
            if (!TextUtils.isEmpty(videoDetailBean.getProgramname())) {
                this.t.setText(this.B.getProgramname());
            } else {
                this.t.setText("");
            }
            if (!TextUtils.isEmpty(this.B.getGenre())) {
                String t = t(this.B.getGenre());
                String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_genre);
                this.u.setText(a2 + " " + t);
            } else {
                this.u.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_genre));
            }
            if (!TextUtils.isEmpty(this.B.getDirector())) {
                String t2 = t(this.B.getDirector());
                String a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_director);
                this.v.setText(a3 + " " + t2);
            } else {
                this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_director));
            }
            if (!TextUtils.isEmpty(this.B.getActor())) {
                String t3 = t(this.B.getActor());
                String a4 = com.zte.iptvclient.android.common.i.a.a.a(R.string.record_detail_starring);
                this.w.setText(a4 + " " + t3);
            } else {
                this.w.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.record_detail_starring));
            }
            if (!TextUtils.isEmpty(this.B.getDescription())) {
                String a5 = com.zte.iptvclient.android.common.i.a.a.a(R.string.show_version_descrption);
                this.A.setText(a5 + " " + this.B.getDescription());
            } else {
                this.A.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.show_version_descrption));
            }
            if (!TextUtils.isEmpty(this.B.getAudiolang())) {
                String t4 = t(this.B.getAudiolang());
                String a6 = com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_audio);
                this.x.setText(a6 + " " + t4);
            } else {
                this.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_audio));
            }
            if (!TextUtils.isEmpty(this.B.getSubtitlelang())) {
                String t5 = t(this.B.getSubtitlelang());
                String a7 = com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_subtitle);
                this.y.setText(a7 + " " + t5);
            } else {
                this.y.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_subtitle));
            }
            if (!TextUtils.isEmpty(this.B.getVideoelapsedtime())) {
                this.c0.setVisibility(0);
                this.d0.setText(com.zte.iptvclient.android.common.k.k.b(this.B.getVideoelapsedtime()));
            } else {
                this.c0.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.B.getReleasedate())) {
                this.e0.setVisibility(0);
                this.e0.setText(this.B.getReleasedate());
            } else {
                this.e0.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.B.getPrice())) {
                try {
                    Double valueOf = Double.valueOf(this.B.getPrice());
                    if (valueOf.doubleValue() > 0.0d) {
                        this.T.setText(w.c(valueOf.doubleValue()) + com.zte.iptvclient.android.common.i.a.a.a(R.string.money_unit_sign));
                    } else {
                        this.T.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.price_free));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else {
                this.T.setText("");
            }
            com.zte.iptvclient.android.common.k.p.a(this.U, this.B.getRatingid());
            if (!TextUtils.isEmpty(this.B.getLanguage())) {
                String t6 = t(this.B.getLanguage());
                String a8 = com.zte.iptvclient.android.common.i.a.a.a(R.string.record_detail_language);
                this.X.setText(a8 + " " + t6);
            } else {
                this.X.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.record_detail_language));
            }
            if (!TextUtils.isEmpty(this.B.getPubcompany())) {
                String t7 = t(this.B.getPubcompany());
                String a9 = com.zte.iptvclient.android.common.i.a.a.a(R.string.production);
                this.Z.setText(a9 + " " + t7);
            }
            if (!TextUtils.isEmpty(this.B.getCountryname())) {
                String t8 = t(this.B.getCountryname());
                String str = com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_country) + ":";
                this.b0.setText(str + " " + t8);
            } else {
                this.b0.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_country) + ":");
            }
            float a10 = com.zte.iptvclient.android.mobile.e0.f.k.a(this.B.getRatingsum(), this.B.getRatingnum());
            if (this.i0) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment instanceof f) {
                    ((f) parentFragment).a(a10);
                }
            }
            this.D.setText(a10 < 0.0f ? "--" : w.a(a10));
            String posterfilelist = this.B.getPosterfilelist();
            if (this.r) {
                posterfilelist = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(this.h) ? 9 : 3, posterfilelist);
                if (!TextUtils.isEmpty(posterfilelist) && posterfilelist.contains("/image")) {
                    int indexOf = posterfilelist.indexOf("/image", 1);
                    posterfilelist = com.zte.iptvclient.android.common.f.b.i.g() + posterfilelist.substring(indexOf);
                }
                Log.d("URLHandler", "1 url: " + posterfilelist);
            } else {
                boolean isEmpty = TextUtils.isEmpty(posterfilelist);
                String[] split = !isEmpty ? posterfilelist.split(";") : null;
                if (!isEmpty && split != null) {
                    String g = com.zte.iptvclient.android.common.f.b.i.g();
                    if (split.length > 9) {
                        posterfilelist = g + "/images/poster/" + split[BaseApp.a(this.h) ? 9 : 3];
                        LogEx.d("USee", "AdapterFavorite image url = " + posterfilelist);
                    }
                }
                Log.d("URLHandler", "2 url: " + posterfilelist);
            }
            if (isAdded()) {
                com.bumptech.glide.d<String> a11 = com.bumptech.glide.i.a((FragmentActivity) this.h).a(posterfilelist);
                a11.a(R.drawable.default_poster_thumb);
                a11.c(300);
                a11.a(this.E);
                com.bumptech.glide.d<String> a12 = com.bumptech.glide.i.a((FragmentActivity) this.h).a(posterfilelist);
                a12.a(R.drawable.default_poster_thumb);
                a12.c(300);
                a12.a(this.G);
            }
            if (this.B.getCpcode().equals("ivi")) {
                this.L.setVisibility(0);
                this.L.setImageDrawable(this.h.getResources().getDrawable(R.drawable.ivi_logo));
                this.K.setVisibility(0);
                this.K.setImageDrawable(this.h.getResources().getDrawable(R.drawable.ivi_logo));
                return;
            }
            if (this.B.getCpcode().equals("Megogo")) {
                this.L.setVisibility(0);
                this.L.setImageDrawable(this.h.getResources().getDrawable(R.drawable.megogo_logo));
                this.K.setVisibility(0);
                this.K.setImageDrawable(this.h.getResources().getDrawable(R.drawable.megogo_logo));
                return;
            }
            this.L.setVisibility(8);
            this.K.setVisibility(8);
        }
    }

    private void L() {
        this.M.setOnClickListener(new a());
        this.q.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.f0.setVisibility(8);
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        if (BaseApp.f()) {
            this.J.setVisibility(8);
        } else {
            this.J.setVisibility(0);
        }
        this.M.setVisibility(8);
        this.q.setVisibility(0);
        this.N.setVisibility(0);
        this.O.setVisibility(0);
        this.a0.setVisibility(0);
        this.Y.setVisibility(0);
        if (this.i0) {
            b(true);
            if (this.r) {
                this.z.setVisibility(0);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = com.zte.iptvclient.android.common.k.g.a(getContext(), 10.0f);
            this.z.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.f0.setVisibility(0);
        this.E.setVisibility(0);
        this.F.setVisibility(0);
        this.M.setVisibility(0);
        this.q.setVisibility(8);
        this.N.setVisibility(8);
        this.O.setVisibility(8);
        this.a0.setVisibility(8);
        this.Y.setVisibility(8);
        if (this.i0) {
            b(false);
            if (this.r) {
                this.z.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.leftMargin = com.zte.iptvclient.android.common.k.g.a(getContext(), 0.0f);
                this.z.setLayoutParams(layoutParams);
            }
        }
    }

    private String t(String str) {
        return str.replace(";", ",");
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        LogEx.d(j0, "--onBackPressedSupport--");
        F();
        if (this.i0) {
            return true;
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof f) {
            ((f) parentFragment).I();
            return true;
        }
        if (parentFragment instanceof k) {
            ((k) parentFragment).I();
            return true;
        }
        LogEx.d(j0, "parentFragment Class" + parentFragment.getClass().getName());
        return true;
    }

    public TextView I() {
        return this.D;
    }

    public void a(d dVar) {
    }

    public void e(String str, String str2) {
        Log.d("score-T", "DetailProgramsInfoFragment---doScoreAndMark---");
        if (TextUtils.isEmpty(str)) {
            String format = String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating), "--");
            TextView textView = this.P;
            if (textView != null) {
                textView.setText(format);
            } else {
                this.Q = format;
            }
        } else {
            String format2 = String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating), w.b(str));
            TextView textView2 = this.P;
            if (textView2 != null) {
                textView2.setText(format2);
            } else {
                this.Q = format2;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            String format3 = String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating_kinopoisk), "--");
            TextView textView3 = this.R;
            if (textView3 != null) {
                textView3.setText(format3);
                return;
            } else {
                this.S = format3;
                return;
            }
        }
        String format4 = String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_rating_kinopoisk), w.b(str2));
        TextView textView4 = this.R;
        if (textView4 != null) {
            textView4.setText(format4);
        } else {
            this.S = format4;
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.i0) {
            return;
        }
        K();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i0 = BaseApp.f();
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (this.i0) {
                this.r = arguments.getBoolean("isSeriesDetailHD", false);
            } else {
                this.B = (VideoDetailBean) arguments.getSerializable("VideoDetailBean");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.detail_programe_ifo_layout, viewGroup, false);
        d(inflate);
        L();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public void s(String str) {
        this.g0.setVisibility(0);
        this.h0.setText(str);
    }

    private void b(boolean z) {
        if (this.i0) {
            int i = z ? 14 : 12;
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.t, 14);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.w, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.v, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.y, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.x, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.u, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.A, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.D, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.P, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.R, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.d0, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.e0, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.h0, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.T, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.V, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.X, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.Z, i);
            com.zte.iptvclient.android.mobile.e0.f.d.a(this.b0, i);
        }
    }

    private void d(View view) {
        this.f0 = (RelativeLayout) view.findViewById(R.id.rl_detail_head_wrapper);
        this.q = (RelativeLayout) view.findViewById(R.id.rl_colse_img);
        this.p = (ImageView) view.findViewById(R.id.img_close);
        this.s = (LinearLayout) view.findViewById(R.id.ll_detail_program_container);
        this.z = (LinearLayout) view.findViewById(R.id.detail_program_introduction);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.common_detail_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.detail_title));
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        this.t = (TextView) view.findViewById(R.id.mtxt_title);
        TextView textView = (TextView) view.findViewById(R.id.txt_gene_title);
        this.u = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_genre));
        TextView textView2 = (TextView) view.findViewById(R.id.txt_director_title);
        this.v = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_director));
        TextView textView3 = (TextView) view.findViewById(R.id.text_star_title);
        this.w = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.record_detail_starring));
        TextView textView4 = (TextView) view.findViewById(R.id.text_audio);
        this.x = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_audio));
        TextView textView5 = (TextView) view.findViewById(R.id.text_subtitle);
        this.y = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_detail_title_subtitle));
        TextView textView6 = (TextView) view.findViewById(R.id.txt_desc_title);
        this.A = textView6;
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.show_version_descrption));
        this.C = (LinearLayout) view.findViewById(R.id.hd_video_detail_bottom_btn_rating);
        this.D = (TextView) view.findViewById(R.id.hd_txt_summary_sum);
        this.E = (ImageView) view.findViewById(R.id.iv_poster_pic);
        this.F = (RelativeLayout) view.findViewById(R.id.rl_poster_pic);
        this.K = (ImageView) view.findViewById(R.id.ivi_logo);
        this.G = (ImageView) view.findViewById(R.id.iv_poster_top);
        this.J = (RelativeLayout) view.findViewById(R.id.rl_poster_top);
        this.L = (ImageView) view.findViewById(R.id.ivi_logo_top);
        if (BaseApp.f()) {
            this.J.setVisibility(8);
        } else {
            this.J.setVisibility(0);
        }
        this.M = (RelativeLayout) view.findViewById(R.id.rl_detail_next_container);
        this.N = (LinearLayout) view.findViewById(R.id.ll_subtitle_container);
        this.O = (LinearLayout) view.findViewById(R.id.ll_audio_container);
        this.P = (TextView) view.findViewById(R.id.txt_imdb);
        this.R = (TextView) view.findViewById(R.id.txt_kino_poisk);
        this.T = (TextView) view.findViewById(R.id.txt_price);
        this.U = (ImageView) this.C.findViewById(R.id.iv_rating_pic);
        this.c0 = (RelativeLayout) this.C.findViewById(R.id.rl_duration_wrapper);
        this.d0 = (TextView) this.C.findViewById(R.id.txt_movie_duration);
        this.e0 = (TextView) this.C.findViewById(R.id.txt_movie_release_year);
        this.g0 = (RelativeLayout) this.C.findViewById(R.id.rl_series_season_wrapper);
        this.h0 = (TextView) this.C.findViewById(R.id.txt_series_season_num);
        this.V = (TextView) view.findViewById(R.id.href_detail_next);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_language_container);
        this.W = linearLayout;
        TextView textView7 = (TextView) linearLayout.findViewById(R.id.text_language);
        this.X = textView7;
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.record_detail_language));
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_pubcompany_container);
        this.Y = linearLayout2;
        TextView textView8 = (TextView) linearLayout2.findViewById(R.id.text_pubcompany);
        this.Z = textView8;
        textView8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.production));
        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_country_container);
        this.a0 = linearLayout3;
        TextView textView9 = (TextView) linearLayout3.findViewById(R.id.txt_country_title);
        this.b0 = textView9;
        textView9.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_country) + ":");
        b(false);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.F);
        com.zte.iptvclient.common.uiframe.f.a(this.K);
        com.zte.iptvclient.common.uiframe.f.a(this.G);
        com.zte.iptvclient.common.uiframe.f.a(this.J);
        com.zte.iptvclient.common.uiframe.f.a(this.L);
        com.zte.iptvclient.common.uiframe.f.a(this.M);
        com.zte.iptvclient.common.uiframe.f.a(this.P);
        com.zte.iptvclient.common.uiframe.f.a(this.R);
        com.zte.iptvclient.common.uiframe.f.a(this.d0);
        com.zte.iptvclient.common.uiframe.f.a(this.e0);
        com.zte.iptvclient.common.uiframe.f.a(this.h0);
        com.zte.iptvclient.common.uiframe.f.a(this.T);
        com.zte.iptvclient.common.uiframe.f.a(this.U);
        com.zte.iptvclient.common.uiframe.f.a(this.V);
        com.zte.iptvclient.common.uiframe.f.a(this.X);
        com.zte.iptvclient.common.uiframe.f.a(this.Z);
        com.zte.iptvclient.common.uiframe.f.a(this.b0);
        this.c0.setVisibility(8);
        this.e0.setVisibility(8);
        if ("1".equals(ConfigMgr.readPropertie("isAt"))) {
            if (this.i0) {
                if (this.r) {
                    this.z.setVisibility(8);
                } else {
                    this.z.setVisibility(0);
                }
            } else {
                this.z.setVisibility(0);
            }
        } else if (this.i0) {
            this.q.setVisibility(8);
            if (this.r) {
                this.z.setVisibility(8);
            } else {
                this.z.setVisibility(0);
            }
        } else {
            this.q.setVisibility(0);
        }
        if (this.i0) {
            return;
        }
        J();
        M();
        view.findViewById(R.id.view_top_separator).setVisibility(0);
        this.q.setVisibility(8);
        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_small_desc_container);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout4.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = com.zte.iptvclient.android.common.k.g.a(getContext(), 0.0f);
            linearLayout4.setLayoutParams(layoutParams);
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.z.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.leftMargin = com.zte.iptvclient.android.common.k.g.a(getContext(), 0.0f);
            this.z.setLayoutParams(layoutParams2);
        }
    }

    public void a(VideoDetailBean videoDetailBean) {
        this.B = videoDetailBean;
        K();
    }
}
