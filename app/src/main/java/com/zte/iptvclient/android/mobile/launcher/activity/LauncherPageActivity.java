package com.zte.iptvclient.android.mobile.launcher.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.n;
import androidx.viewpager.widget.ViewPager;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.m.a.c;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class LauncherPageActivity extends SupportActivity {
    private b A;
    private List<Fragment> B = new ArrayList();
    private com.zte.iptvclient.android.mobile.m.a.a C = null;
    private c D = null;
    private com.zte.iptvclient.android.mobile.m.a.b E = null;
    private boolean F;
    private boolean G;
    private ViewPager v;
    private LinearLayout w;
    private ImageView x;
    private ImageView y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends n {
        public b(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.a
        public int a() {
            return LauncherPageActivity.this.B.size();
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence a(int i) {
            return "";
        }

        @Override // androidx.fragment.app.n
        public Fragment c(int i) {
            return (Fragment) LauncherPageActivity.this.B.get(i);
        }
    }

    private void r() {
        this.v = (ViewPager) findViewById(R.id.vewpager_fragment_contrainer);
        this.w = (LinearLayout) findViewById(R.id.llayout_dot);
        this.x = (ImageView) findViewById(R.id.imgvew_dot1);
        this.y = (ImageView) findViewById(R.id.imgvew_dot2);
        this.z = (ImageView) findViewById(R.id.imgvew_dot3);
        f.a(this.w);
        f.a(this.x);
        f.a(this.y);
        f.a(this.z);
        f.a(this.v);
    }

    private void s() {
        this.B.clear();
        this.C = new com.zte.iptvclient.android.mobile.m.a.a();
        this.D = new c();
        this.E = new com.zte.iptvclient.android.mobile.m.a.b();
        this.B.add(this.C);
        this.B.add(this.D);
        this.B.add(this.E);
        b bVar = new b(getSupportFragmentManager());
        this.A = bVar;
        this.v.a(bVar);
        this.v.d(0);
    }

    private void t() {
        this.v.d(new a());
    }

    @Override // com.zte.fragmentlib.SupportActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ((BaseApp) getApplication()).onTerminate();
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (BaseApp.f == 0) {
            setContentView(R.layout.activity_launcher_page);
        }
        r();
        s();
        t();
    }

    public void b(int i) {
        this.v.d(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ViewPager.i {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            if (LauncherPageActivity.this.F && LauncherPageActivity.this.G && i2 == 0) {
                LogEx.d("LauncherPageActivity", "start MainActivity  else");
                Intent intent = new Intent(LauncherPageActivity.this, (Class<?>) MainActivity.class);
                Intent intent2 = LauncherPageActivity.this.getIntent();
                if (intent2 != null) {
                    Bundle extras = intent2.getExtras();
                    if (extras == null) {
                        extras = new Bundle();
                    }
                    intent.putExtras(extras);
                }
                LauncherPageActivity.this.startActivity(intent);
                LauncherPageActivity.this.finish();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
            LauncherPageActivity.this.F = i == 2;
            if (i == 0) {
                if (BaseApp.f == 0) {
                    LauncherPageActivity.this.w.setVisibility(0);
                    LauncherPageActivity.this.x.setImageResource(R.drawable.launcher_page_dot_press);
                    LauncherPageActivity.this.y.setImageResource(R.drawable.launcher_page_dot_normal);
                    LauncherPageActivity.this.z.setImageResource(R.drawable.launcher_page_dot_normal);
                    return;
                }
                return;
            }
            if (i != 1) {
                if (i == 2 && BaseApp.f == 0) {
                    LauncherPageActivity.this.w.setVisibility(8);
                    return;
                }
                return;
            }
            if (BaseApp.f == 0) {
                LauncherPageActivity.this.w.setVisibility(0);
                LauncherPageActivity.this.x.setImageResource(R.drawable.launcher_page_dot_normal);
                LauncherPageActivity.this.y.setImageResource(R.drawable.launcher_page_dot_press);
                LauncherPageActivity.this.z.setImageResource(R.drawable.launcher_page_dot_normal);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i) {
            LauncherPageActivity.this.G = i == 1;
        }
    }
}
