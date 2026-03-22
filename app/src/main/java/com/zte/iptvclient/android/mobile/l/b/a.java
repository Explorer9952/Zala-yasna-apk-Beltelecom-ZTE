package com.zte.iptvclient.android.mobile.l.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.e.x.s;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.e0.e.n;
import com.zte.iptvclient.android.zala.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: CommonAnhuiTopNavBarFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b {
    private RelativeLayout p;
    private TextView q;
    private LinearLayout r;
    private TextView s;
    private View u;
    private ViewGroup.LayoutParams x;
    private int t = 0;
    private boolean v = false;
    private String w = "";
    private Handler y = new HandlerC0297a();

    /* compiled from: CommonAnhuiTopNavBarFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.l.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class HandlerC0297a extends Handler {
        HandlerC0297a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.y == null) {
                return;
            }
            if (message.what == 0 && a.this.q != null) {
                a aVar = a.this;
                aVar.t(aVar.w);
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonAnhuiTopNavBarFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Fragment parentFragment = a.this.getParentFragment();
            if (parentFragment instanceof com.zte.iptvclient.android.mobile.l.b.d) {
                ((com.zte.iptvclient.android.mobile.l.b.d) parentFragment).I();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonAnhuiTopNavBarFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(a.this.q.getText().toString())) {
                bundle.putString("InitCondition", a.this.q.getText().toString());
            } else {
                bundle.putString("InitCondition", o.j().b(com.zte.iptvclient.android.common.i.a.a.a(R.string.search_default)));
            }
            Intent intent = new Intent(a.this.getActivity(), (Class<?>) HostActivity.class);
            bundle.putString("fragmenttype", "search");
            intent.putExtras(bundle);
            a.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonAnhuiTopNavBarFragment.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {

        /* compiled from: CommonAnhuiTopNavBarFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.l.b.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0298a implements t.d {
            C0298a(d dVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            if (a.this.t != 0) {
                if (a.this.t != 1) {
                    if (a.this.t == 2) {
                        Fragment parentFragment = a.this.getParentFragment();
                        if (parentFragment instanceof n) {
                            ((n) parentFragment).J();
                            return;
                        }
                        return;
                    }
                    if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                        t.a((Context) ((com.zte.fragmentlib.b) a.this).h, false);
                        return;
                    } else {
                        u.a(((com.zte.fragmentlib.b) a.this).h);
                        return;
                    }
                }
                a aVar = a.this;
                aVar.v = true ^ aVar.v;
                if (!a.this.v) {
                    ((ImageView) a.this.u.findViewById(R.id.img_more)).setImageResource(R.drawable.switch_to_multiscreen);
                    ((TextView) a.this.u.findViewById(R.id.txt_more)).setText(R.string.multi_screen_player);
                } else {
                    ((ImageView) a.this.u.findViewById(R.id.img_more)).setImageResource(R.drawable.switch_to_single_screen);
                    ((TextView) a.this.u.findViewById(R.id.txt_more)).setText(R.string.single_screen_player);
                }
                EventBus.getDefault().post(new s(a.this.v));
                return;
            }
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                t.a(((com.zte.fragmentlib.b) a.this).h, new C0298a(this));
            } else {
                u.a(((com.zte.fragmentlib.b) a.this).h);
            }
        }
    }

    /* compiled from: CommonAnhuiTopNavBarFragment.java */
    /* loaded from: classes.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Fragment parentFragment = a.this.getParentFragment();
            if (parentFragment instanceof com.zte.iptvclient.android.mobile.l.b.d) {
                ((com.zte.iptvclient.android.mobile.l.b.d) parentFragment).I();
            }
        }
    }

    private void I() {
        this.p.setOnClickListener(new c());
        this.r.setOnClickListener(new d());
    }

    private void J() {
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.search_default);
        if (a2 != null) {
            String b2 = o.j().b(a2);
            if (!TextUtils.isEmpty(b2)) {
                this.q.setText(b2);
            } else {
                this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.default_search_hint));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        LogEx.d("CommonAnhuiTopNavBar", "updateSearchDeafultHit=" + str);
        if (!TextUtils.isEmpty(str)) {
            this.q.setText(str);
            return;
        }
        String b2 = o.j().b(com.zte.iptvclient.android.common.i.a.a.a(R.string.search_default));
        if (!TextUtils.isEmpty(b2)) {
            this.q.setText(b2);
        } else {
            this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.default_search_hint));
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        EventBus.getDefault().register(this);
        J();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.u == null) {
            View inflate = layoutInflater.inflate(R.layout.anhui_common_top_navbar, (ViewGroup) null);
            this.u = inflate;
            d(inflate);
            I();
        }
        return this.u;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        J();
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Is_Show_Child");
        if (!TextUtils.isEmpty(c2) && c2.equals("1")) {
            ViewGroup.LayoutParams layoutParams = this.x;
            layoutParams.width = -2;
            this.s.setLayoutParams(layoutParams);
            this.s.setVisibility(0);
            if (BaseApp.f()) {
                this.s.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
                layoutParams2.addRule(21);
                this.r.setLayoutParams(layoutParams2);
                if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                    this.p.setVisibility(8);
                    return;
                }
                return;
            }
            if (getParentFragment() instanceof com.zte.iptvclient.android.mobile.l.b.d) {
                this.s.setOnClickListener(new e());
                return;
            }
            this.s.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams3.addRule(21);
            this.r.setLayoutParams(layoutParams3);
            if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                this.p.setVisibility(8);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams4 = this.x;
        layoutParams4.width = 1;
        this.s.setLayoutParams(layoutParams4);
        this.s.setVisibility(4);
    }

    public void s(String str) {
        this.w = str;
        Handler handler = this.y;
        if (handler == null) {
            return;
        }
        handler.sendEmptyMessage(0);
    }

    private void d(View view) {
        this.p = (RelativeLayout) view.findViewById(R.id.rl_search);
        this.q = (TextView) view.findViewById(R.id.txt_default);
        if (BaseApp.a(getContext())) {
            this.q.setTextColor(androidx.core.content.a.a(getContext(), R.color.search_header_texthint_textcolor));
        }
        if (this.t == 2) {
            View findViewById = view.findViewById(R.id.img_more);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.leftMargin = g.a(getContext(), 10.0f);
                findViewById.setLayoutParams(layoutParams);
            }
            View findViewById2 = view.findViewById(R.id.txt_more);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.rightMargin = g.a(getContext(), 10.0f);
                findViewById2.setLayoutParams(layoutParams2);
            }
        }
        this.r = (LinearLayout) view.findViewById(R.id.ll_more);
        this.s = (TextView) view.findViewById(R.id.tv_child_entrance);
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Is_Show_Child");
        this.x = this.s.getLayoutParams();
        if (!TextUtils.isEmpty(c2) && c2.equals("1")) {
            this.s.setVisibility(0);
            ViewGroup.LayoutParams layoutParams3 = this.x;
            layoutParams3.width = -2;
            this.s.setLayoutParams(layoutParams3);
            if (BaseApp.f()) {
                this.s.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
                layoutParams4.addRule(21);
                this.r.setLayoutParams(layoutParams4);
                if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                    this.p.setVisibility(8);
                }
            } else if (getParentFragment() instanceof com.zte.iptvclient.android.mobile.l.b.d) {
                this.s.setOnClickListener(new b());
            } else {
                this.s.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
                layoutParams5.addRule(21);
                this.r.setLayoutParams(layoutParams5);
                if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                    this.p.setVisibility(8);
                }
            }
        } else {
            ViewGroup.LayoutParams layoutParams6 = this.x;
            layoutParams6.width = 1;
            this.s.setLayoutParams(layoutParams6);
            this.s.setVisibility(4);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_search));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_search));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_default));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_more));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_more));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_more));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_container));
        if (this.t == 1) {
            view.findViewById(R.id.txt_more).setVisibility(0);
            ((ImageView) view.findViewById(R.id.img_more)).setImageResource(R.drawable.switch_to_multiscreen);
            ((TextView) view.findViewById(R.id.txt_more)).setText(R.string.multi_screen_player);
        }
        if (this.t == 2) {
            this.u.findViewById(R.id.txt_more).setVisibility(0);
            ImageView imageView = (ImageView) this.u.findViewById(R.id.img_more);
            imageView.setImageResource(R.drawable.icon_vodsort);
            ((TextView) this.u.findViewById(R.id.txt_more)).setText(R.string.filter_txt);
            int i = (int) ((getContext().getResources().getDisplayMetrics().density * 16.0f) + 0.5f);
            ViewGroup.LayoutParams layoutParams7 = imageView.getLayoutParams();
            if (layoutParams7 != null) {
                layoutParams7.width = i;
                layoutParams7.height = i;
                imageView.setLayoutParams(layoutParams7);
            }
        }
    }

    public void d(int i) {
        this.t = i;
    }
}
