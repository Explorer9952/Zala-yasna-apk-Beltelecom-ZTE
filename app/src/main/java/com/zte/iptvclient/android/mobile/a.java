package com.zte.iptvclient.android.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.f.b.j;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.j.i;
import com.zte.iptvclient.android.common.javabean.models.Feature;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.netstate.NetworkStateReceiver;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: MainFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b {
    private h B;
    private ArrayList<com.zte.fragmentlib.b> p;
    private LinearLayout q;
    private View r;
    private int s;
    private j t;
    private List<com.zte.iptvclient.android.mobile.l.c.a.b> u;
    private FrameLayout v;
    private Animation w;
    ImageView x;
    RelativeLayout y;
    private int z = 0;
    private boolean A = false;
    private boolean C = false;

    /* compiled from: MainFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0165a implements Runnable {

        /* compiled from: MainFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0166a implements t.e {
            C0166a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void a() {
            }

            @Override // com.zte.iptvclient.android.common.k.t.e
            public void b() {
                com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a(false);
                a.this.b(false);
            }
        }

        RunnableC0165a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<Feature> a2 = com.zte.iptvclient.android.common.j.c.e().a();
            if (a2 != null && a2.size() > 0) {
                LogEx.d("MainFragment", "showCustomDialog" + a2.size());
                return;
            }
            LogEx.d("MainFragment", "showCustomDialog");
            t.a(((com.zte.fragmentlib.b) a.this).h, com.zte.iptvclient.android.common.i.a.a.a(R.string.switch_childe_mode_to_order_tip), new C0166a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainFragment.java */
    /* loaded from: classes.dex */
    public class b implements Animation.AnimationListener {
        b(a aVar) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.zte.iptvclient.android.common.e.x.d dVar = new com.zte.iptvclient.android.common.e.x.d();
            dVar.a(new com.zte.iptvclient.android.mobile.u.a.a());
            EventBus.getDefault().post(dVar);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainFragment.java */
    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f5274a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f5275b;

        c(EditText editText, com.zte.iptvclient.android.common.customview.a.a.a.b bVar) {
            this.f5274a = editText;
            this.f5275b = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f5274a.getText().toString().equals(a.this.B.u())) {
                a aVar = a.this;
                aVar.a(this.f5274a, ((com.zte.fragmentlib.b) aVar).h);
                this.f5275b.dismiss();
                com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a(false);
                a.this.b(false);
                return;
            }
            if (this.f5274a.getText() != null && !TextUtils.isEmpty(this.f5274a.getText())) {
                this.f5274a.setText("");
                this.f5275b.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.limitpwd_is_wrong));
            } else {
                this.f5275b.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_select_empty));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainFragment.java */
    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f5277a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f5278b;

        d(EditText editText, com.zte.iptvclient.android.common.customview.a.a.a.b bVar) {
            this.f5277a = editText;
            this.f5278b = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            a aVar = a.this;
            aVar.a(this.f5277a, ((com.zte.fragmentlib.b) aVar).h);
            this.f5278b.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainFragment.java */
    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.this.C = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainFragment.java */
    /* loaded from: classes.dex */
    public class f implements DialogInterface.OnShowListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            a.this.C = true;
            LogEx.d("MainFragment", " showPasswordDialog " + a.this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MainFragment.java */
    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private int f5282a;

        public g(int i) {
            this.f5282a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = a.this.s;
            int i2 = this.f5282a;
            if (i != i2 && i2 < a.this.q.getChildCount()) {
                if (TabHostManager.TabName.RETURN.equals(((com.zte.iptvclient.android.mobile.l.c.a.b) a.this.u.get(this.f5282a)).f6762a)) {
                    a.this.N();
                    return;
                }
                if (!TabHostManager.TabName.REMOTE.equals(((com.zte.iptvclient.android.mobile.l.c.a.b) a.this.u.get(this.f5282a)).f6762a) || com.zte.iptvclient.android.mobile.n.c.b.t()) {
                    if (((MainActivity) ((com.zte.fragmentlib.b) a.this).h).t() != null && !TabHostManager.TabName.TV.equals(((com.zte.iptvclient.android.mobile.l.c.a.b) a.this.u.get(this.f5282a)).f6762a) && ((MainActivity) ((com.zte.fragmentlib.b) a.this).h).t().P8) {
                        EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.f());
                    }
                    com.zte.fragmentlib.b bVar = (com.zte.fragmentlib.b) a.this.p.get(this.f5282a);
                    if (a.this.a(bVar.getClass()) != null) {
                        a aVar = a.this;
                        aVar.a(bVar, (com.zte.fragmentlib.b) aVar.p.get(a.this.s));
                    } else {
                        a aVar2 = a.this;
                        aVar2.a(R.id.fl_container, bVar, (com.zte.fragmentlib.b) aVar2.p.get(a.this.s));
                    }
                    if (a.this.r != null) {
                        a.this.r.setSelected(false);
                    }
                    a.this.s = this.f5282a;
                    a aVar3 = a.this;
                    aVar3.r = aVar3.q.getChildAt(this.f5282a);
                    a.this.r.setSelected(true);
                    return;
                }
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                t.a((Context) ((com.zte.fragmentlib.b) a.this).h, false);
            }
        }
    }

    private void J() {
        LogEx.d("MainFragment", "initDefaultView " + this.z);
        ArrayList<com.zte.fragmentlib.b> arrayList = this.p;
        if (arrayList != null && arrayList.size() == this.q.getChildCount() && this.z < this.p.size()) {
            LogEx.d("MainFragment", "loadRootFragmentWitchReplase ");
            List<Fragment> u = getChildFragmentManager().u();
            if (u != null) {
                LogEx.d("MainFragment", "childFragmentList " + u.size());
                u.clear();
                getChildFragmentManager().b().b();
            }
            c(R.id.fl_container, this.p.get(this.z));
            int childCount = this.q.getChildCount();
            int i = this.z;
            if (childCount > i) {
                this.q.getChildAt(i).setSelected(true);
                this.r = this.q.getChildAt(this.z);
                this.s = this.z;
            }
        }
    }

    private void K() {
        if (this.h == null) {
            return;
        }
        LinearLayout linearLayout = this.q;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        this.u = TabHostManager.g().b();
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a() && com.zte.iptvclient.android.mobile.n.c.b.t()) {
            this.u = TabHostManager.g().a();
        }
        this.p = new ArrayList<>();
        if (this.u != null) {
            this.A = false;
            for (int i = 0; i < this.u.size() && i < 5; i++) {
                try {
                    com.zte.fragmentlib.b bVar = (com.zte.fragmentlib.b) this.u.get(i).f6763b.newInstance();
                    if (this.u.get(i).f6763b == com.zte.iptvclient.android.mobile.f0.a.b.class) {
                        Bundle bundle = new Bundle();
                        bundle.putString("FragmentType", this.u.get(i).f6764c);
                        bVar.setArguments(bundle);
                    }
                    this.p.add(bVar);
                    d(i);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InstantiationException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private void L() {
        this.w.setAnimationListener(new b(this));
    }

    private void M() {
        if (TextUtils.equals("1", com.zte.iptvclient.common.uiframe.a.c("Is_Login_ShowTV"))) {
            this.z = 1;
        }
        if (com.zte.iptvclient.android.mobile.n.c.b.o()) {
            this.A = true;
            LogEx.d("MainFragment", "iDefaultShowIndex setted " + this.z);
        }
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            this.z = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        LogEx.d("MainFragment", " showPasswordDialog " + this.C);
        SupportActivity supportActivity = this.h;
        if (supportActivity != null && !supportActivity.isFinishing() && !this.C) {
            this.C = true;
            com.zte.iptvclient.android.common.customview.a.a.a.b bVar = new com.zte.iptvclient.android.common.customview.a.a.a.b(this.h);
            bVar.setTitle(R.string.please_enter_parental_lock_password);
            bVar.a((CharSequence) com.zte.iptvclient.android.common.i.a.a.a(R.string.return_home_tip));
            EditText a2 = bVar.a();
            bVar.b(R.string.common_ok, new c(a2, bVar));
            bVar.a(R.string.common_cancel, new d(a2, bVar));
            bVar.setCancelable(true);
            bVar.setCanceledOnTouchOutside(false);
            bVar.setOnDismissListener(new e());
            bVar.setOnShowListener(new f());
            bVar.show();
            return;
        }
        LogEx.d("MainFragment", " showPasswordDialog return" + this.C);
    }

    public void I() {
        if (this.q == null || "1".equals(ConfigMgr.readPropertie("IsShanDongVersion"))) {
            return;
        }
        if (this.t.d() > 0) {
            c(true);
        } else {
            c(false);
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j e2 = j.e();
        this.t = e2;
        e2.a(this.h);
        this.B = new h(this.h);
        new ArrayList();
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_main, viewGroup, false);
        this.x = (ImageView) inflate.findViewById(R.id.img_interact);
        this.y = (RelativeLayout) inflate.findViewById(R.id.rl_home);
        this.q = (LinearLayout) inflate.findViewById(R.id.ll_tabs);
        this.v = (FrameLayout) inflate.findViewById(R.id.fl_container);
        this.w = AnimationUtils.loadAnimation(this.h, R.anim.tab_bar_remote_rotate_scale);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.txtTabTitle));
        K();
        M();
        J();
        L();
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a() && TextUtils.equals(com.zte.iptvclient.common.uiframe.a.c("Is_ChildMode_Allow_Guest"), "0")) {
            this.q.postDelayed(new RunnableC0165a(), 3000L);
        }
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
        LogEx.d("MainFragment", "测试语言 onDestroy ");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if (cVar.a().equals("0") && com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            D();
            Intent intent = new Intent(getActivity(), (Class<?>) MainActivity.class);
            intent.putExtra("ChildMode", true);
            getActivity().startActivity(intent);
            return;
        }
        ArrayList<com.zte.fragmentlib.b> arrayList = this.p;
        if (arrayList != null && !this.A) {
            if (arrayList.size() == this.q.getChildCount()) {
                this.A = true;
                if (TextUtils.equals("1", com.zte.iptvclient.common.uiframe.a.c("Is_Login_ShowTV"))) {
                    this.z = 1;
                }
                LogEx.d("MainFragment", "iDefaultShowIndex seting for Is_Login_ShowTV =" + com.zte.iptvclient.common.uiframe.a.c("Is_Login_ShowTV"));
            }
            TabHostManager.TabName tabName = TabHostManager.TabName.HOME;
            if (this.z == 1) {
                tabName = TabHostManager.TabName.TV;
            }
            for (int i = 0; i < this.u.size(); i++) {
                if (i < this.q.getChildCount() && tabName.equals(this.u.get(i).f6762a)) {
                    if (a(this.p.get(i).getClass()) != null) {
                        a(this.p.get(i), this.p.get(this.s));
                    } else {
                        a(R.id.fl_container, this.p.get(i), this.p.get(this.s));
                    }
                    View view = this.r;
                    if (view != null) {
                        view.setSelected(false);
                    }
                    this.s = i;
                    View childAt = this.q.getChildAt(i);
                    this.r = childAt;
                    childAt.setSelected(true);
                }
            }
            return;
        }
        LogEx.d("MainFragment", "iDefaultShowIndex setted for return");
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        if (z) {
            return;
        }
        for (int i = 0; i < this.p.size(); i++) {
            if (this.p.get(i).isVisible()) {
                if (i == 2) {
                    SupportActivity supportActivity = this.h;
                    if (supportActivity instanceof MainActivity) {
                        ((MainActivity) supportActivity).u().setVisibility(0);
                        if (!((MainActivity) this.h).t().P8) {
                            ((MainActivity) this.h).t().s0();
                        }
                    }
                    NetworkStateReceiver.a(this.h.getApplicationContext());
                    return;
                }
                return;
            }
        }
    }

    private void c(boolean z) {
        com.zte.iptvclient.android.mobile.l.c.a.b bVar = new com.zte.iptvclient.android.mobile.l.c.a.b();
        bVar.f6762a = TabHostManager.TabName.MINE;
        int indexOf = this.u.indexOf(bVar);
        if (indexOf < 0 || indexOf >= 5) {
            return;
        }
        if (z) {
            this.q.getChildAt(indexOf).findViewById(R.id.message_notice).setVisibility(0);
        } else {
            this.q.getChildAt(indexOf).findViewById(R.id.message_notice).setVisibility(4);
        }
    }

    private void d(int i) {
        SupportActivity supportActivity = this.h;
        if (supportActivity == null) {
            return;
        }
        View inflate = LayoutInflater.from(supportActivity).inflate(R.layout.tab_indicator, (ViewGroup) null);
        com.zte.iptvclient.common.uiframe.f.a(inflate);
        com.zte.iptvclient.common.uiframe.f.a((RelativeLayout) inflate.findViewById(R.id.menu_rl));
        ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
        com.zte.iptvclient.common.uiframe.f.a((ImageView) inflate.findViewById(R.id.message_notice));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.icon));
        if (this.u.get(i).f6762a != TabHostManager.TabName.DISCOVER) {
            imageView.setBackground(c.a.a.a.d.b.d().d(this.u.get(i).f6765d));
            SupportActivity supportActivity2 = this.h;
            if (supportActivity2 != null) {
                supportActivity2.a(imageView, "background", this.u.get(i).f6765d);
            }
            TextView textView = (TextView) inflate.findViewById(R.id.txtTabTitle);
            com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.txtTabTitle));
            textView.setText(this.u.get(i).f);
            inflate.setOnClickListener(new g(i));
        }
        LinearLayout linearLayout = this.q;
        if (linearLayout != null) {
            linearLayout.addView(inflate, new LinearLayout.LayoutParams(0, -1, 1.0f));
        }
    }

    public void b(boolean z) {
        LogEx.d("MainFragment", "switchChildModeMainView");
        i.d().e(new ArrayList<>());
        K();
        M();
        if (z) {
            this.z = 1;
        } else {
            this.z = 0;
            ((MainActivity) this.h).z();
            ((MainActivity) this.h).v();
        }
        J();
        com.zte.iptvclient.android.mobile.n.c.b.k().g();
    }

    public void a(EditText editText, Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null || !inputMethodManager.isActive()) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.p.a aVar) {
        I();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.n.f fVar) {
        if (fVar.a()) {
            this.q.setVisibility(8);
            this.x.setVisibility(8);
        } else {
            this.q.setVisibility(0);
            this.x.setVisibility(0);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.n.a aVar) {
        TabHostManager.TabName a2 = aVar.a();
        if (a2 == null) {
            return;
        }
        if (a2.equals(TabHostManager.TabName.REMOTE) && !com.zte.iptvclient.android.mobile.n.c.b.t()) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            t.a((Context) this.h, false);
            return;
        }
        for (int i = 0; i < this.u.size(); i++) {
            if (i < this.q.getChildCount() && a2.equals(this.u.get(i).f6762a)) {
                if (a(this.p.get(i).getClass()) != null) {
                    a(this.p.get(i), this.p.get(this.s));
                } else {
                    a(R.id.fl_container, this.p.get(i), this.p.get(this.s));
                }
                View view = this.r;
                if (view != null) {
                    view.setSelected(false);
                }
                this.s = i;
                View childAt = this.q.getChildAt(i);
                this.r = childAt;
                childAt.setSelected(true);
            }
        }
    }
}
