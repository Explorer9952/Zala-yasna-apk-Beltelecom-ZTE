package com.zte.iptvclient.android.common.player.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.fragment.app.r;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.e.r.k;
import com.zte.iptvclient.android.common.eventbus.multi.e;
import com.zte.iptvclient.android.common.f.b.b;
import com.zte.iptvclient.android.common.k.d;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.player.f;
import com.zte.iptvclient.android.common.player.j.j;
import com.zte.iptvclient.android.common.player.k.b;
import com.zte.iptvclient.android.common.player.k.c;
import com.zte.iptvclient.android.mobile.login.activity.LoginActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.Date;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public class VOPlayerActivity extends SupportActivity {
    private Bundle x;
    private f y;
    protected String v = "";
    private com.zte.iptvclient.android.common.player.k.c w = null;
    private boolean z = true;
    private boolean A = false;
    private boolean B = false;
    private String C = "";
    c.m0 D = new b();

    /* loaded from: classes.dex */
    class a implements b.v {
        a() {
        }
    }

    /* loaded from: classes.dex */
    class b implements c.m0 {
        b() {
        }

        @Override // com.zte.iptvclient.android.common.player.k.c.m0
        public void a() {
            if (TextUtils.equals(VOPlayerActivity.this.C, "HelpVideoFragment")) {
                VOPlayerActivity.this.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements b.d {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4856a;

            a(String str) {
                this.f4856a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                VOPlayerActivity.this.w.d3();
                VOPlayerActivity.this.w.a2();
                VOPlayerActivity.this.w.K(this.f4856a);
                VOPlayerActivity.this.w.E();
                VOPlayerActivity.this.w.D2();
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4858a;

            b(String str) {
                this.f4858a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                VOPlayerActivity.this.w.d3();
                VOPlayerActivity.this.w.I(this.f4858a);
                VOPlayerActivity.this.w.E();
                VOPlayerActivity.this.w.D2();
            }
        }

        /* renamed from: com.zte.iptvclient.android.common.player.activity.VOPlayerActivity$c$c, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0141c implements Runnable {
            RunnableC0141c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                VOPlayerActivity.this.w.d3();
                com.zte.iptvclient.android.common.f.b.b.j().h();
                VOPlayerActivity.this.w.Z1();
                VOPlayerActivity.this.y.a(new j(), VOPlayerActivity.this.w, VOPlayerActivity.this.x, VOPlayerActivity.this);
            }
        }

        /* loaded from: classes.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                VOPlayerActivity.this.w.d3();
                VOPlayerActivity.this.w.H2();
                VOPlayerActivity.this.w.a2();
                VOPlayerActivity.this.w.E();
                VOPlayerActivity.this.w.D2();
            }
        }

        c() {
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void j() {
            LogEx.d("VOPlayerActivity", "tvod blackout无策略，正常播放");
            VOPlayerActivity.this.runOnUiThread(new RunnableC0141c());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void k(String str) {
            LogEx.d("VOPlayerActivity", "tvod blackout查询展示black照片:" + str);
            VOPlayerActivity.this.runOnUiThread(new a(str));
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void l() {
            LogEx.d("VOPlayerActivity", "get Detail BlackoutInfo is null （pic url or play url is null）");
            VOPlayerActivity.this.runOnUiThread(new d());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void r(String str) {
            LogEx.d("VOPlayerActivity", "tvod blackout查询播放black片源" + str);
            VOPlayerActivity.this.runOnUiThread(new b(str));
        }
    }

    private void s() {
        Bundle extras = getIntent().getExtras();
        this.x = extras;
        if (extras != null) {
            extras.putString("isNotNeedToSwitch", "1");
            String stringExtra = getIntent().getStringExtra("fromActivityName");
            this.C = stringExtra;
            if (TextUtils.equals("MultiPlayActivity", stringExtra)) {
                this.x.putString("fromActivityName", this.C);
            }
            this.v = this.x.getString("auth_contenttype");
            LogEx.d("VOPlayerActivity", "ContentType:" + this.v);
            this.z = this.x.getBoolean("PlayHelperCheck", true);
        }
    }

    private void t() {
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            String string = this.x.getString("prevuebegintime");
            String string2 = this.x.getString("prevueendtime");
            String string3 = this.x.getString("channelcode");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                String replace = string.replace(".", "").replace(":", "").replace(" ", "");
                String replace2 = string2.replace(".", "").replace(":", "").replace(" ", "");
                Date c2 = d.c(replace);
                Date c3 = d.c(replace2);
                if (c2 == null || c3 == null) {
                    return;
                }
                com.zte.iptvclient.android.common.f.b.b.j().a(string3, c2, c3, (int) (c3.getTime() - c2.getTime()));
            }
            com.zte.iptvclient.android.common.f.b.b.j().a(string3, s.b(), new c());
            return;
        }
        this.w.Z1();
        this.y.a(new j(), this.w, this.x, this);
    }

    private void u() {
        if (this.z) {
            return;
        }
        if (this.x.getBoolean("LimitDefinetion", false)) {
            this.w.j(0);
        } else {
            this.y.a(this.w, this.x, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        LogEx.d("VOPlayerActivity", "PlayerFragment startPlayProcess ");
        if (this.y == null) {
            this.y = new f();
        }
        if ("4".equals(this.v)) {
            t();
        } else if ("1".equals(this.v)) {
            u();
        }
    }

    @Override // com.zte.fragmentlib.SupportActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Bundle bundle = this.x;
        if (bundle != null && bundle.getBoolean("isPlayConcurrencyMax", false)) {
            d();
            super.onBackPressed();
        } else {
            if (this.w.s5) {
                return;
            }
            Bundle bundle2 = this.x;
            if (bundle2 != null && !bundle2.getBoolean("isProjection", false)) {
                EventBus.getDefault().post(new e());
            } else {
                EventBus.getDefault().post(new k());
            }
            super.onBackPressed();
        }
    }

    @Override // com.zte.fragmentlib.SupportActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(Util.BYTE_OF_KB, Util.BYTE_OF_KB);
            window.setFlags(512, 512);
        }
        super.onCreate(bundle);
        setRequestedOrientation(0);
        com.zte.iptvclient.common.uiframe.f.a(Util.BYTE_OF_KB, 768);
        com.zte.iptvclient.common.uiframe.f.a(this);
        setContentView(R.layout.play_activity_layout_new);
        s();
        EventBus.getDefault().register(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.b bVar) {
        if (TextUtils.equals("1", bVar.a())) {
            startActivity(new Intent(this, (Class<?>) LoginActivity.class));
        } else if (TextUtils.equals("2", bVar.a())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Bundle extras;
        super.onNewIntent(intent);
        b(intent);
        a(intent);
        if (!intent.getBooleanExtra("switchChannel", false) || this.w == null || (extras = intent.getExtras()) == null) {
            return;
        }
        extras.putString("isNotNeedToSwitch", "1");
        this.w.h(extras);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (!this.A && TextUtils.equals(this.C, "HelpVideoFragment")) {
            this.w = new com.zte.iptvclient.android.common.player.k.c();
            LogEx.d("VOPlayerActivity", "PlayerFragment VOPlayerActivity init ");
            r b2 = getSupportFragmentManager().b();
            b2.a(R.id.play_container, this.w, "PlayerFragment");
            b2.b();
            this.w.a(new a());
            this.w.a(this.D);
            this.A = true;
            return;
        }
        if (this.A || this.B) {
            return;
        }
        this.B = true;
        this.w = new com.zte.iptvclient.android.common.player.k.c();
        LogEx.d("VOPlayerActivity", "PlayerFragment VOPlayerActivity init ");
        r b3 = getSupportFragmentManager().b();
        b3.a(R.id.play_container, this.w, "PlayerFragment");
        b3.b();
        this.w.a(this.D);
        this.A = true;
        v();
    }

    public com.zte.iptvclient.android.common.player.k.c r() {
        return this.w;
    }
}
