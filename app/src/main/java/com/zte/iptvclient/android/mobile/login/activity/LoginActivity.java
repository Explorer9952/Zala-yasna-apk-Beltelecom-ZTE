package com.zte.iptvclient.android.mobile.login.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.video.androidsdk.common.config.ConfigMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.n.b.b;
import com.zte.iptvclient.android.mobile.n.b.f;
import com.zte.iptvclient.android.mobile.vod.event.a;
import com.zte.iptvclient.android.zala.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public class LoginActivity extends SupportActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.a((Activity) this);
        setContentView(R.layout.activity_login);
        if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
            a(R.id.fl_container_login, new b());
            EventBus.getDefault().register(this);
            return;
        }
        f fVar = new f();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("isSideMenu", false);
        bundle2.putBoolean("isFromMulti", true);
        fVar.setArguments(bundle2);
        a(R.id.fl_container_login, fVar);
        EventBus.getDefault().register(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Bundle extras;
        super.onDestroy();
        if (com.zte.iptvclient.android.mobile.n.c.b.t() || (extras = getIntent().getExtras()) == null || !extras.getBoolean("isColumnLock", false)) {
            return;
        }
        EventBus.getDefault().post(new a());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.b bVar) {
        if (!TextUtils.equals("1", bVar.a()) && TextUtils.equals("2", bVar.a())) {
            finish();
        }
    }
}
